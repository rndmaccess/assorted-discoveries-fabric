package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class StringConfigEntry extends AbstractConfigEntry<String> {
    public StringConfigEntry(String name, String defaultValue) {
        super(name, defaultValue);
    }

    public StringConfigEntry(String name, String defaultValue, String comment) {
        super(name, defaultValue, comment);
    }
}
