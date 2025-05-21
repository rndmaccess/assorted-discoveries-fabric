package rndm_access.assorteddiscoveries.conditions;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.registry.RegistryOps;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.ModConfigKeys;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public record ConfigEntryEnabledResourceCondition(String configKey) implements ResourceCondition {
    private static final Map<String, Boolean> ENTRIES;
    public static final MapCodec<ConfigEntryEnabledResourceCondition> CODEC
            = RecordCodecBuilder.mapCodec((instance) -> {
        Function<ConfigEntryEnabledResourceCondition, String> key = ConfigEntryEnabledResourceCondition::getConfigKey;

        return instance.group(Codec.STRING.fieldOf("value").forGetter(key))
                .apply(instance, ConfigEntryEnabledResourceCondition::new);
    });

    public String getConfigKey() {
        return this.configKey;
    }

    @Override
    public ResourceConditionType<?> getType() {
        return ModResourceConditionTypes.CONFIG_ENTRY_ENABLED;
    }

    @Override
    public boolean test(@Nullable RegistryOps.@Nullable RegistryInfoGetter registryInfo) {
        if (ENTRIES.containsKey(this.configKey)) {
            return ENTRIES.get(this.configKey);
        }
        AssortedDiscoveries.LOGGER.error("{} is not a known config entry!", this.configKey);
        return false; // Don't load the resource if we encounter an unknown config key!
    }

    private static Map<String, Boolean> resolveEntries() {
        // By calling this method we make sure that there is a config to load!
        JsonConfig config = ModConfig.createOrLoad();
        Map<String, Boolean> entries = new HashMap<>();

        for (String key : ModConfigKeys.CONFIG_KEYS) {
            BooleanConfigEntry entry = (BooleanConfigEntry) config.getEntry(key);
            boolean val = entry.getValue();
            entries.put(ADReference.makeModId(key).toString(), val);
        }
        return entries;
    }

    static {
        ENTRIES = resolveEntries();
    }
}
