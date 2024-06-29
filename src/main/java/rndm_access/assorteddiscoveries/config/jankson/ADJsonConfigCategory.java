package rndm_access.assorteddiscoveries.config.jankson;

import java.util.*;

/**
 * Instances of this class serve as different categories within the json config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADJsonConfigCategory {
    private final String name;
    private final LinkedHashMap<String, ADJsonConfigComponentBase> components = new LinkedHashMap<>();
    private final LinkedList<String> subCategoryNames = new LinkedList<>();

    public ADJsonConfigCategory(String name) {
        this.name = name;
    }

    public void addEntry(ADJsonConfigEntry entry) {
        components.put(entry.getName(), entry);
    }

    public ADJsonSubCategory addSubCategory(ADJsonSubCategory subCategory) {
        components.put(subCategory.getName(), subCategory);
        subCategoryNames.add(subCategory.getName());
        return subCategory;
    }

    public LinkedList<String> getSubCategoryNames() {
        return subCategoryNames;
    }

    public String getName() {
        return name;
    }

    public ADJsonConfigEntry getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new RuntimeException("The category " + this.name + " does not have entry " + entryName);
        }
        return (ADJsonConfigEntry) components.get(entryName);
    }

    public ADJsonSubCategory getSubCategory(String subCategoryName) {
        if(!this.hasSubCategory(subCategoryName)) {
            throw new RuntimeException("The category " + this.name + " does not have sub category " + subCategoryName);
        }
        return (ADJsonSubCategory) components.get(subCategoryName);
    }

    public boolean hasEntry(String entryName) {
        return components.containsKey(entryName)
                && components.get(entryName) instanceof ADJsonConfigEntry;
    }

    public boolean hasSubCategory(String subCategoryName) {
        return components.containsKey(subCategoryName)
                && components.get(subCategoryName) instanceof ADJsonSubCategory;
    }

    public List<ADJsonConfigComponentBase> getComponents() {
        return components.values().stream().toList();
    }

    public List<String> getComponentNames() {
        return components.keySet().stream().toList();
    }
}
