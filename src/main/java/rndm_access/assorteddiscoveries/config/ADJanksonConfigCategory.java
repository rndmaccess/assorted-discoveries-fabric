package rndm_access.assorteddiscoveries.config;

import java.util.*;

/**
 * Instances of this class serve as different categories within the jankson config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADJanksonConfigCategory {
    private final String name;
    private final LinkedHashMap<String, ADJanksonConfigEntry> entries = new LinkedHashMap<>();

    public ADJanksonConfigCategory(String name) {
        this.name = name;
    }

    public void addEntry(ADJanksonConfigEntry entry) {
        entries.put(entry.getName(), entry);
    }

    public String getName() {
        return name;
    }

    public ADJanksonConfigEntry getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new RuntimeException("The category does not have entry " + entryName);
        }
        return entries.get(entryName);
    }

    public boolean hasEntry(String entryName) {
        return entries.containsKey(entryName);
    }

    public List<ADJanksonConfigEntry> getEntries() {
        return entries.values().stream().toList();
    }

    public List<String> getEntryNames() {
        return entries.keySet().stream().toList();
    }
}
