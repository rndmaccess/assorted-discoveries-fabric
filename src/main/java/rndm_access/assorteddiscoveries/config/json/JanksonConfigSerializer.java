package rndm_access.assorteddiscoveries.config.json;

import org.apache.commons.lang3.SerializationException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class JanksonConfigSerializer {
    private final JsonConfig configCategories;
    private final Path configPath;

    public JanksonConfigSerializer(JsonConfig configCategories, Path configPath) {
        this.configCategories = configCategories;
        this.configPath = configPath;
    }

    public LinkedList<JsonConfigCategory> deserializeConfig() {
        if(Files.exists(configPath)) {
            try {
                List<String> jsonFileLines = Files.readAllLines(configPath);
                JsonParser parser = new JsonParser(jsonFileLines);
                return parser.parseJsonFile();
            } catch (IOException e) {
                throw new SerializationException("Failed to deserialize the file!", e);
            }
        } else {
            throw new SerializationException("Cannot deserialize config because the config file does not exist!");
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
            writer.write(configCategories.toJson());
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize the file!", e);
        }
    }
}
