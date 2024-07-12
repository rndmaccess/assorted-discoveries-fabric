package rndm_access.assorteddiscoveries.config.json;

public class JsonConfigBoolEntry extends JsonConfigEntry {
    private boolean value;

    public JsonConfigBoolEntry(String name, boolean defaultValue) {
        super(name, defaultValue);
        this.value = defaultValue;
    }

    public JsonConfigBoolEntry(String name, boolean defaultValue, String comment) {
        super(name, defaultValue, comment);
        this.value = defaultValue;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        super.setValue(value);
        this.value = value;
    }
}
