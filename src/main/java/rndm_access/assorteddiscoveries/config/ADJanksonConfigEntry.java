package rndm_access.assorteddiscoveries.config;

/**
 * Instances of this class serve as different entries within the jankson config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADJanksonConfigEntry {
    private final String name;
    private Object value;
    private String comment;

    public ADJanksonConfigEntry(String name, Object defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    public ADJanksonConfigEntry(String name, Object defaultValue, String comment) {
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
