package rndm_access.assorteddiscoveries.config;

import me.shedaniel.autoconfig.util.Utils;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonPrimitive;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import rndm_access.assorteddiscoveries.ADReference;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ADConfigSerializer {
    public static final Path CONFIG_PATH;

    public static void deserializeConfig() {
        Jankson jankson = Jankson.builder().build();

        if (Files.exists(CONFIG_PATH)) {
            try {
                JsonObject jsonFile = jankson.load(Files.readString(CONFIG_PATH));
                String json = jsonFile.toJson(true, false);
                parseJson(json);

                // Re-save the config to fix anything that may be missing or incorrect.
                serializeConfig();
            } catch (SyntaxError | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            serializeConfig();
        }
    }

    public static void serializeConfig() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH);
            JsonObject outerJsonObject = new JsonObject();

            for (ADConfigCategory category : ADConfig.getConfigCategories().values()) {
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

    private static void parseJson(String json) {
        json = clearSpaces(json);
        for(int i = 0; i < json.length() - 1; i++) {
            StringBuilder categoryBuilder = new StringBuilder();

            // Parse the category
            while(json.charAt(i) != ':') {
                if(json.charAt(i) != '{' && json.charAt(i) != ','
                        && json.charAt(i) != '"') {
                    categoryBuilder.append(json.charAt(i));
                }
                i++;
            }
            i += 2;

            ADConfigCategory category = new ADConfigCategory(categoryBuilder.toString());

            // Parse the entries
            while(json.charAt(i) != '}') {
                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder valueBuilder = new StringBuilder();

                // Parse the entry name
                while (json.charAt(i) != ':') {
                    if(json.charAt(i) != '"' && json.charAt(i) != '{') {
                        nameBuilder.append(json.charAt(i));
                    }
                    i++;
                }
                i++;

                // Parse the entry value
                while (json.charAt(i) != ',' && json.charAt(i) != '}') {
                    valueBuilder.append(json.charAt(i));
                    i++;
                }

                updateEntry(nameBuilder, valueBuilder, category.getName());

                // If there is a comma at the end then skip it and move onto the next entry
                if(json.charAt(i) == ',') {
                    i++;
                }
            }
        }
    }

    private static void updateEntry(StringBuilder nameBuilder, StringBuilder valueBuilder,
                                             String categoryName) {
        String entryName = nameBuilder.toString();
        ADConfigEntry defaultEntry = ADConfig.getConfigCategories().get(categoryName).getEntry(entryName);
        Object value = getAndFixValues(defaultEntry, valueBuilder);

        // If the value was changed, change it in the map.
        if(!Objects.equals(defaultEntry.getValue(), value)) {
            ADConfig.getConfigCategories().get(categoryName).getEntry(entryName).setValue(value);
        }
    }

    private static Object getAndFixValues(ADConfigEntry defaultEntry, StringBuilder valueBuilder) {
        String entryValue = valueBuilder.toString();

        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            // Fix boolean config options
            if(entryValue.equalsIgnoreCase("true") || entryValue.equalsIgnoreCase("false")) {
                return Boolean.valueOf(entryValue);
            } else {
                return defaultEntry.getValue();
            }
        } else {
            throw new RuntimeException("This type is not supported!");
        }
    }

    private static String clearSpaces(String json) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < json.length(); i++) {
            int subStrEnd = i + 2;

            if(subStrEnd <= json.length()) {
                i = skipComment(json, subStrEnd, i);
            }

            if(!Character.isWhitespace(json.charAt(i))) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }

    private static int skipComment(String json, int subStrEnd, int i) {
        String sub = json.substring(i, subStrEnd);

        if(sub.equals("/*")) {
            while (!sub.equals("*/")) {
                i++;
                subStrEnd = i + 2;
                sub = json.substring(i, subStrEnd);
            }
            i += 2;
        }
        return i;
    }

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
    }
}
