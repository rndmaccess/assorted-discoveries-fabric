package rndm_access.assorteddiscoveries.config.json.json_objects;

public class BooleanConfigEntry extends AbstractConfigEntry<Boolean> {
    public BooleanConfigEntry(String key) {
        super(key, true);
    }

    public BooleanConfigEntry(String key, boolean value) {
        super(key, value);
    }
}
