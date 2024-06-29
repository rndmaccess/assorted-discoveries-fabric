package rndm_access.assorteddiscoveries.config;

import me.shedaniel.autoconfig.util.Utils;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.jankson.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ADConfig {
    private static final Path CONFIG_PATH;
    public static final ADJsonConfig JSON_CONFIG_CATEGORIES;
    public static final ADJanksonConfigSerializer JANKSON_CONFIG_SERIALIZER;

    public static void loadOrCreateConfig() {
        if (Files.exists(CONFIG_PATH)) {
            LinkedList<ADJsonConfigCategory> savedCategories = JANKSON_CONFIG_SERIALIZER.deserializeConfig();

            for (ADJsonConfigCategory savedCategory : savedCategories) {
                updateCategory(savedCategory);
            }

            // Re-serialize the config to make sure that the loaded data is the same as the serialized data.
            JANKSON_CONFIG_SERIALIZER.serializeConfig();
        } else {
            JANKSON_CONFIG_SERIALIZER.serializeConfig();
        }
    }

    private static void updateCategory(ADJsonConfigCategory savedCategory) {
        String savedCategoryName = savedCategory.getName();

        if (JSON_CONFIG_CATEGORIES.hasCategory(savedCategoryName)) {
            ADJsonConfigCategory defaultCategory = JSON_CONFIG_CATEGORIES.getCategory(savedCategoryName);

            for (ADJsonConfigComponentBase savedComponent : savedCategory.getComponents()) {
                if(defaultCategory.hasSubCategory(savedComponent.getName())) {
                    ADJsonSubCategory savedSubCategory = (ADJsonSubCategory) savedComponent;
                    ADJsonSubCategory defaultSubCategory = defaultCategory.getSubCategory(savedComponent.getName());

                    updateSubCategoryEntries(savedSubCategory, defaultSubCategory, defaultCategory);
                } else {
                    updateCategoryEntries(defaultCategory, savedComponent);
                }
            }
        }
    }

    private static void updateSubCategoryEntries(ADJsonSubCategory savedSubCategory,
                                                 ADJsonSubCategory defaultSubCategory,
                                                 ADJsonConfigCategory defaultCategory) {
        for (ADJsonConfigEntry savedEntry : savedSubCategory.getEntries()) {
            if(defaultSubCategory.hasEntry(savedEntry.getName())) {
                String savedValue = Objects.toString(savedEntry.getValue());
                ADJsonConfigEntry defaultEntry = defaultSubCategory.getEntry(savedEntry.getName());
                Object fixedSavedValue = getCorrectedValue(defaultEntry, savedValue);

                if(!Objects.equals(defaultEntry.getValue(), fixedSavedValue)) {
                    JSON_CONFIG_CATEGORIES.getCategory(defaultCategory.getName())
                            .getSubCategory(defaultSubCategory.getName())
                            .getEntry(defaultEntry.getName())
                            .setValue(fixedSavedValue);
                }
            }
        }
    }

    private static void updateCategoryEntries(ADJsonConfigCategory defaultCategory,
                                              ADJsonConfigComponentBase savedComponent) {
        if(defaultCategory.hasEntry(savedComponent.getName())) {
            ADJsonConfigEntry savedEntry = (ADJsonConfigEntry) savedComponent;
            String savedValue = Objects.toString(savedEntry.getValue());
            ADJsonConfigEntry defaultEntry = defaultCategory.getEntry(savedEntry.getName());
            Object fixedSavedValue = getCorrectedValue(defaultEntry, savedValue);

            if(!Objects.equals(defaultEntry.getValue(), fixedSavedValue)) {
                JSON_CONFIG_CATEGORIES.getCategory(defaultCategory.getName())
                        .getEntry(defaultEntry.getName()).setValue(fixedSavedValue);
            }
        }
    }

    private static Object getCorrectedValue(ADJsonConfigEntry defaultEntry, String savedValue) {
        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            if(isBoolean(savedValue)) {
                return Boolean.valueOf(savedValue);
            } else {
                if(savedValue.charAt(0) == '"' && savedValue.charAt(savedValue.length() - 1) == '"') {
                    String fixedValue = savedValue.substring(1, savedValue.length() - 1);

                    if(isBoolean(fixedValue)) {
                        logCorrectionInfo(savedValue, fixedValue, defaultEntry.getName());
                        return Boolean.valueOf(fixedValue);
                    }
                }
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

    private static ADJsonConfig getDefaultConfigCategories() {
        ADJsonConfig.Builder configBuilder = new ADJsonConfig.Builder();

        ADJsonConfigCategory passivePlushiesCategory = configBuilder.addCategory("passive_plushies");
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

        ADJsonConfigCategory neutralPlushiesCategory = configBuilder.addCategory("neutral_plushies");
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_bee_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_cave_spider_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_enderman_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_piglin_plushies", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_polar_bear_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_spider_plush", true));
        neutralPlushiesCategory.addEntry(new ADJsonConfigEntry("enable_pale_wolf_plush", true));

        ADJsonConfigCategory hostilePlushiesCategory = configBuilder.addCategory("hostile_plushies");
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

        ADJsonConfigCategory farmingCategory = configBuilder.addCategory("farming");
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_wooden_planter_boxes", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_green_onions", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_noodle_soup", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_blueberries", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_blueberry_pie", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_blueberry_juice", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_sweet_berry_pie", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_sweet_berry_juice", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_chocolate_cake", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_red_velvet_cake", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_fried_egg", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_hoglin_stew", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_forests_bounty", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_witchs_cradle_soup", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_pudding", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_caramel_apple", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_nether_berries", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_purple_mushrooms", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_cattails", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_bog_blossoms", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_blood_kelp", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("enable_ender_plants", true));

        ADJsonConfigCategory buildingCategory = configBuilder.addCategory("building");

        ADJsonSubCategory wallSubCategory = buildingCategory.addSubCategory(new ADJsonSubCategory("walls"));
        wallSubCategory.addEntry(new ADJsonConfigEntry("enable_wooden_walls", true));
        wallSubCategory.addEntry(new ADJsonConfigEntry("enable_stripped_wooden_walls", true));

        ADJsonConfigCategory miscCategory = configBuilder.addCategory("misc");
        miscCategory.addEntry(new ADJsonConfigEntry("rabbits_safe_fall_increased", true));

        return configBuilder.build();
    }

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
        JSON_CONFIG_CATEGORIES = getDefaultConfigCategories();
        JANKSON_CONFIG_SERIALIZER = new ADJanksonConfigSerializer(JSON_CONFIG_CATEGORIES, CONFIG_PATH);
    }
}
