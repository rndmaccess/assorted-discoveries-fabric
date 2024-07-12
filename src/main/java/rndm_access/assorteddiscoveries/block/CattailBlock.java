package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CattailBlock extends TallPlantBlock implements Fertilizable {
    public static final MapCodec<CattailBlock> CODEC;
    public static final BooleanProperty WATERLOGGED;

    public CattailBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(HALF, DoubleBlockHalf.LOWER)
                .with(WATERLOGGED, false));
    }

    @Override
    public MapCodec<CattailBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floorState, BlockView world, BlockPos floorPos) {
        return floorState.isSideSolidFullSquare(world, floorPos, Direction.UP)
                && !floorState.isOf(Blocks.MAGMA_BLOCK);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        return blockPos.getY() < world.getTopY() - 1 && world.getBlockState(blockPos.up()).canReplace(ctx)
                ? this.getDefaultState().with(WATERLOGGED, world.isWater(blockPos)) : null;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        // Break the other half when the top is broken and drop an item.
        if(!world.isClient() && isUpperHalf(state) && !player.isCreative()) {
            BlockPos bottomPos = pos.down();
            BlockState bottomState = world.getBlockState(bottomPos);
            BlockState newState = bottomState.getFluidState().isOf(Fluids.WATER) ? Blocks.WATER.getDefaultState()
                    : Blocks.AIR.getDefaultState();

            dropStacks(bottomState, world, bottomPos, null, player, player.getMainHandStack());
            world.setBlockState(bottomPos, newState, 3);
            world.syncWorldEvent(player, 2001, bottomPos, Block.getRawIdFromState(bottomState));
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos topPos = pos.up();
        BlockPos floorPos = pos.down();
        BlockState topState = world.getBlockState(topPos);
        FluidState topFluidState = world.getFluidState(topPos);

        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            return state.isReplaceable() && super.canPlaceAt(state, world, pos);
        }

        return ((this.isWaterAdjacent(world, floorPos) && topState.isReplaceable() && topFluidState.isEmpty())
                || (this.hasRootsInWater(world, pos) && topState.isReplaceable() && topFluidState.isEmpty())
                && super.canPlaceAt(state, world, pos));
    }

    private boolean hasRootsInWater(WorldView world, BlockPos bottomPos) {
        return world.isWater(bottomPos);
    }

    private boolean isWaterAdjacent(WorldView world, BlockPos floorPos) {
        for(Direction direction : Direction.values()) {
            if(direction.getAxis().isHorizontal()) {
                BlockPos adjacentPos = floorPos.offset(direction);

                if(world.isWater(adjacentPos)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if(this.canStay(state, neighborState, direction, world, pos)) {
            return state;
        }
        return Blocks.AIR.getDefaultState();
    }

    private boolean canStay(BlockState state, BlockState neighborState, Direction direction,
                            WorldAccess world, BlockPos pos) {
        // Break the other half when the bottom is broken.
        // We don't check the top here so tall plants can be replaced!
        if(direction == Direction.DOWN && isUpperHalf(state)) {
            return neighborState.isOf(state.getBlock());
        } else {
            BlockPos floorPos = pos.down();
            BlockState floorState = world.getBlockState(floorPos);

            if(isLowerHalf(state)) {
                return canPlantOnTop(floorState, world, floorPos) && isWaterAdjacent(world, floorPos)
                        || canPlantOnTop(floorState, world, floorPos) && hasRootsInWater(world, pos);
            }
            return true;
        }
    }

    private boolean isUpperHalf(BlockState state) {
        return Objects.equals(state.get(HALF), DoubleBlockHalf.UPPER);
    }

    private boolean isLowerHalf(BlockState state) {
        return Objects.equals(state.get(HALF), DoubleBlockHalf.LOWER);
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, HALF);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        dropStack(world, pos, new ItemStack(this));
    }

    static {
        CODEC = createCodec(CattailBlock::new);
        WATERLOGGED = Properties.WATERLOGGED;
    }
}
