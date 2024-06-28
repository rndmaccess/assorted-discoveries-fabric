package rndm_access.assorteddiscoveries.config.jankson;

import java.util.Collection;
import java.util.LinkedHashMap;

public class ADJsonConfig {
    public LinkedHashMap<String, ADJsonConfigCategory> configCategories;

    protected ADJsonConfig(LinkedHashMap<String, ADJsonConfigCategory> configCategories) {
        this.configCategories = configCategories;
    }

    public ADJsonConfigCategory getCategory(String categoryName) {
        if(!this.hasCategory(categoryName)) {
            throw new RuntimeException("The config does not have category " + categoryName);
        }
        return configCategories.get(categoryName);
    }

    public boolean hasCategory(String categoryName) {
        return configCategories.containsKey(categoryName);
    }

    public Collection<ADJsonConfigCategory> getCategories() {
        return configCategories.values();
    }

    public static class Builder {
        public LinkedHashMap<String, ADJsonConfigCategory> configCategories = new LinkedHashMap<>();

        public ADJsonConfigCategory addCategory(String categoryName) {
            ADJsonConfigCategory category = new ADJsonConfigCategory(categoryName);
            configCategories.put(categoryName, category);
            return category;
        }

        public ADJsonConfig build() {
            return new ADJsonConfig(configCategories);
        }
    }
}
