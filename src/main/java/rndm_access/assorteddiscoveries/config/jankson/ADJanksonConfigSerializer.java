package rndm_access.assorteddiscoveries.config.jankson;

import me.shedaniel.autoconfig.util.Utils;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonPrimitive;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import org.apache.commons.lang3.SerializationException;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;

public class ADJanksonConfigSerializer {
    public LinkedHashMap<String, ADJsonConfigCategory> configCategories;
    private static final Path CONFIG_PATH;

    public ADJanksonConfigSerializer(LinkedHashMap<String, ADJsonConfigCategory> configCategories) {
        this.configCategories = configCategories;
    }

    public void deserializeConfig() {
        Jankson jankson = Jankson.builder().build();

        if (Files.exists(CONFIG_PATH)) {
            try {
                JsonObject jsonFile = jankson.load(Files.readString(CONFIG_PATH));
                ADJsonParser parser = new ADJsonParser(jsonFile);
                LinkedList<ADJsonConfigCategory> savedCategories = parser.parseJsonFile();

                for (ADJsonConfigCategory savedCategory : savedCategories) {
                    updateCategory(savedCategory);
                }

                // Re-save the config to fix anything that may be missing or incorrect.
                serializeConfig();
            } catch (SyntaxError | IOException e) {
                throw new SerializationException(e);
            }
        } else {
            serializeConfig();
        }
    }

    private void updateCategory(ADJsonConfigCategory savedCategory) {
        String savedCategoryName = savedCategory.getName();

        if (configCategories.containsKey(savedCategoryName)) {
            ADJsonConfigCategory defaultCategory = configCategories.get(savedCategoryName);

            for (ADJsonConfigEntry savedEntry : savedCategory.getEntries()) {
                if(defaultCategory.hasEntry(savedEntry.getName())) {
                    updateEntry(savedEntry, defaultCategory);
                }
            }
        }
    }

    private void updateEntry(ADJsonConfigEntry savedEntry, ADJsonConfigCategory defaultCategory) {
        String savedValue = Objects.toString(savedEntry.getValue());
        ADJsonConfigEntry defaultEntry = defaultCategory.getEntry(savedEntry.getName());
        Object fixedSavedValue = getAndFixValue(defaultEntry, savedValue);

        if(!Objects.equals(defaultEntry.getValue(), fixedSavedValue)) {
            configCategories.get(defaultCategory.getName()).getEntry(defaultEntry.getName())
                    .setValue(fixedSavedValue);
        }
    }

    private Object getAndFixValue(ADJsonConfigEntry defaultEntry, String jsonValue) {
        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            if(jsonValue.equalsIgnoreCase("true") || jsonValue.equalsIgnoreCase("false")) {
                return Boolean.valueOf(jsonValue);
            } else {
                warnCorrection(jsonValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
                return defaultEntry.getValue();
            }
        } else if(defaultEntry.getValue().getClass().equals(Integer.class)) {
            return Integer.parseInt(fixNumber(defaultEntry, jsonValue));
        } else if(defaultEntry.getValue().getClass().equals(Long.class)) {
            return Long.parseLong(fixNumber(defaultEntry, jsonValue));
        } else if(defaultEntry.getValue().getClass().equals(Double.class)) {
            return Double.parseDouble(fixDecimalNumber(defaultEntry, jsonValue));
        } else if(defaultEntry.getValue().getClass().equals(Float.class)) {
            return Float.parseFloat(fixDecimalNumber(defaultEntry, jsonValue));
        } else {
            return jsonValue;
        }
    }

    private static String fixNumber(ADJsonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            warnCorrection(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                if(!Character.isDigit(entryValue.charAt(i))) {
                    warnCorrection(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private static String fixDecimalNumber(ADJsonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            warnCorrection(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                char c = entryValue.charAt(i);

                if(!Character.isDigit(c) || c != '.') {
                    warnCorrection(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private static void warnCorrection(String savedValue, String newValue, String entryName) {
        AssortedDiscoveries.LOGGER.warn("corrected the value {} to {} for entry {}", savedValue, newValue, entryName);
    }

    public void serializeConfig() {
        if(!Files.exists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        try {
            BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH);
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

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
    }
}
