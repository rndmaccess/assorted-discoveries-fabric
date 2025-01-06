package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.ModConfigKeys;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.core.ModResourceConditions;
import rndm_access.assorteddiscoveries.core.*;

public class AssortedDiscoveries implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("AssortedDiscoveries");
	private static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(
			RegistryKeys.ITEM_GROUP, ADReference.makeModId("item_group"));

	@Override
	public void onInitialize() {
        // Config
        JsonConfig config = ModConfig.createOrInitConfig();
        ModResourceConditions.registerResourceConditions(config);

		// General Registries
		ModBlocks.registerBlocks();
		ModItems.registerItems();
        AssortedDiscoveries.addItemGroups(config);
		ModBlockEntityTypes.registerBlockEntityTypes();
		ModParticleTypes.registerParticleTypes();
		ModScreenHandlerTypes.registerScreenHandlerTypes();
		ModRecipeTypes.registerRecipeTypes();
		ModRecipeSerializers.registerRecipeSerializers();
		ModPaintingVariants.registerPaintingVariants();
		ModSoundEvents.registerSoundEvents();
		AssortedDiscoveries.registerFuel();
		AssortedDiscoveries.registerCompostables();
		AssortedDiscoveries.modifyLootTables(config);

		// Entity Registries
		ModVillagerTypes.registerVillagerTypes();
		ModPointOfInterestTypes.registerPointOfInterestTypes();
		ModVillagerProfessions.registerVillagerProfessions();
		ModVillagerOffers.registerVillagerTradeOffers();

		// World Generation Registries
		ModFeatures.registerFeatures();
		AssortedDiscoveries.addFeaturesToBiomes(config);
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

        BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_LOWER);
		BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_UPPER);

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
        FuelRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP_BLOCK, 4000);
	}

	private static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CINDERSNAP_BERRIES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.FROSTBITE_BERRIES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.WITCHS_CRADLE_BRANCH, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOD_KELP_SEED_CLUSTER, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOD_KELP, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP_BLOCK, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SNAPDRAGON, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.SHORT_ENDER_GRASS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.PURPLE_MUSHROOM_BLOCK, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.PURPLE_MUSHROOM, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CATTAIL, 0.5F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION_SEEDS, 0.3F);
	}

	private static void modifyLootTables(JsonConfig config) {
		Identifier spruceLeavesLootTableId = Blocks.SPRUCE_LEAVES.getLootTableId();
        BooleanConfigEntry configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY);

        if (configEntry.getValue()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id,
                                             tableBuilder, source) -> {
                if(source.isBuiltin() && spruceLeavesLootTableId.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02F, 0.023F,
                                    0.025F, 0.035F, 0.1F))
                            .with(ItemEntry.builder(ModItems.SPRUCE_CONE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)));

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
	}

	private static void addItemGroups(JsonConfig config) {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup." + ADReference.MOD_ID + ".item_group"))
				.icon(() -> new ItemStack(ModItems.ENDERMAN_PLUSHIE))
				.entries((context, entries) -> {
                    BooleanConfigEntry configEntry;

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SLIME_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.SLIME_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.MAGMA_CUBE_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_OCELOT_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.OCELOT_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CAT_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.TABBY_CAT_PLUSHIE);
                        entries.add(ModItems.TUXEDO_CAT_PLUSHIE);
                        entries.add(ModItems.RED_CAT_PLUSHIE);
                        entries.add(ModItems.SIAMESE_CAT_PLUSHIE);
                        entries.add(ModItems.BRITISH_SHORTHAIR_CAT_PLUSHIE);
                        entries.add(ModItems.CALICO_CAT_PLUSHIE);
                        entries.add(ModItems.PERSIAN_CAT_PLUSHIE);
                        entries.add(ModItems.RAGDOLL_CAT_PLUSHIE);
                        entries.add(ModItems.BLACK_CAT_PLUSHIE);
                        entries.add(ModItems.JELLIE_CAT_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PALE_WOLF_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PALE_WOLF_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.ZOMBIE_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SKELETON_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.SKELETON_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.ENDERMAN_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CREEPER_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CREEPER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SPIDER_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.SPIDER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CAVE_SPIDER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.GUARDIAN_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PHANTOM_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PHANTOM_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAT_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.BAT_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SQUID_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.SQUID_PLUSHIE);
                        entries.add(ModItems.GLOW_SQUID_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BEE_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.BEE_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PIGLIN_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PIGLIN_PLUSHIE);
                        entries.add(ModItems.ZOMBIFIED_PIGLIN_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_HOGLIN_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.HOGLIN_PLUSHIE);
                        entries.add(ModItems.ZOGLIN_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GHAST_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.GHAST_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLAZE_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.BLAZE_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STRIDER_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.STRIDER_PLUSHIE);
                        entries.add(ModItems.SHIVERING_STRIDER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CHICKEN_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CHICKEN_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PIG_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PIG_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_COW_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.COW_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.RED_MOOSHROOM_PLUSHIE);
                        entries.add(ModItems.BROWN_MOOSHROOM_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SHEEP_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WHITE_SHEEP_PLUSHIE);
                        entries.add(ModItems.ORANGE_SHEEP_PLUSHIE);
                        entries.add(ModItems.MAGENTA_SHEEP_PLUSHIE);
                        entries.add(ModItems.LIGHT_BLUE_SHEEP_PLUSHIE);
                        entries.add(ModItems.YELLOW_SHEEP_PLUSHIE);
                        entries.add(ModItems.LIME_SHEEP_PLUSHIE);
                        entries.add(ModItems.PINK_SHEEP_PLUSHIE);
                        entries.add(ModItems.GRAY_SHEEP_PLUSHIE);
                        entries.add(ModItems.LIGHT_GRAY_SHEEP_PLUSHIE);
                        entries.add(ModItems.CYAN_SHEEP_PLUSHIE);
                        entries.add(ModItems.PURPLE_SHEEP_PLUSHIE);
                        entries.add(ModItems.BLUE_SHEEP_PLUSHIE);
                        entries.add(ModItems.BROWN_SHEEP_PLUSHIE);
                        entries.add(ModItems.RED_SHEEP_PLUSHIE);
                        entries.add(ModItems.GREEN_SHEEP_PLUSHIE);
                        entries.add(ModItems.BLACK_SHEEP_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_HORSE_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WHITE_HORSE_PLUSHIE);
                        entries.add(ModItems.GRAY_HORSE_PLUSHIE);
                        entries.add(ModItems.LIGHT_GRAY_HORSE_PLUSHIE);
                        entries.add(ModItems.BROWN_HORSE_PLUSHIE);
                        entries.add(ModItems.BLACK_HORSE_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_RABBIT_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.BROWN_RABBIT_PLUSHIE);
                        entries.add(ModItems.WHITE_RABBIT_PLUSHIE);
                        entries.add(ModItems.BLACK_RABBIT_PLUSHIE);
                        entries.add(ModItems.WHITE_SPLOTCHED_RABBIT_PLUSHIE);
                        entries.add(ModItems.GOLD_RABBIT_PLUSHIE);
                        entries.add(ModItems.TOAST_RABBIT_PLUSHIE);
                        entries.add(ModItems.SALT_RABBIT_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ILLAGER_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PILLAGER_PLUSHIE);
                        entries.add(ModItems.VINDICATOR_PLUSHIE);
                        entries.add(ModItems.EVOKER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_VILLAGER_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PLAINS_VILLAGER_PLUSHIE);
                        entries.add(ModItems.DESERT_VILLAGER_PLUSHIE);
                        entries.add(ModItems.JUNGLE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SAVANNA_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SNOW_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SWAMP_VILLAGER_PLUSHIE);
                        entries.add(ModItems.TAIGA_VILLAGER_PLUSHIE);
                        entries.add(ModItems.CRIMSON_VILLAGER_PLUSHIE);
                        entries.add(ModItems.WARPED_VILLAGER_PLUSHIE);
                        entries.add(ModItems.WANDERING_TRADER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ZOMBIE_VILLAGER_PLUSHIES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PLAINS_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.DESERT_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.JUNGLE_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SAVANNA_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SNOW_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SWAMP_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.TAIGA_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.CRIMSON_ZOMBIE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.WARPED_ZOMBIE_VILLAGER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WITCH_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WITCH_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PUFFERFISH_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WITHER_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WITHER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_POLAR_BEAR_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.POLAR_BEAR_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ALLAY_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.ALLAY_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_VEX_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.VEX_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_RAVAGER_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.RAVAGER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SHULKER_PLUSHIE);
					if (configEntry.getValue()) {
                        entries.add(ModItems.SHULKER_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CAMEL_PLUSHIE);
					if (configEntry.getValue()) {
                        entries.add(ModItems.CAMEL_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CREAKING_PLUSHIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CREAKING_PLUSHIE);
                    }

                    configEntry = (BooleanConfigEntry) config
                            .getEntry(ModConfigKeys.ENABLE_WOODEN_PLANTER_BOXES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.OAK_PLANTER_BOX);
                        entries.add(ModItems.SPRUCE_PLANTER_BOX);
                        entries.add(ModItems.BIRCH_PLANTER_BOX);
                        entries.add(ModItems.JUNGLE_PLANTER_BOX);
                        entries.add(ModItems.ACACIA_PLANTER_BOX);
                        entries.add(ModItems.DARK_OAK_PLANTER_BOX);
                        entries.add(ModItems.MANGROVE_PLANTER_BOX);
                        entries.add(ModItems.CHERRY_PLANTER_BOX);
                        entries.add(ModItems.BAMBOO_PLANTER_BOX);
                        entries.add(ModItems.CRIMSON_PLANTER_BOX);
                        entries.add(ModItems.WARPED_PLANTER_BOX);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WOODCUTTER);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WOODCUTTER);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WOODEN_WALLS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.OAK_WALL);
                        entries.add(ModItems.SPRUCE_WALL);
                        entries.add(ModItems.BIRCH_WALL);
                        entries.add(ModItems.JUNGLE_WALL);
                        entries.add(ModItems.ACACIA_WALL);
                        entries.add(ModItems.DARK_OAK_WALL);
                        entries.add(ModItems.MANGROVE_WALL);
                        entries.add(ModItems.CHERRY_WALL);
                        entries.add(ModItems.CRIMSON_WALL);
                        entries.add(ModItems.WARPED_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.STRIPPED_OAK_WALL);
                        entries.add(ModItems.STRIPPED_SPRUCE_WALL);
                        entries.add(ModItems.STRIPPED_BIRCH_WALL);
                        entries.add(ModItems.STRIPPED_JUNGLE_WALL);
                        entries.add(ModItems.STRIPPED_ACACIA_WALL);
                        entries.add(ModItems.STRIPPED_DARK_OAK_WALL);
                        entries.add(ModItems.STRIPPED_MANGROVE_WALL);
                        entries.add(ModItems.STRIPPED_CHERRY_WALL);
                        entries.add(ModItems.STRIPPED_CRIMSON_WALL);
                        entries.add(ModItems.STRIPPED_WARPED_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WOODEN_ROPE_LADDERS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.OAK_ROPE_LADDER);
                        entries.add(ModItems.SPRUCE_ROPE_LADDER);
                        entries.add(ModItems.BIRCH_ROPE_LADDER);
                        entries.add(ModItems.JUNGLE_ROPE_LADDER);
                        entries.add(ModItems.ACACIA_ROPE_LADDER);
                        entries.add(ModItems.DARK_OAK_ROPE_LADDER);
                        entries.add(ModItems.MANGROVE_ROPE_LADDER);
                        entries.add(ModItems.CHERRY_ROPE_LADDER);
                        entries.add(ModItems.CRIMSON_ROPE_LADDER);
                        entries.add(ModItems.WARPED_ROPE_LADDER);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_IRON_LADDERS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.IRON_LADDER);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DYED_CAMPFIRES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WHITE_CAMPFIRE);
                        entries.add(ModItems.ORANGE_CAMPFIRE);
                        entries.add(ModItems.MAGENTA_CAMPFIRE);
                        entries.add(ModItems.LIGHT_BLUE_CAMPFIRE);
                        entries.add(ModItems.YELLOW_CAMPFIRE);
                        entries.add(ModItems.LIME_CAMPFIRE);
                        entries.add(ModItems.PINK_CAMPFIRE);
                        entries.add(ModItems.GRAY_CAMPFIRE);
                        entries.add(ModItems.LIGHT_GRAY_CAMPFIRE);
                        entries.add(ModItems.CYAN_CAMPFIRE);
                        entries.add(ModItems.PURPLE_CAMPFIRE);
                        entries.add(ModItems.BLUE_CAMPFIRE);
                        entries.add(ModItems.BROWN_CAMPFIRE);
                        entries.add(ModItems.GREEN_CAMPFIRE);
                        entries.add(ModItems.RED_CAMPFIRE);
                        entries.add(ModItems.BLACK_CAMPFIRE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DYED_LANTERNS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WHITE_LANTERN);
                        entries.add(ModItems.ORANGE_LANTERN);
                        entries.add(ModItems.MAGENTA_LANTERN);
                        entries.add(ModItems.LIGHT_BLUE_LANTERN);
                        entries.add(ModItems.YELLOW_LANTERN);
                        entries.add(ModItems.LIME_LANTERN);
                        entries.add(ModItems.PINK_LANTERN);
                        entries.add(ModItems.GRAY_LANTERN);
                        entries.add(ModItems.LIGHT_GRAY_LANTERN);
                        entries.add(ModItems.CYAN_LANTERN);
                        entries.add(ModItems.PURPLE_LANTERN);
                        entries.add(ModItems.BLUE_LANTERN);
                        entries.add(ModItems.BROWN_LANTERN);
                        entries.add(ModItems.GREEN_LANTERN);
                        entries.add(ModItems.RED_LANTERN);
                        entries.add(ModItems.BLACK_LANTERN);
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
                        entries.add(ModItems.TWISTED_NETHERRACK);
                        entries.add(ModItems.TWISTED_NETHERRACK_STAIRS);
                        entries.add(ModItems.TWISTED_NETHERRACK_SLAB);
                        entries.add(ModItems.TWISTED_NETHERRACK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_NETHERRACK);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WEEPING_NETHERRACK);
                        entries.add(ModItems.WEEPING_NETHERRACK_STAIRS);
                        entries.add(ModItems.WEEPING_NETHERRACK_SLAB);
                        entries.add(ModItems.WEEPING_NETHERRACK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.TWISTED_NETHER_BRICKS);
                        entries.add(ModItems.TWISTED_NETHER_BRICK_STAIRS);
                        entries.add(ModItems.TWISTED_NETHER_BRICK_SLAB);
                        entries.add(ModItems.TWISTED_NETHER_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WEEPING_NETHER_BRICKS);
                        entries.add(ModItems.WEEPING_NETHER_BRICK_STAIRS);
                        entries.add(ModItems.WEEPING_NETHER_BRICK_SLAB);
                        entries.add(ModItems.WEEPING_NETHER_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.TWISTED_BLACKSTONE);
                        entries.add(ModItems.TWISTED_BLACKSTONE_STAIRS);
                        entries.add(ModItems.TWISTED_BLACKSTONE_SLAB);
                        entries.add(ModItems.TWISTED_BLACKSTONE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WEEPING_BLACKSTONE);
                        entries.add(ModItems.WEEPING_BLACKSTONE_STAIRS);
                        entries.add(ModItems.WEEPING_BLACKSTONE_SLAB);
                        entries.add(ModItems.WEEPING_BLACKSTONE_WALL);
                    }

                    configEntry = (BooleanConfigEntry)
                            config.getEntry(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry)
                            config.getEntry(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLACKSTONE_TILES);
                    boolean blackstoneTilesEnabled = configEntry.getValue();
                    if (blackstoneTilesEnabled) {
                        entries.add(ModItems.BLACKSTONE_TILES);
                        entries.add(ModItems.BLACKSTONE_TILE_STAIRS);
                        entries.add(ModItems.BLACKSTONE_TILE_SLAB);
                        entries.add(ModItems.BLACKSTONE_TILE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES);
                    if (blackstoneTilesEnabled && configEntry.getValue()) {
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILES);
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILE_STAIRS);
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILE_SLAB);
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES);
                    if (blackstoneTilesEnabled && configEntry.getValue()) {
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILES);
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILE_STAIRS);
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILE_SLAB);
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
                    boolean smokyQuartzBlocksEnabled = configEntry.getValue();
                    if (smokyQuartzBlocksEnabled) {
                        entries.add(ModItems.NETHER_SMOKY_QUARTZ_ORE);
                        entries.add(ModItems.SMOKY_QUARTZ);
                        entries.add(ModItems.SMOKY_QUARTZ_BLOCK);
                        entries.add(ModItems.SMOKY_QUARTZ_STAIRS);
                        entries.add(ModItems.SMOKY_QUARTZ_SLAB);
                        entries.add(ModItems.SMOKY_QUARTZ_WALL);
                        entries.add(ModItems.CHISELED_SMOKY_QUARTZ_BLOCK);
                        entries.add(ModItems.SMOKY_QUARTZ_PILLAR);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS);
                    if (smokyQuartzBlocksEnabled && configEntry.getValue()) {
                        entries.add(ModItems.SMOKY_QUARTZ_BRICKS);
                        entries.add(ModItems.SMOKY_QUARTZ_BRICK_STAIRS);
                        entries.add(ModItems.SMOKY_QUARTZ_BRICK_SLAB);
                        entries.add(ModItems.SMOKY_QUARTZ_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ);
                    if (smokyQuartzBlocksEnabled && configEntry.getValue()) {
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ);
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ_STAIRS);
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ_SLAB);
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.QUARTZ_BRICK_STAIRS);
                        entries.add(ModItems.QUARTZ_BRICK_SLAB);
                        entries.add(ModItems.QUARTZ_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_QUARTZ_TILES);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.QUARTZ_TILES);
                        entries.add(ModItems.QUARTZ_TILE_STAIRS);
                        entries.add(ModItems.QUARTZ_TILE_SLAB);
                        entries.add(ModItems.QUARTZ_TILE_WALL);
                    }

                    // TODO: Finish implementing the enable_quartz_walls config entry so recipes can be disabled!
                    //        Maybe split this entry into enable_quartz_wall and enable_smooth_quartz_wall.
                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_QUARTZ_WALLS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.QUARTZ_WALL);
                        entries.add(ModItems.SMOOTH_QUARTZ_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAUXITE);
                    boolean bauxiteEnabled = configEntry.getValue();
                    if (bauxiteEnabled) {
                        entries.add(ModItems.BAUXITE);
                        entries.add(ModItems.BAUXITE_SLAB);
                        entries.add(ModItems.BAUXITE_STAIRS);
                        entries.add(ModItems.BAUXITE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BAUXITE_BRICKS);
                    boolean bauxiteBricksEnabled = configEntry.getValue();
                    if (bauxiteEnabled && bauxiteBricksEnabled) {
                        entries.add(ModItems.BAUXITE_BRICKS);
                        entries.add(ModItems.BAUXITE_BRICK_STAIRS);
                        entries.add(ModItems.BAUXITE_BRICK_SLAB);
                        entries.add(ModItems.BAUXITE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS);
                    if (bauxiteEnabled && bauxiteBricksEnabled && configEntry.getValue()) {
                        entries.add(ModItems.CRACKED_BAUXITE_BRICKS);
                        entries.add(ModItems.CRACKED_BAUXITE_BRICK_STAIRS);
                        entries.add(ModItems.CRACKED_BAUXITE_BRICK_SLAB);
                        entries.add(ModItems.CRACKED_BAUXITE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS);
					if (bauxiteEnabled && bauxiteBricksEnabled && configEntry.getValue()) {
                        entries.add(ModItems.MOSSY_BAUXITE_BRICKS);
                        entries.add(ModItems.MOSSY_BAUXITE_BRICK_STAIRS);
                        entries.add(ModItems.MOSSY_BAUXITE_BRICK_SLAB);
                        entries.add(ModItems.MOSSY_BAUXITE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STONE_TILES);
                    boolean stoneTilesEnabled = configEntry.getValue();
                    if (stoneTilesEnabled) {
                        entries.add(ModItems.STONE_TILES);
                        entries.add(ModItems.STONE_TILE_SLAB);
                        entries.add(ModItems.STONE_TILE_STAIRS);
                        entries.add(ModItems.STONE_TILE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_STONE_TILES);
                    if (stoneTilesEnabled && configEntry.getValue()) {
                        entries.add(ModItems.CRACKED_STONE_TILES);
                        entries.add(ModItems.CRACKED_STONE_TILE_SLAB);
                        entries.add(ModItems.CRACKED_STONE_TILE_STAIRS);
                        entries.add(ModItems.CRACKED_STONE_TILE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_STONE_TILES);
                    if (stoneTilesEnabled && configEntry.getValue()) {
                        entries.add(ModItems.MOSSY_STONE_TILES);
                        entries.add(ModItems.MOSSY_STONE_TILE_SLAB);
                        entries.add(ModItems.MOSSY_STONE_TILE_STAIRS);
                        entries.add(ModItems.MOSSY_STONE_TILE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CRACKED_STONE_BRICK_STAIRS);
                        entries.add(ModItems.CRACKED_STONE_BRICK_SLAB);
                        entries.add(ModItems.CRACKED_STONE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_STONE_WALLS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.STONE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CALCITE_BLOCKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CALCITE_STAIRS);
                        entries.add(ModItems.CALCITE_SLAB);
                        entries.add(ModItems.CALCITE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_POLISHED_CALCITE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.POLISHED_CALCITE);
                        entries.add(ModItems.POLISHED_CALCITE_STAIRS);
                        entries.add(ModItems.POLISHED_CALCITE_SLAB);
                        entries.add(ModItems.POLISHED_CALCITE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CALCITE_BRICKS);
                    boolean calciteBricksEnabled = configEntry.getValue();
                    if (calciteBricksEnabled) {
                        entries.add(ModItems.CALCITE_BRICKS);
                        entries.add(ModItems.CALCITE_BRICK_STAIRS);
                        entries.add(ModItems.CALCITE_BRICK_SLAB);
                        entries.add(ModItems.CALCITE_BRICK_WALL);
                        entries.add(ModItems.CHISELED_CALCITE_BRICKS);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS);
                    if (configEntry.getValue() && calciteBricksEnabled) {
                        entries.add(ModItems.CRACKED_CALCITE_BRICKS);
                        entries.add(ModItems.CRACKED_CALCITE_BRICK_STAIRS);
                        entries.add(ModItems.CRACKED_CALCITE_BRICK_SLAB);
                        entries.add(ModItems.CRACKED_CALCITE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS);
                    if (configEntry.getValue() && calciteBricksEnabled) {
                        entries.add(ModItems.MOSSY_CALCITE_BRICKS);
                        entries.add(ModItems.MOSSY_CALCITE_BRICK_STAIRS);
                        entries.add(ModItems.MOSSY_CALCITE_BRICK_SLAB);
                        entries.add(ModItems.MOSSY_CALCITE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.DRIPSTONE_STAIRS);
                        entries.add(ModItems.DRIPSTONE_SLAB);
                        entries.add(ModItems.DRIPSTONE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.POLISHED_DRIPSTONE);
                        entries.add(ModItems.POLISHED_DRIPSTONE_STAIRS);
                        entries.add(ModItems.POLISHED_DRIPSTONE_SLAB);
                        entries.add(ModItems.POLISHED_DRIPSTONE_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS);
                    boolean dripstoneBricksEnabled = configEntry.getValue();
                    if (dripstoneBricksEnabled) {
                        entries.add(ModItems.DRIPSTONE_BRICKS);
                        entries.add(ModItems.DRIPSTONE_BRICK_STAIRS);
                        entries.add(ModItems.DRIPSTONE_BRICK_SLAB);
                        entries.add(ModItems.DRIPSTONE_BRICK_WALL);
                        entries.add(ModItems.CHISELED_DRIPSTONE_BRICKS);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS);
                    if (configEntry.getValue() && dripstoneBricksEnabled) {
                        entries.add(ModItems.CRACKED_DRIPSTONE_BRICKS);
                        entries.add(ModItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
                        entries.add(ModItems.CRACKED_DRIPSTONE_BRICK_SLAB);
                        entries.add(ModItems.CRACKED_DRIPSTONE_BRICK_WALL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS);
                    if (configEntry.getValue() && dripstoneBricksEnabled) {
                        entries.add(ModItems.MOSSY_DRIPSTONE_BRICKS);
                        entries.add(ModItems.MOSSY_DRIPSTONE_BRICK_STAIRS);
                        entries.add(ModItems.MOSSY_DRIPSTONE_BRICK_SLAB);
                        entries.add(ModItems.MOSSY_DRIPSTONE_BRICK_WALL);
                    }

                    entries.add(ModItems.SNOW_BRICKS);
                    entries.add(ModItems.SNOW_BRICK_STAIRS);
                    entries.add(ModItems.SNOW_BRICK_SLAB);
                    entries.add(ModItems.SNOW_BRICK_WALL);

                    entries.add(ModItems.PACKED_SNOW);
                    entries.add(ModItems.PACKED_SNOW_STAIRS);
                    entries.add(ModItems.PACKED_SNOW_SLAB);
                    entries.add(ModItems.PACKED_SNOW_WALL);

                    entries.add(ModItems.GRASS_SLAB);
                    entries.add(ModItems.PODZOL_SLAB);
                    entries.add(ModItems.MYCELIUM_SLAB);
                    entries.add(ModItems.DIRT_PATH_SLAB);
                    entries.add(ModItems.DIRT_SLAB);
                    entries.add(ModItems.ROOTED_DIRT_SLAB);
                    entries.add(ModItems.COARSE_DIRT_SLAB);

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PURPLE_MUSHROOM_BLOCK);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_CHOCOLATE_CAKE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.CHOCOLATE_CAKE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_RED_VELVET_CAKE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.RED_VELVET_CAKE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_SWEET_BERRY_PIE);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.SWEET_BERRY_PIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLUEBERRIES);
                    boolean blueberriesEnabled = configEntry.getValue();
                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BLUEBERRY_PIE);
                    if (blueberriesEnabled && configEntry.getValue()) {
                        entries.add(ModItems.BLUEBERRY_PIE);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_GREEN_ONIONS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.WILD_GREEN_ONIONS);
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
                        entries.add(ModItems.CATTAIL);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.BOG_BLOSSOM);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_ENDER_PLANTS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.SNAPDRAGON);
                        entries.add(ModItems.SHORT_ENDER_GRASS);
                    }

                    configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS);
                    if (configEntry.getValue()) {
                        entries.add(ModItems.PURPLE_MUSHROOM);
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
                        entries.add(ModItems.DRIED_BLOOD_KELP_BLOCK);
                        entries.add(ModItems.BLOOD_KELP_LANTERN);
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
				}).build());
	}
}
