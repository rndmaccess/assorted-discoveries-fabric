package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
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
        // The file is empty! So we should exit before trying to load data!
        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return;
        }

        requireToken(TokenType.LEFT_CURLY);
        tokenList.consumeToken();

        while (tokenList.hasNextToken()) {

            if(tokenList.hasNextToken() && tokenList.matchNext(TokenType.COLON)) {
                requireToken(TokenType.STRING);
                JsonToken keyToken = tokenList.consumeToken();
                tokenList.consumeToken();

                if (requireToken(TokenType.LEFT_CURLY)) {
                    tokenList.consumeToken();

                    JsonConfigCategory category = config.getCategory(keyToken.value());

                    parseJsonObject(category);
                }
            } else {
                tokenList.consumeToken();
            }
        }
    }

    public void parseJsonObject(JsonConfigCategory category) {
        do {
            requireToken(TokenType.STRING);
            JsonToken keyToken = tokenList.consumeToken();

            if (requireToken(TokenType.COLON)) {
                tokenList.consumeToken();

                if (tokenList.match(TokenType.LEFT_CURLY)) {
                    tokenList.consumeToken();

                    parseJsonObject(category.getSubcategory(keyToken.value()));

                    requireToken(TokenType.RIGHT_CURLY);
                    tokenList.consumeToken();

                    // Require commas after each sub category!
                    requireToken(TokenType.COMMA);
                } else {
                    JsonToken valueToken = tokenList.get();

                    if (tokenList.match(TokenType.ERROR)) {
                        AssortedDiscoveries.LOGGER.error("Could not load the value {} for entry {}.",
                                valueToken.value(), keyToken.value());
                    } else {
                        if (category.hasBooleanEntry(keyToken.value())) {
                            requireToken(TokenType.BOOL);
                            JsonBooleanConfigEntry entry = category.getBooleanEntry(keyToken.value());
                            entry.setValue(Boolean.valueOf(valueToken.value()));
                        } else if (category.hasIntegerEntry(keyToken.value())) {
                            requireToken(TokenType.INT);
                            JsonIntegerConfigEntry entry = category.getIntegerEntry(keyToken.value());
                            entry.setValue(Integer.valueOf(valueToken.value()));
                        } else if (category.hasStringEntry(keyToken.value())) {
                            requireToken(TokenType.STRING);
                            JsonStringConfigEntry entry = category.getStringEntry(keyToken.value());
                            entry.setValue(valueToken.value());
                        }
                    }
                    tokenList.consumeToken();

                    requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                }
            }
        } while (tokenList.hasNextToken() && tokenList.matchAndConsume(TokenType.COMMA));
    }

    public boolean requireToken(TokenType... types) {
        if (!tokenList.hasNextToken()) {
            throw new JsonSyntaxException(getErrorMessage(types));
        }

        if (!tokenList.match(types)) {
            throw new JsonSyntaxException(getErrorMessage(types));
        }
        return true;
    }

    private String getErrorMessage(TokenType... types) {
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
        message.append(". Config path: ").append(ModConfig.CONFIG_PATH);

        return message.toString();
    }
}
