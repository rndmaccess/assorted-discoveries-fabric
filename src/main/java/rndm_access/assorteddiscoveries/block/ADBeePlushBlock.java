package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class ADBeePlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADBeePlushBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public ADBeePlushBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<ADBeePlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }

    static {
        CODEC = createCodec(ADBeePlushBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 2.5D, 13.5D, 7.0D, 14.5D);
    }
}
