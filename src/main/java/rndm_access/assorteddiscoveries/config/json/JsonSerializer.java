package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;
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

    public void serialize(Map<String, Object> changeList) {
        List<String> newContent = new ArrayList<>();

        this.writeContent(newContent, changeList);

        // To prevent partial files we first save it to a temporary file, then replace the config file!
        try {
            Path tempFile = Files.createTempFile(configPath.getFileName().toString(), null);
            Files.write(tempFile, newContent);
            Files.move(tempFile, configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the file!", e);
        }
    }

    public void writeContent(List<String> newContent, Map<String, Object> changeList) {
        List<ConfigCategory> categories = config.getCategories();
        this.writeText("{", newContent);

        for (int i = 0; i < categories.size(); i++) {
            ConfigCategory category = categories.get(i);
            String catName = category.getName();
            String categoryLine = "\"" + catName + "\"" + ": {";
            line++;
            depth++;
            this.writeText(categoryLine, newContent);
            this.traverseSubcategories(category, changeList, newContent);

            List<AbstractConfigEntry<?>> entries = category.getEntries();

            if (category.hasSubCategories() && category.hasEntries()) {
                this.writeText(",", newContent); // We append a comma here because if the category
                                                       // has subcategories then we will have a closing curly here and
                                                       // to support more entries we have to separate it with a comma!
            }

            if (category.hasEntries()) {
                this.writeEntries(entries, changeList, newContent);
            }

            this.writeEndingCurly(i, categories.size(), newContent);
        }
        line++;
        depth--;
        this.writeText("}", newContent);
    }

    private void traverseSubcategories(ConfigCategory category, Map<String, Object> changeList,
                                       List<String> newContent) {
        if (category.hasSubCategories()) {
            List<ConfigCategory> subcategories = category.getSubcategories();

            for (int i = 0; i < subcategories.size(); i++) {
                ConfigCategory subcategory = subcategories.get(i);
                String subcategoryName = subcategory.getName();
                String subcategoryLine = "\"" + subcategoryName + "\"" + ": {";
                List<AbstractConfigEntry<?>> entries = subcategory.getEntries();
                line++;
                depth++;
                this.writeText(subcategoryLine, newContent);
                this.writeEntries(entries, changeList, newContent);
                this.writeEndingCurly(i, subcategories.size(), newContent);
                this.traverseSubcategories(subcategory, changeList, newContent);
            }
        }
    }

    private void writeEntries(List<AbstractConfigEntry<?>> entries, Map<String, Object> changeList,
                              List<String> newContent) {
        depth++;
        for (int i = 0; i < entries.size(); i++) {
            AbstractConfigEntry<?> entry = entries.get(i);
            String entryName = entry.getName();
            Object entryVal = entry.getValue();
            line++;

            if (entry.hasComment()) {
                String comment = "// " + entry.getComment();
                this.writeText(comment, newContent);
                line++;
            }

            if (changeList.containsKey(entryName)) {
                entryVal = changeList.get(entryName);
            }

            String entryLine = "\"" + entryName + "\": " + entryVal;

            if (i < entries.size() - 1) {
                entryLine = entryLine + ",";
            }
            this.writeText(entryLine, newContent);
        }
        depth--;
    }

    private void writeEndingCurly(int i, int size, List<String> newContent) {
        String curlyLine = "}";

        // If we have more stuff then we need to append a comma here!
        if (i < size - 1) {
            curlyLine = curlyLine + ",";
        }

        line++;
        this.writeText(curlyLine, newContent);
        depth--;
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
