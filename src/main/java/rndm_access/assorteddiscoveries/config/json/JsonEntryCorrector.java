package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

public class JsonEntryCorrector {
    private final JsonConfig config;
    private final Path configPath;
    private final List<String> fileContent;

    public JsonEntryCorrector(List<String> fileContent, JsonConfig config, Path configPath) {
        this.config = config;
        this.configPath = configPath;
        this.fileContent = fileContent;
    }

    public void correct(Map<String, Token> errorList) {
        for (ConfigCategory category : config.getCategories()) {
            if (category.hasSubCategories()) {
                this.correctSubcategoryEntries(errorList, category);
            }
            this.correctEntries(errorList, category);
        }

        try {
            // To prevent partial files we first save it to a temporary file, then replace the config file!
            Path tempFile = Files.createTempFile(configPath.getFileName().toString(), null);
            Files.write(tempFile, fileContent);
            Files.move(tempFile, configPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Could not correct the config!", e);
        }
    }

    private void correctSubcategoryEntries(Map<String, Token> errorList, ConfigCategory category) {
        for (ConfigCategory subcategory : category.getSubcategories()) {

            if (subcategory.hasSubCategories()) {
                this.correctSubcategoryEntries(errorList, category);
            }
            this.correctEntries(errorList, subcategory);
        }
    }

    private void correctEntries(Map<String, Token> errorList, ConfigCategory category) {
        for (String entryName : errorList.keySet()) {
            this.correctEntryValue(errorList, category, entryName);
        }
    }

    private void correctEntryValue(Map<String, Token> errorList, ConfigCategory category, String entryName) {
        if (category.hasEntry(entryName)) {
            Token errorToken = errorList.get(entryName);
            int lineNum = errorToken.getLine();
            int errorStart = errorToken.getStart();
            int errorEnd = errorToken.getEnd();
            String errorValue = errorToken.getValue();
            Object defaultValue = category.getEntry(entryName).getValue();
            String line = fileContent.get(lineNum);
            String startLine = line.substring(0, errorStart);
            String endLine = line.substring(errorEnd);

            fileContent.set(lineNum, startLine + defaultValue + endLine); // Correct the entry's value!

            AssortedDiscoveries.LOGGER.warn("Could not load value {} for entry \"{}\", correcting to {} at line {}.",
                    errorValue, entryName, defaultValue, lineNum);
        }
    }
}
