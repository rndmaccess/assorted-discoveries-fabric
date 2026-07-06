package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;

public class ConfigDeserializer {
    private int lineNum;
    private int pos;
    private Character curChar;
    private final Path path;
    private String line;
    private final String configName;
    private int invalidTypeNum;

    public ConfigDeserializer(String configName) {
        this.lineNum = 0;
        this.pos = 0;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(configName + ".json5");
        this.configName = configName;
        this.invalidTypeNum = 0;
    }

    public Config deserialize() throws JsonSyntaxException {
        File file = new File(String.valueOf(path));

        if (path == null || !Files.exists(path)) {
            throw new JsonConfigException("Couldn't load config at " + path + " because it does not exist!");
        }

        Config.Builder config = new Config.Builder(configName);

        try (LineIterator iterator = FileUtils.lineIterator(file)) {
            consumeChar(iterator); // Bump the char pointer to the first character

            require(iterator, '{');
            while (curChar != '\0') {
                this.deserializeLine(config, iterator);
            }

            if (this.invalidTypeNum > 0) {
                AssortedDiscoveries.LOGGER.warn("Config: The type for {} entry(s) is not supported using the default values for each!",  invalidTypeNum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return config.build();
    }

    private void deserializeLine(Config.Builder config, LineIterator iter) throws JsonSyntaxException {
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
                    invalidTypeNum += 1;
                }
            }

            if (this.curChar != '}') {
                require(iter, ','); // Consume and require the comma after each category/entry!
            }
        }
        require(iter, '}'); // Consume and require the left curly after each category!
    }

    private String parseValue(LineIterator iter) throws JsonSyntaxException {
        int startPos = this.pos;

        if (findEndingChar(',', '}')) {
            String value = line.substring(startPos, this.pos); // Saves some time if the ending character is all on the same line!
            return value.toLowerCase();
        } else {
            StringBuilder valueBuilder = new StringBuilder();

            while (this.curChar != '\0' && this.curChar != '}' && this.curChar != ',') {
                valueBuilder.append(this.curChar);
                consumeChar(iter);
            }
            return valueBuilder.toString().toLowerCase();
        }
    }

    private String parseKey(LineIterator iter) throws JsonSyntaxException {
        require(iter, '"');
        int startPos = this.pos;

        if (findEndingChar('"')) {
            String key = line.substring(startPos, this.pos); // Saves some time if the ending character is all on the same line!
            require(iter, '"');
            return key;
        } else {
            StringBuilder keyBuilder = new StringBuilder();

            while (this.curChar != '\0' && curChar != ':' && this.curChar != '"') {
                keyBuilder.append(curChar);
                consumeChar(iter);
            }
            require(iter, '"');
            return keyBuilder.toString();
        }
    }

    private boolean findEndingChar(Character... endChars) {
        for (int i = this.pos; i < line.length(); i++) {
            for (char endChar : endChars) {
                if (line.charAt(i) == endChar) {
                    movePointer(i); // Manually move the char pointer to the ending character!
                    return true;
                }
            }
        }
        return false;
    }

    private void movePointer(int pos) {
        this.pos = pos;
        curChar = line.charAt(pos);
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
