package rndm_access.assorteddiscoveries.config;

import java.util.Map;

/**
 * This config is used in client based places in the code such as creative tabs to reflect the server config data.
 * The config is populated on the client whenever a player joins the game and is updated on
 * the server whenever a server starts! Currently, it's only used to decide what items should be
 * visible in the assorted discoveries creative tab!
 */
public class ModClientConfig {
    private static volatile Map<String, Boolean> boolServerConfigEntries = null;

    public static synchronized Map<String, Boolean> get() {
        return boolServerConfigEntries;
    }

    public static synchronized void update(Map<String, Boolean> entries) {
        boolServerConfigEntries = entries;
    }
}
