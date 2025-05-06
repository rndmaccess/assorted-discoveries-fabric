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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        JsonConfig config = ModConfig.createOrInitConfig();
        Map<String, Boolean> entries = new HashMap<>();
        List<String> configKeys = getConfigKeys();

        for (String key : configKeys) {
            BooleanConfigEntry entry = (BooleanConfigEntry) config.getEntry(key);
            boolean val = entry.getValue();
            entries.put(ADReference.makeModId(key).toString(), val);
        }
        return entries;
    }

    private static List<String> getConfigKeys() {
        List<String> configEntries = new ArrayList<>();

        configEntries.add(ModConfigKeys.ENABLE_ALLAY_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_BAT_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_CAMEL_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_CAT_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_CHICKEN_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_COW_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_HORSE_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_OCELOT_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_PIG_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_RABBIT_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_SHEEP_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_SQUID_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_STRIDER_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_VILLAGER_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_BEE_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_PIGLIN_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_SPIDER_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_BLAZE_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_CREEPER_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_GHAST_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_HOGLIN_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_ILLAGER_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_PHANTOM_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_RAVAGER_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_SHULKER_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_SKELETON_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_SLIME_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_VEX_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_WITCH_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_WITHER_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES);
        configEntries.add(ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES);
        configEntries.add(ModConfigKeys.ENABLE_GREEN_ONIONS);
        configEntries.add(ModConfigKeys.ENABLE_NOODLE_SOUP);
        configEntries.add(ModConfigKeys.ENABLE_BLUEBERRIES);
        configEntries.add(ModConfigKeys.ENABLE_BLUEBERRY_PIE);
        configEntries.add(ModConfigKeys.ENABLE_BLUEBERRY_JUICE);
        configEntries.add(ModConfigKeys.ENABLE_SWEET_BERRY_PIE);
        configEntries.add(ModConfigKeys.ENABLE_SWEET_BERRY_JUICE);
        configEntries.add(ModConfigKeys.ENABLE_CHOCOLATE_CAKE);
        configEntries.add(ModConfigKeys.ENABLE_RED_VELVET_CAKE);
        configEntries.add(ModConfigKeys.ENABLE_FRIED_EGG);
        configEntries.add(ModConfigKeys.ENABLE_HOGLIN_STEW);
        configEntries.add(ModConfigKeys.ENABLE_FORESTS_BOUNTY);
        configEntries.add(ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP);
        configEntries.add(ModConfigKeys.ENABLE_PUDDING);
        configEntries.add(ModConfigKeys.ENABLE_CARAMEL_APPLE);
        configEntries.add(ModConfigKeys.ENABLE_CATTAILS);
        configEntries.add(ModConfigKeys.ENABLE_BLOOD_KELP);
        configEntries.add(ModConfigKeys.ENABLE_ENDER_PLANTS);
        configEntries.add(ModConfigKeys.ENABLE_CREAKING_PLUSHIE);
        configEntries.add(ModConfigKeys.ENABLE_STONE_WALLS);
        configEntries.add(ModConfigKeys.ENABLE_CALCITE_BLOCKS);
        configEntries.add(ModConfigKeys.ENABLE_POLISHED_CALCITE);
        configEntries.add(ModConfigKeys.ENABLE_CALCITE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_BLACKSTONE_TILES);
        configEntries.add(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES);
        configEntries.add(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES);
        configEntries.add(ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS);
        configEntries.add(ModConfigKeys.ENABLE_WOODEN_WALLS);
        configEntries.add(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS);
        configEntries.add(ModConfigKeys.ENABLE_IRON_LADDERS);
        configEntries.add(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE);
        configEntries.add(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE);
        configEntries.add(ModConfigKeys.ENABLE_DYED_CAMPFIRES);
        configEntries.add(ModConfigKeys.ENABLE_DYED_TORCHES);
        configEntries.add(ModConfigKeys.ENABLE_DYED_LANTERNS);
        configEntries.add(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_WEEPING_NETHERRACK);
        configEntries.add(ModConfigKeys.ENABLE_TWISTED_NETHERRACK);
        configEntries.add(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
        configEntries.add(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ);
        configEntries.add(ModConfigKeys.ENABLE_QUARTZ_TILES);
        configEntries.add(ModConfigKeys.ENABLE_BAUXITE);
        configEntries.add(ModConfigKeys.ENABLE_BAUXITE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_STONE_TILES);
        configEntries.add(ModConfigKeys.ENABLE_MOSSY_STONE_TILES);
        configEntries.add(ModConfigKeys.ENABLE_CRACKED_STONE_TILES);
        configEntries.add(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS);
        configEntries.add(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS);
        configEntries.add(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE);
        configEntries.add(ModConfigKeys.ENABLE_PACKED_SNOW);
        configEntries.add(ModConfigKeys.ENABLE_SNOW_BRICKS);
        configEntries.add(ModConfigKeys.ENABLE_QUARTZ_WALLS);
        configEntries.add(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS);
        configEntries.add(ModConfigKeys.ENABLE_DIRT_SLABS);
        configEntries.add(ModConfigKeys.ENABLE_SNIFFER_PLUSHIE);
        return configEntries;
    }

    static {
        ENTRIES = resolveEntries();
    }
}
