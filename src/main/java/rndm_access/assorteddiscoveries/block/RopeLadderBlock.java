package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;

public class RopeLadderBlock extends LadderBlock {
    public static final IntProperty LENGTH;
    public static final BooleanProperty DOWN;

    public RopeLadderBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH)
                .with(WATERLOGGED, false).with(LENGTH, 0).with(DOWN, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        FluidState fluidState = world.getFluidState(pos);
        BlockState placedState = this.getDefaultState().with(WATERLOGGED, this.isWaterSource(fluidState))
                .with(DOWN, this.isEnd(world, pos));

        if (this.hasSupport(world, pos)) {
            return this.placeHangingLadder(world, pos, placedState);
        } else {
            return this.placeLadder(context, placedState);
        }
    }

    private BlockState placeHangingLadder(World world, BlockPos pos, BlockState placedState) {
        BlockState stateAboveLadder = world.getBlockState(pos.up());
        Direction facing = stateAboveLadder.get(FACING);
        int length = this.getNextLength(world, pos);

        if (length <= this.getMaxLength()) {
            if (!this.hasSupportingBlock(world, facing, pos)) {
                return placedState.with(LENGTH, length).with(FACING, facing);
            }
            return placedState.with(FACING, facing);
        }
        return null;
    }

    private BlockState placeLadder(ItemPlacementContext context, BlockState placedState) {
        for (Direction direction : context.getPlacementDirections()) {
            if (direction.getAxis().isHorizontal()) {
                return placedState.with(FACING, direction.getOpposite());
            }
        }
        return null;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        Direction facing = state.get(FACING);
        BlockState stateAbove = world.getBlockState(pos.up());

        if (canPlaceAt(state, world, pos)) {
            if (state.get(WATERLOGGED)) {
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }

            // Set the ladder's length to 0 when a block is placed behind it.
            if (this.hasSupportingBlock(world, facing, pos)) {
                return state.with(LENGTH, 0).with(DOWN, this.isEnd(world, pos));
            }

            // Update each ladders length after the new support block to keep each ladder's length consistent.
            if (this.isRopeLadder(stateAbove)) {
                return state.with(LENGTH, this.getNextLength(world, pos)).with(DOWN, this.isEnd(world, pos));
            }
        }
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction facing = state.get(FACING);
        BlockState stateAboveLadder = world.getBlockState(pos.up());

        if (this.isRopeLadder(stateAboveLadder)) {
            int length = this.getNextLength(world, pos);
            return length <= this.getMaxLength();
        }
        return this.hasSupportingBlock(world, facing, pos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LENGTH, DOWN, FACING, WATERLOGGED);
    }

    private boolean hasSupportingBlock(WorldView world, Direction facing, BlockPos pos) {
        BlockPos posBehindLadder = pos.offset(facing.getOpposite());
        BlockState stateBehindLadder = world.getBlockState(posBehindLadder);

        return stateBehindLadder.isSideSolidFullSquare(world, posBehindLadder, facing);
    }

    private boolean isEnd(WorldAccess world, BlockPos pos) {
        BlockState stateBelowLadder = world.getBlockState(pos.down());

        return this.isRopeLadder(stateBelowLadder);
    }

    private int getMaxLength() {
        return 16;
    }

    private int getNextLength(WorldView world, BlockPos pos) {
        BlockState stateAboveLadder = world.getBlockState(pos.up());

        return stateAboveLadder.get(LENGTH) + 1;
    }

    private boolean isRopeLadder(BlockState state) {
        return state.isOf(this);
    }

    private boolean hasSupport(World world, BlockPos pos) {
        return this.isRopeLadder(world.getBlockState(pos.up()));
    }

    private boolean isWaterSource(FluidState fluidState) {
        return fluidState.isIn(FluidTags.WATER) && fluidState.isStill();
    }

    static {
        LENGTH = ModBlockStateProperties.LENGTH;
        DOWN = Properties.DOWN;
    }
}
