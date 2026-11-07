package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AllayPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(3.0D, 0.0D, 3.0D,
            13.0D, 10.0D, 13.0D);

    public AllayPlushieBlock(Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
