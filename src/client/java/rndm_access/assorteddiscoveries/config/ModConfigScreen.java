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
        Config config = loadLocalConfig();
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

    /**
     * @return A copy of the configuration object loaded from the local file.
     * This way the config can be safely edited without affecting the current loaded config.
     */
    private static Config loadLocalConfig() {
        Config localConfig = ModConfig.DEFAULT_CONFIG.copy();
        localConfig.loadFromFile(ModConfig.DEFAULT_CONFIG);
        return localConfig;
    }

    private static void addBuildingBlocksCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = "building_blocks";
        JsonConfigCategory category = config.getCategory(categoryKey);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_planter_boxes", categoryKey);
        screenCategory.addEntry(configEntry);

        // Dyed Blocks
        configEntry = makeBoolEntry(category, entryBuilder, "enable_dyed_campfires", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_dyed_lanterns", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_dyed_torches", categoryKey);
        screenCategory.addEntry(configEntry);

        // Netherrack and Nether Bricks
        configEntry = makeBoolEntry(category, entryBuilder, "enable_twisted_netherrack", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_netherrack", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_twisted_nether_bricks", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_nether_bricks", categoryKey, true);
        screenCategory.addEntry(configEntry);

        // Blackstone Entries
        configEntry = makeBoolEntry(category, entryBuilder, "enable_twisted_blackstone", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_blackstone", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_twisted_polished_blackstone_bricks",
                categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_weeping_polished_blackstone_bricks",
                categoryKey, true);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlackstoneTiles = makeBoolEntry(category, entryBuilder,
                "enable_blackstone_tiles", categoryKey, true);
        screenCategory.addEntry(enableBlackstoneTiles);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_twisted_blackstone_tiles",
                categoryKey, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_weeping_blackstone_tiles",
                categoryKey, enableBlackstoneTiles);
        screenCategory.addEntry(configEntry);

        configEntry = makeBoolEntry(category, entryBuilder, "enable_wooden_walls", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_stripped_wooden_walls", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_rope_ladders", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_iron_ladders", categoryKey);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableSmokyQuartzBlocks = makeBoolEntry(category, entryBuilder,
                "enable_smoky_quartz_blocks", categoryKey, true);
        screenCategory.addEntry(enableSmokyQuartzBlocks);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_smoky_quartz_bricks",
                categoryKey, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_smooth_smoky_quartz",
                categoryKey, enableSmokyQuartzBlocks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_quartz_brick_blocks",
                categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_quartz_tiles", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_quartz_walls",
                categoryKey, true);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableBauxite = makeBoolEntry(category, entryBuilder, "enable_bauxite",
                categoryKey, true);
        BooleanListEntry enableBauxiteBricks = makeBoolEntry(true, category, entryBuilder,
                "enable_bauxite_bricks", categoryKey, enableBauxite);

        screenCategory.addEntry(enableBauxite);
        screenCategory.addEntry(enableBauxiteBricks);
        configEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_cracked_bauxite_bricks", categoryKey, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_mossy_bauxite_bricks", categoryKey, enableBauxite, enableBauxiteBricks);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableStoneTiles = makeBoolEntry(true, category, entryBuilder,
                "enable_stone_tiles", categoryKey);

        screenCategory.addEntry(enableStoneTiles);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_cracked_stone_tiles",
                categoryKey, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_mossy_stone_tiles",
                categoryKey, enableStoneTiles);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cracked_stone_brick_blocks",
                categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_stone_walls", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_calcite_blocks", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_polished_calcite", categoryKey);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCalciteBricksEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_calcite_bricks", categoryKey);
        screenCategory.addEntry(enableCalciteBricksEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_cracked_calcite_bricks", categoryKey,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_mossy_calcite_bricks", categoryKey,
                enableCalciteBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_dripstone_blocks", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_polished_dripstone", categoryKey);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableDripstoneBricksEntry = makeBoolEntry(true, category, entryBuilder,
                "enable_dripstone_bricks", categoryKey);
        screenCategory.addEntry(enableDripstoneBricksEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_cracked_dripstone_bricks",
                categoryKey, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(true, category, entryBuilder, "enable_mossy_dripstone_bricks",
                categoryKey, enableDripstoneBricksEntry);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_snow_bricks", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_packed_snow", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_dirt_slabs", categoryKey, true);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlushiesCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = "plushies";
        JsonConfigCategory category = config.getCategory(categoryKey);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_allay_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_bat_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_camel_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_wolf_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cat_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_chicken_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cow_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_horse_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_mooshroom_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_pig_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_pufferfish_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_rabbit_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sheep_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_squid_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_strider_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_villager_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sniffer_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_bee_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cave_spider_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_enderman_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_piglin_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_spider_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_blaze_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_creeper_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_ghast_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_guardian_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_hoglin_plushies", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_illager_plushies", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_magma_cube_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_phantom_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_shulker_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_skeleton_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_slime_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_vex_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_witch_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_wither_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_zombie_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_creaking_plushie", categoryKey);
        screenCategory.addEntry(configEntry);
    }

    private static void addFoodsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = "foods";
        JsonConfigCategory category = config.getCategory(categoryKey);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_green_onions", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_noodle_soup", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_chocolate_cake", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_red_velvet_cake", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_fried_egg", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_hoglin_stew", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_forests_bounty", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_pudding", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_caramel_apple", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sweet_berry_pie", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_sweet_berry_juice", categoryKey);
        screenCategory.addEntry(configEntry);
        BooleanListEntry enableBlueberries = makeBoolEntry(category, entryBuilder, "enable_blueberries",
                categoryKey, true);
        screenCategory.addEntry(enableBlueberries);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_blueberry_pie", categoryKey,
                enableBlueberries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_blueberry_juice", categoryKey,
                enableBlueberries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableCindersnapBerries = makeBoolEntry(category, entryBuilder,
                "enable_cindersnap_berries", categoryKey);
        screenCategory.addEntry(enableCindersnapBerries);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cindersnap_berry_juice", categoryKey,
                enableCindersnapBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_crimson_forage_mix", categoryKey,
                enableCindersnapBerries);
        screenCategory.addEntry(configEntry);

        BooleanListEntry enableFrostbiteBerries = makeBoolEntry(category, entryBuilder,
                "enable_frostbite_berries", categoryKey);
        screenCategory.addEntry(enableFrostbiteBerries);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_frostbite_berry_juice", categoryKey,
                enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_warped_forage_mix", categoryKey,
                enableFrostbiteBerries);
        screenCategory.addEntry(configEntry);
    }

    private static void addPlantsCategory(Config config, ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryKey = "plants";
        JsonConfigCategory category = config.getCategory(categoryKey);
        ConfigCategory screenCategory = makeCategory(configBuilder, categoryKey);
        BooleanListEntry configEntry;

        configEntry = makeBoolEntry(category, entryBuilder, "enable_blood_kelp", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_purple_mushrooms", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_cattails", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_bog_blossoms", categoryKey);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_ender_plants", categoryKey, true);
        screenCategory.addEntry(configEntry);
        configEntry = makeBoolEntry(category, entryBuilder, "enable_witchs_cradles", categoryKey);
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
