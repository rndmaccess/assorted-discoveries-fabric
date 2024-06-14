package rndm_access.assorteddiscoveries.config.jankson;

/**
 * Instances of this class serve as different entries within the json config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADJsonConfigEntry {
    private final String name;
    private Object value;
    private String comment;

    public ADJsonConfigEntry(String name, Object defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    public ADJsonConfigEntry(String name, Object defaultValue, String comment) {
        this.name = name;
        this.value = defaultValue;
        this.comment = comment;
    }

    public String getName() {
        return name;
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
