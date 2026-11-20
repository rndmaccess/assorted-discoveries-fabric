package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.impl.builders.BooleanToggleBuilder;
import net.minecraft.network.chat.Component;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanJsonConfigEntry;

import java.util.*;
import java.util.function.Supplier;

public class ModConfigScreen {
    public static final HashMap<String, Object> ENTRY_VALUE_CHANGES = new HashMap<>();

    public static ConfigBuilder getConfigScreenBuilder() {
        Component title = Component.translatable("title." + AssortedDiscoveries.MOD_ID + ".config");
        ConfigBuilder configBuilder = ConfigBuilder.create().setTitle(title);
        configBuilder.setDefaultBackgroundTexture(AssortedDiscoveries.makeModId("textures/block/calcite_bricks.png"));
        configBuilder.setGlobalized(true);
        configBuilder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();

        addBuildingBlocksCategory(configBuilder, entryBuilder);
        addPlushiesCategory(configBuilder, entryBuilder);
        addFoodsCategory(configBuilder, entryBuilder);
        addPlantsCategory(configBuilder, entryBuilder);

        configBuilder.setSavingRunnable(() -> {
            ModConfig.CONFIG_MANAGER.save(ENTRY_VALUE_CHANGES);
            ModConfig.CONFIG_MANAGER.updateLocalValues(ENTRY_VALUE_CHANGES);
            ENTRY_VALUE_CHANGES.clear();
        });
        return configBuilder;
    }

