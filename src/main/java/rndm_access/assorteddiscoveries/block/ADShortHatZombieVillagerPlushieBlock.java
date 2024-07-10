package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class ADShortHatZombieVillagerPlushieBlock extends ADAbstractSimplePlushieBlock {
    public static final MapCodec<ADShortHatZombieVillagerPlushieBlock> CODEC;
    private static final VoxelShape NORTH_SHAPE;

    public ADShortHatZombieVillagerPlushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<ADShortHatZombieVillagerPlushieBlock> getCodec() {
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
        CODEC = createCodec(ADShortHatZombieVillagerPlushieBlock::new);
        NORTH_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.5D, 13.5D, 13.5D);
    }
}
