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
import rndm_access.assorteddiscoveries.config.ADConfig;
import rndm_access.assorteddiscoveries.config.json.ADJsonConfigCategory;
import rndm_access.assorteddiscoveries.item.crafting.ADResourceConditions;
import rndm_access.assorteddiscoveries.core.*;

public class AssortedDiscoveries implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("AssortedDiscoveries");
	private static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(
			RegistryKeys.ITEM_GROUP, ADReference.makeModId("item_group"));

	@Override
	public void onInitialize() {
        // Config
        ADConfig.loadOrCreateConfig();
        ADResourceConditions.registerResourceConditions();

		// General Registries
		ADBlocks.registerBlocks();
		ADItems.registerItems();
        AssortedDiscoveries.addItemGroups();
		ADBlockEntityTypes.registerBlockEntityTypes();
		ADParticleTypes.registerParticleTypes();
		ADScreenHandlerTypes.registerScreenHandlerTypes();
		ADRecipeTypes.registerRecipeTypes();
		ADRecipeSerializers.registerRecipeSerializers();
		ADPaintingVariants.registerPaintingVariants();
		ADSoundEvents.registerSoundEvents();
		AssortedDiscoveries.registerFuel();
		AssortedDiscoveries.registerCompostables();
		AssortedDiscoveries.modifyLootTables();

		// Entity Registries
		ADVillagerTypes.registerVillagerTypes();
		ADPointOfInterestTypes.registerPointOfInterestTypes();
		ADVillagerProfessions.registerVillagerProfessions();
		ADVillagerOffers.registerVillagerTradeOffers();

		// World Generation Registries
		ADFeature.registerFeatures();
		AssortedDiscoveries.addFeaturesToBiomes();
	}

	private static void addFeaturesToBiomes() {
        ADJsonConfigCategory farmingCategory = ADConfig.CONFIG.getCategory("farming");

        if(farmingCategory.getEntry("enable_cattails").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_CATTAIL_MANGROVE_SWAMP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_CATTAIL_MANGROVE_SWAMP);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_CATTAIL_RIVER),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_CATTAIL_RIVER);
        }

        BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.ORE_SMOKY_QUARTZ),
				GenerationStep.Feature.UNDERGROUND_ORES, ADPlacedFeatureKeys.ORE_SMOKY_QUARTZ);

        if(farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_HUGE_PURPLE_MUSHROOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_HUGE_PURPLE_MUSHROOM);
        }

        if(farmingCategory.getEntry("enable_blueberries").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_BLUEBERRY_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_BLUEBERRY_RARE);
        }

        if(farmingCategory.getEntry("enable_witchs_cradle_soup").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_WITCHS_CRADLE_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_WITCHS_CRADLE_RARE);
        }

        if(farmingCategory.getEntry("enable_ender_plants").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_ENDER_PLANTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_ENDER_PLANTS);
        }

        if(farmingCategory.getEntry("enable_blood_kelp").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.BLOOD_KELP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.BLOOD_KELP);
        }

        if(farmingCategory.getEntry("enable_bog_blossoms").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.BOG_BLOSSOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.BOG_BLOSSOM);
        }

        BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.ORE_BAUXITE),
                GenerationStep.Feature.UNDERGROUND_ORES, ADPlacedFeatureKeys.ORE_BAUXITE_LOWER);
		BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.ORE_BAUXITE),
				GenerationStep.Feature.UNDERGROUND_ORES, ADPlacedFeatureKeys.ORE_BAUXITE_UPPER);

        if(farmingCategory.getEntry("enable_nether_berries").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_RARE);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_RARE);
        }

        if(farmingCategory.getEntry("enable_green_onions").getValueAsBool()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(CBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ADPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_RARE);
        }
	}

	private static void registerFuel() {
        if(ADConfig.CONFIG.getCategory("farming")
                .getEntry("enable_blood_kelp").getValueAsBool()) {
            FuelRegistry.INSTANCE.add(ADItems.DRIED_BLOOD_KELP_BLOCK, 4000);
        }
	}

	private static void registerCompostables() {
        ADJsonConfigCategory farmingCategory = ADConfig.CONFIG.getCategory("farming");

        if(farmingCategory.getEntry("enable_blueberries").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.BLUEBERRIES, 0.3F);
        }

        if(farmingCategory.getEntry("enable_nether_berries").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.CINDERSNAP_BERRIES, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.FROSTBITE_BERRIES, 0.3F);
        }

        if(farmingCategory.getEntry("enable_witchs_cradle_soup").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.WITCHS_CRADLE_BRANCH, 0.3F);
        }

        if(farmingCategory.getEntry("enable_blood_kelp").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.BLOOD_KELP_SEED_CLUSTER, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.BLOOD_KELP, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.DRIED_BLOOD_KELP, 0.3F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.DRIED_BLOOD_KELP_BLOCK, 0.5F);
        }

        if(farmingCategory.getEntry("enable_ender_plants").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.SNAPDRAGON, 0.65F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.SHORT_ENDER_GRASS, 0.3F);
        }

        if(farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.PURPLE_MUSHROOM_BLOCK, 0.85F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.PURPLE_MUSHROOM, 0.65F);
        }

        if(farmingCategory.getEntry("enable_cattails").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.CATTAIL, 0.5F);
        }

        if(farmingCategory.getEntry("enable_green_onions").getValueAsBool()) {
            CompostingChanceRegistry.INSTANCE.add(ADItems.GREEN_ONION, 0.65F);
            CompostingChanceRegistry.INSTANCE.add(ADItems.GREEN_ONION_SEEDS, 0.3F);
        }
	}

	private static void modifyLootTables() {
		Identifier spruceLeavesLootTableId = Blocks.SPRUCE_LEAVES.getLootTableId();

        if(ADConfig.CONFIG.getCategory("farming")
                .getEntry("enable_forests_bounty").getValueAsBool()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if(source.isBuiltin() && spruceLeavesLootTableId.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02F, 0.023F,
                                    0.025F, 0.035F, 0.1F))
                            .with(ItemEntry.builder(ADItems.SPRUCE_CONE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)));

                    tableBuilder.pool(poolBuilder);
                }
            });
        }
	}

	private static void addItemGroups() {
		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup." + ADReference.MOD_ID + ".item_group"))
				.icon(() -> new ItemStack(ADItems.ENDERMAN_PLUSH))
				.entries((context, entries) -> {
                    ADJsonConfigCategory buildingCategory = ADConfig.CONFIG
                            .getCategory("building");
                    ADJsonConfigCategory dyedSubcategory = buildingCategory
                            .getSubcategory("dyed");
                    ADJsonConfigCategory hostilePlushiesSubcategory = buildingCategory
                            .getSubcategory("hostile_plushies");
                    ADJsonConfigCategory passivePlushiesSubcategory = buildingCategory
                            .getSubcategory("passive_plushies");
                    ADJsonConfigCategory neutralPlushiesSubcategory = buildingCategory
                            .getSubcategory("neutral_plushies");
                    ADJsonConfigCategory farmingCategory = ADConfig.CONFIG
                            .getCategory("farming");

                    if (hostilePlushiesSubcategory.getEntry("enable_slime_plush").getValueAsBool()) {
                        entries.add(ADItems.SLIME_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_magma_cube_plush").getValueAsBool()) {
                        entries.add(ADItems.MAGMA_CUBE_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_ocelot_plush").getValueAsBool()) {
                        entries.add(ADItems.OCELOT_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_cat_plushies").getValueAsBool()) {
                        entries.add(ADItems.TABBY_CAT_PLUSH);
                        entries.add(ADItems.TUXEDO_CAT_PLUSH);
                        entries.add(ADItems.RED_CAT_PLUSH);
                        entries.add(ADItems.SIAMESE_CAT_PLUSH);
                        entries.add(ADItems.BRITISH_SHORTHAIR_CAT_PLUSH);
                        entries.add(ADItems.CALICO_CAT_PLUSH);
                        entries.add(ADItems.PERSIAN_CAT_PLUSH);
                        entries.add(ADItems.RAGDOLL_CAT_PLUSH);
                        entries.add(ADItems.BLACK_CAT_PLUSH);
                        entries.add(ADItems.JELLIE_CAT_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_pale_wolf_plush").getValueAsBool()) {
                        entries.add(ADItems.PALE_WOLF_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_zombie_plush").getValueAsBool()) {
                        entries.add(ADItems.ZOMBIE_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_skeleton_plush").getValueAsBool()) {
                        entries.add(ADItems.SKELETON_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_enderman_plush").getValueAsBool()) {
                        entries.add(ADItems.ENDERMAN_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_creeper_plush").getValueAsBool()) {
                        entries.add(ADItems.CREEPER_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_spider_plush").getValueAsBool()) {
                        entries.add(ADItems.SPIDER_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_cave_spider_plush").getValueAsBool()) {
                        entries.add(ADItems.CAVE_SPIDER_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_guardian_plush").getValueAsBool()) {
                        entries.add(ADItems.GUARDIAN_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_phantom_plush").getValueAsBool()) {
                        entries.add(ADItems.PHANTOM_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_bat_plush").getValueAsBool()) {
                        entries.add(ADItems.BAT_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_squid_plushies").getValueAsBool()) {
                        entries.add(ADItems.SQUID_PLUSH);
                        entries.add(ADItems.GLOW_SQUID_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_bee_plush").getValueAsBool()) {
                        entries.add(ADItems.BEE_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_piglin_plushies").getValueAsBool()) {
                        entries.add(ADItems.PIGLIN_PLUSH);
                        entries.add(ADItems.ZOMBIFIED_PIGLIN_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_hoglin_plushies").getValueAsBool()) {
                        entries.add(ADItems.HOGLIN_PLUSH);
                        entries.add(ADItems.ZOGLIN_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_ghast_plush").getValueAsBool()) {
                        entries.add(ADItems.GHAST_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_blaze_plush").getValueAsBool()) {
                        entries.add(ADItems.BLAZE_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_strider_plushies").getValueAsBool()) {
                        entries.add(ADItems.STRIDER_PLUSH);
                        entries.add(ADItems.SHIVERING_STRIDER_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_chicken_plush").getValueAsBool()) {
                        entries.add(ADItems.CHICKEN_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_pig_plush").getValueAsBool()) {
                        entries.add(ADItems.PIG_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_cow_plush").getValueAsBool()) {
                        entries.add(ADItems.COW_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_mooshroom_plushies").getValueAsBool()) {
                        entries.add(ADItems.RED_MOOSHROOM_PLUSH);
                        entries.add(ADItems.BROWN_MOOSHROOM_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_sheep_plushies").getValueAsBool()) {
                        entries.add(ADItems.WHITE_SHEEP_PLUSH);
                        entries.add(ADItems.ORANGE_SHEEP_PLUSH);
                        entries.add(ADItems.MAGENTA_SHEEP_PLUSH);
                        entries.add(ADItems.LIGHT_BLUE_SHEEP_PLUSH);
                        entries.add(ADItems.YELLOW_SHEEP_PLUSH);
                        entries.add(ADItems.LIME_SHEEP_PLUSH);
                        entries.add(ADItems.PINK_SHEEP_PLUSH);
                        entries.add(ADItems.GRAY_SHEEP_PLUSH);
                        entries.add(ADItems.LIGHT_GRAY_SHEEP_PLUSH);
                        entries.add(ADItems.CYAN_SHEEP_PLUSH);
                        entries.add(ADItems.PURPLE_SHEEP_PLUSH);
                        entries.add(ADItems.BLUE_SHEEP_PLUSH);
                        entries.add(ADItems.BROWN_SHEEP_PLUSH);
                        entries.add(ADItems.RED_SHEEP_PLUSH);
                        entries.add(ADItems.GREEN_SHEEP_PLUSH);
                        entries.add(ADItems.BLACK_SHEEP_PLUSH);
                        entries.add(ADItems.MAROON_SHEEP_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_horse_plushies").getValueAsBool()) {
                        entries.add(ADItems.WHITE_HORSE_PLUSH);
                        entries.add(ADItems.GRAY_HORSE_PLUSH);
                        entries.add(ADItems.LIGHT_GRAY_HORSE_PLUSH);
                        entries.add(ADItems.BROWN_HORSE_PLUSH);
                        entries.add(ADItems.BLACK_HORSE_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_rabbit_plushies").getValueAsBool()) {
                        entries.add(ADItems.BROWN_RABBIT_PLUSH);
                        entries.add(ADItems.WHITE_RABBIT_PLUSH);
                        entries.add(ADItems.BLACK_RABBIT_PLUSH);
                        entries.add(ADItems.WHITE_SPLOTCHED_RABBIT_PLUSH);
                        entries.add(ADItems.GOLD_RABBIT_PLUSH);
                        entries.add(ADItems.TOAST_RABBIT_PLUSH);
                        entries.add(ADItems.SALT_RABBIT_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_illager_plushies").getValueAsBool()) {
                        entries.add(ADItems.PILLAGER_PLUSH);
                        entries.add(ADItems.VINDICATOR_PLUSH);
                        entries.add(ADItems.EVOKER_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_villager_plushies").getValueAsBool()) {
                        entries.add(ADItems.PLAINS_VILLAGER_PLUSH);
                        entries.add(ADItems.DESERT_VILLAGER_PLUSH);
                        entries.add(ADItems.JUNGLE_VILLAGER_PLUSH);
                        entries.add(ADItems.SAVANNA_VILLAGER_PLUSH);
                        entries.add(ADItems.SNOW_VILLAGER_PLUSH);
                        entries.add(ADItems.SWAMP_VILLAGER_PLUSH);
                        entries.add(ADItems.TAIGA_VILLAGER_PLUSH);
                        entries.add(ADItems.CRIMSON_VILLAGER_PLUSH);
                        entries.add(ADItems.WARPED_VILLAGER_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_wandering_trader_plush").getValueAsBool()) {
                        entries.add(ADItems.WANDERING_TRADER_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_zombie_villager_plushies").getValueAsBool()) {
                        entries.add(ADItems.PLAINS_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.DESERT_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.JUNGLE_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.SAVANNA_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.SNOW_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.SWAMP_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.TAIGA_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.CRIMSON_ZOMBIE_VILLAGER_PLUSH);
                        entries.add(ADItems.WARPED_ZOMBIE_VILLAGER_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_witch_plush").getValueAsBool()) {
                        entries.add(ADItems.WITCH_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_pufferfish_plush").getValueAsBool()) {
                        entries.add(ADItems.PUFFERFISH_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_wither_plush").getValueAsBool()) {
                        entries.add(ADItems.WITHER_PLUSH);
                    }

                    if (neutralPlushiesSubcategory.getEntry("enable_polar_bear_plush").getValueAsBool()) {
                        entries.add(ADItems.POLAR_BEAR_PLUSH);
                    }

                    if (passivePlushiesSubcategory.getEntry("enable_allay_plush").getValueAsBool()) {
                        entries.add(ADItems.ALLAY_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_vex_plush").getValueAsBool()) {
                        entries.add(ADItems.VEX_PLUSH);
                    }

                    if (hostilePlushiesSubcategory.getEntry("enable_ravager_plush").getValueAsBool()) {
                        entries.add(ADItems.RAVAGER_PLUSH);
                    }

					if (hostilePlushiesSubcategory.getEntry("enable_shulker_plush").getValueAsBool()) {
                        entries.add(ADItems.SHULKER_PLUSH);
                    }

					if (passivePlushiesSubcategory.getEntry("enable_camel_plush").getValueAsBool()) {
                        entries.add(ADItems.CAMEL_PLUSH);
                    }

                    if (farmingCategory.getEntry("enable_wooden_planter_boxes").getValueAsBool()) {
                        entries.add(ADItems.OAK_PLANTER_BOX);
                        entries.add(ADItems.SPRUCE_PLANTER_BOX);
                        entries.add(ADItems.BIRCH_PLANTER_BOX);
                        entries.add(ADItems.JUNGLE_PLANTER_BOX);
                        entries.add(ADItems.ACACIA_PLANTER_BOX);
                        entries.add(ADItems.DARK_OAK_PLANTER_BOX);
                        entries.add(ADItems.MANGROVE_PLANTER_BOX);
                        entries.add(ADItems.CHERRY_PLANTER_BOX);
                        entries.add(ADItems.BAMBOO_PLANTER_BOX);
                        entries.add(ADItems.CRIMSON_PLANTER_BOX);
                        entries.add(ADItems.WARPED_PLANTER_BOX);
                    }

                    if (buildingCategory.getEntry("enable_woodcutter")
                            .getValueAsBool()) {
                        entries.add(ADItems.WOODCUTTER);
                    }

                    if (buildingCategory.getEntry("enable_wooden_walls")
                            .getValueAsBool()) {
                        entries.add(ADItems.OAK_WALL);
                        entries.add(ADItems.SPRUCE_WALL);
                        entries.add(ADItems.BIRCH_WALL);
                        entries.add(ADItems.JUNGLE_WALL);
                        entries.add(ADItems.ACACIA_WALL);
                        entries.add(ADItems.DARK_OAK_WALL);
                        entries.add(ADItems.MANGROVE_WALL);
                        entries.add(ADItems.CHERRY_WALL);
                        entries.add(ADItems.CRIMSON_WALL);
                        entries.add(ADItems.WARPED_WALL);
                    }

                    if (buildingCategory.getEntry("enable_stripped_wooden_walls").getValueAsBool()) {
                        entries.add(ADItems.STRIPPED_OAK_WALL);
                        entries.add(ADItems.STRIPPED_SPRUCE_WALL);
                        entries.add(ADItems.STRIPPED_BIRCH_WALL);
                        entries.add(ADItems.STRIPPED_JUNGLE_WALL);
                        entries.add(ADItems.STRIPPED_ACACIA_WALL);
                        entries.add(ADItems.STRIPPED_DARK_OAK_WALL);
                        entries.add(ADItems.STRIPPED_MANGROVE_WALL);
                        entries.add(ADItems.STRIPPED_CHERRY_WALL);
                        entries.add(ADItems.STRIPPED_CRIMSON_WALL);
                        entries.add(ADItems.STRIPPED_WARPED_WALL);
                    }

                    if (buildingCategory.getEntry("enable_wooden_rope_ladders").getValueAsBool()) {
                        entries.add(ADItems.OAK_ROPE_LADDER);
                        entries.add(ADItems.SPRUCE_ROPE_LADDER);
                        entries.add(ADItems.BIRCH_ROPE_LADDER);
                        entries.add(ADItems.JUNGLE_ROPE_LADDER);
                        entries.add(ADItems.ACACIA_ROPE_LADDER);
                        entries.add(ADItems.DARK_OAK_ROPE_LADDER);
                        entries.add(ADItems.MANGROVE_ROPE_LADDER);
                        entries.add(ADItems.CHERRY_ROPE_LADDER);
                        entries.add(ADItems.CRIMSON_ROPE_LADDER);
                        entries.add(ADItems.WARPED_ROPE_LADDER);
                    }

                    if (buildingCategory.getEntry("enable_iron_ladders").getValueAsBool()) {
                        entries.add(ADItems.IRON_LADDER);
                    }

                    if (dyedSubcategory.getEntry("enable_dyed_campfires").getValueAsBool()) {
                        entries.add(ADItems.WHITE_CAMPFIRE);
                        entries.add(ADItems.ORANGE_CAMPFIRE);
                        entries.add(ADItems.MAGENTA_CAMPFIRE);
                        entries.add(ADItems.LIGHT_BLUE_CAMPFIRE);
                        entries.add(ADItems.YELLOW_CAMPFIRE);
                        entries.add(ADItems.LIME_CAMPFIRE);
                        entries.add(ADItems.PINK_CAMPFIRE);
                        entries.add(ADItems.GRAY_CAMPFIRE);
                        entries.add(ADItems.LIGHT_GRAY_CAMPFIRE);
                        entries.add(ADItems.CYAN_CAMPFIRE);
                        entries.add(ADItems.PURPLE_CAMPFIRE);
                        entries.add(ADItems.BLUE_CAMPFIRE);
                        entries.add(ADItems.BROWN_CAMPFIRE);
                        entries.add(ADItems.GREEN_CAMPFIRE);
                        entries.add(ADItems.RED_CAMPFIRE);
                        entries.add(ADItems.BLACK_CAMPFIRE);
                        entries.add(ADItems.MAROON_CAMPFIRE);
                    }

                    if (dyedSubcategory.getEntry("enable_dyed_lanterns").getValueAsBool()) {
                        entries.add(ADItems.WHITE_LANTERN);
                        entries.add(ADItems.ORANGE_LANTERN);
                        entries.add(ADItems.MAGENTA_LANTERN);
                        entries.add(ADItems.LIGHT_BLUE_LANTERN);
                        entries.add(ADItems.YELLOW_LANTERN);
                        entries.add(ADItems.LIME_LANTERN);
                        entries.add(ADItems.PINK_LANTERN);
                        entries.add(ADItems.GRAY_LANTERN);
                        entries.add(ADItems.LIGHT_GRAY_LANTERN);
                        entries.add(ADItems.CYAN_LANTERN);
                        entries.add(ADItems.PURPLE_LANTERN);
                        entries.add(ADItems.BLUE_LANTERN);
                        entries.add(ADItems.BROWN_LANTERN);
                        entries.add(ADItems.GREEN_LANTERN);
                        entries.add(ADItems.RED_LANTERN);
                        entries.add(ADItems.BLACK_LANTERN);
                        entries.add(ADItems.MAROON_LANTERN);
                    }

                    if (dyedSubcategory.getEntry("enable_dyed_torches").getValueAsBool()) {
                        entries.add(ADItems.WHITE_TORCH);
                        entries.add(ADItems.ORANGE_TORCH);
                        entries.add(ADItems.MAGENTA_TORCH);
                        entries.add(ADItems.LIGHT_BLUE_TORCH);
                        entries.add(ADItems.YELLOW_TORCH);
                        entries.add(ADItems.LIME_TORCH);
                        entries.add(ADItems.PINK_TORCH);
                        entries.add(ADItems.GRAY_TORCH);
                        entries.add(ADItems.LIGHT_GRAY_TORCH);
                        entries.add(ADItems.CYAN_TORCH);
                        entries.add(ADItems.PURPLE_TORCH);
                        entries.add(ADItems.BLUE_TORCH);
                        entries.add(ADItems.BROWN_TORCH);
                        entries.add(ADItems.GREEN_TORCH);
                        entries.add(ADItems.RED_TORCH);
                        entries.add(ADItems.BLACK_TORCH);
                        entries.add(ADItems.MAROON_TORCH);
                    }

                    if (buildingCategory.getEntry("enable_twisted_netherrack").getValueAsBool()) {
                        entries.add(ADItems.TWISTED_NETHERRACK);
                        entries.add(ADItems.TWISTED_NETHERRACK_STAIRS);
                        entries.add(ADItems.TWISTED_NETHERRACK_SLAB);
                        entries.add(ADItems.TWISTED_NETHERRACK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_netherrack").getValueAsBool()) {
                        entries.add(ADItems.WEEPING_NETHERRACK);
                        entries.add(ADItems.WEEPING_NETHERRACK_STAIRS);
                        entries.add(ADItems.WEEPING_NETHERRACK_SLAB);
                        entries.add(ADItems.WEEPING_NETHERRACK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_nether_bricks").getValueAsBool()) {
                        entries.add(ADItems.TWISTED_NETHER_BRICKS);
                        entries.add(ADItems.TWISTED_NETHER_BRICK_STAIRS);
                        entries.add(ADItems.TWISTED_NETHER_BRICK_SLAB);
                        entries.add(ADItems.TWISTED_NETHER_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_nether_bricks").getValueAsBool()) {
                        entries.add(ADItems.WEEPING_NETHER_BRICKS);
                        entries.add(ADItems.WEEPING_NETHER_BRICK_STAIRS);
                        entries.add(ADItems.WEEPING_NETHER_BRICK_SLAB);
                        entries.add(ADItems.WEEPING_NETHER_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_blackstone").getValueAsBool()) {
                        entries.add(ADItems.TWISTED_BLACKSTONE);
                        entries.add(ADItems.TWISTED_BLACKSTONE_STAIRS);
                        entries.add(ADItems.TWISTED_BLACKSTONE_SLAB);
                        entries.add(ADItems.TWISTED_BLACKSTONE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_blackstone").getValueAsBool()) {
                        entries.add(ADItems.WEEPING_BLACKSTONE);
                        entries.add(ADItems.WEEPING_BLACKSTONE_STAIRS);
                        entries.add(ADItems.WEEPING_BLACKSTONE_SLAB);
                        entries.add(ADItems.WEEPING_BLACKSTONE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_polished_blackstone_bricks")
                            .getValueAsBool()) {
                        entries.add(ADItems.TWISTED_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(ADItems.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ADItems.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ADItems.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_polished_blackstone_bricks")
                            .getValueAsBool()) {
                        entries.add(ADItems.WEEPING_POLISHED_BLACKSTONE_BRICKS);
                        entries.add(ADItems.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ADItems.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ADItems.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_blackstone_tiles").getValueAsBool()) {
                        entries.add(ADItems.BLACKSTONE_TILES);
                        entries.add(ADItems.BLACKSTONE_TILE_STAIRS);
                        entries.add(ADItems.BLACKSTONE_TILE_SLAB);
                        entries.add(ADItems.BLACKSTONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_twisted_blackstone_tiles").getValueAsBool()) {
                        entries.add(ADItems.TWISTED_BLACKSTONE_TILES);
                        entries.add(ADItems.TWISTED_BLACKSTONE_TILE_STAIRS);
                        entries.add(ADItems.TWISTED_BLACKSTONE_TILE_SLAB);
                        entries.add(ADItems.TWISTED_BLACKSTONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_weeping_blackstone_tiles").getValueAsBool()) {
                        entries.add(ADItems.WEEPING_BLACKSTONE_TILES);
                        entries.add(ADItems.WEEPING_BLACKSTONE_TILE_STAIRS);
                        entries.add(ADItems.WEEPING_BLACKSTONE_TILE_SLAB);
                        entries.add(ADItems.WEEPING_BLACKSTONE_TILE_WALL);
                    }

                    boolean enableSmokyQuartzBlocks = buildingCategory.getEntry("enable_smoky_quartz_blocks")
                            .getValueAsBool();
                    boolean enableSmokyQuartzBricks = buildingCategory.getEntry("enable_smoky_quartz_bricks")
                            .getValueAsBool();
                    boolean enableSmoothSmokyQuartz = buildingCategory.getEntry("enable_smooth_smoky_quartz")
                            .getValueAsBool();

                    if (enableSmokyQuartzBlocks) {
                        entries.add(ADItems.NETHER_SMOKY_QUARTZ_ORE);
                        entries.add(ADItems.SMOKY_QUARTZ);
                        entries.add(ADItems.SMOKY_QUARTZ_BLOCK);
                        entries.add(ADItems.SMOKY_QUARTZ_STAIRS);
                        entries.add(ADItems.SMOKY_QUARTZ_SLAB);
                        entries.add(ADItems.SMOKY_QUARTZ_WALL);
                    }

                    if (enableSmokyQuartzBlocks && enableSmokyQuartzBricks) {
                        entries.add(ADItems.SMOKY_QUARTZ_BRICKS);
                        entries.add(ADItems.SMOKY_QUARTZ_BRICK_STAIRS);
                        entries.add(ADItems.SMOKY_QUARTZ_BRICK_SLAB);
                        entries.add(ADItems.SMOKY_QUARTZ_BRICK_WALL);
                        entries.add(ADItems.CHISELED_SMOKY_QUARTZ_BLOCK);
                        entries.add(ADItems.SMOKY_QUARTZ_PILLAR);
                    }

                    if (enableSmokyQuartzBlocks && enableSmoothSmokyQuartz) {
                        entries.add(ADItems.SMOOTH_SMOKY_QUARTZ);
                        entries.add(ADItems.SMOOTH_SMOKY_QUARTZ_STAIRS);
                        entries.add(ADItems.SMOOTH_SMOKY_QUARTZ_SLAB);
                        entries.add(ADItems.SMOOTH_SMOKY_QUARTZ_WALL);
                    }

                    if (buildingCategory.getEntry("enable_quartz_tiles").getValueAsBool()) {
                        entries.add(ADItems.QUARTZ_TILES);
                        entries.add(ADItems.QUARTZ_TILE_STAIRS);
                        entries.add(ADItems.QUARTZ_TILE_SLAB);
                        entries.add(ADItems.QUARTZ_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_quartz_walls").getValueAsBool()) {
                        entries.add(ADItems.QUARTZ_WALL);
                        entries.add(ADItems.SMOOTH_QUARTZ_WALL);
                    }

                    if (buildingCategory.getEntry("enable_bauxite").getValueAsBool()) {
                        entries.add(ADItems.BAUXITE);
                        entries.add(ADItems.BAUXITE_SLAB);
                        entries.add(ADItems.BAUXITE_STAIRS);
                        entries.add(ADItems.BAUXITE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_bauxite_bricks").getValueAsBool()) {
                        entries.add(ADItems.BAUXITE_BRICKS);
                        entries.add(ADItems.BAUXITE_BRICK_STAIRS);
                        entries.add(ADItems.BAUXITE_BRICK_SLAB);
                        entries.add(ADItems.BAUXITE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_cracked_bauxite_bricks").getValueAsBool()) {
                        entries.add(ADItems.CRACKED_BAUXITE_BRICKS);
                        entries.add(ADItems.CRACKED_BAUXITE_BRICK_STAIRS);
                        entries.add(ADItems.CRACKED_BAUXITE_BRICK_SLAB);
                        entries.add(ADItems.CRACKED_BAUXITE_BRICK_WALL);
                    }

					if (buildingCategory.getEntry("enable_mossy_bauxite_bricks").getValueAsBool()) {
                        entries.add(ADItems.MOSSY_BAUXITE_BRICKS);
                        entries.add(ADItems.MOSSY_BAUXITE_BRICK_STAIRS);
                        entries.add(ADItems.MOSSY_BAUXITE_BRICK_SLAB);
                        entries.add(ADItems.MOSSY_BAUXITE_BRICK_WALL);
                    }

                    if (buildingCategory.getEntry("enable_stone_tiles").getValueAsBool()) {
                        entries.add(ADItems.STONE_TILES);
                        entries.add(ADItems.STONE_TILE_SLAB);
                        entries.add(ADItems.STONE_TILE_STAIRS);
                        entries.add(ADItems.STONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_cracked_stone_tiles").getValueAsBool()) {
                        entries.add(ADItems.CRACKED_STONE_TILES);
                        entries.add(ADItems.CRACKED_STONE_TILE_SLAB);
                        entries.add(ADItems.CRACKED_STONE_TILE_STAIRS);
                        entries.add(ADItems.CRACKED_STONE_TILE_WALL);
                    }

                    if (buildingCategory.getEntry("enable_mossy_stone_tiles").getValueAsBool()) {
                        entries.add(ADItems.MOSSY_STONE_TILES);
                        entries.add(ADItems.MOSSY_STONE_TILE_SLAB);
                        entries.add(ADItems.MOSSY_STONE_TILE_STAIRS);
                        entries.add(ADItems.MOSSY_STONE_TILE_WALL);
                    }


					entries.add(ADItems.CRACKED_STONE_BRICK_STAIRS);
					entries.add(ADItems.CRACKED_STONE_BRICK_SLAB);
					entries.add(ADItems.CRACKED_STONE_BRICK_WALL);
					entries.add(ADItems.STONE_WALL);
					entries.add(ADItems.CALCITE_STAIRS);
					entries.add(ADItems.CALCITE_SLAB);
					entries.add(ADItems.CALCITE_WALL);
					entries.add(ADItems.POLISHED_CALCITE);
					entries.add(ADItems.POLISHED_CALCITE_STAIRS);
					entries.add(ADItems.POLISHED_CALCITE_SLAB);
					entries.add(ADItems.POLISHED_CALCITE_WALL);
					entries.add(ADItems.CALCITE_BRICKS);
					entries.add(ADItems.CALCITE_BRICK_STAIRS);
					entries.add(ADItems.CALCITE_BRICK_SLAB);
					entries.add(ADItems.CALCITE_BRICK_WALL);
					entries.add(ADItems.CRACKED_CALCITE_BRICKS);
					entries.add(ADItems.CRACKED_CALCITE_BRICK_STAIRS);
					entries.add(ADItems.CRACKED_CALCITE_BRICK_SLAB);
					entries.add(ADItems.CRACKED_CALCITE_BRICK_WALL);
					entries.add(ADItems.CHISELED_CALCITE_BRICKS);
					entries.add(ADItems.MOSSY_CALCITE_BRICKS);
					entries.add(ADItems.MOSSY_CALCITE_BRICK_STAIRS);
					entries.add(ADItems.MOSSY_CALCITE_BRICK_SLAB);
					entries.add(ADItems.MOSSY_CALCITE_BRICK_WALL);
					entries.add(ADItems.DRIPSTONE_STAIRS);
					entries.add(ADItems.DRIPSTONE_SLAB);
					entries.add(ADItems.DRIPSTONE_WALL);
					entries.add(ADItems.POLISHED_DRIPSTONE);
					entries.add(ADItems.POLISHED_DRIPSTONE_STAIRS);
					entries.add(ADItems.POLISHED_DRIPSTONE_SLAB);
					entries.add(ADItems.POLISHED_DRIPSTONE_WALL);
					entries.add(ADItems.DRIPSTONE_BRICKS);
					entries.add(ADItems.DRIPSTONE_BRICK_STAIRS);
					entries.add(ADItems.DRIPSTONE_BRICK_SLAB);
					entries.add(ADItems.DRIPSTONE_BRICK_WALL);
					entries.add(ADItems.CRACKED_DRIPSTONE_BRICKS);
					entries.add(ADItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
					entries.add(ADItems.CRACKED_DRIPSTONE_BRICK_SLAB);
					entries.add(ADItems.CRACKED_DRIPSTONE_BRICK_WALL);
					entries.add(ADItems.CHISELED_DRIPSTONE_BRICKS);
					entries.add(ADItems.MOSSY_DRIPSTONE_BRICKS);
					entries.add(ADItems.MOSSY_DRIPSTONE_BRICK_STAIRS);
					entries.add(ADItems.MOSSY_DRIPSTONE_BRICK_SLAB);
					entries.add(ADItems.MOSSY_DRIPSTONE_BRICK_WALL);

					entries.add(ADItems.SNOW_BRICKS);
					entries.add(ADItems.SNOW_BRICK_STAIRS);
					entries.add(ADItems.SNOW_BRICK_SLAB);
					entries.add(ADItems.SNOW_BRICK_WALL);

					entries.add(ADItems.PACKED_SNOW);
					entries.add(ADItems.PACKED_SNOW_STAIRS);
					entries.add(ADItems.PACKED_SNOW_SLAB);
					entries.add(ADItems.PACKED_SNOW_WALL);

					entries.add(ADItems.MAROON_WOOL);
					entries.add(ADItems.MAROON_CONCRETE);
					entries.add(ADItems.MAROON_CONCRETE_POWDER);
					entries.add(ADItems.MAROON_STAINED_GLASS);
					entries.add(ADItems.MAROON_STAINED_GLASS_PANE);
					entries.add(ADItems.MAROON_CANDLE);

                    entries.add(ADItems.GRASS_SLAB);
                    entries.add(ADItems.PODZOL_SLAB);
                    entries.add(ADItems.MYCELIUM_SLAB);
                    entries.add(ADItems.DIRT_PATH_SLAB);
                    entries.add(ADItems.DIRT_SLAB);
                    entries.add(ADItems.ROOTED_DIRT_SLAB);
                    entries.add(ADItems.COARSE_DIRT_SLAB);

                    if (farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
                        entries.add(ADItems.PURPLE_MUSHROOM_BLOCK);
                    }

                    if (farmingCategory.getEntry("enable_chocolate_cake").getValueAsBool()) {
                        entries.add(ADItems.CHOCOLATE_CAKE);
                    }

                    if (farmingCategory.getEntry("enable_red_velvet_cake").getValueAsBool()) {
                        entries.add(ADItems.RED_VELVET_CAKE);
                    }

                    if (farmingCategory.getEntry("enable_sweet_berry_pie").getValueAsBool()) {
                        entries.add(ADItems.SWEET_BERRY_PIE);
                    }

                    if (farmingCategory.getEntry("enable_blueberries").getValueAsBool()
                            && farmingCategory.getEntry("enable_blueberry_pie").getValueAsBool()) {
                        entries.add(ADItems.BLUEBERRY_PIE);
                    }

                    if (farmingCategory.getEntry("enable_green_onions").getValueAsBool()) {
                        entries.add(ADItems.WILD_GREEN_ONIONS);
                        entries.add(ADItems.GREEN_ONION_SEEDS);
                        entries.add(ADItems.GREEN_ONION);
                    }

                    if (farmingCategory.getEntry("enable_noodle_soup").getValueAsBool()) {
                        entries.add(ADItems.NOODLES);
                        entries.add(ADItems.NOODLE_SOUP);
                    }

                    if (farmingCategory.getEntry("enable_blueberries").getValueAsBool()) {
                        entries.add(ADItems.BLUEBERRIES);
                    }

                    if (farmingCategory.getEntry("enable_nether_berries").getValueAsBool()) {
                        entries.add(ADItems.CINDERSNAP_BERRIES);
                        entries.add(ADItems.FROSTBITE_BERRIES);
                    }

                    if (farmingCategory.getEntry("enable_cattails").getValueAsBool()) {
                        entries.add(ADItems.CATTAIL);
                    }

                    if (farmingCategory.getEntry("enable_bog_blossoms").getValueAsBool()) {
                        entries.add(ADItems.BOG_BLOSSOM);
                    }

                    if (farmingCategory.getEntry("enable_ender_plants").getValueAsBool()) {
                        entries.add(ADItems.SNAPDRAGON);
                        entries.add(ADItems.SHORT_ENDER_GRASS);
                    }

                    if (farmingCategory.getEntry("enable_purple_mushrooms").getValueAsBool()) {
                        entries.add(ADItems.PURPLE_MUSHROOM);
                    }

                    if (farmingCategory.getEntry("enable_caramel_apple").getValueAsBool()) {
                        entries.add(ADItems.CARAMEL_APPLE);
                        entries.add(ADItems.CARAMEL);
                    }

                    if (farmingCategory.getEntry("enable_fried_egg").getValueAsBool()) {
                        entries.add(ADItems.FRIED_EGG);
                    }

                    if (farmingCategory.getEntry("enable_blood_kelp").getValueAsBool()) {
                        entries.add(ADItems.DRIED_BLOOD_KELP_BLOCK);
                        entries.add(ADItems.BLOOD_KELP_LANTERN);
                        entries.add(ADItems.BLOOD_KELP_SEED_CLUSTER);
                        entries.add(ADItems.BLOOD_KELP);
                        entries.add(ADItems.DRIED_BLOOD_KELP);
                    }

                    if (farmingCategory.getEntry("enable_hoglin_stew").getValueAsBool()) {
                        entries.add(ADItems.HOGLIN_STEW);
                    }

                    if (farmingCategory.getEntry("enable_forests_bounty").getValueAsBool()) {
                        entries.add(ADItems.FORESTS_BOUNTY);
                        entries.add(ADItems.SPRUCE_CONE);
                    }

                    if (farmingCategory.getEntry("enable_witchs_cradle_soup").getValueAsBool()) {
                        entries.add(ADItems.WITCHS_CRADLE_SOUP);
                        entries.add(ADItems.WITCHS_CRADLE_BRANCH);
                    }

                    if (farmingCategory.getEntry("enable_pudding").getValueAsBool()) {
                        entries.add(ADItems.BERRY_PUDDING);
                        entries.add(ADItems.PUDDING);
                    }

                    if (farmingCategory.getEntry("enable_blueberries").getValueAsBool()
                            && farmingCategory.getEntry("enable_blueberry_juice").getValueAsBool()) {
                        entries.add(ADItems.BLUEBERRY_JUICE);
                    }

                    if (farmingCategory.getEntry("enable_sweet_berry_juice").getValueAsBool()) {
                        entries.add(ADItems.SWEET_BERRY_JUICE);
                    }

					entries.add(ADItems.MAROON_DYE);
				}).build());
	}
}
