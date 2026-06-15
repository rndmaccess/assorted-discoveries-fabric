package rndm_access.assorteddiscoveries.config.json.deserializer;

import rndm_access.assorteddiscoveries.config.json.deserializer.entries.*;

import java.util.*;

public class JsonConfigCategory extends ConfigObject {
    private final List<ConfigObject> objects;
    private final Map<String, AbstractConfigEntry<?>> entries;

    protected JsonConfigCategory(JsonConfigCategory.Builder builder) {
        super(builder.name);
        this.objects = builder.objects;
        this.entries = builder.entries;
    }

    public AbstractConfigEntry<?> getEntry(String name) {
        return lookupEntry(name);
    }

    public BooleanConfigEntry getBoolEntry(String name) {
        return (BooleanConfigEntry) lookupEntry(name);
    }

    private AbstractConfigEntry<?> lookupEntry(String key) {
        if (entries.containsKey(key)) {
            return entries.get(key);
        }
        return null;
    }

    public int getSize() {
        return objects.size();
    }

    public List<ConfigObject> getConfigObjects() {
        return objects;
    }

    public static class Builder {
        public String name;
        private final List<ConfigObject> objects = new ArrayList<>();
        private final Map<String, AbstractConfigEntry<?>> entries = new HashMap<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addComment(CommentConfigEntry comment) {
            objects.add(comment);
            return this;
        }

        public <T extends AbstractConfigEntry<?>> Builder addEntry(T entry) {
            entries.put(entry.getKey(), entry);
            objects.add(entry);
            return this;
        }

        public JsonConfigCategory build() {
            return new JsonConfigCategory(this);
        }
    }
}
