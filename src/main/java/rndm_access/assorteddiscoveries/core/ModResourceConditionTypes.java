package rndm_access.assorteddiscoveries.core;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.conditions.ConfigEntryEnabledResourceCondition;

public final class ModResourceConditionTypes {
    public static final ResourceConditionType<ConfigEntryEnabledResourceCondition> CONFIG_ENTRY_ENABLED;

    private static <T extends ResourceCondition> ResourceConditionType<T> create(String name, MapCodec<T> codec) {
        return ResourceConditionType.create(ADReference.makeModId(name), codec);
    }

    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered resource conditions!");
    }

    static {
        CONFIG_ENTRY_ENABLED = create("config_entry_enabled", ConfigEntryEnabledResourceCondition.CODEC);
    }
}
