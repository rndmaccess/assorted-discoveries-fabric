package rndm_access.assorteddiscoveries.config.json.tokenizer;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.Config;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigTokenizer {
    private int lineNum;
    private int pos;
    private Character curChar;
    private final Path path;
    private String line;
    private final String configName;

    public ConfigTokenizer(String configName) {
        this.lineNum = 0;
        this.pos = 0;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(configName + ".json5");
        this.configName = configName;
    }

    public Config tokenize() throws JsonSyntaxException {
        File file = new File(String.valueOf(path));

        if (path == null || !Files.exists(path)) {
            throw new JsonConfigException("Couldn't load config at " + path + " because it does not exist!");
        }

        Config.Builder config = new Config.Builder(configName);

        try (LineIterator iterator = FileUtils.lineIterator(file)) {
            consumeChar(iterator); // Bump the char pointer to the first character
            require('{');
            consumeChar(iterator);

            while (iterator.hasNext() && this.curChar != '}') {
                this.tokenizeLine(config, iterator);
            }
            require('}');
            consumeChar(iterator);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return config.build();
    }

    private void tokenizeLine(Config.Builder config, LineIterator iter) throws JsonSyntaxException {
        if(consumeComment(iter)) {
            return;
        }

        if (curChar == '"') {
            consumeChar(iter);
            JsonConfigCategory category = parseCategory(iter);
            config.addCategory(category);
        }
    }

    private boolean consumeComment(LineIterator iter) {
        if (curChar == '/') {
            consumeChar(iter);
            require('/');
            consumeChar(iter);

            line = iter.next().strip();
            pos = 0;
            lineNum++;
            this.curChar = line.charAt(pos);
            return true;
        }
        return false;
    }

    private JsonConfigCategory parseCategory(LineIterator iter) {
        String key = parseKey(iter);
        require(':', key);
        consumeChar(iter);
        require('{');
        consumeChar(iter);

        JsonConfigCategory.Builder categoryBuilder = new JsonConfigCategory.Builder(key);
        parseEntry(categoryBuilder, iter);
        require('}');
        consumeChar(iter);

        if (this.curChar != '}') {
            require(',');
            consumeChar(iter);
        }

        return categoryBuilder.build();
    }

    private void parseEntry(JsonConfigCategory.Builder category, LineIterator iter) throws JsonSyntaxException {
        while (iter.hasNext() && curChar != '}') {
            if(consumeComment(iter)) {
                continue;
            }

            String key = parseKey(iter);
            StringBuilder valueBuilder = new StringBuilder();

            require(':', key);
            consumeChar(iter);

            while (this.curChar != '}' && this.curChar != ',') {
                valueBuilder.append(this.curChar);
                consumeChar(iter);
            }

            if (this.curChar != '}') {
                require(',');
                consumeChar(iter);
            }

            String value = valueBuilder.toString().toLowerCase();

            if (value.equals("true") || value.equals("false")) {
                category.addEntry(new BooleanConfigEntry(key, Boolean.parseBoolean(value)));
            } else {
                AssortedDiscoveries.LOGGER.warn("The type for {} is not supported using default!", key);
            }
        }
    }

    private String parseKey(LineIterator iter) throws JsonSyntaxException {
        StringBuilder keyBuilder = new StringBuilder();

        if (curChar == '"') {
            consumeChar(iter);
        }

        while (curChar != ':' && this.curChar != '"') {
            keyBuilder.append(curChar);
            consumeChar(iter);
        }
        if (curChar == '"') {
            consumeChar(iter);
        }
        return keyBuilder.toString();
    }

    private void consumeChar(LineIterator iter) {
        do {
            nextChar(iter);
        } while (Character.isWhitespace(curChar));
    }

    private void nextChar(LineIterator iter) {
        pos++;

        if (iter.hasNext()) {
            if (line == null || pos > line.length() - 1) {
                line = iter.next().strip();
                pos = 0;
                lineNum++;
            }
            curChar = line.charAt(pos);
        }
    }

    private void require(char expectedChar) {
        require(expectedChar, this.curChar.toString());
    }

    private void require(char expectedChar, String prevToken) throws JsonSyntaxException {
        if (this.curChar != expectedChar) {
            int reportedLine = this.lineNum + 1;

            throw new JsonSyntaxException("Expected '" + expectedChar
                    + "', got '" + prevToken + "' at line " + reportedLine);
        }
    }
}
