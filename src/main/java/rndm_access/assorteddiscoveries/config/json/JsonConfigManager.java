package rndm_access.assorteddiscoveries.config.json;

import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanJsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class JsonConfigManager {
    private final JsonConfig config;
    private boolean hasError;

    public JsonConfigManager(String name) {
        this.config = new JsonConfig(name);
        this.hasError = false;
    }

    public JsonConfig getConfig() {
        return this.config;
    }

    public void restoreLocalValues() {
        for (ModConfigCategory category : this.config.getCategories()) {
            for (JsonConfigEntry<?> entry : category.getEntries()) {
                entry.restoreLocalValue();
            }
        }
    }

    public void applyServerSync(Map<String, Boolean> configMap) {
        for (ModConfigCategory category : this.config.getCategories()) {
            for (JsonConfigEntry<?> entry : category.getEntries()) {
                updateActiveValue(entry, configMap);
            }
        }
    }

    private void updateActiveValue(JsonConfigEntry<?> entry, Map<String, Boolean> configMap) {
        if (entry instanceof BooleanJsonConfigEntry booleanEntry) {
            String entryKey = entry.getKey();
            Boolean value = configMap.get(entryKey); // Nullable if key is missing

            if (value != null) {
                booleanEntry.setActiveValue(value);
            } else {
                AssortedDiscoveries.LOGGER.error("Could not sync config entry {}", entryKey);
            }
        }
    }

    public void updateLocalValues(Map<String, Object> changeMap) {
        for (ModConfigCategory category : this.config.getCategories()) {
            for (JsonConfigEntry<?> entry : category.getEntries()) {
                if (changeMap.containsKey(entry.getKey())) {
                    updateLocalValue(entry, changeMap);
                }
            }
        }
    }

    private void updateLocalValue(JsonConfigEntry<?> entry, Map<String, Object> configMap) {
        if (entry instanceof BooleanJsonConfigEntry booleanEntry) {
            String entryKey = entry.getKey();
            if (entryKey == null) {
                AssortedDiscoveries.LOGGER.error("Config entry of type Boolean is missing a key " +
                        "(key is null)! Skipping local value update.");
                return;
            }
            Object value = configMap.get(entryKey);

            if (value instanceof Boolean booleanVal) {
                booleanEntry.setLocalValue(booleanVal);
            }
        }
    }

    public void loadFromFile() {
        try {
            JsonConfigDeserializer deserializer = new JsonConfigDeserializer(this.config.getPath());
            Map<String, Map<String, Boolean>> categories = deserializer.deserialize();

            // Load the file contents into memory in one atomic load operation.
            this.loadFileContents(categories);

            // If there are missing categories or entries we
            // back up the config and add the missing entries/categories.
            if (needsMigration(categories)) {
                this.backupAndSave();
            }
        } catch (JsonSyntaxException e) {
            String errorMessage = e.getMessage();
            AssortedDiscoveries.LOGGER.error("Config load error: falling back to default configuration!");
            AssortedDiscoveries.LOGGER.error(errorMessage);
            hasError = true;
            // If there is an error loading the file we fall back to
            // default values and backup our old config.
            this.backupAndSave();
        }
    }

    private boolean needsMigration(Map<String, Map<String, Boolean>> loadedCategories) {
        List<ModConfigCategory> categories = this.config.getCategories();

        if (loadedCategories == null || loadedCategories.size() != categories.size()) {
            return true;
        }

        for (ModConfigCategory category : categories) {
            Map<String, Boolean> loadedEntries = loadedCategories.get(category.getCategoryName());
            List<JsonConfigEntry<?>> entries = category.getEntries();

            if (loadedEntries == null || loadedEntries.size() != entries.size()) {
                return true;
            }

            for (JsonConfigEntry<?> entry : entries) {
                if (loadedEntries.get(entry.getKey()) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private void loadFileContents(Map<String, Map<String, Boolean>> loadedCategories) {
        for (Map.Entry<String, Map<String, Boolean>> loadedCategory : loadedCategories.entrySet()) {
            String loadedCategoryKey = loadedCategory.getKey();
            ModConfigCategory category = this.config.getCategory(loadedCategoryKey);

            if (category == null) {
                AssortedDiscoveries.LOGGER.warn("Skipping unknown category: {}", loadedCategoryKey);
                continue;
            }

            Map<String, Boolean> loadedEntries = loadedCategories.get(loadedCategoryKey);
            if (loadedEntries == null) {
                continue;
            }

            for (Map.Entry<String, Boolean> loadedEntry : loadedEntries.entrySet()) {
                String entryKey = loadedEntry.getKey();
                JsonConfigEntry<?> entry = category.getEntry(entryKey);
                Boolean value = loadedEntries.get(entryKey);

                // Protect against null values when updating the entries.
                if (value == null) {
                    continue;
                }

                if (entry instanceof BooleanJsonConfigEntry booleanEntry) {
                    booleanEntry.setLocalValue(value);
                } else {
                    AssortedDiscoveries.LOGGER.warn("Skipping unknown entry: {}", entryKey);
                }
            }
        }
    }

    private void backupAndSave() {
        String configName = this.config.getName();
        Path baseConfigPath = this.config.getPath();
        Path tempPath = baseConfigPath.resolveSibling(configName + ".json5.tmp");

        try {
            this.save(tempPath);

            if (Files.exists(baseConfigPath)) {
                int i = 1;
                Path backupPath = baseConfigPath.resolveSibling(configName + "-" + i + ".json5.bak");
                while (Files.exists(backupPath)) {
                    i++;
                    backupPath = baseConfigPath.resolveSibling(configName + "-" + i + ".json5.bak");
                }
                // Replace existing is used here to prevent potential race conditions.
                Files.move(baseConfigPath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            }

            try {
                Files.move(tempPath, baseConfigPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(tempPath, baseConfigPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            // Clean up the assorted-discoveries.tmp file if something failed
            try {
                Files.deleteIfExists(tempPath);
            } catch (IOException ignored) {}
            throw new RuntimeException("Failed to safely save config", ex);
        }
    }

    public boolean hasError() {
        return hasError;
    }

    public void create() {
        Path baseConfigPath = this.config.getPath();

        if (!Files.exists(baseConfigPath)) {
            JsonConfigSerializer serializer = new JsonConfigSerializer(baseConfigPath);
            serializer.serialize();
        } else {
            AssortedDiscoveries.LOGGER.error("The config file already exists!");
        }
    }

    private void save(Path path) {
        JsonConfigSerializer serializer = new JsonConfigSerializer(path);
        serializer.serialize();
    }

    public void save(Map<String, Object> entryChangeList) {
        String configName = this.config.getName();
        Path baseConfigPath = this.config.getPath();
        Path tempPath = baseConfigPath.resolveSibling(configName + ".json5.tmp");

        try {
            JsonConfigSerializer serializer = new JsonConfigSerializer(tempPath);
            serializer.serialize(entryChangeList);

            // Atomically move the new file to the old file's path replacing the old config.
            try {
                Files.move(tempPath, baseConfigPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(tempPath, baseConfigPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            // Clean up the assorted-discoveries.tmp file if something failed
            try {
                Files.deleteIfExists(tempPath);
            } catch (IOException ignored) {}
            throw new RuntimeException("Failed to safely save config", ex);
        }
    }
}
