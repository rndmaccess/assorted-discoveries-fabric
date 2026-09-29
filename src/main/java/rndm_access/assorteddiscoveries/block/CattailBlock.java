package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class CattailBlock extends DoublePlantBlock implements BonemealableBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CattailBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected boolean mayPlaceOn(BlockState floorState, BlockGetter blockGetter, BlockPos floorPos) {
        return floorState.isFaceSturdy(blockGetter, floorPos, Direction.UP)
                && !floorState.is(Blocks.MAGMA_BLOCK);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockPos blockPos = ctx.getClickedPos();
        Level world = ctx.getLevel();
        return world.getBlockState(blockPos.above()).canBeReplaced(ctx)
                ? this.defaultBlockState().setValue(WATERLOGGED, world.isWaterAt(blockPos))
                : null;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        boolean isUpperHalf = state.getValue(HALF) == DoubleBlockHalf.UPPER;

        // Break the other half when the top is broken and drop an item.
        if(!level.isClientSide() && isUpperHalf && !player.isCreative()) {
            BlockPos bottomHalfPos = pos.below();
            BlockState bottomState = level.getBlockState(bottomHalfPos);
            BlockState newState = bottomState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState()
                    : Blocks.AIR.defaultBlockState();

            dropResources(bottomState, level, bottomHalfPos, null, player, player.getMainHandItem());
            level.setBlock(bottomHalfPos, newState, Block.UPDATE_CLIENTS);
            level.levelEvent(player, 2001, bottomHalfPos, Block.getId(bottomState));
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos upperPos = pos.above();
        BlockPos floorPos = pos.below();
        BlockState upperState = levelReader.getBlockState(upperPos);
        FluidState upperFluidState = levelReader.getFluidState(upperPos);
        boolean hasRootsInWater = levelReader.isWaterAt(pos);
        boolean isUpperHalf = state.getValue(HALF) == DoubleBlockHalf.UPPER;

        if (isUpperHalf) {
            return state.canBeReplaced() && super.canSurvive(state, levelReader, pos);
        }

        return ((this.isWaterAdjacent(levelReader, floorPos) && upperState.canBeReplaced() && upperFluidState.isEmpty())
                || (hasRootsInWater && upperState.canBeReplaced() && upperFluidState.isEmpty())
                && super.canSurvive(state, levelReader, pos));
    }

    private boolean isWaterAdjacent(LevelReader levelReader, BlockPos floorPos) {
        for(Direction direction : Direction.values()) {
            if(direction.getAxis().isHorizontal()) {
                BlockPos adjacentPos = floorPos.relative(direction);

                if(levelReader.isWaterAt(adjacentPos)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess tickView,
                                  BlockPos pos, Direction direction, BlockPos neighborPos,
                                  BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        if(this.canStay(state, neighborState, direction, levelReader, pos)) {
            return state;
        }
        return Blocks.AIR.defaultBlockState();
    }

    private boolean canStay(BlockState state, BlockState neighborState, Direction direction,
                            LevelReader levelReader, BlockPos pos) {
        boolean isUpperHalf = state.getValue(HALF) == DoubleBlockHalf.UPPER;
        boolean isLowerHalf = state.getValue(HALF) == DoubleBlockHalf.LOWER;
        boolean hasRootsInWater = levelReader.isWaterAt(pos);

        // Break the other half when the bottom is broken.
        // We don't check the top here so tall plants can be replaced!
        if(direction == Direction.DOWN && isUpperHalf) {
            return neighborState.is(state.getBlock());
        } else {
            BlockPos soilPos = pos.below();
            BlockState soilState = levelReader.getBlockState(soilPos);

            if(isLowerHalf) {
                return mayPlaceOn(soilState, levelReader, soilPos) && isWaterAdjacent(levelReader, soilPos)
                        || mayPlaceOn(soilState, levelReader, soilPos) && hasRootsInWater;
            }
            return true;
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, HALF);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        popResource(level, pos, new ItemStack(this));
    }
}
