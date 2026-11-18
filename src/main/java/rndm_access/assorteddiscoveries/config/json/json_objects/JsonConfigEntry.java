package rndm_access.assorteddiscoveries.config.json.json_objects;

import rndm_access.assorteddiscoveries.config.ConfigSyncManager;

import java.util.Objects;

public abstract class JsonConfigEntry<T> {
    private final String key;
    private T localValue;
    private T activeValue;
    private final T defaultValue;
    private final String comment;

    public JsonConfigEntry(String key, T defaultValue, String comment) {
        this.key = key;
        this.activeValue = defaultValue;
        this.localValue = defaultValue;
        this.defaultValue = defaultValue;
        this.comment = comment;
    }

    public JsonConfigEntry(String key, T defaultValue) {
        this.key = key;
        this.localValue = defaultValue;
        this.activeValue = defaultValue;
        this.defaultValue = defaultValue;
        this.comment = "";
    }

    public String getKey() {
        return key;
    }

    public T getLocalValue() {
        return localValue;
    }

    public void setLocalValue(T value) {
        this.localValue = value;

        if (!ConfigSyncManager.isSyncedWithServer()) {
            this.activeValue = value;
        }
    }

    public T getActiveValue() {
        return activeValue;
    }

    public void setActiveValue(T activeValue) {
        this.activeValue = activeValue;
    }

    public void restoreLocalValue() {
        this.activeValue = this.localValue;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public String getComment() {
        return comment;
    }

    public boolean hasComment() {
        return !Objects.equals(comment, "");
    }
}
