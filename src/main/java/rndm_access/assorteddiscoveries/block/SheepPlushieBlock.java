package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.EnumMap;

public class SheepPlushieBlock extends PlushieBlock {
    private static final EnumMap<Direction, VoxelShape> SHAPES = ShapeHelper.makeShapeRotMap(
            Block.box(4.0D, 0.0D, 2.0D, 12.0D, 12.0D, 14.0D)
    );
    private final DyeColor color;

    public SheepPlushieBlock(DyeColor color, BlockBehaviour.Properties properties) {
        super(properties);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }
}