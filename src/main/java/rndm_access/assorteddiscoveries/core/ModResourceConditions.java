package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.json.JsonConfigBoolEntry;
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

        registerEntry("enable_allay_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_allay_plushie")).getValue());
        registerEntry("enable_bat_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_bat_plushie")).getValue());
        registerEntry("enable_camel_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_camel_plushie")).getValue());
        registerEntry("enable_cat_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_cat_plushies")).getValue());
        registerEntry("enable_chicken_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_chicken_plushie")).getValue());
        registerEntry("enable_cow_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_cow_plushie")).getValue());
        registerEntry("enable_horse_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_horse_plushies")).getValue());
        registerEntry("enable_mooshroom_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_mooshroom_plushies")).getValue());
        registerEntry("enable_ocelot_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_ocelot_plushie")).getValue());
        registerEntry("enable_pig_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_pig_plushie")).getValue());
        registerEntry("enable_pufferfish_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_pufferfish_plushie")).getValue());
        registerEntry("enable_rabbit_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_rabbit_plushies")).getValue());
        registerEntry("enable_sheep_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_sheep_plushies")).getValue());
        registerEntry("enable_squid_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_squid_plushies")).getValue());
        registerEntry("enable_strider_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_strider_plushies")).getValue());
        registerEntry("enable_villager_plushies", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_villager_plushies")).getValue());
        registerEntry("enable_wandering_trader_plushie", ((JsonConfigBoolEntry) passivePlushiesSubcategory
                .getEntry("enable_wandering_trader_plushie")).getValue());
        registerEntry("enable_bee_plushie", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_bee_plushie")).getValue());
        registerEntry("enable_cave_spider_plushie", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_cave_spider_plushie")).getValue());
        registerEntry("enable_enderman_plushie", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_enderman_plushie")).getValue());
        registerEntry("enable_piglin_plushies", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_piglin_plushies")).getValue());
        registerEntry("enable_polar_bear_plushie", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_polar_bear_plushie")).getValue());
        registerEntry("enable_spider_plushie", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_spider_plushie")).getValue());
        registerEntry("enable_pale_wolf_plushie", ((JsonConfigBoolEntry) neutralPlushiesSubcategory
                .getEntry("enable_pale_wolf_plushie")).getValue());
        registerEntry("enable_blaze_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_blaze_plushie")).getValue());
        registerEntry("enable_creeper_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_creeper_plushie")).getValue());
        registerEntry("enable_ghast_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_ghast_plushie")).getValue());
        registerEntry("enable_guardian_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_guardian_plushie")).getValue());
        registerEntry("enable_hoglin_plushies", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_hoglin_plushies")).getValue());
        registerEntry("enable_illager_plushies", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_illager_plushies")).getValue());
        registerEntry("enable_magma_cube_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_magma_cube_plushie")).getValue());
        registerEntry("enable_phantom_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_phantom_plushie")).getValue());
        registerEntry("enable_ravager_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_ravager_plushie")).getValue());
        registerEntry("enable_shulker_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_shulker_plushie")).getValue());
        registerEntry("enable_skeleton_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_skeleton_plushie")).getValue());
        registerEntry("enable_slime_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_slime_plushie")).getValue());
        registerEntry("enable_vex_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_vex_plushie")).getValue());
        registerEntry("enable_witch_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_witch_plushie")).getValue());
        registerEntry("enable_wither_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_wither_plushie")).getValue());
        registerEntry("enable_zombie_plushie", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_zombie_plushie")).getValue());
        registerEntry("enable_zombie_villager_plushies", ((JsonConfigBoolEntry) hostilePlushiesSubcategory
                .getEntry("enable_zombie_villager_plushies")).getValue());
        registerEntry("enable_smoky_quartz_blocks", ((JsonConfigBoolEntry) buildingCategory
                .getEntry("enable_smoky_quartz_blocks")).getValue());
        registerEntry("enable_smoky_quartz_bricks", ((JsonConfigBoolEntry) buildingCategory
                .getEntry("enable_smoky_quartz_bricks")).getValue());
        registerEntry("enable_woodcutter", ((JsonConfigBoolEntry) buildingCategory
                .getEntry("enable_woodcutter")).getValue());

        registerEntry("enable_wooden_planter_boxes", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_wooden_planter_boxes")).getValue());
        registerEntry("enable_green_onions", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_green_onions")).getValue());
        registerEntry("enable_noodle_soup", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_noodle_soup")).getValue());
        registerEntry("enable_blueberries", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_blueberries")).getValue());
        registerEntry("enable_blueberry_pie", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_blueberry_pie")).getValue());
        registerEntry("enable_blueberry_juice", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_blueberry_juice")).getValue());
        registerEntry("enable_sweet_berry_pie", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_sweet_berry_pie")).getValue());
        registerEntry("enable_sweet_berry_juice", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_sweet_berry_juice")).getValue());
        registerEntry("enable_chocolate_cake", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_chocolate_cake")).getValue());
        registerEntry("enable_red_velvet_cake", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_red_velvet_cake")).getValue());
        registerEntry("enable_fried_egg", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_fried_egg")).getValue());
        registerEntry("enable_hoglin_stew", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_hoglin_stew")).getValue());
        registerEntry("enable_forests_bounty", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_forests_bounty")).getValue());
        registerEntry("enable_witchs_cradle_soup", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_witchs_cradle_soup")).getValue());
        registerEntry("enable_pudding", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_pudding")).getValue());
        registerEntry("enable_caramel_apple", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_caramel_apple")).getValue());
        registerEntry("enable_cattails", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_cattails")).getValue());
        registerEntry("enable_blood_kelp", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_blood_kelp")).getValue());
        registerEntry("enable_ender_plants", ((JsonConfigBoolEntry) farmingCategory
                .getEntry("enable_ender_plants")).getValue());
    }

    static {
        NAME_TO_CONFIG_ENTRY = Maps.newHashMap();
        CONFIG_ENTRY_ENABLED = ADReference.makeModId("config_entry_enabled");
    }
}
