package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfigKeys;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;

import java.util.Map;

public class ModResourceConditions {
    private static final Map<String, Boolean> NAME_TO_CONFIG_ENTRY;
    private static final Identifier CONFIG_ENTRY_ENABLED;

    public static void registerResourceConditions(JsonConfig config) {
        registerConfigEntryConditions(config);
        ResourceConditions.register(CONFIG_ENTRY_ENABLED, object -> {
            String config_entry = JsonHelper.getString(object, "value");

            if(NAME_TO_CONFIG_ENTRY.containsKey(config_entry)) {
                return NAME_TO_CONFIG_ENTRY.get(config_entry);
            } else {
                AssortedDiscoveries.LOGGER.error("{} is not a known config entry!", config_entry);
                return true;
            }
        });
    }

    private static void registerEntry(JsonConfig config, String key) {
        BooleanConfigEntry entry = (BooleanConfigEntry) config.getEntry(key);
        boolean val = entry.getValue();

        registerEntry(key, val);
    }

    private static void registerEntry(String name, boolean configEntry) {
        if(!NAME_TO_CONFIG_ENTRY.containsKey(name)) {
            NAME_TO_CONFIG_ENTRY.put(ADReference.makeModId(name).toString(), configEntry);
        } else {
            AssortedDiscoveries.LOGGER.error("{} is already registered!", name);
        }
    }

    private static void registerConfigEntryConditions(JsonConfig config) {
        registerEntry(config, ModConfigKeys.ENABLE_ALLAY_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_BAT_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_CAMEL_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_CAT_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_CHICKEN_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_COW_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_HORSE_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_OCELOT_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_PIG_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_RABBIT_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_SHEEP_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_SQUID_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_STRIDER_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_VILLAGER_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_BEE_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_PIGLIN_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_SPIDER_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_BLAZE_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_CREEPER_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_GHAST_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_HOGLIN_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_ILLAGER_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_PHANTOM_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_RAVAGER_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_SHULKER_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_SKELETON_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_SLIME_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_VEX_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_WITCH_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_WITHER_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES);
        registerEntry(config, ModConfigKeys.ENABLE_WOODCUTTER);
        registerEntry(config, ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES);
        registerEntry(config, ModConfigKeys.ENABLE_GREEN_ONIONS);
        registerEntry(config, ModConfigKeys.ENABLE_NOODLE_SOUP);
        registerEntry(config, ModConfigKeys.ENABLE_BLUEBERRIES);
        registerEntry(config, ModConfigKeys.ENABLE_BLUEBERRY_PIE);
        registerEntry(config, ModConfigKeys.ENABLE_BLUEBERRY_JUICE);
        registerEntry(config, ModConfigKeys.ENABLE_SWEET_BERRY_PIE);
        registerEntry(config, ModConfigKeys.ENABLE_SWEET_BERRY_JUICE);
        registerEntry(config, ModConfigKeys.ENABLE_CHOCOLATE_CAKE);
        registerEntry(config, ModConfigKeys.ENABLE_RED_VELVET_CAKE);
        registerEntry(config, ModConfigKeys.ENABLE_FRIED_EGG);
        registerEntry(config, ModConfigKeys.ENABLE_HOGLIN_STEW);
        registerEntry(config, ModConfigKeys.ENABLE_FORESTS_BOUNTY);
        registerEntry(config, ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP);
        registerEntry(config, ModConfigKeys.ENABLE_PUDDING);
        registerEntry(config, ModConfigKeys.ENABLE_CARAMEL_APPLE);
        registerEntry(config, ModConfigKeys.ENABLE_CATTAILS);
        registerEntry(config, ModConfigKeys.ENABLE_BLOOD_KELP);
        registerEntry(config, ModConfigKeys.ENABLE_ENDER_PLANTS);
        registerEntry(config, ModConfigKeys.ENABLE_CREAKING_PLUSHIE);
        registerEntry(config, ModConfigKeys.ENABLE_STONE_WALLS);
        registerEntry(config, ModConfigKeys.ENABLE_CALCITE_BLOCKS);
        registerEntry(config, ModConfigKeys.ENABLE_POLISHED_CALCITE);
        registerEntry(config, ModConfigKeys.ENABLE_CALCITE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_BLACKSTONE_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS);
        registerEntry(config, ModConfigKeys.ENABLE_WOODEN_WALLS);
        registerEntry(config, ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS);
        registerEntry(config, ModConfigKeys.ENABLE_IRON_LADDERS);
        registerEntry(config, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE);
        registerEntry(config, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE);
        registerEntry(config, ModConfigKeys.ENABLE_DYED_CAMPFIRES);
        registerEntry(config, ModConfigKeys.ENABLE_DYED_TORCHES);
        registerEntry(config, ModConfigKeys.ENABLE_DYED_LANTERNS);
        registerEntry(config, ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_WEEPING_NETHERRACK);
        registerEntry(config, ModConfigKeys.ENABLE_TWISTED_NETHERRACK);
        registerEntry(config, ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
        registerEntry(config, ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ);
        registerEntry(config, ModConfigKeys.ENABLE_QUARTZ_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_BAUXITE);
        registerEntry(config, ModConfigKeys.ENABLE_BAUXITE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_STONE_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_MOSSY_STONE_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_CRACKED_STONE_TILES);
        registerEntry(config, ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS);
        registerEntry(config, ModConfigKeys.ENABLE_DRIPSTONE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS);
        registerEntry(config, ModConfigKeys.ENABLE_POLISHED_DRIPSTONE);
        registerEntry(config, ModConfigKeys.ENABLE_PACKED_SNOW);
        registerEntry(config, ModConfigKeys.ENABLE_SNOW_BRICKS);
        registerEntry(config, ModConfigKeys.ENABLE_QUARTZ_WALLS);
        registerEntry(config, ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS);
        registerEntry(config, ModConfigKeys.ENABLE_DIRT_SLABS);
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
