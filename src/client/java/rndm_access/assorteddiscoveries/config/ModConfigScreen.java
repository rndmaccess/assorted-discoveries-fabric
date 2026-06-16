package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.impl.builders.BooleanToggleBuilder;
import net.minecraft.network.chat.Component;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.Config;
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;

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
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PLANTER_BOXES, categoryName);
        screenCategory.addEntry(configEntry);

        // Dyed Blocks
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_DYED_CAMPFIRES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_DYED_LANTERNS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_DYED_TORCHES, categoryName);
        screenCategory.addEntry(configEntry);

        // Netherrack and Nether Bricks
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_NETHERRACK, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WEEPING_NETHERRACK, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS, categoryName, true);
        screenCategory.addEntry(configEntry);

        // Blackstone Entries
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS,
                categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS,
                categoryName, true);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlackstoneTiles = makeBoolEntry(category, entryBuilder,
                ModConfigKeys.ENABLE_BLACKSTONE_TILES, categoryName, true);
        screenCategory.addEntry(enableBlackstoneTiles);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);

        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WOODEN_WALLS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_ROPE_LADDERS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_IRON_LADDERS, categoryName);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableSmokyQuartzBlocks = makeBoolEntry(category, entryBuilder,
                ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS, categoryName, true);
        screenCategory.addEntry(enableSmokyQuartzBlocks);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS,
                categoryName, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ,
                categoryName, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS,
                categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_QUARTZ_TILES, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_QUARTZ_WALLS,
                categoryName, true);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableBauxite = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BAUXITE,
                categoryName, true);
        BooleanListEntry enableBauxiteBricks = makeBoolEntry(true, category, entryBuilder,
                ModConfigKeys.ENABLE_BAUXITE_BRICKS, categoryName, enableBauxite);

        screenCategory.addEntry(enableBauxite);
        screenCategory.addEntry(enableBauxiteBricks);
        configEntry = makeBoolEntry(true, category, entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS, categoryName, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS, categoryName, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableStoneTiles = makeBoolEntry(true, category, entryBuilder,
                ModConfigKeys.ENABLE_STONE_TILES, categoryName);

        screenCategory.addEntry(enableStoneTiles);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_CRACKED_STONE_TILES,
                categoryName, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_MOSSY_STONE_TILES,
                categoryName, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS,
                categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_STONE_WALLS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_CALCITE_BLOCKS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_POLISHED_CALCITE, categoryName);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCalciteBricksEntry = makeBoolEntry(true, category, entryBuilder,
                ModConfigKeys.ENABLE_CALCITE_BRICKS, categoryName);
        screenCategory.addEntry(enableCalciteBricksEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS, categoryName,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS, categoryName,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_POLISHED_DRIPSTONE, categoryName);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableDripstoneBricksEntry = makeBoolEntry(true, category, entryBuilder,
                ModConfigKeys.ENABLE_DRIPSTONE_BRICKS, categoryName);
        screenCategory.addEntry(enableDripstoneBricksEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS,
                categoryName, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS,
                categoryName, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SNOW_BRICKS, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PACKED_SNOW, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_DIRT_SLABS, categoryName, true);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlushiesCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "plushies";
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_ALLAY_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BAT_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CAMEL_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WOLF_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CAT_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CHICKEN_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_COW_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_HORSE_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PIG_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_RABBIT_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SHEEP_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SQUID_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_STRIDER_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_VILLAGER_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SNIFFER_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BEE_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PIGLIN_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SPIDER_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BLAZE_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CREEPER_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_GHAST_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_HOGLIN_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_ILLAGER_PLUSHIES, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PHANTOM_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SHULKER_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SKELETON_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SLIME_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_VEX_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WITCH_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WITHER_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CREAKING_PLUSHIE, categoryName);
        screenCategory.addEntry(configEntry);
    }

    private static void addFoodsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "foods";
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_GREEN_ONIONS, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_NOODLE_SOUP, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CHOCOLATE_CAKE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_RED_VELVET_CAKE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_FRIED_EGG, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_HOGLIN_STEW, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_FORESTS_BOUNTY, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PUDDING, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CARAMEL_APPLE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SWEET_BERRY_PIE, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_SWEET_BERRY_JUICE, categoryName);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlueberries = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BLUEBERRIES,
                categoryName, true);
        screenCategory.addEntry(enableBlueberries);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BLUEBERRY_PIE, categoryName,
                enableBlueberries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BLUEBERRY_JUICE, categoryName,
                enableBlueberries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCindersnapBerries = makeBoolEntry(category, entryBuilder,
                ModConfigKeys.ENABLE_CINDERSNAP_BERRIES, categoryName);
        screenCategory.addEntry(enableCindersnapBerries);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CINDERSNAP_BERRY_JUICE, categoryName,
                enableCindersnapBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CRIMSON_FORAGE_MIX, categoryName,
                enableCindersnapBerries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableFrostbiteBerries = makeBoolEntry(category, entryBuilder,
                ModConfigKeys.ENABLE_FROSTBITE_BERRIES, categoryName);
        screenCategory.addEntry(enableFrostbiteBerries);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_FROSTBITE_BERRY_JUICE, categoryName,
                enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WARPED_FORAGE_MIX, categoryName,
                enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlantsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "plants";
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BLOOD_KELP, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_PURPLE_MUSHROOMS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_CATTAILS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_BOG_BLOSSOMS, categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_ENDER_PLANTS, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_WITCHS_CRADLES, categoryName);
        screenCategory.addEntry(configEntry);
    }

    private static ConfigCategory makeCategory(ConfigBuilder builder, String categoryName) {
        Component categoryText = makeCategoryText(categoryName);
        return builder.getOrCreateCategory(categoryText);
    }

    private static BooleanListEntry makeBoolEntry(JsonConfigCategory category, ConfigEntryBuilder entryBuilder, String key,
                                                      String categoryName) {
        return makeBoolEntry(category, entryBuilder, key, categoryName, false);
    }

    private static BooleanListEntry makeBoolEntry(JsonConfigCategory category, ConfigEntryBuilder entryBuilder, String key,
                                                       String categoryName, boolean hasTooltip) {
        BooleanConfigEntry entry = (BooleanConfigEntry) category.getEntry(key);
        final String entryName = entry.getKey();
        final boolean entryValue = entry.getValue();
        Component displayText = makeEntryText(categoryName, entryName);
        BooleanToggleBuilder toggle = entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entry.getKey(), newValue);
                    }
                }).setDefaultValue(true).requireRestart();

        if (hasTooltip) {
            Component tooltipText = makeTooltipText(categoryName, entryName);
            return toggle.setTooltip(tooltipText).build();
        }
        return toggle.build();
    }

    private static BooleanListEntry makeBoolEntry(JsonConfigCategory category, ConfigEntryBuilder entryBuilder, String key,
                                                  String categoryName, BooleanListEntry... dependencies) {
        return makeBoolEntry(false, category, entryBuilder, key, categoryName, dependencies);
    }

    @SuppressWarnings("UnstableApiUsage")
    private static BooleanListEntry makeBoolEntry(boolean hasTooltip, JsonConfigCategory category, ConfigEntryBuilder entryBuilder, String key,
                                                  String categoryName, BooleanListEntry... dependencies) {
        BooleanConfigEntry entry = (BooleanConfigEntry) category.getEntry(key);
        final String entryName = entry.getKey();
        final boolean entryValue = entry.getValue();
        Component requirementText = makeEntryRequirementText(categoryName, entryName);
        Supplier<Optional<Component[]>> requirementTooltip = getRequirementToolTip(hasTooltip, categoryName, entryName, requirementText, dependencies);
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
    private static Supplier<Optional<Component[]>> getRequirementToolTip(boolean hasTooltip, String categoryName, String entryName,
                                                                         Component requirementText, BooleanListEntry... dependencies) {
        return () -> {
            Requirement[] requirements = getFalseRequirements(dependencies);
            Component[] requirementTextArray = new Component[]{requirementText};


            if(Requirement.any(requirements).check()) {
                return Optional.of(requirementTextArray);
            }
            if (hasTooltip) {
                Component[] tooltipText = new Component[]{makeTooltipText(categoryName, entryName)};
                return Optional.of(tooltipText);
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

    private static Component makeTooltipText(String categoryName, String entryName) {
        return Component.translatable("tooltip.cloth-config." + AssortedDiscoveries.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }
}
