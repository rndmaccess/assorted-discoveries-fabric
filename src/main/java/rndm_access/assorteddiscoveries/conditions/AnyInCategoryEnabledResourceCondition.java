package rndm_access.assorteddiscoveries.conditions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.resources.RegistryOps;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;

import java.util.List;

public record AnyInCategoryEnabledResourceCondition(String configKey) implements ResourceCondition {
    public static final MapCodec<AnyInCategoryEnabledResourceCondition> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.STRING.fieldOf("value").forGetter(AnyInCategoryEnabledResourceCondition::configKey)
            ).apply(instance, AnyInCategoryEnabledResourceCondition::new)
    );

    @Override
    public @NonNull ResourceConditionType<?> getType() {
        return ModResourceConditionTypes.ANY_IN_CATEGORY_ENABLED;
    }

    @Override
    public boolean test(@Nullable RegistryOps.@Nullable RegistryInfoLookup registryInfo) {
        JsonConfigCategory category = ModConfig.CONFIG.getCategory(configKey);
        if (category == null) {
            AssortedDiscoveries.LOGGER.error("{} is not a known config category!", this.configKey);
            return false; // Don't load the resource if we encounter an unknown config key!
        }
        List<ConfigObject> objects = category.getConfigObjects();

        for (ConfigObject object : objects) {
            if (object instanceof BooleanConfigEntry entry && entry.getValue()) {
                return true;
            }
        }
        return false;
    }
}
