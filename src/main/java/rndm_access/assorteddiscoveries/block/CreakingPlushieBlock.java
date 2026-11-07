package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CreakingPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(1.5D, 0.0D, 1.5D,
            14.5D, 14.5D, 14.5D);

    public CreakingPlushieBlock(Properties settings) {
        super(settings, NORTH_SHAPE);
    }
}
