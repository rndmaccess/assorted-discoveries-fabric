package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.SubCategoryListEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.json.ConfigData;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;

import java.util.*;
import java.util.function.Supplier;

public class ModConfigScreen {
    public static final HashMap<String, Object> ENTRY_VALUE_CHANGES;

    public static ConfigBuilder getConfigScreenBuilder() {
        Text title = Text.translatable("title." + ADReference.MOD_ID + ".config");
        ConfigBuilder builder = ConfigBuilder.create().setTitle(title);
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        String buildingBlocksCategoryName = "building_blocks";

        // Building config options
        ConfigCategory buildingScreenCategory = builder.getOrCreateCategory(makeCategoryText(buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeDyedSubCategory(buildingBlocksCategoryName, entryBuilder));
        buildingScreenCategory.addEntry(makePassivePlushieSubCategory(buildingBlocksCategoryName, entryBuilder));
        buildingScreenCategory.addEntry(makeNeutralPlushieSubCategory(buildingBlocksCategoryName, entryBuilder));
        buildingScreenCategory.addEntry(makeHostilePlushieSubCategory(buildingBlocksCategoryName, entryBuilder));

        // Netherrack and Nether Bricks
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_TWISTED_NETHERRACK, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WEEPING_NETHERRACK, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS, buildingBlocksCategoryName));

