package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block_entity.ADDyedCampfireBlockEntity;

public class ADBlockEntityTypes {
    public static final BlockEntityType<ADDyedCampfireBlockEntity> DYED_CAMPFIRE =
            BlockEntityType.Builder.create(ADDyedCampfireBlockEntity::new,
            ADBlocks.WHITE_CAMPFIRE, ADBlocks.ORANGE_CAMPFIRE, ADBlocks.MAGENTA_CAMPFIRE,
            ADBlocks.LIGHT_BLUE_CAMPFIRE, ADBlocks.YELLOW_CAMPFIRE,
            ADBlocks.LIME_CAMPFIRE, ADBlocks.PINK_CAMPFIRE, ADBlocks.GRAY_CAMPFIRE,
            ADBlocks.LIGHT_GRAY_CAMPFIRE, ADBlocks.CYAN_CAMPFIRE,
            ADBlocks.PURPLE_CAMPFIRE, ADBlocks.BLUE_CAMPFIRE, ADBlocks.BROWN_CAMPFIRE,
            ADBlocks.GREEN_CAMPFIRE, ADBlocks.RED_CAMPFIRE, ADBlocks.BLACK_CAMPFIRE,
            ADBlocks.MAROON_CAMPFIRE).build();

    private static <T extends BlockEntity> void registerBlockEntityType(String path, BlockEntityType<T> type) {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, ADReference.makeModId(path), type);
    }

    /**
     * Called during mod initialization to register every block entity type.
     */
    public static void registerBlockEntityTypes() {
        registerBlockEntityType("dyed_campfire", DYED_CAMPFIRE);

        AssortedDiscoveries.LOGGER.info("Registered block entity types");
    }
}
