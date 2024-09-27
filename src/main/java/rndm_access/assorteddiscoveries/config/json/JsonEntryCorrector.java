package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class JsonEntryCorrector {
    private final List<String> fileContent;
    private final JsonConfig config;
    private final Path configPath;

    public JsonEntryCorrector(List<String> fileContent, JsonConfig config,
                              Path configPath) {
        this.fileContent = fileContent;
        this.config = config;
        this.configPath = configPath;
    }

    public void correct(Map<String, JsonToken> errorList) {
        for (JsonConfigCategory category : config.getCategories()) {
            if (category.hasSubCategories()) {
                this.correctSubCategoryEntries(errorList, category);
            }
            correctEntries(errorList, category);
        }

        try {
            Files.write(configPath, fileContent);
        } catch (IOException e) {
            throw new RuntimeException("Could not correct the config!", e);
        }
    }

    private void correctSubCategoryEntries(Map<String, JsonToken> errorList, JsonConfigCategory category) {
        for (String subcategoryName : category.getSubcategoryNames()) {
            JsonConfigCategory subCategory = category.getSubcategory(subcategoryName);

            if (subCategory.hasSubCategories()) {
                correctSubCategoryEntries(errorList, category);
            }
            correctEntries(errorList, subCategory);
        }
    }

    private void correctEntries(Map<String, JsonToken> errorList, JsonConfigCategory category) {
        for (String entryName : errorList.keySet()) {
            correctEntryValue(errorList, category, entryName);
        }
    }

    private void correctEntryValue(Map<String, JsonToken> errorList, JsonConfigCategory category, String entryName) {
        if (category.hasEntry(entryName)) {
            JsonToken errorToken = errorList.get(entryName);
            int errorLine = errorToken.getLine();
            int errorStart = errorToken.getStart();
            int errorEnd = errorToken.getEnd();
            String errorValue = errorToken.getValue();
            Object defaultValue = category.getEntry(entryName).getValue();
            String line = fileContent.get(errorLine);
            String startLine = line.substring(0, errorStart);
            String endLine = line.substring(errorEnd);

            fileContent.set(errorLine, startLine + defaultValue + endLine);

            AssortedDiscoveries.LOGGER.warn("Could not load the value {} for entry {} correcting to {}.",
                    errorValue, entryName, defaultValue);
        }
    }
}
