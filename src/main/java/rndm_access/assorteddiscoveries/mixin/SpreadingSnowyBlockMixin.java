package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpreadingSnowyBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(SpreadingSnowyBlock.class)
public abstract class SpreadingSnowyBlockMixin {
    @Inject(method = "canStayAlive", at = @At("HEAD"), cancellable = true)
    private static void canStayAlive(BlockState state, LevelReader level, BlockPos pos,
                                     CallbackInfoReturnable<Boolean> info) {
        BlockState blockState = level.getBlockState(pos.above());

        if(blockState.is(BlockTags.SNOW) || blockState.is(ModBlockTags.SNOW_SLABS)
                || blockState.is(ModBlockTags.SNOW_STAIRS)) {
            info.setReturnValue(true);
        }
    }


}
