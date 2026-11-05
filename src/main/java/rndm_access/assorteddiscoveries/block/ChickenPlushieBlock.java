package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChickenPlushieBlock extends SimplePlushieBlock {
    private static final VoxelShape NORTH_SHAPE = Block.box(4.0D, 0.0D, 3.0D,
            12.0D, 11.0D, 13.0D);

    public ChickenPlushieBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
