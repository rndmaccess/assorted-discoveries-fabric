package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.*;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.json.ADJsonConfigCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ADConfigScreen {
    @SuppressWarnings("UnstableApiUsage")
    public static ConfigBuilder getConfigScreenBuilder() {
        HashMap<String, Object> entryValueChanges = new HashMap<>();

        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(Text.translatable("title." + ADReference.MOD_ID + ".config"));
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        ADJsonConfigCategory buildingCategory = ADConfig.CONFIG.getCategory("building");
        ADJsonConfigCategory dyedSubcategory = buildingCategory
                .getSubcategory("dyed");
        ADJsonConfigCategory passivePlushiesSubcategory = buildingCategory
                .getSubcategory("passive_plushies");
        ADJsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                .getSubcategory("neutral_plushies");
        ADJsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                .getSubcategory("hostile_plushies");

        // Building config options
        ConfigCategory buildingScreenCategory = builder.getOrCreateCategory(makeCategoryText("building"));
        BooleanListEntry enableDyedCampfires = entryBuilder.startBooleanToggle(
                        makeDyedEntryText("enable_dyed_campfires"),
                        dyedSubcategory.getEntry("enable_dyed_campfires")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_dyed_campfires", newValue))
                .requireRestart().build();
        BooleanListEntry enableDyedLanterns = entryBuilder.startBooleanToggle(
                        makeDyedEntryText("enable_dyed_lanterns"),
                        dyedSubcategory.getEntry("enable_dyed_lanterns")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_dyed_lanterns", newValue))
                .requireRestart().build();
        BooleanListEntry enableDyedTorches = entryBuilder.startBooleanToggle(
                        makeDyedEntryText("enable_dyed_torches"),
                        dyedSubcategory.getEntry("enable_dyed_torches")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_dyed_torches", newValue))
                .requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("dyed"),
                List.of(enableDyedCampfires, enableDyedLanterns, enableDyedTorches)).build());

        BooleanListEntry enableAllayPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_allay_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_allay_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_allay_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableBatPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_bat_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_bat_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bat_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableCamelPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_camel_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_camel_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_camel_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableCatPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_cat_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_cat_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cat_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableChickenPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_chicken_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_chicken_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_chicken_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableCowPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_cow_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_cow_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cow_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableHorsePlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_horse_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_horse_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_horse_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableMooshroomPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_mooshroom_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_mooshroom_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mooshroom_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableOcelotPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_ocelot_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_ocelot_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ocelot_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enablePigPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_pig_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_pig_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pig_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enablePufferfishPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_pufferfish_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_pufferfish_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pufferfish_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableRabbitPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_rabbit_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_rabbit_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_rabbit_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableSheepPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_sheep_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_sheep_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sheep_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableSquidPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_squid_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_squid_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_squid_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableStriderPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_strider_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_strider_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_strider_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableVillagerPlushies = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_villager_plushies"),
                        passivePlushiesSubcategory.getEntry("enable_villager_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_villager_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableWanderingTraderPlush = entryBuilder.startBooleanToggle(
                makePassivePlushiesEntryText("enable_wandering_trader_plushie"),
                        passivePlushiesSubcategory.getEntry("enable_wandering_trader_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wandering_trader_plushie", newValue))
                .requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("passive_plushies"),
                List.of(enableAllayPlush, enableBatPlush, enableCamelPlush, enableCatPlushies, enableChickenPlush,
                        enableCowPlush, enableHorsePlushies, enableMooshroomPlushies, enableOcelotPlush,
                        enablePigPlush, enablePufferfishPlush, enableRabbitPlush, enableSheepPlush,
                        enableSquidPlushies, enableStriderPlushies, enableVillagerPlushies,
                        enableWanderingTraderPlush)).build());

        BooleanListEntry enableBeePlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_bee_plushie"),
                        neutralPlushiesSubcategory.getEntry("enable_bee_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bee_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableCaveSpiderPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_cave_spider_plushie"),
                        neutralPlushiesSubcategory.getEntry("enable_cave_spider_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cave_spider_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableEndermanPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_enderman_plushie"),
                        neutralPlushiesSubcategory.getEntry("enable_enderman_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_enderman_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enablePiglinPlushies = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_piglin_plushies"),
                        neutralPlushiesSubcategory.getEntry("enable_piglin_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_piglin_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enablePolarBearPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_polar_bear_plushie"),
                        neutralPlushiesSubcategory.getEntry("enable_polar_bear_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_polar_bear_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableSpiderPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_spider_plushie"),
                        neutralPlushiesSubcategory.getEntry("enable_spider_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_spider_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enablePaleWolfPlush = entryBuilder.startBooleanToggle(
                makeNeutralPlushiesEntryText("enable_pale_wolf_plushie"),
                        neutralPlushiesSubcategory.getEntry("enable_pale_wolf_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pale_wolf_plushie", newValue))
                .requireRestart().build();

        buildingScreenCategory.addEntry(entryBuilder.startSubCategory(
                makeBuildingSubcategoryText("neutral_plushies"),
                List.of(enableBeePlush, enableCaveSpiderPlush, enableEndermanPlush, enablePiglinPlushies,
                        enablePolarBearPlush, enableSpiderPlush, enablePaleWolfPlush)).build());

        BooleanListEntry enableBlazePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_blaze_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_blaze_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blaze_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableCreeperPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_creeper_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_creeper_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_creeper_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableGhastPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_ghast_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_ghast_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ghast_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableGuardianPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_guardian_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_guardian_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_guardian_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableHoglinPlushies = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_hoglin_plushies"),
                        hostilePlushiesSubcategory.getEntry("enable_hoglin_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_hoglin_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableIllagerPlushies = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_illager_plushies"),
                        hostilePlushiesSubcategory.getEntry("enable_illager_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_illager_plushies", newValue))
                .requireRestart().build();
        BooleanListEntry enableMagmaCubePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_magma_cube_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_magma_cube_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_magma_cube_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enablePhantomPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_phantom_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_phantom_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_phantom_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableRavagerPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_ravager_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_ravager_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ravager_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableShulkerPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_shulker_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_shulker_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_shulker_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableSkeletonPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_skeleton_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_skeleton_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_skeleton_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableSlimePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_slime_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_slime_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_slime_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableVexPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_vex_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_vex_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_vex_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableWitchPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_witch_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_witch_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_witch_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableWitherPlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_wither_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_wither_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wither_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableZombiePlush = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_zombie_plushie"),
                        hostilePlushiesSubcategory.getEntry("enable_zombie_plushie")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_plushie", newValue))
                .requireRestart().build();
        BooleanListEntry enableZombieVillagerPlushies = entryBuilder.startBooleanToggle(
                makeHostilePlushiesEntryText("enable_zombie_villager_plushies"),
                        hostilePlushiesSubcategory.getEntry("enable_zombie_villager_plushies")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_villager_plushies", newValue))
                .requireRestart().build();

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
                        buildingCategory.getEntry("enable_wooden_walls")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wooden_walls", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_stripped_wooden_walls"),
                        buildingCategory.getEntry("enable_stripped_wooden_walls")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_stripped_wooden_walls", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_wooden_rope_ladders"),
                        buildingCategory.getEntry("enable_wooden_rope_ladders")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wooden_rope_ladders", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_iron_ladders"),
                        buildingCategory.getEntry("enable_iron_ladders")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_iron_ladders", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_blackstone"),
                        buildingCategory.getEntry("enable_twisted_blackstone")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_blackstone", newValue))
                .requireRestart().build());

        Text requiresBlackstoneTilesText = Text.literal("Requires blackstone tiles");
        BooleanListEntry enableBlackstoneTiles = entryBuilder.startBooleanToggle(
                makeBuildingEntryText("enable_blackstone_tiles"),
                        buildingCategory.getEntry("enable_blackstone_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blackstone_tiles", newValue))
                .requireRestart().build();

        buildingScreenCategory.addEntry(enableBlackstoneTiles);
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_blackstone_tiles"),
                        buildingCategory.getEntry("enable_twisted_blackstone_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_blackstone_tiles", newValue))
                .setRequirement(Requirement.isTrue(enableBlackstoneTiles))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableBlackstoneTiles),
                        requiresBlackstoneTilesText))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_blackstone_tiles"),
                        buildingCategory.getEntry("enable_weeping_blackstone_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_blackstone_tiles", newValue))
                .setRequirement(Requirement.isTrue(enableBlackstoneTiles))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableBlackstoneTiles),
                        requiresBlackstoneTilesText))
                .requireRestart().build());

        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_netherrack"),
                        buildingCategory.getEntry("enable_twisted_netherrack")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_netherrack", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_nether_bricks"),
                        buildingCategory.getEntry("enable_twisted_nether_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_nether_bricks", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_twisted_polished_blackstone_bricks"),
                        buildingCategory.getEntry("enable_twisted_polished_blackstone_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_twisted_polished_blackstone_bricks", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_netherrack"),
                        buildingCategory.getEntry("enable_weeping_netherrack")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_netherrack", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_nether_bricks"),
                        buildingCategory.getEntry("enable_weeping_nether_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_nether_bricks", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_blackstone"),
                        buildingCategory.getEntry("enable_weeping_blackstone")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_blackstone", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_weeping_polished_blackstone_bricks"),
                        buildingCategory.getEntry("enable_weeping_polished_blackstone_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_weeping_polished_blackstone_bricks", newValue))
                .requireRestart().build());

        Text requiresSmokyQuartzBlocksText = Text.literal("Requires smoky quartz blocks");
        BooleanListEntry enableSmokyQuartzBlocks = entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_smoky_quartz_blocks"),
                        buildingCategory.getEntry("enable_smoky_quartz_blocks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_smoky_quartz_blocks", newValue))
                .requireRestart().build();

        buildingScreenCategory.addEntry(enableSmokyQuartzBlocks);
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_smoky_quartz_bricks"),
                        buildingCategory.getEntry("enable_smoky_quartz_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_smoky_quartz_bricks", newValue))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableSmokyQuartzBlocks),
                        requiresSmokyQuartzBlocksText))
                .requireRestart().setRequirement(Requirement.isTrue(enableSmokyQuartzBlocks)).build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_smooth_smoky_quartz"),
                        buildingCategory.getEntry("enable_smooth_smoky_quartz")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_smooth_smoky_quartz", newValue))
                .setTooltipSupplier(() -> makeOptionalToolTip(Requirement.isFalse(enableSmokyQuartzBlocks),
                        requiresSmokyQuartzBlocksText))
                .requireRestart().setRequirement(Requirement.isTrue(enableSmokyQuartzBlocks)).build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_quartz_tiles"),
                        buildingCategory.getEntry("enable_quartz_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_quartz_tiles", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_quartz_walls"),
                        buildingCategory.getEntry("enable_quartz_walls")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_quartz_walls", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_bauxite"),
                        buildingCategory.getEntry("enable_bauxite")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bauxite", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_bauxite_bricks"),
                        buildingCategory.getEntry("enable_bauxite_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bauxite_bricks", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_cracked_bauxite_bricks"),
                        buildingCategory.getEntry("enable_cracked_bauxite_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cracked_bauxite_bricks", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_mossy_bauxite_bricks"),
                        buildingCategory.getEntry("enable_mossy_bauxite_bricks")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mossy_bauxite_bricks", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_stone_tiles"),
                        buildingCategory.getEntry("enable_stone_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_stone_tiles", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_cracked_stone_tiles"),
                        buildingCategory.getEntry("enable_cracked_stone_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cracked_stone_tiles", newValue))
                .requireRestart().build());
        buildingScreenCategory.addEntry(entryBuilder.startBooleanToggle(
                        makeBuildingEntryText("enable_mossy_stone_tiles"),
                        buildingCategory.getEntry("enable_mossy_stone_tiles")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mossy_stone_tiles", newValue))
                .requireRestart().build());

        // Farming config options
        ConfigCategory farming = builder.getOrCreateCategory(Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option.farming"));
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_wooden_planter_boxes"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_wooden_planter_boxes").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wooden_planter_boxes", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(makeFarmingOptionText("enable_green_onions"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_green_onions")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_green_onions", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(makeFarmingOptionText("enable_noodle_soup"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_noodle_soup").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_noodle_soup", newValue))
                .requireRestart().build());

        BooleanListEntry enableBlueberries = entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberries"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_blueberries").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberries", newValue))
                .requireRestart().build();
        farming.addEntry(enableBlueberries);

        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_pie"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_blueberry_pie").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberry_pie", newValue))
                .requireRestart().setRequirement(Requirement.isTrue(enableBlueberries)).build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_juice"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_blueberry_juice").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberry_juice", newValue))
                .requireRestart().setRequirement(Requirement.isTrue(enableBlueberries)).build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_sweet_berry_pie"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_sweet_berry_pie").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sweet_berry_pie", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_sweet_berry_juice"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_sweet_berry_juice").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sweet_berry_juice", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_chocolate_cake"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_chocolate_cake").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_chocolate_cake", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_red_velvet_cake"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_red_velvet_cake").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_red_velvet_cake", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_fried_egg"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_fried_egg").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_fried_egg", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_hoglin_stew"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_hoglin_stew").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_hoglin_stew", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_forests_bounty"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_forests_bounty").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_forests_bounty", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_witchs_cradle_soup"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_witchs_cradle_soup").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_witchs_cradle_soup", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_pudding"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_pudding").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pudding", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_caramel_apple"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_caramel_apple").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_caramel_apple", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_nether_berries"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_nether_berries").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_nether_berries", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_purple_mushrooms"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_purple_mushrooms").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_purple_mushrooms", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_cattails"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_cattails").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cattails", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_bog_blossoms"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_bog_blossoms").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bog_blossoms", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_blood_kelp"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_blood_kelp").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blood_kelp", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_ender_plants"),
                        ADConfig.CONFIG.getCategory("farming")
                                .getEntry("enable_ender_plants").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ender_plants", newValue))
                .requireRestart().build());

        // Misc config options
        ConfigCategory misc = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.misc"));
        misc.addEntry(entryBuilder.startBooleanToggle(
                        makeMiscOptionText("rabbits_safe_fall_increased"),
                        ADConfig.CONFIG.getCategory("misc")
                                .getEntry("rabbits_safe_fall_increased").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("rabbits_safe_fall_increased", newValue))
                .requireRestart().build());

        builder.setSavingRunnable(() -> {
            // When the config is saved make the changes to the categories and serialize to the config file.
            for(ADJsonConfigCategory category : ADConfig.CONFIG.getCategories()) {
                for(String entryName : entryValueChanges.keySet()) {
                    saveEntries(category, entryName, entryValueChanges);
                }
            }
            ADConfig.JANKSON_CONFIG_SERIALIZER.serializeConfig();
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

    private static void saveEntries(ADJsonConfigCategory category, String entryName,
                                    HashMap<String, Object> entryValueChanges) {
        if(category.hasEntry(entryName)) {
            category.getEntry(entryName).setValue(entryValueChanges.get(entryName));
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
