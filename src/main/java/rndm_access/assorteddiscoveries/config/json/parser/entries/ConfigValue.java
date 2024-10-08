package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class ConfigValue<T> {
    private T entryValue;
    private int start;
    private int end;

    public ConfigValue(T entryValue) {
        this.entryValue = entryValue;
        this.start = -1;
        this.end = -1;
    }

    public void setEntryValue(T value) {
        this.entryValue = value;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public T evaluate() {
        return entryValue;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
