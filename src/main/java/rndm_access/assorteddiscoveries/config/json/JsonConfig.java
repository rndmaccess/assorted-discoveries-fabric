package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.parser.JsonParser;
import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.parser.entries.ErrorConfigEntry;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonConfig {
    private final HashMap<String, ConfigCategory> categories;
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

    public ConfigCategory getCategory(String name) {
        if(!this.hasCategory(name)) {
            throw new NoSuchElementException("The config does not have category " + name);
        }
        return categories.get(name);
    }

    public boolean hasCategory(String name) {
        return categories.containsKey(name);
    }

    public Collection<ConfigCategory> getCategories() {
        return categories.values();
    }

    public void loadAndCorrect() {
        if (path == null || !Files.exists(path)) {
            throw new JsonConfigException("Couldn't load the config because it does not exist!");
        }

        try {
            List<String> source = Files.readAllLines(path);

            JsonParser parser = new JsonParser(this, source, path);
            parser.parse();

            List<ErrorConfigEntry> entryErrors = parser.getEntryErrors();

            // Correct if there were any entry value errors found during parsing!
            if (!entryErrors.isEmpty()) {
                JsonEntryCorrector corrector = new JsonEntryCorrector(this, source, path);
                corrector.correct(entryErrors);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveOrCreate(Map<AbstractConfigEntry<?>, Object> entryChangeList) {
        if (path == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        if (!Files.exists(path)) {
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                String configContent = this.createFileContent();
                writer.write(configContent);
            } catch (IOException e) {
                throw new JsonConfigException("Failed to create the config!");
            }
        } else {
            JsonEntrySaver entrySaver = new JsonEntrySaver(path);
            // If the config file exists then save specific entries instead of overwriting the entire file!
            entrySaver.save(entryChangeList);
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

    public static class Builder {
        public HashMap<String, ConfigCategory> categories = new LinkedHashMap<>();

        public Builder addCategory(ConfigCategory category) {
            categories.put(category.getName(), category);
            return this;
        }

        public JsonConfig build() {
            return new JsonConfig(this);
        }
    }
}
