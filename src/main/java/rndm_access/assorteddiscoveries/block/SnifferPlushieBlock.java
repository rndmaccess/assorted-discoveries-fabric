package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class SnifferPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<SnifferPlushieBlock> CODEC = createCodec(SnifferPlushieBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 1.0D,
            14.0D, 9.5D, 15.0D);

    public SnifferPlushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends AbstractSimplePlushieBlock> getCodec() {
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
