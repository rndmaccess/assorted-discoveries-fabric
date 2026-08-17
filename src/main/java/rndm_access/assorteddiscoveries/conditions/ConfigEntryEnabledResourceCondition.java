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
import rndm_access.assorteddiscoveries.config.json.json_objects.AbstractConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;

import java.util.List;

public record ConfigEntryEnabledResourceCondition(List<String> configKeys) implements ResourceCondition {
    public static final MapCodec<ConfigEntryEnabledResourceCondition> CODEC
            = RecordCodecBuilder.mapCodec((instance) -> instance.group(
                    Codec.withAlternative(Codec.STRING.listOf(), Codec.STRING.xmap(List::of, List::getFirst))
                            .fieldOf("value")
                            .forGetter(ConfigEntryEnabledResourceCondition::configKeys)
            ).apply(instance, ConfigEntryEnabledResourceCondition::new));

    @Override
    public @NonNull ResourceConditionType<?> getType() {
        return ModResourceConditionTypes.CONFIG_ENTRY_ENABLED;
    }

    @Override
    public boolean test(@Nullable RegistryOps.@Nullable RegistryInfoLookup registryInfo) {
        if (this.configKeys.isEmpty()) {
            return true;
        }

        for (String configKey : this.configKeys) {
            AbstractConfigEntry<?> entry = ModConfig.CONFIG.getEntry(configKey);
            if (!(entry instanceof BooleanConfigEntry)) {
                AssortedDiscoveries.LOGGER.error("{} is not a known config entry or is not a boolean!", configKey);
                continue; // Don't load the resource if we encounter an unknown config key!
            }

            boolean value = ((BooleanConfigEntry) entry).getValue();

            if (!value) {
                return false;
            }
        }
        return true;
    }
}
