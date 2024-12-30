package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonTokenizer;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenList;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class JsonSerializer {
    private int line;
    private int depth;
    private final TokenList tokenList;
    private final Path configPath;
    private final JsonConfig config;

    public JsonSerializer(JsonConfig config, Path configPath) {
        line = 0;
        depth = 0;
        this.tokenList = new JsonTokenizer(configPath).tokenize();
        this.configPath = configPath;
        this.config = config;
    }

    public void serialize(Map<String, Object> changeList) {
        List<String> newContent = new ArrayList<>();

        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not serialize to the config file because it was empty!");
            return;
        }

        writeContent(newContent, changeList);

        // To prevent partial files we first save it to a temporary file, then replace the config file!
        try {
            Path tempFile = Files.createTempFile(configPath.getFileName().toString(), null);
            Files.write(tempFile, newContent);
            Files.move(tempFile, configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file!", e);
        }
    }

    private void writeContent(List<String> newContent, Map<String, Object> changeList) {
        ArrayDeque<ConfigCategory> categories = new ArrayDeque<>();

        while (tokenList.hasNextToken()) {
            if (tokenList.match(TokenType.RIGHT_CURLY)) {
                line++;
                depth--;
                Token token = tokenList.consumeToken();
                String rightCurly = token.getValue();
                this.writeText(rightCurly, newContent);

                if (!categories.isEmpty()) {
                    categories.pop();
                }
            } else if (tokenList.match(TokenType.COMMA)) {
                Token token = tokenList.consumeToken();
                String comma = token.getValue();
                this.writeText(comma, newContent);
                line++;
            } else if (tokenList.match(TokenType.LEFT_CURLY, TokenType.LEFT_BRACKET)) {
                Token token = tokenList.consumeToken();
                String tokenVal = token.getValue();
                this.writeText(tokenVal, newContent);
                line++;
                depth++;
            } else if (tokenList.match(TokenType.KEY)) {
                Token keyToken = tokenList.consumeToken();
                String key = keyToken.getValue();
                StringBuilder lineContent = new StringBuilder(key);
                String entryName = parseJsonString(key);
                Token colonToken = tokenList.consumeToken();
                String colon = colonToken.getValue();
                lineContent.append(colon).append(" ");

                if (tokenList.match(TokenType.LEFT_CURLY)) {
                    this.insertCategory(newContent, entryName, lineContent, categories);
                } else {
                    this.insertEntry(newContent, entryName, lineContent, categories, changeList);
                }
            } else {
                Token token = tokenList.consumeToken();
                String tokenVal = token.getValue();

                this.writeText(tokenVal, newContent);
            }
        }

        if (depth > 0) {
            throw new RuntimeException("Failed to save the file! Found unclosed body missing '}'!");
        }
    }

    private void insertCategory(List<String> newContent, String entryName, StringBuilder lineContent,
                                ArrayDeque<ConfigCategory> categories) {
        Token token = tokenList.consumeToken();
        String leftCurly = token.getValue();
        lineContent.append(leftCurly);
        this.writeText(lineContent.toString(), newContent);
        line++;
        depth++;

        if (categories.isEmpty() && config.hasCategory(entryName)) {
            categories.push(config.getCategory(entryName));
        }

        if (!categories.isEmpty() && categories.peek().hasSubcategory(entryName)) {
            assert categories.peek() != null;
            categories.push(categories.peek().getSubcategory(entryName));
        }
    }

    private void insertEntry(List<String> newContent, String entryName, StringBuilder lineContent,
                             ArrayDeque<ConfigCategory> categories, Map<String, Object> changeList) {
        Token valueToken = tokenList.consumeToken();
        String value = valueToken.getValue();

        this.insertComment(newContent, entryName, categories);

        if (changeList.containsKey(entryName)) {
            value = String.valueOf(changeList.get(entryName));
        }
        lineContent.append(value);
        this.writeText(lineContent.toString(), newContent);
    }

    private void insertComment(List<String> newContent, String entryName, ArrayDeque<ConfigCategory> categories) {
        assert categories.peek() != null;
        ConfigCategory category = categories.peek();

        if (!category.hasEntry(entryName)) {
            return;
        }

        AbstractConfigEntry<?> entry = category.getEntry(entryName);
        String comment = "\t".repeat(depth) + "// " + entry.getComment();

        if (entry.hasComment()) {
            newContent.add(comment);
            line++;
        }
    }

    /**
     * @param input The input to trim!
     * @return The input without extra surrounding quotes if there are any otherwise the input itself.
     */
    private String parseJsonString(String input) {
        if (input.charAt(0) == '"' && input.charAt(input.length() - 1) == '"') {
            return input.substring(1, input.length() - 1);
        }
        return input;
    }

    private void writeText(String value, List<String> newContent) {
        if (line >= newContent.size()) {
            if (depth > 0) {
                newContent.add("\t".repeat(depth) + value);
            } else {
                newContent.add(value);
            }
        } else {
            String lineContent = newContent.get(line);
            newContent.set(line, lineContent + value);
        }
    }
}
