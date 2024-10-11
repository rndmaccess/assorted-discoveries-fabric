package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import me.shedaniel.clothconfig2.gui.entries.SubCategoryListEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.json.parser.entries.BooleanConfigEntry;

import java.util.*;
import java.util.function.Supplier;

public class ModConfigScreen {
    public static final HashMap<String, Object> ENTRY_VALUE_CHANGES;

    public static ConfigBuilder getConfigScreenBuilder() {
        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(Text.translatable("title." + ADReference.MOD_ID + ".config"));
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        String buildingCategoryName = "building";

        // Building config options
        ConfigCategory buildingScreenCategory = builder.getOrCreateCategory(makeCategoryText(buildingCategoryName));
        buildingScreenCategory.addEntry(makeDyedSubCategory(buildingCategoryName, entryBuilder));
        buildingScreenCategory.addEntry(makePassivePlushieSubCategory(buildingCategoryName, entryBuilder));
        buildingScreenCategory.addEntry(makeNeutralPlushieSubCategory(buildingCategoryName, entryBuilder));
        buildingScreenCategory.addEntry(makeHostilePlushieSubCategory(buildingCategoryName, entryBuilder));

        Text displayText;
        String woodenWallsName = ModConfig.ENABLE_WOODEN_WALLS.getKey().getName();
        displayText = makeEntryText(buildingCategoryName, woodenWallsName);
        entryBuilder.startBooleanToggle(displayText, ModConfig.ENABLE_WOODEN_WALLS.getValue().evaluate())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put(woodenWallsName, newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_STRIPPED_WOODEN_WALLS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WOODEN_ROPE_LADDERS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_IRON_LADDERS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_TWISTED_BLACKSTONE, buildingCategoryName));
        BooleanListEntry enableBlackstoneTiles = makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BLACKSTONE_TILES, buildingCategoryName);
        buildingScreenCategory.addEntry(enableBlackstoneTiles);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_TWISTED_BLACKSTONE_TILES, buildingCategoryName, enableBlackstoneTiles));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WEEPING_BLACKSTONE_TILES, buildingCategoryName, enableBlackstoneTiles));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_TWISTED_NETHERRACK, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_TWISTED_NETHER_BRICKS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WEEPING_NETHERRACK, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WEEPING_NETHER_BRICKS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WEEPING_BLACKSTONE, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS, buildingCategoryName));
        BooleanListEntry enableSmokyQuartzBlocks = makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_SMOKY_QUARTZ_BLOCKS, buildingCategoryName);
        buildingScreenCategory.addEntry(enableSmokyQuartzBlocks);
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_SMOKY_QUARTZ_BRICKS, buildingCategoryName, enableSmokyQuartzBlocks));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_SMOOTH_SMOKY_QUARTZ, buildingCategoryName, enableSmokyQuartzBlocks));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_QUARTZ_TILES, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_QUARTZ_WALLS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BAUXITE, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BAUXITE_BRICKS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_CRACKED_BAUXITE_BRICKS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_MOSSY_BAUXITE_BRICKS, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_STONE_TILES, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_CRACKED_STONE_TILES, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_MOSSY_STONE_TILES, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WOODCUTTER, buildingCategoryName));
        buildingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_CRACKED_STONE_BRICK_BLOCKS, buildingCategoryName));

        // Farming config options
        String farmingCategoryName = "farming";
        ConfigCategory farmingScreenCategory = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option." + farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WOODEN_PLANTER_BOXES, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_GREEN_ONIONS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_NOODLE_SOUP, farmingCategoryName));
        BooleanListEntry enableBlueberries = makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BLUEBERRIES, farmingCategoryName);
        farmingScreenCategory.addEntry(enableBlueberries);
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BLUEBERRY_PIE, farmingCategoryName, enableBlueberries));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BLUEBERRY_JUICE, farmingCategoryName, enableBlueberries));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_SWEET_BERRY_PIE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_SWEET_BERRY_JUICE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_CHOCOLATE_CAKE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_RED_VELVET_CAKE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_FRIED_EGG, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_HOGLIN_STEW, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_FORESTS_BOUNTY, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_WITCHS_CRADLE_SOUP, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_PUDDING, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_CARAMEL_APPLE, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_NETHER_BERRIES, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_PURPLE_MUSHROOMS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_CATTAILS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BOG_BLOSSOMS, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_BLOOD_KELP, farmingCategoryName));
        farmingScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.ENABLE_ENDER_PLANTS, farmingCategoryName));

        // Misc config options
        String miscCategoryName = "misc";
        ConfigCategory miscScreenCategory = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option." + miscCategoryName));
        miscScreenCategory.addEntry(makeToggleableConfigEntry(entryBuilder,
                ModConfig.RABBITS_SAFE_FALL_INCREASED, miscCategoryName));

        builder.setSavingRunnable(() -> {
            ModConfig.CONFIG.save(ENTRY_VALUE_CHANGES);
            ModConfig.CONFIG.load();
        });
        return builder;
    }

    @SuppressWarnings("rawtypes")
    private static SubCategoryListEntry makeDyedSubCategory(String categoryName, ConfigEntryBuilder entryBuilder) {
        final List<AbstractConfigListEntry> entryList = new ArrayList<>();
        final String subCategoryName = "dyed";
        final Text subCategoryText = makeSubcategoryText(categoryName, subCategoryName);
        BooleanListEntry configEntry;

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_DYED_CAMPFIRES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_DYED_LANTERNS,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_DYED_TORCHES,
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

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_ALLAY_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_BAT_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_CAMEL_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_CAT_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_CHICKEN_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_COW_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_HORSE_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_MOOSHROOM_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_OCELOT_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_PIG_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_PUFFERFISH_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_RABBIT_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_SHEEP_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_SQUID_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_STRIDER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_VILLAGER_PLUSHIES,
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

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_BEE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_CAVE_SPIDER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_ENDERMAN_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_PIGLIN_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_POLAR_BEAR_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_SPIDER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_PALE_WOLF_PLUSHIE,
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

        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_BLAZE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_CREEPER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_GHAST_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_GUARDIAN_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_HOGLIN_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_ILLAGER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_MAGMA_CUBE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_PHANTOM_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_RAVAGER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_SHULKER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_SKELETON_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_SLIME_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_VEX_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_WITCH_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_WITHER_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_ZOMBIE_PLUSHIE,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        configEntry = makeToggleableConfigEntry(entryBuilder, ModConfig.ENABLE_ZOMBIE_VILLAGER_PLUSHIES,
                categoryName, subCategoryName);
        entryList.add(configEntry);
        return entryBuilder.startSubCategory(subCategoryText, entryList).build();
    }

    private static BooleanListEntry makeToggleableConfigEntry(ConfigEntryBuilder entryBuilder, BooleanConfigEntry entry,
                                                              String categoryName, String subCategoryName) {
        final String entryName = entry.getKey().getName();
        final boolean entryValue = entry.getValue().evaluate();
        Text displayText = makeEntryText(categoryName, subCategoryName, entryName);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entryName, newValue);
                    }
                }).setDefaultValue(true).requireRestart().build();
    }

    private static BooleanListEntry makeToggleableConfigEntry(ConfigEntryBuilder entryBuilder, BooleanConfigEntry entry,
                                                             String categoryName) {
        final String entryName = entry.getKey().getName();
        final boolean entryValue = entry.getValue().evaluate();
        Text displayText = makeEntryText(categoryName, entryName);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entryName, newValue);
                    }
                }).setDefaultValue(true).requireRestart().build();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static BooleanListEntry makeToggleableConfigEntry(ConfigEntryBuilder entryBuilder, BooleanConfigEntry entry,
                                                              String categoryName, BooleanListEntry dependency) {
        final String entryName = entry.getKey().getName();
        final boolean entryValue = entry.getValue().evaluate();
        Text requirementText = makeEntryRequirementText(categoryName, entryName);
        Supplier<Optional<Text[]>> requirementTooltip = getRequirementToolTip(dependency, requirementText);
        Text displayText = makeEntryText(categoryName, entryName);

        return entryBuilder.startBooleanToggle(displayText, entryValue)
                .setSaveConsumer(newValue -> {
                    if (entryValue != newValue) {
                        ENTRY_VALUE_CHANGES.put(entryName, newValue);
                    }
                }).setTooltipSupplier(requirementTooltip).setDefaultValue(true).requireRestart()
                .setRequirement(Requirement.isTrue(dependency)).build();
    }

    /**
     * @param dependency The dependency to check.
     * @param requirementText The tooltip text to display when the requirement is met.
     * @return If the requirement is met the tooltip to show otherwise nothing.
     */
    @SuppressWarnings("UnstableApiUsage")
    private static Supplier<Optional<Text[]>> getRequirementToolTip(BooleanListEntry dependency, Text requirementText) {
        return () -> {
            Requirement requirement = Requirement.isFalse(dependency);

            if(requirement.check()) {
                return Optional.of(requirementText.withoutStyle().toArray(new Text[0]));
            }
            return Optional.empty();
        };
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
