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
        Config config = ModConfig.getLocalConfig(); // Reload the config every time we open the screen.
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

        configEntry = makeBoolEntry(category, entryBuilder, ModConfig.ENABLE_PLANTER_BOXES.getKey(), categoryName);
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
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_nether_bricks", categoryName, true);
        screenCategory.addEntry(configEntry);

        // Blackstone Entries
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE, categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_blackstone", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS,
                categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_polished_blackstone_bricks",
                categoryName, true);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlackstoneTiles = makeBoolEntry(category, entryBuilder,
                ModConfigKeys.ENABLE_BLACKSTONE_TILES, categoryName, true);
        screenCategory.addEntry(enableBlackstoneTiles);
        configEntry = makeBoolEntry(true, category, entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_weeping_blackstone_tiles",
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
                "enable_smoky_quartz_blocks", categoryName, true);
        screenCategory.addEntry(enableSmokyQuartzBlocks);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_smoky_quartz_bricks",
                categoryName, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_smooth_smoky_quartz",
                categoryName, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_quartz_brick_blocks",
                categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_quartz_tiles", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_quartz_walls",
                categoryName, true);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableBauxite = makeBoolEntry(category, entryBuilder, "enable_bauxite",
                categoryName, true);
        BooleanListEntry enableBauxiteBricks = makeBoolEntry(true, category, entryBuilder,
                "enable_bauxite_bricks", categoryName, enableBauxite);

        screenCategory.addEntry(enableBauxite);
        screenCategory.addEntry(enableBauxiteBricks);
        configEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_cracked_bauxite_bricks", categoryName, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_mossy_bauxite_bricks", categoryName, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableStoneTiles = makeBoolEntry(true, category, entryBuilder,
                "enable_stone_tiles", categoryName);

        screenCategory.addEntry(enableStoneTiles);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_cracked_stone_tiles",
                categoryName, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_mossy_stone_tiles",
                categoryName, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cracked_stone_brick_blocks",
                categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_stone_walls", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_calcite_blocks", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_polished_calcite", categoryName);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCalciteBricksEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_calcite_bricks", categoryName);
        screenCategory.addEntry(enableCalciteBricksEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_cracked_calcite_bricks", categoryName,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_mossy_calcite_bricks", categoryName,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_dripstone_blocks", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_polished_dripstone", categoryName);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableDripstoneBricksEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_dripstone_bricks", categoryName);
        screenCategory.addEntry(enableDripstoneBricksEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_cracked_dripstone_bricks",
                categoryName, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_mossy_dripstone_bricks",
                categoryName, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_snow_bricks", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_packed_snow", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_dirt_slabs", categoryName, true);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlushiesCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "plushies";
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_allay_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_bat_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_camel_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_wolf_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cat_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_chicken_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cow_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_horse_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_mooshroom_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_pig_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_pufferfish_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_rabbit_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sheep_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_squid_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_strider_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_villager_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sniffer_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_bee_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cave_spider_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_enderman_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_piglin_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_spider_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_blaze_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_creeper_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_ghast_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_guardian_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_hoglin_plushies", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_illager_plushies", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_magma_cube_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_phantom_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_shulker_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_skeleton_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_slime_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_vex_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_witch_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_wither_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_zombie_plushie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_creaking_plushie", categoryName);
        screenCategory.addEntry(configEntry);
    }

    private static void addFoodsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "foods";
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_green_onions", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_noodle_soup", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_chocolate_cake", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_red_velvet_cake", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_fried_egg", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_hoglin_stew", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_forests_bounty", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_pudding", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_caramel_apple", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sweet_berry_pie", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sweet_berry_juice", categoryName);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlueberries = makeBoolEntry(category, entryBuilder, "enable_blueberries",
                categoryName, true);
        screenCategory.addEntry(enableBlueberries);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_blueberry_pie", categoryName,
                enableBlueberries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_blueberry_juice", categoryName,
                enableBlueberries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCindersnapBerries = makeBoolEntry(category, entryBuilder,
                "enable_cindersnap_berries", categoryName);
        screenCategory.addEntry(enableCindersnapBerries);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cindersnap_berry_juice", categoryName,
                enableCindersnapBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_crimson_forage_mix", categoryName,
                enableCindersnapBerries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableFrostbiteBerries = makeBoolEntry(category, entryBuilder,
                "enable_frostbite_berries", categoryName);
        screenCategory.addEntry(enableFrostbiteBerries);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_frostbite_berry_juice", categoryName,
                enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_warped_forage_mix", categoryName,
                enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlantsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "plants";
        JsonConfigCategory category = config.getCategory(categoryName);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryName);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_blood_kelp", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_purple_mushrooms", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cattails", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_bog_blossoms", categoryName);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_ender_plants", categoryName, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_witchs_cradles", categoryName);
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
