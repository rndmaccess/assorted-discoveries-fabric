package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DesertVillagerPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(3.5D, 0.0D, 3.5D,
            13.0D, 14.5D, 13.0D);

    public DesertVillagerPlushieBlock(Properties settings) {
        super(settings, NORTH_SHAPE);
    }
}
