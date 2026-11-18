package rndm_access.assorteddiscoveries.config.json.json_objects;

public class BooleanJsonConfigEntry extends JsonConfigEntry<Boolean> {
    public BooleanJsonConfigEntry(String key, String comment) {
        super(key, true, comment);
    }

    public BooleanJsonConfigEntry(String key) {
        super(key, true);
    }
}
