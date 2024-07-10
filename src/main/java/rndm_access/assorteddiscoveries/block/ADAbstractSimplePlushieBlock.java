package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import rndm_access.assorteddiscoveries.util.ADShapeHelper;

import java.util.HashMap;

public abstract class ADAbstractSimplePlushieBlock extends ADAbstractPlushieBlock {
    private final HashMap<Direction, VoxelShape> shapes;

    public ADAbstractSimplePlushieBlock(Settings settings) {
        super(settings);
        this.shapes = ADShapeHelper.makeShapeRotMap(this.getNorthShape());
    }

    @Override
    protected abstract MapCodec<? extends ADAbstractSimplePlushieBlock> getCodec();

    @Override
    protected abstract void appendProperties(StateManager.Builder<Block, BlockState> builder);

    protected abstract VoxelShape getNorthShape();

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shapes.get(state.get(FACING));
    }
}
