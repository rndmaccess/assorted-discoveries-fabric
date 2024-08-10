package rndm_access.assorteddiscoveries.config.json.parser.entries;

import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigObject;

public abstract class AbstractJsonConfigEntry<T> extends JsonConfigObject {
    private T value;
    private String comment;

    public AbstractJsonConfigEntry(String name, T defaultValue) {
        super(name);
        this.value = defaultValue;
    }

    public AbstractJsonConfigEntry(String name, T defaultValue, String comment) {
        super(name);
        this.value = defaultValue;
        this.comment = comment;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }
}
