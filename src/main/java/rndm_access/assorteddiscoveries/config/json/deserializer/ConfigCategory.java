package rndm_access.assorteddiscoveries.config.json.deserializer;

import rndm_access.assorteddiscoveries.config.json.deserializer.entries.*;

import java.util.*;

public class ConfigCategory extends ConfigObject {
    private final List<ConfigObject> objects;
    private final List<AbstractConfigEntry<?>> entries;

    protected ConfigCategory(ConfigCategory.Builder builder) {
        super(builder.name);
        this.objects = builder.objects;
        this.entries = builder.entries;
    }

    public List<AbstractConfigEntry<?>> getEntries() {
        return entries;
    }

    public AbstractConfigEntry<?> getEntry(String name) {
        return lookupEntry(name);
    }

    public BooleanConfigEntry getBoolEntry(String name) {
        return (BooleanConfigEntry) lookupEntry(name);
    }

    private AbstractConfigEntry<?> lookupEntry(String key) {
        for (AbstractConfigEntry<?> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }

    public List<ConfigObject> getJsonObjects() {
        return objects;
    }

    public static class Builder {
        public String name;
        private final List<ConfigObject> objects = new ArrayList<>();
        private final List<AbstractConfigEntry<?>> entries = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addComment(CommentConfigEntry comment) {
            objects.add(comment);
            return this;
        }

        public <T extends AbstractConfigEntry<?>> Builder addEntry(T entry) {
            entries.add(entry);
            objects.add(entry);
            return this;
        }

        public ConfigCategory build() {
            return new ConfigCategory(this);
        }
    }
}
