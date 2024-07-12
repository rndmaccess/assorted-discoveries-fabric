package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class ChickenPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<ChickenPlushieBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public ChickenPlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<ChickenPlushieBlock> getCodec() {
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
        CODEC = createCodec(ChickenPlushieBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 3.0D, 12.0D,
                11.0D, 13.0D);
    }
}
