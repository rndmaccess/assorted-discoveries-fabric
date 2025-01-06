package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
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
        ConfigBuilder configBuilder = ConfigBuilder.create().setTitle(title);
        configBuilder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        configBuilder.setGlobalized(true);
        configBuilder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();

        ModConfigScreen.addBuildingBlocksCategory(configBuilder, entryBuilder);
        ModConfigScreen.addPassivePlushieCategory(configBuilder, entryBuilder);
        ModConfigScreen.addNeutralPlushieCategory(configBuilder, entryBuilder);
        ModConfigScreen.addHostilePlushieCategory(configBuilder, entryBuilder);
        ModConfigScreen.addStructureCategory(configBuilder, entryBuilder);
        ModConfigScreen.addFarmingCategory(configBuilder, entryBuilder);

        configBuilder.setSavingRunnable(() -> {
            ConfigData data = ConfigData.getInstance();
            JsonConfig config = ModConfig.getInternalConfig();

            config.load(data);
            config.save(data, ENTRY_VALUE_CHANGES);
        });
        return configBuilder;
    }

    private static void addBuildingBlocksCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "building_blocks";
        Text categoryText = makeCategoryText(categoryName);
        ConfigCategory category = configBuilder.getOrCreateCategory(categoryText);
        BooleanListEntry configEntry;

        // Dyed Blocks
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DYED_CAMPFIRES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DYED_LANTERNS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DYED_TORCHES, categoryName);
        category.addEntry(configEntry);

        // Netherrack and Nether Bricks
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_TWISTED_NETHERRACK, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WEEPING_NETHERRACK, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS, categoryName);
        category.addEntry(configEntry);

        // Blackstone Entries
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS,
                categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS,
                categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableBlackstoneTiles = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BLACKSTONE_TILES, categoryName);
        category.addEntry(enableBlackstoneTiles);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES,
                categoryName, enableBlackstoneTiles);
        category.addEntry(configEntry);

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WOODEN_WALLS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_IRON_LADDERS, categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableSmokyQuartzBlocks = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS, categoryName);
        category.addEntry(enableSmokyQuartzBlocks);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS,
                categoryName, enableSmokyQuartzBlocks);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ,
                categoryName, enableSmokyQuartzBlocks);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_QUARTZ_TILES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_QUARTZ_WALLS, categoryName);
        category.addEntry(configEntry);

        BooleanListEntry enableBauxite = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BAUXITE,
                categoryName);
        BooleanListEntry enableBauxiteBricks = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_BAUXITE_BRICKS, categoryName, enableBauxite);

        category.addEntry(enableBauxite);
        category.addEntry(enableBauxiteBricks);
        configEntry = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS, categoryName, enableBauxite, enableBauxiteBricks);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS, categoryName, enableBauxite, enableBauxiteBricks);
        category.addEntry(configEntry);

        BooleanListEntry enableStoneTiles = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_STONE_TILES, categoryName);

        category.addEntry(enableStoneTiles);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CRACKED_STONE_TILES,
                categoryName, enableStoneTiles);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MOSSY_STONE_TILES,
                categoryName, enableStoneTiles);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WOODCUTTER, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS,
                categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_STONE_WALLS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CALCITE_BLOCKS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_POLISHED_CALCITE, categoryName);
        category.addEntry(configEntry);

        BooleanListEntry enableCalciteBricksEntry = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_CALCITE_BRICKS, categoryName);
        category.addEntry(enableCalciteBricksEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS, categoryName,
                enableCalciteBricksEntry);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS, categoryName,
                enableCalciteBricksEntry);
        category.addEntry(configEntry);

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS, categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableDripstoneBricksEntry = makeBoolConfigEntry(entryBuilder,
                ModConfigKeys.ENABLE_DRIPSTONE_BRICKS, categoryName);
        category.addEntry(enableDripstoneBricksEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS,
                categoryName, enableDripstoneBricksEntry);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS,
                categoryName, enableDripstoneBricksEntry);
        category.addEntry(configEntry);

    }

    private static void addPassivePlushieCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "passive_plushies";
        Text categoryText = makeCategoryText(categoryName);
        ConfigCategory category = configBuilder.getOrCreateCategory(categoryText);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ALLAY_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BAT_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CAMEL_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CAT_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CHICKEN_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_COW_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_HORSE_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_OCELOT_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PIG_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_RABBIT_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SHEEP_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SQUID_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_STRIDER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_VILLAGER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
    }

    private static void addNeutralPlushieCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "neutral_plushies";
        Text categoryText = makeCategoryText(categoryName);
        ConfigCategory category = configBuilder.getOrCreateCategory(categoryText);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BEE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PIGLIN_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SPIDER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE, categoryName);
        category.addEntry(configEntry);
    }

    private static void addHostilePlushieCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "hostile_plushies";
        Text categoryText = makeCategoryText(categoryName);
        ConfigCategory category = configBuilder.getOrCreateCategory(categoryText);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BLAZE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CREEPER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_GHAST_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_HOGLIN_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ILLAGER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PHANTOM_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_RAVAGER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SHULKER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SKELETON_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SLIME_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_VEX_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WITCH_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WITHER_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CREAKING_PLUSHIE, categoryName);
        category.addEntry(configEntry);
    }

    private static void addStructureCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "structures";
        Text categoryText = makeCategoryText(categoryName);
        ConfigCategory category = configBuilder.getOrCreateCategory(categoryText);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_FOREST_CABINS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_DARK_FOREST_CABINS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BIRCH_FOREST_CABINS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_TAIGA_CABINS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SNOWY_TAIGA_CABINS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CRIMSON_FOREST_CABINS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WARPED_FOREST_CABINS, categoryName);
        category.addEntry(configEntry);
    }

    private static void addFarmingCategory(ConfigBuilder configBuilder, ConfigEntryBuilder entryBuilder) {
        String categoryName = "farming";
        Text categoryText = makeCategoryText(categoryName);
        ConfigCategory category = configBuilder.getOrCreateCategory(categoryText);
        BooleanListEntry configEntry;

        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_GREEN_ONIONS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_NOODLE_SOUP, categoryName);
        category.addEntry(configEntry);
        BooleanListEntry enableBlueberries = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BLUEBERRIES,
                categoryName);
        category.addEntry(enableBlueberries);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BLUEBERRY_PIE, categoryName,
                enableBlueberries);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BLUEBERRY_JUICE, categoryName,
                enableBlueberries);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SWEET_BERRY_PIE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_SWEET_BERRY_JUICE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CHOCOLATE_CAKE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_RED_VELVET_CAKE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_FRIED_EGG, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_HOGLIN_STEW, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_FORESTS_BOUNTY, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PUDDING, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CARAMEL_APPLE, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_NETHER_BERRIES, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_PURPLE_MUSHROOMS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_CATTAILS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BOG_BLOSSOMS, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_BLOOD_KELP, categoryName);
        category.addEntry(configEntry);
        configEntry = makeBoolConfigEntry(entryBuilder, ModConfigKeys.ENABLE_ENDER_PLANTS, categoryName);
        category.addEntry(configEntry);
    }

    private static BooleanListEntry makeBoolConfigEntry(ConfigEntryBuilder entryBuilder, String key,
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
    private static BooleanListEntry makeBoolConfigEntry(ConfigEntryBuilder entryBuilder, String key,
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

    private static Text makeEntryRequirementText(String categoryName, String entryName) {
        return Text.translatable("requirement.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Text makeCategoryText(String categoryName) {
        return Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName);
    }

    static {
        ENTRY_VALUE_CHANGES = new HashMap<>();
    }
}
