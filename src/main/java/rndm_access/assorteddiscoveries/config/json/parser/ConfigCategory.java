package rndm_access.assorteddiscoveries.config.json.parser;

import rndm_access.assorteddiscoveries.config.json.parser.entries.*;

import java.util.*;

public class ConfigCategory extends ConfigObject {
    public HashMap<String, ConfigObject> jsonConfigObjects;
    public ArrayList<String> subcategoryNames;
    public int startLine;
    public int endLine;

    protected ConfigCategory(ConfigCategory.Builder builder) {
        super(builder.key);
        this.jsonConfigObjects = builder.jsonConfigObjects;
        this.subcategoryNames = builder.subcategoryNames;
        this.startLine = -1;
        this.endLine = -1;
    }

    public int getStartLine() {
        return startLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public ArrayList<String> getSubcategoryNames() {
        return subcategoryNames;
    }

    public boolean hasSubCategories() {
        return !subcategoryNames.isEmpty();
    }

    public AbstractConfigEntry<?> getEntry(String name) {
        if(!this.hasEntry(name)) {
            throw new NoSuchElementException("The category " + this.getKey().getName() + " does not have entry " + name);
        }
        return (AbstractConfigEntry<?>) jsonConfigObjects.get(name);
    }

    public BooleanConfigEntry getBooleanEntry(String name) {
        if(!this.hasBooleanEntry(name)) {
            throw new NoSuchElementException("The category " + this.getKey().getName() + " does not have boolean entry "
                    + name);
        }
        return (BooleanConfigEntry) jsonConfigObjects.get(name);
    }

    public IntegerConfigEntry getIntegerEntry(String name) {
        if(!this.hasIntegerEntry(name)) {
            throw new NoSuchElementException("The category " + this.getKey().getName() + " does not have integer entry "
                    + name);
        }
        return (IntegerConfigEntry) jsonConfigObjects.get(name);
    }

    public StringConfigEntry getStringEntry(String name) {
        if(!this.hasStringEntry(name)) {
            throw new NoSuchElementException("The category " + this.getKey().getName() + " does not have string entry "
                    + name);
        }
        return (StringConfigEntry) jsonConfigObjects.get(name);
    }

    public ConfigCategory getSubcategory(String name) {
        if(!this.hasSubcategory(name)) {
            throw new NoSuchElementException("The category " + this.getKey().getName() + " does not have subcategory "
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
        public ConfigKey key;
        public HashMap<String, ConfigObject> jsonConfigObjects = new LinkedHashMap<>();
        public ArrayList<String> subcategoryNames = new ArrayList<>();

        public Builder(String name) {
            this.key = new ConfigKey(name);
        }

        public Builder addBooleanEntry(BooleanConfigEntry entry) {
            jsonConfigObjects.put(entry.getKey().getName(), entry);
            return this;
        }

        public Builder addIntegerEntry(IntegerConfigEntry entry) {
            jsonConfigObjects.put(entry.getKey().getName(), entry);
            return this;
        }

        public Builder addStringEntry(StringConfigEntry entry) {
            jsonConfigObjects.put(entry.getKey().getName(), entry);
            return this;
        }

        public Builder addSubcategory(ConfigCategory subCategory) {
            jsonConfigObjects.put(subCategory.getKey().getName(), subCategory);
            subcategoryNames.add(subCategory.getKey().getName());
            return this;
        }

        public ConfigCategory build() {
            return new ConfigCategory(this);
        }
    }
}
