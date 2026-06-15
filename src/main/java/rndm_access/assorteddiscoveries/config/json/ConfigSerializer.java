package rndm_access.assorteddiscoveries.config.json;

import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.json_objects.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.StringConfigEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class ConfigSerializer {
    private int line;
    private int depth;
    private final Path configPath;
    private final Config config;

    public ConfigSerializer(Config config, Path configPath) {
        line = 0;
        depth = 0;
        this.configPath = configPath;
        this.config = config;
    }

    /**
     * Create a new config file!
     */
    public void serialize() {
        // The config does not exist so we don't have any changes!
        this.serialize(null);
    }

    /**
     * Save changes to a config file!
     * @param changeList The changes to save
     */
    public void serialize(Map<String, Object> changeList) {
        List<String> newContent = this.getContent(changeList);

        // To prevent partial files we first save it to a temporary file, then replace the config file!
        try (TempConfig tempFile = new TempConfig(configPath)) {
            Files.write(tempFile.getFile(), newContent);
            Files.move(tempFile.getFile(), configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file!", e);
        }
    }

    private List<String> getContent(@Nullable Map<String, Object> changeList) {
        List<String> newContent = new ArrayList<>();
        List<ConfigObject> objects = config.getObjects();

        if (!objects.isEmpty()) {
            this.writeText("{", newContent);
            depth++;
            line++;

            int size = objects.size();
            for (int i = 0; i < size; i++) {
                ConfigObject object = objects.get(i);

                if (object.isComment()) {
                    String comment = object.getKey();
                    this.writeComment(newContent, comment);
                    continue;
                }

                JsonConfigCategory category = (JsonConfigCategory) object;
                this.writeCategory(newContent, category, changeList);

                if(i + 1 < size) {
                    this.writeText(",", newContent);
                }
                line++;
            }
            line++;
            depth--;
            this.writeText("}", newContent);
        }
        return newContent;
    }

    private void writeCategory(List<String> newContent, JsonConfigCategory category, Map<String, Object> changeList) {
        List<ConfigObject> objects = category.getConfigObjects();
        int size = objects.size();
        this.writeText("\"" + category.getKey() + "\": {", newContent);
        depth++;
        line++;

        for (int i = 0; i < size; i++) {
            ConfigObject component = objects.get(i);
            String key = component.getKey();

            if (component.isComment()) {
                this.writeComment(newContent, key);
                continue;
            }

            AbstractConfigEntry<?> entry = category.getEntry(key);
            if (entry != null) {
                this.writeEntry(newContent, entry, changeList);
            }

            if (i + 1 < size) {
                this.writeText(",", newContent);
                line++;
            } else {
                depth--;
                line++;
                this.writeText("}", newContent);
            }
        }
    }

    private void writeEntry(List<String> newContent, AbstractConfigEntry<?> entry,
                            Map<String, Object> changeList) {
        StringBuilder entryLine = new StringBuilder();
        String key = entry.getKey();
        Object value = entry.getValue();
        entryLine.append("\"").append(key).append("\": ");

        if (changeList != null && changeList.containsKey(key)) {
            value = changeList.get(key);
        }

        if (entry instanceof StringConfigEntry) {
            entryLine.append("\"").append(value).append("\"");
        } else {
            entryLine.append(value);
        }
        this.writeText(entryLine.toString(), newContent);
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
