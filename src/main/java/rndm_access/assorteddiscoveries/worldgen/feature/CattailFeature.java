package rndm_access.assorteddiscoveries.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import rndm_access.assorteddiscoveries.block.CattailBlock;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class CattailFeature extends Feature<ProbabilityConfig> {
    public CattailFeature(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<ProbabilityConfig> context) {
        BlockPos origin = context.getOrigin();

        return placeCattail(context.getWorld(), context.getRandom(), origin.getX(), origin.getZ());
    }

    private boolean placeCattail(StructureWorldAccess world, Random random, int xOrigin, int zOrigin) {
        BlockPos lowerPos = this.offsetPos(random, world, xOrigin, zOrigin);
        BlockPos upperPos = lowerPos.up();
        BlockState lowerHalf = ModBlocks.CATTAIL.getDefaultState();
        BlockState upperHalf = lowerHalf.with(CattailBlock.HALF, DoubleBlockHalf.UPPER);
        boolean canPlace = lowerHalf.canPlaceAt(world, lowerPos) && world.getBlockState(upperPos).isAir();

        if (canPlace) {
            world.setBlockState(lowerPos, lowerHalf.with(CattailBlock.WATERLOGGED, world.isWater(lowerPos)), 2);
            world.setBlockState(upperPos, upperHalf, 2);
            return true;
        }
        return false;
    }

    private BlockPos offsetPos(Random random, StructureWorldAccess world, int xOrigin, int zOrigin) {
        int x = offsetCoordinate(xOrigin, random);
        int z = offsetCoordinate(zOrigin, random);
        int y = world.getTopY(Heightmap.Type.OCEAN_FLOOR, x, z);

        return new BlockPos(x, y, z);
    }

    private int offsetCoordinate(int origin, Random random) {
        return origin + random.nextInt(8) - random.nextInt(8);
    }
}
