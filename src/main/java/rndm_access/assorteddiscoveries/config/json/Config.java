package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.json_objects.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.CommentConfigEntry;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.json_objects.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Config {
    private final List<ConfigObject> objects;
    private final List<JsonConfigCategory> categories;
    private final Path path;
    private final String name;
    private String configError;

    public Config(Config.Builder builder) {
        this.objects = builder.objects;
        this.categories = builder.categories;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(builder.name + ".json5");
        this.name = builder.name;
    }

    public Config loadConfigFromList(List<JsonConfigCategory> configList) {
        if (configList == null || configList.isEmpty()) {
            // If there is no config list to load we can just return the existing config early!
            AssortedDiscoveries.LOGGER.error("Failed to sync config!");
            return this;
        }

        for (JsonConfigCategory configCategory : configList) {
            for (ConfigObject object : configCategory.getConfigObjects()) {
                if (object instanceof BooleanConfigEntry boolEntry) {
                    this.syncConfigEntry(boolEntry);
                } else {
                    AssortedDiscoveries.LOGGER.error("Skipped syncing config entry {}!", object.getKey());
                }
            }
        }
        return this;
    }

    private void syncConfigEntry(BooleanConfigEntry serverEntry) {
        String key = serverEntry.getKey();
        boolean serverValue = serverEntry.getValue();

        for (JsonConfigCategory category : categories) {
            BooleanConfigEntry clientEntry = category.getBoolEntry(key);

            if (clientEntry != null) {
                clientEntry.setValue(serverValue);
            }
        }
    }

    public Config loadConfigFromFile() {
        try {
            ConfigDeserializer deserializer = new ConfigDeserializer(AssortedDiscoveries.MOD_ID);
            Config loadedConfig = deserializer.deserialize();
            Config newConfig = this.merge(loadedConfig);
            // Re-save the config with the values in memory so when we load it
            // we can ensure any new config entries are added to the config file!
            newConfig.save();
            return newConfig;
        } catch (IOException e) {
            AssortedDiscoveries.LOGGER.error("The config file is unreadable! Using the default config!");
            return this;
        } catch (JsonSyntaxException e) {
            String errorMessage = e.getMessage();
            AssortedDiscoveries.LOGGER.error("Using the default config, because the config file could not be loaded:");
            AssortedDiscoveries.LOGGER.error(errorMessage);
            configError = errorMessage;
            return this;
        }
    }

    public String getConfigError() {
        return configError;
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public List<JsonConfigCategory> getBooleanEntries() {
        List<JsonConfigCategory> list = new ArrayList<>();

        for (JsonConfigCategory category : categories) {
            String key = category.getKey();
            JsonConfigCategory.Builder categoryBuilder = new JsonConfigCategory.Builder(key);

            for (ConfigObject object : category.getConfigObjects()) {
                if (object instanceof BooleanConfigEntry boolEntry) {
                    categoryBuilder.addEntry(boolEntry);
                }
            }
            list.add(categoryBuilder.build());
        }
        return list;
    }

    public boolean evaluateEntry(String entryKey) {
        return ((BooleanConfigEntry) this.getEntry(entryKey)).getValue();
    }

    /**
     * @param key The key for the config entry we are looking for
     * @return The config entry associated with the key if it's found otherwise null
     */
    public AbstractConfigEntry<?> getEntry(String key) {
        List<JsonConfigCategory> categories = this.getCategories();

        for (JsonConfigCategory category : categories) {
            AbstractConfigEntry<?> entry = category.getEntry(key);

            if (entry != null) {
                return entry;
            }
        }
        return null; // Entry not found!
    }

    /**
     * @param key The key for the config defaultCategory we are looking for
     * @return The config defaultCategory associated with the key if it's found otherwise null
     */
    public JsonConfigCategory getCategory(String key) {
        for (JsonConfigCategory category : categories) {
            if (category.getKey().equals(key)) {
                return category;
            }
        }
        return null;
    }

    public List<JsonConfigCategory> getCategories() {
        return categories;
    }

    public List<ConfigObject> getObjects() {
        return objects;
    }

    public void create() {
        if (path == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        if (!Files.exists(path)) {
            ConfigSerializer serializer = new ConfigSerializer(this, path);
            serializer.serialize();
        }
    }

    public void save() {
        if (path == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        ConfigSerializer serializer = new ConfigSerializer(this, path);
        serializer.serialize();
    }

    public void save(Map<String, Object> entryChangeList) {
        if (path == null) {
            throw new JsonConfigException("The config path has not been set!");
        }

        if (Files.exists(path)) {
            ConfigSerializer serializer = new ConfigSerializer(this, path);
            serializer.serialize(entryChangeList);
        }
    }

    public Config merge(Config loadedConfig) {
        Config.Builder configBuilder = new Config.Builder(this.name);

        for (ConfigObject object : this.getObjects()) {
            if (object.isComment()) {
                CommentConfigEntry comment = (CommentConfigEntry) object;
                configBuilder.addComment(comment);
                continue;
            }

            String categoryKey = object.getKey();
            JsonConfigCategory defaultCategory = this.getCategory(categoryKey);
            JsonConfigCategory loadedCategory = loadedConfig.getCategory(categoryKey);

            if (loadedCategory != null) {
                this.mergeCategories(configBuilder, loadedCategory, defaultCategory);
            } else {
                configBuilder.addCategory(defaultCategory);
            }
        }
        return configBuilder.build();
    }

    private void mergeCategories(Config.Builder configBuilder, JsonConfigCategory loadedCategory, JsonConfigCategory defaultCategory) {
        JsonConfigCategory.Builder categoryBuilder = new JsonConfigCategory.Builder(defaultCategory.getKey());

        for (ConfigObject object : defaultCategory.getConfigObjects()) {
            if (object.isComment()) {
                CommentConfigEntry comment = (CommentConfigEntry) object;
                categoryBuilder.addComment(comment);
                continue;
            }

            String entryKey = object.getKey();
            AbstractConfigEntry<?> loadedEntry = loadedCategory.getEntry(entryKey);

            if (loadedEntry != null) {
                categoryBuilder.addEntry(loadedEntry);
            } else {
                AbstractConfigEntry<?> defaultEntry = defaultCategory.getEntry(entryKey);
                categoryBuilder.addEntry(defaultEntry);
            }
        }
        configBuilder.addCategory(categoryBuilder.build());
    }

    public static class Builder {
        public String name;
        private final List<ConfigObject> objects = new ArrayList<>();
        private final List<JsonConfigCategory> categories = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Config.Builder addComment(CommentConfigEntry comment) {
            objects.add(comment);
            return this;
        }

        public Config.Builder addCategory(JsonConfigCategory category) {
            categories.add(category);
            objects.add(category);
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
