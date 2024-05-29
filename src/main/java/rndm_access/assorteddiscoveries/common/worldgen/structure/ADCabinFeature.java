package rndm_access.assorteddiscoveries.common.worldgen.structure;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.structure.StructureGeneratorFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.feature.JigsawFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class ADCabinFeature extends JigsawFeature {
    public ADCabinFeature(Codec<StructurePoolFeatureConfig> config) {
        super(config, 0, true, true, ADCabinFeature::checkLocation);
    }

    @Override
    public GenerationStep.Feature getGenerationStep() {
        return GenerationStep.Feature.SURFACE_STRUCTURES;
    }

    private static boolean checkLocation(StructureGeneratorFactory.Context<StructurePoolFeatureConfig> context) {
        BlockPos blockPos = context.chunkPos().getStartPos();
        int landHeight = context.chunkGenerator().getHeightOnGround(blockPos.getX(), blockPos.getZ(), Heightmap.Type.WORLD_SURFACE_WG, context.world());
        VerticalBlockSample columnOfBlocks = context.chunkGenerator().getColumnSample(blockPos.getX(), blockPos.getZ(), context.world());
        BlockState topBlock = columnOfBlocks.getState(landHeight);

        return topBlock.getFluidState().isEmpty();
    }
}
