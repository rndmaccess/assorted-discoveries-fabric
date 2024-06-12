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

    private void parseJson(String json) {
        json = removeWhitespace(json);
        for(int i = 0; i < json.length() - 1; i++) {
            StringBuilder categoryBuilder = new StringBuilder();

            // Parse the category
            while(hasNextChar(i, json) && json.charAt(i) != ':' && json.charAt(i + 1) != '{') {
                i = parseString(categoryBuilder, json, i);
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
                    i = parseString(nameBuilder, json, i);
                    i++;
                }

                // Parse the entry value
                if(json.charAt(i) == ':') {
                    i++;
                    do {
                        valueBuilder.append(json.charAt(i));
                        i++;
                    } while(hasNextChar(i, json) && json.charAt(i) != ',' && json.charAt(i) != '}');
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
            if(entryValue.equalsIgnoreCase("true") || entryValue.equalsIgnoreCase("false")) {
                return Boolean.valueOf(entryValue);
            } else {
                return defaultEntry.getValue();
            }
        } else if(defaultEntry.getValue().getClass().equals(Integer.class)) {
            return Integer.parseInt(fixNumber(defaultEntry, entryValue));
        } else if(defaultEntry.getValue().getClass().equals(Long.class)) {
            return Long.parseLong(fixNumber(defaultEntry, entryValue));
        } else if(defaultEntry.getValue().getClass().equals(Double.class)) {
            return Double.parseDouble(fixDecimalNumber(defaultEntry, entryValue));
        } else if(defaultEntry.getValue().getClass().equals(Float.class)) {
            return Float.parseFloat(fixDecimalNumber(defaultEntry, entryValue));
        } else {
            return entryValue;
        }
    }

    private String fixNumber(ADJanksonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                if(!Character.isDigit(entryValue.charAt(i))) {
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private String fixDecimalNumber(ADJanksonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                char c = entryValue.charAt(i);

                if(!Character.isDigit(c) || c != '.') {
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private String removeWhitespace(String json) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            // Keep the quotes and spaces within strings
            if(c == '"') {
                do {
                    builder.append(json.charAt(i));
                    i++;
                    c = json.charAt(i);
                } while (c != '"');
            }

            if(!Character.isWhitespace(c)) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }

    private int parseString(StringBuilder builder, String inputStr, int i) {
        // Strip out the spaces when parsing strings.
        if(inputStr.charAt(i) == '"') {
            i++;
            while (inputStr.charAt(i) != '"') {
                builder.append(inputStr.charAt(i));
                i++;
            }
        }
        return i;
    }

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
    }
}
