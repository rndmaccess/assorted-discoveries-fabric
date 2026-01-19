package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(SpreadingSnowyDirtBlock.class)
public abstract class SpreadableBlockMixin {
    @Inject(method = "canBeGrass", at = @At("HEAD"), cancellable = true)
    private static void canBeGrass(BlockState state, LevelReader world, BlockPos pos,
                                                       CallbackInfoReturnable<Boolean> info) {
        BlockState blockState = world.getBlockState(pos.above());

        if(blockState.is(BlockTags.SNOW) || blockState.is(ModBlockTags.SNOW_SLABS)
                || blockState.is(ModBlockTags.SNOW_STAIRS)) {
            info.setReturnValue(true);
        }
    }
}
