package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(FungusBlock.class)
public abstract class FungusBlockMixin {
    @Inject(method = "mayPlaceOn", at = @At("HEAD"), cancellable = true)
    private void mayPlaceOn(BlockState floor, BlockGetter world,
                            BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if(floor.is(ModBlockTags.NETHER_PLANTER_BOXES)) {
            info.setReturnValue(true);
        }
    }
}
