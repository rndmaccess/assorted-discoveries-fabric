package rndm_access.assorteddiscoveries.config;

import me.shedaniel.autoconfig.util.Utils;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonPrimitive;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import org.jetbrains.annotations.NotNull;
import rndm_access.assorteddiscoveries.ADReference;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;

public class ADConfigSerializer {
    public static final Path CONFIG_PATH;

    public static void deserializeConfig() {
        Jankson jankson = Jankson.builder().build();

        if (Files.exists(CONFIG_PATH)) {
            try {
                JsonObject jsonFile = jankson.load(Files.readString(CONFIG_PATH));
                String json = jsonFile.toJson(true, false);
                parseJson(json);
                addMissingCategoriesOrEntries();

                // Re-save the config to fix anything that may be missing or incorrect.
                serializeConfig();
            } catch (SyntaxError | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            ADConfig.configCategories = new LinkedHashMap<>(ADConfig.defaultConfigCategories);
            serializeConfig();
        }
    }

    public static void serializeConfig() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH);
            JsonObject outerJsonObject = new JsonObject();

            for (ADConfigCategory category : ADConfig.configCategories.values()) {
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

            // Make the entries
            while(json.charAt(i) != '}') {
                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder valueBuilder = new StringBuilder();
                StringBuilder commentBuilder = new StringBuilder();
                int subStrEnd = i + 2;

                // Parse the comment
                if(subStrEnd <= json.length()) {
                    String sub = json.substring(i, subStrEnd);

                    // Read the comment for the entry
                    if(sub.equals("/*")) {
                        while(!sub.equals("*/")) {
                            if(json.charAt(i) != '*' && json.charAt(i) != '/') {
                                commentBuilder.append(json.charAt(i));
                            }
                            i++;
                            subStrEnd = i + 2;
                            sub = json.substring(i, subStrEnd);
                        }
                        i += 2;
                    }
                }

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

                ADConfigEntry entry = buildEntry(commentBuilder, nameBuilder, valueBuilder, category.getName());
                category.addEntry(entry);

                // If there is a comma at the end then skip it and move onto the next entry
                if(json.charAt(i) == ',') {
                    i++;
                }
            }
            ADConfig.configCategories.put(category.getName(), category);
        }
    }

    private static @NotNull ADConfigEntry buildEntry(StringBuilder commentBuilder, StringBuilder nameBuilder,
                                                     StringBuilder valueBuilder, String categoryName) {
        String comment = commentBuilder.toString().strip();
        String entryName = nameBuilder.toString();
        String entryValue = valueBuilder.toString();
        ADConfigEntry entry = new ADConfigEntry(entryName);
        ADConfigEntry defaultEntry = ADConfig.defaultConfigCategories.get(categoryName).getEntry(entryName);

        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            // Fix boolean config options
            if(entryValue.equalsIgnoreCase("true") || entryValue.equalsIgnoreCase("false")) {
                entry.setValue(Boolean.valueOf(entryValue));
            } else {
                entry.setValue(defaultEntry.getValue());
            }
        }

        if(!comment.isEmpty()) {
            entry.setComment(comment);
        }
        return entry;
    }

    private static String clearSpaces(String json) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < json.length(); i++) {
            int subStrEnd = i + 2;

            if(subStrEnd <= json.length()) {
                i = skipCommentSpaces(json, subStrEnd, builder, i);
            }

            if(!Character.isWhitespace(json.charAt(i))) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }

    private static int skipCommentSpaces(String json, int subStrEnd, StringBuilder builder, int i) {
        String sub = json.substring(i, subStrEnd);

        if(sub.equals("/*")) {
            while (!sub.equals("*/")) {
                builder.append(json.charAt(i));
                i++;
                subStrEnd = i + 2;
                sub = json.substring(i, subStrEnd);
            }
            builder.append(sub);
            i += 2;
        }
        return i;
    }

    private static void addMissingCategoriesOrEntries() {
        for(ADConfigCategory category : ADConfig.defaultConfigCategories.values()) {
            if(!ADConfig.configCategories.containsKey(category.getName())) {
                ADConfig.configCategories.put(category.getName(), category);
                continue;
            }

            for(ADConfigEntry entry : category.getEntries()) {
                if(!ADConfig.configCategories.get(category.getName()).hasEntry(entry.getName())) {
                    ADConfig.configCategories.get(category.getName()).addEntry(entry);
                }
            }
        }
    }

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
    }
}