        // Blackstone Entries
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_TWISTED_BLACKSTONE, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WEEPING_BLACKSTONE, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS, buildingBlocksCategoryName));
        BooleanListEntry enableBlackstoneTiles = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BLACKSTONE_TILES, buildingBlocksCategoryName);
        buildingScreenCategory.addEntry(enableBlackstoneTiles);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES, buildingBlocksCategoryName, enableBlackstoneTiles));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES, buildingBlocksCategoryName, enableBlackstoneTiles));

        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WOODEN_WALLS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_IRON_LADDERS, buildingBlocksCategoryName));
        BooleanListEntry enableSmokyQuartzBlocks = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS, buildingBlocksCategoryName);
        buildingScreenCategory.addEntry(enableSmokyQuartzBlocks);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS, buildingBlocksCategoryName, enableSmokyQuartzBlocks));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ, buildingBlocksCategoryName, enableSmokyQuartzBlocks));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_QUARTZ_TILES, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_QUARTZ_WALLS, buildingBlocksCategoryName));

        BooleanListEntry enableBauxite = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BAUXITE, buildingBlocksCategoryName);
        BooleanListEntry enableBauxiteBricks = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BAUXITE_BRICKS, buildingBlocksCategoryName, enableBauxite);

        buildingScreenCategory.addEntry(enableBauxite);
        buildingScreenCategory.addEntry(enableBauxiteBricks);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS, buildingBlocksCategoryName, enableBauxite, enableBauxiteBricks));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS, buildingBlocksCategoryName, enableBauxite, enableBauxiteBricks));

        BooleanListEntry enableStoneTiles = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_STONE_TILES, buildingBlocksCategoryName);

        buildingScreenCategory.addEntry(enableStoneTiles);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_STONE_TILES, buildingBlocksCategoryName, enableStoneTiles));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_STONE_TILES, buildingBlocksCategoryName, enableStoneTiles));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WOODCUTTER, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_STONE_WALLS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CALCITE_BLOCKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_POLISHED_CALCITE, buildingBlocksCategoryName));

        BooleanListEntry enableCalciteBricksEntry = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CALCITE_BRICKS, buildingBlocksCategoryName);

        buildingScreenCategory.addEntry(enableCalciteBricksEntry);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS, buildingBlocksCategoryName, enableCalciteBricksEntry));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS, buildingBlocksCategoryName, enableCalciteBricksEntry));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS, buildingBlocksCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS, buildingBlocksCategoryName));

        // Structures config options
        String structuresCategoryName = "structures";
        ConfigCategory structuresCategory = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option." + structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_FOREST_CABINS, structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_DARK_FOREST_CABINS, structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BIRCH_FOREST_CABINS, structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_TAIGA_CABINS, structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SNOWY_TAIGA_CABINS, structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRIMSON_FOREST_CABINS, structuresCategoryName));
        structuresCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WARPED_FOREST_CABINS, structuresCategoryName));

        // Farming config options
        String farmingCategoryName = "farming";
        ConfigCategory farmingScreenCategory = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option." + farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_GREEN_ONIONS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_NOODLE_SOUP, farmingCategoryName));
        BooleanListEntry enableBlueberries = makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BLUEBERRIES, farmingCategoryName);
        farmingScreenCategory.addEntry(enableBlueberries);
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BLUEBERRY_PIE, farmingCategoryName, enableBlueberries));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BLUEBERRY_JUICE, farmingCategoryName, enableBlueberries));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SWEET_BERRY_PIE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SWEET_BERRY_JUICE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CHOCOLATE_CAKE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_RED_VELVET_CAKE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_FRIED_EGG, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_HOGLIN_STEW, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_FORESTS_BOUNTY, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_PUDDING, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CARAMEL_APPLE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_NETHER_BERRIES, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_PURPLE_MUSHROOMS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CATTAILS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BOG_BLOSSOMS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BLOOD_KELP, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_ENDER_PLANTS, farmingCategoryName));

        builder.setSavingRunnable(() -> {
            ConfigData data = ConfigData.getInstance();
            JsonConfig config = ModConfig.getInternalConfig();

            config.load(data);
            config.save(data, ENTRY_VALUE_CHANGES);
            config.load(data); // Load the new changes into memory here!
        });
        return builder;
    }

    @SuppressWarnings("rawtypes")
    private static SubCategoryListEntry makeDyedSubCategory(String categoryName, ConfigEntryBuilder entryBuilder) {
        final List<AbstractConfigListEntry> entryList = new ArrayList<>();
        final String subCategoryName = "dyed";
        final Text subCategoryText = makeSubcategoryText(categoryName, subCategoryName);
        BooleanListEntry configEntry;

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DYED_CAMPFIRES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DYED_LANTERNS,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DYED_TORCHES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        return entryBuilder.startSubCategory(subCategoryText, entryList).build();
    }

    @SuppressWarnings("rawtypes")
    private static SubCategoryListEntry makePassivePlushieSubCategory(String categoryName,
                                                                      ConfigEntryBuilder entryBuilder) {
        final List<AbstractConfigListEntry> entryList = new ArrayList<>();
        final String subCategoryName = "passive_plushies";
        final Text subCategoryText = makeSubcategoryText(categoryName, subCategoryName);
        BooleanListEntry configEntry;

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ALLAY_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BAT_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CAMEL_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CAT_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CHICKEN_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_COW_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_HORSE_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_OCELOT_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PIG_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_RABBIT_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SHEEP_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SQUID_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_STRIDER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_VILLAGER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        return entryBuilder.startSubCategory(subCategoryText, entryList).build();
    }

    @SuppressWarnings("rawtypes")
    private static SubCategoryListEntry makeNeutralPlushieSubCategory(String categoryName,
                                                                      ConfigEntryBuilder entryBuilder) {
        final List<AbstractConfigListEntry> entryList = new ArrayList<>();
        final String subCategoryName = "neutral_plushies";
        final Text subCategoryText = makeSubcategoryText(categoryName, subCategoryName);
        BooleanListEntry configEntry;

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BEE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PIGLIN_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SPIDER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        return entryBuilder.startSubCategory(subCategoryText, entryList).build();
    }

    @SuppressWarnings("rawtypes")
    private static SubCategoryListEntry makeHostilePlushieSubCategory(String categoryName,
                                                                      ConfigEntryBuilder entryBuilder) {
        final List<AbstractConfigListEntry> entryList = new ArrayList<>();
        final String subCategoryName = "hostile_plushies";
        final Text subCategoryText = makeSubcategoryText(categoryName, subCategoryName);
        BooleanListEntry configEntry;

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BLAZE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CREEPER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_GHAST_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_HOGLIN_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ILLAGER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PHANTOM_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_RAVAGER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SHULKER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SKELETON_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SLIME_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_VEX_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WITCH_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WITHER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CREAKING_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        return entryBuilder.startSubCategory(subCategoryText, entryList).build();
    }

    private static BooleanListEntry makeToggleableConfigEntry(ConfigEntryBuilder entryBuilder, String key,
                                                              String categoryName, String subCategoryName) {
        BooleanConfigEntry entry = (BooleanConfigEntry) ModConfigScreen.getConfig().getEntry(key);
        final String entryName = entry.getName();
        final boolean entryValue = entry.getValue();
        Text displayText = makeEntryText(categoryName, subCategoryName, entryName);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entry.getName(), newValue);
                    }
                }).setDefaultValue(true).requireRestart().build();
    }

    private static BooleanListEntry makeToggleableConfigEntry(ConfigEntryBuilder entryBuilder, String key,
                                                              String categoryName) {
        BooleanConfigEntry entry = (BooleanConfigEntry) ModConfigScreen.getConfig().getEntry(key);
        final String entryName = entry.getName();
        final boolean entryValue = entry.getValue();
        Text displayText = makeEntryText(categoryName, entryName);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entry.getName(), newValue);
                    }
                }).setDefaultValue(true).requireRestart().build();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static BooleanListEntry makeToggleableConfigEntry(ConfigEntryBuilder entryBuilder, String key,
                                                              String categoryName, BooleanListEntry... dependencies) {
        BooleanConfigEntry entry = (BooleanConfigEntry) ModConfigScreen.getConfig().getEntry(key);
        final String entryName = entry.getName();
        final boolean entryValue = entry.getValue();
        Text requirementText = makeEntryRequirementText(categoryName, entryName);
        Supplier<Optional<Text[]>> requirementTooltip = getRequirementToolTip(requirementText, dependencies);
        Text displayText = makeEntryText(categoryName, entryName);
        Requirement[] requirements = getTrueRequirements(dependencies);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entry.getName(), newValue);
                    }
                }).setDefaultValue(true).requireRestart().setRequirement(Requirement.all(requirements))
                .setTooltipSupplier(requirementTooltip).build();
    }

    private static JsonConfig getConfig() {
        ConfigData data = ConfigData.getInstance();
        JsonConfig config = ModConfig.getInternalConfig();
        config.load(data);
        return config;
    }

    /**
     * @param dependencies The dependencies to check.
     * @param requirementText The tooltip text to display when the requirement is met.
     * @return If the requirement is met the tooltip to show otherwise nothing.
     */
    @SuppressWarnings("UnstableApiUsage")
    private static Supplier<Optional<Text[]>> getRequirementToolTip(Text requirementText, BooleanListEntry... dependencies) {
        return () -> {
            Requirement[] requirements = getFalseRequirements(dependencies);
            Text[] requirementTextArray = new Text[]{requirementText};

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

    private static Text makeEntryText(String categoryName, String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Text makeEntryText(String categoryName, String subCategoryName, String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + subCategoryName + "." + entryName);
    }

    private static Text makeEntryRequirementText(String categoryName, String entryName) {
        return Text.translatable("requirement.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Text makeCategoryText(String categoryName) {
        return Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName);
    }

    private static Text makeSubcategoryText(String categoryName, String subCategoryName) {
        return Text.translatable("subcategory.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + subCategoryName);
    }

    static {
        ENTRY_VALUE_CHANGES = new HashMap<>();
    }
}
