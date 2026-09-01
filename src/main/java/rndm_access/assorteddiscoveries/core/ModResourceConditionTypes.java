package rndm_access.assorteddiscoveries.core;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.conditions.AnyInCategoryEnabledResourceCondition;
import rndm_access.assorteddiscoveries.conditions.AllEntriesEnabledResourceCondition;

public final class ModResourceConditionTypes {
    public static final ResourceConditionType<AllEntriesEnabledResourceCondition> ALL_ENTRIES_ENABLED
            = create("all_entries_enabled", AllEntriesEnabledResourceCondition.CODEC);
    public static final ResourceConditionType<AnyInCategoryEnabledResourceCondition> ANY_IN_CATEGORY_ENABLED
            = create("any_in_category_enabled", AnyInCategoryEnabledResourceCondition.CODEC);

    private ModResourceConditionTypes() {}

    private static <T extends ResourceCondition> ResourceConditionType<T> create(String name, MapCodec<T> codec) {
        return ResourceConditionType.create(AssortedDiscoveries.makeModId(name), codec);
    }

    public static void register() {
        ResourceConditions.register(ALL_ENTRIES_ENABLED);
        ResourceConditions.register(ANY_IN_CATEGORY_ENABLED);
        AssortedDiscoveries.LOGGER.info("Registered resource conditions");
    }
}