    private static void addBuildingBlocksCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = ModConfigCategory.BUILDING_BLOCKS.getCategoryName();
        ConfigCategory screenCategory = makeCategory(configBuilder, ModConfigCategory.BUILDING_BLOCKS.getCategoryName());
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PLANTER_BOXES, categoryKey);
        screenCategory.addEntry(configEntry);

        // Dyed Blocks
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_DYED_CAMPFIRES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_DYED_LANTERNS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_DYED_TORCHES, categoryKey);
        screenCategory.addEntry(configEntry);

        // Netherrack and Nether Bricks
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_TWISTED_NETHERRACK, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WEEPING_NETHERRACK, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_TWISTED_NETHER_BRICKS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WEEPING_NETHER_BRICKS, categoryKey);
        screenCategory.addEntry(configEntry);

        // Blackstone Entries
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_TWISTED_BLACKSTONE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WEEPING_BLACKSTONE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder,
                ModConfig.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder,
                ModConfig.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS, categoryKey);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlackstoneTiles = makeBoolEntry(entryBuilder,
                ModConfig.ENABLE_BLACKSTONE_TILES, categoryKey);
        screenCategory.addEntry(enableBlackstoneTiles);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_TWISTED_BLACKSTONE_TILES,
                categoryKey, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WEEPING_BLACKSTONE_TILES,
                categoryKey, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);

        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WOODEN_WALLS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_STRIPPED_WOODEN_WALLS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_ROPE_LADDERS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_IRON_LADDERS, categoryKey);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableSmokyQuartzBlocks = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_SMOKY_QUARTZ_BLOCKS, categoryKey);
        screenCategory.addEntry(enableSmokyQuartzBlocks);
        BooleanListEntry enableSmokyQuartzBricks = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_SMOKY_QUARTZ_BRICKS, categoryKey, enableSmokyQuartzBlocks);
        screenCategory.addEntry(enableSmokyQuartzBricks);
        configEntry = makeBoolEntry(entryBuilder,
                ModConfig.ENABLE_SMOOTH_SMOKY_QUARTZ, categoryKey, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SMOKY_QUARTZ_TILES, categoryKey,
                enableSmokyQuartzBlocks, enableSmokyQuartzBricks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_QUARTZ_BRICK_BLOCKS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_QUARTZ_TILES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_QUARTZ_WALLS, categoryKey);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableBauxite = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_BAUXITE, categoryKey);
        BooleanListEntry enableBauxiteBricks = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_BAUXITE_BRICKS, categoryKey, enableBauxite);

        screenCategory.addEntry(enableBauxite);
        screenCategory.addEntry(enableBauxiteBricks);
        configEntry = makeBoolEntry(entryBuilder,
                ModConfig.ENABLE_CRACKED_BAUXITE_BRICKS, categoryKey, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder,
                ModConfig.ENABLE_MOSSY_BAUXITE_BRICKS, categoryKey, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableStoneTiles = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_STONE_TILES, categoryKey);

        screenCategory.addEntry(enableStoneTiles);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CRACKED_STONE_TILES,
                categoryKey, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_MOSSY_STONE_TILES,
                categoryKey, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_CRACKED_STONE_BRICK_BLOCKS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_STONE_WALLS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_CALCITE_BLOCKS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_POLISHED_CALCITE, categoryKey);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCalciteBricksEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_CALCITE_BRICKS, categoryKey);
        screenCategory.addEntry(enableCalciteBricksEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CRACKED_CALCITE_BRICKS, categoryKey,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_MOSSY_CALCITE_BRICKS, categoryKey,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_DRIPSTONE_BLOCKS, categoryKey);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enablePolishedDripstoneEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_POLISHED_DRIPSTONE, categoryKey);
        screenCategory.addEntry(enablePolishedDripstoneEntry);

        BooleanListEntry enableDripstoneBricksEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_DRIPSTONE_BRICKS, categoryKey, enablePolishedDripstoneEntry);
        screenCategory.addEntry(enableDripstoneBricksEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CRACKED_DRIPSTONE_BRICKS,
                categoryKey, enablePolishedDripstoneEntry, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_MOSSY_DRIPSTONE_BRICKS,
                categoryKey, enablePolishedDripstoneEntry, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableDripstoneTilesEntry = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_DRIPSTONE_TILES, categoryKey, enablePolishedDripstoneEntry, enableDripstoneBricksEntry);
        screenCategory.addEntry(enableDripstoneTilesEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CRACKED_DRIPSTONE_TILES,
                categoryKey, enablePolishedDripstoneEntry, enableDripstoneTilesEntry, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_MOSSY_DRIPSTONE_TILES,
                categoryKey, enablePolishedDripstoneEntry, enableDripstoneTilesEntry, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);

        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SNOW_BRICKS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PACKED_SNOW, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_DIRT_SLABS, categoryKey);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlushiesCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = ModConfigCategory.PLUSHIES.getCategoryName();
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_ALLAY_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BAT_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CAMEL_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WOLF_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CAT_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CHICKEN_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_COW_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_HORSE_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_MOOSHROOM_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PIG_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PUFFERFISH_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_RABBIT_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SHEEP_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SQUID_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_STRIDER_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_VILLAGER_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SNIFFER_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BEE_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CAVE_SPIDER_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_ENDERMAN_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PIGLIN_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SPIDER_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BLAZE_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CREEPER_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_GHAST_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_GUARDIAN_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_HOGLIN_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_ILLAGER_PLUSHIES, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_MAGMA_CUBE_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PHANTOM_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SHULKER_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SKELETON_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SLIME_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_VEX_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WITCH_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WITHER_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_ZOMBIE_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CREAKING_PLUSHIE, categoryKey);
        screenCategory.addEntry(configEntry);
    }

    private static void addFoodsCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = ModConfigCategory.FOODS.getCategoryName();
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_GREEN_ONIONS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_NOODLE_SOUP, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CHOCOLATE_CAKE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_RED_VELVET_CAKE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_FRIED_EGG, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_HOGLIN_STEW, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_FORESTS_BOUNTY, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_PUDDING, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_CARAMEL_APPLE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SWEET_BERRY_PIE, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_SWEET_BERRY_JUICE, categoryKey);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlueberries = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_BLUEBERRIES, categoryKey);
        screenCategory.addEntry(enableBlueberries);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BLUEBERRY_PIE, categoryKey, enableBlueberries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BLUEBERRY_JUICE, categoryKey, enableBlueberries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCindersnapBerries = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_CINDERSNAP_BERRIES, categoryKey);
        screenCategory.addEntry(enableCindersnapBerries);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CINDERSNAP_BERRY_JUICE,
                categoryKey, enableCindersnapBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CRIMSON_FORAGE_MIX,
                categoryKey, enableCindersnapBerries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableFrostbiteBerries = makeBoolEntry(true, entryBuilder,
                ModConfig.ENABLE_FROSTBITE_BERRIES, categoryKey);
        screenCategory.addEntry(enableFrostbiteBerries);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_FROSTBITE_BERRY_JUICE,
                categoryKey, enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WARPED_FORAGE_MIX,
                categoryKey, enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlantsCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = ModConfigCategory.PLANTS.getCategoryName();
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BLOOD_KELP, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_PURPLE_MUSHROOMS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_CATTAILS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_BOG_BLOSSOMS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, entryBuilder, ModConfig.ENABLE_ENDER_PLANTS, categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(entryBuilder, ModConfig.ENABLE_WITCHS_CRADLES, categoryKey);
        screenCategory.addEntry(configEntry);
    }

    private static ConfigCategory makeCategory(ConfigBuilder builder, String categoryName) {
        Component categoryText = makeCategoryText(categoryName);
        return builder.getOrCreateCategory(categoryText);
    }

    private static BooleanListEntry makeBoolEntry(ConfigEntryBuilder entryBuilder, BooleanJsonConfigEntry entry,
                                                  String categoryName) {
        return makeBoolEntry(false, entryBuilder, entry, categoryName);
    }

    private static BooleanListEntry makeBoolEntry(boolean hasTooltip, ConfigEntryBuilder entryBuilder,
                                                  BooleanJsonConfigEntry entry, String categoryName) {
        final String entryName = entry.getKey();
        final boolean entryValue = entry.getLocalValue();
        Component displayText = makeEntryText(categoryName, entryName);

        BooleanToggleBuilder toggle = entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entryName, newValue);
                    }
                }).setDefaultValue(entry.getDefaultValue()).requireRestart();

        if (hasTooltip) {
            Component tooltipText = makeTooltipText(categoryName, entryName);
            return toggle.setTooltip(tooltipText).build();
        }
        return toggle.build();
    }

    private static BooleanListEntry makeBoolEntry(ConfigEntryBuilder entryBuilder, BooleanJsonConfigEntry entry,
                                                  String categoryName, BooleanListEntry... dependencies) {
        return makeBoolEntry(false, entryBuilder, entry, categoryName, dependencies);
    }

    @SuppressWarnings("UnstableApiUsage")
    private static BooleanListEntry makeBoolEntry(boolean hasTooltip, ConfigEntryBuilder entryBuilder,
                                                  BooleanJsonConfigEntry entry, String categoryName,
                                                  BooleanListEntry... dependencies) {
        final String entryName = entry.getKey();
        final boolean entryValue = entry.getLocalValue();
        Component requirementText = makeEntryRequirementText(categoryName, entryName);
        Supplier<Optional<Component[]>> requirementTooltip = getRequirementToolTip(hasTooltip, categoryName, entryName,
                requirementText, dependencies);
        Component displayText = makeEntryText(categoryName, entryName);
        Requirement[] requirements = getTrueRequirements(dependencies);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entryName, newValue);
                    }
                }).setDefaultValue(entry.getDefaultValue()).requireRestart()
                .setRequirement(Requirement.all(requirements)).setTooltipSupplier(requirementTooltip).build();
    }

    /**
     * @param dependencies The dependencies to check.
     * @param requirementText The tooltip text to display when the requirement is met.
     * @return If the requirement is met the tooltip to show otherwise nothing.
     */
    @SuppressWarnings("UnstableApiUsage")
    private static Supplier<Optional<Component[]>> getRequirementToolTip(boolean hasTooltip, String categoryName,
                                                                         String entryName, Component requirementText,
                                                                         BooleanListEntry... dependencies) {
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
        return Component.translatable("config.entry." + AssortedDiscoveries.MOD_ID
                + "." + categoryName + "." + entryName);
    }

    private static Component makeEntryRequirementText(String categoryName, String entryName) {
        return Component.translatable("config.requirement." + AssortedDiscoveries.MOD_ID
                + "." + categoryName + "." + entryName);
    }

    private static Component makeCategoryText(String categoryName) {
        return Component.translatable("config.category." + AssortedDiscoveries.MOD_ID + "." + categoryName);
    }

    private static Component makeTooltipText(String categoryName, String entryName) {
        return Component.translatable("config.tooltip." + AssortedDiscoveries.MOD_ID + "."
                + categoryName + "." + entryName);
    }
}
