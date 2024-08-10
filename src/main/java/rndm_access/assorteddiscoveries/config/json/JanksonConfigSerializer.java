package rndm_access.assorteddiscoveries.config.json;

import org.apache.commons.lang3.SerializationException;
import rndm_access.assorteddiscoveries.config.json.parser.JsonParser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JanksonConfigSerializer {
    private final JsonConfig config;
    private final Path configPath;

    public JanksonConfigSerializer(JsonConfig config, Path configPath) {
        this.config = config;
        this.configPath = configPath;
    }

    public void deserializeConfig() {
        if(Files.exists(configPath)) {
            try {
                List<String> jsonFileLines = Files.readAllLines(configPath);
                JsonParser parser = new JsonParser(jsonFileLines, config);
                parser.parse();
            } catch (IOException e) {
                throw new SerializationException("Failed to deserialize the file!", e);
            }
        } else {
            throw new SerializationException("Cannot deserialize config because the config"
                    + " file does not exist!");
        }
    }

    public void serializeConfig() {
        if(!Files.exists(configPath)) {
            try {
                Files.createFile(configPath);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(configPath)) {
            writer.write(config.toJson());
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize the file!", e);
        }
    }
}
