package rndm_access.assorteddiscoveries.config.json;

import org.apache.commons.lang3.SerializationException;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.JsonParser;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.ConfigValue;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class JsonConfigSerializer {
    private final JsonConfig config;
    private final Path configPath;

    public JsonConfigSerializer(JsonConfig config, Path configPath) {
        this.config = config;
        this.configPath = configPath;
    }

    public void deserializeConfig() {
        if(Files.exists(configPath)) {
            try {
                config.setFileContent(Files.readAllLines(configPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            JsonParser parser = new JsonParser(config, configPath);
            JsonEntryCorrector corrector = new JsonEntryCorrector(config, configPath);
            parser.parse();

            Map<String, Token> entryErrors = parser.getEntryErrors();

            if (!entryErrors.isEmpty()) {
                corrector.correct(entryErrors);
            }
        } else {
            throw new SerializationException("Cannot deserialize config because the config"
                    + " file does not exist!");
        }
    }

    public void serializeConfig(Map<String, Object> entryList) {
        if (!Files.exists(configPath)) {
            try (BufferedWriter writer = Files.newBufferedWriter(configPath)) {
                String configContent = config.createFileContent();
                writer.write(configContent);
            } catch (IOException e) {
                throw new SerializationException("Failed to serialize the file!", e);
            }
        } else {
            if (config.getFileContent().isEmpty()) {
                throw new SerializationException("The config was not loaded!");
            }

            try {
                List<String> fileContent = config.getFileContent();

                for (ConfigCategory category : config.getCategories()) {
                    if (category.hasSubCategories()) {
                        this.updateSubCategoryEntries(fileContent, entryList, category);
                    }
                    updateEntryValues(fileContent, entryList, category);
                }

                Files.write(config.getPath(), fileContent);
            } catch (IOException e) {
                throw new SerializationException("Failed to serialize the file!", e);
            }
        }
    }

    private void updateSubCategoryEntries(List<String> fileContent, Map<String, Object> entryList,
                                          ConfigCategory category) {
        for (String subcategoryName : category.getSubcategoryNames()) {
            ConfigCategory subCategory = category.getSubcategory(subcategoryName);

            if (subCategory.hasSubCategories()) {
                updateSubCategoryEntries(fileContent, entryList, category);
            }
            updateEntryValues(fileContent, entryList, subCategory);
        }
    }

    private void updateEntryValues(List<String> fileContent, Map<String, Object> entryList,
                                   ConfigCategory category) {
        for (String entryName : entryList.keySet()) {
            updateEntryValue(fileContent, entryList, category, entryName);
        }
    }

    private void updateEntryValue(List<String> fileContent, Map<String, Object> entryList, ConfigCategory category,
                                  String entryName) {
        if (category.hasEntry(entryName)) {
            AbstractConfigEntry<?> entry = category.getEntry(entryName);
            int entryLine = entry.getLine();

            if(entryLine != -1) {
                ConfigValue<?> value = entry.getValue();
                int valStart =  value.getStart();
                int valEnd = value.getEnd();

                Object newValue = entryList.get(entryName);
                String line = fileContent.get(entryLine);
                String startLine = line.substring(0, valStart);
                String endLine = line.substring(valEnd);

                fileContent.set(entryLine, startLine + newValue + endLine);
            } else {
                int lastEntryLine = category.getEndLine() - 1;
                String line = fileContent.get(lastEntryLine);
                String indent = getWhitespace(line);

                line += ",\n" + indent;
                line += "\"" + entryName + "\": " + entryList.get(entryName);

                fileContent.set(lastEntryLine, line);
            }
        }
    }

    public String getWhitespace(String line) {
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while (Character.isWhitespace(line.charAt(i))) {
            builder.append(line.charAt(i));
            i++;
        }
        return builder.toString();
    }
}
