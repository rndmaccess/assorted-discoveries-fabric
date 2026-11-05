package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CamelPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(2.0D, 0.0D, 1.0D,
            14.0D, 12.0D, 15.0D);

    public CamelPlushieBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
