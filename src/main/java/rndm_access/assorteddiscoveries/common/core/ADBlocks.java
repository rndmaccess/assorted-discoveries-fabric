package rndm_access.assorteddiscoveries.common.core;

import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.common.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.common.block.*;

import java.util.function.ToIntFunction;

public class ADBlocks {
    public static final Block BAT_PLUSH = new ADBatPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.GRAY)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BLAZE_PLUSH = new ADBlazePlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.YELLOW)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block CAVE_SPIDER_PLUSH = new ADCaveSpiderPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.CYAN)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block CHICKEN_PLUSH = new ADChickenPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.WHITE)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block COW_PLUSH = new ADCowPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.BROWN)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block CREEPER_PLUSH = new ADCreeperPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.LIME)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block ENDERMAN_PLUSH = new ADEndermanPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.BLACK)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block GHAST_PLUSH = new ADGhastPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block GUARDIAN_PLUSH = new ADGuardianPlushBlock(AbstractBlock.Settings.copy(CAVE_SPIDER_PLUSH));
    public static final Block WHITE_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block GRAY_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block LIGHT_GRAY_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.LIGHT_GRAY)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BROWN_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block BLACK_HORSE_PLUSH = new ADHorsePlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block MAGMA_CUBE_PLUSH = new ADCubePlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.RED)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block RED_MOOSHROOM_PLUSH = new ADMooshroomPlushBlock(AbstractBlock.Settings.copy(MAGMA_CUBE_PLUSH));
    public static final Block BROWN_MOOSHROOM_PLUSH = new ADMooshroomPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block OCELOT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block TABBY_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block TUXEDO_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block RED_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.ORANGE)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block SIAMESE_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_HORSE_PLUSH));
    public static final Block CALICO_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block PERSIAN_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block RAGDOLL_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block WHITE_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block JELLIE_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block BLACK_CAT_PLUSH = new ADCatPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block PIG_PLUSH = new ADPigPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.PINK)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BROWN_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block WHITE_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block BLACK_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block GOLD_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block TOAST_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block SALT_RABBIT_PLUSH = new ADRabbitPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block WHITE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block ORANGE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(RED_CAT_PLUSH));
    public static final Block MAGENTA_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.MAGENTA)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block LIGHT_BLUE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.LIGHT_BLUE)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block YELLOW_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block LIME_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(CREEPER_PLUSH));
    public static final Block PINK_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(PIG_PLUSH));
    public static final Block GRAY_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(BAT_PLUSH));
    public static final Block LIGHT_GRAY_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_HORSE_PLUSH));
    public static final Block CYAN_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(CAVE_SPIDER_PLUSH));
    public static final Block PURPLE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.PURPLE)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BLUE_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.BLUE)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block BROWN_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block GREEN_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.of(Material.WOOL, MapColor.GREEN)
            .strength(0.2F).sounds(BlockSoundGroup.WOOL));
    public static final Block RED_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(MAGMA_CUBE_PLUSH));
    public static final Block BLACK_SHEEP_PLUSH = new ADSheepPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block SKELETON_PLUSH = new ADSkeletonPlushBlock(AbstractBlock.Settings.copy(LIGHT_GRAY_HORSE_PLUSH));
    public static final Block SLIME_PLUSH = new ADCubePlushBlock(AbstractBlock.Settings.copy(CREEPER_PLUSH));
    public static final Block SPIDER_PLUSH = new ADSpiderPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block SQUID_PLUSH = new ADSquidPlushBlock(AbstractBlock.Settings.copy(BLUE_SHEEP_PLUSH));
    public static final Block GLOW_SQUID_PLUSH = new ADSquidPlushBlock(AbstractBlock.Settings.copy(LIGHT_BLUE_SHEEP_PLUSH).luminance((state) -> 10));
    public static final Block BEE_PLUSH = new ADBeePlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block PLAINS_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block DESERT_VILLAGER_PLUSH = new ADDesertVillagerPlushBlock(AbstractBlock.Settings.copy(RED_CAT_PLUSH));
    public static final Block JUNGLE_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block SAVANNA_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block SNOW_VILLAGER_PLUSH = new ADShortHatVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block SWAMP_VILLAGER_PLUSH = new ADShortHatVillagerPlushBlock(AbstractBlock.Settings.copy(GREEN_SHEEP_PLUSH));
    public static final Block TAIGA_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block CRIMSON_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block WARPED_VILLAGER_PLUSH = new ADVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block WANDERING_TRADER_PLUSH = new ADShortHatVillagerPlushBlock(AbstractBlock.Settings.copy(BLUE_SHEEP_PLUSH));
    public static final Block PLAINS_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(GREEN_SHEEP_PLUSH));
    public static final Block DESERT_ZOMBIE_VILLAGER_PLUSH = new ADDesertZombieVillagerPlushBlock(AbstractBlock.Settings.copy(GREEN_SHEEP_PLUSH));
    public static final Block JUNGLE_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block SAVANNA_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block SNOW_ZOMBIE_VILLAGER_PLUSH = new ADShortHatZombieVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block SWAMP_ZOMBIE_VILLAGER_PLUSH = new ADShortHatZombieVillagerPlushBlock(AbstractBlock.Settings.copy(COW_PLUSH));
    public static final Block TAIGA_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block CRIMSON_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block WARPED_ZOMBIE_VILLAGER_PLUSH = new ADZombieVillagerPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block WITCH_PLUSH = new ADWitchPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block WOLF_PLUSH = new ADWolfPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block ZOMBIE_PLUSH = new ADZombiePlushBlock(AbstractBlock.Settings.copy(GREEN_SHEEP_PLUSH));
    public static final Block PIGLIN_PLUSH = new ADPiglinPlushBlock(AbstractBlock.Settings.copy(PIG_PLUSH));
    public static final Block ZOMBIFIED_PIGLIN_PLUSH = new ADZombiePlushBlock(AbstractBlock.Settings.copy(PIG_PLUSH));
    public static final Block PUFFERFISH_PLUSH = new ADPufferfishPlushBlock(AbstractBlock.Settings.copy(BLAZE_PLUSH));
    public static final Block WITHER_PLUSH = new ADWitherPlushBlock(AbstractBlock.Settings.copy(ENDERMAN_PLUSH));
    public static final Block STRIDER_PLUSH = new ADStriderPlushBlock(AbstractBlock.Settings.copy(MAGMA_CUBE_PLUSH));
    public static final Block SHIVERING_STRIDER_PLUSH = new ADStriderPlushBlock(AbstractBlock.Settings.copy(PURPLE_SHEEP_PLUSH));
    public static final Block PHANTOM_PLUSH = new ADPhantomPlushBlock(AbstractBlock.Settings.copy(BLUE_SHEEP_PLUSH));
    public static final Block HOGLIN_PLUSH = new ADHoglinPlushBlock(AbstractBlock.Settings.copy(RED_CAT_PLUSH));
    public static final Block ZOGLIN_PLUSH = new ADHoglinPlushBlock(AbstractBlock.Settings.copy(PIG_PLUSH));
    public static final Block POLAR_BEAR_PLUSH = new ADPolarBearPlushBlock(AbstractBlock.Settings.copy(CHICKEN_PLUSH));
    public static final Block NETHER_SMOKY_QUARTZ_ORE = new OreBlock(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE));
    public static final Block SMOKY_QUARTZ_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.BLACK)
            .requiresTool().strength(0.8F));
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICKS = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS = new ADStairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_PILLAR = new PillarBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_STAIRS = new ADStairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOKY_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = new ADStairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
    public static final Block CRACKED_STONE_BRICK_STAIRS = new ADStairsBlock(Blocks.CRACKED_STONE_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block CRACKED_STONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block CRACKED_STONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK));
    public static final Block SMOOTH_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ));
    public static final Block STONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE));
    public static final Block RED_GLASS = new GlassBlock(AbstractBlock.Settings.copy(Blocks.GLASS));
    public static final Block RED_GLASS_PANE = new ADPaneBlock(AbstractBlock.Settings.copy(Blocks.GLASS_PANE));
    public static final Block BLUEBERRY_BUSH = new ADBlueberryBushBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
    public static final Block BOK_CHOY = new ADBokChoyCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
    public static final Block GARLIC = new ADOnionBlock(AbstractBlock.Settings.copy(Blocks.WHEAT), () -> ADItems.GARLIC);
    public static final Block GREEN_ONIONS = new ADOnionBlock(AbstractBlock.Settings.copy(Blocks.WHEAT), () -> ADItems.GREEN_ONION);
    public static final Block OAK_PLANTER_BOX = planterBoxBlock(MapColor.OAK_TAN);
    public static final Block SPRUCE_PLANTER_BOX = planterBoxBlock(MapColor.SPRUCE_BROWN);
    public static final Block BIRCH_PLANTER_BOX = planterBoxBlock(MapColor.PALE_YELLOW);
    public static final Block JUNGLE_PLANTER_BOX = planterBoxBlock(MapColor.DIRT_BROWN);
    public static final Block ACACIA_PLANTER_BOX = planterBoxBlock(MapColor.ORANGE);
    public static final Block DARK_OAK_PLANTER_BOX = planterBoxBlock(MapColor.BROWN);
    public static final Block CRIMSON_PLANTER_BOX = netherPlanterBoxBlock(MapColor.DULL_PINK);
    public static final Block WARPED_PLANTER_BOX = netherPlanterBoxBlock(MapColor.DARK_AQUA);
    public static final Block OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block SPRUCE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS));
    public static final Block BIRCH_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS));
    public static final Block JUNGLE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS));
    public static final Block ACACIA_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS));
    public static final Block DARK_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS));
    public static final Block CRIMSON_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));
    public static final Block WARPED_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
    public static final Block STRIPPED_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block STRIPPED_SPRUCE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS));
    public static final Block STRIPPED_BIRCH_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS));
    public static final Block STRIPPED_JUNGLE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS));
    public static final Block STRIPPED_ACACIA_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS));
    public static final Block STRIPPED_DARK_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS));
    public static final Block STRIPPED_CRIMSON_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));
    public static final Block STRIPPED_WARPED_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
    public static final Block OAK_ROPE_LADDER = ropeLadderBlock();
    public static final Block SPRUCE_ROPE_LADDER = ropeLadderBlock();
    public static final Block BIRCH_ROPE_LADDER = ropeLadderBlock();
    public static final Block JUNGLE_ROPE_LADDER = ropeLadderBlock();
    public static final Block ACACIA_ROPE_LADDER = ropeLadderBlock();
    public static final Block DARK_OAK_ROPE_LADDER = ropeLadderBlock();
    public static final Block CRIMSON_ROPE_LADDER = ropeLadderBlock();
    public static final Block WARPED_ROPE_LADDER = ropeLadderBlock();
    public static final Block IRON_LADDER = new ADLadderBlock(AbstractBlock.Settings.of(Material.METAL)
            .strength(0.4F, 5.0F).sounds(BlockSoundGroup.METAL).nonOpaque());
    public static final Block DIRT_SLAB = new ADDirtSlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT).ticksRandomly());
    public static final Block GRASS_SLAB = new ADGrassSlabBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK));
    public static final Block DIRT_PATH_SLAB = new ADDirtPathSlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT_PATH));
    public static final Block COARSE_DIRT_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.COARSE_DIRT));
    public static final Block SNOW_BRICKS = new Block(AbstractBlock.Settings.of(Material.SNOW_BLOCK).strength(0.6F)
            .requiresTool().sounds(BlockSoundGroup.SNOW));
    public static final Block SNOW_BRICK_STAIRS = new ADStairsBlock(ADBlocks.SNOW_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block SNOW_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block SNOW_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
    public static final Block PURPLE_MUSHROOM = new MushroomPlantBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM),
            () -> ADConfiguredFeatures.HUGE_PURPLE_MUSHROOM);
    public static final Block PURPLE_MUSHROOM_BLOCK = new ADPurpleMushroomBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
    public static final Block WOODCUTTER = new ADWoodcutterBlock(AbstractBlock.Settings.copy(Blocks.STONECUTTER));
    public static final Block WHITE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.WHITE_SPARK);
    public static final Block ORANGE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.ORANGE_SPARK);
    public static final Block MAGENTA_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.MAGENTA_SPARK);
    public static final Block LIGHT_BLUE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.LIGHT_BLUE_SPARK);
    public static final Block YELLOW_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.YELLOW_SPARK);
    public static final Block LIME_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.LIME_SPARK);
    public static final Block PINK_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.PINK_SPARK);
    public static final Block GRAY_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.GRAY_SPARK);
    public static final Block LIGHT_GRAY_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.LIGHT_GRAY_SPARK);
    public static final Block CYAN_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.CYAN_SPARK);
    public static final Block PURPLE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.PURPLE_SPARK);
    public static final Block BLUE_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.BLUE_SPARK);
    public static final Block BROWN_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.BROWN_SPARK);
    public static final Block GREEN_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.GREEN_SPARK);
    public static final Block RED_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.RED_SPARK);
    public static final Block BLACK_CAMPFIRE = dyedCampfireBlock(ADParticleTypes.BLACK_SPARK);
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
    public static final Block WITCHS_CRADLE = new ADWitchsCradleBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
            .luminance((state) -> 10));
    public static final Block FRESH_BAMBOO_FENCE = bambooFenceBlock(MapColor.DARK_GREEN);
    public static final Block FRESH_BAMBOO_FENCE_GATE = new FenceGateBlock(AbstractBlock.Settings.copy(FRESH_BAMBOO_FENCE));
    public static final Block DRIED_BAMBOO_FENCE = bambooFenceBlock(MapColor.PALE_YELLOW);
    public static final Block DRIED_BAMBOO_FENCE_GATE = new FenceGateBlock(AbstractBlock.Settings.copy(DRIED_BAMBOO_FENCE));
    public static final Block BAUXITE = new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.SPRUCE_BROWN)
            .strength(0.3F));
    public static final Block BAUXITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE));
    public static final Block BAUXITE_STAIRS = new ADStairsBlock(BAUXITE.getDefaultState(),
            AbstractBlock.Settings.copy(BAUXITE));
    public static final Block BAUXITE_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE));
    public static final Block BAUXITE_BRICKS = new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.SPRUCE_BROWN)
            .strength(0.4F));
    public static final Block BAUXITE_BRICK_STAIRS = new ADStairsBlock(BAUXITE_BRICKS.getDefaultState(),
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
    public static final Block SNOW_SLAB = new SlabBlock(AbstractBlock.Settings.of(Material.SNOW_BLOCK).requiresTool()
            .strength(0.2F).sounds(BlockSoundGroup.SNOW));
    public static final Block SNOW_STAIRS = new ADStairsBlock(Blocks.SNOW_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(SNOW_SLAB));
    public static final Block SNOW_WALL = new WallBlock(AbstractBlock.Settings.copy(SNOW_SLAB));
    public static final Block TWISTED_NETHER_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_STAIRS = new ADStairsBlock(TWISTED_NETHER_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
    public static final Block TWISTED_NETHERRACK = new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK));
    public static final Block TWISTED_NETHERRACK_STAIRS = new ADStairsBlock(TWISTED_NETHERRACK.getDefaultState(),
            AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
    public static final Block TWISTED_NETHERRACK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
    public static final Block TWISTED_NETHERRACK_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
    public static final Block WEEPING_NETHER_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_STAIRS = new ADStairsBlock(WEEPING_NETHER_BRICKS.getDefaultState(),
            AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
    public static final Block WEEPING_NETHERRACK = new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK));
    public static final Block WEEPING_NETHERRACK_STAIRS = new ADStairsBlock(WEEPING_NETHERRACK.getDefaultState(),
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
    public static final Block ICICLE = new ADIcicleBlock(AbstractBlock.Settings.of(Material.ICE).requiresTool()
            .strength(0.2F).noCollision().sounds(BlockSoundGroup.GLASS));
    public static final Block CATTAIL = new ADCattailBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision()
            .nonOpaque().sounds(BlockSoundGroup.WET_GRASS));
    public static final Block CHOCOLATE_CAKE = new ADCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
    public static final Block RED_VELVET_CAKE = new ADCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
    public static final Block STONE_TILES = new Block(AbstractBlock.Settings.copy(Blocks.STONE)
            .sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block STONE_TILE_STAIRS = new ADStairsBlock(STONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILES = new Block(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILE_STAIRS = new ADStairsBlock(MOSSY_STONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block MOSSY_STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILES = new Block(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILE_STAIRS = new ADStairsBlock(CRACKED_STONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block CRACKED_STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
    public static final Block SWEET_BERRY_PIE = new ADPieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), 3,
            0.6F);
    public static final Block BLUEBERRY_PIE = new ADPieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), 3,
            0.6F);
    public static final Block BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)
            .sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block BLACKSTONE_TILE_STAIRS = new ADStairsBlock(BLACKSTONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS = new ADStairsBlock(BLACKSTONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS = new ADStairsBlock(BLACKSTONE_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block WEEPING_BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS = new ADStairsBlock(
            Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = new ADStairsBlock(
            Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_BLACKSTONE = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_STAIRS = new ADStairsBlock(Blocks.BLACKSTONE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_STAIRS = new ADStairsBlock(
            Blocks.BLACKSTONE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
    public static final Block QUARTZ_TILES = new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK)
            .sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block QUARTZ_TILE_STAIRS = new ADStairsBlock(QUARTZ_TILES.getDefaultState(),
            AbstractBlock.Settings.copy(QUARTZ_TILES));
    public static final Block QUARTZ_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(QUARTZ_TILES));
    public static final Block QUARTZ_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(QUARTZ_TILES));
    public static final Block CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_STAIRS = new ADStairsBlock(Blocks.CALCITE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICK_STAIRS = new ADStairsBlock(Blocks.CALCITE.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block MOSSY_CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CRACKED_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block CRACKED_CALCITE_BRICK_STAIRS = new ADStairsBlock(
            CRACKED_CALCITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
    public static final Block CRACKED_CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
    public static final Block CRACKED_CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
    public static final Block CHISELED_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
    public static final Block TUFF_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block TUFF_BRICK_STAIRS = new ADStairsBlock(Blocks.TUFF.getDefaultState(), AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block TUFF_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block TUFF_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block MOSSY_TUFF_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block MOSSY_TUFF_BRICK_STAIRS = new ADStairsBlock(Blocks.TUFF.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block MOSSY_TUFF_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block MOSSY_TUFF_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block CRACKED_TUFF_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block CRACKED_TUFF_BRICK_STAIRS = new ADStairsBlock(Blocks.TUFF.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block CRACKED_TUFF_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block CRACKED_TUFF_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block CHISELED_TUFF_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.TUFF));
    public static final Block DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICK_STAIRS = new ADStairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS = new ADStairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = new ADStairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
            AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block CHISELED_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
    public static final Block BLOOD_KELP = new ADBloodKelpBlock(AbstractBlock.Settings.copy(Blocks.KELP)
            .luminance(getLuminanceFromState(10)));
    public static final Block BLOOD_KELP_PLANT = new ADBloodKelpPlantBlock(AbstractBlock.Settings.copy(Blocks.KELP_PLANT)
            .luminance(getLuminanceFromState(10)));
    public static final Block DRIED_BLOOD_KELP_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.DRIED_KELP_BLOCK));

    private static ADBambooFenceBlock bambooFenceBlock(MapColor color) {
        return new ADBambooFenceBlock(AbstractBlock.Settings.of(Material.WOOD, color).strength(1.0F)
                .breakInstantly().nonOpaque().sounds(BlockSoundGroup.BAMBOO));
    }

    private static WallTorchBlock wallTorchBlock(ParticleEffect flameParticle) {
        return new ADWallTorchBlock(AbstractBlock.Settings.copy(Blocks.WALL_TORCH), flameParticle);
    }

    private static TorchBlock torchBlock(ParticleEffect flameParticle) {
        return new ADTorchBlock(AbstractBlock.Settings.copy(Blocks.TORCH), flameParticle);
    }

    private static LanternBlock lanternBlock() {
        return new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN));
    }

    private static ADRopeLadderBlock ropeLadderBlock() { return new ADRopeLadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER)); }

    private static ADPlanterBoxBlock planterBoxBlock(MapColor color) {
        return new ADPlanterBoxBlock(AbstractBlock.Settings.of(Material.WOOD, color).strength(2.5F).sounds(BlockSoundGroup.WOOD));
    }

    private static ADPlanterBoxBlock netherPlanterBoxBlock(MapColor color) {
        return new ADPlanterBoxBlock(AbstractBlock.Settings.of(Material.NETHER_WOOD, color).strength(2.5F).sounds(BlockSoundGroup.WOOD));
    }

    private static ADDyedCampfireBlock dyedCampfireBlock(ParticleEffect sparkParticle) {
        return new ADDyedCampfireBlock(AbstractBlock.Settings.copy(Blocks.CAMPFIRE), sparkParticle);
    }

    private static ToIntFunction<BlockState> getLuminanceFromState(int luminance) {
        return (state) -> state.get(Properties.LIT) ? luminance : 0;
    }

    private static void register(String path, Block block) {
        Registry.register(Registry.BLOCK, ADReference.makeId(path), block);
    }

    /**
     * Called during mod initialization to register every block.
     */
    public static void registerBlocks() {
        register("bat_plush", BAT_PLUSH);
        register("blaze_plush", BLAZE_PLUSH);
        register("cave_spider_plush", CAVE_SPIDER_PLUSH);
        register("chicken_plush", CHICKEN_PLUSH);
        register("cow_plush", COW_PLUSH);
        register("creeper_plush", CREEPER_PLUSH);
        register("enderman_plush", ENDERMAN_PLUSH);
        register("ghast_plush", GHAST_PLUSH);
        register("guardian_plush", GUARDIAN_PLUSH);
        register("white_horse_plush", WHITE_HORSE_PLUSH);
        register("gray_horse_plush", GRAY_HORSE_PLUSH);
        register("light_gray_horse_plush", LIGHT_GRAY_HORSE_PLUSH);
        register("brown_horse_plush", BROWN_HORSE_PLUSH);
        register("black_horse_plush", BLACK_HORSE_PLUSH);
        register("magma_cube_plush", MAGMA_CUBE_PLUSH);
        register("red_mooshroom_plush", RED_MOOSHROOM_PLUSH);
        register("brown_mooshroom_plush", BROWN_MOOSHROOM_PLUSH);
        register("ocelot_plush", OCELOT_PLUSH);
        register("tabby_cat_plush", TABBY_CAT_PLUSH);
        register("tuxedo_cat_plush", TUXEDO_CAT_PLUSH);
        register("red_cat_plush", RED_CAT_PLUSH);
        register("siamese_cat_plush", SIAMESE_CAT_PLUSH);
        register("british_shorthair_cat_plush", BRITISH_SHORTHAIR_CAT_PLUSH);
        register("calico_cat_plush", CALICO_CAT_PLUSH);
        register("persian_cat_plush", PERSIAN_CAT_PLUSH);
        register("ragdoll_cat_plush", RAGDOLL_CAT_PLUSH);
        register("white_cat_plush", WHITE_CAT_PLUSH);
        register("jellie_cat_plush", JELLIE_CAT_PLUSH);
        register("black_cat_plush", BLACK_CAT_PLUSH);
        register("pig_plush", PIG_PLUSH);
        register("brown_rabbit_plush", BROWN_RABBIT_PLUSH);
        register("white_rabbit_plush", WHITE_RABBIT_PLUSH);
        register("black_rabbit_plush", BLACK_RABBIT_PLUSH);
        register("white_splotched_rabbit_plush", WHITE_SPLOTCHED_RABBIT_PLUSH);
        register("gold_rabbit_plush", GOLD_RABBIT_PLUSH);
        register("toast_rabbit_plush", TOAST_RABBIT_PLUSH);
        register("salt_rabbit_plush", SALT_RABBIT_PLUSH);
        register("white_sheep_plush", WHITE_SHEEP_PLUSH);
        register("orange_sheep_plush", ORANGE_SHEEP_PLUSH);
        register("magenta_sheep_plush", MAGENTA_SHEEP_PLUSH);
        register("light_blue_sheep_plush", LIGHT_BLUE_SHEEP_PLUSH);
        register("yellow_sheep_plush", YELLOW_SHEEP_PLUSH);
        register("lime_sheep_plush", LIME_SHEEP_PLUSH);
        register("pink_sheep_plush", PINK_SHEEP_PLUSH);
        register("gray_sheep_plush", GRAY_SHEEP_PLUSH);
        register("light_gray_sheep_plush", LIGHT_GRAY_SHEEP_PLUSH);
        register("cyan_sheep_plush", CYAN_SHEEP_PLUSH);
        register("purple_sheep_plush", PURPLE_SHEEP_PLUSH);
        register("blue_sheep_plush", BLUE_SHEEP_PLUSH);
        register("brown_sheep_plush", BROWN_SHEEP_PLUSH);
        register("green_sheep_plush", GREEN_SHEEP_PLUSH);
        register("red_sheep_plush", RED_SHEEP_PLUSH);
        register("black_sheep_plush", BLACK_SHEEP_PLUSH);
        register("skeleton_plush", SKELETON_PLUSH);
        register("slime_plush", SLIME_PLUSH);
        register("spider_plush", SPIDER_PLUSH);
        register("squid_plush", SQUID_PLUSH);
        register("glow_squid_plush", GLOW_SQUID_PLUSH);
        register("bee_plush", BEE_PLUSH);
        register("plains_villager_plush", PLAINS_VILLAGER_PLUSH);
        register("desert_villager_plush", DESERT_VILLAGER_PLUSH);
        register("jungle_villager_plush", JUNGLE_VILLAGER_PLUSH);
        register("savanna_villager_plush", SAVANNA_VILLAGER_PLUSH);
        register("snow_villager_plush", SNOW_VILLAGER_PLUSH);
        register("swamp_villager_plush", SWAMP_VILLAGER_PLUSH);
        register("taiga_villager_plush", TAIGA_VILLAGER_PLUSH);
        register("crimson_villager_plush", CRIMSON_VILLAGER_PLUSH);
        register("warped_villager_plush", WARPED_VILLAGER_PLUSH);
        register("wandering_trader_plush", WANDERING_TRADER_PLUSH);
        register("plains_zombie_villager_plush", PLAINS_ZOMBIE_VILLAGER_PLUSH);
        register("desert_zombie_villager_plush", DESERT_ZOMBIE_VILLAGER_PLUSH);
        register("jungle_zombie_villager_plush", JUNGLE_ZOMBIE_VILLAGER_PLUSH);
        register("savanna_zombie_villager_plush", SAVANNA_ZOMBIE_VILLAGER_PLUSH);
        register("snow_zombie_villager_plush", SNOW_ZOMBIE_VILLAGER_PLUSH);
        register("swamp_zombie_villager_plush", SWAMP_ZOMBIE_VILLAGER_PLUSH);
        register("taiga_zombie_villager_plush", TAIGA_ZOMBIE_VILLAGER_PLUSH);
        register("crimson_zombie_villager_plush", CRIMSON_ZOMBIE_VILLAGER_PLUSH);
        register("warped_zombie_villager_plush", WARPED_ZOMBIE_VILLAGER_PLUSH);
        register("witch_plush", WITCH_PLUSH);
        register("wolf_plush", WOLF_PLUSH);
        register("zombie_plush", ZOMBIE_PLUSH);
        register("piglin_plush", PIGLIN_PLUSH);
        register("zombified_piglin_plush", ZOMBIFIED_PIGLIN_PLUSH);
        register("pufferfish_plush", PUFFERFISH_PLUSH);
        register("wither_plush", WITHER_PLUSH);
        register("strider_plush", STRIDER_PLUSH);
        register("shivering_strider_plush", SHIVERING_STRIDER_PLUSH);
        register("phantom_plush", PHANTOM_PLUSH);
        register("hoglin_plush", HOGLIN_PLUSH);
        register("zoglin_plush", ZOGLIN_PLUSH);
        register("polar_bear_plush", POLAR_BEAR_PLUSH);
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
        register("quartz_wall", QUARTZ_WALL);
        register("smooth_quartz_wall", SMOOTH_QUARTZ_WALL);
        register("stone_wall", STONE_WALL);
        register("red_glass", RED_GLASS);
        register("red_glass_pane", RED_GLASS_PANE);
        register("blueberry_bush", BLUEBERRY_BUSH);
        register("bok_choy", BOK_CHOY);
        register("garlic", GARLIC);
        register("green_onions", GREEN_ONIONS);
        register("oak_planter_box", OAK_PLANTER_BOX);
        register("spruce_planter_box", SPRUCE_PLANTER_BOX);
        register("birch_planter_box", BIRCH_PLANTER_BOX);
        register("jungle_planter_box", JUNGLE_PLANTER_BOX);
        register("acacia_planter_box", ACACIA_PLANTER_BOX);
        register("dark_oak_planter_box", DARK_OAK_PLANTER_BOX);
        register("crimson_planter_box", CRIMSON_PLANTER_BOX);
        register("warped_planter_box", WARPED_PLANTER_BOX);
        register("oak_wall", OAK_WALL);
        register("spruce_wall", SPRUCE_WALL);
        register("birch_wall", BIRCH_WALL);
        register("jungle_wall", JUNGLE_WALL);
        register("acacia_wall", ACACIA_WALL);
        register("dark_oak_wall", DARK_OAK_WALL);
        register("crimson_wall", CRIMSON_WALL);
        register("warped_wall", WARPED_WALL);
        register("stripped_oak_wall", STRIPPED_OAK_WALL);
        register("stripped_spruce_wall", STRIPPED_SPRUCE_WALL);
        register("stripped_birch_wall", STRIPPED_BIRCH_WALL);
        register("stripped_jungle_wall", STRIPPED_JUNGLE_WALL);
        register("stripped_acacia_wall", STRIPPED_ACACIA_WALL);
        register("stripped_dark_oak_wall", STRIPPED_DARK_OAK_WALL);
        register("stripped_crimson_wall", STRIPPED_CRIMSON_WALL);
        register("stripped_warped_wall", STRIPPED_WARPED_WALL);
        register("oak_rope_ladder", OAK_ROPE_LADDER);
        register("spruce_rope_ladder", SPRUCE_ROPE_LADDER);
        register("birch_rope_ladder", BIRCH_ROPE_LADDER);
        register("jungle_rope_ladder", JUNGLE_ROPE_LADDER);
        register("acacia_rope_ladder", ACACIA_ROPE_LADDER);
        register("dark_oak_rope_ladder", DARK_OAK_ROPE_LADDER);
        register("crimson_rope_ladder", CRIMSON_ROPE_LADDER);
        register("warped_rope_ladder", WARPED_ROPE_LADDER);
        register("iron_ladder", IRON_LADDER);
        register("dirt_slab", DIRT_SLAB);
        register("grass_slab", GRASS_SLAB);
        register("dirt_path_slab", DIRT_PATH_SLAB);
        register("coarse_dirt_slab", COARSE_DIRT_SLAB);
        register("snow_bricks", SNOW_BRICKS);
        register("snow_brick_stairs", SNOW_BRICK_STAIRS);
        register("snow_brick_slab", SNOW_BRICK_SLAB);
        register("snow_brick_wall", SNOW_BRICK_WALL);
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
        register("witchs_cradle", WITCHS_CRADLE);
        register("fresh_bamboo_fence", FRESH_BAMBOO_FENCE);
        register("fresh_bamboo_fence_gate", FRESH_BAMBOO_FENCE_GATE);
        register("dried_bamboo_fence", DRIED_BAMBOO_FENCE);
        register("dried_bamboo_fence_gate", DRIED_BAMBOO_FENCE_GATE);
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
        register("snow_slab", SNOW_SLAB);
        register("snow_stairs", SNOW_STAIRS);
        register("snow_wall", SNOW_WALL);
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
        register("ender_grass", ENDER_GRASS);
        register("icicle", ICICLE);
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
        register("tuff_bricks", TUFF_BRICKS);
        register("tuff_brick_stairs", TUFF_BRICK_STAIRS);
        register("tuff_brick_slab", TUFF_BRICK_SLAB);
        register("tuff_brick_wall", TUFF_BRICK_WALL);
        register("mossy_tuff_bricks", MOSSY_TUFF_BRICKS);
        register("mossy_tuff_brick_stairs", MOSSY_TUFF_BRICK_STAIRS);
        register("mossy_tuff_brick_slab", MOSSY_TUFF_BRICK_SLAB);
        register("mossy_tuff_brick_wall", MOSSY_TUFF_BRICK_WALL);
        register("cracked_tuff_bricks", CRACKED_TUFF_BRICKS);
        register("cracked_tuff_brick_stairs", CRACKED_TUFF_BRICK_STAIRS);
        register("cracked_tuff_brick_slab", CRACKED_TUFF_BRICK_SLAB);
        register("cracked_tuff_brick_wall", CRACKED_TUFF_BRICK_WALL);
        register("chiseled_tuff_bricks", CHISELED_TUFF_BRICKS);
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

        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }
}
