package rndm_access.assorteddiscoveries.core;

import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.item.crafting.WoodcuttingRecipe;

public class ModRecipeSerializers {
    public static final RecipeSerializer<WoodcuttingRecipe> WOODCUTTING;

    public static void registerRecipeSerializers() {
        register("woodcutting", WOODCUTTING);

        AssortedDiscoveries.LOGGER.info("Registered recipe serializers");
    }

    /**
     * Called during mod initialization to register every recipe serializer.
     */
    private static <T extends Recipe<Inventory>> void register(String id, RecipeSerializer<T> serializer) {
        Registry.register(Registries.RECIPE_SERIALIZER, ADReference.makeModId(id), serializer);
    }

    static {
        WOODCUTTING = new WoodcuttingRecipe.Serializer<>(WoodcuttingRecipe::new);
    }
}
