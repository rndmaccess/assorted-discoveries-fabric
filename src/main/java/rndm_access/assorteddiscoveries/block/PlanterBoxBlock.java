package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.EnumMap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PlanterBoxBlock extends Block {
    public static final MapCodec<PlanterBoxBlock> CODEC = simpleCodec(PlanterBoxBlock::new);
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    private static final VoxelShape[] SHAPES = collectStateShapes();

    public PlanterBoxBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(NORTH, false).setValue(SOUTH, false)
                .setValue(WEST, false).setValue(EAST, false));
    }

    @Override
    protected MapCodec<PlanterBoxBlock> codec() {
        return CODEC;
    }

    /**
     * @param north The north property value.
     * @param south The south property value.
     * @param west The west property value.
     * @param east The east property value.
     * @return The index for the planter box voxel shape.
     */
    private static int getIndex(boolean north, boolean south, boolean west, boolean east) {
        int index = 0;

        // Bits mapped to N, S, E, W (in order) for this state.
        if (north) index |= 1;
        if (south) index |= 2;
        if (west) index |= 4;
        if (east) index |= 8;
        return index;
    }

    /**
     * @return An array of voxel shapes for each block state. The shapes are indexed by integers, with the first 4 bits
     * representing the state's shape. Use {@link #getIndex(boolean north, boolean south, boolean east, boolean west)}
     * to get the correct index for this array.
     */
    private static VoxelShape[] collectStateShapes() {
        VoxelShape bottomShape = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);
        VoxelShape northBorderShape = Block.box(0.0, 15.0, 13.0, 16.0, 16.0, 16.0);
        EnumMap<Direction, VoxelShape> borderShapes = ShapeHelper.makeShapeRotMap(northBorderShape);
        VoxelShape[] shapes = new VoxelShape[16]; // 2 to the power of 4 states.
        int borderNum = 4;
        int stateNum = 1 << borderNum;

        for (int i = 0; i < stateNum; i++) {
            VoxelShape tempBorderShape = Shapes.empty();

            // Resolve the booleans from each bit for this state.
            boolean north = (i & 1) == 0;
            boolean south = (i & 2) == 0;
            boolean west =  (i & 4) == 0;
            boolean east =  (i & 8) == 0;

            // Add the borders for this state.
            if (south) tempBorderShape = Shapes.or(tempBorderShape, borderShapes.get(Direction.NORTH)); // South border
            if (north) tempBorderShape = Shapes.or(tempBorderShape, borderShapes.get(Direction.SOUTH)); // North border
            if (east)  tempBorderShape = Shapes.or(tempBorderShape, borderShapes.get(Direction.WEST)); // East border
            if (west)  tempBorderShape = Shapes.or(tempBorderShape, borderShapes.get(Direction.EAST)); // West border

            shapes[i] = Shapes.or(tempBorderShape, bottomShape);
        }
        return shapes;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        int index = getIndex(
                state.getValue(NORTH), state.getValue(SOUTH),
                state.getValue(WEST), state.getValue(EAST)
        );
        return SHAPES[index];
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.getPlanterBoxState(this.defaultBlockState(), context.getLevel(), context.getClickedPos());
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess tickView,
                                  BlockPos pos, Direction direction, BlockPos neighborPos,
                                  BlockState neighborState, RandomSource random) {
        return this.getPlanterBoxState(state, levelReader, pos);
    }

    private BlockState getPlanterBoxState(BlockState state, LevelReader world, BlockPos pos) {
        return state.setValue(NORTH, world.getBlockState(pos.north()).is(this))
                .setValue(SOUTH, world.getBlockState(pos.south()).is(this))
                .setValue(WEST, world.getBlockState(pos.west()).is(this))
                .setValue(EAST, world.getBlockState(pos.east()).is(this));
    }

    /**
     * When a structure is rotated with this block in it. This method decides what
     * state each block should be in.
     */
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        boolean north = state.getValue(NORTH);
        boolean south = state.getValue(SOUTH);
        boolean west = state.getValue(WEST);
        boolean east = state.getValue(EAST);

        switch (rotation) {
            case CLOCKWISE_180 -> {
                return state.setValue(SOUTH, north)
                        .setValue(NORTH, south)
                        .setValue(EAST, west)
                        .setValue(WEST, east);
            }
            case CLOCKWISE_90 -> {
                return state.setValue(EAST, north)
                        .setValue(WEST, south)
                        .setValue(NORTH, west)
                        .setValue(SOUTH, east);
            }
            case COUNTERCLOCKWISE_90 -> {
                return state.setValue(WEST, north)
                        .setValue(EAST, south)
                        .setValue(SOUTH, west)
                        .setValue(NORTH, east);
            }
            default -> {
                return state;
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, WEST, EAST);
    }
}
