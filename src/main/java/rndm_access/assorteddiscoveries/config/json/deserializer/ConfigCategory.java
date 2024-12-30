package rndm_access.assorteddiscoveries.config.json.deserializer;

import rndm_access.assorteddiscoveries.config.json.deserializer.entries.*;

import java.util.*;

public class ConfigCategory extends ConfigObject {
    public HashMap<String, ConfigObject> jsonConfigObjects;
    public ArrayList<ConfigCategory> subcategories;
    public int startLine;
    public int endLine;

    protected ConfigCategory(ConfigCategory.Builder builder) {
        super(builder.name);
        this.jsonConfigObjects = builder.jsonConfigObjects;
        this.subcategories = builder.subcategories;
        this.startLine = -1;
        this.endLine = -1;
    }

    public ArrayList<ConfigCategory> getSubcategories() {
        return subcategories;
    }

    public boolean hasSubCategories() {
        return !subcategories.isEmpty();
    }

    public AbstractConfigEntry<?> getEntry(String name) {
        if(!this.hasEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have entry " + name);
        }
        return (AbstractConfigEntry<?>) jsonConfigObjects.get(name);
    }

    public BooleanConfigEntry getBooleanEntry(String name) {
        if(!this.hasBooleanEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have boolean entry "
                    + name);
        }
        return (BooleanConfigEntry) jsonConfigObjects.get(name);
    }

    public IntegerConfigEntry getIntegerEntry(String name) {
        if(!this.hasIntegerEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have integer entry "
                    + name);
        }
        return (IntegerConfigEntry) jsonConfigObjects.get(name);
    }

    public StringConfigEntry getStringEntry(String name) {
        if(!this.hasStringEntry(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have string entry "
                    + name);
        }
        return (StringConfigEntry) jsonConfigObjects.get(name);
    }

    public ConfigCategory getSubcategory(String name) {
        if(!this.hasSubcategory(name)) {
            throw new NoSuchElementException("The category " + this.getName() + " does not have subcategory "
                    + name);
        }
        return (ConfigCategory) jsonConfigObjects.get(name);
    }

    public boolean hasEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof AbstractConfigEntry<?>;
    }

    public boolean hasBooleanEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof BooleanConfigEntry;
    }

    public boolean hasIntegerEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof IntegerConfigEntry;
    }

    public boolean hasStringEntry(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof StringConfigEntry;
    }

    public boolean hasSubcategory(String name) {
        return hasConfigObject(name) && jsonConfigObjects.get(name) instanceof ConfigCategory;
    }

    private boolean hasConfigObject(String name) {
        return jsonConfigObjects.containsKey(name);
    }

    public List<ConfigObject> getJsonObjects() {
        return jsonConfigObjects.values().stream().toList();
    }

    public static class Builder {
        public String name;
        public HashMap<String, ConfigObject> jsonConfigObjects = new LinkedHashMap<>();
        public ArrayList<ConfigCategory> subcategories = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addBooleanEntry(BooleanConfigEntry entry) {
            jsonConfigObjects.put(entry.getName(), entry);
            return this;
        }

        public Builder addIntegerEntry(IntegerConfigEntry entry) {
            jsonConfigObjects.put(entry.getName(), entry);
            return this;
        }

        public Builder addStringEntry(StringConfigEntry entry) {
            jsonConfigObjects.put(entry.getName(), entry);
            return this;
        }

        public Builder addSubcategory(ConfigCategory subCategory) {
            jsonConfigObjects.put(subCategory.getName(), subCategory);
            subcategories.add(subCategory);
            return this;
        }

        public ConfigCategory build() {
            return new ConfigCategory(this);
        }
    }
}
