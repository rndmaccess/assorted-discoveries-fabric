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
import java.util.LinkedHashMap;
import java.util.Objects;

public class ADJanksonConfigSerializer {
    public LinkedHashMap<String, ADJanksonConfigCategory> configCategories;
    private static final Path CONFIG_PATH;

    public ADJanksonConfigSerializer(LinkedHashMap<String, ADJanksonConfigCategory> configCategories) {
        this.configCategories = configCategories;
    }

    public void deserializeConfig() {
        Jankson jankson = Jankson.builder().build();

        if (Files.exists(CONFIG_PATH)) {
            try {
                JsonObject jsonFile = jankson.load(Files.readString(CONFIG_PATH));
                String json = jsonFile.toJson();
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

    public void serializeConfig() {
        if(!Files.exists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH);
            JsonObject outerJsonObject = new JsonObject();

            for (ADJanksonConfigCategory category : configCategories.values()) {
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

    private boolean hasNextChar(int i, String str) {
        return (i + 1) < str.length();
    }

    private boolean isValidChar(char c) {
        return Character.isLetter(c) || c == '_';
    }

    private void parseJson(String json) {
        json = removeWhitespace(json);
        for(int i = 0; i < json.length() - 1; i++) {
            StringBuilder categoryBuilder = new StringBuilder();

            // Parse the category
            while(hasNextChar(i, json) && json.charAt(i) != ':' && json.charAt(i + 1) != '{') {
                char c = json.charAt(i);

                if(isValidChar(c)) {
                    categoryBuilder.append(json.charAt(i));
                }
                i++;
            }

            ADJanksonConfigCategory category = new ADJanksonConfigCategory(categoryBuilder.toString());

            // Parse the entries
            while(hasNextChar(i, json) && json.charAt(i) != '}') {
                i++;
                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder valueBuilder = new StringBuilder();

                // Parse the entry name
                while (hasNextChar(i, json) && json.charAt(i) != ':') {
                    char c = json.charAt(i);

                    if(isValidChar(c)) {
                        nameBuilder.append(json.charAt(i));
                    }
                    i++;
                }

                // Parse the entry value
                while (hasNextChar(i, json) && json.charAt(i) != ',' && json.charAt(i) != '}') {
                    char c = json.charAt(i);

                    if(isValidChar(c) || c == '"') {
                        valueBuilder.append(json.charAt(i));
                    }
                    i++;
                }
                updateEntry(nameBuilder, valueBuilder, category.getName());
            }
        }
    }

    private void updateEntry(StringBuilder nameBuilder, StringBuilder valueBuilder,
                                             String categoryName) {
        String entryName = nameBuilder.toString();

        if(configCategories.get(categoryName).hasEntry(entryName)) {
            ADJanksonConfigEntry defaultEntry = configCategories.get(categoryName).getEntry(entryName);
            Object value = getAndFixValue(defaultEntry, valueBuilder);

            if(!Objects.equals(defaultEntry.getValue(), value)) {
                configCategories.get(categoryName).getEntry(entryName).setValue(value);
            }
        }
    }

    private Object getAndFixValue(ADJanksonConfigEntry defaultEntry, StringBuilder valueBuilder) {
        String entryValue = valueBuilder.toString();

        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            // Fix boolean config options
            if(entryValue.equalsIgnoreCase("true") || entryValue.equalsIgnoreCase("false")) {
                return Boolean.valueOf(entryValue);
            } else {
                return defaultEntry.getValue();
            }
        } else {
            throw new RuntimeException("The type " + entryValue.getClass() + " is not supported!");
        }
    }

    private String removeWhitespace(String json) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < json.length(); i++) {
            if(!Character.isWhitespace(json.charAt(i))) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
    }
}
