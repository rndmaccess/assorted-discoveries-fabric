package rndm_access.assorteddiscoveries.config.json.parser.entries;

import rndm_access.assorteddiscoveries.config.json.parser.ConfigObject;

public abstract class AbstractConfigEntry<T> extends ConfigObject {
    private final ConfigValue<T> value;
    private String comment;
    private int line;
    private int start;
    private int end;

    public AbstractConfigEntry(String name, T defaultValue) {
        super(new ConfigKey(name));
        this.value = new ConfigValue<>(defaultValue);
        this.line = -1;
        this.start = -1;
        this.end = -1;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLine() {
        return line;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public AbstractConfigEntry(String name, T defaultValue, String comment) {
        super(new ConfigKey(name));
        this.value = new ConfigValue<>(defaultValue);
        this.comment = comment;
    }

    public ConfigValue<T> getValue() {
        return value;
    }

    public String getComment() {
        return comment;
    }
}
