package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block.*;
import rndm_access.assorteddiscoveries.item.RopeLadderBlockItem;

import java.util.function.Function;
import java.util.function.ToIntFunction;

@SuppressWarnings("unused")
public final class ModBlocks {
    public static final Block BAT_PLUSHIE
            = register(ModBlockIds.BAT_PLUSHIE_KEY, BatPlushieBlock::new, makePlushieSettings());
    public static final Block BLAZE_PLUSHIE
            = register(ModBlockIds.BLAZE_PLUSHIE_KEY, BlazePlushieBlock::new, makeGlowingPlushieSettings());
    public static final Block CAVE_SPIDER_PLUSHIE
            = register(ModBlockIds.CAVE_SPIDER_PLUSHIE_KEY, CaveSpiderPlushieBlock::new, makePlushieSettings());
    public static final Block TEMPERATE_CHICKEN_PLUSHIE
            = register(ModBlockIds.TEMPERATE_CHICKEN_PLUSHIE_KEY, ChickenPlushieBlock::new, makePlushieSettings());
    public static final Block TEMPERATE_COW_PLUSHIE
            = register(ModBlockIds.TEMPERATE_COW_PLUSHIE_KEY, CowPlushieBlock::new, makePlushieSettings());
    public static final Block CREEPER_PLUSHIE
            = register(ModBlockIds.CREEPER_PLUSHIE_KEY,  CreeperPlushieBlock::new, makePlushieSettings());
    public static final Block ENDERMAN_PLUSHIE
            = register(ModBlockIds.ENDERMAN_PLUSHIE_KEY, EndermanPlushieBlock::new, makePlushieSettings());
    public static final Block GHAST_PLUSHIE
            = register(ModBlockIds.GHAST_PLUSHIE_KEY, GhastPlushieBlock::new, makePlushieSettings());
    public static final Block GUARDIAN_PLUSHIE
            = register(ModBlockIds.GUARDIAN_PLUSHIE_KEY, GuardianPlushieBlock::new, makePlushieSettings());
    public static final Block WHITE_HORSE_PLUSHIE = registerHorsePlushie(ModBlockIds.WHITE_HORSE_PLUSHIE_KEY);
    public static final Block GRAY_HORSE_PLUSHIE = registerHorsePlushie(ModBlockIds.GRAY_HORSE_PLUSHIE_KEY);
    public static final Block BROWN_HORSE_PLUSHIE = registerHorsePlushie(ModBlockIds.BROWN_HORSE_PLUSHIE_KEY);
    public static final Block BLACK_HORSE_PLUSHIE = registerHorsePlushie(ModBlockIds.BLACK_HORSE_PLUSHIE_KEY);
    public static final Block MAGMA_CUBE_PLUSHIE = registerCubePlushie(ModBlockIds.MAGMA_CUBE_PLUSHIE_KEY);
    public static final Block RED_MOOSHROOM_PLUSHIE = registerMooshroomPlushie(ModBlockIds.RED_MOOSHROOM_PLUSHIE_KEY);
    public static final Block BROWN_MOOSHROOM_PLUSHIE = registerMooshroomPlushie(ModBlockIds.BROWN_MOOSHROOM_PLUSHIE_KEY);
    public static final Block OCELOT_PLUSHIE = registerCatPlushie(ModBlockIds.OCELOT_PLUSHIE_KEY);
    public static final Block TABBY_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.TABBY_CAT_PLUSHIE_KEY);
    public static final Block TUXEDO_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.TUXEDO_CAT_PLUSHIE_KEY);
    public static final Block RED_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.RED_CAT_PLUSHIE_KEY);
    public static final Block SIAMESE_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.SIAMESE_CAT_PLUSHIE_KEY);
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSHIE
            = registerCatPlushie(ModBlockIds.BRITISH_SHORTHAIR_CAT_PLUSHIE_KEY);
    public static final Block CALICO_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.CALICO_CAT_PLUSHIE_KEY);
    public static final Block PERSIAN_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.PERSIAN_CAT_PLUSHIE_KEY);
    public static final Block RAGDOLL_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.RAGDOLL_CAT_PLUSHIE_KEY);
    public static final Block WHITE_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.WHITE_CAT_PLUSHIE_KEY);
    public static final Block JELLIE_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.JELLIE_CAT_PLUSHIE_KEY);
    public static final Block BLACK_CAT_PLUSHIE = registerCatPlushie(ModBlockIds.BLACK_CAT_PLUSHIE_KEY);
    public static final Block TEMPERATE_PIG_PLUSHIE = registerPigPlushie(ModBlockIds.TEMPERATE_PIG_PLUSHIE_KEY);
    public static final Block COLD_PIG_PLUSHIE = registerPigPlushie(ModBlockIds.COLD_PIG_PLUSHIE_KEY);
    public static final Block WARM_PIG_PLUSHIE = registerPigPlushie(ModBlockIds.WARM_PIG_PLUSHIE_KEY);
    public static final Block BROWN_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.BROWN_RABBIT_PLUSHIE_KEY);
    public static final Block WHITE_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.WHITE_RABBIT_PLUSHIE_KEY);
    public static final Block BLACK_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.BLACK_RABBIT_PLUSHIE_KEY);
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY);
    public static final Block GOLD_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.GOLD_RABBIT_PLUSHIE_KEY);
    public static final Block TOAST_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.TOAST_RABBIT_PLUSHIE_KEY);
    public static final Block SALT_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.SALT_RABBIT_PLUSHIE_KEY);
    public static final ColorCollection<Block> DYED_SHEEP_PLUSHIES
            = ColorCollection.registerBlocks(ModBlockIds.DYED_SHEEP_KEYS, ModBlocks::register, SheepPlushieBlock::new,
            (color) -> makePlushieSettings());
    public static final Block SKELETON_PLUSHIE
            = register(ModBlockIds.SKELETON_PLUSHIE_KEY, SkeletonPlushieBlock::new, makePlushieSettings());
    public static final Block SLIME_PLUSHIE = registerCubePlushie(ModBlockIds.SLIME_PLUSHIE_KEY);
    public static final Block SPIDER_PLUSHIE
            = register(ModBlockIds.SPIDER_PLUSHIE_KEY, SpiderPlushieBlock::new, makePlushieSettings());
    public static final Block SQUID_PLUSHIE
            = register(ModBlockIds.SQUID_PLUSHIE_KEY, SquidPlushieBlock::new, makePlushieSettings());
    public static final Block GLOW_SQUID_PLUSHIE
            = register(ModBlockIds.GLOW_SQUID_PLUSHIE_KEY, SquidPlushieBlock::new, makeGlowingPlushieSettings());
    public static final Block BEE_PLUSHIE
            = register(ModBlockIds.BEE_PLUSHIE_KEY, BeePlushieBlock::new, makePlushieSettings());
    public static final Block PLAINS_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.PLAINS_VILLAGER_PLUSHIE_KEY);
    public static final Block DESERT_VILLAGER_PLUSHIE
            = register(ModBlockIds.DESERT_VILLAGER_PLUSHIE_KEY, DesertVillagerPlushieBlock::new, makePlushieSettings());
    public static final Block JUNGLE_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.JUNGLE_VILLAGER_PLUSHIE_KEY);
    public static final Block SAVANNA_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.SAVANNA_VILLAGER_PLUSHIE_KEY);
    public static final Block SNOWY_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(ModBlockIds.SNOWY_VILLAGER_PLUSHIE_KEY);
    public static final Block SWAMP_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(ModBlockIds.SWAMP_VILLAGER_PLUSHIE_KEY);
    public static final Block TAIGA_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.TAIGA_VILLAGER_PLUSHIE_KEY);
    public static final Block WITCH_PLUSHIE
            = register(ModBlockIds.WITCH_PLUSHIE_KEY, WitchPlushieBlock::new, makePlushieSettings());
    public static final Block PALE_WOLF_PLUSHIE = registerWolfPlushie(ModBlockIds.PALE_WOLF_PLUSHIE_KEY);
    public static final Block ZOMBIE_PLUSHIE = registerZombiePlushie(ModBlockIds.ZOMBIE_PLUSHIE_KEY);
    public static final Block PIGLIN_PLUSHIE
            = register(ModBlockIds.PIGLIN_PLUSHIE_KEY, PiglinPlushieBlock::new, makePlushieSettings());
    public static final Block ZOMBIFIED_PIGLIN_PLUSHIE = registerZombiePlushie(ModBlockIds.ZOMBIFIED_PIGLIN_PLUSHIE_KEY);
    public static final Block PUFFERFISH_PLUSHIE
            = register(ModBlockIds.PUFFERFISH_PLUSHIE_KEY, PufferfishPlushieBlock::new, makePlushieSettings());
    public static final Block WITHER_PLUSHIE
            = register(ModBlockIds.WITHER_PLUSHIE_KEY, WitherPlushieBlock::new, makePlushieSettings());
    public static final Block STRIDER_PLUSHIE = registerStriderPlushie(ModBlockIds.STRIDER_PLUSHIE_KEY);
    public static final Block SHIVERING_STRIDER_PLUSHIE = registerStriderPlushie(ModBlockIds.SHIVERING_STRIDER_PLUSHIE_KEY);
    public static final Block PHANTOM_PLUSHIE
            = register(ModBlockIds.PHANTOM_PLUSHIE_KEY, PhantomPlushieBlock::new, makePlushieSettings());
    public static final Block HOGLIN_PLUSHIE = registerHoglinPlushie(ModBlockIds.HOGLIN_PLUSHIE_KEY);
    public static final Block ZOGLIN_PLUSHIE = registerHoglinPlushie(ModBlockIds.ZOGLIN_PLUSHIE_KEY);
    public static final Block ALLAY_PLUSHIE = registerAllayPlushie(ModBlockIds.ALLAY_PLUSHIE_KEY);
    public static final Block PILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.PILLAGER_PLUSHIE_KEY);
    public static final Block VINDICATOR_PLUSHIE = registerVillagerPlushie(ModBlockIds.VINDICATOR_PLUSHIE_KEY);
    public static final Block EVOKER_PLUSHIE = registerVillagerPlushie(ModBlockIds.EVOKER_PLUSHIE_KEY);
    public static final Block SHULKER_PLUSHIE
            = register(ModBlockIds.SHULKER_PLUSHIE_KEY, ShulkerPlushieBlock::new, makePlushieSettings());
    public static final Block VEX_PLUSHIE = registerAllayPlushie(ModBlockIds.VEX_PLUSHIE_KEY);
    public static final Block CAMEL_PLUSHIE
            = register(ModBlockIds.CAMEL_PLUSHIE_KEY, CamelPlushieBlock::new, makePlushieSettings());
    public static final Block NETHER_SMOKY_QUARTZ_ORE = registerNetherSmokyQuartzOre();
    public static final Block SMOKY_QUARTZ_BLOCK
            = register(ModBlockIds.SMOKY_QUARTZ_BLOCK_KEY, Block::new, makeSmokyQuartzSettings());
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK
            = register(ModBlockIds.CHISELED_SMOKY_QUARTZ_BLOCK_KEY, Block::new, makeSmokyQuartzSettings());
    public static final Block SMOKY_QUARTZ_BRICKS
            = register(ModBlockIds.SMOKY_QUARTZ_BRICKS_KEY, Block::new, makeSmokyQuartzSettings());
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS
            = registerStairs(ModBlockIds.SMOKY_QUARTZ_BRICK_STAIRS_KEY, makeSmokyQuartzSettings(), SMOKY_QUARTZ_BRICKS);
    public static final Block SMOKY_QUARTZ_BRICK_SLAB
            = registerSlab(ModBlockIds.SMOKY_QUARTZ_BRICK_SLAB_KEY, makeSmokyQuartzSettings());
    public static final Block SMOKY_QUARTZ_BRICK_WALL
            = registerWall(ModBlockIds.SMOKY_QUARTZ_BRICK_WALL_KEY, makeSmokyQuartzSettings());
    public static final Block SMOKY_QUARTZ_PILLAR
            = register(ModBlockIds.SMOKY_QUARTZ_PILLAR_KEY, RotatedPillarBlock::new, makeSmokyQuartzSettings());
    public static final Block SMOKY_QUARTZ_STAIRS
            = registerStairs(ModBlockIds.SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(), SMOKY_QUARTZ_BLOCK);
    public static final Block SMOKY_QUARTZ_SLAB
            = registerSlab(ModBlockIds.SMOKY_QUARTZ_SLAB_KEY, makeSmokyQuartzSettings());
    public static final Block SMOKY_QUARTZ_WALL
            = registerWall(ModBlockIds.SMOKY_QUARTZ_WALL_KEY, makeSmokyQuartzSettings());
    public static final Block SMOOTH_SMOKY_QUARTZ
            = register(ModBlockIds.SMOOTH_SMOKY_QUARTZ_KEY, Block::new, makeSmokyQuartzSettings());
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS
            = registerStairs(ModBlockIds.SMOOTH_SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(), SMOOTH_SMOKY_QUARTZ);
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB
            = registerSlab(ModBlockIds.SMOOTH_SMOKY_QUARTZ_SLAB_KEY, makeSmokyQuartzSettings());
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL
            = registerWall(ModBlockIds.SMOOTH_SMOKY_QUARTZ_WALL_KEY, makeSmokyQuartzSettings());
    public static final Block CRACKED_STONE_BRICK_STAIRS
            = registerStairs(ModBlockIds.CRACKED_STONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS), Blocks.CRACKED_STONE_BRICKS);
    public static final Block CRACKED_STONE_BRICK_SLAB = registerSlab(ModBlockIds.CRACKED_STONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block CRACKED_STONE_BRICK_WALL = registerWall(ModBlockIds.CRACKED_STONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS));
    public static final Block BLUEBERRY_BUSH = registerBlueberryBush();
    public static final Block GREEN_ONIONS = registerGreenOnions();
    public static final Block OAK_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.OAK_PLANTER_BOX_KEY, Blocks.OAK_PLANKS.defaultMapColor(), SoundType.WOOD);
    public static final Block SPRUCE_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.SPRUCE_PLANTER_BOX_KEY, Blocks.SPRUCE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final Block BIRCH_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.BIRCH_PLANTER_BOX_KEY, Blocks.BIRCH_PLANKS.defaultMapColor(), SoundType.WOOD);
    public static final Block JUNGLE_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.JUNGLE_PLANTER_BOX_KEY, Blocks.JUNGLE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final Block ACACIA_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.ACACIA_PLANTER_BOX_KEY, Blocks.ACACIA_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final Block DARK_OAK_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.DARK_OAK_PLANTER_BOX_KEY, Blocks.DARK_OAK_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final Block MANGROVE_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.MANGROVE_PLANTER_BOX_KEY, Blocks.MANGROVE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final Block CHERRY_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.CHERRY_PLANTER_BOX_KEY, Blocks.CHERRY_PLANKS.defaultMapColor(),
            SoundType.CHERRY_WOOD);
    public static final Block PALE_OAK_PLANTER_BOX
            = registerPlanterBox(ModBlockIds.PALE_OAK_PLANTER_BOX_KEY, Blocks.PALE_OAK_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final Block CRIMSON_PLANTER_BOX
            = registerNetherPlanterBox(ModBlockIds.CRIMSON_PLANTER_BOX_KEY, Blocks.CRIMSON_PLANKS.defaultMapColor());
    public static final Block WARPED_PLANTER_BOX
            = registerNetherPlanterBox(ModBlockIds.WARPED_PLANTER_BOX_KEY, Blocks.WARPED_PLANKS.defaultMapColor());
    public static final Block OAK_WALL
            = registerWall(ModBlockIds.OAK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final Block SPRUCE_WALL
            = registerWall(ModBlockIds.SPRUCE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final Block BIRCH_WALL
            = registerWall(ModBlockIds.BIRCH_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
    public static final Block JUNGLE_WALL
            = registerWall(ModBlockIds.JUNGLE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
    public static final Block ACACIA_WALL
            = registerWall(ModBlockIds.ACACIA_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
    public static final Block DARK_OAK_WALL
            = registerWall(ModBlockIds.DARK_OAK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
    public static final Block MANGROVE_WALL
            = registerWall(ModBlockIds.MANGROVE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));
    public static final Block CRIMSON_WALL
            = registerWall(ModBlockIds.CRIMSON_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
    public static final Block WARPED_WALL
            = registerWall(ModBlockIds.WARPED_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));
    public static final Block CHERRY_WALL
            = registerWall(ModBlockIds.CHERRY_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS));
    public static final Block STRIPPED_OAK_WALL
            = registerWall(ModBlockIds.STRIPPED_OAK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final Block STRIPPED_SPRUCE_WALL
            = registerWall(ModBlockIds.STRIPPED_SPRUCE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final Block STRIPPED_BIRCH_WALL
            = registerWall(ModBlockIds.STRIPPED_BIRCH_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS));
    public static final Block STRIPPED_JUNGLE_WALL
            = registerWall(ModBlockIds.STRIPPED_JUNGLE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS));
    public static final Block STRIPPED_ACACIA_WALL
            = registerWall(ModBlockIds.STRIPPED_ACACIA_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS));
    public static final Block STRIPPED_DARK_OAK_WALL
            = registerWall(ModBlockIds.STRIPPED_DARK_OAK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS));
    public static final Block STRIPPED_MANGROVE_WALL
            = registerWall(ModBlockIds.STRIPPED_MANGROVE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));
    public static final Block STRIPPED_CRIMSON_WALL
            = registerWall(ModBlockIds.STRIPPED_CRIMSON_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS));
    public static final Block STRIPPED_WARPED_WALL
            = registerWall(ModBlockIds.STRIPPED_WARPED_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));
    public static final Block STRIPPED_CHERRY_WALL
            = registerWall(ModBlockIds.STRIPPED_CHERRY_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS));
    public static final Block OAK_ROPE_LADDER = registerRopeLadder(ModBlockIds.OAK_ROPE_LADDER_KEY);
    public static final Block SPRUCE_ROPE_LADDER = registerRopeLadder(ModBlockIds.SPRUCE_ROPE_LADDER_KEY);
    public static final Block BIRCH_ROPE_LADDER = registerRopeLadder(ModBlockIds.BIRCH_ROPE_LADDER_KEY);
    public static final Block JUNGLE_ROPE_LADDER = registerRopeLadder(ModBlockIds.JUNGLE_ROPE_LADDER_KEY);
    public static final Block ACACIA_ROPE_LADDER = registerRopeLadder(ModBlockIds.ACACIA_ROPE_LADDER_KEY);
    public static final Block DARK_OAK_ROPE_LADDER = registerRopeLadder(ModBlockIds.DARK_OAK_ROPE_LADDER_KEY);
    public static final Block CRIMSON_ROPE_LADDER = registerRopeLadder(ModBlockIds.CRIMSON_ROPE_LADDER_KEY);
    public static final Block WARPED_ROPE_LADDER = registerRopeLadder(ModBlockIds.WARPED_ROPE_LADDER_KEY);
    public static final Block MANGROVE_ROPE_LADDER = registerRopeLadder(ModBlockIds.MANGROVE_ROPE_LADDER_KEY);
    public static final Block CHERRY_ROPE_LADDER = registerRopeLadder(ModBlockIds.CHERRY_ROPE_LADDER_KEY);
    public static final Block PALE_OAK_ROPE_LADDER = registerRopeLadder(ModBlockIds.PALE_OAK_ROPE_LADDER_KEY);
    public static final Block IRON_LADDER = registerIronLadder();
    public static final Block SNOW_BRICKS = register(ModBlockIds.SNOW_BRICKS_KEY, Block::new, makeSnowBrickSettings());
    public static final Block SNOW_BRICK_STAIRS
            = registerStairs(ModBlockIds.SNOW_BRICK_STAIRS_KEY, makeSnowBrickSettings(), SNOW_BRICKS);
    public static final Block SNOW_BRICK_SLAB
            = registerSlab(ModBlockIds.SNOW_BRICK_SLAB_KEY, makeSnowBrickSettings());
    public static final Block SNOW_BRICK_WALL
            = registerWall(ModBlockIds.SNOW_BRICK_WALL_KEY, makeSnowBrickSettings());
    public static final Block PACKED_SNOW
            = register(ModBlockIds.PACKED_SNOW_KEY, Block::new, makePackedSnowSettings());
    public static final Block PACKED_SNOW_STAIRS
            = registerStairs(ModBlockIds.PACKED_SNOW_STAIRS_KEY, makePackedSnowSettings(), PACKED_SNOW);
    public static final Block PACKED_SNOW_SLAB
            = registerSlab(ModBlockIds.PACKED_SNOW_SLAB_KEY, makePackedSnowSettings());
    public static final Block PACKED_SNOW_WALL
            = registerWall(ModBlockIds.PACKED_SNOW_WALL_KEY, makePackedSnowSettings());
    public static final Block PURPLE_MUSHROOM
            = register(ModBlockIds.PURPLE_MUSHROOM_KEY,
            (props) -> new MushroomBlock(ModTreeConfiguredFeatures.HUGE_PURPLE_MUSHROOM, props),
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .pushReaction(PushReaction.DESTROY).noCollision().randomTicks().instabreak()
                    .sound(SoundType.GRASS).postProcess(ModBlocks::postProcessSelf));
    public static final Block PURPLE_MUSHROOM_BLOCK
            = register(ModBlockIds.PURPLE_MUSHROOM_BLOCK_KEY, PurpleMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.BASS).strength(0.2F)
                    .sound(SoundType.WOOD).ignitedByLava());
    public static final Block WHITE_CAMPFIRE
            = registerDyedCampfire(ModBlockIds.WHITE_CAMPFIRE_KEY, ModParticleTypes.WHITE_EMBER);
    public static final Block ORANGE_CAMPFIRE
            = registerDyedCampfire(ModBlockIds.ORANGE_CAMPFIRE_KEY, ModParticleTypes.ORANGE_EMBER);
    public static final Block MAGENTA_CAMPFIRE
            = registerDyedCampfire(ModBlockIds.MAGENTA_CAMPFIRE_KEY, ModParticleTypes.MAGENTA_EMBER);
    public static final Block LIGHT_BLUE_CAMPFIRE
            = registerDyedCampfire(ModBlockIds.LIGHT_BLUE_CAMPFIRE_KEY, ModParticleTypes.LIGHT_BLUE_EMBER);
    public static final Block YELLOW_CAMPFIRE
            = registerDyedCampfire(ModBlockIds.YELLOW_CAMPFIRE_KEY, ModParticleTypes.YELLOW_EMBER);
    public static final Block LIME_CAMPFIRE = registerDyedCampfire(ModBlockIds.LIME_CAMPFIRE_KEY, ModParticleTypes.LIME_EMBER);
    public static final Block PINK_CAMPFIRE = registerDyedCampfire(ModBlockIds.PINK_CAMPFIRE_KEY, ModParticleTypes.PINK_EMBER);
    public static final Block GRAY_CAMPFIRE = registerDyedCampfire(ModBlockIds.GRAY_CAMPFIRE_KEY, ModParticleTypes.GRAY_EMBER);
    public static final Block LIGHT_GRAY_CAMPFIRE
            = registerDyedCampfire(ModBlockIds.LIGHT_GRAY_CAMPFIRE_KEY, ModParticleTypes.LIGHT_GRAY_EMBER);
    public static final Block CYAN_CAMPFIRE = registerDyedCampfire(ModBlockIds.CYAN_CAMPFIRE_KEY, ModParticleTypes.CYAN_EMBER);
    public static final Block PURPLE_CAMPFIRE = registerDyedCampfire(ModBlockIds.PURPLE_CAMPFIRE_KEY, ModParticleTypes.PURPLE_EMBER);
    public static final Block BLUE_CAMPFIRE = registerDyedCampfire(ModBlockIds.BLUE_CAMPFIRE_KEY, ModParticleTypes.BLUE_EMBER);
    public static final Block BROWN_CAMPFIRE = registerDyedCampfire(ModBlockIds.BROWN_CAMPFIRE_KEY, ModParticleTypes.BROWN_EMBER);
    public static final Block GREEN_CAMPFIRE = registerDyedCampfire(ModBlockIds.GREEN_CAMPFIRE_KEY, ModParticleTypes.GREEN_EMBER);
    public static final Block RED_CAMPFIRE = registerDyedCampfire(ModBlockIds.RED_CAMPFIRE_KEY, ModParticleTypes.RED_EMBER);
    public static final Block BLACK_CAMPFIRE = registerDyedCampfire(ModBlockIds.BLACK_CAMPFIRE_KEY, ModParticleTypes.BLACK_EMBER);
    public static final ColorCollection<Block> DYED_LANTERNS = ColorCollection.registerBlocks(ModBlockIds.DYED_LANTERN_KEYS,
            ModBlocks::register, (s, p) -> new LanternBlock(p),
            (color) -> BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN));
    public static final Block WHITE_TORCH = registerTorch(ModBlockIds.WHITE_TORCH_KEY, ModParticleTypes.WHITE_FLAME);
    public static final Block ORANGE_TORCH = registerTorch(ModBlockIds.ORANGE_TORCH_KEY, ModParticleTypes.ORANGE_FLAME);
    public static final Block MAGENTA_TORCH = registerTorch(ModBlockIds.MAGENTA_TORCH_KEY, ModParticleTypes.MAGENTA_FLAME);
    public static final Block LIGHT_BLUE_TORCH = registerTorch(ModBlockIds.LIGHT_BLUE_TORCH_KEY, ModParticleTypes.LIGHT_BLUE_FLAME);
    public static final Block YELLOW_TORCH = registerTorch(ModBlockIds.YELLOW_TORCH_KEY, ModParticleTypes.YELLOW_FLAME);
    public static final Block LIME_TORCH = registerTorch(ModBlockIds.LIME_TORCH_KEY, ModParticleTypes.LIME_FLAME);
    public static final Block PINK_TORCH = registerTorch(ModBlockIds.PINK_TORCH_KEY, ModParticleTypes.PINK_FLAME);
    public static final Block GRAY_TORCH = registerTorch(ModBlockIds.GRAY_TORCH_KEY, ModParticleTypes.GRAY_FLAME);
    public static final Block LIGHT_GRAY_TORCH = registerTorch(ModBlockIds.LIGHT_GRAY_TORCH_KEY, ModParticleTypes.LIGHT_GRAY_FLAME);
    public static final Block CYAN_TORCH = registerTorch(ModBlockIds.CYAN_TORCH_KEY, ModParticleTypes.CYAN_FLAME);
    public static final Block PURPLE_TORCH = registerTorch(ModBlockIds.PURPLE_TORCH_KEY, ModParticleTypes.PURPLE_FLAME);
    public static final Block BLUE_TORCH = registerTorch(ModBlockIds.BLUE_TORCH_KEY, ModParticleTypes.BLUE_FLAME);
    public static final Block BROWN_TORCH = registerTorch(ModBlockIds.BROWN_TORCH_KEY, ModParticleTypes.BROWN_FLAME);
    public static final Block GREEN_TORCH = registerTorch(ModBlockIds.GREEN_TORCH_KEY, ModParticleTypes.GREEN_FLAME);
    public static final Block RED_TORCH = registerTorch(ModBlockIds.RED_TORCH_KEY, ModParticleTypes.RED_FLAME);
    public static final Block BLACK_TORCH = registerTorch(ModBlockIds.BLACK_TORCH_KEY, ModParticleTypes.BLACK_FLAME);
    public static final Block WHITE_WALL_TORCH = registerWallTorch(ModBlockIds.WHITE_WALL_TORCH_KEY, WHITE_TORCH, ModParticleTypes.WHITE_FLAME);
    public static final Block ORANGE_WALL_TORCH = registerWallTorch(ModBlockIds.ORANGE_WALL_TORCH_KEY, ORANGE_TORCH, ModParticleTypes.ORANGE_FLAME);
    public static final Block MAGENTA_WALL_TORCH = registerWallTorch(ModBlockIds.MAGENTA_WALL_TORCH_KEY, MAGENTA_TORCH, ModParticleTypes.MAGENTA_FLAME);
    public static final Block LIGHT_BLUE_WALL_TORCH = registerWallTorch(ModBlockIds.LIGHT_BLUE_WALL_TORCH_KEY, LIGHT_BLUE_TORCH, ModParticleTypes.LIGHT_BLUE_FLAME);
    public static final Block YELLOW_WALL_TORCH = registerWallTorch(ModBlockIds.YELLOW_WALL_TORCH_KEY, YELLOW_TORCH, ModParticleTypes.YELLOW_FLAME);
    public static final Block LIME_WALL_TORCH = registerWallTorch(ModBlockIds.LIME_WALL_TORCH_KEY, LIME_TORCH, ModParticleTypes.LIME_FLAME);
    public static final Block PINK_WALL_TORCH = registerWallTorch(ModBlockIds.PINK_WALL_TORCH_KEY, PINK_TORCH, ModParticleTypes.PINK_FLAME);
    public static final Block GRAY_WALL_TORCH = registerWallTorch(ModBlockIds.GRAY_WALL_TORCH_KEY, GRAY_TORCH, ModParticleTypes.GRAY_FLAME);
    public static final Block LIGHT_GRAY_WALL_TORCH = registerWallTorch(ModBlockIds.LIGHT_GRAY_WALL_TORCH_KEY, LIGHT_GRAY_TORCH, ModParticleTypes.LIGHT_GRAY_FLAME);
    public static final Block CYAN_WALL_TORCH = registerWallTorch(ModBlockIds.CYAN_WALL_TORCH_KEY, CYAN_TORCH, ModParticleTypes.CYAN_FLAME);
    public static final Block PURPLE_WALL_TORCH = registerWallTorch(ModBlockIds.PURPLE_WALL_TORCH_KEY, PURPLE_TORCH, ModParticleTypes.PURPLE_FLAME);
    public static final Block BLUE_WALL_TORCH = registerWallTorch(ModBlockIds.BLUE_WALL_TORCH_KEY, BLUE_TORCH, ModParticleTypes.BLUE_FLAME);
    public static final Block BROWN_WALL_TORCH = registerWallTorch(ModBlockIds.BROWN_WALL_TORCH_KEY, BROWN_TORCH, ModParticleTypes.BROWN_FLAME);
    public static final Block GREEN_WALL_TORCH = registerWallTorch(ModBlockIds.GREEN_WALL_TORCH_KEY, GREEN_TORCH, ModParticleTypes.GREEN_FLAME);
    public static final Block RED_WALL_TORCH = registerWallTorch(ModBlockIds.RED_WALL_TORCH_KEY, RED_TORCH, ModParticleTypes.RED_FLAME);
    public static final Block BLACK_WALL_TORCH = registerWallTorch(ModBlockIds.BLACK_WALL_TORCH_KEY, BLACK_TORCH, ModParticleTypes.BLACK_FLAME);
    public static final Block WITCHS_CRADLE
            = registerWithoutItemBlock(ModBlockIds.WITCHS_CRADLE_KEY, WitchsCradleBlock::new, BlockBehaviour.Properties
            .ofFullCopy(Blocks.SWEET_BERRY_BUSH).lightLevel((state) -> 8));
    public static final Block BAUXITE = register(ModBlockIds.BAUXITE_KEY, Block::new, makeBauxiteSettings());
    public static final Block BAUXITE_SLAB = registerSlab(ModBlockIds.BAUXITE_SLAB_KEY, makeBauxiteSettings());
    public static final Block BAUXITE_STAIRS
            = registerStairs(ModBlockIds.BAUXITE_STAIRS_KEY, makeBauxiteSettings(), BAUXITE);
    public static final Block BAUXITE_WALL = registerWall(ModBlockIds.BAUXITE_WALL_KEY, makeBauxiteSettings());
    public static final Block BAUXITE_BRICKS
            = register(ModBlockIds.BAUXITE_BRICKS_KEY, Block::new, makeBauxiteBricksSettings());
    public static final Block BAUXITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(), BAUXITE_BRICKS);
    public static final Block BAUXITE_BRICK_SLAB
            = registerSlab(ModBlockIds.BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings());
    public static final Block BAUXITE_BRICK_WALL
            = registerWall(ModBlockIds.BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings());
    public static final Block MOSSY_BAUXITE_BRICKS
            = register(ModBlockIds.MOSSY_BAUXITE_BRICKS_KEY, Block::new, makeBauxiteBricksSettings());
    public static final Block MOSSY_BAUXITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.MOSSY_BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(),
            MOSSY_BAUXITE_BRICKS);
    public static final Block MOSSY_BAUXITE_BRICK_SLAB
            = registerSlab(ModBlockIds.MOSSY_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings());
    public static final Block MOSSY_BAUXITE_BRICK_WALL
            = registerWall(ModBlockIds.MOSSY_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings());
    public static final Block CRACKED_BAUXITE_BRICKS
            = register(ModBlockIds.CRACKED_BAUXITE_BRICKS_KEY, Block::new, makeBauxiteBricksSettings());
    public static final Block CRACKED_BAUXITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.CRACKED_BAUXITE_BRICK_STAIRS_KEY,
            makeBauxiteBricksSettings(), CRACKED_BAUXITE_BRICKS);
    public static final Block CRACKED_BAUXITE_BRICK_SLAB
            = registerSlab(ModBlockIds.CRACKED_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings());
    public static final Block CRACKED_BAUXITE_BRICK_WALL
            = registerWall(ModBlockIds.CRACKED_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings());
    public static final Block TWISTED_NETHER_BRICKS
            = register(ModBlockIds.TWISTED_NETHER_BRICKS_KEY, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_STAIRS
            = registerStairs(ModBlockIds.TWISTED_NETHER_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS), TWISTED_NETHER_BRICKS);
    public static final Block TWISTED_NETHER_BRICK_SLAB
            = registerSlab(ModBlockIds.TWISTED_NETHER_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final Block TWISTED_NETHER_BRICK_WALL
            = registerWall(ModBlockIds.TWISTED_NETHER_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final Block TWISTED_NETHERRACK = register(ModBlockIds.TWISTED_NETHERRACK_KEY,  Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block TWISTED_NETHERRACK_STAIRS
            = registerStairs(ModBlockIds.TWISTED_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK), TWISTED_NETHERRACK);
    public static final Block TWISTED_NETHERRACK_SLAB
            = registerSlab(ModBlockIds.TWISTED_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block TWISTED_NETHERRACK_WALL
            = registerWall(ModBlockIds.TWISTED_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block WEEPING_NETHER_BRICKS = register(ModBlockIds.WEEPING_NETHER_BRICKS_KEY, Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_STAIRS
            = registerStairs(ModBlockIds.WEEPING_NETHER_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS), WEEPING_NETHER_BRICKS);
    public static final Block WEEPING_NETHER_BRICK_SLAB
            = registerSlab(ModBlockIds.WEEPING_NETHER_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final Block WEEPING_NETHER_BRICK_WALL
            = registerWall(ModBlockIds.WEEPING_NETHER_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final Block WEEPING_NETHERRACK
            = register(ModBlockIds.WEEPING_NETHERRACK_KEY, Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block WEEPING_NETHERRACK_STAIRS
            = registerStairs(ModBlockIds.WEEPING_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK), WEEPING_NETHERRACK);
    public static final Block WEEPING_NETHERRACK_SLAB
            = registerSlab(ModBlockIds.WEEPING_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block WEEPING_NETHERRACK_WALL
            = registerWall(ModBlockIds.WEEPING_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final Block SNAPDRAGON = register(ModBlockIds.SNAPDRAGON_KEY,
            (props) -> new SnapdragonBlock(MobEffects.LUCK, 8, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).lightLevel((state) -> 8));
    public static final Block POTTED_SNAPDRAGON = registerPottedSnapdragon();
    public static final Block POTTED_PURPLE_MUSHROOM = register(ModBlockIds.POTTED_PURPLE_MUSHROOM_KEY,
            (props) -> new FlowerPotBlock(ModBlocks.PURPLE_MUSHROOM, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM));
    public static final Block SHORT_ENDER_GRASS
        = register(ModBlockIds.SHORT_ENDER_GRASS_KEY, ShortEnderGrassBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).lightLevel((state) -> 8));
    public static final Block CATTAIL = register(ModBlockIds.CATTAIL_KEY, CattailBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollision()
                    .noOcclusion().sound(SoundType.WET_GRASS));
    public static final Block CHOCOLATE_CAKE = registerCake(ModBlockIds.CHOCOLATE_CAKE_KEY);
    public static final Block RED_VELVET_CAKE = registerCake(ModBlockIds.RED_VELVET_CAKE_KEY);
    public static final Block CANDLE_CHOCOLATE_CAKE = registerChocolateCandleCake();
    public static final ColorCollection<Block> DYED_CHOCOLATE_CAKE = ColorCollection.registerBlocks(ModBlockIds.DYED_CANDLE_CHOCOLATE_CAKE_KEYS,
            ModBlocks::registerCandleCake, (s, p) -> new ModdedCandleCakeBlock(ModBlocks.CHOCOLATE_CAKE, Blocks.DYED_CANDLE.pick(s), p),
            (var0) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));
    public static final Block CANDLE_RED_VELVET_CAKE = registerRedVelvetCandleCake();
    public static final ColorCollection<Block> DYED_RED_VELVET_CAKE = ColorCollection.registerBlocks(ModBlockIds.DYED_CANDLE_RED_VELVET_CAKE_KEYS,
            ModBlocks::registerCandleCake, (s, p) -> new ModdedCandleCakeBlock(ModBlocks.RED_VELVET_CAKE, Blocks.DYED_CANDLE.pick(s), p),
            (var0) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));
    public static final Block STONE_TILES
            = register(ModBlockIds.STONE_TILES_KEY, Block::new, makeStoneTileSettings());
    public static final Block STONE_TILE_SLAB
            = registerSlab(ModBlockIds.STONE_TILE_SLAB_KEY, makeStoneTileSettings());
    public static final Block STONE_TILE_STAIRS
            = registerStairs(ModBlockIds.STONE_TILE_STAIRS_KEY, makeStoneTileSettings(), STONE_TILES);
    public static final Block STONE_TILE_WALL
            = registerWall(ModBlockIds.STONE_TILE_WALL_KEY, makeStoneTileSettings());
    public static final Block MOSSY_STONE_TILES
            = register(ModBlockIds.MOSSY_STONE_TILES_KEY, Block::new, makeStoneTileSettings());
    public static final Block MOSSY_STONE_TILE_SLAB
            = registerSlab(ModBlockIds.MOSSY_STONE_TILE_SLAB_KEY, makeStoneTileSettings());
    public static final Block MOSSY_STONE_TILE_STAIRS
            = registerStairs(ModBlockIds.MOSSY_STONE_TILE_STAIRS_KEY, makeStoneTileSettings(), MOSSY_STONE_TILES);
    public static final Block MOSSY_STONE_TILE_WALL
            = registerWall(ModBlockIds.MOSSY_STONE_TILE_WALL_KEY, makeStoneTileSettings());
    public static final Block CRACKED_STONE_TILES
            = register(ModBlockIds.CRACKED_STONE_TILES_KEY, Block::new, makeStoneTileSettings());
    public static final Block CRACKED_STONE_TILE_SLAB
            = registerSlab(ModBlockIds.CRACKED_STONE_TILE_SLAB_KEY, makeStoneTileSettings());
    public static final Block CRACKED_STONE_TILE_STAIRS
            = registerStairs(ModBlockIds.CRACKED_STONE_TILE_STAIRS_KEY, makeStoneTileSettings(), CRACKED_STONE_TILES);
    public static final Block CRACKED_STONE_TILE_WALL
            = registerWall(ModBlockIds.CRACKED_STONE_TILE_WALL_KEY, makeStoneTileSettings());
    public static final Block SWEET_BERRY_PIE = registerPie(ModBlockIds.SWEET_BERRY_PIE_KEY);
    public static final Block BLUEBERRY_PIE = registerPie(ModBlockIds.BLUEBERRY_PIE_KEY);
    public static final Block BLACKSTONE_TILES
            = register(ModBlockIds.BLACKSTONE_TILES_KEY, Block::new, makeBlackstoneTileSettings());
    public static final Block BLACKSTONE_TILE_STAIRS
            = registerStairs(ModBlockIds.BLACKSTONE_TILE_STAIRS_KEY, makeBlackstoneTileSettings(), BLACKSTONE_TILES);
    public static final Block BLACKSTONE_TILE_SLAB
            = registerSlab(ModBlockIds.BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings());
    public static final Block BLACKSTONE_TILE_WALL
            = registerWall(ModBlockIds.BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings());
    public static final Block TWISTED_BLACKSTONE_TILES
            = register(ModBlockIds.TWISTED_BLACKSTONE_TILES_KEY, Block::new, makeBlackstoneTileSettings());
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS
            = registerStairs(ModBlockIds.TWISTED_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(), TWISTED_BLACKSTONE_TILES);
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB
            = registerSlab(ModBlockIds.TWISTED_BLACKSTONE_TILE_SLAB_KEY,
            makeBlackstoneTileSettings());
    public static final Block TWISTED_BLACKSTONE_TILE_WALL
            = registerWall(ModBlockIds.TWISTED_BLACKSTONE_TILE_WALL_KEY,
            makeBlackstoneTileSettings());
    public static final Block WEEPING_BLACKSTONE_TILES
            = register(ModBlockIds.WEEPING_BLACKSTONE_TILES_KEY, Block::new, makeBlackstoneTileSettings());
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS = registerStairs(ModBlockIds.WEEPING_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(), WEEPING_BLACKSTONE_TILES);
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB
            = registerSlab(ModBlockIds.WEEPING_BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings());
    public static final Block WEEPING_BLACKSTONE_TILE_WALL
            = registerWall(ModBlockIds.WEEPING_BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings());
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS
            = register(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY, Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS),
            Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS
            = register(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY, Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS),
            WEEPING_POLISHED_BLACKSTONE_BRICKS);
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Block TWISTED_BLACKSTONE
            = register(ModBlockIds.TWISTED_BLACKSTONE_KEY, Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_STAIRS
            = registerStairs(ModBlockIds.TWISTED_BLACKSTONE_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE), Blocks.BLACKSTONE);
    public static final Block TWISTED_BLACKSTONE_SLAB = registerSlab(ModBlockIds.TWISTED_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final Block TWISTED_BLACKSTONE_WALL = registerWall(ModBlockIds.TWISTED_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE
            = register(ModBlockIds.WEEPING_BLACKSTONE_KEY, Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_STAIRS
            = registerStairs(ModBlockIds.WEEPING_BLACKSTONE_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE), WEEPING_BLACKSTONE);
    public static final Block WEEPING_BLACKSTONE_SLAB = registerSlab(ModBlockIds.WEEPING_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final Block WEEPING_BLACKSTONE_WALL = registerWall(ModBlockIds.WEEPING_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final Block QUARTZ_TILES
            = register(ModBlockIds.QUARTZ_TILES_KEY, Block::new, makeQuartzTileSettings());
    public static final Block QUARTZ_TILE_STAIRS
            = registerStairs(ModBlockIds.QUARTZ_TILE_STAIRS_KEY, makeQuartzTileSettings(), QUARTZ_TILES);
    public static final Block QUARTZ_TILE_SLAB
            = registerSlab(ModBlockIds.QUARTZ_TILE_SLAB_KEY, makeQuartzTileSettings());
    public static final Block QUARTZ_TILE_WALL
            = registerWall(ModBlockIds.QUARTZ_TILE_WALL_KEY, makeQuartzTileSettings());
    public static final Block CALCITE_BRICKS = register(ModBlockIds.CALCITE_BRICKS_KEY, Block::new, makeCalciteSettings());
    public static final Block CALCITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.CALCITE_BRICK_STAIRS_KEY, makeCalciteSettings(), CALCITE_BRICKS);
    public static final Block CALCITE_BRICK_SLAB
            = registerSlab(ModBlockIds.CALCITE_BRICK_SLAB_KEY, makeCalciteSettings());
    public static final Block CALCITE_BRICK_WALL
            = registerWall(ModBlockIds.CALCITE_BRICK_WALL_KEY, makeCalciteSettings());
    public static final Block MOSSY_CALCITE_BRICKS
            = register(ModBlockIds.MOSSY_CALCITE_BRICKS_KEY, Block::new, makeCalciteSettings());
    public static final Block MOSSY_CALCITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.MOSSY_CALCITE_BRICK_STAIRS_KEY, makeCalciteSettings(), MOSSY_CALCITE_BRICKS);
    public static final Block MOSSY_CALCITE_BRICK_SLAB
            = registerSlab(ModBlockIds.MOSSY_CALCITE_BRICK_SLAB_KEY, makeCalciteSettings());
    public static final Block MOSSY_CALCITE_BRICK_WALL = registerWall(ModBlockIds.MOSSY_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings());
    public static final Block CRACKED_CALCITE_BRICKS
            = register(ModBlockIds.CRACKED_CALCITE_BRICKS_KEY, Block::new, makeCalciteSettings());
    public static final Block CRACKED_CALCITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.CRACKED_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(), CRACKED_CALCITE_BRICKS);
    public static final Block CRACKED_CALCITE_BRICK_SLAB = registerSlab(ModBlockIds.CRACKED_CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings());
    public static final Block CRACKED_CALCITE_BRICK_WALL = registerWall(ModBlockIds.CRACKED_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings());
    public static final Block CHISELED_CALCITE_BRICKS
            = register(ModBlockIds.CHISELED_CALCITE_BRICKS_KEY, RotatedPillarBlock::new, makeCalciteSettings());
    public static final Block DRIPSTONE_BRICKS
            = register(ModBlockIds.DRIPSTONE_BRICKS_KEY, Block::new, makeDripstoneSettings());
    public static final Block DRIPSTONE_BRICK_STAIRS = registerStairs(ModBlockIds.DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(), DRIPSTONE_BRICKS);
    public static final Block DRIPSTONE_BRICK_SLAB = registerSlab(ModBlockIds.DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings());
    public static final Block DRIPSTONE_BRICK_WALL = registerWall(ModBlockIds.DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings());
    public static final Block MOSSY_DRIPSTONE_BRICKS
            = register(ModBlockIds.MOSSY_DRIPSTONE_BRICKS_KEY, Block::new, makeDripstoneSettings());
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS = registerStairs(ModBlockIds.MOSSY_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(), MOSSY_DRIPSTONE_BRICKS);
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB = registerSlab(ModBlockIds.MOSSY_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings());
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL = registerWall(ModBlockIds.MOSSY_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings());
    public static final Block CRACKED_DRIPSTONE_BRICKS
            = register(ModBlockIds.CRACKED_DRIPSTONE_BRICKS_KEY, Block::new, makeDripstoneSettings());
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = registerStairs(ModBlockIds.CRACKED_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(), CRACKED_DRIPSTONE_BRICKS);
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = registerSlab(ModBlockIds.CRACKED_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings());
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL = registerWall(ModBlockIds.CRACKED_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings());
    public static final Block CHISELED_DRIPSTONE_BRICKS
            = register(ModBlockIds.CHISELED_DRIPSTONE_BRICKS_KEY, Block::new, makeDripstoneSettings());
    public static final Block BLOOD_KELP
            = registerWithoutItemBlock(ModBlockIds.BLOOD_KELP_KEY, BloodKelpBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.KELP)
            .lightLevel(getLuminanceFromState()));
    public static final Block BLOOD_KELP_PLANT
            = registerWithoutItemBlock(ModBlockIds.BLOOD_KELP_PLANT_KEY, BloodKelpPlantBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT)
            .lightLevel(getLuminanceFromState()));
    public static final Block DRIED_BLOOD_KELP_BLOCK
            = register(ModBlockIds.DRIED_BLOOD_KELP_BLOCK_KEY, Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DRIED_KELP_BLOCK));
    public static final Block BLOOD_KELP_LANTERN
            = register(ModBlockIds.BLOOD_KELP_LANTERN_KEY, RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.3F)
                    .sound(SoundType.GLASS).lightLevel((state) -> 15));
    public static final Block BOG_BLOSSOM = register(ModBlockIds.BOG_BLOSSOM_KEY, BogBlossomBlock::new, BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).instabreak().noCollision().sound(SoundType.SPORE_BLOSSOM)
            .pushReaction(PushReaction.DESTROY).lightLevel((state) -> 5));
    public static final Block CINDERSNAP_BERRY_BUSH
            = registerWithoutItemBlock(ModBlockIds.CINDERSNAP_BERRY_BUSH_KEY, CindersnapBerryBushBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
            .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> 8));
    public static final Block FROSTBITE_BERRY_BUSH
            = registerWithoutItemBlock(ModBlockIds.FROSTBITE_BERRY_BUSH_KEY, FrostbiteBerryBushBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
            .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> 5));
    public static final Block POLISHED_DRIPSTONE
            = register(ModBlockIds.POLISHED_DRIPSTONE_KEY, Block::new, makeDripstoneSettings());
    public static final Block POLISHED_DRIPSTONE_STAIRS = registerStairs(ModBlockIds.POLISHED_DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(), POLISHED_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_SLAB
            = registerSlab(ModBlockIds.POLISHED_DRIPSTONE_SLAB_KEY, makeDripstoneSettings());
    public static final Block POLISHED_DRIPSTONE_WALL = registerWall(ModBlockIds.POLISHED_DRIPSTONE_WALL_KEY,
            makeDripstoneSettings());
    public static final Block POLISHED_CALCITE
            = register(ModBlockIds.POLISHED_CALCITE_KEY, Block::new, makeCalciteSettings());
    public static final Block POLISHED_CALCITE_STAIRS = registerStairs(ModBlockIds.POLISHED_CALCITE_STAIRS_KEY,
            makeCalciteSettings(), POLISHED_CALCITE);
    public static final Block POLISHED_CALCITE_SLAB = registerSlab(ModBlockIds.POLISHED_CALCITE_SLAB_KEY,
            makeCalciteSettings());
    public static final Block POLISHED_CALCITE_WALL = registerWall(ModBlockIds.POLISHED_CALCITE_WALL_KEY,
            makeCalciteSettings());
    public static final Block DRIPSTONE_STAIRS = registerStairs(ModBlockIds.DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(), Blocks.DRIPSTONE_BLOCK);
    public static final Block DRIPSTONE_SLAB = registerSlab(ModBlockIds.DRIPSTONE_SLAB_KEY,
            makeDripstoneSettings());
    public static final Block DRIPSTONE_WALL
            = registerWall(ModBlockIds.DRIPSTONE_WALL_KEY, makeDripstoneSettings());
    public static final Block CALCITE_STAIRS
            = registerStairs(ModBlockIds.CALCITE_STAIRS_KEY, makeCalciteSettings(), Blocks.CALCITE);
    public static final Block CALCITE_SLAB
            = registerSlab(ModBlockIds.CALCITE_SLAB_KEY, makeCalciteSettings());
    public static final Block CALCITE_WALL
            = registerWall(ModBlockIds.CALCITE_WALL_KEY, makeCalciteSettings());
    public static final Block BAMBOO_PLANTER_BOX = registerPlanterBox(ModBlockIds.BAMBOO_PLANTER_BOX_KEY,
            Blocks.BAMBOO_PLANKS.defaultMapColor(), SoundType.BAMBOO_WOOD);
    public static final Block POTTED_CATTAIL
            = registerWithoutItemBlock(ModBlockIds.POTTED_CATTAIL_KEY, (props) -> new FlowerPotBlock(ModBlocks.CATTAIL, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM));
    public static final Block STONE_WALL = registerWall(ModBlockIds.STONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final Block QUARTZ_WALL = registerWall(ModBlockIds.QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK));
    public static final Block SMOOTH_QUARTZ_WALL = registerWall(ModBlockIds.SMOOTH_QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ));
    public static final Block GRASS_SLAB
            = register(ModBlockIds.GRASS_SLAB_KEY, GrassSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK));
    public static final Block PODZOL_SLAB = registerSnowySlab(ModBlockIds.PODZOL_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL));
    public static final Block MYCELIUM_SLAB = registerSnowySlab(ModBlockIds.MYCELIUM_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM));
    public static final Block DIRT_PATH_SLAB
            = register(ModBlockIds.DIRT_PATH_SLAB_KEY, DirtPathSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH));
    public static final Block DIRT_SLAB
            = register(ModBlockIds.DIRT_SLAB_KEY, DirtSlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final Block COARSE_DIRT_SLAB = registerSlab(ModBlockIds.COARSE_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT));
    public static final Block ROOTED_DIRT_SLAB = registerSlab(ModBlockIds.ROOTED_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT));
    public static final Block WILD_GREEN_ONIONS = register(ModBlockIds.WILD_GREEN_ONIONS_KEY, WildGreenOnionsBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().randomTicks()
                    .instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY));
    public static final Block CREAKING_PLUSHIE
            = register(ModBlockIds.CREAKING_PLUSHIE_KEY, CreakingPlushieBlock::new, makePlushieSettings());
    public static final Block QUARTZ_BRICK_STAIRS = registerStairs(ModBlockIds.QUARTZ_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS), Blocks.QUARTZ_BRICKS);
    public static final Block QUARTZ_BRICK_SLAB
            = registerSlab(ModBlockIds.QUARTZ_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS));
    public static final Block QUARTZ_BRICK_WALL = registerWall(ModBlockIds.QUARTZ_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS));
    public static final Block SNIFFER_PLUSHIE
            = register(ModBlockIds.SNIFFER_PLUSHIE_KEY, SnifferPlushieBlock::new, makePlushieSettings());
    public static final Block STRIPPED_PALE_OAK_WALL = registerWall(ModBlockIds.STRIPPED_PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS));
    public static final Block PALE_OAK_WALL = registerWall(ModBlockIds.PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS));
    public static final Block BAMBOO_ROPE_LADDER = registerRopeLadder(ModBlockIds.BAMBOO_ROPE_LADDER_KEY);
    public static final Block STRIPPED_BAMBOO_WALL = registerWall(ModBlockIds.STRIPPED_BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS));
    public static final Block BAMBOO_WALL = registerWall(ModBlockIds.BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS));
    public static final Block BLACK_WOLF_PLUSHIE = registerWolfPlushie(ModBlockIds.BLACK_WOLF_PLUSHIE_KEY);
    public static final Block ASHEN_WOLF_PLUSHIE = registerWolfPlushie(ModBlockIds.ASHEN_WOLF_PLUSHIE_KEY);
    public static final Block CHESTNUT_WOLF_PLUSHIE = registerWolfPlushie(ModBlockIds.CHESTNUT_WOLF_PLUSHIE_KEY);
    public static final Block RUSTY_WOLF_PLUSHIE = registerWolfPlushie(ModBlockIds.RUSTY_WOLF_PLUSHIE_KEY);

    private static BlockPos postProcessSelf(final BlockState state, final BlockGetter blockGetter, final BlockPos blockPos) {
        return blockPos;
    }

    private static ToIntFunction<BlockState> getLuminanceFromState() {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? 10 : 0;
    }

    public static Block registerCandleCake(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(id.block()));
        return Registry.register(BuiltInRegistries.BLOCK, id.block(), block);
    }

    public static Block registerRopeLadder(BlockItemId id) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, id.block(),
                new RopeLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(id.block())));
        Item blockItem = Registry.register(BuiltInRegistries.ITEM, id.item(),
                new RopeLadderBlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item())));
        // Add our block item and block to this map so we can retrieve our block item from its block!
        Item.BY_BLOCK.put(block, blockItem);
        return block;
    }

    public static Block register(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        Block block = Registry.register(BuiltInRegistries.BLOCK, id.block(),
                factory.apply(properties.setId(id.block())));
        BlockItem blockItem = Registry.register(BuiltInRegistries.ITEM, id.item(),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item())));
        // Add our block item and block to this map so we can retrieve our block item from its block!
        Item.BY_BLOCK.put(block, blockItem);
        return block;
    }

    public static Block registerWithoutItemBlock(final ResourceKey<Block> id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        return Registry.register(BuiltInRegistries.BLOCK, id, factory.apply(properties.setId(id)));
    }

    private static Block registerHorsePlushie(BlockItemId id) {
        return register(id, HorsePlushieBlock::new, makePlushieSettings());
    }

    private static Block registerCubePlushie(BlockItemId id) {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE)
                .strength(0.2F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY);
        return register(id, CubePlushieBlock::new, settings);
    }

    private static Block registerMooshroomPlushie(BlockItemId id) {
        return register(id, MooshroomPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerWolfPlushie(BlockItemId id) {
        return register(id, WolfPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerCatPlushie(BlockItemId id) {
        return register(id, CatPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerRabbitPlushie(BlockItemId id) {
        return register(id, RabbitPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerVillagerPlushie(BlockItemId id) {
        return register(id, VillagerPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerPigPlushie(BlockItemId id) {
        return register(id, PigPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerShortHatVillagerPlushie(BlockItemId id) {
        return register(id, ShortHatVillagerPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerZombiePlushie(BlockItemId id) {
        return register(id, ZombiePlushieBlock::new, makePlushieSettings());
    }

    private static Block registerStriderPlushie(BlockItemId id) {
        return register(id, StriderPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerHoglinPlushie(BlockItemId id) {
        return register(id, HoglinPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerAllayPlushie(BlockItemId id) {
        return register(id, AllayPlushieBlock::new, makeGlowingPlushieSettings());
    }

    private static Block registerPlanterBox(BlockItemId id, MapColor color, SoundType soundGroup) {
        BlockBehaviour.Properties planterBoxSettings = BlockBehaviour.Properties.of().mapColor(color)
                .strength(2.5F).sound(soundGroup).ignitedByLava();
        return register(id, PlanterBoxBlock::new, planterBoxSettings);
    }

    private static Block registerNetherPlanterBox(BlockItemId id, MapColor color) {
        BlockBehaviour.Properties blockSettings = BlockBehaviour.Properties.of().mapColor(color)
                .strength(2.5F).sound(SoundType.NETHER_WOOD);
        return register(id, PlanterBoxBlock::new, blockSettings);
    }

    private static Block registerTorch(final ResourceKey<Block> id, SimpleParticleType particle) {
        BlockBehaviour.Properties torchSettings = BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH);
        return registerWithoutItemBlock(id, (props) -> new TorchBlock(particle, props), torchSettings);
    }

    private static Block registerWallTorch(final ResourceKey<Block> id, Block standingTorch, SimpleParticleType particle) {
        BlockBehaviour.Properties wallTorchSettings = wallVariant(standingTorch).noCollision().instabreak()
                .lightLevel((blockState) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY);
        return registerWithoutItemBlock(id, (props) -> new WallTorchBlock(particle, props), wallTorchSettings);
    }

    private static BlockBehaviour.Properties wallVariant(Block block) {
        return BlockBehaviour.Properties.of().overrideLootTable(block.getLootTable())
                .overrideDescription(block.getDescriptionId());
    }

    private static Block registerBlueberryBush() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().mapColor(MapColor.GRASS)
                .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH)
                .pushReaction(PushReaction.DESTROY);
        return registerWithoutItemBlock(ModBlockIds.BLUEBERRY_BUSH_KEY, BlueberryBushBlock::new, settings);
    }

    private static Block registerGreenOnions() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                .pushReaction(PushReaction.DESTROY);
        return registerWithoutItemBlock(ModBlockIds.GREEN_ONIONS_KEY, GreenOnionsBlock::new, settings);
    }

    private static Block registerIronLadder() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F)
                .sound(SoundType.METAL).noOcclusion();
        return register(ModBlockIds.IRON_LADDER_KEY, LadderBlock::new, settings);
    }

    private static Block registerStairs(BlockItemId id, BlockBehaviour.Properties settings, Block baseBlock) {
        return register(id, (props) -> new StairBlock(baseBlock.defaultBlockState(), props), settings);
    }

    private static Block registerSlab(BlockItemId id, BlockBehaviour.Properties settings) {
        return register(id, SlabBlock::new, settings);
    }

    private static Block registerWall(BlockItemId id, BlockBehaviour.Properties settings) {
        return register(id, WallBlock::new, settings);
    }

    private static Block registerDyedCampfire(BlockItemId id, ParticleOptions emberParticle) {
        return register(id, (props) -> new DyedCampfireBlock(props, emberParticle),
                BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE));
    }

    private static Block registerPottedSnapdragon() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
                .lightLevel((state) -> 8);
        return registerWithoutItemBlock(ModBlockIds.POTTED_SNAPDRAGON_KEY,
                (props) -> new PottedSnapdragonBlock(ModBlocks.SNAPDRAGON, props), settings);
    }

    private static Block registerCake(BlockItemId id) {
        return register(id, ModdedCakeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    }

    private static Block registerChocolateCandleCake() {
        return registerCandleCake(ModBlockIds.CANDLE_CHOCOLATE_CAKE_KEY, ModBlocks.CHOCOLATE_CAKE);
    }

    private static Block registerRedVelvetCandleCake() {
        return registerCandleCake(ModBlockIds.CANDLE_RED_VELVET_CAKE_KEY, ModBlocks.RED_VELVET_CAKE);
    }

    private static Block registerNetherSmokyQuartzOre() {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE);
        return register(ModBlockIds.NETHER_SMOKY_QUARTZ_ORE_KEY,
                (props) -> new DropExperienceBlock(UniformInt.of(2, 5), props), properties);
    }

    private static Block registerCandleCake(final ResourceKey<Block> id, Block cake) {
        return registerWithoutItemBlock(id, (props) -> new ModdedCandleCakeBlock(cake, Blocks.CANDLE, props),
                BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));
    }

    private static Block registerPie(BlockItemId id) {
        BlockBehaviour.Properties pieSettings = BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE);
        return register(id, (props) -> new PieBlock(props, 3, 0.6F), pieSettings);
    }

    private static Block registerSnowySlab(BlockItemId id, BlockBehaviour.Properties settings) {
        return register(id, SnowySlabBlock::new, settings);
    }

    private static BlockBehaviour.Properties makeBauxiteSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).requiresCorrectToolForDrops()
                .strength(0.3F);
    }

    private static BlockBehaviour.Properties makeBauxiteBricksSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).requiresCorrectToolForDrops()
                .strength(0.4F);
    }

    private static BlockBehaviour.Properties makeSmokyQuartzSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                .requiresCorrectToolForDrops().strength(0.8F);
    }

    private static BlockBehaviour.Properties makeStoneTileSettings() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .sound(SoundType.DEEPSLATE_TILES);
    }

    private static BlockBehaviour.Properties makeBlackstoneTileSettings() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
                .sound(SoundType.DEEPSLATE_TILES);
    }

    private static BlockBehaviour.Properties makeQuartzTileSettings() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)
                .sound(SoundType.DEEPSLATE_TILES);
    }

    private static BlockBehaviour.Properties makePlushieSettings() {
        return BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE)
                .strength(0.2F).sound(SoundType.WOOL);
    }

    private static BlockBehaviour.Properties makeGlowingPlushieSettings() {
        return BlockBehaviour.Properties.of().ignitedByLava()
                .mapColor(MapColor.NONE).strength(0.2F).sound(SoundType.WOOL)
                .lightLevel((state) -> 10);
    }

    private static BlockBehaviour.Properties makeSnowBrickSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.SNOW)
                .strength(0.4F).requiresCorrectToolForDrops().sound(SoundType.SNOW);
    }

    private static BlockBehaviour.Properties makePackedSnowSettings() {
        return BlockBehaviour.Properties.of().mapColor(MapColor.SNOW)
                .strength(0.6F).requiresCorrectToolForDrops().sound(SoundType.SNOW);
    }

    private static BlockBehaviour.Properties makeCalciteSettings() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE);
    }

    private static BlockBehaviour.Properties makeDripstoneSettings() {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK);
    }

    /**
     * Called during mod initialization to make sure that every block
     * is registered and available later during gameplay.
     */
    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }
}
