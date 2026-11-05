package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(3.5D, 0.0D, 3.5D,
            13.0D, 12.5D, 13.0D);

    public VillagerPlushieBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
