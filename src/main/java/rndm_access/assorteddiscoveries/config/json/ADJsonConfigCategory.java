package rndm_access.assorteddiscoveries.config.json;

import java.util.*;

public class ADJsonConfigCategory extends ADJsonConfigComponent {
    public LinkedHashMap<String, ADJsonConfigComponent> components;
    public LinkedList<String> subcategoryNames;

    protected ADJsonConfigCategory(ADJsonConfigCategory.Builder builder) {
        super(builder.name);
        this.components = builder.components;
        this.subcategoryNames = builder.subcategoryNames;
    }

    public LinkedList<String> getSubcategoryNames() {
        return subcategoryNames;
    }

    public ADJsonConfigEntry getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have entry " + entryName);
        }
        return (ADJsonConfigEntry) components.get(entryName);
    }

    public ADJsonConfigCategory getSubcategory(String subCategoryName) {
        if(!this.hasSubcategory(subCategoryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have sub category " + subCategoryName);
        }
        return (ADJsonConfigCategory) components.get(subCategoryName);
    }

    public boolean hasEntry(String entryName) {
        return components.containsKey(entryName)
                && components.get(entryName) instanceof ADJsonConfigEntry;
    }

    public boolean hasSubcategory(String subCategoryName) {
        return components.containsKey(subCategoryName)
                && components.get(subCategoryName) instanceof ADJsonConfigCategory;
    }

    public List<ADJsonConfigComponent> getComponents() {
        return components.values().stream().toList();
    }

    public static class Builder {
        public String name;
        public LinkedHashMap<String, ADJsonConfigComponent> components = new LinkedHashMap<>();
        public LinkedList<String> subcategoryNames = new LinkedList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder addEntry(ADJsonConfigEntry entry) {
            components.put(entry.getName(), entry);
            return this;
        }

        public Builder addSubcategory(ADJsonConfigCategory subCategory) {
            components.put(subCategory.getName(), subCategory);
            subcategoryNames.add(subCategory.getName());
            return this;
        }

        public ADJsonConfigCategory build() {
            return new ADJsonConfigCategory(this);
        }
    }
}
