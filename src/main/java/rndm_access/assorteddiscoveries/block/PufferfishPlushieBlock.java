package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PufferfishPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(1.5D, 0.0D, 2.5D, 14.5D, 8.5D, 11.5D);

    public PufferfishPlushieBlock(BlockBehaviour.Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
