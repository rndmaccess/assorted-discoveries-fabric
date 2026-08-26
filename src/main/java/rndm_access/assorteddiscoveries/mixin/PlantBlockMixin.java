package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.util.SoilSlabUtil;

@Mixin(VegetationBlock.class)
public abstract class PlantBlockMixin {
    @ModifyReturnValue(method = "mayPlaceOn", at = @At("RETURN"))
    private boolean assorteddiscoveries$mayPlaceOnSlabs(boolean original, BlockState state, BlockGetter level, BlockPos pos) {
        if(SoilSlabUtil.isForbiddenBottomSlab(state)) {
            return false;
        }
        return original;
    }
}