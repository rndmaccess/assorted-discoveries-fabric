package rndm_access.assorteddiscoveries.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import rndm_access.assorteddiscoveries.block.CattailBlock;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public record CattailFeature(float probability) implements Feature {
    public static final MapCodec<CattailFeature> CODEC = RecordCodecBuilder.mapCodec((i) ->
            i.group(Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(CattailFeature::probability))
                    .apply(i, CattailFeature::new));

    @Override
    public MapCodec<CattailFeature> codec() {
        return CODEC;
    }

    @Override
    public boolean place(final WorldGenLevel level, final ChunkGenerator chunkGenerator,
                         final RandomSource random, final BlockPos origin) {
        return placeCattail(level, random, origin.getX(), origin.getZ());
    }

    private boolean placeCattail(WorldGenLevel world, RandomSource random, int xOrigin, int zOrigin) {
        BlockPos lowerPos = this.offsetPos(random, world, xOrigin, zOrigin);
        BlockPos upperPos = lowerPos.above();
        BlockState lowerHalf = ModBlocks.CATTAIL.defaultBlockState();
        BlockState upperHalf = lowerHalf.setValue(CattailBlock.HALF, DoubleBlockHalf.UPPER);
        boolean canPlace = lowerHalf.canSurvive(world, lowerPos) && world.getBlockState(upperPos).isAir();
        boolean isCold = world.getBiome(lowerPos).value().coldEnoughToSnow(lowerPos, world.getSeaLevel());

        if (canPlace && !isCold) {
            world.setBlock(lowerPos, lowerHalf.setValue(CattailBlock.WATERLOGGED, world.isWaterAt(lowerPos)), 2);
            world.setBlock(upperPos, upperHalf, 2);
            return true;
        }
        return false;
    }

    private BlockPos offsetPos(RandomSource random, WorldGenLevel world, int xOrigin, int zOrigin) {
        int xOffset = random.nextInt(8) - random.nextInt(8);
        int zOffset = random.nextInt(8) - random.nextInt(8);
        int x = xOrigin + xOffset;
        int z = zOrigin + zOffset;
        int y = world.getHeight(Heightmap.Types.OCEAN_FLOOR, x, z);

        return new BlockPos(x, y, z);
    }
}
