package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import rndm_access.assorteddiscoveries.core.CommonBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class DirtSlabBlock extends SoilSlabBlock implements BonemealableBlock {
    public DirtSlabBlock(Properties settings) {
        super(settings);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, BonemealSource source) {
        return SnowySlabBlock.canGrowGrass(state, level, pos);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        BlockPos neighborPos = pos.above();
        BlockState neighborState = level.getBlockState(neighborPos);
        Block result = getSlabResult(level, pos);

        level.setBlock(pos, result.defaultBlockState().setValue(TYPE, state.getValue(TYPE))
                .setValue(WATERLOGGED, state.getValue(WATERLOGGED))
                .setValue(SnowySlabBlock.SNOWY, SnowySlabBlock.isSnowCovered(level, neighborPos, state, neighborState)), 3);
    }

    private Block getSlabResult(ServerLevel world, BlockPos originPos) {
        BlockPos[] poses = {originPos.below(), originPos, originPos.above()};

        for (BlockPos pose : poses) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                BlockPos neighborPos = pose.relative(dir);
                BlockState neighborState = world.getBlockState(neighborPos);

                if (neighborState.is(CommonBlockTags.MYCELIUM)) {
                    return ModBlocks.MYCELIUM_SLAB;
                } else if (neighborState.is(CommonBlockTags.PODZOL)) {
                    return ModBlocks.PODZOL_SLAB;
                }
            }
        }
        return ModBlocks.GRASS_SLAB;
    }
}
