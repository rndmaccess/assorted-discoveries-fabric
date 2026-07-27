package rndm_access.assorteddiscoveries.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class EndBoneMealHelper {
    public static void spawnEndGrowthParticles(final Level level, final BlockPos pos) {
        int count = level.getRandom().nextInt(10);
        ParticleUtils.spawnParticles(level, pos, count * 3, 3.0D, 1.0D,
                false, ParticleTypes.END_ROD);
    }

    public static void growEnderPlants(Level level, BlockPos centerPos) {
        RandomSource random = level.getRandom();
        BlockPos.MutableBlockPos plantPos = centerPos.mutable();
        BlockPos.MutableBlockPos soilPos = centerPos.below().mutable();

        for (int i = 0; i < 256; ++i) {
            plantPos.set(centerPos);

            // A short walk ensuring that it stays relatively close to the center. This "walk" favors the center.
            int steps = 4 + random.nextInt(5);
            for (int j = 0; j < steps; ++j) {
                plantPos.move(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            // Skip the blocks where plants can't grow!
            if (!level.getBlockState(plantPos).isAir()) continue;

            // Calculate distance from the true center
            double distSq = plantPos.distSqr(centerPos);
            double maxRadiusSq = 100.0; // 10 blocks out

            // 1.0 at center, tapering to 0.0 at edge
            float chance = (float) Math.max(0, 1.0 - (distSq / maxRadiusSq));

            // High density multiplier (0.9F) keeps the center thick
            if (random.nextFloat() > (chance * 0.9F)) continue;

            soilPos.set(plantPos.getX(), plantPos.getY() - 1, plantPos.getZ());
            if (level.getBlockState(soilPos).is(ModBlockTags.END_BONE_MEALABLE_BLOCKS)) {
                placeBlock(level, random, plantPos);
            }
        }
    }

    private static void placeBlock(Level level, RandomSource random, BlockPos pos) {
        boolean placeSnapdragon = random.nextFloat() <= 0.4F; // 40% chance

        if(placeSnapdragon) {
            level.setBlockAndUpdate(pos, ModBlocks.SNAPDRAGON.defaultBlockState());
        } else {
            level.setBlockAndUpdate(pos, ModBlocks.SHORT_ENDER_GRASS.defaultBlockState());
        }
    }
}
