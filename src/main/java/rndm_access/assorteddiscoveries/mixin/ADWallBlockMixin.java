package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.CBlockTags;

@Mixin(WallBlock.class)
public class ADWallBlockMixin {
    @Inject(method = "shouldConnectTo", at = @At("HEAD"), cancellable = true)
    private void assorteddiscoveries_shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side,
                                                      CallbackInfoReturnable<Boolean> cir) {
        if(state.isIn(CBlockTags.SNOW_WALLS) || state.isIn(CBlockTags.WOODEN_WALLS)) {
            cir.setReturnValue(true);
        }
    }
}
