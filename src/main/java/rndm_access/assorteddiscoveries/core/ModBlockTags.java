package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import rndm_access.assorteddiscoveries.ADReference;

public class ModBlockTags {
    public static final TagKey<Block> OVERWORLD_PLANTER_BOXES;
    public static final TagKey<Block> NETHER_PLANTER_BOXES;

    /**
     * @param path The name of the tag.
     * @return The tag from the location or an empty tag if none exists.
     */
    private static TagKey<Block> of(String path) {
        return TagKey.of(RegistryKeys.BLOCK, ADReference.makeModId(path));
    }

    static {
        OVERWORLD_PLANTER_BOXES = of("overworld_planter_boxes");
        NETHER_PLANTER_BOXES = of("nether_planter_boxes");
    }
}
