package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModTreeFeatures {
    public static final ResourceKey<Feature> HUGE_PURPLE_MUSHROOM = createKey("huge_purple_mushroom");

    private ModTreeFeatures() {}

    public static ResourceKey<Feature> createKey(final String name) {
        return ResourceKey.create(Registries.FEATURE, AssortedDiscoveries.makeModId(name));
    }
}
