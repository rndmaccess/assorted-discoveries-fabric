package rndm_access.assorteddiscoveries.config.jankson;

import java.util.*;

/**
 * Instances of this class serve as different categories within the json config file.
 * This class is designed to be used directly with the cloth config library.
 *
 * @author rndm_access
 */
public class ADJsonConfigCategory extends ADJsonConfigComponentBase {
    private final LinkedHashMap<String, ADJsonConfigComponentBase> components = new LinkedHashMap<>();
    private final LinkedList<String> subCategoryNames = new LinkedList<>();

    public ADJsonConfigCategory(String name) {
        super(name);
    }

    public void addEntry(ADJsonConfigEntry entry) {
        components.put(entry.getName(), entry);
    }

    public ADJsonConfigCategory addSubCategory(ADJsonConfigCategory subCategory) {
        components.put(subCategory.getName(), subCategory);
        subCategoryNames.add(subCategory.getName());
        return subCategory;
    }

    public LinkedList<String> getSubCategoryNames() {
        return subCategoryNames;
    }

    public ADJsonConfigEntry getEntry(String entryName) {
        if(!this.hasEntry(entryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have entry " + entryName);
        }
        return (ADJsonConfigEntry) components.get(entryName);
    }

    public ADJsonConfigCategory getSubCategory(String subCategoryName) {
        if(!this.hasSubCategory(subCategoryName)) {
            throw new RuntimeException("The category " + this.getName() + " does not have sub category " + subCategoryName);
        }
        return (ADJsonConfigCategory) components.get(subCategoryName);
    }

    public boolean hasEntry(String entryName) {
        return components.containsKey(entryName)
                && components.get(entryName) instanceof ADJsonConfigEntry;
    }

    public boolean hasSubCategory(String subCategoryName) {
        return components.containsKey(subCategoryName)
                && components.get(subCategoryName) instanceof ADJsonConfigCategory;
    }

    public List<ADJsonConfigComponentBase> getComponents() {
        return components.values().stream().toList();
    }

    public List<String> getComponentNames() {
        return components.keySet().stream().toList();
    }
}
