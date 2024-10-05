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

    public boolean hasSubCategories() {
        return !subcategoryNames.isEmpty();
    }

    public AbstractJsonConfigEntry<?> getEntry(String name) {
        if(!this.hasEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have entry " + name);
        }
        return (AbstractJsonConfigEntry<?>) jsonConfigObjects.get(name);
    }

    public JsonBooleanConfigEntry getBooleanEntry(String name) {
        if(!this.hasBooleanEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have boolean entry "
                    + name);
        }
        return (JsonBooleanConfigEntry) jsonConfigObjects.get(name);
    }

    public JsonIntegerConfigEntry getIntegerEntry(String name) {
        if(!this.hasIntegerEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have integer entry "
                    + name);
        }
        return (JsonIntegerConfigEntry) jsonConfigObjects.get(name);
    }

    public JsonStringConfigEntry getStringEntry(String name) {
        if(!this.hasStringEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have string entry "
                    + name);
        }
        return (JsonStringConfigEntry) jsonConfigObjects.get(name);
    }

    public JsonConfigCategory getSubcategory(String name) {
        if(!this.hasSubcategory(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have subcategory "
                    + name);
        }
        return (JsonConfigCategory) jsonConfigObjects.get(name);
    }

    public boolean hasEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof AbstractJsonConfigEntry<?>;
    }

    public boolean hasBooleanEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof JsonBooleanConfigEntry;
    }

    public boolean hasIntegerEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof JsonIntegerConfigEntry;
    }

    public boolean hasStringEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof JsonStringConfigEntry;
    }

    public boolean hasSubcategory(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof JsonConfigCategory;
    }

    private boolean hasConfigObject(String name) {
        return jsonConfigObjects.containsKey(name);
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
