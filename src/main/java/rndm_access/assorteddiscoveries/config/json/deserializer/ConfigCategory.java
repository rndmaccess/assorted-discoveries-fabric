package rndm_access.assorteddiscoveries.config.json.deserializer;

import rndm_access.assorteddiscoveries.config.json.deserializer.entries.*;

import java.util.*;

public class ConfigCategory extends ConfigObject {
    private final List<ConfigObject> objects;
    private final Map<String, AbstractConfigEntry<?>> entries;

    protected ConfigCategory(ConfigCategory.Builder builder) {
        super(builder.name);
        this.objects = builder.objects;
        this.entries = builder.entries;
    }

    public List<AbstractConfigEntry<?>> getEntries() {
        return entries.values().stream().toList();
    }

    public AbstractConfigEntry<?> getEntry(String name) {
        if(!this.hasEntry(name)) {
            throw new NoSuchElementException("The category " + this.getKey() + " does not have entry " + name);
        }
        return entries.get(name);
    }

    public BooleanConfigEntry getBoolEntry(String name) {
        if(!this.hasEntry(name)) {
            throw new NoSuchElementException("The category " + this.getKey() + " does not have entry " + name);
        }
        return (BooleanConfigEntry) entries.get(name);
    }

    public boolean hasEntry(String name) {
        return entries.containsKey(name) && entries.get(name) instanceof AbstractConfigEntry<?>;
    }

    public boolean hasStringEntry(String name) {
        return entries.containsKey(name) && entries.get(name) instanceof StringConfigEntry;
    }

    public List<ConfigObject> getJsonObjects() {
        return objects;
    }

    public static class Builder {
        public String name;
        private final List<ConfigObject> objects = new ArrayList<>();
        private final Map<String, AbstractConfigEntry<?>> entries = new LinkedHashMap<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addComment(CommentConfigEntry comment) {
            objects.add(comment);
            return this;
        }

        public <T extends AbstractConfigEntry<?>> Builder addEntry(T entry) {
            String name = entry.getKey();
            entries.put(name, entry);
            objects.add(entry);
            return this;
        }

        public ConfigCategory build() {
            return new ConfigCategory(this);
        }
    }
}
