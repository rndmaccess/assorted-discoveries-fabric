package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.CommentConfigEntry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ModConfig {
    private static volatile Config config = null;

    /**
     * Config data available:<br>
     * Server: Immediately when the game is started!
     * Client: After the player joins.<br>
     *
     * @return The config with the data from either the server's config or the client's config.
     *         Config data is synchronized through packets.
     *         If there is a problem loading then the config will use default values.
     */
    public static synchronized Config getConfig() {
        if (config == null) {
            config = makeConfig();
        }
        return config;
    }

    /**
     * Useful for places where you need to make a temporary copy of the config data. One use could be for saving!
     * @return A new config based on the default config with values loaded from the local config file.
     */
    public static synchronized Config makeConfig() {
        return createOrLoad(getDefaultConfig());
    }

    public static synchronized void updateFromList(List<ConfigCategory> configList) {
        config = config.loadConfigFromList(configList);
    }

    public static synchronized void updateFromFile() {
        config = createOrLoad(getDefaultConfig());
    }

    private static Config createOrLoad(Config defaultConfig) {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve(AssortedDiscoveries.MOD_ID + ".json5");

        if (!Files.exists(configPath)) {
            defaultConfig.create();
            return defaultConfig;
        }
        return defaultConfig.loadConfigFromFile();
    }

    private static Config getDefaultConfig() {
        CommentConfigEntry requiredRestartComment = new CommentConfigEntry("Each option in the config " +
                "requires a game restart!");

        ConfigCategory buildingBlocksCategory = new ConfigCategory.Builder("building_blocks")
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PLANTER_BOXES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_CAMPFIRES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_LANTERNS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_TORCHES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOODEN_WALLS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ROPE_LADDERS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_IRON_LADDERS))
                .addComment(new CommentConfigEntry("Toggle all blackstone tile variants (weeping and twisted) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLACKSTONE_TILES))
                .addComment(new CommentConfigEntry("Toggle twisted blackstone and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE))
                .addComment(new CommentConfigEntry("Toggle twisted blackstone tiles and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES))
                .addComment(new CommentConfigEntry("Toggle twisted netherrack and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_NETHERRACK))
                .addComment(new CommentConfigEntry("Toggle twisted nether bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS))
                .addComment(new CommentConfigEntry("Toggle twisted polished blackstone bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle weeping netherrack and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_NETHERRACK))
                .addComment(new CommentConfigEntry("Toggle weeping nether bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS))
                .addComment(new CommentConfigEntry("Toggle weeping blackstone variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE))
                .addComment(new CommentConfigEntry("Toggle weeping polished blackstone bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle weeping blackstone tiles and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES))
                .addComment(new CommentConfigEntry("Toggle all smoky quartz blocks and variants (bricks and smooth) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS))
                .addComment(new CommentConfigEntry("Toggle smoky quartz bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS))
                .addComment(new CommentConfigEntry("Toggle smooth smoky quartz and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ))
                .addComment(new CommentConfigEntry("Toggle quartz brick stairs, slabs, and walls on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS))
                .addComment(new CommentConfigEntry("Toggle quartz tiles and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_TILES))
                .addComment(new CommentConfigEntry("Toggle the smooth quartz wall and quartz wall on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_WALLS))
                .addComment(new CommentConfigEntry("Toggle all bauxite variants (normal, bricks, mossy bricks, etc.) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAUXITE))
                .addComment(new CommentConfigEntry("Toggle all bauxite brick variants (mossy and cracked) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAUXITE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle cracked bauxite bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle mossy bauxite bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle all stone tile variants (normal, cracked, mossy, etc.) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STONE_TILES))
                .addComment(new CommentConfigEntry("Toggle cracked stone tiles and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_STONE_TILES))
                .addComment(new CommentConfigEntry("Toggle mossy stone tiles and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_STONE_TILES))
                .addComment(new CommentConfigEntry("Toggle cracked stone brick stairs, slabs, and walls on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STONE_WALLS))
                .addComment(new CommentConfigEntry("Toggle calcite stairs, slabs, and walls on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CALCITE_BLOCKS))
                .addComment(new CommentConfigEntry("Toggle polished calcite and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLISHED_CALCITE))
                .addComment(new CommentConfigEntry("Toggle all calcite bricks variants (cracked and mossy) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CALCITE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle cracked calcite bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle mossy calcite bricks and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle dripstone stairs, slabs, and walls on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS))
                .addComment(new CommentConfigEntry("Toggle polished dripstone and variants (stairs, slabs, walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE))
                .addComment(new CommentConfigEntry("Toggle all dripstone bricks and variants (cracked and mossy) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle cracked dripstone bricks and variants (stairs, slabs, and walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle mossy dripstone bricks and variants (stairs, slabs, and walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Toggle snow bricks and variants (stairs, slabs, and walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SNOW_BRICKS))
                .addComment(new CommentConfigEntry("Toggle packed snow and variants (stairs, slabs, and walls) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PACKED_SNOW))
                .addComment(new CommentConfigEntry("Toggle all dirt slab variants (coarse, grass, podzol, etc.) on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DIRT_SLABS)).build();

        ConfigCategory plushiesCategory = new ConfigCategory.Builder("plushies")
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ALLAY_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAT_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CAMEL_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOLF_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CAT_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CHICKEN_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_COW_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HORSE_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PIG_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_RABBIT_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SHEEP_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SQUID_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STRIDER_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_VILLAGER_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SNIFFER_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BEE_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PIGLIN_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SPIDER_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLAZE_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CREEPER_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GHAST_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HOGLIN_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ILLAGER_PLUSHIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PHANTOM_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SHULKER_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SKELETON_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SLIME_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_VEX_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITCH_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITHER_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CREAKING_PLUSHIE)).build();

        ConfigCategory foodCategory = new ConfigCategory.Builder("foods")
                .addComment(new CommentConfigEntry("If disabled, noodle soup does not require green onions."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GREEN_ONIONS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_NOODLE_SOUP))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CHOCOLATE_CAKE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_RED_VELVET_CAKE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FRIED_EGG))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HOGLIN_STEW))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY))
                .addComment(new CommentConfigEntry("Toggle pudding and berry pudding on or off."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PUDDING))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CARAMEL_APPLE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SWEET_BERRY_PIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SWEET_BERRY_JUICE))
                .addComment(new CommentConfigEntry("If disabled, berry pudding does not require blueberries."))
                .addComment(new CommentConfigEntry("When disabled, blueberry pie and juice are disabled."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLUEBERRIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLUEBERRY_PIE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLUEBERRY_JUICE))
                .addComment(new CommentConfigEntry("When disabled cindersnap berry juice and cindersnap forage mix are disabled."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CINDERSNAP_BERRIES))
                .addComment(new CommentConfigEntry("When disabled frostbite berry juice and frostbite forage mix are disabled."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FROSTBITE_BERRIES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CINDERSNAP_BERRY_JUICE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRIMSON_FORAGE_MIX))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FROSTBITE_BERRY_JUICE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WARPED_FORAGE_MIX)).build();

        ConfigCategory plantsCategory = new ConfigCategory.Builder("plants")
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLOOD_KELP))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CATTAILS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS))
                .addComment(new CommentConfigEntry("Toggle snapdragons and ender grass."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ENDER_PLANTS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITCHS_CRADLES)).build();

        Config.Builder config = new Config.Builder(AssortedDiscoveries.MOD_ID)
                .addComment(requiredRestartComment)
                .addCategory(buildingBlocksCategory)
                .addCategory(plushiesCategory)
                .addCategory(foodCategory)
                .addCategory(plantsCategory);
        return config.build();
    }
}
