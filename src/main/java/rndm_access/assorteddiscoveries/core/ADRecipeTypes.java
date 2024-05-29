package rndm_access.assorteddiscoveries.core;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.item.crafting.ADWoodcuttingRecipe;

public class ADRecipeTypes {
    public static final RecipeType<ADWoodcuttingRecipe> WOODCUTTING = registerRecipeType("woodcutting");

    public static void registerRecipeTypes() {
        AssortedDiscoveries.LOGGER.info("Registered recipe types.");
    }

    private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(String path) {
        return Registry.register(Registries.RECIPE_TYPE, ADReference.makeModId(path), new RecipeType<T>() {
            public String toString() {
                return ADReference.makeModId(path).toString();
            }
        });
    }
}