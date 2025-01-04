package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.deserializer.JsonDeserializer;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonConfig {
    private final HashMap<String, ConfigCategory> categories;
    public Path path;

    public JsonConfig(ConfigCategory... categories) {
        this.categories = toMap(categories);
    }

    public AbstractConfigEntry<?> getEntry(String entryName) {
        Stack<ConfigCategory> stack = new Stack<>();

        // Start by adding the root categories to the stack. We then will look in each category for the entry!
        for (ConfigCategory category : this.getCategories()) {
            stack.push(category);
        }

        while (!stack.isEmpty()) {
            ConfigCategory currentCategory = stack.pop();

            // If the current category has the entry then we have found it!
            if (currentCategory.hasEntry(entryName)) {
                return currentCategory.getEntry(entryName);
            }

            // If the category has subcategories, push those onto the stack and look through those as well!
            if (currentCategory.hasSubCategories()) {
                for (ConfigCategory subcategory : currentCategory.getSubcategories()) {
                    stack.push(subcategory);
                }
            }
        }
        return null; // Entry not found!
    }

    public HashMap<String, ConfigCategory> toMap(ConfigCategory... categories) {
        HashMap<String, ConfigCategory> categoryHashMap = new HashMap<>();

        for (ConfigCategory category : categories) {
            String name = category.getName();

            categoryHashMap.put(name, category);
        }
        return categoryHashMap;
    }

    public ConfigCategory getCategory(String name) {
        if(!this.hasCategory(name)) {
            throw new NoSuchElementException("The config does not have category " + name);
        }
        return categories.get(name);
    }

    public boolean hasCategory(String name) {
        return categories.containsKey(name);
    }

    public List<ConfigCategory> getCategories() {
        return categories.values().stream().toList();
    }

    public void load(ConfigData data) {
        if (data.getPath() == null || !Files.exists(data.getPath())) {
            throw new JsonConfigException("Couldn't load the config because it does not exist!");
        }

        try {
            JsonDeserializer deserializer = new JsonDeserializer(this, data.getPath());
            deserializer.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(ConfigData data) {
        if (data.getPath() == null) {
            throw new JsonConfigException("The config hasn't been loaded!");
        }

        if (!Files.exists(data.getPath())) {
            try (BufferedWriter writer = Files.newBufferedWriter(data.getPath())) {
                String configContent = this.createFileContent();
                writer.write(configContent);
            } catch (IOException e) {
                throw new JsonConfigException("Failed to create the config!");
            }
        }
    }

    public void save(ConfigData data, Map<String, Object> entryChangeList) {
        if (data.getPath() == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        if (Files.exists(data.getPath())) {
            JsonSerializer serializer = new JsonSerializer(this, data.getPath());
            serializer.serialize(entryChangeList);
        }
    }

    public String createFileContent() {
        StringBuilder builder = new StringBuilder();

        if (!this.getCategories().isEmpty()) {
            builder.append('{');

            int indent = 1;
            int i = 0;
            for (ConfigCategory category : this.getCategories()) {
                builder.append('\n');
                writeCategory(category, builder, indent);

                if(i + 1 < this.getCategories().size()) {
                    builder.append(',');
                }
                i++;
            }
            builder.append('\n');
            builder.append('}');
        }
        return builder.toString();
    }

    private void writeCategory(ConfigCategory category, StringBuilder builder, int depth) {
        indent(builder, depth);
        depth++;
        builder.append('\"');
        builder.append(category.getName());
        builder.append('\"');
        builder.append(": {");
        builder.append('\n');

        for (int i = 0; i < category.getJsonObjects().size(); i++) {
            ConfigObject component = category.getJsonObjects().get(i);

            if (category.hasEntry(component.getName())) {
                AbstractConfigEntry<?> entry = (AbstractConfigEntry<?>) component;
                writeEntry(category, entry, builder, depth);
            } else {
                ConfigCategory subCategory = category.getSubcategory(component.getName());
                writeCategory(subCategory, builder, depth);
            }

            if (i + 1 < category.getJsonObjects().size()) {
                builder.append(',');
                builder.append('\n');
            } else {
                depth--;
                builder.append('\n');
                indent(builder, depth);
                builder.append('}');
            }
        }
    }

    private void writeEntry(ConfigCategory category, AbstractConfigEntry<?> entry,
                            StringBuilder builder, int depth) {
        if (entry.getComment() != null) {
            writeComment(builder, entry, depth);
        }

        indent(builder, depth);
        builder.append('\"');
        builder.append(entry.getName());
        builder.append('\"');
        builder.append(": ");

        if (category.hasStringEntry(entry.getName())) {
            builder.append('\"');
            builder.append(entry.getValue());
            builder.append('\"');
        } else {
            builder.append(entry.getValue());
        }
    }

    private void writeComment(StringBuilder builder, AbstractConfigEntry<?> entry, int depth) {
        indent(builder, depth);
        builder.append("// ");

        for (int i = 0; i < entry.getComment().length(); i++) {
            char token = entry.getComment().charAt(i);

            if(token == '\n') {
                builder.append(token);
                indent(builder, depth);
                builder.append("// ");
            } else {
                builder.append(token);
            }
        }
        builder.append('\n');
    }

    private void indent(StringBuilder builder, int indent) {
        builder.append("\t".repeat(Math.max(0, indent)));
    }
}
