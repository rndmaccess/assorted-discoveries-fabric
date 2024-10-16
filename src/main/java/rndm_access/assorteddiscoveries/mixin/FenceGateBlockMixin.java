package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.CommonBlockTags;

@Mixin(FenceGateBlock.class)
public abstract class FenceGateBlockMixin {

    @Inject(method = "isWall", at = @At("HEAD"), cancellable = true)
    private void isWall(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if(state.isIn(CommonBlockTags.SNOW_WALLS) || state.isIn(CommonBlockTags.WOODEN_WALLS)) {
            cir.setReturnValue(true);
        }
    }
}
