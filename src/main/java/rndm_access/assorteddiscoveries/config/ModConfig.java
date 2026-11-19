package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.json_objects.*;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Config data available:<br>
 * Server: Immediately when the game is started!<br>
 * Client: After the player joins.<br>
 *
 * Config data is synchronized through packets.
 * If there is a problem loading then the config will use default values.
 */
public class ModConfig {
    public static final JsonConfig CONFIG;
    public static final BooleanJsonConfigEntry ENABLE_PLANTER_BOXES;
    public static final BooleanJsonConfigEntry ENABLE_DYED_CAMPFIRES;
    public static final BooleanJsonConfigEntry ENABLE_DYED_LANTERNS;
    public static final BooleanJsonConfigEntry ENABLE_DYED_TORCHES;
    public static final BooleanJsonConfigEntry ENABLE_WOODEN_WALLS;
    public static final BooleanJsonConfigEntry ENABLE_STRIPPED_WOODEN_WALLS;
    public static final BooleanJsonConfigEntry ENABLE_ROPE_LADDERS;
    public static final BooleanJsonConfigEntry ENABLE_IRON_LADDERS;
    public static final BooleanJsonConfigEntry ENABLE_BLACKSTONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_TWISTED_BLACKSTONE;
    public static final BooleanJsonConfigEntry ENABLE_TWISTED_BLACKSTONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_TWISTED_NETHERRACK;
    public static final BooleanJsonConfigEntry ENABLE_TWISTED_NETHER_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_WEEPING_NETHERRACK;
    public static final BooleanJsonConfigEntry ENABLE_WEEPING_NETHER_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_WEEPING_BLACKSTONE;
    public static final BooleanJsonConfigEntry ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_WEEPING_BLACKSTONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_SMOKY_QUARTZ_BLOCKS;
    public static final BooleanJsonConfigEntry ENABLE_SMOKY_QUARTZ_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_SMOOTH_SMOKY_QUARTZ;
    public static final BooleanJsonConfigEntry ENABLE_SMOKY_QUARTZ_TILES;
    public static final BooleanJsonConfigEntry ENABLE_QUARTZ_TILES;
    public static final BooleanJsonConfigEntry ENABLE_QUARTZ_WALLS;
    public static final BooleanJsonConfigEntry ENABLE_BAUXITE;
    public static final BooleanJsonConfigEntry ENABLE_BAUXITE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_CRACKED_BAUXITE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_MOSSY_BAUXITE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_STONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_CRACKED_STONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_MOSSY_STONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_CRACKED_STONE_BRICK_BLOCKS;
    public static final BooleanJsonConfigEntry ENABLE_STONE_WALLS;
    public static final BooleanJsonConfigEntry ENABLE_CALCITE_BLOCKS;
    public static final BooleanJsonConfigEntry ENABLE_POLISHED_CALCITE;
    public static final BooleanJsonConfigEntry ENABLE_CALCITE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_CRACKED_CALCITE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_MOSSY_CALCITE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_DRIPSTONE_BLOCKS;
    public static final BooleanJsonConfigEntry ENABLE_POLISHED_DRIPSTONE;
    public static final BooleanJsonConfigEntry ENABLE_DRIPSTONE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_CRACKED_DRIPSTONE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_MOSSY_DRIPSTONE_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_DRIPSTONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_CRACKED_DRIPSTONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_MOSSY_DRIPSTONE_TILES;
    public static final BooleanJsonConfigEntry ENABLE_QUARTZ_BRICK_BLOCKS;
    public static final BooleanJsonConfigEntry ENABLE_SNOW_BRICKS;
    public static final BooleanJsonConfigEntry ENABLE_PACKED_SNOW;
    public static final BooleanJsonConfigEntry ENABLE_DIRT_SLABS;
    public static final BooleanJsonConfigEntry ENABLE_ALLAY_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_BAT_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_CAMEL_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_CAT_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_CHICKEN_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_COW_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_HORSE_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_MOOSHROOM_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_PIG_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_PUFFERFISH_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_RABBIT_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_SHEEP_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_SQUID_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_STRIDER_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_VILLAGER_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_BEE_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_CAVE_SPIDER_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_ENDERMAN_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_PIGLIN_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_SPIDER_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_WOLF_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_BLAZE_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_CREEPER_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_GHAST_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_GUARDIAN_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_HOGLIN_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_ILLAGER_PLUSHIES;
    public static final BooleanJsonConfigEntry ENABLE_MAGMA_CUBE_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_PHANTOM_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_SHULKER_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_SKELETON_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_SLIME_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_VEX_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_WITCH_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_WITHER_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_ZOMBIE_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_CREAKING_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_SNIFFER_PLUSHIE;
    public static final BooleanJsonConfigEntry ENABLE_GREEN_ONIONS;
    public static final BooleanJsonConfigEntry ENABLE_NOODLE_SOUP;
    public static final BooleanJsonConfigEntry ENABLE_BLUEBERRIES;
    public static final BooleanJsonConfigEntry ENABLE_BLUEBERRY_PIE;
    public static final BooleanJsonConfigEntry ENABLE_BLUEBERRY_JUICE;
    public static final BooleanJsonConfigEntry ENABLE_SWEET_BERRY_PIE;
    public static final BooleanJsonConfigEntry ENABLE_SWEET_BERRY_JUICE;
    public static final BooleanJsonConfigEntry ENABLE_CHOCOLATE_CAKE;
    public static final BooleanJsonConfigEntry ENABLE_RED_VELVET_CAKE;
    public static final BooleanJsonConfigEntry ENABLE_FRIED_EGG;
    public static final BooleanJsonConfigEntry ENABLE_HOGLIN_STEW;
    public static final BooleanJsonConfigEntry ENABLE_FORESTS_BOUNTY;
    public static final BooleanJsonConfigEntry ENABLE_PUDDING;
    public static final BooleanJsonConfigEntry ENABLE_CARAMEL_APPLE;
    public static final BooleanJsonConfigEntry ENABLE_CINDERSNAP_BERRIES;
    public static final BooleanJsonConfigEntry ENABLE_FROSTBITE_BERRIES;
    public static final BooleanJsonConfigEntry ENABLE_CINDERSNAP_BERRY_JUICE;
    public static final BooleanJsonConfigEntry ENABLE_FROSTBITE_BERRY_JUICE;
    public static final BooleanJsonConfigEntry ENABLE_CRIMSON_FORAGE_MIX;
    public static final BooleanJsonConfigEntry ENABLE_WARPED_FORAGE_MIX;
    public static final BooleanJsonConfigEntry ENABLE_WITCHS_CRADLES;
    public static final BooleanJsonConfigEntry ENABLE_PURPLE_MUSHROOMS;
    public static final BooleanJsonConfigEntry ENABLE_CATTAILS;
    public static final BooleanJsonConfigEntry ENABLE_BOG_BLOSSOMS;
    public static final BooleanJsonConfigEntry ENABLE_BLOOD_KELP;
    public static final BooleanJsonConfigEntry ENABLE_ENDER_PLANTS;

