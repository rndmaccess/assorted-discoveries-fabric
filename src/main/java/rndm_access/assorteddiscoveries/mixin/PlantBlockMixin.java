package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(VegetationBlock.class)
public abstract class PlantBlockMixin {
    @ModifyReturnValue(method = "mayPlaceOn", at = @At("RETURN"))
    private boolean mayPlaceOn(boolean original, BlockState state, BlockGetter level, BlockPos pos) {
        if(canSupportPlant(state)) {
            return false;
        }
        return original;
    }

    @Unique
    private static boolean canSupportPlant(BlockState soil) {
        // If slabbed is installed we should allow placing plants on dirt slabs!
        return !FabricLoader.getInstance().isModLoaded("slabbed")
                && soil.is(ModBlockTags.SOIL_SLABS)
                && soil.hasProperty(SlabBlock.TYPE)
                && soil.getValue(SlabBlock.TYPE) == SlabType.BOTTOM;
    }
}