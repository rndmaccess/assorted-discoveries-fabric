package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.worldgen.feature.BloodKelpFeature;
import rndm_access.assorteddiscoveries.worldgen.feature.CattailFeature;

@SuppressWarnings("unused")
public final class ModFeatures {
    public static final Feature<ProbabilityConfig> CATTAIL
            = register("cattail", new CattailFeature(ProbabilityConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> BLOOD_KELP
            = register("blood_kelp", new BloodKelpFeature(DefaultFeatureConfig.CODEC));

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registries.FEATURE, AssortedDiscoveries.makeModId(name), feature);
    }

    /**
     * Called during initialization to register every feature.
     */
    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered features");
    }
}
