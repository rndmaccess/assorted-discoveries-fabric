package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ADCattailBlock extends TallFlowerBlock {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public ADCattailBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(WATERLOGGED, false));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP) && !floor.isOf(Blocks.MAGMA_BLOCK);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        World world = ctx.getWorld();
        boolean isWater = world.getFluidState(pos).isOf(Fluids.WATER);

        return Objects.requireNonNull(super.getPlacementState(ctx)).with(WATERLOGGED, isWater);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos topPos = pos.up();

        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return this.isEmpty(world, pos) && super.canPlaceAt(state, world, pos);
        }
        return ((this.isWaterAdjacent(world, pos) && this.isEmpty(world, topPos))
                || (world.isWater(pos) && this.isEmpty(world, topPos)))
                && super.canPlaceAt(state, world, pos);
    }

    private boolean isEmpty(WorldView world, BlockPos pos) {
        return world.getFluidState(pos).isEmpty();
    }

    private boolean isWaterAdjacent(WorldView world, BlockPos pos) {
        BlockPos groundPos = pos.down();
        boolean isWaterNorth = world.getFluidState(groundPos.north()).isOf(Fluids.WATER);
        boolean isWaterSouth = world.getFluidState(groundPos.south()).isOf(Fluids.WATER);
        boolean isWaterWest = world.getFluidState(groundPos.west()).isOf(Fluids.WATER);
        boolean isWaterEast = world.getFluidState(groundPos.east()).isOf(Fluids.WATER);

        return isWaterNorth || isWaterSouth || isWaterWest || isWaterEast;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, HALF);
    }
}
