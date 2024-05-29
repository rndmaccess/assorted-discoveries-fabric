package rndm_access.assorteddiscoveries.common.worldgen.structure;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.JigsawFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.random.AtomicSimpleRandom;
import net.minecraft.world.gen.random.ChunkRandom;

public class ADNetherCabinFeature extends JigsawFeature {
    public ADNetherCabinFeature(Codec<StructurePoolFeatureConfig> config) {
        super(config, 33, true, false, ADNetherCabinFeature::checkLocation);
    }

    @Override
    public GenerationStep.Feature getGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    private static boolean checkLocation(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        ChunkRandom chunkRandom = new ChunkRandom(new AtomicSimpleRandom(0L));
        chunkRandom.setCarverSeed(context.seed(), context.chunkPos().x, context.chunkPos().z);
        BlockPos blockPos = context.chunkPos().getStartPos();
        VerticalBlockSample columnOfBlocks = context.chunkGenerator()
                .getColumnSample(blockPos.getX(), blockPos.getZ(), context.world());

        return columnOfBlocks.getState(34).isAir() && chunkRandom.nextInt(5) >= 2;
    }
}
