package rndm_access.assorteddiscoveries.config.json;

import org.apache.commons.lang3.SerializationException;
import rndm_access.assorteddiscoveries.config.json.parser.JsonParser;
import rndm_access.assorteddiscoveries.config.json.tokenizer.Token;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
                JsonEntrySerializer entrySerializer = new JsonEntrySerializer(config, configPath);
                entrySerializer.serialize(entryList);
            } catch (IOException e) {
                throw new SerializationException("Failed to serialize the file!", e);
            }
        }
    }
}
