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

    private static void putEntry(String name, boolean configEntry) {
        if(!NAME_TO_CONFIG_ENTRY.containsKey(name)) {
            NAME_TO_CONFIG_ENTRY.put(ADReference.makeModId(name).toString(), configEntry);
        } else {
            AssortedDiscoveries.LOGGER.error("{} is already registered!", name);
        }
    }

    private static void populateEntries() {
        // Passive plush config options
        putEntry("enable_allay_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_allay_plush").getValueAsBool());
        putEntry("enable_bat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_bat_plush").getValueAsBool());
        putEntry("enable_camel_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_camel_plush").getValueAsBool());
        putEntry("enable_tabby_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_tabby_cat_plush").getValueAsBool());
        putEntry("enable_tuxedo_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_tuxedo_cat_plush").getValueAsBool());
        putEntry("enable_red_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_red_cat_plush").getValueAsBool());
        putEntry("enable_siamese_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_siamese_cat_plush").getValueAsBool());
        putEntry("enable_british_shorthair_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_british_shorthair_cat_plush").getValueAsBool());
        putEntry("enable_calico_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_calico_cat_plush").getValueAsBool());
        putEntry("enable_persian_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_persian_cat_plush").getValueAsBool());
        putEntry("enable_ragdoll_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_ragdoll_cat_plush").getValueAsBool());
        putEntry("enable_white_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_white_cat_plush").getValueAsBool());
        putEntry("enable_black_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_black_cat_plush").getValueAsBool());
        putEntry("enable_jellie_cat_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_jellie_cat_plush").getValueAsBool());
        putEntry("enable_chicken_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_chicken_plush").getValueAsBool());
        putEntry("enable_cow_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_cow_plush").getValueAsBool());
        putEntry("enable_horse_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_horse_plushies").getValueAsBool());
        putEntry("enable_mooshroom_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_mooshroom_plushies").getValueAsBool());
        putEntry("enable_ocelot_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_ocelot_plush").getValueAsBool());
        putEntry("enable_pig_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_pig_plush").getValueAsBool());
        putEntry("enable_pufferfish_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_pufferfish_plush").getValueAsBool());
        putEntry("enable_rabbit_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_rabbit_plushies").getValueAsBool());
        putEntry("enable_sheep_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_sheep_plushies").getValueAsBool());
        putEntry("enable_squid_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_squid_plushies").getValueAsBool());
        putEntry("enable_strider_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_strider_plushies").getValueAsBool());
        putEntry("enable_villager_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_villager_plushies").getValueAsBool());
        putEntry("enable_wandering_trader_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("passive_plushies")
                .getEntry("enable_wandering_trader_plush").getValueAsBool());

        // Neutral plush config options
        putEntry("enable_bee_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_bee_plush").getValueAsBool());
        putEntry("enable_cave_spider_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_cave_spider_plush").getValueAsBool());
        putEntry("enable_enderman_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_enderman_plush").getValueAsBool());
        putEntry("enable_piglin_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_piglin_plushies").getValueAsBool());
        putEntry("enable_polar_bear_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_polar_bear_plush").getValueAsBool());
        putEntry("enable_spider_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_spider_plush").getValueAsBool());
        putEntry("enable_pale_wolf_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("neutral_plushies")
                .getEntry("enable_pale_wolf_plush").getValueAsBool());

        // Hostile plush config options
        putEntry("enable_blaze_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_blaze_plush").getValueAsBool());
        putEntry("enable_creeper_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_creeper_plush").getValueAsBool());
        putEntry("enable_ghast_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_ghast_plush").getValueAsBool());
        putEntry("enable_guardian_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_guardian_plush").getValueAsBool());
        putEntry("enable_hoglin_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_hoglin_plushies").getValueAsBool());
        putEntry("enable_illager_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_illager_plushies").getValueAsBool());
        putEntry("enable_magma_cube_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_magma_cube_plush").getValueAsBool());
        putEntry("enable_phantom_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_phantom_plush").getValueAsBool());
        putEntry("enable_ravager_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_ravager_plush").getValueAsBool());
        putEntry("enable_shulker_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_shulker_plush").getValueAsBool());
        putEntry("enable_skeleton_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_skeleton_plush").getValueAsBool());
        putEntry("enable_slime_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_slime_plush").getValueAsBool());
        putEntry("enable_vex_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_vex_plush").getValueAsBool());
        putEntry("enable_witch_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_witch_plush").getValueAsBool());
        putEntry("enable_wither_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_wither_plush").getValueAsBool());
        putEntry("enable_zombie_plush", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_zombie_plush").getValueAsBool());
        putEntry("enable_zombie_villager_plushies", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("hostile_plushies")
                .getEntry("enable_zombie_villager_plushies").getValueAsBool());

        // Farming config options
        putEntry("enable_wooden_planter_boxes", ADConfig.JSON_CONFIG_CATEGORIES.getCategory("farming")
                .getEntry("enable_wooden_planter_boxes").getValueAsBool());
        putEntry("enable_green_onions", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_green_onions").getValueAsBool());
        putEntry("enable_noodle_soup", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_noodle_soup").getValueAsBool());
        putEntry("enable_blueberries", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_blueberries").getValueAsBool());
        putEntry("enable_blueberry_pie", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_blueberry_pie").getValueAsBool());
        putEntry("enable_blueberry_juice", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_blueberry_juice").getValueAsBool());
        putEntry("enable_sweet_berry_pie", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_sweet_berry_pie").getValueAsBool());
        putEntry("enable_sweet_berry_juice", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_sweet_berry_juice").getValueAsBool());
        putEntry("enable_chocolate_cake", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_chocolate_cake").getValueAsBool());
        putEntry("enable_red_velvet_cake", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_red_velvet_cake").getValueAsBool());
        putEntry("enable_fried_egg", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_fried_egg").getValueAsBool());
        putEntry("enable_hoglin_stew", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_hoglin_stew").getValueAsBool());
        putEntry("enable_forests_bounty", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_forests_bounty").getValueAsBool());
        putEntry("enable_witchs_cradle_soup", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_witchs_cradle_soup").getValueAsBool());
        putEntry("enable_pudding", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_pudding").getValueAsBool());
        putEntry("enable_caramel_apple", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_caramel_apple").getValueAsBool());
        putEntry("enable_cattails", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_cattails").getValueAsBool());
        putEntry("enable_blood_kelp", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_blood_kelp").getValueAsBool());
        putEntry("enable_ender_plants", ADConfig.JSON_CONFIG_CATEGORIES
                .getCategory("farming").getEntry("enable_ender_plants").getValueAsBool());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
