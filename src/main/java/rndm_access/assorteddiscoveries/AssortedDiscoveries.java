package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
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
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rndm_access.assorteddiscoveries.config.BooleanEntriesS2CPayload;
import rndm_access.assorteddiscoveries.config.ModServerConfig;
import rndm_access.assorteddiscoveries.config.ModServerConfigKeys;
import rndm_access.assorteddiscoveries.config.ModClientConfig;
import rndm_access.assorteddiscoveries.config.json.ServerConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;
import rndm_access.assorteddiscoveries.core.ModResourceConditionTypes;
import rndm_access.assorteddiscoveries.core.*;

import java.util.Optional;

public class AssortedDiscoveries implements ModInitializer {
    public static final String MOD_ID = "assorted-discoveries";
    public static final Logger LOGGER = LoggerFactory.getLogger("AssortedDiscoveries");
    private static final RegistryKey<ItemGroup> MOD_ITEM_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, makeModId("item_group"));
    public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.ENDERMAN_PLUSHIE.asItem()))
            .displayName(Text.translatable("itemGroup." + MOD_ID))
            .build();

    @Override
    public void onInitialize() {
        // Config
        AssortedDiscoveries.registerConfigEvents();
        ModResourceConditionTypes.register();

        // General Registries
        ModBlocks.register();
        ModItems.register();
        AssortedDiscoveries.addItemGroups();
        ModBlockEntityTypes.register();
        ModParticleTypes.register();
        ModSoundEvents.register();
        AssortedDiscoveries.registerFuel();
        AssortedDiscoveries.registerCompostables();
        AssortedDiscoveries.modifyLootTables();
        AssortedDiscoveries.registerVillagerInteractions();

        // World Generation Registries
        ModFeatures.register();
        AssortedDiscoveries.addFeaturesToBiomes();
    }

    public static Identifier makeModId(String path) {
        return Identifier.of(MOD_ID, path);
    }

    private static void registerConfigEvents() {
        PayloadTypeRegistry.playS2C().register(BooleanEntriesS2CPayload.ID, BooleanEntriesS2CPayload.CODEC);

        ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
            if (!server.getOverworld().isClient()) {
                ModClientConfig.updateBoolEntries(ModServerConfig.getInstance().toEntryMap());
                LOGGER.info("Loaded server config");
            }
        });

        ServerPlayerEvents.JOIN.register((player) -> {
            if (!player.getWorld().isClient) {
                BooleanEntriesS2CPayload payload = new BooleanEntriesS2CPayload(ModClientConfig.getBoolEntries());
                String playerName = player.getName().getString();

                if (ServerPlayNetworking.canSend(player, payload.getId())) {
                    ServerPlayNetworking.send(player, payload);
                    LOGGER.info("Sent server config data to {}!", playerName);
                }
            }
        });
    }

    private static void registerVillagerInteractions() {
        VillagerInteractionRegistries.registerCompostable(ModItems.GREEN_ONION);
        VillagerInteractionRegistries.registerFood(ModItems.GREEN_ONION, 1);
    }

    private static void addFeaturesToBiomes() {
        ServerConfig config = ModServerConfig.getInstance();
        BooleanConfigEntry configEntry;

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_CATTAILS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CATTAIL_SWAMP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_SWAMP);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CATTAIL_RIVER),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_RIVER);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_SMOKY_QUARTZ),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_SMOKY_QUARTZ);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_PURPLE_MUSHROOMS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_HUGE_PURPLE_MUSHROOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_HUGE_PURPLE_MUSHROOM);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_BLUEBERRIES);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_BLUEBERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_WITCHS_CRADLES);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_ENDER_PLANTS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_ENDER_PLANTS),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_ENDER_PLANTS);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_BLOOD_KELP);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.BLOOD_KELP),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.BLOOD_KELP);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_BOG_BLOSSOMS);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.BOG_BLOSSOM),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.BOG_BLOSSOM);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_BAUXITE);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_LOWER);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                    GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_UPPER);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_CINDERSNAP_BERRIES);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_FROSTBITE_BERRIES);
        if (configEntry.getValue()) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_RARE);
        }

        configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_GREEN_ONIONS);
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

    private static void modifyLootTables() {
        Optional<RegistryKey<LootTable>> spruceLeavesLootTableId = Blocks.SPRUCE_LEAVES.getLootTableKey();

        LootTableEvents.MODIFY.register((key, tableBuilder, source,
                                         registries) -> {
            if(source.isBuiltin() && spruceLeavesLootTableId.isPresent() && spruceLeavesLootTableId.get().equals(key)) {
                modifySpruceLeavesLootTable(registries, tableBuilder);
            }
        });
    }

    private static void modifySpruceLeavesLootTable(RegistryWrapper.WrapperLookup registries, LootTable.Builder builder) {
        ServerConfig config = ModServerConfig.getInstance();
        BooleanConfigEntry configEntry = (BooleanConfigEntry) config.getEntry(ModServerConfigKeys.ENABLE_FORESTS_BOUNTY);

        if (configEntry.getValue()) {
            Optional<RegistryEntry.Reference<Enchantment>> fortune = registries.getOptionalEntry(Enchantments.FORTUNE);
            assert fortune.isPresent();
            RegistryEntry<Enchantment> fortuneEnchant = RegistryEntry.of(fortune.get().value());

            LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(TableBonusLootCondition.builder(fortuneEnchant, 0.02F, 0.023F,
                            0.025F, 0.035F, 0.1F))
                    .with(ItemEntry.builder(ModItems.SPRUCE_CONE))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)));

            builder.pool(poolBuilder);
        }
    }

    private static void addItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MOD_ITEM_GROUP_KEY, MOD_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(MOD_ITEM_GROUP_KEY).register((entries) -> {
            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SLIME_PLUSHIE)) {
                entries.add(ModBlocks.SLIME_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE)) {
                entries.add(ModBlocks.MAGMA_CUBE_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CAT_PLUSHIES)) {
                entries.add(ModBlocks.OCELOT_PLUSHIE.asItem());
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

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WOLF_PLUSHIES)) {
                entries.add(ModBlocks.PALE_WOLF_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_WOLF_PLUSHIE.asItem());
                entries.add(ModBlocks.ASHEN_WOLF_PLUSHIE.asItem());
                entries.add(ModBlocks.CHESTNUT_WOLF_PLUSHIE.asItem());
                entries.add(ModBlocks.RUSTY_WOLF_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_ZOMBIE_PLUSHIE)) {
                entries.add(ModBlocks.ZOMBIE_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SKELETON_PLUSHIE)) {
                entries.add(ModBlocks.SKELETON_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_ENDERMAN_PLUSHIE)) {
                entries.add(ModBlocks.ENDERMAN_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CREEPER_PLUSHIE)) {
                entries.add(ModBlocks.CREEPER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SPIDER_PLUSHIE)) {
                entries.add(ModBlocks.SPIDER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE)) {
                entries.add(ModBlocks.CAVE_SPIDER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_GUARDIAN_PLUSHIE)) {
                entries.add(ModBlocks.GUARDIAN_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PHANTOM_PLUSHIE)) {
                entries.add(ModBlocks.PHANTOM_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BAT_PLUSHIE)) {
                entries.add(ModBlocks.BAT_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SQUID_PLUSHIES)) {
                entries.add(ModBlocks.SQUID_PLUSHIE.asItem());
                entries.add(ModBlocks.GLOW_SQUID_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BEE_PLUSHIE)) {
                entries.add(ModBlocks.BEE_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PIGLIN_PLUSHIES)) {
                entries.add(ModBlocks.PIGLIN_PLUSHIE.asItem());
                entries.add(ModBlocks.ZOMBIFIED_PIGLIN_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_HOGLIN_PLUSHIES)) {
                entries.add(ModBlocks.HOGLIN_PLUSHIE.asItem());
                entries.add(ModBlocks.ZOGLIN_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_GHAST_PLUSHIE)) {
                entries.add(ModBlocks.GHAST_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BLAZE_PLUSHIE)) {
                entries.add(ModBlocks.BLAZE_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_STRIDER_PLUSHIES)) {
                entries.add(ModBlocks.STRIDER_PLUSHIE.asItem());
                entries.add(ModBlocks.SHIVERING_STRIDER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CHICKEN_PLUSHIES)) {
                entries.add(ModBlocks.TEMPERATE_CHICKEN_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PIG_PLUSHIES)) {
                entries.add(ModBlocks.TEMPERATE_PIG_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_COW_PLUSHIES)) {
                entries.add(ModBlocks.TEMPERATE_COW_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_MOOSHROOM_PLUSHIES)) {
                entries.add(ModBlocks.RED_MOOSHROOM_PLUSHIE.asItem());
                entries.add(ModBlocks.BROWN_MOOSHROOM_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SHEEP_PLUSHIES)) {
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

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_HORSE_PLUSHIES)) {
                entries.add(ModBlocks.WHITE_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.GRAY_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.BROWN_HORSE_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_HORSE_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_RABBIT_PLUSHIES)) {
                entries.add(ModBlocks.BROWN_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.WHITE_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.BLACK_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.WHITE_SPLOTCHED_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.GOLD_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.TOAST_RABBIT_PLUSHIE.asItem());
                entries.add(ModBlocks.SALT_RABBIT_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_ILLAGER_PLUSHIES)) {
                entries.add(ModBlocks.PILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.VINDICATOR_PLUSHIE.asItem());
                entries.add(ModBlocks.EVOKER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_VILLAGER_PLUSHIES)) {
                entries.add(ModBlocks.PLAINS_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.DESERT_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.JUNGLE_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SAVANNA_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SNOWY_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.SWAMP_VILLAGER_PLUSHIE.asItem());
                entries.add(ModBlocks.TAIGA_VILLAGER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WITCH_PLUSHIE)) {
                entries.add(ModBlocks.WITCH_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PUFFERFISH_PLUSHIE)) {
                entries.add(ModBlocks.PUFFERFISH_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WITHER_PLUSHIE)) {
                entries.add(ModBlocks.WITHER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_ALLAY_PLUSHIE)) {
                entries.add(ModBlocks.ALLAY_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_VEX_PLUSHIE)) {
                entries.add(ModBlocks.VEX_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SHULKER_PLUSHIE)) {
                entries.add(ModBlocks.SHULKER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CAMEL_PLUSHIE)) {
                entries.add(ModBlocks.CAMEL_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CREAKING_PLUSHIE)) {
                entries.add(ModBlocks.CREAKING_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SNIFFER_PLUSHIE)) {
                entries.add(ModBlocks.SNIFFER_PLUSHIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PLANTER_BOXES)) {
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

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WOODEN_WALLS)) {
                entries.add(ModBlocks.OAK_WALL.asItem());
                entries.add(ModBlocks.SPRUCE_WALL.asItem());
                entries.add(ModBlocks.BIRCH_WALL.asItem());
                entries.add(ModBlocks.JUNGLE_WALL.asItem());
                entries.add(ModBlocks.ACACIA_WALL.asItem());
                entries.add(ModBlocks.DARK_OAK_WALL.asItem());
                entries.add(ModBlocks.MANGROVE_WALL.asItem());
                entries.add(ModBlocks.CHERRY_WALL.asItem());
                entries.add(ModBlocks.BAMBOO_WALL.asItem());
                entries.add(ModBlocks.PALE_OAK_WALL.asItem());
                entries.add(ModBlocks.CRIMSON_WALL.asItem());
                entries.add(ModBlocks.WARPED_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS)) {
                entries.add(ModBlocks.STRIPPED_OAK_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_SPRUCE_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_BIRCH_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_JUNGLE_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_ACACIA_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_DARK_OAK_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_MANGROVE_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_CHERRY_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_BAMBOO_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_PALE_OAK_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_CRIMSON_WALL.asItem());
                entries.add(ModBlocks.STRIPPED_WARPED_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_ROPE_LADDERS)) {
                entries.add(ModBlocks.OAK_ROPE_LADDER.asItem());
                entries.add(ModBlocks.SPRUCE_ROPE_LADDER.asItem());
                entries.add(ModBlocks.BIRCH_ROPE_LADDER.asItem());
                entries.add(ModBlocks.JUNGLE_ROPE_LADDER.asItem());
                entries.add(ModBlocks.ACACIA_ROPE_LADDER.asItem());
                entries.add(ModBlocks.DARK_OAK_ROPE_LADDER.asItem());
                entries.add(ModBlocks.MANGROVE_ROPE_LADDER.asItem());
                entries.add(ModBlocks.CHERRY_ROPE_LADDER.asItem());
                entries.add(ModBlocks.BAMBOO_ROPE_LADDER.asItem());
                entries.add(ModBlocks.PALE_OAK_ROPE_LADDER.asItem());
                entries.add(ModBlocks.CRIMSON_ROPE_LADDER.asItem());
                entries.add(ModBlocks.WARPED_ROPE_LADDER.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_IRON_LADDERS)) {
                entries.add(ModBlocks.IRON_LADDER.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_DYED_CAMPFIRES)) {
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

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_DYED_LANTERNS)) {
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

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_DYED_TORCHES)) {
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

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_TWISTED_NETHERRACK)) {
                entries.add(ModBlocks.TWISTED_NETHERRACK.asItem());
                entries.add(ModBlocks.TWISTED_NETHERRACK_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_NETHERRACK_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_NETHERRACK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WEEPING_NETHERRACK)) {
                entries.add(ModBlocks.WEEPING_NETHERRACK.asItem());
                entries.add(ModBlocks.WEEPING_NETHERRACK_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_NETHERRACK_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_NETHERRACK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_TWISTED_NETHER_BRICKS)) {
                entries.add(ModBlocks.TWISTED_NETHER_BRICKS.asItem());
                entries.add(ModBlocks.TWISTED_NETHER_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_NETHER_BRICK_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_NETHER_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WEEPING_NETHER_BRICKS)) {
                entries.add(ModBlocks.WEEPING_NETHER_BRICKS.asItem());
                entries.add(ModBlocks.WEEPING_NETHER_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_NETHER_BRICK_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_NETHER_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_TWISTED_BLACKSTONE)) {
                entries.add(ModBlocks.TWISTED_BLACKSTONE.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WEEPING_BLACKSTONE)) {
                entries.add(ModBlocks.WEEPING_BLACKSTONE.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS)) {
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICKS.asItem());
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS)) {
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.asItem());
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.asItem());
            }

            boolean blackstoneTilesEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BLACKSTONE_TILES);
            if (blackstoneTilesEnabled) {
                entries.add(ModBlocks.BLACKSTONE_TILES.asItem());
                entries.add(ModBlocks.BLACKSTONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.BLACKSTONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.BLACKSTONE_TILE_WALL.asItem());
            }

            if (blackstoneTilesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES)) {
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILES.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.TWISTED_BLACKSTONE_TILE_WALL.asItem());
            }

            if (blackstoneTilesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES)) {
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILES.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.WEEPING_BLACKSTONE_TILE_WALL.asItem());
            }

            boolean smokyQuartzBlocksEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
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

            if (smokyQuartzBlocksEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS)) {
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICKS.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICK_SLAB.asItem());
                entries.add(ModBlocks.SMOKY_QUARTZ_BRICK_WALL.asItem());
            }

            if (smokyQuartzBlocksEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ)) {
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ.asItem());
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.asItem());
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.asItem());
                entries.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS)) {
                entries.add(ModBlocks.QUARTZ_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.QUARTZ_BRICK_SLAB.asItem());
                entries.add(ModBlocks.QUARTZ_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_QUARTZ_TILES)) {
                entries.add(ModBlocks.QUARTZ_TILES.asItem());
                entries.add(ModBlocks.QUARTZ_TILE_STAIRS.asItem());
                entries.add(ModBlocks.QUARTZ_TILE_SLAB.asItem());
                entries.add(ModBlocks.QUARTZ_TILE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_QUARTZ_WALLS)) {
                entries.add(ModBlocks.QUARTZ_WALL.asItem());
                entries.add(ModBlocks.SMOOTH_QUARTZ_WALL.asItem());
            }

            boolean bauxiteEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BAUXITE);
            if (bauxiteEnabled) {
                entries.add(ModBlocks.BAUXITE.asItem());
                entries.add(ModBlocks.BAUXITE_SLAB.asItem());
                entries.add(ModBlocks.BAUXITE_STAIRS.asItem());
                entries.add(ModBlocks.BAUXITE_WALL.asItem());
            }

            boolean bauxiteBricksEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BAUXITE_BRICKS);
            if (bauxiteEnabled && bauxiteBricksEnabled) {
                entries.add(ModBlocks.BAUXITE_BRICKS.asItem());
                entries.add(ModBlocks.BAUXITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.BAUXITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.BAUXITE_BRICK_WALL.asItem());
            }

            if (bauxiteEnabled && bauxiteBricksEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS)) {
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICKS.asItem());
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_BAUXITE_BRICK_WALL.asItem());
            }

            if (bauxiteEnabled && bauxiteBricksEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS)) {
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICKS.asItem());
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_BAUXITE_BRICK_WALL.asItem());
            }

            boolean stoneTilesEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_STONE_TILES);
            if (stoneTilesEnabled) {
                entries.add(ModBlocks.STONE_TILES.asItem());
                entries.add(ModBlocks.STONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.STONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.STONE_TILE_WALL.asItem());
            }

            if (stoneTilesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CRACKED_STONE_TILES)) {
                entries.add(ModBlocks.CRACKED_STONE_TILES.asItem());
                entries.add(ModBlocks.CRACKED_STONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_STONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_STONE_TILE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_MOSSY_STONE_TILES)) {
                entries.add(ModBlocks.MOSSY_STONE_TILES.asItem());
                entries.add(ModBlocks.MOSSY_STONE_TILE_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_STONE_TILE_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_STONE_TILE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS)) {
                entries.add(ModBlocks.CRACKED_STONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_STONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_STONE_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_STONE_WALLS)) {
                entries.add(ModBlocks.STONE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CALCITE_BLOCKS)) {
                entries.add(ModBlocks.CALCITE_STAIRS.asItem());
                entries.add(ModBlocks.CALCITE_SLAB.asItem());
                entries.add(ModBlocks.CALCITE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_POLISHED_CALCITE)) {
                entries.add(ModBlocks.POLISHED_CALCITE.asItem());
                entries.add(ModBlocks.POLISHED_CALCITE_STAIRS.asItem());
                entries.add(ModBlocks.POLISHED_CALCITE_SLAB.asItem());
                entries.add(ModBlocks.POLISHED_CALCITE_WALL.asItem());
            }

            boolean calciteBricksEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CALCITE_BRICKS);
            if (calciteBricksEnabled) {
                entries.add(ModBlocks.CALCITE_BRICKS.asItem());
                entries.add(ModBlocks.CALCITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CALCITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CALCITE_BRICK_WALL.asItem());
                entries.add(ModBlocks.CHISELED_CALCITE_BRICKS.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS) && calciteBricksEnabled) {
                entries.add(ModBlocks.CRACKED_CALCITE_BRICKS.asItem());
                entries.add(ModBlocks.CRACKED_CALCITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_CALCITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_CALCITE_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS) && calciteBricksEnabled) {
                entries.add(ModBlocks.MOSSY_CALCITE_BRICKS.asItem());
                entries.add(ModBlocks.MOSSY_CALCITE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_CALCITE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_CALCITE_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_DRIPSTONE_BLOCKS)) {
                entries.add(ModBlocks.DRIPSTONE_STAIRS.asItem());
                entries.add(ModBlocks.DRIPSTONE_SLAB.asItem());
                entries.add(ModBlocks.DRIPSTONE_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_POLISHED_DRIPSTONE)) {
                entries.add(ModBlocks.POLISHED_DRIPSTONE.asItem());
                entries.add(ModBlocks.POLISHED_DRIPSTONE_STAIRS.asItem());
                entries.add(ModBlocks.POLISHED_DRIPSTONE_SLAB.asItem());
                entries.add(ModBlocks.POLISHED_DRIPSTONE_WALL.asItem());
            }

            boolean dripstoneBricksEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_DRIPSTONE_BRICKS);
            if (dripstoneBricksEnabled) {
                entries.add(ModBlocks.DRIPSTONE_BRICKS.asItem());
                entries.add(ModBlocks.DRIPSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.DRIPSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.DRIPSTONE_BRICK_WALL.asItem());
                entries.add(ModBlocks.CHISELED_DRIPSTONE_BRICKS.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS) && dripstoneBricksEnabled) {
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS.asItem());
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS) && dripstoneBricksEnabled) {
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS.asItem());
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.asItem());
                entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SNOW_BRICKS)) {
                entries.add(ModBlocks.SNOW_BRICKS.asItem());
                entries.add(ModBlocks.SNOW_BRICK_STAIRS.asItem());
                entries.add(ModBlocks.SNOW_BRICK_SLAB.asItem());
                entries.add(ModBlocks.SNOW_BRICK_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PACKED_SNOW)) {
                entries.add(ModBlocks.PACKED_SNOW.asItem());
                entries.add(ModBlocks.PACKED_SNOW_STAIRS.asItem());
                entries.add(ModBlocks.PACKED_SNOW_SLAB.asItem());
                entries.add(ModBlocks.PACKED_SNOW_WALL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_DIRT_SLABS)) {
                entries.add(ModBlocks.GRASS_SLAB.asItem());
                entries.add(ModBlocks.PODZOL_SLAB.asItem());
                entries.add(ModBlocks.MYCELIUM_SLAB.asItem());
                entries.add(ModBlocks.DIRT_PATH_SLAB.asItem());
                entries.add(ModBlocks.DIRT_SLAB.asItem());
                entries.add(ModBlocks.ROOTED_DIRT_SLAB.asItem());
                entries.add(ModBlocks.COARSE_DIRT_SLAB.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PURPLE_MUSHROOMS)) {
                entries.add(ModBlocks.PURPLE_MUSHROOM_BLOCK.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CATTAILS)) {
                entries.add(ModBlocks.CATTAIL.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BOG_BLOSSOMS)) {
                entries.add(ModBlocks.BOG_BLOSSOM.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_ENDER_PLANTS)) {
                entries.add(ModBlocks.SNAPDRAGON.asItem());
                entries.add(ModBlocks.SHORT_ENDER_GRASS.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PURPLE_MUSHROOMS)) {
                entries.add(ModBlocks.PURPLE_MUSHROOM.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BLOOD_KELP)) {
                entries.add(ModBlocks.DRIED_BLOOD_KELP_BLOCK);
                entries.add(ModBlocks.BLOOD_KELP_LANTERN);
                entries.add(ModItems.BLOOD_KELP_SEED_CLUSTER);
                entries.add(ModItems.BLOOD_KELP);
                entries.add(ModItems.DRIED_BLOOD_KELP);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_GREEN_ONIONS)) {
                entries.add(ModBlocks.WILD_GREEN_ONIONS.asItem());
                entries.add(ModItems.GREEN_ONION_SEEDS);
                entries.add(ModItems.GREEN_ONION);
            }

            boolean caramelAppleEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CARAMEL_APPLE);
            if (caramelAppleEnabled) {
                entries.add(ModItems.CARAMEL);
            }

            boolean forestsBountyEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_FORESTS_BOUNTY);
            if (forestsBountyEnabled) {
                entries.add(ModItems.SPRUCE_CONE);
            }

            boolean noodleSoupEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_NOODLE_SOUP);
            if (noodleSoupEnabled) {
                entries.add(ModItems.NOODLES);
            }

            boolean witchsCradleEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WITCHS_CRADLES);
            if (witchsCradleEnabled) {
                entries.add(ModItems.WITCHS_CRADLE_BRANCH);
            }

            boolean blueberriesEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BLUEBERRIES);
            if (blueberriesEnabled) {
                entries.add(ModItems.BLUEBERRIES);
            }

            boolean cindersnapBerriesEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CINDERSNAP_BERRIES);
            if (cindersnapBerriesEnabled) {
                entries.add(ModItems.CINDERSNAP_BERRIES);
            }

            boolean frostbiteBerriesEnabled = ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_FROSTBITE_BERRIES);
            if (frostbiteBerriesEnabled) {
                entries.add(ModItems.FROSTBITE_BERRIES);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_FRIED_EGG)) {
                entries.add(ModItems.FRIED_EGG);
            }

            if (caramelAppleEnabled) {
                entries.add(ModItems.CARAMEL_APPLE);
            }

            if (forestsBountyEnabled) {
                entries.add(ModItems.FORESTS_BOUNTY);
            }

            if (noodleSoupEnabled) {
                entries.add(ModItems.NOODLE_SOUP);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_HOGLIN_STEW)) {
                entries.add(ModItems.HOGLIN_STEW);
            }

            if (witchsCradleEnabled) {
                entries.add(ModItems.WITCHS_CRADLE_SOUP);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_PUDDING)) {
                entries.add(ModItems.BERRY_PUDDING);
                entries.add(ModItems.PUDDING);
            }

            if (frostbiteBerriesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_WARPED_FORAGE_MIX)) {
                entries.add(ModItems.WARPED_FORAGE_MIX);
            }

            if (cindersnapBerriesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CRIMSON_FORAGE_MIX)) {
                entries.add(ModItems.CRIMSON_FORAGE_MIX);
            }

            if (blueberriesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BLUEBERRY_JUICE)) {
                entries.add(ModItems.BLUEBERRY_JUICE);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SWEET_BERRY_JUICE)) {
                entries.add(ModItems.SWEET_BERRY_JUICE);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CINDERSNAP_BERRY_JUICE)
                    && cindersnapBerriesEnabled) {
                entries.add(ModItems.CINDERSNAP_BERRY_JUICE);
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_FROSTBITE_BERRY_JUICE)
                    && frostbiteBerriesEnabled) {
                entries.add(ModItems.FROSTBITE_BERRY_JUICE);
            }

            if (blueberriesEnabled && ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_BLUEBERRY_PIE)) {
                entries.add(ModBlocks.BLUEBERRY_PIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_SWEET_BERRY_PIE)) {
                entries.add(ModBlocks.SWEET_BERRY_PIE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_CHOCOLATE_CAKE)) {
                entries.add(ModBlocks.CHOCOLATE_CAKE.asItem());
            }

            if (ModClientConfig.getBoolEntries().get(ModServerConfigKeys.ENABLE_RED_VELVET_CAKE)) {
                entries.add(ModBlocks.RED_VELVET_CAKE.asItem());
            }
        });
    }
}
