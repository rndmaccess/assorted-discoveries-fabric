package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class IntegerConfigEntry extends AbstractConfigEntry<Integer> {
    public IntegerConfigEntry(String name, int defaultValue) {
        super(name, defaultValue);
    }

    public IntegerConfigEntry(String name, int defaultValue, String comment) {
        super(name, defaultValue, comment);
    }
}
