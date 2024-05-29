package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block.*;

import java.util.function.ToIntFunction;

public class ADBlocks {
    public static final Block BAT_PLUSH = new ADBatPlushBlock(AbstractBlock.Settings.create().burnable()
            .mapColor(MapColor.CLEAR).strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BLAZE_PLUSH = new ADBlazePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CAVE_SPIDER_PLUSH = new ADCaveSpiderPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CHICKEN_PLUSH = new ADChickenPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block COW_PLUSH = new ADCowPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CREEPER_PLUSH = new ADCreeperPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block ENDERMAN_PLUSH = new ADEndermanPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GHAST_PLUSH = new ADGhastPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GUARDIAN_PLUSH = new ADGuardianPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WHITE_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GRAY_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block LIGHT_GRAY_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BROWN_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BLACK_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block MAGMA_CUBE_PLUSH = new ADCubePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block RED_MOOSHROOM_PLUSH = new ADMooshroomPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BROWN_MOOSHROOM_PLUSH = new ADMooshroomPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block OCELOT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block TABBY_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block TUXEDO_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block RED_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SIAMESE_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CALICO_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PERSIAN_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block RAGDOLL_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WHITE_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block JELLIE_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BLACK_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PIG_PLUSH = new ADPigPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BROWN_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WHITE_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BLACK_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GOLD_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block TOAST_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SALT_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WHITE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block ORANGE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block MAGENTA_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block LIGHT_BLUE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block YELLOW_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block LIME_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PINK_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GRAY_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block LIGHT_GRAY_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CYAN_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PURPLE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BLUE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BROWN_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GREEN_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block RED_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block BLACK_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block MAROON_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SKELETON_PLUSH = new ADSkeletonPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SLIME_PLUSH = new ADCubePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SPIDER_PLUSH = new ADSpiderPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SQUID_PLUSH = new ADSquidPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block GLOW_SQUID_PLUSH = new ADSquidPlushBlock(AbstractBlock.Settings.create().burnable()
            .mapColor(MapColor.CLEAR).strength(0.2F).sounds(BlockSoundGroup.WOOL).luminance((state) -> 10));
    public static final Block BEE_PLUSH = new ADBeePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PLAINS_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block DESERT_VILLAGER_PLUSH = new ADDesertVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block JUNGLE_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SAVANNA_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SNOW_VILLAGER_PLUSH = new ADShortHatVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SWAMP_VILLAGER_PLUSH = new ADShortHatVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block TAIGA_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CRIMSON_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WARPED_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WANDERING_TRADER_PLUSH = new ADShortHatVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PLAINS_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block DESERT_ZOMBIE_VILLAGER_PLUSH = new ADDesertZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block JUNGLE_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SAVANNA_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SNOW_ZOMBIE_VILLAGER_PLUSH = new ADShortHatZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SWAMP_ZOMBIE_VILLAGER_PLUSH = new ADShortHatZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block TAIGA_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block CRIMSON_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WARPED_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WITCH_PLUSH = new ADWitchPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WOLF_PLUSH = new ADWolfPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block ZOMBIE_PLUSH = new ADZombiePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PIGLIN_PLUSH = new ADPiglinPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block ZOMBIFIED_PIGLIN_PLUSH = new ADZombiePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PUFFERFISH_PLUSH = new ADPufferfishPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block WITHER_PLUSH = new ADWitherPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block STRIDER_PLUSH = new ADStriderPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SHIVERING_STRIDER_PLUSH = new ADStriderPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block PHANTOM_PLUSH = new ADPhantomPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block HOGLIN_PLUSH = new ADHoglinPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block ZOGLIN_PLUSH = new ADHoglinPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block POLAR_BEAR_PLUSH = new ADPolarBearPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block ALLAY_PLUSH = new ADAllayPlushBlock(AbstractBlock.Settings.copy(GLOW_SQUID_PLUSH));
    public static final Block PILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block VINDICATOR_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block EVOKER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block RAVAGER_PLUSH = new ADHoglinPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block SHULKER_PLUSH = new ADShulkerPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block VEX_PLUSH = new ADAllayPlushBlock(AbstractBlock.Settings.copy(GLOW_SQUID_PLUSH));
    public static final Block NETHER_SMOKY_QUARTZ_ORE = new ExperienceDroppingBlock(
            AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE));
    public static final Block SMOKY_QUARTZ_BLOCK = new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK)
            .requiresTool().strength(0.8F));
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICKS = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS = new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_PILLAR = new PillarBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_STAIRS = new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block CRACKED_STONE_BRICK_STAIRS = new StairsBlock(Blocks.CRACKED_STONE_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block CRACKED_STONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block CRACKED_STONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block BLUEBERRY_BUSH = new ADBlueberryBushBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
    public static final Block GREEN_ONIONS = new ADGreenOnionBlock(AbstractBlock.Settings.copy(Blocks.WHEAT),
            () -> ADItems.GREEN_ONION);
    public static final Block OAK_PLANTER_BOX = planterBoxBlock(Blocks.OAK_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block SPRUCE_PLANTER_BOX = planterBoxBlock(Blocks.SPRUCE_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block BIRCH_PLANTER_BOX = planterBoxBlock(Blocks.BIRCH_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block JUNGLE_PLANTER_BOX = planterBoxBlock(Blocks.JUNGLE_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block ACACIA_PLANTER_BOX = planterBoxBlock(Blocks.ACACIA_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block DARK_OAK_PLANTER_BOX = planterBoxBlock(Blocks.DARK_OAK_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block MANGROVE_PLANTER_BOX = planterBoxBlock(Blocks.MANGROVE_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.WOOD);
    public static final Block CHERRY_PLANTER_BOX = planterBoxBlock(Blocks.CHERRY_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.CHERRY_WOOD);
    public static final Block CRIMSON_PLANTER_BOX = netherPlanterBoxBlock(Blocks.CRIMSON_PLANKS.getDefaultMapColor());
    public static final Block WARPED_PLANTER_BOX = netherPlanterBoxBlock(Blocks.WARPED_PLANKS.getDefaultMapColor());
    public static final Block OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block SPRUCE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS));
    public static final Block BIRCH_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS));
    public static final Block JUNGLE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS));
    public static final Block ACACIA_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS));
    public static final Block DARK_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS));
    public static final Block MANGROVE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS));
    public static final Block CRIMSON_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));
    public static final Block WARPED_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
    public static final Block CHERRY_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS));
    public static final Block STRIPPED_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block STRIPPED_SPRUCE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS));
    public static final Block STRIPPED_BIRCH_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS));
    public static final Block STRIPPED_JUNGLE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS));
    public static final Block STRIPPED_ACACIA_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS));
    public static final Block STRIPPED_DARK_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS));
    public static final Block STRIPPED_MANGROVE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS));
    public static final Block STRIPPED_CRIMSON_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));
    public static final Block STRIPPED_WARPED_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
    public static final Block STRIPPED_CHERRY_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS));
    public static final Block OAK_ROPE_LADDER = ropeLadderBlock();
    public static final Block SPRUCE_ROPE_LADDER = ropeLadderBlock();
    public static final Block BIRCH_ROPE_LADDER = ropeLadderBlock();
    public static final Block JUNGLE_ROPE_LADDER = ropeLadderBlock();
    public static final Block ACACIA_ROPE_LADDER = ropeLadderBlock();
    public static final Block DARK_OAK_ROPE_LADDER = ropeLadderBlock();
    public static final Block CRIMSON_ROPE_LADDER = ropeLadderBlock();
    public static final Block WARPED_ROPE_LADDER = ropeLadderBlock();
    public static final Block MANGROVE_ROPE_LADDER = ropeLadderBlock();
    public static final Block CHERRY_ROPE_LADDER = ropeLadderBlock();
    public static final Block IRON_LADDER = new LadderBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY)
            .requiresTool().strength(5.0F).sounds(BlockSoundGroup.METAL).nonOpaque());
    public static final Block SNOW_BRICKS = new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE)
            .strength(0.4F).requiresTool().sounds(BlockSoundGroup.SNOW));
    public static final Block SNOW_BRICK_STAIRS = new StairsBlock(ADBlocks.SNOW_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block SNOW_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block SNOW_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block PACKED_SNOW = new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE)
            .strength(0.6F).requiresTool().sounds(BlockSoundGroup.SNOW));
    public static final Block PACKED_SNOW_STAIRS = new StairsBlock(ADBlocks.PACKED_SNOW.getDefaultState(),
            AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block PACKED_SNOW_SLAB = new SlabBlock(AbstractBlock.Settings.copy(PACKED_SNOW));
    public static final Block PACKED_SNOW_WALL = new WallBlock(AbstractBlock.Settings.copy(PACKED_SNOW));
    public static final Block PURPLE_MUSHROOM = new MushroomPlantBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.PURPLE).pistonBehavior(PistonBehavior.DESTROY).noCollision().ticksRandomly()
            .breakInstantly().sounds(BlockSoundGroup.GRASS).postProcess(ADBlocks::always),
            ADConfiguredFeatureKeys.HUGE_PURPLE_MUSHROOM);
    public static final Block PURPLE_MUSHROOM_BLOCK = new ADPurpleMushroomBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block WOODCUTTER = new ADWoodcutterBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.OAK_TAN).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable());
    public static final Block WHITE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.WHITE_EMBER);
    public static final Block ORANGE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.ORANGE_EMBER);
    public static final Block MAGENTA_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.MAGENTA_EMBER);
    public static final Block LIGHT_BLUE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.LIGHT_BLUE_EMBER);
    public static final Block YELLOW_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.YELLOW_EMBER);
    public static final Block LIME_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.LIME_EMBER);
    public static final Block PINK_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.PINK_EMBER);
    public static final Block GRAY_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.GRAY_EMBER);
    public static final Block LIGHT_GRAY_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.LIGHT_GRAY_EMBER);
    public static final Block CYAN_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.CYAN_EMBER);
    public static final Block PURPLE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.PURPLE_EMBER);
    public static final Block BLUE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.BLUE_EMBER);
    public static final Block BROWN_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.BROWN_EMBER);
    public static final Block GREEN_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.GREEN_EMBER);
    public static final Block RED_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.RED_EMBER);
    public static final Block BLACK_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.BLACK_EMBER);
    public static final Block MAROON_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.MAROON_EMBER);
    public static final Block WHITE_LANTERN = lanternBlock();
    public static final Block ORANGE_LANTERN = lanternBlock();
    public static final Block MAGENTA_LANTERN = lanternBlock();
    public static final Block LIGHT_BLUE_LANTERN = lanternBlock();
    public static final Block YELLOW_LANTERN = lanternBlock();
    public static final Block LIME_LANTERN = lanternBlock();
    public static final Block PINK_LANTERN = lanternBlock();
    public static final Block GRAY_LANTERN = lanternBlock();
    public static final Block LIGHT_GRAY_LANTERN = lanternBlock();
    public static final Block CYAN_LANTERN = lanternBlock();
    public static final Block PURPLE_LANTERN = lanternBlock();
    public static final Block BLUE_LANTERN = lanternBlock();
    public static final Block BROWN_LANTERN = lanternBlock();
    public static final Block GREEN_LANTERN = lanternBlock();
    public static final Block RED_LANTERN = lanternBlock();
    public static final Block BLACK_LANTERN = lanternBlock();
    public static final Block MAROON_LANTERN = lanternBlock();
    public static final Block WHITE_WALL_TORCH = wallTorchBlock(ADParticleTypes.WHITE_FLAME);
    public static final Block ORANGE_WALL_TORCH = wallTorchBlock(ADParticleTypes.ORANGE_FLAME);
    public static final Block MAGENTA_WALL_TORCH = wallTorchBlock(ADParticleTypes.MAGENTA_FLAME);
    public static final Block LIGHT_BLUE_WALL_TORCH = wallTorchBlock(ADParticleTypes.LIGHT_BLUE_FLAME);
    public static final Block YELLOW_WALL_TORCH = wallTorchBlock(ADParticleTypes.YELLOW_FLAME);
    public static final Block LIME_WALL_TORCH = wallTorchBlock(ADParticleTypes.LIME_FLAME);
    public static final Block PINK_WALL_TORCH = wallTorchBlock(ADParticleTypes.PINK_FLAME);
    public static final Block GRAY_WALL_TORCH = wallTorchBlock(ADParticleTypes.GRAY_FLAME);
    public static final Block LIGHT_GRAY_WALL_TORCH = wallTorchBlock(ADParticleTypes.LIGHT_GRAY_FLAME);
    public static final Block CYAN_WALL_TORCH = wallTorchBlock(ADParticleTypes.CYAN_FLAME);
    public static final Block PURPLE_WALL_TORCH = wallTorchBlock(ADParticleTypes.PURPLE_FLAME);
    public static final Block BLUE_WALL_TORCH = wallTorchBlock(ADParticleTypes.BLUE_FLAME);
    public static final Block BROWN_WALL_TORCH = wallTorchBlock(ADParticleTypes.BROWN_FLAME);
    public static final Block GREEN_WALL_TORCH = wallTorchBlock(ADParticleTypes.GREEN_FLAME);
    public static final Block RED_WALL_TORCH = wallTorchBlock(ADParticleTypes.RED_FLAME);
    public static final Block BLACK_WALL_TORCH = wallTorchBlock(ADParticleTypes.BLACK_FLAME);
    public static final Block MAROON_WALL_TORCH = wallTorchBlock(ADParticleTypes.MAROON_FLAME);
    public static final Block WHITE_TORCH = torchBlock(ADParticleTypes.WHITE_FLAME);
    public static final Block ORANGE_TORCH = torchBlock(ADParticleTypes.ORANGE_FLAME);
    public static final Block MAGENTA_TORCH = torchBlock(ADParticleTypes.MAGENTA_FLAME);
    public static final Block LIGHT_BLUE_TORCH = torchBlock(ADParticleTypes.LIGHT_BLUE_FLAME);
    public static final Block YELLOW_TORCH = torchBlock(ADParticleTypes.YELLOW_FLAME);
    public static final Block LIME_TORCH = torchBlock(ADParticleTypes.LIME_FLAME);
    public static final Block PINK_TORCH = torchBlock(ADParticleTypes.PINK_FLAME);
    public static final Block GRAY_TORCH = torchBlock(ADParticleTypes.GRAY_FLAME);
    public static final Block LIGHT_GRAY_TORCH = torchBlock(ADParticleTypes.LIGHT_GRAY_FLAME);
    public static final Block CYAN_TORCH = torchBlock(ADParticleTypes.CYAN_FLAME);
    public static final Block PURPLE_TORCH = torchBlock(ADParticleTypes.PURPLE_FLAME);
    public static final Block BLUE_TORCH = torchBlock(ADParticleTypes.BLUE_FLAME);
    public static final Block BROWN_TORCH = torchBlock(ADParticleTypes.BROWN_FLAME);
    public static final Block GREEN_TORCH = torchBlock(ADParticleTypes.GREEN_FLAME);
    public static final Block RED_TORCH = torchBlock(ADParticleTypes.RED_FLAME);
    public static final Block BLACK_TORCH = torchBlock(ADParticleTypes.BLACK_FLAME);
    public static final Block MAROON_TORCH = torchBlock(ADParticleTypes.MAROON_FLAME);
    public static final Block WITCHS_CRADLE = new ADWitchsCradleBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
            .luminance((state) -> 10));
    public static final Block BAUXITE = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.SPRUCE_BROWN).strength(0.3F));
    public static final Block BAUXITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE));
    public static final Block BAUXITE_STAIRS = new StairsBlock(BAUXITE.getDefaultState(),
            AbstractBlock.Settings.copy(BAUXITE));
    public static final Block BAUXITE_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE));
    public static final Block BAUXITE_BRICKS = new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.SPRUCE_BROWN).strength(0.4F).sounds(BlockSoundGroup.STONE));
    public static final Block BAUXITE_BRICK_STAIRS = new StairsBlock(BAUXITE_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block BAUXITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block BAUXITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block MOSSY_BAUXITE_BRICKS = new Block(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block MOSSY_BAUXITE_BRICK_STAIRS = new StairsBlock(MOSSY_BAUXITE_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block MOSSY_BAUXITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block MOSSY_BAUXITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block CRACKED_BAUXITE_BRICKS = new Block(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block CRACKED_BAUXITE_BRICK_STAIRS = new StairsBlock(BAUXITE_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block CRACKED_BAUXITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block CRACKED_BAUXITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
    public static final Block TWISTED_NETHER_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_STAIRS = new StairsBlock(TWISTED_NETHER_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
    public static final Block TWISTED_NETHERRACK = new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK));
    public static final Block TWISTED_NETHERRACK_STAIRS = new StairsBlock(TWISTED_NETHERRACK.getDefaultState(),
            AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
    public static final Block TWISTED_NETHERRACK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
    public static final Block TWISTED_NETHERRACK_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
    public static final Block WEEPING_NETHER_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_STAIRS = new StairsBlock(WEEPING_NETHER_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
    public static final Block WEEPING_NETHERRACK = new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK));
    public static final Block WEEPING_NETHERRACK_STAIRS = new StairsBlock(WEEPING_NETHERRACK.getDefaultState(),
            AbstractBlock.Settings.copy(WEEPING_NETHERRACK));
    public static final Block WEEPING_NETHERRACK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(WEEPING_NETHERRACK));
    public static final Block WEEPING_NETHERRACK_WALL = new WallBlock(AbstractBlock.Settings.copy(WEEPING_NETHERRACK));
    public static final Block SNAPDRAGON = new ADSnapdragonBlock(StatusEffects.LUCK, 8,
            AbstractBlock.Settings.copy(Blocks.POPPY).luminance((state) -> 7));
    public static final Block POTTED_SNAPDRAGON = new ADPottedSnapdragonBlock(ADBlocks.SNAPDRAGON,
            AbstractBlock.Settings.copy(Blocks.POTTED_POPPY).luminance((state) -> 7));
    public static final Block POTTED_PURPLE_MUSHROOM = new FlowerPotBlock(ADBlocks.PURPLE_MUSHROOM,
            AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM));
    public static final Block ENDER_GRASS = new ADEnderGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS)
            .luminance((state) -> 7));
    public static final Block ICICLE = new ADIcicleBlock(AbstractBlock.Settings.create().requiresTool()
            .strength(0.2F).noCollision().sounds(BlockSoundGroup.GLASS));
    public static final Block CATTAIL = new ADCattailBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
            .noCollision().nonOpaque().sounds(BlockSoundGroup.WET_GRASS));
    public static final Block CHOCOLATE_CAKE = new ADCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
    public static final Block RED_VELVET_CAKE = new ADCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
    public static final Block STONE_TILES = new Block(AbstractBlock.Settings.copy(Blocks.STONE)
            .sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block STONE_TILE_STAIRS = new StairsBlock(STONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILES = new Block(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILE_STAIRS = new StairsBlock(MOSSY_STONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILES = new Block(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILE_STAIRS = new StairsBlock(CRACKED_STONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block SWEET_BERRY_PIE = new ADPieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), 3,
            0.6F);
    public static final Block BLUEBERRY_PIE = new ADPieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), 3,
            0.6F);
    public static final Block BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)
            .sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block BLACKSTONE_TILE_STAIRS = new StairsBlock(BLACKSTONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS = new StairsBlock(BLACKSTONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS = new StairsBlock(BLACKSTONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS = new StairsBlock(
            Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = new StairsBlock(
            Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_BLACKSTONE = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_STAIRS = new StairsBlock(Blocks.BLACKSTONE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_STAIRS = new StairsBlock(
            Blocks.BLACKSTONE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block QUARTZ_TILES = new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK)
            .sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block QUARTZ_TILE_STAIRS = new StairsBlock(QUARTZ_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(QUARTZ_TILES));
    public static final Block QUARTZ_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(QUARTZ_TILES));
    public static final Block QUARTZ_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(QUARTZ_TILES));
    public static final Block CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICK_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CRACKED_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CRACKED_CALCITE_BRICK_STAIRS = new StairsBlock(
            CRACKED_CALCITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
    public static final Block CRACKED_CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
    public static final Block CRACKED_CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
    public static final Block CHISELED_CALCITE_BRICKS = new PillarBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICK_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CHISELED_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block BLOOD_KELP = new ADBloodKelpBlock(AbstractBlock.Settings.copy(Blocks.KELP)
            .luminance(getLuminanceFromState()));
    public static final Block BLOOD_KELP_PLANT = new ADBloodKelpPlantBlock(AbstractBlock.Settings.copy(Blocks.KELP_PLANT)
            .luminance(getLuminanceFromState()));
    public static final Block DRIED_BLOOD_KELP_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.DRIED_KELP_BLOCK));
    public static final Block BLOOD_KELP_LANTERN = new PillarBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.PALE_YELLOW).strength(0.3F).sounds(BlockSoundGroup.GLASS).luminance((state) -> 15));
    public static final Block MAROON_WOOL = new Block(AbstractBlock.Settings.copy(Blocks.RED_WOOL));
    public static final Block MAROON_STAINED_GLASS = new StainedGlassBlock(DyeColor.RED,
            AbstractBlock.Settings.create().mapColor(DyeColor.RED).strength(0.3F).sounds(BlockSoundGroup.GLASS)
                    .nonOpaque().allowsSpawning(ADBlocks::never).solidBlock(ADBlocks::never).suffocates(ADBlocks::never)
                    .blockVision(ADBlocks::never));
    public static final Block MAROON_STAINED_GLASS_PANE = new StainedGlassPaneBlock(DyeColor.RED,
            AbstractBlock.Settings.create().instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS)
                    .nonOpaque());
    public static final Block MAROON_CANDLE = new CandleBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_RED).nonOpaque().strength(0.1F)
            .sounds(BlockSoundGroup.CANDLE).luminance(CandleBlock.STATE_TO_LUMINANCE)
            .pistonBehavior(PistonBehavior.DESTROY));
    public static final Block MAROON_CONCRETE = new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED)
            .requiresTool().strength(1.8F).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.STONE));
    public static final Block MAROON_CONCRETE_POWDER = new ConcretePowderBlock(MAROON_CONCRETE,
            AbstractBlock.Settings.create().instrument(Instrument.SNARE).mapColor(MapColor.DARK_RED)
                    .strength(0.5F).sounds(BlockSoundGroup.SAND));
    public static final Block MAROON_CANDLE_CAKE = new CandleCakeBlock(MAROON_CANDLE, AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block WEEPING_HEART = new ADWeepingHeartBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_GREEN).breakInstantly().noCollision().sounds(BlockSoundGroup.SPORE_BLOSSOM)
            .pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> 10));
    public static final Block MAROON_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, MAROON_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block WHITE_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.WHITE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block ORANGE_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.ORANGE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block MAGENTA_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.MAGENTA_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIGHT_BLUE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block YELLOW_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.YELLOW_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block LIME_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIME_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block PINK_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.PINK_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block GRAY_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.GRAY_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIGHT_GRAY_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block CYAN_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.CYAN_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block PURPLE_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.PURPLE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block BLUE_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BLUE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block BROWN_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BROWN_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block GREEN_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.GREEN_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block RED_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.RED_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block BLACK_CANDLE_CHOCOLATE_CAKE = new ADCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BLACK_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block MAROON_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, MAROON_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block WHITE_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.WHITE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block ORANGE_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.ORANGE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block MAGENTA_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.MAGENTA_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block LIGHT_BLUE_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.LIGHT_BLUE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block YELLOW_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.YELLOW_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block LIME_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.LIME_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block PINK_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.PINK_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block GRAY_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.GRAY_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block LIGHT_GRAY_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.LIGHT_GRAY_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block CYAN_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.CYAN_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block PURPLE_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.PURPLE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block BLUE_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.BLUE_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block BROWN_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.BROWN_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block GREEN_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.GREEN_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block RED_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.RED_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block BLACK_CANDLE_RED_VELVET_CAKE = new ADCandleCakeBlock(RED_VELVET_CAKE, Blocks.BLACK_CANDLE,
            AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
    public static final Block CAMEL_PLUSH = new ADCamelPlushBlock(AbstractBlock.Settings.copy(ADBlocks.BAT_PLUSH));
    public static final Block CINDERSNAP_BERRY_BUSH = new ADCindersnapBerryBushBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_CRIMSON).ticksRandomly().noCollision().sounds(BlockSoundGroup.NETHER_SPROUTS)
            .pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> 8));
    public static final Block FROSTBITE_BERRY_BUSH = new ADFrostbiteBerryBushBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.CYAN).ticksRandomly().noCollision().sounds(BlockSoundGroup.NETHER_SPROUTS)
            .pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> 5));
    public static final Block POLISHED_DRIPSTONE = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block POLISHED_DRIPSTONE_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block POLISHED_DRIPSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block POLISHED_DRIPSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block POLISHED_CALCITE = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block DRIPSTONE_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CALCITE_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block BAMBOO_PLANTER_BOX = planterBoxBlock(Blocks.BAMBOO_PLANKS.getDefaultMapColor(),
            BlockSoundGroup.BAMBOO_WOOD);

    private static WallTorchBlock wallTorchBlock(ParticleEffect flameParticle) {
        return new WallTorchBlock(AbstractBlock.Settings.copy(Blocks.WALL_TORCH), flameParticle);
    }

    private static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    private static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    private static TorchBlock torchBlock(ParticleEffect flameParticle) {
        return new TorchBlock(AbstractBlock.Settings.copy(Blocks.TORCH), flameParticle);
    }

    private static LanternBlock lanternBlock() {
        return new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN));
    }

    private static ADRopeLadderBlock ropeLadderBlock() { return new ADRopeLadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER)); }

    private static ADPlanterBoxBlock planterBoxBlock(MapColor color, BlockSoundGroup soundGroup) {
        return new ADPlanterBoxBlock(AbstractBlock.Settings.create().mapColor(color).strength(2.5F)
                .sounds(soundGroup).burnable());
    }

    private static ADPlanterBoxBlock netherPlanterBoxBlock(MapColor color) {
        return new ADPlanterBoxBlock(AbstractBlock.Settings.create().mapColor(color).strength(2.5F)
                .sounds(BlockSoundGroup.NETHER_WOOD));
    }

    private static ADDyedCampfireBlock dyedCampfireBlock(ParticleEffect emberParticle) {
        return new ADDyedCampfireBlock(AbstractBlock.Settings.copy(Blocks.CAMPFIRE), emberParticle);
    }

    private static ToIntFunction<BlockState> getLuminanceFromState() {
        return (state) -> state.get(Properties.LIT) ? 10 : 0;
    }

    private static void registerBlock(String path, Block block) {
        Registry.register(Registries.BLOCK, ADReference.makeModId(path), block);
    }

    /**
     * Called during mod initialization to register every block.
     */
    public static void registerBlocks() {
        registerBlock("bat_plush", BAT_PLUSH);
        registerBlock("blaze_plush", BLAZE_PLUSH);
        registerBlock("cave_spider_plush", CAVE_SPIDER_PLUSH);
        registerBlock("chicken_plush", CHICKEN_PLUSH);
        registerBlock("cow_plush", COW_PLUSH);
        registerBlock("creeper_plush", CREEPER_PLUSH);
        registerBlock("enderman_plush", ENDERMAN_PLUSH);
        registerBlock("ghast_plush", GHAST_PLUSH);
        registerBlock("guardian_plush", GUARDIAN_PLUSH);
        registerBlock("white_horse_plush", WHITE_HORSE_PLUSH);
        registerBlock("gray_horse_plush", GRAY_HORSE_PLUSH);
        registerBlock("light_gray_horse_plush", LIGHT_GRAY_HORSE_PLUSH);
        registerBlock("brown_horse_plush", BROWN_HORSE_PLUSH);
        registerBlock("black_horse_plush", BLACK_HORSE_PLUSH);
        registerBlock("magma_cube_plush", MAGMA_CUBE_PLUSH);
        registerBlock("red_mooshroom_plush", RED_MOOSHROOM_PLUSH);
        registerBlock("brown_mooshroom_plush", BROWN_MOOSHROOM_PLUSH);
        registerBlock("ocelot_plush", OCELOT_PLUSH);
        registerBlock("tabby_cat_plush", TABBY_CAT_PLUSH);
        registerBlock("tuxedo_cat_plush", TUXEDO_CAT_PLUSH);
        registerBlock("red_cat_plush", RED_CAT_PLUSH);
        registerBlock("siamese_cat_plush", SIAMESE_CAT_PLUSH);
        registerBlock("british_shorthair_cat_plush", BRITISH_SHORTHAIR_CAT_PLUSH);
        registerBlock("calico_cat_plush", CALICO_CAT_PLUSH);
        registerBlock("persian_cat_plush", PERSIAN_CAT_PLUSH);
        registerBlock("ragdoll_cat_plush", RAGDOLL_CAT_PLUSH);
        registerBlock("white_cat_plush", WHITE_CAT_PLUSH);
        registerBlock("jellie_cat_plush", JELLIE_CAT_PLUSH);
        registerBlock("black_cat_plush", BLACK_CAT_PLUSH);
        registerBlock("pig_plush", PIG_PLUSH);
        registerBlock("brown_rabbit_plush", BROWN_RABBIT_PLUSH);
        registerBlock("white_rabbit_plush", WHITE_RABBIT_PLUSH);
        registerBlock("black_rabbit_plush", BLACK_RABBIT_PLUSH);
        registerBlock("white_splotched_rabbit_plush", WHITE_SPLOTCHED_RABBIT_PLUSH);
        registerBlock("gold_rabbit_plush", GOLD_RABBIT_PLUSH);
        registerBlock("toast_rabbit_plush", TOAST_RABBIT_PLUSH);
        registerBlock("salt_rabbit_plush", SALT_RABBIT_PLUSH);
        registerBlock("white_sheep_plush", WHITE_SHEEP_PLUSH);
        registerBlock("orange_sheep_plush", ORANGE_SHEEP_PLUSH);
        registerBlock("magenta_sheep_plush", MAGENTA_SHEEP_PLUSH);
        registerBlock("light_blue_sheep_plush", LIGHT_BLUE_SHEEP_PLUSH);
        registerBlock("yellow_sheep_plush", YELLOW_SHEEP_PLUSH);
        registerBlock("lime_sheep_plush", LIME_SHEEP_PLUSH);
        registerBlock("pink_sheep_plush", PINK_SHEEP_PLUSH);
        registerBlock("gray_sheep_plush", GRAY_SHEEP_PLUSH);
        registerBlock("light_gray_sheep_plush", LIGHT_GRAY_SHEEP_PLUSH);
        registerBlock("cyan_sheep_plush", CYAN_SHEEP_PLUSH);
        registerBlock("purple_sheep_plush", PURPLE_SHEEP_PLUSH);
        registerBlock("blue_sheep_plush", BLUE_SHEEP_PLUSH);
        registerBlock("brown_sheep_plush", BROWN_SHEEP_PLUSH);
        registerBlock("green_sheep_plush", GREEN_SHEEP_PLUSH);
        registerBlock("red_sheep_plush", RED_SHEEP_PLUSH);
        registerBlock("black_sheep_plush", BLACK_SHEEP_PLUSH);
        registerBlock("maroon_sheep_plush", MAROON_SHEEP_PLUSH);
        registerBlock("skeleton_plush", SKELETON_PLUSH);
        registerBlock("slime_plush", SLIME_PLUSH);
        registerBlock("spider_plush", SPIDER_PLUSH);
        registerBlock("squid_plush", SQUID_PLUSH);
        registerBlock("glow_squid_plush", GLOW_SQUID_PLUSH);
        registerBlock("bee_plush", BEE_PLUSH);
        registerBlock("plains_villager_plush", PLAINS_VILLAGER_PLUSH);
        registerBlock("desert_villager_plush", DESERT_VILLAGER_PLUSH);
        registerBlock("jungle_villager_plush", JUNGLE_VILLAGER_PLUSH);
        registerBlock("savanna_villager_plush", SAVANNA_VILLAGER_PLUSH);
        registerBlock("snow_villager_plush", SNOW_VILLAGER_PLUSH);
        registerBlock("swamp_villager_plush", SWAMP_VILLAGER_PLUSH);
        registerBlock("taiga_villager_plush", TAIGA_VILLAGER_PLUSH);
        registerBlock("crimson_villager_plush", CRIMSON_VILLAGER_PLUSH);
        registerBlock("warped_villager_plush", WARPED_VILLAGER_PLUSH);
        registerBlock("wandering_trader_plush", WANDERING_TRADER_PLUSH);
        registerBlock("plains_zombie_villager_plush", PLAINS_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("desert_zombie_villager_plush", DESERT_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("jungle_zombie_villager_plush", JUNGLE_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("savanna_zombie_villager_plush", SAVANNA_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("snow_zombie_villager_plush", SNOW_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("swamp_zombie_villager_plush", SWAMP_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("taiga_zombie_villager_plush", TAIGA_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("crimson_zombie_villager_plush", CRIMSON_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("warped_zombie_villager_plush", WARPED_ZOMBIE_VILLAGER_PLUSH);
        registerBlock("witch_plush", WITCH_PLUSH);
        registerBlock("wolf_plush", WOLF_PLUSH);
        registerBlock("zombie_plush", ZOMBIE_PLUSH);
        registerBlock("piglin_plush", PIGLIN_PLUSH);
        registerBlock("zombified_piglin_plush", ZOMBIFIED_PIGLIN_PLUSH);
        registerBlock("pufferfish_plush", PUFFERFISH_PLUSH);
        registerBlock("wither_plush", WITHER_PLUSH);
        registerBlock("strider_plush", STRIDER_PLUSH);
        registerBlock("shivering_strider_plush", SHIVERING_STRIDER_PLUSH);
        registerBlock("phantom_plush", PHANTOM_PLUSH);
        registerBlock("hoglin_plush", HOGLIN_PLUSH);
        registerBlock("zoglin_plush", ZOGLIN_PLUSH);
        registerBlock("polar_bear_plush", POLAR_BEAR_PLUSH);
        registerBlock("allay_plush", ALLAY_PLUSH);
        registerBlock("pillager_plush", PILLAGER_PLUSH);
        registerBlock("vindicator_plush", VINDICATOR_PLUSH);
        registerBlock("evoker_plush", EVOKER_PLUSH);
        registerBlock("ravager_plush", RAVAGER_PLUSH);
        registerBlock("shulker_plush", SHULKER_PLUSH);
        registerBlock("vex_plush", VEX_PLUSH);
        registerBlock("nether_smoky_quartz_ore", NETHER_SMOKY_QUARTZ_ORE);
        registerBlock("smoky_quartz_block", SMOKY_QUARTZ_BLOCK);
        registerBlock("chiseled_smoky_quartz_block", CHISELED_SMOKY_QUARTZ_BLOCK);
        registerBlock("smoky_quartz_bricks", SMOKY_QUARTZ_BRICKS);
        registerBlock("smoky_quartz_brick_stairs", SMOKY_QUARTZ_BRICK_STAIRS);
        registerBlock("smoky_quartz_brick_slab", SMOKY_QUARTZ_BRICK_SLAB);
        registerBlock("smoky_quartz_brick_wall", SMOKY_QUARTZ_BRICK_WALL);
        registerBlock("smoky_quartz_pillar", SMOKY_QUARTZ_PILLAR);
        registerBlock("smoky_quartz_stairs", SMOKY_QUARTZ_STAIRS);
        registerBlock("smoky_quartz_slab", SMOKY_QUARTZ_SLAB);
        registerBlock("smoky_quartz_wall", SMOKY_QUARTZ_WALL);
        registerBlock("smooth_smoky_quartz", SMOOTH_SMOKY_QUARTZ);
        registerBlock("smooth_smoky_quartz_stairs", SMOOTH_SMOKY_QUARTZ_STAIRS);
        registerBlock("smooth_smoky_quartz_slab", SMOOTH_SMOKY_QUARTZ_SLAB);
        registerBlock("smooth_smoky_quartz_wall", SMOOTH_SMOKY_QUARTZ_WALL);
        registerBlock("cracked_stone_brick_stairs", CRACKED_STONE_BRICK_STAIRS);
        registerBlock("cracked_stone_brick_slab", CRACKED_STONE_BRICK_SLAB);
        registerBlock("cracked_stone_brick_wall", CRACKED_STONE_BRICK_WALL);
        registerBlock("blueberry_bush", BLUEBERRY_BUSH);
        registerBlock("green_onions", GREEN_ONIONS);
        registerBlock("oak_planter_box", OAK_PLANTER_BOX);
        registerBlock("spruce_planter_box", SPRUCE_PLANTER_BOX);
        registerBlock("birch_planter_box", BIRCH_PLANTER_BOX);
        registerBlock("jungle_planter_box", JUNGLE_PLANTER_BOX);
        registerBlock("acacia_planter_box", ACACIA_PLANTER_BOX);
        registerBlock("dark_oak_planter_box", DARK_OAK_PLANTER_BOX);
        registerBlock("mangrove_planter_box", MANGROVE_PLANTER_BOX);
        registerBlock("cherry_planter_box", CHERRY_PLANTER_BOX);
        registerBlock("crimson_planter_box", CRIMSON_PLANTER_BOX);
        registerBlock("warped_planter_box", WARPED_PLANTER_BOX);
        registerBlock("oak_wall", OAK_WALL);
        registerBlock("spruce_wall", SPRUCE_WALL);
        registerBlock("birch_wall", BIRCH_WALL);
        registerBlock("jungle_wall", JUNGLE_WALL);
        registerBlock("acacia_wall", ACACIA_WALL);
        registerBlock("dark_oak_wall", DARK_OAK_WALL);
        registerBlock("mangrove_wall", MANGROVE_WALL);
        registerBlock("crimson_wall", CRIMSON_WALL);
        registerBlock("warped_wall", WARPED_WALL);
        registerBlock("cherry_wall", CHERRY_WALL);
        registerBlock("stripped_oak_wall", STRIPPED_OAK_WALL);
        registerBlock("stripped_spruce_wall", STRIPPED_SPRUCE_WALL);
        registerBlock("stripped_birch_wall", STRIPPED_BIRCH_WALL);
        registerBlock("stripped_jungle_wall", STRIPPED_JUNGLE_WALL);
        registerBlock("stripped_acacia_wall", STRIPPED_ACACIA_WALL);
        registerBlock("stripped_dark_oak_wall", STRIPPED_DARK_OAK_WALL);
        registerBlock("stripped_mangrove_wall", STRIPPED_MANGROVE_WALL);
        registerBlock("stripped_crimson_wall", STRIPPED_CRIMSON_WALL);
        registerBlock("stripped_warped_wall", STRIPPED_WARPED_WALL);
        registerBlock("stripped_cherry_wall", STRIPPED_CHERRY_WALL);
        registerBlock("oak_rope_ladder", OAK_ROPE_LADDER);
        registerBlock("spruce_rope_ladder", SPRUCE_ROPE_LADDER);
        registerBlock("birch_rope_ladder", BIRCH_ROPE_LADDER);
        registerBlock("jungle_rope_ladder", JUNGLE_ROPE_LADDER);
        registerBlock("acacia_rope_ladder", ACACIA_ROPE_LADDER);
        registerBlock("dark_oak_rope_ladder", DARK_OAK_ROPE_LADDER);
        registerBlock("crimson_rope_ladder", CRIMSON_ROPE_LADDER);
        registerBlock("warped_rope_ladder", WARPED_ROPE_LADDER);
        registerBlock("mangrove_rope_ladder", MANGROVE_ROPE_LADDER);
        registerBlock("cherry_rope_ladder", CHERRY_ROPE_LADDER);
        registerBlock("iron_ladder", IRON_LADDER);
        registerBlock("snow_bricks", SNOW_BRICKS);
        registerBlock("snow_brick_stairs", SNOW_BRICK_STAIRS);
        registerBlock("snow_brick_slab", SNOW_BRICK_SLAB);
        registerBlock("snow_brick_wall", SNOW_BRICK_WALL);
        registerBlock("packed_snow", PACKED_SNOW);
        registerBlock("packed_snow_stairs", PACKED_SNOW_STAIRS);
        registerBlock("packed_snow_slab", PACKED_SNOW_SLAB);
        registerBlock("packed_snow_wall", PACKED_SNOW_WALL);
        registerBlock("purple_mushroom", PURPLE_MUSHROOM);
        registerBlock("purple_mushroom_block", PURPLE_MUSHROOM_BLOCK);
        registerBlock("woodcutter", WOODCUTTER);
        registerBlock("white_campfire", WHITE_CAMPFIRE);
        registerBlock("orange_campfire", ORANGE_CAMPFIRE);
        registerBlock("magenta_campfire", MAGENTA_CAMPFIRE);
        registerBlock("light_blue_campfire", LIGHT_BLUE_CAMPFIRE);
        registerBlock("yellow_campfire", YELLOW_CAMPFIRE);
        registerBlock("lime_campfire", LIME_CAMPFIRE);
        registerBlock("pink_campfire", PINK_CAMPFIRE);
        registerBlock("gray_campfire", GRAY_CAMPFIRE);
        registerBlock("light_gray_campfire", LIGHT_GRAY_CAMPFIRE);
        registerBlock("cyan_campfire", CYAN_CAMPFIRE);
        registerBlock("purple_campfire", PURPLE_CAMPFIRE);
        registerBlock("blue_campfire", BLUE_CAMPFIRE);
        registerBlock("brown_campfire", BROWN_CAMPFIRE);
        registerBlock("green_campfire", GREEN_CAMPFIRE);
        registerBlock("red_campfire", RED_CAMPFIRE);
        registerBlock("black_campfire", BLACK_CAMPFIRE);
        registerBlock("maroon_campfire", MAROON_CAMPFIRE);
        registerBlock("white_lantern", WHITE_LANTERN);
        registerBlock("orange_lantern", ORANGE_LANTERN);
        registerBlock("magenta_lantern", MAGENTA_LANTERN);
        registerBlock("light_blue_lantern", LIGHT_BLUE_LANTERN);
        registerBlock("yellow_lantern", YELLOW_LANTERN);
        registerBlock("lime_lantern", LIME_LANTERN);
        registerBlock("pink_lantern", PINK_LANTERN);
        registerBlock("gray_lantern", GRAY_LANTERN);
        registerBlock("light_gray_lantern", LIGHT_GRAY_LANTERN);
        registerBlock("cyan_lantern", CYAN_LANTERN);
        registerBlock("purple_lantern", PURPLE_LANTERN);
        registerBlock("blue_lantern", BLUE_LANTERN);
        registerBlock("brown_lantern", BROWN_LANTERN);
        registerBlock("green_lantern", GREEN_LANTERN);
        registerBlock("red_lantern", RED_LANTERN);
        registerBlock("black_lantern", BLACK_LANTERN);
        registerBlock("maroon_lantern", MAROON_LANTERN);
        registerBlock("white_wall_torch", WHITE_WALL_TORCH);
        registerBlock("orange_wall_torch", ORANGE_WALL_TORCH);
        registerBlock("magenta_wall_torch", MAGENTA_WALL_TORCH);
        registerBlock("light_blue_wall_torch", LIGHT_BLUE_WALL_TORCH);
        registerBlock("yellow_wall_torch", YELLOW_WALL_TORCH);
        registerBlock("lime_wall_torch", LIME_WALL_TORCH);
        registerBlock("pink_wall_torch", PINK_WALL_TORCH);
        registerBlock("gray_wall_torch", GRAY_WALL_TORCH);
        registerBlock("light_gray_wall_torch", LIGHT_GRAY_WALL_TORCH);
        registerBlock("cyan_wall_torch", CYAN_WALL_TORCH);
        registerBlock("purple_wall_torch", PURPLE_WALL_TORCH);
        registerBlock("blue_wall_torch", BLUE_WALL_TORCH);
        registerBlock("brown_wall_torch", BROWN_WALL_TORCH);
        registerBlock("green_wall_torch", GREEN_WALL_TORCH);
        registerBlock("red_wall_torch", RED_WALL_TORCH);
        registerBlock("black_wall_torch", BLACK_WALL_TORCH);
        registerBlock("maroon_wall_torch", MAROON_WALL_TORCH);
        registerBlock("white_torch", WHITE_TORCH);
        registerBlock("orange_torch", ORANGE_TORCH);
        registerBlock("magenta_torch", MAGENTA_TORCH);
        registerBlock("light_blue_torch", LIGHT_BLUE_TORCH);
        registerBlock("yellow_torch", YELLOW_TORCH);
        registerBlock("lime_torch", LIME_TORCH);
        registerBlock("pink_torch", PINK_TORCH);
        registerBlock("gray_torch", GRAY_TORCH);
        registerBlock("light_gray_torch", LIGHT_GRAY_TORCH);
        registerBlock("cyan_torch", CYAN_TORCH);
        registerBlock("purple_torch", PURPLE_TORCH);
        registerBlock("blue_torch", BLUE_TORCH);
        registerBlock("brown_torch", BROWN_TORCH);
        registerBlock("green_torch", GREEN_TORCH);
        registerBlock("red_torch", RED_TORCH);
        registerBlock("black_torch", BLACK_TORCH);
        registerBlock("maroon_torch", MAROON_TORCH);
        registerBlock("witchs_cradle", WITCHS_CRADLE);
        registerBlock("bauxite", BAUXITE);
        registerBlock("bauxite_slab", BAUXITE_SLAB);
        registerBlock("bauxite_stairs", BAUXITE_STAIRS);
        registerBlock("bauxite_wall", BAUXITE_WALL);
        registerBlock("bauxite_bricks", BAUXITE_BRICKS);
        registerBlock("bauxite_brick_stairs", BAUXITE_BRICK_STAIRS);
        registerBlock("bauxite_brick_slab", BAUXITE_BRICK_SLAB);
        registerBlock("bauxite_brick_wall", BAUXITE_BRICK_WALL);
        registerBlock("mossy_bauxite_bricks", MOSSY_BAUXITE_BRICKS);
        registerBlock("mossy_bauxite_brick_stairs", MOSSY_BAUXITE_BRICK_STAIRS);
        registerBlock("mossy_bauxite_brick_slab", MOSSY_BAUXITE_BRICK_SLAB);
        registerBlock("mossy_bauxite_brick_wall", MOSSY_BAUXITE_BRICK_WALL);
        registerBlock("cracked_bauxite_bricks", CRACKED_BAUXITE_BRICKS);
        registerBlock("cracked_bauxite_brick_stairs", CRACKED_BAUXITE_BRICK_STAIRS);
        registerBlock("cracked_bauxite_brick_slab", CRACKED_BAUXITE_BRICK_SLAB);
        registerBlock("cracked_bauxite_brick_wall", CRACKED_BAUXITE_BRICK_WALL);
        registerBlock("twisted_nether_bricks", TWISTED_NETHER_BRICKS);
        registerBlock("twisted_nether_brick_stairs", TWISTED_NETHER_BRICK_STAIRS);
        registerBlock("twisted_nether_brick_slab", TWISTED_NETHER_BRICK_SLAB);
        registerBlock("twisted_nether_brick_wall", TWISTED_NETHER_BRICK_WALL);
        registerBlock("twisted_netherrack", TWISTED_NETHERRACK);
        registerBlock("twisted_netherrack_stairs", TWISTED_NETHERRACK_STAIRS);
        registerBlock("twisted_netherrack_slab", TWISTED_NETHERRACK_SLAB);
        registerBlock("twisted_netherrack_wall", TWISTED_NETHERRACK_WALL);
        registerBlock("weeping_nether_bricks", WEEPING_NETHER_BRICKS);
        registerBlock("weeping_nether_brick_stairs", WEEPING_NETHER_BRICK_STAIRS);
        registerBlock("weeping_nether_brick_slab", WEEPING_NETHER_BRICK_SLAB);
        registerBlock("weeping_nether_brick_wall", WEEPING_NETHER_BRICK_WALL);
        registerBlock("weeping_netherrack", WEEPING_NETHERRACK);
        registerBlock("weeping_netherrack_stairs", WEEPING_NETHERRACK_STAIRS);
        registerBlock("weeping_netherrack_slab", WEEPING_NETHERRACK_SLAB);
        registerBlock("weeping_netherrack_wall", WEEPING_NETHERRACK_WALL);
        registerBlock("snapdragon", SNAPDRAGON);
        registerBlock("potted_snapdragon", POTTED_SNAPDRAGON);
        registerBlock("potted_purple_mushroom", POTTED_PURPLE_MUSHROOM);
        registerBlock("ender_grass", ENDER_GRASS);
        registerBlock("icicle", ICICLE);
        registerBlock("chocolate_cake", CHOCOLATE_CAKE);
        registerBlock("red_velvet_cake", RED_VELVET_CAKE);
        registerBlock("stone_tiles", STONE_TILES);
        registerBlock("stone_tile_slab", STONE_TILE_SLAB);
        registerBlock("stone_tile_stairs", STONE_TILE_STAIRS);
        registerBlock("stone_tile_wall", STONE_TILE_WALL);
        registerBlock("mossy_stone_tiles", MOSSY_STONE_TILES);
        registerBlock("mossy_stone_tile_slab", MOSSY_STONE_TILE_SLAB);
        registerBlock("mossy_stone_tile_stairs", MOSSY_STONE_TILE_STAIRS);
        registerBlock("mossy_stone_tile_wall", MOSSY_STONE_TILE_WALL);
        registerBlock("cracked_stone_tiles", CRACKED_STONE_TILES);
        registerBlock("cracked_stone_tile_slab", CRACKED_STONE_TILE_SLAB);
        registerBlock("cracked_stone_tile_stairs", CRACKED_STONE_TILE_STAIRS);
        registerBlock("cracked_stone_tile_wall", CRACKED_STONE_TILE_WALL);
        registerBlock("sweet_berry_pie", SWEET_BERRY_PIE);
        registerBlock("blueberry_pie", BLUEBERRY_PIE);
        registerBlock("blackstone_tiles", BLACKSTONE_TILES);
        registerBlock("blackstone_tile_stairs", BLACKSTONE_TILE_STAIRS);
        registerBlock("blackstone_tile_slab", BLACKSTONE_TILE_SLAB);
        registerBlock("blackstone_tile_wall", BLACKSTONE_TILE_WALL);
        registerBlock("twisted_blackstone_tiles", TWISTED_BLACKSTONE_TILES);
        registerBlock("twisted_blackstone_tile_stairs", TWISTED_BLACKSTONE_TILE_STAIRS);
        registerBlock("twisted_blackstone_tile_slab", TWISTED_BLACKSTONE_TILE_SLAB);
        registerBlock("twisted_blackstone_tile_wall", TWISTED_BLACKSTONE_TILE_WALL);
        registerBlock("weeping_blackstone_tiles", WEEPING_BLACKSTONE_TILES);
        registerBlock("weeping_blackstone_tile_stairs", WEEPING_BLACKSTONE_TILE_STAIRS);
        registerBlock("weeping_blackstone_tile_slab", WEEPING_BLACKSTONE_TILE_SLAB);
        registerBlock("weeping_blackstone_tile_wall", WEEPING_BLACKSTONE_TILE_WALL);
        registerBlock("twisted_polished_blackstone_bricks", TWISTED_POLISHED_BLACKSTONE_BRICKS);
        registerBlock("twisted_polished_blackstone_brick_stairs", TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
        registerBlock("twisted_polished_blackstone_brick_slab", TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
        registerBlock("twisted_polished_blackstone_brick_wall", TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
        registerBlock("weeping_polished_blackstone_bricks", WEEPING_POLISHED_BLACKSTONE_BRICKS);
        registerBlock("weeping_polished_blackstone_brick_stairs", WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
        registerBlock("weeping_polished_blackstone_brick_slab", WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
        registerBlock("weeping_polished_blackstone_brick_wall", WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
        registerBlock("twisted_blackstone", TWISTED_BLACKSTONE);
        registerBlock("twisted_blackstone_stairs", TWISTED_BLACKSTONE_STAIRS);
        registerBlock("twisted_blackstone_slab", TWISTED_BLACKSTONE_SLAB);
        registerBlock("twisted_blackstone_wall", TWISTED_BLACKSTONE_WALL);
        registerBlock("weeping_blackstone", WEEPING_BLACKSTONE);
        registerBlock("weeping_blackstone_stairs", WEEPING_BLACKSTONE_STAIRS);
        registerBlock("weeping_blackstone_slab", WEEPING_BLACKSTONE_SLAB);
        registerBlock("weeping_blackstone_wall", WEEPING_BLACKSTONE_WALL);
        registerBlock("quartz_tiles", QUARTZ_TILES);
        registerBlock("quartz_tile_stairs", QUARTZ_TILE_STAIRS);
        registerBlock("quartz_tile_slab", QUARTZ_TILE_SLAB);
        registerBlock("quartz_tile_wall", QUARTZ_TILE_WALL);
        registerBlock("calcite_bricks", CALCITE_BRICKS);
        registerBlock("calcite_brick_stairs", CALCITE_BRICK_STAIRS);
        registerBlock("calcite_brick_slab", CALCITE_BRICK_SLAB);
        registerBlock("calcite_brick_wall", CALCITE_BRICK_WALL);
        registerBlock("mossy_calcite_bricks", MOSSY_CALCITE_BRICKS);
        registerBlock("mossy_calcite_brick_stairs", MOSSY_CALCITE_BRICK_STAIRS);
        registerBlock("mossy_calcite_brick_slab", MOSSY_CALCITE_BRICK_SLAB);
        registerBlock("mossy_calcite_brick_wall", MOSSY_CALCITE_BRICK_WALL);
        registerBlock("cracked_calcite_bricks", CRACKED_CALCITE_BRICKS);
        registerBlock("cracked_calcite_brick_stairs", CRACKED_CALCITE_BRICK_STAIRS);
        registerBlock("cracked_calcite_brick_slab", CRACKED_CALCITE_BRICK_SLAB);
        registerBlock("cracked_calcite_brick_wall", CRACKED_CALCITE_BRICK_WALL);
        registerBlock("chiseled_calcite_bricks", CHISELED_CALCITE_BRICKS);
        registerBlock("dripstone_bricks", DRIPSTONE_BRICKS);
        registerBlock("dripstone_brick_stairs", DRIPSTONE_BRICK_STAIRS);
        registerBlock("dripstone_brick_slab", DRIPSTONE_BRICK_SLAB);
        registerBlock("dripstone_brick_wall", DRIPSTONE_BRICK_WALL);
        registerBlock("mossy_dripstone_bricks", MOSSY_DRIPSTONE_BRICKS);
        registerBlock("mossy_dripstone_brick_stairs", MOSSY_DRIPSTONE_BRICK_STAIRS);
        registerBlock("mossy_dripstone_brick_slab", MOSSY_DRIPSTONE_BRICK_SLAB);
        registerBlock("mossy_dripstone_brick_wall", MOSSY_DRIPSTONE_BRICK_WALL);
        registerBlock("cracked_dripstone_bricks", CRACKED_DRIPSTONE_BRICKS);
        registerBlock("cracked_dripstone_brick_stairs", CRACKED_DRIPSTONE_BRICK_STAIRS);
        registerBlock("cracked_dripstone_brick_slab", CRACKED_DRIPSTONE_BRICK_SLAB);
        registerBlock("cracked_dripstone_brick_wall", CRACKED_DRIPSTONE_BRICK_WALL);
        registerBlock("chiseled_dripstone_bricks", CHISELED_DRIPSTONE_BRICKS);
        registerBlock("cattail", CATTAIL);
        registerBlock("blood_kelp", BLOOD_KELP);
        registerBlock("blood_kelp_plant", BLOOD_KELP_PLANT);
        registerBlock("dried_blood_kelp_block", DRIED_BLOOD_KELP_BLOCK);
        registerBlock("blood_kelp_lantern", BLOOD_KELP_LANTERN);
        registerBlock("maroon_wool", MAROON_WOOL);
        registerBlock("maroon_stained_glass", MAROON_STAINED_GLASS);
        registerBlock("maroon_stained_glass_pane", MAROON_STAINED_GLASS_PANE);
        registerBlock("maroon_candle", MAROON_CANDLE);
        registerBlock("maroon_candle_cake", MAROON_CANDLE_CAKE);
        registerBlock("maroon_concrete", MAROON_CONCRETE);
        registerBlock("maroon_concrete_powder", MAROON_CONCRETE_POWDER);
        registerBlock("weeping_heart", WEEPING_HEART);
        registerBlock("maroon_candle_chocolate_cake", MAROON_CANDLE_CHOCOLATE_CAKE);
        registerBlock("candle_chocolate_cake", CANDLE_CHOCOLATE_CAKE);
        registerBlock("white_candle_chocolate_cake", WHITE_CANDLE_CHOCOLATE_CAKE);
        registerBlock("orange_candle_chocolate_cake", ORANGE_CANDLE_CHOCOLATE_CAKE);
        registerBlock("magenta_candle_chocolate_cake", MAGENTA_CANDLE_CHOCOLATE_CAKE);
        registerBlock("light_blue_candle_chocolate_cake", LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE);
        registerBlock("yellow_candle_chocolate_cake", YELLOW_CANDLE_CHOCOLATE_CAKE);
        registerBlock("lime_candle_chocolate_cake", LIME_CANDLE_CHOCOLATE_CAKE);
        registerBlock("pink_candle_chocolate_cake", PINK_CANDLE_CHOCOLATE_CAKE);
        registerBlock("gray_candle_chocolate_cake", GRAY_CANDLE_CHOCOLATE_CAKE);
        registerBlock("light_gray_candle_chocolate_cake", LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE);
        registerBlock("cyan_candle_chocolate_cake", CYAN_CANDLE_CHOCOLATE_CAKE);
        registerBlock("purple_candle_chocolate_cake", PURPLE_CANDLE_CHOCOLATE_CAKE);
        registerBlock("blue_candle_chocolate_cake", BLUE_CANDLE_CHOCOLATE_CAKE);
        registerBlock("brown_candle_chocolate_cake", BROWN_CANDLE_CHOCOLATE_CAKE);
        registerBlock("green_candle_chocolate_cake", GREEN_CANDLE_CHOCOLATE_CAKE);
        registerBlock("red_candle_chocolate_cake", RED_CANDLE_CHOCOLATE_CAKE);
        registerBlock("black_candle_chocolate_cake", BLACK_CANDLE_CHOCOLATE_CAKE);
        registerBlock("maroon_candle_red_velvet_cake", MAROON_CANDLE_RED_VELVET_CAKE);
        registerBlock("candle_red_velvet_cake", CANDLE_RED_VELVET_CAKE);
        registerBlock("white_candle_red_velvet_cake", WHITE_CANDLE_RED_VELVET_CAKE);
        registerBlock("orange_candle_red_velvet_cake", ORANGE_CANDLE_RED_VELVET_CAKE);
        registerBlock("magenta_candle_red_velvet_cake", MAGENTA_CANDLE_RED_VELVET_CAKE);
        registerBlock("light_blue_candle_red_velvet_cake", LIGHT_BLUE_CANDLE_RED_VELVET_CAKE);
        registerBlock("yellow_candle_red_velvet_cake", YELLOW_CANDLE_RED_VELVET_CAKE);
        registerBlock("lime_candle_red_velvet_cake", LIME_CANDLE_RED_VELVET_CAKE);
        registerBlock("pink_candle_red_velvet_cake", PINK_CANDLE_RED_VELVET_CAKE);
        registerBlock("gray_candle_red_velvet_cake", GRAY_CANDLE_RED_VELVET_CAKE);
        registerBlock("light_gray_candle_red_velvet_cake", LIGHT_GRAY_CANDLE_RED_VELVET_CAKE);
        registerBlock("cyan_candle_red_velvet_cake", CYAN_CANDLE_RED_VELVET_CAKE);
        registerBlock("purple_candle_red_velvet_cake", PURPLE_CANDLE_RED_VELVET_CAKE);
        registerBlock("blue_candle_red_velvet_cake", BLUE_CANDLE_RED_VELVET_CAKE);
        registerBlock("brown_candle_red_velvet_cake", BROWN_CANDLE_RED_VELVET_CAKE);
        registerBlock("green_candle_red_velvet_cake", GREEN_CANDLE_RED_VELVET_CAKE);
        registerBlock("red_candle_red_velvet_cake", RED_CANDLE_RED_VELVET_CAKE);
        registerBlock("black_candle_red_velvet_cake", BLACK_CANDLE_RED_VELVET_CAKE);
        registerBlock("camel_plush", CAMEL_PLUSH);
        registerBlock("cindersnap_berry_bush", CINDERSNAP_BERRY_BUSH);
        registerBlock("frostbite_berry_bush", FROSTBITE_BERRY_BUSH);
        registerBlock("polished_dripstone", POLISHED_DRIPSTONE);
        registerBlock("polished_dripstone_stairs", POLISHED_DRIPSTONE_STAIRS);
        registerBlock("polished_dripstone_slab", POLISHED_DRIPSTONE_SLAB);
        registerBlock("polished_dripstone_wall", POLISHED_DRIPSTONE_WALL);
        registerBlock("polished_calcite", POLISHED_CALCITE);
        registerBlock("polished_calcite_stairs", POLISHED_CALCITE_STAIRS);
        registerBlock("polished_calcite_slab", POLISHED_CALCITE_SLAB);
        registerBlock("polished_calcite_wall", POLISHED_CALCITE_WALL);
        registerBlock("dripstone_stairs", DRIPSTONE_STAIRS);
        registerBlock("dripstone_slab", DRIPSTONE_SLAB);
        registerBlock("dripstone_wall", DRIPSTONE_WALL);
        registerBlock("calcite_stairs", CALCITE_STAIRS);
        registerBlock("calcite_slab", CALCITE_SLAB);
        registerBlock("calcite_wall", CALCITE_WALL);
        registerBlock("bamboo_planter_box", BAMBOO_PLANTER_BOX);

        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }
}
