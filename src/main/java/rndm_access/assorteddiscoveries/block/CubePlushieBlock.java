package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.EnumMap;

public class CubePlushieBlock extends PlushieBlock {
    public static final IntegerProperty STACK_SIZE = ModBlockStateProperties.STACK_SIZE;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static final VoxelShape NORTH_BOTTOM_SHAPE = Block.box(2.5D, 0.0D, 2.5D,
            13.5D, 9.5D, 13.5D);
    private static final VoxelShape NORTH_MIDDLE_SHAPE = Block.box(3.5D, 7.0D, 3.5D,
            12.5D, 16.5D, 12.5D);
    private static final VoxelShape NORTH_TOP_SHAPE = Block.box(5.5D, 0.0D, 5.5D,
            10.5D, 4.5D, 10.5D);
    private static final EnumMap<Direction, VoxelShape> BOTTOM_SHAPES
            = ShapeHelper.makeShapeRotMap(NORTH_BOTTOM_SHAPE);
    private static final EnumMap<Direction, VoxelShape> MIDDLE_SHAPES
            = ShapeHelper.makeShapeRotMap(NORTH_BOTTOM_SHAPE, NORTH_MIDDLE_SHAPE);
    private static final EnumMap<Direction, VoxelShape> TOP_SHAPES = ShapeHelper.makeShapeRotMap(NORTH_TOP_SHAPE);

    public CubePlushieBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(STACK_SIZE, 1)
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        BlockState state = level.getBlockState(pos);

        if (this.isCubePlush(state)) {
            return state.setValue(STACK_SIZE, this.getNextStackSize(state));
        }
        return super.getStateForPlacement(context);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer,
                            ItemStack itemStack) {
        BlockPos abovePos = pos.above();
        FluidState fluidState = level.getFluidState(abovePos);
        boolean isTripleStacked = state.hasProperty(STACK_SIZE) && state.getValue(STACK_SIZE) == 3;

        // Top off the stack with the final cube plush.
        if (!level.isClientSide() && isTripleStacked) {
            BlockState placedState = state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STACK_SIZE, 3)
                    .setValue(WATERLOGGED, fluidState.is(Fluids.WATER));

            level.setBlock(abovePos, placedState, Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        BlockPos abovePos = context.getClickedPos().above();
        BlockState aboveState = context.getLevel().getBlockState(abovePos);
        boolean isDoubleStacked = state.hasProperty(STACK_SIZE) && state.getValue(STACK_SIZE) == 2;
        boolean isStackWithinOneBlock = state.hasProperty(STACK_SIZE) && state.getValue(STACK_SIZE) < 2;

        return (this.isCubePlush(context) && isStackWithinOneBlock)
                || (this.isCubePlush(context) && aboveState.canBeReplaced() && isDoubleStacked);
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess tickView,
                                  BlockPos pos, Direction direction, BlockPos neighborPos,
                                  BlockState neighborState, RandomSource random) {
        if(this.canStay(state, neighborState, direction)) {
            return state;
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    private boolean canStay(BlockState state, BlockState neighborState, Direction direction) {
        boolean isUpperHalf = state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER;
        boolean isLowerHalf = state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
        boolean isTripleStacked = state.hasProperty(STACK_SIZE) && state.getValue(STACK_SIZE) == 3;

        if(isTripleStacked
                && (direction == Direction.DOWN && isUpperHalf
                || direction == Direction.UP && isLowerHalf)) {
            return this.isCubePlush(neighborState);
        } else {
            return true;
        }
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        // Return early if we are on the client side. Since items are not dropped on the client.
        if (level.isClientSide()) {
            return super.playerWillDestroy(level, pos, state, player);
        }

        boolean isUpperHalf = state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER;

        // Prevents items from being dropped when breaking a 3-tier plush in creative.
        if ((player.isCreative() || !player.hasCorrectToolForDrops(state)) && isUpperHalf) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            boolean isLowerHalf = belowState.hasProperty(HALF) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER;

            if (this.isCubePlush(belowState) && isLowerHalf) {
                BlockState newState = belowState.getValue(WATERLOGGED) ? Blocks.WATER.defaultBlockState()
                        : Blocks.AIR.defaultBlockState();

                // Replace the cube plush's lower half with either air or water.
                level.setBlock(belowPos, newState, Block.UPDATE_CLIENTS);
                level.levelEvent(player, 2001, belowPos, Block.getId(belowState));
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean isUpperHalf = state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER;

        return switch (state.getValue(STACK_SIZE)) {
            case 1 -> BOTTOM_SHAPES.get(direction);
            case 2 -> MIDDLE_SHAPES.get(direction);
            default -> (isUpperHalf
                    ? TOP_SHAPES.get(direction)
                    : MIDDLE_SHAPES.get(direction));
        };
    }

    private boolean isCubePlush(BlockPlaceContext context) {
        return context.getItemInHand().is(this.asItem());
    }

    private boolean isCubePlush(BlockState state) {
        return state.is(this);
    }

    private int getNextStackSize(BlockState state) {
        return Math.min(3, state.getValue(STACK_SIZE) + 1);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STACK_SIZE, HALF);
    }
}
