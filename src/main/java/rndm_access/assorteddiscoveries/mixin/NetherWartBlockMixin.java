package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(NetherWartBlock.class)
public abstract class NetherWartBlockMixin {
    @ModifyReturnValue(method = "mayPlaceOn", at = @At("RETURN"))
    private boolean mayPlaceOn(boolean original, BlockState floor, BlockGetter world) {
        if(floor.is(ModBlockTags.NETHER_PLANTER_BOXES)) {
            return true;
        }
        return original;
    }
}
