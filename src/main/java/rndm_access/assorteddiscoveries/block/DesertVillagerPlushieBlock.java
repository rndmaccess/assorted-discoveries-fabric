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

public class DesertVillagerPlushieBlock extends PlushieBlock {
    private static final EnumMap<Direction, VoxelShape> SHAPES = ShapeHelper.makeShapeRotMap(
            Block.box(3.5D, 0.0D, 3.5D, 13.0D, 14.5D, 13.0D)
    );

    public DesertVillagerPlushieBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }
}
