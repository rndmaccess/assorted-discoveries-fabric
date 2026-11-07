package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SpiderPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(2.0D, 0.0D, 2.0D,
            14.0D, 7.0D, 14.5D);

    public SpiderPlushieBlock(BlockBehaviour.Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
