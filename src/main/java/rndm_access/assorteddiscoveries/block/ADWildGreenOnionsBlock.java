package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ADWildGreenOnionsBlock extends PlantBlock {
    public static final MapCodec<ADWildGreenOnionsBlock> CODEC = createCodec(ADWildGreenOnionsBlock::new);
    private static final VoxelShape SHAPE;

    public ADWildGreenOnionsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADWildGreenOnionsBlock> getCodec() {
        return CODEC;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    static {
        SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }
}
