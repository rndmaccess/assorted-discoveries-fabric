package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class JsonBooleanConfigEntry extends AbstractJsonConfigEntry<Boolean> {
    public JsonBooleanConfigEntry(String name, boolean defaultValue) {
        super(name, defaultValue);
    }

    public JsonBooleanConfigEntry(String name, boolean defaultValue, String comment) {
        super(name, defaultValue, comment);
    }
}
