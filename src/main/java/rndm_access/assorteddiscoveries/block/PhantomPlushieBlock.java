package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class PhantomPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<PhantomPlushieBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public PhantomPlushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<PhantomPlushieBlock> getCodec() {
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
        CODEC = createCodec(PhantomPlushieBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(2.5, 0.0, 0.0, 13.5, 5.0, 14.0);
    }
}
