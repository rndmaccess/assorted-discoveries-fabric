package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SproutsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(SproutsBlock.class)
public abstract class SproutsBlockMixin {
    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void canPlantOnTop(BlockState floor, BlockView world,
                               BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if(floor.isIn(ModBlockTags.NETHER_PLANTER_BOXES)) {
            info.setReturnValue(true);
        }
    }
}
