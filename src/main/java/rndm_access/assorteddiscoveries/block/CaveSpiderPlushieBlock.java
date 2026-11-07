package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CaveSpiderPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(2.0D, 0.0D, 2.0D,
            13.5D, 6.0D, 14.0D);

    public CaveSpiderPlushieBlock(BlockBehaviour.Properties settings) {
        super(settings, NORTH_SHAPE);
    }
}
