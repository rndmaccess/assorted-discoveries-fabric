package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ModConfig {
    private static final Path CONFIG_PATH;
    public static final JsonConfig CONFIG;
    public static final JanksonConfigSerializer JANKSON_CONFIG_SERIALIZER;

    public static void loadOrCreateConfig() {
        if (Files.exists(CONFIG_PATH)) {
            LinkedList<JsonConfigCategory> savedCategories = JANKSON_CONFIG_SERIALIZER.deserializeConfig();

            if(savedCategories.isEmpty()) {
                AssortedDiscoveries.LOGGER.error("None of the categories could be loaded! "
                        + "Regenerating the config file!");
                JANKSON_CONFIG_SERIALIZER.serializeConfig();
            } else {
                for (JsonConfigCategory savedCategory : savedCategories) {
                    updateCategory(savedCategory);
                }

                // Re-serialize the config to make sure that the loaded data
                // is the same as the serialized data.
                JANKSON_CONFIG_SERIALIZER.serializeConfig();
            }
        } else {
            JANKSON_CONFIG_SERIALIZER.serializeConfig();
        }
    }

    private static void updateCategory(JsonConfigCategory savedCategory) {
        String savedCategoryName = savedCategory.getName();

        if (CONFIG.hasCategory(savedCategoryName)) {
            JsonConfigCategory defaultCategory = CONFIG.getCategory(savedCategoryName);

            updateValues(savedCategory, defaultCategory);
        }
    }

    private static void updateValues(JsonConfigCategory savedCategory,
                                     JsonConfigCategory defaultCategory) {
        for (JsonConfigObject savedObject : savedCategory.getJsonObjects()) {
            if(defaultCategory.hasSubcategory(savedObject.getName())) {
                updateValues(savedCategory.getSubcategory(savedObject.getName()),
                        defaultCategory.getSubcategory(savedObject.getName()));
            } else {
                if(defaultCategory.hasEntry(savedObject.getName())) {
                    JsonConfigEntry savedEntry = (JsonConfigEntry) savedObject;
                    String entryName = savedEntry.getName();
                    String savedValue = Objects.toString(savedEntry.getValue());
                    JsonConfigEntry defaultEntry = defaultCategory.getEntry(savedEntry.getName());

                    if(defaultEntry.isBooleanEntry()) {
                        JsonConfigBoolEntry defaultBoolEntry = (JsonConfigBoolEntry) defaultEntry;
                        boolean correctedValue = getCorrectedBoolValue(entryName, defaultBoolEntry.getValue(), savedValue);

                        defaultBoolEntry.setValue(correctedValue);
                    } else {
                        AssortedDiscoveries.LOGGER.error("This type is not supported. "
                                + "Resetting the value to its default!");
                        //defaultCategory.getEntry(savedObject.getName()).setValue(defaultEntry.getValue());
                    }
                }
            }
        }
    }

    private static Boolean getCorrectedBoolValue(String entryName, boolean defaultValue, String savedValue) {
        if(savedValue.equalsIgnoreCase("true") || savedValue.equalsIgnoreCase("false")) {
            return Boolean.valueOf(savedValue);
        } else {
            logCorrectionInfo(savedValue, String.valueOf(defaultValue), entryName);
            return defaultValue;
        }
    }

    /*
    private static Object getCorrectedValue(JsonConfigEntry defaultEntry, String savedValue) {
        if(defaultEntry.isBooleanEntry()) {
            JsonConfigBoolEntry defaultBoolEntry = (JsonConfigBoolEntry) defaultEntry;

            if(savedValue.equalsIgnoreCase("true") || savedValue.equalsIgnoreCase("false")) {
                return Boolean.valueOf(savedValue);
            } else {
                logCorrectionInfo(savedValue, String.valueOf(defaultBoolEntry.getValue()), defaultBoolEntry.getName());
                return defaultBoolEntry.getValue();
            }
        }
        else if(defaultEntry.getValue().getClass().equals(Integer.class)) {
            return Integer.parseInt(correctNumber(defaultEntry, savedValue));
        } else if(defaultEntry.getValue().getClass().equals(Long.class)) {
            return Long.parseLong(correctNumber(defaultEntry, savedValue));
        } else if(defaultEntry.getValue().getClass().equals(Double.class)) {
            return Double.parseDouble(correctDecimalNumber(defaultEntry, savedValue));
        } else if(defaultEntry.getValue().getClass().equals(Float.class)) {
            return Float.parseFloat(correctDecimalNumber(defaultEntry, savedValue));
        }
        else {
            return savedValue;
        }
    }
    */

    /*
    private static String correctNumber(JsonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()),
                    defaultEntry.getName());
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                if(!Character.isDigit(entryValue.charAt(i))) {
                    logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()),
                            defaultEntry.getName());
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private static String correctDecimalNumber(JsonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()),
                    defaultEntry.getName());
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                char c = entryValue.charAt(i);

                if(!Character.isDigit(c) || c != '.') {
                    logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()),
                            defaultEntry.getName());
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }
    */

    private static void logCorrectionInfo(String savedValue, String newValue, String entryName) {
        AssortedDiscoveries.LOGGER.info("Corrected the value {} to {} for config entry {}",
                savedValue, newValue, entryName);
    }

    private static JsonConfig makeConfig() {
        JsonConfig.Builder configBuilder = new JsonConfig.Builder();

        JsonConfigCategory dyedSubcategory = new JsonConfigCategory.Builder("dyed")
                .addEntry(new JsonConfigBoolEntry("enable_dyed_campfires", true))
                .addEntry(new JsonConfigBoolEntry("enable_dyed_lanterns", true))
                .addEntry(new JsonConfigBoolEntry("enable_dyed_torches", true)).build();

        JsonConfigCategory passivePlushiesSubcategory = new JsonConfigCategory.Builder("passive_plushies")
                .addEntry(new JsonConfigBoolEntry("enable_allay_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_bat_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_camel_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_cat_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_chicken_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_cow_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_horse_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_mooshroom_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_ocelot_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_pig_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_pufferfish_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_rabbit_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_sheep_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_squid_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_strider_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_villager_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_wandering_trader_plushie", true)).build();

        JsonConfigCategory neutralPlushiesSubcategory = new JsonConfigCategory.Builder("neutral_plushies")
                .addEntry(new JsonConfigBoolEntry("enable_bee_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_cave_spider_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_enderman_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_piglin_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_polar_bear_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_spider_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_pale_wolf_plushie", true)).build();

        JsonConfigCategory hostilePlushiesSubcategory = new JsonConfigCategory.Builder("hostile_plushies")
                .addEntry(new JsonConfigBoolEntry("enable_blaze_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_creeper_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_ghast_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_guardian_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_hoglin_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_illager_plushies", true))
                .addEntry(new JsonConfigBoolEntry("enable_magma_cube_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_phantom_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_ravager_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_shulker_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_skeleton_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_slime_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_vex_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_witch_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_wither_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_zombie_plushie", true))
                .addEntry(new JsonConfigBoolEntry("enable_zombie_villager_plushies", true)).build();

        JsonConfigCategory buildingCategory = new JsonConfigCategory.Builder("building")
                .addSubcategory(dyedSubcategory)
                .addSubcategory(passivePlushiesSubcategory)
                .addSubcategory(neutralPlushiesSubcategory)
                .addSubcategory(hostilePlushiesSubcategory)
                .addEntry(new JsonConfigBoolEntry("enable_wooden_walls", true))
                .addEntry(new JsonConfigBoolEntry("enable_stripped_wooden_walls", true))
                .addEntry(new JsonConfigBoolEntry("enable_wooden_rope_ladders", true))
                .addEntry(new JsonConfigBoolEntry("enable_iron_ladders", true))
                .addEntry(new JsonConfigBoolEntry("enable_blackstone_tiles", true))
                .addEntry(new JsonConfigBoolEntry("enable_twisted_blackstone", true))
                .addEntry(new JsonConfigBoolEntry("enable_twisted_blackstone_tiles", true,
                "Requires blackstone tiles!"))
                .addEntry(new JsonConfigBoolEntry("enable_twisted_netherrack", true))
                .addEntry(new JsonConfigBoolEntry("enable_twisted_nether_bricks", true))
                .addEntry(new JsonConfigBoolEntry(
                "enable_twisted_polished_blackstone_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_weeping_netherrack", true))
                .addEntry(new JsonConfigBoolEntry("enable_weeping_nether_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_weeping_blackstone", true))
                .addEntry(new JsonConfigBoolEntry(
                "enable_weeping_polished_blackstone_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_weeping_blackstone_tiles", true,
                "Requires blackstone tiles!"))
                .addEntry(new JsonConfigBoolEntry("enable_smoky_quartz_blocks", true))
                .addEntry(new JsonConfigBoolEntry("enable_smoky_quartz_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_smooth_smoky_quartz", true))
                .addEntry(new JsonConfigBoolEntry("enable_quartz_tiles", true))
                .addEntry(new JsonConfigBoolEntry("enable_quartz_walls", true))
                .addEntry(new JsonConfigBoolEntry("enable_bauxite", true))
                .addEntry(new JsonConfigBoolEntry("enable_bauxite_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_cracked_bauxite_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_mossy_bauxite_bricks", true))
                .addEntry(new JsonConfigBoolEntry("enable_stone_tiles", true))
                .addEntry(new JsonConfigBoolEntry("enable_cracked_stone_tiles", true))
                .addEntry(new JsonConfigBoolEntry("enable_mossy_stone_tiles", true))
                .addEntry(new JsonConfigBoolEntry("enable_woodcutter", true)).build();

        //TODO: Give enable_ender_plants a better name!
        JsonConfigCategory farmingCategory = new JsonConfigCategory.Builder("farming")
                .addEntry(new JsonConfigBoolEntry("enable_wooden_planter_boxes", true))
                .addEntry(new JsonConfigBoolEntry("enable_green_onions", true))
                .addEntry(new JsonConfigBoolEntry("enable_noodle_soup", true))
                .addEntry(new JsonConfigBoolEntry("enable_blueberries", true))
                .addEntry(new JsonConfigBoolEntry("enable_blueberry_pie", true))
                .addEntry(new JsonConfigBoolEntry("enable_blueberry_juice", true))
                .addEntry(new JsonConfigBoolEntry("enable_sweet_berry_pie", true))
                .addEntry(new JsonConfigBoolEntry("enable_sweet_berry_juice", true))
                .addEntry(new JsonConfigBoolEntry("enable_chocolate_cake", true))
                .addEntry(new JsonConfigBoolEntry("enable_red_velvet_cake", true))
                .addEntry(new JsonConfigBoolEntry("enable_fried_egg", true))
                .addEntry(new JsonConfigBoolEntry("enable_hoglin_stew", true))
                .addEntry(new JsonConfigBoolEntry("enable_forests_bounty", true))
                .addEntry(new JsonConfigBoolEntry("enable_witchs_cradle_soup", true))
                .addEntry(new JsonConfigBoolEntry("enable_pudding", true))
                .addEntry(new JsonConfigBoolEntry("enable_caramel_apple", true))
                .addEntry(new JsonConfigBoolEntry("enable_nether_berries", true))
                .addEntry(new JsonConfigBoolEntry("enable_purple_mushrooms", true))
                .addEntry(new JsonConfigBoolEntry("enable_cattails", true))
                .addEntry(new JsonConfigBoolEntry("enable_bog_blossoms", true))
                .addEntry(new JsonConfigBoolEntry("enable_blood_kelp", true))
                .addEntry(new JsonConfigBoolEntry("enable_ender_plants", true)).build();

        JsonConfigCategory miscCategory = new JsonConfigCategory.Builder("misc")
                .addEntry(new JsonConfigBoolEntry("rabbits_safe_fall_increased", true)).build();

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
