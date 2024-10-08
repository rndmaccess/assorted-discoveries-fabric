package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class BooleanConfigEntry extends AbstractConfigEntry<Boolean> {
    public BooleanConfigEntry(String name) {
        super(name, true);
    }

    public BooleanConfigEntry(String name, String comment) {
        super(name, true, comment);
    }
}
