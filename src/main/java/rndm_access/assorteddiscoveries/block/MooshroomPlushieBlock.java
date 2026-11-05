package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MooshroomPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(3.5D, 0.0D, 1.0D,
            12.5D, 14.0D, 15.0D);

    public MooshroomPlushieBlock(BlockBehaviour.Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
