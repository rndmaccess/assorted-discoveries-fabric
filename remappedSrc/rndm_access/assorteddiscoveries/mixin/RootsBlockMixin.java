package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(RootsBlock.class)
public abstract class RootsBlockMixin {
    @Inject(method = "mayPlaceOn", at = @At("HEAD"), cancellable = true)
    private void canPlantOnTop(BlockState floor, BlockGetter world,
                               BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if(floor.is(ModBlockTags.NETHER_PLANTER_BOXES)) {
            info.setReturnValue(true);
        }
    }
}
