package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.config.json.parser.entries.AbstractJsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonBooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonIntegerConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonStringConfigEntry;

import java.util.*;

public class JsonConfigCategory extends JsonConfigObject {
    public LinkedHashMap<String, JsonConfigObject> jsonConfigObjects;
    public LinkedList<String> subcategoryNames;

    protected JsonConfigCategory(JsonConfigCategory.Builder builder) {
        super(builder.name);
        this.jsonConfigObjects = builder.jsonConfigObjects;
        this.subcategoryNames = builder.subcategoryNames;
    }

    public LinkedList<String> getSubcategoryNames() {
        return subcategoryNames;
    }

    public List<String> getEntryNames() {
        return jsonConfigObjects.keySet().stream().toList();
    }

    public AbstractJsonConfigEntry<?> getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have entry " + entryName);
        }
        return (AbstractJsonConfigEntry<?>) jsonConfigObjects.get(entryName);
    }

    public JsonBooleanConfigEntry getBooleanEntry(String entryName) {
        if(!this.hasBooleanEntry(entryName)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have boolean entry "
                    + entryName);
        }
        return (JsonBooleanConfigEntry) jsonConfigObjects.get(entryName);
    }

    public JsonIntegerConfigEntry getIntegerEntry(String entryName) {
        if(!this.hasIntegerEntry(entryName)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have integer entry "
                    + entryName);
        }
        return (JsonIntegerConfigEntry) jsonConfigObjects.get(entryName);
    }

    public JsonStringConfigEntry getStringEntry(String entryName) {
        if(!this.hasStringEntry(entryName)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have string entry "
                    + entryName);
        }
        return (JsonStringConfigEntry) jsonConfigObjects.get(entryName);
    }

    public JsonConfigCategory getSubcategory(String subCategoryName) {
        if(!this.hasSubcategory(subCategoryName)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have subcategory "
                    + subCategoryName);
        }
        return (JsonConfigCategory) jsonConfigObjects.get(subCategoryName);
    }

    public boolean hasEntry(String entryName) {
        return hasConfigObject(entryName) && jsonConfigObjects.get(entryName) instanceof AbstractJsonConfigEntry<?>;
    }

    public boolean hasBooleanEntry(String entryName) {
        return hasConfigObject(entryName) && jsonConfigObjects.get(entryName) instanceof JsonBooleanConfigEntry;
    }

    public boolean hasIntegerEntry(String entryName) {
        return hasConfigObject(entryName) && jsonConfigObjects.get(entryName) instanceof JsonIntegerConfigEntry;
    }

    public boolean hasStringEntry(String entryName) {
        return hasConfigObject(entryName) && jsonConfigObjects.get(entryName) instanceof JsonStringConfigEntry;
    }

    public boolean hasSubcategory(String subCategoryName) {
        return hasConfigObject(subCategoryName) && jsonConfigObjects.get(subCategoryName) instanceof JsonConfigCategory;
    }

    private boolean hasConfigObject(String key) {
        return jsonConfigObjects.containsKey(key);
    }

    public List<JsonConfigObject> getJsonObjects() {
        return jsonConfigObjects.values().stream().toList();
    }

    public static class Builder {
        public String name;
        public LinkedHashMap<String, JsonConfigObject> jsonConfigObjects = new LinkedHashMap<>();
        public LinkedList<String> subcategoryNames = new LinkedList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addBooleanEntry(JsonBooleanConfigEntry entry) {
            jsonConfigObjects.put(entry.getName(), entry);
            return this;
        }

        public Builder addIntegerEntry(JsonIntegerConfigEntry entry) {
            jsonConfigObjects.put(entry.getName(), entry);
            return this;
        }

        public Builder addStringEntry(JsonStringConfigEntry entry) {
            jsonConfigObjects.put(entry.getName(), entry);
            return this;
        }

        public Builder addSubcategory(JsonConfigCategory subCategory) {
            jsonConfigObjects.put(subCategory.getName(), subCategory);
            subcategoryNames.add(subCategory.getName());
            return this;
        }

        public JsonConfigCategory build() {
            return new JsonConfigCategory(this);
        }
    }
}
