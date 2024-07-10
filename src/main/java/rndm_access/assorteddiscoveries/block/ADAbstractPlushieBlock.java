package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public abstract class ADAbstractPlushieBlock extends HorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;

    protected ADAbstractPlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected abstract MapCodec<? extends ADAbstractPlushieBlock> getCodec();

    @Override
    protected abstract void appendProperties(StateManager.Builder<Block, BlockState> builder);

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        FluidState fluidState = world.getFluidState(pos);

        for (Direction direction : context.getPlacementDirections()) {
            if (direction.getAxis().isHorizontal()) {
                return this.getDefaultState().with(FACING, direction.getOpposite())
                        .with(WATERLOGGED, fluidState.isOf(Fluids.WATER));
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction.getAxis().isHorizontal() ? state.with(FACING, state.get(FACING)) : state;
    }

    @Override
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
    }
}
