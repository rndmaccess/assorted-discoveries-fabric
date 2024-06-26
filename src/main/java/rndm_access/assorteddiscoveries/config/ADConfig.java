package rndm_access.assorteddiscoveries.config;

import me.shedaniel.autoconfig.util.Utils;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.jankson.ADJanksonConfigSerializer;
import rndm_access.assorteddiscoveries.config.jankson.ADJsonConfigCategory;
import rndm_access.assorteddiscoveries.config.jankson.ADJsonConfigEntry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ADConfig {
    private static final Path CONFIG_PATH;
    public static final LinkedHashMap<String, ADJsonConfigCategory> JSON_CONFIG_CATEGORIES;
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

        if (JSON_CONFIG_CATEGORIES.containsKey(savedCategoryName)) {
            ADJsonConfigCategory defaultCategory = JSON_CONFIG_CATEGORIES.get(savedCategoryName);

            for (ADJsonConfigEntry savedEntry : savedCategory.getEntries()) {
                if(defaultCategory.hasEntry(savedEntry.getName())) {
                    updateEntry(savedEntry, defaultCategory);
                }
            }
        }
    }

    private static void updateEntry(ADJsonConfigEntry savedEntry, ADJsonConfigCategory defaultCategory) {
        String savedValue = Objects.toString(savedEntry.getValue());
        ADJsonConfigEntry defaultEntry = defaultCategory.getEntry(savedEntry.getName());
        Object fixedSavedValue = getCorrectedValue(defaultEntry, savedValue);

        if(!Objects.equals(defaultEntry.getValue(), fixedSavedValue)) {
            JSON_CONFIG_CATEGORIES.get(defaultCategory.getName()).getEntry(defaultEntry.getName())
                    .setValue(fixedSavedValue);
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

        farmingCategory.addEntry(new ADJsonConfigEntry("enable_purple_mushrooms", true));
        farmingCategory.addEntry(new ADJsonConfigEntry("mushroom_bounce_height", 15));

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
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
        JSON_CONFIG_CATEGORIES = getDefaultConfigCategories();
        JANKSON_CONFIG_SERIALIZER = new ADJanksonConfigSerializer(JSON_CONFIG_CATEGORIES, CONFIG_PATH);
    }
}
