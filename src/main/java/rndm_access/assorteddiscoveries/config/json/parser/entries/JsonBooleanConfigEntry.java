package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class JsonBooleanConfigEntry extends AbstractJsonConfigEntry<Boolean> {
    public JsonBooleanConfigEntry(String name) {
        super(name, true);
    }

    public JsonBooleanConfigEntry(String name, String comment) {
        super(name, true, comment);
    }
}
