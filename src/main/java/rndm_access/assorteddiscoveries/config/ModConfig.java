package rndm_access.assorteddiscoveries.config;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.WorldSavePath;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.*;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.deserializer.ConfigCategory;

import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    public static final Path GLOBAL_PATH;

    public static JsonConfig createOrInitConfig() {
        if (Files.exists(GLOBAL_PATH)) {
            // Here we get the instance because it is are first time calling this function so the instance will be null!
            ConfigData data = ConfigData.getInstance(GLOBAL_PATH, ConfigType.GLOBAL);
            return loadGlobalConfig(data);
        } else {
            return createGlobalConfig();
        }
    }

    public static void registerConfigServerEvents() {
        // When loading the world load the config for that world if there is one!
        ServerWorldEvents.LOAD.register((phase, listener) -> {
            ConfigData data = ConfigData.getInstance();
            ConfigType type = data.getType();

            if (type == ConfigType.GLOBAL) {
                loadLocalConfig(phase);
            }
        });

        // After unloading the world reload the global config!
        ServerWorldEvents.UNLOAD.register((phase, listener) -> {
            ConfigData data = ConfigData.getInstance();
            ConfigType type = data.getType();

            if (type == ConfigType.LOCAL) {
                ConfigData.update(GLOBAL_PATH, ConfigType.GLOBAL);
                data = ConfigData.getInstance();
                loadGlobalConfig(data);
            }
        });
    }

    private static void loadLocalConfig(MinecraftServer phase) {
        Path worldPathFolder = phase.getSavePath(WorldSavePath.ROOT).getParent();
        Path worldPath = Path.of(worldPathFolder.toString() + "/config/")
                .resolve(ADReference.MOD_ID + ".json5");

        if (Files.exists(worldPath)) {
            ConfigData.update(worldPath, ConfigType.LOCAL);
            ConfigData data = ConfigData.getInstance();
            JsonConfig config = ModConfig.getInternalConfig();

            config.load(data);
            AssortedDiscoveries.LOGGER.info("Loaded world config for '{}'", worldPathFolder.getFileName());
        }
    }

    private static JsonConfig createGlobalConfig() {
        ConfigData data = ConfigData.getInstance(GLOBAL_PATH, ConfigType.GLOBAL);
        JsonConfig config = ModConfig.getInternalConfig();

        config.create(data);
        config.load(data);
        AssortedDiscoveries.LOGGER.info("Created global config");
        return config;
    }

    private static JsonConfig loadGlobalConfig(ConfigData data) {
        JsonConfig config = ModConfig.getInternalConfig();

        config.load(data);
        AssortedDiscoveries.LOGGER.info("Loaded global config");
        return config;
    }

    public static JsonConfig getInternalConfig() {
        ConfigCategory dyedSubcategory = new ConfigCategory.Builder("dyed")
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_CAMPFIRES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_LANTERNS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DYED_TORCHES)).build();

        ConfigCategory passivePlushiesSubcategory = new ConfigCategory.Builder("passive_plushies")
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ALLAY_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAT_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CAMEL_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CAT_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CHICKEN_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_COW_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HORSE_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_OCELOT_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PIG_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_RABBIT_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SHEEP_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SQUID_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STRIDER_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_VILLAGER_PLUSHIES)).build();

        ConfigCategory neutralPlushiesSubcategory = new ConfigCategory.Builder("neutral_plushies")
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BEE_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PIGLIN_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SPIDER_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE)).build();

        ConfigCategory hostilePlushiesSubcategory = new ConfigCategory.Builder("hostile_plushies")
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLAZE_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CREEPER_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GHAST_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HOGLIN_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ILLAGER_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PHANTOM_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_RAVAGER_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SHULKER_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SKELETON_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SLIME_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_VEX_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITCH_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITHER_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CREAKING_PLUSHIE)).build();

        ConfigCategory structureCategory = new ConfigCategory.Builder("structures")
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FOREST_CABINS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DARK_FOREST_CABINS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BIRCH_FOREST_CABINS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TAIGA_CABINS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SNOWY_TAIGA_CABINS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRIMSON_FOREST_CABINS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WARPED_FOREST_CABINS)).build();

        ConfigCategory buildingBlocksCategory = new ConfigCategory.Builder("building_blocks")
                .addSubcategory(dyedSubcategory)
                .addSubcategory(passivePlushiesSubcategory)
                .addSubcategory(neutralPlushiesSubcategory)
                .addSubcategory(hostilePlushiesSubcategory)
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOODEN_WALLS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_IRON_LADDERS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLACKSTONE_TILES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES,
                        "This option requires blackstone tiles!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_NETHERRACK))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_NETHERRACK))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES,
                        "This option requires blackstone tiles!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS,
                        "This option requires smoky quartz blocks!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ,
                        "This option requires smoky quartz blocks!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_TILES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_QUARTZ_WALLS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAUXITE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BAUXITE_BRICKS,
                        "This option requires bauxite!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS,
                        "This option requires bauxite and bauxite bricks!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS,
                        "This option requires bauxite and bauxite bricks!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STONE_TILES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_STONE_TILES,
                        "This option requires stone tiles!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_STONE_TILES,
                        "This option requires stone tiles!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOODCUTTER))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_STONE_WALLS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CALCITE_BLOCKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLISHED_CALCITE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CALCITE_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS,
                        "This option requires calcite bricks!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS,
                        "This option requires calcite bricks!"))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS)).build();

        //TODO: Give enable_ender_plants a better name!
        ConfigCategory farmingCategory = new ConfigCategory.Builder("farming")
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_GREEN_ONIONS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_NOODLE_SOUP))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLUEBERRIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLUEBERRY_PIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLUEBERRY_JUICE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SWEET_BERRY_PIE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_SWEET_BERRY_JUICE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CHOCOLATE_CAKE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_RED_VELVET_CAKE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FRIED_EGG))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_HOGLIN_STEW))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PUDDING))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CARAMEL_APPLE))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_NETHER_BERRIES))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_CATTAILS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_BLOOD_KELP))
                .addBooleanEntry(new BooleanConfigEntry(ModConfigKeys.ENABLE_ENDER_PLANTS,
                        "Whether patches of ender grass and snapdragons should spawn!")).build();

        return new JsonConfig(buildingBlocksCategory, structureCategory, farmingCategory);
    }

    static {
        GLOBAL_PATH = FabricLoader.getInstance().getConfigDir().resolve(ADReference.MOD_ID + ".json5");
    }
}
