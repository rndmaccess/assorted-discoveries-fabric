package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(FenceGateBlock.class)
public abstract class FenceGateBlockMixin {

    @Inject(method = "isWall", at = @At("HEAD"), cancellable = true)
    private void isWall(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if(state.is(ModBlockTags.SNOW_WALLS) || state.is(ModBlockTags.WOODEN_WALLS)) {
            cir.setReturnValue(true);
        }
    }
}
