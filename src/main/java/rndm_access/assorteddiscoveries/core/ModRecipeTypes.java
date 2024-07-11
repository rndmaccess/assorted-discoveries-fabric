package rndm_access.assorteddiscoveries.core;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.item.crafting.WoodcuttingRecipe;

public class ModRecipeTypes {
    public static final RecipeType<WoodcuttingRecipe> WOODCUTTING;

    public static void registerRecipeTypes() {
        register("woodcutting", WOODCUTTING);
        AssortedDiscoveries.LOGGER.info("Registered recipe types.");
    }

    private static <T extends Recipe<?>> void register(String path, RecipeType<T> recipe) {
        Registry.register(Registries.RECIPE_TYPE, ADReference.makeModId(path), recipe);
    }

    private static <T extends Recipe<?>> RecipeType<T> makeRecipe(String path) {
        return new RecipeType<>() {
            public String toString() {
                return ADReference.makeModId(path).toString();
            }
        };
    }

    static {
        WOODCUTTING = makeRecipe("woodcutting");
    }
}