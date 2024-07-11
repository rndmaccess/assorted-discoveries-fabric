package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import java.util.HashMap;

public class DirtPathSlabBlock extends SlabBlock {
    protected static final HashMap<SlabType, VoxelShape> SHAPE;
    public static final MapCodec<DirtPathSlabBlock> CODEC;

    public DirtPathSlabBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<DirtPathSlabBlock> getCodec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if(direction.equals(Direction.UP) && !state.get(TYPE).equals(SlabType.BOTTOM)) {
            return ModBlocks.DIRT_SLAB.getDefaultState().with(TYPE, state.get(TYPE))
                    .with(WATERLOGGED, state.get(WATERLOGGED));
        } else {
            return state;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        SlabType slabType = state.get(TYPE);
        return SHAPE.get(slabType);
    }

    static {
        SHAPE = new HashMap<>();
        SHAPE.put(SlabType.DOUBLE, Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0,
                16.0));
        SHAPE.put(SlabType.BOTTOM, Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 7.0,
                16.0));
        SHAPE.put(SlabType.TOP, Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 15.0,
                16.0));
        CODEC = createCodec(DirtPathSlabBlock::new);
    }
}
