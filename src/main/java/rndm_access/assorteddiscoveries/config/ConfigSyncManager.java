package rndm_access.assorteddiscoveries.config;

import com.mojang.datafixers.util.Pair;

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
}
