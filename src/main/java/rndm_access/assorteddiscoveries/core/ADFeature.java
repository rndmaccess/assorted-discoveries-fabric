package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.worldgen.feature.ADBloodKelpFeature;
import rndm_access.assorteddiscoveries.worldgen.feature.ADCattailFeature;

public class ADFeature {
    public static final Feature<ProbabilityConfig> CATTAIL = new ADCattailFeature(ProbabilityConfig.CODEC);
    public static final Feature<DefaultFeatureConfig> BLOOD_KELP = new ADBloodKelpFeature(DefaultFeatureConfig.CODEC);

    private static <C extends FeatureConfig, F extends Feature<C>> void registerFeature(String path, F feature) {
        Registry.register(Registries.FEATURE, ADReference.makeModId(path), feature);
    }

    /**
     * Called during initialization to register every feature.
     */
    public static void registerFeatures() {
        registerFeature("cattail", CATTAIL);
        registerFeature("blood_kelp", BLOOD_KELP);

        AssortedDiscoveries.LOGGER.info("Registered features");
    }
}
