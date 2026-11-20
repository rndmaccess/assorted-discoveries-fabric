package rndm_access.assorteddiscoveries.config;

import com.mojang.datafixers.util.Pair;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanJsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ConfigSyncManager {
    private static volatile boolean syncedWithServer = false;

    private ConfigSyncManager() {}

    public static boolean isSyncedWithServer() {
        return syncedWithServer;
    }

    /**
     * Called when a player connects to a server.
     *
     * @param configList The config values received from the server.
     */
    public static void syncWithServer(List<Pair<String, Boolean>> configList) {
        syncedWithServer = true;

        Map<String, Boolean> configMap = new HashMap<>();
        for (Pair<String, Boolean> configValue : configList) {
            configMap.put(configValue.getFirst(), configValue.getSecond());
        }
        ModConfig.CONFIG_MANAGER.applyServerSync(configMap);
    }

    /**
     * Called when the player disconnects from a server
     */
    public static void reset() {
        syncedWithServer = false;
        ModConfig.CONFIG_MANAGER.restoreLocalValues();
    }

    /**
     * @return A flattened view of boolean config entries that can be used when sending packets.
     */
    public static List<Pair<String, Boolean>> collectBooleanSyncEntries(JsonConfig config) {
        List<Pair<String, Boolean>> flatEntries = new ArrayList<>();

        for (ModConfigCategory category : config.getCategories()) {
            for (JsonConfigEntry<?> entry : category.getEntries()) {
                if (entry instanceof BooleanJsonConfigEntry boolEntry) {
                    flatEntries.add(new Pair<>(boolEntry.getKey(), boolEntry.getLocalValue()));
                }
            }
        }
        return flatEntries;
    }
}
