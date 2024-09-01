package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractJsonConfigEntry;
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
            JsonToken keyToken = tokenList.get();

            if(tokenList.match(TokenType.STRING)) {
                tokenList.consumeToken();
                requireToken(TokenType.COLON);
                tokenList.consumeToken();

                if (requireToken(TokenType.LEFT_CURLY)) {
                    tokenList.consumeToken();
                    String categoryName = keyToken.value();
                    int categoryLine = keyToken.line();
                    int categoryColumn = keyToken.column();

                    if(!config.hasCategory(categoryName)) {
                        throw new JsonConfigException("The config does not have category " + categoryName
                                + " at line " + categoryLine + 1
                                + ", column " + categoryColumn + 1);
                    }

                    JsonConfigCategory category = config.getCategory(categoryName);
                    parseJsonObject(category, categoryLine, categoryColumn);
                }
            } else {
                tokenList.consumeToken();
            }
        }
    }

    private void parseJsonObject(JsonConfigCategory category, int categoryLine, int categoryColumn) {
        do {
            requireToken(TokenType.STRING);
            JsonToken keyToken = tokenList.consumeToken();

            if (requireToken(TokenType.COLON)) {
                tokenList.consumeToken();

                if (tokenList.match(TokenType.LEFT_CURLY)) {
                    tokenList.consumeToken();
                    String subcategoryName = keyToken.value();

                    if (!category.hasSubcategory(subcategoryName)) {
                        throw new JsonConfigException(getSubcategoryErrorMessage(category.getName(), categoryLine,
                                categoryColumn, keyToken.value(), keyToken.line(), keyToken.column()));
                    }

                    JsonConfigCategory subcategory = category.getSubcategory(keyToken.value());
                    parseJsonObject(subcategory, keyToken.line(), keyToken.column());

                    requireToken(TokenType.RIGHT_CURLY);
                    tokenList.consumeToken();

                    // Require commas after each sub category!
                    requireToken(TokenType.COMMA);
                } else {
                    JsonToken valueToken = tokenList.get();

                    parseEntry(keyToken, valueToken, category);
                }
            }
        } while (tokenList.hasNextToken() && tokenList.matchAndConsume(TokenType.COMMA));
    }

    private void parseEntry(JsonToken keyToken, JsonToken valueToken, JsonConfigCategory category) {
        if (tokenList.match(TokenType.ERROR)) {
            if(category.hasEntry(keyToken.value())) {
                AbstractJsonConfigEntry<?> entry = category.getEntry(keyToken.value());

                AssortedDiscoveries.LOGGER.warn("Could not load the value {} for entry {} resetting to {}.",
                        valueToken.value(), keyToken.value(), entry.getValue());
            } else {
                logInvalidConfigEntry(keyToken);
            }
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
            } else {
                logInvalidConfigEntry(keyToken);
            }
        }
        tokenList.consumeToken();

        requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
    }

    public boolean requireToken(TokenType... types) {
        if (!tokenList.hasNextToken() || !tokenList.match(types)) {
            throw new JsonSyntaxException(getSyntaxErrorMessage(types));
        }
        return true;
    }

    private void logInvalidConfigEntry(JsonToken keyToken) {
        AssortedDiscoveries.LOGGER.warn("Skipping invalid config entry {}", keyToken.value());
    }

    private String getSubcategoryErrorMessage(String categoryName, int categoryLine, int categoryColumn,
                                              String subcategoryName, int subcategoryLine, int subcategoryColumn) {
        return "The category \"" + categoryName + "\""
                + " at line " + (categoryLine + 1)
                + ", column " + (categoryColumn + 1)
                + " does not have subcategory \"" + subcategoryName + "\""
                + " at line " + (subcategoryLine + 1)
                + ", column " + (subcategoryColumn + 1) + ".";
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
        message.append(". Config path: ").append(config.getConfigPath());

        return message.toString();
    }
}
