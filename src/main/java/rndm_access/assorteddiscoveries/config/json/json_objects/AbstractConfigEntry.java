package rndm_access.assorteddiscoveries.config.json.json_objects;

import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;

public abstract class AbstractConfigEntry<T> extends ConfigObject {
    private final boolean isImmutable;
    private T value;

    public AbstractConfigEntry(String key, T value, boolean isImmutable) {
        super(key);
        this.value = value;
        this.isImmutable = isImmutable;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        if (isImmutable) {
            throw new JsonConfigException("Cannot edit the default config!");
        }
        this.value = value;
    }
}
