package rndm_access.assorteddiscoveries.config.jankson;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonPrimitive;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import org.apache.commons.lang3.SerializationException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class ADJanksonConfigSerializer {
    private final ADJsonConfig configCategories;
    private final Path configPath;

    public ADJanksonConfigSerializer(ADJsonConfig configCategories, Path configPath) {
        this.configCategories = configCategories;
        this.configPath = configPath;
    }

    public LinkedList<ADJsonConfigCategory> deserializeConfig() {
        Jankson jankson = Jankson.builder().build();

        if(Files.exists(configPath)) {
            try {
                JsonObject jsonFile = jankson.load(Files.readString(configPath));
                ADJsonParser parser = new ADJsonParser(jsonFile);
                return parser.parseJsonFile();
            } catch (SyntaxError | IOException e) {
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

        try {
            BufferedWriter writer = Files.newBufferedWriter(configPath);
            JsonObject jsonObject = new JsonObject();

            for (ADJsonConfigCategory category : configCategories.getCategories()) {
                writeCategories(category, jsonObject);
            }

            try {
                writer.write(jsonObject.toJson(true, true));
            } catch (IOException e) {
                throw new RuntimeException("Failed to serialize the file!", e);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeCategories(ADJsonConfigCategory category, JsonObject jsonObject) {
        JsonObject innerJsonObject = new JsonObject();

        for (ADJsonConfigComponentBase component : category.getComponents()) {
            if (category.hasEntry(component.getName())) {
                ADJsonConfigEntry entry = (ADJsonConfigEntry) component;

                if (entry.getComment() != null) {
                    innerJsonObject.put(entry.getName(), new JsonPrimitive(entry.getValue()),
                            entry.getComment());
                } else {
                    innerJsonObject.put(entry.getName(), new JsonPrimitive(entry.getValue()));
                }
            } else {
                ADJsonConfigCategory subCategory = category.getSubCategory(component.getName());
                writeCategories(subCategory, innerJsonObject);
            }
        }
        jsonObject.put(category.getName(), innerJsonObject);
    }
}
