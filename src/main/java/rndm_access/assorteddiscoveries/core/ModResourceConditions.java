package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.json.JsonConfigCategory;

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

    private static void registerConfigEntryConditions() {
        JsonConfigCategory buildingCategory = ModConfig.CONFIG.getCategory("building");
        JsonConfigCategory farmingCategory = ModConfig.CONFIG.getCategory("farming");
        JsonConfigCategory passivePlushiesSubcategory = buildingCategory
                .getSubcategory("passive_plushies");
        JsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                .getSubcategory("neutral_plushies");
        JsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                .getSubcategory("hostile_plushies");

        registerEntry("enable_allay_plushie", passivePlushiesSubcategory
                .getEntry("enable_allay_plushie").getValueAsBool());
        registerEntry("enable_bat_plushie", passivePlushiesSubcategory
                .getEntry("enable_bat_plushie").getValueAsBool());
        registerEntry("enable_camel_plushie", passivePlushiesSubcategory
                .getEntry("enable_camel_plushie").getValueAsBool());
        registerEntry("enable_cat_plushies", passivePlushiesSubcategory
                .getEntry("enable_cat_plushies").getValueAsBool());
        registerEntry("enable_chicken_plushie", passivePlushiesSubcategory
                .getEntry("enable_chicken_plushie").getValueAsBool());
        registerEntry("enable_cow_plushie", passivePlushiesSubcategory
                .getEntry("enable_cow_plushie").getValueAsBool());
        registerEntry("enable_horse_plushies", passivePlushiesSubcategory
                .getEntry("enable_horse_plushies").getValueAsBool());
        registerEntry("enable_mooshroom_plushies", passivePlushiesSubcategory
                .getEntry("enable_mooshroom_plushies").getValueAsBool());
        registerEntry("enable_ocelot_plushie", passivePlushiesSubcategory
                .getEntry("enable_ocelot_plushie").getValueAsBool());
        registerEntry("enable_pig_plushie", passivePlushiesSubcategory
                .getEntry("enable_pig_plushie").getValueAsBool());
        registerEntry("enable_pufferfish_plushie", passivePlushiesSubcategory
                .getEntry("enable_pufferfish_plushie").getValueAsBool());
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
        registerEntry("enable_wandering_trader_plushie", passivePlushiesSubcategory
                .getEntry("enable_wandering_trader_plushie").getValueAsBool());
        registerEntry("enable_bee_plushie", neutralPlushiesSubcategory
                .getEntry("enable_bee_plushie").getValueAsBool());
        registerEntry("enable_cave_spider_plushie", neutralPlushiesSubcategory
                .getEntry("enable_cave_spider_plushie").getValueAsBool());
        registerEntry("enable_enderman_plushie", neutralPlushiesSubcategory
                .getEntry("enable_enderman_plushie").getValueAsBool());
        registerEntry("enable_piglin_plushies", neutralPlushiesSubcategory
                .getEntry("enable_piglin_plushies").getValueAsBool());
        registerEntry("enable_polar_bear_plushie", neutralPlushiesSubcategory
                .getEntry("enable_polar_bear_plushie").getValueAsBool());
        registerEntry("enable_spider_plushie", neutralPlushiesSubcategory
                .getEntry("enable_spider_plushie").getValueAsBool());
        registerEntry("enable_pale_wolf_plushie", neutralPlushiesSubcategory
                .getEntry("enable_pale_wolf_plushie").getValueAsBool());
        registerEntry("enable_blaze_plushie", hostilePlushiesSubcategory
                .getEntry("enable_blaze_plushie").getValueAsBool());
        registerEntry("enable_creeper_plushie", hostilePlushiesSubcategory
                .getEntry("enable_creeper_plushie").getValueAsBool());
        registerEntry("enable_ghast_plushie", hostilePlushiesSubcategory
                .getEntry("enable_ghast_plushie").getValueAsBool());
        registerEntry("enable_guardian_plushie", hostilePlushiesSubcategory
                .getEntry("enable_guardian_plushie").getValueAsBool());
        registerEntry("enable_hoglin_plushies", hostilePlushiesSubcategory
                .getEntry("enable_hoglin_plushies").getValueAsBool());
        registerEntry("enable_illager_plushies", hostilePlushiesSubcategory
                .getEntry("enable_illager_plushies").getValueAsBool());
        registerEntry("enable_magma_cube_plushie", hostilePlushiesSubcategory
                .getEntry("enable_magma_cube_plushie").getValueAsBool());
        registerEntry("enable_phantom_plushie", hostilePlushiesSubcategory
                .getEntry("enable_phantom_plushie").getValueAsBool());
        registerEntry("enable_ravager_plushie", hostilePlushiesSubcategory
                .getEntry("enable_ravager_plushie").getValueAsBool());
        registerEntry("enable_shulker_plushie", hostilePlushiesSubcategory
                .getEntry("enable_shulker_plushie").getValueAsBool());
        registerEntry("enable_skeleton_plushie", hostilePlushiesSubcategory
                .getEntry("enable_skeleton_plushie").getValueAsBool());
        registerEntry("enable_slime_plushie", hostilePlushiesSubcategory
                .getEntry("enable_slime_plushie").getValueAsBool());
        registerEntry("enable_vex_plushie", hostilePlushiesSubcategory
                .getEntry("enable_vex_plushie").getValueAsBool());
        registerEntry("enable_witch_plushie", hostilePlushiesSubcategory
                .getEntry("enable_witch_plushie").getValueAsBool());
        registerEntry("enable_wither_plushie", hostilePlushiesSubcategory
                .getEntry("enable_wither_plushie").getValueAsBool());
        registerEntry("enable_zombie_plushie", hostilePlushiesSubcategory
                .getEntry("enable_zombie_plushie").getValueAsBool());
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
