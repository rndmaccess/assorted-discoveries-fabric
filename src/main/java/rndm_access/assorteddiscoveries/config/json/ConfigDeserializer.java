package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.CommentConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.StringConfigEntry;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenList;
import rndm_access.assorteddiscoveries.config.json.tokenizer.ConfigTokenizer;
import rndm_access.assorteddiscoveries.config.json.tokenizer.TokenType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

public class ConfigDeserializer {
    private TokenList tokenList;
    private final Path configPath;
    private final String configName;

    /**
     * @param configName The name of the config without the file suffix.
     */
    public ConfigDeserializer(String configName) throws IOException {
        this.configName = configName;
        this.configPath = FabricLoader.getInstance().getConfigDir().resolve(configName + ".json5");
    }

    public Config deserialize() throws JsonSyntaxException {
        // We tokenize here in case this method throws a JsonConfigException
        this.tokenList = new ConfigTokenizer(configPath).tokenize();
        Config.Builder config = new Config.Builder(configName);

        if(tokenList.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Could not load the config file because it was empty!");
            return config.build();
        }

        requireToken(TokenType.LEFT_CURLY);
        deserialize(config);
        requireToken(TokenType.RIGHT_CURLY);
        return config.build();
    }

    private void deserialize(Config.Builder config) throws JsonSyntaxException {
        while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {
            if (tokenList.match(TokenType.COMMENT)) {
                String value = tokenList.consumeToken().getValue();
                CommentConfigEntry comment = new CommentConfigEntry(value);
                config.addComment(comment);
            } else {
                this.parseCategoryOrEntry(config);
            }
        }
    }

    private void parseCategoryOrEntry(Config.Builder config) {
        Token keyToken = requireToken(TokenType.KEY);
        requireToken(TokenType.COLON);

        if (tokenList.matchAndConsume(TokenType.LEFT_CURLY)) {
            JsonConfigCategory category = parseCategory(keyToken);
            config.addCategory(category);
        } else {
            requireToken(TokenType.VALUE);
            AssortedDiscoveries.LOGGER.warn("Config entries are not allowed outside categories! Skipping entry {}", keyToken.getValue());
        }

        if (!tokenList.match(TokenType.RIGHT_CURLY) && tokenList.getNext() != null) {
            requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
        }
    }

    /**
     * @param input The input to trim!
     * @return The input without extra surrounding quotes if there are any otherwise the input itself.
     */
    private String parseString(String input) {
        if (input.charAt(0) == '"' && input.charAt(input.length() - 1) == '"') {
            return input.substring(1, input.length() - 1);
        }
        return input;
    }

    private JsonConfigCategory parseCategory(Token keyToken) throws JsonSyntaxException {
        String categoryName = parseString(keyToken.getValue());
        JsonConfigCategory.Builder category = new JsonConfigCategory.Builder(categoryName);
        parseEntry(category);
        return category.build();
    }

    private void parseEntry(JsonConfigCategory.Builder category) throws JsonSyntaxException {
        while (tokenList.hasNextToken() && !tokenList.match(TokenType.RIGHT_CURLY)) {
            if (tokenList.match(TokenType.COMMENT)) {
                String value = tokenList.consumeToken().getValue();
                CommentConfigEntry comment = new CommentConfigEntry(value);
                category.addComment(comment);
            } else if (tokenList.match(TokenType.ERROR)) {
                throw new JsonSyntaxException(getSyntaxErrorMessage(TokenType.KEY));
            } else if (tokenList.match(TokenType.KEY)) {
                Token keyToken = requireToken(TokenType.KEY);
                requireToken(TokenType.COLON);

                if (tokenList.match(TokenType.ERROR)) {
                    tokenList.consumeToken();
                    AssortedDiscoveries.LOGGER.error("The type for {} is not supported!", keyToken.getValue());
                } else if (tokenList.match(TokenType.LEFT_CURLY)) {
                    tokenList.consumeToken();
                    JsonConfigCategory subcategory = parseCategory(keyToken);
                    AssortedDiscoveries.LOGGER.warn("Only top level config categories are supported! Ignoring subcategory {}", subcategory);
                } else {
                    Token token = requireToken(TokenType.VALUE);
                    String key = parseString(keyToken.getValue());
                    String value = token.getValue();

                    if (Objects.equals(value, "true") || Objects.equals(value, "false")) {
                        boolean boolVal = Boolean.parseBoolean(value);
                        BooleanConfigEntry entry = new BooleanConfigEntry(key, boolVal);
                        category.addEntry(entry);
                    } else {
                        String stringVal = parseString(value);
                        StringConfigEntry entry = new StringConfigEntry(key, stringVal);
                        category.addEntry(entry);
                    }
                }

                if (!tokenList.match(TokenType.RIGHT_CURLY)) {
                    requireToken(TokenType.COMMA, TokenType.RIGHT_CURLY);
                }
            }
        }
        tokenList.consumeToken(); // Consume the closing right curly for this entry!
    }

    public Token requireToken(TokenType... types) throws JsonSyntaxException {
        if (!tokenList.match(types)) {
            throw new JsonSyntaxException(getSyntaxErrorMessage(types));
        }
        return tokenList.consumeToken();
    }

    private String getSyntaxErrorMessage(TokenType... types) {
        StringBuilder message = new StringBuilder();

        message.append("Failed to load config at ").append(configPath).append(": ");

        for (int i = 0; i < types.length; i++) {
            message.append("'").append(types[i].getSerializedName()).append("'");

            if(i != types.length - 1) {
                message.append(" or ");
            }
        }
        message.append(" expected");

        if (tokenList.hasNextToken()) {
            Token currentToken = tokenList.get();

            message.append(", got ");
            if (tokenList.match(TokenType.VALUE)) {
                message.append("'").append(currentToken.getType().getSerializedName()).append("'");
                message.append(" with value ").append("'").append(currentToken.getValue()).append("'");
            } else {
                message.append("'").append(currentToken.getValue()).append("'");
            }
            message.append(" at line ").append(currentToken.getLine() + 1);
        }
        return message.toString();
    }
}
