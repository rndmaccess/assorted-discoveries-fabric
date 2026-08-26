package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.util.SoilSlabUtil;

@Mixin(MushroomBlock.class)
public abstract class MushroomBlockMixin {
    @ModifyReturnValue(method = "canSurvive", at = @At("RETURN"))
    private boolean assorteddiscoveries$canSurviveOnSlabs(boolean original, final BlockState state, final LevelReader level, final BlockPos pos) {
        // Only run our logic if Minecraft already thinks the mushroom CAN survive here
        if (original) {
            BlockPos belowPos = pos.below();
            BlockState below = level.getBlockState(belowPos);

            if(SoilSlabUtil.isForbiddenBottomSlab(below)) {
                return false;
            }
        }
        return original;
    }
}