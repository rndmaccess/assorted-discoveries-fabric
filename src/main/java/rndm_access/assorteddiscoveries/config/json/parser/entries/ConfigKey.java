package rndm_access.assorteddiscoveries.config.json.parser.entries;

public class ConfigKey {
    public String name;
    public int start;
    public int end;

    public ConfigKey(String name) {
        this.name = name;
        this.start = -1;
        this.end = -1;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }
}
