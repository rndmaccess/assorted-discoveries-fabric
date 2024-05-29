package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.SlabBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import rndm_access.assorteddiscoveries.core.ADBlocks;

public class ADDirtSlabBlock extends SlabBlock implements Fertilizable {
    public static final MapCodec<ADDirtSlabBlock> CODEC;

    public ADDirtSlabBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<ADDirtSlabBlock> getCodec() {
        return CODEC;
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return ADSnowySlabBlock.canSurvive(state, world, pos);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, ADBlocks.GRASS_SLAB.getDefaultState().with(TYPE, state.get(TYPE))
                .with(WATERLOGGED, state.get(WATERLOGGED)), 3);
    }

    static {
        CODEC = createCodec(ADDirtSlabBlock::new);
    }
}
