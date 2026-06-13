package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigDeserializer;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.CommentConfigEntry;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Config {
    private final List<ConfigObject> objects;
    private final List<ConfigCategory> categories;
    private final Path path;
    private final String name;
    private String configError;

    public Config(Config.Builder builder) {
        this.objects = builder.objects;
        this.categories = builder.categories;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(builder.name + ".json5");
        this.name = builder.name;
    }

    public Config loadConfigFromList(List<EntryPair<Boolean>> configList) {
        configList.forEach((configEntry) -> {
            String key = configEntry.key();
            boolean value = configEntry.value();

            for (ConfigCategory category : categories) {
                BooleanConfigEntry entry = category.getBoolEntry(key);

                if (entry != null) {
                    entry.setValue(value);
                    break;
                }
            }
        });
        return this;
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

    public List<EntryPair<Boolean>> toBooleanEntryList() {
        List<EntryPair<Boolean>> list = new ArrayList<>();

        for (ConfigCategory category : categories) {
            for (AbstractConfigEntry<?> entry : category.getEntries()) {
                if (entry instanceof BooleanConfigEntry) {
                    list.add(new EntryPair<>(entry.getKey(), (Boolean) entry.getValue()));
                }
            }
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
        List<ConfigCategory> categories = this.getCategories();

        for (ConfigCategory category : categories) {
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
    public ConfigCategory getCategory(String key) {
        for (ConfigCategory category : categories) {
            if (category.getKey().equals(key)) {
                return category;
            }
        }
        return null;
    }

    public List<ConfigCategory> getCategories() {
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
            ConfigCategory defaultCategory = this.getCategory(categoryKey);
            ConfigCategory loadedCategory = loadedConfig.getCategory(categoryKey);

            if (loadedCategory != null) {
                this.mergeCategories(configBuilder, loadedCategory, defaultCategory);
            } else {
                configBuilder.addCategory(defaultCategory);
            }
        }
        return configBuilder.build();
    }

    private void mergeCategories(Config.Builder configBuilder, ConfigCategory loadedCategory, ConfigCategory defaultCategory) {
        ConfigCategory.Builder categoryBuilder = new ConfigCategory.Builder(defaultCategory.getKey());

        for (ConfigObject object : defaultCategory.getJsonObjects()) {
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
        private final List<ConfigCategory> categories = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Config.Builder addComment(CommentConfigEntry comment) {
            objects.add(comment);
            return this;
        }

        public Config.Builder addCategory(ConfigCategory category) {
            categories.add(category);
            objects.add(category);
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
