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

    public JsonParser(JsonConfig config, Path configPath) {
        this.tokenList = new JsonTokenizer(config.getFileContent()).tokenize();
        this.config = config;
        this.configPath = configPath;
        this.entryErrors = new HashMap<>();
    }

    public Map<String, Token> getEntryErrors() {
        return entryErrors;
    }

    public void parse() {
        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return;
        }

        requireToken(TokenType.LEFT_CURLY);
        while (tokenList.hasNextToken()) {
            parse(null);
        }
    }

    private void parse(ConfigCategory category) {
        while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {
            Token keyToken = requireToken(TokenType.STRING);
            requireToken(TokenType.COLON);

            if (tokenList.matchAndConsume(TokenType.LEFT_CURLY)) {
                parseCategory(keyToken, category);
            } else {
                parseEntry(keyToken, category);
            }

            if (!tokenList.match(TokenType.RIGHT_CURLY) && tokenList.getNext() != null) {
                requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
            }
        }

        if (category != null) {
            Token token = requireToken(TokenType.RIGHT_CURLY);

            category.setEndLine(token.getLine());
        } else {
            tokenList.consumeToken(); // Ignore the invalid tokens at the end of the file :)
        }
    }

    private void parseCategory(Token keyToken, ConfigCategory category) {
        if (category == null) {
            String categoryName = keyToken.getValue();

            if (config.hasCategory(categoryName)) {
                category = config.getCategory(categoryName);
                category.setStartLine(keyToken.getLine());
                ConfigKey key = category.getKey();
                key.setStart(keyToken.getStart());
                key.setEnd(keyToken.getEnd());
                parse(category);
            } else {
                logInvalidConfigCategory(categoryName);

                while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {
                    tokenList.consumeToken();
                }
            }
        } else {
            parseSubCategory(keyToken, category);
        }
    }

    private void parseSubCategory(Token keyToken, ConfigCategory category) {
        String categoryName = category.getKey().getName();
        String subcategoryName = keyToken.getValue();

        if (category.hasSubcategory(subcategoryName)) {
            ConfigCategory subCategory = category.getSubcategory(subcategoryName);
            subCategory.setStartLine(keyToken.getLine());
            ConfigKey key = subCategory.getKey();
            key.setStart(keyToken.getStart());
            key.setEnd(keyToken.getEnd());
            parse(subCategory);
        } else {
            logInvalidConfigSubcategory(subcategoryName, categoryName);

            while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {
                tokenList.consumeToken();
            }
            parse(category);
        }
    }

    private void parseEntry(Token keyToken, ConfigCategory category) {
        String entryName = keyToken.getValue();

        if (Objects.equals(category, null)) {
            requireToken(TokenType.LEFT_CURLY);
        }

        if (tokenList.match(TokenType.ERROR)) {
            Token errorToken = tokenList.consumeToken();

            if (category.hasEntry(entryName)) {
                entryErrors.put(entryName, errorToken);
            } else {
                String categoryName = category.getKey().getName();

                logInvalidConfigEntry(entryName, categoryName);
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
                String categoryName = category.getKey().getName();

                logInvalidConfigEntry(entryName, categoryName);
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

    private void logInvalidConfigEntry(String entryName, String categoryName) {
        AssortedDiscoveries.LOGGER.error("Skipping {} because it is not a known " +
                "config entry for category {}!", entryName, categoryName);
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
