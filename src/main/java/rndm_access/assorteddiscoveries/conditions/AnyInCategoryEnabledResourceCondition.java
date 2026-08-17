package rndm_access.assorteddiscoveries.conditions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.resources.RegistryOps;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;

import java.util.List;
import java.util.function.Function;

public record AnyInCategoryEnabledResourceCondition(String configKey) implements ResourceCondition {
    public static final MapCodec<AnyInCategoryEnabledResourceCondition> CODEC
            = RecordCodecBuilder.mapCodec((instance) -> {
        Function<AnyInCategoryEnabledResourceCondition, String> key = AnyInCategoryEnabledResourceCondition::getConfigKey;

        return instance.group(Codec.STRING.fieldOf("value").forGetter(key))
                .apply(instance, AnyInCategoryEnabledResourceCondition::new);
    });

    public String getConfigKey() {
        return this.configKey;
    }

    @Override
    public ResourceConditionType<?> getType() {
        return ModResourceConditionTypes.CONFIG_ENTRY_ENABLED;
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
            if (object instanceof BooleanConfigEntry entry) {
                boolean value = entry.getValue();

                if (value) {
                    return true;
                }
            }
        }
        return false;
    }
}
