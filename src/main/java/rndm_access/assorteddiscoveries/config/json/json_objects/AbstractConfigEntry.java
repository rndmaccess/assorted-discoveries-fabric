package rndm_access.assorteddiscoveries.config.json.json_objects;

public abstract class AbstractConfigEntry<T> extends ConfigObject {
    private T value;
    private final T defaultValue;

    public AbstractConfigEntry(String key, T defaultValue) {
        super(key);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    public AbstractConfigEntry(String key, T value, T defaultValue) {
        super(key);
        this.value = value;
        this.defaultValue = defaultValue;
    }

    public T getValue() {
        return value;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
