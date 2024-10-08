package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.parser.entries.*;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenList;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonTokenizer;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenType;

import java.nio.file.Path;
import java.util.*;

public class JsonParser {
    private final TokenList tokenList;
    private final JsonConfig config;
    private final Path configPath;
    private final Map<String, Token> entryErrors;
    private int depth;

    public JsonParser(JsonConfig config, Path configPath) {
        this.tokenList = new JsonTokenizer(config.getFileContent()).tokenize();
        this.config = config;
        this.configPath = configPath;
        this.entryErrors = new HashMap<>();
        this.depth = 0;
    }

    public Map<String, Token> getEntryErrors() {
        return entryErrors;
    }

    public void parse() {
        Stack<ConfigCategory> categories = new Stack<>();

        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return;
        }

        requireToken(TokenType.LEFT_CURLY);
        do {
            Token keyToken = requireToken(TokenType.STRING);
            requireToken(TokenType.COLON);

            if (tokenList.matchAndConsume(TokenType.LEFT_CURLY)) {
                parseCategory(keyToken, categories);
            } else {
                if(categories.isEmpty()) {
                    requireToken(TokenType.LEFT_CURLY);
                }
                parseEntry(keyToken, categories.peek());

                if(tokenList.match(TokenType.RIGHT_CURLY)) {
                    depth--;
                    categories.peek().setEndLine(tokenList.get().getLine());
                    categories.pop();
                    requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                }
                requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
            }
        } while (tokenList.hasNextToken());

        // If the depth is greater than 0 we have an unclosed curly brace!
        if (depth > 0) {
            throw new JsonSyntaxException(getSyntaxErrorMessage(TokenType.COMMA, TokenType.RIGHT_CURLY));
        }
    }

    private void parseCategory(Token categoryToken, Stack<ConfigCategory> categories) {
        if (categories.isEmpty()) {
            String categoryName = categoryToken.getValue();
            depth++;

            if (config.hasCategory(categoryName)) {
                ConfigCategory category = config.getCategory(categoryName);
                category.setStartLine(categoryToken.getLine());
                ConfigKey key = category.getKey();
                key.setStart(categoryToken.getStart());
                key.setEnd(categoryToken.getEnd());
                categories.push(category);
            } else {
                logInvalidConfigCategory(categoryName);
            }
        } else {
            ConfigCategory category = categories.peek();
            String categoryName = category.getKey().getName();
            String subcategoryName = categoryToken.getValue();
            depth++;

            if (category.hasSubcategory(subcategoryName)) {
                ConfigCategory subCategory = category.getSubcategory(subcategoryName);
                subCategory.setStartLine(categoryToken.getLine());
                ConfigKey key = subCategory.getKey();
                key.setStart(categoryToken.getStart());
                key.setEnd(categoryToken.getEnd());
                categories.push(subCategory);
            } else {
                logInvalidConfigSubcategory(subcategoryName, categoryName);
            }
        }
    }

    private void parseEntry(Token keyToken, ConfigCategory category) {
        String entryName = keyToken.getValue();

        if (tokenList.match(TokenType.ERROR)) {
            Token errorToken = tokenList.consumeToken();

            if (category.hasEntry(entryName)) {
                entryErrors.put(entryName, errorToken);
            } else {
                logInvalidConfigEntry(entryName);
            }
        } else {
            if (category.hasBooleanEntry(entryName)) {
                Token boolToken = requireToken(TokenType.BOOL);
                BooleanConfigEntry entry = category.getBooleanEntry(entryName);
                entry.setLine(boolToken.getLine());
                entry.setStart(keyToken.getStart());
                entry.setEnd(boolToken.getEnd());
                ConfigValue<Boolean> boolValue = entry.getValue();
                boolValue.setEntryValue(Boolean.valueOf(boolToken.getValue()));
                boolValue.setStart(boolToken.getStart());
                boolValue.setEnd(boolToken.getEnd());
                ConfigKey boolKey = entry.getKey();
                boolKey.setStart(keyToken.getStart());
                boolKey.setEnd(keyToken.getEnd());
            } else if (category.hasIntegerEntry(entryName)) {
                Token intToken = requireToken(TokenType.INT);
                IntegerConfigEntry entry = category.getIntegerEntry(entryName);
                entry.setLine(intToken.getLine());
                entry.setStart(keyToken.getStart());
                entry.setEnd(intToken.getEnd());
                ConfigValue<Integer> intValue = entry.getValue();
                intValue.setEntryValue(Integer.valueOf(intToken.getValue()));
                intValue.setStart(intToken.getStart());
                intValue.setEnd(intToken.getEnd());
                ConfigKey intKey = entry.getKey();
                intKey.setStart(keyToken.getStart());
                intKey.setEnd(keyToken.getEnd());
            } else if (category.hasStringEntry(entryName)) {
                Token stringToken = requireToken(TokenType.STRING);
                StringConfigEntry entry = category.getStringEntry(entryName);
                entry.setLine(stringToken.getLine());
                entry.setStart(keyToken.getStart());
                entry.setEnd(stringToken.getEnd());
                ConfigValue<String> stringValue = entry.getValue();
                stringValue.setEntryValue(stringToken.getValue());
                stringValue.setStart(stringToken.getStart());
                stringValue.setEnd(stringToken.getEnd());
                ConfigKey stringKey = entry.getKey();
                stringKey.setStart(keyToken.getStart());
                stringKey.setEnd(keyToken.getEnd());
            } else {
                logInvalidConfigEntry(entryName);
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
            Token currentToken = tokenList.get();

            message.append(", got ");
            if (tokenList.match(TokenType.STRING, TokenType.INT, TokenType.BOOL)) {
                message.append("'").append(currentToken.getType().asString()).append("'");
                message.append(" with value ").append("'").append(currentToken.getValue()).append("'");
            } else {
                message.append("'").append(currentToken.getValue()).append("'");
            }

            message.append(" at line ").append(currentToken.getLine() + 1);
            message.append(", column ").append(currentToken.getStart() + 1);
        }
        message.append(". Config path: ").append(configPath);

        return message.toString();
    }
}
