package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import rndm_access.assorteddiscoveries.ADReference;

public class CBlockTags {
    public static final TagKey<Block> END_BONE_MEALABLE_BLOCKS = of("end_bone_mealable_blocks");
    public static final TagKey<Block> SNAPDRAGON_PLANTABLE_ON = of("snapdragon_plantable_on");
    public static final TagKey<Block> ENDER_GRASS_PLANTABLE_ON = of("ender_grass_plantable_on");
    public static final TagKey<Block> CINDERSNAP_BERRY_BUSH_PLANTABLE_ON = of("cindersnap_berry_bush_plantable_on");
    public static final TagKey<Block> FROSTBITE_BERRY_BUSH_PLANTABLE_ON = of("frostbite_berry_bush_plantable_on");
    public static final TagKey<Block> SNOW_SLABS = of("snow_slabs");
    public static final TagKey<Block> SNOW_STAIRS = of("snow_stairs");
    public static final TagKey<Block> SNOW_WALLS = of("snow_walls");
    public static final TagKey<Block> WOODEN_WALLS = of("wooden_walls");

    /**
     * @param path The name of the tag.
     * @return The tag from the location or an empty tag if none exists.
     */
    private static TagKey<Block> of(String path) {
        return TagKey.of(RegistryKeys.BLOCK, ADReference.makeCommonId(path));
    }
}
