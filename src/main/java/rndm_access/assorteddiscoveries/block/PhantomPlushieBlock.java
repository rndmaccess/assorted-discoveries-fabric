package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PhantomPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(2.5, 0.0, 0.0,
            13.5, 5.0, 14.0);

    public PhantomPlushieBlock(Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
