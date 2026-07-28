package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.SnowyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.block.SnowySlabBlock;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(SnowyBlock.class)
public abstract class SnowyBlockMixin {
    @ModifyReturnValue(method = "updateShape", at = @At("RETURN"))
    private BlockState getStateForNeighborUpdate(BlockState original, BlockState state, LevelReader level,
                                                 ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour,
                                                 BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if(directionToNeighbour == Direction.UP && isSnowCovered(level, neighbourPos, neighbourState)) {
            return original.setValue(SnowyBlock.SNOWY, true);
        }
        return original;
    }

    @ModifyReturnValue(method = "getStateForPlacement", at = @At("RETURN"))
    private BlockState getPlacementState(BlockState original, BlockPlaceContext context) {
        Level world = context.getLevel();
        BlockPos neighborPos = context.getClickedPos().above();
        BlockState neighborState = context.getLevel().getBlockState(neighborPos);

        if(isSnowCovered(world, neighborPos, neighborState)) {
            return original.setValue(SnowyBlock.SNOWY, true);
        }
        return original;
    }

    @Unique
    private static boolean isSnowCovered(LevelReader world, BlockPos neighborPos, BlockState neighborState) {
        boolean isSnowyStairs = neighborState.is(ModBlockTags.SNOW_STAIRS)
                && isCovered(world, neighborPos, neighborState);
        boolean isSnowySlab = neighborState.is(ModBlockTags.SNOW_SLABS)
                && neighborState.hasProperty(SnowySlabBlock.TYPE)
                && neighborState.getValue(SnowySlabBlock.TYPE) != SlabType.TOP
                && isCovered(world, neighborPos, neighborState);

        return isSnowyStairs || isSnowySlab;
    }

    @Unique
    private static boolean isCovered(LevelReader world, BlockPos neighborPos, BlockState neighborState) {
        return neighborState.isFaceSturdy(world, neighborPos, Direction.DOWN);
    }
}
