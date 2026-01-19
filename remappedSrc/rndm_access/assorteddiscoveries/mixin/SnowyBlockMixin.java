package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(SnowyDirtBlock.class)
public abstract class SnowyBlockMixin {
    @Inject(method = "updateShape", at = @At("HEAD"), cancellable = true)
    private void getStateForNeighborUpdate(BlockState state, LevelReader world, ScheduledTickAccess tickView, BlockPos pos,
                                           Direction direction, BlockPos neighborPos, BlockState neighborState,
                                           RandomSource random, CallbackInfoReturnable<BlockState> cir) {
        if(direction == Direction.UP && this.isSnowSlabOrStairs(world, neighborPos, neighborState)) {
            cir.setReturnValue(state.setValue(SnowyDirtBlock.SNOWY, true));
        }
    }

    @Inject(method = "getStateForPlacement", at = @At("HEAD"), cancellable = true)
    private void getPlacementState(BlockPlaceContext context, CallbackInfoReturnable<BlockState> info) {
        Level world = context.getLevel();
        BlockPos neighborPos = context.getClickedPos().above();
        BlockState neighborState = context.getLevel().getBlockState(neighborPos);
        BlockState placedState = Block.byItem(context.getItemInHand().getItem()).defaultBlockState();

        if(this.isSnowSlabOrStairs(world, neighborPos, neighborState)) {
            info.setReturnValue(placedState.setValue(SnowyDirtBlock.SNOWY, true));
        }
    }

    @Unique
    private boolean isSnowSlabOrStairs(LevelReader world, BlockPos pos, BlockState state) {
        boolean isCovered = state.isFaceSturdy(world, pos, Direction.DOWN);
        return (state.is(ModBlockTags.SNOW_STAIRS) && isCovered)
                || (state.is(ModBlockTags.SNOW_SLABS) && isCovered);
    }
}
