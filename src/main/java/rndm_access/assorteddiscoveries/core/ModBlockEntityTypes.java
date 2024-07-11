package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block_entity.DyedCampfireBlockEntity;

public class ModBlockEntityTypes {
    public static final BlockEntityType<DyedCampfireBlockEntity> DYED_CAMPFIRE;

    private static <T extends BlockEntity> void register(String path, BlockEntityType<T> type) {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, ADReference.makeModId(path), type);
    }

    /**
     * Called during mod initialization to register every block entity type.
     */
    public static void registerBlockEntityTypes() {
        register("dyed_campfire", DYED_CAMPFIRE);

        AssortedDiscoveries.LOGGER.info("Registered block entity types");
    }

    static {
        DYED_CAMPFIRE = BlockEntityType.Builder.create(DyedCampfireBlockEntity::new,
                ModBlocks.WHITE_CAMPFIRE, ModBlocks.ORANGE_CAMPFIRE, ModBlocks.MAGENTA_CAMPFIRE,
                ModBlocks.LIGHT_BLUE_CAMPFIRE, ModBlocks.YELLOW_CAMPFIRE,
                ModBlocks.LIME_CAMPFIRE, ModBlocks.PINK_CAMPFIRE, ModBlocks.GRAY_CAMPFIRE,
                ModBlocks.LIGHT_GRAY_CAMPFIRE, ModBlocks.CYAN_CAMPFIRE,
                ModBlocks.PURPLE_CAMPFIRE, ModBlocks.BLUE_CAMPFIRE, ModBlocks.BROWN_CAMPFIRE,
                ModBlocks.GREEN_CAMPFIRE, ModBlocks.RED_CAMPFIRE, ModBlocks.BLACK_CAMPFIRE,
                ModBlocks.MAROON_CAMPFIRE).build();
    }
}
