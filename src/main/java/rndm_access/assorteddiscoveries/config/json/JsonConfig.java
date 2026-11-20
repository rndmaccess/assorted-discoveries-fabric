package rndm_access.assorteddiscoveries.config.json;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.config.ModConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigEntry;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonConfig {
    private final List<String> globalComments;
    private final List<ModConfigCategory> categories;
    private final Path path;
    private final String name;

    public JsonConfig(String name) {
        this.globalComments = new ArrayList<>();
        this.name = name;
        this.path = FabricLoader.getInstance().getConfigDir().resolve(name + ".json5");
        this.categories = List.of(ModConfigCategory.values());
    }

    public List<String> getGlobalComments() {
        return globalComments;
    }

    public void addGlobalComment(String comment) {
        globalComments.add(comment);
    }

    public Path getPath() {
        return this.path;
    }

    public String getName() {
        return name;
    }

    public List<ModConfigCategory> getCategories() {
        return categories;
    }

    public ModConfigCategory getCategory(String key) {
        for (ModConfigCategory category : categories) {
            if (category.getCategoryName().equals(key)) {
                return category;
            }
        }
        return null;
    }

    public JsonConfigEntry<?> getEntry(String key) {
        for (ModConfigCategory category : categories) {
            if (category.hasEntry(key)) {
                return category.getEntry(key);
            }
        }
        return null;
    }
}
