package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractConfigEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonEntrySaver {
    private final JsonConfig config;
    private final Path configPath;
    private final List<String> fileContent;

    public JsonEntrySaver(JsonConfig config, Path configPath) {
        this.config = config;
        this.configPath = configPath;
        this.fileContent = config.getFileContent();
    }

    public void save(Map<String, Object> entryList) throws IOException {
        for (ConfigCategory category : config.getCategories()) {
            this.saveEntries(entryList, category);
        }
        Files.write(configPath, fileContent);
    }

    private void saveEntries(Map<String, Object> entryList, ConfigCategory category) {
        if (category.hasSubCategories()) {
            for (ConfigCategory subCategory : category.getSubcategories()) {
                this.saveEntries(entryList, subCategory);
            }
        }
        this.saveEntry(entryList, category);
    }

    private void saveEntry(Map<String, Object> entryList, ConfigCategory category) {
        for (String entryName : entryList.keySet()) {
            Object value = entryList.get(entryName);

            if (!category.hasEntry(entryName)) {
                continue;
            }

            if (category.getEndLine() == -1) {
                AssortedDiscoveries.LOGGER.error("Could not save entry {}, because category {} does not exist!",
                        entryName, category.getName());
                continue;
            }

            AbstractConfigEntry<?> entry = category.getEntry(entryName);
            int line = entry.getLine();

            if (line == -1) {
                this.insertEntryLine(entryName, value, category);
            } else {
                this.updateEntryLine(entryName, value, category);
            }
        }
    }

    private void insertEntryLine(String entryName, Object value, ConfigCategory category) {
        int line = category.getEndLine() - 1;
        String entryLine = fileContent.get(line);
        String valueStr = value.toString();
        StringBuilder newLineContent = new StringBuilder(entryLine);

        if (entryLine.isEmpty()) {
            AssortedDiscoveries.LOGGER.error("Failed to save the entry because the config is empty!");
            return;
        }

        char lastChar = entryLine.charAt(entryLine.length() - 1);
        String leadingWhitespace = this.getWhitespace(entryLine);

        if (lastChar != '{') {
            newLineContent.append(",");
        }

        newLineContent.append("\n").append(leadingWhitespace);
        newLineContent.append("\"").append(entryName).append("\": ");
        newLineContent.append(valueStr);

        fileContent.set(line, newLineContent.toString());

        AssortedDiscoveries.LOGGER.warn("Couldn't find the entry in category \"{}\", adding entry \"{}\"",
                category.getName(), entryName);
    }

    private void updateEntryLine(String entryName, Object value, ConfigCategory category) {
        AbstractConfigEntry<?> entry = category.getEntry(entryName);
        int line = entry.getLine();

        if (!Objects.equals(entry.getValue(), value)) {
            int start = entry.getStart();
            int end = entry.getEnd();
            String entryLine = fileContent.get(line);
            String startStr = entryLine.substring(0, start);
            String endStr = entryLine.substring(end);
            String valueStr = value.toString();
            String newLineContent = startStr + "\"" + entryName + "\": " + valueStr + endStr;

            fileContent.set(line, newLineContent);
        }
    }

    private String getWhitespace(String line) {
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (Character.isWhitespace(line.charAt(i))) {
            builder.append(line.charAt(i));
            i++;
        }
        return builder.toString();
    }
}
