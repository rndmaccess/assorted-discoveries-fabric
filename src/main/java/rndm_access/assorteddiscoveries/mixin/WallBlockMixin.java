package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(WallBlock.class)
public abstract class WallBlockMixin {
    @Inject(method = "connectsTo", at = @At("HEAD"), cancellable = true)
    private void connectTo(BlockState state, boolean faceSolid, Direction direction,
                                 CallbackInfoReturnable<Boolean> cir) {
        if(state.is(ModBlockTags.SNOW_WALLS) || state.is(ModBlockTags.WOODEN_WALLS)) {
            cir.setReturnValue(true);
        }
    }
}
