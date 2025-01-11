package rndm_access.assorteddiscoveries.config.json.deserializer;

import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.*;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenList;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonTokenizer;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenType;

import java.io.IOException;
import java.nio.file.Path;

public class JsonDeserializer {
    private final TokenList tokenList;
    private final JsonConfig config;
    private final Path configPath;

    public JsonDeserializer(JsonConfig config, Path configPath) throws IOException {
        this.tokenList = new JsonTokenizer(configPath).tokenize();
        this.config = config;
        this.configPath = configPath;
    }

    public void parse() {
        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return;
        }

        requireToken(TokenType.LEFT_CURLY);
        parse(null);
    }

    private void parse(ConfigCategory category) {
        while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {
            Token keyToken = requireToken(TokenType.KEY);
            requireToken(TokenType.COLON);

            if (tokenList.matchAndConsume(TokenType.LEFT_CURLY)) {
                if (category == null) {
                    parseCategory(keyToken);
                } else {
                    parseSubCategory(keyToken, category);
                }
            } else {
                parseEntry(keyToken, category);
            }

            if (!tokenList.match(TokenType.RIGHT_CURLY) && tokenList.getNext() != null) {
                requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
            }
        }

        if (category != null) {
            requireToken(TokenType.RIGHT_CURLY);
        } else {
            requireToken(TokenType.RIGHT_CURLY);

            if (!tokenList.hasNextToken()) {
                return;
            }

            if (tokenList.match(TokenType.COMMA)) {
                requireToken(TokenType.COMMA);
                this.parse();
            } else {
                Token token = tokenList.consumeToken();
                int line = token.getLine() + 1;

                throw new JsonSyntaxException("Invalid token '" + token.getValue() + "' on line " + line);
            }
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

    private void parseCategory(Token keyToken) {
        String categoryName = parseJsonString(keyToken.getValue());

        if (config.hasCategory(categoryName)) {
            ConfigCategory category = config.getCategory(categoryName);

            parse(category);
        } else {
            int startLine = keyToken.getLine() + 1;

            this.logInvalidCategory(categoryName, startLine);
            this.skipCategory();
        }
    }

    private void parseSubCategory(Token keyToken, ConfigCategory category) {
        String subcategoryName = parseJsonString(keyToken.getValue());

        if (category.hasSubcategory(subcategoryName)) {
            ConfigCategory subCategory = category.getSubcategory(subcategoryName);
            parse(subCategory);
        } else {
            String categoryName = category.getKey();
            int startLine = keyToken.getLine() + 1;

            this.logInvalidSubcategory(subcategoryName, categoryName, startLine);
            this.skipCategory();
        }
    }

    private void skipCategory() {
        while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {

            // Skip all subcategories in the invalid categories!
            if (tokenList.match(TokenType.LEFT_CURLY)) {
                tokenList.consumeToken();
                this.skipCategory();
            }
            tokenList.consumeToken();
        }
        tokenList.consumeToken();
    }

    private void parseEntry(Token keyToken, ConfigCategory category) {
        String entryName = parseJsonString(keyToken.getValue());

        // Skip the entry if it is not in any categories!
        if (category == null) {
            int line = keyToken.getLine() + 1;

            logInvalidEntry(entryName, null, line);
            tokenList.consumeToken();
            return;
        }

        if (tokenList.match(TokenType.ERROR)) {
            String errorVal = tokenList.consumeToken().getValue();
            String categoryName = category.getKey();
            int line = keyToken.getLine() + 1;

            if (category.hasEntry(entryName)) {
                Object defaultVal = category.getEntry(entryName).getValue();

                logEntryError(entryName, errorVal, defaultVal, categoryName, line);
            } else {
                logInvalidEntry(entryName, categoryName, line);
            }
        } else {
            if (category.hasBooleanEntry(entryName)) {
                Token boolToken = requireToken(TokenType.VALUE);
                BooleanConfigEntry entry = category.getBooleanEntry(entryName);
                entry.setValue(Boolean.valueOf(boolToken.getValue()));
            } else if (category.hasIntegerEntry(entryName)) {
                Token intToken = requireToken(TokenType.VALUE);
                IntegerConfigEntry entry = category.getIntegerEntry(entryName);
                entry.setValue(Integer.valueOf(intToken.getValue()));
            } else if (category.hasStringEntry(entryName)) {
                Token stringToken = requireToken(TokenType.VALUE);
                StringConfigEntry entry = category.getStringEntry(entryName);
                entry.setValue(parseJsonString(stringToken.getValue()));
            } else {
                String categoryName = category.getKey();
                int line = keyToken.getLine() + 1;

                logInvalidEntry(entryName, categoryName, line);
                tokenList.consumeToken();
            }
        }
    }

    public Token requireToken(TokenType... types) {
        if (!tokenList.match(types)) {
            throw new JsonSyntaxException(getSyntaxErrorMessage(types));
        }
        return tokenList.consumeToken();
    }

    private void logEntryError(String entryName, String value, Object defaultVal, @Nullable String categoryName, int line) {
        if (categoryName == null) {
            AssortedDiscoveries.LOGGER.error("Could not load value {} for config entry \"{}\" on line {}! " +
                    "Using default value: {}!", value, entryName, line, defaultVal);
        } else {
            AssortedDiscoveries.LOGGER.error("Could not load value {} for config entry \"{}\" in category \"{}\" " +
                    "on line {}! Using default value: {}!", value, entryName, categoryName, line, defaultVal);
        }
    }

    private void logInvalidEntry(String entryName, @Nullable String categoryName, int line) {
        if (categoryName == null) {
            AssortedDiscoveries.LOGGER.error("Skipping unknown config entry \"{}\" on line {}!", entryName, line);
        } else {
            AssortedDiscoveries.LOGGER.error("Skipping unknown config entry \"{}\" in category \"{}\" on line {}!",
                    entryName, categoryName, line);
        }
    }

    private void logInvalidCategory(String categoryName, int startLine) {
        AssortedDiscoveries.LOGGER.error("Skipping unknown config category \"{}\" starting on line {}!",
                categoryName, startLine);
    }

    private void logInvalidSubcategory(String subcategoryName, String categoryName, int startLine) {
        AssortedDiscoveries.LOGGER.error("Skipping unknown subcategory \"{}\" in category \"{}\" starting on line {}!",
                subcategoryName, categoryName, startLine);
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
            Token currentToken = tokenList.get();

            message.append(", got ");
            if (tokenList.match(TokenType.VALUE)) {
                message.append("'").append(currentToken.getType().asString()).append("'");
                message.append(" with value ").append("'").append(currentToken.getValue()).append("'");
            } else {
                message.append("'").append(currentToken.getValue()).append("'");
            }

            message.append(" at line ").append(currentToken.getLine() + 1);
        }
        message.append(". Config path: ").append(configPath);

        return message.toString();
    }
}
