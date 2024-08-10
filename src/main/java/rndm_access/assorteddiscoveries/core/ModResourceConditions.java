package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;

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
                .getBooleanEntry("enable_allay_plushie").getValue());
        registerEntry("enable_bat_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_bat_plushie").getValue());
        registerEntry("enable_camel_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_camel_plushie").getValue());
        registerEntry("enable_cat_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_cat_plushies").getValue());
        registerEntry("enable_chicken_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_chicken_plushie").getValue());
        registerEntry("enable_cow_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_cow_plushie").getValue());
        registerEntry("enable_horse_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_horse_plushies").getValue());
        registerEntry("enable_mooshroom_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_mooshroom_plushies").getValue());
        registerEntry("enable_ocelot_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_ocelot_plushie").getValue());
        registerEntry("enable_pig_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_pig_plushie").getValue());
        registerEntry("enable_pufferfish_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_pufferfish_plushie").getValue());
        registerEntry("enable_rabbit_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_rabbit_plushies").getValue());
        registerEntry("enable_sheep_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_sheep_plushies").getValue());
        registerEntry("enable_squid_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_squid_plushies").getValue());
        registerEntry("enable_strider_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_strider_plushies").getValue());
        registerEntry("enable_villager_plushies", passivePlushiesSubcategory
                .getBooleanEntry("enable_villager_plushies").getValue());
        registerEntry("enable_wandering_trader_plushie", passivePlushiesSubcategory
                .getBooleanEntry("enable_wandering_trader_plushie").getValue());
        registerEntry("enable_bee_plushie", neutralPlushiesSubcategory
                .getBooleanEntry("enable_bee_plushie").getValue());
        registerEntry("enable_cave_spider_plushie", neutralPlushiesSubcategory
                .getBooleanEntry("enable_cave_spider_plushie").getValue());
        registerEntry("enable_enderman_plushie", neutralPlushiesSubcategory
                .getBooleanEntry("enable_enderman_plushie").getValue());
        registerEntry("enable_piglin_plushies", neutralPlushiesSubcategory
                .getBooleanEntry("enable_piglin_plushies").getValue());
        registerEntry("enable_polar_bear_plushie", neutralPlushiesSubcategory
                .getBooleanEntry("enable_polar_bear_plushie").getValue());
        registerEntry("enable_spider_plushie", neutralPlushiesSubcategory
                .getBooleanEntry("enable_spider_plushie").getValue());
        registerEntry("enable_pale_wolf_plushie", neutralPlushiesSubcategory
                .getBooleanEntry("enable_pale_wolf_plushie").getValue());
        registerEntry("enable_blaze_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_blaze_plushie").getValue());
        registerEntry("enable_creeper_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_creeper_plushie").getValue());
        registerEntry("enable_ghast_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_ghast_plushie").getValue());
        registerEntry("enable_guardian_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_guardian_plushie").getValue());
        registerEntry("enable_hoglin_plushies", hostilePlushiesSubcategory
                .getBooleanEntry("enable_hoglin_plushies").getValue());
        registerEntry("enable_illager_plushies", hostilePlushiesSubcategory
                .getBooleanEntry("enable_illager_plushies").getValue());
        registerEntry("enable_magma_cube_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_magma_cube_plushie").getValue());
        registerEntry("enable_phantom_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_phantom_plushie").getValue());
        registerEntry("enable_ravager_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_ravager_plushie").getValue());
        registerEntry("enable_shulker_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_shulker_plushie").getValue());
        registerEntry("enable_skeleton_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_skeleton_plushie").getValue());
        registerEntry("enable_slime_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_slime_plushie").getValue());
        registerEntry("enable_vex_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_vex_plushie").getValue());
        registerEntry("enable_witch_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_witch_plushie").getValue());
        registerEntry("enable_wither_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_wither_plushie").getValue());
        registerEntry("enable_zombie_plushie", hostilePlushiesSubcategory
                .getBooleanEntry("enable_zombie_plushie").getValue());
        registerEntry("enable_zombie_villager_plushies", hostilePlushiesSubcategory
                .getBooleanEntry("enable_zombie_villager_plushies").getValue());
        registerEntry("enable_smoky_quartz_blocks", buildingCategory
                .getBooleanEntry("enable_smoky_quartz_blocks").getValue());
        registerEntry("enable_smoky_quartz_bricks", buildingCategory
                .getBooleanEntry("enable_smoky_quartz_bricks").getValue());
        registerEntry("enable_woodcutter", buildingCategory
                .getBooleanEntry("enable_woodcutter").getValue());

        registerEntry("enable_wooden_planter_boxes", farmingCategory
                .getBooleanEntry("enable_wooden_planter_boxes").getValue());
        registerEntry("enable_green_onions", farmingCategory
                .getBooleanEntry("enable_green_onions").getValue());
        registerEntry("enable_noodle_soup", farmingCategory
                .getBooleanEntry("enable_noodle_soup").getValue());
        registerEntry("enable_blueberries", farmingCategory
                .getBooleanEntry("enable_blueberries").getValue());
        registerEntry("enable_blueberry_pie", farmingCategory
                .getBooleanEntry("enable_blueberry_pie").getValue());
        registerEntry("enable_blueberry_juice", farmingCategory
                .getBooleanEntry("enable_blueberry_juice").getValue());
        registerEntry("enable_sweet_berry_pie", farmingCategory
                .getBooleanEntry("enable_sweet_berry_pie").getValue());
        registerEntry("enable_sweet_berry_juice", farmingCategory
                .getBooleanEntry("enable_sweet_berry_juice").getValue());
        registerEntry("enable_chocolate_cake", farmingCategory
                .getBooleanEntry("enable_chocolate_cake").getValue());
        registerEntry("enable_red_velvet_cake", farmingCategory
                .getBooleanEntry("enable_red_velvet_cake").getValue());
        registerEntry("enable_fried_egg", farmingCategory
                .getBooleanEntry("enable_fried_egg").getValue());
        registerEntry("enable_hoglin_stew", farmingCategory
                .getBooleanEntry("enable_hoglin_stew").getValue());
        registerEntry("enable_forests_bounty", farmingCategory
                .getBooleanEntry("enable_forests_bounty").getValue());
        registerEntry("enable_witchs_cradle_soup", farmingCategory
                .getBooleanEntry("enable_witchs_cradle_soup").getValue());
        registerEntry("enable_pudding", farmingCategory
                .getBooleanEntry("enable_pudding").getValue());
        registerEntry("enable_caramel_apple", farmingCategory
                .getBooleanEntry("enable_caramel_apple").getValue());
        registerEntry("enable_cattails", farmingCategory
                .getBooleanEntry("enable_cattails").getValue());
        registerEntry("enable_blood_kelp", farmingCategory
                .getBooleanEntry("enable_blood_kelp").getValue());
        registerEntry("enable_ender_plants", farmingCategory
                .getBooleanEntry("enable_ender_plants").getValue());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
