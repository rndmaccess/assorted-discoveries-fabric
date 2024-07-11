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
import rndm_access.assorteddiscoveries.config.json.JsonConfigCategory;
import rndm_access.assorteddiscoveries.core.ModResourceConditions;
import rndm_access.assorteddiscoveries.core.*;

public class AssortedDiscoveries implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("AssortedDiscoveries");
	private static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(
			RegistryKeys.ITEM_GROUP, ADReference.makeModId("item_group"));

	@Override
	public void onInitialize() {
        // Config
        ModConfig.loadOrCreateConfig();
        ModResourceConditions.registerResourceConditions();

		// General Registries
		ModBlocks.registerBlocks();
		ModItems.registerItems();
        AssortedDiscoveries.addItemGroups();
		ModBlockEntityTypes.registerBlockEntityTypes();
		ModParticleTypes.registerParticleTypes();
		ModScreenHandlerTypes.registerScreenHandlerTypes();
		ModRecipeTypes.registerRecipeTypes();
		ModRecipeSerializers.registerRecipeSerializers();
		ModPaintingVariants.registerPaintingVariants();
		ModSoundEvents.registerSoundEvents();
		AssortedDiscoveries.registerFuel();
		AssortedDiscoveries.registerCompostables();
		AssortedDiscoveries.modifyLootTables();

		// Entity Registries
		ModVillagerTypes.registerVillagerTypes();
		ModPointOfInterestTypes.registerPointOfInterestTypes();
		ModVillagerProfessions.registerVillagerProfessions();
		ModVillagerOffers.registerVillagerTradeOffers();

		// World Generation Registries
		ModFeatures.registerFeatures();
		AssortedDiscoveries.addFeaturesToBiomes();
	}

	private static void addFeaturesToBiomes() {
        JsonConfigCategory farmingCategory = ModConfig.CONFIG.getCategory("farming");

        if(farmingCategory.getEntry("enable_cattails").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_CATTAIL_MANGROVE_SWAMP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_MANGROVE_SWAMP);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_CATTAIL_RIVER),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_RIVER);
        }

        BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.ORE_SMOKY_QUARTZ),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_SMOKY_QUARTZ);

        if(farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_HUGE_PURPLE_MUSHROOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_HUGE_PURPLE_MUSHROOM);
        }

        if(farmingCategory.getEntry("enable_blueberries").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_RARE);
        }

        if(farmingCategory.getEntry("enable_witchs_cradle_soup").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_RARE);
        }

        if(farmingCategory.getEntry("enable_ender_plants").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_ENDER_PLANTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_ENDER_PLANTS);
        }

        if(farmingCategory.getEntry("enable_blood_kelp").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.BLOOD_KELP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.BLOOD_KELP);
        }

        if(farmingCategory.getEntry("enable_bog_blossoms").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.BOG_BLOSSOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.BOG_BLOSSOM);
        }

        BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.ORE_BAUXITE),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_LOWER);
		BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.ORE_BAUXITE),
				GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_UPPER);

        if(farmingCategory.getEntry("enable_nether_berries").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_RARE);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_RARE);
        }

        if(farmingCategory.getEntry("enable_green_onions").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CommonBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_RARE);
        }
	}

	private static void registerFuel() {
        if(ModConfig.CONFIG.getCategory("farming")
                .getEntry("enable_blood_kelp").getValueAsBool()) {
            FuelRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP_BLOCK, 4000);
        }
	}

	private static void registerCompostables() {
        JsonConfigCategory farmingCategory = ModConfig.CONFIG.getCategory("farming");

        if(farmingCategory.getEntry("enable_blueberries").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.3F);
        }

        if(farmingCategory.getEntry("enable_nether_berries").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.CINDERSNAP_BERRIES, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.FROSTBITE_BERRIES, 0.3F);
        }

        if(farmingCategory.getEntry("enable_witchs_cradle_soup").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.WITCHS_CRADLE_BRANCH, 0.3F);
        }

        if(farmingCategory.getEntry("enable_blood_kelp").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOD_KELP_SEED_CLUSTER, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOD_KELP, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP_BLOCK, 0.5F);
        }

        if(farmingCategory.getEntry("enable_ender_plants").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.SNAPDRAGON, 0.65F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.SHORT_ENDER_GRASS, 0.3F);
        }

        if(farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.PURPLE_MUSHROOM_BLOCK, 0.85F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.PURPLE_MUSHROOM, 0.65F);
        }

        if(farmingCategory.getEntry("enable_cattails").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.CATTAIL, 0.5F);
        }

        if(farmingCategory.getEntry("enable_green_onions").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION, 0.65F);
            CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_ONION_SEEDS, 0.3F);
        }
	}

	private static void modifyLootTables() {
		Identifier spruceLeavesLootTableId = Blocks.SPRUCE_LEAVES.getLootTableId();

        if(ModConfig.CONFIG.getCategory("farming")
                .getEntry("enable_forests_bounty").getValueAsBool()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
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

	private static void addItemGroups() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup." + ADReference.MOD_ID + ".item_group"))
				.icon(() -> new ItemStack(ModItems.ENDERMAN_PLUSHIE))
				.entries((context, entries) -> {
                    JsonConfigCategory buildingCategory = ModConfig.CONFIG
                            .getCategory("building");
                    JsonConfigCategory dyedSubcategory = buildingCategory
                            .getSubcategory("dyed");
                    JsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                            .getSubcategory("hostile_plushies");
                    JsonConfigCategory passivePlushiesSubcategory = buildingCategory
                            .getSubcategory("passive_plushies");
                    JsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                            .getSubcategory("neutral_plushies");
                    JsonConfigCategory farmingCategory = ModConfig.CONFIG
                            .getCategory("farming");

                    if (hostilePlushiesSubcategory.getEntry("enable_slime_plushie").getValueAsBool()) {
                        entries.add(ModItems.SLIME_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_magma_cube_plushie").getValueAsBool()) {
                        entries.add(ModItems.MAGMA_CUBE_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_ocelot_plushie").getValueAsBool()) {
                        entries.add(ModItems.OCELOT_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_cat_plushies").getValueAsBool()) {
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

                    if (neutralPlushiesSubcategory.getEntry("enable_pale_wolf_plushie").getValueAsBool()) {
                        entries.add(ModItems.PALE_WOLF_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_zombie_plushie").getValueAsBool()) {
                        entries.add(ModItems.ZOMBIE_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_skeleton_plushie").getValueAsBool()) {
                        entries.add(ModItems.SKELETON_PLUSHIE);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_enderman_plushie").getValueAsBool()) {
                        entries.add(ModItems.ENDERMAN_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_creeper_plushie").getValueAsBool()) {
                        entries.add(ModItems.CREEPER_PLUSHIE);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_spider_plushie").getValueAsBool()) {
                        entries.add(ModItems.SPIDER_PLUSHIE);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_cave_spider_plushie").getValueAsBool()) {
                        entries.add(ModItems.CAVE_SPIDER_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_guardian_plushie").getValueAsBool()) {
                        entries.add(ModItems.GUARDIAN_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_phantom_plushie").getValueAsBool()) {
                        entries.add(ModItems.PHANTOM_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_bat_plushie").getValueAsBool()) {
                        entries.add(ModItems.BAT_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_squid_plushies").getValueAsBool()) {
                        entries.add(ModItems.SQUID_PLUSHIE);
                        entries.add(ModItems.GLOW_SQUID_PLUSHIE);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_bee_plushie").getValueAsBool()) {
                        entries.add(ModItems.BEE_PLUSHIE);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_piglin_plushies").getValueAsBool()) {
                        entries.add(ModItems.PIGLIN_PLUSHIE);
                        entries.add(ModItems.ZOMBIFIED_PIGLIN_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_hoglin_plushies").getValueAsBool()) {
                        entries.add(ModItems.HOGLIN_PLUSHIE);
                        entries.add(ModItems.ZOGLIN_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_ghast_plushie").getValueAsBool()) {
                        entries.add(ModItems.GHAST_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_blaze_plushie").getValueAsBool()) {
                        entries.add(ModItems.BLAZE_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_strider_plushies").getValueAsBool()) {
                        entries.add(ModItems.STRIDER_PLUSHIE);
                        entries.add(ModItems.SHIVERING_STRIDER_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_chicken_plushie").getValueAsBool()) {
                        entries.add(ModItems.CHICKEN_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_pig_plushie").getValueAsBool()) {
                        entries.add(ModItems.PIG_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_cow_plushie").getValueAsBool()) {
                        entries.add(ModItems.COW_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_mooshroom_plushies").getValueAsBool()) {
                        entries.add(ModItems.RED_MOOSHROOM_PLUSHIE);
                        entries.add(ModItems.BROWN_MOOSHROOM_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_sheep_plushies").getValueAsBool()) {
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
                        entries.add(ModItems.MAROON_SHEEP_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_horse_plushies").getValueAsBool()) {
                        entries.add(ModItems.WHITE_HORSE_PLUSHIE);
                        entries.add(ModItems.GRAY_HORSE_PLUSHIE);
                        entries.add(ModItems.LIGHT_GRAY_HORSE_PLUSHIE);
                        entries.add(ModItems.BROWN_HORSE_PLUSHIE);
                        entries.add(ModItems.BLACK_HORSE_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_rabbit_plushies").getValueAsBool()) {
                        entries.add(ModItems.BROWN_RABBIT_PLUSHIE);
                        entries.add(ModItems.WHITE_RABBIT_PLUSHIE);
                        entries.add(ModItems.BLACK_RABBIT_PLUSHIE);
                        entries.add(ModItems.WHITE_SPLOTCHED_RABBIT_PLUSHIE);
                        entries.add(ModItems.GOLD_RABBIT_PLUSHIE);
                        entries.add(ModItems.TOAST_RABBIT_PLUSHIE);
                        entries.add(ModItems.SALT_RABBIT_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_illager_plushies").getValueAsBool()) {
                        entries.add(ModItems.PILLAGER_PLUSHIE);
                        entries.add(ModItems.VINDICATOR_PLUSHIE);
                        entries.add(ModItems.EVOKER_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_villager_plushies").getValueAsBool()) {
                        entries.add(ModItems.PLAINS_VILLAGER_PLUSHIE);
                        entries.add(ModItems.DESERT_VILLAGER_PLUSHIE);
                        entries.add(ModItems.JUNGLE_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SAVANNA_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SNOW_VILLAGER_PLUSHIE);
                        entries.add(ModItems.SWAMP_VILLAGER_PLUSHIE);
                        entries.add(ModItems.TAIGA_VILLAGER_PLUSHIE);
                        entries.add(ModItems.CRIMSON_VILLAGER_PLUSHIE);
                        entries.add(ModItems.WARPED_VILLAGER_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_wandering_trader_plushie").getValueAsBool()) {
                        entries.add(ModItems.WANDERING_TRADER_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_zombie_villager_plushies").getValueAsBool()) {
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

                    if (hostilePlushiesSubcategory.getEntry("enable_witch_plushie").getValueAsBool()) {
                        entries.add(ModItems.WITCH_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_pufferfish_plushie").getValueAsBool()) {
                        entries.add(ModItems.PUFFERFISH_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_wither_plushie").getValueAsBool()) {
                        entries.add(ModItems.WITHER_PLUSHIE);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_polar_bear_plushie").getValueAsBool()) {
                        entries.add(ModItems.POLAR_BEAR_PLUSHIE);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_allay_plushie").getValueAsBool()) {
                        entries.add(ModItems.ALLAY_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_vex_plushie").getValueAsBool()) {
                        entries.add(ModItems.VEX_PLUSHIE);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_ravager_plushie").getValueAsBool()) {
                        entries.add(ModItems.RAVAGER_PLUSHIE);
                    }

					if (hostilePlushiesSubcategory.getEntry("enable_shulker_plushie").getValueAsBool()) {
                        entries.add(ModItems.SHULKER_PLUSHIE);
                    }

					if (passivePlushiesSubcategory.getEntry("enable_camel_plushie").getValueAsBool()) {
                        entries.add(ModItems.CAMEL_PLUSHIE);
                    }

                    if (farmingCategory.getEntry("enable_wooden_planter_boxes").getValueAsBool()) {
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

                    if (buildingCategory.getEntry("enable_woodcutter")
                            .getValueAsBool()) {
                        entries.add(ModItems.WOODCUTTER);
                    }

                    if (buildingCategory.getEntry("enable_wooden_walls")
                            .getValueAsBool()) {
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

                    if (buildingCategory.getEntry("enable_stripped_wooden_walls").getValueAsBool()) {
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

                    if (buildingCategory.getEntry("enable_wooden_rope_ladders").getValueAsBool()) {
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

                    if (buildingCategory.getEntry("enable_iron_ladders").getValueAsBool()) {
                        entries.add(ModItems.IRON_LADDER);
                    }

                    if (dyedSubcategory.getEntry("enable_dyed_campfires").getValueAsBool()) {
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
                        entries.add(ModItems.MAROON_CAMPFIRE);
                    }

                    if (dyedSubcategory.getEntry("enable_dyed_lanterns").getValueAsBool()) {
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
                        entries.add(ModItems.MAROON_LANTERN);
                    }

                    if (dyedSubcategory.getEntry("enable_dyed_torches").getValueAsBool()) {
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
                        entries.add(ModItems.MAROON_TORCH);
                    }

                    if (buildingCategory.getEntry("enable_twisted_netherrack").getValueAsBool()) {
                        entries.add(ModItems.TWISTED_NETHERRACK);
                        entries.add(ModItems.TWISTED_NETHERRACK_STAIRS);
                        entries.add(ModItems.TWISTED_NETHERRACK_SLAB);
                        entries.add(ModItems.TWISTED_NETHERRACK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_netherrack").getValueAsBool()) {
                        entries.add(ModItems.WEEPING_NETHERRACK);
                        entries.add(ModItems.WEEPING_NETHERRACK_STAIRS);
                        entries.add(ModItems.WEEPING_NETHERRACK_SLAB);
                        entries.add(ModItems.WEEPING_NETHERRACK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_nether_bricks").getValueAsBool()) {
                        entries.add(ModItems.TWISTED_NETHER_BRICKS);
                        entries.add(ModItems.TWISTED_NETHER_BRICK_STAIRS);
                        entries.add(ModItems.TWISTED_NETHER_BRICK_SLAB);
                        entries.add(ModItems.TWISTED_NETHER_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_nether_bricks").getValueAsBool()) {
                        entries.add(ModItems.WEEPING_NETHER_BRICKS);
                        entries.add(ModItems.WEEPING_NETHER_BRICK_STAIRS);
                        entries.add(ModItems.WEEPING_NETHER_BRICK_SLAB);
                        entries.add(ModItems.WEEPING_NETHER_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_blackstone").getValueAsBool()) {
                        entries.add(ModItems.TWISTED_BLACKSTONE);
                        entries.add(ModItems.TWISTED_BLACKSTONE_STAIRS);
                        entries.add(ModItems.TWISTED_BLACKSTONE_SLAB);
                        entries.add(ModItems.TWISTED_BLACKSTONE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_blackstone").getValueAsBool()) {
                        entries.add(ModItems.WEEPING_BLACKSTONE);
                        entries.add(ModItems.WEEPING_BLACKSTONE_STAIRS);
                        entries.add(ModItems.WEEPING_BLACKSTONE_SLAB);
                        entries.add(ModItems.WEEPING_BLACKSTONE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_polished_blackstone_bricks")
                            .getValueAsBool()) {
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ModItems.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_polished_blackstone_bricks")
                            .getValueAsBool()) {
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ModItems.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_blackstone_tiles").getValueAsBool()) {
                        entries.add(ModItems.BLACKSTONE_TILES);
                        entries.add(ModItems.BLACKSTONE_TILE_STAIRS);
                        entries.add(ModItems.BLACKSTONE_TILE_SLAB);
                        entries.add(ModItems.BLACKSTONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_blackstone_tiles").getValueAsBool()) {
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILES);
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILE_STAIRS);
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILE_SLAB);
                        entries.add(ModItems.TWISTED_BLACKSTONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_blackstone_tiles").getValueAsBool()) {
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILES);
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILE_STAIRS);
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILE_SLAB);
                        entries.add(ModItems.WEEPING_BLACKSTONE_TILE_WALL);
                    }

                    boolean enableSmokyQuartzBlocks = buildingCategory.getEntry("enable_smoky_quartz_blocks")
                            .getValueAsBool();
                    boolean enableSmokyQuartzBricks = buildingCategory.getEntry("enable_smoky_quartz_bricks")
                            .getValueAsBool();
                    boolean enableSmoothSmokyQuartz = buildingCategory.getEntry("enable_smooth_smoky_quartz")
                            .getValueAsBool();

                    if (enableSmokyQuartzBlocks) {
                        entries.add(ModItems.NETHER_SMOKY_QUARTZ_ORE);
                        entries.add(ModItems.SMOKY_QUARTZ);
                        entries.add(ModItems.SMOKY_QUARTZ_BLOCK);
                        entries.add(ModItems.SMOKY_QUARTZ_STAIRS);
                        entries.add(ModItems.SMOKY_QUARTZ_SLAB);
                        entries.add(ModItems.SMOKY_QUARTZ_WALL);
                    }

                    if (enableSmokyQuartzBlocks && enableSmokyQuartzBricks) {
                        entries.add(ModItems.SMOKY_QUARTZ_BRICKS);
                        entries.add(ModItems.SMOKY_QUARTZ_BRICK_STAIRS);
                        entries.add(ModItems.SMOKY_QUARTZ_BRICK_SLAB);
                        entries.add(ModItems.SMOKY_QUARTZ_BRICK_WALL);
                        entries.add(ModItems.CHISELED_SMOKY_QUARTZ_BLOCK);
                        entries.add(ModItems.SMOKY_QUARTZ_PILLAR);
                    }

                    if (enableSmokyQuartzBlocks && enableSmoothSmokyQuartz) {
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ);
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ_STAIRS);
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ_SLAB);
                        entries.add(ModItems.SMOOTH_SMOKY_QUARTZ_WALL);
                    }

                    if (buildingCategory.getEntry("enable_quartz_tiles").getValueAsBool()) {
                        entries.add(ModItems.QUARTZ_TILES);
                        entries.add(ModItems.QUARTZ_TILE_STAIRS);
                        entries.add(ModItems.QUARTZ_TILE_SLAB);
                        entries.add(ModItems.QUARTZ_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_quartz_walls").getValueAsBool()) {
                        entries.add(ModItems.QUARTZ_WALL);
                        entries.add(ModItems.SMOOTH_QUARTZ_WALL);
                    }

                    if (buildingCategory.getEntry("enable_bauxite").getValueAsBool()) {
                        entries.add(ModItems.BAUXITE);
                        entries.add(ModItems.BAUXITE_SLAB);
                        entries.add(ModItems.BAUXITE_STAIRS);
                        entries.add(ModItems.BAUXITE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_bauxite_bricks").getValueAsBool()) {
                        entries.add(ModItems.BAUXITE_BRICKS);
                        entries.add(ModItems.BAUXITE_BRICK_STAIRS);
                        entries.add(ModItems.BAUXITE_BRICK_SLAB);
                        entries.add(ModItems.BAUXITE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_cracked_bauxite_bricks").getValueAsBool()) {
                        entries.add(ModItems.CRACKED_BAUXITE_BRICKS);
                        entries.add(ModItems.CRACKED_BAUXITE_BRICK_STAIRS);
                        entries.add(ModItems.CRACKED_BAUXITE_BRICK_SLAB);
                        entries.add(ModItems.CRACKED_BAUXITE_BRICK_WALL);
                    }

					if (buildingCategory.getEntry("enable_mossy_bauxite_bricks").getValueAsBool()) {
                        entries.add(ModItems.MOSSY_BAUXITE_BRICKS);
                        entries.add(ModItems.MOSSY_BAUXITE_BRICK_STAIRS);
                        entries.add(ModItems.MOSSY_BAUXITE_BRICK_SLAB);
                        entries.add(ModItems.MOSSY_BAUXITE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_stone_tiles").getValueAsBool()) {
                        entries.add(ModItems.STONE_TILES);
                        entries.add(ModItems.STONE_TILE_SLAB);
                        entries.add(ModItems.STONE_TILE_STAIRS);
                        entries.add(ModItems.STONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_cracked_stone_tiles").getValueAsBool()) {
                        entries.add(ModItems.CRACKED_STONE_TILES);
                        entries.add(ModItems.CRACKED_STONE_TILE_SLAB);
                        entries.add(ModItems.CRACKED_STONE_TILE_STAIRS);
                        entries.add(ModItems.CRACKED_STONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_mossy_stone_tiles").getValueAsBool()) {
                        entries.add(ModItems.MOSSY_STONE_TILES);
                        entries.add(ModItems.MOSSY_STONE_TILE_SLAB);
                        entries.add(ModItems.MOSSY_STONE_TILE_STAIRS);
                        entries.add(ModItems.MOSSY_STONE_TILE_WALL);
                    }


					entries.add(ModItems.CRACKED_STONE_BRICK_STAIRS);
					entries.add(ModItems.CRACKED_STONE_BRICK_SLAB);
					entries.add(ModItems.CRACKED_STONE_BRICK_WALL);
					entries.add(ModItems.STONE_WALL);
					entries.add(ModItems.CALCITE_STAIRS);
					entries.add(ModItems.CALCITE_SLAB);
					entries.add(ModItems.CALCITE_WALL);
					entries.add(ModItems.POLISHED_CALCITE);
					entries.add(ModItems.POLISHED_CALCITE_STAIRS);
					entries.add(ModItems.POLISHED_CALCITE_SLAB);
					entries.add(ModItems.POLISHED_CALCITE_WALL);
					entries.add(ModItems.CALCITE_BRICKS);
					entries.add(ModItems.CALCITE_BRICK_STAIRS);
					entries.add(ModItems.CALCITE_BRICK_SLAB);
					entries.add(ModItems.CALCITE_BRICK_WALL);
					entries.add(ModItems.CRACKED_CALCITE_BRICKS);
					entries.add(ModItems.CRACKED_CALCITE_BRICK_STAIRS);
					entries.add(ModItems.CRACKED_CALCITE_BRICK_SLAB);
					entries.add(ModItems.CRACKED_CALCITE_BRICK_WALL);
					entries.add(ModItems.CHISELED_CALCITE_BRICKS);
					entries.add(ModItems.MOSSY_CALCITE_BRICKS);
					entries.add(ModItems.MOSSY_CALCITE_BRICK_STAIRS);
					entries.add(ModItems.MOSSY_CALCITE_BRICK_SLAB);
					entries.add(ModItems.MOSSY_CALCITE_BRICK_WALL);
					entries.add(ModItems.DRIPSTONE_STAIRS);
					entries.add(ModItems.DRIPSTONE_SLAB);
					entries.add(ModItems.DRIPSTONE_WALL);
					entries.add(ModItems.POLISHED_DRIPSTONE);
					entries.add(ModItems.POLISHED_DRIPSTONE_STAIRS);
					entries.add(ModItems.POLISHED_DRIPSTONE_SLAB);
					entries.add(ModItems.POLISHED_DRIPSTONE_WALL);
					entries.add(ModItems.DRIPSTONE_BRICKS);
					entries.add(ModItems.DRIPSTONE_BRICK_STAIRS);
					entries.add(ModItems.DRIPSTONE_BRICK_SLAB);
					entries.add(ModItems.DRIPSTONE_BRICK_WALL);
					entries.add(ModItems.CRACKED_DRIPSTONE_BRICKS);
					entries.add(ModItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
					entries.add(ModItems.CRACKED_DRIPSTONE_BRICK_SLAB);
					entries.add(ModItems.CRACKED_DRIPSTONE_BRICK_WALL);
					entries.add(ModItems.CHISELED_DRIPSTONE_BRICKS);
					entries.add(ModItems.MOSSY_DRIPSTONE_BRICKS);
					entries.add(ModItems.MOSSY_DRIPSTONE_BRICK_STAIRS);
					entries.add(ModItems.MOSSY_DRIPSTONE_BRICK_SLAB);
					entries.add(ModItems.MOSSY_DRIPSTONE_BRICK_WALL);

					entries.add(ModItems.SNOW_BRICKS);
					entries.add(ModItems.SNOW_BRICK_STAIRS);
					entries.add(ModItems.SNOW_BRICK_SLAB);
					entries.add(ModItems.SNOW_BRICK_WALL);

					entries.add(ModItems.PACKED_SNOW);
					entries.add(ModItems.PACKED_SNOW_STAIRS);
					entries.add(ModItems.PACKED_SNOW_SLAB);
					entries.add(ModItems.PACKED_SNOW_WALL);

					entries.add(ModItems.MAROON_WOOL);
					entries.add(ModItems.MAROON_CONCRETE);
					entries.add(ModItems.MAROON_CONCRETE_POWDER);
					entries.add(ModItems.MAROON_STAINED_GLASS);
					entries.add(ModItems.MAROON_STAINED_GLASS_PANE);
					entries.add(ModItems.MAROON_CANDLE);

                    entries.add(ModItems.GRASS_SLAB);
                    entries.add(ModItems.PODZOL_SLAB);
                    entries.add(ModItems.MYCELIUM_SLAB);
                    entries.add(ModItems.DIRT_PATH_SLAB);
                    entries.add(ModItems.DIRT_SLAB);
                    entries.add(ModItems.ROOTED_DIRT_SLAB);
                    entries.add(ModItems.COARSE_DIRT_SLAB);

                    if (farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
                        entries.add(ModItems.PURPLE_MUSHROOM_BLOCK);
                    }

                    if (farmingCategory.getEntry("enable_chocolate_cake").getValueAsBool()) {
                        entries.add(ModItems.CHOCOLATE_CAKE);
                    }

                    if (farmingCategory.getEntry("enable_red_velvet_cake").getValueAsBool()) {
                        entries.add(ModItems.RED_VELVET_CAKE);
                    }

                    if (farmingCategory.getEntry("enable_sweet_berry_pie").getValueAsBool()) {
                        entries.add(ModItems.SWEET_BERRY_PIE);
                    }

                    if (farmingCategory.getEntry("enable_blueberries").getValueAsBool()
                            && farmingCategory.getEntry("enable_blueberry_pie").getValueAsBool()) {
                        entries.add(ModItems.BLUEBERRY_PIE);
                    }

                    if (farmingCategory.getEntry("enable_green_onions").getValueAsBool()) {
                        entries.add(ModItems.WILD_GREEN_ONIONS);
                        entries.add(ModItems.GREEN_ONION_SEEDS);
                        entries.add(ModItems.GREEN_ONION);
                    }

                    if (farmingCategory.getEntry("enable_noodle_soup").getValueAsBool()) {
                        entries.add(ModItems.NOODLES);
                        entries.add(ModItems.NOODLE_SOUP);
                    }

                    if (farmingCategory.getEntry("enable_blueberries").getValueAsBool()) {
                        entries.add(ModItems.BLUEBERRIES);
                    }

                    if (farmingCategory.getEntry("enable_nether_berries").getValueAsBool()) {
                        entries.add(ModItems.CINDERSNAP_BERRIES);
                        entries.add(ModItems.FROSTBITE_BERRIES);
                    }

                    if (farmingCategory.getEntry("enable_cattails").getValueAsBool()) {
                        entries.add(ModItems.CATTAIL);
                    }

                    if (farmingCategory.getEntry("enable_bog_blossoms").getValueAsBool()) {
                        entries.add(ModItems.BOG_BLOSSOM);
                    }

                    if (farmingCategory.getEntry("enable_ender_plants").getValueAsBool()) {
                        entries.add(ModItems.SNAPDRAGON);
                        entries.add(ModItems.SHORT_ENDER_GRASS);
                    }

                    if (farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
                        entries.add(ModItems.PURPLE_MUSHROOM);
                    }

                    if (farmingCategory.getEntry("enable_caramel_apple").getValueAsBool()) {
                        entries.add(ModItems.CARAMEL_APPLE);
                        entries.add(ModItems.CARAMEL);
                    }

                    if (farmingCategory.getEntry("enable_fried_egg").getValueAsBool()) {
                        entries.add(ModItems.FRIED_EGG);
                    }

                    if (farmingCategory.getEntry("enable_blood_kelp").getValueAsBool()) {
                        entries.add(ModItems.DRIED_BLOOD_KELP_BLOCK);
                        entries.add(ModItems.BLOOD_KELP_LANTERN);
                        entries.add(ModItems.BLOOD_KELP_SEED_CLUSTER);
                        entries.add(ModItems.BLOOD_KELP);
                        entries.add(ModItems.DRIED_BLOOD_KELP);
                    }

                    if (farmingCategory.getEntry("enable_hoglin_stew").getValueAsBool()) {
                        entries.add(ModItems.HOGLIN_STEW);
                    }

                    if (farmingCategory.getEntry("enable_forests_bounty").getValueAsBool()) {
                        entries.add(ModItems.FORESTS_BOUNTY);
                        entries.add(ModItems.SPRUCE_CONE);
                    }

                    if (farmingCategory.getEntry("enable_witchs_cradle_soup").getValueAsBool()) {
                        entries.add(ModItems.WITCHS_CRADLE_SOUP);
                        entries.add(ModItems.WITCHS_CRADLE_BRANCH);
                    }

                    if (farmingCategory.getEntry("enable_pudding").getValueAsBool()) {
                        entries.add(ModItems.BERRY_PUDDING);
                        entries.add(ModItems.PUDDING);
                    }

                    if (farmingCategory.getEntry("enable_blueberries").getValueAsBool()
                            && farmingCategory.getEntry("enable_blueberry_juice").getValueAsBool()) {
                        entries.add(ModItems.BLUEBERRY_JUICE);
                    }

                    if (farmingCategory.getEntry("enable_sweet_berry_juice").getValueAsBool()) {
                        entries.add(ModItems.SWEET_BERRY_JUICE);
                    }

					entries.add(ModItems.MAROON_DYE);
				}).build());
	}
}
