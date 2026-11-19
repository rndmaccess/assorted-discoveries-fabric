package rndm_access.assorteddiscoveries.config.json;

import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.config.ModConfigCategory;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class JsonConfigSerializer {
    private int line;
    private int depth;
    private final Path configPath;

    public JsonConfigSerializer(Path configPath) {
        line = 0;
        depth = 0;
        this.configPath = configPath;
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
        try (TempJsonConfig tempFile = new TempJsonConfig(configPath)) {
            Files.write(tempFile.getFile(), newContent);
            Files.move(tempFile.getFile(), configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file!", e);
        }
    }

    private List<String> getContent(@Nullable Map<String, Object> changeList) {
        List<String> newContent = new ArrayList<>();
        JsonConfig config = ModConfig.CONFIG_MANAGER.getConfig();

        for (String comment : config.getGlobalComments()) {
            this.writeComment(newContent, comment);
        }
        this.writeText("\n", newContent);

        this.writeText("{", newContent);
        depth++;
        line++;

        List<ModConfigCategory> categories = config.getCategories();
        int size = categories.size();
        for (int i = 0; i < size; i++) {
            ModConfigCategory category = categories.get(i);
            String comment = category.getCategoryComment();
            this.writeComment(newContent, comment);
            this.writeCategory(newContent, category, changeList);

            if(i + 1 < size) {
                this.writeText(",", newContent);
            }
            line++;
        }
        line++;
        depth--;
        this.writeText("}", newContent);
        return newContent;
    }

    private void writeCategory(List<String> newContent, ModConfigCategory category, Map<String, Object> changeList) {
        this.writeText("\"" + category.getCategoryName() + "\": {", newContent);
        depth++;
        line++;

        List<JsonConfigEntry<?>> entries = category.getEntries();
        int size = entries.size();
        for (int i = 0; i < size; i++) {
            JsonConfigEntry<?> entry = entries.get(i);

            if (entry.hasComment()) {
                this.writeComment(newContent, entry.getComment());
            }

            this.writeEntry(newContent, entry, changeList);

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

    private void writeEntry(List<String> newContent, JsonConfigEntry<?> entry,
                            Map<String, Object> changeList) {
        StringBuilder entryLine = new StringBuilder();
        String key = entry.getKey();
        Object value = entry.getLocalValue();
        entryLine.append("\"").append(key).append("\": ");

        if (changeList != null && changeList.containsKey(key)) {
            value = changeList.get(key);
        }
        entryLine.append(value);
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
