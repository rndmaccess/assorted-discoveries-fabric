package rndm_access.assorteddiscoveries.config;

import net.fabricmc.loader.api.FabricLoader;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.CommentConfigEntry;

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

    public static synchronized void updateFromList(List<JsonConfigCategory> configList) {
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

        JsonConfigCategory buildingBlocksCategory = new JsonConfigCategory.Builder("building_blocks")
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PLANTER_BOXES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_CAMPFIRES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_LANTERNS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_TORCHES))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOODEN_WALLS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ROPE_LADDERS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_IRON_LADDERS))
                .addComment(new CommentConfigEntry("Enable/disable all blackstone tile types and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLACKSTONE_TILES))
                .addComment(new CommentConfigEntry("Enable/disable twisted blackstone blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE))
                .addComment(new CommentConfigEntry("Enable/disable twisted blackstone tile blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES))
                .addComment(new CommentConfigEntry("Enable/disable twisted netherrack blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_NETHERRACK))
                .addComment(new CommentConfigEntry("Enable/disable twisted nether brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable twisted polished blackstone brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable weeping netherrack blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_NETHERRACK))
                .addComment(new CommentConfigEntry("Enable/disable weeping nether brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable weeping blackstone blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE))
                .addComment(new CommentConfigEntry("Enable/disable weeping polished blackstone brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable weeping blackstone tiles and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES))
                .addComment(new CommentConfigEntry("Enable/disable all smoky quartz blocks (normal, bricks, smooth) and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS))
                .addComment(new CommentConfigEntry("Enable/disable smoky quartz brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable smooth smoky quartz blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ))
                .addComment(new CommentConfigEntry("Enable/disable quartz brick stairs, slabs, and walls."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS))
                .addComment(new CommentConfigEntry("Enable/disable quartz tile blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_TILES))
                .addComment(new CommentConfigEntry("Enable/disable smooth quartz walls and quartz walls."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_WALLS))
                .addComment(new CommentConfigEntry("Enable/disable all bauxite types (normal, bricks, mossy bricks, etc.) and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAUXITE))
                .addComment(new CommentConfigEntry("Enable/disable all bauxite bricks (normal, mossy, cracked) and their and its variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAUXITE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable cracked bauxite brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable mossy bauxite brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable all stone tiles (normal, cracked, mossy, etc.) and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STONE_TILES))
                .addComment(new CommentConfigEntry("Enable/disable cracked stone tile blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_STONE_TILES))
                .addComment(new CommentConfigEntry("Enable/disable mossy stone tile blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_STONE_TILES))
                .addComment(new CommentConfigEntry("Enable/disable cracked stone brick stairs, slabs, and walls."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STONE_WALLS))
                .addComment(new CommentConfigEntry("Enable/disable calcite stairs, slabs, and walls."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CALCITE_BLOCKS))
                .addComment(new CommentConfigEntry("Enable/disable polished calcite blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLISHED_CALCITE))
                .addComment(new CommentConfigEntry("Enable/disable all calcite bricks (normal, cracked, mossy) and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CALCITE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable cracked calcite brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable mossy calcite brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable dripstone stairs, slabs, and walls."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS))
                .addComment(new CommentConfigEntry("Enable/disable polished dripstone blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE))
                .addComment(new CommentConfigEntry("Enable/disable all dripstone bricks (normal, cracked, mossy) and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable cracked dripstone brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable mossy dripstone brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable snow brick blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SNOW_BRICKS))
                .addComment(new CommentConfigEntry("Enable/disable packed snow blocks and their variants."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PACKED_SNOW))
                .addComment(new CommentConfigEntry("Enable/disable all dirt slabs (coarse, grass, podzol, etc.)"))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DIRT_SLABS)).build();

        JsonConfigCategory plushiesCategory = new JsonConfigCategory.Builder("plushies")
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

        JsonConfigCategory foodCategory = new JsonConfigCategory.Builder("foods")
                .addComment(new CommentConfigEntry("If disabled, noodle soup does not require green onions."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GREEN_ONIONS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_NOODLE_SOUP))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CHOCOLATE_CAKE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_RED_VELVET_CAKE))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FRIED_EGG))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HOGLIN_STEW))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY))
                .addComment(new CommentConfigEntry("Enable/disable pudding and berry pudding."))
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

        JsonConfigCategory plantsCategory = new JsonConfigCategory.Builder("plants")
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLOOD_KELP))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CATTAILS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS))
                .addComment(new CommentConfigEntry("Enable/disable snapdragons and ender grass."))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ENDER_PLANTS))
                .addEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITCHS_CRADLES)).build();

        Config.Builder config = new Config.Builder(AssortedDiscoveries.MOD_ID)
                .addComment(requiredRestartComment)
                .addComment(new CommentConfigEntry("Enable or disable any option by toggling the setting between true and false."))
                .addCategory(buildingBlocksCategory)
                .addCategory(plushiesCategory)
                .addCategory(foodCategory)
                .addCategory(plantsCategory);
        return config.build();
    }
}
