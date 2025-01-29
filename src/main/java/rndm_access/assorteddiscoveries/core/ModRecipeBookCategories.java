package rndm_access.assorteddiscoveries.core;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModRecipeBookCategories {
    public static final RecipeBookCategory WOODCUTTER = new RecipeBookCategory();

    public static void register() {
        register("woodcutter", WOODCUTTER);

        AssortedDiscoveries.LOGGER.info("Registered recipe book categories");
    }

    private static RecipeBookCategory register(String id, RecipeBookCategory category) {
        Identifier recipeBookId = ADReference.makeModId(id);

        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, recipeBookId, category);
    }
}
