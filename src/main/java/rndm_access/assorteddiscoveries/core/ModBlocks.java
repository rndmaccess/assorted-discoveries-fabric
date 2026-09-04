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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WallTorchBlock;
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
    public static final ResourceKey<Block> BAT_PLUSHIE_KEY = makeRegistryKey("bat_plushie");
    public static final Block BAT_PLUSHIE = register(BAT_PLUSHIE_KEY, BatPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> BLAZE_PLUSHIE_KEY = makeRegistryKey("blaze_plushie");
    public static final Block BLAZE_PLUSHIE
            = register(BLAZE_PLUSHIE_KEY, BlazePlushieBlock::new, makeGlowingPlushieSettings());
    public static final ResourceKey<Block> CAVE_SPIDER_PLUSHIE_KEY = makeRegistryKey("cave_spider_plushie");
    public static final Block CAVE_SPIDER_PLUSHIE
            = register(CAVE_SPIDER_PLUSHIE_KEY, CaveSpiderPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> TEMPERATE_CHICKEN_PLUSHIE_KEY
            = makeRegistryKey("temperate_chicken_plushie");
    public static final Block TEMPERATE_CHICKEN_PLUSHIE
            = register(TEMPERATE_CHICKEN_PLUSHIE_KEY, ChickenPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> TEMPERATE_COW_PLUSHIE_KEY
            = makeRegistryKey("temperate_cow_plushie");
    public static final Block TEMPERATE_COW_PLUSHIE
            = register(TEMPERATE_COW_PLUSHIE_KEY, CowPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> CREEPER_PLUSHIE_KEY = makeRegistryKey("creeper_plushie");
    public static final Block CREEPER_PLUSHIE
            = register(CREEPER_PLUSHIE_KEY, CreeperPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> ENDERMAN_PLUSHIE_KEY = makeRegistryKey("enderman_plushie");
    public static final Block ENDERMAN_PLUSHIE
            = register(ENDERMAN_PLUSHIE_KEY, EndermanPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> GHAST_PLUSHIE_KEY = makeRegistryKey("ghast_plushie");
    public static final Block GHAST_PLUSHIE
            = register(GHAST_PLUSHIE_KEY, GhastPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> GUARDIAN_PLUSHIE_KEY = makeRegistryKey("guardian_plushie");
    public static final Block GUARDIAN_PLUSHIE
            = register(GUARDIAN_PLUSHIE_KEY, GuardianPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> WHITE_HORSE_PLUSHIE_KEY = makeRegistryKey("white_horse_plushie");
    public static final Block WHITE_HORSE_PLUSHIE = registerHorsePlushie(WHITE_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> GRAY_HORSE_PLUSHIE_KEY = makeRegistryKey("gray_horse_plushie");
    public static final Block GRAY_HORSE_PLUSHIE = registerHorsePlushie(GRAY_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_HORSE_PLUSHIE_KEY = makeRegistryKey("brown_horse_plushie");
    public static final Block BROWN_HORSE_PLUSHIE = registerHorsePlushie(BROWN_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_HORSE_PLUSHIE_KEY = makeRegistryKey("black_horse_plushie");
    public static final Block BLACK_HORSE_PLUSHIE = registerHorsePlushie(BLACK_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> MAGMA_CUBE_PLUSHIE_KEY = makeRegistryKey("magma_cube_plushie");
    public static final Block MAGMA_CUBE_PLUSHIE = registerCubePlushie(MAGMA_CUBE_PLUSHIE_KEY);
    public static final ResourceKey<Block> RED_MOOSHROOM_PLUSHIE_KEY = makeRegistryKey("red_mooshroom_plushie");
    public static final Block RED_MOOSHROOM_PLUSHIE = registerMooshroomPlushie(RED_MOOSHROOM_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_MOOSHROOM_PLUSHIE_KEY = makeRegistryKey("brown_mooshroom_plushie");
    public static final Block BROWN_MOOSHROOM_PLUSHIE = registerMooshroomPlushie(BROWN_MOOSHROOM_PLUSHIE_KEY);
    public static final ResourceKey<Block> OCELOT_PLUSHIE_KEY = makeRegistryKey("ocelot_plushie");
    public static final Block OCELOT_PLUSHIE = registerCatPlushie(OCELOT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TABBY_CAT_PLUSHIE_KEY = makeRegistryKey("tabby_cat_plushie");
    public static final Block TABBY_CAT_PLUSHIE = registerCatPlushie(TABBY_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TUXEDO_CAT_PLUSHIE_KEY = makeRegistryKey("tuxedo_cat_plushie");
    public static final Block TUXEDO_CAT_PLUSHIE = registerCatPlushie(TUXEDO_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> RED_CAT_PLUSHIE_KEY = makeRegistryKey("red_cat_plushie");
    public static final Block RED_CAT_PLUSHIE = registerCatPlushie(RED_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> SIAMESE_CAT_PLUSHIE_KEY = makeRegistryKey("siamese_cat_plushie");
    public static final Block SIAMESE_CAT_PLUSHIE = registerCatPlushie(SIAMESE_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> BRITISH_SHORTHAIR_CAT_PLUSHIE_KEY
            = makeRegistryKey("british_shorthair_cat_plushie");
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSHIE = registerCatPlushie(BRITISH_SHORTHAIR_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> CALICO_CAT_PLUSHIE_KEY = makeRegistryKey("calico_cat_plushie");
    public static final Block CALICO_CAT_PLUSHIE = registerCatPlushie(CALICO_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> PERSIAN_CAT_PLUSHIE_KEY = makeRegistryKey("persian_cat_plushie");
    public static final Block PERSIAN_CAT_PLUSHIE = registerCatPlushie(PERSIAN_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> RAGDOLL_CAT_PLUSHIE_KEY = makeRegistryKey("ragdoll_cat_plushie");
    public static final Block RAGDOLL_CAT_PLUSHIE = registerCatPlushie(RAGDOLL_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_CAT_PLUSHIE_KEY = makeRegistryKey("white_cat_plushie");
    public static final Block WHITE_CAT_PLUSHIE = registerCatPlushie(WHITE_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> JELLIE_CAT_PLUSHIE_KEY = makeRegistryKey("jellie_cat_plushie");
    public static final Block JELLIE_CAT_PLUSHIE = registerCatPlushie(JELLIE_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_CAT_PLUSHIE_KEY = makeRegistryKey("black_cat_plushie");
    public static final Block BLACK_CAT_PLUSHIE = registerCatPlushie(BLACK_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TEMPERATE_PIG_PLUSHIE_KEY
            = makeRegistryKey("temperate_pig_plushie");
    public static final Block TEMPERATE_PIG_PLUSHIE = registerPigPlushie(TEMPERATE_PIG_PLUSHIE_KEY);
    public static final ResourceKey<Block> COLD_PIG_PLUSHIE_KEY
            = makeRegistryKey("cold_pig_plushie");
    public static final Block COLD_PIG_PLUSHIE = registerPigPlushie(COLD_PIG_PLUSHIE_KEY);
    public static final ResourceKey<Block> WARM_PIG_PLUSHIE_KEY
            = makeRegistryKey("warm_pig_plushie");
    public static final Block WARM_PIG_PLUSHIE = registerPigPlushie(WARM_PIG_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_RABBIT_PLUSHIE_KEY = makeRegistryKey("brown_rabbit_plushie");
    public static final Block BROWN_RABBIT_PLUSHIE = registerRabbitPlushie(BROWN_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_RABBIT_PLUSHIE_KEY = makeRegistryKey("white_rabbit_plushie");
    public static final Block WHITE_RABBIT_PLUSHIE = registerRabbitPlushie(WHITE_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_RABBIT_PLUSHIE_KEY = makeRegistryKey("black_rabbit_plushie");
    public static final Block BLACK_RABBIT_PLUSHIE = registerRabbitPlushie(BLACK_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY
            = makeRegistryKey("white_splotched_rabbit_plushie");
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSHIE = registerRabbitPlushie(WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> GOLD_RABBIT_PLUSHIE_KEY = makeRegistryKey("gold_rabbit_plushie");
    public static final Block GOLD_RABBIT_PLUSHIE = registerRabbitPlushie(GOLD_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TOAST_RABBIT_PLUSHIE_KEY = makeRegistryKey("toast_rabbit_plushie");
    public static final Block TOAST_RABBIT_PLUSHIE = registerRabbitPlushie(TOAST_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> SALT_RABBIT_PLUSHIE_KEY = makeRegistryKey("salt_rabbit_plushie");
    public static final Block SALT_RABBIT_PLUSHIE = registerRabbitPlushie(SALT_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_SHEEP_PLUSHIE_KEY = makeRegistryKey("white_sheep_plushie");
    public static final Block WHITE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.WHITE, WHITE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> ORANGE_SHEEP_PLUSHIE_KEY = makeRegistryKey("orange_sheep_plushie");
    public static final Block ORANGE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.ORANGE, ORANGE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> MAGENTA_SHEEP_PLUSHIE_KEY = makeRegistryKey("magenta_sheep_plushie");
    public static final Block MAGENTA_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.MAGENTA, MAGENTA_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> LIGHT_BLUE_SHEEP_PLUSHIE_KEY
            = makeRegistryKey("light_blue_sheep_plushie");
    public static final Block LIGHT_BLUE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIGHT_BLUE, LIGHT_BLUE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> YELLOW_SHEEP_PLUSHIE_KEY = makeRegistryKey("yellow_sheep_plushie");
    public static final Block YELLOW_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.YELLOW, YELLOW_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> LIME_SHEEP_PLUSHIE_KEY = makeRegistryKey("lime_sheep_plushie");
    public static final Block LIME_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIME, LIME_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> PINK_SHEEP_PLUSHIE_KEY = makeRegistryKey("pink_sheep_plushie");
    public static final Block PINK_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.PINK, PINK_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> GRAY_SHEEP_PLUSHIE_KEY = makeRegistryKey("gray_sheep_plushie");
    public static final Block GRAY_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.GRAY, GRAY_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> LIGHT_GRAY_SHEEP_PLUSHIE_KEY = makeRegistryKey("light_gray_sheep_plushie");
    public static final Block LIGHT_GRAY_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIGHT_GRAY, LIGHT_GRAY_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> CYAN_SHEEP_PLUSHIE_KEY = makeRegistryKey("cyan_sheep_plushie");
    public static final Block CYAN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.CYAN, CYAN_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> PURPLE_SHEEP_PLUSHIE_KEY = makeRegistryKey("purple_sheep_plushie");
    public static final Block PURPLE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.PURPLE, PURPLE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLUE_SHEEP_PLUSHIE_KEY = makeRegistryKey("blue_sheep_plushie");
    public static final Block BLUE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BLUE, BLUE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_SHEEP_PLUSHIE_KEY = makeRegistryKey("brown_sheep_plushie");
    public static final Block BROWN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BROWN, BROWN_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> GREEN_SHEEP_PLUSHIE_KEY = makeRegistryKey("green_sheep_plushie");
    public static final Block GREEN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.GREEN, GREEN_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> RED_SHEEP_PLUSHIE_KEY = makeRegistryKey("red_sheep_plushie");
    public static final Block RED_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.RED, RED_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_SHEEP_PLUSHIE_KEY = makeRegistryKey("black_sheep_plushie");
    public static final Block BLACK_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BLACK, BLACK_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> SKELETON_PLUSHIE_KEY = makeRegistryKey("skeleton_plushie");
    public static final Block SKELETON_PLUSHIE
            = register(SKELETON_PLUSHIE_KEY, SkeletonPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> SLIME_PLUSHIE_KEY = makeRegistryKey("slime_plushie");
    public static final Block SLIME_PLUSHIE = registerCubePlushie(SLIME_PLUSHIE_KEY);
    public static final ResourceKey<Block> SPIDER_PLUSHIE_KEY = makeRegistryKey("spider_plushie");
    public static final Block SPIDER_PLUSHIE
            = register(SPIDER_PLUSHIE_KEY, SpiderPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> SQUID_PLUSHIE_KEY = makeRegistryKey("squid_plushie");
    public static final Block SQUID_PLUSHIE
            = register(SQUID_PLUSHIE_KEY, SquidPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> GLOW_SQUID_PLUSHIE_KEY = makeRegistryKey("glow_squid_plushie");
    public static final Block GLOW_SQUID_PLUSHIE
            = register(GLOW_SQUID_PLUSHIE_KEY, SquidPlushieBlock::new, makeGlowingPlushieSettings());
    public static final ResourceKey<Block> BEE_PLUSHIE_KEY = makeRegistryKey("bee_plushie");
    public static final Block BEE_PLUSHIE
            = register(BEE_PLUSHIE_KEY, BeePlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> PLAINS_VILLAGER_PLUSHIE_KEY = makeRegistryKey("plains_villager_plushie");
    public static final Block PLAINS_VILLAGER_PLUSHIE = registerVillagerPlushie(PLAINS_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> DESERT_VILLAGER_PLUSHIE_KEY = makeRegistryKey("desert_villager_plushie");
    public static final Block DESERT_VILLAGER_PLUSHIE
            = register(DESERT_VILLAGER_PLUSHIE_KEY, DesertVillagerPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> JUNGLE_VILLAGER_PLUSHIE_KEY = makeRegistryKey("jungle_villager_plushie");
    public static final Block JUNGLE_VILLAGER_PLUSHIE = registerVillagerPlushie(JUNGLE_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SAVANNA_VILLAGER_PLUSHIE_KEY
            = makeRegistryKey("savanna_villager_plushie");
    public static final Block SAVANNA_VILLAGER_PLUSHIE = registerVillagerPlushie(SAVANNA_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SNOWY_VILLAGER_PLUSHIE_KEY = makeRegistryKey("snowy_villager_plushie");
    public static final Block SNOWY_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(SNOWY_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SWAMP_VILLAGER_PLUSHIE_KEY = makeRegistryKey("swamp_villager_plushie");
    public static final Block SWAMP_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(SWAMP_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> TAIGA_VILLAGER_PLUSHIE_KEY = makeRegistryKey("taiga_villager_plushie");
    public static final Block TAIGA_VILLAGER_PLUSHIE = registerVillagerPlushie(TAIGA_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> WITCH_PLUSHIE_KEY = makeRegistryKey("witch_plushie");
    public static final Block WITCH_PLUSHIE
            = register(WITCH_PLUSHIE_KEY, WitchPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> PALE_WOLF_PLUSHIE_KEY = makeRegistryKey("pale_wolf_plushie");
    public static final Block PALE_WOLF_PLUSHIE = registerWolfPlushie(PALE_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> ZOMBIE_PLUSHIE_KEY = makeRegistryKey("zombie_plushie");
    public static final Block ZOMBIE_PLUSHIE = registerZombiePlushie(ZOMBIE_PLUSHIE_KEY);
    public static final ResourceKey<Block> PIGLIN_PLUSHIE_KEY = makeRegistryKey("piglin_plushie");
    public static final Block PIGLIN_PLUSHIE
            = register(PIGLIN_PLUSHIE_KEY, PiglinPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> ZOMBIFIED_PIGLIN_PLUSHIE_KEY = makeRegistryKey("zombified_piglin_plushie");
    public static final Block ZOMBIFIED_PIGLIN_PLUSHIE = registerZombiePlushie(ZOMBIFIED_PIGLIN_PLUSHIE_KEY);
    public static final ResourceKey<Block> PUFFERFISH_PLUSHIE_KEY = makeRegistryKey("pufferfish_plushie");
    public static final Block PUFFERFISH_PLUSHIE
            = register(PUFFERFISH_PLUSHIE_KEY, PufferfishPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> WITHER_PLUSHIE_KEY = makeRegistryKey("wither_plushie");
    public static final Block WITHER_PLUSHIE
            = register(WITHER_PLUSHIE_KEY, WitherPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> STRIDER_PLUSHIE_KEY = makeRegistryKey("strider_plushie");
    public static final Block STRIDER_PLUSHIE = registerStriderPlushie(STRIDER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SHIVERING_STRIDER_PLUSHIE_KEY
            = makeRegistryKey("shivering_strider_plushie");
    public static final Block SHIVERING_STRIDER_PLUSHIE = registerStriderPlushie(SHIVERING_STRIDER_PLUSHIE_KEY);
    public static final ResourceKey<Block> PHANTOM_PLUSHIE_KEY = makeRegistryKey("phantom_plushie");
    public static final Block PHANTOM_PLUSHIE
            = register(PHANTOM_PLUSHIE_KEY, PhantomPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> HOGLIN_PLUSHIE_KEY = makeRegistryKey("hoglin_plushie");
    public static final Block HOGLIN_PLUSHIE = registerHoglinPlushie(HOGLIN_PLUSHIE_KEY);
    public static final ResourceKey<Block> ZOGLIN_PLUSHIE_KEY = makeRegistryKey("zoglin_plushie");
    public static final Block ZOGLIN_PLUSHIE = registerHoglinPlushie(ZOGLIN_PLUSHIE_KEY);
    public static final ResourceKey<Block> ALLAY_PLUSHIE_KEY = makeRegistryKey("allay_plushie");
    public static final Block ALLAY_PLUSHIE = registerAllayPlushie(ALLAY_PLUSHIE_KEY);
    public static final ResourceKey<Block> PILLAGER_PLUSHIE_KEY = makeRegistryKey("pillager_plushie");
    public static final Block PILLAGER_PLUSHIE = registerVillagerPlushie(PILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> VINDICATOR_PLUSHIE_KEY = makeRegistryKey("vindicator_plushie");
    public static final Block VINDICATOR_PLUSHIE = registerVillagerPlushie(VINDICATOR_PLUSHIE_KEY);
    public static final ResourceKey<Block> EVOKER_PLUSHIE_KEY = makeRegistryKey("evoker_plushie");
    public static final Block EVOKER_PLUSHIE = registerVillagerPlushie(EVOKER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SHULKER_PLUSHIE_KEY = makeRegistryKey("shulker_plushie");
    public static final Block SHULKER_PLUSHIE
            = register(SHULKER_PLUSHIE_KEY, ShulkerPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> VEX_PLUSHIE_KEY = makeRegistryKey("vex_plushie");
    public static final Block VEX_PLUSHIE = registerAllayPlushie(VEX_PLUSHIE_KEY);
    public static final ResourceKey<Block> CAMEL_PLUSHIE_KEY = makeRegistryKey("camel_plushie");
    public static final Block CAMEL_PLUSHIE
            = register(CAMEL_PLUSHIE_KEY, CamelPlushieBlock::new, makePlushieSettings());
    public static final ResourceKey<Block> NETHER_SMOKY_QUARTZ_ORE_KEY = makeRegistryKey("nether_smoky_quartz_ore");
    public static final Block NETHER_SMOKY_QUARTZ_ORE = register(NETHER_SMOKY_QUARTZ_ORE_KEY,
            (props) -> new DropExperienceBlock(UniformInt.of(2, 5), props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE));
    public static final ResourceKey<Block> SMOKY_QUARTZ_BLOCK_KEY = makeRegistryKey("smoky_quartz_block");
    public static final Block SMOKY_QUARTZ_BLOCK = registerSimple(SMOKY_QUARTZ_BLOCK_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> CHISELED_SMOKY_QUARTZ_BLOCK_KEY
            = makeRegistryKey("chiseled_smoky_quartz_block");
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK
            = registerSimple(CHISELED_SMOKY_QUARTZ_BLOCK_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICKS_KEY = makeRegistryKey("smoky_quartz_bricks");
    public static final Block SMOKY_QUARTZ_BRICKS
            = registerSimple(SMOKY_QUARTZ_BRICKS_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICK_STAIRS_KEY
            = makeRegistryKey("smoky_quartz_brick_stairs");
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS
            = registerStairs(SMOKY_QUARTZ_BRICK_STAIRS_KEY, makeSmokyQuartzSettings(), SMOKY_QUARTZ_BRICKS);
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICK_SLAB_KEY
            = makeRegistryKey("smoky_quartz_brick_slab");
    public static final Block SMOKY_QUARTZ_BRICK_SLAB
            = registerSlab(SMOKY_QUARTZ_BRICK_SLAB_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICK_WALL_KEY = makeRegistryKey("smoky_quartz_brick_wall");
    public static final Block SMOKY_QUARTZ_BRICK_WALL
            = registerWall(SMOKY_QUARTZ_BRICK_WALL_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOKY_QUARTZ_PILLAR_KEY = makeRegistryKey("smoky_quartz_pillar");
    public static final Block SMOKY_QUARTZ_PILLAR
            = register(SMOKY_QUARTZ_PILLAR_KEY, RotatedPillarBlock::new, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOKY_QUARTZ_STAIRS_KEY = makeRegistryKey("smoky_quartz_stairs");
    public static final Block SMOKY_QUARTZ_STAIRS
            = registerStairs(SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(),
            SMOKY_QUARTZ_BLOCK);
    public static final ResourceKey<Block> SMOKY_QUARTZ_SLAB_KEY = makeRegistryKey("smoky_quartz_slab");
    public static final Block SMOKY_QUARTZ_SLAB = registerSlab(SMOKY_QUARTZ_SLAB_KEY,
            makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOKY_QUARTZ_WALL_KEY = makeRegistryKey("smoky_quartz_wall");
    public static final Block SMOKY_QUARTZ_WALL = registerWall(SMOKY_QUARTZ_WALL_KEY,
            makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_KEY = makeRegistryKey("smooth_smoky_quartz");
    public static final Block SMOOTH_SMOKY_QUARTZ
            = registerSimple(SMOOTH_SMOKY_QUARTZ_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_STAIRS_KEY
            = makeRegistryKey("smooth_smoky_quartz_stairs");
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS
            = registerStairs(SMOOTH_SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(), SMOOTH_SMOKY_QUARTZ);
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_SLAB_KEY
            = makeRegistryKey("smooth_smoky_quartz_slab");
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB
            = registerSlab(SMOOTH_SMOKY_QUARTZ_SLAB_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_WALL_KEY
            = makeRegistryKey("smooth_smoky_quartz_wall");
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL
            = registerWall(SMOOTH_SMOKY_QUARTZ_WALL_KEY, makeSmokyQuartzSettings());
    public static final ResourceKey<Block> CRACKED_STONE_BRICK_STAIRS_KEY
            = makeRegistryKey("cracked_stone_brick_stairs");
    public static final Block CRACKED_STONE_BRICK_STAIRS
            = registerStairs(CRACKED_STONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(CRACKED_STONE_BRICK_STAIRS_KEY), Blocks.CRACKED_STONE_BRICKS);
    public static final ResourceKey<Block> CRACKED_STONE_BRICK_SLAB_KEY
            = makeRegistryKey("cracked_stone_brick_slab");
    public static final Block CRACKED_STONE_BRICK_SLAB = registerSlab(CRACKED_STONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(CRACKED_STONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> CRACKED_STONE_BRICK_WALL_KEY
            = makeRegistryKey("cracked_stone_brick_wall");
    public static final Block CRACKED_STONE_BRICK_WALL = registerWall(CRACKED_STONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(CRACKED_STONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> BLUEBERRY_BUSH_KEY = makeRegistryKey("blueberry_bush");
    public static final Block BLUEBERRY_BUSH
            = register(BLUEBERRY_BUSH_KEY, BlueberryBushBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.GRASS)
                    .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH)
                    .pushReaction(PushReaction.DESTROY), false);
    public static final ResourceKey<Block> GREEN_ONIONS_KEY = makeRegistryKey("green_onions");
    public static final Block GREEN_ONIONS
            = register(GREEN_ONIONS_KEY, GreenOnionsBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY), false);
    public static final ResourceKey<Block> OAK_PLANTER_BOX_KEY = makeRegistryKey("oak_planter_box");
    public static final Block OAK_PLANTER_BOX
            = registerPlanterBox(OAK_PLANTER_BOX_KEY, Blocks.OAK_PLANKS.defaultMapColor(), SoundType.WOOD);
    public static final ResourceKey<Block> SPRUCE_PLANTER_BOX_KEY = makeRegistryKey("spruce_planter_box");
    public static final Block SPRUCE_PLANTER_BOX
            = registerPlanterBox(SPRUCE_PLANTER_BOX_KEY, Blocks.SPRUCE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> BIRCH_PLANTER_BOX_KEY = makeRegistryKey("birch_planter_box");
    public static final Block BIRCH_PLANTER_BOX
            = registerPlanterBox(BIRCH_PLANTER_BOX_KEY, Blocks.BIRCH_PLANKS.defaultMapColor(), SoundType.WOOD);
    public static final ResourceKey<Block> JUNGLE_PLANTER_BOX_KEY = makeRegistryKey("jungle_planter_box");
    public static final Block JUNGLE_PLANTER_BOX
            = registerPlanterBox(JUNGLE_PLANTER_BOX_KEY, Blocks.JUNGLE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> ACACIA_PLANTER_BOX_KEY = makeRegistryKey("acacia_planter_box");
    public static final Block ACACIA_PLANTER_BOX
            = registerPlanterBox(ACACIA_PLANTER_BOX_KEY, Blocks.ACACIA_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> DARK_OAK_PLANTER_BOX_KEY = makeRegistryKey("dark_oak_planter_box");
    public static final Block DARK_OAK_PLANTER_BOX
            = registerPlanterBox(DARK_OAK_PLANTER_BOX_KEY, Blocks.DARK_OAK_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> MANGROVE_PLANTER_BOX_KEY = makeRegistryKey("mangrove_planter_box");
    public static final Block MANGROVE_PLANTER_BOX
            = registerPlanterBox(MANGROVE_PLANTER_BOX_KEY, Blocks.MANGROVE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> CHERRY_PLANTER_BOX_KEY = makeRegistryKey("cherry_planter_box");
    public static final Block CHERRY_PLANTER_BOX
            = registerPlanterBox(CHERRY_PLANTER_BOX_KEY, Blocks.CHERRY_PLANKS.defaultMapColor(),
            SoundType.CHERRY_WOOD);
    public static final ResourceKey<Block> PALE_OAK_PLANTER_BOX_KEY = makeRegistryKey("pale_oak_planter_box");
    public static final Block PALE_OAK_PLANTER_BOX
            = registerPlanterBox(PALE_OAK_PLANTER_BOX_KEY, Blocks.PALE_OAK_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> CRIMSON_PLANTER_BOX_KEY = makeRegistryKey("crimson_planter_box");
    public static final Block CRIMSON_PLANTER_BOX
            = registerNetherPlanterBox(CRIMSON_PLANTER_BOX_KEY, Blocks.CRIMSON_PLANKS.defaultMapColor());
    public static final ResourceKey<Block> WARPED_PLANTER_BOX_KEY = makeRegistryKey("warped_planter_box");
    public static final Block WARPED_PLANTER_BOX
            = registerNetherPlanterBox(WARPED_PLANTER_BOX_KEY, Blocks.WARPED_PLANKS.defaultMapColor());
    public static final ResourceKey<Block> OAK_WALL_KEY = makeRegistryKey("oak_wall");
    public static final Block OAK_WALL = registerWall(OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(OAK_WALL_KEY));
    public static final ResourceKey<Block> SPRUCE_WALL_KEY = makeRegistryKey("spruce_wall");
    public static final Block SPRUCE_WALL = registerWall(SPRUCE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).setId(SPRUCE_WALL_KEY));
    public static final ResourceKey<Block> BIRCH_WALL_KEY = makeRegistryKey("birch_wall");
    public static final Block BIRCH_WALL = registerWall(BIRCH_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).setId(BIRCH_WALL_KEY));
    public static final ResourceKey<Block> JUNGLE_WALL_KEY = makeRegistryKey("jungle_wall");
    public static final Block JUNGLE_WALL = registerWall(JUNGLE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).setId(JUNGLE_WALL_KEY));
    public static final ResourceKey<Block> ACACIA_WALL_KEY = makeRegistryKey("acacia_wall");
    public static final Block ACACIA_WALL = registerWall(ACACIA_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).setId(ACACIA_WALL_KEY));
    public static final ResourceKey<Block> DARK_OAK_WALL_KEY = makeRegistryKey("dark_oak_wall");
    public static final Block DARK_OAK_WALL = registerWall(DARK_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).setId(DARK_OAK_WALL_KEY));
    public static final ResourceKey<Block> MANGROVE_WALL_KEY = makeRegistryKey("mangrove_wall");
    public static final Block MANGROVE_WALL = registerWall(MANGROVE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).setId(MANGROVE_WALL_KEY));
    public static final ResourceKey<Block> CRIMSON_WALL_KEY = makeRegistryKey("crimson_wall");
    public static final Block CRIMSON_WALL = registerWall(CRIMSON_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(CRIMSON_WALL_KEY));
    public static final ResourceKey<Block> WARPED_WALL_KEY = makeRegistryKey("warped_wall");
    public static final Block WARPED_WALL = registerWall(WARPED_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(WARPED_WALL_KEY));
    public static final ResourceKey<Block> CHERRY_WALL_KEY = makeRegistryKey("cherry_wall");
    public static final Block CHERRY_WALL = registerWall(CHERRY_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(CHERRY_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_OAK_WALL_KEY = makeRegistryKey("stripped_oak_wall");
    public static final Block STRIPPED_OAK_WALL = registerWall(STRIPPED_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(STRIPPED_OAK_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_SPRUCE_WALL_KEY = makeRegistryKey("stripped_spruce_wall");
    public static final Block STRIPPED_SPRUCE_WALL = registerWall(STRIPPED_SPRUCE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).setId(STRIPPED_SPRUCE_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_BIRCH_WALL_KEY = makeRegistryKey("stripped_birch_wall");
    public static final Block STRIPPED_BIRCH_WALL = registerWall(STRIPPED_BIRCH_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).setId(STRIPPED_BIRCH_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_JUNGLE_WALL_KEY = makeRegistryKey("stripped_jungle_wall");
    public static final Block STRIPPED_JUNGLE_WALL = registerWall(STRIPPED_JUNGLE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).setId(STRIPPED_JUNGLE_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_ACACIA_WALL_KEY = makeRegistryKey("stripped_acacia_wall");
    public static final Block STRIPPED_ACACIA_WALL = registerWall(STRIPPED_ACACIA_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).setId(STRIPPED_ACACIA_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_DARK_OAK_WALL_KEY = makeRegistryKey("stripped_dark_oak_wall");
    public static final Block STRIPPED_DARK_OAK_WALL = registerWall(STRIPPED_DARK_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).setId(STRIPPED_DARK_OAK_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_MANGROVE_WALL_KEY = makeRegistryKey("stripped_mangrove_wall");
    public static final Block STRIPPED_MANGROVE_WALL = registerWall(STRIPPED_MANGROVE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).setId(STRIPPED_MANGROVE_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_CRIMSON_WALL_KEY = makeRegistryKey("stripped_crimson_wall");
    public static final Block STRIPPED_CRIMSON_WALL = registerWall(STRIPPED_CRIMSON_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(STRIPPED_CRIMSON_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_WARPED_WALL_KEY = makeRegistryKey("stripped_warped_wall");
    public static final Block STRIPPED_WARPED_WALL = registerWall(STRIPPED_WARPED_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(STRIPPED_WARPED_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_CHERRY_WALL_KEY = makeRegistryKey("stripped_cherry_wall");
    public static final Block STRIPPED_CHERRY_WALL = registerWall(STRIPPED_CHERRY_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(STRIPPED_CHERRY_WALL_KEY));
    public static final ResourceKey<Block> OAK_ROPE_LADDER_KEY = makeRegistryKey("oak_rope_ladder");
    public static final Block OAK_ROPE_LADDER = registerRopeLadder(OAK_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> SPRUCE_ROPE_LADDER_KEY = makeRegistryKey("spruce_rope_ladder");
    public static final Block SPRUCE_ROPE_LADDER = registerRopeLadder(SPRUCE_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> BIRCH_ROPE_LADDER_KEY = makeRegistryKey("birch_rope_ladder");
    public static final Block BIRCH_ROPE_LADDER = registerRopeLadder(BIRCH_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> JUNGLE_ROPE_LADDER_KEY = makeRegistryKey("jungle_rope_ladder");
    public static final Block JUNGLE_ROPE_LADDER = registerRopeLadder(JUNGLE_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> ACACIA_ROPE_LADDER_KEY = makeRegistryKey("acacia_rope_ladder");
    public static final Block ACACIA_ROPE_LADDER = registerRopeLadder(ACACIA_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> DARK_OAK_ROPE_LADDER_KEY = makeRegistryKey("dark_oak_rope_ladder");
    public static final Block DARK_OAK_ROPE_LADDER = registerRopeLadder(DARK_OAK_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> CRIMSON_ROPE_LADDER_KEY = makeRegistryKey("crimson_rope_ladder");
    public static final Block CRIMSON_ROPE_LADDER = registerRopeLadder(CRIMSON_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> WARPED_ROPE_LADDER_KEY = makeRegistryKey("warped_rope_ladder");
    public static final Block WARPED_ROPE_LADDER = registerRopeLadder(WARPED_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> MANGROVE_ROPE_LADDER_KEY = makeRegistryKey("mangrove_rope_ladder");
    public static final Block MANGROVE_ROPE_LADDER = registerRopeLadder(MANGROVE_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> CHERRY_ROPE_LADDER_KEY = makeRegistryKey("cherry_rope_ladder");
    public static final Block CHERRY_ROPE_LADDER = registerRopeLadder(CHERRY_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> PALE_OAK_ROPE_LADDER_KEY = makeRegistryKey("pale_oak_rope_ladder");
    public static final Block PALE_OAK_ROPE_LADDER = registerRopeLadder(PALE_OAK_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> IRON_LADDER_KEY = makeRegistryKey("iron_ladder");
    public static final Block IRON_LADDER = register(IRON_LADDER_KEY, LadderBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops()
                    .strength(5.0F).sound(SoundType.METAL).noOcclusion());
    public static final ResourceKey<Block> SNOW_BRICKS_KEY = makeRegistryKey("snow_bricks");
    public static final Block SNOW_BRICKS = registerSimple(SNOW_BRICKS_KEY, makeSnowBrickSettings());
    public static final ResourceKey<Block> SNOW_BRICK_STAIRS_KEY = makeRegistryKey("snow_brick_stairs");
    public static final Block SNOW_BRICK_STAIRS
            = registerStairs(SNOW_BRICK_STAIRS_KEY, makeSnowBrickSettings(), SNOW_BRICKS);
    public static final ResourceKey<Block> SNOW_BRICK_SLAB_KEY = makeRegistryKey("snow_brick_slab");
    public static final Block SNOW_BRICK_SLAB
            = registerSlab(SNOW_BRICK_SLAB_KEY, makeSnowBrickSettings());
    public static final ResourceKey<Block> SNOW_BRICK_WALL_KEY = makeRegistryKey("snow_brick_wall");
    public static final Block SNOW_BRICK_WALL
            = registerWall(SNOW_BRICK_WALL_KEY, makeSnowBrickSettings());
    public static final ResourceKey<Block> PACKED_SNOW_KEY = makeRegistryKey("packed_snow");
    public static final Block PACKED_SNOW
            = registerSimple(PACKED_SNOW_KEY, makePackedSnowSettings());
    public static final ResourceKey<Block> PACKED_SNOW_STAIRS_KEY = makeRegistryKey("packed_snow_stairs");
    public static final Block PACKED_SNOW_STAIRS
            = registerStairs(PACKED_SNOW_STAIRS_KEY, makePackedSnowSettings(), PACKED_SNOW);
    public static final ResourceKey<Block> PACKED_SNOW_SLAB_KEY = makeRegistryKey("packed_snow_slab");
    public static final Block PACKED_SNOW_SLAB
            = registerSlab(PACKED_SNOW_SLAB_KEY, makePackedSnowSettings());
    public static final ResourceKey<Block> PACKED_SNOW_WALL_KEY = makeRegistryKey("packed_snow_wall");
    public static final Block PACKED_SNOW_WALL
            = registerWall(PACKED_SNOW_WALL_KEY, makePackedSnowSettings());
    public static final ResourceKey<Block> PURPLE_MUSHROOM_KEY = makeRegistryKey("purple_mushroom");
    public static final Block PURPLE_MUSHROOM = register(PURPLE_MUSHROOM_KEY,
            (props) -> new MushroomBlock(ModTreeConfiguredFeatures.HUGE_PURPLE_MUSHROOM, props),
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .pushReaction(PushReaction.DESTROY).noCollision().randomTicks().instabreak()
                    .sound(SoundType.GRASS).hasPostProcess(ModBlocks::always));
    public static final ResourceKey<Block> PURPLE_MUSHROOM_BLOCK_KEY = makeRegistryKey("purple_mushroom_block");
    public static final Block PURPLE_MUSHROOM_BLOCK = register(PURPLE_MUSHROOM_BLOCK_KEY, PurpleMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .instrument(NoteBlockInstrument.BASS).strength(0.2F)
                    .sound(SoundType.WOOD).ignitedByLava());
    public static final ResourceKey<Block> WHITE_CAMPFIRE_KEY = makeRegistryKey("white_campfire");
    public static final Block WHITE_CAMPFIRE
            = registerDyedCampfire(WHITE_CAMPFIRE_KEY, ModParticleTypes.WHITE_EMBER);
    public static final ResourceKey<Block> ORANGE_CAMPFIRE_KEY = makeRegistryKey("orange_campfire");
    public static final Block ORANGE_CAMPFIRE
            = registerDyedCampfire(ORANGE_CAMPFIRE_KEY, ModParticleTypes.ORANGE_EMBER);
    public static final ResourceKey<Block> MAGENTA_CAMPFIRE_KEY = makeRegistryKey("magenta_campfire");
    public static final Block MAGENTA_CAMPFIRE
            = registerDyedCampfire(MAGENTA_CAMPFIRE_KEY, ModParticleTypes.MAGENTA_EMBER);
    public static final ResourceKey<Block> LIGHT_BLUE_CAMPFIRE_KEY = makeRegistryKey("light_blue_campfire");
    public static final Block LIGHT_BLUE_CAMPFIRE
            = registerDyedCampfire(LIGHT_BLUE_CAMPFIRE_KEY, ModParticleTypes.LIGHT_BLUE_EMBER);
    public static final ResourceKey<Block> YELLOW_CAMPFIRE_KEY = makeRegistryKey("yellow_campfire");
    public static final Block YELLOW_CAMPFIRE
            = registerDyedCampfire(YELLOW_CAMPFIRE_KEY, ModParticleTypes.YELLOW_EMBER);
    public static final ResourceKey<Block> LIME_CAMPFIRE_KEY = makeRegistryKey("lime_campfire");
    public static final Block LIME_CAMPFIRE = registerDyedCampfire(LIME_CAMPFIRE_KEY, ModParticleTypes.LIME_EMBER);
    public static final ResourceKey<Block> PINK_CAMPFIRE_KEY = makeRegistryKey("pink_campfire");
    public static final Block PINK_CAMPFIRE = registerDyedCampfire(PINK_CAMPFIRE_KEY, ModParticleTypes.PINK_EMBER);
    public static final ResourceKey<Block> GRAY_CAMPFIRE_KEY = makeRegistryKey("gray_campfire");
    public static final Block GRAY_CAMPFIRE = registerDyedCampfire(GRAY_CAMPFIRE_KEY, ModParticleTypes.GRAY_EMBER);
    public static final ResourceKey<Block> LIGHT_GRAY_CAMPFIRE_KEY = makeRegistryKey("light_gray_campfire");
    public static final Block LIGHT_GRAY_CAMPFIRE
            = registerDyedCampfire(LIGHT_GRAY_CAMPFIRE_KEY, ModParticleTypes.LIGHT_GRAY_EMBER);
    public static final ResourceKey<Block> CYAN_CAMPFIRE_KEY = makeRegistryKey("cyan_campfire");
    public static final Block CYAN_CAMPFIRE = registerDyedCampfire(CYAN_CAMPFIRE_KEY, ModParticleTypes.CYAN_EMBER);
    public static final ResourceKey<Block> PURPLE_CAMPFIRE_KEY = makeRegistryKey("purple_campfire");
    public static final Block PURPLE_CAMPFIRE = registerDyedCampfire(PURPLE_CAMPFIRE_KEY, ModParticleTypes.PURPLE_EMBER);
    public static final ResourceKey<Block> BLUE_CAMPFIRE_KEY = makeRegistryKey("blue_campfire");
    public static final Block BLUE_CAMPFIRE = registerDyedCampfire(BLUE_CAMPFIRE_KEY, ModParticleTypes.BLUE_EMBER);
    public static final ResourceKey<Block> BROWN_CAMPFIRE_KEY = makeRegistryKey("brown_campfire");
    public static final Block BROWN_CAMPFIRE = registerDyedCampfire(BROWN_CAMPFIRE_KEY, ModParticleTypes.BROWN_EMBER);
    public static final ResourceKey<Block> GREEN_CAMPFIRE_KEY = makeRegistryKey("green_campfire");
    public static final Block GREEN_CAMPFIRE = registerDyedCampfire(GREEN_CAMPFIRE_KEY, ModParticleTypes.GREEN_EMBER);
    public static final ResourceKey<Block> RED_CAMPFIRE_KEY = makeRegistryKey("red_campfire");
    public static final Block RED_CAMPFIRE = registerDyedCampfire(RED_CAMPFIRE_KEY, ModParticleTypes.RED_EMBER);
    public static final ResourceKey<Block> BLACK_CAMPFIRE_KEY = makeRegistryKey("black_campfire");
    public static final Block BLACK_CAMPFIRE = registerDyedCampfire(BLACK_CAMPFIRE_KEY, ModParticleTypes.BLACK_EMBER);
    public static final ResourceKey<Block> WHITE_LANTERN_KEY = makeRegistryKey("white_lantern");
    public static final Block WHITE_LANTERN = registerLantern(WHITE_LANTERN_KEY);
    public static final ResourceKey<Block> ORANGE_LANTERN_KEY = makeRegistryKey("orange_lantern");
    public static final Block ORANGE_LANTERN = registerLantern(ORANGE_LANTERN_KEY);
    public static final ResourceKey<Block> MAGENTA_LANTERN_KEY = makeRegistryKey("magenta_lantern");
    public static final Block MAGENTA_LANTERN = registerLantern(MAGENTA_LANTERN_KEY);
    public static final ResourceKey<Block> LIGHT_BLUE_LANTERN_KEY = makeRegistryKey("light_blue_lantern");
    public static final Block LIGHT_BLUE_LANTERN = registerLantern(LIGHT_BLUE_LANTERN_KEY);
    public static final ResourceKey<Block> YELLOW_LANTERN_KEY = makeRegistryKey("yellow_lantern");
    public static final Block YELLOW_LANTERN = registerLantern(YELLOW_LANTERN_KEY);
    public static final ResourceKey<Block> LIME_LANTERN_KEY = makeRegistryKey("lime_lantern");
    public static final Block LIME_LANTERN = registerLantern(LIME_LANTERN_KEY);
    public static final ResourceKey<Block> PINK_LANTERN_KEY = makeRegistryKey("pink_lantern");
    public static final Block PINK_LANTERN = registerLantern(PINK_LANTERN_KEY);
    public static final ResourceKey<Block> GRAY_LANTERN_KEY = makeRegistryKey("gray_lantern");
    public static final Block GRAY_LANTERN = registerLantern(GRAY_LANTERN_KEY);
    public static final ResourceKey<Block> LIGHT_GRAY_LANTERN_KEY = makeRegistryKey("light_gray_lantern");
    public static final Block LIGHT_GRAY_LANTERN = registerLantern(LIGHT_GRAY_LANTERN_KEY);
    public static final ResourceKey<Block> CYAN_LANTERN_KEY = makeRegistryKey("cyan_lantern");
    public static final Block CYAN_LANTERN = registerLantern(CYAN_LANTERN_KEY);
    public static final ResourceKey<Block> PURPLE_LANTERN_KEY = makeRegistryKey("purple_lantern");
    public static final Block PURPLE_LANTERN = registerLantern(PURPLE_LANTERN_KEY);
    public static final ResourceKey<Block> BLUE_LANTERN_KEY = makeRegistryKey("blue_lantern");
    public static final Block BLUE_LANTERN = registerLantern(BLUE_LANTERN_KEY);
    public static final ResourceKey<Block> BROWN_LANTERN_KEY = makeRegistryKey("brown_lantern");
    public static final Block BROWN_LANTERN = registerLantern(BROWN_LANTERN_KEY);
    public static final ResourceKey<Block> GREEN_LANTERN_KEY = makeRegistryKey("green_lantern");
    public static final Block GREEN_LANTERN = registerLantern(GREEN_LANTERN_KEY);
    public static final ResourceKey<Block> RED_LANTERN_KEY = makeRegistryKey("red_lantern");
    public static final Block RED_LANTERN = registerLantern(RED_LANTERN_KEY);
    public static final ResourceKey<Block> BLACK_LANTERN_KEY = makeRegistryKey("black_lantern");
    public static final Block BLACK_LANTERN = registerLantern(BLACK_LANTERN_KEY);
    public static final ResourceKey<Block> WHITE_TORCH_KEY = makeRegistryKey("white_torch");
    public static final Block WHITE_TORCH = registerTorch(WHITE_TORCH_KEY, ModParticleTypes.WHITE_FLAME);
    public static final ResourceKey<Block> ORANGE_TORCH_KEY = makeRegistryKey("orange_torch");
    public static final Block ORANGE_TORCH = registerTorch(ORANGE_TORCH_KEY, ModParticleTypes.ORANGE_FLAME);
    public static final ResourceKey<Block> MAGENTA_TORCH_KEY = makeRegistryKey("magenta_torch");
    public static final Block MAGENTA_TORCH = registerTorch(MAGENTA_TORCH_KEY, ModParticleTypes.MAGENTA_FLAME);
    public static final ResourceKey<Block> LIGHT_BLUE_TORCH_KEY = makeRegistryKey("light_blue_torch");
    public static final Block LIGHT_BLUE_TORCH = registerTorch(LIGHT_BLUE_TORCH_KEY, ModParticleTypes.LIGHT_BLUE_FLAME);
    public static final ResourceKey<Block> YELLOW_TORCH_KEY = makeRegistryKey("yellow_torch");
    public static final Block YELLOW_TORCH = registerTorch(YELLOW_TORCH_KEY, ModParticleTypes.YELLOW_FLAME);
    public static final ResourceKey<Block> LIME_TORCH_KEY = makeRegistryKey("lime_torch");
    public static final Block LIME_TORCH = registerTorch(LIME_TORCH_KEY, ModParticleTypes.LIME_FLAME);
    public static final ResourceKey<Block> PINK_TORCH_KEY = makeRegistryKey("pink_torch");
    public static final Block PINK_TORCH = registerTorch(PINK_TORCH_KEY, ModParticleTypes.PINK_FLAME);
    public static final ResourceKey<Block> GRAY_TORCH_KEY = makeRegistryKey("gray_torch");
    public static final Block GRAY_TORCH = registerTorch(GRAY_TORCH_KEY, ModParticleTypes.GRAY_FLAME);
    public static final ResourceKey<Block> LIGHT_GRAY_TORCH_KEY = makeRegistryKey("light_gray_torch");
    public static final Block LIGHT_GRAY_TORCH = registerTorch(LIGHT_GRAY_TORCH_KEY, ModParticleTypes.LIGHT_GRAY_FLAME);
    public static final ResourceKey<Block> CYAN_TORCH_KEY = makeRegistryKey("cyan_torch");
    public static final Block CYAN_TORCH = registerTorch(CYAN_TORCH_KEY, ModParticleTypes.CYAN_FLAME);
    public static final ResourceKey<Block> PURPLE_TORCH_KEY = makeRegistryKey("purple_torch");
    public static final Block PURPLE_TORCH = registerTorch(PURPLE_TORCH_KEY, ModParticleTypes.PURPLE_FLAME);
    public static final ResourceKey<Block> BLUE_TORCH_KEY = makeRegistryKey("blue_torch");
    public static final Block BLUE_TORCH = registerTorch(BLUE_TORCH_KEY, ModParticleTypes.BLUE_FLAME);
    public static final ResourceKey<Block> BROWN_TORCH_KEY = makeRegistryKey("brown_torch");
    public static final Block BROWN_TORCH = registerTorch(BROWN_TORCH_KEY, ModParticleTypes.BROWN_FLAME);
    public static final ResourceKey<Block> GREEN_TORCH_KEY = makeRegistryKey("green_torch");
    public static final Block GREEN_TORCH = registerTorch(GREEN_TORCH_KEY, ModParticleTypes.GREEN_FLAME);
    public static final ResourceKey<Block> RED_TORCH_KEY = makeRegistryKey("red_torch");
    public static final Block RED_TORCH = registerTorch(RED_TORCH_KEY, ModParticleTypes.RED_FLAME);
    public static final ResourceKey<Block> BLACK_TORCH_KEY = makeRegistryKey("black_torch");
    public static final Block BLACK_TORCH = registerTorch(BLACK_TORCH_KEY, ModParticleTypes.BLACK_FLAME);
    public static final ResourceKey<Block> WHITE_WALL_TORCH_KEY = makeRegistryKey("white_wall_torch");
    public static final Block WHITE_WALL_TORCH = registerWallTorch(WHITE_WALL_TORCH_KEY, WHITE_TORCH, ModParticleTypes.WHITE_FLAME);
    public static final ResourceKey<Block> ORANGE_WALL_TORCH_KEY = makeRegistryKey("orange_wall_torch");
    public static final Block ORANGE_WALL_TORCH = registerWallTorch(ORANGE_WALL_TORCH_KEY, ORANGE_TORCH, ModParticleTypes.ORANGE_FLAME);
    public static final ResourceKey<Block> MAGENTA_WALL_TORCH_KEY = makeRegistryKey("magenta_wall_torch");
    public static final Block MAGENTA_WALL_TORCH = registerWallTorch(MAGENTA_WALL_TORCH_KEY, MAGENTA_TORCH, ModParticleTypes.MAGENTA_FLAME);
    public static final ResourceKey<Block> LIGHT_BLUE_WALL_TORCH_KEY = makeRegistryKey("light_blue_wall_torch");
    public static final Block LIGHT_BLUE_WALL_TORCH = registerWallTorch(LIGHT_BLUE_WALL_TORCH_KEY, LIGHT_BLUE_TORCH, ModParticleTypes.LIGHT_BLUE_FLAME);
    public static final ResourceKey<Block> YELLOW_WALL_TORCH_KEY = makeRegistryKey("yellow_wall_torch");
    public static final Block YELLOW_WALL_TORCH = registerWallTorch(YELLOW_WALL_TORCH_KEY, YELLOW_TORCH, ModParticleTypes.YELLOW_FLAME);
    public static final ResourceKey<Block> LIME_WALL_TORCH_KEY = makeRegistryKey("lime_wall_torch");
    public static final Block LIME_WALL_TORCH = registerWallTorch(LIME_WALL_TORCH_KEY, LIME_TORCH, ModParticleTypes.LIME_FLAME);
    public static final ResourceKey<Block> PINK_WALL_TORCH_KEY = makeRegistryKey("pink_wall_torch");
    public static final Block PINK_WALL_TORCH = registerWallTorch(PINK_WALL_TORCH_KEY, PINK_TORCH, ModParticleTypes.PINK_FLAME);
    public static final ResourceKey<Block> GRAY_WALL_TORCH_KEY = makeRegistryKey("gray_wall_torch");
    public static final Block GRAY_WALL_TORCH = registerWallTorch(GRAY_WALL_TORCH_KEY, GRAY_TORCH, ModParticleTypes.GRAY_FLAME);
    public static final ResourceKey<Block> LIGHT_GRAY_WALL_TORCH_KEY = makeRegistryKey("light_gray_wall_torch");
    public static final Block LIGHT_GRAY_WALL_TORCH = registerWallTorch(LIGHT_GRAY_WALL_TORCH_KEY, LIGHT_GRAY_TORCH, ModParticleTypes.LIGHT_GRAY_FLAME);
    public static final ResourceKey<Block> CYAN_WALL_TORCH_KEY = makeRegistryKey("cyan_wall_torch");
    public static final Block CYAN_WALL_TORCH = registerWallTorch(CYAN_WALL_TORCH_KEY, CYAN_TORCH, ModParticleTypes.CYAN_FLAME);
    public static final ResourceKey<Block> PURPLE_WALL_TORCH_KEY = makeRegistryKey("purple_wall_torch");
    public static final Block PURPLE_WALL_TORCH = registerWallTorch(PURPLE_WALL_TORCH_KEY, PURPLE_TORCH, ModParticleTypes.PURPLE_FLAME);
    public static final ResourceKey<Block> BLUE_WALL_TORCH_KEY = makeRegistryKey("blue_wall_torch");
    public static final Block BLUE_WALL_TORCH = registerWallTorch(BLUE_WALL_TORCH_KEY, BLUE_TORCH, ModParticleTypes.BLUE_FLAME);
    public static final ResourceKey<Block> BROWN_WALL_TORCH_KEY = makeRegistryKey("brown_wall_torch");
    public static final Block BROWN_WALL_TORCH = registerWallTorch(BROWN_WALL_TORCH_KEY, BROWN_TORCH, ModParticleTypes.BROWN_FLAME);
    public static final ResourceKey<Block> GREEN_WALL_TORCH_KEY = makeRegistryKey("green_wall_torch");
    public static final Block GREEN_WALL_TORCH = registerWallTorch(GREEN_WALL_TORCH_KEY, GREEN_TORCH, ModParticleTypes.GREEN_FLAME);
    public static final ResourceKey<Block> RED_WALL_TORCH_KEY = makeRegistryKey("red_wall_torch");
    public static final Block RED_WALL_TORCH = registerWallTorch(RED_WALL_TORCH_KEY, RED_TORCH, ModParticleTypes.RED_FLAME);
    public static final ResourceKey<Block> BLACK_WALL_TORCH_KEY = makeRegistryKey("black_wall_torch");
    public static final Block BLACK_WALL_TORCH = registerWallTorch(BLACK_WALL_TORCH_KEY, BLACK_TORCH, ModParticleTypes.BLACK_FLAME);
    public static final ResourceKey<Block> WITCHS_CRADLE_KEY = makeRegistryKey("witchs_cradle");
    public static final Block WITCHS_CRADLE = register(WITCHS_CRADLE_KEY, WitchsCradleBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                    .lightLevel((state) -> 8), false);
    public static final ResourceKey<Block> BAUXITE_KEY = makeRegistryKey("bauxite");
    public static final Block BAUXITE = registerSimple(BAUXITE_KEY, makeBauxiteSettings());
    public static final ResourceKey<Block> BAUXITE_SLAB_KEY = makeRegistryKey("bauxite_slab");
    public static final Block BAUXITE_SLAB = registerSlab(BAUXITE_SLAB_KEY, makeBauxiteSettings());
    public static final ResourceKey<Block> BAUXITE_STAIRS_KEY = makeRegistryKey("bauxite_stairs");
    public static final Block BAUXITE_STAIRS
            = registerStairs(BAUXITE_STAIRS_KEY, makeBauxiteSettings(), BAUXITE);
    public static final ResourceKey<Block> BAUXITE_WALL_KEY = makeRegistryKey("bauxite_wall");
    public static final Block BAUXITE_WALL = registerWall(BAUXITE_WALL_KEY, makeBauxiteSettings());
    public static final ResourceKey<Block> BAUXITE_BRICKS_KEY = makeRegistryKey("bauxite_bricks");
    public static final Block BAUXITE_BRICKS = registerSimple(BAUXITE_BRICKS_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> BAUXITE_BRICK_STAIRS_KEY = makeRegistryKey("bauxite_brick_stairs");
    public static final Block BAUXITE_BRICK_STAIRS
            = registerStairs(BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(), BAUXITE_BRICKS);
    public static final ResourceKey<Block> BAUXITE_BRICK_SLAB_KEY = makeRegistryKey("bauxite_brick_slab");
    public static final Block BAUXITE_BRICK_SLAB
            = registerSlab(BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> BAUXITE_BRICK_WALL_KEY = makeRegistryKey("bauxite_brick_wall");
    public static final Block BAUXITE_BRICK_WALL
            = registerWall(BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICKS_KEY = makeRegistryKey("mossy_bauxite_bricks");
    public static final Block MOSSY_BAUXITE_BRICKS
            = registerSimple(MOSSY_BAUXITE_BRICKS_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICK_STAIRS_KEY
            = makeRegistryKey("mossy_bauxite_brick_stairs");
    public static final Block MOSSY_BAUXITE_BRICK_STAIRS
            = registerStairs(MOSSY_BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(), MOSSY_BAUXITE_BRICKS);
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICK_SLAB_KEY
            = makeRegistryKey("mossy_bauxite_brick_slab");
    public static final Block MOSSY_BAUXITE_BRICK_SLAB
            = registerSlab(MOSSY_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICK_WALL_KEY
            = makeRegistryKey("mossy_bauxite_brick_wall");
    public static final Block MOSSY_BAUXITE_BRICK_WALL
            = registerWall(MOSSY_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICKS_KEY = makeRegistryKey("cracked_bauxite_bricks");
    public static final Block CRACKED_BAUXITE_BRICKS
            = registerSimple(CRACKED_BAUXITE_BRICKS_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICK_STAIRS_KEY
            = makeRegistryKey("cracked_bauxite_brick_stairs");
    public static final Block CRACKED_BAUXITE_BRICK_STAIRS
            = registerStairs(CRACKED_BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(), CRACKED_BAUXITE_BRICKS);
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICK_SLAB_KEY
            = makeRegistryKey("cracked_bauxite_brick_slab");
    public static final Block CRACKED_BAUXITE_BRICK_SLAB
            = registerSlab(CRACKED_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICK_WALL_KEY
            = makeRegistryKey("cracked_bauxite_brick_wall");
    public static final Block CRACKED_BAUXITE_BRICK_WALL
            = registerWall(CRACKED_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings());
    public static final ResourceKey<Block> TWISTED_NETHER_BRICKS_KEY = makeRegistryKey("twisted_nether_bricks");
    public static final Block TWISTED_NETHER_BRICKS
            = registerSimple(TWISTED_NETHER_BRICKS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final ResourceKey<Block> TWISTED_NETHER_BRICK_STAIRS_KEY
            = makeRegistryKey("twisted_nether_brick_stairs");
    public static final Block TWISTED_NETHER_BRICK_STAIRS
            = registerStairs(TWISTED_NETHER_BRICK_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(TWISTED_NETHER_BRICK_STAIRS_KEY), TWISTED_NETHER_BRICKS);
    public static final ResourceKey<Block> TWISTED_NETHER_BRICK_SLAB_KEY
            = makeRegistryKey("twisted_nether_brick_slab");
    public static final Block TWISTED_NETHER_BRICK_SLAB
            = registerSlab(TWISTED_NETHER_BRICK_SLAB_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(TWISTED_NETHER_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_NETHER_BRICK_WALL_KEY
            = makeRegistryKey("twisted_nether_brick_wall");
    public static final Block TWISTED_NETHER_BRICK_WALL
            = registerWall(TWISTED_NETHER_BRICK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(TWISTED_NETHER_BRICK_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_NETHERRACK_KEY = makeRegistryKey("twisted_netherrack");
    public static final Block TWISTED_NETHERRACK
            = registerSimple(TWISTED_NETHERRACK_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final ResourceKey<Block> TWISTED_NETHERRACK_STAIRS_KEY
            = makeRegistryKey("twisted_netherrack_stairs");
    public static final Block TWISTED_NETHERRACK_STAIRS = registerStairs(TWISTED_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(TWISTED_NETHERRACK_STAIRS_KEY),
            TWISTED_NETHERRACK);
    public static final ResourceKey<Block> TWISTED_NETHERRACK_SLAB_KEY
            = makeRegistryKey("twisted_netherrack_slab");
    public static final Block TWISTED_NETHERRACK_SLAB = registerSlab(TWISTED_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(TWISTED_NETHERRACK_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_NETHERRACK_WALL_KEY
            = makeRegistryKey("twisted_netherrack_wall");
    public static final Block TWISTED_NETHERRACK_WALL = registerWall(TWISTED_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(TWISTED_NETHERRACK_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_NETHER_BRICKS_KEY = makeRegistryKey("weeping_nether_bricks");
    public static final Block WEEPING_NETHER_BRICKS
            = registerSimple(WEEPING_NETHER_BRICKS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS));
    public static final ResourceKey<Block> WEEPING_NETHER_BRICK_STAIRS_KEY
            = makeRegistryKey("weeping_nether_brick_stairs");
    public static final Block WEEPING_NETHER_BRICK_STAIRS = registerStairs(WEEPING_NETHER_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(WEEPING_NETHER_BRICK_STAIRS_KEY), WEEPING_NETHER_BRICKS);
    public static final ResourceKey<Block> WEEPING_NETHER_BRICK_SLAB_KEY
            = makeRegistryKey("weeping_nether_brick_slab");
    public static final Block WEEPING_NETHER_BRICK_SLAB = registerSlab(WEEPING_NETHER_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                .setId(WEEPING_NETHER_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_NETHER_BRICK_WALL_KEY
            = makeRegistryKey("weeping_nether_brick_wall");
    public static final Block WEEPING_NETHER_BRICK_WALL = registerWall(WEEPING_NETHER_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                .setId(WEEPING_NETHER_BRICK_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_NETHERRACK_KEY = makeRegistryKey("weeping_netherrack");
    public static final Block WEEPING_NETHERRACK
            = registerSimple(WEEPING_NETHERRACK_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK));
    public static final ResourceKey<Block> WEEPING_NETHERRACK_STAIRS_KEY
            = makeRegistryKey("weeping_netherrack_stairs");
    public static final Block WEEPING_NETHERRACK_STAIRS = registerStairs(WEEPING_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .setId(WEEPING_NETHERRACK_STAIRS_KEY), WEEPING_NETHERRACK);
    public static final ResourceKey<Block> WEEPING_NETHERRACK_SLAB_KEY
            = makeRegistryKey("weeping_netherrack_slab");
    public static final Block WEEPING_NETHERRACK_SLAB = registerSlab(WEEPING_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .setId(WEEPING_NETHERRACK_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_NETHERRACK_WALL_KEY = makeRegistryKey("weeping_netherrack_wall");
    public static final Block WEEPING_NETHERRACK_WALL = registerWall(WEEPING_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(WEEPING_NETHERRACK_WALL_KEY));
    public static final ResourceKey<Block> SNAPDRAGON_KEY = makeRegistryKey("snapdragon");
    public static final Block SNAPDRAGON
            = register(SNAPDRAGON_KEY,
            (props) -> new SnapdragonBlock(MobEffects.LUCK, 8, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)
                    .lightLevel((state) -> 8));
    public static final ResourceKey<Block> POTTED_SNAPDRAGON_KEY = makeRegistryKey("potted_snapdragon");
    public static final Block POTTED_SNAPDRAGON = registerPottedSnapdragon();
    public static final ResourceKey<Block> POTTED_PURPLE_MUSHROOM_KEY = makeRegistryKey("potted_purple_mushroom");
    public static final Block POTTED_PURPLE_MUSHROOM = register(POTTED_PURPLE_MUSHROOM_KEY,
            (props) -> new FlowerPotBlock(ModBlocks.PURPLE_MUSHROOM, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM), false);
    public static final ResourceKey<Block> SHORT_ENDER_GRASS_KEY = makeRegistryKey("short_ender_grass");
    public static final Block SHORT_ENDER_GRASS
        = register(SHORT_ENDER_GRASS_KEY, ShortEnderGrassBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
                    .lightLevel((state) -> 8));
    public static final ResourceKey<Block> CATTAIL_KEY = makeRegistryKey("cattail");
    public static final Block CATTAIL = register(CATTAIL_KEY, CattailBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)
                    .noCollision().noOcclusion().sound(SoundType.WET_GRASS));
    public static final ResourceKey<Block> CHOCOLATE_CAKE_KEY = makeRegistryKey("chocolate_cake");
    public static final Block CHOCOLATE_CAKE = registerCake(CHOCOLATE_CAKE_KEY);
    public static final ResourceKey<Block> RED_VELVET_CAKE_KEY = makeRegistryKey("red_velvet_cake");
    public static final Block RED_VELVET_CAKE = registerCake(RED_VELVET_CAKE_KEY);
    public static final ResourceKey<Block> CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("candle_chocolate_cake");
    public static final Block CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(CANDLE_CHOCOLATE_CAKE_KEY, Blocks.CANDLE);
    public static final ResourceKey<Block> WHITE_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("white_candle_chocolate_cake");
    public static final Block WHITE_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(WHITE_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.WHITE_CANDLE);
    public static final ResourceKey<Block> ORANGE_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("orange_candle_chocolate_cake");
    public static final Block ORANGE_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(ORANGE_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.ORANGE_CANDLE);
    public static final ResourceKey<Block> MAGENTA_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("magenta_candle_chocolate_cake");
    public static final Block MAGENTA_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(MAGENTA_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.MAGENTA_CANDLE);
    public static final ResourceKey<Block> LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("light_blue_candle_chocolate_cake");
    public static final Block LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.LIGHT_BLUE_CANDLE);
    public static final ResourceKey<Block> YELLOW_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("yellow_candle_chocolate_cake");
    public static final Block YELLOW_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(YELLOW_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.YELLOW_CANDLE);
    public static final ResourceKey<Block> LIME_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("lime_candle_chocolate_cake");
    public static final Block LIME_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(LIME_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.LIME_CANDLE);
    public static final ResourceKey<Block> PINK_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("pink_candle_chocolate_cake");
    public static final Block PINK_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(PINK_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.PINK_CANDLE);
    public static final ResourceKey<Block> GRAY_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("gray_candle_chocolate_cake");
    public static final Block GRAY_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(GRAY_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.GRAY_CANDLE);
    public static final ResourceKey<Block> LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("light_gray_candle_chocolate_cake");
    public static final Block LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.LIGHT_GRAY_CANDLE);
    public static final ResourceKey<Block> CYAN_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("cyan_candle_chocolate_cake");
    public static final Block CYAN_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(CYAN_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.CYAN_CANDLE);
    public static final ResourceKey<Block> PURPLE_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("purple_candle_chocolate_cake");
    public static final Block PURPLE_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(PURPLE_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.PURPLE_CANDLE);
    public static final ResourceKey<Block> BLUE_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("blue_candle_chocolate_cake");
    public static final Block BLUE_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(BLUE_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.BLUE_CANDLE);
    public static final ResourceKey<Block> BROWN_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("brown_candle_chocolate_cake");
    public static final Block BROWN_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(BROWN_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.BROWN_CANDLE);
    public static final ResourceKey<Block> GREEN_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("green_candle_chocolate_cake");
    public static final Block GREEN_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(GREEN_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.GREEN_CANDLE);
    public static final ResourceKey<Block> RED_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("red_candle_chocolate_cake");
    public static final Block RED_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(RED_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.RED_CANDLE);
    public static final ResourceKey<Block> BLACK_CANDLE_CHOCOLATE_CAKE_KEY
            = makeRegistryKey("black_candle_chocolate_cake");
    public static final Block BLACK_CANDLE_CHOCOLATE_CAKE
            = registerChocolateCandleCake(BLACK_CANDLE_CHOCOLATE_CAKE_KEY, Blocks.BLACK_CANDLE);
    public static final ResourceKey<Block> CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("candle_red_velvet_cake");
    public static final Block CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(CANDLE_RED_VELVET_CAKE_KEY, Blocks.CANDLE);
    public static final ResourceKey<Block> WHITE_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("white_candle_red_velvet_cake");
    public static final Block WHITE_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(WHITE_CANDLE_RED_VELVET_CAKE_KEY, Blocks.WHITE_CANDLE);
    public static final ResourceKey<Block> ORANGE_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("orange_candle_red_velvet_cake");
    public static final Block ORANGE_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(ORANGE_CANDLE_RED_VELVET_CAKE_KEY, Blocks.ORANGE_CANDLE);
    public static final ResourceKey<Block> MAGENTA_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("magenta_candle_red_velvet_cake");
    public static final Block MAGENTA_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(MAGENTA_CANDLE_RED_VELVET_CAKE_KEY, Blocks.MAGENTA_CANDLE);
    public static final ResourceKey<Block> LIGHT_BLUE_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("light_blue_candle_red_velvet_cake");
    public static final Block LIGHT_BLUE_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(LIGHT_BLUE_CANDLE_RED_VELVET_CAKE_KEY, Blocks.LIGHT_BLUE_CANDLE);
    public static final ResourceKey<Block> YELLOW_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("yellow_candle_red_velvet_cake");
    public static final Block YELLOW_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(YELLOW_CANDLE_RED_VELVET_CAKE_KEY, Blocks.YELLOW_CANDLE);
    public static final ResourceKey<Block> LIME_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("lime_candle_red_velvet_cake");
    public static final Block LIME_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(LIME_CANDLE_RED_VELVET_CAKE_KEY, Blocks.LIME_CANDLE);
    public static final ResourceKey<Block> PINK_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("pink_candle_red_velvet_cake");
    public static final Block PINK_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(PINK_CANDLE_RED_VELVET_CAKE_KEY, Blocks.PINK_CANDLE);
    public static final ResourceKey<Block> GRAY_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("gray_candle_red_velvet_cake");
    public static final Block GRAY_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(GRAY_CANDLE_RED_VELVET_CAKE_KEY, Blocks.GRAY_CANDLE);
    public static final ResourceKey<Block> LIGHT_GRAY_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("light_gray_candle_red_velvet_cake");
    public static final Block LIGHT_GRAY_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(LIGHT_GRAY_CANDLE_RED_VELVET_CAKE_KEY, Blocks.LIGHT_GRAY_CANDLE);
    public static final ResourceKey<Block> CYAN_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("cyan_candle_red_velvet_cake");
    public static final Block CYAN_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(CYAN_CANDLE_RED_VELVET_CAKE_KEY, Blocks.CYAN_CANDLE);
    public static final ResourceKey<Block> PURPLE_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("purple_candle_red_velvet_cake");
    public static final Block PURPLE_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(PURPLE_CANDLE_RED_VELVET_CAKE_KEY, Blocks.PURPLE_CANDLE);
    public static final ResourceKey<Block> BLUE_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("blue_candle_red_velvet_cake");
    public static final Block BLUE_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(BLUE_CANDLE_RED_VELVET_CAKE_KEY, Blocks.BLUE_CANDLE);
    public static final ResourceKey<Block> BROWN_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("brown_candle_red_velvet_cake");
    public static final Block BROWN_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(BROWN_CANDLE_RED_VELVET_CAKE_KEY, Blocks.BROWN_CANDLE);
    public static final ResourceKey<Block> GREEN_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("green_candle_red_velvet_cake");
    public static final Block GREEN_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(GREEN_CANDLE_RED_VELVET_CAKE_KEY, Blocks.GREEN_CANDLE);
    public static final ResourceKey<Block> RED_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("red_candle_red_velvet_cake");
    public static final Block RED_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(RED_CANDLE_RED_VELVET_CAKE_KEY, Blocks.RED_CANDLE);
    public static final ResourceKey<Block> BLACK_CANDLE_RED_VELVET_CAKE_KEY
            = makeRegistryKey("black_candle_red_velvet_cake");
    public static final Block BLACK_CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake(BLACK_CANDLE_RED_VELVET_CAKE_KEY, Blocks.BLACK_CANDLE);
    public static final ResourceKey<Block> STONE_TILES_KEY = makeRegistryKey("stone_tiles");
    public static final Block STONE_TILES = registerSimple(STONE_TILES_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> STONE_TILE_SLAB_KEY = makeRegistryKey("stone_tile_slab");
    public static final Block STONE_TILE_SLAB
            = registerSlab(STONE_TILE_SLAB_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> STONE_TILE_STAIRS_KEY = makeRegistryKey("stone_tile_stairs");
    public static final Block STONE_TILE_STAIRS
            = registerStairs(STONE_TILE_STAIRS_KEY, makeStoneTileSettings(), STONE_TILES);
    public static final ResourceKey<Block> STONE_TILE_WALL_KEY = makeRegistryKey("stone_tile_wall");
    public static final Block STONE_TILE_WALL
            = registerWall(STONE_TILE_WALL_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> MOSSY_STONE_TILES_KEY = makeRegistryKey("mossy_stone_tiles");
    public static final Block MOSSY_STONE_TILES = registerSimple(MOSSY_STONE_TILES_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> MOSSY_STONE_TILE_SLAB_KEY = makeRegistryKey("mossy_stone_tile_slab");
    public static final Block MOSSY_STONE_TILE_SLAB
            = registerSlab(MOSSY_STONE_TILE_SLAB_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> MOSSY_STONE_TILE_STAIRS_KEY = makeRegistryKey("mossy_stone_tile_stairs");
    public static final Block MOSSY_STONE_TILE_STAIRS
            = registerStairs(MOSSY_STONE_TILE_STAIRS_KEY, makeStoneTileSettings(), MOSSY_STONE_TILES);
    public static final ResourceKey<Block> MOSSY_STONE_TILE_WALL_KEY = makeRegistryKey("mossy_stone_tile_wall");
    public static final Block MOSSY_STONE_TILE_WALL
            = registerWall(MOSSY_STONE_TILE_WALL_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> CRACKED_STONE_TILES_KEY = makeRegistryKey("cracked_stone_tiles");
    public static final Block CRACKED_STONE_TILES = registerSimple(CRACKED_STONE_TILES_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> CRACKED_STONE_TILE_SLAB_KEY
            = makeRegistryKey("cracked_stone_tile_slab");
    public static final Block CRACKED_STONE_TILE_SLAB
            = registerSlab(CRACKED_STONE_TILE_SLAB_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> CRACKED_STONE_TILE_STAIRS_KEY
            = makeRegistryKey("cracked_stone_tile_stairs");
    public static final Block CRACKED_STONE_TILE_STAIRS
            = registerStairs(CRACKED_STONE_TILE_STAIRS_KEY, makeStoneTileSettings(), CRACKED_STONE_TILES);
    public static final ResourceKey<Block> CRACKED_STONE_TILE_WALL_KEY
            = makeRegistryKey("cracked_stone_tile_wall");
    public static final Block CRACKED_STONE_TILE_WALL
            = registerWall(CRACKED_STONE_TILE_WALL_KEY, makeStoneTileSettings());
    public static final ResourceKey<Block> SWEET_BERRY_PIE_KEY = makeRegistryKey("sweet_berry_pie");
    public static final Block SWEET_BERRY_PIE = registerPie(SWEET_BERRY_PIE_KEY);
    public static final ResourceKey<Block> BLUEBERRY_PIE_KEY = makeRegistryKey("blueberry_pie");
    public static final Block BLUEBERRY_PIE = registerPie(BLUEBERRY_PIE_KEY);
    public static final ResourceKey<Block> BLACKSTONE_TILES_KEY = makeRegistryKey("blackstone_tiles");
    public static final Block BLACKSTONE_TILES
            = registerSimple(BLACKSTONE_TILES_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> BLACKSTONE_TILE_STAIRS_KEY = makeRegistryKey("blackstone_tile_stairs");
    public static final Block BLACKSTONE_TILE_STAIRS
            = registerStairs(BLACKSTONE_TILE_STAIRS_KEY, makeBlackstoneTileSettings(), BLACKSTONE_TILES);
    public static final ResourceKey<Block> BLACKSTONE_TILE_SLAB_KEY = makeRegistryKey("blackstone_tile_slab");
    public static final Block BLACKSTONE_TILE_SLAB
            = registerSlab(BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> BLACKSTONE_TILE_WALL_KEY = makeRegistryKey("blackstone_tile_wall");
    public static final Block BLACKSTONE_TILE_WALL
            = registerWall(BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILES_KEY = makeRegistryKey("twisted_blackstone_tiles");
    public static final Block TWISTED_BLACKSTONE_TILES
            = registerSimple(TWISTED_BLACKSTONE_TILES_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILE_STAIRS_KEY
            = makeRegistryKey("twisted_blackstone_tile_stairs");
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS
            = registerStairs(TWISTED_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(), TWISTED_BLACKSTONE_TILES);
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILE_SLAB_KEY
            = makeRegistryKey("twisted_blackstone_tile_slab");
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB
            = registerSlab(TWISTED_BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILE_WALL_KEY
            = makeRegistryKey("twisted_blackstone_tile_wall");
    public static final Block TWISTED_BLACKSTONE_TILE_WALL
            = registerWall(TWISTED_BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILES_KEY
            = makeRegistryKey("weeping_blackstone_tiles");
    public static final Block WEEPING_BLACKSTONE_TILES
            = registerSimple(WEEPING_BLACKSTONE_TILES_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILE_STAIRS_KEY
            = makeRegistryKey("weeping_blackstone_tile_stairs");
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS = registerStairs(WEEPING_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(), WEEPING_BLACKSTONE_TILES);
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILE_SLAB_KEY
            = makeRegistryKey("weeping_blackstone_tile_slab");
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB
            = registerSlab(WEEPING_BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILE_WALL_KEY
            = makeRegistryKey("weeping_blackstone_tile_wall");
    public static final Block WEEPING_BLACKSTONE_TILE_WALL
            = registerWall(WEEPING_BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings());
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY
            = makeRegistryKey("twisted_polished_blackstone_bricks");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS
            = registerSimple(TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY
            = makeRegistryKey("twisted_polished_blackstone_brick_stairs");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY),
            Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY
            = makeRegistryKey("twisted_polished_blackstone_brick_slab");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY
            = makeRegistryKey("twisted_polished_blackstone_brick_wall");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY
            = makeRegistryKey("weeping_polished_blackstone_bricks");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS
            = registerSimple(WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY
            = makeRegistryKey("weeping_polished_blackstone_brick_stairs");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY),
            WEEPING_POLISHED_BLACKSTONE_BRICKS);
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY
            = makeRegistryKey("weeping_polished_blackstone_brick_slab");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY
            = makeRegistryKey("weeping_polished_blackstone_brick_wall");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_KEY = makeRegistryKey("twisted_blackstone");
    public static final Block TWISTED_BLACKSTONE
            = registerSimple(TWISTED_BLACKSTONE_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_STAIRS_KEY
            = makeRegistryKey("twisted_blackstone_stairs");
    public static final Block TWISTED_BLACKSTONE_STAIRS
            = registerStairs(TWISTED_BLACKSTONE_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
            .setId(TWISTED_BLACKSTONE_STAIRS_KEY), Blocks.BLACKSTONE);
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_SLAB_KEY
            = makeRegistryKey("twisted_blackstone_slab");
    public static final Block TWISTED_BLACKSTONE_SLAB = registerSlab(TWISTED_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(TWISTED_BLACKSTONE_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_WALL_KEY
            = makeRegistryKey("twisted_blackstone_wall");
    public static final Block TWISTED_BLACKSTONE_WALL = registerWall(TWISTED_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(TWISTED_BLACKSTONE_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_KEY = makeRegistryKey("weeping_blackstone");
    public static final Block WEEPING_BLACKSTONE
            = registerSimple(WEEPING_BLACKSTONE_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_STAIRS_KEY
            = makeRegistryKey("weeping_blackstone_stairs");
    public static final Block WEEPING_BLACKSTONE_STAIRS
            = registerStairs(WEEPING_BLACKSTONE_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
                        .setId(WEEPING_BLACKSTONE_STAIRS_KEY), WEEPING_BLACKSTONE);
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_SLAB_KEY
            = makeRegistryKey("weeping_blackstone_slab");
    public static final Block WEEPING_BLACKSTONE_SLAB = registerSlab(WEEPING_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(WEEPING_BLACKSTONE_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_WALL_KEY
            = makeRegistryKey("weeping_blackstone_wall");
    public static final Block WEEPING_BLACKSTONE_WALL = registerWall(WEEPING_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(WEEPING_BLACKSTONE_WALL_KEY));
    public static final ResourceKey<Block> QUARTZ_TILES_KEY = makeRegistryKey("quartz_tiles");
    public static final Block QUARTZ_TILES = registerSimple(QUARTZ_TILES_KEY, makeQuartzTileSettings());
    public static final ResourceKey<Block> QUARTZ_TILE_STAIRS_KEY = makeRegistryKey("quartz_tile_stairs");
    public static final Block QUARTZ_TILE_STAIRS = registerStairs(QUARTZ_TILE_STAIRS_KEY,
            makeQuartzTileSettings(), QUARTZ_TILES);
    public static final ResourceKey<Block> QUARTZ_TILE_SLAB_KEY = makeRegistryKey("quartz_tile_slab");
    public static final Block QUARTZ_TILE_SLAB
            = registerSlab(QUARTZ_TILE_SLAB_KEY, makeQuartzTileSettings());
    public static final ResourceKey<Block> QUARTZ_TILE_WALL_KEY = makeRegistryKey("quartz_tile_wall");
    public static final Block QUARTZ_TILE_WALL
            = registerWall(QUARTZ_TILE_WALL_KEY, makeQuartzTileSettings());
    public static final ResourceKey<Block> CALCITE_BRICKS_KEY = makeRegistryKey("calcite_bricks");
    public static final Block CALCITE_BRICKS = registerSimple(CALCITE_BRICKS_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> CALCITE_BRICK_STAIRS_KEY = makeRegistryKey("calcite_brick_stairs");
    public static final Block CALCITE_BRICK_STAIRS = registerStairs(CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(), CALCITE_BRICKS);
    public static final ResourceKey<Block> CALCITE_BRICK_SLAB_KEY = makeRegistryKey("calcite_brick_slab");
    public static final Block CALCITE_BRICK_SLAB = registerSlab(CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings());
    public static final ResourceKey<Block> CALCITE_BRICK_WALL_KEY = makeRegistryKey("calcite_brick_wall");
    public static final Block CALCITE_BRICK_WALL = registerWall(CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings());
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICKS_KEY = makeRegistryKey("mossy_calcite_bricks");
    public static final Block MOSSY_CALCITE_BRICKS = registerSimple(MOSSY_CALCITE_BRICKS_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICK_STAIRS_KEY
            = makeRegistryKey("mossy_calcite_brick_stairs");
    public static final Block MOSSY_CALCITE_BRICK_STAIRS = registerStairs(MOSSY_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(), MOSSY_CALCITE_BRICKS);
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICK_SLAB_KEY
            = makeRegistryKey("mossy_calcite_brick_slab");
    public static final Block MOSSY_CALCITE_BRICK_SLAB
            = registerSlab(MOSSY_CALCITE_BRICK_SLAB_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICK_WALL_KEY
            = makeRegistryKey("mossy_calcite_brick_wall");
    public static final Block MOSSY_CALCITE_BRICK_WALL
            = registerWall(MOSSY_CALCITE_BRICK_WALL_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICKS_KEY
            = makeRegistryKey("cracked_calcite_bricks");
    public static final Block CRACKED_CALCITE_BRICKS
            = register(CRACKED_CALCITE_BRICKS_KEY, Block::new, makeCalciteSettings(), true);
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICK_STAIRS_KEY
            = makeRegistryKey("cracked_calcite_brick_stairs");
    public static final Block CRACKED_CALCITE_BRICK_STAIRS = registerStairs(CRACKED_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(), CRACKED_CALCITE_BRICKS);
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICK_SLAB_KEY
            = makeRegistryKey("cracked_calcite_brick_slab");
    public static final Block CRACKED_CALCITE_BRICK_SLAB = registerSlab(CRACKED_CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings());
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICK_WALL_KEY
            = makeRegistryKey("cracked_calcite_brick_wall");
    public static final Block CRACKED_CALCITE_BRICK_WALL = registerWall(CRACKED_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings());
    public static final ResourceKey<Block> CHISELED_CALCITE_BRICKS_KEY
            = makeRegistryKey("chiseled_calcite_bricks");
    public static final Block CHISELED_CALCITE_BRICKS
            = register(CHISELED_CALCITE_BRICKS_KEY, RotatedPillarBlock::new, makeCalciteSettings());
    public static final ResourceKey<Block> DRIPSTONE_BRICKS_KEY = makeRegistryKey("dripstone_bricks");
    public static final Block DRIPSTONE_BRICKS = registerSimple(DRIPSTONE_BRICKS_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> DRIPSTONE_BRICK_STAIRS_KEY = makeRegistryKey("dripstone_brick_stairs");
    public static final Block DRIPSTONE_BRICK_STAIRS = registerStairs(DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(), DRIPSTONE_BRICKS);
    public static final ResourceKey<Block> DRIPSTONE_BRICK_SLAB_KEY = makeRegistryKey("dripstone_brick_slab");
    public static final Block DRIPSTONE_BRICK_SLAB = registerSlab(DRIPSTONE_BRICK_SLAB_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> DRIPSTONE_BRICK_WALL_KEY = makeRegistryKey("dripstone_brick_wall");
    public static final Block DRIPSTONE_BRICK_WALL = registerWall(DRIPSTONE_BRICK_WALL_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICKS_KEY = makeRegistryKey("mossy_dripstone_bricks");
    public static final Block MOSSY_DRIPSTONE_BRICKS
            = registerSimple(MOSSY_DRIPSTONE_BRICKS_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICK_STAIRS_KEY
            = makeRegistryKey("mossy_dripstone_brick_stairs");
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS = registerStairs(MOSSY_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(), MOSSY_DRIPSTONE_BRICKS);
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICK_SLAB_KEY
            = makeRegistryKey("mossy_dripstone_brick_slab");
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB = registerSlab(MOSSY_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings());
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICK_WALL_KEY
            = makeRegistryKey("mossy_dripstone_brick_wall");
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL = registerWall(MOSSY_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings());
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICKS_KEY
            = makeRegistryKey("cracked_dripstone_bricks");
    public static final Block CRACKED_DRIPSTONE_BRICKS
            = registerSimple(CRACKED_DRIPSTONE_BRICKS_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICK_STAIRS_KEY
            = makeRegistryKey("cracked_dripstone_brick_stairs");
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = registerStairs(CRACKED_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(), CRACKED_DRIPSTONE_BRICKS);
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICK_SLAB_KEY
            = makeRegistryKey("cracked_dripstone_brick_slab");
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = registerSlab(CRACKED_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings());
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICK_WALL_KEY
            = makeRegistryKey("cracked_dripstone_brick_wall");
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL = registerWall(CRACKED_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings());
    public static final ResourceKey<Block> CHISELED_DRIPSTONE_BRICKS_KEY
            = makeRegistryKey("chiseled_dripstone_bricks");
    public static final Block CHISELED_DRIPSTONE_BRICKS
            = registerSimple(CHISELED_DRIPSTONE_BRICKS_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> BLOOD_KELP_KEY = makeRegistryKey("blood_kelp");
    public static final Block BLOOD_KELP = register(BLOOD_KELP_KEY, BloodKelpBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.KELP)
                    .lightLevel(getLuminanceFromState()), false);
    public static final ResourceKey<Block> BLOOD_KELP_PLANT_KEY = makeRegistryKey("blood_kelp_plant");
    public static final Block BLOOD_KELP_PLANT = register(BLOOD_KELP_PLANT_KEY, BloodKelpPlantBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT)
                    .lightLevel(getLuminanceFromState()), false);
    public static final ResourceKey<Block> DRIED_BLOOD_KELP_BLOCK_KEY = makeRegistryKey("dried_blood_kelp_block");
    public static final Block DRIED_BLOOD_KELP_BLOCK
            = registerSimple(DRIED_BLOOD_KELP_BLOCK_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.DRIED_KELP_BLOCK));
    public static final ResourceKey<Block> BLOOD_KELP_LANTERN_KEY = makeRegistryKey("blood_kelp_lantern");
    public static final Block BLOOD_KELP_LANTERN
            = register(BLOOD_KELP_LANTERN_KEY, RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.3F)
                    .sound(SoundType.GLASS).lightLevel((state) -> 15));
    public static final ResourceKey<Block> BOG_BLOSSOM_KEY = makeRegistryKey("bog_blossom");
    public static final Block BOG_BLOSSOM = register(BOG_BLOSSOM_KEY, BogBlossomBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).instabreak().noCollision().sound(SoundType.SPORE_BLOSSOM)
                    .pushReaction(PushReaction.DESTROY).lightLevel((state) -> 5).setId(BOG_BLOSSOM_KEY));
    public static final ResourceKey<Block> CINDERSNAP_BERRY_BUSH_KEY = makeRegistryKey("cindersnap_berry_bush");
    public static final Block CINDERSNAP_BERRY_BUSH = register(CINDERSNAP_BERRY_BUSH_KEY, CindersnapBerryBushBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
                    .lightLevel((state) -> 8), false);
    public static final ResourceKey<Block> FROSTBITE_BERRY_BUSH_KEY = makeRegistryKey("frostbite_berry_bush");
    public static final Block FROSTBITE_BERRY_BUSH
            = register(FROSTBITE_BERRY_BUSH_KEY, FrostbiteBerryBushBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
                    .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS)
                    .pushReaction(PushReaction.DESTROY).lightLevel((state) -> 5), false);
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_KEY = makeRegistryKey("polished_dripstone");
    public static final Block POLISHED_DRIPSTONE = registerSimple(POLISHED_DRIPSTONE_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_STAIRS_KEY
            = makeRegistryKey("polished_dripstone_stairs");
    public static final Block POLISHED_DRIPSTONE_STAIRS
            = registerStairs(POLISHED_DRIPSTONE_STAIRS_KEY, makeDripstoneSettings(), POLISHED_DRIPSTONE);
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_SLAB_KEY
            = makeRegistryKey("polished_dripstone_slab");
    public static final Block POLISHED_DRIPSTONE_SLAB
            = registerSlab(POLISHED_DRIPSTONE_SLAB_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_WALL_KEY
            = makeRegistryKey("polished_dripstone_wall");
    public static final Block POLISHED_DRIPSTONE_WALL
            = registerWall(POLISHED_DRIPSTONE_WALL_KEY, makeDripstoneSettings());
    public static final ResourceKey<Block> POLISHED_CALCITE_KEY = makeRegistryKey("polished_calcite");
    public static final Block POLISHED_CALCITE = registerSimple(POLISHED_CALCITE_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> POLISHED_CALCITE_STAIRS_KEY
            = makeRegistryKey("polished_calcite_stairs");
    public static final Block POLISHED_CALCITE_STAIRS
            = registerStairs(POLISHED_CALCITE_STAIRS_KEY, makeCalciteSettings(), POLISHED_CALCITE);
    public static final ResourceKey<Block> POLISHED_CALCITE_SLAB_KEY = makeRegistryKey("polished_calcite_slab");
    public static final Block POLISHED_CALCITE_SLAB
            = registerSlab(POLISHED_CALCITE_SLAB_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> POLISHED_CALCITE_WALL_KEY = makeRegistryKey("polished_calcite_wall");
    public static final Block POLISHED_CALCITE_WALL
            = registerWall(POLISHED_CALCITE_WALL_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> DRIPSTONE_STAIRS_KEY = makeRegistryKey("dripstone_stairs");
    public static final Block DRIPSTONE_STAIRS = registerStairs(DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(), Blocks.DRIPSTONE_BLOCK);
    public static final ResourceKey<Block> DRIPSTONE_SLAB_KEY = makeRegistryKey("dripstone_slab");
    public static final Block DRIPSTONE_SLAB = registerSlab(DRIPSTONE_SLAB_KEY,
            makeDripstoneSettings());
    public static final ResourceKey<Block> DRIPSTONE_WALL_KEY = makeRegistryKey("dripstone_wall");
    public static final Block DRIPSTONE_WALL = registerWall(DRIPSTONE_WALL_KEY,
            makeDripstoneSettings());
    public static final ResourceKey<Block> CALCITE_STAIRS_KEY = makeRegistryKey("calcite_stairs");
    public static final Block CALCITE_STAIRS = registerStairs(CALCITE_STAIRS_KEY,
            makeCalciteSettings(), Blocks.CALCITE);
    public static final ResourceKey<Block> CALCITE_SLAB_KEY = makeRegistryKey("calcite_slab");
    public static final Block CALCITE_SLAB = registerSlab(CALCITE_SLAB_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> CALCITE_WALL_KEY = makeRegistryKey("calcite_wall");
    public static final Block CALCITE_WALL = registerWall(CALCITE_WALL_KEY, makeCalciteSettings());
    public static final ResourceKey<Block> BAMBOO_PLANTER_BOX_KEY = makeRegistryKey("bamboo_planter_box");
    public static final Block BAMBOO_PLANTER_BOX = registerPlanterBox(BAMBOO_PLANTER_BOX_KEY,
            Blocks.BAMBOO_PLANKS.defaultMapColor(), SoundType.BAMBOO_WOOD);
    public static final ResourceKey<Block> POTTED_CATTAIL_KEY = makeRegistryKey("potted_cattail");
    public static final Block POTTED_CATTAIL = register(POTTED_CATTAIL_KEY,
            (props) -> new FlowerPotBlock(ModBlocks.CATTAIL, props),
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM), false);
    public static final ResourceKey<Block> STONE_WALL_KEY = makeRegistryKey("stone_wall");
    public static final Block STONE_WALL = registerWall(STONE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
            .setId(STONE_WALL_KEY));
    public static final ResourceKey<Block> QUARTZ_WALL_KEY = makeRegistryKey("quartz_wall");
    public static final Block QUARTZ_WALL = registerWall(QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(QUARTZ_WALL_KEY));
    public static final ResourceKey<Block> SMOOTH_QUARTZ_WALL_KEY = makeRegistryKey("smooth_quartz_wall");
    public static final Block SMOOTH_QUARTZ_WALL = registerWall(SMOOTH_QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).setId(SMOOTH_QUARTZ_WALL_KEY));
    public static final ResourceKey<Block> GRASS_SLAB_KEY = makeRegistryKey("grass_slab");
    public static final Block GRASS_SLAB = register(GRASS_SLAB_KEY, GrassSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK), true);
    public static final ResourceKey<Block> PODZOL_SLAB_KEY = makeRegistryKey("podzol_slab");
    public static final Block PODZOL_SLAB = register(PODZOL_SLAB_KEY, SnowySlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL));
    public static final ResourceKey<Block> MYCELIUM_SLAB_KEY = makeRegistryKey("mycelium_slab");
    public static final Block MYCELIUM_SLAB = register(MYCELIUM_SLAB_KEY, MyceliumSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM));
    public static final ResourceKey<Block> DIRT_PATH_SLAB_KEY = makeRegistryKey("dirt_path_slab");
    public static final Block DIRT_PATH_SLAB = register(DIRT_PATH_SLAB_KEY, DirtPathSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH), true);
    public static final ResourceKey<Block> DIRT_SLAB_KEY = makeRegistryKey("dirt_slab");
    public static final Block DIRT_SLAB = register(DIRT_SLAB_KEY, DirtSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT), true);
    public static final ResourceKey<Block> COARSE_DIRT_SLAB_KEY = makeRegistryKey("coarse_dirt_slab");
    public static final Block COARSE_DIRT_SLAB = registerSlab(COARSE_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT).setId(COARSE_DIRT_SLAB_KEY));
    public static final ResourceKey<Block> ROOTED_DIRT_SLAB_KEY = makeRegistryKey("rooted_dirt_slab");
    public static final Block ROOTED_DIRT_SLAB = registerSlab(ROOTED_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(ROOTED_DIRT_SLAB_KEY));
    public static final ResourceKey<Block> WILD_GREEN_ONIONS_KEY = makeRegistryKey("wild_green_onions");
    public static final Block WILD_GREEN_ONIONS
            = register(WILD_GREEN_ONIONS_KEY, WildGreenOnionsBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
            .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY), true);
    public static final ResourceKey<Block> CREAKING_PLUSHIE_KEY = makeRegistryKey("creaking_plushie");
    public static final Block CREAKING_PLUSHIE
            = register(CREAKING_PLUSHIE_KEY, CreakingPlushieBlock::new, makePlushieSettings(), true);
    public static final ResourceKey<Block> QUARTZ_BRICK_STAIRS_KEY = makeRegistryKey("quartz_brick_stairs");
    public static final Block QUARTZ_BRICK_STAIRS = registerStairs(QUARTZ_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(QUARTZ_BRICK_STAIRS_KEY),
            Blocks.QUARTZ_BRICKS);
    public static final ResourceKey<Block> QUARTZ_BRICK_SLAB_KEY = makeRegistryKey("quartz_brick_slab");
    public static final Block QUARTZ_BRICK_SLAB = registerSlab(QUARTZ_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(QUARTZ_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> QUARTZ_BRICK_WALL_KEY = makeRegistryKey("quartz_brick_wall");
    public static final Block QUARTZ_BRICK_WALL = registerWall(QUARTZ_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(QUARTZ_BRICK_WALL_KEY));
    public static final ResourceKey<Block> SNIFFER_PLUSHIE_KEY = makeRegistryKey("sniffer_plushie");
    public static final Block SNIFFER_PLUSHIE
            = register(SNIFFER_PLUSHIE_KEY, SnifferPlushieBlock::new, makePlushieSettings(), true);
    public static final ResourceKey<Block> STRIPPED_PALE_OAK_WALL_KEY = makeRegistryKey("stripped_pale_oak_wall");
    public static final Block STRIPPED_PALE_OAK_WALL = registerWall(STRIPPED_PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).setId(STRIPPED_PALE_OAK_WALL_KEY));
    public static final ResourceKey<Block> PALE_OAK_WALL_KEY = makeRegistryKey("pale_oak_wall");
    public static final Block PALE_OAK_WALL = registerWall(PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).setId(PALE_OAK_WALL_KEY));
    public static final ResourceKey<Block> BAMBOO_ROPE_LADDER_KEY = makeRegistryKey("bamboo_rope_ladder");
    public static final Block BAMBOO_ROPE_LADDER = registerRopeLadder(BAMBOO_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> STRIPPED_BAMBOO_WALL_KEY = makeRegistryKey("stripped_bamboo_wall");
    public static final Block STRIPPED_BAMBOO_WALL = registerWall(STRIPPED_BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(STRIPPED_BAMBOO_WALL_KEY));
    public static final ResourceKey<Block> BAMBOO_WALL_KEY = makeRegistryKey("bamboo_wall");
    public static final Block BAMBOO_WALL = registerWall(BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(BAMBOO_WALL_KEY));
    public static final ResourceKey<Block> BLACK_WOLF_PLUSHIE_KEY = makeRegistryKey("black_wolf_plushie");
    public static final Block BLACK_WOLF_PLUSHIE = registerWolfPlushie(BLACK_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> ASHEN_WOLF_PLUSHIE_KEY = makeRegistryKey("ashen_wolf_plushie");
    public static final Block ASHEN_WOLF_PLUSHIE = registerWolfPlushie(ASHEN_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> CHESTNUT_WOLF_PLUSHIE_KEY = makeRegistryKey("chestnut_wolf_plushie");
    public static final Block CHESTNUT_WOLF_PLUSHIE = registerWolfPlushie(CHESTNUT_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> RUSTY_WOLF_PLUSHIE_KEY = makeRegistryKey("rusty_wolf_plushie");
    public static final Block RUSTY_WOLF_PLUSHIE = registerWolfPlushie(RUSTY_WOLF_PLUSHIE_KEY);

    private ModBlocks() {}

    private static ResourceKey<Block> makeRegistryKey(String name) {
        return ResourceKey.create(Registries.BLOCK, AssortedDiscoveries.makeModId(name));
    }

    private static boolean always(BlockState state, BlockGetter world, BlockPos pos) {
        return true;
    }

    private static ToIntFunction<BlockState> getLuminanceFromState() {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? 10 : 0;
    }

    private static Block register(ResourceKey<Block> blockKey, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties, boolean includeItem) {
        // Must register the block before the block item to prevent bugs.
        Block block = Registry.register(BuiltInRegistries.BLOCK, blockKey, function.apply(properties.setId(blockKey)));
        if (includeItem) {
            ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockKey.identifier());
            BlockItem blockItem = Registry.register(BuiltInRegistries.ITEM, itemKey,
                    new BlockItem(block, new Item.Properties().setId(itemKey)));
            // Add our block item and block to this map so we can retrieve our block item from its block later!
            Item.BY_BLOCK.put(block, blockItem);
        }
        return block;
    }

    private static Block register(ResourceKey<Block> blockKey, Function<BlockBehaviour.Properties, Block> function, BlockBehaviour.Properties properties) {
        return register(blockKey, function, properties, true);
    }

    public static Block registerRopeLadder(ResourceKey<Block> blockKey) {
        // Must register the block before the block item to prevent bugs.
        Block block = Registry.register(BuiltInRegistries.BLOCK, blockKey,
                new RopeLadderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER).setId(blockKey)));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockKey.identifier());
        BlockItem blockItem = Registry.register(BuiltInRegistries.ITEM, itemKey,
                new RopeLadderBlockItem(block, new Item.Properties().setId(itemKey)));
        // Add our block item and block to this map so we can retrieve our block item from its block later!
        Item.BY_BLOCK.put(block, blockItem);
        return block;
    }

    private static Block registerHorsePlushie(final ResourceKey<Block> id) {
        return register(id, HorsePlushieBlock::new, makePlushieSettings());
    }

    private static Block registerCubePlushie(final ResourceKey<Block> id) {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.NONE)
                .strength(0.2F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY);
        return register(id, CubePlushieBlock::new, settings);
    }

    private static Block registerMooshroomPlushie(final ResourceKey<Block> id) {
        return register(id, MooshroomPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerWolfPlushie(final ResourceKey<Block> id) {
        return register(id, WolfPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerCatPlushie(final ResourceKey<Block> id) {
        return register(id, CatPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerRabbitPlushie(final ResourceKey<Block> id) {
        return register(id, RabbitPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerVillagerPlushie(final ResourceKey<Block> id) {
        return register(id, VillagerPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerPigPlushie(final ResourceKey<Block> id) {
        return register(id, PigPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerLantern(final ResourceKey<Block> id) {
        return register(id, LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN));
    }

    private static Block registerSheepPlushie(final DyeColor color, final ResourceKey<Block> id) {
        return register(id, (props) -> new SheepPlushieBlock(color, props), makePlushieSettings());
    }

    private static Block registerShortHatVillagerPlushie(final ResourceKey<Block> id) {
        return register(id, ShortHatVillagerPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerZombiePlushie(final ResourceKey<Block> id) {
        return register(id, ZombiePlushieBlock::new, makePlushieSettings());
    }

    private static Block registerStriderPlushie(final ResourceKey<Block> id) {
        return register(id, StriderPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerHoglinPlushie(final ResourceKey<Block> id) {
        return register(id, HoglinPlushieBlock::new, makePlushieSettings());
    }

    private static Block registerAllayPlushie(final ResourceKey<Block> id) {
        return register(id, AllayPlushieBlock::new, makeGlowingPlushieSettings());
    }

    private static Block registerPlanterBox(final ResourceKey<Block> id, MapColor color, SoundType soundGroup) {
        BlockBehaviour.Properties planterBoxSettings = BlockBehaviour.Properties.of().mapColor(color)
                .strength(2.5F).sound(soundGroup).ignitedByLava();
        return register(id, PlanterBoxBlock::new, planterBoxSettings);
    }

    private static Block registerNetherPlanterBox(final ResourceKey<Block> id, MapColor color) {
        BlockBehaviour.Properties blockSettings = BlockBehaviour.Properties.of().mapColor(color)
                .strength(2.5F).sound(SoundType.NETHER_WOOD);
        return register(id, PlanterBoxBlock::new, blockSettings);
    }

    private static Block registerTorch(final ResourceKey<Block> id, SimpleParticleType particle) {
        BlockBehaviour.Properties torchSettings = BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH);
        return register(id, (props) -> new TorchBlock(particle, props), torchSettings, false);
    }

    private static Block registerWallTorch(final ResourceKey<Block> id, Block standingTorch, SimpleParticleType particle) {
        BlockBehaviour.Properties wallTorchSettings = wallVariant(standingTorch).noCollision().instabreak()
                .lightLevel((blockState) -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY);
        return register(id, (props) -> new WallTorchBlock(particle, props), wallTorchSettings, false);
    }

    private static BlockBehaviour.Properties wallVariant(Block block) {
        return BlockBehaviour.Properties.of().overrideLootTable(block.getLootTable())
                .overrideDescription(block.getDescriptionId());
    }

    private static Block registerBlueberryBush() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().mapColor(MapColor.GRASS)
                .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH)
                .pushReaction(PushReaction.DESTROY);
        return register(BLUEBERRY_BUSH_KEY, BlueberryBushBlock::new, settings, false);
    }

    private static Block registerGreenOnions() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                .pushReaction(PushReaction.DESTROY);
        return register(GREEN_ONIONS_KEY, GreenOnionsBlock::new, settings, false);
    }

    private static Block registerIronLadder() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F)
                .sound(SoundType.METAL).noOcclusion();
        return register(IRON_LADDER_KEY, LadderBlock::new, settings);
    }

    private static Block registerStairs(final ResourceKey<Block> id, BlockBehaviour.Properties settings, Block baseBlock) {
        return register(id, (props) -> new StairBlock(baseBlock.defaultBlockState(), props), settings);
    }

    private static Block registerSlab(final ResourceKey<Block> id, BlockBehaviour.Properties settings) {
        return register(id, SlabBlock::new, settings);
    }

    private static Block registerWall(final ResourceKey<Block> id, BlockBehaviour.Properties settings) {
        return register(id, WallBlock::new, settings);
    }

    private static Block registerSimple(final ResourceKey<Block> id, BlockBehaviour.Properties settings) {
        return register(id, Block::new, settings);
    }

    private static Block registerDyedCampfire(final ResourceKey<Block> id, ParticleOptions emberParticle) {
        return register(id, (props) -> new DyedCampfireBlock(props, emberParticle),
                BlockBehaviour.Properties.ofFullCopy(Blocks.CAMPFIRE));
    }

    private static Block registerPottedSnapdragon() {
        BlockBehaviour.Properties settings = BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_POPPY)
                .lightLevel((state) -> 8);
        return register(POTTED_SNAPDRAGON_KEY,
                (props) -> new PottedSnapdragonBlock(ModBlocks.SNAPDRAGON, props), settings, false);
    }

    private static Block registerCake(final ResourceKey<Block> id) {
        return register(id, ModdedCakeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    }

    private static Block registerChocolateCandleCake(ResourceKey<Block> id, Block candle) {
        return registerCandleCake(id, candle, ModBlocks.CHOCOLATE_CAKE);
    }

    private static Block registerRedVelvetCandleCake(ResourceKey<Block> id, Block candle) {
        return registerCandleCake(id, candle, ModBlocks.RED_VELVET_CAKE);
    }

    private static Block registerNetherSmokyQuartzOre() {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE);
        return register(NETHER_SMOKY_QUARTZ_ORE_KEY,
                (props) -> new DropExperienceBlock(UniformInt.of(2, 5), props), properties);
    }

    private static Block registerCandleCake(final ResourceKey<Block> id, Block candle, Block cake) {
        return register(id, (props) -> new ModdedCandleCakeBlock(cake, candle, props),
                BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE), false);
    }

    private static Block registerPie(final ResourceKey<Block> id) {
        BlockBehaviour.Properties pieSettings = BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE);
        return register(id, (props) -> new PieBlock(props, 3, 0.6F), pieSettings);
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
