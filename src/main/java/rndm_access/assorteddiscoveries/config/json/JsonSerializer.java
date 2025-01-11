package rndm_access.assorteddiscoveries.config.json;

import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.AbstractConfigEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class JsonSerializer {
    private int line;
    private int depth;
    private final Path configPath;
    private final JsonConfig config;

    public JsonSerializer(JsonConfig config, Path configPath) {
        line = 0;
        depth = 0;
        this.configPath = configPath;
        this.config = config;
    }

    /*
     * This method is used to serialize to a new config file!
     */
    public void serialize() {
        // The config does not exist so we don't have any changes!
        this.serialize(null);
    }

    /**
     * This method is used to serialize new changes to a config file!
     * @param changeList The changes to serialize
     */
    public void serialize(Map<String, Object> changeList) {
        List<String> newContent = this.getContent(changeList);

        // To prevent partial files we first save it to a temporary file, then replace the config file!
        try {
            Path tempFile = Files.createTempFile(configPath.getFileName().toString(), null);
            Files.write(tempFile, newContent);
            Files.move(tempFile, configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file!", e);
        }
    }

    private List<String> getContent(@Nullable Map<String, Object> changeList) {
        List<String> newContent = new ArrayList<>();

        if (!config.getCategories().isEmpty()) {
            this.writeText("{", newContent);

            depth++;
            int i = 0;
            for (ConfigCategory category : config.getCategories()) {
                line++;
                this.writeCategory(newContent, category, changeList);

                if(i + 1 < config.getCategories().size()) {
                    this.writeText(",", newContent);
                }
                i++;
            }
            line++;
            depth--;
            this.writeText("}", newContent);
        }
        return newContent;
    }

    private void writeCategory(List<String> newContent, ConfigCategory category, Map<String, Object> changeList) {
        List<ConfigObject> objects = category.getJsonObjects();
        this.writeText("\"" + category.getKey() + "\": {", newContent);
        depth++;
        line++;

        for (int i = 0; i < objects.size(); i++) {
            ConfigObject component = objects.get(i);
            String key = component.getKey();

            if (component.isComment()) {
                this.writeComment(newContent, key);
                continue;
            }

            if (category.hasEntry(key)) {
                AbstractConfigEntry<?> entry = (AbstractConfigEntry<?>) component;
                writeEntry(newContent, category, entry, changeList);
            } else {
                ConfigCategory subCategory = category.getSubcategory(key);
                writeCategory(newContent, subCategory, changeList);
            }

            if (i + 1 < category.getJsonObjects().size()) {
                this.writeText(",", newContent);
                line++;
            } else {
                depth--;
                line++;
                this.writeText("}", newContent);
            }
        }
    }

    private void writeEntry(List<String> newContent, ConfigCategory category, AbstractConfigEntry<?> entry,
                            Map<String, Object> changeList) {
        this.writeText("\"" + entry.getKey() + "\": ", newContent);

        if (category.hasStringEntry(entry.getKey())) {
            String entryName = entry.getKey();
            Object entryVal = entry.getValue();

            if (changeList.containsKey(entryName)) {
                entryVal = changeList.get(entryName);
            }

            this.writeText("\"" + entryVal + "\"", newContent);
        } else {
            String entryName = entry.getKey();
            Object entryVal = entry.getValue();

            if (changeList != null && changeList.containsKey(entryName)) {
                entryVal = changeList.get(entryName);
            }

            this.writeText(entryVal.toString(), newContent);
        }
    }

    private void writeComment(List<String> newContent, String comment) {
        this.writeText("// ", newContent);

        for (int i = 0; i < comment.length(); i++) {
            char token = comment.charAt(i);

            if(token == '\n') {
                line++;
                this.writeText("// ", newContent);
            } else {
                this.writeText(Character.toString(token), newContent);
            }
        }
        line++;
    }

    private void writeText(String value, List<String> newContent) {
        if (line >= newContent.size()) {
            if (depth > 0) {
                newContent.add("\t".repeat(depth) + value);
            } else {
                newContent.add(value);
            }
        } else {
            String lineContent = newContent.get(line);
            newContent.set(line, lineContent + value);
        }
    }
}
