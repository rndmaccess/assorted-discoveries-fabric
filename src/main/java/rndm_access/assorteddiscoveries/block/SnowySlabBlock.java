package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class SnowySlabBlock extends SoilSlabBlock {
    public static final BooleanProperty SNOWY = BlockStateProperties.SNOWY;

    public SnowySlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SNOWY, false)
                .setValue(WATERLOGGED, false).setValue(TYPE, SlabType.BOTTOM));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess tickView,
                                     BlockPos pos, Direction direction, BlockPos neighborPos,
                                     BlockState neighborState, RandomSource random) {
        if (direction == Direction.UP) {
            boolean isSnowy = isSnowCovered(state, neighborState);
            return state.setValue(SNOWY, isSnowy);
        } else {
            return state;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level level = ctx.getLevel();
        BlockPos neighborPos = ctx.getClickedPos().above();
        BlockState neighborState = level.getBlockState(neighborPos);
        BlockState state = super.getStateForPlacement(ctx);

        return state != null ? state.setValue(SNOWY, isSnowCovered(state, neighborState)) : null;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if(!canGrowGrass(state, world, pos)) {
            world.setBlock(pos, ModBlocks.DIRT_SLAB.defaultBlockState().setValue(TYPE, state.getValue(TYPE))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED)), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED, SNOWY);
    }
}
