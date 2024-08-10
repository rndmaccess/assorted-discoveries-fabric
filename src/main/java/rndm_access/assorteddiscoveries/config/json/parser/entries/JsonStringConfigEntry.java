package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class JsonStringConfigEntry extends AbstractJsonConfigEntry<String> {
    public JsonStringConfigEntry(String name, String defaultValue) {
        super(name, defaultValue);
    }

    public JsonStringConfigEntry(String name, String defaultValue, String comment) {
        super(name, defaultValue, comment);
    }
}
