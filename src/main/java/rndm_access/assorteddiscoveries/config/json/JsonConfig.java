package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractJsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class JsonConfig {
    private final LinkedHashMap<String, JsonConfigCategory> categories;
    private ConfigType type;
    private Path path;

    protected JsonConfig(Builder builder) {
        this.categories = builder.categories;
        this.path = null;
        this.type = ConfigType.NONE;
    }

    public ConfigType getType() {
        return type;
    }

    public void setType(ConfigType type) {
        this.type = type;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public JsonConfigCategory getCategory(String name) {
        if(!this.hasCategory(name)) {
            throw new NoSuchElementException("The config does not have category " + name);
        }
        return categories.get(name);
    }

    public boolean hasCategory(String name) {
        return categories.containsKey(name);
    }

    public Collection<JsonConfigCategory> getCategories() {
        return categories.values();
    }

    public void load() {
        if (path == null || !Files.exists(path)) {
            throw new JsonConfigException("Couldn't load the config because it does not exist!");
        }

        JanksonConfigSerializer serializer = new JanksonConfigSerializer(this, path);
        serializer.deserializeConfig();
    }

    public void save() {
        if (path == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        JanksonConfigSerializer serializer = new JanksonConfigSerializer(this, path);
        serializer.serializeConfig();
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
        public LinkedHashMap<String, JsonConfigCategory> categories = new LinkedHashMap<>();

        public Builder addCategory(JsonConfigCategory category) {
            categories.put(category.getName(), category);
            return this;
        }

        public JsonConfig build() {
            return new JsonConfig(this);
        }
    }
}
