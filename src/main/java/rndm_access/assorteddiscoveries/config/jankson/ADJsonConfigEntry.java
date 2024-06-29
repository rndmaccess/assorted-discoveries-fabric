package rndm_access.assorteddiscoveries.config.jankson;

/**
 * Instances of this class serve as different entries within the json config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADJsonConfigEntry extends ADJsonConfigComponentBase {
    private Object value;
    private String comment;

    public ADJsonConfigEntry(String name, String defaultValue) {
        super(name);
        this.value = defaultValue;
    }

    public ADJsonConfigEntry(String name, boolean defaultValue) {
        super(name);
        this.value = defaultValue;
    }

    public ADJsonConfigEntry(String name, boolean defaultValue, String comment) {
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
