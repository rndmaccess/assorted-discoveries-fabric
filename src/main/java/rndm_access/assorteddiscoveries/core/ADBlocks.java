package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block.*;

import java.util.function.ToIntFunction;

public class ADBlocks {
    public static final Block BAT_PLUSHIE = new ADBatPlushieBlock(AbstractBlock.Settings.create().burnable()
            .mapColor(MapColor.CLEAR).strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BLAZE_PLUSHIE = new ADBlazePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CAVE_SPIDER_PLUSHIE = new ADCaveSpiderPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CHICKEN_PLUSHIE = new ADChickenPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block COW_PLUSHIE = new ADCowPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CREEPER_PLUSHIE = new ADCreeperPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block ENDERMAN_PLUSHIE = new ADEndermanPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GHAST_PLUSHIE = new ADGhastPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GUARDIAN_PLUSHIE = new ADGuardianPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WHITE_HORSE_PLUSHIE = new ADHorsePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GRAY_HORSE_PLUSHIE = new ADHorsePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block LIGHT_GRAY_HORSE_PLUSHIE = new ADHorsePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BROWN_HORSE_PLUSHIE = new ADHorsePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BLACK_HORSE_PLUSHIE = new ADHorsePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block MAGMA_CUBE_PLUSHIE = new ADCubePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE)
            .pistonBehavior(PistonBehavior.DESTROY));
    public static final Block RED_MOOSHROOM_PLUSHIE = new ADMooshroomPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BROWN_MOOSHROOM_PLUSHIE = new ADMooshroomPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block OCELOT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block TABBY_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block TUXEDO_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block RED_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SIAMESE_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CALICO_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PERSIAN_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block RAGDOLL_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WHITE_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block JELLIE_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BLACK_CAT_PLUSHIE = new ADCatPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PIG_PLUSHIE = new ADPigPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BROWN_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WHITE_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BLACK_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GOLD_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block TOAST_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SALT_RABBIT_PLUSHIE = new ADRabbitPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WHITE_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block ORANGE_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block MAGENTA_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block LIGHT_BLUE_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block YELLOW_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block LIME_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PINK_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GRAY_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block LIGHT_GRAY_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CYAN_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PURPLE_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BLUE_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BROWN_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GREEN_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block RED_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block BLACK_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block MAROON_SHEEP_PLUSHIE = new ADSheepPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SKELETON_PLUSHIE = new ADSkeletonPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SLIME_PLUSHIE = new ADCubePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE)
            .pistonBehavior(PistonBehavior.DESTROY));
    public static final Block SPIDER_PLUSHIE = new ADSpiderPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SQUID_PLUSHIE = new ADSquidPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block GLOW_SQUID_PLUSHIE = new ADSquidPlushieBlock(AbstractBlock.Settings.create().burnable()
            .mapColor(MapColor.CLEAR).strength(0.2F).sounds(BlockSoundGroup.WOOL).luminance((state) -> 10));
    public static final Block BEE_PLUSHIE = new ADBeePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PLAINS_VILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block DESERT_VILLAGER_PLUSHIE = new ADDesertVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block JUNGLE_VILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SAVANNA_VILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SNOW_VILLAGER_PLUSHIE = new ADShortHatVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SWAMP_VILLAGER_PLUSHIE = new ADShortHatVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block TAIGA_VILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CRIMSON_VILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WARPED_VILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WANDERING_TRADER_PLUSHIE = new ADShortHatVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PLAINS_ZOMBIE_VILLAGER_PLUSHIE = new ADZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block DESERT_ZOMBIE_VILLAGER_PLUSHIE = new ADDesertZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block JUNGLE_ZOMBIE_VILLAGER_PLUSHIE = new ADZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SAVANNA_ZOMBIE_VILLAGER_PLUSHIE = new ADZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SNOW_ZOMBIE_VILLAGER_PLUSHIE = new ADShortHatZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SWAMP_ZOMBIE_VILLAGER_PLUSHIE = new ADShortHatZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block TAIGA_ZOMBIE_VILLAGER_PLUSHIE = new ADZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block CRIMSON_ZOMBIE_VILLAGER_PLUSHIE = new ADZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WARPED_ZOMBIE_VILLAGER_PLUSHIE = new ADZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WITCH_PLUSHIE = new ADWitchPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PALE_WOLF_PLUSHIE = new ADWolfPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block ZOMBIE_PLUSHIE = new ADZombiePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PIGLIN_PLUSHIE = new ADPiglinPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block ZOMBIFIED_PIGLIN_PLUSHIE = new ADZombiePlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PUFFERFISH_PLUSHIE = new ADPufferfishPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block WITHER_PLUSHIE = new ADWitherPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block STRIDER_PLUSHIE = new ADStriderPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SHIVERING_STRIDER_PLUSHIE = new ADStriderPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block PHANTOM_PLUSHIE = new ADPhantomPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block HOGLIN_PLUSHIE = new ADHoglinPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block ZOGLIN_PLUSHIE = new ADHoglinPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block POLAR_BEAR_PLUSHIE = new ADPolarBearPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block ALLAY_PLUSHIE = new ADAllayPlushieBlock(AbstractBlock.Settings.copy(GLOW_SQUID_PLUSHIE));
    public static final Block PILLAGER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block VINDICATOR_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block EVOKER_PLUSHIE = new ADVillagerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block RAVAGER_PLUSHIE = new ADHoglinPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block SHULKER_PLUSHIE = new ADShulkerPlushieBlock(AbstractBlock.Settings.copy(BAT_PLUSHIE));
    public static final Block VEX_PLUSHIE = new ADAllayPlushieBlock(AbstractBlock.Settings.copy(GLOW_SQUID_PLUSHIE));
    public static final Block NETHER_SMOKY_QUARTZ_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
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
    public static final Block GREEN_ONIONS = new ADGreenOnionsBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
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
    public static final Block PURPLE_MUSHROOM = new MushroomPlantBlock(ADTreeConfiguredFeatures.HUGE_PURPLE_MUSHROOM,
            AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).pistonBehavior(PistonBehavior.DESTROY)
                    .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)
                    .postProcess(ADBlocks::always));
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
    public static final Block SHORT_ENDER_GRASS = new ADShortEnderGrassBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)
            .luminance((state) -> 7));
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
    public static final Block BOG_BLOSSOM = new ADBogBlossomBlock(AbstractBlock.Settings.create()
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
    public static final Block CAMEL_PLUSHIE = new ADCamelPlushieBlock(AbstractBlock.Settings.copy(ADBlocks.BAT_PLUSHIE));
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
    public static final Block POTTED_CATTAIL = new FlowerPotBlock(ADBlocks.CATTAIL,
            AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM));
    public static final Block STONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE));
    public static final Block QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK));
    public static final Block SMOOTH_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ));
    public static final Block GRASS_SLAB = new ADSnowySlabBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK));
    public static final Block PODZOL_SLAB = new ADSnowySlabBlock(AbstractBlock.Settings.copy(Blocks.PODZOL));
    public static final Block MYCELIUM_SLAB = new ADSnowySlabBlock(AbstractBlock.Settings.copy(Blocks.MYCELIUM));
    public static final Block DIRT_PATH_SLAB = new ADDirtPathSlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT_PATH));
    public static final Block DIRT_SLAB = new ADDirtSlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT));
    public static final Block COARSE_DIRT_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.COARSE_DIRT));
    public static final Block ROOTED_DIRT_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.ROOTED_DIRT));
    public static final Block WILD_GREEN_ONIONS = new ADWildGreenOnionsBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));

    private static WallTorchBlock wallTorchBlock(DefaultParticleType flameParticle) {
        return new WallTorchBlock(flameParticle, AbstractBlock.Settings.copy(Blocks.WALL_TORCH));
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

    private static TorchBlock torchBlock(DefaultParticleType flameParticle) {
        return new TorchBlock(flameParticle, AbstractBlock.Settings.copy(Blocks.TORCH));
    }

    private static LanternBlock lanternBlock() {
        return new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN));
    }

    private static ADRopeLadderBlock ropeLadderBlock() {
        return new ADRopeLadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER));
    }

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

    private static void register(String path, Block block) {
        Registry.register(Registries.BLOCK, ADReference.makeModId(path), block);
    }

    /**
     * Called during mod initialization to register every block.
     */
    public static void registerBlocks() {
        register("bat_plushie", BAT_PLUSHIE);
        register("blaze_plushie", BLAZE_PLUSHIE);
        register("cave_spider_plushie", CAVE_SPIDER_PLUSHIE);
        register("chicken_plushie", CHICKEN_PLUSHIE);
        register("cow_plushie", COW_PLUSHIE);
        register("creeper_plushie", CREEPER_PLUSHIE);
        register("enderman_plushie", ENDERMAN_PLUSHIE);
        register("ghast_plushie", GHAST_PLUSHIE);
        register("guardian_plushie", GUARDIAN_PLUSHIE);
        register("white_horse_plushie", WHITE_HORSE_PLUSHIE);
        register("gray_horse_plushie", GRAY_HORSE_PLUSHIE);
        register("light_gray_horse_plushie", LIGHT_GRAY_HORSE_PLUSHIE);
        register("brown_horse_plushie", BROWN_HORSE_PLUSHIE);
        register("black_horse_plushie", BLACK_HORSE_PLUSHIE);
        register("magma_cube_plushie", MAGMA_CUBE_PLUSHIE);
        register("red_mooshroom_plushie", RED_MOOSHROOM_PLUSHIE);
        register("brown_mooshroom_plushie", BROWN_MOOSHROOM_PLUSHIE);
        register("ocelot_plushie", OCELOT_PLUSHIE);
        register("tabby_cat_plushie", TABBY_CAT_PLUSHIE);
        register("tuxedo_cat_plushie", TUXEDO_CAT_PLUSHIE);
        register("red_cat_plushie", RED_CAT_PLUSHIE);
        register("siamese_cat_plushie", SIAMESE_CAT_PLUSHIE);
        register("british_shorthair_cat_plushie", BRITISH_SHORTHAIR_CAT_PLUSHIE);
        register("calico_cat_plushie", CALICO_CAT_PLUSHIE);
        register("persian_cat_plushie", PERSIAN_CAT_PLUSHIE);
        register("ragdoll_cat_plushie", RAGDOLL_CAT_PLUSHIE);
        register("white_cat_plushie", WHITE_CAT_PLUSHIE);
        register("jellie_cat_plushie", JELLIE_CAT_PLUSHIE);
        register("black_cat_plushie", BLACK_CAT_PLUSHIE);
        register("pig_plushie", PIG_PLUSHIE);
        register("brown_rabbit_plushie", BROWN_RABBIT_PLUSHIE);
        register("white_rabbit_plushie", WHITE_RABBIT_PLUSHIE);
        register("black_rabbit_plushie", BLACK_RABBIT_PLUSHIE);
        register("white_splotched_rabbit_plushie", WHITE_SPLOTCHED_RABBIT_PLUSHIE);
        register("gold_rabbit_plushie", GOLD_RABBIT_PLUSHIE);
        register("toast_rabbit_plushie", TOAST_RABBIT_PLUSHIE);
        register("salt_rabbit_plushie", SALT_RABBIT_PLUSHIE);
        register("white_sheep_plushie", WHITE_SHEEP_PLUSHIE);
        register("orange_sheep_plushie", ORANGE_SHEEP_PLUSHIE);
        register("magenta_sheep_plushie", MAGENTA_SHEEP_PLUSHIE);
        register("light_blue_sheep_plushie", LIGHT_BLUE_SHEEP_PLUSHIE);
        register("yellow_sheep_plushie", YELLOW_SHEEP_PLUSHIE);
        register("lime_sheep_plushie", LIME_SHEEP_PLUSHIE);
        register("pink_sheep_plushie", PINK_SHEEP_PLUSHIE);
        register("gray_sheep_plushie", GRAY_SHEEP_PLUSHIE);
        register("light_gray_sheep_plushie", LIGHT_GRAY_SHEEP_PLUSHIE);
        register("cyan_sheep_plushie", CYAN_SHEEP_PLUSHIE);
        register("purple_sheep_plushie", PURPLE_SHEEP_PLUSHIE);
        register("blue_sheep_plushie", BLUE_SHEEP_PLUSHIE);
        register("brown_sheep_plushie", BROWN_SHEEP_PLUSHIE);
        register("green_sheep_plushie", GREEN_SHEEP_PLUSHIE);
        register("red_sheep_plushie", RED_SHEEP_PLUSHIE);
        register("black_sheep_plushie", BLACK_SHEEP_PLUSHIE);
        register("maroon_sheep_plushie", MAROON_SHEEP_PLUSHIE);
        register("skeleton_plushie", SKELETON_PLUSHIE);
        register("slime_plushie", SLIME_PLUSHIE);
        register("spider_plushie", SPIDER_PLUSHIE);
        register("squid_plushie", SQUID_PLUSHIE);
        register("glow_squid_plushie", GLOW_SQUID_PLUSHIE);
        register("bee_plushie", BEE_PLUSHIE);
        register("plains_villager_plushie", PLAINS_VILLAGER_PLUSHIE);
        register("desert_villager_plushie", DESERT_VILLAGER_PLUSHIE);
        register("jungle_villager_plushie", JUNGLE_VILLAGER_PLUSHIE);
        register("savanna_villager_plushie", SAVANNA_VILLAGER_PLUSHIE);
        register("snow_villager_plushie", SNOW_VILLAGER_PLUSHIE);
        register("swamp_villager_plushie", SWAMP_VILLAGER_PLUSHIE);
        register("taiga_villager_plushie", TAIGA_VILLAGER_PLUSHIE);
        register("crimson_villager_plushie", CRIMSON_VILLAGER_PLUSHIE);
        register("warped_villager_plushie", WARPED_VILLAGER_PLUSHIE);
        register("wandering_trader_plushie", WANDERING_TRADER_PLUSHIE);
        register("plains_zombie_villager_plushie", PLAINS_ZOMBIE_VILLAGER_PLUSHIE);
        register("desert_zombie_villager_plushie", DESERT_ZOMBIE_VILLAGER_PLUSHIE);
        register("jungle_zombie_villager_plushie", JUNGLE_ZOMBIE_VILLAGER_PLUSHIE);
        register("savanna_zombie_villager_plushie", SAVANNA_ZOMBIE_VILLAGER_PLUSHIE);
        register("snow_zombie_villager_plushie", SNOW_ZOMBIE_VILLAGER_PLUSHIE);
        register("swamp_zombie_villager_plushie", SWAMP_ZOMBIE_VILLAGER_PLUSHIE);
        register("taiga_zombie_villager_plushie", TAIGA_ZOMBIE_VILLAGER_PLUSHIE);
        register("crimson_zombie_villager_plushie", CRIMSON_ZOMBIE_VILLAGER_PLUSHIE);
        register("warped_zombie_villager_plushie", WARPED_ZOMBIE_VILLAGER_PLUSHIE);
        register("witch_plushie", WITCH_PLUSHIE);
        register("pale_wolf_plushie", PALE_WOLF_PLUSHIE);
        register("zombie_plushie", ZOMBIE_PLUSHIE);
        register("piglin_plushie", PIGLIN_PLUSHIE);
        register("zombified_piglin_plushie", ZOMBIFIED_PIGLIN_PLUSHIE);
        register("pufferfish_plushie", PUFFERFISH_PLUSHIE);
        register("wither_plushie", WITHER_PLUSHIE);
        register("strider_plushie", STRIDER_PLUSHIE);
        register("shivering_strider_plushie", SHIVERING_STRIDER_PLUSHIE);
        register("phantom_plushie", PHANTOM_PLUSHIE);
        register("hoglin_plushie", HOGLIN_PLUSHIE);
        register("zoglin_plushie", ZOGLIN_PLUSHIE);
        register("polar_bear_plushie", POLAR_BEAR_PLUSHIE);
        register("allay_plushie", ALLAY_PLUSHIE);
        register("pillager_plushie", PILLAGER_PLUSHIE);
        register("vindicator_plushie", VINDICATOR_PLUSHIE);
        register("evoker_plushie", EVOKER_PLUSHIE);
        register("ravager_plushie", RAVAGER_PLUSHIE);
        register("shulker_plushie", SHULKER_PLUSHIE);
        register("vex_plushie", VEX_PLUSHIE);
        register("nether_smoky_quartz_ore", NETHER_SMOKY_QUARTZ_ORE);
        register("smoky_quartz_block", SMOKY_QUARTZ_BLOCK);
        register("chiseled_smoky_quartz_block", CHISELED_SMOKY_QUARTZ_BLOCK);
        register("smoky_quartz_bricks", SMOKY_QUARTZ_BRICKS);
        register("smoky_quartz_brick_stairs", SMOKY_QUARTZ_BRICK_STAIRS);
        register("smoky_quartz_brick_slab", SMOKY_QUARTZ_BRICK_SLAB);
        register("smoky_quartz_brick_wall", SMOKY_QUARTZ_BRICK_WALL);
        register("smoky_quartz_pillar", SMOKY_QUARTZ_PILLAR);
        register("smoky_quartz_stairs", SMOKY_QUARTZ_STAIRS);
        register("smoky_quartz_slab", SMOKY_QUARTZ_SLAB);
        register("smoky_quartz_wall", SMOKY_QUARTZ_WALL);
        register("smooth_smoky_quartz", SMOOTH_SMOKY_QUARTZ);
        register("smooth_smoky_quartz_stairs", SMOOTH_SMOKY_QUARTZ_STAIRS);
        register("smooth_smoky_quartz_slab", SMOOTH_SMOKY_QUARTZ_SLAB);
        register("smooth_smoky_quartz_wall", SMOOTH_SMOKY_QUARTZ_WALL);
        register("cracked_stone_brick_stairs", CRACKED_STONE_BRICK_STAIRS);
        register("cracked_stone_brick_slab", CRACKED_STONE_BRICK_SLAB);
        register("cracked_stone_brick_wall", CRACKED_STONE_BRICK_WALL);
        register("blueberry_bush", BLUEBERRY_BUSH);
        register("green_onions", GREEN_ONIONS);
        register("oak_planter_box", OAK_PLANTER_BOX);
        register("spruce_planter_box", SPRUCE_PLANTER_BOX);
        register("birch_planter_box", BIRCH_PLANTER_BOX);
        register("jungle_planter_box", JUNGLE_PLANTER_BOX);
        register("acacia_planter_box", ACACIA_PLANTER_BOX);
        register("dark_oak_planter_box", DARK_OAK_PLANTER_BOX);
        register("mangrove_planter_box", MANGROVE_PLANTER_BOX);
        register("cherry_planter_box", CHERRY_PLANTER_BOX);
        register("crimson_planter_box", CRIMSON_PLANTER_BOX);
        register("warped_planter_box", WARPED_PLANTER_BOX);
        register("oak_wall", OAK_WALL);
        register("spruce_wall", SPRUCE_WALL);
        register("birch_wall", BIRCH_WALL);
        register("jungle_wall", JUNGLE_WALL);
        register("acacia_wall", ACACIA_WALL);
        register("dark_oak_wall", DARK_OAK_WALL);
        register("mangrove_wall", MANGROVE_WALL);
        register("crimson_wall", CRIMSON_WALL);
        register("warped_wall", WARPED_WALL);
        register("cherry_wall", CHERRY_WALL);
        register("stripped_oak_wall", STRIPPED_OAK_WALL);
        register("stripped_spruce_wall", STRIPPED_SPRUCE_WALL);
        register("stripped_birch_wall", STRIPPED_BIRCH_WALL);
        register("stripped_jungle_wall", STRIPPED_JUNGLE_WALL);
        register("stripped_acacia_wall", STRIPPED_ACACIA_WALL);
        register("stripped_dark_oak_wall", STRIPPED_DARK_OAK_WALL);
        register("stripped_mangrove_wall", STRIPPED_MANGROVE_WALL);
        register("stripped_crimson_wall", STRIPPED_CRIMSON_WALL);
        register("stripped_warped_wall", STRIPPED_WARPED_WALL);
        register("stripped_cherry_wall", STRIPPED_CHERRY_WALL);
        register("oak_rope_ladder", OAK_ROPE_LADDER);
        register("spruce_rope_ladder", SPRUCE_ROPE_LADDER);
        register("birch_rope_ladder", BIRCH_ROPE_LADDER);
        register("jungle_rope_ladder", JUNGLE_ROPE_LADDER);
        register("acacia_rope_ladder", ACACIA_ROPE_LADDER);
        register("dark_oak_rope_ladder", DARK_OAK_ROPE_LADDER);
        register("crimson_rope_ladder", CRIMSON_ROPE_LADDER);
        register("warped_rope_ladder", WARPED_ROPE_LADDER);
        register("mangrove_rope_ladder", MANGROVE_ROPE_LADDER);
        register("cherry_rope_ladder", CHERRY_ROPE_LADDER);
        register("iron_ladder", IRON_LADDER);
        register("snow_bricks", SNOW_BRICKS);
        register("snow_brick_stairs", SNOW_BRICK_STAIRS);
        register("snow_brick_slab", SNOW_BRICK_SLAB);
        register("snow_brick_wall", SNOW_BRICK_WALL);
        register("packed_snow", PACKED_SNOW);
        register("packed_snow_stairs", PACKED_SNOW_STAIRS);
        register("packed_snow_slab", PACKED_SNOW_SLAB);
        register("packed_snow_wall", PACKED_SNOW_WALL);
        register("purple_mushroom", PURPLE_MUSHROOM);
        register("purple_mushroom_block", PURPLE_MUSHROOM_BLOCK);
        register("woodcutter", WOODCUTTER);
        register("white_campfire", WHITE_CAMPFIRE);
        register("orange_campfire", ORANGE_CAMPFIRE);
        register("magenta_campfire", MAGENTA_CAMPFIRE);
        register("light_blue_campfire", LIGHT_BLUE_CAMPFIRE);
        register("yellow_campfire", YELLOW_CAMPFIRE);
        register("lime_campfire", LIME_CAMPFIRE);
        register("pink_campfire", PINK_CAMPFIRE);
        register("gray_campfire", GRAY_CAMPFIRE);
        register("light_gray_campfire", LIGHT_GRAY_CAMPFIRE);
        register("cyan_campfire", CYAN_CAMPFIRE);
        register("purple_campfire", PURPLE_CAMPFIRE);
        register("blue_campfire", BLUE_CAMPFIRE);
        register("brown_campfire", BROWN_CAMPFIRE);
        register("green_campfire", GREEN_CAMPFIRE);
        register("red_campfire", RED_CAMPFIRE);
        register("black_campfire", BLACK_CAMPFIRE);
        register("maroon_campfire", MAROON_CAMPFIRE);
        register("white_lantern", WHITE_LANTERN);
        register("orange_lantern", ORANGE_LANTERN);
        register("magenta_lantern", MAGENTA_LANTERN);
        register("light_blue_lantern", LIGHT_BLUE_LANTERN);
        register("yellow_lantern", YELLOW_LANTERN);
        register("lime_lantern", LIME_LANTERN);
        register("pink_lantern", PINK_LANTERN);
        register("gray_lantern", GRAY_LANTERN);
        register("light_gray_lantern", LIGHT_GRAY_LANTERN);
        register("cyan_lantern", CYAN_LANTERN);
        register("purple_lantern", PURPLE_LANTERN);
        register("blue_lantern", BLUE_LANTERN);
        register("brown_lantern", BROWN_LANTERN);
        register("green_lantern", GREEN_LANTERN);
        register("red_lantern", RED_LANTERN);
        register("black_lantern", BLACK_LANTERN);
        register("maroon_lantern", MAROON_LANTERN);
        register("white_wall_torch", WHITE_WALL_TORCH);
        register("orange_wall_torch", ORANGE_WALL_TORCH);
        register("magenta_wall_torch", MAGENTA_WALL_TORCH);
        register("light_blue_wall_torch", LIGHT_BLUE_WALL_TORCH);
        register("yellow_wall_torch", YELLOW_WALL_TORCH);
        register("lime_wall_torch", LIME_WALL_TORCH);
        register("pink_wall_torch", PINK_WALL_TORCH);
        register("gray_wall_torch", GRAY_WALL_TORCH);
        register("light_gray_wall_torch", LIGHT_GRAY_WALL_TORCH);
        register("cyan_wall_torch", CYAN_WALL_TORCH);
        register("purple_wall_torch", PURPLE_WALL_TORCH);
        register("blue_wall_torch", BLUE_WALL_TORCH);
        register("brown_wall_torch", BROWN_WALL_TORCH);
        register("green_wall_torch", GREEN_WALL_TORCH);
        register("red_wall_torch", RED_WALL_TORCH);
        register("black_wall_torch", BLACK_WALL_TORCH);
        register("maroon_wall_torch", MAROON_WALL_TORCH);
        register("white_torch", WHITE_TORCH);
        register("orange_torch", ORANGE_TORCH);
        register("magenta_torch", MAGENTA_TORCH);
        register("light_blue_torch", LIGHT_BLUE_TORCH);
        register("yellow_torch", YELLOW_TORCH);
        register("lime_torch", LIME_TORCH);
        register("pink_torch", PINK_TORCH);
        register("gray_torch", GRAY_TORCH);
        register("light_gray_torch", LIGHT_GRAY_TORCH);
        register("cyan_torch", CYAN_TORCH);
        register("purple_torch", PURPLE_TORCH);
        register("blue_torch", BLUE_TORCH);
        register("brown_torch", BROWN_TORCH);
        register("green_torch", GREEN_TORCH);
        register("red_torch", RED_TORCH);
        register("black_torch", BLACK_TORCH);
        register("maroon_torch", MAROON_TORCH);
        register("witchs_cradle", WITCHS_CRADLE);
        register("bauxite", BAUXITE);
        register("bauxite_slab", BAUXITE_SLAB);
        register("bauxite_stairs", BAUXITE_STAIRS);
        register("bauxite_wall", BAUXITE_WALL);
        register("bauxite_bricks", BAUXITE_BRICKS);
        register("bauxite_brick_stairs", BAUXITE_BRICK_STAIRS);
        register("bauxite_brick_slab", BAUXITE_BRICK_SLAB);
        register("bauxite_brick_wall", BAUXITE_BRICK_WALL);
        register("mossy_bauxite_bricks", MOSSY_BAUXITE_BRICKS);
        register("mossy_bauxite_brick_stairs", MOSSY_BAUXITE_BRICK_STAIRS);
        register("mossy_bauxite_brick_slab", MOSSY_BAUXITE_BRICK_SLAB);
        register("mossy_bauxite_brick_wall", MOSSY_BAUXITE_BRICK_WALL);
        register("cracked_bauxite_bricks", CRACKED_BAUXITE_BRICKS);
        register("cracked_bauxite_brick_stairs", CRACKED_BAUXITE_BRICK_STAIRS);
        register("cracked_bauxite_brick_slab", CRACKED_BAUXITE_BRICK_SLAB);
        register("cracked_bauxite_brick_wall", CRACKED_BAUXITE_BRICK_WALL);
        register("twisted_nether_bricks", TWISTED_NETHER_BRICKS);
        register("twisted_nether_brick_stairs", TWISTED_NETHER_BRICK_STAIRS);
        register("twisted_nether_brick_slab", TWISTED_NETHER_BRICK_SLAB);
        register("twisted_nether_brick_wall", TWISTED_NETHER_BRICK_WALL);
        register("twisted_netherrack", TWISTED_NETHERRACK);
        register("twisted_netherrack_stairs", TWISTED_NETHERRACK_STAIRS);
        register("twisted_netherrack_slab", TWISTED_NETHERRACK_SLAB);
        register("twisted_netherrack_wall", TWISTED_NETHERRACK_WALL);
        register("weeping_nether_bricks", WEEPING_NETHER_BRICKS);
        register("weeping_nether_brick_stairs", WEEPING_NETHER_BRICK_STAIRS);
        register("weeping_nether_brick_slab", WEEPING_NETHER_BRICK_SLAB);
        register("weeping_nether_brick_wall", WEEPING_NETHER_BRICK_WALL);
        register("weeping_netherrack", WEEPING_NETHERRACK);
        register("weeping_netherrack_stairs", WEEPING_NETHERRACK_STAIRS);
        register("weeping_netherrack_slab", WEEPING_NETHERRACK_SLAB);
        register("weeping_netherrack_wall", WEEPING_NETHERRACK_WALL);
        register("snapdragon", SNAPDRAGON);
        register("potted_snapdragon", POTTED_SNAPDRAGON);
        register("potted_purple_mushroom", POTTED_PURPLE_MUSHROOM);
        register("short_ender_grass", SHORT_ENDER_GRASS);
        register("chocolate_cake", CHOCOLATE_CAKE);
        register("red_velvet_cake", RED_VELVET_CAKE);
        register("stone_tiles", STONE_TILES);
        register("stone_tile_slab", STONE_TILE_SLAB);
        register("stone_tile_stairs", STONE_TILE_STAIRS);
        register("stone_tile_wall", STONE_TILE_WALL);
        register("mossy_stone_tiles", MOSSY_STONE_TILES);
        register("mossy_stone_tile_slab", MOSSY_STONE_TILE_SLAB);
        register("mossy_stone_tile_stairs", MOSSY_STONE_TILE_STAIRS);
        register("mossy_stone_tile_wall", MOSSY_STONE_TILE_WALL);
        register("cracked_stone_tiles", CRACKED_STONE_TILES);
        register("cracked_stone_tile_slab", CRACKED_STONE_TILE_SLAB);
        register("cracked_stone_tile_stairs", CRACKED_STONE_TILE_STAIRS);
        register("cracked_stone_tile_wall", CRACKED_STONE_TILE_WALL);
        register("sweet_berry_pie", SWEET_BERRY_PIE);
        register("blueberry_pie", BLUEBERRY_PIE);
        register("blackstone_tiles", BLACKSTONE_TILES);
        register("blackstone_tile_stairs", BLACKSTONE_TILE_STAIRS);
        register("blackstone_tile_slab", BLACKSTONE_TILE_SLAB);
        register("blackstone_tile_wall", BLACKSTONE_TILE_WALL);
        register("twisted_blackstone_tiles", TWISTED_BLACKSTONE_TILES);
        register("twisted_blackstone_tile_stairs", TWISTED_BLACKSTONE_TILE_STAIRS);
        register("twisted_blackstone_tile_slab", TWISTED_BLACKSTONE_TILE_SLAB);
        register("twisted_blackstone_tile_wall", TWISTED_BLACKSTONE_TILE_WALL);
        register("weeping_blackstone_tiles", WEEPING_BLACKSTONE_TILES);
        register("weeping_blackstone_tile_stairs", WEEPING_BLACKSTONE_TILE_STAIRS);
        register("weeping_blackstone_tile_slab", WEEPING_BLACKSTONE_TILE_SLAB);
        register("weeping_blackstone_tile_wall", WEEPING_BLACKSTONE_TILE_WALL);
        register("twisted_polished_blackstone_bricks", TWISTED_POLISHED_BLACKSTONE_BRICKS);
        register("twisted_polished_blackstone_brick_stairs", TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
        register("twisted_polished_blackstone_brick_slab", TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
        register("twisted_polished_blackstone_brick_wall", TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
        register("weeping_polished_blackstone_bricks", WEEPING_POLISHED_BLACKSTONE_BRICKS);
        register("weeping_polished_blackstone_brick_stairs", WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
        register("weeping_polished_blackstone_brick_slab", WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
        register("weeping_polished_blackstone_brick_wall", WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
        register("twisted_blackstone", TWISTED_BLACKSTONE);
        register("twisted_blackstone_stairs", TWISTED_BLACKSTONE_STAIRS);
        register("twisted_blackstone_slab", TWISTED_BLACKSTONE_SLAB);
        register("twisted_blackstone_wall", TWISTED_BLACKSTONE_WALL);
        register("weeping_blackstone", WEEPING_BLACKSTONE);
        register("weeping_blackstone_stairs", WEEPING_BLACKSTONE_STAIRS);
        register("weeping_blackstone_slab", WEEPING_BLACKSTONE_SLAB);
        register("weeping_blackstone_wall", WEEPING_BLACKSTONE_WALL);
        register("quartz_tiles", QUARTZ_TILES);
        register("quartz_tile_stairs", QUARTZ_TILE_STAIRS);
        register("quartz_tile_slab", QUARTZ_TILE_SLAB);
        register("quartz_tile_wall", QUARTZ_TILE_WALL);
        register("calcite_bricks", CALCITE_BRICKS);
        register("calcite_brick_stairs", CALCITE_BRICK_STAIRS);
        register("calcite_brick_slab", CALCITE_BRICK_SLAB);
        register("calcite_brick_wall", CALCITE_BRICK_WALL);
        register("mossy_calcite_bricks", MOSSY_CALCITE_BRICKS);
        register("mossy_calcite_brick_stairs", MOSSY_CALCITE_BRICK_STAIRS);
        register("mossy_calcite_brick_slab", MOSSY_CALCITE_BRICK_SLAB);
        register("mossy_calcite_brick_wall", MOSSY_CALCITE_BRICK_WALL);
        register("cracked_calcite_bricks", CRACKED_CALCITE_BRICKS);
        register("cracked_calcite_brick_stairs", CRACKED_CALCITE_BRICK_STAIRS);
        register("cracked_calcite_brick_slab", CRACKED_CALCITE_BRICK_SLAB);
        register("cracked_calcite_brick_wall", CRACKED_CALCITE_BRICK_WALL);
        register("chiseled_calcite_bricks", CHISELED_CALCITE_BRICKS);
        register("dripstone_bricks", DRIPSTONE_BRICKS);
        register("dripstone_brick_stairs", DRIPSTONE_BRICK_STAIRS);
        register("dripstone_brick_slab", DRIPSTONE_BRICK_SLAB);
        register("dripstone_brick_wall", DRIPSTONE_BRICK_WALL);
        register("mossy_dripstone_bricks", MOSSY_DRIPSTONE_BRICKS);
        register("mossy_dripstone_brick_stairs", MOSSY_DRIPSTONE_BRICK_STAIRS);
        register("mossy_dripstone_brick_slab", MOSSY_DRIPSTONE_BRICK_SLAB);
        register("mossy_dripstone_brick_wall", MOSSY_DRIPSTONE_BRICK_WALL);
        register("cracked_dripstone_bricks", CRACKED_DRIPSTONE_BRICKS);
        register("cracked_dripstone_brick_stairs", CRACKED_DRIPSTONE_BRICK_STAIRS);
        register("cracked_dripstone_brick_slab", CRACKED_DRIPSTONE_BRICK_SLAB);
        register("cracked_dripstone_brick_wall", CRACKED_DRIPSTONE_BRICK_WALL);
        register("chiseled_dripstone_bricks", CHISELED_DRIPSTONE_BRICKS);
        register("cattail", CATTAIL);
        register("blood_kelp", BLOOD_KELP);
        register("blood_kelp_plant", BLOOD_KELP_PLANT);
        register("dried_blood_kelp_block", DRIED_BLOOD_KELP_BLOCK);
        register("blood_kelp_lantern", BLOOD_KELP_LANTERN);
        register("maroon_wool", MAROON_WOOL);
        register("maroon_stained_glass", MAROON_STAINED_GLASS);
        register("maroon_stained_glass_pane", MAROON_STAINED_GLASS_PANE);
        register("maroon_candle", MAROON_CANDLE);
        register("maroon_candle_cake", MAROON_CANDLE_CAKE);
        register("maroon_concrete", MAROON_CONCRETE);
        register("maroon_concrete_powder", MAROON_CONCRETE_POWDER);
        register("bog_blossom", BOG_BLOSSOM);
        register("maroon_candle_chocolate_cake", MAROON_CANDLE_CHOCOLATE_CAKE);
        register("candle_chocolate_cake", CANDLE_CHOCOLATE_CAKE);
        register("white_candle_chocolate_cake", WHITE_CANDLE_CHOCOLATE_CAKE);
        register("orange_candle_chocolate_cake", ORANGE_CANDLE_CHOCOLATE_CAKE);
        register("magenta_candle_chocolate_cake", MAGENTA_CANDLE_CHOCOLATE_CAKE);
        register("light_blue_candle_chocolate_cake", LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE);
        register("yellow_candle_chocolate_cake", YELLOW_CANDLE_CHOCOLATE_CAKE);
        register("lime_candle_chocolate_cake", LIME_CANDLE_CHOCOLATE_CAKE);
        register("pink_candle_chocolate_cake", PINK_CANDLE_CHOCOLATE_CAKE);
        register("gray_candle_chocolate_cake", GRAY_CANDLE_CHOCOLATE_CAKE);
        register("light_gray_candle_chocolate_cake", LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE);
        register("cyan_candle_chocolate_cake", CYAN_CANDLE_CHOCOLATE_CAKE);
        register("purple_candle_chocolate_cake", PURPLE_CANDLE_CHOCOLATE_CAKE);
        register("blue_candle_chocolate_cake", BLUE_CANDLE_CHOCOLATE_CAKE);
        register("brown_candle_chocolate_cake", BROWN_CANDLE_CHOCOLATE_CAKE);
        register("green_candle_chocolate_cake", GREEN_CANDLE_CHOCOLATE_CAKE);
        register("red_candle_chocolate_cake", RED_CANDLE_CHOCOLATE_CAKE);
        register("black_candle_chocolate_cake", BLACK_CANDLE_CHOCOLATE_CAKE);
        register("maroon_candle_red_velvet_cake", MAROON_CANDLE_RED_VELVET_CAKE);
        register("candle_red_velvet_cake", CANDLE_RED_VELVET_CAKE);
        register("white_candle_red_velvet_cake", WHITE_CANDLE_RED_VELVET_CAKE);
        register("orange_candle_red_velvet_cake", ORANGE_CANDLE_RED_VELVET_CAKE);
        register("magenta_candle_red_velvet_cake", MAGENTA_CANDLE_RED_VELVET_CAKE);
        register("light_blue_candle_red_velvet_cake", LIGHT_BLUE_CANDLE_RED_VELVET_CAKE);
        register("yellow_candle_red_velvet_cake", YELLOW_CANDLE_RED_VELVET_CAKE);
        register("lime_candle_red_velvet_cake", LIME_CANDLE_RED_VELVET_CAKE);
        register("pink_candle_red_velvet_cake", PINK_CANDLE_RED_VELVET_CAKE);
        register("gray_candle_red_velvet_cake", GRAY_CANDLE_RED_VELVET_CAKE);
        register("light_gray_candle_red_velvet_cake", LIGHT_GRAY_CANDLE_RED_VELVET_CAKE);
        register("cyan_candle_red_velvet_cake", CYAN_CANDLE_RED_VELVET_CAKE);
        register("purple_candle_red_velvet_cake", PURPLE_CANDLE_RED_VELVET_CAKE);
        register("blue_candle_red_velvet_cake", BLUE_CANDLE_RED_VELVET_CAKE);
        register("brown_candle_red_velvet_cake", BROWN_CANDLE_RED_VELVET_CAKE);
        register("green_candle_red_velvet_cake", GREEN_CANDLE_RED_VELVET_CAKE);
        register("red_candle_red_velvet_cake", RED_CANDLE_RED_VELVET_CAKE);
        register("black_candle_red_velvet_cake", BLACK_CANDLE_RED_VELVET_CAKE);
        register("camel_plushie", CAMEL_PLUSHIE);
        register("cindersnap_berry_bush", CINDERSNAP_BERRY_BUSH);
        register("frostbite_berry_bush", FROSTBITE_BERRY_BUSH);
        register("polished_dripstone", POLISHED_DRIPSTONE);
        register("polished_dripstone_stairs", POLISHED_DRIPSTONE_STAIRS);
        register("polished_dripstone_slab", POLISHED_DRIPSTONE_SLAB);
        register("polished_dripstone_wall", POLISHED_DRIPSTONE_WALL);
        register("polished_calcite", POLISHED_CALCITE);
        register("polished_calcite_stairs", POLISHED_CALCITE_STAIRS);
        register("polished_calcite_slab", POLISHED_CALCITE_SLAB);
        register("polished_calcite_wall", POLISHED_CALCITE_WALL);
        register("dripstone_stairs", DRIPSTONE_STAIRS);
        register("dripstone_slab", DRIPSTONE_SLAB);
        register("dripstone_wall", DRIPSTONE_WALL);
        register("calcite_stairs", CALCITE_STAIRS);
        register("calcite_slab", CALCITE_SLAB);
        register("calcite_wall", CALCITE_WALL);
        register("bamboo_planter_box", BAMBOO_PLANTER_BOX);
        register("potted_cattail", POTTED_CATTAIL);
        register("stone_wall", STONE_WALL);
        register("quartz_wall", QUARTZ_WALL);
        register("smooth_quartz_wall", SMOOTH_QUARTZ_WALL);
        register("grass_slab", GRASS_SLAB);
        register("podzol_slab", PODZOL_SLAB);
        register("mycelium_slab", MYCELIUM_SLAB);
        register("dirt_path_slab", DIRT_PATH_SLAB);
        register("dirt_slab", DIRT_SLAB);
        register("coarse_dirt_slab", COARSE_DIRT_SLAB);
        register("rooted_dirt_slab", ROOTED_DIRT_SLAB);
        register("wild_green_onions", WILD_GREEN_ONIONS);

        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }
}
