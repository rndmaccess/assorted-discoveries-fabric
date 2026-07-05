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
import java.util.StringJoiner;

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

            require(iterator, '{');
            while (curChar != '\0') {
                this.tokenizeLine(config, iterator);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return config.build();
    }

    private void tokenizeLine(Config.Builder config, LineIterator iter) throws JsonSyntaxException {
        if(consumeComment(iter)) {
            return;
        }

        String key = parseKey(iter);
        require(iter, key, ':');

        if (this.curChar == '{') {
            JsonConfigCategory category = parseCategory(key, iter);
            config.addCategory(category);
            require(iter, '}', ',');
        } else {
            int reportedLine = this.lineNum + 1;
            throw new JsonSyntaxException("Expected a config category but got '" + curChar + "' at line " + reportedLine);
        }
    }

    private boolean consumeComment(LineIterator iter) {
        if (curChar == '/') {
            consumeChar(iter);
            require(iter, '/');

            line = iter.next().strip();
            pos = 0;
            lineNum++;
            this.curChar = line.charAt(pos);
            return true;
        }
        return false;
    }

    private JsonConfigCategory parseCategory(String key, LineIterator iter) {
        require(iter, '{');
        JsonConfigCategory.Builder categoryBuilder = new JsonConfigCategory.Builder(key);
        parseEntries(categoryBuilder, iter);
        return categoryBuilder.build();
    }

    private void parseEntries(JsonConfigCategory.Builder category, LineIterator iter) throws JsonSyntaxException {
        while (curChar != '\0' && curChar != '}') {
            if(consumeComment(iter)) {
                continue;
            }

            String key = parseKey(iter);
            require(iter, key, ':');

            if (this.curChar == '{') {
                parseCategory(key, iter);
                AssortedDiscoveries.LOGGER.warn("Only top level config categories are supported! Ignoring subcategory '{}'", key);
            } else {
                String value = parseValue(iter);

                if (value.equals("true") || value.equals("false")) {
                    category.addEntry(new BooleanConfigEntry(key, Boolean.parseBoolean(value)));
                } else {
                    AssortedDiscoveries.LOGGER.warn("The type for {} is not supported using default!", key);
                }
            }

            if (this.curChar != '}') {
                require(iter, ','); // Consume and require the comma after each category/entry!
            }
        }
        require(iter, '}'); // Consume and require the left curly after each category!
    }

    private String parseValue(LineIterator iter) throws JsonSyntaxException {
        StringBuilder valueBuilder = new StringBuilder();

        while (this.curChar != '\0' && this.curChar != '}' && this.curChar != ',') {
            valueBuilder.append(this.curChar);
            consumeChar(iter);
        }
        return valueBuilder.toString().toLowerCase();
    }

    private String parseKey(LineIterator iter) throws JsonSyntaxException {
        StringBuilder keyBuilder = new StringBuilder();

        require(iter, '"');
        while (this.curChar != '\0' && curChar != ':' && this.curChar != '"') {
            keyBuilder.append(curChar);
            consumeChar(iter);
        }
        require(iter, '"');
        return keyBuilder.toString();
    }

    private void consumeChar(LineIterator iter) {
        do {
            nextChar(iter);
        } while (Character.isWhitespace(curChar));
    }

    private void nextChar(LineIterator iter) {
        pos++;

        while (line == null || pos > line.length() - 1) {
            if (!iter.hasNext()) {
                curChar = '\0';
                return;
            }

            line = iter.next().strip();
            pos = 0;
            lineNum++;

            // Skip empty lines!
            if (line.isEmpty()) {
                line = null;
            }
        }
        curChar = line.charAt(pos);
    }

    private void require(LineIterator iter, Character... expectedChars) {
        require(iter, this.curChar.toString(), expectedChars);
    }

    private void require(LineIterator iter, String prevToken, Character... expectedChars) throws JsonSyntaxException {
        Character expectedChar = matchesChar(expectedChars);

        if (expectedChar != null) {
            int reportedLine = this.lineNum + 1;
            StringJoiner charText = new StringJoiner(" or ");

            for (char c : expectedChars) {
                charText.add("'" + c + "'");
            }
            throw new JsonSyntaxException("Expected " + charText
                    + ", got '" + prevToken + "' at line " + reportedLine);
        } else {
            consumeChar(iter);
        }
    }

    private Character matchesChar(Character... expectedChars) {
        Character invalidChar = null;
        for (char c : expectedChars) {
            if (this.curChar == c) {
                return null;
            }
            invalidChar = c;
        }
        return invalidChar;
    }
}
