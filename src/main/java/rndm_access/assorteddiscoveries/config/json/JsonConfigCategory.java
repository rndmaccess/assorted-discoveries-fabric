package rndm_access.assorteddiscoveries.config.json;

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

    public JsonConfigEntry getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have entry " + entryName);
        }
        return (JsonConfigEntry) jsonConfigObjects.get(entryName);
    }

    public JsonConfigCategory getSubcategory(String subCategoryName) {
        if(!this.hasSubcategory(subCategoryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have sub category " + subCategoryName);
        }
        return (JsonConfigCategory) jsonConfigObjects.get(subCategoryName);
    }

    public boolean hasEntry(String entryName) {
        return jsonConfigObjects.containsKey(entryName)
                && jsonConfigObjects.get(entryName) instanceof JsonConfigEntry;
    }

    public boolean hasSubcategory(String subCategoryName) {
        return jsonConfigObjects.containsKey(subCategoryName)
                && jsonConfigObjects.get(subCategoryName) instanceof JsonConfigCategory;
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

        public Builder addEntry(JsonConfigEntry entry) {
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
