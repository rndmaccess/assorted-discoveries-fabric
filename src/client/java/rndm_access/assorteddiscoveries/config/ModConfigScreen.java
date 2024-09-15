package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonBooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ModConfigScreen {
    public static final HashMap<String, Object> ENTRY_VALUE_CHANGES;

    @SuppressWarnings("UnstableApiUsage")
    public static ConfigBuilder getConfigScreenBuilder() {

        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(Text.translatable("title." + ADReference.MOD_ID + ".config"));
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        JsonConfigCategory buildingCategory = ModConfig.CONFIG.getCategory("building");

        // Building config options
        ConfigCategory buildingScreenCategory = builder.getOrCreateCategory(makeCategoryText("building"));
        String dyedCategoryName = "dyed";
        String passivePlushiesCategoryName = "passive_plushies";
        String neutralPlushiesCategoryName = "neutral_plushies";
        String hostilePlushiesCategoryName = "hostile_plushies";

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText(dyedCategoryName),
                makeBuildingSubEntryList(entryBuilder, dyedCategoryName)).build());
        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText(passivePlushiesCategoryName),
                makeBuildingSubEntryList(entryBuilder, passivePlushiesCategoryName)).build());
        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText(neutralPlushiesCategoryName),
                makeBuildingSubEntryList(entryBuilder, neutralPlushiesCategoryName)).build());
        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText(hostilePlushiesCategoryName),
                makeBuildingSubEntryList(entryBuilder, hostilePlushiesCategoryName)).build());

        buildingScreenCategory.addEntry(makeBooleanEntry(buildingCategory, entryBuilder,
                "enable_wooden_walls", makeBuildingEntryText("enable_wooden_walls")));

        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_stripped_wooden_walls"),
                        buildingCategory.getBooleanEntry("enable_stripped_wooden_walls")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_stripped_wooden_walls", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_wooden_rope_ladders"),
                        buildingCategory.getBooleanEntry("enable_wooden_rope_ladders")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_wooden_rope_ladders", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_iron_ladders"),
                        buildingCategory.getBooleanEntry("enable_iron_ladders")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_iron_ladders", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_blackstone"),
                        buildingCategory.getBooleanEntry("enable_twisted_blackstone")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_twisted_blackstone", newValue))
                .setDefaultValue(true).requireRestart().build());

        Text requiresBlackstoneTilesText = Text.literal("Requires blackstone tiles");
        BooleanListEntry enableBlackstoneTiles = entryBuilder.startBooleanToggle(
                makeBuildingEntryText("enable_blackstone_tiles"),
                        buildingCategory.getBooleanEntry("enable_blackstone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_blackstone_tiles", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(enableBlackstoneTiles);
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_blackstone_tiles"),
                        buildingCategory.getBooleanEntry("enable_twisted_blackstone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_twisted_blackstone_tiles", newValue))
                .setRequirement(Requirement.isTrue(enableBlackstoneTiles))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableBlackstoneTiles),
                        requiresBlackstoneTilesText))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_blackstone_tiles"),
                        buildingCategory.getBooleanEntry("enable_weeping_blackstone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_weeping_blackstone_tiles", newValue))
                .setRequirement(Requirement.isTrue(enableBlackstoneTiles))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableBlackstoneTiles),
                        requiresBlackstoneTilesText))
                .setDefaultValue(true).requireRestart().build());

        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_netherrack"),
                        buildingCategory.getBooleanEntry("enable_twisted_netherrack")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_twisted_netherrack", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_nether_bricks"),
                        buildingCategory.getBooleanEntry("enable_twisted_nether_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_twisted_nether_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_polished_blackstone_bricks"),
                        buildingCategory.getBooleanEntry("enable_twisted_polished_blackstone_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_twisted_polished_blackstone_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_netherrack"),
                        buildingCategory.getBooleanEntry("enable_weeping_netherrack")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_weeping_netherrack", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_nether_bricks"),
                        buildingCategory.getBooleanEntry("enable_weeping_nether_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_weeping_nether_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_blackstone"),
                        buildingCategory.getBooleanEntry("enable_weeping_blackstone")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_weeping_blackstone", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_polished_blackstone_bricks"),
                        buildingCategory.getBooleanEntry("enable_weeping_polished_blackstone_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_weeping_polished_blackstone_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());

        BooleanListEntry enableSmokyQuartzBlocks = makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_smoky_quartz_blocks");

        buildingScreenCategory.addEntry(enableSmokyQuartzBlocks);
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_smoky_quartz_bricks", enableSmokyQuartzBlocks));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_smooth_smoky_quartz", enableSmokyQuartzBlocks));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_quartz_tiles"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_quartz_walls"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_bauxite"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_bauxite_bricks"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_cracked_bauxite_bricks"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_mossy_bauxite_bricks"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_stone_tiles"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_cracked_stone_tiles"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_mossy_stone_tiles"));
        buildingScreenCategory.addEntry(makeBooleanBuildingEntry(buildingCategory, entryBuilder,
                "enable_woodcutter"));

        // Farming config options
        ConfigCategory farming = builder.getOrCreateCategory(Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option.farming"));
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_wooden_planter_boxes"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_wooden_planter_boxes").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_wooden_planter_boxes", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(makeFarmingOptionText("enable_green_onions"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_green_onions").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_green_onions", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(makeFarmingOptionText("enable_noodle_soup"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_noodle_soup").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_noodle_soup", newValue))
                .setDefaultValue(true).requireRestart().build());

        BooleanListEntry enableBlueberries = entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberries"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blueberries").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_blueberries", newValue))
                .setDefaultValue(true).requireRestart().build();
        farming.addEntry(enableBlueberries);

        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_pie"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blueberry_pie").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_blueberry_pie", newValue))
                .setDefaultValue(true).requireRestart().setRequirement(Requirement.isTrue(enableBlueberries)).build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_juice"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blueberry_juice").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_blueberry_juice", newValue))
                .setDefaultValue(true).requireRestart().setRequirement(Requirement.isTrue(enableBlueberries)).build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_sweet_berry_pie"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_sweet_berry_pie").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_sweet_berry_pie", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_sweet_berry_juice"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_sweet_berry_juice").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_sweet_berry_juice", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_chocolate_cake"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_chocolate_cake").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_chocolate_cake", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_red_velvet_cake"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_red_velvet_cake").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_red_velvet_cake", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_fried_egg"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_fried_egg").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_fried_egg", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_hoglin_stew"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_hoglin_stew").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_hoglin_stew", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_forests_bounty"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_forests_bounty").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_forests_bounty", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_witchs_cradle_soup"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_witchs_cradle_soup").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_witchs_cradle_soup", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_pudding"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_pudding").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_pudding", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_caramel_apple"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_caramel_apple").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_caramel_apple", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_nether_berries"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_nether_berries").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_nether_berries", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_purple_mushrooms"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_purple_mushrooms").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_purple_mushrooms", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_cattails"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_cattails").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_cattails", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_bog_blossoms"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_bog_blossoms").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_bog_blossoms", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_blood_kelp"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blood_kelp").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_blood_kelp", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_ender_plants"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_ender_plants").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("enable_ender_plants", newValue))
                .setDefaultValue(true).requireRestart().build());

        // Misc config options
        ConfigCategory misc = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.misc"));
        misc.addEntry(entryBuilder.startBooleanToggle(
                makeMiscOptionText("rabbits_safe_fall_increased"),
                        ModConfig.CONFIG.getCategory("misc")
                                .getBooleanEntry("rabbits_safe_fall_increased").getValue())
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put("rabbits_safe_fall_increased", newValue))
                .setDefaultValue(true).requireRestart().build());

        builder.setSavingRunnable(() -> {
            // When the config is saved make the changes to the categories and serialize to the config file.
            for (JsonConfigCategory category : ModConfig.CONFIG.getCategories()) {
                for (String entryName : ENTRY_VALUE_CHANGES.keySet()) {
                    saveEntries(category, entryName, ENTRY_VALUE_CHANGES);
                }
            }

            if (ModConfig.worldConfigPath != null && Files.exists(ModConfig.worldConfigPath)) {
                ModConfig.CONFIG.save(ModConfig.worldConfigPath);
            } else {
                ModConfig.CONFIG.save(ModConfig.GLOBAL_PATH);
            }
        });
        return builder;
    }

    @SuppressWarnings("rawtypes")
    public static List<AbstractConfigListEntry> makeBuildingSubEntryList(ConfigEntryBuilder entryBuilder,
                                                                         String subCategoryName) {
        List<AbstractConfigListEntry> list = new LinkedList<>();
        String buildingCategoryName = "building";
        JsonConfigCategory passivePlushieCategory = ModConfig.CONFIG.getCategory(buildingCategoryName)
                .getSubcategory(subCategoryName);

        for (String name : passivePlushieCategory.getEntryNames()) {
            Text displayName = makeSubCategoryEntryText(buildingCategoryName, subCategoryName, name);
            list.add(makeBooleanEntry(passivePlushieCategory, entryBuilder, name, displayName));
        }
        return list;
    }

    public static BooleanListEntry makeBooleanBuildingEntry(JsonConfigCategory category,
                                                            ConfigEntryBuilder entryBuilder, String entryName) {
        Text displayName = makeBuildingEntryText(entryName);

        return makeBooleanEntry(category, entryBuilder, entryName, displayName);
    }

    public static BooleanListEntry makeBooleanBuildingEntry(JsonConfigCategory category,
                                                            ConfigEntryBuilder entryBuilder, String entryName,
                                                            ValueHolder<Boolean> dependency) {
        Text displayName = makeBuildingEntryText(entryName);
        Text requirementText = makeBuildingRequirementText(entryName);

        return makeBooleanEntry(category, entryBuilder, entryName, displayName, dependency, requirementText);
    }

    /**
     * @param category The subcategory that this entry is in.
     * @param entryBuilder An entry builder.
     * @param entryName The name of this entry from the config.
     * @param displayName The text that is displayed in the config screen for this entry.
     * @return A new boolean entry list element
     */
    private static BooleanListEntry makeBooleanEntry(JsonConfigCategory category, ConfigEntryBuilder entryBuilder,
                                                     String entryName, Text displayName) {
        boolean configValue = category.getBooleanEntry(entryName).getValue();

        return entryBuilder.startBooleanToggle(displayName, configValue)
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put(entryName, newValue))
                .setDefaultValue(true).requireRestart().build();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static BooleanListEntry makeBooleanEntry(JsonConfigCategory category, ConfigEntryBuilder entryBuilder,
                                                     String entryName, Text displayName, ValueHolder<Boolean> dependency,
                                                     Text requirementText) {
        boolean configValue = category.getBooleanEntry(entryName).getValue();

        return entryBuilder.startBooleanToggle(displayName, configValue)
                .setSaveConsumer(newValue -> ENTRY_VALUE_CHANGES.put(entryName, newValue))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(dependency), requirementText))
                .setDefaultValue(true).requireRestart()
                .setRequirement(Requirement.isTrue(dependency)).build();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static Optional<Text[]> makeOptionalToolTip(Requirement requirement, Text requirementText) {
        if(requirement.check()) {
            return Optional.of(requirementText.withoutStyle().toArray(new Text[0]));
        }
        return Optional.empty();
    }

    private static void saveEntries(JsonConfigCategory category, String entryName,
                                    HashMap<String, Object> entryValueChanges) {
        if(category.hasBooleanEntry(entryName)) {
            JsonBooleanConfigEntry entry = category.getBooleanEntry(entryName);
            entry.setValue(Boolean.parseBoolean(entryValueChanges.get(entryName).toString()));
        } else {
            for (String subcategoryName : category.getSubcategoryNames()) {
                if(category.hasSubcategory(subcategoryName)) {
                    saveEntries(category.getSubcategory(subcategoryName), entryName, entryValueChanges);
                }
            }
        }
    }

    private static Text makeFarmingOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.farming." + entryName);
    }

    private static Text makeMiscOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.misc." + entryName);
    }

    private static Text makeBuildingEntryText(String entryName) {
        return makeEntryText("building", entryName);
    }

    private static Text makeBuildingRequirementText(String entryName) {
        return makeRequirementText("building", entryName);
    }

    private static Text makeEntryText(String categoryName, String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Text makeRequirementText(String categoryName, String entryName) {
        return Text.translatable("requirement.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + entryName);
    }

    private static Text makeBuildingSubcategoryText(String subCategoryName) {
        return makeSubcategoryText("building", subCategoryName);
    }

    private static Text makeCategoryText(String categoryName) {
        return Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName);
    }

    private static Text makeSubcategoryText(String categoryName, String subCategoryName) {
        return Text.translatable("subcategory.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + subCategoryName);
    }

    private static Text makeSubCategoryEntryText(String categoryName, String subCategoryName, String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName + "." + subCategoryName + "." + entryName);
    }

    static {
        ENTRY_VALUE_CHANGES = new HashMap<>();
    }
}
