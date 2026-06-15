package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import net.minecraft.network.chat.Component;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.Config;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;

import java.util.*;
import java.util.function.Supplier;

public class ModConfigScreen {
    public static final HashMap<String, Object> ENTRY_VALUE_CHANGES = new HashMap<>();

    public static ConfigBuilder getConfigScreenBuilder() {
        Config config = ModConfig.makeConfig(); // Reload the config every time we open the screen.
                                                // This can be safely edited without affecting the current config loaded.
        Component title = Component.translatable("title." + AssortedDiscoveries.MOD_ID + ".config");
        ConfigBuilder configBuilder = ConfigBuilder.create().setTitle(title);
        configBuilder.setDefaultBackgroundTexture(AssortedDiscoveries.makeModId("textures/block/calcite_bricks.png"));
        configBuilder.setGlobalized(true);
        configBuilder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();

        addBuildingBlocksCategory(config, configBuilder, entryBuilder);
        addPlushiesCategory(config, configBuilder, entryBuilder);
        addFoodsCategory(config, configBuilder, entryBuilder);
        addPlantsCategory(config, configBuilder, entryBuilder);

        configBuilder.setSavingRunnable(() -> config.save(ENTRY_VALUE_CHANGES));
        return configBuilder;
    }

    private static void addBuildingBlocksCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "building_blocks";
        ConfigCategory category = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PLANTER_BOXES, categoryName);
        category.addEntry(configEntry);

        // Dyed Blocks
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_DYED_CAMPFIRES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_DYED_LANTERNS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_DYED_TORCHES, categoryName);
        category.addEntry(configEntry);

        // Netherrack and Nether Bricks
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_TWISTED_NETHERRACK, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WEEPING_NETHERRACK, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS, categoryName);
        category.addEntry(configEntry);

        // Blackstone Entries
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS,
                categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS,
                categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableBlackstoneTiles = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_BLACKSTONE_TILES, categoryName);
        category.addEntry(enableBlackstoneTiles);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        category.addEntry(configEntry);

        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WOODEN_WALLS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_ROPE_LADDERS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_IRON_LADDERS, categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableSmokyQuartzBlocks = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS, categoryName);
        category.addEntry(enableSmokyQuartzBlocks);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS,
                categoryName, enableSmokyQuartzBlocks);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ,
                categoryName, enableSmokyQuartzBlocks);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_QUARTZ_TILES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_QUARTZ_WALLS, categoryName);
        category.addEntry(configEntry);

        BooleanListEntry enableBauxite = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BAUXITE,
                categoryName);
        BooleanListEntry enableBauxiteBricks = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_BAUXITE_BRICKS, categoryName, enableBauxite);

        category.addEntry(enableBauxite);
        category.addEntry(enableBauxiteBricks);
        configEntry = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS, categoryName, enableBauxite, enableBauxiteBricks);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS, categoryName, enableBauxite, enableBauxiteBricks);
        category.addEntry(configEntry);

        BooleanListEntry enableStoneTiles = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_STONE_TILES, categoryName);

        category.addEntry(enableStoneTiles);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CRACKED_STONE_TILES,
                categoryName, enableStoneTiles);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_MOSSY_STONE_TILES,
                categoryName, enableStoneTiles);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS,
                categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_STONE_WALLS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CALCITE_BLOCKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_POLISHED_CALCITE, categoryName);
        category.addEntry(configEntry);

        BooleanListEntry enableCalciteBricksEntry = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_CALCITE_BRICKS, categoryName);
        category.addEntry(enableCalciteBricksEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS, categoryName,
                enableCalciteBricksEntry);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS, categoryName,
                enableCalciteBricksEntry);
        category.addEntry(configEntry);

        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS, categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableDripstoneBricksEntry = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_DRIPSTONE_BRICKS, categoryName);
        category.addEntry(enableDripstoneBricksEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS,
                categoryName, enableDripstoneBricksEntry);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS,
                categoryName, enableDripstoneBricksEntry);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SNOW_BRICKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PACKED_SNOW, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_DIRT_SLABS, categoryName);
        category.addEntry(configEntry);
    }

    private static void addPlushiesCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "plushies";
        ConfigCategory category = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_ALLAY_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BAT_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CAMEL_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WOLF_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CAT_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CHICKEN_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_COW_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_HORSE_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PIG_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_RABBIT_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SHEEP_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SQUID_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_STRIDER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_VILLAGER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SNIFFER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BEE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PIGLIN_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SPIDER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BLAZE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CREEPER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_GHAST_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_HOGLIN_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_ILLAGER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PHANTOM_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SHULKER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SKELETON_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SLIME_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_VEX_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WITCH_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WITHER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CREAKING_PLUSHIE, categoryName);
        category.addEntry(configEntry);
    }

    private static void addFoodsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "foods";
        ConfigCategory category = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_GREEN_ONIONS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_NOODLE_SOUP, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CHOCOLATE_CAKE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_RED_VELVET_CAKE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_FRIED_EGG, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_HOGLIN_STEW, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_FORESTS_BOUNTY, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PUDDING, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CARAMEL_APPLE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SWEET_BERRY_PIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_SWEET_BERRY_JUICE, categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableBlueberries = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BLUEBERRIES,
                categoryName);
        category.addEntry(enableBlueberries);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BLUEBERRY_PIE, categoryName,
                enableBlueberries);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BLUEBERRY_JUICE, categoryName,
                enableBlueberries);
        category.addEntry(configEntry);

        BooleanListEntry enableCindersnapBerries = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_CINDERSNAP_BERRIES, categoryName);
        category.addEntry(enableCindersnapBerries);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CINDERSNAP_BERRY_JUICE, categoryName,
                enableCindersnapBerries);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CRIMSON_FORAGE_MIX, categoryName,
                enableCindersnapBerries);
        category.addEntry(configEntry);

        BooleanListEntry enableFrostbiteBerries = makeBoolConfigEntry(config, entryBuilder,
                ModConfigKeys.ENABLE_FROSTBITE_BERRIES, categoryName);
        category.addEntry(enableFrostbiteBerries);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_FROSTBITE_BERRY_JUICE, categoryName,
                enableFrostbiteBerries);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WARPED_FORAGE_MIX, categoryName,
                enableFrostbiteBerries);
        category.addEntry(configEntry);
    }

    private static void addPlantsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "plants";
        ConfigCategory category = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BLOOD_KELP, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_PURPLE_MUSHROOMS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_CATTAILS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_BOG_BLOSSOMS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_ENDER_PLANTS, categoryName);
        category.addEntry(configEntry); // TODO: Add a tooltip that says: "Toggles snapdragons and ender grass"
        configEntry = makeBoolConfigEntry(config, entryBuilder, ModConfigKeys.ENABLE_WITCHS_CRADLES, categoryName);
        category.addEntry(configEntry);
    }

    private static ConfigCategory makeCategory(ConfigBuilder builder, String categoryName) {
        Component categoryText = makeCategoryText(categoryName);
        return builder.getOrCreateCategory(categoryText);
    }

    private static BooleanListEntry makeBoolConfigEntry(Config config, ConfigEntryBuilder entryBuilder, String key,
                                                        String categoryName) {
        BooleanConfigEntry entry = (BooleanConfigEntry) config.getEntry(key);
        final String entryName = entry.getKey();
        final boolean entryValue = entry.getValue();
        Component displayText = makeEntryText(categoryName, entryName);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entry.getKey(), newValue);
                    }
                }).setDefaultValue(true).requireRestart().build();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static BooleanListEntry makeBoolConfigEntry(Config config, ConfigEntryBuilder entryBuilder, String key,
                                                        String categoryName, BooleanListEntry... dependencies) {
        BooleanConfigEntry entry = (BooleanConfigEntry) config.getEntry(key);
        final String entryName = entry.getKey();
        final boolean entryValue = entry.getValue();
        Component requirementText = makeEntryRequirementText(categoryName, entryName);
        Supplier<Optional<Component[]>> requirementTooltip = getRequirementToolTip(requirementText, dependencies);
        Component displayText = makeEntryText(categoryName, entryName);
        Requirement[] requirements = getTrueRequirements(dependencies);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entry.getKey(), newValue);
                    }
                }).setDefaultValue(true).requireRestart().setRequirement(Requirement.all(requirements))
                .setTooltipSupplier(requirementTooltip).build();
    }

    /**
     * @param dependencies The dependencies to check.
     * @param requirementText The tooltip text to display when the requirement is met.
     * @return If the requirement is met the tooltip to show otherwise nothing.
     */
    @SuppressWarnings("UnstableApiUsage")
    private static Supplier<Optional<Component[]>> getRequirementToolTip(Component requirementText, BooleanListEntry... dependencies) {
        return () -> {
            Requirement[] requirements = getFalseRequirements(dependencies);
            Component[] requirementTextArray = new Component[]{requirementText};

            if(Requirement.any(requirements).check()) {
                return Optional.of(requirementTextArray);
            }
            return Optional.empty();
        };
    }

    @SuppressWarnings("UnstableApiUsage")
    private static Requirement[] getTrueRequirements(BooleanListEntry... dependencies) {
        ArrayList<Requirement> requirementsList = new ArrayList<>();

        for (BooleanListEntry dependency : dependencies) {
            requirementsList.add(Requirement.isTrue(dependency));
        }
        return requirementsList.toArray(Requirement[]::new);
    }

    @SuppressWarnings("UnstableApiUsage")
    private static Requirement[] getFalseRequirements(BooleanListEntry... dependencies) {
        ArrayList<Requirement> requirementsList = new ArrayList<>();

        for (BooleanListEntry dependency : dependencies) {
            requirementsList.add(Requirement.isFalse(dependency));
        }
        return requirementsList.toArray(Requirement[]::new);
    }

    private static Component makeEntryText(String categoryName, String entryName) {
        return Component.translatable("text.cloth-config." + AssortedDiscoveries.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Component makeEntryRequirementText(String categoryName, String entryName) {
        return Component.translatable("requirement.cloth-config." + AssortedDiscoveries.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Component makeCategoryText(String categoryName) {
        return Component.translatable("category.cloth-config." + AssortedDiscoveries.MOD_ID
                + ".option." + categoryName);
    }
}
