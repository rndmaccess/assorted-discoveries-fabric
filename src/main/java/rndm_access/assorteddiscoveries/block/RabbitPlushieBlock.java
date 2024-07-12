package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class RabbitPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<RabbitPlushieBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public RabbitPlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<RabbitPlushieBlock> getCodec() {
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
        CODEC = createCodec(RabbitPlushieBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(2.5D, 0.0D, 2.5D, 13.5D,
                10.5D, 13.0D);
    }
}
