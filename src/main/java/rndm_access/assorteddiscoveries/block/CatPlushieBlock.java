package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.EnumMap;

public class CatPlushieBlock extends SittingPlushieBlock {
    private static final EnumMap<Direction, VoxelShape> SHAPES = ShapeHelper.makeShapeRotMap(
            Block.box(4.5D, 0.0D, 1.0D, 11.5D, 9.5D, 14.5D)
    );

    public CatPlushieBlock(Properties settings) {
        super(settings);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }
}
