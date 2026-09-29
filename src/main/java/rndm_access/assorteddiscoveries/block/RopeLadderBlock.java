package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;

public class RopeLadderBlock extends LadderBlock {
    public static final IntegerProperty LENGTH = ModBlockStateProperties.LENGTH;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    public RopeLadderBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false).setValue(LENGTH, 0).setValue(DOWN, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = level.getFluidState(pos);
        BlockState placedState = this.defaultBlockState().setValue(WATERLOGGED, this.isWaterSource(fluidState))
                .setValue(DOWN, this.isEnd(level, pos));

        if (this.hasSupport(level, pos)) {
            return this.placeHangingLadder(level, pos, placedState);
        } else {
            return this.placeLadder(context, placedState);
        }
    }

    private BlockState placeHangingLadder(Level level, BlockPos pos, BlockState placedState) {
        BlockState stateAboveLadder = level.getBlockState(pos.above());
        Direction facing = stateAboveLadder.getValue(FACING);
        int length = this.getNextLength(level, pos);

        if (length <= this.getMaxLength()) {
            if (!this.hasSupportingBlock(level, facing, pos)) {
                return placedState.setValue(LENGTH, length).setValue(FACING, facing);
            }
            return placedState.setValue(FACING, facing);
        }
        return null;
    }

    private BlockState placeLadder(BlockPlaceContext blockPlaceContext, BlockState placedState) {
        for (Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                return placedState.setValue(FACING, direction.getOpposite());
            }
        }
        return null;
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess tickView,
                                  BlockPos pos, Direction direction, BlockPos neighborPos,
                                  BlockState neighborState, RandomSource random) {
        Direction facing = state.getValue(FACING);
        BlockState stateAbove = levelReader.getBlockState(pos.above());

        if (canSurvive(state, levelReader, pos)) {
            if (state.getValue(WATERLOGGED)) {
                tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
            }

            // Set the ladder's length to 0 when a block is placed behind it.
            if (this.hasSupportingBlock(levelReader, facing, pos)) {
                return state.setValue(LENGTH, 0).setValue(DOWN, this.isEnd(levelReader, pos));
            }

            // Update each ladders length after the new support block to keep each ladder's length consistent.
            if (this.isRopeLadder(stateAbove)) {
                return state.setValue(LENGTH, this.getNextLength(levelReader, pos)).setValue(DOWN, this.isEnd(levelReader, pos));
            }
        }
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockState stateAboveLadder = levelReader.getBlockState(pos.above());

        if (this.isRopeLadder(stateAboveLadder)) {
            int length = this.getNextLength(levelReader, pos);
            return length <= this.getMaxLength();
        }
        return this.hasSupportingBlock(levelReader, facing, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LENGTH, DOWN, FACING, WATERLOGGED);
    }

    private boolean hasSupportingBlock(LevelReader levelReader, Direction facing, BlockPos pos) {
        BlockPos posBehindLadder = pos.relative(facing.getOpposite());
        BlockState stateBehindLadder = levelReader.getBlockState(posBehindLadder);

        return stateBehindLadder.isFaceSturdy(levelReader, posBehindLadder, facing);
    }

    private boolean isEnd(LevelReader levelReader, BlockPos pos) {
        BlockState stateBelowLadder = levelReader.getBlockState(pos.below());

        return this.isRopeLadder(stateBelowLadder);
    }

    private int getMaxLength() {
        return 16;
    }

    private int getNextLength(LevelReader levelReader, BlockPos pos) {
        BlockState stateAboveLadder = levelReader.getBlockState(pos.above());
        return stateAboveLadder.getValue(LENGTH) + 1;
    }

    private boolean isRopeLadder(BlockState state) {
        return state.is(this);
    }

    private boolean hasSupport(Level level, BlockPos pos) {
        return this.isRopeLadder(level.getBlockState(pos.above()));
    }

    private boolean isWaterSource(FluidState fluidState) {
        return fluidState.is(FluidTags.WATER) && fluidState.isSource();
    }
}
