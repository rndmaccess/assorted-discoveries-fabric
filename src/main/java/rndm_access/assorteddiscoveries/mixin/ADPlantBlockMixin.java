package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ADBlockTags;

@Mixin(PlantBlock.class)
public class ADPlantBlockMixin {
    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void assorteddiscoveries_canPlantOnTop(BlockState floor, BlockView world, BlockPos pos,
                                                   CallbackInfoReturnable<Boolean> info) {
        if(floor.isIn(ADBlockTags.OVERWORLD_PLANTER_BOXES)) {
            info.setReturnValue(true);
        }
    }
}