package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rndm_access.assorteddiscoveries.config.BooleanEntriesS2CPayload;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.ModConfigKeys;
import rndm_access.assorteddiscoveries.config.json.Config;
import rndm_access.assorteddiscoveries.core.*;

import java.util.Optional;

public class AssortedDiscoveries implements ModInitializer {
    public static final String MOD_ID = "assorted-discoveries";
    public static final Logger LOGGER = LoggerFactory.getLogger("AssortedDiscoveries");
    private static final ResourceKey<@NotNull CreativeModeTab> MOD_CREATIVE_TAB_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB, makeModId("item_group"));
    public static final CreativeModeTab MOD_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.ENDERMAN_PLUSHIE.asItem()))
            .title(Component.translatable("itemGroup." + MOD_ID))
            .build();

    @Override
    public void onInitialize() {
        // Config
        AssortedDiscoveries.registerConfigEvents();
        ModResourceConditionTypes.register();

        // General Registries
        ModBlocks.register();
        ModItems.register();
        AssortedDiscoveries.modifyCreativeTabs();
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
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    private static void registerConfigEvents() {
        PayloadTypeRegistry.clientboundPlay().register(BooleanEntriesS2CPayload.ID, BooleanEntriesS2CPayload.CODEC);

        ServerPlayerEvents.JOIN.register(AssortedDiscoveries::sendConfigData);
    }

    @SuppressWarnings("resource")
    private static void sendConfigData(ServerPlayer player) {
        // If I use the auto-closable on level it closes the world too early and breaks loading!
        if (!player.level().isClientSide()) {
            sendConfigToPlayer(player);
        }
    }

    private static void sendConfigToPlayer(ServerPlayer player) {
        BooleanEntriesS2CPayload payload = new BooleanEntriesS2CPayload(ModConfig.getConfig().getBooleanEntries());
        String playerName = player.getName().getString();

        if (ServerPlayNetworking.canSend(player, payload.type())) {
            ServerPlayNetworking.send(player, payload);
            LOGGER.info("Sent config data to {}!", playerName);
        }
    }

    private static void registerVillagerInteractions() {
        VillagerInteractionRegistries.registerCompostable(ModItems.GREEN_ONION);
        VillagerInteractionRegistries.registerFood(ModItems.GREEN_ONION, 1);
    }

    private static void addFeaturesToBiomes() {
        Config config = ModConfig.getConfig();

        if (config.evaluateEntry(ModConfigKeys.ENABLE_CATTAILS)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CATTAIL_SWAMP),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_SWAMP);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CATTAIL_RIVER),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CATTAIL_RIVER);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_SMOKY_QUARTZ),
                    GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_SMOKY_QUARTZ);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_HUGE_PURPLE_MUSHROOM)
                            .and(BiomeSelectors.excludeByKey(Biomes.PALE_GARDEN)),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_HUGE_PURPLE_MUSHROOM);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_BLUEBERRIES)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_BLUEBERRY_BUSH)
                            .and(BiomeSelectors.excludeByKey(Biomes.PALE_GARDEN)),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_BLUEBERRY_BUSH)
                            .and(BiomeSelectors.excludeByKey(Biomes.PALE_GARDEN)),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_BLUEBERRY_RARE);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_WITCHS_CRADLES)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WITCHS_CRADLE),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WITCHS_CRADLE_RARE);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_ENDER_PLANTS)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_ENDER_PLANTS),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_ENDER_PLANTS);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_BLOOD_KELP)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.BLOOD_KELP),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.BLOOD_KELP);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.BOG_BLOSSOM),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.BOG_BLOSSOM);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_BAUXITE)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                    GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_LOWER);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.ORE_BAUXITE),
                    GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatureKeys.ORE_BAUXITE_UPPER);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_CINDERSNAP_BERRIES)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_CINDERSNAP_BERRY_BUSH),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_CINDERSNAP_BERRY_BUSH_RARE);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_FROSTBITE_BERRIES)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_FROSTBITE_BERRY_BUSH),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_FROSTBITE_BERRY_BUSH_RARE);
        }

        if (config.evaluateEntry(ModConfigKeys.ENABLE_GREEN_ONIONS)) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_COMMON);
            BiomeModifications.addFeature(BiomeSelectors.tag(ModBiomeTags.PATCH_WILD_GREEN_ONIONS),
                    GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatureKeys.PATCH_WILD_GREEN_ONIONS_RARE);
        }
    }

    private static void registerFuel() {
        FuelValueEvents.BUILD.register((builder, context) ->
                builder.add(ModBlocks.DRIED_BLOOD_KELP_BLOCK, 4000));
    }

    private static void registerCompostables() {
        CompostableRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.3F);
        CompostableRegistry.INSTANCE.add(ModItems.CINDERSNAP_BERRIES, 0.3F);
        CompostableRegistry.INSTANCE.add(ModItems.FROSTBITE_BERRIES, 0.3F);
        CompostableRegistry.INSTANCE.add(ModItems.WITCHS_CRADLE_BRANCH, 0.3F);
        CompostableRegistry.INSTANCE.add(ModItems.BLOOD_KELP_SEED_CLUSTER, 0.3F);
        CompostableRegistry.INSTANCE.add(ModItems.BLOOD_KELP, 0.3F);
        CompostableRegistry.INSTANCE.add(ModItems.DRIED_BLOOD_KELP, 0.3F);
        CompostableRegistry.INSTANCE.add(ModBlocks.DRIED_BLOOD_KELP_BLOCK, 0.5F);
        CompostableRegistry.INSTANCE.add(ModBlocks.SNAPDRAGON, 0.65F);
        CompostableRegistry.INSTANCE.add(ModBlocks.SHORT_ENDER_GRASS, 0.3F);
        CompostableRegistry.INSTANCE.add(ModBlocks.PURPLE_MUSHROOM_BLOCK, 0.85F);
        CompostableRegistry.INSTANCE.add(ModBlocks.PURPLE_MUSHROOM, 0.65F);
        CompostableRegistry.INSTANCE.add(ModBlocks.CATTAIL, 0.5F);
        CompostableRegistry.INSTANCE.add(ModItems.GREEN_ONION, 0.65F);
        CompostableRegistry.INSTANCE.add(ModItems.GREEN_ONION_SEEDS, 0.3F);
    }

    private static void modifyLootTables() {
        Optional<ResourceKey<@NotNull LootTable>> spruceLeavesLootTableId = Blocks.SPRUCE_LEAVES.getLootTable();

        LootTableEvents.MODIFY.register((key, tableBuilder, source,
                                         registries) -> {
            if(source.isBuiltin() && spruceLeavesLootTableId.isPresent() && spruceLeavesLootTableId.get().equals(key)) {
                modifySpruceLeavesLootTable(registries, tableBuilder);
            }
        });
    }

    private static void modifySpruceLeavesLootTable(HolderLookup.Provider registries, LootTable.Builder builder) {
        Config config = ModConfig.getConfig();

        if (config.evaluateEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY)) {
            Optional<Holder.Reference<Enchantment>> fortune = registries.get(Enchantments.FORTUNE);
            assert fortune.isPresent();
            Holder<Enchantment> fortuneEnchant = Holder.direct(fortune.get().value());

            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .add(LootItem.lootTableItem(ModItems.SPRUCE_CONE))
                    .when(BonusLevelTableCondition.bonusLevelFlatChance(fortuneEnchant, 0.02F, 0.023F,
                            0.025F, 0.035F, 0.1F))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                    .apply(ApplyExplosionDecay.explosionDecay());

            builder.withPool(poolBuilder);
        }
    }

    private static void modifyCreativeTabs() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MOD_CREATIVE_TAB_KEY, MOD_CREATIVE_TAB);
        CreativeModeTabEvents.modifyOutputEvent(MOD_CREATIVE_TAB_KEY).register((entries) -> {
            Config config = ModConfig.getConfig();

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SLIME_PLUSHIE)) {
                entries.accept(ModBlocks.SLIME_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_MAGMA_CUBE_PLUSHIE)) {
                entries.accept(ModBlocks.MAGMA_CUBE_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CAT_PLUSHIES)) {
                entries.accept(ModBlocks.OCELOT_PLUSHIE.asItem());
                entries.accept(ModBlocks.WHITE_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.TABBY_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.TUXEDO_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.RED_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.SIAMESE_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.BRITISH_SHORTHAIR_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.CALICO_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.PERSIAN_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.RAGDOLL_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.BLACK_CAT_PLUSHIE.asItem());
                entries.accept(ModBlocks.JELLIE_CAT_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WOLF_PLUSHIES)) {
                entries.accept(ModBlocks.PALE_WOLF_PLUSHIE.asItem());
                entries.accept(ModBlocks.BLACK_WOLF_PLUSHIE.asItem());
                entries.accept(ModBlocks.ASHEN_WOLF_PLUSHIE.asItem());
                entries.accept(ModBlocks.CHESTNUT_WOLF_PLUSHIE.asItem());
                entries.accept(ModBlocks.RUSTY_WOLF_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_ZOMBIE_PLUSHIE)) {
                entries.accept(ModBlocks.ZOMBIE_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SKELETON_PLUSHIE)) {
                entries.accept(ModBlocks.SKELETON_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_ENDERMAN_PLUSHIE)) {
                entries.accept(ModBlocks.ENDERMAN_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CREEPER_PLUSHIE)) {
                entries.accept(ModBlocks.CREEPER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SPIDER_PLUSHIE)) {
                entries.accept(ModBlocks.SPIDER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CAVE_SPIDER_PLUSHIE)) {
                entries.accept(ModBlocks.CAVE_SPIDER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_GUARDIAN_PLUSHIE)) {
                entries.accept(ModBlocks.GUARDIAN_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PHANTOM_PLUSHIE)) {
                entries.accept(ModBlocks.PHANTOM_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_BAT_PLUSHIE)) {
                entries.accept(ModBlocks.BAT_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SQUID_PLUSHIES)) {
                entries.accept(ModBlocks.SQUID_PLUSHIE.asItem());
                entries.accept(ModBlocks.GLOW_SQUID_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_BEE_PLUSHIE)) {
                entries.accept(ModBlocks.BEE_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PIGLIN_PLUSHIES)) {
                entries.accept(ModBlocks.PIGLIN_PLUSHIE.asItem());
                entries.accept(ModBlocks.ZOMBIFIED_PIGLIN_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_HOGLIN_PLUSHIES)) {
                entries.accept(ModBlocks.HOGLIN_PLUSHIE.asItem());
                entries.accept(ModBlocks.ZOGLIN_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_GHAST_PLUSHIE)) {
                entries.accept(ModBlocks.GHAST_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_BLAZE_PLUSHIE)) {
                entries.accept(ModBlocks.BLAZE_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_STRIDER_PLUSHIES)) {
                entries.accept(ModBlocks.STRIDER_PLUSHIE.asItem());
                entries.accept(ModBlocks.SHIVERING_STRIDER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CHICKEN_PLUSHIES)) {
                entries.accept(ModBlocks.TEMPERATE_CHICKEN_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PIG_PLUSHIES)) {
                entries.accept(ModBlocks.TEMPERATE_PIG_PLUSHIE.asItem());
                entries.accept(ModBlocks.COLD_PIG_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_COW_PLUSHIES)) {
                entries.accept(ModBlocks.TEMPERATE_COW_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_MOOSHROOM_PLUSHIES)) {
                entries.accept(ModBlocks.RED_MOOSHROOM_PLUSHIE.asItem());
                entries.accept(ModBlocks.BROWN_MOOSHROOM_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SHEEP_PLUSHIES)) {
                entries.accept(ModBlocks.WHITE_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.ORANGE_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.MAGENTA_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.LIGHT_BLUE_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.YELLOW_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.LIME_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.PINK_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.GRAY_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.LIGHT_GRAY_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.CYAN_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.PURPLE_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.BLUE_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.BROWN_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.RED_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.GREEN_SHEEP_PLUSHIE.asItem());
                entries.accept(ModBlocks.BLACK_SHEEP_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_HORSE_PLUSHIES)) {
                entries.accept(ModBlocks.WHITE_HORSE_PLUSHIE.asItem());
                entries.accept(ModBlocks.GRAY_HORSE_PLUSHIE.asItem());
                entries.accept(ModBlocks.BROWN_HORSE_PLUSHIE.asItem());
                entries.accept(ModBlocks.BLACK_HORSE_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_RABBIT_PLUSHIES)) {
                entries.accept(ModBlocks.BROWN_RABBIT_PLUSHIE.asItem());
                entries.accept(ModBlocks.WHITE_RABBIT_PLUSHIE.asItem());
                entries.accept(ModBlocks.BLACK_RABBIT_PLUSHIE.asItem());
                entries.accept(ModBlocks.WHITE_SPLOTCHED_RABBIT_PLUSHIE.asItem());
                entries.accept(ModBlocks.GOLD_RABBIT_PLUSHIE.asItem());
                entries.accept(ModBlocks.TOAST_RABBIT_PLUSHIE.asItem());
                entries.accept(ModBlocks.SALT_RABBIT_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_ILLAGER_PLUSHIES)) {
                entries.accept(ModBlocks.PILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.VINDICATOR_PLUSHIE.asItem());
                entries.accept(ModBlocks.EVOKER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_VILLAGER_PLUSHIES)) {
                entries.accept(ModBlocks.PLAINS_VILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.DESERT_VILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.JUNGLE_VILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.SAVANNA_VILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.SNOWY_VILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.SWAMP_VILLAGER_PLUSHIE.asItem());
                entries.accept(ModBlocks.TAIGA_VILLAGER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WITCH_PLUSHIE)) {
                entries.accept(ModBlocks.WITCH_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PUFFERFISH_PLUSHIE)) {
                entries.accept(ModBlocks.PUFFERFISH_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WITHER_PLUSHIE)) {
                entries.accept(ModBlocks.WITHER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_ALLAY_PLUSHIE)) {
                entries.accept(ModBlocks.ALLAY_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_VEX_PLUSHIE)) {
                entries.accept(ModBlocks.VEX_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SHULKER_PLUSHIE)) {
                entries.accept(ModBlocks.SHULKER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CAMEL_PLUSHIE)) {
                entries.accept(ModBlocks.CAMEL_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CREAKING_PLUSHIE)) {
                entries.accept(ModBlocks.CREAKING_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SNIFFER_PLUSHIE)) {
                entries.accept(ModBlocks.SNIFFER_PLUSHIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PLANTER_BOXES)) {
                entries.accept(ModBlocks.OAK_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.SPRUCE_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.BIRCH_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.JUNGLE_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.ACACIA_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.DARK_OAK_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.MANGROVE_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.CHERRY_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.BAMBOO_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.PALE_OAK_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.CRIMSON_PLANTER_BOX.asItem());
                entries.accept(ModBlocks.WARPED_PLANTER_BOX.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WOODEN_WALLS)) {
                entries.accept(ModBlocks.OAK_WALL.asItem());
                entries.accept(ModBlocks.SPRUCE_WALL.asItem());
                entries.accept(ModBlocks.BIRCH_WALL.asItem());
                entries.accept(ModBlocks.JUNGLE_WALL.asItem());
                entries.accept(ModBlocks.ACACIA_WALL.asItem());
                entries.accept(ModBlocks.DARK_OAK_WALL.asItem());
                entries.accept(ModBlocks.MANGROVE_WALL.asItem());
                entries.accept(ModBlocks.CHERRY_WALL.asItem());
                entries.accept(ModBlocks.BAMBOO_WALL.asItem());
                entries.accept(ModBlocks.PALE_OAK_WALL.asItem());
                entries.accept(ModBlocks.CRIMSON_WALL.asItem());
                entries.accept(ModBlocks.WARPED_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_STRIPPED_WOODEN_WALLS)) {
                entries.accept(ModBlocks.STRIPPED_OAK_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_SPRUCE_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_BIRCH_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_JUNGLE_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_ACACIA_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_DARK_OAK_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_MANGROVE_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_CHERRY_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_BAMBOO_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_PALE_OAK_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_CRIMSON_WALL.asItem());
                entries.accept(ModBlocks.STRIPPED_WARPED_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_ROPE_LADDERS)) {
                entries.accept(ModBlocks.OAK_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.SPRUCE_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.BIRCH_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.JUNGLE_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.ACACIA_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.DARK_OAK_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.MANGROVE_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.CHERRY_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.BAMBOO_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.PALE_OAK_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.CRIMSON_ROPE_LADDER.asItem());
                entries.accept(ModBlocks.WARPED_ROPE_LADDER.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_IRON_LADDERS)) {
                entries.accept(ModBlocks.IRON_LADDER.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_DYED_CAMPFIRES)) {
                entries.accept(ModBlocks.WHITE_CAMPFIRE.asItem());
                entries.accept(ModBlocks.ORANGE_CAMPFIRE.asItem());
                entries.accept(ModBlocks.MAGENTA_CAMPFIRE.asItem());
                entries.accept(ModBlocks.LIGHT_BLUE_CAMPFIRE.asItem());
                entries.accept(ModBlocks.YELLOW_CAMPFIRE.asItem());
                entries.accept(ModBlocks.LIME_CAMPFIRE.asItem());
                entries.accept(ModBlocks.PINK_CAMPFIRE.asItem());
                entries.accept(ModBlocks.GRAY_CAMPFIRE.asItem());
                entries.accept(ModBlocks.LIGHT_GRAY_CAMPFIRE.asItem());
                entries.accept(ModBlocks.CYAN_CAMPFIRE.asItem());
                entries.accept(ModBlocks.PURPLE_CAMPFIRE.asItem());
                entries.accept(ModBlocks.BLUE_CAMPFIRE.asItem());
                entries.accept(ModBlocks.BROWN_CAMPFIRE.asItem());
                entries.accept(ModBlocks.GREEN_CAMPFIRE.asItem());
                entries.accept(ModBlocks.RED_CAMPFIRE.asItem());
                entries.accept(ModBlocks.BLACK_CAMPFIRE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_DYED_LANTERNS)) {
                entries.accept(ModBlocks.WHITE_LANTERN.asItem());
                entries.accept(ModBlocks.ORANGE_LANTERN.asItem());
                entries.accept(ModBlocks.MAGENTA_LANTERN.asItem());
                entries.accept(ModBlocks.LIGHT_BLUE_LANTERN.asItem());
                entries.accept(ModBlocks.YELLOW_LANTERN.asItem());
                entries.accept(ModBlocks.LIME_LANTERN.asItem());
                entries.accept(ModBlocks.PINK_LANTERN.asItem());
                entries.accept(ModBlocks.GRAY_LANTERN.asItem());
                entries.accept(ModBlocks.LIGHT_GRAY_LANTERN.asItem());
                entries.accept(ModBlocks.CYAN_LANTERN.asItem());
                entries.accept(ModBlocks.PURPLE_LANTERN.asItem());
                entries.accept(ModBlocks.BLUE_LANTERN.asItem());
                entries.accept(ModBlocks.BROWN_LANTERN.asItem());
                entries.accept(ModBlocks.GREEN_LANTERN.asItem());
                entries.accept(ModBlocks.RED_LANTERN.asItem());
                entries.accept(ModBlocks.BLACK_LANTERN.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_DYED_TORCHES)) {
                entries.accept(ModItems.WHITE_TORCH);
                entries.accept(ModItems.ORANGE_TORCH);
                entries.accept(ModItems.MAGENTA_TORCH);
                entries.accept(ModItems.LIGHT_BLUE_TORCH);
                entries.accept(ModItems.YELLOW_TORCH);
                entries.accept(ModItems.LIME_TORCH);
                entries.accept(ModItems.PINK_TORCH);
                entries.accept(ModItems.GRAY_TORCH);
                entries.accept(ModItems.LIGHT_GRAY_TORCH);
                entries.accept(ModItems.CYAN_TORCH);
                entries.accept(ModItems.PURPLE_TORCH);
                entries.accept(ModItems.BLUE_TORCH);
                entries.accept(ModItems.BROWN_TORCH);
                entries.accept(ModItems.GREEN_TORCH);
                entries.accept(ModItems.RED_TORCH);
                entries.accept(ModItems.BLACK_TORCH);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_TWISTED_NETHERRACK)) {
                entries.accept(ModBlocks.TWISTED_NETHERRACK.asItem());
                entries.accept(ModBlocks.TWISTED_NETHERRACK_STAIRS.asItem());
                entries.accept(ModBlocks.TWISTED_NETHERRACK_SLAB.asItem());
                entries.accept(ModBlocks.TWISTED_NETHERRACK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WEEPING_NETHERRACK)) {
                entries.accept(ModBlocks.WEEPING_NETHERRACK.asItem());
                entries.accept(ModBlocks.WEEPING_NETHERRACK_STAIRS.asItem());
                entries.accept(ModBlocks.WEEPING_NETHERRACK_SLAB.asItem());
                entries.accept(ModBlocks.WEEPING_NETHERRACK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_TWISTED_NETHER_BRICKS)) {
                entries.accept(ModBlocks.TWISTED_NETHER_BRICKS.asItem());
                entries.accept(ModBlocks.TWISTED_NETHER_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.TWISTED_NETHER_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.TWISTED_NETHER_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WEEPING_NETHER_BRICKS)) {
                entries.accept(ModBlocks.WEEPING_NETHER_BRICKS.asItem());
                entries.accept(ModBlocks.WEEPING_NETHER_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.WEEPING_NETHER_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.WEEPING_NETHER_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE)) {
                entries.accept(ModBlocks.TWISTED_BLACKSTONE.asItem());
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_STAIRS.asItem());
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_SLAB.asItem());
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE)) {
                entries.accept(ModBlocks.WEEPING_BLACKSTONE.asItem());
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_STAIRS.asItem());
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_SLAB.asItem());
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_TWISTED_POLISHED_BLACKSTONE_BRICKS)) {
                entries.accept(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICKS.asItem());
                entries.accept(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_WEEPING_POLISHED_BLACKSTONE_BRICKS)) {
                entries.accept(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS.asItem());
                entries.accept(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL.asItem());
            }

            boolean blackstoneTilesEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_BLACKSTONE_TILES);
            if (blackstoneTilesEnabled) {
                entries.accept(ModBlocks.BLACKSTONE_TILES.asItem());
                entries.accept(ModBlocks.BLACKSTONE_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.BLACKSTONE_TILE_SLAB.asItem());
                entries.accept(ModBlocks.BLACKSTONE_TILE_WALL.asItem());
            }

            if (blackstoneTilesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_TWISTED_BLACKSTONE_TILES)) {
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_TILES.asItem());
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_TILE_SLAB.asItem());
                entries.accept(ModBlocks.TWISTED_BLACKSTONE_TILE_WALL.asItem());
            }

            if (blackstoneTilesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_WEEPING_BLACKSTONE_TILES)) {
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_TILES.asItem());
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_TILE_SLAB.asItem());
                entries.accept(ModBlocks.WEEPING_BLACKSTONE_TILE_WALL.asItem());
            }

            boolean smokyQuartzBlocksEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BLOCKS);
            if (smokyQuartzBlocksEnabled) {
                entries.accept(ModBlocks.NETHER_SMOKY_QUARTZ_ORE.asItem());
                entries.accept(ModItems.SMOKY_QUARTZ);
                entries.accept(ModBlocks.SMOKY_QUARTZ_BLOCK.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_STAIRS.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_SLAB.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_WALL.asItem());
                entries.accept(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_PILLAR.asItem());
            }

            if (smokyQuartzBlocksEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_SMOKY_QUARTZ_BRICKS)) {
                entries.accept(ModBlocks.SMOKY_QUARTZ_BRICKS.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.SMOKY_QUARTZ_BRICK_WALL.asItem());
            }

            if (smokyQuartzBlocksEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_SMOOTH_SMOKY_QUARTZ)) {
                entries.accept(ModBlocks.SMOOTH_SMOKY_QUARTZ.asItem());
                entries.accept(ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.asItem());
                entries.accept(ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.asItem());
                entries.accept(ModBlocks.SMOOTH_SMOKY_QUARTZ_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_QUARTZ_BRICK_BLOCKS)) {
                entries.accept(ModBlocks.QUARTZ_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.QUARTZ_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.QUARTZ_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_QUARTZ_TILES)) {
                entries.accept(ModBlocks.QUARTZ_TILES.asItem());
                entries.accept(ModBlocks.QUARTZ_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.QUARTZ_TILE_SLAB.asItem());
                entries.accept(ModBlocks.QUARTZ_TILE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_QUARTZ_WALLS)) {
                entries.accept(ModBlocks.QUARTZ_WALL.asItem());
                entries.accept(ModBlocks.SMOOTH_QUARTZ_WALL.asItem());
            }

            boolean bauxiteEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_BAUXITE);
            if (bauxiteEnabled) {
                entries.accept(ModBlocks.BAUXITE.asItem());
                entries.accept(ModBlocks.BAUXITE_SLAB.asItem());
                entries.accept(ModBlocks.BAUXITE_STAIRS.asItem());
                entries.accept(ModBlocks.BAUXITE_WALL.asItem());
            }

            boolean bauxiteBricksEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_BAUXITE_BRICKS);
            if (bauxiteEnabled && bauxiteBricksEnabled) {
                entries.accept(ModBlocks.BAUXITE_BRICKS.asItem());
                entries.accept(ModBlocks.BAUXITE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.BAUXITE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.BAUXITE_BRICK_WALL.asItem());
            }

            if (bauxiteEnabled && bauxiteBricksEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_CRACKED_BAUXITE_BRICKS)) {
                entries.accept(ModBlocks.CRACKED_BAUXITE_BRICKS.asItem());
                entries.accept(ModBlocks.CRACKED_BAUXITE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.CRACKED_BAUXITE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.CRACKED_BAUXITE_BRICK_WALL.asItem());
            }

            if (bauxiteEnabled && bauxiteBricksEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_MOSSY_BAUXITE_BRICKS)) {
                entries.accept(ModBlocks.MOSSY_BAUXITE_BRICKS.asItem());
                entries.accept(ModBlocks.MOSSY_BAUXITE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.MOSSY_BAUXITE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.MOSSY_BAUXITE_BRICK_WALL.asItem());
            }

            boolean stoneTilesEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_STONE_TILES);
            if (stoneTilesEnabled) {
                entries.accept(ModBlocks.STONE_TILES.asItem());
                entries.accept(ModBlocks.STONE_TILE_SLAB.asItem());
                entries.accept(ModBlocks.STONE_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.STONE_TILE_WALL.asItem());
            }

            if (stoneTilesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_CRACKED_STONE_TILES)) {
                entries.accept(ModBlocks.CRACKED_STONE_TILES.asItem());
                entries.accept(ModBlocks.CRACKED_STONE_TILE_SLAB.asItem());
                entries.accept(ModBlocks.CRACKED_STONE_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.CRACKED_STONE_TILE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_MOSSY_STONE_TILES)) {
                entries.accept(ModBlocks.MOSSY_STONE_TILES.asItem());
                entries.accept(ModBlocks.MOSSY_STONE_TILE_SLAB.asItem());
                entries.accept(ModBlocks.MOSSY_STONE_TILE_STAIRS.asItem());
                entries.accept(ModBlocks.MOSSY_STONE_TILE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CRACKED_STONE_BRICK_BLOCKS)) {
                entries.accept(ModBlocks.CRACKED_STONE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.CRACKED_STONE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.CRACKED_STONE_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_STONE_WALLS)) {
                entries.accept(ModBlocks.STONE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CALCITE_BLOCKS)) {
                entries.accept(ModBlocks.CALCITE_STAIRS.asItem());
                entries.accept(ModBlocks.CALCITE_SLAB.asItem());
                entries.accept(ModBlocks.CALCITE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_POLISHED_CALCITE)) {
                entries.accept(ModBlocks.POLISHED_CALCITE.asItem());
                entries.accept(ModBlocks.POLISHED_CALCITE_STAIRS.asItem());
                entries.accept(ModBlocks.POLISHED_CALCITE_SLAB.asItem());
                entries.accept(ModBlocks.POLISHED_CALCITE_WALL.asItem());
            }

            boolean calciteBricksEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_CALCITE_BRICKS);
            if (calciteBricksEnabled) {
                entries.accept(ModBlocks.CALCITE_BRICKS.asItem());
                entries.accept(ModBlocks.CALCITE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.CALCITE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.CALCITE_BRICK_WALL.asItem());
                entries.accept(ModBlocks.CHISELED_CALCITE_BRICKS.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CRACKED_CALCITE_BRICKS) && calciteBricksEnabled) {
                entries.accept(ModBlocks.CRACKED_CALCITE_BRICKS.asItem());
                entries.accept(ModBlocks.CRACKED_CALCITE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.CRACKED_CALCITE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.CRACKED_CALCITE_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_MOSSY_CALCITE_BRICKS) && calciteBricksEnabled) {
                entries.accept(ModBlocks.MOSSY_CALCITE_BRICKS.asItem());
                entries.accept(ModBlocks.MOSSY_CALCITE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.MOSSY_CALCITE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.MOSSY_CALCITE_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_DRIPSTONE_BLOCKS)) {
                entries.accept(ModBlocks.DRIPSTONE_STAIRS.asItem());
                entries.accept(ModBlocks.DRIPSTONE_SLAB.asItem());
                entries.accept(ModBlocks.DRIPSTONE_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_POLISHED_DRIPSTONE)) {
                entries.accept(ModBlocks.POLISHED_DRIPSTONE.asItem());
                entries.accept(ModBlocks.POLISHED_DRIPSTONE_STAIRS.asItem());
                entries.accept(ModBlocks.POLISHED_DRIPSTONE_SLAB.asItem());
                entries.accept(ModBlocks.POLISHED_DRIPSTONE_WALL.asItem());
            }

            boolean dripstoneBricksEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_DRIPSTONE_BRICKS);
            if (dripstoneBricksEnabled) {
                entries.accept(ModBlocks.DRIPSTONE_BRICKS.asItem());
                entries.accept(ModBlocks.DRIPSTONE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.DRIPSTONE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.DRIPSTONE_BRICK_WALL.asItem());
                entries.accept(ModBlocks.CHISELED_DRIPSTONE_BRICKS.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CRACKED_DRIPSTONE_BRICKS) && dripstoneBricksEnabled) {
                entries.accept(ModBlocks.CRACKED_DRIPSTONE_BRICKS.asItem());
                entries.accept(ModBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.CRACKED_DRIPSTONE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.CRACKED_DRIPSTONE_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_MOSSY_DRIPSTONE_BRICKS) && dripstoneBricksEnabled) {
                entries.accept(ModBlocks.MOSSY_DRIPSTONE_BRICKS.asItem());
                entries.accept(ModBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.MOSSY_DRIPSTONE_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SNOW_BRICKS)) {
                entries.accept(ModBlocks.SNOW_BRICKS.asItem());
                entries.accept(ModBlocks.SNOW_BRICK_STAIRS.asItem());
                entries.accept(ModBlocks.SNOW_BRICK_SLAB.asItem());
                entries.accept(ModBlocks.SNOW_BRICK_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PACKED_SNOW)) {
                entries.accept(ModBlocks.PACKED_SNOW.asItem());
                entries.accept(ModBlocks.PACKED_SNOW_STAIRS.asItem());
                entries.accept(ModBlocks.PACKED_SNOW_SLAB.asItem());
                entries.accept(ModBlocks.PACKED_SNOW_WALL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_DIRT_SLABS)) {
                entries.accept(ModBlocks.GRASS_SLAB.asItem());
                entries.accept(ModBlocks.PODZOL_SLAB.asItem());
                entries.accept(ModBlocks.MYCELIUM_SLAB.asItem());
                entries.accept(ModBlocks.DIRT_PATH_SLAB.asItem());
                entries.accept(ModBlocks.DIRT_SLAB.asItem());
                entries.accept(ModBlocks.ROOTED_DIRT_SLAB.asItem());
                entries.accept(ModBlocks.COARSE_DIRT_SLAB.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS)) {
                entries.accept(ModBlocks.PURPLE_MUSHROOM_BLOCK.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CATTAILS)) {
                entries.accept(ModBlocks.CATTAIL.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_BOG_BLOSSOMS)) {
                entries.accept(ModBlocks.BOG_BLOSSOM.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_ENDER_PLANTS)) {
                entries.accept(ModBlocks.SNAPDRAGON.asItem());
                entries.accept(ModBlocks.SHORT_ENDER_GRASS.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PURPLE_MUSHROOMS)) {
                entries.accept(ModBlocks.PURPLE_MUSHROOM.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_BLOOD_KELP)) {
                entries.accept(ModBlocks.DRIED_BLOOD_KELP_BLOCK);
                entries.accept(ModBlocks.BLOOD_KELP_LANTERN);
                entries.accept(ModItems.BLOOD_KELP_SEED_CLUSTER);
                entries.accept(ModItems.BLOOD_KELP);
                entries.accept(ModItems.DRIED_BLOOD_KELP);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_GREEN_ONIONS)) {
                entries.accept(ModBlocks.WILD_GREEN_ONIONS.asItem());
                entries.accept(ModItems.GREEN_ONION_SEEDS);
                entries.accept(ModItems.GREEN_ONION);
            }

            boolean caramelAppleEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_CARAMEL_APPLE);
            if (caramelAppleEnabled) {
                entries.accept(ModItems.CARAMEL);
            }

            boolean forestsBountyEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_FORESTS_BOUNTY);
            if (forestsBountyEnabled) {
                entries.accept(ModItems.SPRUCE_CONE);
            }

            boolean noodleSoupEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_NOODLE_SOUP);
            if (noodleSoupEnabled) {
                entries.accept(ModItems.NOODLES);
            }

            boolean witchsCradleEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_WITCHS_CRADLES);
            if (witchsCradleEnabled) {
                entries.accept(ModItems.WITCHS_CRADLE_BRANCH);
            }

            boolean blueberriesEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_BLUEBERRIES);
            if (blueberriesEnabled) {
                entries.accept(ModItems.BLUEBERRIES);
            }

            boolean cindersnapBerriesEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_CINDERSNAP_BERRIES);
            if (cindersnapBerriesEnabled) {
                entries.accept(ModItems.CINDERSNAP_BERRIES);
            }

            boolean frostbiteBerriesEnabled = config.evaluateEntry(ModConfigKeys.ENABLE_FROSTBITE_BERRIES);
            if (frostbiteBerriesEnabled) {
                entries.accept(ModItems.FROSTBITE_BERRIES);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_FRIED_EGG)) {
                entries.accept(ModItems.FRIED_EGG);
            }

            if (caramelAppleEnabled) {
                entries.accept(ModItems.CARAMEL_APPLE);
            }

            if (forestsBountyEnabled) {
                entries.accept(ModItems.FORESTS_BOUNTY);
            }

            if (noodleSoupEnabled) {
                entries.accept(ModItems.NOODLE_SOUP);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_HOGLIN_STEW)) {
                entries.accept(ModItems.HOGLIN_STEW);
            }

            if (witchsCradleEnabled) {
                entries.accept(ModItems.WITCHS_CRADLE_SOUP);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_PUDDING)) {
                entries.accept(ModItems.BERRY_PUDDING);
                entries.accept(ModItems.PUDDING);
            }

            if (frostbiteBerriesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_WARPED_FORAGE_MIX)) {
                entries.accept(ModItems.WARPED_FORAGE_MIX);
            }

            if (cindersnapBerriesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_CRIMSON_FORAGE_MIX)) {
                entries.accept(ModItems.CRIMSON_FORAGE_MIX);
            }

            if (blueberriesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_BLUEBERRY_JUICE)) {
                entries.accept(ModItems.BLUEBERRY_JUICE);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SWEET_BERRY_JUICE)) {
                entries.accept(ModItems.SWEET_BERRY_JUICE);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CINDERSNAP_BERRY_JUICE)
                    && cindersnapBerriesEnabled) {
                entries.accept(ModItems.CINDERSNAP_BERRY_JUICE);
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_FROSTBITE_BERRY_JUICE)
                    && frostbiteBerriesEnabled) {
                entries.accept(ModItems.FROSTBITE_BERRY_JUICE);
            }

            if (blueberriesEnabled && config.evaluateEntry(ModConfigKeys.ENABLE_BLUEBERRY_PIE)) {
                entries.accept(ModBlocks.BLUEBERRY_PIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_SWEET_BERRY_PIE)) {
                entries.accept(ModBlocks.SWEET_BERRY_PIE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_CHOCOLATE_CAKE)) {
                entries.accept(ModBlocks.CHOCOLATE_CAKE.asItem());
            }

            if (config.evaluateEntry(ModConfigKeys.ENABLE_RED_VELVET_CAKE)) {
                entries.accept(ModBlocks.RED_VELVET_CAKE.asItem());
            }
        });
    }
}
