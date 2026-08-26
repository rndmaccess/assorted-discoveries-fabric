package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.util.SoilSlabUtil;

@Mixin(BambooStalkBlock.class)
public abstract class BambooBlockMixin {
    @Inject(method = "getStateForPlacement", at = @At("HEAD"), cancellable = true)
    private void assorteddiscoveries$cancelPlacementOnBottomSlabs(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        Level level = context.getLevel();
        BlockPos soilPos = context.getClickedPos().below();
        BlockState soil = level.getBlockState(soilPos);

        if (SoilSlabUtil.isForbiddenBottomSlab(soil)) {
            cir.setReturnValue(null);
        }
    }

    @ModifyReturnValue(method = "canSurvive", at = @At("RETURN"))
    private boolean assorteddiscoveries$canSurviveOnSlabs(boolean original, BlockState state, LevelReader level, BlockPos pos) {
        if (original) {
            BlockState soil = level.getBlockState(pos.below());

            if (SoilSlabUtil.isForbiddenBottomSlab(soil)) {
                return false;
            }
        }
        return original;
    }
}