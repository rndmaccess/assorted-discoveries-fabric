package rndm_access.assorteddiscoveries.config;

import me.shedaniel.autoconfig.util.Utils;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonPrimitive;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.api.SyntaxError;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import rndm_access.assorteddiscoveries.ADReference;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ADConfig {
    private static final Path CONFIG_PATH;
    public static LinkedHashMap<String, ADConfigCategory> defaultConfigCategories;
    public static LinkedHashMap<String, ADConfigCategory> configCategories;

    private static boolean rabbitsSafeFallIncreased = true;

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
                (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_allay_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_allay_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_bat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_bat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_camel_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_camel_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_camel_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_tabby_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_tabby_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_tabby_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_tuxedo_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_tuxedo_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_tuxedo_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_red_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_red_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_red_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_siamese_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_siamese_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_siamese_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_british_shorthair_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_british_shorthair_cat_plush").getValue())
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_british_shorthair_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_calico_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_calico_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_calico_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_persian_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_persian_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_persian_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_ragdoll_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_ragdoll_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ragdoll_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_white_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_white_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_white_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_black_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_black_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_black_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_jellie_cat_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_jellie_cat_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_jellie_cat_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_chicken_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_chicken_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_chicken_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_cow_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_cow_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cow_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_horse_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_horse_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_horse_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_mooshroom_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_mooshroom_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_mooshroom_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_ocelot_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_ocelot_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ocelot_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_pig_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_pig_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pig_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_pufferfish_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_pufferfish_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pufferfish_plush", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_rabbit_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_rabbit_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_rabbit_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_sheep_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_sheep_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_sheep_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                        makePassiveMobOptionText("enable_squid_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_squid_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_squid_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_strider_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_strider_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_strider_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_villager_plushies"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_villager_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_villager_plushies", newValue))
                .requireRestart().build());
        passivePlushies.addEntry(entryBuilder.startBooleanToggle(
                makePassiveMobOptionText("enable_wandering_trader_plush"),
                        (Boolean) configCategories.get("passive_plushies")
                                .getEntry("enable_wandering_trader_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wandering_trader_plush", newValue))
                .requireRestart().build());

        // Neutral plush config options
        ConfigCategory neutralPlushies = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.neutral_plushies"));
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                makeNeutralMobOptionText("enable_bee_plush"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_bee_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_bee_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                        makeNeutralMobOptionText("enable_cave_spider_plush"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_cave_spider_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_cave_spider_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                makeNeutralMobOptionText("enable_enderman_plush"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_enderman_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_enderman_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                makeNeutralMobOptionText("enable_piglin_plushies"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_piglin_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_piglin_plushies", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                makeNeutralMobOptionText("enable_polar_bear_plush"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_polar_bear_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_polar_bear_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                makeNeutralMobOptionText("enable_spider_plush"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_spider_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_spider_plush", newValue))
                .requireRestart().build());
        neutralPlushies.addEntry(entryBuilder.startBooleanToggle(
                makeNeutralMobOptionText("enable_pale_wolf_plush"),
                        (Boolean) configCategories.get("neutral_plushies")
                                .getEntry("enable_pale_wolf_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_pale_wolf_plush", newValue))
                .requireRestart().build());

        // Hostile plush config options
        ConfigCategory hostilePlushies = builder.getOrCreateCategory(Text.translatable("category.cloth-config."
                + ADReference.MOD_ID + ".option.hostile_plushies"));
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_blaze_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_blaze_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_blaze_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_creeper_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_creeper_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_creeper_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_ghast_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_ghast_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ghast_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_guardian_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_guardian_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_guardian_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_hoglin_plushies"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_hoglin_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_hoglin_plushies", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_illager_plushies"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_illager_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_illager_plushies", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_magma_cube_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_magma_cube_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_magma_cube_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_phantom_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_phantom_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_phantom_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_ravager_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_ravager_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_ravager_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_shulker_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_shulker_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_shulker_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_skeleton_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_skeleton_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_skeleton_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_slime_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_slime_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_slime_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_vex_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_vex_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_vex_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_witch_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_witch_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_witch_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_wither_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_wither_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_wither_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_zombie_plush"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_zombie_plush").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_plush", newValue))
                .requireRestart().build());
        hostilePlushies.addEntry(entryBuilder.startBooleanToggle(
                makeHostileMobOptionText("enable_zombie_villager_plushies"),
                        (Boolean) configCategories.get("hostile_plushies")
                                .getEntry("enable_zombie_villager_plushies").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_zombie_villager_plushies", newValue))
                .requireRestart().build());

        // Farming config options
        ConfigCategory farming = builder.getOrCreateCategory(Text.translatable("category.cloth-config." + ADReference.MOD_ID
                + ".option.farming"));
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_overworld_planter_boxes"),
                        (Boolean) configCategories.get("farming")
                                .getEntry("enable_overworld_planter_boxes").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_overworld_planter_boxes", newValue))
                .requireRestart().build());
        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_nether_planter_boxes"),
                        (Boolean) configCategories.get("farming")
                                .getEntry("enable_nether_planter_boxes").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_nether_planter_boxes", newValue))
                .requireRestart().build());

        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_green_onions_and_wild_green_onions"),
                        (Boolean) configCategories.get("farming")
                                .getEntry("enable_green_onions_and_wild_green_onions")
                                .getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_green_onions_and_wild_green_onions",
                        newValue))
                .requireRestart().setTooltip(Text.literal("If disabled noodle soup does not use green onions."))
                .build());

        farming.addEntry(entryBuilder.startBooleanToggle(
                makeFarmingOptionText("enable_noodles_and_noodle_soup"),
                        (Boolean) configCategories.get("farming")
                                .getEntry("enable_noodles_and_noodle_soup").getValue()).setDefaultValue(true)
                .setSaveConsumer(newValue -> entryValueChanges.put("enable_noodles_and_noodle_soup", newValue))
                .requireRestart().build());

        // Misc config options
        ConfigCategory misc = builder.getOrCreateCategory(Text.translatable("category." + ADReference.MOD_ID
                + ".misc"));
        misc.addEntry(entryBuilder.startBooleanToggle(
                makeMiscOptionText("rabbits_safe_fall_increased"), rabbitsSafeFallIncreased)
                .setDefaultValue(true).setSaveConsumer(newValue -> rabbitsSafeFallIncreased = newValue)
                .requireRestart().build());
        builder.setSavingRunnable(() -> {
            if(!Files.exists(CONFIG_PATH)) {
                try {
                    Files.createFile(CONFIG_PATH);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            // When the config is saved make the changes to the categories and save it to the config file.
            for(ADConfigCategory category : configCategories.values()) {
                for(String entryName : entryValueChanges.keySet()) {
                    if(category.hasEntry(entryName)) {
                        category.getEntry(entryName).setValue(entryValueChanges.get(entryName));
                    }
                }
            }
            saveConfig();
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

    public static void loadConfig() {
        Jankson jankson = Jankson.builder().build();

        if (Files.exists(CONFIG_PATH)) {
            try {
                JsonObject jsonFile = jankson.load(Files.readString(CONFIG_PATH));
                String json = jsonFile.toJson(true, false);
                parseJson(json);
                addMissingCategoriesOrEntries();

                // Re-save the config to fix anything that may be missing or incorrect.
                saveConfig();
            } catch (SyntaxError | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            configCategories = new LinkedHashMap<>(defaultConfigCategories);
            saveConfig();
        }
    }

    private static void saveConfig() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH);
            JsonObject outerJsonObject = new JsonObject();

            for (ADConfigCategory category : configCategories.values()) {
                JsonObject innerJsonObject = new JsonObject();

                for(String name : category.getEntryNames()) {
                    if(category.getEntry(name).getComment() != null) {
                        innerJsonObject.put(name, new JsonPrimitive(category.getEntry(name).getValue()),
                                category.getEntry(name).getComment());
                    } else {
                        innerJsonObject.put(name, new JsonPrimitive(category.getEntry(name).getValue()));
                    }
                }
                outerJsonObject.put(category.getName(), innerJsonObject);
            }

            try {
                writer.write(outerJsonObject.toJson(true, true));
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerCategory(ADConfigCategory category) {
        if(!defaultConfigCategories.containsKey(category.getName())) {
            defaultConfigCategories.put(category.getName(), category);
        } else {
            throw new RuntimeException("The category " + category.getName() + " is already registered!");
        }
    }

    public static LinkedHashMap<String, ADConfigCategory> getConfigCategories() {
        return configCategories;
    }

    // Load and save helper methods:

    public static void parseJson(String json) {
        json = clearSpaces(json);
        for(int i = 0; i < json.length() - 1; i++) {
            StringBuilder categoryBuilder = new StringBuilder();

            // Read the category
            while(json.charAt(i) != ':') {
                if(json.charAt(i) != '{' && json.charAt(i) != ','
                        && json.charAt(i) != '"') {
                    categoryBuilder.append(json.charAt(i));
                }
                i++;
            }
            i += 2;

            ADConfigCategory category = new ADConfigCategory(categoryBuilder.toString());

            // Make the entries
            while(json.charAt(i) != '}') {
                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder valueBuilder = new StringBuilder();
                StringBuilder commentBuilder = new StringBuilder();
                int subStrEnd = i + 2;

                // Parse the comment
                if(subStrEnd <= json.length()) {
                    String sub = json.substring(i, subStrEnd);

                    // Read the comment for the entry
                    if(sub.equals("/*")) {
                        while(!sub.equals("*/")) {
                            if(json.charAt(i) != '*' && json.charAt(i) != '/') {
                                commentBuilder.append(json.charAt(i));
                            }
                            i++;
                            subStrEnd = i + 2;
                            sub = json.substring(i, subStrEnd);
                        }
                        i += 2;
                    }
                }

                // Parse the entry name
                while (json.charAt(i) != ':') {
                    if(json.charAt(i) != '"' && json.charAt(i) != '{') {
                        nameBuilder.append(json.charAt(i));
                    }
                    i++;
                }
                i++;

                // Parse the entry value
                while (json.charAt(i) != ',' && json.charAt(i) != '}') {
                    valueBuilder.append(json.charAt(i));
                    i++;
                }

                ADConfigEntry entry = buildEntry(commentBuilder, nameBuilder, valueBuilder, category.getName());
                category.addEntry(entry);

                // If there is a comma at the end then skip it and move onto the next entry
                if(json.charAt(i) == ',') {
                    i++;
                }
            }
            configCategories.put(category.getName(), category);
        }
    }

    private static @NotNull ADConfigEntry buildEntry(StringBuilder commentBuilder, StringBuilder nameBuilder,
                                                     StringBuilder valueBuilder, String categoryName) {
        String comment = commentBuilder.toString().strip();
        String entryName = nameBuilder.toString();
        String entryValue = valueBuilder.toString();
        ADConfigEntry entry = new ADConfigEntry(entryName);
        ADConfigEntry defaultEntry = defaultConfigCategories.get(categoryName).getEntry(entryName);

        if(defaultEntry.getValue().getClass().equals(Boolean.class)) {
            // Fix boolean config options
            if(entryValue.equalsIgnoreCase("true") || entryValue.equalsIgnoreCase("false")) {
                entry.setValue(Boolean.valueOf(entryValue));
            } else {
                entry.setValue(defaultEntry.getValue());
            }
        }

        if(!comment.isEmpty()) {
            entry.setComment(comment);
        }
        return entry;
    }

    private static String clearSpaces(String json) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < json.length(); i++) {
            int subStrEnd = i + 2;

            if(subStrEnd <= json.length()) {
                i = skipCommentSpaces(json, subStrEnd, builder, i);
            }

            if(!Character.isWhitespace(json.charAt(i))) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }

    private static int skipCommentSpaces(String json, int subStrEnd, StringBuilder builder, int i) {
        String sub = json.substring(i, subStrEnd);

        if(sub.equals("/*")) {
            while (!sub.equals("*/")) {
                builder.append(json.charAt(i));
                i++;
                subStrEnd = i + 2;
                sub = json.substring(i, subStrEnd);
            }
            builder.append(sub);
            i += 2;
        }
        return i;
    }

    private static void addMissingCategoriesOrEntries() {
        for(ADConfigCategory category : defaultConfigCategories.values()) {
            if(!configCategories.containsKey(category.getName())) {
                configCategories.put(category.getName(), category);
                continue;
            }

            for(ADConfigEntry entry : category.getEntries()) {
                if(!configCategories.get(category.getName()).hasEntry(entry.getName())) {
                    configCategories.get(category.getName()).addEntry(entry);
                }
            }
        }
    }

    static {
        CONFIG_PATH = Utils.getConfigFolder().resolve(ADReference.MOD_ID + ".json5");
        configCategories = new LinkedHashMap<>();
        defaultConfigCategories = new LinkedHashMap<>();
    }
}
