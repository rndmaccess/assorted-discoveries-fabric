package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BatPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(1.0D, 0.0D, 4.0D,
            15.0D, 12.0D, 12.0D);

    public BatPlushieBlock(BlockBehaviour.Properties settings) {
        super(settings, NORTH_SHAPE);
    }
}
