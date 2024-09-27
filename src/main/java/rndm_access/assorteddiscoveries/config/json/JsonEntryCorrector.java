package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.tokenizer.JsonToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class JsonEntryCorrector {
    private final Map<String, JsonToken> errorTokenList;
    private final List<String> fileContent;
    private final JsonConfig config;
    private final Path configPath;

    public JsonEntryCorrector(Map<String, JsonToken> errorTokenList, List<String> fileContent, JsonConfig config,
                              Path configPath) {
        this.errorTokenList = errorTokenList;
        this.fileContent = fileContent;
        this.config = config;
        this.configPath = configPath;
    }

    public void correct() {
        for (JsonConfigCategory category : config.getCategories()) {
            for (String entryName : errorTokenList.keySet()) {
                correctEntryValue(category, entryName);
            }
        }

        try {
            Files.write(configPath, fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void correctEntryValue(JsonConfigCategory category, String entryName) {
        if (category.hasEntry(entryName)) {
            JsonToken errorToken = errorTokenList.get(entryName);
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
