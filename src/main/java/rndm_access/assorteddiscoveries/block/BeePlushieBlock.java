package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BeePlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(3.0D, 0.0D, 2.5D,
            13.5D, 7.0D, 14.5D);

    public BeePlushieBlock(BlockBehaviour.Properties settings) {
        super(settings, NORTH_SHAPE);
    }
}
