package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ADBlockTags;

@Mixin(CropBlock.class)
public abstract class ADCropBlockMixin {
    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos,
                               CallbackInfoReturnable<Boolean> info) {
        if(floor.isIn(ADBlockTags.CROPS_PLANTABLE_ON)) {
            info.setReturnValue(true);
        }
    }
}
