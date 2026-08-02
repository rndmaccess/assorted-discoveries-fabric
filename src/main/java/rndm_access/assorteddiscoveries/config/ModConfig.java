package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.json_objects.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Config data available:<br>
 * Server: Immediately when the game is started!<br>
 * Client: After the player joins.<br>
 *
 * Config data is synchronized through packets.
 * If there is a problem loading then the config will use default values.
 */
public class ModConfig {
    public static final Config CONFIG;
    public static final BooleanConfigEntry ENABLE_PLANTER_BOXES;
    public static final BooleanConfigEntry ENABLE_DYED_CAMPFIRES;
    public static final BooleanConfigEntry ENABLE_DYED_LANTERNS;
    public static final BooleanConfigEntry ENABLE_DYED_TORCHES;
    public static final BooleanConfigEntry ENABLE_WOODEN_WALLS;
    public static final BooleanConfigEntry ENABLE_STRIPPED_WOODEN_WALLS;
    public static final BooleanConfigEntry ENABLE_ROPE_LADDERS;
    public static final BooleanConfigEntry ENABLE_IRON_LADDERS;
    public static final BooleanConfigEntry ENABLE_BLACKSTONE_TILES;
    public static final BooleanConfigEntry ENABLE_TWISTED_BLACKSTONE;
    public static final BooleanConfigEntry ENABLE_TWISTED_BLACKSTONE_TILES;
    public static final BooleanConfigEntry ENABLE_TWISTED_NETHERRACK;
    public static final BooleanConfigEntry ENABLE_TWISTED_NETHER_BRICKS;
    public static final BooleanConfigEntry ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS;
    public static final BooleanConfigEntry ENABLE_WEEPING_NETHERRACK;
    public static final BooleanConfigEntry ENABLE_WEEPING_NETHER_BRICKS;
    public static final BooleanConfigEntry ENABLE_WEEPING_BLACKSTONE;
    public static final BooleanConfigEntry ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS;
    public static final BooleanConfigEntry ENABLE_WEEPING_BLACKSTONE_TILES;
    public static final BooleanConfigEntry ENABLE_SMOKY_QUARTZ_BLOCKS;
    public static final BooleanConfigEntry ENABLE_SMOKY_QUARTZ_BRICKS;
    public static final BooleanConfigEntry ENABLE_SMOOTH_SMOKY_QUARTZ;
    public static final BooleanConfigEntry ENABLE_QUARTZ_TILES;
    public static final BooleanConfigEntry ENABLE_QUARTZ_WALLS;
    public static final BooleanConfigEntry ENABLE_BAUXITE;
    public static final BooleanConfigEntry ENABLE_BAUXITE_BRICKS;
    public static final BooleanConfigEntry ENABLE_CRACKED_BAUXITE_BRICKS;
    public static final BooleanConfigEntry ENABLE_MOSSY_BAUXITE_BRICKS;
    public static final BooleanConfigEntry ENABLE_STONE_TILES;
    public static final BooleanConfigEntry ENABLE_CRACKED_STONE_TILES;
    public static final BooleanConfigEntry ENABLE_MOSSY_STONE_TILES;
    public static final BooleanConfigEntry ENABLE_CRACKED_STONE_BRICK_BLOCKS;
    public static final BooleanConfigEntry ENABLE_STONE_WALLS;
    public static final BooleanConfigEntry ENABLE_CALCITE_BLOCKS;
    public static final BooleanConfigEntry ENABLE_POLISHED_CALCITE;
    public static final BooleanConfigEntry ENABLE_CALCITE_BRICKS;
    public static final BooleanConfigEntry ENABLE_CRACKED_CALCITE_BRICKS;
    public static final BooleanConfigEntry ENABLE_MOSSY_CALCITE_BRICKS;
    public static final BooleanConfigEntry ENABLE_DRIPSTONE_BLOCKS;
    public static final BooleanConfigEntry ENABLE_POLISHED_DRIPSTONE;
    public static final BooleanConfigEntry ENABLE_DRIPSTONE_BRICKS;
    public static final BooleanConfigEntry ENABLE_CRACKED_DRIPSTONE_BRICKS;
    public static final BooleanConfigEntry ENABLE_MOSSY_DRIPSTONE_BRICKS;
    public static final BooleanConfigEntry ENABLE_QUARTZ_BRICK_BLOCKS;
    public static final BooleanConfigEntry ENABLE_SNOW_BRICKS;
    public static final BooleanConfigEntry ENABLE_PACKED_SNOW;
    public static final BooleanConfigEntry ENABLE_DIRT_SLABS;
    public static final BooleanConfigEntry ENABLE_ALLAY_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_BAT_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CAMEL_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CAT_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_CHICKEN_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_COW_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_HORSE_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_MOOSHROOM_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_PIG_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_PUFFERFISH_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_RABBIT_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_SHEEP_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_SQUID_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_STRIDER_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_VILLAGER_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_BEE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CAVE_SPIDER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_ENDERMAN_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_PIGLIN_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_SPIDER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_WOLF_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_BLAZE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CREEPER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_GHAST_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_GUARDIAN_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_HOGLIN_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_ILLAGER_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_MAGMA_CUBE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_PHANTOM_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SHULKER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SKELETON_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SLIME_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_VEX_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_WITCH_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_WITHER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_ZOMBIE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CREAKING_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SNIFFER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_GREEN_ONIONS;
    public static final BooleanConfigEntry ENABLE_NOODLE_SOUP;
    public static final BooleanConfigEntry ENABLE_BLUEBERRIES;
    public static final BooleanConfigEntry ENABLE_BLUEBERRY_PIE;
    public static final BooleanConfigEntry ENABLE_BLUEBERRY_JUICE;
    public static final BooleanConfigEntry ENABLE_SWEET_BERRY_PIE;
    public static final BooleanConfigEntry ENABLE_SWEET_BERRY_JUICE;
    public static final BooleanConfigEntry ENABLE_CHOCOLATE_CAKE;
    public static final BooleanConfigEntry ENABLE_RED_VELVET_CAKE;
    public static final BooleanConfigEntry ENABLE_FRIED_EGG;
    public static final BooleanConfigEntry ENABLE_HOGLIN_STEW;
    public static final BooleanConfigEntry ENABLE_FORESTS_BOUNTY;
    public static final BooleanConfigEntry ENABLE_PUDDING;
    public static final BooleanConfigEntry ENABLE_CARAMEL_APPLE;
    public static final BooleanConfigEntry ENABLE_CINDERSNAP_BERRIES;
    public static final BooleanConfigEntry ENABLE_FROSTBITE_BERRIES;
    public static final BooleanConfigEntry ENABLE_CINDERSNAP_BERRY_JUICE;
    public static final BooleanConfigEntry ENABLE_FROSTBITE_BERRY_JUICE;
    public static final BooleanConfigEntry ENABLE_CRIMSON_FORAGE_MIX;
    public static final BooleanConfigEntry ENABLE_WARPED_FORAGE_MIX;
    public static final BooleanConfigEntry ENABLE_WITCHS_CRADLES;
    public static final BooleanConfigEntry ENABLE_PURPLE_MUSHROOMS;
    public static final BooleanConfigEntry ENABLE_CATTAILS;
    public static final BooleanConfigEntry ENABLE_BOG_BLOSSOMS;
    public static final BooleanConfigEntry ENABLE_BLOOD_KELP;
    public static final BooleanConfigEntry ENABLE_ENDER_PLANTS;

