package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.ModConfigKeys;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;
import rndm_access.assorteddiscoveries.core.*;

import java.util.Optional;

public class AssortedDiscoveries implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("AssortedDiscoveries");
	private static final RegistryKey<ItemGroup> MOD_ITEM_GROUP_KEY = RegistryKey.of(
			RegistryKeys.ITEM_GROUP, ADReference.makeModId("item_group"));
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.ENDERMAN_PLUSHIE.asItem()))
            .displayName(Text.translatable("itemGroup." + ADReference.MOD_ID))
            .build();

	@Override
	public void onInitialize() {
        // Config
        JsonConfig config = ModConfig.createOrInitConfig();
        ModResourceConditionTypes.register();

		// General Registries
		ModBlocks.register();
		ModItems.register();
        AssortedDiscoveries.addItemGroups(config);
		ModBlockEntityTypes.register();
		ModParticleTypes.register();
		ModSoundEvents.register();
		AssortedDiscoveries.registerFuel();
		AssortedDiscoveries.registerCompostables();
		AssortedDiscoveries.modifyLootTables(config);
        AssortedDiscoveries.registerVillagerInteractions();

		// World Generation Registries
		ModFeatures.register();
		AssortedDiscoveries.addFeaturesToBiomes(config);
	}

    private static void registerVillagerInteractions() {
        VillagerInteractionRegistries.registerCompostable(ModItems.GREEN_ONION);
        VillagerInteractionRegistries.registerFood(ModItems.GREEN_ONION, 1);
    }

	private static void addFeaturesToBiomes(JsonConfig config) {
        BooleanConfigEntry configEntry;

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CATTAILS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CATTAIL_MANGROVE_SWAMP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_MANGROVE_SWAMP);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CATTAIL_RIVER),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_RIVER);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_SMOKY_QUARTZ),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_SMOKY_QUARTZ);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_HUGE_PURPLE_MUSHROOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_HUGE_PURPLE_MUSHROOM);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLUEBERRIES);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ENDER_PLANTS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_ENDER_PLANTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_ENDER_PLANTS);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLOOD_KELP);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.BLOOD_KELP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.BLOOD_KELP);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.BOG_BLOSSOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.BOG_BLOSSOM);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAUXITE);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_LOWER);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_UPPER);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_NETHER_BERRIES);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_RARE);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GREEN_ONIONS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_RARE);
        }
	}

	private static void registerFuel() {
        FuelRegistryEvents.BUILD.register((builder, context) ->
                builder.add(ModBlocks.DRIED_BLOOD_KELP_BLOCK, 4000));
	}

	private static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CINDERSNAP_BERRIES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.FROSTBITE_BERRIES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.WITCHS_CRADLE_BRANCH, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOD_KELP_SEED_CLUSTER, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOD_KELP, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.DRIED_BLOOD_KELP_BLOCK, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.SNAPDRAGON, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.SHORT_ENDER_GRASS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PURPLE_MUSHROOM_BLOCK, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PURPLE_MUSHROOM, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.CATTAIL, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION_SEEDS, 0.3F);
	}

	private static void modifyLootTables(JsonConfig config) {
		Optional<RegistryKey<LootTable>> spruceLeavesLootTableId = Blocks.SPRUCE_LEAVES.getLootTableKey();
        BooleanConfigEntry configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY);

        if (configEntry.getValue()) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source,
                                             registries) -> {
                if(source.isBuiltin() && spruceLeavesLootTableId.isPresent()
                        && spruceLeavesLootTableId.get().equals(key)) {
                    Optional<RegistryEntry.Reference<Enchantment>> optionalFortuneEffect
                            = registries.getOptionalEntry(Enchantments.FORTUNE);
                    assert optionalFortuneEffect.isPresent();
                    RegistryEntry<Enchantment> fortuneEffect = RegistryEntry.of(optionalFortuneEffect.get().value());

                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(TableBonusLootCondition.builder(fortuneEffect, 0.02F, 0.023F,
                                    0.025F, 0.035F, 0.1F))
                            .with(ItemEntry.builder(ModItems.SPRUCE_CONE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)));

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
	}

	private static void addItemGroups(JsonConfig config) {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register((entries) -> {
            BooleanConfigEntry configEntry;

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SLIME_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SLIME_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.MAGMA_CUBE_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_OCELOT_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.OCELOT_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CAT_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WHITE_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.TABBY_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.TUXEDO_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.RED_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.SIAMESE_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.BRITISH_SHORTHAIR_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.CALICO_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.PERSIAN_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.RAGDOLL_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_CAT_PLUSHIE.asItem());
                entries.add(ModBlocks.JELLIE_CAT_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PALE_WOLF_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.ZOMBIE_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SKELETON_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SKELETON_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.ENDERMAN_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CREEPER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CREEPER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SPIDER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SPIDER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CAVE_SPIDER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.GUARDIAN_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PHANTOM_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PHANTOM_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAT_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.BAT_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SQUID_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SQUID_PLUSHIE.asItem());
                entries.add(ModBlocks.GLOW_SQUID_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BEE_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.BEE_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PIGLIN_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PIGLIN_PLUSHIE.asItem());
                entries.add(ModBlocks.ZOMBIFIED_PIGLIN_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_HOGLIN_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.HOGLIN_PLUSHIE.asItem());
                entries.add(ModBlocks.ZOGLIN_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GHAST_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.GHAST_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLAZE_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.BLAZE_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STRIDER_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.STRIDER_PLUSHIE.asItem());
                entries.add(ModBlocks.SHIVERING_STRIDER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CHICKEN_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CHICKEN_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PIG_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PIG_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_COW_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.COW_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.RED_MOOSHROOM_PLUSHIE.asItem());
                entries.add(ModBlocks.BROWN_MOOSHROOM_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SHEEP_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WHITE_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.ORANGE_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.MAGENTA_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.LIGHT_BLUE_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.YELLOW_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.LIME_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.PINK_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.GRAY_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.LIGHT_GRAY_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.CYAN_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.PURPLE_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.BLUE_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.BROWN_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.RED_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.GREEN_SHEEP_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_SHEEP_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_HORSE_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WHITE_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.GRAY_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.LIGHT_GRAY_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.BROWN_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_HORSE_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_RABBIT_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.BROWN_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.WHITE_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.WHITE_SPLOTCHED_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.GOLD_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.TOAST_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.SALT_RABBIT_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ILLAGER_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.VINDICATOR_PLUSHIE.asItem());
                entries.add(ModBlocks.EVOKER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_VILLAGER_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PLAINS_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.DESERT_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.JUNGLE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SAVANNA_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SNOW_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SWAMP_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.TAIGA_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.WANDERING_TRADER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PLAINS_ZOMBIE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.DESERT_ZOMBIE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.JUNGLE_ZOMBIE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SAVANNA_ZOMBIE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SNOW_ZOMBIE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SWAMP_ZOMBIE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.TAIGA_ZOMBIE_VILLAGER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WITCH_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WITCH_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PUFFERFISH_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WITHER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WITHER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.POLAR_BEAR_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ALLAY_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.ALLAY_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_VEX_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.VEX_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_RAVAGER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.RAVAGER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SHULKER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SHULKER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CAMEL_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CAMEL_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CREAKING_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CREAKING_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SNIFFER_PLUSHIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SNIFFER_PLUSHIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config
                    .getEntry(ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.OAK_PLANTER_BOX.asItem());
                entries.add(ModBlocks.SPRUCE_PLANTER_BOX.asItem());
                entries.add(ModBlocks.BIRCH_PLANTER_BOX.asItem());
                entries.add(ModBlocks.JUNGLE_PLANTER_BOX.asItem());
                entries.add(ModBlocks.ACACIA_PLANTER_BOX.asItem());
                entries.add(ModBlocks.DARK_OAK_PLANTER_BOX.asItem());
                entries.add(ModBlocks.MANGROVE_PLANTER_BOX.asItem());
                entries.add(ModBlocks.CHERRY_PLANTER_BOX.asItem());
                entries.add(ModBlocks.BAMBOO_PLANTER_BOX.asItem());
                entries.add(ModBlocks.PALE_OAK_PLANTER_BOX.asItem());
                entries.add(ModBlocks.CRIMSON_PLANTER_BOX.asItem());
                entries.add(ModBlocks.WARPED_PLANTER_BOX.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WOODEN_WALLS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.OAK_WALL.asItem());
                entries.add(ModBlocks.SPRUCE_WALL.asItem());
                entries.add(ModBlocks.BIRCH_WALL.asItem());
                entries.add(ModBlocks.JUNGLE_WALL.asItem());
                entries.add(ModBlocks.ACACIA_WALL.asItem());
                entries.add(ModBlocks.DARK_OAK_WALL.asItem());
                entries.add(ModBlocks.MANGROVE_WALL.asItem());
                entries.add(ModBlocks.CHERRY_WALL.asItem());
                entries.add(ModBlocks.CRIMSON_WALL.asItem());
                entries.add(ModBlocks.WARPED_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.STRIPPED_OAK_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_SPRUCE_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_BIRCH_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_JUNGLE_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_ACACIA_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_DARK_OAK_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_MANGROVE_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_CHERRY_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_CRIMSON_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_WARPED_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.OAK_ROPE_LADDER.asItem());
                entries.add(ModBlocks.SPRUCE_ROPE_LADDER.asItem());
                entries.add(ModBlocks.BIRCH_ROPE_LADDER.asItem());
                entries.add(ModBlocks.JUNGLE_ROPE_LADDER.asItem());
                entries.add(ModBlocks.ACACIA_ROPE_LADDER.asItem());
                entries.add(ModBlocks.DARK_OAK_ROPE_LADDER.asItem());
                entries.add(ModBlocks.MANGROVE_ROPE_LADDER.asItem());
                entries.add(ModBlocks.CHERRY_ROPE_LADDER.asItem());
                entries.add(ModBlocks.PALE_OAK_ROPE_LADDER.asItem());
                entries.add(ModBlocks.CRIMSON_ROPE_LADDER.asItem());
                entries.add(ModBlocks.WARPED_ROPE_LADDER.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_IRON_LADDERS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.IRON_LADDER.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DYED_CAMPFIRES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WHITE_CAMPFIRE.asItem());
                entries.add(ModBlocks.ORANGE_CAMPFIRE.asItem());
                entries.add(ModBlocks.MAGENTA_CAMPFIRE.asItem());
                entries.add(ModBlocks.LIGHT_BLUE_CAMPFIRE.asItem());
                entries.add(ModBlocks.YELLOW_CAMPFIRE.asItem());
                entries.add(ModBlocks.LIME_CAMPFIRE.asItem());
                entries.add(ModBlocks.PINK_CAMPFIRE.asItem());
                entries.add(ModBlocks.GRAY_CAMPFIRE.asItem());
                entries.add(ModBlocks.LIGHT_GRAY_CAMPFIRE.asItem());
                entries.add(ModBlocks.CYAN_CAMPFIRE.asItem());
                entries.add(ModBlocks.PURPLE_CAMPFIRE.asItem());
                entries.add(ModBlocks.BLUE_CAMPFIRE.asItem());
                entries.add(ModBlocks.BROWN_CAMPFIRE.asItem());
                entries.add(ModBlocks.GREEN_CAMPFIRE.asItem());
                entries.add(ModBlocks.RED_CAMPFIRE.asItem());
                entries.add(ModBlocks.BLACK_CAMPFIRE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DYED_LANTERNS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WHITE_LANTERN.asItem());
                entries.add(ModBlocks.ORANGE_LANTERN.asItem());
                entries.add(ModBlocks.MAGENTA_LANTERN.asItem());
                entries.add(ModBlocks.LIGHT_BLUE_LANTERN.asItem());
                entries.add(ModBlocks.YELLOW_LANTERN.asItem());
                entries.add(ModBlocks.LIME_LANTERN.asItem());
                entries.add(ModBlocks.PINK_LANTERN.asItem());
                entries.add(ModBlocks.GRAY_LANTERN.asItem());
                entries.add(ModBlocks.LIGHT_GRAY_LANTERN.asItem());
                entries.add(ModBlocks.CYAN_LANTERN.asItem());
                entries.add(ModBlocks.PURPLE_LANTERN.asItem());
                entries.add(ModBlocks.BLUE_LANTERN.asItem());
                entries.add(ModBlocks.BROWN_LANTERN.asItem());
                entries.add(ModBlocks.GREEN_LANTERN.asItem());
                entries.add(ModBlocks.RED_LANTERN.asItem());
                entries.add(ModBlocks.BLACK_LANTERN.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DYED_TORCHES);
            if (configEntry.getValue()) {
                entries.add(ModItems.WHITE_TORCH);
                entries.add(ModItems.ORANGE_TORCH);
                entries.add(ModItems.MAGENTA_TORCH);
                entries.add(ModItems.LIGHT_BLUE_TORCH);
                entries.add(ModItems.YELLOW_TORCH);
                entries.add(ModItems.LIME_TORCH);
                entries.add(ModItems.PINK_TORCH);
                entries.add(ModItems.GRAY_TORCH);
                entries.add(ModItems.LIGHT_GRAY_TORCH);
                entries.add(ModItems.CYAN_TORCH);
                entries.add(ModItems.PURPLE_TORCH);
                entries.add(ModItems.BLUE_TORCH);
                entries.add(ModItems.BROWN_TORCH);
                entries.add(ModItems.GREEN_TORCH);
                entries.add(ModItems.RED_TORCH);
                entries.add(ModItems.BLACK_TORCH);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_NETHERRACK);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.TWISTED_NETHERRACK.asItem());
                entries.add(ModBlocks.TWISTED_NETHERRACK_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_NETHERRACK_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_NETHERRACK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_NETHERRACK);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WEEPING_NETHERRACK.asItem());
                entries.add(ModBlocks.WEEPING_NETHERRACK_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_NETHERRACK_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_NETHERRACK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.TWISTED_NETHER_BRICKS.asItem());
                entries.add(ModBlocks.TWISTED_NETHER_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_NETHER_BRICK_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_NETHER_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WEEPING_NETHER_BRICKS.asItem());
                entries.add(ModBlocks.WEEPING_NETHER_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_NETHER_BRICK_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_NETHER_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.TWISTED_BLACKSTONE.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WEEPING_BLACKSTONE.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry)
                    config.getEntry(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICKS.asItem());
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry)
                    config.getEntry(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.asItem());
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLACKSTONE_TILES);
            boolean blackstoneTilesEnabled = configEntry.getValue();
            if (blackstoneTilesEnabled) {
                entries.add(ModBlocks.BLACKSTONE_TILES.asItem());
                entries.add(ModBlocks.BLACKSTONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.BLACKSTONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.BLACKSTONE_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES);
            if (blackstoneTilesEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILES.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES);
            if (blackstoneTilesEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILES.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
            boolean smokyQuartzBlocksEnabled = configEntry.getValue();
            if (smokyQuartzBlocksEnabled) {
                entries.add(ModBlocks.NETHER_SMOKY_QUARTZ_ORE.asItem());
                entries.add(ModItems.SMOKY_QUARTZ);
                entries.add(ModBlocks.SMOKY_QUARTZ_BLOCK.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_STAIRS.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_SLAB.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_WALL.asItem());
                entries.add(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_PILLAR.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS);
            if (smokyQuartzBlocksEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICKS.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICK_SLAB.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ);
            if (smokyQuartzBlocksEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ.asItem());
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.asItem());
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.asItem());
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.QUARTZ_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.QUARTZ_BRICK_SLAB.asItem());
                entries.add(ModBlocks.QUARTZ_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_QUARTZ_TILES);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.QUARTZ_TILES.asItem());
                entries.add(ModBlocks.QUARTZ_TILE_STAIRS.asItem());
                entries.add(ModBlocks.QUARTZ_TILE_SLAB.asItem());
                entries.add(ModBlocks.QUARTZ_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_QUARTZ_WALLS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.QUARTZ_WALL.asItem());
                entries.add(ModBlocks.SMOOTH_QUARTZ_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAUXITE);
            boolean bauxiteEnabled = configEntry.getValue();
            if (bauxiteEnabled) {
                entries.add(ModBlocks.BAUXITE.asItem());
                entries.add(ModBlocks.BAUXITE_SLAB.asItem());
                entries.add(ModBlocks.BAUXITE_STAIRS.asItem());
                entries.add(ModBlocks.BAUXITE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAUXITE_BRICKS);
            boolean bauxiteBricksEnabled = configEntry.getValue();
            if (bauxiteEnabled && bauxiteBricksEnabled) {
                entries.add(ModBlocks.BAUXITE_BRICKS.asItem());
                entries.add(ModBlocks.BAUXITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.BAUXITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.BAUXITE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS);
            if (bauxiteEnabled && bauxiteBricksEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICKS.asItem());
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS);
            if (bauxiteEnabled && bauxiteBricksEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICKS.asItem());
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STONE_TILES);
            boolean stoneTilesEnabled = configEntry.getValue();
            if (stoneTilesEnabled) {
                entries.add(ModBlocks.STONE_TILES.asItem());
                entries.add(ModBlocks.STONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.STONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.STONE_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_STONE_TILES);
            if (stoneTilesEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.CRACKED_STONE_TILES.asItem());
                entries.add(ModBlocks.CRACKED_STONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_STONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_STONE_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_STONE_TILES);
            if (stoneTilesEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.MOSSY_STONE_TILES.asItem());
                entries.add(ModBlocks.MOSSY_STONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_STONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_STONE_TILE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CRACKED_STONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_STONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_STONE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STONE_WALLS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.STONE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CALCITE_BLOCKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CALCITE_STAIRS.asItem());
                entries.add(ModBlocks.CALCITE_SLAB.asItem());
                entries.add(ModBlocks.CALCITE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_POLISHED_CALCITE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.POLISHED_CALCITE.asItem());
                entries.add(ModBlocks.POLISHED_CALCITE_STAIRS.asItem());
                entries.add(ModBlocks.POLISHED_CALCITE_SLAB.asItem());
                entries.add(ModBlocks.POLISHED_CALCITE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CALCITE_BRICKS);
            boolean calciteBricksEnabled = configEntry.getValue();
            if (calciteBricksEnabled) {
                entries.add(ModBlocks.CALCITE_BRICKS.asItem());
                entries.add(ModBlocks.CALCITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CALCITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CALCITE_BRICK_WALL.asItem());
                entries.add(ModBlocks.CHISELED_CALCITE_BRICKS.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS);
            if (configEntry.getValue() && calciteBricksEnabled) {
                entries.add(ModBlocks.CRACKED_CALCITE_BRICKS.asItem());
                entries.add(ModBlocks.CRACKED_CALCITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_CALCITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_CALCITE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS);
            if (configEntry.getValue() && calciteBricksEnabled) {
                entries.add(ModBlocks.MOSSY_CALCITE_BRICKS.asItem());
                entries.add(ModBlocks.MOSSY_CALCITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_CALCITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_CALCITE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.DRIPSTONE_STAIRS.asItem());
                entries.add(ModBlocks.DRIPSTONE_SLAB.asItem());
                entries.add(ModBlocks.DRIPSTONE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.POLISHED_DRIPSTONE.asItem());
                entries.add(ModBlocks.POLISHED_DRIPSTONE_STAIRS.asItem());
                entries.add(ModBlocks.POLISHED_DRIPSTONE_SLAB.asItem());
                entries.add(ModBlocks.POLISHED_DRIPSTONE_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS);
            boolean dripstoneBricksEnabled = configEntry.getValue();
            if (dripstoneBricksEnabled) {
                entries.add(ModBlocks.DRIPSTONE_BRICKS.asItem());
                entries.add(ModBlocks.DRIPSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.DRIPSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.DRIPSTONE_BRICK_WALL.asItem());
                entries.add(ModBlocks.CHISELED_DRIPSTONE_BRICKS.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS);
            if (configEntry.getValue() && dripstoneBricksEnabled) {
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS.asItem());
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS);
            if (configEntry.getValue() && dripstoneBricksEnabled) {
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS.asItem());
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SNOW_BRICKS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SNOW_BRICKS.asItem());
                entries.add(ModBlocks.SNOW_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.SNOW_BRICK_SLAB.asItem());
                entries.add(ModBlocks.SNOW_BRICK_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PACKED_SNOW);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PACKED_SNOW.asItem());
                entries.add(ModBlocks.PACKED_SNOW_STAIRS.asItem());
                entries.add(ModBlocks.PACKED_SNOW_SLAB.asItem());
                entries.add(ModBlocks.PACKED_SNOW_WALL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DIRT_SLABS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.GRASS_SLAB.asItem());
                entries.add(ModBlocks.PODZOL_SLAB.asItem());
                entries.add(ModBlocks.MYCELIUM_SLAB.asItem());
                entries.add(ModBlocks.DIRT_PATH_SLAB.asItem());
                entries.add(ModBlocks.DIRT_SLAB.asItem());
                entries.add(ModBlocks.ROOTED_DIRT_SLAB.asItem());
                entries.add(ModBlocks.COARSE_DIRT_SLAB.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PURPLE_MUSHROOM_BLOCK.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CHOCOLATE_CAKE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CHOCOLATE_CAKE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_RED_VELVET_CAKE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.RED_VELVET_CAKE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SWEET_BERRY_PIE);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SWEET_BERRY_PIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLUEBERRIES);
            boolean blueberriesEnabled = configEntry.getValue();
            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLUEBERRY_PIE);
            if (blueberriesEnabled && configEntry.getValue()) {
                entries.add(ModBlocks.BLUEBERRY_PIE.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GREEN_ONIONS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.WILD_GREEN_ONIONS.asItem());
                entries.add(ModItems.GREEN_ONION_SEEDS);
                entries.add(ModItems.GREEN_ONION);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_NOODLE_SOUP);
            if (configEntry.getValue()) {
                entries.add(ModItems.NOODLES);
                entries.add(ModItems.NOODLE_SOUP);
            }

            if (blueberriesEnabled) {
                entries.add(ModItems.BLUEBERRIES);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_NETHER_BERRIES);
            if (configEntry.getValue()) {
                entries.add(ModItems.CINDERSNAP_BERRIES);
                entries.add(ModItems.FROSTBITE_BERRIES);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CATTAILS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.CATTAIL.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.BOG_BLOSSOM.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ENDER_PLANTS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.SNAPDRAGON.asItem());
                entries.add(ModBlocks.SHORT_ENDER_GRASS.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.PURPLE_MUSHROOM.asItem());
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CARAMEL_APPLE);
            if (configEntry.getValue()) {
                entries.add(ModItems.CARAMEL_APPLE);
                entries.add(ModItems.CARAMEL);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_FRIED_EGG);
            if (configEntry.getValue()) {
                entries.add(ModItems.FRIED_EGG);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLOOD_KELP);
            if (configEntry.getValue()) {
                entries.add(ModBlocks.DRIED_BLOOD_KELP_BLOCK);
                entries.add(ModBlocks.BLOOD_KELP_LANTERN);
                entries.add(ModItems.BLOOD_KELP_SEED_CLUSTER);
                entries.add(ModItems.BLOOD_KELP);
                entries.add(ModItems.DRIED_BLOOD_KELP);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_HOGLIN_STEW);
            if (configEntry.getValue()) {
                entries.add(ModItems.HOGLIN_STEW);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY);
            if (configEntry.getValue()) {
                entries.add(ModItems.FORESTS_BOUNTY);
                entries.add(ModItems.SPRUCE_CONE);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WITCHS_CRADLE_SOUP);
            if (configEntry.getValue()) {
                entries.add(ModItems.WITCHS_CRADLE_SOUP);
                entries.add(ModItems.WITCHS_CRADLE_BRANCH);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PUDDING);
            if (configEntry.getValue()) {
                entries.add(ModItems.BERRY_PUDDING);
                entries.add(ModItems.PUDDING);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLUEBERRY_JUICE);
            if (blueberriesEnabled && configEntry.getValue()) {
                entries.add(ModItems.BLUEBERRY_JUICE);
            }

            configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SWEET_BERRY_JUICE);
            if (configEntry.getValue()) {
                entries.add(ModItems.SWEET_BERRY_JUICE);
            }
        });
	}
}
