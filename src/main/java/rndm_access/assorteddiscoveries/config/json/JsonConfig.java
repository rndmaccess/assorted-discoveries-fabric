package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.CommentConfigEntry;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.deserializer.JsonDeserializer;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JsonConfig {
    private final List<ConfigObject> objects;
    private final HashMap<String, ConfigCategory> categories;
    private final Path path;

    public JsonConfig(JsonConfig.Builder builder) {
        this.objects = builder.objects;
        this.categories = builder.categories;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(builder.name + ".json5");
    }

    public Path getPath() {
        return path;
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

    public List<ConfigObject> getObjects() {
        return objects;
    }

    public void load() {
        if (path == null || !Files.exists(path)) {
            throw new JsonConfigException("Couldn't load the config because it does not exist!");
        }

        try {
            JsonDeserializer deserializer = new JsonDeserializer(this, path);
            deserializer.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create() {
        if (path == null) {
            throw new JsonConfigException("The config hasn't been loaded!");
        }

        if (!Files.exists(path)) {
            JsonSerializer serializer = new JsonSerializer(this, path);
            serializer.serialize();
        }
    }

    public void save(Map<String, Object> entryChangeList) {
        if (path == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        if (Files.exists(path)) {
            JsonSerializer serializer = new JsonSerializer(this, path);
            serializer.serialize(entryChangeList);
        }
    }

    public static class Builder {
        public String name;
        private final List<ConfigObject> objects = new ArrayList<>();
        private final HashMap<String, ConfigCategory> categories = new LinkedHashMap<>();

        public Builder(String name) {
            this.name = name;
        }

        public JsonConfig.Builder addComment(CommentConfigEntry comment) {
            objects.add(comment);
            return this;
        }

        public JsonConfig.Builder addCategory(ConfigCategory category) {
            categories.put(category.getKey(), category);
            objects.add(category);
            return this;
        }

        public JsonConfig build() {
            return new JsonConfig(this);
        }
    }
}
