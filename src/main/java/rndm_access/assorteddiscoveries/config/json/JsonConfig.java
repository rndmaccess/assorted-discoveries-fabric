package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractJsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;

public class JsonConfig {
    private final LinkedHashMap<String, JsonConfigCategory> nameToCategories;
    private final Path configPath;

    protected JsonConfig(Builder builder) {
        this.nameToCategories = builder.configCategories;
        this.configPath = FabricLoader.getInstance().getConfigDir().resolve(builder.configName + ".json5");
    }

    public JsonConfigCategory getCategory(String categoryName) {
        if(!this.hasCategory(categoryName)) {
            throw new JsonConfigException("The config does not have category " + categoryName);
        }
        return nameToCategories.get(categoryName);
    }

    public boolean hasCategory(String categoryName) {
        return nameToCategories.containsKey(categoryName);
    }

    public Collection<JsonConfigCategory> getCategories() {
        return nameToCategories.values();
    }

    public void load() {
        if (!configExists()) {
            throw new JsonConfigException("Couldn't load the config because it does not exist!");
        }

        JanksonConfigSerializer serializer = new JanksonConfigSerializer(this, configPath);

        serializer.deserializeConfig();
        serializer.serializeConfig(); // Correct any data that could not be loaded!
    }

    public void save() {
        JanksonConfigSerializer serializer = new JanksonConfigSerializer(this, configPath);
        serializer.serializeConfig();
    }

    public boolean configExists() {
        return Files.exists(configPath);
    }

    public Path getConfigPath() {
        return configPath;
    }

    public String toJson() {
        StringBuilder builder = new StringBuilder();

        if (!this.getCategories().isEmpty()) {
            builder.append('{');

            int indent = 1;
            int i = 0;
            for (JsonConfigCategory category : this.getCategories()) {
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

    private void writeCategory(JsonConfigCategory category, StringBuilder builder, int depth) {
        indent(builder, depth);
        depth++;
        builder.append('\"');
        builder.append(category.getName());
        builder.append('\"');
        builder.append(": {");
        builder.append('\n');

        for (int i = 0; i < category.getJsonObjects().size(); i++) {
            JsonConfigObject component = category.getJsonObjects().get(i);

            if (category.hasEntry(component.getName())) {
                AbstractJsonConfigEntry<?> entry = (AbstractJsonConfigEntry<?>) component;
                writeEntry(category, entry, builder, depth);
            } else {
                JsonConfigCategory subCategory = category.getSubcategory(component.getName());
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

    private void writeEntry(JsonConfigCategory category, AbstractJsonConfigEntry<?> entry,
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

    private void writeComment(StringBuilder builder, AbstractJsonConfigEntry<?> entry, int depth) {
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

    public static class Builder {
        public LinkedHashMap<String, JsonConfigCategory> configCategories = new LinkedHashMap<>();
        public String configName;

        public Builder(String configName) {
            this.configName = configName;
        }

        public Builder addCategory(JsonConfigCategory category) {
            configCategories.put(category.getName(), category);
            return this;
        }

        public JsonConfig build() {
            return new JsonConfig(this);
        }
    }
}
