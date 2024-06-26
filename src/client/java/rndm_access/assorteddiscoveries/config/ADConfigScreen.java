package rndm_access.assorteddiscoveries.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.config.jankson.ADJsonConfigCategory;

import java.util.HashMap;

public class ADConfigScreen {

    public static ConfigBuilder getConfigScreenBuilder() {
        HashMap<String, Object> entryValueChanges = new HashMap<>();

        ConfigBuilder builder = ConfigBuilder.create()
                .setTitle(Text.translatable("title." + ADReference.MOD_ID + ".config"));
        builder.setDefaultBackgroundTexture(new Identifier("assorted-discoveries:textures/block/calcite_bricks.png"));
        builder.setGlobalized(true);
        builder.setGlobalizedExpanded(false);
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        // Passive plush config options
        ConfigCategory passivePlushies = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.passive_plushies"));
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_allay_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_allay_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_allay_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_bat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_bat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_camel_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_camel_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_camel_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_tabby_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_tabby_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_tabby_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_tuxedo_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_tuxedo_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_tuxedo_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_red_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_red_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_red_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_siamese_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_siamese_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_siamese_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_british_shorthair_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_british_shorthair_cat_plush").getValueAsBool())
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_british_shorthair_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_calico_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_calico_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_calico_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_persian_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_persian_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_persian_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_ragdoll_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_ragdoll_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ragdoll_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_white_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_white_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_white_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_black_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_black_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_black_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_jellie_cat_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_jellie_cat_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_jellie_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_chicken_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_chicken_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_chicken_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_cow_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_cow_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cow_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_horse_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_horse_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_horse_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_mooshroom_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_mooshroom_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mooshroom_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_ocelot_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_ocelot_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ocelot_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_pig_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_pig_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pig_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_pufferfish_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_pufferfish_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pufferfish_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_rabbit_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_rabbit_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_rabbit_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_sheep_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_sheep_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sheep_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_squid_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_squid_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_squid_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_strider_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_strider_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_strider_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_villager_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_villager_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_villager_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_wandering_trader_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("passive_plushies")
                                .getEntry("enable_wandering_trader_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wandering_trader_plush", newValue))
                .requireRestart().build());

        // Neutral plush config options
        ConfigCategory neutralPlushies = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.neutral_plushies"));
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_bee_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_bee_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bee_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_cave_spider_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_cave_spider_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cave_spider_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_enderman_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_enderman_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_enderman_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_piglin_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_piglin_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_piglin_plushies", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_polar_bear_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_polar_bear_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_polar_bear_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_spider_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_spider_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_spider_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_pale_wolf_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("neutral_plushies")
                                .getEntry("enable_pale_wolf_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pale_wolf_plush", newValue))
                .requireRestart().build());

        // Hostile plush config options
        ConfigCategory hostilePlushies = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.hostile_plushies"));
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_blaze_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_blaze_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blaze_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_creeper_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_creeper_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_creeper_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_ghast_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_ghast_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ghast_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_guardian_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_guardian_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_guardian_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_hoglin_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_hoglin_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_hoglin_plushies", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_illager_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_illager_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_illager_plushies", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_magma_cube_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_magma_cube_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_magma_cube_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_phantom_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_phantom_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_phantom_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_ravager_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_ravager_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ravager_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_shulker_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_shulker_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_shulker_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_skeleton_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_skeleton_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_skeleton_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_slime_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_slime_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_slime_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_vex_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_vex_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_vex_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_witch_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_witch_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_witch_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_wither_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_wither_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wither_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_zombie_plush"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_zombie_plush").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeHostileMobOptionText("enable_zombie_villager_plushies"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("hostile_plushies")
                                .getEntry("enable_zombie_villager_plushies").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_villager_plushies", newValue))
                .requireRestart().build());

        // Farming config options
        ConfigCategory farming = builder.getOrCreateCategory(Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option.farming"));
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_overworld_planter_boxes"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_overworld_planter_boxes").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_overworld_planter_boxes", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_nether_planter_boxes"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_nether_planter_boxes").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_nether_planter_boxes", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_green_onions_and_wild_green_onions"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_green_onions_and_wild_green_onions")
                                .getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_green_onions_and_wild_green_onions",
                        newValue))
                .requireRestart().setTooltip(Text.literal("If disabled noodle soup does not use green onions."))
                .build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_noodles_and_noodle_soup"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_noodles_and_noodle_soup").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_noodles_and_noodle_soup", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_pie"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_blueberry_pie").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberry_pie", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                        makeFarmingOptionText("enable_blueberry_juice"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_blueberry_juice").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blueberry_juice", newValue))
                .requireRestart().build());

        // Another category?
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_purple_mushrooms"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("enable_purple_mushrooms").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_purple_mushrooms", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startIntSlider(
                makeFarmingOptionText("mushroom_bounce_height"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("farming")
                                .getEntry("mushroom_bounce_height").getValueAsInt(), 15, 25)
                .setDefaultValue(15)
                .setSaveConsumer(newValue -> entryValueChanges.put("mushroom_bounce_height", newValue))
                .build());

        // Misc config options
        ConfigCategory misc = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.misc"));
        misc.addEntry(entryBuilder.startBooleanToggle(
                        makeMiscOptionText("rabbits_safe_fall_increased"),
                        ADConfig.JSON_CONFIG_CATEGORIES.get("misc")
                                .getEntry("rabbits_safe_fall_increased").getValueAsBool()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("rabbits_safe_fall_increased", newValue))
                .requireRestart().build());

        builder.setSavingRunnable(() -> {
            // When the config is saved make the changes to the categories and serialize to the config file.
            for(ADJsonConfigCategory category : ADConfig.JSON_CONFIG_CATEGORIES.values()) {
                for(String entryName : entryValueChanges.keySet()) {
                    if(category.hasEntry(entryName)) {
                        category.getEntry(entryName).setValue(entryValueChanges.get(entryName));
                    }
                }
            }
            ADConfig.JANKSON_CONFIG_SERIALIZER.serializeConfig();
        });
        return builder;
    }

    private static Text makePassiveMobOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.passive_plushies." + entryName);
    }

    private static Text makeNeutralMobOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.neutral_plushies." + entryName);
    }

    private static Text makeHostileMobOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.hostile_plushies." + entryName);
    }

    private static Text makeFarmingOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.farming." + entryName);
    }

    private static Text makeMiscOptionText(String entryName) {
        return Text.translatable("text.cloth-config." + ADReference.MOD_ID
                + ".option.misc." + entryName);
    }
}
