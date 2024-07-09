package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ADConfig {
    private static final Path CONFIG_PATH;
    public static final ADJsonConfig CONFIG;
    public static final ADJanksonConfigSerializer JANKSON_CONFIG_SERIALIZER;

    public static void loadOrCreateConfig() {
        if (Files.exists(CONFIG_PATH)) {
            LinkedList<ADJsonConfigCategory> savedCategories = JANKSON_CONFIG_SERIALIZER.deserializeConfig();

            if(savedCategories.isEmpty()) {
                AssortedDiscoveries.LOGGER.error("None of the categories could be loaded! Regenerating the config file!");
                JANKSON_CONFIG_SERIALIZER.serializeConfig();
            } else {
                for (ADJsonConfigCategory savedCategory : savedCategories) {
                    updateCategory(savedCategory);
                }

                // Re-serialize the config to make sure that the loaded data is the same as the serialized data.
                JANKSON_CONFIG_SERIALIZER.serializeConfig();
            }
        } else {
            JANKSON_CONFIG_SERIALIZER.serializeConfig();
        }
    }

    private static void updateCategory(ADJsonConfigCategory savedCategory) {
        String savedCategoryName = savedCategory.getName();

        if (CONFIG.hasCategory(savedCategoryName)) {
            ADJsonConfigCategory defaultCategory = CONFIG.getCategory(savedCategoryName);

            updateValues(savedCategory, defaultCategory);
        }
    }

    private static void updateValues(ADJsonConfigCategory savedCategory,
                                     ADJsonConfigCategory defaultCategory) {
        for (ADJsonConfigComponent savedComponent : savedCategory.getComponents()) {
            if(defaultCategory.hasSubcategory(savedComponent.getName())) {
                updateValues(savedCategory.getSubcategory(savedComponent.getName()),
                        defaultCategory.getSubcategory(savedComponent.getName()));
            } else {
                if(defaultCategory.hasEntry(savedComponent.getName())) {
                    ADJsonConfigEntry savedEntry = (ADJsonConfigEntry) savedComponent;
                    String savedValue = Objects.toString(savedEntry.getValue());
                    ADJsonConfigEntry defaultEntry = defaultCategory.getEntry(savedEntry.getName());
                    Object fixedSavedValue = getCorrectedValue(defaultEntry, savedValue);

                    defaultCategory.getEntry(savedComponent.getName()).setValue(fixedSavedValue);
                }
            }
        }
    }

    private static Object getCorrectedValue(ADJsonConfigEntry defaultEntry, String savedValue) {
        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            if(isBoolean(savedValue)) {
                return Boolean.valueOf(savedValue);
            } else {
                logCorrectionInfo(savedValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
                return defaultEntry.getValue();
            }
        } else if(defaultEntry.getValue().getClass().equals(Integer.class)) {
            return Integer.parseInt(correctNumber(defaultEntry, savedValue));
        } else if(defaultEntry.getValue().getClass().equals(Long.class)) {
            return Long.parseLong(correctNumber(defaultEntry, savedValue));
        } else if(defaultEntry.getValue().getClass().equals(Double.class)) {
            return Double.parseDouble(correctDecimalNumber(defaultEntry, savedValue));
        } else if(defaultEntry.getValue().getClass().equals(Float.class)) {
            return Float.parseFloat(correctDecimalNumber(defaultEntry, savedValue));
        } else {
            return savedValue;
        }
    }

    private static boolean isBoolean(String value) {
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
    }

    private static String correctNumber(ADJsonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                if(!Character.isDigit(entryValue.charAt(i))) {
                    logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private static String correctDecimalNumber(ADJsonConfigEntry defaultEntry, String entryValue) {
        if(entryValue.isEmpty()) {
            logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
            return String.valueOf(defaultEntry.getValue());
        } else {
            for (int i = 0; i < entryValue.length(); i++) {
                char c = entryValue.charAt(i);

                if(!Character.isDigit(c) || c != '.') {
                    logCorrectionInfo(entryValue, String.valueOf(defaultEntry.getValue()), defaultEntry.getName());
                    return String.valueOf(defaultEntry.getValue());
                }
            }
            return entryValue;
        }
    }

    private static void logCorrectionInfo(String savedValue, String newValue, String entryName) {
        AssortedDiscoveries.LOGGER.info("Corrected the value {} to {} for config entry {}",
                savedValue, newValue, entryName);
    }

    private static ADJsonConfig makeConfig() {
        ADJsonConfig.Builder configBuilder = new ADJsonConfig.Builder();

        ADJsonConfigCategory dyedSubcategory = new ADJsonConfigCategory.Builder("dyed")
                .addEntry(new ADJsonConfigEntry("enable_dyed_campfires", true))
                .addEntry(new ADJsonConfigEntry("enable_dyed_lanterns", true))
                .addEntry(new ADJsonConfigEntry("enable_dyed_torches", true)).build();

        ADJsonConfigCategory passivePlushiesSubcategory = new ADJsonConfigCategory.Builder("passive_plushies")
                .addEntry(new ADJsonConfigEntry("enable_allay_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_bat_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_camel_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_cat_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_chicken_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_cow_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_horse_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_mooshroom_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_ocelot_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_pig_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_pufferfish_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_rabbit_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_sheep_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_squid_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_strider_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_villager_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_wandering_trader_plush", true)).build();

        ADJsonConfigCategory neutralPlushiesSubcategory = new ADJsonConfigCategory.Builder("neutral_plushies")
                .addEntry(new ADJsonConfigEntry("enable_bee_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_cave_spider_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_enderman_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_piglin_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_polar_bear_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_spider_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_pale_wolf_plush", true)).build();

        ADJsonConfigCategory hostilePlushiesSubcategory = new ADJsonConfigCategory.Builder("hostile_plushies")
                .addEntry(new ADJsonConfigEntry("enable_blaze_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_creeper_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_ghast_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_guardian_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_hoglin_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_illager_plushies", true))
                .addEntry(new ADJsonConfigEntry("enable_magma_cube_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_phantom_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_ravager_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_shulker_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_skeleton_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_slime_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_vex_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_witch_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_wither_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_zombie_plush", true))
                .addEntry(new ADJsonConfigEntry("enable_zombie_villager_plushies", true)).build();

        ADJsonConfigCategory buildingCategory = new ADJsonConfigCategory.Builder("building")
                .addSubcategory(dyedSubcategory)
                .addSubcategory(passivePlushiesSubcategory)
                .addSubcategory(neutralPlushiesSubcategory)
                .addSubcategory(hostilePlushiesSubcategory)
                .addEntry(new ADJsonConfigEntry("enable_wooden_walls", true))
                .addEntry(new ADJsonConfigEntry("enable_stripped_wooden_walls", true))
                .addEntry(new ADJsonConfigEntry("enable_wooden_rope_ladders", true))
                .addEntry(new ADJsonConfigEntry("enable_iron_ladders", true))
                .addEntry(new ADJsonConfigEntry("enable_blackstone_tiles", true))
                .addEntry(new ADJsonConfigEntry("enable_twisted_blackstone", true))
                .addEntry(new ADJsonConfigEntry("enable_twisted_blackstone_tiles", true,
                "Requires blackstone tiles!"))
                .addEntry(new ADJsonConfigEntry("enable_twisted_netherrack", true))
                .addEntry(new ADJsonConfigEntry("enable_twisted_nether_bricks", true))
                .addEntry(new ADJsonConfigEntry(
                "enable_twisted_polished_blackstone_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_weeping_netherrack", true))
                .addEntry(new ADJsonConfigEntry("enable_weeping_nether_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_weeping_blackstone", true))
                .addEntry(new ADJsonConfigEntry(
                "enable_weeping_polished_blackstone_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_weeping_blackstone_tiles", true,
                "Requires blackstone tiles!"))
                .addEntry(new ADJsonConfigEntry("enable_smoky_quartz_blocks", true))
                .addEntry(new ADJsonConfigEntry("enable_smoky_quartz_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_smooth_smoky_quartz", true))
                .addEntry(new ADJsonConfigEntry("enable_quartz_tiles", true))
                .addEntry(new ADJsonConfigEntry("enable_quartz_walls", true))
                .addEntry(new ADJsonConfigEntry("enable_bauxite", true))
                .addEntry(new ADJsonConfigEntry("enable_bauxite_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_cracked_bauxite_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_mossy_bauxite_bricks", true))
                .addEntry(new ADJsonConfigEntry("enable_stone_tiles", true))
                .addEntry(new ADJsonConfigEntry("enable_cracked_stone_tiles", true))
                .addEntry(new ADJsonConfigEntry("enable_mossy_stone_tiles", true))
                .addEntry(new ADJsonConfigEntry("enable_woodcutter", true)).build();

        //TODO: Give enable_ender_plants a better name!
        ADJsonConfigCategory farmingCategory = new ADJsonConfigCategory.Builder("farming")
                .addEntry(new ADJsonConfigEntry("enable_wooden_planter_boxes", true))
                .addEntry(new ADJsonConfigEntry("enable_green_onions", true))
                .addEntry(new ADJsonConfigEntry("enable_noodle_soup", true))
                .addEntry(new ADJsonConfigEntry("enable_blueberries", true))
                .addEntry(new ADJsonConfigEntry("enable_blueberry_pie", true))
                .addEntry(new ADJsonConfigEntry("enable_blueberry_juice", true))
                .addEntry(new ADJsonConfigEntry("enable_sweet_berry_pie", true))
                .addEntry(new ADJsonConfigEntry("enable_sweet_berry_juice", true))
                .addEntry(new ADJsonConfigEntry("enable_chocolate_cake", true))
                .addEntry(new ADJsonConfigEntry("enable_red_velvet_cake", true))
                .addEntry(new ADJsonConfigEntry("enable_fried_egg", true))
                .addEntry(new ADJsonConfigEntry("enable_hoglin_stew", true))
                .addEntry(new ADJsonConfigEntry("enable_forests_bounty", true))
                .addEntry(new ADJsonConfigEntry("enable_witchs_cradle_soup", true))
                .addEntry(new ADJsonConfigEntry("enable_pudding", true))
                .addEntry(new ADJsonConfigEntry("enable_caramel_apple", true))
                .addEntry(new ADJsonConfigEntry("enable_nether_berries", true))
                .addEntry(new ADJsonConfigEntry("enable_purple_mushrooms", true))
                .addEntry(new ADJsonConfigEntry("enable_cattails", true))
                .addEntry(new ADJsonConfigEntry("enable_bog_blossoms", true))
                .addEntry(new ADJsonConfigEntry("enable_blood_kelp", true))
                .addEntry(new ADJsonConfigEntry("enable_ender_plants", true)).build();

        ADJsonConfigCategory miscCategory = new ADJsonConfigCategory.Builder("misc")
                .addEntry(new ADJsonConfigEntry("rabbits_safe_fall_increased", true)).build();

        return configBuilder.addCategory(buildingCategory).addCategory(farmingCategory)
                .addCategory(miscCategory).build();
    }

    static {
        CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(ADReference.MOD_ID + ".json5");
        CONFIG = makeConfig();
        JANKSON_CONFIG_SERIALIZER = new ADJanksonConfigSerializer(CONFIG, CONFIG_PATH);
    }
}
