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
    public static final ResourceKey<Block> BAT_PLUSHIE_KEY = createKey("bat_plushie");
    public static final Block BAT_PLUSHIE = register(new BatPlushieBlock(makePlushieSettings(BAT_PLUSHIE_KEY)),
            BAT_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> BLAZE_PLUSHIE_KEY = createKey("blaze_plushie");
    public static final Block BLAZE_PLUSHIE = register(new BlazePlushieBlock(makeGlowingPlushieSettings(BLAZE_PLUSHIE_KEY)),
            BLAZE_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> CAVE_SPIDER_PLUSHIE_KEY = createKey("cave_spider_plushie");
    public static final Block CAVE_SPIDER_PLUSHIE
            = register(new CaveSpiderPlushieBlock(makePlushieSettings(CAVE_SPIDER_PLUSHIE_KEY)),
            CAVE_SPIDER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> TEMPERATE_CHICKEN_PLUSHIE_KEY
            = createKey("temperate_chicken_plushie");
    public static final Block TEMPERATE_CHICKEN_PLUSHIE
            = register(new ChickenPlushieBlock(makePlushieSettings(TEMPERATE_CHICKEN_PLUSHIE_KEY)),
            TEMPERATE_CHICKEN_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> TEMPERATE_COW_PLUSHIE_KEY
            = createKey("temperate_cow_plushie");
    public static final Block TEMPERATE_COW_PLUSHIE
            = register(new CowPlushieBlock(makePlushieSettings(TEMPERATE_COW_PLUSHIE_KEY)),
            TEMPERATE_COW_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> CREEPER_PLUSHIE_KEY = createKey("creeper_plushie");
    public static final Block CREEPER_PLUSHIE
            = register(new CreeperPlushieBlock(makePlushieSettings(CREEPER_PLUSHIE_KEY)),
            CREEPER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> ENDERMAN_PLUSHIE_KEY = createKey("enderman_plushie");
    public static final Block ENDERMAN_PLUSHIE
            = register(new EndermanPlushieBlock(makePlushieSettings(ENDERMAN_PLUSHIE_KEY)),
            ENDERMAN_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> GHAST_PLUSHIE_KEY = createKey("ghast_plushie");
    public static final Block GHAST_PLUSHIE = register(new GhastPlushieBlock(makePlushieSettings(GHAST_PLUSHIE_KEY)),
            GHAST_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> GUARDIAN_PLUSHIE_KEY = createKey("guardian_plushie");
    public static final Block GUARDIAN_PLUSHIE
            = register(new GuardianPlushieBlock(makePlushieSettings(GUARDIAN_PLUSHIE_KEY)),
            GUARDIAN_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> WHITE_HORSE_PLUSHIE_KEY = createKey("white_horse_plushie");
    public static final Block WHITE_HORSE_PLUSHIE = registerHorsePlushie(WHITE_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> GRAY_HORSE_PLUSHIE_KEY = createKey("gray_horse_plushie");
    public static final Block GRAY_HORSE_PLUSHIE = registerHorsePlushie(GRAY_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_HORSE_PLUSHIE_KEY = createKey("brown_horse_plushie");
    public static final Block BROWN_HORSE_PLUSHIE = registerHorsePlushie(BROWN_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_HORSE_PLUSHIE_KEY = createKey("black_horse_plushie");
    public static final Block BLACK_HORSE_PLUSHIE = registerHorsePlushie(BLACK_HORSE_PLUSHIE_KEY);
    public static final ResourceKey<Block> MAGMA_CUBE_PLUSHIE_KEY = createKey("magma_cube_plushie");
    public static final Block MAGMA_CUBE_PLUSHIE = registerCubePlushie(MAGMA_CUBE_PLUSHIE_KEY);
    public static final ResourceKey<Block> RED_MOOSHROOM_PLUSHIE_KEY = createKey("red_mooshroom_plushie");
    public static final Block RED_MOOSHROOM_PLUSHIE = registerMooshroomPlushie(RED_MOOSHROOM_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_MOOSHROOM_PLUSHIE_KEY = createKey("brown_mooshroom_plushie");
    public static final Block BROWN_MOOSHROOM_PLUSHIE = registerMooshroomPlushie(BROWN_MOOSHROOM_PLUSHIE_KEY);
    public static final ResourceKey<Block> OCELOT_PLUSHIE_KEY = createKey("ocelot_plushie");
    public static final Block OCELOT_PLUSHIE = registerCatPlushie(OCELOT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TABBY_CAT_PLUSHIE_KEY = createKey("tabby_cat_plushie");
    public static final Block TABBY_CAT_PLUSHIE = registerCatPlushie(TABBY_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TUXEDO_CAT_PLUSHIE_KEY = createKey("tuxedo_cat_plushie");
    public static final Block TUXEDO_CAT_PLUSHIE = registerCatPlushie(TUXEDO_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> RED_CAT_PLUSHIE_KEY = createKey("red_cat_plushie");
    public static final Block RED_CAT_PLUSHIE = registerCatPlushie(RED_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> SIAMESE_CAT_PLUSHIE_KEY = createKey("siamese_cat_plushie");
    public static final Block SIAMESE_CAT_PLUSHIE = registerCatPlushie(SIAMESE_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> BRITISH_SHORTHAIR_CAT_PLUSHIE_KEY
            = createKey("british_shorthair_cat_plushie");
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSHIE = registerCatPlushie(BRITISH_SHORTHAIR_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> CALICO_CAT_PLUSHIE_KEY = createKey("calico_cat_plushie");
    public static final Block CALICO_CAT_PLUSHIE = registerCatPlushie(CALICO_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> PERSIAN_CAT_PLUSHIE_KEY = createKey("persian_cat_plushie");
    public static final Block PERSIAN_CAT_PLUSHIE = registerCatPlushie(PERSIAN_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> RAGDOLL_CAT_PLUSHIE_KEY = createKey("ragdoll_cat_plushie");
    public static final Block RAGDOLL_CAT_PLUSHIE = registerCatPlushie(RAGDOLL_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_CAT_PLUSHIE_KEY = createKey("white_cat_plushie");
    public static final Block WHITE_CAT_PLUSHIE = registerCatPlushie(WHITE_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> JELLIE_CAT_PLUSHIE_KEY = createKey("jellie_cat_plushie");
    public static final Block JELLIE_CAT_PLUSHIE = registerCatPlushie(JELLIE_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_CAT_PLUSHIE_KEY = createKey("black_cat_plushie");
    public static final Block BLACK_CAT_PLUSHIE = registerCatPlushie(BLACK_CAT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TEMPERATE_PIG_PLUSHIE_KEY = createKey("temperate_pig_plushie");
    public static final Block TEMPERATE_PIG_PLUSHIE
            = register(new PigPlushieBlock(makePlushieSettings(TEMPERATE_PIG_PLUSHIE_KEY)),
            TEMPERATE_PIG_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> COLD_PIG_PLUSHIE_KEY = createKey("cold_pig_plushie");
    public static final Block COLD_PIG_PLUSHIE
            = register(new PigPlushieBlock(makePlushieSettings(COLD_PIG_PLUSHIE_KEY)),
            COLD_PIG_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> BROWN_RABBIT_PLUSHIE_KEY = createKey("brown_rabbit_plushie");
    public static final Block BROWN_RABBIT_PLUSHIE = registerRabbitPlushie(BROWN_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_RABBIT_PLUSHIE_KEY = createKey("white_rabbit_plushie");
    public static final Block WHITE_RABBIT_PLUSHIE = registerRabbitPlushie(WHITE_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_RABBIT_PLUSHIE_KEY = createKey("black_rabbit_plushie");
    public static final Block BLACK_RABBIT_PLUSHIE = registerRabbitPlushie(BLACK_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY
            = createKey("white_splotched_rabbit_plushie");
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSHIE = registerRabbitPlushie(WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> GOLD_RABBIT_PLUSHIE_KEY = createKey("gold_rabbit_plushie");
    public static final Block GOLD_RABBIT_PLUSHIE = registerRabbitPlushie(GOLD_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> TOAST_RABBIT_PLUSHIE_KEY = createKey("toast_rabbit_plushie");
    public static final Block TOAST_RABBIT_PLUSHIE = registerRabbitPlushie(TOAST_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> SALT_RABBIT_PLUSHIE_KEY = createKey("salt_rabbit_plushie");
    public static final Block SALT_RABBIT_PLUSHIE = registerRabbitPlushie(SALT_RABBIT_PLUSHIE_KEY);
    public static final ResourceKey<Block> WHITE_SHEEP_PLUSHIE_KEY = createKey("white_sheep_plushie");
    public static final Block WHITE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.WHITE, WHITE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> ORANGE_SHEEP_PLUSHIE_KEY = createKey("orange_sheep_plushie");
    public static final Block ORANGE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.ORANGE, ORANGE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> MAGENTA_SHEEP_PLUSHIE_KEY = createKey("magenta_sheep_plushie");
    public static final Block MAGENTA_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.MAGENTA, MAGENTA_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> LIGHT_BLUE_SHEEP_PLUSHIE_KEY
            = createKey("light_blue_sheep_plushie");
    public static final Block LIGHT_BLUE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIGHT_BLUE, LIGHT_BLUE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> YELLOW_SHEEP_PLUSHIE_KEY = createKey("yellow_sheep_plushie");
    public static final Block YELLOW_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.YELLOW, YELLOW_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> LIME_SHEEP_PLUSHIE_KEY = createKey("lime_sheep_plushie");
    public static final Block LIME_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIME, LIME_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> PINK_SHEEP_PLUSHIE_KEY = createKey("pink_sheep_plushie");
    public static final Block PINK_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.PINK, PINK_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> GRAY_SHEEP_PLUSHIE_KEY = createKey("gray_sheep_plushie");
    public static final Block GRAY_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.GRAY, GRAY_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> LIGHT_GRAY_SHEEP_PLUSHIE_KEY = createKey("light_gray_sheep_plushie");
    public static final Block LIGHT_GRAY_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.LIGHT_GRAY, LIGHT_GRAY_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> CYAN_SHEEP_PLUSHIE_KEY = createKey("cyan_sheep_plushie");
    public static final Block CYAN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.CYAN, CYAN_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> PURPLE_SHEEP_PLUSHIE_KEY = createKey("purple_sheep_plushie");
    public static final Block PURPLE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.PURPLE, PURPLE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLUE_SHEEP_PLUSHIE_KEY = createKey("blue_sheep_plushie");
    public static final Block BLUE_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BLUE, BLUE_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> BROWN_SHEEP_PLUSHIE_KEY = createKey("brown_sheep_plushie");
    public static final Block BROWN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BROWN, BROWN_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> GREEN_SHEEP_PLUSHIE_KEY = createKey("green_sheep_plushie");
    public static final Block GREEN_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.GREEN, GREEN_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> RED_SHEEP_PLUSHIE_KEY = createKey("red_sheep_plushie");
    public static final Block RED_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.RED, RED_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> BLACK_SHEEP_PLUSHIE_KEY = createKey("black_sheep_plushie");
    public static final Block BLACK_SHEEP_PLUSHIE = registerSheepPlushie(DyeColor.BLACK, BLACK_SHEEP_PLUSHIE_KEY);
    public static final ResourceKey<Block> SKELETON_PLUSHIE_KEY = createKey("skeleton_plushie");
    public static final Block SKELETON_PLUSHIE
            = register(new SkeletonPlushieBlock(makePlushieSettings(SKELETON_PLUSHIE_KEY)),
            SKELETON_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> SLIME_PLUSHIE_KEY = createKey("slime_plushie");
    public static final Block SLIME_PLUSHIE = registerCubePlushie(SLIME_PLUSHIE_KEY);
    public static final ResourceKey<Block> SPIDER_PLUSHIE_KEY = createKey("spider_plushie");
    public static final Block SPIDER_PLUSHIE
            = register(new SpiderPlushieBlock(makePlushieSettings(SPIDER_PLUSHIE_KEY)),
            SPIDER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> SQUID_PLUSHIE_KEY = createKey("squid_plushie");
    public static final Block SQUID_PLUSHIE
            = register(new SquidPlushieBlock(makePlushieSettings(SQUID_PLUSHIE_KEY)),
            SQUID_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> GLOW_SQUID_PLUSHIE_KEY = createKey("glow_squid_plushie");
    public static final Block GLOW_SQUID_PLUSHIE
            = register(new SquidPlushieBlock(makeGlowingPlushieSettings(GLOW_SQUID_PLUSHIE_KEY)),
            GLOW_SQUID_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> BEE_PLUSHIE_KEY = createKey("bee_plushie");
    public static final Block BEE_PLUSHIE
            = register(new BeePlushieBlock(makePlushieSettings(BEE_PLUSHIE_KEY)),
            BEE_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> PLAINS_VILLAGER_PLUSHIE_KEY = createKey("plains_villager_plushie");
    public static final Block PLAINS_VILLAGER_PLUSHIE = registerVillagerPlushie(PLAINS_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> DESERT_VILLAGER_PLUSHIE_KEY = createKey("desert_villager_plushie");
    public static final Block DESERT_VILLAGER_PLUSHIE
            = register(new DesertVillagerPlushieBlock(makePlushieSettings(DESERT_VILLAGER_PLUSHIE_KEY)),
            DESERT_VILLAGER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> JUNGLE_VILLAGER_PLUSHIE_KEY = createKey("jungle_villager_plushie");
    public static final Block JUNGLE_VILLAGER_PLUSHIE = registerVillagerPlushie(JUNGLE_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SAVANNA_VILLAGER_PLUSHIE_KEY
            = createKey("savanna_villager_plushie");
    public static final Block SAVANNA_VILLAGER_PLUSHIE = registerVillagerPlushie(SAVANNA_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SNOWY_VILLAGER_PLUSHIE_KEY = createKey("snowy_villager_plushie");
    public static final Block SNOWY_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(SNOWY_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SWAMP_VILLAGER_PLUSHIE_KEY = createKey("swamp_villager_plushie");
    public static final Block SWAMP_VILLAGER_PLUSHIE = registerShortHatVillagerPlushie(SWAMP_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> TAIGA_VILLAGER_PLUSHIE_KEY = createKey("taiga_villager_plushie");
    public static final Block TAIGA_VILLAGER_PLUSHIE = registerVillagerPlushie(TAIGA_VILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> WITCH_PLUSHIE_KEY = createKey("witch_plushie");
    public static final Block WITCH_PLUSHIE = register(new WitchPlushieBlock(makePlushieSettings(WITCH_PLUSHIE_KEY)),
            WITCH_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> PALE_WOLF_PLUSHIE_KEY = createKey("pale_wolf_plushie");
    public static final Block PALE_WOLF_PLUSHIE = registerWolfPlushie(PALE_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> ZOMBIE_PLUSHIE_KEY = createKey("zombie_plushie");
    public static final Block ZOMBIE_PLUSHIE = registerZombiePlushie(ZOMBIE_PLUSHIE_KEY);
    public static final ResourceKey<Block> PIGLIN_PLUSHIE_KEY = createKey("piglin_plushie");
    public static final Block PIGLIN_PLUSHIE
            = register(new PiglinPlushieBlock(makePlushieSettings(PIGLIN_PLUSHIE_KEY)),
            PIGLIN_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> ZOMBIFIED_PIGLIN_PLUSHIE_KEY = createKey("zombified_piglin_plushie");
    public static final Block ZOMBIFIED_PIGLIN_PLUSHIE = registerZombiePlushie(ZOMBIFIED_PIGLIN_PLUSHIE_KEY);
    public static final ResourceKey<Block> PUFFERFISH_PLUSHIE_KEY = createKey("pufferfish_plushie");
    public static final Block PUFFERFISH_PLUSHIE
            = register(new PufferfishPlushieBlock(makePlushieSettings(PUFFERFISH_PLUSHIE_KEY)),
            PUFFERFISH_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> WITHER_PLUSHIE_KEY = createKey("wither_plushie");
    public static final Block WITHER_PLUSHIE
            = register(new WitherPlushieBlock(makePlushieSettings(WITHER_PLUSHIE_KEY)),
            WITHER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> STRIDER_PLUSHIE_KEY = createKey("strider_plushie");
    public static final Block STRIDER_PLUSHIE = registerStriderPlushie(STRIDER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SHIVERING_STRIDER_PLUSHIE_KEY
            = createKey("shivering_strider_plushie");
    public static final Block SHIVERING_STRIDER_PLUSHIE = registerStriderPlushie(SHIVERING_STRIDER_PLUSHIE_KEY);
    public static final ResourceKey<Block> PHANTOM_PLUSHIE_KEY = createKey("phantom_plushie");
    public static final Block PHANTOM_PLUSHIE
            = register(new PhantomPlushieBlock(makePlushieSettings(PHANTOM_PLUSHIE_KEY)),
            PHANTOM_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> HOGLIN_PLUSHIE_KEY = createKey("hoglin_plushie");
    public static final Block HOGLIN_PLUSHIE = registerHoglinPlushie(HOGLIN_PLUSHIE_KEY);
    public static final ResourceKey<Block> ZOGLIN_PLUSHIE_KEY = createKey("zoglin_plushie");
    public static final Block ZOGLIN_PLUSHIE = registerHoglinPlushie(ZOGLIN_PLUSHIE_KEY);
    public static final ResourceKey<Block> ALLAY_PLUSHIE_KEY = createKey("allay_plushie");
    public static final Block ALLAY_PLUSHIE = registerAllayPlushie(ALLAY_PLUSHIE_KEY);
    public static final ResourceKey<Block> PILLAGER_PLUSHIE_KEY = createKey("pillager_plushie");
    public static final Block PILLAGER_PLUSHIE = registerVillagerPlushie(PILLAGER_PLUSHIE_KEY);
    public static final ResourceKey<Block> VINDICATOR_PLUSHIE_KEY = createKey("vindicator_plushie");
    public static final Block VINDICATOR_PLUSHIE = registerVillagerPlushie(VINDICATOR_PLUSHIE_KEY);
    public static final ResourceKey<Block> EVOKER_PLUSHIE_KEY = createKey("evoker_plushie");
    public static final Block EVOKER_PLUSHIE = registerVillagerPlushie(EVOKER_PLUSHIE_KEY);
    public static final ResourceKey<Block> SHULKER_PLUSHIE_KEY = createKey("shulker_plushie");
    public static final Block SHULKER_PLUSHIE
            = register(new ShulkerPlushieBlock(makePlushieSettings(SHULKER_PLUSHIE_KEY)),
            SHULKER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> VEX_PLUSHIE_KEY = createKey("vex_plushie");
    public static final Block VEX_PLUSHIE = registerAllayPlushie(VEX_PLUSHIE_KEY);
    public static final ResourceKey<Block> CAMEL_PLUSHIE_KEY = createKey("camel_plushie");
    public static final Block CAMEL_PLUSHIE
            = register(new CamelPlushieBlock(makePlushieSettings(CAMEL_PLUSHIE_KEY)),
            CAMEL_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> NETHER_SMOKY_QUARTZ_ORE_KEY = createKey("nether_smoky_quartz_ore");
    public static final Block NETHER_SMOKY_QUARTZ_ORE
            = register(new DropExperienceBlock(UniformInt.of(2, 5),
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).setId(NETHER_SMOKY_QUARTZ_ORE_KEY)),
            NETHER_SMOKY_QUARTZ_ORE_KEY, true);
    public static final ResourceKey<Block> SMOKY_QUARTZ_BLOCK_KEY = createKey("smoky_quartz_block");
    public static final Block SMOKY_QUARTZ_BLOCK
            = register(new Block(makeSmokyQuartzSettings(SMOKY_QUARTZ_BLOCK_KEY)),
            SMOKY_QUARTZ_BLOCK_KEY, true);
    public static final ResourceKey<Block> CHISELED_SMOKY_QUARTZ_BLOCK_KEY
            = createKey("chiseled_smoky_quartz_block");
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK
            = register(new Block(makeSmokyQuartzSettings(CHISELED_SMOKY_QUARTZ_BLOCK_KEY)),
            CHISELED_SMOKY_QUARTZ_BLOCK_KEY, true);
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICKS_KEY = createKey("smoky_quartz_bricks");
    public static final Block SMOKY_QUARTZ_BRICKS
            = register(new Block(makeSmokyQuartzSettings(SMOKY_QUARTZ_BRICKS_KEY)),
            SMOKY_QUARTZ_BRICKS_KEY, true);
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICK_STAIRS_KEY
            = createKey("smoky_quartz_brick_stairs");
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS
            = registerStairs(SMOKY_QUARTZ_BRICK_STAIRS_KEY, makeSmokyQuartzSettings(SMOKY_QUARTZ_BRICK_STAIRS_KEY),
            SMOKY_QUARTZ_BRICKS);
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICK_SLAB_KEY
            = createKey("smoky_quartz_brick_slab");
    public static final Block SMOKY_QUARTZ_BRICK_SLAB
            = registerSlab(SMOKY_QUARTZ_BRICK_SLAB_KEY, makeSmokyQuartzSettings(SMOKY_QUARTZ_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> SMOKY_QUARTZ_BRICK_WALL_KEY = createKey("smoky_quartz_brick_wall");
    public static final Block SMOKY_QUARTZ_BRICK_WALL
            = registerWall(SMOKY_QUARTZ_BRICK_WALL_KEY, makeSmokyQuartzSettings(SMOKY_QUARTZ_BRICK_WALL_KEY));
    public static final ResourceKey<Block> SMOKY_QUARTZ_PILLAR_KEY = createKey("smoky_quartz_pillar");
    public static final Block SMOKY_QUARTZ_PILLAR
            = register(new RotatedPillarBlock(makeSmokyQuartzSettings(SMOKY_QUARTZ_PILLAR_KEY)),
            SMOKY_QUARTZ_PILLAR_KEY, true);
    public static final ResourceKey<Block> SMOKY_QUARTZ_STAIRS_KEY = createKey("smoky_quartz_stairs");
    public static final Block SMOKY_QUARTZ_STAIRS
            = registerStairs(SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(SMOKY_QUARTZ_STAIRS_KEY),
            SMOKY_QUARTZ_BLOCK);
    public static final ResourceKey<Block> SMOKY_QUARTZ_SLAB_KEY = createKey("smoky_quartz_slab");
    public static final Block SMOKY_QUARTZ_SLAB = registerSlab(SMOKY_QUARTZ_SLAB_KEY,
            makeSmokyQuartzSettings(SMOKY_QUARTZ_SLAB_KEY));
    public static final ResourceKey<Block> SMOKY_QUARTZ_WALL_KEY = createKey("smoky_quartz_wall");
    public static final Block SMOKY_QUARTZ_WALL = registerWall(SMOKY_QUARTZ_WALL_KEY,
            makeSmokyQuartzSettings(SMOKY_QUARTZ_WALL_KEY));
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_KEY = createKey("smooth_smoky_quartz");
    public static final Block SMOOTH_SMOKY_QUARTZ
            = register(new Block(makeSmokyQuartzSettings(SMOOTH_SMOKY_QUARTZ_KEY)),
            SMOOTH_SMOKY_QUARTZ_KEY, true);
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_STAIRS_KEY
            = createKey("smooth_smoky_quartz_stairs");
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS
            = registerStairs(SMOOTH_SMOKY_QUARTZ_STAIRS_KEY, makeSmokyQuartzSettings(SMOOTH_SMOKY_QUARTZ_STAIRS_KEY),
            SMOOTH_SMOKY_QUARTZ);
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_SLAB_KEY
            = createKey("smooth_smoky_quartz_slab");
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = registerSlab(SMOOTH_SMOKY_QUARTZ_SLAB_KEY,
            makeSmokyQuartzSettings(SMOOTH_SMOKY_QUARTZ_SLAB_KEY));
    public static final ResourceKey<Block> SMOOTH_SMOKY_QUARTZ_WALL_KEY
            = createKey("smooth_smoky_quartz_wall");
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL = registerWall(SMOOTH_SMOKY_QUARTZ_WALL_KEY,
            makeSmokyQuartzSettings(SMOOTH_SMOKY_QUARTZ_WALL_KEY));
    public static final ResourceKey<Block> CRACKED_STONE_BRICK_STAIRS_KEY
            = createKey("cracked_stone_brick_stairs");
    public static final Block CRACKED_STONE_BRICK_STAIRS
            = registerStairs(CRACKED_STONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(CRACKED_STONE_BRICK_STAIRS_KEY), Blocks.CRACKED_STONE_BRICKS);
    public static final ResourceKey<Block> CRACKED_STONE_BRICK_SLAB_KEY
            = createKey("cracked_stone_brick_slab");
    public static final Block CRACKED_STONE_BRICK_SLAB = registerSlab(CRACKED_STONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(CRACKED_STONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> CRACKED_STONE_BRICK_WALL_KEY
            = createKey("cracked_stone_brick_wall");
    public static final Block CRACKED_STONE_BRICK_WALL = registerWall(CRACKED_STONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRACKED_STONE_BRICKS)
                    .setId(CRACKED_STONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> BLUEBERRY_BUSH_KEY = createKey("blueberry_bush");
    public static final Block BLUEBERRY_BUSH
            = register(new BlueberryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS)
            .randomTicks().noCollision().sound(SoundType.SWEET_BERRY_BUSH)
            .pushReaction(PushReaction.DESTROY).setId(BLUEBERRY_BUSH_KEY)),
            BLUEBERRY_BUSH_KEY, false);
    public static final ResourceKey<Block> GREEN_ONIONS_KEY = createKey("green_onions");
    public static final Block GREEN_ONIONS
            = register(new GreenOnionsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
            .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY).setId(GREEN_ONIONS_KEY)),
            GREEN_ONIONS_KEY, false);
    public static final ResourceKey<Block> OAK_PLANTER_BOX_KEY = createKey("oak_planter_box");
    public static final Block OAK_PLANTER_BOX
            = registerPlanterBox(OAK_PLANTER_BOX_KEY, Blocks.OAK_PLANKS.defaultMapColor(), SoundType.WOOD);
    public static final ResourceKey<Block> SPRUCE_PLANTER_BOX_KEY = createKey("spruce_planter_box");
    public static final Block SPRUCE_PLANTER_BOX
            = registerPlanterBox(SPRUCE_PLANTER_BOX_KEY, Blocks.SPRUCE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> BIRCH_PLANTER_BOX_KEY = createKey("birch_planter_box");
    public static final Block BIRCH_PLANTER_BOX
            = registerPlanterBox(BIRCH_PLANTER_BOX_KEY, Blocks.BIRCH_PLANKS.defaultMapColor(), SoundType.WOOD);
    public static final ResourceKey<Block> JUNGLE_PLANTER_BOX_KEY = createKey("jungle_planter_box");
    public static final Block JUNGLE_PLANTER_BOX
            = registerPlanterBox(JUNGLE_PLANTER_BOX_KEY, Blocks.JUNGLE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> ACACIA_PLANTER_BOX_KEY = createKey("acacia_planter_box");
    public static final Block ACACIA_PLANTER_BOX
            = registerPlanterBox(ACACIA_PLANTER_BOX_KEY, Blocks.ACACIA_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> DARK_OAK_PLANTER_BOX_KEY = createKey("dark_oak_planter_box");
    public static final Block DARK_OAK_PLANTER_BOX
            = registerPlanterBox(DARK_OAK_PLANTER_BOX_KEY, Blocks.DARK_OAK_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> MANGROVE_PLANTER_BOX_KEY = createKey("mangrove_planter_box");
    public static final Block MANGROVE_PLANTER_BOX
            = registerPlanterBox(MANGROVE_PLANTER_BOX_KEY, Blocks.MANGROVE_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> CHERRY_PLANTER_BOX_KEY = createKey("cherry_planter_box");
    public static final Block CHERRY_PLANTER_BOX
            = registerPlanterBox(CHERRY_PLANTER_BOX_KEY, Blocks.CHERRY_PLANKS.defaultMapColor(),
            SoundType.CHERRY_WOOD);
    public static final ResourceKey<Block> PALE_OAK_PLANTER_BOX_KEY = createKey("pale_oak_planter_box");
    public static final Block PALE_OAK_PLANTER_BOX
            = registerPlanterBox(PALE_OAK_PLANTER_BOX_KEY, Blocks.PALE_OAK_PLANKS.defaultMapColor(),
            SoundType.WOOD);
    public static final ResourceKey<Block> CRIMSON_PLANTER_BOX_KEY = createKey("crimson_planter_box");
    public static final Block CRIMSON_PLANTER_BOX
            = registerNetherPlanterBox(CRIMSON_PLANTER_BOX_KEY, Blocks.CRIMSON_PLANKS.defaultMapColor());
    public static final ResourceKey<Block> WARPED_PLANTER_BOX_KEY = createKey("warped_planter_box");
    public static final Block WARPED_PLANTER_BOX
            = registerNetherPlanterBox(WARPED_PLANTER_BOX_KEY, Blocks.WARPED_PLANKS.defaultMapColor());
    public static final ResourceKey<Block> OAK_WALL_KEY = createKey("oak_wall");
    public static final Block OAK_WALL = registerWall(OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(OAK_WALL_KEY));
    public static final ResourceKey<Block> SPRUCE_WALL_KEY = createKey("spruce_wall");
    public static final Block SPRUCE_WALL = registerWall(SPRUCE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).setId(SPRUCE_WALL_KEY));
    public static final ResourceKey<Block> BIRCH_WALL_KEY = createKey("birch_wall");
    public static final Block BIRCH_WALL = registerWall(BIRCH_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).setId(BIRCH_WALL_KEY));
    public static final ResourceKey<Block> JUNGLE_WALL_KEY = createKey("jungle_wall");
    public static final Block JUNGLE_WALL = registerWall(JUNGLE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).setId(JUNGLE_WALL_KEY));
    public static final ResourceKey<Block> ACACIA_WALL_KEY = createKey("acacia_wall");
    public static final Block ACACIA_WALL = registerWall(ACACIA_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).setId(ACACIA_WALL_KEY));
    public static final ResourceKey<Block> DARK_OAK_WALL_KEY = createKey("dark_oak_wall");
    public static final Block DARK_OAK_WALL = registerWall(DARK_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).setId(DARK_OAK_WALL_KEY));
    public static final ResourceKey<Block> MANGROVE_WALL_KEY = createKey("mangrove_wall");
    public static final Block MANGROVE_WALL = registerWall(MANGROVE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).setId(MANGROVE_WALL_KEY));
    public static final ResourceKey<Block> CRIMSON_WALL_KEY = createKey("crimson_wall");
    public static final Block CRIMSON_WALL = registerWall(CRIMSON_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(CRIMSON_WALL_KEY));
    public static final ResourceKey<Block> WARPED_WALL_KEY = createKey("warped_wall");
    public static final Block WARPED_WALL = registerWall(WARPED_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(WARPED_WALL_KEY));
    public static final ResourceKey<Block> CHERRY_WALL_KEY = createKey("cherry_wall");
    public static final Block CHERRY_WALL = registerWall(CHERRY_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(CHERRY_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_OAK_WALL_KEY = createKey("stripped_oak_wall");
    public static final Block STRIPPED_OAK_WALL = registerWall(STRIPPED_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(STRIPPED_OAK_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_SPRUCE_WALL_KEY = createKey("stripped_spruce_wall");
    public static final Block STRIPPED_SPRUCE_WALL = registerWall(STRIPPED_SPRUCE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).setId(STRIPPED_SPRUCE_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_BIRCH_WALL_KEY = createKey("stripped_birch_wall");
    public static final Block STRIPPED_BIRCH_WALL = registerWall(STRIPPED_BIRCH_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).setId(STRIPPED_BIRCH_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_JUNGLE_WALL_KEY = createKey("stripped_jungle_wall");
    public static final Block STRIPPED_JUNGLE_WALL = registerWall(STRIPPED_JUNGLE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).setId(STRIPPED_JUNGLE_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_ACACIA_WALL_KEY = createKey("stripped_acacia_wall");
    public static final Block STRIPPED_ACACIA_WALL = registerWall(STRIPPED_ACACIA_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).setId(STRIPPED_ACACIA_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_DARK_OAK_WALL_KEY = createKey("stripped_dark_oak_wall");
    public static final Block STRIPPED_DARK_OAK_WALL = registerWall(STRIPPED_DARK_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).setId(STRIPPED_DARK_OAK_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_MANGROVE_WALL_KEY = createKey("stripped_mangrove_wall");
    public static final Block STRIPPED_MANGROVE_WALL = registerWall(STRIPPED_MANGROVE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).setId(STRIPPED_MANGROVE_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_CRIMSON_WALL_KEY = createKey("stripped_crimson_wall");
    public static final Block STRIPPED_CRIMSON_WALL = registerWall(STRIPPED_CRIMSON_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(STRIPPED_CRIMSON_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_WARPED_WALL_KEY = createKey("stripped_warped_wall");
    public static final Block STRIPPED_WARPED_WALL = registerWall(STRIPPED_WARPED_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(STRIPPED_WARPED_WALL_KEY));
    public static final ResourceKey<Block> STRIPPED_CHERRY_WALL_KEY = createKey("stripped_cherry_wall");
    public static final Block STRIPPED_CHERRY_WALL = registerWall(STRIPPED_CHERRY_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(STRIPPED_CHERRY_WALL_KEY));
    public static final ResourceKey<Block> OAK_ROPE_LADDER_KEY = createKey("oak_rope_ladder");
    public static final Block OAK_ROPE_LADDER = registerRopeLadder(OAK_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> SPRUCE_ROPE_LADDER_KEY = createKey("spruce_rope_ladder");
    public static final Block SPRUCE_ROPE_LADDER = registerRopeLadder(SPRUCE_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> BIRCH_ROPE_LADDER_KEY = createKey("birch_rope_ladder");
    public static final Block BIRCH_ROPE_LADDER = registerRopeLadder(BIRCH_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> JUNGLE_ROPE_LADDER_KEY = createKey("jungle_rope_ladder");
    public static final Block JUNGLE_ROPE_LADDER = registerRopeLadder(JUNGLE_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> ACACIA_ROPE_LADDER_KEY = createKey("acacia_rope_ladder");
    public static final Block ACACIA_ROPE_LADDER = registerRopeLadder(ACACIA_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> DARK_OAK_ROPE_LADDER_KEY = createKey("dark_oak_rope_ladder");
    public static final Block DARK_OAK_ROPE_LADDER = registerRopeLadder(DARK_OAK_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> CRIMSON_ROPE_LADDER_KEY = createKey("crimson_rope_ladder");
    public static final Block CRIMSON_ROPE_LADDER = registerRopeLadder(CRIMSON_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> WARPED_ROPE_LADDER_KEY = createKey("warped_rope_ladder");
    public static final Block WARPED_ROPE_LADDER = registerRopeLadder(WARPED_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> MANGROVE_ROPE_LADDER_KEY = createKey("mangrove_rope_ladder");
    public static final Block MANGROVE_ROPE_LADDER = registerRopeLadder(MANGROVE_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> CHERRY_ROPE_LADDER_KEY = createKey("cherry_rope_ladder");
    public static final Block CHERRY_ROPE_LADDER = registerRopeLadder(CHERRY_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> PALE_OAK_ROPE_LADDER_KEY = createKey("pale_oak_rope_ladder");
    public static final Block PALE_OAK_ROPE_LADDER = registerRopeLadder(PALE_OAK_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> IRON_LADDER_KEY = createKey("iron_ladder");
    public static final Block IRON_LADDER = register(new LadderBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL)
                    .noOcclusion().setId(IRON_LADDER_KEY)), IRON_LADDER_KEY, true);
    public static final ResourceKey<Block> SNOW_BRICKS_KEY = createKey("snow_bricks");
    public static final Block SNOW_BRICKS
            = register(new Block(makeSnowBrickSettings(SNOW_BRICKS_KEY)), SNOW_BRICKS_KEY, true);
    public static final ResourceKey<Block> SNOW_BRICK_STAIRS_KEY = createKey("snow_brick_stairs");
    public static final Block SNOW_BRICK_STAIRS
            = registerStairs(SNOW_BRICK_STAIRS_KEY, makeSnowBrickSettings(SNOW_BRICK_STAIRS_KEY), SNOW_BRICKS);
    public static final ResourceKey<Block> SNOW_BRICK_SLAB_KEY = createKey("snow_brick_slab");
    public static final Block SNOW_BRICK_SLAB
            = registerSlab(SNOW_BRICK_SLAB_KEY, makeSnowBrickSettings(SNOW_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> SNOW_BRICK_WALL_KEY = createKey("snow_brick_wall");
    public static final Block SNOW_BRICK_WALL
            = registerWall(SNOW_BRICK_WALL_KEY, makeSnowBrickSettings(SNOW_BRICK_WALL_KEY));
    public static final ResourceKey<Block> PACKED_SNOW_KEY = createKey("packed_snow");
    public static final Block PACKED_SNOW
            = register(new Block(makePackedSnowSettings(PACKED_SNOW_KEY)), PACKED_SNOW_KEY, true);
    public static final ResourceKey<Block> PACKED_SNOW_STAIRS_KEY = createKey("packed_snow_stairs");
    public static final Block PACKED_SNOW_STAIRS
            = registerStairs(PACKED_SNOW_STAIRS_KEY, makePackedSnowSettings(PACKED_SNOW_STAIRS_KEY), PACKED_SNOW);
    public static final ResourceKey<Block> PACKED_SNOW_SLAB_KEY = createKey("packed_snow_slab");
    public static final Block PACKED_SNOW_SLAB
            = registerSlab(PACKED_SNOW_SLAB_KEY, makePackedSnowSettings(PACKED_SNOW_SLAB_KEY));
    public static final ResourceKey<Block> PACKED_SNOW_WALL_KEY = createKey("packed_snow_wall");
    public static final Block PACKED_SNOW_WALL
            = registerWall(PACKED_SNOW_WALL_KEY, makePackedSnowSettings(PACKED_SNOW_WALL_KEY));
    public static final ResourceKey<Block> PURPLE_MUSHROOM_KEY = createKey("purple_mushroom");
    public static final Block PURPLE_MUSHROOM
            = register(new MushroomBlock(ModTreeConfiguredFeatures.HUGE_PURPLE_MUSHROOM,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
                    .pushReaction(PushReaction.DESTROY).noCollision().randomTicks().instabreak()
                    .sound(SoundType.GRASS).postProcess(ModBlocks::postProcessSelf).setId(PURPLE_MUSHROOM_KEY)),
            PURPLE_MUSHROOM_KEY, true);
    public static final ResourceKey<Block> PURPLE_MUSHROOM_BLOCK_KEY = createKey("purple_mushroom_block");
    public static final Block PURPLE_MUSHROOM_BLOCK
            = register(new PurpleMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE)
            .instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
            .setId(PURPLE_MUSHROOM_BLOCK_KEY)), PURPLE_MUSHROOM_BLOCK_KEY, true);
    public static final ResourceKey<Block> WHITE_CAMPFIRE_KEY = createKey("white_campfire");
    public static final Block WHITE_CAMPFIRE
            = registerDyedCampfire(WHITE_CAMPFIRE_KEY, ModParticleTypes.WHITE_EMBER);
    public static final ResourceKey<Block> ORANGE_CAMPFIRE_KEY = createKey("orange_campfire");
    public static final Block ORANGE_CAMPFIRE
            = registerDyedCampfire(ORANGE_CAMPFIRE_KEY, ModParticleTypes.ORANGE_EMBER);
    public static final ResourceKey<Block> MAGENTA_CAMPFIRE_KEY = createKey("magenta_campfire");
    public static final Block MAGENTA_CAMPFIRE
            = registerDyedCampfire(MAGENTA_CAMPFIRE_KEY, ModParticleTypes.MAGENTA_EMBER);
    public static final ResourceKey<Block> LIGHT_BLUE_CAMPFIRE_KEY = createKey("light_blue_campfire");
    public static final Block LIGHT_BLUE_CAMPFIRE
            = registerDyedCampfire(LIGHT_BLUE_CAMPFIRE_KEY, ModParticleTypes.LIGHT_BLUE_EMBER);
    public static final ResourceKey<Block> YELLOW_CAMPFIRE_KEY = createKey("yellow_campfire");
    public static final Block YELLOW_CAMPFIRE
            = registerDyedCampfire(YELLOW_CAMPFIRE_KEY, ModParticleTypes.YELLOW_EMBER);
    public static final ResourceKey<Block> LIME_CAMPFIRE_KEY = createKey("lime_campfire");
    public static final Block LIME_CAMPFIRE = registerDyedCampfire(LIME_CAMPFIRE_KEY, ModParticleTypes.LIME_EMBER);
    public static final ResourceKey<Block> PINK_CAMPFIRE_KEY = createKey("pink_campfire");
    public static final Block PINK_CAMPFIRE = registerDyedCampfire(PINK_CAMPFIRE_KEY, ModParticleTypes.PINK_EMBER);
    public static final ResourceKey<Block> GRAY_CAMPFIRE_KEY = createKey("gray_campfire");
    public static final Block GRAY_CAMPFIRE = registerDyedCampfire(GRAY_CAMPFIRE_KEY, ModParticleTypes.GRAY_EMBER);
    public static final ResourceKey<Block> LIGHT_GRAY_CAMPFIRE_KEY = createKey("light_gray_campfire");
    public static final Block LIGHT_GRAY_CAMPFIRE
            = registerDyedCampfire(LIGHT_GRAY_CAMPFIRE_KEY, ModParticleTypes.LIGHT_GRAY_EMBER);
    public static final ResourceKey<Block> CYAN_CAMPFIRE_KEY = createKey("cyan_campfire");
    public static final Block CYAN_CAMPFIRE = registerDyedCampfire(CYAN_CAMPFIRE_KEY, ModParticleTypes.CYAN_EMBER);
    public static final ResourceKey<Block> PURPLE_CAMPFIRE_KEY = createKey("purple_campfire");
    public static final Block PURPLE_CAMPFIRE = registerDyedCampfire(PURPLE_CAMPFIRE_KEY, ModParticleTypes.PURPLE_EMBER);
    public static final ResourceKey<Block> BLUE_CAMPFIRE_KEY = createKey("blue_campfire");
    public static final Block BLUE_CAMPFIRE = registerDyedCampfire(BLUE_CAMPFIRE_KEY, ModParticleTypes.BLUE_EMBER);
    public static final ResourceKey<Block> BROWN_CAMPFIRE_KEY = createKey("brown_campfire");
    public static final Block BROWN_CAMPFIRE = registerDyedCampfire(BROWN_CAMPFIRE_KEY, ModParticleTypes.BROWN_EMBER);
    public static final ResourceKey<Block> GREEN_CAMPFIRE_KEY = createKey("green_campfire");
    public static final Block GREEN_CAMPFIRE = registerDyedCampfire(GREEN_CAMPFIRE_KEY, ModParticleTypes.GREEN_EMBER);
    public static final ResourceKey<Block> RED_CAMPFIRE_KEY = createKey("red_campfire");
    public static final Block RED_CAMPFIRE = registerDyedCampfire(RED_CAMPFIRE_KEY, ModParticleTypes.RED_EMBER);
    public static final ResourceKey<Block> BLACK_CAMPFIRE_KEY = createKey("black_campfire");
    public static final Block BLACK_CAMPFIRE = registerDyedCampfire(BLACK_CAMPFIRE_KEY, ModParticleTypes.BLACK_EMBER);
    public static final ResourceKey<Block> WHITE_LANTERN_KEY = createKey("white_lantern");
    public static final Block WHITE_LANTERN = registerLantern(WHITE_LANTERN_KEY);
    public static final ResourceKey<Block> ORANGE_LANTERN_KEY = createKey("orange_lantern");
    public static final Block ORANGE_LANTERN = registerLantern(ORANGE_LANTERN_KEY);
    public static final ResourceKey<Block> MAGENTA_LANTERN_KEY = createKey("magenta_lantern");
    public static final Block MAGENTA_LANTERN = registerLantern(MAGENTA_LANTERN_KEY);
    public static final ResourceKey<Block> LIGHT_BLUE_LANTERN_KEY = createKey("light_blue_lantern");
    public static final Block LIGHT_BLUE_LANTERN = registerLantern(LIGHT_BLUE_LANTERN_KEY);
    public static final ResourceKey<Block> YELLOW_LANTERN_KEY = createKey("yellow_lantern");
    public static final Block YELLOW_LANTERN = registerLantern(YELLOW_LANTERN_KEY);
    public static final ResourceKey<Block> LIME_LANTERN_KEY = createKey("lime_lantern");
    public static final Block LIME_LANTERN = registerLantern(LIME_LANTERN_KEY);
    public static final ResourceKey<Block> PINK_LANTERN_KEY = createKey("pink_lantern");
    public static final Block PINK_LANTERN = registerLantern(PINK_LANTERN_KEY);
    public static final ResourceKey<Block> GRAY_LANTERN_KEY = createKey("gray_lantern");
    public static final Block GRAY_LANTERN = registerLantern(GRAY_LANTERN_KEY);
    public static final ResourceKey<Block> LIGHT_GRAY_LANTERN_KEY = createKey("light_gray_lantern");
    public static final Block LIGHT_GRAY_LANTERN = registerLantern(LIGHT_GRAY_LANTERN_KEY);
    public static final ResourceKey<Block> CYAN_LANTERN_KEY = createKey("cyan_lantern");
    public static final Block CYAN_LANTERN = registerLantern(CYAN_LANTERN_KEY);
    public static final ResourceKey<Block> PURPLE_LANTERN_KEY = createKey("purple_lantern");
    public static final Block PURPLE_LANTERN = registerLantern(PURPLE_LANTERN_KEY);
    public static final ResourceKey<Block> BLUE_LANTERN_KEY = createKey("blue_lantern");
    public static final Block BLUE_LANTERN = registerLantern(BLUE_LANTERN_KEY);
    public static final ResourceKey<Block> BROWN_LANTERN_KEY = createKey("brown_lantern");
    public static final Block BROWN_LANTERN = registerLantern(BROWN_LANTERN_KEY);
    public static final ResourceKey<Block> GREEN_LANTERN_KEY = createKey("green_lantern");
    public static final Block GREEN_LANTERN = registerLantern(GREEN_LANTERN_KEY);
    public static final ResourceKey<Block> RED_LANTERN_KEY = createKey("red_lantern");
    public static final Block RED_LANTERN = registerLantern(RED_LANTERN_KEY);
    public static final ResourceKey<Block> BLACK_LANTERN_KEY = createKey("black_lantern");
    public static final Block BLACK_LANTERN = registerLantern(BLACK_LANTERN_KEY);
    public static final ResourceKey<Block> WHITE_TORCH_KEY = createKey("white_torch");
    public static final Block WHITE_TORCH = registerTorch(WHITE_TORCH_KEY, ModParticleTypes.WHITE_FLAME);
    public static final ResourceKey<Block> ORANGE_TORCH_KEY = createKey("orange_torch");
    public static final Block ORANGE_TORCH = registerTorch(ORANGE_TORCH_KEY, ModParticleTypes.ORANGE_FLAME);
    public static final ResourceKey<Block> MAGENTA_TORCH_KEY = createKey("magenta_torch");
    public static final Block MAGENTA_TORCH = registerTorch(MAGENTA_TORCH_KEY, ModParticleTypes.MAGENTA_FLAME);
    public static final ResourceKey<Block> LIGHT_BLUE_TORCH_KEY = createKey("light_blue_torch");
    public static final Block LIGHT_BLUE_TORCH = registerTorch(LIGHT_BLUE_TORCH_KEY, ModParticleTypes.LIGHT_BLUE_FLAME);
    public static final ResourceKey<Block> YELLOW_TORCH_KEY = createKey("yellow_torch");
    public static final Block YELLOW_TORCH = registerTorch(YELLOW_TORCH_KEY, ModParticleTypes.YELLOW_FLAME);
    public static final ResourceKey<Block> LIME_TORCH_KEY = createKey("lime_torch");
    public static final Block LIME_TORCH = registerTorch(LIME_TORCH_KEY, ModParticleTypes.LIME_FLAME);
    public static final ResourceKey<Block> PINK_TORCH_KEY = createKey("pink_torch");
    public static final Block PINK_TORCH = registerTorch(PINK_TORCH_KEY, ModParticleTypes.PINK_FLAME);
    public static final ResourceKey<Block> GRAY_TORCH_KEY = createKey("gray_torch");
    public static final Block GRAY_TORCH = registerTorch(GRAY_TORCH_KEY, ModParticleTypes.GRAY_FLAME);
    public static final ResourceKey<Block> LIGHT_GRAY_TORCH_KEY = createKey("light_gray_torch");
    public static final Block LIGHT_GRAY_TORCH = registerTorch(LIGHT_GRAY_TORCH_KEY, ModParticleTypes.LIGHT_GRAY_FLAME);
    public static final ResourceKey<Block> CYAN_TORCH_KEY = createKey("cyan_torch");
    public static final Block CYAN_TORCH = registerTorch(CYAN_TORCH_KEY, ModParticleTypes.CYAN_FLAME);
    public static final ResourceKey<Block> PURPLE_TORCH_KEY = createKey("purple_torch");
    public static final Block PURPLE_TORCH = registerTorch(PURPLE_TORCH_KEY, ModParticleTypes.PURPLE_FLAME);
    public static final ResourceKey<Block> BLUE_TORCH_KEY = createKey("blue_torch");
    public static final Block BLUE_TORCH = registerTorch(BLUE_TORCH_KEY, ModParticleTypes.BLUE_FLAME);
    public static final ResourceKey<Block> BROWN_TORCH_KEY = createKey("brown_torch");
    public static final Block BROWN_TORCH = registerTorch(BROWN_TORCH_KEY, ModParticleTypes.BROWN_FLAME);
    public static final ResourceKey<Block> GREEN_TORCH_KEY = createKey("green_torch");
    public static final Block GREEN_TORCH = registerTorch(GREEN_TORCH_KEY, ModParticleTypes.GREEN_FLAME);
    public static final ResourceKey<Block> RED_TORCH_KEY = createKey("red_torch");
    public static final Block RED_TORCH = registerTorch(RED_TORCH_KEY, ModParticleTypes.RED_FLAME);
    public static final ResourceKey<Block> BLACK_TORCH_KEY = createKey("black_torch");
    public static final Block BLACK_TORCH = registerTorch(BLACK_TORCH_KEY, ModParticleTypes.BLACK_FLAME);
    public static final ResourceKey<Block> WHITE_WALL_TORCH_KEY = createKey("white_wall_torch");
    public static final Block WHITE_WALL_TORCH = registerWallTorch(WHITE_WALL_TORCH_KEY, WHITE_TORCH, ModParticleTypes.WHITE_FLAME);
    public static final ResourceKey<Block> ORANGE_WALL_TORCH_KEY = createKey("orange_wall_torch");
    public static final Block ORANGE_WALL_TORCH = registerWallTorch(ORANGE_WALL_TORCH_KEY, ORANGE_TORCH, ModParticleTypes.ORANGE_FLAME);
    public static final ResourceKey<Block> MAGENTA_WALL_TORCH_KEY = createKey("magenta_wall_torch");
    public static final Block MAGENTA_WALL_TORCH = registerWallTorch(MAGENTA_WALL_TORCH_KEY, MAGENTA_TORCH, ModParticleTypes.MAGENTA_FLAME);
    public static final ResourceKey<Block> LIGHT_BLUE_WALL_TORCH_KEY = createKey("light_blue_wall_torch");
    public static final Block LIGHT_BLUE_WALL_TORCH = registerWallTorch(LIGHT_BLUE_WALL_TORCH_KEY, LIGHT_BLUE_TORCH, ModParticleTypes.LIGHT_BLUE_FLAME);
    public static final ResourceKey<Block> YELLOW_WALL_TORCH_KEY = createKey("yellow_wall_torch");
    public static final Block YELLOW_WALL_TORCH = registerWallTorch(YELLOW_WALL_TORCH_KEY, YELLOW_TORCH, ModParticleTypes.YELLOW_FLAME);
    public static final ResourceKey<Block> LIME_WALL_TORCH_KEY = createKey("lime_wall_torch");
    public static final Block LIME_WALL_TORCH = registerWallTorch(LIME_WALL_TORCH_KEY, LIME_TORCH, ModParticleTypes.LIME_FLAME);
    public static final ResourceKey<Block> PINK_WALL_TORCH_KEY = createKey("pink_wall_torch");
    public static final Block PINK_WALL_TORCH = registerWallTorch(PINK_WALL_TORCH_KEY, PINK_TORCH, ModParticleTypes.PINK_FLAME);
    public static final ResourceKey<Block> GRAY_WALL_TORCH_KEY = createKey("gray_wall_torch");
    public static final Block GRAY_WALL_TORCH = registerWallTorch(GRAY_WALL_TORCH_KEY, GRAY_TORCH, ModParticleTypes.GRAY_FLAME);
    public static final ResourceKey<Block> LIGHT_GRAY_WALL_TORCH_KEY = createKey("light_gray_wall_torch");
    public static final Block LIGHT_GRAY_WALL_TORCH = registerWallTorch(LIGHT_GRAY_WALL_TORCH_KEY, LIGHT_GRAY_TORCH, ModParticleTypes.LIGHT_GRAY_FLAME);
    public static final ResourceKey<Block> CYAN_WALL_TORCH_KEY = createKey("cyan_wall_torch");
    public static final Block CYAN_WALL_TORCH = registerWallTorch(CYAN_WALL_TORCH_KEY, CYAN_TORCH, ModParticleTypes.CYAN_FLAME);
    public static final ResourceKey<Block> PURPLE_WALL_TORCH_KEY = createKey("purple_wall_torch");
    public static final Block PURPLE_WALL_TORCH = registerWallTorch(PURPLE_WALL_TORCH_KEY, PURPLE_TORCH, ModParticleTypes.PURPLE_FLAME);
    public static final ResourceKey<Block> BLUE_WALL_TORCH_KEY = createKey("blue_wall_torch");
    public static final Block BLUE_WALL_TORCH = registerWallTorch(BLUE_WALL_TORCH_KEY, BLUE_TORCH, ModParticleTypes.BLUE_FLAME);
    public static final ResourceKey<Block> BROWN_WALL_TORCH_KEY = createKey("brown_wall_torch");
    public static final Block BROWN_WALL_TORCH = registerWallTorch(BROWN_WALL_TORCH_KEY, BROWN_TORCH, ModParticleTypes.BROWN_FLAME);
    public static final ResourceKey<Block> GREEN_WALL_TORCH_KEY = createKey("green_wall_torch");
    public static final Block GREEN_WALL_TORCH = registerWallTorch(GREEN_WALL_TORCH_KEY, GREEN_TORCH, ModParticleTypes.GREEN_FLAME);
    public static final ResourceKey<Block> RED_WALL_TORCH_KEY = createKey("red_wall_torch");
    public static final Block RED_WALL_TORCH = registerWallTorch(RED_WALL_TORCH_KEY, RED_TORCH, ModParticleTypes.RED_FLAME);
    public static final ResourceKey<Block> BLACK_WALL_TORCH_KEY = createKey("black_wall_torch");
    public static final Block BLACK_WALL_TORCH = registerWallTorch(BLACK_WALL_TORCH_KEY, BLACK_TORCH, ModParticleTypes.BLACK_FLAME);
    public static final ResourceKey<Block> WITCHS_CRADLE_KEY = createKey("witchs_cradle");
    public static final Block WITCHS_CRADLE = register(new WitchsCradleBlock(BlockBehaviour.Properties
            .ofFullCopy(Blocks.SWEET_BERRY_BUSH).lightLevel((state) -> 8).setId(WITCHS_CRADLE_KEY)),
            WITCHS_CRADLE_KEY, false);
    public static final ResourceKey<Block> BAUXITE_KEY = createKey("bauxite");
    public static final Block BAUXITE = register(new Block(makeBauxiteSettings(BAUXITE_KEY)),
            BAUXITE_KEY, true);
    public static final ResourceKey<Block> BAUXITE_SLAB_KEY = createKey("bauxite_slab");
    public static final Block BAUXITE_SLAB = registerSlab(BAUXITE_SLAB_KEY, makeBauxiteSettings(BAUXITE_SLAB_KEY));
    public static final ResourceKey<Block> BAUXITE_STAIRS_KEY = createKey("bauxite_stairs");
    public static final Block BAUXITE_STAIRS
            = registerStairs(BAUXITE_STAIRS_KEY, makeBauxiteSettings(BAUXITE_STAIRS_KEY), BAUXITE);
    public static final ResourceKey<Block> BAUXITE_WALL_KEY = createKey("bauxite_wall");
    public static final Block BAUXITE_WALL = registerWall(BAUXITE_WALL_KEY, makeBauxiteSettings(BAUXITE_WALL_KEY));
    public static final ResourceKey<Block> BAUXITE_BRICKS_KEY = createKey("bauxite_bricks");
    public static final Block BAUXITE_BRICKS = register(new Block(makeBauxiteBricksSettings(BAUXITE_BRICKS_KEY)),
            BAUXITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> BAUXITE_BRICK_STAIRS_KEY = createKey("bauxite_brick_stairs");
    public static final Block BAUXITE_BRICK_STAIRS
            = registerStairs(BAUXITE_BRICK_STAIRS_KEY,
            makeBauxiteBricksSettings(BAUXITE_BRICK_STAIRS_KEY), BAUXITE_BRICKS);
    public static final ResourceKey<Block> BAUXITE_BRICK_SLAB_KEY = createKey("bauxite_brick_slab");
    public static final Block BAUXITE_BRICK_SLAB
            = registerSlab(BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings(BAUXITE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> BAUXITE_BRICK_WALL_KEY = createKey("bauxite_brick_wall");
    public static final Block BAUXITE_BRICK_WALL
            = registerWall(BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings(BAUXITE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICKS_KEY = createKey("mossy_bauxite_bricks");
    public static final Block MOSSY_BAUXITE_BRICKS
            = register(new Block(makeBauxiteBricksSettings(MOSSY_BAUXITE_BRICKS_KEY)),
            MOSSY_BAUXITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICK_STAIRS_KEY
            = createKey("mossy_bauxite_brick_stairs");
    public static final Block MOSSY_BAUXITE_BRICK_STAIRS
            = registerStairs(MOSSY_BAUXITE_BRICK_STAIRS_KEY, makeBauxiteBricksSettings(MOSSY_BAUXITE_BRICK_STAIRS_KEY),
            MOSSY_BAUXITE_BRICKS);
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICK_SLAB_KEY
            = createKey("mossy_bauxite_brick_slab");
    public static final Block MOSSY_BAUXITE_BRICK_SLAB
            = registerSlab(MOSSY_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings(MOSSY_BAUXITE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> MOSSY_BAUXITE_BRICK_WALL_KEY
            = createKey("mossy_bauxite_brick_wall");
    public static final Block MOSSY_BAUXITE_BRICK_WALL
            = registerWall(MOSSY_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings(MOSSY_BAUXITE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICKS_KEY = createKey("cracked_bauxite_bricks");
    public static final Block CRACKED_BAUXITE_BRICKS
            = register(new Block(makeBauxiteBricksSettings(CRACKED_BAUXITE_BRICKS_KEY)),
            CRACKED_BAUXITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICK_STAIRS_KEY
            = createKey("cracked_bauxite_brick_stairs");
    public static final Block CRACKED_BAUXITE_BRICK_STAIRS
            = registerStairs(CRACKED_BAUXITE_BRICK_STAIRS_KEY,
            makeBauxiteBricksSettings(CRACKED_BAUXITE_BRICK_STAIRS_KEY), CRACKED_BAUXITE_BRICKS);
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICK_SLAB_KEY
            = createKey("cracked_bauxite_brick_slab");
    public static final Block CRACKED_BAUXITE_BRICK_SLAB
            = registerSlab(CRACKED_BAUXITE_BRICK_SLAB_KEY, makeBauxiteBricksSettings(CRACKED_BAUXITE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> CRACKED_BAUXITE_BRICK_WALL_KEY
            = createKey("cracked_bauxite_brick_wall");
    public static final Block CRACKED_BAUXITE_BRICK_WALL
            = registerWall(CRACKED_BAUXITE_BRICK_WALL_KEY, makeBauxiteBricksSettings(CRACKED_BAUXITE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_NETHER_BRICKS_KEY = createKey("twisted_nether_bricks");
    public static final Block TWISTED_NETHER_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(TWISTED_NETHER_BRICKS_KEY)),
            TWISTED_NETHER_BRICKS_KEY, true);
    public static final ResourceKey<Block> TWISTED_NETHER_BRICK_STAIRS_KEY
            = createKey("twisted_nether_brick_stairs");
    public static final Block TWISTED_NETHER_BRICK_STAIRS
            = registerStairs(TWISTED_NETHER_BRICK_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(TWISTED_NETHER_BRICK_STAIRS_KEY), TWISTED_NETHER_BRICKS);
    public static final ResourceKey<Block> TWISTED_NETHER_BRICK_SLAB_KEY
            = createKey("twisted_nether_brick_slab");
    public static final Block TWISTED_NETHER_BRICK_SLAB
            = registerSlab(TWISTED_NETHER_BRICK_SLAB_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(TWISTED_NETHER_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_NETHER_BRICK_WALL_KEY
            = createKey("twisted_nether_brick_wall");
    public static final Block TWISTED_NETHER_BRICK_WALL
            = registerWall(TWISTED_NETHER_BRICK_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(TWISTED_NETHER_BRICK_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_NETHERRACK_KEY = createKey("twisted_netherrack");
    public static final Block TWISTED_NETHERRACK = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
            .setId(TWISTED_NETHERRACK_KEY)), TWISTED_NETHERRACK_KEY, true);
    public static final ResourceKey<Block> TWISTED_NETHERRACK_STAIRS_KEY
            = createKey("twisted_netherrack_stairs");
    public static final Block TWISTED_NETHERRACK_STAIRS = registerStairs(TWISTED_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(TWISTED_NETHERRACK_STAIRS_KEY),
            TWISTED_NETHERRACK);
    public static final ResourceKey<Block> TWISTED_NETHERRACK_SLAB_KEY
            = createKey("twisted_netherrack_slab");
    public static final Block TWISTED_NETHERRACK_SLAB = registerSlab(TWISTED_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(TWISTED_NETHERRACK_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_NETHERRACK_WALL_KEY
            = createKey("twisted_netherrack_wall");
    public static final Block TWISTED_NETHERRACK_WALL = registerWall(TWISTED_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(TWISTED_NETHERRACK_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_NETHER_BRICKS_KEY = createKey("weeping_nether_bricks");
    public static final Block WEEPING_NETHER_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
            .setId(WEEPING_NETHER_BRICKS_KEY)), WEEPING_NETHER_BRICKS_KEY, true);
    public static final ResourceKey<Block> WEEPING_NETHER_BRICK_STAIRS_KEY
            = createKey("weeping_nether_brick_stairs");
    public static final Block WEEPING_NETHER_BRICK_STAIRS = registerStairs(WEEPING_NETHER_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                    .setId(WEEPING_NETHER_BRICK_STAIRS_KEY), WEEPING_NETHER_BRICKS);
    public static final ResourceKey<Block> WEEPING_NETHER_BRICK_SLAB_KEY
            = createKey("weeping_nether_brick_slab");
    public static final Block WEEPING_NETHER_BRICK_SLAB = registerSlab(WEEPING_NETHER_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                .setId(WEEPING_NETHER_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_NETHER_BRICK_WALL_KEY
            = createKey("weeping_nether_brick_wall");
    public static final Block WEEPING_NETHER_BRICK_WALL = registerWall(WEEPING_NETHER_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)
                .setId(WEEPING_NETHER_BRICK_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_NETHERRACK_KEY = createKey("weeping_netherrack");
    public static final Block WEEPING_NETHERRACK
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
            .setId(WEEPING_NETHERRACK_KEY)), WEEPING_NETHERRACK_KEY, true);
    public static final ResourceKey<Block> WEEPING_NETHERRACK_STAIRS_KEY
            = createKey("weeping_netherrack_stairs");
    public static final Block WEEPING_NETHERRACK_STAIRS = registerStairs(WEEPING_NETHERRACK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .setId(WEEPING_NETHERRACK_STAIRS_KEY), WEEPING_NETHERRACK);
    public static final ResourceKey<Block> WEEPING_NETHERRACK_SLAB_KEY
            = createKey("weeping_netherrack_slab");
    public static final Block WEEPING_NETHERRACK_SLAB = registerSlab(WEEPING_NETHERRACK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .setId(WEEPING_NETHERRACK_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_NETHERRACK_WALL_KEY = createKey("weeping_netherrack_wall");
    public static final Block WEEPING_NETHERRACK_WALL = registerWall(WEEPING_NETHERRACK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).setId(WEEPING_NETHERRACK_WALL_KEY));
    public static final ResourceKey<Block> SNAPDRAGON_KEY = createKey("snapdragon");
    public static final Block SNAPDRAGON = register(new SnapdragonBlock(MobEffects.LUCK, 8,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY).lightLevel((state) -> 8)
                    .setId(SNAPDRAGON_KEY)), SNAPDRAGON_KEY, true);
    public static final ResourceKey<Block> POTTED_SNAPDRAGON_KEY = createKey("potted_snapdragon");
    public static final Block POTTED_SNAPDRAGON = registerPottedSnapdragon(BlockBehaviour.Properties
            .ofFullCopy(Blocks.POTTED_POPPY).lightLevel((state) -> 8).setId(POTTED_SNAPDRAGON_KEY));
    public static final ResourceKey<Block> POTTED_PURPLE_MUSHROOM_KEY = createKey("potted_purple_mushroom");
    public static final Block POTTED_PURPLE_MUSHROOM = register(new FlowerPotBlock(ModBlocks.PURPLE_MUSHROOM,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).setId(POTTED_PURPLE_MUSHROOM_KEY)),
            POTTED_PURPLE_MUSHROOM_KEY, false);
    public static final ResourceKey<Block> SHORT_ENDER_GRASS_KEY = createKey("short_ender_grass");
    public static final Block SHORT_ENDER_GRASS
        = register(new ShortEnderGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)
            .lightLevel((state) -> 8).setId(SHORT_ENDER_GRASS_KEY)),
            SHORT_ENDER_GRASS_KEY, true);
    public static final ResourceKey<Block> CATTAIL_KEY = createKey("cattail");
    public static final Block CATTAIL = register(new CattailBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BROWN).noCollision().noOcclusion().sound(SoundType.WET_GRASS)
            .setId(CATTAIL_KEY)), CATTAIL_KEY, true);
    public static final ResourceKey<Block> CHOCOLATE_CAKE_KEY = createKey("chocolate_cake");
    public static final Block CHOCOLATE_CAKE = registerCake(CHOCOLATE_CAKE_KEY);
    public static final ResourceKey<Block> RED_VELVET_CAKE_KEY = createKey("red_velvet_cake");
    public static final Block RED_VELVET_CAKE = registerCake(RED_VELVET_CAKE_KEY);

    public static final ResourceKey<Block> CANDLE_CHOCOLATE_CAKE_KEY = createKey("candle_chocolate_cake");
    public static final Block CANDLE_CHOCOLATE_CAKE = registerChocolateCandleCake();

    public static final ColorCollection<ResourceKey<Block>> DYED_CHOCOLATE_CANDLE_CAKE_KEYS = createSimpleColored("candle_chocolate_cake");
    public static final ColorCollection<Block> DYED_CHOCOLATE_CAKE = ColorCollection.registerBlocks(DYED_CHOCOLATE_CANDLE_CAKE_KEYS,
            ModBlocks::registerCandleCake, (s, p) -> new ModdedCandleCakeBlock(ModBlocks.CHOCOLATE_CAKE, Blocks.DYED_CANDLE.pick(s), p),
            (var0) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));

    public static final ResourceKey<Block> CANDLE_RED_VELVET_CAKE_KEY
            = createKey("candle_red_velvet_cake");
    public static final Block CANDLE_RED_VELVET_CAKE
            = registerRedVelvetCandleCake();

    public static final ColorCollection<ResourceKey<Block>> DYED_RED_VELVET_CAKE_KEYS = createSimpleColored("candle_red_velvet_cake");
    public static final ColorCollection<Block> DYED_RED_VELVET_CAKE = ColorCollection.registerBlocks(DYED_RED_VELVET_CAKE_KEYS,
            ModBlocks::registerCandleCake, (s, p) -> new ModdedCandleCakeBlock(ModBlocks.RED_VELVET_CAKE, Blocks.DYED_CANDLE.pick(s), p),
            (var0) -> BlockBehaviour.Properties.ofFullCopy(Blocks.CANDLE_CAKE));


    public static final ResourceKey<Block> STONE_TILES_KEY = createKey("stone_tiles");
    public static final Block STONE_TILES
            = register(new Block(makeStoneTileSettings(STONE_TILES_KEY)), STONE_TILES_KEY, true);
    public static final ResourceKey<Block> STONE_TILE_SLAB_KEY = createKey("stone_tile_slab");
    public static final Block STONE_TILE_SLAB
            = registerSlab(STONE_TILE_SLAB_KEY, makeStoneTileSettings(STONE_TILE_SLAB_KEY));
    public static final ResourceKey<Block> STONE_TILE_STAIRS_KEY = createKey("stone_tile_stairs");
    public static final Block STONE_TILE_STAIRS
            = registerStairs(STONE_TILE_STAIRS_KEY, makeStoneTileSettings(STONE_TILE_STAIRS_KEY), STONE_TILES);
    public static final ResourceKey<Block> STONE_TILE_WALL_KEY = createKey("stone_tile_wall");
    public static final Block STONE_TILE_WALL
            = registerWall(STONE_TILE_WALL_KEY, makeStoneTileSettings(STONE_TILE_WALL_KEY));
    public static final ResourceKey<Block> MOSSY_STONE_TILES_KEY = createKey("mossy_stone_tiles");
    public static final Block MOSSY_STONE_TILES = register(new Block(makeStoneTileSettings(MOSSY_STONE_TILES_KEY)),
            MOSSY_STONE_TILES_KEY, true);
    public static final ResourceKey<Block> MOSSY_STONE_TILE_SLAB_KEY = createKey("mossy_stone_tile_slab");
    public static final Block MOSSY_STONE_TILE_SLAB
            = registerSlab(MOSSY_STONE_TILE_SLAB_KEY, makeStoneTileSettings(MOSSY_STONE_TILE_SLAB_KEY));
    public static final ResourceKey<Block> MOSSY_STONE_TILE_STAIRS_KEY = createKey("mossy_stone_tile_stairs");
    public static final Block MOSSY_STONE_TILE_STAIRS
            = registerStairs(MOSSY_STONE_TILE_STAIRS_KEY,
            makeStoneTileSettings(MOSSY_STONE_TILE_STAIRS_KEY), MOSSY_STONE_TILES);
    public static final ResourceKey<Block> MOSSY_STONE_TILE_WALL_KEY = createKey("mossy_stone_tile_wall");
    public static final Block MOSSY_STONE_TILE_WALL
            = registerWall(MOSSY_STONE_TILE_WALL_KEY, makeStoneTileSettings(MOSSY_STONE_TILE_WALL_KEY));
    public static final ResourceKey<Block> CRACKED_STONE_TILES_KEY = createKey("cracked_stone_tiles");
    public static final Block CRACKED_STONE_TILES = register(new Block(makeStoneTileSettings(CRACKED_STONE_TILES_KEY)),
            CRACKED_STONE_TILES_KEY, true);
    public static final ResourceKey<Block> CRACKED_STONE_TILE_SLAB_KEY
            = createKey("cracked_stone_tile_slab");
    public static final Block CRACKED_STONE_TILE_SLAB
            = registerSlab(CRACKED_STONE_TILE_SLAB_KEY, makeStoneTileSettings(CRACKED_STONE_TILE_SLAB_KEY));
    public static final ResourceKey<Block> CRACKED_STONE_TILE_STAIRS_KEY
            = createKey("cracked_stone_tile_stairs");
    public static final Block CRACKED_STONE_TILE_STAIRS
            = registerStairs(CRACKED_STONE_TILE_STAIRS_KEY,
            makeStoneTileSettings(CRACKED_STONE_TILE_STAIRS_KEY), CRACKED_STONE_TILES);
    public static final ResourceKey<Block> CRACKED_STONE_TILE_WALL_KEY
            = createKey("cracked_stone_tile_wall");
    public static final Block CRACKED_STONE_TILE_WALL
            = registerWall(CRACKED_STONE_TILE_WALL_KEY, makeStoneTileSettings(CRACKED_STONE_TILE_WALL_KEY));
    public static final ResourceKey<Block> SWEET_BERRY_PIE_KEY = createKey("sweet_berry_pie");
    public static final Block SWEET_BERRY_PIE = registerPie(SWEET_BERRY_PIE_KEY);
    public static final ResourceKey<Block> BLUEBERRY_PIE_KEY = createKey("blueberry_pie");
    public static final Block BLUEBERRY_PIE = registerPie(BLUEBERRY_PIE_KEY);
    public static final ResourceKey<Block> BLACKSTONE_TILES_KEY = createKey("blackstone_tiles");
    public static final Block BLACKSTONE_TILES
            = register(new Block(makeBlackstoneTileSettings(BLACKSTONE_TILES_KEY)),
            BLACKSTONE_TILES_KEY, true);
    public static final ResourceKey<Block> BLACKSTONE_TILE_STAIRS_KEY = createKey("blackstone_tile_stairs");
    public static final Block BLACKSTONE_TILE_STAIRS
            = registerStairs(BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(BLACKSTONE_TILE_STAIRS_KEY), BLACKSTONE_TILES);
    public static final ResourceKey<Block> BLACKSTONE_TILE_SLAB_KEY = createKey("blackstone_tile_slab");
    public static final Block BLACKSTONE_TILE_SLAB
            = registerSlab(BLACKSTONE_TILE_SLAB_KEY, makeBlackstoneTileSettings(BLACKSTONE_TILE_SLAB_KEY));
    public static final ResourceKey<Block> BLACKSTONE_TILE_WALL_KEY = createKey("blackstone_tile_wall");
    public static final Block BLACKSTONE_TILE_WALL
            = registerWall(BLACKSTONE_TILE_WALL_KEY, makeBlackstoneTileSettings(BLACKSTONE_TILE_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILES_KEY = createKey("twisted_blackstone_tiles");
    public static final Block TWISTED_BLACKSTONE_TILES
            = register(new Block(makeBlackstoneTileSettings(TWISTED_BLACKSTONE_TILES_KEY)),
            TWISTED_BLACKSTONE_TILES_KEY, true);
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILE_STAIRS_KEY
            = createKey("twisted_blackstone_tile_stairs");
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS
            = registerStairs(TWISTED_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(TWISTED_BLACKSTONE_TILE_STAIRS_KEY), TWISTED_BLACKSTONE_TILES);
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILE_SLAB_KEY
            = createKey("twisted_blackstone_tile_slab");
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB
            = registerSlab(TWISTED_BLACKSTONE_TILE_SLAB_KEY,
            makeBlackstoneTileSettings(TWISTED_BLACKSTONE_TILE_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_TILE_WALL_KEY
            = createKey("twisted_blackstone_tile_wall");
    public static final Block TWISTED_BLACKSTONE_TILE_WALL
            = registerWall(TWISTED_BLACKSTONE_TILE_WALL_KEY,
            makeBlackstoneTileSettings(TWISTED_BLACKSTONE_TILE_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILES_KEY
            = createKey("weeping_blackstone_tiles");
    public static final Block WEEPING_BLACKSTONE_TILES
            = register(new Block(makeBlackstoneTileSettings(WEEPING_BLACKSTONE_TILES_KEY)),
            WEEPING_BLACKSTONE_TILES_KEY, true);
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILE_STAIRS_KEY
            = createKey("weeping_blackstone_tile_stairs");
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS = registerStairs(WEEPING_BLACKSTONE_TILE_STAIRS_KEY,
            makeBlackstoneTileSettings(WEEPING_BLACKSTONE_TILE_STAIRS_KEY), WEEPING_BLACKSTONE_TILES);
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILE_SLAB_KEY
            = createKey("weeping_blackstone_tile_slab");
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB
            = registerSlab(WEEPING_BLACKSTONE_TILE_SLAB_KEY,
            makeBlackstoneTileSettings(WEEPING_BLACKSTONE_TILE_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_TILE_WALL_KEY
            = createKey("weeping_blackstone_tile_wall");
    public static final Block WEEPING_BLACKSTONE_TILE_WALL
            = registerWall(WEEPING_BLACKSTONE_TILE_WALL_KEY,
            makeBlackstoneTileSettings(WEEPING_BLACKSTONE_TILE_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY
            = createKey("twisted_polished_blackstone_bricks");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY)),
            TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY, true);
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY
            = createKey("twisted_polished_blackstone_brick_stairs");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY),
            Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY
            = createKey("twisted_polished_blackstone_brick_slab");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY
            = createKey("twisted_polished_blackstone_brick_wall");
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY
            = createKey("weeping_polished_blackstone_bricks");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY)),
            WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY, true);
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY
            = createKey("weeping_polished_blackstone_brick_stairs");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS
            = registerStairs(WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY),
            WEEPING_POLISHED_BLACKSTONE_BRICKS);
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY
            = createKey("weeping_polished_blackstone_brick_slab");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB
            = registerSlab(WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY
            = createKey("weeping_polished_blackstone_brick_wall");
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL
            = registerWall(WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .setId(WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_KEY = createKey("twisted_blackstone");
    public static final Block TWISTED_BLACKSTONE
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(TWISTED_BLACKSTONE_KEY)),
            TWISTED_BLACKSTONE_KEY, true);
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_STAIRS_KEY
            = createKey("twisted_blackstone_stairs");
    public static final Block TWISTED_BLACKSTONE_STAIRS
            = registerStairs(TWISTED_BLACKSTONE_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
            .setId(TWISTED_BLACKSTONE_STAIRS_KEY), Blocks.BLACKSTONE);
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_SLAB_KEY
            = createKey("twisted_blackstone_slab");
    public static final Block TWISTED_BLACKSTONE_SLAB = registerSlab(TWISTED_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(TWISTED_BLACKSTONE_SLAB_KEY));
    public static final ResourceKey<Block> TWISTED_BLACKSTONE_WALL_KEY
            = createKey("twisted_blackstone_wall");
    public static final Block TWISTED_BLACKSTONE_WALL = registerWall(TWISTED_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(TWISTED_BLACKSTONE_WALL_KEY));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_KEY = createKey("weeping_blackstone");
    public static final Block WEEPING_BLACKSTONE = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
            .setId(WEEPING_BLACKSTONE_KEY)), WEEPING_BLACKSTONE_KEY, true);
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_STAIRS_KEY
            = createKey("weeping_blackstone_stairs");
    public static final Block WEEPING_BLACKSTONE_STAIRS
            = registerStairs(WEEPING_BLACKSTONE_STAIRS_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)
                        .setId(WEEPING_BLACKSTONE_STAIRS_KEY), WEEPING_BLACKSTONE);
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_SLAB_KEY
            = createKey("weeping_blackstone_slab");
    public static final Block WEEPING_BLACKSTONE_SLAB = registerSlab(WEEPING_BLACKSTONE_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(WEEPING_BLACKSTONE_SLAB_KEY));
    public static final ResourceKey<Block> WEEPING_BLACKSTONE_WALL_KEY
            = createKey("weeping_blackstone_wall");
    public static final Block WEEPING_BLACKSTONE_WALL = registerWall(WEEPING_BLACKSTONE_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE).setId(WEEPING_BLACKSTONE_WALL_KEY));
    public static final ResourceKey<Block> QUARTZ_TILES_KEY = createKey("quartz_tiles");
    public static final Block QUARTZ_TILES = register(new Block(makeQuartzTileSettings(QUARTZ_TILES_KEY)),
            QUARTZ_TILES_KEY, true);
    public static final ResourceKey<Block> QUARTZ_TILE_STAIRS_KEY = createKey("quartz_tile_stairs");
    public static final Block QUARTZ_TILE_STAIRS = registerStairs(QUARTZ_TILE_STAIRS_KEY,
            makeQuartzTileSettings(QUARTZ_TILE_STAIRS_KEY), QUARTZ_TILES);
    public static final ResourceKey<Block> QUARTZ_TILE_SLAB_KEY = createKey("quartz_tile_slab");
    public static final Block QUARTZ_TILE_SLAB
            = registerSlab(QUARTZ_TILE_SLAB_KEY, makeQuartzTileSettings(QUARTZ_TILE_SLAB_KEY));
    public static final ResourceKey<Block> QUARTZ_TILE_WALL_KEY = createKey("quartz_tile_wall");
    public static final Block QUARTZ_TILE_WALL
            = registerWall(QUARTZ_TILE_WALL_KEY, makeQuartzTileSettings(QUARTZ_TILE_WALL_KEY));
    public static final ResourceKey<Block> CALCITE_BRICKS_KEY = createKey("calcite_bricks");
    public static final Block CALCITE_BRICKS = register(new Block(makeCalciteSettings(CALCITE_BRICKS_KEY)),
            CALCITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> CALCITE_BRICK_STAIRS_KEY = createKey("calcite_brick_stairs");
    public static final Block CALCITE_BRICK_STAIRS = registerStairs(CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(CALCITE_BRICK_STAIRS_KEY), CALCITE_BRICKS);
    public static final ResourceKey<Block> CALCITE_BRICK_SLAB_KEY = createKey("calcite_brick_slab");
    public static final Block CALCITE_BRICK_SLAB = registerSlab(CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings(CALCITE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> CALCITE_BRICK_WALL_KEY = createKey("calcite_brick_wall");
    public static final Block CALCITE_BRICK_WALL = registerWall(CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings(CALCITE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICKS_KEY = createKey("mossy_calcite_bricks");
    public static final Block MOSSY_CALCITE_BRICKS
            = register(new Block(makeCalciteSettings(MOSSY_CALCITE_BRICKS_KEY)),
            MOSSY_CALCITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICK_STAIRS_KEY
            = createKey("mossy_calcite_brick_stairs");
    public static final Block MOSSY_CALCITE_BRICK_STAIRS = registerStairs(MOSSY_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(MOSSY_CALCITE_BRICK_STAIRS_KEY), MOSSY_CALCITE_BRICKS);
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICK_SLAB_KEY
            = createKey("mossy_calcite_brick_slab");
    public static final Block MOSSY_CALCITE_BRICK_SLAB
            = registerSlab(MOSSY_CALCITE_BRICK_SLAB_KEY, makeCalciteSettings(MOSSY_CALCITE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> MOSSY_CALCITE_BRICK_WALL_KEY
            = createKey("mossy_calcite_brick_wall");
    public static final Block MOSSY_CALCITE_BRICK_WALL = registerWall(MOSSY_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings(MOSSY_CALCITE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICKS_KEY
            = createKey("cracked_calcite_bricks");
    public static final Block CRACKED_CALCITE_BRICKS
            = register(new Block(makeCalciteSettings(CRACKED_CALCITE_BRICKS_KEY)),
            CRACKED_CALCITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICK_STAIRS_KEY
            = createKey("cracked_calcite_brick_stairs");
    public static final Block CRACKED_CALCITE_BRICK_STAIRS = registerStairs(CRACKED_CALCITE_BRICK_STAIRS_KEY,
            makeCalciteSettings(CRACKED_CALCITE_BRICK_STAIRS_KEY), CRACKED_CALCITE_BRICKS);
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICK_SLAB_KEY
            = createKey("cracked_calcite_brick_slab");
    public static final Block CRACKED_CALCITE_BRICK_SLAB = registerSlab(CRACKED_CALCITE_BRICK_SLAB_KEY,
            makeCalciteSettings(CRACKED_CALCITE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> CRACKED_CALCITE_BRICK_WALL_KEY
            = createKey("cracked_calcite_brick_wall");
    public static final Block CRACKED_CALCITE_BRICK_WALL = registerWall(CRACKED_CALCITE_BRICK_WALL_KEY,
            makeCalciteSettings(CRACKED_CALCITE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> CHISELED_CALCITE_BRICKS_KEY
            = createKey("chiseled_calcite_bricks");
    public static final Block CHISELED_CALCITE_BRICKS
            = register(new RotatedPillarBlock(makeCalciteSettings(CHISELED_CALCITE_BRICKS_KEY)),
            CHISELED_CALCITE_BRICKS_KEY, true);
    public static final ResourceKey<Block> DRIPSTONE_BRICKS_KEY = createKey("dripstone_bricks");
    public static final Block DRIPSTONE_BRICKS = register(new Block(makeDripstoneSettings(DRIPSTONE_BRICKS_KEY)),
            DRIPSTONE_BRICKS_KEY, true);
    public static final ResourceKey<Block> DRIPSTONE_BRICK_STAIRS_KEY = createKey("dripstone_brick_stairs");
    public static final Block DRIPSTONE_BRICK_STAIRS = registerStairs(DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(DRIPSTONE_BRICK_STAIRS_KEY), DRIPSTONE_BRICKS);
    public static final ResourceKey<Block> DRIPSTONE_BRICK_SLAB_KEY = createKey("dripstone_brick_slab");
    public static final Block DRIPSTONE_BRICK_SLAB = registerSlab(DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings(DRIPSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> DRIPSTONE_BRICK_WALL_KEY = createKey("dripstone_brick_wall");
    public static final Block DRIPSTONE_BRICK_WALL = registerWall(DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings(DRIPSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICKS_KEY = createKey("mossy_dripstone_bricks");
    public static final Block MOSSY_DRIPSTONE_BRICKS
            = register(new Block(makeDripstoneSettings(MOSSY_DRIPSTONE_BRICKS_KEY)),
            MOSSY_DRIPSTONE_BRICKS_KEY, true);
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICK_STAIRS_KEY
            = createKey("mossy_dripstone_brick_stairs");
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS = registerStairs(MOSSY_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(MOSSY_DRIPSTONE_BRICK_STAIRS_KEY), MOSSY_DRIPSTONE_BRICKS);
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICK_SLAB_KEY
            = createKey("mossy_dripstone_brick_slab");
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB = registerSlab(MOSSY_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings(MOSSY_DRIPSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> MOSSY_DRIPSTONE_BRICK_WALL_KEY
            = createKey("mossy_dripstone_brick_wall");
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL = registerWall(MOSSY_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings(MOSSY_DRIPSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICKS_KEY
            = createKey("cracked_dripstone_bricks");
    public static final Block CRACKED_DRIPSTONE_BRICKS
            = register(new Block(makeDripstoneSettings(CRACKED_DRIPSTONE_BRICKS_KEY)),
            CRACKED_DRIPSTONE_BRICKS_KEY, true);
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICK_STAIRS_KEY
            = createKey("cracked_dripstone_brick_stairs");
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS = registerStairs(CRACKED_DRIPSTONE_BRICK_STAIRS_KEY,
            makeDripstoneSettings(CRACKED_DRIPSTONE_BRICK_STAIRS_KEY), CRACKED_DRIPSTONE_BRICKS);
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICK_SLAB_KEY
            = createKey("cracked_dripstone_brick_slab");
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB = registerSlab(CRACKED_DRIPSTONE_BRICK_SLAB_KEY,
            makeDripstoneSettings(CRACKED_DRIPSTONE_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> CRACKED_DRIPSTONE_BRICK_WALL_KEY
            = createKey("cracked_dripstone_brick_wall");
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL = registerWall(CRACKED_DRIPSTONE_BRICK_WALL_KEY,
            makeDripstoneSettings(CRACKED_DRIPSTONE_BRICK_WALL_KEY));
    public static final ResourceKey<Block> CHISELED_DRIPSTONE_BRICKS_KEY
            = createKey("chiseled_dripstone_bricks");
    public static final Block CHISELED_DRIPSTONE_BRICKS
            = register(new Block(makeDripstoneSettings(CHISELED_DRIPSTONE_BRICKS_KEY)),
            CHISELED_DRIPSTONE_BRICKS_KEY, true);
    public static final ResourceKey<Block> BLOOD_KELP_KEY = createKey("blood_kelp");
    public static final Block BLOOD_KELP
            = register(new BloodKelpBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP)
                    .lightLevel(getLuminanceFromState()).setId(BLOOD_KELP_KEY)),
            BLOOD_KELP_KEY, false);
    public static final ResourceKey<Block> BLOOD_KELP_PLANT_KEY = createKey("blood_kelp_plant");
    public static final Block BLOOD_KELP_PLANT
            = register(new BloodKelpPlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.KELP_PLANT)
                    .lightLevel(getLuminanceFromState()).setId(BLOOD_KELP_PLANT_KEY)),
            BLOOD_KELP_PLANT_KEY, false);
    public static final ResourceKey<Block> DRIED_BLOOD_KELP_BLOCK_KEY = createKey("dried_blood_kelp_block");
    public static final Block DRIED_BLOOD_KELP_BLOCK
            = register(new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIED_KELP_BLOCK)
                    .setId(DRIED_BLOOD_KELP_BLOCK_KEY)), DRIED_BLOOD_KELP_BLOCK_KEY, true);
    public static final ResourceKey<Block> BLOOD_KELP_LANTERN_KEY = createKey("blood_kelp_lantern");
    public static final Block BLOOD_KELP_LANTERN
            = register(new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.3F)
                    .sound(SoundType.GLASS).lightLevel((state) -> 15)
                    .setId(BLOOD_KELP_LANTERN_KEY)),
            BLOOD_KELP_LANTERN_KEY, true);
    public static final ResourceKey<Block> BOG_BLOSSOM_KEY = createKey("bog_blossom");
    public static final Block BOG_BLOSSOM = register(new BogBlossomBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.PLANT).instabreak().noCollision().sound(SoundType.SPORE_BLOSSOM)
            .pushReaction(PushReaction.DESTROY).lightLevel((state) -> 5).setId(BOG_BLOSSOM_KEY)),
            BOG_BLOSSOM_KEY, true);
    public static final ResourceKey<Block> CINDERSNAP_BERRY_BUSH_KEY = createKey("cindersnap_berry_bush");
    public static final Block CINDERSNAP_BERRY_BUSH
            = register(new CindersnapBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
            .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> 8).setId(CINDERSNAP_BERRY_BUSH_KEY)),
            CINDERSNAP_BERRY_BUSH_KEY, false);
    public static final ResourceKey<Block> FROSTBITE_BERRY_BUSH_KEY = createKey("frostbite_berry_bush");
    public static final Block FROSTBITE_BERRY_BUSH
            = register(new FrostbiteBerryBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN)
            .randomTicks().noCollision().sound(SoundType.NETHER_SPROUTS).pushReaction(PushReaction.DESTROY)
            .lightLevel((state) -> 5).setId(FROSTBITE_BERRY_BUSH_KEY)),
            FROSTBITE_BERRY_BUSH_KEY, false);
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_KEY = createKey("polished_dripstone");
    public static final Block POLISHED_DRIPSTONE
            = register(new Block(makeDripstoneSettings(POLISHED_DRIPSTONE_KEY)),
            POLISHED_DRIPSTONE_KEY, true);
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_STAIRS_KEY
            = createKey("polished_dripstone_stairs");
    public static final Block POLISHED_DRIPSTONE_STAIRS = registerStairs(POLISHED_DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(POLISHED_DRIPSTONE_STAIRS_KEY), POLISHED_DRIPSTONE);
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_SLAB_KEY
            = createKey("polished_dripstone_slab");
    public static final Block POLISHED_DRIPSTONE_SLAB
            = registerSlab(POLISHED_DRIPSTONE_SLAB_KEY, makeDripstoneSettings(POLISHED_DRIPSTONE_SLAB_KEY));
    public static final ResourceKey<Block> POLISHED_DRIPSTONE_WALL_KEY
            = createKey("polished_dripstone_wall");
    public static final Block POLISHED_DRIPSTONE_WALL = registerWall(POLISHED_DRIPSTONE_WALL_KEY,
            makeDripstoneSettings(POLISHED_DRIPSTONE_WALL_KEY));
    public static final ResourceKey<Block> POLISHED_CALCITE_KEY = createKey("polished_calcite");
    public static final Block POLISHED_CALCITE = register(new Block(makeCalciteSettings(POLISHED_CALCITE_KEY)),
            POLISHED_CALCITE_KEY, true);
    public static final ResourceKey<Block> POLISHED_CALCITE_STAIRS_KEY
            = createKey("polished_calcite_stairs");
    public static final Block POLISHED_CALCITE_STAIRS = registerStairs(POLISHED_CALCITE_STAIRS_KEY, 
            makeCalciteSettings(POLISHED_CALCITE_STAIRS_KEY), POLISHED_CALCITE);
    public static final ResourceKey<Block> POLISHED_CALCITE_SLAB_KEY = createKey("polished_calcite_slab");
    public static final Block POLISHED_CALCITE_SLAB = registerSlab(POLISHED_CALCITE_SLAB_KEY,
            makeCalciteSettings(POLISHED_CALCITE_SLAB_KEY));
    public static final ResourceKey<Block> POLISHED_CALCITE_WALL_KEY = createKey("polished_calcite_wall");
    public static final Block POLISHED_CALCITE_WALL = registerWall(POLISHED_CALCITE_WALL_KEY,
            makeCalciteSettings(POLISHED_CALCITE_WALL_KEY));
    public static final ResourceKey<Block> DRIPSTONE_STAIRS_KEY = createKey("dripstone_stairs");
    public static final Block DRIPSTONE_STAIRS = registerStairs(DRIPSTONE_STAIRS_KEY,
            makeDripstoneSettings(DRIPSTONE_STAIRS_KEY), Blocks.DRIPSTONE_BLOCK);
    public static final ResourceKey<Block> DRIPSTONE_SLAB_KEY = createKey("dripstone_slab");
    public static final Block DRIPSTONE_SLAB = registerSlab(DRIPSTONE_SLAB_KEY,
            makeDripstoneSettings(DRIPSTONE_SLAB_KEY));
    public static final ResourceKey<Block> DRIPSTONE_WALL_KEY = createKey("dripstone_wall");
    public static final Block DRIPSTONE_WALL = registerWall(DRIPSTONE_WALL_KEY,
            makeDripstoneSettings(DRIPSTONE_WALL_KEY));
    public static final ResourceKey<Block> CALCITE_STAIRS_KEY = createKey("calcite_stairs");
    public static final Block CALCITE_STAIRS = registerStairs(CALCITE_STAIRS_KEY,
            makeCalciteSettings(CALCITE_STAIRS_KEY), Blocks.CALCITE);
    public static final ResourceKey<Block> CALCITE_SLAB_KEY = createKey("calcite_slab");
    public static final Block CALCITE_SLAB = registerSlab(CALCITE_SLAB_KEY, makeCalciteSettings(CALCITE_SLAB_KEY));
    public static final ResourceKey<Block> CALCITE_WALL_KEY = createKey("calcite_wall");
    public static final Block CALCITE_WALL = registerWall(CALCITE_WALL_KEY, makeCalciteSettings(CALCITE_WALL_KEY));
    public static final ResourceKey<Block> BAMBOO_PLANTER_BOX_KEY = createKey("bamboo_planter_box");
    public static final Block BAMBOO_PLANTER_BOX = registerPlanterBox(BAMBOO_PLANTER_BOX_KEY,
            Blocks.BAMBOO_PLANKS.defaultMapColor(), SoundType.BAMBOO_WOOD);
    public static final ResourceKey<Block> POTTED_CATTAIL_KEY = createKey("potted_cattail");
    public static final Block POTTED_CATTAIL = register(new FlowerPotBlock(ModBlocks.CATTAIL,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).setId(POTTED_CATTAIL_KEY)),
            POTTED_CATTAIL_KEY, false);
    public static final ResourceKey<Block> STONE_WALL_KEY = createKey("stone_wall");
    public static final Block STONE_WALL = registerWall(STONE_WALL_KEY, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
            .setId(STONE_WALL_KEY));
    public static final ResourceKey<Block> QUARTZ_WALL_KEY = createKey("quartz_wall");
    public static final Block QUARTZ_WALL = registerWall(QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BLOCK).setId(QUARTZ_WALL_KEY));
    public static final ResourceKey<Block> SMOOTH_QUARTZ_WALL_KEY = createKey("smooth_quartz_wall");
    public static final Block SMOOTH_QUARTZ_WALL = registerWall(SMOOTH_QUARTZ_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ).setId(SMOOTH_QUARTZ_WALL_KEY));
    public static final ResourceKey<Block> GRASS_SLAB_KEY = createKey("grass_slab");
    public static final Block GRASS_SLAB
            = register(new GrassSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)
                    .setId(GRASS_SLAB_KEY)),
            GRASS_SLAB_KEY, true);
    public static final ResourceKey<Block> PODZOL_SLAB_KEY = createKey("podzol_slab");
    public static final Block PODZOL_SLAB = registerSnowySlab(PODZOL_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PODZOL).setId(PODZOL_SLAB_KEY));
    public static final ResourceKey<Block> MYCELIUM_SLAB_KEY = createKey("mycelium_slab");
    public static final Block MYCELIUM_SLAB = registerSnowySlab(MYCELIUM_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.MYCELIUM).setId(MYCELIUM_SLAB_KEY));
    public static final ResourceKey<Block> DIRT_PATH_SLAB_KEY = createKey("dirt_path_slab");
    public static final Block DIRT_PATH_SLAB
            = register(new DirtPathSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT_PATH)
                    .setId(DIRT_PATH_SLAB_KEY)),
            DIRT_PATH_SLAB_KEY, true);
    public static final ResourceKey<Block> DIRT_SLAB_KEY = createKey("dirt_slab");
    public static final Block DIRT_SLAB
            = register(new DirtSlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)
                    .setId(DIRT_SLAB_KEY)),
            DIRT_SLAB_KEY, true);
    public static final ResourceKey<Block> COARSE_DIRT_SLAB_KEY = createKey("coarse_dirt_slab");
    public static final Block COARSE_DIRT_SLAB = registerSlab(COARSE_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT).setId(COARSE_DIRT_SLAB_KEY));
    public static final ResourceKey<Block> ROOTED_DIRT_SLAB_KEY = createKey("rooted_dirt_slab");
    public static final Block ROOTED_DIRT_SLAB = registerSlab(ROOTED_DIRT_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(ROOTED_DIRT_SLAB_KEY));
    public static final ResourceKey<Block> WILD_GREEN_ONIONS_KEY = createKey("wild_green_onions");
    public static final Block WILD_GREEN_ONIONS
            = register(new WildGreenOnionsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
            .noCollision().randomTicks().instabreak().sound(SoundType.CROP)
            .pushReaction(PushReaction.DESTROY).setId(WILD_GREEN_ONIONS_KEY)),
            WILD_GREEN_ONIONS_KEY, true);
    public static final ResourceKey<Block> CREAKING_PLUSHIE_KEY = createKey("creaking_plushie");
    public static final Block CREAKING_PLUSHIE
            = register(new CreakingPlushieBlock(makePlushieSettings(CREAKING_PLUSHIE_KEY)),
            CREAKING_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> QUARTZ_BRICK_STAIRS_KEY = createKey("quartz_brick_stairs");
    public static final Block QUARTZ_BRICK_STAIRS = registerStairs(QUARTZ_BRICK_STAIRS_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(QUARTZ_BRICK_STAIRS_KEY),
            Blocks.QUARTZ_BRICKS);
    public static final ResourceKey<Block> QUARTZ_BRICK_SLAB_KEY = createKey("quartz_brick_slab");
    public static final Block QUARTZ_BRICK_SLAB = registerSlab(QUARTZ_BRICK_SLAB_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(QUARTZ_BRICK_SLAB_KEY));
    public static final ResourceKey<Block> QUARTZ_BRICK_WALL_KEY = createKey("quartz_brick_wall");
    public static final Block QUARTZ_BRICK_WALL = registerWall(QUARTZ_BRICK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS).setId(QUARTZ_BRICK_WALL_KEY));
    public static final ResourceKey<Block> SNIFFER_PLUSHIE_KEY = createKey("sniffer_plushie");
    public static final Block SNIFFER_PLUSHIE
            = register(new SnifferPlushieBlock(makePlushieSettings(SNIFFER_PLUSHIE_KEY)),
            SNIFFER_PLUSHIE_KEY, true);
    public static final ResourceKey<Block> STRIPPED_PALE_OAK_WALL_KEY = createKey("stripped_pale_oak_wall");
    public static final Block STRIPPED_PALE_OAK_WALL = registerWall(STRIPPED_PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).setId(STRIPPED_PALE_OAK_WALL_KEY));
    public static final ResourceKey<Block> PALE_OAK_WALL_KEY = createKey("pale_oak_wall");
    public static final Block PALE_OAK_WALL = registerWall(PALE_OAK_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS).setId(PALE_OAK_WALL_KEY));
    public static final ResourceKey<Block> BAMBOO_ROPE_LADDER_KEY = createKey("bamboo_rope_ladder");
    public static final Block BAMBOO_ROPE_LADDER = registerRopeLadder(BAMBOO_ROPE_LADDER_KEY);
    public static final ResourceKey<Block> STRIPPED_BAMBOO_WALL_KEY = createKey("stripped_bamboo_wall");
    public static final Block STRIPPED_BAMBOO_WALL = registerWall(STRIPPED_BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(STRIPPED_BAMBOO_WALL_KEY));
    public static final ResourceKey<Block> BAMBOO_WALL_KEY = createKey("bamboo_wall");
    public static final Block BAMBOO_WALL = registerWall(BAMBOO_WALL_KEY,
            BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(BAMBOO_WALL_KEY));
    public static final ResourceKey<Block> BLACK_WOLF_PLUSHIE_KEY = createKey("black_wolf_plushie");
    public static final Block BLACK_WOLF_PLUSHIE = registerWolfPlushie(BLACK_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> ASHEN_WOLF_PLUSHIE_KEY = createKey("ashen_wolf_plushie");
    public static final Block ASHEN_WOLF_PLUSHIE = registerWolfPlushie(ASHEN_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> CHESTNUT_WOLF_PLUSHIE_KEY = createKey("chestnut_wolf_plushie");
    public static final Block CHESTNUT_WOLF_PLUSHIE = registerWolfPlushie(CHESTNUT_WOLF_PLUSHIE_KEY);
    public static final ResourceKey<Block> RUSTY_WOLF_PLUSHIE_KEY = createKey("rusty_wolf_plushie");
    public static final Block RUSTY_WOLF_PLUSHIE = registerWolfPlushie(RUSTY_WOLF_PLUSHIE_KEY);

    private static ResourceKey<Block> createKey(String name) {
        return ResourceKey.create(Registries.BLOCK, AssortedDiscoveries.makeModId(name));
    }

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
        return register(pottedSnapdragonBlock, ModBlocks.POTTED_SNAPDRAGON_KEY, false);
    }

    private static Block registerCake(ResourceKey<Block> blockKey) {
        Block moddedCakeBlock = new ModdedCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).setId(blockKey));
        return register(moddedCakeBlock, blockKey, true);
    }

    private static Block registerChocolateCandleCake() {
        return registerCandleCake(ModBlocks.CANDLE_CHOCOLATE_CAKE_KEY, ModBlocks.CHOCOLATE_CAKE);
    }

    private static Block registerRedVelvetCandleCake() {
        return registerCandleCake(ModBlocks.CANDLE_RED_VELVET_CAKE_KEY, ModBlocks.RED_VELVET_CAKE);
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

    private static ColorCollection<ResourceKey<Block>> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModBlocks::createKey);
    }

    /**
     * Called during mod initialization to make sure that every block
     * is registered and available later during gameplay.
     */
    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }
}
