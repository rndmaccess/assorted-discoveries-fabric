package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SimplePlushieBlock extends PlushieBlock {
    public static final MapCodec<SimplePlushieBlock> CODEC = BuiltInRegistries.BLOCK.byNameCodec()
            .dispatchMap(
                    "type",
                    block -> block,
                    block -> MapCodec.unit((SimplePlushieBlock) block)
            );
    private final HashMap<Direction, VoxelShape> shapes;

    public SimplePlushieBlock(Properties properties, VoxelShape shape) {
        super(properties);
        this.shapes = ShapeHelper.makeShapeRotMap(shape);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected MapCodec<? extends PlushieBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shapes.get(state.getValue(FACING));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }
}
