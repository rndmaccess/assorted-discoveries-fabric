package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PigPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(4.0D, 0.0D, 1.0D,
            12.0D, 12.0D, 15.0D);

    public PigPlushieBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
