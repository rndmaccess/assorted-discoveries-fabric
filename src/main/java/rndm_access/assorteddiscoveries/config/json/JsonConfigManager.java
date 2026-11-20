package rndm_access.assorteddiscoveries.config.json;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.loader.api.FabricLoader;
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
    private final List<String> globalComments = new ArrayList<>();
    private final List<ModConfigCategory> categories;
    private final Path path;
    private final String name;
    private boolean hasError;

    public JsonConfigManager(String name) {
        this.name = name;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(name + ".json5");
        this.hasError = false;
        this.categories = List.of(ModConfigCategory.values());
    }

    public void addGlobalComment(String comment) {
        globalComments.add(comment);
    }

    public List<String> getGlobalComments() {
        return globalComments;
    }

    public List<ModConfigCategory> getCategories() {
        return categories;
    }

    public ModConfigCategory getCategory(String key) {
        for (ModConfigCategory category : categories) {
            if (category.getCategoryName().equals(key)) {
                return category;
            }
        }
        return null;
    }

    public JsonConfigEntry<?> getEntry(String key) {
        for (ModConfigCategory category : categories) {
            if (category.hasEntry(key)) {
                return category.getEntry(key);
            }
        }
        return null;
    }

    public void restoreLocalValues() {
        for (ModConfigCategory category : categories) {
            for (JsonConfigEntry<?> entry : category.getEntries()) {
                entry.restoreLocalValue();
            }
        }
    }

    public void applyServerSync(Map<String, Boolean> configMap) {
        for (ModConfigCategory category : categories) {
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

    public void refreshConfigInMemory(Map<String, Object> changeMap) {
        for (ModConfigCategory category : this.categories) {
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
            JsonConfigDeserializer deserializer = new JsonConfigDeserializer(path);
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
            ModConfigCategory category = getCategory(loadedCategoryKey);

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
        Path tempPath = this.path.resolveSibling(this.name + ".json5.tmp");

        try {
            this.save(tempPath);

            if (Files.exists(this.path)) {
                int i = 1;
                Path backupPath = this.path.resolveSibling(this.name + "-" + i + ".json5.bak");
                while (Files.exists(backupPath)) {
                    i++;
                    backupPath = this.path.resolveSibling(this.name + "-" + i + ".json5.bak");
                }
                // Replace existing is used here to prevent potential race conditions.
                Files.move(this.path, backupPath, StandardCopyOption.REPLACE_EXISTING);
            }

            try {
                Files.move(tempPath, this.path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(tempPath, this.path, StandardCopyOption.REPLACE_EXISTING);
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

    public String getName() {
        return name;
    }

    /**
     * @return A flattened view of boolean config entries that can be used when sending packets.
     */
    public List<Pair<String, Boolean>> getBooleanEntries() {
        List<Pair<String, Boolean>> flatEntries = new ArrayList<>();

        for (ModConfigCategory category : categories) {
            for (JsonConfigEntry<?> entry : category.getEntries()) {
                if (entry instanceof BooleanJsonConfigEntry boolEntry) {
                    flatEntries.add(new Pair<>(boolEntry.getKey(), boolEntry.getLocalValue()));
                }
            }
        }
        // Flatten the entry list for sending it to the server in a packet.
        return flatEntries;
    }

    public void create() {
        if (!Files.exists(path)) {
            JsonConfigSerializer serializer = new JsonConfigSerializer(path);
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
        Path tempPath = path.resolveSibling(this.name + ".json5.tmp");

        try {
            JsonConfigSerializer serializer = new JsonConfigSerializer(tempPath);
            serializer.serialize(entryChangeList);

            // Atomically move the new file to the old file's path replacing the old config.
            try {
                Files.move(tempPath, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                Files.move(tempPath, path, StandardCopyOption.REPLACE_EXISTING);
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
