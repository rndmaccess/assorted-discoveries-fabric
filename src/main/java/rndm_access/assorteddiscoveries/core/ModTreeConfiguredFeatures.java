package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import rndm_access.assorteddiscoveries.ADReference;

public class ModTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> HUGE_PURPLE_MUSHROOM;

    public static RegistryKey<ConfiguredFeature<?,?>> of(String path) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, ADReference.makeModId(path));
    }

    static {
        HUGE_PURPLE_MUSHROOM = of("huge_purple_mushroom");
    }
}
