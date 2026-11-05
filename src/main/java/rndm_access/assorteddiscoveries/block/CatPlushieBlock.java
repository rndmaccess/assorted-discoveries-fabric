package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CatPlushieBlock extends SittingPlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(4.5D, 0.0D, 1.0D,
            11.5D, 9.5D, 14.5D);

    public CatPlushieBlock(Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
