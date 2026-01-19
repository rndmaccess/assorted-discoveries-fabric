package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class DirtSlabBlock extends SlabBlock implements BonemealableBlock {
    public static final MapCodec<DirtSlabBlock> CODEC = simpleCodec(DirtSlabBlock::new);

    public DirtSlabBlock(Properties settings) {
        super(settings);
    }

    @Override
    public MapCodec<DirtSlabBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return SnowySlabBlock.canGrowGrass(state, world, pos);
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos neighborPos = pos.above();
        BlockState neighborState = world.getBlockState(neighborPos);

        world.setBlock(pos, ModBlocks.GRASS_SLAB.defaultBlockState().setValue(TYPE, state.getValue(TYPE))
                .setValue(WATERLOGGED, state.getValue(WATERLOGGED))
                .setValue(SnowySlabBlock.SNOWY, SnowySlabBlock.isSnow(world, state, neighborPos, neighborState)), 3);
    }
}
