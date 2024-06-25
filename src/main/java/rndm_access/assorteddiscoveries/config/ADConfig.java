package rndm_access.assorteddiscoveries.config;

import rndm_access.assorteddiscoveries.config.jankson.ADJanksonConfigSerializer;
import rndm_access.assorteddiscoveries.config.jankson.ADJsonConfigCategory;
import rndm_access.assorteddiscoveries.config.jankson.ADJsonConfigEntry;

import java.util.*;

public class ADConfig {
    public static final LinkedHashMap<String, ADJsonConfigCategory> JSON_CONFIG_CATEGORIES;
    public static final ADJanksonConfigSerializer JANKSON_CONFIG_SERIALIZER;



    private static LinkedHashMap<String, ADJsonConfigCategory> getDefaultConfigCategories() {
        ADJsonConfigCategory passivePlushiesCategory = new ADJsonConfigCategory("passive_plushies");
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_allay_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_bat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_camel_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_tabby_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_tuxedo_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_red_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_siamese_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_british_shorthair_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_calico_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_persian_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_ragdoll_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_white_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_black_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_jellie_cat_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_chicken_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_cow_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_horse_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_mooshroom_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_ocelot_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_pig_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_pufferfish_plush", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_rabbit_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_sheep_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_squid_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_strider_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_villager_plushies", true));
        passivePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_wandering_trader_plush", true));

        ADJsonConfigCategory neutralPlushiesCategory = new ADJsonConfigCategory("neutral_plushies");
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_bee_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_cave_spider_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_enderman_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_piglin_plushies", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_polar_bear_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_spider_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_pale_wolf_plush", true));

        ADJsonConfigCategory hostilePlushiesCategory = new ADJsonConfigCategory("hostile_plushies");
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_blaze_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_creeper_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_ghast_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_guardian_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_hoglin_plushies", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_illager_plushies", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_magma_cube_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_phantom_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_ravager_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_shulker_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_skeleton_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_slime_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_vex_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_witch_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_wither_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_zombie_plush", true));
        hostilePlushiesCategory.addEntry(new ADJsonConfigEntry("enable_zombie_villager_plushies", true));

        ADJsonConfigCategory farmingCategory = new ADJsonConfigCategory("farming");
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_overworld_planter_boxes", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_nether_planter_boxes", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_green_onions_and_wild_green_onions",
                true, "If disabled noodle soup does not use green onions."));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_noodles_and_noodle_soup", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_blueberry_pie", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_blueberry_juice", true));

        ADJsonConfigCategory miscCategory = new ADJsonConfigCategory("misc");
        miscCategory.addEntry(new ADJsonConfigEntry("rabbits_safe_fall_increased", true));

        LinkedHashMap<String, ADJsonConfigCategory> jsonConfigCategories = new LinkedHashMap<>();
        jsonConfigCategories.put(passivePlushiesCategory.getName(), passivePlushiesCategory);
        jsonConfigCategories.put(neutralPlushiesCategory.getName(), neutralPlushiesCategory);
        jsonConfigCategories.put(hostilePlushiesCategory.getName(), hostilePlushiesCategory);
        jsonConfigCategories.put(farmingCategory.getName(), farmingCategory);
        jsonConfigCategories.put(miscCategory.getName(), miscCategory);
        return jsonConfigCategories;
    }

    static {
        JSON_CONFIG_CATEGORIES = getDefaultConfigCategories();
        JANKSON_CONFIG_SERIALIZER = new ADJanksonConfigSerializer(JSON_CONFIG_CATEGORIES);
    }
}
