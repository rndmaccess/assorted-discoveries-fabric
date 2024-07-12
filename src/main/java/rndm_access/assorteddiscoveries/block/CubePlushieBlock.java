package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.HashMap;
import java.util.Objects;

public class CubePlushieBlock extends AbstractPlushieBlock {
    public static final MapCodec<CubePlushieBlock> CODEC;
    public static final IntProperty STACK_SIZE;
    public static final EnumProperty<DoubleBlockHalf> HALF;
    private static final VoxelShape NORTH_BOTTOM_SHAPE;
    private static final VoxelShape NORTH_MIDDLE_SHAPE;
    private static final VoxelShape NORTH_TOP_SHAPE;
    private static final HashMap<Direction, VoxelShape> BOTTOM_SHAPES;
    private static final HashMap<Direction, VoxelShape> MIDDLE_SHAPES;
    private static final HashMap<Direction, VoxelShape> TOP_SHAPES;

    public CubePlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(HALF, DoubleBlockHalf.LOWER)
                .with(STACK_SIZE, 1).with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<CubePlushieBlock> getCodec() {
        return CODEC;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        BlockState state = world.getBlockState(pos);

        if (this.isCubePlush(state)) {
            return state.with(STACK_SIZE, this.getNextStackSize(state));
        }
        return super.getPlacementState(context);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
                         ItemStack itemStack) {
        BlockPos abovePos = pos.up();
        FluidState fluidState = world.getFluidState(abovePos);

        // Top off the stack with the final cube plush.
        if (this.isTripleStacked(state)) {
            BlockState placedState = state.with(HALF, DoubleBlockHalf.UPPER).with(STACK_SIZE, 3)
                    .with(WATERLOGGED, fluidState.isOf(Fluids.WATER));

            world.setBlockState(abovePos, placedState, 3);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        BlockPos abovePos = context.getBlockPos().up();
        BlockState aboveState = context.getWorld().getBlockState(abovePos);

        return (this.isCubePlush(context) && this.isStackWithinOneBlock(state))
                || (this.isCubePlush(context) && aboveState.isReplaceable() && this.isDoubleStacked(state));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if(this.canStay(state, neighborState, direction)) {
            return state;
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    private boolean canStay(BlockState state, BlockState neighborState, Direction direction) {
        if(this.isTripleStacked(state) && (direction == Direction.DOWN && isUpperHalf(state)
                || direction == Direction.UP && isLowerHalf(state))) {
            return isCubePlush(neighborState);
        } else {
            return true;
        }
    }

    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        // Prevents items from being dropped when breaking a 3-tier plush in creative.
        if ((!world.isClient() && (player.isCreative() || !player.canHarvest(state))) && this.isUpperHalf(state)) {
            BlockPos belowPos = pos.down();
            BlockState belowState = world.getBlockState(belowPos);
            if (this.isCubePlush(belowState) && this.isLowerHalf(belowState)) {
                BlockState newState = belowState.get(WATERLOGGED) ? Blocks.WATER.getDefaultState()
                        : Blocks.AIR.getDefaultState();

                // Replace the cube plush's lower half with either air or water.
                world.setBlockState(belowPos, newState, 3);
                world.syncWorldEvent(player, 2001, belowPos, Block.getRawIdFromState(belowState));
            }
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        VoxelShape bottomShape = BOTTOM_SHAPES.get(direction);
        VoxelShape middleShape = MIDDLE_SHAPES.get(direction);
        VoxelShape topShape = TOP_SHAPES.get(direction);

        return switch (state.get(STACK_SIZE)) {
            case 1 -> bottomShape;
            case 2 -> middleShape;
            default -> (this.isUpperHalf(state) ? topShape : middleShape);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STACK_SIZE, HALF, WATERLOGGED, FACING);
    }

    private boolean isCubePlush(ItemPlacementContext context) {
        return context.getStack().isOf(this.asItem());
    }

    private boolean isCubePlush(BlockState state) {
        return state.isOf(this);
    }

    private boolean isStackWithinOneBlock(BlockState state) {
        return state.get(STACK_SIZE) < 2;
    }

    private boolean isDoubleStacked(BlockState state) {
        return Objects.equals(state.get(STACK_SIZE), 2);
    }

    private boolean isTripleStacked(BlockState state) {
        return Objects.equals(state.get(STACK_SIZE), 3);
    }

    private boolean isUpperHalf(BlockState state) {
        return Objects.equals(state.get(HALF), DoubleBlockHalf.UPPER);
    }

    private boolean isLowerHalf(BlockState state) {
        return Objects.equals(state.get(HALF), DoubleBlockHalf.LOWER);
    }

    private int getNextStackSize(BlockState state) {
        return Math.min(3, state.get(STACK_SIZE) + 1);
    }

    static {
        CODEC = createCodec(CubePlushieBlock::new);
        STACK_SIZE = ModBlockStateProperties.STACK_SIZE;
        HALF = Properties.DOUBLE_BLOCK_HALF;
        NORTH_BOTTOM_SHAPE = Block.createCuboidShape(2.5D, 0.0D, 2.5D, 13.5D, 9.5D,
                13.5D);
        NORTH_MIDDLE_SHAPE = Block.createCuboidShape(3.5D, 7.0D, 3.5D, 12.5D, 16.5D,
                12.5D);
        NORTH_TOP_SHAPE = Block.createCuboidShape(5.5D, 0.0D, 5.5D, 10.5D, 4.5D,
                10.5D);
        BOTTOM_SHAPES = ShapeHelper.makeShapeRotMap(NORTH_BOTTOM_SHAPE);
        MIDDLE_SHAPES = ShapeHelper.makeShapeRotMap(NORTH_BOTTOM_SHAPE, NORTH_MIDDLE_SHAPE);
        TOP_SHAPES = ShapeHelper.makeShapeRotMap(NORTH_TOP_SHAPE);
    }
}
