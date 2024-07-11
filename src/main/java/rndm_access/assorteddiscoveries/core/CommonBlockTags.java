package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import rndm_access.assorteddiscoveries.ADReference;

public class CommonBlockTags {
    public static final TagKey<Block> END_BONE_MEALABLE_BLOCKS;
    public static final TagKey<Block> SNAPDRAGON_PLANTABLE_ON;
    public static final TagKey<Block> ENDER_GRASS_PLANTABLE_ON;
    public static final TagKey<Block> CINDERSNAP_BERRY_BUSH_PLANTABLE_ON;
    public static final TagKey<Block> FROSTBITE_BERRY_BUSH_PLANTABLE_ON;
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
        END_BONE_MEALABLE_BLOCKS = of("end_bone_mealable_blocks");
        SNAPDRAGON_PLANTABLE_ON = of("snapdragon_plantable_on");
        ENDER_GRASS_PLANTABLE_ON = of("ender_grass_plantable_on");
        CINDERSNAP_BERRY_BUSH_PLANTABLE_ON = of("cindersnap_berry_bush_plantable_on");
        FROSTBITE_BERRY_BUSH_PLANTABLE_ON = of("frostbite_berry_bush_plantable_on");
        SNOW_SLABS = of("snow_slabs");
        SNOW_STAIRS = of("snow_stairs");
        SNOW_WALLS = of("snow_walls");
        WOODEN_WALLS = of("wooden_walls");
    }
}
