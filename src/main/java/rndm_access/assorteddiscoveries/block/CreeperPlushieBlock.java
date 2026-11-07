package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CreeperPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(4.0D, 0.0D, 2.0D,
            12.0D, 12.0D, 14.0D);

    public CreeperPlushieBlock(Properties settings) {
        super(settings, NORTH_SHAPE);
    }
}
