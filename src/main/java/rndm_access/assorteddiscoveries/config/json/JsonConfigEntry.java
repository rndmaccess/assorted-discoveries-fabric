package rndm_access.assorteddiscoveries.config.json;

public class JsonConfigEntry extends JsonConfigObject {
    private Object value;
    private String comment;

    public JsonConfigEntry(String name, Object defaultValue) {
        super(name);
        this.value = defaultValue;
    }

    public JsonConfigEntry(String name, Object defaultValue, String comment) {
        super(name);
        this.value = defaultValue;
        this.comment = comment;
    }

    public boolean isBooleanEntry() {
        return this instanceof JsonConfigBoolEntry;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }
}
