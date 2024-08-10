package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class JsonIntegerConfigEntry extends AbstractJsonConfigEntry<Integer> {
    public JsonIntegerConfigEntry(String name, int defaultValue) {
        super(name, defaultValue);
    }

    public JsonIntegerConfigEntry(String name, int defaultValue, String comment) {
        super(name, defaultValue, comment);
    }
}
