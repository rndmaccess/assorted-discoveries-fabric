package rndm_access.assorteddiscoveries.config.json.deserializer.entries;

import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigObject;

public abstract class AbstractConfigEntry<T> extends ConfigObject {
    private T value;
    private String comment;

    public AbstractConfigEntry(String name, T value) {
        super(name);
        this.value = value;
    }

    public AbstractConfigEntry(String name, T value, String comment) {
        super(name);
        this.value = value;
        this.comment = comment;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }

    public boolean hasComment() {
        return comment != null;
    }
}
