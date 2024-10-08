package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.config.json.parser.entries.ConfigKey;

public class ConfigObject {
    private final ConfigKey key;

    public ConfigObject(ConfigKey key) {
        this.key = key;
    }

    public ConfigKey getKey() {
        return key;
    }
}
