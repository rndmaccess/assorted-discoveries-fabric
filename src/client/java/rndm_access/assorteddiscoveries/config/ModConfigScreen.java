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
    public static final HashMap<String, Object> entryValueChanges = new HashMap<>();

    @SuppressWarnings("UnstableApiUsage")
    public static ConfigBuilder getConfigScreenBuilder() {

        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(Text.translatable("title." + ADReference.MOD_ID + ".config"));
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        JsonConfigCategory buildingCategory = ModConfig.CONFIG.getCategory("building");

        JsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                .getSubcategory("neutral_plushies");
        JsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                .getSubcategory("hostile_plushies");

        // Building config options
        ConfigCategory buildingScreenCategory = builder.getOrCreateCategory(makeCategoryText("building"));

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("dyed"),
                makeDyedEntryList(buildingCategory, entryBuilder)).build());
        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("passive_plushies"),
                makePassivePlushieEntryList(buildingCategory, entryBuilder)).build());

        BooleanListEntry enableBeePlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_bee_plushie"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_bee_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bee_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableCaveSpiderPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_cave_spider_plushie"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_cave_spider_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cave_spider_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableEndermanPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_enderman_plushie"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_enderman_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_enderman_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enablePiglinPlushies = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_piglin_plushies"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_piglin_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_piglin_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enablePolarBearPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_polar_bear_plushie"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_polar_bear_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_polar_bear_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableSpiderPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_spider_plushie"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_spider_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_spider_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enablePaleWolfPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_pale_wolf_plushie"),
                        neutralPlushiesSubcategory.getBooleanEntry("enable_pale_wolf_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pale_wolf_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("neutral_plushies"),
                List.of(enableBeePlush, enableCaveSpiderPlush, enableEndermanPlush, enablePiglinPlushies,
                        enablePolarBearPlush, enableSpiderPlush, enablePaleWolfPlush)).build());

        BooleanListEntry enableBlazePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_blaze_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_blaze_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blaze_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableCreeperPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_creeper_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_creeper_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_creeper_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableGhastPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_ghast_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_ghast_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ghast_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableGuardianPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_guardian_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_guardian_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_guardian_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableHoglinPlushies = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_hoglin_plushies"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_hoglin_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_hoglin_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableIllagerPlushies = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_illager_plushies"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_illager_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_illager_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableMagmaCubePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_magma_cube_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_magma_cube_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_magma_cube_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enablePhantomPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_phantom_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_phantom_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_phantom_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableRavagerPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_ravager_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_ravager_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ravager_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableShulkerPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_shulker_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_shulker_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_shulker_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableSkeletonPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_skeleton_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_skeleton_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_skeleton_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableSlimePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_slime_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_slime_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_slime_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableVexPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_vex_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_vex_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_vex_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableWitchPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_witch_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_witch_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_witch_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableWitherPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_wither_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_wither_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wither_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableZombiePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_zombie_plushie"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_zombie_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableZombieVillagerPlushies = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_zombie_villager_plushies"),
                        hostilePlushiesSubcategory.getBooleanEntry("enable_zombie_villager_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_villager_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("hostile_plushies"),
                List.of(enableBlazePlush, enableCreeperPlush, enableGhastPlush, enableGuardianPlush,
                        enableHoglinPlushies, enableIllagerPlushies, enableMagmaCubePlush,
                        enablePhantomPlush, enableRavagerPlush, enableShulkerPlush,
                        enableSkeletonPlush, enableSlimePlush, enableVexPlush,
                        enableWitchPlush, enableWitherPlush, enableZombiePlush,
                        enableZombieVillagerPlushies)).build());

        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_wooden_walls"),
                        buildingCategory.getBooleanEntry("enable_wooden_walls").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wooden_walls", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_stripped_wooden_walls"),
                        buildingCategory.getBooleanEntry("enable_stripped_wooden_walls")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_stripped_wooden_walls", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_wooden_rope_ladders"),
                        buildingCategory.getBooleanEntry("enable_wooden_rope_ladders")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wooden_rope_ladders", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_iron_ladders"),
                        buildingCategory.getBooleanEntry("enable_iron_ladders")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_iron_ladders", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_blackstone"),
                        buildingCategory.getBooleanEntry("enable_twisted_blackstone")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_blackstone", newValue))
                .setDefaultValue(true).requireRestart().build());

        Text requiresBlackstoneTilesText = Text.literal("Requires blackstone tiles");
        BooleanListEntry enableBlackstoneTiles = entryBuilder.startBooleanToggle(
                makeBuildingEntryText("enable_blackstone_tiles"),
                        buildingCategory.getBooleanEntry("enable_blackstone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blackstone_tiles", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(enableBlackstoneTiles);
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_blackstone_tiles"),
                        buildingCategory.getBooleanEntry("enable_twisted_blackstone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_blackstone_tiles", newValue))
                .setRequirement(Requirement.isTrue(enableBlackstoneTiles))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableBlackstoneTiles),
                        requiresBlackstoneTilesText))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_blackstone_tiles"),
                        buildingCategory.getBooleanEntry("enable_weeping_blackstone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_blackstone_tiles", newValue))
                .setRequirement(Requirement.isTrue(enableBlackstoneTiles))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableBlackstoneTiles),
                        requiresBlackstoneTilesText))
                .setDefaultValue(true).requireRestart().build());

        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_netherrack"),
                        buildingCategory.getBooleanEntry("enable_twisted_netherrack")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_netherrack", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_nether_bricks"),
                        buildingCategory.getBooleanEntry("enable_twisted_nether_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_nether_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_polished_blackstone_bricks"),
                        buildingCategory.getBooleanEntry("enable_twisted_polished_blackstone_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_polished_blackstone_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_netherrack"),
                        buildingCategory.getBooleanEntry("enable_weeping_netherrack")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_netherrack", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_nether_bricks"),
                        buildingCategory.getBooleanEntry("enable_weeping_nether_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_nether_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_blackstone"),
                        buildingCategory.getBooleanEntry("enable_weeping_blackstone")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_blackstone", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_polished_blackstone_bricks"),
                        buildingCategory.getBooleanEntry("enable_weeping_polished_blackstone_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_polished_blackstone_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());

        Text requiresSmokyQuartzBlocksText = Text.literal("Requires smoky quartz blocks");
        BooleanListEntry enableSmokyQuartzBlocks = entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_smoky_quartz_blocks"),
                        buildingCategory.getBooleanEntry("enable_smoky_quartz_blocks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_smoky_quartz_blocks", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(enableSmokyQuartzBlocks);
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_smoky_quartz_bricks"),
                        buildingCategory.getBooleanEntry("enable_smoky_quartz_bricks").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_smoky_quartz_bricks", newValue))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableSmokyQuartzBlocks),
                        requiresSmokyQuartzBlocksText))
                .setDefaultValue(true).requireRestart()
                .setRequirement(Requirement.isTrue(enableSmokyQuartzBlocks)).build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_smooth_smoky_quartz"),
                        buildingCategory.getBooleanEntry("enable_smooth_smoky_quartz")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_smooth_smoky_quartz", newValue))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableSmokyQuartzBlocks),
                        requiresSmokyQuartzBlocksText))
                .setDefaultValue(true).requireRestart()
                .setRequirement(Requirement.isTrue(enableSmokyQuartzBlocks)).build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_quartz_tiles"),
                        buildingCategory.getBooleanEntry("enable_quartz_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_quartz_tiles", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_quartz_walls"),
                        buildingCategory.getBooleanEntry("enable_quartz_walls").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_quartz_walls", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_bauxite"),
                        buildingCategory.getBooleanEntry("enable_bauxite").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bauxite", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_bauxite_bricks"),
                        buildingCategory.getBooleanEntry("enable_bauxite_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bauxite_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_cracked_bauxite_bricks"),
                        buildingCategory.getBooleanEntry("enable_cracked_bauxite_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cracked_bauxite_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_mossy_bauxite_bricks"),
                        buildingCategory.getBooleanEntry("enable_mossy_bauxite_bricks")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mossy_bauxite_bricks", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_stone_tiles"),
                        buildingCategory.getBooleanEntry("enable_stone_tiles").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_stone_tiles", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_cracked_stone_tiles"),
                        buildingCategory.getBooleanEntry("enable_cracked_stone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cracked_stone_tiles", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                makeBuildingEntryText("enable_mossy_stone_tiles"),
                        buildingCategory.getBooleanEntry("enable_mossy_stone_tiles")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mossy_stone_tiles", newValue))
                .setDefaultValue(true).requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                makeBuildingEntryText("enable_woodcutter"),
                buildingCategory.getBooleanEntry("enable_woodcutter")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_woodcutter", newValue))
                .setDefaultValue(true).requireRestart().build());

        // Farming config options
        ConfigCategory farming = builder.getOrCreateCategory(Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option.farming"));
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_wooden_planter_boxes"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_wooden_planter_boxes").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wooden_planter_boxes", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(makeFarmingOptionText("enable_green_onions"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_green_onions").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_green_onions", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(makeFarmingOptionText("enable_noodle_soup"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_noodle_soup").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_noodle_soup", newValue))
                .setDefaultValue(true).requireRestart().build());

        BooleanListEntry enableBlueberries = entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberries"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blueberries").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberries", newValue))
                .setDefaultValue(true).requireRestart().build();
        farming.addEntry(enableBlueberries);

        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_pie"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blueberry_pie").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberry_pie", newValue))
                .setDefaultValue(true).requireRestart().setRequirement(Requirement.isTrue(enableBlueberries)).build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_juice"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blueberry_juice").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberry_juice", newValue))
                .setDefaultValue(true).requireRestart().setRequirement(Requirement.isTrue(enableBlueberries)).build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_sweet_berry_pie"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_sweet_berry_pie").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sweet_berry_pie", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_sweet_berry_juice"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_sweet_berry_juice").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sweet_berry_juice", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_chocolate_cake"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_chocolate_cake").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_chocolate_cake", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_red_velvet_cake"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_red_velvet_cake").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_red_velvet_cake", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_fried_egg"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_fried_egg").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_fried_egg", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_hoglin_stew"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_hoglin_stew").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_hoglin_stew", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_forests_bounty"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_forests_bounty").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_forests_bounty", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_witchs_cradle_soup"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_witchs_cradle_soup").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_witchs_cradle_soup", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_pudding"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_pudding").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pudding", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_caramel_apple"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_caramel_apple").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_caramel_apple", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_nether_berries"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_nether_berries").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_nether_berries", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_purple_mushrooms"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_purple_mushrooms").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_purple_mushrooms", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_cattails"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_cattails").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cattails", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_bog_blossoms"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_bog_blossoms").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bog_blossoms", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_blood_kelp"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_blood_kelp").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blood_kelp", newValue))
                .setDefaultValue(true).requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_ender_plants"),
                        ModConfig.CONFIG.getCategory("farming")
                                .getBooleanEntry("enable_ender_plants").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ender_plants", newValue))
                .setDefaultValue(true).requireRestart().build());

        // Misc config options
        ConfigCategory misc = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.misc"));
        misc.addEntry(entryBuilder.startBooleanToggle(
                makeMiscOptionText("rabbits_safe_fall_increased"),
                        ModConfig.CONFIG.getCategory("misc")
                                .getBooleanEntry("rabbits_safe_fall_increased").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("rabbits_safe_fall_increased", newValue))
                .setDefaultValue(true).requireRestart().build());

        builder.setSavingRunnable(() -> {
            // When the config is saved make the changes to the categories and serialize to the config file.
            for (JsonConfigCategory category : ModConfig.CONFIG.getCategories()) {
                for (String entryName : entryValueChanges.keySet()) {
                    saveEntries(category, entryName, entryValueChanges);
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
    private static List<AbstractConfigListEntry> makeDyedEntryList(JsonConfigCategory buildingCategory,
                                                                   ConfigEntryBuilder entryBuilder) {
        JsonConfigCategory dyedSubcategory = buildingCategory.getSubcategory("dyed");
        String enableDyedCampfiresName = "enable_dyed_campfires";
        String enableDyedLanternsName = "enable_dyed_lanterns";
        String enableDyedTorchesName = "enable_dyed_torches";

        BooleanListEntry enableDyedCampfiresEntry = entryBuilder.startBooleanToggle(
                        makeDyedEntryText(enableDyedCampfiresName),
                        dyedSubcategory.getBooleanEntry(enableDyedCampfiresName).getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put(enableDyedCampfiresName, newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableDyedLanternsEntry = entryBuilder.startBooleanToggle(
                        makeDyedEntryText(enableDyedLanternsName),
                        dyedSubcategory.getBooleanEntry(enableDyedLanternsName).getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put(enableDyedLanternsName, newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableDyedTorchesEntry = entryBuilder.startBooleanToggle(
                        makeDyedEntryText(enableDyedTorchesName),
                        dyedSubcategory.getBooleanEntry(enableDyedTorchesName).getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put(enableDyedTorchesName, newValue))
                .setDefaultValue(true).requireRestart().build();
        return List.of(enableDyedCampfiresEntry, enableDyedLanternsEntry, enableDyedTorchesEntry);
    }

    @SuppressWarnings("rawtypes")
    public static List<AbstractConfigListEntry> makePassivePlushieEntryList(JsonConfigCategory category,
                                                                            ConfigEntryBuilder entryBuilder) {
        List<AbstractConfigListEntry> list = new LinkedList<>();
        List<String> boolEntryNames = List.of("enable_allay_plushie", "enable_bat_plushie",
                "enable_camel_plushie", "enable_cat_plushies", "enable_chicken_plushie", "enable_cow_plushie",
                "enable_horse_plushies", "enable_mooshroom_plushies", "enable_ocelot_plushie", "enable_pig_plushie",
                "enable_pufferfish_plushie", "enable_rabbit_plushies", "enable_sheep_plushies", "enable_squid_plushies",
                "enable_strider_plushies", "enable_villager_plushies", "enable_wandering_trader_plushie");
        JsonConfigCategory subCategory = category.getSubcategory("passive_plushies");

        for (String name : boolEntryNames) {
            Text displayName = makePassivePlushieEntryText(name);

            list.add(makeBooleanEntry(subCategory, entryBuilder, name, displayName));
        }
        return list;
    }

    /**
     * @param subCategory The subcategory that this entry is in.
     * @param entryBuilder An entry builder.
     * @param entryName The name of this entry from the config.
     * @param displayName The text that is displayed in the config screen for this entry.
     * @return A new boolean entry list element
     */
    private static BooleanListEntry makeBooleanEntry(JsonConfigCategory subCategory, ConfigEntryBuilder entryBuilder,
                                                     String entryName, Text displayName) {
        return entryBuilder.startBooleanToggle(displayName, subCategory.getBooleanEntry(entryName).getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put(entryName, newValue))
                .setDefaultValue(true).requireRestart().build();
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

    private static Text makeDyedEntryText(String entryName) {
        return makeBuildingSubcategoryEntryText("dyed", entryName);
    }

    private static Text makeHostilePlushiesEntryText(String entryName) {
        return makeBuildingSubcategoryEntryText("hostile_plushies", entryName);
    }

    private static Text makeNeutralPlushiesEntryText(String entryName) {
        return makeBuildingSubcategoryEntryText("neutral_plushies", entryName);
    }

    private static Text makePassivePlushieEntryText(String entryName) {
        return makeBuildingSubcategoryEntryText("passive_plushies", entryName);
    }

    private static Text makeBuildingSubcategoryEntryText(String subCategoryName, String entryName) {
        return makeSubCategoryEntryText("building", subCategoryName, entryName);
    }

    private static Text makeBuildingEntryText(String entryName) {
        return makeEntryText("building", entryName);
    }

    private static Text makeEntryText(String categoryName, String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
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
}
