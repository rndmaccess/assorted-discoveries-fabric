package rndm_access.assorteddiscoveries.item.crafting;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ADConfig;
import rndm_access.assorteddiscoveries.config.json.ADJsonConfigCategory;

import java.util.Map;

public class ADResourceConditions {
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

    private static void registerConfigEntryConditions() {
        ADJsonConfigCategory buildingCategory = ADConfig.CONFIG.getCategory("building");
        ADJsonConfigCategory farmingCategory = ADConfig.CONFIG.getCategory("farming");
        ADJsonConfigCategory passivePlushiesSubcategory = buildingCategory
                .getSubcategory("passive_plushies");
        ADJsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                .getSubcategory("neutral_plushies");
        ADJsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                .getSubcategory("hostile_plushies");

        registerEntry("enable_allay_plush", passivePlushiesSubcategory
                .getEntry("enable_allay_plush").getValueAsBool());
        registerEntry("enable_bat_plush", passivePlushiesSubcategory
                .getEntry("enable_bat_plush").getValueAsBool());
        registerEntry("enable_camel_plush", passivePlushiesSubcategory
                .getEntry("enable_camel_plush").getValueAsBool());
        registerEntry("enable_cat_plushies", passivePlushiesSubcategory
                .getEntry("enable_cat_plushies").getValueAsBool());
        registerEntry("enable_chicken_plush", passivePlushiesSubcategory
                .getEntry("enable_chicken_plush").getValueAsBool());
        registerEntry("enable_cow_plush", passivePlushiesSubcategory
                .getEntry("enable_cow_plush").getValueAsBool());
        registerEntry("enable_horse_plushies", passivePlushiesSubcategory
                .getEntry("enable_horse_plushies").getValueAsBool());
        registerEntry("enable_mooshroom_plushies", passivePlushiesSubcategory
                .getEntry("enable_mooshroom_plushies").getValueAsBool());
        registerEntry("enable_ocelot_plush", passivePlushiesSubcategory
                .getEntry("enable_ocelot_plush").getValueAsBool());
        registerEntry("enable_pig_plush", passivePlushiesSubcategory
                .getEntry("enable_pig_plush").getValueAsBool());
        registerEntry("enable_pufferfish_plush", passivePlushiesSubcategory
                .getEntry("enable_pufferfish_plush").getValueAsBool());
        registerEntry("enable_rabbit_plushies", passivePlushiesSubcategory
                .getEntry("enable_rabbit_plushies").getValueAsBool());
        registerEntry("enable_sheep_plushies", passivePlushiesSubcategory
                .getEntry("enable_sheep_plushies").getValueAsBool());
        registerEntry("enable_squid_plushies", passivePlushiesSubcategory
                .getEntry("enable_squid_plushies").getValueAsBool());
        registerEntry("enable_strider_plushies", passivePlushiesSubcategory
                .getEntry("enable_strider_plushies").getValueAsBool());
        registerEntry("enable_villager_plushies", passivePlushiesSubcategory
                .getEntry("enable_villager_plushies").getValueAsBool());
        registerEntry("enable_wandering_trader_plush", passivePlushiesSubcategory
                .getEntry("enable_wandering_trader_plush").getValueAsBool());
        registerEntry("enable_bee_plush", neutralPlushiesSubcategory
                .getEntry("enable_bee_plush").getValueAsBool());
        registerEntry("enable_cave_spider_plush", neutralPlushiesSubcategory
                .getEntry("enable_cave_spider_plush").getValueAsBool());
        registerEntry("enable_enderman_plush", neutralPlushiesSubcategory
                .getEntry("enable_enderman_plush").getValueAsBool());
        registerEntry("enable_piglin_plushies", neutralPlushiesSubcategory
                .getEntry("enable_piglin_plushies").getValueAsBool());
        registerEntry("enable_polar_bear_plush", neutralPlushiesSubcategory
                .getEntry("enable_polar_bear_plush").getValueAsBool());
        registerEntry("enable_spider_plush", neutralPlushiesSubcategory
                .getEntry("enable_spider_plush").getValueAsBool());
        registerEntry("enable_pale_wolf_plush", neutralPlushiesSubcategory
                .getEntry("enable_pale_wolf_plush").getValueAsBool());
        registerEntry("enable_blaze_plush", hostilePlushiesSubcategory
                .getEntry("enable_blaze_plush").getValueAsBool());
        registerEntry("enable_creeper_plush", hostilePlushiesSubcategory
                .getEntry("enable_creeper_plush").getValueAsBool());
        registerEntry("enable_ghast_plush", hostilePlushiesSubcategory
                .getEntry("enable_ghast_plush").getValueAsBool());
        registerEntry("enable_guardian_plush", hostilePlushiesSubcategory
                .getEntry("enable_guardian_plush").getValueAsBool());
        registerEntry("enable_hoglin_plushies", hostilePlushiesSubcategory
                .getEntry("enable_hoglin_plushies").getValueAsBool());
        registerEntry("enable_illager_plushies", hostilePlushiesSubcategory
                .getEntry("enable_illager_plushies").getValueAsBool());
        registerEntry("enable_magma_cube_plush", hostilePlushiesSubcategory
                .getEntry("enable_magma_cube_plush").getValueAsBool());
        registerEntry("enable_phantom_plush", hostilePlushiesSubcategory
                .getEntry("enable_phantom_plush").getValueAsBool());
        registerEntry("enable_ravager_plush", hostilePlushiesSubcategory
                .getEntry("enable_ravager_plush").getValueAsBool());
        registerEntry("enable_shulker_plush", hostilePlushiesSubcategory
                .getEntry("enable_shulker_plush").getValueAsBool());
        registerEntry("enable_skeleton_plush", hostilePlushiesSubcategory
                .getEntry("enable_skeleton_plush").getValueAsBool());
        registerEntry("enable_slime_plush", hostilePlushiesSubcategory
                .getEntry("enable_slime_plush").getValueAsBool());
        registerEntry("enable_vex_plush", hostilePlushiesSubcategory
                .getEntry("enable_vex_plush").getValueAsBool());
        registerEntry("enable_witch_plush", hostilePlushiesSubcategory
                .getEntry("enable_witch_plush").getValueAsBool());
        registerEntry("enable_wither_plush", hostilePlushiesSubcategory
                .getEntry("enable_wither_plush").getValueAsBool());
        registerEntry("enable_zombie_plush", hostilePlushiesSubcategory
                .getEntry("enable_zombie_plush").getValueAsBool());
        registerEntry("enable_zombie_villager_plushies", hostilePlushiesSubcategory
                .getEntry("enable_zombie_villager_plushies").getValueAsBool());
        registerEntry("enable_smoky_quartz_blocks", buildingCategory
                .getEntry("enable_smoky_quartz_blocks").getValueAsBool());
        registerEntry("enable_smoky_quartz_bricks", buildingCategory
                .getEntry("enable_smoky_quartz_bricks").getValueAsBool());
        registerEntry("enable_woodcutter", buildingCategory
                .getEntry("enable_woodcutter").getValueAsBool());

        registerEntry("enable_wooden_planter_boxes", farmingCategory
                .getEntry("enable_wooden_planter_boxes").getValueAsBool());
        registerEntry("enable_green_onions", farmingCategory
                .getEntry("enable_green_onions").getValueAsBool());
        registerEntry("enable_noodle_soup", farmingCategory
                .getEntry("enable_noodle_soup").getValueAsBool());
        registerEntry("enable_blueberries", farmingCategory
                .getEntry("enable_blueberries").getValueAsBool());
        registerEntry("enable_blueberry_pie", farmingCategory
                .getEntry("enable_blueberry_pie").getValueAsBool());
        registerEntry("enable_blueberry_juice", farmingCategory
                .getEntry("enable_blueberry_juice").getValueAsBool());
        registerEntry("enable_sweet_berry_pie", farmingCategory
                .getEntry("enable_sweet_berry_pie").getValueAsBool());
        registerEntry("enable_sweet_berry_juice", farmingCategory
                .getEntry("enable_sweet_berry_juice").getValueAsBool());
        registerEntry("enable_chocolate_cake", farmingCategory
                .getEntry("enable_chocolate_cake").getValueAsBool());
        registerEntry("enable_red_velvet_cake", farmingCategory
                .getEntry("enable_red_velvet_cake").getValueAsBool());
        registerEntry("enable_fried_egg", farmingCategory
                .getEntry("enable_fried_egg").getValueAsBool());
        registerEntry("enable_hoglin_stew", farmingCategory
                .getEntry("enable_hoglin_stew").getValueAsBool());
        registerEntry("enable_forests_bounty", farmingCategory
                .getEntry("enable_forests_bounty").getValueAsBool());
        registerEntry("enable_witchs_cradle_soup", farmingCategory
                .getEntry("enable_witchs_cradle_soup").getValueAsBool());
        registerEntry("enable_pudding", farmingCategory
                .getEntry("enable_pudding").getValueAsBool());
        registerEntry("enable_caramel_apple", farmingCategory
                .getEntry("enable_caramel_apple").getValueAsBool());
        registerEntry("enable_cattails", farmingCategory
                .getEntry("enable_cattails").getValueAsBool());
        registerEntry("enable_blood_kelp", farmingCategory
                .getEntry("enable_blood_kelp").getValueAsBool());
        registerEntry("enable_ender_plants", farmingCategory
                .getEntry("enable_ender_plants").getValueAsBool());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
