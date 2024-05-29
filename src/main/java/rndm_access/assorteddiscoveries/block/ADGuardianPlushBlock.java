package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class ADGuardianPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADGuardianPlushBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public ADGuardianPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<ADGuardianPlushBlock> getCodec() {
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
        CODEC = createCodec(ADGuardianPlushBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 2.5D, 12.5D, 8.5D, 12.5D);
    }
}
