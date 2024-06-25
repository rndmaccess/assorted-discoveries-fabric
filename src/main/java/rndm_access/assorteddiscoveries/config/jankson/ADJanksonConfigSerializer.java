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
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ADJanksonConfigSerializer {
    private final LinkedHashMap<String, ADJsonConfigCategory> configCategories;
    private final Path configPath;

    public ADJanksonConfigSerializer(LinkedHashMap<String, ADJsonConfigCategory> configCategories, Path configPath) {
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
                throw new SerializationException(e);
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
            JsonObject outerJsonObject = new JsonObject();

            for (ADJsonConfigCategory category : configCategories.values()) {
                JsonObject innerJsonObject = new JsonObject();

                for(String name : category.getEntryNames()) {
                    if(category.getEntry(name).getComment() != null) {
                        innerJsonObject.put(name, new JsonPrimitive(category.getEntry(name).getValue()),
                                category.getEntry(name).getComment());
                    } else {
                        innerJsonObject.put(name, new JsonPrimitive(category.getEntry(name).getValue()));
                    }
                }
                outerJsonObject.put(category.getName(), innerJsonObject);
            }

            try {
                writer.write(outerJsonObject.toJson(true, true));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
