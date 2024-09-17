package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonBooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonIntegerConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonStringConfigEntry;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonToken;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonTokenList;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonTokenizer;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenType;

import java.nio.file.Path;
import java.util.*;

public class JsonParser {
    private final JsonConfig config;
    private final JsonTokenList tokenList;
    private final Path configPath;

    public JsonParser(List<String> source, JsonConfig config, Path configPath) {
        this.tokenList = new JsonTokenizer(source).tokenize();
        this.config = config;
        this.configPath = configPath;
    }

    public void parse() {
        // The file is empty! So we should exit before trying to load data!
        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return;
        }

        requireToken(TokenType.LEFT_CURLY);
        parseObjects();
    }

    private void parseObjects() {
        Stack<JsonToken> categoryTokens = new Stack<>();
        Stack<JsonConfigCategory> categories = new Stack<>();

        do {
            JsonToken keyToken = requireToken(TokenType.STRING);
            requireToken(TokenType.COLON);

            if (tokenList.matchAndConsume(TokenType.LEFT_CURLY)) {
                parseCategory(keyToken, categoryTokens, categories);
            } else {
                if(!categoryTokens.isEmpty()) {
                    parseEntry(keyToken, categories.peek());

                    if(tokenList.match(TokenType.RIGHT_CURLY)) {
                        categories.pop();
                        categoryTokens.pop();
                        requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                    }
                    requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                } else {
                    requireToken(TokenType.LEFT_CURLY);
                }
            }
        } while (tokenList.hasNextToken());
    }

    private void parseCategory(JsonToken categoryToken, Stack<JsonToken> categoryTokens, Stack<JsonConfigCategory> categories) {
        if (categoryTokens.isEmpty()) {
            String categoryName = categoryToken.value();
            int categoryLine = categoryToken.line();
            int categoryCol = categoryToken.column();

            if (!config.hasCategory(categoryName)) {
                throw new JsonConfigException("The config does not have category " + categoryName
                        + " at line " + (categoryLine + 1)
                        + ", column " + (categoryCol + 1));
            }
            categoryTokens.push(categoryToken);
            categories.push(config.getCategory(categoryName));
        } else {
            JsonConfigCategory category = categories.peek();
            String categoryName = categoryTokens.peek().value();
            int categoryLine = categoryTokens.peek().line();
            int categoryCol = categoryTokens.peek().column();
            String subcategoryName = categoryToken.value();
            int subcategoryLine = categoryToken.line();
            int subcategoryCol = categoryToken.column();

            if (!category.hasSubcategory(subcategoryName)) {
                String subcategoryErrorMsg = "The category \"" + categoryName + "\""
                        + " at line " + (categoryLine + 1)
                        + ", column " + (categoryCol + 1)
                        + " does not have subcategory \"" + subcategoryName + "\""
                        + " at line " + (subcategoryLine + 1)
                        + ", column " + (subcategoryCol + 1) + ".";

                throw new JsonConfigException(subcategoryErrorMsg);
            }
            categoryTokens.push(categoryToken);
            categories.push(category.getSubcategory(subcategoryName));
        }
    }

    private void parseEntry(JsonToken keyToken, JsonConfigCategory category) {
        String entryName = keyToken.value();

        if (tokenList.match(TokenType.ERROR)) {
            String errorValue = tokenList.consumeToken().value();

            if (category.hasEntry(entryName)) {
                Object defaultValue = category.getEntry(entryName).getValue();

                AssortedDiscoveries.LOGGER.warn("Could not load the value {} for entry {} resetting to {}.",
                        errorValue, entryName, defaultValue);
            } else {
                logInvalidConfigEntry(entryName);
            }
        } else {
            if (category.hasBooleanEntry(entryName)) {
                JsonToken boolToken = requireToken(TokenType.BOOL);
                JsonBooleanConfigEntry entry = category.getBooleanEntry(entryName);
                entry.setValue(Boolean.valueOf(boolToken.value()));
            } else if (category.hasIntegerEntry(entryName)) {
                JsonToken intToken = requireToken(TokenType.INT);
                JsonIntegerConfigEntry entry = category.getIntegerEntry(entryName);
                entry.setValue(Integer.valueOf(intToken.value()));
            } else if (category.hasStringEntry(entryName)) {
                JsonToken stringToken = requireToken(TokenType.STRING);
                JsonStringConfigEntry entry = category.getStringEntry(entryName);
                entry.setValue(stringToken.value());
            } else {
                logInvalidConfigEntry(entryName);
                tokenList.consumeToken();
            }
        }
    }

    public JsonToken requireToken(TokenType... types) {
        if (!tokenList.match(types)) {
            throw new JsonSyntaxException(getSyntaxErrorMessage(types));
        }
        return tokenList.consumeToken();
    }

    private void logInvalidConfigEntry(String entryName) {
        AssortedDiscoveries.LOGGER.warn("Skipping invalid config entry {}", entryName);
    }

    private String getSyntaxErrorMessage(TokenType... types) {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < types.length; i++) {
            message.append("'").append(types[i].asString()).append("'");

            if(i != types.length - 1) {
                message.append(" or ");
            }
        }
        message.append(" expected");

        if (tokenList.hasNextToken()) {
            JsonToken currentToken = tokenList.get();

            message.append(", got '").append(currentToken.value()).append("'");
            message.append(" at line ").append(currentToken.line() + 1);
            message.append(", column ").append(currentToken.column() + 1);
        }
        message.append(". Config path: ").append(configPath);

        return message.toString();
    }
}
