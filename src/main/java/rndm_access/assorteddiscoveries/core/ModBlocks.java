package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
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
    public static final Block BAT_PLUSHIE = register(new BatPlushieBlock(makePlushieSettings(ModBlockIds.BAT_PLUSHIE_KEY)),
            ModBlockIds.BAT_PLUSHIE_KEY, true);
    public static final Block BLAZE_PLUSHIE = register(
            new BlazePlushieBlock(makeGlowingPlushieSettings(ModBlockIds.BLAZE_PLUSHIE_KEY)),
            ModBlockIds.BLAZE_PLUSHIE_KEY, true);
    public static final Block CAVE_SPIDER_PLUSHIE
            = register(new CaveSpiderPlushieBlock(makePlushieSettings(ModBlockIds.CAVE_SPIDER_PLUSHIE_KEY)),
            ModBlockIds.CAVE_SPIDER_PLUSHIE_KEY, true);
    public static final Block TEMPERATE_CHICKEN_PLUSHIE
            = register(new ChickenPlushieBlock(makePlushieSettings(ModBlockIds.TEMPERATE_CHICKEN_PLUSHIE_KEY)),
            ModBlockIds.TEMPERATE_CHICKEN_PLUSHIE_KEY, true);
    public static final Block TEMPERATE_COW_PLUSHIE
            = register(new CowPlushieBlock(makePlushieSettings(ModBlockIds.TEMPERATE_COW_PLUSHIE_KEY)),
            ModBlockIds.TEMPERATE_COW_PLUSHIE_KEY, true);
    public static final Block CREEPER_PLUSHIE
            = register(new CreeperPlushieBlock(makePlushieSettings(ModBlockIds.CREEPER_PLUSHIE_KEY)),
            ModBlockIds.CREEPER_PLUSHIE_KEY, true);
    public static final Block ENDERMAN_PLUSHIE
            = register(new EndermanPlushieBlock(makePlushieSettings(ModBlockIds.ENDERMAN_PLUSHIE_KEY)),
            ModBlockIds.ENDERMAN_PLUSHIE_KEY, true);
    public static final Block GHAST_PLUSHIE = register(new GhastPlushieBlock(makePlushieSettings(ModBlockIds.GHAST_PLUSHIE_KEY)),
            ModBlockIds.GHAST_PLUSHIE_KEY, true);
    public static final Block GUARDIAN_PLUSHIE
            = register(new GuardianPlushieBlock(makePlushieSettings(ModBlockIds.GUARDIAN_PLUSHIE_KEY)),
            ModBlockIds.GUARDIAN_PLUSHIE_KEY, true);
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
    public static final Block TEMPERATE_PIG_PLUSHIE
            = register(new PigPlushieBlock(makePlushieSettings(ModBlockIds.TEMPERATE_PIG_PLUSHIE_KEY)),
            ModBlockIds.TEMPERATE_PIG_PLUSHIE_KEY, true);
    public static final Block COLD_PIG_PLUSHIE
            = register(new PigPlushieBlock(makePlushieSettings(ModBlockIds.COLD_PIG_PLUSHIE_KEY)),
            ModBlockIds.COLD_PIG_PLUSHIE_KEY, true);
    public static final Block BROWN_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.BROWN_RABBIT_PLUSHIE_KEY);
    public static final Block WHITE_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.WHITE_RABBIT_PLUSHIE_KEY);
    public static final Block BLACK_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.BLACK_RABBIT_PLUSHIE_KEY);
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY);
    public static final Block GOLD_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.GOLD_RABBIT_PLUSHIE_KEY);
    public static final Block TOAST_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.TOAST_RABBIT_PLUSHIE_KEY);
    public static final Block SALT_RABBIT_PLUSHIE = registerRabbitPlushie(ModBlockIds.SALT_RABBIT_PLUSHIE_KEY);
    public static final Block WHITE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.WHITE, ModBlockIds.WHITE_SHEEP_PLUSHIE_KEY);
    public static final Block ORANGE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.ORANGE, ModBlockIds.ORANGE_SHEEP_PLUSHIE_KEY);
    public static final Block MAGENTA_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.MAGENTA, ModBlockIds.MAGENTA_SHEEP_PLUSHIE_KEY);
    public static final Block LIGHT_BLUE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIGHT_BLUE, ModBlockIds.LIGHT_BLUE_SHEEP_PLUSHIE_KEY);
    public static final Block YELLOW_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.YELLOW, ModBlockIds.YELLOW_SHEEP_PLUSHIE_KEY);
    public static final Block LIME_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIME, ModBlockIds.LIME_SHEEP_PLUSHIE_KEY);
    public static final Block PINK_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.PINK, ModBlockIds.PINK_SHEEP_PLUSHIE_KEY);
    public static final Block GRAY_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.GRAY, ModBlockIds.GRAY_SHEEP_PLUSHIE_KEY);
    public static final Block LIGHT_GRAY_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIGHT_GRAY, ModBlockIds.LIGHT_GRAY_SHEEP_PLUSHIE_KEY);
    public static final Block CYAN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.CYAN, ModBlockIds.CYAN_SHEEP_PLUSHIE_KEY);
    public static final Block PURPLE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.PURPLE, ModBlockIds.PURPLE_SHEEP_PLUSHIE_KEY);
    public static final Block BLUE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BLUE, ModBlockIds.BLUE_SHEEP_PLUSHIE_KEY);
    public static final Block BROWN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BROWN, ModBlockIds.BROWN_SHEEP_PLUSHIE_KEY);
    public static final Block GREEN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.GREEN, ModBlockIds.GREEN_SHEEP_PLUSHIE_KEY);
    public static final Block RED_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.RED, ModBlockIds.RED_SHEEP_PLUSHIE_KEY);
    public static final Block BLACK_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BLACK, ModBlockIds.BLACK_SHEEP_PLUSHIE_KEY);
    public static final Block SKELETON_PLUSHIE
            = register(new SkeletonPlushieBlock(makePlushieSettings(ModBlockIds.SKELETON_PLUSHIE_KEY)),
            ModBlockIds.SKELETON_PLUSHIE_KEY, true);
    public static final Block SLIME_PLUSHIE = registerCubePlushie(ModBlockIds.SLIME_PLUSHIE_KEY);
    public static final Block SPIDER_PLUSHIE
            = register(new SpiderPlushieBlock(makePlushieSettings(ModBlockIds.SPIDER_PLUSHIE_KEY)),
            ModBlockIds.SPIDER_PLUSHIE_KEY, true);
    public static final Block SQUID_PLUSHIE
            = register(new SquidPlushieBlock(makePlushieSettings(ModBlockIds.SQUID_PLUSHIE_KEY)),
            ModBlockIds.SQUID_PLUSHIE_KEY, true);
    public static final Block GLOW_SQUID_PLUSHIE
            = register(new SquidPlushieBlock(makeGlowingPlushieSettings(ModBlockIds.GLOW_SQUID_PLUSHIE_KEY)),
            ModBlockIds.GLOW_SQUID_PLUSHIE_KEY, true);
    public static final Block BEE_PLUSHIE
            = register(new BeePlushieBlock(makePlushieSettings(ModBlockIds.BEE_PLUSHIE_KEY)),
            ModBlockIds.BEE_PLUSHIE_KEY, true);
    public static final Block PLAINS_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.PLAINS_VILLAGER_PLUSHIE_KEY);
    public static final Block DESERT_VILLAGER_PLUSHIE
            = register(new DesertVillagerPlushieBlock(makePlushieSettings(ModBlockIds.DESERT_VILLAGER_PLUSHIE_KEY)),
            ModBlockIds.DESERT_VILLAGER_PLUSHIE_KEY, true);
    public static final Block JUNGLE_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.JUNGLE_VILLAGER_PLUSHIE_KEY);
    public static final Block SAVANNA_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.SAVANNA_VILLAGER_PLUSHIE_KEY);
    public static final Block SNOWY_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(ModBlockIds.SNOWY_VILLAGER_PLUSHIE_KEY);
    public static final Block SWAMP_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(ModBlockIds.SWAMP_VILLAGER_PLUSHIE_KEY);
    public static final Block TAIGA_VILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.TAIGA_VILLAGER_PLUSHIE_KEY);
    public static final Block WITCH_PLUSHIE = register(new WitchPlushieBlock(makePlushieSettings(ModBlockIds.WITCH_PLUSHIE_KEY)),
            ModBlockIds.WITCH_PLUSHIE_KEY, true);
    public static final Block PALE_WOLF_PLUSHIE = registerWolfPlushie(ModBlockIds.PALE_WOLF_PLUSHIE_KEY);
    public static final Block ZOMBIE_PLUSHIE = registerZombiePlushie(ModBlockIds.ZOMBIE_PLUSHIE_KEY);
    public static final Block PIGLIN_PLUSHIE
            = register(new PiglinPlushieBlock(makePlushieSettings(ModBlockIds.PIGLIN_PLUSHIE_KEY)),
            ModBlockIds.PIGLIN_PLUSHIE_KEY, true);
    public static final Block ZOMBIFIED_PIGLIN_PLUSHIE = registerZombiePlushie(ModBlockIds.ZOMBIFIED_PIGLIN_PLUSHIE_KEY);
    public static final Block PUFFERFISH_PLUSHIE
            = register(new PufferfishPlushieBlock(makePlushieSettings(ModBlockIds.PUFFERFISH_PLUSHIE_KEY)),
            ModBlockIds.PUFFERFISH_PLUSHIE_KEY, true);
    public static final Block WITHER_PLUSHIE
            = register(new WitherPlushieBlock(makePlushieSettings(ModBlockIds.WITHER_PLUSHIE_KEY)),
            ModBlockIds.WITHER_PLUSHIE_KEY, true);
    public static final Block STRIDER_PLUSHIE = registerStriderPlushie(ModBlockIds.STRIDER_PLUSHIE_KEY);
    public static final Block SHIVERING_STRIDER_PLUSHIE = registerStriderPlushie(ModBlockIds.SHIVERING_STRIDER_PLUSHIE_KEY);
    public static final Block PHANTOM_PLUSHIE
            = register(new PhantomPlushieBlock(makePlushieSettings(ModBlockIds.PHANTOM_PLUSHIE_KEY)),
            ModBlockIds.PHANTOM_PLUSHIE_KEY, true);
    public static final Block HOGLIN_PLUSHIE = registerHoglinPlushie(ModBlockIds.HOGLIN_PLUSHIE_KEY);
    public static final Block ZOGLIN_PLUSHIE = registerHoglinPlushie(ModBlockIds.ZOGLIN_PLUSHIE_KEY);
    public static final Block ALLAY_PLUSHIE = registerAllayPlushie(ModBlockIds.ALLAY_PLUSHIE_KEY);
    public static final Block PILLAGER_PLUSHIE = registerVillagerPlushie(ModBlockIds.PILLAGER_PLUSHIE_KEY);
    public static final Block VINDICATOR_PLUSHIE = registerVillagerPlushie(ModBlockIds.VINDICATOR_PLUSHIE_KEY);
    public static final Block EVOKER_PLUSHIE = registerVillagerPlushie(ModBlockIds.EVOKER_PLUSHIE_KEY);
    public static final Block SHULKER_PLUSHIE
            = register(new ShulkerPlushieBlock(makePlushieSettings(ModBlockIds.SHULKER_PLUSHIE_KEY)),
            ModBlockIds.SHULKER_PLUSHIE_KEY, true);
    public static final Block VEX_PLUSHIE = registerAllayPlushie(ModBlockIds.VEX_PLUSHIE_KEY);
    public static final Block CAMEL_PLUSHIE
            = register(new CamelPlushieBlock(makePlushieSettings(ModBlockIds.CAMEL_PLUSHIE_KEY)),
            ModBlockIds.CAMEL_PLUSHIE_KEY, true);
    public static final Block NETHER_SMOKY_QUARTZ_ORE
            = register(new DropExperienceBlock(UniformInt.of(2, 5),
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).setId(ModBlockIds.NETHER_SMOKY_QUARTZ_ORE_KEY)),
            ModBlockIds.NETHER_SMOKY_QUARTZ_ORE_KEY, true);
    public static final Block SMOKY_QUARTZ_BLOCK
            = register(new Block(makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_BLOCK_KEY)),
            ModBlockIds.SMOKY_QUARTZ_BLOCK_KEY, true);
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK
            = register(new Block(makeSmokyQuartzSettings(ModBlockIds.CHISELED_SMOKY_QUARTZ_BLOCK_KEY)),
            ModBlockIds.CHISELED_SMOKY_QUARTZ_BLOCK_KEY, true);
    public static final Block SMOKY_QUARTZ_BRICKS
            = register(new Block(makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_BRICKS_KEY)),
            ModBlockIds.SMOKY_QUARTZ_BRICKS_KEY, true);
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS
            = registerStairs(ModBlockIds.SMOKY_QUARTZ_BRICK_STAIRS_KEY, makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_BRICK_STAIRS_KEY),
            SMOKY_QUARTZ_BRICKS);
    public static final Block SMOKY_QUARTZ_BRICK_SLAB
            = registerSlab(ModBlockIds.SMOKY_QUARTZ_BRICK_SLAB_KEY, makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_BRICK_SLAB_KEY));
    public static final Block SMOKY_QUARTZ_BRICK_WALL
            = registerWall(ModBlockIds.SMOKY_QUARTZ_BRICK_WALL_KEY, makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_BRICK_WALL_KEY));
    public static final Block SMOKY_QUARTZ_PILLAR
            = register(new RotatedPillarBlock(makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_PILLAR_KEY)),
            ModBlockIds.SMOKY_QUARTZ_PILLAR_KEY, true);
    public static final Block SMOKY_QUARTZ_STAIRS
            = registerStairs(ModBlockIds.SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_STAIRS_KEY),
            SMOKY_QUARTZ_BLOCK);
    public static final Block SMOKY_QUARTZ_SLAB = registerSlab(ModBlockIds.SMOKY_QUARTZ_SLAB_KEY,
            makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_SLAB_KEY));
    public static final Block SMOKY_QUARTZ_WALL = registerWall(ModBlockIds.SMOKY_QUARTZ_WALL_KEY,
            makeSmokyQuartzSettings(ModBlockIds.SMOKY_QUARTZ_WALL_KEY));
    public static final Block SMOOTH_SMOKY_QUARTZ
            = register(new Block(makeSmokyQuartzSettings(ModBlockIds.SMOOTH_SMOKY_QUARTZ_KEY)),
            ModBlockIds.SMOOTH_SMOKY_QUARTZ_KEY, true);
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS
            = registerStairs(ModBlockIds.SMOOTH_SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(ModBlockIds.SMOOTH_SMOKY_QUARTZ_STAIRS_KEY),
            SMOOTH_SMOKY_QUARTZ);
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = registerSlab(ModBlockIds.SMOOTH_SMOKY_QUARTZ_SLAB_KEY,
            makeSmokyQuartzSettings(ModBlockIds.SMOOTH_SMOKY_QUARTZ_SLAB_KEY));
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL = registerWall(ModBlockIds.SMOOTH_SMOKY_QUARTZ_WALL_KEY,
            makeSmokyQuartzSettings(ModBlockIds.SMOOTH_SMOKY_QUARTZ_WALL_KEY));
    public static final Block CRACKED_STONE_BRICK_STAIRS
            = registerStairs(ModBlockIds.CRACKED_STONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(ModBlockIds.CRACKED_STONE_BRICK_STAIRS_KEY), Blocks.CRACKED_STONE_BRICKS);
    public static final Block CRACKED_STONE_BRICK_SLAB = registerSlab(ModBlockIds.CRACKED_STONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(ModBlockIds.CRACKED_STONE_BRICK_SLAB_KEY));
    public static final Block CRACKED_STONE_BRICK_WALL = registerWall(ModBlockIds.CRACKED_STONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(ModBlockIds.CRACKED_STONE_BRICK_WALL_KEY));
    public static final Block BLUEBERRY_BUSH
            = register(new BlueberryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS)
            .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH)
            .pushReaction(PushReaction.DESTROY).setId(ModBlockIds.BLUEBERRY_BUSH_KEY)),
            ModBlockIds.BLUEBERRY_BUSH_KEY, false);
    public static final Block GREEN_ONIONS
            = register(new GreenOnionsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
            .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY).setId(ModBlockIds.GREEN_ONIONS_KEY)),
            ModBlockIds.GREEN_ONIONS_KEY, false);
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
    public static final Block OAK_WALL = registerWall(ModBlockIds.OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ModBlockIds.OAK_WALL_KEY));
    public static final Block SPRUCE_WALL = registerWall(ModBlockIds.SPRUCE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).setId(ModBlockIds.SPRUCE_WALL_KEY));
    public static final Block BIRCH_WALL = registerWall(ModBlockIds.BIRCH_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).setId(ModBlockIds.BIRCH_WALL_KEY));
    public static final Block JUNGLE_WALL = registerWall(ModBlockIds.JUNGLE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).setId(ModBlockIds.JUNGLE_WALL_KEY));
    public static final Block ACACIA_WALL = registerWall(ModBlockIds.ACACIA_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).setId(ModBlockIds.ACACIA_WALL_KEY));
    public static final Block DARK_OAK_WALL = registerWall(ModBlockIds.DARK_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).setId(ModBlockIds.DARK_OAK_WALL_KEY));
    public static final Block MANGROVE_WALL = registerWall(ModBlockIds.MANGROVE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).setId(ModBlockIds.MANGROVE_WALL_KEY));
    public static final Block CRIMSON_WALL = registerWall(ModBlockIds.CRIMSON_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(ModBlockIds.CRIMSON_WALL_KEY));
    public static final Block WARPED_WALL = registerWall(ModBlockIds.WARPED_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(ModBlockIds.WARPED_WALL_KEY));
    public static final Block CHERRY_WALL = registerWall(ModBlockIds.CHERRY_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(ModBlockIds.CHERRY_WALL_KEY));
    public static final Block STRIPPED_OAK_WALL = registerWall(ModBlockIds.STRIPPED_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(ModBlockIds.STRIPPED_OAK_WALL_KEY));
    public static final Block STRIPPED_SPRUCE_WALL = registerWall(ModBlockIds.STRIPPED_SPRUCE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).setId(ModBlockIds.STRIPPED_SPRUCE_WALL_KEY));
    public static final Block STRIPPED_BIRCH_WALL = registerWall(ModBlockIds.STRIPPED_BIRCH_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).setId(ModBlockIds.STRIPPED_BIRCH_WALL_KEY));
    public static final Block STRIPPED_JUNGLE_WALL = registerWall(ModBlockIds.STRIPPED_JUNGLE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).setId(ModBlockIds.STRIPPED_JUNGLE_WALL_KEY));
    public static final Block STRIPPED_ACACIA_WALL = registerWall(ModBlockIds.STRIPPED_ACACIA_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).setId(ModBlockIds.STRIPPED_ACACIA_WALL_KEY));
    public static final Block STRIPPED_DARK_OAK_WALL = registerWall(ModBlockIds.STRIPPED_DARK_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).setId(ModBlockIds.STRIPPED_DARK_OAK_WALL_KEY));
    public static final Block STRIPPED_MANGROVE_WALL = registerWall(ModBlockIds.STRIPPED_MANGROVE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).setId(ModBlockIds.STRIPPED_MANGROVE_WALL_KEY));
    public static final Block STRIPPED_CRIMSON_WALL = registerWall(ModBlockIds.STRIPPED_CRIMSON_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(ModBlockIds.STRIPPED_CRIMSON_WALL_KEY));
    public static final Block STRIPPED_WARPED_WALL = registerWall(ModBlockIds.STRIPPED_WARPED_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(ModBlockIds.STRIPPED_WARPED_WALL_KEY));
    public static final Block STRIPPED_CHERRY_WALL = registerWall(ModBlockIds.STRIPPED_CHERRY_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(ModBlockIds.STRIPPED_CHERRY_WALL_KEY));
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
    public static final Block IRON_LADDER = register(new LadderBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL)
                    .noOcclusion().setId(ModBlockIds.IRON_LADDER_KEY)), ModBlockIds.IRON_LADDER_KEY, true);
    public static final Block SNOW_BRICKS
            = register(new Block(makeSnowBrickSettings(ModBlockIds.SNOW_BRICKS_KEY)), ModBlockIds.SNOW_BRICKS_KEY, true);
    public static final Block SNOW_BRICK_STAIRS
            = registerStairs(ModBlockIds.SNOW_BRICK_STAIRS_KEY, makeSnowBrickSettings(ModBlockIds.SNOW_BRICK_STAIRS_KEY), SNOW_BRICKS);
    public static final Block SNOW_BRICK_SLAB
            = registerSlab(ModBlockIds.SNOW_BRICK_SLAB_KEY, makeSnowBrickSettings(ModBlockIds.SNOW_BRICK_SLAB_KEY));
    public static final Block SNOW_BRICK_WALL
            = registerWall(ModBlockIds.SNOW_BRICK_WALL_KEY, makeSnowBrickSettings(ModBlockIds.SNOW_BRICK_WALL_KEY));
    public static final Block PACKED_SNOW
            = register(new Block(makePackedSnowSettings(ModBlockIds.PACKED_SNOW_KEY)), ModBlockIds.PACKED_SNOW_KEY, true);
    public static final Block PACKED_SNOW_STAIRS
            = registerStairs(ModBlockIds.PACKED_SNOW_STAIRS_KEY, makePackedSnowSettings(ModBlockIds.PACKED_SNOW_STAIRS_KEY), PACKED_SNOW);
    public static final Block PACKED_SNOW_SLAB
            = registerSlab(ModBlockIds.PACKED_SNOW_SLAB_KEY, makePackedSnowSettings(ModBlockIds.PACKED_SNOW_SLAB_KEY));
    public static final Block PACKED_SNOW_WALL
            = registerWall(ModBlockIds.PACKED_SNOW_WALL_KEY, makePackedSnowSettings(ModBlockIds.PACKED_SNOW_WALL_KEY));
    public static final Block PURPLE_MUSHROOM
            = register(new MushroomBlock(ModTreeConfiguredFeatures.HUGE_PURPLE_MUSHROOM,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .pushReaction(PushReaction.DESTROY).noCollision().randomTicks().instabreak()
                    .sound(SoundType.GRASS).postProcess(ModBlocks::postProcessSelf).setId(ModBlockIds.PURPLE_MUSHROOM_KEY)),
            ModBlockIds.PURPLE_MUSHROOM_KEY, true);
    public static final Block PURPLE_MUSHROOM_BLOCK
            = register(new PurpleMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
            .instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
            .setId(ModBlockIds.PURPLE_MUSHROOM_BLOCK_KEY)), ModBlockIds.PURPLE_MUSHROOM_BLOCK_KEY, true);
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

    public static final Block WHITE_LANTERN = registerLantern(ModBlockIds.WHITE_LANTERN_KEY);
    public static final Block ORANGE_LANTERN = registerLantern(ModBlockIds.ORANGE_LANTERN_KEY);
    public static final Block MAGENTA_LANTERN = registerLantern(ModBlockIds.MAGENTA_LANTERN_KEY);
    public static final Block LIGHT_BLUE_LANTERN = registerLantern(ModBlockIds.LIGHT_BLUE_LANTERN_KEY);
    public static final Block YELLOW_LANTERN = registerLantern(ModBlockIds.YELLOW_LANTERN_KEY);
    public static final Block LIME_LANTERN = registerLantern(ModBlockIds.LIME_LANTERN_KEY);
    public static final Block PINK_LANTERN = registerLantern(ModBlockIds.PINK_LANTERN_KEY);
    public static final Block GRAY_LANTERN = registerLantern(ModBlockIds.GRAY_LANTERN_KEY);
    public static final Block LIGHT_GRAY_LANTERN = registerLantern(ModBlockIds.LIGHT_GRAY_LANTERN_KEY);
    public static final Block CYAN_LANTERN = registerLantern(ModBlockIds.CYAN_LANTERN_KEY);
    public static final Block PURPLE_LANTERN = registerLantern(ModBlockIds.PURPLE_LANTERN_KEY);
    public static final Block BLUE_LANTERN = registerLantern(ModBlockIds.BLUE_LANTERN_KEY);
    public static final Block BROWN_LANTERN = registerLantern(ModBlockIds.BROWN_LANTERN_KEY);
    public static final Block GREEN_LANTERN = registerLantern(ModBlockIds.GREEN_LANTERN_KEY);
    public static final Block RED_LANTERN = registerLantern(ModBlockIds.RED_LANTERN_KEY);
    public static final Block BLACK_LANTERN = registerLantern(ModBlockIds.BLACK_LANTERN_KEY);
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
    public static final Block WITCHS_CRADLE = register(new WitchsCradleBlock(BlockBehaviour.Properties
            .ofFullCopy(Blocks.SWEET_BERRY_BUSH).lightLevel((state) -> 8).setId(ModBlockIds.WITCHS_CRADLE_KEY)),
            ModBlockIds.WITCHS_CRADLE_KEY, false);
    public static final Block BAUXITE = register(new Block(makeBauxiteSettings(ModBlockIds.BAUXITE_KEY)),
            ModBlockIds.BAUXITE_KEY, true);
    public static final Block BAUXITE_SLAB = registerSlab(ModBlockIds.BAUXITE_SLAB_KEY, makeBauxiteSettings(ModBlockIds.BAUXITE_SLAB_KEY));
    public static final Block BAUXITE_STAIRS
            = registerStairs(ModBlockIds.BAUXITE_STAIRS_KEY, makeBauxiteSettings(ModBlockIds.BAUXITE_STAIRS_KEY), BAUXITE);
    public static final Block BAUXITE_WALL = registerWall(ModBlockIds.BAUXITE_WALL_KEY, makeBauxiteSettings(ModBlockIds.BAUXITE_WALL_KEY));
    public static final Block BAUXITE_BRICKS = register(new Block(makeBauxiteBricksSettings(ModBlockIds.BAUXITE_BRICKS_KEY)),
            ModBlockIds.BAUXITE_BRICKS_KEY, true);
    public static final Block BAUXITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.BAUXITE_BRICK_STAIRS_KEY,
            makeBauxiteBricksSettings(ModBlockIds.BAUXITE_BRICK_STAIRS_KEY), BAUXITE_BRICKS);
    public static final Block BAUXITE_BRICK_SLAB
            = registerSlab(ModBlockIds.BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings(ModBlockIds.BAUXITE_BRICK_SLAB_KEY));
    public static final Block BAUXITE_BRICK_WALL
            = registerWall(ModBlockIds.BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings(ModBlockIds.BAUXITE_BRICK_WALL_KEY));
    public static final Block MOSSY_BAUXITE_BRICKS
            = register(new Block(makeBauxiteBricksSettings(ModBlockIds.MOSSY_BAUXITE_BRICKS_KEY)),
            ModBlockIds.MOSSY_BAUXITE_BRICKS_KEY, true);
    public static final Block MOSSY_BAUXITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.MOSSY_BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(ModBlockIds.MOSSY_BAUXITE_BRICK_STAIRS_KEY),
            MOSSY_BAUXITE_BRICKS);
    public static final Block MOSSY_BAUXITE_BRICK_SLAB
            = registerSlab(ModBlockIds.MOSSY_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings(ModBlockIds.MOSSY_BAUXITE_BRICK_SLAB_KEY));
    public static final Block MOSSY_BAUXITE_BRICK_WALL
            = registerWall(ModBlockIds.MOSSY_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings(ModBlockIds.MOSSY_BAUXITE_BRICK_WALL_KEY));
    public static final Block CRACKED_BAUXITE_BRICKS
            = register(new Block(makeBauxiteBricksSettings(ModBlockIds.CRACKED_BAUXITE_BRICKS_KEY)),
            ModBlockIds.CRACKED_BAUXITE_BRICKS_KEY, true);
    public static final Block CRACKED_BAUXITE_BRICK_STAIRS
            = registerStairs(ModBlockIds.CRACKED_BAUXITE_BRICK_STAIRS_KEY,
            makeBauxiteBricksSettings(ModBlockIds.CRACKED_BAUXITE_BRICK_STAIRS_KEY), CRACKED_BAUXITE_BRICKS);
    public static final Block CRACKED_BAUXITE_BRICK_SLAB
            = registerSlab(ModBlockIds.CRACKED_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings(ModBlockIds.CRACKED_BAUXITE_BRICK_SLAB_KEY));
    public static final Block CRACKED_BAUXITE_BRICK_WALL
            = registerWall(ModBlockIds.CRACKED_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings(ModBlockIds.CRACKED_BAUXITE_BRICK_WALL_KEY));
    public static final Block TWISTED_NETHER_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(ModBlockIds.TWISTED_NETHER_BRICKS_KEY)),
            ModBlockIds.TWISTED_NETHER_BRICKS_KEY, true);
    public static final Block TWISTED_NETHER_BRICK_STAIRS
            = registerStairs(ModBlockIds.TWISTED_NETHER_BRICK_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(ModBlockIds.TWISTED_NETHER_BRICK_STAIRS_KEY), TWISTED_NETHER_BRICKS);
    public static final Block TWISTED_NETHER_BRICK_SLAB
            = registerSlab(ModBlockIds.TWISTED_NETHER_BRICK_SLAB_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(ModBlockIds.TWISTED_NETHER_BRICK_SLAB_KEY));
    public static final Block TWISTED_NETHER_BRICK_WALL
            = registerWall(ModBlockIds.TWISTED_NETHER_BRICK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(ModBlockIds.TWISTED_NETHER_BRICK_WALL_KEY));
    public static final Block TWISTED_NETHERRACK = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
            .setId(ModBlockIds.TWISTED_NETHERRACK_KEY)), ModBlockIds.TWISTED_NETHERRACK_KEY, true);
    public static final Block TWISTED_NETHERRACK_STAIRS = registerStairs(ModBlockIds.TWISTED_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(ModBlockIds.TWISTED_NETHERRACK_STAIRS_KEY),
            TWISTED_NETHERRACK);
    public static final Block TWISTED_NETHERRACK_SLAB = registerSlab(ModBlockIds.TWISTED_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(ModBlockIds.TWISTED_NETHERRACK_SLAB_KEY));
    public static final Block TWISTED_NETHERRACK_WALL = registerWall(ModBlockIds.TWISTED_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(ModBlockIds.TWISTED_NETHERRACK_WALL_KEY));
    public static final Block WEEPING_NETHER_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(ModBlockIds.WEEPING_NETHER_BRICKS_KEY)), ModBlockIds.WEEPING_NETHER_BRICKS_KEY, true);
    public static final Block WEEPING_NETHER_BRICK_STAIRS = registerStairs(ModBlockIds.WEEPING_NETHER_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(ModBlockIds.WEEPING_NETHER_BRICK_STAIRS_KEY), WEEPING_NETHER_BRICKS);
    public static final Block WEEPING_NETHER_BRICK_SLAB = registerSlab(ModBlockIds.WEEPING_NETHER_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                .setId(ModBlockIds.WEEPING_NETHER_BRICK_SLAB_KEY));
    public static final Block WEEPING_NETHER_BRICK_WALL = registerWall(ModBlockIds.WEEPING_NETHER_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                .setId(ModBlockIds.WEEPING_NETHER_BRICK_WALL_KEY));
    public static final Block WEEPING_NETHERRACK
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
            .setId(ModBlockIds.WEEPING_NETHERRACK_KEY)), ModBlockIds.WEEPING_NETHERRACK_KEY, true);
    public static final Block WEEPING_NETHERRACK_STAIRS = registerStairs(ModBlockIds.WEEPING_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .setId(ModBlockIds.WEEPING_NETHERRACK_STAIRS_KEY), WEEPING_NETHERRACK);
    public static final Block WEEPING_NETHERRACK_SLAB = registerSlab(ModBlockIds.WEEPING_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .setId(ModBlockIds.WEEPING_NETHERRACK_SLAB_KEY));
    public static final Block WEEPING_NETHERRACK_WALL = registerWall(ModBlockIds.WEEPING_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(ModBlockIds.WEEPING_NETHERRACK_WALL_KEY));
    public static final Block SNAPDRAGON = register(new SnapdragonBlock(MobEffects.LUCK, 8,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).lightLevel((state) -> 8)
                    .setId(ModBlockIds.SNAPDRAGON_KEY)), ModBlockIds.SNAPDRAGON_KEY, true);
    public static final Block POTTED_SNAPDRAGON = registerPottedSnapdragon(BlockBehaviour.Properties
            .ofFullCopy(Blocks.POTTED_POPPY).lightLevel((state) -> 8).setId(ModBlockIds.POTTED_SNAPDRAGON_KEY));
    public static final Block POTTED_PURPLE_MUSHROOM = register(new FlowerPotBlock(ModBlocks.PURPLE_MUSHROOM,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).setId(ModBlockIds.POTTED_PURPLE_MUSHROOM_KEY)),
            ModBlockIds.POTTED_PURPLE_MUSHROOM_KEY, false);
    public static final Block SHORT_ENDER_GRASS
        = register(new ShortEnderGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
            .lightLevel((state) -> 8).setId(ModBlockIds.SHORT_ENDER_GRASS_KEY)),
            ModBlockIds.SHORT_ENDER_GRASS_KEY, true);
    public static final Block CATTAIL = register(new CattailBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN).noCollision().noOcclusion().sound(SoundType.WET_GRASS)
            .setId(ModBlockIds.CATTAIL_KEY)), ModBlockIds.CATTAIL_KEY, true);
    public static final Block CHOCOLATE_CAKE = registerCake(ModBlockIds.CHOCOLATE_CAKE_KEY);
    public static final Block RED_VELVET_CAKE = registerCake(ModBlockIds.RED_VELVET_CAKE_KEY);
    public static final Block CANDLE_CHOCOLATE_CAKE = registerChocolateCandleCake();
    public static final ColorCollection<Block> DYED_CHOCOLATE_CAKE = ColorCollection.registerBlocks(ModBlockIds.DYED_CHOCOLATE_CANDLE_CAKE_KEYS,
            ModBlocks::registerCandleCake, (s, p) -> new ModdedCandleCakeBlock(ModBlocks.CHOCOLATE_CAKE, Blocks.DYED_CANDLE.pick(s), p),
            (var0) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));
    public static final Block CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake();
    public static final ColorCollection<Block> DYED_RED_VELVET_CAKE = ColorCollection.registerBlocks(ModBlockIds.DYED_RED_VELVET_CAKE_KEYS,
            ModBlocks::registerCandleCake, (s, p) -> new ModdedCandleCakeBlock(ModBlocks.RED_VELVET_CAKE, Blocks.DYED_CANDLE.pick(s), p),
            (var0) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));
    public static final Block STONE_TILES
            = register(new Block(makeStoneTileSettings(ModBlockIds.STONE_TILES_KEY)), ModBlockIds.STONE_TILES_KEY, true);
    public static final Block STONE_TILE_SLAB
            = registerSlab(ModBlockIds.STONE_TILE_SLAB_KEY, makeStoneTileSettings(ModBlockIds.STONE_TILE_SLAB_KEY));
    public static final Block STONE_TILE_STAIRS
            = registerStairs(ModBlockIds.STONE_TILE_STAIRS_KEY, makeStoneTileSettings(ModBlockIds.STONE_TILE_STAIRS_KEY), STONE_TILES);
    public static final Block STONE_TILE_WALL
            = registerWall(ModBlockIds.STONE_TILE_WALL_KEY, makeStoneTileSettings(ModBlockIds.STONE_TILE_WALL_KEY));
    public static final Block MOSSY_STONE_TILES = register(new Block(makeStoneTileSettings(ModBlockIds.MOSSY_STONE_TILES_KEY)),
            ModBlockIds.MOSSY_STONE_TILES_KEY, true);
    public static final Block MOSSY_STONE_TILE_SLAB
            = registerSlab(ModBlockIds.MOSSY_STONE_TILE_SLAB_KEY, makeStoneTileSettings(ModBlockIds.MOSSY_STONE_TILE_SLAB_KEY));
    public static final Block MOSSY_STONE_TILE_STAIRS
            = registerStairs(ModBlockIds.MOSSY_STONE_TILE_STAIRS_KEY,
            makeStoneTileSettings(ModBlockIds.MOSSY_STONE_TILE_STAIRS_KEY), MOSSY_STONE_TILES);
    public static final Block MOSSY_STONE_TILE_WALL
            = registerWall(ModBlockIds.MOSSY_STONE_TILE_WALL_KEY, makeStoneTileSettings(ModBlockIds.MOSSY_STONE_TILE_WALL_KEY));
    public static final Block CRACKED_STONE_TILES = register(new Block(makeStoneTileSettings(ModBlockIds.CRACKED_STONE_TILES_KEY)),
            ModBlockIds.CRACKED_STONE_TILES_KEY, true);
    public static final Block CRACKED_STONE_TILE_SLAB
            = registerSlab(ModBlockIds.CRACKED_STONE_TILE_SLAB_KEY, makeStoneTileSettings(ModBlockIds.CRACKED_STONE_TILE_SLAB_KEY));
    public static final Block CRACKED_STONE_TILE_STAIRS
            = registerStairs(ModBlockIds.CRACKED_STONE_TILE_STAIRS_KEY,
            makeStoneTileSettings(ModBlockIds.CRACKED_STONE_TILE_STAIRS_KEY), CRACKED_STONE_TILES);
    public static final Block CRACKED_STONE_TILE_WALL
            = registerWall(ModBlockIds.CRACKED_STONE_TILE_WALL_KEY, makeStoneTileSettings(ModBlockIds.CRACKED_STONE_TILE_WALL_KEY));
    public static final Block SWEET_BERRY_PIE = registerPie(ModBlockIds.SWEET_BERRY_PIE_KEY);
    public static final Block BLUEBERRY_PIE = registerPie(ModBlockIds.BLUEBERRY_PIE_KEY);
    public static final Block BLACKSTONE_TILES
            = register(new Block(makeBlackstoneTileSettings(ModBlockIds.BLACKSTONE_TILES_KEY)),
            ModBlockIds.BLACKSTONE_TILES_KEY, true);
    public static final Block BLACKSTONE_TILE_STAIRS
            = registerStairs(ModBlockIds.BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(ModBlockIds.BLACKSTONE_TILE_STAIRS_KEY), BLACKSTONE_TILES);
    public static final Block BLACKSTONE_TILE_SLAB
            = registerSlab(ModBlockIds.BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings(ModBlockIds.BLACKSTONE_TILE_SLAB_KEY));
    public static final Block BLACKSTONE_TILE_WALL
            = registerWall(ModBlockIds.BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings(ModBlockIds.BLACKSTONE_TILE_WALL_KEY));
    public static final Block TWISTED_BLACKSTONE_TILES
            = register(new Block(makeBlackstoneTileSettings(ModBlockIds.TWISTED_BLACKSTONE_TILES_KEY)),
            ModBlockIds.TWISTED_BLACKSTONE_TILES_KEY, true);
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS
            = registerStairs(ModBlockIds.TWISTED_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(ModBlockIds.TWISTED_BLACKSTONE_TILE_STAIRS_KEY), TWISTED_BLACKSTONE_TILES);
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB
            = registerSlab(ModBlockIds.TWISTED_BLACKSTONE_TILE_SLAB_KEY,
            makeBlackstoneTileSettings(ModBlockIds.TWISTED_BLACKSTONE_TILE_SLAB_KEY));
    public static final Block TWISTED_BLACKSTONE_TILE_WALL
            = registerWall(ModBlockIds.TWISTED_BLACKSTONE_TILE_WALL_KEY,
            makeBlackstoneTileSettings(ModBlockIds.TWISTED_BLACKSTONE_TILE_WALL_KEY));
    public static final Block WEEPING_BLACKSTONE_TILES
            = register(new Block(makeBlackstoneTileSettings(ModBlockIds.WEEPING_BLACKSTONE_TILES_KEY)),
            ModBlockIds.WEEPING_BLACKSTONE_TILES_KEY, true);
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS = registerStairs(ModBlockIds.WEEPING_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(ModBlockIds.WEEPING_BLACKSTONE_TILE_STAIRS_KEY), WEEPING_BLACKSTONE_TILES);
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB
            = registerSlab(ModBlockIds.WEEPING_BLACKSTONE_TILE_SLAB_KEY,
            makeBlackstoneTileSettings(ModBlockIds.WEEPING_BLACKSTONE_TILE_SLAB_KEY));
    public static final Block WEEPING_BLACKSTONE_TILE_WALL
            = registerWall(ModBlockIds.WEEPING_BLACKSTONE_TILE_WALL_KEY,
            makeBlackstoneTileSettings(ModBlockIds.WEEPING_BLACKSTONE_TILE_WALL_KEY));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY)),
            ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY, true);
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY),
            Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY));
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY)),
            ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY, true);
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY),
            WEEPING_POLISHED_BLACKSTONE_BRICKS);
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY));
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(ModBlockIds.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY));
    public static final Block TWISTED_BLACKSTONE
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(ModBlockIds.TWISTED_BLACKSTONE_KEY)),
            ModBlockIds.TWISTED_BLACKSTONE_KEY, true);
    public static final Block TWISTED_BLACKSTONE_STAIRS
            = registerStairs(ModBlockIds.TWISTED_BLACKSTONE_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
            .setId(ModBlockIds.TWISTED_BLACKSTONE_STAIRS_KEY), Blocks.BLACKSTONE);
    public static final Block TWISTED_BLACKSTONE_SLAB = registerSlab(ModBlockIds.TWISTED_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(ModBlockIds.TWISTED_BLACKSTONE_SLAB_KEY));
    public static final Block TWISTED_BLACKSTONE_WALL = registerWall(ModBlockIds.TWISTED_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(ModBlockIds.TWISTED_BLACKSTONE_WALL_KEY));
    public static final Block WEEPING_BLACKSTONE = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
            .setId(ModBlockIds.WEEPING_BLACKSTONE_KEY)), ModBlockIds.WEEPING_BLACKSTONE_KEY, true);
    public static final Block WEEPING_BLACKSTONE_STAIRS
            = registerStairs(ModBlockIds.WEEPING_BLACKSTONE_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
                        .setId(ModBlockIds.WEEPING_BLACKSTONE_STAIRS_KEY), WEEPING_BLACKSTONE);
    public static final Block WEEPING_BLACKSTONE_SLAB = registerSlab(ModBlockIds.WEEPING_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(ModBlockIds.WEEPING_BLACKSTONE_SLAB_KEY));
    public static final Block WEEPING_BLACKSTONE_WALL = registerWall(ModBlockIds.WEEPING_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(ModBlockIds.WEEPING_BLACKSTONE_WALL_KEY));
    public static final Block QUARTZ_TILES = register(new Block(makeQuartzTileSettings(ModBlockIds.QUARTZ_TILES_KEY)),
            ModBlockIds.QUARTZ_TILES_KEY, true);
    public static final Block QUARTZ_TILE_STAIRS = registerStairs(ModBlockIds.QUARTZ_TILE_STAIRS_KEY,
            makeQuartzTileSettings(ModBlockIds.QUARTZ_TILE_STAIRS_KEY), QUARTZ_TILES);
    public static final Block QUARTZ_TILE_SLAB
            = registerSlab(ModBlockIds.QUARTZ_TILE_SLAB_KEY, makeQuartzTileSettings(ModBlockIds.QUARTZ_TILE_SLAB_KEY));
    public static final Block QUARTZ_TILE_WALL
            = registerWall(ModBlockIds.QUARTZ_TILE_WALL_KEY, makeQuartzTileSettings(ModBlockIds.QUARTZ_TILE_WALL_KEY));
    public static final Block CALCITE_BRICKS = register(new Block(makeCalciteSettings(ModBlockIds.CALCITE_BRICKS_KEY)),
            ModBlockIds.CALCITE_BRICKS_KEY, true);
    public static final Block CALCITE_BRICK_STAIRS = registerStairs(ModBlockIds.CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(ModBlockIds.CALCITE_BRICK_STAIRS_KEY), CALCITE_BRICKS);
    public static final Block CALCITE_BRICK_SLAB = registerSlab(ModBlockIds.CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings(ModBlockIds.CALCITE_BRICK_SLAB_KEY));
    public static final Block CALCITE_BRICK_WALL = registerWall(ModBlockIds.CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings(ModBlockIds.CALCITE_BRICK_WALL_KEY));
    public static final Block MOSSY_CALCITE_BRICKS
            = register(new Block(makeCalciteSettings(ModBlockIds.MOSSY_CALCITE_BRICKS_KEY)),
            ModBlockIds.MOSSY_CALCITE_BRICKS_KEY, true);
    public static final Block MOSSY_CALCITE_BRICK_STAIRS = registerStairs(ModBlockIds.MOSSY_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(ModBlockIds.MOSSY_CALCITE_BRICK_STAIRS_KEY), MOSSY_CALCITE_BRICKS);
    public static final Block MOSSY_CALCITE_BRICK_SLAB
            = registerSlab(ModBlockIds.MOSSY_CALCITE_BRICK_SLAB_KEY, makeCalciteSettings(ModBlockIds.MOSSY_CALCITE_BRICK_SLAB_KEY));
    public static final Block MOSSY_CALCITE_BRICK_WALL = registerWall(ModBlockIds.MOSSY_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings(ModBlockIds.MOSSY_CALCITE_BRICK_WALL_KEY));
    public static final Block CRACKED_CALCITE_BRICKS
            = register(new Block(makeCalciteSettings(ModBlockIds.CRACKED_CALCITE_BRICKS_KEY)),
            ModBlockIds.CRACKED_CALCITE_BRICKS_KEY, true);
    public static final Block CRACKED_CALCITE_BRICK_STAIRS = registerStairs(ModBlockIds.CRACKED_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(ModBlockIds.CRACKED_CALCITE_BRICK_STAIRS_KEY), CRACKED_CALCITE_BRICKS);
    public static final Block CRACKED_CALCITE_BRICK_SLAB = registerSlab(ModBlockIds.CRACKED_CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings(ModBlockIds.CRACKED_CALCITE_BRICK_SLAB_KEY));
    public static final Block CRACKED_CALCITE_BRICK_WALL = registerWall(ModBlockIds.CRACKED_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings(ModBlockIds.CRACKED_CALCITE_BRICK_WALL_KEY));
    public static final Block CHISELED_CALCITE_BRICKS
            = register(new RotatedPillarBlock(makeCalciteSettings(ModBlockIds.CHISELED_CALCITE_BRICKS_KEY)),
            ModBlockIds.CHISELED_CALCITE_BRICKS_KEY, true);
    public static final Block DRIPSTONE_BRICKS = register(new Block(makeDripstoneSettings(ModBlockIds.DRIPSTONE_BRICKS_KEY)),
            ModBlockIds.DRIPSTONE_BRICKS_KEY, true);
    public static final Block DRIPSTONE_BRICK_STAIRS = registerStairs(ModBlockIds.DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(ModBlockIds.DRIPSTONE_BRICK_STAIRS_KEY), DRIPSTONE_BRICKS);
    public static final Block DRIPSTONE_BRICK_SLAB = registerSlab(ModBlockIds.DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings(ModBlockIds.DRIPSTONE_BRICK_SLAB_KEY));
    public static final Block DRIPSTONE_BRICK_WALL = registerWall(ModBlockIds.DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings(ModBlockIds.DRIPSTONE_BRICK_WALL_KEY));
    public static final Block MOSSY_DRIPSTONE_BRICKS
            = register(new Block(makeDripstoneSettings(ModBlockIds.MOSSY_DRIPSTONE_BRICKS_KEY)),
            ModBlockIds.MOSSY_DRIPSTONE_BRICKS_KEY, true);
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS = registerStairs(ModBlockIds.MOSSY_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(ModBlockIds.MOSSY_DRIPSTONE_BRICK_STAIRS_KEY), MOSSY_DRIPSTONE_BRICKS);
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB = registerSlab(ModBlockIds.MOSSY_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings(ModBlockIds.MOSSY_DRIPSTONE_BRICK_SLAB_KEY));
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL = registerWall(ModBlockIds.MOSSY_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings(ModBlockIds.MOSSY_DRIPSTONE_BRICK_WALL_KEY));
    public static final Block CRACKED_DRIPSTONE_BRICKS
            = register(new Block(makeDripstoneSettings(ModBlockIds.CRACKED_DRIPSTONE_BRICKS_KEY)),
            ModBlockIds.CRACKED_DRIPSTONE_BRICKS_KEY, true);
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = registerStairs(ModBlockIds.CRACKED_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(ModBlockIds.CRACKED_DRIPSTONE_BRICK_STAIRS_KEY), CRACKED_DRIPSTONE_BRICKS);
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = registerSlab(ModBlockIds.CRACKED_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings(ModBlockIds.CRACKED_DRIPSTONE_BRICK_SLAB_KEY));
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL = registerWall(ModBlockIds.CRACKED_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings(ModBlockIds.CRACKED_DRIPSTONE_BRICK_WALL_KEY));
    public static final Block CHISELED_DRIPSTONE_BRICKS
            = register(new Block(makeDripstoneSettings(ModBlockIds.CHISELED_DRIPSTONE_BRICKS_KEY)),
            ModBlockIds.CHISELED_DRIPSTONE_BRICKS_KEY, true);
    public static final Block BLOOD_KELP
            = register(new BloodKelpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP)
                    .lightLevel(getLuminanceFromState()).setId(ModBlockIds.BLOOD_KELP_KEY)),
            ModBlockIds.BLOOD_KELP_KEY, false);
    public static final Block BLOOD_KELP_PLANT
            = register(new BloodKelpPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT)
                    .lightLevel(getLuminanceFromState()).setId(ModBlockIds.BLOOD_KELP_PLANT_KEY)),
            ModBlockIds.BLOOD_KELP_PLANT_KEY, false);
    public static final Block DRIED_BLOOD_KELP_BLOCK
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIED_KELP_BLOCK)
                    .setId(ModBlockIds.DRIED_BLOOD_KELP_BLOCK_KEY)), ModBlockIds.DRIED_BLOOD_KELP_BLOCK_KEY, true);
    public static final Block BLOOD_KELP_LANTERN
            = register(new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.3F)
                    .sound(SoundType.GLASS).lightLevel((state) -> 15)
                    .setId(ModBlockIds.BLOOD_KELP_LANTERN_KEY)),
            ModBlockIds.BLOOD_KELP_LANTERN_KEY, true);
    public static final Block BOG_BLOSSOM = register(new BogBlossomBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).instabreak().noCollision().sound(SoundType.SPORE_BLOSSOM)
            .pushReaction(PushReaction.DESTROY).lightLevel((state) -> 5).setId(ModBlockIds.BOG_BLOSSOM_KEY)),
            ModBlockIds.BOG_BLOSSOM_KEY, true);
    public static final Block CINDERSNAP_BERRY_BUSH
            = register(new CindersnapBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
            .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> 8).setId(ModBlockIds.CINDERSNAP_BERRY_BUSH_KEY)),
            ModBlockIds.CINDERSNAP_BERRY_BUSH_KEY, false);
    public static final Block FROSTBITE_BERRY_BUSH
            = register(new FrostbiteBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
            .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> 5).setId(ModBlockIds.FROSTBITE_BERRY_BUSH_KEY)),
            ModBlockIds.FROSTBITE_BERRY_BUSH_KEY, false);
    public static final Block POLISHED_DRIPSTONE
            = register(new Block(makeDripstoneSettings(ModBlockIds.POLISHED_DRIPSTONE_KEY)),
            ModBlockIds.POLISHED_DRIPSTONE_KEY, true);
    public static final Block POLISHED_DRIPSTONE_STAIRS = registerStairs(ModBlockIds.POLISHED_DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(ModBlockIds.POLISHED_DRIPSTONE_STAIRS_KEY), POLISHED_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_SLAB
            = registerSlab(ModBlockIds.POLISHED_DRIPSTONE_SLAB_KEY, makeDripstoneSettings(ModBlockIds.POLISHED_DRIPSTONE_SLAB_KEY));
    public static final Block POLISHED_DRIPSTONE_WALL = registerWall(ModBlockIds.POLISHED_DRIPSTONE_WALL_KEY,
            makeDripstoneSettings(ModBlockIds.POLISHED_DRIPSTONE_WALL_KEY));
    public static final Block POLISHED_CALCITE = register(new Block(makeCalciteSettings(ModBlockIds.POLISHED_CALCITE_KEY)),
            ModBlockIds.POLISHED_CALCITE_KEY, true);
    public static final Block POLISHED_CALCITE_STAIRS = registerStairs(ModBlockIds.POLISHED_CALCITE_STAIRS_KEY,
            makeCalciteSettings(ModBlockIds.POLISHED_CALCITE_STAIRS_KEY), POLISHED_CALCITE);
    public static final Block POLISHED_CALCITE_SLAB = registerSlab(ModBlockIds.POLISHED_CALCITE_SLAB_KEY,
            makeCalciteSettings(ModBlockIds.POLISHED_CALCITE_SLAB_KEY));
    public static final Block POLISHED_CALCITE_WALL = registerWall(ModBlockIds.POLISHED_CALCITE_WALL_KEY,
            makeCalciteSettings(ModBlockIds.POLISHED_CALCITE_WALL_KEY));
    public static final Block DRIPSTONE_STAIRS = registerStairs(ModBlockIds.DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(ModBlockIds.DRIPSTONE_STAIRS_KEY), Blocks.DRIPSTONE_BLOCK);
    public static final Block DRIPSTONE_SLAB = registerSlab(ModBlockIds.DRIPSTONE_SLAB_KEY,
            makeDripstoneSettings(ModBlockIds.DRIPSTONE_SLAB_KEY));
    public static final Block DRIPSTONE_WALL = registerWall(ModBlockIds.DRIPSTONE_WALL_KEY,
            makeDripstoneSettings(ModBlockIds.DRIPSTONE_WALL_KEY));
    public static final Block CALCITE_STAIRS = registerStairs(ModBlockIds.CALCITE_STAIRS_KEY,
            makeCalciteSettings(ModBlockIds.CALCITE_STAIRS_KEY), Blocks.CALCITE);
    public static final Block CALCITE_SLAB = registerSlab(ModBlockIds.CALCITE_SLAB_KEY, makeCalciteSettings(ModBlockIds.CALCITE_SLAB_KEY));
    public static final Block CALCITE_WALL = registerWall(ModBlockIds.CALCITE_WALL_KEY, makeCalciteSettings(ModBlockIds.CALCITE_WALL_KEY));
    public static final Block BAMBOO_PLANTER_BOX = registerPlanterBox(ModBlockIds.BAMBOO_PLANTER_BOX_KEY,
            Blocks.BAMBOO_PLANKS.defaultMapColor(), SoundType.BAMBOO_WOOD);
    public static final Block POTTED_CATTAIL = register(new FlowerPotBlock(ModBlocks.CATTAIL,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).setId(ModBlockIds.POTTED_CATTAIL_KEY)),
            ModBlockIds.POTTED_CATTAIL_KEY, false);
    public static final Block STONE_WALL = registerWall(ModBlockIds.STONE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
            .setId(ModBlockIds.STONE_WALL_KEY));
    public static final Block QUARTZ_WALL = registerWall(ModBlockIds.QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(ModBlockIds.QUARTZ_WALL_KEY));
    public static final Block SMOOTH_QUARTZ_WALL = registerWall(ModBlockIds.SMOOTH_QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).setId(ModBlockIds.SMOOTH_QUARTZ_WALL_KEY));
    public static final Block GRASS_SLAB
            = register(new GrassSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)
                    .setId(ModBlockIds.GRASS_SLAB_KEY)),
            ModBlockIds.GRASS_SLAB_KEY, true);
    public static final Block PODZOL_SLAB = registerSnowySlab(ModBlockIds.PODZOL_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL).setId(ModBlockIds.PODZOL_SLAB_KEY));
    public static final Block MYCELIUM_SLAB = registerSnowySlab(ModBlockIds.MYCELIUM_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM).setId(ModBlockIds.MYCELIUM_SLAB_KEY));
    public static final Block DIRT_PATH_SLAB
            = register(new DirtPathSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)
                    .setId(ModBlockIds.DIRT_PATH_SLAB_KEY)),
            ModBlockIds.DIRT_PATH_SLAB_KEY, true);
    public static final Block DIRT_SLAB
            = register(new DirtSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)
                    .setId(ModBlockIds.DIRT_SLAB_KEY)),
            ModBlockIds.DIRT_SLAB_KEY, true);
    public static final Block COARSE_DIRT_SLAB = registerSlab(ModBlockIds.COARSE_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT).setId(ModBlockIds.COARSE_DIRT_SLAB_KEY));
    public static final Block ROOTED_DIRT_SLAB = registerSlab(ModBlockIds.ROOTED_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(ModBlockIds.ROOTED_DIRT_SLAB_KEY));
    public static final Block WILD_GREEN_ONIONS
            = register(new WildGreenOnionsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
            .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY).setId(ModBlockIds.WILD_GREEN_ONIONS_KEY)),
            ModBlockIds.WILD_GREEN_ONIONS_KEY, true);
    public static final Block CREAKING_PLUSHIE
            = register(new CreakingPlushieBlock(makePlushieSettings(ModBlockIds.CREAKING_PLUSHIE_KEY)),
            ModBlockIds.CREAKING_PLUSHIE_KEY, true);
    public static final Block QUARTZ_BRICK_STAIRS = registerStairs(ModBlockIds.QUARTZ_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(ModBlockIds.QUARTZ_BRICK_STAIRS_KEY),
            Blocks.QUARTZ_BRICKS);
    public static final Block QUARTZ_BRICK_SLAB = registerSlab(ModBlockIds.QUARTZ_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(ModBlockIds.QUARTZ_BRICK_SLAB_KEY));
    public static final Block QUARTZ_BRICK_WALL = registerWall(ModBlockIds.QUARTZ_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(ModBlockIds.QUARTZ_BRICK_WALL_KEY));
    public static final Block SNIFFER_PLUSHIE
            = register(new SnifferPlushieBlock(makePlushieSettings(ModBlockIds.SNIFFER_PLUSHIE_KEY)),
            ModBlockIds.SNIFFER_PLUSHIE_KEY, true);
    public static final Block STRIPPED_PALE_OAK_WALL = registerWall(ModBlockIds.STRIPPED_PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).setId(ModBlockIds.STRIPPED_PALE_OAK_WALL_KEY));
    public static final Block PALE_OAK_WALL = registerWall(ModBlockIds.PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).setId(ModBlockIds.PALE_OAK_WALL_KEY));
    public static final Block BAMBOO_ROPE_LADDER = registerRopeLadder(ModBlockIds.BAMBOO_ROPE_LADDER_KEY);
    public static final Block STRIPPED_BAMBOO_WALL = registerWall(ModBlockIds.STRIPPED_BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(ModBlockIds.STRIPPED_BAMBOO_WALL_KEY));
    public static final Block BAMBOO_WALL = registerWall(ModBlockIds.BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(ModBlockIds.BAMBOO_WALL_KEY));
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

    public static Block registerCandleCake(final ResourceKey<Block> id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties.setId(id));
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static Block register(Block block, ResourceKey<Block> blockKey, boolean shouldRegisterItem) {
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockKey.identifier());
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey));
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
            Item.BY_BLOCK.put(block, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static Block registerHorsePlushie(ResourceKey<Block> blockKey) {
        Block horsePlushieBlock = new HorsePlushieBlock(makePlushieSettings(blockKey));
        return register(horsePlushieBlock, blockKey, true);
    }

    private static Block registerCubePlushie(ResourceKey<Block> blockKey) {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE)
                .strength(0.2F).sound(SoundType.WOOL)
                .pushReaction(PushReaction.DESTROY).setId(blockKey);
        Block cubePlushieBlock = new CubePlushieBlock(settings);
        return register(cubePlushieBlock, blockKey, true);
    }

    private static Block registerMooshroomPlushie(ResourceKey<Block> blockKey) {
        Block mooshroomPlushieBlock = new MooshroomPlushieBlock(makePlushieSettings(blockKey));
        return register(mooshroomPlushieBlock, blockKey, true);
    }

    private static Block registerWolfPlushie(ResourceKey<Block> blockKey) {
        Block wolfPlushieBlock = new WolfPlushieBlock(makePlushieSettings(blockKey));
        return register(wolfPlushieBlock, blockKey, true);
    }

    private static Block registerCatPlushie(ResourceKey<Block> blockKey) {
        Block catPlushieBlock = new CatPlushieBlock(makePlushieSettings(blockKey));
        return register(catPlushieBlock, blockKey, true);
    }

    private static Block registerRabbitPlushie(ResourceKey<Block> blockKey) {
        Block rabbitPlushieBlock = new RabbitPlushieBlock(makePlushieSettings(blockKey));
        return register(rabbitPlushieBlock, blockKey, true);
    }

    private static Block registerSheepPlushie(DyeColor color, ResourceKey<Block> blockKey) {
        Block sheepPlushieBlock = new SheepPlushieBlock(color, makePlushieSettings(blockKey));
        return register(sheepPlushieBlock, blockKey, true);
    }

    private static Block registerVillagerPlushie(ResourceKey<Block> blockKey) {
        Block villagerPlushieBlock = new VillagerPlushieBlock(makePlushieSettings(blockKey));
        return register(villagerPlushieBlock, blockKey, true);
    }

    private static Block registerShortHatVillagerPlushie(ResourceKey<Block> blockKey) {
        Block shortHatVillagerPlushieBlock = new ShortHatVillagerPlushieBlock(makePlushieSettings(blockKey));
        return register(shortHatVillagerPlushieBlock, blockKey, true);
    }

    private static Block registerZombiePlushie(ResourceKey<Block> blockKey) {
        Block zombiePlushieBlock = new ZombiePlushieBlock(makePlushieSettings(blockKey));
        return register(zombiePlushieBlock, blockKey, true);
    }

    private static Block registerStriderPlushie(ResourceKey<Block> blockKey) {
        Block striderPlushieBlock = new StriderPlushieBlock(makePlushieSettings(blockKey));
        return register(striderPlushieBlock, blockKey, true);
    }

    private static Block registerHoglinPlushie(ResourceKey<Block> blockKey) {
        Block hoglinPlushieBlock = new HoglinPlushieBlock(makePlushieSettings(blockKey));
        return register(hoglinPlushieBlock, blockKey, true);
    }

    private static Block registerAllayPlushie(ResourceKey<Block> blockKey) {
        Block allayPlushieBlock = new AllayPlushieBlock(makeGlowingPlushieSettings(blockKey));
        return register(allayPlushieBlock, blockKey, true);
    }

    private static Block registerPlanterBox(ResourceKey<Block> blockKey, MapColor color, SoundType soundGroup) {
        BlockBehaviour.Properties planterBoxSettings = BlockBehaviour.Properties.of().mapColor(color)
                .strength(2.5F).sound(soundGroup).ignitedByLava().setId(blockKey);
        Block planterBoxBlock = new PlanterBoxBlock(planterBoxSettings);
        return register(planterBoxBlock, blockKey, true);
    }

    private static Block registerNetherPlanterBox(ResourceKey<Block> blockKey, MapColor color) {
        BlockBehaviour.Properties blockSettings = BlockBehaviour.Properties.of().mapColor(color).strength(2.5F)
                .sound(SoundType.NETHER_WOOD).setId(blockKey);
        Block netherPlanterBoxBlock = new PlanterBoxBlock(blockSettings);
        return register(netherPlanterBoxBlock, blockKey, true);
    }

    public static Block registerRopeLadder(ResourceKey<Block> blockKey) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockKey.identifier());
        Block block = new RopeLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(blockKey));
        BlockItem blockItem = new RopeLadderBlockItem(block, new Item.Properties().setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        Item.BY_BLOCK.put(block, blockItem);
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static Block registerTorch(ResourceKey<Block> blockKey, SimpleParticleType particle) {
        BlockBehaviour.Properties torchSettings = BlockBehaviour.Properties
                .ofFullCopy(Blocks.TORCH).setId(blockKey);
        Block torchBlock = new TorchBlock(particle, torchSettings);
        return register(torchBlock, blockKey, false);
    }

    private static Block registerWallTorch(ResourceKey<Block> blockKey, Block standingTorch, SimpleParticleType particle) {
        BlockBehaviour.Properties wallTorchSettings = wallVariant(standingTorch).noCollision().instabreak()
                .lightLevel((blockState) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)
                .setId(blockKey);
        Block wallTorchBlock = new WallTorchBlock(particle, wallTorchSettings);
        return register(wallTorchBlock, blockKey, false);
    }

    private static BlockBehaviour.Properties wallVariant(Block block) {
        return BlockBehaviour.Properties.of().overrideLootTable(block.getLootTable())
                .overrideDescription(block.getDescriptionId());
    }

    private static Block registerStairs(ResourceKey<Block> blockKey, BlockBehaviour.Properties settings, Block baseBlock) {
        Block stairsBlock = new StairBlock(baseBlock.defaultBlockState(), settings);
        return register(stairsBlock, blockKey, true);
    }

    private static Block registerSlab(ResourceKey<Block> blockKey, BlockBehaviour.Properties settings) {
        Block slabBlock = new SlabBlock(settings);
        return register(slabBlock, blockKey, true);
    }

    private static Block registerWall(ResourceKey<Block> blockKey, BlockBehaviour.Properties settings) {
        Block wallBlock = new WallBlock(settings);
        return register(wallBlock, blockKey, true);
    }

    private static Block registerDyedCampfire(ResourceKey<Block> blockKey, ParticleOptions emberParticle) {
        Block dyedCampfireBlock = new DyedCampfireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE)
                .setId(blockKey), emberParticle);
        return register(dyedCampfireBlock, blockKey, true);
    }

    private static Block registerLantern(ResourceKey<Block> blockKey) {
        Block lanternBlock = new LanternBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN).setId(blockKey));
        return register(lanternBlock, blockKey, true);
    }

    private static Block registerPottedSnapdragon(BlockBehaviour.Properties settings) {
        Block pottedSnapdragonBlock = new PottedSnapdragonBlock(ModBlocks.SNAPDRAGON, settings);
        return register(pottedSnapdragonBlock, ModBlockIds.POTTED_SNAPDRAGON_KEY, false);
    }

    private static Block registerCake(ResourceKey<Block> blockKey) {
        Block moddedCakeBlock = new ModdedCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(blockKey));
        return register(moddedCakeBlock, blockKey, true);
    }

    private static Block registerChocolateCandleCake() {
        return registerCandleCake(ModBlockIds.CANDLE_CHOCOLATE_CAKE_KEY, ModBlocks.CHOCOLATE_CAKE);
    }

    private static Block registerRedVelvetCandleCake() {
        return registerCandleCake(ModBlockIds.CANDLE_RED_VELVET_CAKE_KEY, ModBlocks.RED_VELVET_CAKE);
    }

    private static Block registerCandleCake(ResourceKey<Block> blockKey, Block cake) {
        Block candleCakeBlock = new ModdedCandleCakeBlock(cake, Blocks.CANDLE,
                BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE).setId(blockKey));
        return register(candleCakeBlock, blockKey, false);
    }

    private static Block registerPie(ResourceKey<Block> blockKey) {
        BlockBehaviour.Properties pieSettings = BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(blockKey);
        Block pieBlock = new PieBlock(pieSettings, 3, 0.6F);
        return register(pieBlock, blockKey, true);
    }

    private static Block registerSnowySlab(ResourceKey<Block> blockKey, BlockBehaviour.Properties settings) {
        Block snowySlabBlock = new SnowySlabBlock(settings);
        return register(snowySlabBlock, blockKey, true);
    }

    private static BlockBehaviour.Properties makeBauxiteSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).requiresCorrectToolForDrops()
                .strength(0.3F).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeBauxiteBricksSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).requiresCorrectToolForDrops()
                .strength(0.4F).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeSmokyQuartzSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                .requiresCorrectToolForDrops().strength(0.8F).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeStoneTileSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .sound(SoundType.DEEPSLATE_TILES).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeBlackstoneTileSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
                .sound(SoundType.DEEPSLATE_TILES).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeQuartzTileSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK)
                .sound(SoundType.DEEPSLATE_TILES).setId(blockKey);
    }

    private static BlockBehaviour.Properties makePlushieSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE)
                .strength(0.2F).sound(SoundType.WOOL).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeGlowingPlushieSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().ignitedByLava()
                .mapColor(MapColor.NONE).strength(0.2F).sound(SoundType.WOOL)
                .lightLevel((state) -> 10).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeSnowBrickSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.SNOW)
                .strength(0.4F).requiresCorrectToolForDrops().sound(SoundType.SNOW).setId(blockKey);
    }

    private static BlockBehaviour.Properties makePackedSnowSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.SNOW)
                .strength(0.6F).requiresCorrectToolForDrops().sound(SoundType.SNOW).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeCalciteSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).setId(blockKey);
    }

    private static BlockBehaviour.Properties makeDripstoneSettings(ResourceKey<Block> blockKey) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK).setId(blockKey);
    }

    /**
     * Called during mod initialization to make sure that every block
     * is registered and available later during gameplay.
     */
    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }
}
