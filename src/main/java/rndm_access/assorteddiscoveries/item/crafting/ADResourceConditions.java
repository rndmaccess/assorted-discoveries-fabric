package rndm_access.assorteddiscoveries.item.crafting;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ADConfig;

import java.util.Map;

public class ADResourceConditions {
    private static final Map<String, Boolean> NAME_TO_CONFIG_ENTRY;
    private static final Identifier CONFIG_ENTRY_ENABLED;

    public static void registerResourceConditions() {
        populateEntries();
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

    private static void putEntry(String name, Boolean config_entry) {
        if(!NAME_TO_CONFIG_ENTRY.containsKey(name)) {
            NAME_TO_CONFIG_ENTRY.put(ADReference.makeModId(name).toString(), config_entry);
        } else {
            AssortedDiscoveries.LOGGER.error("{} is already registered!", name);
        }
    }

    private static void populateEntries() {
        // Passive plush config options
        putEntry("enable_allay_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_allay_plush").getValue());
        putEntry("enable_bat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_bat_plush").getValue());
        putEntry("enable_camel_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_camel_plush").getValue());
        putEntry("enable_tabby_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_tabby_cat_plush").getValue());
        putEntry("enable_tuxedo_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_tuxedo_cat_plush").getValue());
        putEntry("enable_red_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_red_cat_plush").getValue());
        putEntry("enable_siamese_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_siamese_cat_plush").getValue());
        putEntry("enable_british_shorthair_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_british_shorthair_cat_plush").getValue());
        putEntry("enable_calico_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_calico_cat_plush").getValue());
        putEntry("enable_persian_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_persian_cat_plush").getValue());
        putEntry("enable_ragdoll_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_ragdoll_cat_plush").getValue());
        putEntry("enable_white_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_white_cat_plush").getValue());
        putEntry("enable_black_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_black_cat_plush").getValue());
        putEntry("enable_jellie_cat_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_jellie_cat_plush").getValue());
        putEntry("enable_chicken_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_chicken_plush").getValue());
        putEntry("enable_cow_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_cow_plush").getValue());
        putEntry("enable_horse_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_horse_plushies").getValue());
        putEntry("enable_mooshroom_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_mooshroom_plushies").getValue());
        putEntry("enable_ocelot_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_ocelot_plush").getValue());
        putEntry("enable_pig_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_pig_plush").getValue());
        putEntry("enable_pufferfish_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_pufferfish_plush").getValue());
        putEntry("enable_rabbit_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_rabbit_plushies").getValue());
        putEntry("enable_sheep_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_sheep_plushies").getValue());
        putEntry("enable_squid_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_squid_plushies").getValue());
        putEntry("enable_strider_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_strider_plushies").getValue());
        putEntry("enable_villager_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_villager_plushies").getValue());
        putEntry("enable_wandering_trader_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("passive_plushies")
                .getEntry("enable_wandering_trader_plush").getValue());

        // Neutral plush config options
        putEntry("enable_bee_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_bee_plush").getValue());
        putEntry("enable_cave_spider_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_cave_spider_plush").getValue());
        putEntry("enable_enderman_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_enderman_plush").getValue());
        putEntry("enable_piglin_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_piglin_plushies").getValue());
        putEntry("enable_polar_bear_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_polar_bear_plush").getValue());
        putEntry("enable_spider_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_spider_plush").getValue());
        putEntry("enable_pale_wolf_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("neutral_plushies")
                .getEntry("enable_pale_wolf_plush").getValue());

        // Hostile plush config options
        putEntry("enable_blaze_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_blaze_plush").getValue());
        putEntry("enable_creeper_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_creeper_plush").getValue());
        putEntry("enable_ghast_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_ghast_plush").getValue());
        putEntry("enable_guardian_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_guardian_plush").getValue());
        putEntry("enable_hoglin_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_hoglin_plushies").getValue());
        putEntry("enable_illager_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_illager_plushies").getValue());
        putEntry("enable_magma_cube_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_magma_cube_plush").getValue());
        putEntry("enable_phantom_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_phantom_plush").getValue());
        putEntry("enable_ravager_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_ravager_plush").getValue());
        putEntry("enable_shulker_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_shulker_plush").getValue());
        putEntry("enable_skeleton_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_skeleton_plush").getValue());
        putEntry("enable_slime_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_slime_plush").getValue());
        putEntry("enable_vex_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_vex_plush").getValue());
        putEntry("enable_witch_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_witch_plush").getValue());
        putEntry("enable_wither_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_wither_plush").getValue());
        putEntry("enable_zombie_plush", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_zombie_plush").getValue());
        putEntry("enable_zombie_villager_plushies", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("hostile_plushies")
                .getEntry("enable_zombie_villager_plushies").getValue());

        // Farming config options
        putEntry("enable_overworld_planter_boxes", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("farming")
                .getEntry("enable_overworld_planter_boxes").getValue());
        putEntry("enable_nether_planter_boxes", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES.get("farming")
                .getEntry("enable_nether_planter_boxes").getValue());
        putEntry("enable_green_onions_and_wild_green_onions", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES
                .get("farming").getEntry("enable_green_onions_and_wild_green_onions").getValue());
        putEntry("enable_noodles_and_noodle_soup", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES
                .get("farming").getEntry("enable_noodles_and_noodle_soup").getValue());
        putEntry("enable_blueberry_pie", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES
                .get("farming").getEntry("enable_blueberry_pie").getValue());
        putEntry("enable_blueberry_juice", (Boolean) ADConfig.JANKSON_CONFIG_CATEGORIES
                .get("farming").getEntry("enable_blueberry_juice").getValue());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
