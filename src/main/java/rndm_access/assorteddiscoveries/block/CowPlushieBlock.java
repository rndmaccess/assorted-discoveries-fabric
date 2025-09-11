package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class CowPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<CowPlushieBlock> CODEC = createCodec(CowPlushieBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 1.0D,
            12.5D, 12.0D, 15.0D);

    public CowPlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<CowPlushieBlock> getCodec() {
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
}
