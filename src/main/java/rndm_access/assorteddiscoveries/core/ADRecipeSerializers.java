package rndm_access.assorteddiscoveries.core;

import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.item.crafting.ADWoodcuttingRecipe;

public class ADRecipeSerializers {
    public static final RecipeSerializer<ADWoodcuttingRecipe> WOODCUTTING = new ADWoodcuttingRecipe.Serializer<>(ADWoodcuttingRecipe::new);

    public static void registerRecipeSerializers() {
        registerRecipeSerializer("woodcutting", WOODCUTTING);

        AssortedDiscoveries.LOGGER.info("Registered recipe serializers");
    }

    /**
     * Called during mod initialization to register every recipe serializer.
     */
    private static <T extends Recipe<Inventory>> void registerRecipeSerializer(String id, RecipeSerializer<T> serializer) {
        Registry.register(Registries.RECIPE_SERIALIZER, ADReference.makeModId(id), serializer);
    }
}
