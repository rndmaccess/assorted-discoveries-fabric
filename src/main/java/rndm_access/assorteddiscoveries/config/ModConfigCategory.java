package rndm_access.assorteddiscoveries.config;

import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanJsonConfigEntry;

import java.util.*;

public enum ModConfigCategory {
    BUILDING_BLOCKS("building_blocks",
            "All options toggle both the base blocks and their variants in creative menus and recipes."),
    PLUSHIES("plushies",
            "All options toggle the plushies in creative menus and recipes."),
    FOODS("foods",
            "All options toggle the foods and blocks in creative menus, recipes, and world generation."),
    PLANTS("plants",
            "All options toggle the blocks in creative menus, recipes, and world generation.");

    private final String name;
    private final String comment;
    private final Map<String, JsonConfigEntry<?>> entries;
    private final List<JsonConfigEntry<?>> entryList;

    ModConfigCategory(String name, String comment) {
        this.name = name;
        this.comment = comment;
        this.entries = new HashMap<>();
        this.entryList = new ArrayList<>();
    }

    public String getCategoryName() {
        return name;
    }

    public String getCategoryComment() {
        return comment;
    }

    public List<JsonConfigEntry<?>> getEntries() {
        return entryList;
    }

    public boolean hasEntry(String key) {
        return this.entries.containsKey(key);
    }

    public <T extends JsonConfigEntry<?>> T addEntry(T entry) {
        if (entries.containsKey(entry.getKey())) {
            throw new IllegalArgumentException("Duplicate config entry key: " + entry.getKey());
        }

        entries.put(entry.getKey(), entry);
        entryList.add(entry);
        return entry;
    }

    private JsonConfigEntry<?> lookupEntry(String key) {
        if (entries.containsKey(key)) {
            return entries.get(key);
        }
        return null;
    }

    public JsonConfigEntry<?> getEntry(String name) {
        return lookupEntry(name);
    }

    public BooleanJsonConfigEntry getBoolEntry(String name) {
        return (BooleanJsonConfigEntry) lookupEntry(name);
    }
}
