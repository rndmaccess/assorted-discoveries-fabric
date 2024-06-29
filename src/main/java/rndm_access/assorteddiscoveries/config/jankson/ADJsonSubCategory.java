package rndm_access.assorteddiscoveries.config.jankson;

import java.util.LinkedHashMap;
import java.util.List;

public class ADJsonSubCategory extends ADJsonConfigComponentBase {
    private final LinkedHashMap<String, ADJsonConfigEntry> entries = new LinkedHashMap<>();

    public ADJsonSubCategory(String name) {
        super(name);
    }

    public void addEntry(ADJsonConfigEntry entry) {
        entries.put(entry.getName(), entry);
    }

    public ADJsonConfigEntry getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have entry " + entryName);
        }
        return entries.get(entryName);
    }

    public boolean hasEntry(String entryName) {
        return entries.containsKey(entryName);
    }

    public List<ADJsonConfigEntry> getEntries() {
        return entries.values().stream().toList();
    }
}
