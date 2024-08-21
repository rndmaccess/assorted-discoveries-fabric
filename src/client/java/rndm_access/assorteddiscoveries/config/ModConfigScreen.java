package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.json.parser.entries.JsonBooleanConfigEntry;
import rndm_access.assorteddiscoveries.config.json.parser.JsonConfigCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ModConfigScreen {
    @SuppressWarnings("UnstableApiUsage")
    public static ConfigBuilder getConfigScreenBuilder() {
        HashMap<String, Object> entryValueChanges = new HashMap<>();

        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(Text.translatable("title." + ADReference.MOD_ID + ".config"));
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        JsonConfigCategory buildingCategory = ModConfig.CONFIG.getCategory("building");
        JsonConfigCategory dyedSubcategory = buildingCategory
                .getSubcategory("dyed");
        JsonConfigCategory passivePlushiesSubcategory = buildingCategory
                .getSubcategory("passive_plushies");
        JsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                .getSubcategory("neutral_plushies");
        JsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                .getSubcategory("hostile_plushies");

        // Building config options
        ConfigCategory buildingScreenCategory = builder.getOrCreateCategory(makeCategoryText("building"));
        BooleanListEntry enableDyedCampfires = entryBuilder.startBooleanToggle(
                        makeDyedEntryText("enable_dyed_campfires"),
                        dyedSubcategory.getBooleanEntry("enable_dyed_campfires").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_dyed_campfires", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableDyedLanterns = entryBuilder.startBooleanToggle(
                        makeDyedEntryText("enable_dyed_lanterns"),
                        dyedSubcategory.getBooleanEntry("enable_dyed_lanterns").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_dyed_lanterns", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableDyedTorches = entryBuilder.startBooleanToggle(
                        makeDyedEntryText("enable_dyed_torches"),
                        dyedSubcategory.getBooleanEntry("enable_dyed_torches").getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_dyed_torches", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("dyed"),
                List.of(enableDyedCampfires, enableDyedLanterns, enableDyedTorches)).build());

        BooleanListEntry enableAllayPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_allay_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_allay_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_allay_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableBatPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_bat_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_bat_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bat_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableCamelPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_camel_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_camel_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_camel_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableCatPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_cat_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_cat_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cat_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableChickenPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_chicken_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_chicken_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_chicken_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableCowPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_cow_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_cow_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cow_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableHorsePlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_horse_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_horse_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_horse_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableMooshroomPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_mooshroom_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_mooshroom_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mooshroom_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableOcelotPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_ocelot_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_ocelot_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ocelot_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enablePigPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_pig_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_pig_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pig_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enablePufferfishPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_pufferfish_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_pufferfish_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pufferfish_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableRabbitPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_rabbit_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_rabbit_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_rabbit_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableSheepPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_sheep_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_sheep_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sheep_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableSquidPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_squid_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_squid_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_squid_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableStriderPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_strider_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_strider_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_strider_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableVillagerPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_villager_plushies"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_villager_plushies")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_villager_plushies", newValue))
                .setDefaultValue(true).requireRestart().build();
        BooleanListEntry enableWanderingTraderPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_wandering_trader_plushie"),
                        passivePlushiesSubcategory.getBooleanEntry("enable_wandering_trader_plushie")
                                .getValue())
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wandering_trader_plushie", newValue))
                .setDefaultValue(true).requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("passive_plushies"),
                List.of(enableAllayPlush, enableBatPlush, enableCamelPlush, enableCatPlushies, enableChickenPlush,
                        enableCowPlush, enableHorsePlushies, enableMooshroomPlushies, enableOcelotPlush,
                        enablePigPlush, enablePufferfishPlush, enableRabbitPlush, enableSheepPlush,
                        enableSquidPlushies, enableStriderPlushies, enableVillagerPlushies,
                        enableWanderingTraderPlush)).build());

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
            for(JsonConfigCategory category : ModConfig.CONFIG.getCategories()) {
                for(String entryName : entryValueChanges.keySet()) {
                    saveEntries(category, entryName, entryValueChanges);
                }
            }
            ModConfig.JANKSON_CONFIG_SERIALIZER.serializeConfig();
        });
        return builder;
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

    private static Text makePassivePlushiesEntryText(String entryName) {
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

    private static Text makeCategoryText(String categoryName) {
        return Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option." + categoryName);
    }

    private static Text makeBuildingSubcategoryText(String subCategoryName) {
        return makeSubcategoryText("building", subCategoryName);
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
