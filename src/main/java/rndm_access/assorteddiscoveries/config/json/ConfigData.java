package rndm_access.assorteddiscoveries.config.json;

import java.nio.file.Path;

public class ConfigData {
    private static ConfigData instance;
    private Path path;
    private ConfigType type;

    private ConfigData(Path path, ConfigType type) {
        this.path = path;
        this.type = type;
    }

    public static synchronized ConfigData getInstance(Path path, ConfigType type) {
        if (instance == null) {
            instance = new ConfigData(path, type);
        }
        return instance;
    }

    public static synchronized ConfigData getInstance() {
        return instance;
    }

    public static synchronized void update(Path path, ConfigType type) {
        instance.type = type;
        instance.path = path;
    }

    public Path getPath() {
        return path;
    }

    public ConfigType getType() {
        return type;
    }
}
