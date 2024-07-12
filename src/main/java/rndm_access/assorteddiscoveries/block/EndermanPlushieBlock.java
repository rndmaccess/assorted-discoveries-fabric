package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class EndermanPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<EndermanPlushieBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public EndermanPlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<EndermanPlushieBlock> getCodec() {
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
        CODEC = createCodec(EndermanPlushieBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 13.0D,
                12.5D, 14.0D);
    }
}
