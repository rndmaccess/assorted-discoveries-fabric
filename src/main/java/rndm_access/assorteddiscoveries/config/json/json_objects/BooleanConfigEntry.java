package rndm_access.assorteddiscoveries.config.json.json_objects;

public class BooleanConfigEntry extends AbstractConfigEntry<Boolean> {
    public BooleanConfigEntry(String key) {
        super(key, true, false);
    }

    public BooleanConfigEntry(String key, boolean value, boolean isImmutable) {
        super(key, value, isImmutable);
    }
}