    public static void updateFromList(List<JsonConfigCategory> configList) {
        CONFIG.loadFromList(configList);
    }

    public static void updateFromFile() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve(AssortedDiscoveries.MOD_ID + ".json5");

        if (!Files.exists(configPath)) {
            CONFIG.create();
            return;
        }
        CONFIG.loadFromFile();
    }

    static {
        JsonConfigCategory.Builder buildingBlocksCategory = new JsonConfigCategory.Builder("building_blocks");
        ENABLE_PLANTER_BOXES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_planter_boxes"));
        ENABLE_DYED_CAMPFIRES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_dyed_campfires"));
        ENABLE_DYED_LANTERNS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_dyed_lanterns"));
        ENABLE_DYED_TORCHES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_dyed_torches"));
        ENABLE_WOODEN_WALLS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_wooden_walls"));
        ENABLE_STRIPPED_WOODEN_WALLS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_stripped_wooden_walls"));
        ENABLE_ROPE_LADDERS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_rope_ladders"));
        ENABLE_IRON_LADDERS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_iron_ladders"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all blackstone tile types and their variants."));
        ENABLE_BLACKSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_blackstone_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable twisted blackstone blocks and their variants."));
        ENABLE_TWISTED_BLACKSTONE = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_twisted_blackstone"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable twisted blackstone tile blocks and their variants."));
        ENABLE_TWISTED_BLACKSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_twisted_blackstone_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable twisted netherrack blocks and their variants."));
        ENABLE_TWISTED_NETHERRACK = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_twisted_netherrack"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable twisted nether brick blocks and their variants."));
        ENABLE_TWISTED_NETHER_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_twisted_nether_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable twisted polished blackstone brick blocks and their variants."));
        ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_twisted_polished_blackstone_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable weeping netherrack blocks and their variants."));
        ENABLE_WEEPING_NETHERRACK = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_weeping_netherrack"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable weeping nether brick blocks and their variants."));
        ENABLE_WEEPING_NETHER_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_weeping_nether_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable weeping blackstone blocks and their variants."));
        ENABLE_WEEPING_BLACKSTONE = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_weeping_blackstone"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable weeping polished blackstone brick blocks and their variants."));
        ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_weeping_polished_blackstone_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable weeping blackstone tiles and their variants."));
        ENABLE_WEEPING_BLACKSTONE_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_weeping_blackstone_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all smoky quartz blocks (normal, bricks, smooth) and their variants."));
        ENABLE_SMOKY_QUARTZ_BLOCKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_smoky_quartz_blocks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable smoky quartz brick blocks and their variants."));
        ENABLE_SMOKY_QUARTZ_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_smoky_quartz_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable smooth smoky quartz blocks and their variants."));
        ENABLE_SMOOTH_SMOKY_QUARTZ = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_smooth_smoky_quartz"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable quartz brick stairs, slabs, and walls."));
        ENABLE_QUARTZ_BRICK_BLOCKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_quartz_brick_blocks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable quartz tile blocks and their variants."));
        ENABLE_QUARTZ_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_quartz_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable smooth quartz walls and quartz walls."));
        ENABLE_QUARTZ_WALLS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_quartz_walls"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all bauxite types (normal, bricks, mossy bricks, etc.) and their variants."));
        ENABLE_BAUXITE = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_bauxite"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all bauxite bricks (normal, mossy, cracked) and their and its variants."));
        ENABLE_BAUXITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_bauxite_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable cracked bauxite brick blocks and their variants."));
        ENABLE_CRACKED_BAUXITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_cracked_bauxite_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable mossy bauxite brick blocks and their variants."));
        ENABLE_MOSSY_BAUXITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_mossy_bauxite_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all stone tiles (normal, cracked, mossy, etc.) and their variants."));
        ENABLE_STONE_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_stone_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable cracked stone tile blocks and their variants."));
        ENABLE_CRACKED_STONE_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_cracked_stone_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable mossy stone tile blocks and their variants."));
        ENABLE_MOSSY_STONE_TILES = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_mossy_stone_tiles"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable cracked stone brick stairs, slabs, and walls."));
        ENABLE_CRACKED_STONE_BRICK_BLOCKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_cracked_stone_brick_blocks"));
        ENABLE_STONE_WALLS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_stone_walls"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable calcite stairs, slabs, and walls."));
        ENABLE_CALCITE_BLOCKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_calcite_blocks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable polished calcite blocks and their variants."));
        ENABLE_POLISHED_CALCITE = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_polished_calcite"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all calcite bricks (normal, cracked, mossy) and their variants."));
        ENABLE_CALCITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_calcite_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable cracked calcite brick blocks and their variants."));
        ENABLE_CRACKED_CALCITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_cracked_calcite_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable mossy calcite brick blocks and their variants."));
        ENABLE_MOSSY_CALCITE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_mossy_calcite_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable dripstone stairs, slabs, and walls."));
        ENABLE_DRIPSTONE_BLOCKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_dripstone_blocks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable polished dripstone blocks and their variants."));
        ENABLE_POLISHED_DRIPSTONE = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_polished_dripstone"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all dripstone bricks (normal, cracked, mossy) and their variants."));
        ENABLE_DRIPSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_dripstone_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable cracked dripstone brick blocks and their variants."));
        ENABLE_CRACKED_DRIPSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_cracked_dripstone_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable mossy dripstone brick blocks and their variants."));
        ENABLE_MOSSY_DRIPSTONE_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_mossy_dripstone_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable snow brick blocks and their variants."));
        ENABLE_SNOW_BRICKS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_snow_bricks"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable packed snow blocks and their variants."));
        ENABLE_PACKED_SNOW = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_packed_snow"));
        buildingBlocksCategory.addComment(new CommentConfigEntry("Enable/disable all dirt slabs (coarse, grass, podzol, etc.)"));
        ENABLE_DIRT_SLABS = buildingBlocksCategory.addEntry(new BooleanConfigEntry("enable_dirt_slabs"));

        JsonConfigCategory.Builder plushiesCategory = new JsonConfigCategory.Builder("plushies");
        ENABLE_ALLAY_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_allay_plushie"));
        ENABLE_BAT_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_bat_plushie"));
        ENABLE_CAMEL_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_camel_plushie"));
        ENABLE_WOLF_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_wolf_plushies"));
        ENABLE_CAT_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_cat_plushies"));
        ENABLE_CHICKEN_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_chicken_plushies"));
        ENABLE_COW_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_cow_plushies"));
        ENABLE_HORSE_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_horse_plushies"));
        ENABLE_MOOSHROOM_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_mooshroom_plushies"));
        ENABLE_PIG_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_pig_plushies"));
        ENABLE_PUFFERFISH_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_pufferfish_plushie"));
        ENABLE_RABBIT_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_rabbit_plushies"));
        ENABLE_SHEEP_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_sheep_plushies"));
        ENABLE_SQUID_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_squid_plushies"));
        ENABLE_STRIDER_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_strider_plushies"));
        ENABLE_VILLAGER_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_villager_plushies"));
        ENABLE_SNIFFER_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_sniffer_plushie"));
        ENABLE_BEE_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_bee_plushie"));
        ENABLE_CAVE_SPIDER_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_cave_spider_plushie"));
        ENABLE_ENDERMAN_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_enderman_plushie"));
        ENABLE_PIGLIN_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_piglin_plushies"));
        ENABLE_SPIDER_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_spider_plushie"));
        ENABLE_BLAZE_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_blaze_plushie"));
        ENABLE_CREEPER_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_creeper_plushie"));
        ENABLE_GHAST_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_ghast_plushie"));
        ENABLE_GUARDIAN_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_guardian_plushie"));
        plushiesCategory.addComment(new CommentConfigEntry("Enable/dislable hoglin and zoglin plushies."));
        ENABLE_HOGLIN_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_hoglin_plushies"));
        ENABLE_ILLAGER_PLUSHIES = plushiesCategory.addEntry(new BooleanConfigEntry("enable_illager_plushies"));
        ENABLE_MAGMA_CUBE_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_magma_cube_plushie"));
        ENABLE_PHANTOM_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_phantom_plushie"));
        ENABLE_SHULKER_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_shulker_plushie"));
        ENABLE_SKELETON_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_skeleton_plushie"));
        ENABLE_SLIME_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_slime_plushie"));
        ENABLE_VEX_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_vex_plushie"));
        ENABLE_WITCH_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_witch_plushie"));
        ENABLE_WITHER_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_wither_plushie"));
        ENABLE_ZOMBIE_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_zombie_plushie"));
        ENABLE_CREAKING_PLUSHIE = plushiesCategory.addEntry(new BooleanConfigEntry("enable_creaking_plushie"));

        JsonConfigCategory.Builder foodCategory = new JsonConfigCategory.Builder("foods");
        foodCategory.addComment(new CommentConfigEntry("When disabled, noodle soup no longer requires green onions."));
        ENABLE_GREEN_ONIONS = foodCategory.addEntry(new BooleanConfigEntry("enable_green_onions"));
        ENABLE_NOODLE_SOUP = foodCategory.addEntry(new BooleanConfigEntry("enable_noodle_soup"));
        ENABLE_CHOCOLATE_CAKE = foodCategory.addEntry(new BooleanConfigEntry("enable_chocolate_cake"));
        ENABLE_RED_VELVET_CAKE = foodCategory.addEntry(new BooleanConfigEntry("enable_red_velvet_cake"));
        ENABLE_FRIED_EGG = foodCategory.addEntry(new BooleanConfigEntry("enable_fried_egg"));
        ENABLE_HOGLIN_STEW = foodCategory.addEntry(new BooleanConfigEntry("enable_hoglin_stew"));
        ENABLE_FORESTS_BOUNTY = foodCategory.addEntry(new BooleanConfigEntry("enable_forests_bounty"));
        foodCategory.addComment(new CommentConfigEntry("Enable/disable pudding and berry pudding."));
        ENABLE_PUDDING = foodCategory.addEntry(new BooleanConfigEntry("enable_pudding"));
        ENABLE_CARAMEL_APPLE = foodCategory.addEntry(new BooleanConfigEntry("enable_caramel_apple"));
        ENABLE_SWEET_BERRY_PIE = foodCategory.addEntry(new BooleanConfigEntry("enable_sweet_berry_pie"));
        ENABLE_SWEET_BERRY_JUICE = foodCategory.addEntry(new BooleanConfigEntry("enable_sweet_berry_juice"));
        foodCategory.addComment(new CommentConfigEntry("When disabled, berry pudding noodle soup no longer requires blueberries,"));
        foodCategory.addComment(new CommentConfigEntry("and blueberry pie and juice are disabled."));
        ENABLE_BLUEBERRIES = foodCategory.addEntry(new BooleanConfigEntry("enable_blueberries"));
        ENABLE_BLUEBERRY_PIE = foodCategory.addEntry(new BooleanConfigEntry("enable_blueberry_pie"));
        ENABLE_BLUEBERRY_JUICE = foodCategory.addEntry(new BooleanConfigEntry("enable_blueberry_juice"));
        foodCategory.addComment(new CommentConfigEntry("When disabled cindersnap berry juice and cindersnap forage mix are disabled."));
        ENABLE_CINDERSNAP_BERRIES = foodCategory.addEntry(new BooleanConfigEntry("enable_cindersnap_berries"));
        foodCategory.addComment(new CommentConfigEntry("When disabled frostbite berry juice and frostbite forage mix are disabled."));
        ENABLE_FROSTBITE_BERRIES = foodCategory.addEntry(new BooleanConfigEntry("enable_frostbite_berries"));
        ENABLE_CINDERSNAP_BERRY_JUICE = foodCategory.addEntry(new BooleanConfigEntry("enable_cindersnap_berry_juice"));
        ENABLE_CRIMSON_FORAGE_MIX = foodCategory.addEntry(new BooleanConfigEntry("enable_crimson_forage_mix"));
        ENABLE_FROSTBITE_BERRY_JUICE = foodCategory.addEntry(new BooleanConfigEntry("enable_frostbite_berry_juice"));
        ENABLE_WARPED_FORAGE_MIX = foodCategory.addEntry(new BooleanConfigEntry("enable_warped_forage_mix"));

        JsonConfigCategory.Builder plantsCategory = new JsonConfigCategory.Builder("plants");
        ENABLE_BLOOD_KELP = plantsCategory.addEntry(new BooleanConfigEntry("enable_blood_kelp"));
        ENABLE_PURPLE_MUSHROOMS = plantsCategory.addEntry(new BooleanConfigEntry("enable_purple_mushrooms"));
        ENABLE_CATTAILS = plantsCategory.addEntry(new BooleanConfigEntry("enable_cattails"));
        ENABLE_BOG_BLOSSOMS = plantsCategory.addEntry(new BooleanConfigEntry("enable_bog_blossoms"));
        plantsCategory.addComment(new CommentConfigEntry("Enable/disable snapdragons and ender grass."));
        ENABLE_ENDER_PLANTS = plantsCategory.addEntry(new BooleanConfigEntry("enable_ender_plants"));
        ENABLE_WITCHS_CRADLES = plantsCategory.addEntry(new BooleanConfigEntry("enable_witchs_cradles"));

        CommentConfigEntry requiredRestartComment = new CommentConfigEntry("Each option in the config " +
                "requires a game restart!");

        Config.Builder configBuilder = new Config.Builder(AssortedDiscoveries.MOD_ID)
                .addComment(requiredRestartComment)
                .addComment(new CommentConfigEntry("Enable or disable any option by toggling the setting between true and false."))
                .addCategory(buildingBlocksCategory.build())
                .addCategory(plushiesCategory.build())
                .addCategory(foodCategory.build())
                .addCategory(plantsCategory.build());
        CONFIG = configBuilder.build();
        updateFromFile();
    }
}
