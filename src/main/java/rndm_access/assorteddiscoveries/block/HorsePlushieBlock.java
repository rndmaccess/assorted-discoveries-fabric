package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HorsePlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(4.5D, 0.0D, 0.5D,
            11.5D, 12.5, 15.5D);

    public HorsePlushieBlock(BlockBehaviour.Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
