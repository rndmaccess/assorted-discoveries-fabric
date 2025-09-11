package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class ShulkerPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<ShulkerPlushieBlock> CODEC = createCodec(ShulkerPlushieBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D,
            14.0D, 12.0D, 14.0D);

    public ShulkerPlushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<ShulkerPlushieBlock> getCodec() {
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
