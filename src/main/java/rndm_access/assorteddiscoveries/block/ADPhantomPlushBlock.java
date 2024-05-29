package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class ADPhantomPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADPhantomPlushBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public ADPhantomPlushBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<ADPhantomPlushBlock> getCodec() {
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
        CODEC = createCodec(ADPhantomPlushBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(2.5, 0.0, 0.0, 13.5, 5.0, 14.0);
    }
}
