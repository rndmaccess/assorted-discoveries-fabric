package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
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
    private int depth = 0;

    public JsonParser(List<String> source, JsonConfig config, Path configPath) {
        this.tokenList = new JsonTokenizer(source).tokenize();
        this.config = config;
        this.configPath = configPath;
    }

    public void parse() {
        Stack<JsonConfigCategory> categories = new Stack<>();

        // The file is empty! So we should exit before trying to load data!
        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return;
        }

        requireToken(TokenType.LEFT_CURLY);
        do {
            JsonToken keyToken = requireToken(TokenType.STRING);
            requireToken(TokenType.COLON);

            if (tokenList.matchAndConsume(TokenType.LEFT_CURLY)) {
                parseCategory(keyToken, categories);
            } else {
                if(!categories.isEmpty()) {
                    parseEntry(keyToken, categories.peek());

                    if(tokenList.match(TokenType.RIGHT_CURLY)) {
                        depth--;
                        categories.pop();
                        requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                    }
                    requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                } else {
                    requireToken(TokenType.LEFT_CURLY);
                }
            }
        } while (tokenList.hasNextToken());

        // If the depth is greater than 0 we have an unclosed curly brace!
        if (depth > 0) {
            throw new JsonSyntaxException(getSyntaxErrorMessage(TokenType.COMMA, TokenType.RIGHT_CURLY));
        }

        // TODO: Correct the file for each value error! Use a substring of 0, start + defaultValue + end, end of line!
    }

    private void parseCategory(JsonToken categoryToken, Stack<JsonConfigCategory> categories) {
        if (categories.isEmpty()) {
            String categoryName = categoryToken.getValue();
            depth++;

            if (config.hasCategory(categoryName)) {
                categories.push(config.getCategory(categoryName));
            } else {
                logInvalidConfigCategory(categoryName);
            }
        } else {
            JsonConfigCategory category = categories.peek();
            String categoryName = category.getName();
            String subcategoryName = categoryToken.getValue();
            depth++;

            if (category.hasSubcategory(subcategoryName)) {
                categories.push(category.getSubcategory(subcategoryName));
            } else {
                logInvalidConfigSubcategory(subcategoryName, categoryName);
            }
        }
    }

    private void parseEntry(JsonToken keyToken, JsonConfigCategory category) {
        String entryName = keyToken.getValue();

        if (tokenList.match(TokenType.ERROR)) {
            String errorValue = tokenList.consumeToken().getValue();

            if (category.hasEntry(entryName)) {
                Object defaultValue = category.getEntry(entryName).getValue();

                AssortedDiscoveries.LOGGER.warn("Could not load the value {} for entry {} correcting to {}.",
                        errorValue, entryName, defaultValue);
                // TODO: Add each value error to a list to update the config later!
            } else {
                logInvalidConfigEntry(entryName);
            }
        } else {
            if (category.hasBooleanEntry(entryName)) {
                JsonToken boolToken = requireToken(TokenType.BOOL);
                JsonBooleanConfigEntry entry = category.getBooleanEntry(entryName);
                entry.setValue(Boolean.valueOf(boolToken.getValue()));
            } else if (category.hasIntegerEntry(entryName)) {
                JsonToken intToken = requireToken(TokenType.INT);
                JsonIntegerConfigEntry entry = category.getIntegerEntry(entryName);
                entry.setValue(Integer.valueOf(intToken.getValue()));
            } else if (category.hasStringEntry(entryName)) {
                JsonToken stringToken = requireToken(TokenType.STRING);
                JsonStringConfigEntry entry = category.getStringEntry(entryName);
                entry.setValue(stringToken.getValue());
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
        AssortedDiscoveries.LOGGER.error("Skipping {} because it is not a known config entry!", entryName);
    }

    private void logInvalidConfigCategory(String categoryName) {
        AssortedDiscoveries.LOGGER.error("Skipping {} because it is not a known config category!", categoryName);
    }

    private void logInvalidConfigSubcategory(String subcategoryName, String categoryName) {
        AssortedDiscoveries.LOGGER.error("Skipping {} because it is not a known subcategory in category {}!",
                subcategoryName, categoryName);
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

            message.append(", got '").append(currentToken.getValue()).append("'");
            message.append(" at line ").append(currentToken.getLine() + 1);
            message.append(", column ").append(currentToken.getStart() + 1);
        }
        message.append(". Config path: ").append(configPath);

        return message.toString();
    }
}
