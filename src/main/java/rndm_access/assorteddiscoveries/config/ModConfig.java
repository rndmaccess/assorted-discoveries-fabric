package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonBooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;

import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    public static final Path CONFIG_PATH;
    public static final JsonConfig CONFIG;
    public static final JanksonConfigSerializer JANKSON_CONFIG_SERIALIZER;

    public static void loadOrCreateConfig() {
        if (Files.exists(CONFIG_PATH)) {
            JANKSON_CONFIG_SERIALIZER.deserializeConfig();

            // Re-serialize the config to make sure that the loaded data
            // is the same as the serialized data.
            JANKSON_CONFIG_SERIALIZER.serializeConfig();
        } else {
            JANKSON_CONFIG_SERIALIZER.serializeConfig();
        }
    }

    private static JsonConfig makeConfig() {
        JsonConfig.Builder configBuilder = new JsonConfig.Builder();

        JsonConfigCategory dyedSubcategory = new JsonConfigCategory.Builder("dyed")
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_dyed_campfires", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_dyed_lanterns", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_dyed_torches", true)).build();

        JsonConfigCategory passivePlushiesSubcategory = new JsonConfigCategory.Builder("passive_plushies")
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_allay_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_bat_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_camel_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_cat_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_chicken_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_cow_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_horse_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_mooshroom_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_ocelot_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_pig_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_pufferfish_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_rabbit_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_sheep_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_squid_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_strider_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_villager_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_wandering_trader_plushie", true)).build();

        JsonConfigCategory neutralPlushiesSubcategory = new JsonConfigCategory.Builder("neutral_plushies")
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_bee_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_cave_spider_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_enderman_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_piglin_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_polar_bear_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_spider_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_pale_wolf_plushie", true)).build();

        JsonConfigCategory hostilePlushiesSubcategory = new JsonConfigCategory.Builder("hostile_plushies")
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_blaze_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_creeper_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_ghast_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_guardian_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_hoglin_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_illager_plushies", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_magma_cube_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_phantom_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_ravager_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_shulker_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_skeleton_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_slime_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_vex_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_witch_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_wither_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_zombie_plushie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_zombie_villager_plushies", true)).build();

        JsonConfigCategory buildingCategory = new JsonConfigCategory.Builder("building")
                .addSubcategory(dyedSubcategory)
                .addSubcategory(passivePlushiesSubcategory)
                .addSubcategory(neutralPlushiesSubcategory)
                .addSubcategory(hostilePlushiesSubcategory)
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_wooden_walls", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_stripped_wooden_walls", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_wooden_rope_ladders", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_iron_ladders", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_blackstone_tiles", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_twisted_blackstone", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_twisted_blackstone_tiles", true,
                "Requires blackstone tiles!"))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_twisted_netherrack", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_twisted_nether_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry(
                "enable_twisted_polished_blackstone_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_weeping_netherrack", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_weeping_nether_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_weeping_blackstone", true))
                .addBooleanEntry(new JsonBooleanConfigEntry(
                "enable_weeping_polished_blackstone_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_weeping_blackstone_tiles", true,
                "Requires blackstone tiles!"))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_smoky_quartz_blocks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_smoky_quartz_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_smooth_smoky_quartz", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_quartz_tiles", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_quartz_walls", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_bauxite", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_bauxite_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_cracked_bauxite_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_mossy_bauxite_bricks", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_stone_tiles", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_cracked_stone_tiles", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_mossy_stone_tiles", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_woodcutter", true)).build();

        //TODO: Give enable_ender_plants a better name!
        JsonConfigCategory farmingCategory = new JsonConfigCategory.Builder("farming")
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_wooden_planter_boxes", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_green_onions", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_noodle_soup", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_blueberries", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_blueberry_pie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_blueberry_juice", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_sweet_berry_pie", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_sweet_berry_juice", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_chocolate_cake", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_red_velvet_cake", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_fried_egg", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_hoglin_stew", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_forests_bounty", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_witchs_cradle_soup", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_pudding", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_caramel_apple", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_nether_berries", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_purple_mushrooms", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_cattails", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_bog_blossoms", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_blood_kelp", true))
                .addBooleanEntry(new JsonBooleanConfigEntry("enable_ender_plants", true)).build();

        JsonConfigCategory miscCategory = new JsonConfigCategory.Builder("misc")
                .addBooleanEntry(new JsonBooleanConfigEntry("rabbits_safe_fall_increased", true))
                .build();

        return configBuilder.addCategory(buildingCategory).addCategory(farmingCategory)
                .addCategory(miscCategory).build();
    }

    static {
        CONFIG_PATH = FabricLoader.getInstance().getConfigDir()
                .resolve(ADReference.MOD_ID + ".json5");
        CONFIG = makeConfig();
        JANKSON_CONFIG_SERIALIZER = new JanksonConfigSerializer(CONFIG, CONFIG_PATH);
    }
}
