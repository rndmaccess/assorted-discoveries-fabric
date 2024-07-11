package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.worldgen.feature.BloodKelpFeature;
import rndm_access.assorteddiscoveries.worldgen.feature.CattailFeature;

public class ModFeatures {
    public static final Feature<ProbabilityConfig> CATTAIL;
    public static final Feature<DefaultFeatureConfig> BLOOD_KELP;

    private static <C extends FeatureConfig, F extends Feature<C>> void register(String path, F feature) {
        Registry.register(Registries.FEATURE, ADReference.makeModId(path), feature);
    }

    /**
     * Called during initialization to register every feature.
     */
    public static void registerFeatures() {
        register("cattail", CATTAIL);
        register("blood_kelp", BLOOD_KELP);

        AssortedDiscoveries.LOGGER.info("Registered features");
    }

    static {
        CATTAIL = new CattailFeature(ProbabilityConfig.CODEC);
        BLOOD_KELP = new BloodKelpFeature(DefaultFeatureConfig.CODEC);
    }
}
