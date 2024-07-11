package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import rndm_access.assorteddiscoveries.ADReference;

public class ADBlockTags {
    public static final TagKey<Block> CROPS_PLANTABLE_ON;
    public static final TagKey<Block> FUNGUS_PLANTABLE_ON;
    public static final TagKey<Block> NETHER_WART_PLANTABLE_ON;
    public static final TagKey<Block> ROOTS_PLANTABLE_ON;
    public static final TagKey<Block> SPROUTS_PLANTABLE_ON;
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
        CROPS_PLANTABLE_ON = of("crops_plantable_on");
        FUNGUS_PLANTABLE_ON = of("fungus_plantable_on");
        NETHER_WART_PLANTABLE_ON = of("nether_wart_plantable_on");
        ROOTS_PLANTABLE_ON = of("roots_plantable_on");
        SPROUTS_PLANTABLE_ON = of("sprouts_plantable_on");
        OVERWORLD_PLANTER_BOXES = of("overworld_planter_boxes");
        NETHER_PLANTER_BOXES = of("nether_planter_boxes");
    }
}
