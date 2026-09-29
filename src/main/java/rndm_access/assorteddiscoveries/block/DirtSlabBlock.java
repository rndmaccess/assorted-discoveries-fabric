package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import rndm_access.assorteddiscoveries.core.CommonBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class DirtSlabBlock extends SoilSlabBlock implements BonemealableBlock {
    public static final MapCodec<DirtSlabBlock> CODEC = simpleCodec(DirtSlabBlock::new);

    public DirtSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<DirtSlabBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state) {
        return SnowySlabBlock.canGrowGrass(state, levelReader, pos);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos neighborPos = pos.above();
        BlockState neighborState = serverLevel.getBlockState(neighborPos);
        Block result = getSlabResult(serverLevel, pos);

        serverLevel.setBlock(pos, result.defaultBlockState().setValue(TYPE, state.getValue(TYPE))
                .setValue(WATERLOGGED, state.getValue(WATERLOGGED))
                .setValue(SnowySlabBlock.SNOWY, SnowySlabBlock.isSnowCovered(serverLevel, neighborPos, state, neighborState)), 3);
    }

    private Block getSlabResult(ServerLevel serverLevel, BlockPos originPos) {
        BlockPos[] poses = {originPos.below(), originPos, originPos.above()};

        for (BlockPos pose : poses) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                BlockPos neighborPos = pose.relative(dir);
                BlockState neighborState = serverLevel.getBlockState(neighborPos);

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
