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
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class DirtSlabBlock extends SlabBlock implements Fertilizable {
    public static final MapCodec<DirtSlabBlock> CODEC;

    public DirtSlabBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<DirtSlabBlock> getCodec() {
        return CODEC;
    }

    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return SnowySlabBlock.canSurvive(state, world, pos);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, ModBlocks.GRASS_SLAB.getDefaultState().with(TYPE, state.get(TYPE))
                .with(WATERLOGGED, state.get(WATERLOGGED)), 3);
    }

    static {
        CODEC = createCodec(DirtSlabBlock::new);
    }
}
