package rndm_access.assorteddiscoveries.config.json;

public class JsonConfigEntry extends JsonConfigObject {
    private Object value;
    private String comment;

    public JsonConfigEntry(String name, String defaultValue) {
        super(name);
        this.value = defaultValue;
    }

    public JsonConfigEntry(String name, boolean defaultValue) {
        super(name);
        this.value = defaultValue;
    }

    public JsonConfigEntry(String name, boolean defaultValue, String comment) {
        super(name);
        this.value = defaultValue;
        this.comment = comment;
    }

    public Object getValue() {
        return value;
    }

    public boolean getValueAsBool() {
        if(this.value.getClass().equals(Boolean.class)) {
            return (Boolean) value;
        } else {
            throw new RuntimeException("Cannot get value as a boolean for entry " + this.getName());
        }
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }
}
