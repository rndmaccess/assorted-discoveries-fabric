package rndm_access.assorteddiscoveries.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WitherPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(2.5, 0.0, 3.5,
            13.5, 13.5, 12.5);

    public WitherPlushieBlock(BlockBehaviour.Properties properties) {
        super(properties, NORTH_SHAPE);
    }
}
