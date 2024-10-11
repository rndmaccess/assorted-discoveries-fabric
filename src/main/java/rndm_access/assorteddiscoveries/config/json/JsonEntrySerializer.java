package rndm_access.assorteddiscoveries.config.json;

import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.ConfigValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonEntrySerializer {
    private final JsonConfig config;
    private final Path configPath;

    public JsonEntrySerializer(JsonConfig config, Path configPath) {
        this.config = config;
        this.configPath = configPath;
    }

    public void serialize(Map<String, Object> entryList) throws IOException {
        List<String> fileContent = config.getFileContent();

        for (ConfigCategory category : config.getCategories()) {
            if (category.hasSubCategories()) {
                this.serializeEntries(fileContent, entryList, category);
            }

            for (String entryName : entryList.keySet()) {
                serializeCategory(fileContent, entryList, category, null, entryName);
            }
        }
        Files.write(configPath, fileContent);
    }

    private void serializeEntries(List<String> fileContent, Map<String, Object> entryList,
                                  ConfigCategory category) {
        for (String subcategoryName : category.getSubcategoryNames()) {
            ConfigCategory subCategory = category.getSubcategory(subcategoryName);

            if (subCategory.hasSubCategories()) {
                serializeEntries(fileContent, entryList, category);
            }

            for (String entryName : entryList.keySet()) {
                serializeCategory(fileContent, entryList, category, subCategory, entryName);
            }
        }
    }

    private void serializeCategory(List<String> fileContent, Map<String, Object> entryList,
                                   ConfigCategory category, @Nullable ConfigCategory subcategory, String entryName) {
        if(category.hasEntry(entryName)) {
            serializeEntry(fileContent, entryList, category, entryName);
            return;
        }

        // TODO: add outer categories to the config file if the entry exists in an inner category and multiple
        //  categories are not defined!
        Queue<ConfigCategory> categories = new ArrayDeque<>();

        if (subcategory != null && subcategory.hasEntry(entryName)) {
            if (subcategory.getStartLine() == -1) {
                int categoryEndLine = category.getEndLine() - 1;
                String line = fileContent.get(categoryEndLine);
                String indent = getWhitespace(line);

                line += ",\n" + indent;
                line += "\"" + subcategory.getKey().getName() + "\": {\n";
                line += "\t" + makeEntry(fileContent, entryList, category, entryName);
                line += "\n" + indent + "}";

                fileContent.set(categoryEndLine, line);
            } else {
                serializeEntry(fileContent, entryList, subcategory, entryName);
            }
        } else {
            // TODO: search each inner category recursively so it gets added to the entry gets added
            //  to the correct category!
            serializeEntry(fileContent, entryList, category, entryName);
        }
    }

    private void serializeEntry(List<String> fileContent, Map<String, Object> entryList,
                                ConfigCategory category, String entryName) {
        if(category.getEntry(entryName).getLine() == -1) {
            int categoryEndLine = category.getEndLine() - 1;
            String line = fileContent.get(categoryEndLine);

            line += ",\n";
            line += makeEntry(fileContent, entryList, category, entryName);

            fileContent.set(categoryEndLine, line);
        } else {
            updateValue(fileContent, entryList, category, entryName);
        }
    }

    private void updateValue(List<String> fileContent, Map<String, Object> entryList,
                             ConfigCategory category, String entryName) {
        AbstractConfigEntry<?> entry = category.getEntry(entryName);
        int entryLine = entry.getLine();
        ConfigValue<?> value = entry.getValue();
        int valStart =  value.getStart();
        int valEnd = value.getEnd();

        Object newValue = entryList.get(entryName);
        String line = fileContent.get(entryLine);
        String startLine = line.substring(0, valStart);
        String endLine = line.substring(valEnd);

        fileContent.set(entryLine, startLine + newValue + endLine);
    }

    private String makeEntry(List<String> fileContent, Map<String, Object> entryList,
                             ConfigCategory category, String entryName) {
        int lastEntryLine = category.getEndLine() - 1;
        String line = fileContent.get(lastEntryLine);
        String indent = getWhitespace(line);

        return indent + "\"" + entryName + "\": " + entryList.get(entryName);
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
