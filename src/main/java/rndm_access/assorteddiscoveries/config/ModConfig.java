package rndm_access.assorteddiscoveries.config;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.WorldSavePath;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.parser.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.ConfigCategory;

import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    public static final Path GLOBAL_PATH;
    public static final BooleanConfigEntry ENABLE_DYED_CAMPFIRES;
    public static final BooleanConfigEntry ENABLE_DYED_LANTERNS;
    public static final BooleanConfigEntry ENABLE_DYED_TORCHES;
    public static final BooleanConfigEntry ENABLE_ALLAY_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_BAT_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CAMEL_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CAT_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_CHICKEN_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_COW_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_HORSE_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_MOOSHROOM_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_OCELOT_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_PIG_PLUSHIE;
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
    public static final BooleanConfigEntry ENABLE_POLAR_BEAR_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SPIDER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_PALE_WOLF_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_BLAZE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_CREEPER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_GHAST_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_GUARDIAN_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_HOGLIN_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_ILLAGER_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_MAGMA_CUBE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_PHANTOM_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_RAVAGER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SHULKER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SKELETON_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_SLIME_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_VEX_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_WITCH_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_WITHER_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_ZOMBIE_PLUSHIE;
    public static final BooleanConfigEntry ENABLE_ZOMBIE_VILLAGER_PLUSHIES;
    public static final BooleanConfigEntry ENABLE_WOODEN_WALLS;
    public static final BooleanConfigEntry ENABLE_STRIPPED_WOODEN_WALLS;
    public static final BooleanConfigEntry ENABLE_WOODEN_ROPE_LADDERS;
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
    public static final BooleanConfigEntry ENABLE_WOODCUTTER;
    public static final BooleanConfigEntry ENABLE_CRACKED_STONE_BRICK_BLOCKS;
    public static final BooleanConfigEntry ENABLE_WOODEN_PLANTER_BOXES;
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
    public static final BooleanConfigEntry ENABLE_WITCHS_CRADLE_SOUP;
    public static final BooleanConfigEntry ENABLE_PUDDING;
    public static final BooleanConfigEntry ENABLE_CARAMEL_APPLE;
    public static final BooleanConfigEntry ENABLE_NETHER_BERRIES;
    public static final BooleanConfigEntry ENABLE_PURPLE_MUSHROOMS;
    public static final BooleanConfigEntry ENABLE_CATTAILS;
    public static final BooleanConfigEntry ENABLE_BOG_BLOSSOMS;
    public static final BooleanConfigEntry ENABLE_BLOOD_KELP;
    public static final BooleanConfigEntry ENABLE_ENDER_PLANTS;
    public static final BooleanConfigEntry RABBITS_SAFE_FALL_INCREASED;
    public static final JsonConfig CONFIG;

    public static void initializeConfig() {
        CONFIG.setPath(GLOBAL_PATH);
        CONFIG.setType(ConfigType.GLOBAL);

        if (Files.exists(GLOBAL_PATH)) {
            CONFIG.load();
            AssortedDiscoveries.LOGGER.info("Loaded global config");
        } else {
            CONFIG.save(null);
            CONFIG.load();
            AssortedDiscoveries.LOGGER.info("Created global config");
        }

        // When loading the world load the config for that world if there is one!
        ServerWorldEvents.LOAD.register((phase, listener) -> {
            Path worldPathFolder = phase.getSavePath(WorldSavePath.ROOT).getParent();
            Path worldPath = Path.of(worldPathFolder.toString() + "/config/")
                    .resolve(ADReference.MOD_ID + ".json5");

            if (CONFIG.getType().equals(ConfigType.GLOBAL) && Files.exists(worldPath)) {
                CONFIG.setPath(worldPath);
                CONFIG.load();
                CONFIG.setType(ConfigType.LOCAL);
                AssortedDiscoveries.LOGGER.info("Loaded world config for '{}'", worldPathFolder.getFileName());
            }
        });

        // After unloading the world reload the global config!
        ServerWorldEvents.UNLOAD.register((phase, listener) -> {
            if (CONFIG.getType().equals(ConfigType.LOCAL)) {
                CONFIG.setPath(GLOBAL_PATH);
                CONFIG.load();
                CONFIG.setType(ConfigType.GLOBAL);
                AssortedDiscoveries.LOGGER.info("Loaded global config");
            }
        });
    }

    /**
     * @return A config with all entries set to their default values!
     */
    private static JsonConfig makeConfig() {
        JsonConfig.Builder configBuilder = new JsonConfig.Builder();

        ConfigCategory dyedSubcategory = new ConfigCategory.Builder("dyed")
                .addBooleanEntry(ENABLE_DYED_CAMPFIRES)
                .addBooleanEntry(ENABLE_DYED_LANTERNS)
                .addBooleanEntry(ENABLE_DYED_TORCHES).build();

        ConfigCategory passivePlushiesSubcategory = new ConfigCategory.Builder("passive_plushies")
                .addBooleanEntry(ENABLE_ALLAY_PLUSHIE)
                .addBooleanEntry(ENABLE_BAT_PLUSHIE)
                .addBooleanEntry(ENABLE_CAMEL_PLUSHIE)
                .addBooleanEntry(ENABLE_CAT_PLUSHIES)
                .addBooleanEntry(ENABLE_CHICKEN_PLUSHIE)
                .addBooleanEntry(ENABLE_COW_PLUSHIE)
                .addBooleanEntry(ENABLE_HORSE_PLUSHIES)
                .addBooleanEntry(ENABLE_MOOSHROOM_PLUSHIES)
                .addBooleanEntry(ENABLE_OCELOT_PLUSHIE)
                .addBooleanEntry(ENABLE_PIG_PLUSHIE)
                .addBooleanEntry(ENABLE_PUFFERFISH_PLUSHIE)
                .addBooleanEntry(ENABLE_RABBIT_PLUSHIES)
                .addBooleanEntry(ENABLE_SHEEP_PLUSHIES)
                .addBooleanEntry(ENABLE_SQUID_PLUSHIES)
                .addBooleanEntry(ENABLE_STRIDER_PLUSHIES)
                .addBooleanEntry(ENABLE_VILLAGER_PLUSHIES)
                .build();

        ConfigCategory neutralPlushiesSubcategory = new ConfigCategory.Builder("neutral_plushies")
                .addBooleanEntry(ENABLE_BEE_PLUSHIE)
                .addBooleanEntry(ENABLE_CAVE_SPIDER_PLUSHIE)
                .addBooleanEntry(ENABLE_ENDERMAN_PLUSHIE)
                .addBooleanEntry(ENABLE_PIGLIN_PLUSHIES)
                .addBooleanEntry(ENABLE_POLAR_BEAR_PLUSHIE)
                .addBooleanEntry(ENABLE_SPIDER_PLUSHIE)
                .addBooleanEntry(ENABLE_PALE_WOLF_PLUSHIE)
                .build();

        ConfigCategory hostilePlushiesSubcategory = new ConfigCategory.Builder("hostile_plushies")
                .addBooleanEntry(ENABLE_BLAZE_PLUSHIE)
                .addBooleanEntry(ENABLE_CREEPER_PLUSHIE)
                .addBooleanEntry(ENABLE_GHAST_PLUSHIE)
                .addBooleanEntry(ENABLE_GUARDIAN_PLUSHIE)
                .addBooleanEntry(ENABLE_HOGLIN_PLUSHIES)
                .addBooleanEntry(ENABLE_ILLAGER_PLUSHIES)
                .addBooleanEntry(ENABLE_MAGMA_CUBE_PLUSHIE)
                .addBooleanEntry(ENABLE_PHANTOM_PLUSHIE)
                .addBooleanEntry(ENABLE_RAVAGER_PLUSHIE)
                .addBooleanEntry(ENABLE_SHULKER_PLUSHIE)
                .addBooleanEntry(ENABLE_SKELETON_PLUSHIE)
                .addBooleanEntry(ENABLE_SLIME_PLUSHIE)
                .addBooleanEntry(ENABLE_VEX_PLUSHIE)
                .addBooleanEntry(ENABLE_WITCH_PLUSHIE)
                .addBooleanEntry(ENABLE_WITHER_PLUSHIE)
                .addBooleanEntry(ENABLE_ZOMBIE_PLUSHIE)
                .addBooleanEntry(ENABLE_ZOMBIE_VILLAGER_PLUSHIES)
                .build();

        ConfigCategory buildingCategory = new ConfigCategory.Builder("building")
                .addSubcategory(dyedSubcategory)
                .addSubcategory(passivePlushiesSubcategory)
                .addSubcategory(neutralPlushiesSubcategory)
                .addSubcategory(hostilePlushiesSubcategory)
                .addBooleanEntry(ENABLE_WOODEN_WALLS)
                .addBooleanEntry(ENABLE_STRIPPED_WOODEN_WALLS)
                .addBooleanEntry(ENABLE_WOODEN_ROPE_LADDERS)
                .addBooleanEntry(ENABLE_IRON_LADDERS)
                .addBooleanEntry(ENABLE_BLACKSTONE_TILES)
                .addBooleanEntry(ENABLE_TWISTED_BLACKSTONE)
                .addBooleanEntry(ENABLE_TWISTED_BLACKSTONE_TILES)
                .addBooleanEntry(ENABLE_TWISTED_NETHERRACK)
                .addBooleanEntry(ENABLE_TWISTED_NETHER_BRICKS)
                .addBooleanEntry(ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS)
                .addBooleanEntry(ENABLE_WEEPING_NETHERRACK)
                .addBooleanEntry(ENABLE_WEEPING_NETHER_BRICKS)
                .addBooleanEntry(ENABLE_WEEPING_BLACKSTONE)
                .addBooleanEntry(ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS)
                .addBooleanEntry(ENABLE_WEEPING_BLACKSTONE_TILES)
                .addBooleanEntry(ENABLE_SMOKY_QUARTZ_BLOCKS)
                .addBooleanEntry(ENABLE_SMOKY_QUARTZ_BRICKS)
                .addBooleanEntry(ENABLE_SMOOTH_SMOKY_QUARTZ)
                .addBooleanEntry(ENABLE_QUARTZ_TILES)
                .addBooleanEntry(ENABLE_QUARTZ_WALLS)
                .addBooleanEntry(ENABLE_BAUXITE)
                .addBooleanEntry(ENABLE_BAUXITE_BRICKS)
                .addBooleanEntry(ENABLE_CRACKED_BAUXITE_BRICKS)
                .addBooleanEntry(ENABLE_MOSSY_BAUXITE_BRICKS)
                .addBooleanEntry(ENABLE_STONE_TILES)
                .addBooleanEntry(ENABLE_CRACKED_STONE_TILES)
                .addBooleanEntry(ENABLE_MOSSY_STONE_TILES)
                .addBooleanEntry(ENABLE_WOODCUTTER)
                .addBooleanEntry(ENABLE_CRACKED_STONE_BRICK_BLOCKS)
                .build();

        //TODO: Give enable_ender_plants a better name!
        ConfigCategory farmingCategory = new ConfigCategory.Builder("farming")
                .addBooleanEntry(ENABLE_WOODEN_PLANTER_BOXES)
                .addBooleanEntry(ENABLE_GREEN_ONIONS)
                .addBooleanEntry(ENABLE_NOODLE_SOUP)
                .addBooleanEntry(ENABLE_BLUEBERRIES)
                .addBooleanEntry(ENABLE_BLUEBERRY_PIE)
                .addBooleanEntry(ENABLE_BLUEBERRY_JUICE)
                .addBooleanEntry(ENABLE_SWEET_BERRY_PIE)
                .addBooleanEntry(ENABLE_SWEET_BERRY_JUICE)
                .addBooleanEntry(ENABLE_CHOCOLATE_CAKE)
                .addBooleanEntry(ENABLE_RED_VELVET_CAKE)
                .addBooleanEntry(ENABLE_FRIED_EGG)
                .addBooleanEntry(ENABLE_HOGLIN_STEW)
                .addBooleanEntry(ENABLE_FORESTS_BOUNTY)
                .addBooleanEntry(ENABLE_WITCHS_CRADLE_SOUP)
                .addBooleanEntry(ENABLE_PUDDING)
                .addBooleanEntry(ENABLE_CARAMEL_APPLE)
                .addBooleanEntry(ENABLE_NETHER_BERRIES)
                .addBooleanEntry(ENABLE_PURPLE_MUSHROOMS)
                .addBooleanEntry(ENABLE_CATTAILS)
                .addBooleanEntry(ENABLE_BOG_BLOSSOMS)
                .addBooleanEntry(ENABLE_BLOOD_KELP)
                .addBooleanEntry(ENABLE_ENDER_PLANTS).build();

        ConfigCategory miscCategory = new ConfigCategory.Builder("misc")
                .addBooleanEntry(RABBITS_SAFE_FALL_INCREASED)
                .build();

        return configBuilder.addCategory(buildingCategory).addCategory(farmingCategory)
                .addCategory(miscCategory).build();
    }

    static {
        GLOBAL_PATH = FabricLoader.getInstance().getConfigDir().resolve(ADReference.MOD_ID + ".json5");
        ENABLE_DYED_CAMPFIRES = new BooleanConfigEntry("enable_dyed_campfires");
        ENABLE_DYED_LANTERNS = new BooleanConfigEntry("enable_dyed_lanterns");
        ENABLE_DYED_TORCHES = new BooleanConfigEntry("enable_dyed_torches");
        ENABLE_ALLAY_PLUSHIE = new BooleanConfigEntry("enable_allay_plushie");
        ENABLE_BAT_PLUSHIE = new BooleanConfigEntry("enable_bat_plushie");
        ENABLE_CAMEL_PLUSHIE = new BooleanConfigEntry("enable_camel_plushie");
        ENABLE_CAT_PLUSHIES = new BooleanConfigEntry("enable_cat_plushies");
        ENABLE_CHICKEN_PLUSHIE = new BooleanConfigEntry("enable_chicken_plushie");
        ENABLE_COW_PLUSHIE = new BooleanConfigEntry("enable_cow_plushie");
        ENABLE_HORSE_PLUSHIES = new BooleanConfigEntry("enable_horse_plushies");
        ENABLE_MOOSHROOM_PLUSHIES = new BooleanConfigEntry("enable_mooshroom_plushies");
        ENABLE_OCELOT_PLUSHIE = new BooleanConfigEntry("enable_ocelot_plushie");
        ENABLE_PIG_PLUSHIE = new BooleanConfigEntry("enable_pig_plushie");
        ENABLE_PUFFERFISH_PLUSHIE = new BooleanConfigEntry("enable_pufferfish_plushie");
        ENABLE_RABBIT_PLUSHIES = new BooleanConfigEntry("enable_rabbit_plushies");
        ENABLE_SHEEP_PLUSHIES = new BooleanConfigEntry("enable_sheep_plushies");
        ENABLE_SQUID_PLUSHIES = new BooleanConfigEntry("enable_squid_plushies");
        ENABLE_STRIDER_PLUSHIES = new BooleanConfigEntry("enable_strider_plushies");
        ENABLE_VILLAGER_PLUSHIES = new BooleanConfigEntry("enable_villager_plushies");
        ENABLE_BEE_PLUSHIE = new BooleanConfigEntry("enable_bee_plushie");
        ENABLE_CAVE_SPIDER_PLUSHIE = new BooleanConfigEntry("enable_cave_spider_plushie");
        ENABLE_ENDERMAN_PLUSHIE = new BooleanConfigEntry("enable_enderman_plushie");
        ENABLE_PIGLIN_PLUSHIES = new BooleanConfigEntry("enable_piglin_plushies");
        ENABLE_POLAR_BEAR_PLUSHIE = new BooleanConfigEntry("enable_polar_bear_plushie");
        ENABLE_SPIDER_PLUSHIE = new BooleanConfigEntry("enable_spider_plushie");
        ENABLE_PALE_WOLF_PLUSHIE = new BooleanConfigEntry("enable_pale_wolf_plushie");
        ENABLE_BLAZE_PLUSHIE = new BooleanConfigEntry("enable_blaze_plushie");
        ENABLE_CREEPER_PLUSHIE = new BooleanConfigEntry("enable_creeper_plushie");
        ENABLE_GHAST_PLUSHIE = new BooleanConfigEntry("enable_ghast_plushie");
        ENABLE_GUARDIAN_PLUSHIE = new BooleanConfigEntry("enable_guardian_plushie");
        ENABLE_HOGLIN_PLUSHIES = new BooleanConfigEntry("enable_hoglin_plushies");
        ENABLE_ILLAGER_PLUSHIES = new BooleanConfigEntry("enable_illager_plushies");
        ENABLE_MAGMA_CUBE_PLUSHIE = new BooleanConfigEntry("enable_magma_cube_plushie");
        ENABLE_PHANTOM_PLUSHIE = new BooleanConfigEntry("enable_phantom_plushie");
        ENABLE_RAVAGER_PLUSHIE = new BooleanConfigEntry("enable_ravager_plushie");
        ENABLE_SHULKER_PLUSHIE = new BooleanConfigEntry("enable_shulker_plushie");
        ENABLE_SKELETON_PLUSHIE = new BooleanConfigEntry("enable_skeleton_plushie");
        ENABLE_SLIME_PLUSHIE = new BooleanConfigEntry("enable_slime_plushie");
        ENABLE_VEX_PLUSHIE = new BooleanConfigEntry("enable_vex_plushie");
        ENABLE_WITCH_PLUSHIE = new BooleanConfigEntry("enable_witch_plushie");
        ENABLE_WITHER_PLUSHIE = new BooleanConfigEntry("enable_wither_plushie");
        ENABLE_ZOMBIE_PLUSHIE = new BooleanConfigEntry("enable_zombie_plushie");
        ENABLE_ZOMBIE_VILLAGER_PLUSHIES = new BooleanConfigEntry("enable_zombie_villager_plushies");
        ENABLE_WOODEN_WALLS = new BooleanConfigEntry("enable_wooden_walls");
        ENABLE_STRIPPED_WOODEN_WALLS = new BooleanConfigEntry("enable_stripped_wooden_walls");
        ENABLE_WOODEN_ROPE_LADDERS = new BooleanConfigEntry("enable_wooden_rope_ladders");
        ENABLE_IRON_LADDERS = new BooleanConfigEntry("enable_iron_ladders");
        ENABLE_BLACKSTONE_TILES = new BooleanConfigEntry("enable_blackstone_tiles");
        ENABLE_TWISTED_BLACKSTONE = new BooleanConfigEntry("enable_twisted_blackstone");
        ENABLE_TWISTED_BLACKSTONE_TILES = new BooleanConfigEntry("enable_twisted_blackstone_tiles",
                "Requires blackstone tiles!");
        ENABLE_TWISTED_NETHERRACK = new BooleanConfigEntry("enable_twisted_netherrack");
        ENABLE_TWISTED_NETHER_BRICKS = new BooleanConfigEntry("enable_twisted_nether_bricks");
        ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS
                = new BooleanConfigEntry("enable_twisted_polished_blackstone_bricks");
        ENABLE_WEEPING_NETHERRACK = new BooleanConfigEntry("enable_weeping_netherrack");
        ENABLE_WEEPING_NETHER_BRICKS = new BooleanConfigEntry("enable_weeping_nether_bricks");
        ENABLE_WEEPING_BLACKSTONE = new BooleanConfigEntry("enable_weeping_blackstone");
        ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS
                = new BooleanConfigEntry("enable_weeping_polished_blackstone_bricks");
        ENABLE_WEEPING_BLACKSTONE_TILES = new BooleanConfigEntry("enable_weeping_blackstone_tiles",
                "Requires blackstone tiles!");
        ENABLE_SMOKY_QUARTZ_BLOCKS = new BooleanConfigEntry("enable_smoky_quartz_blocks");
        ENABLE_SMOKY_QUARTZ_BRICKS = new BooleanConfigEntry("enable_smoky_quartz_bricks");
        ENABLE_SMOOTH_SMOKY_QUARTZ = new BooleanConfigEntry("enable_smooth_smoky_quartz");
        ENABLE_QUARTZ_TILES = new BooleanConfigEntry("enable_quartz_tiles");
        ENABLE_QUARTZ_WALLS = new BooleanConfigEntry("enable_quartz_walls");
        ENABLE_BAUXITE = new BooleanConfigEntry("enable_bauxite");
        ENABLE_BAUXITE_BRICKS = new BooleanConfigEntry("enable_bauxite_bricks");
        ENABLE_CRACKED_BAUXITE_BRICKS = new BooleanConfigEntry("enable_cracked_bauxite_bricks");
        ENABLE_MOSSY_BAUXITE_BRICKS = new BooleanConfigEntry("enable_mossy_bauxite_bricks");
        ENABLE_STONE_TILES = new BooleanConfigEntry("enable_stone_tiles");
        ENABLE_CRACKED_STONE_TILES = new BooleanConfigEntry("enable_cracked_stone_tiles");
        ENABLE_MOSSY_STONE_TILES = new BooleanConfigEntry("enable_mossy_stone_tiles");
        ENABLE_WOODCUTTER = new BooleanConfigEntry("enable_woodcutter");
        ENABLE_CRACKED_STONE_BRICK_BLOCKS = new BooleanConfigEntry("enable_cracked_stone_brick_blocks");
        ENABLE_WOODEN_PLANTER_BOXES = new BooleanConfigEntry("enable_wooden_planter_boxes");
        ENABLE_GREEN_ONIONS = new BooleanConfigEntry("enable_green_onions");
        ENABLE_NOODLE_SOUP = new BooleanConfigEntry("enable_noodle_soup");
        ENABLE_BLUEBERRIES = new BooleanConfigEntry("enable_blueberries");
        ENABLE_BLUEBERRY_PIE = new BooleanConfigEntry("enable_blueberry_pie");
        ENABLE_BLUEBERRY_JUICE = new BooleanConfigEntry("enable_blueberry_juice");
        ENABLE_SWEET_BERRY_PIE = new BooleanConfigEntry("enable_sweet_berry_pie");
        ENABLE_SWEET_BERRY_JUICE = new BooleanConfigEntry("enable_sweet_berry_juice");
        ENABLE_CHOCOLATE_CAKE = new BooleanConfigEntry("enable_chocolate_cake");
        ENABLE_RED_VELVET_CAKE = new BooleanConfigEntry("enable_red_velvet_cake");
        ENABLE_FRIED_EGG = new BooleanConfigEntry("enable_fried_egg");
        ENABLE_HOGLIN_STEW = new BooleanConfigEntry("enable_hoglin_stew");
        ENABLE_FORESTS_BOUNTY = new BooleanConfigEntry("enable_forests_bounty");
        ENABLE_WITCHS_CRADLE_SOUP = new BooleanConfigEntry("enable_witchs_cradle_soup");
        ENABLE_PUDDING = new BooleanConfigEntry("enable_pudding");
        ENABLE_CARAMEL_APPLE = new BooleanConfigEntry("enable_caramel_apple");
        ENABLE_NETHER_BERRIES = new BooleanConfigEntry("enable_nether_berries");
        ENABLE_PURPLE_MUSHROOMS = new BooleanConfigEntry("enable_purple_mushrooms");
        ENABLE_CATTAILS = new BooleanConfigEntry("enable_cattails");
        ENABLE_BOG_BLOSSOMS = new BooleanConfigEntry("enable_bog_blossoms");
        ENABLE_BLOOD_KELP = new BooleanConfigEntry("enable_blood_kelp");
        ENABLE_ENDER_PLANTS = new BooleanConfigEntry("enable_ender_plants",
                "Whether patches of ender grass and snapdragons should spawn!");
        RABBITS_SAFE_FALL_INCREASED = new BooleanConfigEntry("rabbits_safe_fall_increased");
        CONFIG = makeConfig();
    }
}
