package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowyBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(SnowyBlock.class)
public abstract class SnowyBlockMixin {
    @Inject(method = "getStateForNeighborUpdate", at = @At("HEAD"), cancellable = true)
    private void getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos,
                                           Direction direction, BlockPos neighborPos, BlockState neighborState,
                                           Random random, CallbackInfoReturnable<BlockState> cir) {
        if(direction == Direction.UP && this.isSnowSlabOrStairs(world, neighborPos, neighborState)) {
            cir.setReturnValue(state.with(SnowyBlock.SNOWY, true));
        }
    }

    @Inject(method = "getPlacementState", at = @At("HEAD"), cancellable = true)
    private void getPlacementState(ItemPlacementContext context, CallbackInfoReturnable<BlockState> info) {
        World world = context.getWorld();
        BlockPos neighborPos = context.getBlockPos().up();
        BlockState neighborState = context.getWorld().getBlockState(neighborPos);
        BlockState placedState = Block.getBlockFromItem(context.getStack().getItem()).getDefaultState();

        if(this.isSnowSlabOrStairs(world, neighborPos, neighborState)) {
            info.setReturnValue(placedState.with(SnowyBlock.SNOWY, true));
        }
    }

    @Unique
    private boolean isSnowSlabOrStairs(WorldView world, BlockPos pos, BlockState state) {
        boolean isCovered = state.isSideSolidFullSquare(world, pos, Direction.DOWN);
        return (state.isIn(ModBlockTags.SNOW_STAIRS) && isCovered)
                || (state.isIn(ModBlockTags.SNOW_SLABS) && isCovered);
    }
}
