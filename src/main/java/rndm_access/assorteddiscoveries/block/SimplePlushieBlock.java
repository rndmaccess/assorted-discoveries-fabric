package rndm_access.assorteddiscoveries.block;

import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.EnumMap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SimplePlushieBlock extends PlushieBlock {
    private final EnumMap<Direction, VoxelShape> shapes;

    public SimplePlushieBlock(Properties settings, VoxelShape northShape) {
        super(settings);
        this.shapes = ShapeHelper.makeShapeRotMap(northShape);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shapes.get(state.getValue(FACING));
    }
}
