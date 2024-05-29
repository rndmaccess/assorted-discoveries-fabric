package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.CBlockTags;

@Mixin(FenceGateBlock.class)
public class ADFenceGateBlockMixin {

    @Inject(method = "isWall", at = @At("HEAD"), cancellable = true)
    private void assorteddiscoveries_isWall(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if(state.isIn(CBlockTags.SNOW_WALLS) || state.isIn(CBlockTags.WOODEN_WALLS)) {
            cir.setReturnValue(true);
        }
    }
}
