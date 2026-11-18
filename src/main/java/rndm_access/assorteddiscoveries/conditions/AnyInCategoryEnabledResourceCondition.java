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
import rndm_access.assorteddiscoveries.config.ModConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanJsonConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigEntry;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;

import java.util.List;

public record AnyInCategoryEnabledResourceCondition(String configKey) implements ResourceCondition {
    public static final MapCodec<AnyInCategoryEnabledResourceCondition> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.STRING.fieldOf("value").forGetter(AnyInCategoryEnabledResourceCondition::configKey)
            ).apply(instance, AnyInCategoryEnabledResourceCondition::new)
    );

    @Override
    public ResourceConditionType<?> getType() {
        return ModResourceConditionTypes.ANY_IN_CATEGORY_ENABLED;
    }

    @Override
    public boolean test(@Nullable RegistryOps.RegistryInfoLookup registryInfo) {
        ModConfigCategory category = ModConfig.CONFIG.getCategory(configKey);
        if (category == null) {
            AssortedDiscoveries.LOGGER.error("{} is not a known config category!", this.configKey);
            return false; // Don't load the resource if we encounter an unknown config key!
        }
        List<JsonConfigEntry<?>> entries = category.getEntries();

        for (JsonConfigEntry<?> entry : entries) {
            if (entry instanceof BooleanJsonConfigEntry booleanEntry && booleanEntry.getActiveValue()) {
                return true;
            }
        }
        return false;
    }
}
