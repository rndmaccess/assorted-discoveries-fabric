package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(FungusBlock.class)
public abstract class FungusBlockMixin {
    @ModifyReturnValue(method = "mayPlaceOn", at = @At("RETURN"))
    private boolean assorteddiscoveries$mayPlaceOnPlanterBox(boolean original, BlockState floor, BlockGetter world) {
        if(floor.is(ModBlockTags.NETHER_PLANTER_BOXES)) {
            return true;
        }
        return original;
    }
}
