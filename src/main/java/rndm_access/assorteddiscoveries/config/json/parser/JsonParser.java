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

import java.util.*;

public class JsonParser {
    private final JsonConfig config;
    private final JsonTokenList tokenList;

    public JsonParser(List<String> source, JsonConfig config) {
        this.tokenList = new JsonTokenizer(source).tokenize();
        this.config = config;
    }

    public void parse() {
        requireToken(TokenType.LEFT_CURLY, tokenList.get(), "{");
        tokenList.consumeToken();

        while (tokenList.hasNextToken()) {
            JsonToken token = tokenList.consumeToken();

            if(tokenList.hasNextToken() && tokenList.get().match(TokenType.COLON)) {
                tokenList.consumeToken();

                if (requireToken(TokenType.LEFT_CURLY, tokenList.get(), "{")) {
                    tokenList.consumeToken();

                    JsonConfigCategory category = config.getCategory(token.value());
                    parseJsonObject(category);
                }
            }
        }
    }

    public void parseJsonObject(JsonConfigCategory category) {
        while (tokenList.hasNextToken() && !tokenList.get().match(TokenType.COMMA)
                && !tokenList.get().match(TokenType.RIGHT_CURLY)) {
            JsonToken keyToken = tokenList.consumeToken();
            requireToken(TokenType.STRING, keyToken, "a string");

            if(requireToken(TokenType.COLON, tokenList.get(), ":")) {
                tokenList.consumeToken();

                if (tokenList.get().match(TokenType.LEFT_CURLY)) {
                    tokenList.consumeToken();

                    parseJsonObject(category.getSubcategory(keyToken.value()));
                } else {
                    JsonToken valueToken = tokenList.consumeToken();

                    // We are trying to parse a category here, but we are actually parsing it as an entry.
                    // This is an error!
                    if (tokenList.get().match(TokenType.COLON)) {
                        throw new JsonSyntaxException("Expected {"
                                + " but found :"
                                + " at line " + (valueToken.line() + 1)
                                + ", column " + (valueToken.column() + 1));
                    } else {
                        if (category.hasBooleanEntry(keyToken.value())) {
                            JsonBooleanConfigEntry entry = category.getBooleanEntry(keyToken.value());
                            boolean newValue = getCorrectedBoolValue(entry.getName(), entry.getValue(), valueToken.value());

                            if (!Objects.equals(entry.getValue(), newValue)) {
                                entry.setValue(newValue);
                            }
                        }

                        if (category.hasIntegerEntry(keyToken.value())) {
                            JsonIntegerConfigEntry entry = category.getIntegerEntry(keyToken.value());
                            int newValue = getCorrectedIntegerValue(entry.getName(), entry.getValue(), valueToken.value());

                            if (!Objects.equals(entry.getValue(), newValue)) {
                                entry.setValue(newValue);
                            }
                        }

                        if (category.hasStringEntry(keyToken.value())) {
                            JsonStringConfigEntry entry = category.getStringEntry(keyToken.value());

                            if (!Objects.equals(entry.getValue(), valueToken.value())) {
                                entry.setValue(valueToken.value());
                            }
                        }

                        // Make sure that every object literal is comma seperated! If not throw an error!
                        if (!tokenList.get().match(TokenType.RIGHT_CURLY)) {
                            requireToken(TokenType.COMMA, tokenList.get(), ",");
                        }

                        // Make sure that object literals do not end with an extra comma!
                        if(tokenList.get().match(TokenType.COMMA) && tokenList.peek().match(TokenType.RIGHT_CURLY)) {
                            throw new JsonSyntaxException("Expected object literal to end with } but found ,"
                                    + " at line " + (tokenList.get().line() + 1)
                                    + ", column " + (tokenList.get().column() + 1));
                        }
                    }
                }
            }
            tokenList.consumeToken();
        }
    }

    public boolean requireToken(TokenType type, JsonToken token, String name) {
        if(!token.match(type)) {
            throw new JsonSyntaxException("Expected " + name
                    + " but found " + token.value()
                    + " at line " + (token.line() + 1)
                    + ", column " + (token.column() + 1));
        }
        return true;
    }

    private static Boolean getCorrectedBoolValue(String entryName, boolean defaultValue, String savedValue) {
        if(savedValue.equalsIgnoreCase("true") || savedValue.equalsIgnoreCase("false")) {
            return Boolean.valueOf(savedValue);
        } else {
            logCorrectionInfo(savedValue, String.valueOf(defaultValue), entryName);
            return defaultValue;
        }
    }

    private static Integer getCorrectedIntegerValue(String entryName, int defaultValue, String savedValue) {
        for (int i = 0; i < savedValue.length(); i++) {
            if(!Character.isDigit(savedValue.charAt(i)) && savedValue.charAt(0) != '-') {
                logCorrectionInfo(savedValue, String.valueOf(defaultValue), entryName);
                return defaultValue;
            }
        }
        return Integer.valueOf(savedValue);
    }

    private static void logCorrectionInfo(String savedValue, String newValue, String entryName) {
        AssortedDiscoveries.LOGGER.info("Corrected the value {} to {} for config entry {}",
                savedValue, newValue, entryName);
    }
}
