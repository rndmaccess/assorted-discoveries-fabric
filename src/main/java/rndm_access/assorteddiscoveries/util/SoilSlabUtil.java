package rndm_access.assorteddiscoveries.util;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

public class SoilSlabUtil {
    public static boolean isForbiddenBottomSlab(BlockState soil) {
        // If slabbed is installed we should allow placing plants on dirt slabs!
        return !FabricLoader.getInstance().isModLoaded("slabbed")
                && soil.is(ModBlockTags.SOIL_SLABS)
                && soil.hasProperty(SlabBlock.TYPE)
                && soil.getValue(SlabBlock.TYPE) == SlabType.BOTTOM;
    }
}
