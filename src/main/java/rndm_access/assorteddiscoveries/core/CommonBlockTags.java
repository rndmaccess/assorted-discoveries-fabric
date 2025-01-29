package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import rndm_access.assorteddiscoveries.ADReference;

public final class CommonBlockTags {
    public static final TagKey<Block> SNOW_SLABS;
    public static final TagKey<Block> SNOW_STAIRS;
    public static final TagKey<Block> SNOW_WALLS;
    public static final TagKey<Block> WOODEN_WALLS;

    /**
     * @param path The name of the tag.
     * @return The tag from the location or an empty tag if none exists.
     */
    private static TagKey<Block> of(String path) {
        return TagKey.of(RegistryKeys.BLOCK, ADReference.makeCommonId(path));
    }

    static {
        SNOW_SLABS = of("snow_slabs");
        SNOW_STAIRS = of("snow_stairs");
        SNOW_WALLS = of("snow_walls");
        WOODEN_WALLS = of("wooden_walls");
    }
}