    public static void updateFromFile() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve(AssortedDiscoveries.MOD_ID + ".json5");

        if (!Files.exists(configPath)) {
            CONFIG.create();
            return;
        }
        CONFIG.loadFromFile();
    }

    static {
        ModConfigCategory buildingBlocksCategory = ModConfigCategory.BUILDING_BLOCKS;
        ENABLE_PLANTER_BOXES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_planter_boxes"));
        ENABLE_DYED_CAMPFIRES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_dyed_campfires"));
        ENABLE_DYED_LANTERNS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_dyed_lanterns"));
        ENABLE_DYED_TORCHES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_dyed_torches"));
        ENABLE_WOODEN_WALLS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_wooden_walls"));
        ENABLE_STRIPPED_WOODEN_WALLS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_stripped_wooden_walls"));
        ENABLE_ROPE_LADDERS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_rope_ladders"));
        ENABLE_IRON_LADDERS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_iron_ladders"));
        ENABLE_BLACKSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_blackstone_tiles"));
        ENABLE_TWISTED_BLACKSTONE = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_twisted_blackstone"));
        ENABLE_TWISTED_BLACKSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_twisted_blackstone_tiles"));
        ENABLE_TWISTED_NETHERRACK = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_twisted_netherrack"));
        ENABLE_TWISTED_NETHER_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_twisted_nether_bricks"));
        ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_twisted_polished_blackstone_bricks"));
        ENABLE_WEEPING_NETHERRACK = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_weeping_netherrack"));
        ENABLE_WEEPING_NETHER_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_weeping_nether_bricks"));
        ENABLE_WEEPING_BLACKSTONE = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_weeping_blackstone"));
        ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_weeping_polished_blackstone_bricks"));
        ENABLE_WEEPING_BLACKSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_weeping_blackstone_tiles"));
        ENABLE_SMOKY_QUARTZ_BLOCKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_smoky_quartz_blocks",
                "Toggle all smoky quartz block types (normal, bricks, smooth, etc.)"
        ));
        ENABLE_SMOKY_QUARTZ_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_smoky_quartz_bricks",
                "Toggle smoky quartz bricks and tiles"
        ));
        ENABLE_SMOOTH_SMOKY_QUARTZ = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_smooth_smoky_quartz"));
        ENABLE_SMOKY_QUARTZ_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_smoky_quartz_tiles"));
        ENABLE_QUARTZ_BRICK_BLOCKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_quartz_brick_blocks",
                "Toggle quartz brick stairs, slabs, and walls")
        );
        ENABLE_QUARTZ_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_quartz_tiles"));
        ENABLE_QUARTZ_WALLS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_quartz_walls",
                "Toggle smooth quartz and quartz walls"
        ));
        ENABLE_BAUXITE = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_bauxite",
                "Toggle all bauxite types (normal, bricks, mossy bricks, etc.)"
        ));
        ENABLE_BAUXITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_bauxite_bricks",
                "Toggle all bauxite bricks (normal, mossy, cracked)"
        ));
        ENABLE_CRACKED_BAUXITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_cracked_bauxite_bricks"));
        ENABLE_MOSSY_BAUXITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_mossy_bauxite_bricks"));
        ENABLE_STONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_stone_tiles",
                "Toggle all stone tiles (normal, cracked, mossy, etc.)"
        ));
        ENABLE_CRACKED_STONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_cracked_stone_tiles"));
        ENABLE_MOSSY_STONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_mossy_stone_tiles"));
        ENABLE_CRACKED_STONE_BRICK_BLOCKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_cracked_stone_brick_blocks",
                "Toggle cracked stone brick stairs, slabs, and walls"
        ));
        ENABLE_STONE_WALLS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_stone_walls"));
        ENABLE_CALCITE_BLOCKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_calcite_blocks",
                "Toggle calcite stairs, slabs, and walls"
        ));
        ENABLE_POLISHED_CALCITE = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_polished_calcite"));
        ENABLE_CALCITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_calcite_bricks",
                "Toggle all calcite bricks (normal, cracked, mossy)"
        ));
        ENABLE_CRACKED_CALCITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_cracked_calcite_bricks"));
        ENABLE_MOSSY_CALCITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_mossy_calcite_bricks"));
        ENABLE_DRIPSTONE_BLOCKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_dripstone_blocks",
                "Toggle dripstone stairs, slabs, and walls"
        ));
        ENABLE_POLISHED_DRIPSTONE = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_polished_dripstone"));
        ENABLE_DRIPSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_dripstone_bricks",
                "Toggle all dripstone bricks and tiles (normal, cracked, mossy)"
        ));
        ENABLE_CRACKED_DRIPSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_cracked_dripstone_bricks"));
        ENABLE_MOSSY_DRIPSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_mossy_dripstone_bricks"));

        ENABLE_DRIPSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_dripstone_tiles",
                "Toggle all dripstone tiles (normal, cracked, mossy)")
        );
        ENABLE_CRACKED_DRIPSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_cracked_dripstone_tiles"));
        ENABLE_MOSSY_DRIPSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_mossy_dripstone_tiles"));

        ENABLE_SNOW_BRICKS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_snow_bricks"));
        ENABLE_PACKED_SNOW = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry("enable_packed_snow"));
        ENABLE_DIRT_SLABS = buildingBlocksCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_dirt_slabs",
                "Toggle all soil slabs (dirt, grass, podzol, etc.)")
        );

        ModConfigCategory plushiesCategory = ModConfigCategory.PLUSHIES;
        ENABLE_ALLAY_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_allay_plushie"));
        ENABLE_BAT_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_bat_plushie"));
        ENABLE_CAMEL_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_camel_plushie"));
        ENABLE_WOLF_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_wolf_plushies"));
        ENABLE_CAT_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_cat_plushies"));
        ENABLE_CHICKEN_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_chicken_plushies"));
        ENABLE_COW_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_cow_plushies"));
        ENABLE_HORSE_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_horse_plushies"));
        ENABLE_MOOSHROOM_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_mooshroom_plushies"));
        ENABLE_PIG_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_pig_plushies"));
        ENABLE_PUFFERFISH_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_pufferfish_plushie"));
        ENABLE_RABBIT_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_rabbit_plushies"));
        ENABLE_SHEEP_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_sheep_plushies"));
        ENABLE_SQUID_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_squid_plushies"));
        ENABLE_STRIDER_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_strider_plushies"));
        ENABLE_VILLAGER_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_villager_plushies"));
        ENABLE_SNIFFER_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_sniffer_plushie"));
        ENABLE_BEE_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_bee_plushie"));
        ENABLE_CAVE_SPIDER_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_cave_spider_plushie"));
        ENABLE_ENDERMAN_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_enderman_plushie"));
        ENABLE_PIGLIN_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_piglin_plushies"));
        ENABLE_SPIDER_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_spider_plushie"));
        ENABLE_BLAZE_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_blaze_plushie"));
        ENABLE_CREEPER_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_creeper_plushie"));
        ENABLE_GHAST_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_ghast_plushie"));
        ENABLE_GUARDIAN_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_guardian_plushie"));
        ENABLE_HOGLIN_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_hoglin_plushies",
                "Toggle hoglin and zoglin plushies"
        ));
        ENABLE_ILLAGER_PLUSHIES = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_illager_plushies"));
        ENABLE_MAGMA_CUBE_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_magma_cube_plushie"));
        ENABLE_PHANTOM_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_phantom_plushie"));
        ENABLE_SHULKER_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_shulker_plushie"));
        ENABLE_SKELETON_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_skeleton_plushie"));
        ENABLE_SLIME_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_slime_plushie"));
        ENABLE_VEX_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_vex_plushie"));
        ENABLE_WITCH_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_witch_plushie"));
        ENABLE_WITHER_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_wither_plushie"));
        ENABLE_ZOMBIE_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_zombie_plushie"));
        ENABLE_CREAKING_PLUSHIE = plushiesCategory.addEntry(new BooleanJsonConfigEntry("enable_creaking_plushie"));

        ModConfigCategory foodCategory = ModConfigCategory.FOODS;
        ENABLE_GREEN_ONIONS = foodCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_green_onions",
                "When off, noodle soup can be crafted without green onions"
        ));
        ENABLE_NOODLE_SOUP = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_noodle_soup"));
        ENABLE_CHOCOLATE_CAKE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_chocolate_cake"));
        ENABLE_RED_VELVET_CAKE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_red_velvet_cake"));
        ENABLE_FRIED_EGG = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_fried_egg"));
        ENABLE_HOGLIN_STEW = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_hoglin_stew"));
        ENABLE_FORESTS_BOUNTY = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_forests_bounty"));
        ENABLE_PUDDING = foodCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_pudding",
                "Toggle pudding and berry pudding"
        ));
        ENABLE_CARAMEL_APPLE = foodCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_caramel_apple",
                "Toggle caramel, caramel apples, and caramel blocks"
        ));
        ENABLE_SWEET_BERRY_PIE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_sweet_berry_pie"));
        ENABLE_SWEET_BERRY_JUICE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_sweet_berry_juice"));
        ENABLE_BLUEBERRIES = foodCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_blueberries",
                "Toggle blueberries, pie, and juice (when off, berry pudding takes an extra sweet berry instead)"
        ));
        ENABLE_BLUEBERRY_PIE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_blueberry_pie"));
        ENABLE_BLUEBERRY_JUICE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_blueberry_juice"));
        ENABLE_CINDERSNAP_BERRIES = foodCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_cindersnap_berries",
                "Toggle cindersnap berries, cindersnap berry juice, and crimson forage mix"
        ));
        ENABLE_FROSTBITE_BERRIES = foodCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_frostbite_berries",
                "Toggle frostbite berries, frostbite berry juice, and warped forage mix"
        ));
        ENABLE_CINDERSNAP_BERRY_JUICE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_cindersnap_berry_juice"));
        ENABLE_CRIMSON_FORAGE_MIX = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_crimson_forage_mix"));
        ENABLE_FROSTBITE_BERRY_JUICE = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_frostbite_berry_juice"));
        ENABLE_WARPED_FORAGE_MIX = foodCategory.addEntry(new BooleanJsonConfigEntry("enable_warped_forage_mix"));

        ModConfigCategory plantsCategory = ModConfigCategory.PLANTS;
        ENABLE_BLOOD_KELP = plantsCategory.addEntry(new BooleanJsonConfigEntry("enable_blood_kelp"));
        ENABLE_PURPLE_MUSHROOMS = plantsCategory.addEntry(new BooleanJsonConfigEntry("enable_purple_mushrooms"));
        ENABLE_CATTAILS = plantsCategory.addEntry(new BooleanJsonConfigEntry("enable_cattails"));
        ENABLE_BOG_BLOSSOMS = plantsCategory.addEntry(new BooleanJsonConfigEntry("enable_bog_blossoms"));
        ENABLE_ENDER_PLANTS = plantsCategory.addEntry(new BooleanJsonConfigEntry(
                "enable_ender_plants",
                "Toggle snapdragons and ender grass"
        ));
        ENABLE_WITCHS_CRADLES = plantsCategory.addEntry(new BooleanJsonConfigEntry("enable_witchs_cradles"));

        String line = "======================================================";
        CONFIG = new JsonConfig(AssortedDiscoveries.MOD_ID);
        CONFIG.addGlobalComment(line);
        CONFIG.addGlobalComment("Assorted Discoveries Config Notes:");
        CONFIG.addGlobalComment("- Each option in the config requires a game restart!");
        CONFIG.addGlobalComment("- Enable or disable any config option by toggling the setting between true and false.");
        CONFIG.addGlobalComment("- Wiki & Documentation: https://rndmaccess.github.io/assorted-discoveries-wiki/");
        CONFIG.addGlobalComment(line);

        updateFromFile();
    }
}
