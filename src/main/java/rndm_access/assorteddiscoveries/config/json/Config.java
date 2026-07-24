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
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    public void loadFromList(List<JsonConfigCategory> configList) {
        if (configList == null || configList.isEmpty()) {
            // If there is no config list to load we can just return the existing config early!
            AssortedDiscoveries.LOGGER.error("Failed to sync config!");
            return;
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

    /**
     * @return A deep copy of the config this method is called on.
     */
    public Config copy(boolean isImmutable) {
        Builder configCopybuilder = new Builder(this.name);

        for (ConfigObject configObject : this.getObjects()) {
            if (configObject.isComment()) {
                configCopybuilder.addComment(new CommentConfigEntry(configObject.getKey()));
                continue;
            }

            if (configObject instanceof JsonConfigCategory category) {
                JsonConfigCategory categoryCopy = makeCategoryCopy(category, isImmutable);
                configCopybuilder.addCategory(categoryCopy);
            }
        }
        return configCopybuilder.build();
    }

    private JsonConfigCategory makeCategoryCopy(JsonConfigCategory origCategory, boolean isImmutable) {
        JsonConfigCategory.Builder categoryCopy = new JsonConfigCategory.Builder(origCategory.getKey());

        for (ConfigObject entryObject : origCategory.getConfigObjects()) {
            if (entryObject.isComment()) {
                categoryCopy.addComment(new CommentConfigEntry(entryObject.getKey()));
                continue;
            }
            if (entryObject instanceof BooleanConfigEntry entry) {
                categoryCopy.addEntry(new BooleanConfigEntry(entry.getKey(), entry.getValue(), isImmutable));
            }
        }
        return categoryCopy.build();
    }

    public void loadFromFile(Config defaultConfig) {
        try {
            ConfigDeserializer deserializer = new ConfigDeserializer(AssortedDiscoveries.MOD_ID);
            Config loadedConfig = deserializer.deserialize();
            this.merge(loadedConfig);

            if (shouldMigrate(defaultConfig, loadedConfig)) {
                this.backupAndSave(this);
            }
        } catch (JsonSyntaxException e) {
            String errorMessage = e.getMessage();
            AssortedDiscoveries.LOGGER.error("Config load error: falling back to default configuration!");
            AssortedDiscoveries.LOGGER.error(errorMessage);
            configError = errorMessage;
            this.backupAndSave(defaultConfig);
        }
    }

    private boolean shouldMigrate(Config defaultConfig, Config loadedConfig) {
        for (JsonConfigCategory category : defaultConfig.getCategories()) {
            JsonConfigCategory loadedCategory = loadedConfig.getCategory(category.getKey());
            if (loadedCategory == null) {
                return true;
            }

            for (ConfigObject object : category.getConfigObjects()) {
                if (object instanceof AbstractConfigEntry<?> entry) {
                    String key = entry.getKey();
                    if (!loadedCategory.containsEntry(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void backupAndSave(Config config) {
        Path configPath = Paths.get("./config");

        try {
            int i = 1;
            Path targetConfigPath = configPath.resolve(this.name + "-" + i + ".json5.bak");

            while (Files.exists(targetConfigPath)) {
                i++;
                targetConfigPath = configPath.resolve( this.name + "-" + i + ".json5.bak");
            }

            Files.move(path, targetConfigPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        config.save();
    }

    public boolean hasError() {
        return configError != null;
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
        } else {
            AssortedDiscoveries.LOGGER.error("The config file already exists!");
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

    public void merge(Config loadedConfig) {
        for (JsonConfigCategory category : this.getCategories()) {
            JsonConfigCategory loadedCategory = loadedConfig.getCategory(category.getKey());
            if (loadedCategory == null) {
                continue;
            }

            for (ConfigObject object : category.getConfigObjects()) {
                if (object instanceof BooleanConfigEntry configEntry) {
                    BooleanConfigEntry entry = (BooleanConfigEntry) loadedCategory.getEntry(configEntry.getKey());

                    if (entry != null) {
                        configEntry.setValue(entry.getValue());
                    }
                }
            }
        }
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
