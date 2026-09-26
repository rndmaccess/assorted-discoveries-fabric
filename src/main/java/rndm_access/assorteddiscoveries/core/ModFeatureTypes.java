package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.worldgen.feature.BloodKelpFeature;
import rndm_access.assorteddiscoveries.worldgen.feature.CattailFeature;

@SuppressWarnings("unused")
public final class ModFeatureTypes {
    private ModFeatureTypes() {}

    /**
     * Called during initialization to register every feature type.
     */
    public static void register() {
        Registry.register(BuiltInRegistries.FEATURE_TYPE, AssortedDiscoveries.makeModId("cattail"), CattailFeature.CODEC);
        Registry.register(BuiltInRegistries.FEATURE_TYPE, AssortedDiscoveries.makeModId("blood_kelp"), BloodKelpFeature.CODEC);
        AssortedDiscoveries.LOGGER.info("Registered feature types");
    }
}
