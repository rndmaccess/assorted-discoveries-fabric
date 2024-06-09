package rndm_access.assorteddiscoveries.config;

/**
 * Instances of this class serve as different entries within the jankson config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADConfigEntry {
    private final String name;
    private Object value;
    private String comment;

    public ADConfigEntry(String name, Object defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    public ADConfigEntry(String name) {
        this.name = name;
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

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
