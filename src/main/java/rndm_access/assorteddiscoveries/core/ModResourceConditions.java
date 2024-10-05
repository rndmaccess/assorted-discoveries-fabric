package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;

import java.util.Map;

public class ModResourceConditions {
    private static final Map<String, Boolean> NAME_TO_CONFIG_ENTRY;
    private static final Identifier CONFIG_ENTRY_ENABLED;

    public static void registerResourceConditions() {
        registerConfigEntryConditions();
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

    private static void registerEntry(String name, boolean configEntry) {
        if(!NAME_TO_CONFIG_ENTRY.containsKey(name)) {
            NAME_TO_CONFIG_ENTRY.put(ADReference.makeModId(name).toString(), configEntry);
        } else {
            AssortedDiscoveries.LOGGER.error("{} is already registered!", name);
        }
    }

    // TODO: Structures currently can not be loaded conditionally. Add config entries for this when fabric adds support!
    private static void registerConfigEntryConditions() {
        registerEntry("enable_allay_plushie", ModConfig.ENABLE_ALLAY_PLUSHIE.getValue());
        registerEntry("enable_bat_plushie", ModConfig.ENABLE_BAT_PLUSHIE.getValue());
        registerEntry("enable_camel_plushie", ModConfig.ENABLE_CAMEL_PLUSHIE.getValue());
        registerEntry("enable_cat_plushies", ModConfig.ENABLE_CAT_PLUSHIES.getValue());
        registerEntry("enable_chicken_plushie", ModConfig.ENABLE_CHICKEN_PLUSHIE.getValue());
        registerEntry("enable_cow_plushie", ModConfig.ENABLE_COW_PLUSHIE.getValue());
        registerEntry("enable_horse_plushies", ModConfig.ENABLE_HORSE_PLUSHIES.getValue());
        registerEntry("enable_mooshroom_plushies", ModConfig.ENABLE_MOOSHROOM_PLUSHIES.getValue());
        registerEntry("enable_ocelot_plushie", ModConfig.ENABLE_OCELOT_PLUSHIE.getValue());
        registerEntry("enable_pig_plushie", ModConfig.ENABLE_PIG_PLUSHIE.getValue());
        registerEntry("enable_pufferfish_plushie", ModConfig.ENABLE_PUFFERFISH_PLUSHIE.getValue());
        registerEntry("enable_rabbit_plushies", ModConfig.ENABLE_RABBIT_PLUSHIES.getValue());
        registerEntry("enable_sheep_plushies", ModConfig.ENABLE_SHEEP_PLUSHIES.getValue());
        registerEntry("enable_squid_plushies", ModConfig.ENABLE_SQUID_PLUSHIES.getValue());
        registerEntry("enable_strider_plushies", ModConfig.ENABLE_STRIDER_PLUSHIES.getValue());
        registerEntry("enable_villager_plushies", ModConfig.ENABLE_VILLAGER_PLUSHIES.getValue());
        registerEntry("enable_bee_plushie", ModConfig.ENABLE_BEE_PLUSHIE.getValue());
        registerEntry("enable_cave_spider_plushie", ModConfig.ENABLE_CAVE_SPIDER_PLUSHIE.getValue());
        registerEntry("enable_enderman_plushie", ModConfig.ENABLE_ENDERMAN_PLUSHIE.getValue());
        registerEntry("enable_piglin_plushies", ModConfig.ENABLE_PIGLIN_PLUSHIES.getValue());
        registerEntry("enable_polar_bear_plushie", ModConfig.ENABLE_POLAR_BEAR_PLUSHIE.getValue());
        registerEntry("enable_spider_plushie", ModConfig.ENABLE_SPIDER_PLUSHIE.getValue());
        registerEntry("enable_pale_wolf_plushie", ModConfig.ENABLE_PALE_WOLF_PLUSHIE.getValue());
        registerEntry("enable_blaze_plushie", ModConfig.ENABLE_BLAZE_PLUSHIE.getValue());
        registerEntry("enable_creeper_plushie", ModConfig.ENABLE_CREEPER_PLUSHIE.getValue());
        registerEntry("enable_ghast_plushie", ModConfig.ENABLE_GHAST_PLUSHIE.getValue());
        registerEntry("enable_guardian_plushie", ModConfig.ENABLE_GUARDIAN_PLUSHIE.getValue());
        registerEntry("enable_hoglin_plushies", ModConfig.ENABLE_HOGLIN_PLUSHIES.getValue());
        registerEntry("enable_illager_plushies", ModConfig.ENABLE_ILLAGER_PLUSHIES.getValue());
        registerEntry("enable_magma_cube_plushie", ModConfig.ENABLE_MAGMA_CUBE_PLUSHIE.getValue());
        registerEntry("enable_phantom_plushie", ModConfig.ENABLE_PHANTOM_PLUSHIE.getValue());
        registerEntry("enable_ravager_plushie", ModConfig.ENABLE_RAVAGER_PLUSHIE.getValue());
        registerEntry("enable_shulker_plushie", ModConfig.ENABLE_SHULKER_PLUSHIE.getValue());
        registerEntry("enable_skeleton_plushie", ModConfig.ENABLE_SKELETON_PLUSHIE.getValue());
        registerEntry("enable_slime_plushie", ModConfig.ENABLE_SLIME_PLUSHIE.getValue());
        registerEntry("enable_vex_plushie", ModConfig.ENABLE_VEX_PLUSHIE.getValue());
        registerEntry("enable_witch_plushie", ModConfig.ENABLE_WITCH_PLUSHIE.getValue());
        registerEntry("enable_wither_plushie", ModConfig.ENABLE_WITHER_PLUSHIE.getValue());
        registerEntry("enable_zombie_plushie", ModConfig.ENABLE_ZOMBIE_PLUSHIE.getValue());
        registerEntry("enable_zombie_villager_plushies", ModConfig.ENABLE_ZOMBIE_VILLAGER_PLUSHIES.getValue());
        registerEntry("enable_smoky_quartz_blocks", ModConfig.ENABLE_SMOKY_QUARTZ_BLOCKS.getValue());
        registerEntry("enable_smoky_quartz_bricks", ModConfig.ENABLE_SMOKY_QUARTZ_BRICKS.getValue());
        registerEntry("enable_woodcutter", ModConfig.ENABLE_WOODCUTTER.getValue());

        registerEntry("enable_wooden_planter_boxes", ModConfig.ENABLE_WOODEN_PLANTER_BOXES.getValue());
        registerEntry("enable_green_onions", ModConfig.ENABLE_GREEN_ONIONS.getValue());
        registerEntry("enable_noodle_soup", ModConfig.ENABLE_NOODLE_SOUP.getValue());
        registerEntry("enable_blueberries", ModConfig.ENABLE_BLUEBERRIES.getValue());
        registerEntry("enable_blueberry_pie", ModConfig.ENABLE_BLUEBERRY_PIE.getValue());
        registerEntry("enable_blueberry_juice", ModConfig.ENABLE_BLUEBERRY_JUICE.getValue());
        registerEntry("enable_sweet_berry_pie", ModConfig.ENABLE_SWEET_BERRY_PIE.getValue());
        registerEntry("enable_sweet_berry_juice", ModConfig.ENABLE_SWEET_BERRY_JUICE.getValue());
        registerEntry("enable_chocolate_cake", ModConfig.ENABLE_CHOCOLATE_CAKE.getValue());
        registerEntry("enable_red_velvet_cake", ModConfig.ENABLE_RED_VELVET_CAKE.getValue());
        registerEntry("enable_fried_egg", ModConfig.ENABLE_FRIED_EGG.getValue());
        registerEntry("enable_hoglin_stew", ModConfig.ENABLE_HOGLIN_STEW.getValue());
        registerEntry("enable_forests_bounty", ModConfig.ENABLE_FORESTS_BOUNTY.getValue());
        registerEntry("enable_witchs_cradle_soup", ModConfig.ENABLE_WITCHS_CRADLE_SOUP.getValue());
        registerEntry("enable_pudding", ModConfig.ENABLE_PUDDING.getValue());
        registerEntry("enable_caramel_apple", ModConfig.ENABLE_CARAMEL_APPLE.getValue());
        registerEntry("enable_cattails", ModConfig.ENABLE_CATTAILS.getValue());
        registerEntry("enable_blood_kelp", ModConfig.ENABLE_BLOOD_KELP.getValue());
        registerEntry("enable_ender_plants", ModConfig.ENABLE_ENDER_PLANTS.getValue());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
