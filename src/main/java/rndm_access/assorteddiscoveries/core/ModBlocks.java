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

public class ModBlocks {
    public static final Block BAT_PLUSHIE;
    public static final Block BLAZE_PLUSHIE;
    public static final Block CAVE_SPIDER_PLUSHIE;
    public static final Block CHICKEN_PLUSHIE;
    public static final Block COW_PLUSHIE;
    public static final Block CREEPER_PLUSHIE;
    public static final Block ENDERMAN_PLUSHIE;
    public static final Block GHAST_PLUSHIE;
    public static final Block GUARDIAN_PLUSHIE;
    public static final Block WHITE_HORSE_PLUSHIE;
    public static final Block GRAY_HORSE_PLUSHIE;
    public static final Block LIGHT_GRAY_HORSE_PLUSHIE;
    public static final Block BROWN_HORSE_PLUSHIE;
    public static final Block BLACK_HORSE_PLUSHIE;
    public static final Block MAGMA_CUBE_PLUSHIE;
    public static final Block RED_MOOSHROOM_PLUSHIE;
    public static final Block BROWN_MOOSHROOM_PLUSHIE;
    public static final Block OCELOT_PLUSHIE;
    public static final Block TABBY_CAT_PLUSHIE;
    public static final Block TUXEDO_CAT_PLUSHIE;
    public static final Block RED_CAT_PLUSHIE;
    public static final Block SIAMESE_CAT_PLUSHIE;
    public static final Block BRITISH_SHORTHAIR_CAT_PLUSHIE;
    public static final Block CALICO_CAT_PLUSHIE;
    public static final Block PERSIAN_CAT_PLUSHIE;
    public static final Block RAGDOLL_CAT_PLUSHIE;
    public static final Block WHITE_CAT_PLUSHIE;
    public static final Block JELLIE_CAT_PLUSHIE;
    public static final Block BLACK_CAT_PLUSHIE;
    public static final Block PIG_PLUSHIE;
    public static final Block BROWN_RABBIT_PLUSHIE;
    public static final Block WHITE_RABBIT_PLUSHIE;
    public static final Block BLACK_RABBIT_PLUSHIE;
    public static final Block WHITE_SPLOTCHED_RABBIT_PLUSHIE;
    public static final Block GOLD_RABBIT_PLUSHIE;
    public static final Block TOAST_RABBIT_PLUSHIE;
    public static final Block SALT_RABBIT_PLUSHIE;
    public static final Block WHITE_SHEEP_PLUSHIE;
    public static final Block ORANGE_SHEEP_PLUSHIE;
    public static final Block MAGENTA_SHEEP_PLUSHIE;
    public static final Block LIGHT_BLUE_SHEEP_PLUSHIE;
    public static final Block YELLOW_SHEEP_PLUSHIE;
    public static final Block LIME_SHEEP_PLUSHIE;
    public static final Block PINK_SHEEP_PLUSHIE;
    public static final Block GRAY_SHEEP_PLUSHIE;
    public static final Block LIGHT_GRAY_SHEEP_PLUSHIE;
    public static final Block CYAN_SHEEP_PLUSHIE;
    public static final Block PURPLE_SHEEP_PLUSHIE;
    public static final Block BLUE_SHEEP_PLUSHIE;
    public static final Block BROWN_SHEEP_PLUSHIE;
    public static final Block GREEN_SHEEP_PLUSHIE;
    public static final Block RED_SHEEP_PLUSHIE;
    public static final Block BLACK_SHEEP_PLUSHIE;
    public static final Block MAROON_SHEEP_PLUSHIE;
    public static final Block SKELETON_PLUSHIE;
    public static final Block SLIME_PLUSHIE;
    public static final Block SPIDER_PLUSHIE;
    public static final Block SQUID_PLUSHIE;
    public static final Block GLOW_SQUID_PLUSHIE;
    public static final Block BEE_PLUSHIE;
    public static final Block PLAINS_VILLAGER_PLUSHIE;
    public static final Block DESERT_VILLAGER_PLUSHIE;
    public static final Block JUNGLE_VILLAGER_PLUSHIE;
    public static final Block SAVANNA_VILLAGER_PLUSHIE;
    public static final Block SNOW_VILLAGER_PLUSHIE;
    public static final Block SWAMP_VILLAGER_PLUSHIE;
    public static final Block TAIGA_VILLAGER_PLUSHIE;
    public static final Block CRIMSON_VILLAGER_PLUSHIE;
    public static final Block WARPED_VILLAGER_PLUSHIE;
    public static final Block WANDERING_TRADER_PLUSHIE;
    public static final Block PLAINS_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block DESERT_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block JUNGLE_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block SAVANNA_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block SNOW_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block SWAMP_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block TAIGA_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block CRIMSON_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block WARPED_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Block WITCH_PLUSHIE;
    public static final Block PALE_WOLF_PLUSHIE;
    public static final Block ZOMBIE_PLUSHIE;
    public static final Block PIGLIN_PLUSHIE;
    public static final Block ZOMBIFIED_PIGLIN_PLUSHIE;
    public static final Block PUFFERFISH_PLUSHIE;
    public static final Block WITHER_PLUSHIE;
    public static final Block STRIDER_PLUSHIE;
    public static final Block SHIVERING_STRIDER_PLUSHIE;
    public static final Block PHANTOM_PLUSHIE;
    public static final Block HOGLIN_PLUSHIE;
    public static final Block ZOGLIN_PLUSHIE;
    public static final Block POLAR_BEAR_PLUSHIE;
    public static final Block ALLAY_PLUSHIE;
    public static final Block PILLAGER_PLUSHIE;
    public static final Block VINDICATOR_PLUSHIE;
    public static final Block EVOKER_PLUSHIE;
    public static final Block RAVAGER_PLUSHIE;
    public static final Block SHULKER_PLUSHIE;
    public static final Block VEX_PLUSHIE;
    public static final Block CAMEL_PLUSHIE;
    public static final Block NETHER_SMOKY_QUARTZ_ORE;
    public static final Block SMOKY_QUARTZ_BLOCK;
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK;
    public static final Block SMOKY_QUARTZ_BRICKS;
    public static final Block SMOKY_QUARTZ_BRICK_STAIRS;
    public static final Block SMOKY_QUARTZ_BRICK_SLAB;
    public static final Block SMOKY_QUARTZ_BRICK_WALL;
    public static final Block SMOKY_QUARTZ_PILLAR;
    public static final Block SMOKY_QUARTZ_STAIRS;
    public static final Block SMOKY_QUARTZ_SLAB;
    public static final Block SMOKY_QUARTZ_WALL;
    public static final Block SMOOTH_SMOKY_QUARTZ;
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS;
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB;
    public static final Block SMOOTH_SMOKY_QUARTZ_WALL;
    public static final Block CRACKED_STONE_BRICK_STAIRS;
    public static final Block CRACKED_STONE_BRICK_SLAB;
    public static final Block CRACKED_STONE_BRICK_WALL;
    public static final Block BLUEBERRY_BUSH;
    public static final Block GREEN_ONIONS;
    public static final Block OAK_PLANTER_BOX;
    public static final Block SPRUCE_PLANTER_BOX;
    public static final Block BIRCH_PLANTER_BOX;
    public static final Block JUNGLE_PLANTER_BOX;
    public static final Block ACACIA_PLANTER_BOX;
    public static final Block DARK_OAK_PLANTER_BOX;
    public static final Block MANGROVE_PLANTER_BOX;
    public static final Block CHERRY_PLANTER_BOX;
    public static final Block CRIMSON_PLANTER_BOX;
    public static final Block WARPED_PLANTER_BOX;
    public static final Block OAK_WALL;
    public static final Block SPRUCE_WALL;
    public static final Block BIRCH_WALL;
    public static final Block JUNGLE_WALL;
    public static final Block ACACIA_WALL;
    public static final Block DARK_OAK_WALL;
    public static final Block MANGROVE_WALL;
    public static final Block CRIMSON_WALL;
    public static final Block WARPED_WALL;
    public static final Block CHERRY_WALL;
    public static final Block STRIPPED_OAK_WALL;
    public static final Block STRIPPED_SPRUCE_WALL;
    public static final Block STRIPPED_BIRCH_WALL;
    public static final Block STRIPPED_JUNGLE_WALL;
    public static final Block STRIPPED_ACACIA_WALL;
    public static final Block STRIPPED_DARK_OAK_WALL;
    public static final Block STRIPPED_MANGROVE_WALL;
    public static final Block STRIPPED_CRIMSON_WALL;
    public static final Block STRIPPED_WARPED_WALL;
    public static final Block STRIPPED_CHERRY_WALL;
    public static final Block OAK_ROPE_LADDER;
    public static final Block SPRUCE_ROPE_LADDER;
    public static final Block BIRCH_ROPE_LADDER;
    public static final Block JUNGLE_ROPE_LADDER;
    public static final Block ACACIA_ROPE_LADDER;
    public static final Block DARK_OAK_ROPE_LADDER;
    public static final Block CRIMSON_ROPE_LADDER;
    public static final Block WARPED_ROPE_LADDER;
    public static final Block MANGROVE_ROPE_LADDER;
    public static final Block CHERRY_ROPE_LADDER;
    public static final Block IRON_LADDER;
    public static final Block SNOW_BRICKS;
    public static final Block SNOW_BRICK_STAIRS;
    public static final Block SNOW_BRICK_SLAB;
    public static final Block SNOW_BRICK_WALL;
    public static final Block PACKED_SNOW;
    public static final Block PACKED_SNOW_STAIRS;
    public static final Block PACKED_SNOW_SLAB;
    public static final Block PACKED_SNOW_WALL;
    public static final Block PURPLE_MUSHROOM;
    public static final Block PURPLE_MUSHROOM_BLOCK;
    public static final Block WOODCUTTER;
    public static final Block WHITE_CAMPFIRE;
    public static final Block ORANGE_CAMPFIRE;
    public static final Block MAGENTA_CAMPFIRE;
    public static final Block LIGHT_BLUE_CAMPFIRE;
    public static final Block YELLOW_CAMPFIRE;
    public static final Block LIME_CAMPFIRE;
    public static final Block PINK_CAMPFIRE;
    public static final Block GRAY_CAMPFIRE;
    public static final Block LIGHT_GRAY_CAMPFIRE;
    public static final Block CYAN_CAMPFIRE;
    public static final Block PURPLE_CAMPFIRE;
    public static final Block BLUE_CAMPFIRE;
    public static final Block BROWN_CAMPFIRE;
    public static final Block GREEN_CAMPFIRE;
    public static final Block RED_CAMPFIRE;
    public static final Block BLACK_CAMPFIRE;
    public static final Block MAROON_CAMPFIRE;
    public static final Block WHITE_LANTERN;
    public static final Block ORANGE_LANTERN;
    public static final Block MAGENTA_LANTERN;
    public static final Block LIGHT_BLUE_LANTERN;
    public static final Block YELLOW_LANTERN;
    public static final Block LIME_LANTERN;
    public static final Block PINK_LANTERN;
    public static final Block GRAY_LANTERN;
    public static final Block LIGHT_GRAY_LANTERN;
    public static final Block CYAN_LANTERN;
    public static final Block PURPLE_LANTERN;
    public static final Block BLUE_LANTERN;
    public static final Block BROWN_LANTERN;
    public static final Block GREEN_LANTERN;
    public static final Block RED_LANTERN;
    public static final Block BLACK_LANTERN;
    public static final Block MAROON_LANTERN;
    public static final Block WHITE_WALL_TORCH;
    public static final Block ORANGE_WALL_TORCH;
    public static final Block MAGENTA_WALL_TORCH;
    public static final Block LIGHT_BLUE_WALL_TORCH;
    public static final Block YELLOW_WALL_TORCH;
    public static final Block LIME_WALL_TORCH;
    public static final Block PINK_WALL_TORCH;
    public static final Block GRAY_WALL_TORCH;
    public static final Block LIGHT_GRAY_WALL_TORCH;
    public static final Block CYAN_WALL_TORCH;
    public static final Block PURPLE_WALL_TORCH;
    public static final Block BLUE_WALL_TORCH;
    public static final Block BROWN_WALL_TORCH;
    public static final Block GREEN_WALL_TORCH;
    public static final Block RED_WALL_TORCH;
    public static final Block BLACK_WALL_TORCH;
    public static final Block MAROON_WALL_TORCH;
    public static final Block WHITE_TORCH;
    public static final Block ORANGE_TORCH;
    public static final Block MAGENTA_TORCH;
    public static final Block LIGHT_BLUE_TORCH;
    public static final Block YELLOW_TORCH;
    public static final Block LIME_TORCH;
    public static final Block PINK_TORCH;
    public static final Block GRAY_TORCH;
    public static final Block LIGHT_GRAY_TORCH;
    public static final Block CYAN_TORCH;
    public static final Block PURPLE_TORCH;
    public static final Block BLUE_TORCH;
    public static final Block BROWN_TORCH;
    public static final Block GREEN_TORCH;
    public static final Block RED_TORCH;
    public static final Block BLACK_TORCH;
    public static final Block MAROON_TORCH;
    public static final Block WITCHS_CRADLE;
    public static final Block BAUXITE;
    public static final Block BAUXITE_SLAB;
    public static final Block BAUXITE_STAIRS;
    public static final Block BAUXITE_WALL;
    public static final Block BAUXITE_BRICKS;
    public static final Block BAUXITE_BRICK_STAIRS;
    public static final Block BAUXITE_BRICK_SLAB;
    public static final Block BAUXITE_BRICK_WALL;
    public static final Block MOSSY_BAUXITE_BRICKS;
    public static final Block MOSSY_BAUXITE_BRICK_STAIRS;
    public static final Block MOSSY_BAUXITE_BRICK_SLAB;
    public static final Block MOSSY_BAUXITE_BRICK_WALL;
    public static final Block CRACKED_BAUXITE_BRICKS;
    public static final Block CRACKED_BAUXITE_BRICK_STAIRS;
    public static final Block CRACKED_BAUXITE_BRICK_SLAB;
    public static final Block CRACKED_BAUXITE_BRICK_WALL;
    public static final Block TWISTED_NETHER_BRICKS;
    public static final Block TWISTED_NETHER_BRICK_STAIRS;
    public static final Block TWISTED_NETHER_BRICK_SLAB;
    public static final Block TWISTED_NETHER_BRICK_WALL;
    public static final Block TWISTED_NETHERRACK;
    public static final Block TWISTED_NETHERRACK_STAIRS;
    public static final Block TWISTED_NETHERRACK_SLAB;
    public static final Block TWISTED_NETHERRACK_WALL;
    public static final Block WEEPING_NETHER_BRICKS;
    public static final Block WEEPING_NETHER_BRICK_STAIRS;
    public static final Block WEEPING_NETHER_BRICK_SLAB;
    public static final Block WEEPING_NETHER_BRICK_WALL;
    public static final Block WEEPING_NETHERRACK;
    public static final Block WEEPING_NETHERRACK_STAIRS;
    public static final Block WEEPING_NETHERRACK_SLAB;
    public static final Block WEEPING_NETHERRACK_WALL;
    public static final Block SNAPDRAGON;
    public static final Block POTTED_SNAPDRAGON;
    public static final Block POTTED_PURPLE_MUSHROOM;
    public static final Block SHORT_ENDER_GRASS;
    public static final Block CATTAIL;
    public static final Block CHOCOLATE_CAKE;
    public static final Block RED_VELVET_CAKE;
    public static final Block STONE_TILES;
    public static final Block STONE_TILE_SLAB;
    public static final Block STONE_TILE_STAIRS;
    public static final Block STONE_TILE_WALL;
    public static final Block MOSSY_STONE_TILES;
    public static final Block MOSSY_STONE_TILE_SLAB;
    public static final Block MOSSY_STONE_TILE_STAIRS;
    public static final Block MOSSY_STONE_TILE_WALL;
    public static final Block CRACKED_STONE_TILES;
    public static final Block CRACKED_STONE_TILE_SLAB;
    public static final Block CRACKED_STONE_TILE_STAIRS;
    public static final Block CRACKED_STONE_TILE_WALL;
    public static final Block SWEET_BERRY_PIE;
    public static final Block BLUEBERRY_PIE;
    public static final Block BLACKSTONE_TILES;
    public static final Block BLACKSTONE_TILE_STAIRS;
    public static final Block BLACKSTONE_TILE_SLAB;
    public static final Block BLACKSTONE_TILE_WALL;
    public static final Block TWISTED_BLACKSTONE_TILES;
    public static final Block TWISTED_BLACKSTONE_TILE_STAIRS;
    public static final Block TWISTED_BLACKSTONE_TILE_SLAB;
    public static final Block TWISTED_BLACKSTONE_TILE_WALL;
    public static final Block WEEPING_BLACKSTONE_TILES;
    public static final Block WEEPING_BLACKSTONE_TILE_STAIRS;
    public static final Block WEEPING_BLACKSTONE_TILE_SLAB;
    public static final Block WEEPING_BLACKSTONE_TILE_WALL;
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICKS;
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS;
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB;
    public static final Block TWISTED_POLISHED_BLACKSTONE_BRICK_WALL;
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICKS;
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS;
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB;
    public static final Block WEEPING_POLISHED_BLACKSTONE_BRICK_WALL;
    public static final Block TWISTED_BLACKSTONE;
    public static final Block TWISTED_BLACKSTONE_STAIRS;
    public static final Block TWISTED_BLACKSTONE_SLAB;
    public static final Block TWISTED_BLACKSTONE_WALL;
    public static final Block WEEPING_BLACKSTONE;
    public static final Block WEEPING_BLACKSTONE_STAIRS;
    public static final Block WEEPING_BLACKSTONE_SLAB;
    public static final Block WEEPING_BLACKSTONE_WALL;
    public static final Block QUARTZ_TILES;
    public static final Block QUARTZ_TILE_STAIRS;
    public static final Block QUARTZ_TILE_SLAB;
    public static final Block QUARTZ_TILE_WALL;
    public static final Block CALCITE_BRICKS;
    public static final Block CALCITE_BRICK_STAIRS;
    public static final Block CALCITE_BRICK_SLAB;
    public static final Block CALCITE_BRICK_WALL;
    public static final Block MOSSY_CALCITE_BRICKS;
    public static final Block MOSSY_CALCITE_BRICK_STAIRS;
    public static final Block MOSSY_CALCITE_BRICK_SLAB;
    public static final Block MOSSY_CALCITE_BRICK_WALL;
    public static final Block CRACKED_CALCITE_BRICKS;
    public static final Block CRACKED_CALCITE_BRICK_STAIRS;
    public static final Block CRACKED_CALCITE_BRICK_SLAB;
    public static final Block CRACKED_CALCITE_BRICK_WALL;
    public static final Block CHISELED_CALCITE_BRICKS;
    public static final Block DRIPSTONE_BRICKS;
    public static final Block DRIPSTONE_BRICK_STAIRS;
    public static final Block DRIPSTONE_BRICK_SLAB;
    public static final Block DRIPSTONE_BRICK_WALL;
    public static final Block MOSSY_DRIPSTONE_BRICKS;
    public static final Block MOSSY_DRIPSTONE_BRICK_STAIRS;
    public static final Block MOSSY_DRIPSTONE_BRICK_SLAB;
    public static final Block MOSSY_DRIPSTONE_BRICK_WALL;
    public static final Block CRACKED_DRIPSTONE_BRICKS;
    public static final Block CRACKED_DRIPSTONE_BRICK_STAIRS;
    public static final Block CRACKED_DRIPSTONE_BRICK_SLAB;
    public static final Block CRACKED_DRIPSTONE_BRICK_WALL;
    public static final Block CHISELED_DRIPSTONE_BRICKS;
    public static final Block BLOOD_KELP;
    public static final Block BLOOD_KELP_PLANT;
    public static final Block DRIED_BLOOD_KELP_BLOCK;
    public static final Block BLOOD_KELP_LANTERN;
    public static final Block MAROON_WOOL;
    public static final Block MAROON_STAINED_GLASS;
    public static final Block MAROON_STAINED_GLASS_PANE;
    public static final Block MAROON_CANDLE;
    public static final Block MAROON_CONCRETE;
    public static final Block MAROON_CONCRETE_POWDER;
    public static final Block MAROON_CANDLE_CAKE;
    public static final Block BOG_BLOSSOM;
    public static final Block MAROON_CANDLE_CHOCOLATE_CAKE;
    public static final Block CANDLE_CHOCOLATE_CAKE;
    public static final Block WHITE_CANDLE_CHOCOLATE_CAKE;
    public static final Block ORANGE_CANDLE_CHOCOLATE_CAKE;
    public static final Block MAGENTA_CANDLE_CHOCOLATE_CAKE;
    public static final Block LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE;
    public static final Block YELLOW_CANDLE_CHOCOLATE_CAKE;
    public static final Block LIME_CANDLE_CHOCOLATE_CAKE;
    public static final Block PINK_CANDLE_CHOCOLATE_CAKE;
    public static final Block GRAY_CANDLE_CHOCOLATE_CAKE;
    public static final Block LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE;
    public static final Block CYAN_CANDLE_CHOCOLATE_CAKE;
    public static final Block PURPLE_CANDLE_CHOCOLATE_CAKE;
    public static final Block BLUE_CANDLE_CHOCOLATE_CAKE;
    public static final Block BROWN_CANDLE_CHOCOLATE_CAKE;
    public static final Block GREEN_CANDLE_CHOCOLATE_CAKE;
    public static final Block RED_CANDLE_CHOCOLATE_CAKE;
    public static final Block BLACK_CANDLE_CHOCOLATE_CAKE;
    public static final Block MAROON_CANDLE_RED_VELVET_CAKE;
    public static final Block CANDLE_RED_VELVET_CAKE;
    public static final Block WHITE_CANDLE_RED_VELVET_CAKE;
    public static final Block ORANGE_CANDLE_RED_VELVET_CAKE;
    public static final Block MAGENTA_CANDLE_RED_VELVET_CAKE;
    public static final Block LIGHT_BLUE_CANDLE_RED_VELVET_CAKE;
    public static final Block YELLOW_CANDLE_RED_VELVET_CAKE;
    public static final Block LIME_CANDLE_RED_VELVET_CAKE;
    public static final Block PINK_CANDLE_RED_VELVET_CAKE;
    public static final Block GRAY_CANDLE_RED_VELVET_CAKE;
    public static final Block LIGHT_GRAY_CANDLE_RED_VELVET_CAKE;
    public static final Block CYAN_CANDLE_RED_VELVET_CAKE;
    public static final Block PURPLE_CANDLE_RED_VELVET_CAKE;
    public static final Block BLUE_CANDLE_RED_VELVET_CAKE;
    public static final Block BROWN_CANDLE_RED_VELVET_CAKE;
    public static final Block GREEN_CANDLE_RED_VELVET_CAKE;
    public static final Block RED_CANDLE_RED_VELVET_CAKE;
    public static final Block BLACK_CANDLE_RED_VELVET_CAKE;
    public static final Block CINDERSNAP_BERRY_BUSH;
    public static final Block FROSTBITE_BERRY_BUSH;
    public static final Block POLISHED_DRIPSTONE;
    public static final Block POLISHED_DRIPSTONE_STAIRS;
    public static final Block POLISHED_DRIPSTONE_SLAB;
    public static final Block POLISHED_DRIPSTONE_WALL;
    public static final Block POLISHED_CALCITE;
    public static final Block POLISHED_CALCITE_STAIRS;
    public static final Block POLISHED_CALCITE_SLAB;
    public static final Block POLISHED_CALCITE_WALL;
    public static final Block DRIPSTONE_STAIRS;
    public static final Block DRIPSTONE_SLAB;
    public static final Block DRIPSTONE_WALL;
    public static final Block CALCITE_STAIRS;
    public static final Block CALCITE_SLAB;
    public static final Block CALCITE_WALL;
    public static final Block BAMBOO_PLANTER_BOX;
    public static final Block POTTED_CATTAIL;
    public static final Block STONE_WALL;
    public static final Block QUARTZ_WALL;
    public static final Block SMOOTH_QUARTZ_WALL;
    public static final Block GRASS_SLAB;
    public static final Block PODZOL_SLAB;
    public static final Block MYCELIUM_SLAB;
    public static final Block DIRT_PATH_SLAB;
    public static final Block DIRT_SLAB;
    public static final Block COARSE_DIRT_SLAB;
    public static final Block ROOTED_DIRT_SLAB;
    public static final Block WILD_GREEN_ONIONS;

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

    private static RopeLadderBlock ropeLadderBlock() {
        return new RopeLadderBlock(AbstractBlock.Settings.copy(Blocks.LADDER));
    }

    private static PlanterBoxBlock planterBoxBlock(MapColor color, BlockSoundGroup soundGroup) {
        return new PlanterBoxBlock(AbstractBlock.Settings.create().mapColor(color).strength(2.5F)
                .sounds(soundGroup).burnable());
    }

    private static PlanterBoxBlock netherPlanterBoxBlock(MapColor color) {
        return new PlanterBoxBlock(AbstractBlock.Settings.create().mapColor(color).strength(2.5F)
                .sounds(BlockSoundGroup.NETHER_WOOD));
    }

    private static DyedCampfireBlock dyedCampfireBlock(ParticleEffect emberParticle) {
        return new DyedCampfireBlock(AbstractBlock.Settings.copy(Blocks.CAMPFIRE), emberParticle);
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
        register("bat_plushie", ModBlocks.BAT_PLUSHIE);
        register("blaze_plushie", ModBlocks.BLAZE_PLUSHIE);
        register("cave_spider_plushie", ModBlocks.CAVE_SPIDER_PLUSHIE);
        register("chicken_plushie", ModBlocks.CHICKEN_PLUSHIE);
        register("cow_plushie", ModBlocks.COW_PLUSHIE);
        register("creeper_plushie", ModBlocks.CREEPER_PLUSHIE);
        register("enderman_plushie", ModBlocks.ENDERMAN_PLUSHIE);
        register("ghast_plushie", ModBlocks.GHAST_PLUSHIE);
        register("guardian_plushie", ModBlocks.GUARDIAN_PLUSHIE);
        register("white_horse_plushie", ModBlocks.WHITE_HORSE_PLUSHIE);
        register("gray_horse_plushie", ModBlocks.GRAY_HORSE_PLUSHIE);
        register("light_gray_horse_plushie", ModBlocks.LIGHT_GRAY_HORSE_PLUSHIE);
        register("brown_horse_plushie", ModBlocks.BROWN_HORSE_PLUSHIE);
        register("black_horse_plushie", ModBlocks.BLACK_HORSE_PLUSHIE);
        register("magma_cube_plushie", ModBlocks.MAGMA_CUBE_PLUSHIE);
        register("red_mooshroom_plushie", ModBlocks.RED_MOOSHROOM_PLUSHIE);
        register("brown_mooshroom_plushie", ModBlocks.BROWN_MOOSHROOM_PLUSHIE);
        register("ocelot_plushie", ModBlocks.OCELOT_PLUSHIE);
        register("tabby_cat_plushie", ModBlocks.TABBY_CAT_PLUSHIE);
        register("tuxedo_cat_plushie", ModBlocks.TUXEDO_CAT_PLUSHIE);
        register("red_cat_plushie", ModBlocks.RED_CAT_PLUSHIE);
        register("siamese_cat_plushie", ModBlocks.SIAMESE_CAT_PLUSHIE);
        register("british_shorthair_cat_plushie", ModBlocks.BRITISH_SHORTHAIR_CAT_PLUSHIE);
        register("calico_cat_plushie", ModBlocks.CALICO_CAT_PLUSHIE);
        register("persian_cat_plushie", ModBlocks.PERSIAN_CAT_PLUSHIE);
        register("ragdoll_cat_plushie", ModBlocks.RAGDOLL_CAT_PLUSHIE);
        register("white_cat_plushie", ModBlocks.WHITE_CAT_PLUSHIE);
        register("jellie_cat_plushie", ModBlocks.JELLIE_CAT_PLUSHIE);
        register("black_cat_plushie", ModBlocks.BLACK_CAT_PLUSHIE);
        register("pig_plushie", ModBlocks.PIG_PLUSHIE);
        register("brown_rabbit_plushie", ModBlocks.BROWN_RABBIT_PLUSHIE);
        register("white_rabbit_plushie", ModBlocks.WHITE_RABBIT_PLUSHIE);
        register("black_rabbit_plushie", ModBlocks.BLACK_RABBIT_PLUSHIE);
        register("white_splotched_rabbit_plushie", ModBlocks.WHITE_SPLOTCHED_RABBIT_PLUSHIE);
        register("gold_rabbit_plushie", ModBlocks.GOLD_RABBIT_PLUSHIE);
        register("toast_rabbit_plushie", ModBlocks.TOAST_RABBIT_PLUSHIE);
        register("salt_rabbit_plushie", ModBlocks.SALT_RABBIT_PLUSHIE);
        register("white_sheep_plushie", ModBlocks.WHITE_SHEEP_PLUSHIE);
        register("orange_sheep_plushie", ModBlocks.ORANGE_SHEEP_PLUSHIE);
        register("magenta_sheep_plushie", ModBlocks.MAGENTA_SHEEP_PLUSHIE);
        register("light_blue_sheep_plushie", ModBlocks.LIGHT_BLUE_SHEEP_PLUSHIE);
        register("yellow_sheep_plushie", ModBlocks.YELLOW_SHEEP_PLUSHIE);
        register("lime_sheep_plushie", ModBlocks.LIME_SHEEP_PLUSHIE);
        register("pink_sheep_plushie", ModBlocks.PINK_SHEEP_PLUSHIE);
        register("gray_sheep_plushie", ModBlocks.GRAY_SHEEP_PLUSHIE);
        register("light_gray_sheep_plushie", ModBlocks.LIGHT_GRAY_SHEEP_PLUSHIE);
        register("cyan_sheep_plushie", ModBlocks.CYAN_SHEEP_PLUSHIE);
        register("purple_sheep_plushie", ModBlocks.PURPLE_SHEEP_PLUSHIE);
        register("blue_sheep_plushie", ModBlocks.BLUE_SHEEP_PLUSHIE);
        register("brown_sheep_plushie", ModBlocks.BROWN_SHEEP_PLUSHIE);
        register("green_sheep_plushie", ModBlocks.GREEN_SHEEP_PLUSHIE);
        register("red_sheep_plushie", ModBlocks.RED_SHEEP_PLUSHIE);
        register("black_sheep_plushie", ModBlocks.BLACK_SHEEP_PLUSHIE);
        register("maroon_sheep_plushie", ModBlocks.MAROON_SHEEP_PLUSHIE);
        register("skeleton_plushie", ModBlocks.SKELETON_PLUSHIE);
        register("slime_plushie", ModBlocks.SLIME_PLUSHIE);
        register("spider_plushie", ModBlocks.SPIDER_PLUSHIE);
        register("squid_plushie", ModBlocks.SQUID_PLUSHIE);
        register("glow_squid_plushie", ModBlocks.GLOW_SQUID_PLUSHIE);
        register("bee_plushie", ModBlocks.BEE_PLUSHIE);
        register("plains_villager_plushie", ModBlocks.PLAINS_VILLAGER_PLUSHIE);
        register("desert_villager_plushie", ModBlocks.DESERT_VILLAGER_PLUSHIE);
        register("jungle_villager_plushie", ModBlocks.JUNGLE_VILLAGER_PLUSHIE);
        register("savanna_villager_plushie", ModBlocks.SAVANNA_VILLAGER_PLUSHIE);
        register("snow_villager_plushie", ModBlocks.SNOW_VILLAGER_PLUSHIE);
        register("swamp_villager_plushie", ModBlocks.SWAMP_VILLAGER_PLUSHIE);
        register("taiga_villager_plushie", ModBlocks.TAIGA_VILLAGER_PLUSHIE);
        register("crimson_villager_plushie", ModBlocks.CRIMSON_VILLAGER_PLUSHIE);
        register("warped_villager_plushie", ModBlocks.WARPED_VILLAGER_PLUSHIE);
        register("wandering_trader_plushie", ModBlocks.WANDERING_TRADER_PLUSHIE);
        register("plains_zombie_villager_plushie", ModBlocks.PLAINS_ZOMBIE_VILLAGER_PLUSHIE);
        register("desert_zombie_villager_plushie", ModBlocks.DESERT_ZOMBIE_VILLAGER_PLUSHIE);
        register("jungle_zombie_villager_plushie", ModBlocks.JUNGLE_ZOMBIE_VILLAGER_PLUSHIE);
        register("savanna_zombie_villager_plushie", ModBlocks.SAVANNA_ZOMBIE_VILLAGER_PLUSHIE);
        register("snow_zombie_villager_plushie", ModBlocks.SNOW_ZOMBIE_VILLAGER_PLUSHIE);
        register("swamp_zombie_villager_plushie", ModBlocks.SWAMP_ZOMBIE_VILLAGER_PLUSHIE);
        register("taiga_zombie_villager_plushie", ModBlocks.TAIGA_ZOMBIE_VILLAGER_PLUSHIE);
        register("crimson_zombie_villager_plushie", ModBlocks.CRIMSON_ZOMBIE_VILLAGER_PLUSHIE);
        register("warped_zombie_villager_plushie", ModBlocks.WARPED_ZOMBIE_VILLAGER_PLUSHIE);
        register("witch_plushie", ModBlocks.WITCH_PLUSHIE);
        register("pale_wolf_plushie", ModBlocks.PALE_WOLF_PLUSHIE);
        register("zombie_plushie", ModBlocks.ZOMBIE_PLUSHIE);
        register("piglin_plushie", ModBlocks.PIGLIN_PLUSHIE);
        register("zombified_piglin_plushie", ModBlocks.ZOMBIFIED_PIGLIN_PLUSHIE);
        register("pufferfish_plushie", ModBlocks.PUFFERFISH_PLUSHIE);
        register("wither_plushie", ModBlocks.WITHER_PLUSHIE);
        register("strider_plushie", ModBlocks.STRIDER_PLUSHIE);
        register("shivering_strider_plushie", ModBlocks.SHIVERING_STRIDER_PLUSHIE);
        register("phantom_plushie", ModBlocks.PHANTOM_PLUSHIE);
        register("hoglin_plushie", ModBlocks.HOGLIN_PLUSHIE);
        register("zoglin_plushie", ModBlocks.ZOGLIN_PLUSHIE);
        register("polar_bear_plushie", ModBlocks.POLAR_BEAR_PLUSHIE);
        register("allay_plushie", ModBlocks.ALLAY_PLUSHIE);
        register("pillager_plushie", ModBlocks.PILLAGER_PLUSHIE);
        register("vindicator_plushie", ModBlocks.VINDICATOR_PLUSHIE);
        register("evoker_plushie", ModBlocks.EVOKER_PLUSHIE);
        register("ravager_plushie", ModBlocks.RAVAGER_PLUSHIE);
        register("shulker_plushie", ModBlocks.SHULKER_PLUSHIE);
        register("vex_plushie", ModBlocks.VEX_PLUSHIE);
        register("nether_smoky_quartz_ore", ModBlocks.NETHER_SMOKY_QUARTZ_ORE);
        register("smoky_quartz_block", ModBlocks.SMOKY_QUARTZ_BLOCK);
        register("chiseled_smoky_quartz_block", ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        register("smoky_quartz_bricks", ModBlocks.SMOKY_QUARTZ_BRICKS);
        register("smoky_quartz_brick_stairs", ModBlocks.SMOKY_QUARTZ_BRICK_STAIRS);
        register("smoky_quartz_brick_slab", ModBlocks.SMOKY_QUARTZ_BRICK_SLAB);
        register("smoky_quartz_brick_wall", ModBlocks.SMOKY_QUARTZ_BRICK_WALL);
        register("smoky_quartz_pillar", ModBlocks.SMOKY_QUARTZ_PILLAR);
        register("smoky_quartz_stairs", ModBlocks.SMOKY_QUARTZ_STAIRS);
        register("smoky_quartz_slab", ModBlocks.SMOKY_QUARTZ_SLAB);
        register("smoky_quartz_wall", ModBlocks.SMOKY_QUARTZ_WALL);
        register("smooth_smoky_quartz", ModBlocks.SMOOTH_SMOKY_QUARTZ);
        register("smooth_smoky_quartz_stairs", ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
        register("smooth_smoky_quartz_slab", ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB);
        register("smooth_smoky_quartz_wall", ModBlocks.SMOOTH_SMOKY_QUARTZ_WALL);
        register("cracked_stone_brick_stairs", ModBlocks.CRACKED_STONE_BRICK_STAIRS);
        register("cracked_stone_brick_slab", ModBlocks.CRACKED_STONE_BRICK_SLAB);
        register("cracked_stone_brick_wall", ModBlocks.CRACKED_STONE_BRICK_WALL);
        register("blueberry_bush", ModBlocks.BLUEBERRY_BUSH);
        register("green_onions", ModBlocks.GREEN_ONIONS);
        register("oak_planter_box", ModBlocks.OAK_PLANTER_BOX);
        register("spruce_planter_box", ModBlocks.SPRUCE_PLANTER_BOX);
        register("birch_planter_box", ModBlocks.BIRCH_PLANTER_BOX);
        register("jungle_planter_box", ModBlocks.JUNGLE_PLANTER_BOX);
        register("acacia_planter_box", ModBlocks.ACACIA_PLANTER_BOX);
        register("dark_oak_planter_box", ModBlocks.DARK_OAK_PLANTER_BOX);
        register("mangrove_planter_box", ModBlocks.MANGROVE_PLANTER_BOX);
        register("cherry_planter_box", ModBlocks.CHERRY_PLANTER_BOX);
        register("crimson_planter_box", ModBlocks.CRIMSON_PLANTER_BOX);
        register("warped_planter_box", ModBlocks.WARPED_PLANTER_BOX);
        register("oak_wall", ModBlocks.OAK_WALL);
        register("spruce_wall", ModBlocks.SPRUCE_WALL);
        register("birch_wall", ModBlocks.BIRCH_WALL);
        register("jungle_wall", ModBlocks.JUNGLE_WALL);
        register("acacia_wall", ModBlocks.ACACIA_WALL);
        register("dark_oak_wall", ModBlocks.DARK_OAK_WALL);
        register("mangrove_wall", ModBlocks.MANGROVE_WALL);
        register("crimson_wall", ModBlocks.CRIMSON_WALL);
        register("warped_wall", ModBlocks.WARPED_WALL);
        register("cherry_wall", ModBlocks.CHERRY_WALL);
        register("stripped_oak_wall", ModBlocks.STRIPPED_OAK_WALL);
        register("stripped_spruce_wall", ModBlocks.STRIPPED_SPRUCE_WALL);
        register("stripped_birch_wall", ModBlocks.STRIPPED_BIRCH_WALL);
        register("stripped_jungle_wall", ModBlocks.STRIPPED_JUNGLE_WALL);
        register("stripped_acacia_wall", ModBlocks.STRIPPED_ACACIA_WALL);
        register("stripped_dark_oak_wall", ModBlocks.STRIPPED_DARK_OAK_WALL);
        register("stripped_mangrove_wall", ModBlocks.STRIPPED_MANGROVE_WALL);
        register("stripped_crimson_wall", ModBlocks.STRIPPED_CRIMSON_WALL);
        register("stripped_warped_wall", ModBlocks.STRIPPED_WARPED_WALL);
        register("stripped_cherry_wall", ModBlocks.STRIPPED_CHERRY_WALL);
        register("oak_rope_ladder", ModBlocks.OAK_ROPE_LADDER);
        register("spruce_rope_ladder", ModBlocks.SPRUCE_ROPE_LADDER);
        register("birch_rope_ladder", ModBlocks.BIRCH_ROPE_LADDER);
        register("jungle_rope_ladder", ModBlocks.JUNGLE_ROPE_LADDER);
        register("acacia_rope_ladder", ModBlocks.ACACIA_ROPE_LADDER);
        register("dark_oak_rope_ladder", ModBlocks.DARK_OAK_ROPE_LADDER);
        register("crimson_rope_ladder", ModBlocks.CRIMSON_ROPE_LADDER);
        register("warped_rope_ladder", ModBlocks.WARPED_ROPE_LADDER);
        register("mangrove_rope_ladder", ModBlocks.MANGROVE_ROPE_LADDER);
        register("cherry_rope_ladder", ModBlocks.CHERRY_ROPE_LADDER);
        register("iron_ladder", ModBlocks.IRON_LADDER);
        register("snow_bricks", ModBlocks.SNOW_BRICKS);
        register("snow_brick_stairs", ModBlocks.SNOW_BRICK_STAIRS);
        register("snow_brick_slab", ModBlocks.SNOW_BRICK_SLAB);
        register("snow_brick_wall", ModBlocks.SNOW_BRICK_WALL);
        register("packed_snow", ModBlocks.PACKED_SNOW);
        register("packed_snow_stairs", ModBlocks.PACKED_SNOW_STAIRS);
        register("packed_snow_slab", ModBlocks.PACKED_SNOW_SLAB);
        register("packed_snow_wall", ModBlocks.PACKED_SNOW_WALL);
        register("purple_mushroom", ModBlocks.PURPLE_MUSHROOM);
        register("purple_mushroom_block", ModBlocks.PURPLE_MUSHROOM_BLOCK);
        register("woodcutter", ModBlocks.WOODCUTTER);
        register("white_campfire", ModBlocks.WHITE_CAMPFIRE);
        register("orange_campfire", ModBlocks.ORANGE_CAMPFIRE);
        register("magenta_campfire", ModBlocks.MAGENTA_CAMPFIRE);
        register("light_blue_campfire", ModBlocks.LIGHT_BLUE_CAMPFIRE);
        register("yellow_campfire", ModBlocks.YELLOW_CAMPFIRE);
        register("lime_campfire", ModBlocks.LIME_CAMPFIRE);
        register("pink_campfire", ModBlocks.PINK_CAMPFIRE);
        register("gray_campfire", ModBlocks.GRAY_CAMPFIRE);
        register("light_gray_campfire", ModBlocks.LIGHT_GRAY_CAMPFIRE);
        register("cyan_campfire", ModBlocks.CYAN_CAMPFIRE);
        register("purple_campfire", ModBlocks.PURPLE_CAMPFIRE);
        register("blue_campfire", ModBlocks.BLUE_CAMPFIRE);
        register("brown_campfire", ModBlocks.BROWN_CAMPFIRE);
        register("green_campfire", ModBlocks.GREEN_CAMPFIRE);
        register("red_campfire", ModBlocks.RED_CAMPFIRE);
        register("black_campfire", ModBlocks.BLACK_CAMPFIRE);
        register("maroon_campfire", ModBlocks.MAROON_CAMPFIRE);
        register("white_lantern", ModBlocks.WHITE_LANTERN);
        register("orange_lantern", ModBlocks.ORANGE_LANTERN);
        register("magenta_lantern", ModBlocks.MAGENTA_LANTERN);
        register("light_blue_lantern", ModBlocks.LIGHT_BLUE_LANTERN);
        register("yellow_lantern", ModBlocks.YELLOW_LANTERN);
        register("lime_lantern", ModBlocks.LIME_LANTERN);
        register("pink_lantern", ModBlocks.PINK_LANTERN);
        register("gray_lantern", ModBlocks.GRAY_LANTERN);
        register("light_gray_lantern", ModBlocks.LIGHT_GRAY_LANTERN);
        register("cyan_lantern", ModBlocks.CYAN_LANTERN);
        register("purple_lantern", ModBlocks.PURPLE_LANTERN);
        register("blue_lantern", ModBlocks.BLUE_LANTERN);
        register("brown_lantern", ModBlocks.BROWN_LANTERN);
        register("green_lantern", ModBlocks.GREEN_LANTERN);
        register("red_lantern", ModBlocks.RED_LANTERN);
        register("black_lantern", ModBlocks.BLACK_LANTERN);
        register("maroon_lantern", ModBlocks.MAROON_LANTERN);
        register("white_wall_torch", ModBlocks.WHITE_WALL_TORCH);
        register("orange_wall_torch", ModBlocks.ORANGE_WALL_TORCH);
        register("magenta_wall_torch", ModBlocks.MAGENTA_WALL_TORCH);
        register("light_blue_wall_torch", ModBlocks.LIGHT_BLUE_WALL_TORCH);
        register("yellow_wall_torch", ModBlocks.YELLOW_WALL_TORCH);
        register("lime_wall_torch", ModBlocks.LIME_WALL_TORCH);
        register("pink_wall_torch", ModBlocks.PINK_WALL_TORCH);
        register("gray_wall_torch", ModBlocks.GRAY_WALL_TORCH);
        register("light_gray_wall_torch", ModBlocks.LIGHT_GRAY_WALL_TORCH);
        register("cyan_wall_torch", ModBlocks.CYAN_WALL_TORCH);
        register("purple_wall_torch", ModBlocks.PURPLE_WALL_TORCH);
        register("blue_wall_torch", ModBlocks.BLUE_WALL_TORCH);
        register("brown_wall_torch", ModBlocks.BROWN_WALL_TORCH);
        register("green_wall_torch", ModBlocks.GREEN_WALL_TORCH);
        register("red_wall_torch", ModBlocks.RED_WALL_TORCH);
        register("black_wall_torch", ModBlocks.BLACK_WALL_TORCH);
        register("maroon_wall_torch", ModBlocks.MAROON_WALL_TORCH);
        register("white_torch", ModBlocks.WHITE_TORCH);
        register("orange_torch", ModBlocks.ORANGE_TORCH);
        register("magenta_torch", ModBlocks.MAGENTA_TORCH);
        register("light_blue_torch", ModBlocks.LIGHT_BLUE_TORCH);
        register("yellow_torch", ModBlocks.YELLOW_TORCH);
        register("lime_torch", ModBlocks.LIME_TORCH);
        register("pink_torch", ModBlocks.PINK_TORCH);
        register("gray_torch", ModBlocks.GRAY_TORCH);
        register("light_gray_torch", ModBlocks.LIGHT_GRAY_TORCH);
        register("cyan_torch", ModBlocks.CYAN_TORCH);
        register("purple_torch", ModBlocks.PURPLE_TORCH);
        register("blue_torch", ModBlocks.BLUE_TORCH);
        register("brown_torch", ModBlocks.BROWN_TORCH);
        register("green_torch", ModBlocks.GREEN_TORCH);
        register("red_torch", ModBlocks.RED_TORCH);
        register("black_torch", ModBlocks.BLACK_TORCH);
        register("maroon_torch", ModBlocks.MAROON_TORCH);
        register("witchs_cradle", ModBlocks.WITCHS_CRADLE);
        register("bauxite", ModBlocks.BAUXITE);
        register("bauxite_slab", ModBlocks.BAUXITE_SLAB);
        register("bauxite_stairs", ModBlocks.BAUXITE_STAIRS);
        register("bauxite_wall", ModBlocks.BAUXITE_WALL);
        register("bauxite_bricks", ModBlocks.BAUXITE_BRICKS);
        register("bauxite_brick_stairs", ModBlocks.BAUXITE_BRICK_STAIRS);
        register("bauxite_brick_slab", ModBlocks.BAUXITE_BRICK_SLAB);
        register("bauxite_brick_wall", ModBlocks.BAUXITE_BRICK_WALL);
        register("mossy_bauxite_bricks", ModBlocks.MOSSY_BAUXITE_BRICKS);
        register("mossy_bauxite_brick_stairs", ModBlocks.MOSSY_BAUXITE_BRICK_STAIRS);
        register("mossy_bauxite_brick_slab", ModBlocks.MOSSY_BAUXITE_BRICK_SLAB);
        register("mossy_bauxite_brick_wall", ModBlocks.MOSSY_BAUXITE_BRICK_WALL);
        register("cracked_bauxite_bricks", ModBlocks.CRACKED_BAUXITE_BRICKS);
        register("cracked_bauxite_brick_stairs", ModBlocks.CRACKED_BAUXITE_BRICK_STAIRS);
        register("cracked_bauxite_brick_slab", ModBlocks.CRACKED_BAUXITE_BRICK_SLAB);
        register("cracked_bauxite_brick_wall", ModBlocks.CRACKED_BAUXITE_BRICK_WALL);
        register("twisted_nether_bricks", ModBlocks.TWISTED_NETHER_BRICKS);
        register("twisted_nether_brick_stairs", ModBlocks.TWISTED_NETHER_BRICK_STAIRS);
        register("twisted_nether_brick_slab", ModBlocks.TWISTED_NETHER_BRICK_SLAB);
        register("twisted_nether_brick_wall", ModBlocks.TWISTED_NETHER_BRICK_WALL);
        register("twisted_netherrack", ModBlocks.TWISTED_NETHERRACK);
        register("twisted_netherrack_stairs", ModBlocks.TWISTED_NETHERRACK_STAIRS);
        register("twisted_netherrack_slab", ModBlocks.TWISTED_NETHERRACK_SLAB);
        register("twisted_netherrack_wall", ModBlocks.TWISTED_NETHERRACK_WALL);
        register("weeping_nether_bricks", ModBlocks.WEEPING_NETHER_BRICKS);
        register("weeping_nether_brick_stairs", ModBlocks.WEEPING_NETHER_BRICK_STAIRS);
        register("weeping_nether_brick_slab", ModBlocks.WEEPING_NETHER_BRICK_SLAB);
        register("weeping_nether_brick_wall", ModBlocks.WEEPING_NETHER_BRICK_WALL);
        register("weeping_netherrack", ModBlocks.WEEPING_NETHERRACK);
        register("weeping_netherrack_stairs", ModBlocks.WEEPING_NETHERRACK_STAIRS);
        register("weeping_netherrack_slab", ModBlocks.WEEPING_NETHERRACK_SLAB);
        register("weeping_netherrack_wall", ModBlocks.WEEPING_NETHERRACK_WALL);
        register("snapdragon", ModBlocks.SNAPDRAGON);
        register("potted_snapdragon", ModBlocks.POTTED_SNAPDRAGON);
        register("potted_purple_mushroom", ModBlocks.POTTED_PURPLE_MUSHROOM);
        register("short_ender_grass", ModBlocks.SHORT_ENDER_GRASS);
        register("chocolate_cake", ModBlocks.CHOCOLATE_CAKE);
        register("red_velvet_cake", ModBlocks.RED_VELVET_CAKE);
        register("stone_tiles", ModBlocks.STONE_TILES);
        register("stone_tile_slab", ModBlocks.STONE_TILE_SLAB);
        register("stone_tile_stairs", ModBlocks.STONE_TILE_STAIRS);
        register("stone_tile_wall", ModBlocks.STONE_TILE_WALL);
        register("mossy_stone_tiles", ModBlocks.MOSSY_STONE_TILES);
        register("mossy_stone_tile_slab", ModBlocks.MOSSY_STONE_TILE_SLAB);
        register("mossy_stone_tile_stairs", ModBlocks.MOSSY_STONE_TILE_STAIRS);
        register("mossy_stone_tile_wall", ModBlocks.MOSSY_STONE_TILE_WALL);
        register("cracked_stone_tiles", ModBlocks.CRACKED_STONE_TILES);
        register("cracked_stone_tile_slab", ModBlocks.CRACKED_STONE_TILE_SLAB);
        register("cracked_stone_tile_stairs", ModBlocks.CRACKED_STONE_TILE_STAIRS);
        register("cracked_stone_tile_wall", ModBlocks.CRACKED_STONE_TILE_WALL);
        register("sweet_berry_pie", ModBlocks.SWEET_BERRY_PIE);
        register("blueberry_pie", ModBlocks.BLUEBERRY_PIE);
        register("blackstone_tiles", ModBlocks.BLACKSTONE_TILES);
        register("blackstone_tile_stairs", ModBlocks.BLACKSTONE_TILE_STAIRS);
        register("blackstone_tile_slab", ModBlocks.BLACKSTONE_TILE_SLAB);
        register("blackstone_tile_wall", ModBlocks.BLACKSTONE_TILE_WALL);
        register("twisted_blackstone_tiles", ModBlocks.TWISTED_BLACKSTONE_TILES);
        register("twisted_blackstone_tile_stairs", ModBlocks.TWISTED_BLACKSTONE_TILE_STAIRS);
        register("twisted_blackstone_tile_slab", ModBlocks.TWISTED_BLACKSTONE_TILE_SLAB);
        register("twisted_blackstone_tile_wall", ModBlocks.TWISTED_BLACKSTONE_TILE_WALL);
        register("weeping_blackstone_tiles", ModBlocks.WEEPING_BLACKSTONE_TILES);
        register("weeping_blackstone_tile_stairs", ModBlocks.WEEPING_BLACKSTONE_TILE_STAIRS);
        register("weeping_blackstone_tile_slab", ModBlocks.WEEPING_BLACKSTONE_TILE_SLAB);
        register("weeping_blackstone_tile_wall", ModBlocks.WEEPING_BLACKSTONE_TILE_WALL);
        register("twisted_polished_blackstone_bricks", ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICKS);
        register("twisted_polished_blackstone_brick_stairs", ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
        register("twisted_polished_blackstone_brick_slab", ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
        register("twisted_polished_blackstone_brick_wall", ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
        register("weeping_polished_blackstone_bricks", ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS);
        register("weeping_polished_blackstone_brick_stairs", ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
        register("weeping_polished_blackstone_brick_slab", ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
        register("weeping_polished_blackstone_brick_wall", ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
        register("twisted_blackstone", ModBlocks.TWISTED_BLACKSTONE);
        register("twisted_blackstone_stairs", ModBlocks.TWISTED_BLACKSTONE_STAIRS);
        register("twisted_blackstone_slab", ModBlocks.TWISTED_BLACKSTONE_SLAB);
        register("twisted_blackstone_wall", ModBlocks.TWISTED_BLACKSTONE_WALL);
        register("weeping_blackstone", ModBlocks.WEEPING_BLACKSTONE);
        register("weeping_blackstone_stairs", ModBlocks.WEEPING_BLACKSTONE_STAIRS);
        register("weeping_blackstone_slab", ModBlocks.WEEPING_BLACKSTONE_SLAB);
        register("weeping_blackstone_wall", ModBlocks.WEEPING_BLACKSTONE_WALL);
        register("quartz_tiles", ModBlocks.QUARTZ_TILES);
        register("quartz_tile_stairs", ModBlocks.QUARTZ_TILE_STAIRS);
        register("quartz_tile_slab", ModBlocks.QUARTZ_TILE_SLAB);
        register("quartz_tile_wall", ModBlocks.QUARTZ_TILE_WALL);
        register("calcite_bricks", ModBlocks.CALCITE_BRICKS);
        register("calcite_brick_stairs", ModBlocks.CALCITE_BRICK_STAIRS);
        register("calcite_brick_slab", ModBlocks.CALCITE_BRICK_SLAB);
        register("calcite_brick_wall", ModBlocks.CALCITE_BRICK_WALL);
        register("mossy_calcite_bricks", ModBlocks.MOSSY_CALCITE_BRICKS);
        register("mossy_calcite_brick_stairs", ModBlocks.MOSSY_CALCITE_BRICK_STAIRS);
        register("mossy_calcite_brick_slab", ModBlocks.MOSSY_CALCITE_BRICK_SLAB);
        register("mossy_calcite_brick_wall", ModBlocks.MOSSY_CALCITE_BRICK_WALL);
        register("cracked_calcite_bricks", ModBlocks.CRACKED_CALCITE_BRICKS);
        register("cracked_calcite_brick_stairs", ModBlocks.CRACKED_CALCITE_BRICK_STAIRS);
        register("cracked_calcite_brick_slab", ModBlocks.CRACKED_CALCITE_BRICK_SLAB);
        register("cracked_calcite_brick_wall", ModBlocks.CRACKED_CALCITE_BRICK_WALL);
        register("chiseled_calcite_bricks", ModBlocks.CHISELED_CALCITE_BRICKS);
        register("dripstone_bricks", ModBlocks.DRIPSTONE_BRICKS);
        register("dripstone_brick_stairs", ModBlocks.DRIPSTONE_BRICK_STAIRS);
        register("dripstone_brick_slab", ModBlocks.DRIPSTONE_BRICK_SLAB);
        register("dripstone_brick_wall", ModBlocks.DRIPSTONE_BRICK_WALL);
        register("mossy_dripstone_bricks", ModBlocks.MOSSY_DRIPSTONE_BRICKS);
        register("mossy_dripstone_brick_stairs", ModBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS);
        register("mossy_dripstone_brick_slab", ModBlocks.MOSSY_DRIPSTONE_BRICK_SLAB);
        register("mossy_dripstone_brick_wall", ModBlocks.MOSSY_DRIPSTONE_BRICK_WALL);
        register("cracked_dripstone_bricks", ModBlocks.CRACKED_DRIPSTONE_BRICKS);
        register("cracked_dripstone_brick_stairs", ModBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS);
        register("cracked_dripstone_brick_slab", ModBlocks.CRACKED_DRIPSTONE_BRICK_SLAB);
        register("cracked_dripstone_brick_wall", ModBlocks.CRACKED_DRIPSTONE_BRICK_WALL);
        register("chiseled_dripstone_bricks", ModBlocks.CHISELED_DRIPSTONE_BRICKS);
        register("cattail", ModBlocks.CATTAIL);
        register("blood_kelp", ModBlocks.BLOOD_KELP);
        register("blood_kelp_plant", ModBlocks.BLOOD_KELP_PLANT);
        register("dried_blood_kelp_block", ModBlocks.DRIED_BLOOD_KELP_BLOCK);
        register("blood_kelp_lantern", ModBlocks.BLOOD_KELP_LANTERN);
        register("maroon_wool", ModBlocks.MAROON_WOOL);
        register("maroon_stained_glass", ModBlocks.MAROON_STAINED_GLASS);
        register("maroon_stained_glass_pane", ModBlocks.MAROON_STAINED_GLASS_PANE);
        register("maroon_candle", ModBlocks.MAROON_CANDLE);
        register("maroon_candle_cake", ModBlocks.MAROON_CANDLE_CAKE);
        register("maroon_concrete", ModBlocks.MAROON_CONCRETE);
        register("maroon_concrete_powder", ModBlocks.MAROON_CONCRETE_POWDER);
        register("bog_blossom", ModBlocks.BOG_BLOSSOM);
        register("maroon_candle_chocolate_cake", ModBlocks.MAROON_CANDLE_CHOCOLATE_CAKE);
        register("candle_chocolate_cake", ModBlocks.CANDLE_CHOCOLATE_CAKE);
        register("white_candle_chocolate_cake", ModBlocks.WHITE_CANDLE_CHOCOLATE_CAKE);
        register("orange_candle_chocolate_cake", ModBlocks.ORANGE_CANDLE_CHOCOLATE_CAKE);
        register("magenta_candle_chocolate_cake", ModBlocks.MAGENTA_CANDLE_CHOCOLATE_CAKE);
        register("light_blue_candle_chocolate_cake", ModBlocks.LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE);
        register("yellow_candle_chocolate_cake", ModBlocks.YELLOW_CANDLE_CHOCOLATE_CAKE);
        register("lime_candle_chocolate_cake", ModBlocks.LIME_CANDLE_CHOCOLATE_CAKE);
        register("pink_candle_chocolate_cake", ModBlocks.PINK_CANDLE_CHOCOLATE_CAKE);
        register("gray_candle_chocolate_cake", ModBlocks.GRAY_CANDLE_CHOCOLATE_CAKE);
        register("light_gray_candle_chocolate_cake", ModBlocks.LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE);
        register("cyan_candle_chocolate_cake", ModBlocks.CYAN_CANDLE_CHOCOLATE_CAKE);
        register("purple_candle_chocolate_cake", ModBlocks.PURPLE_CANDLE_CHOCOLATE_CAKE);
        register("blue_candle_chocolate_cake", ModBlocks.BLUE_CANDLE_CHOCOLATE_CAKE);
        register("brown_candle_chocolate_cake", ModBlocks.BROWN_CANDLE_CHOCOLATE_CAKE);
        register("green_candle_chocolate_cake", ModBlocks.GREEN_CANDLE_CHOCOLATE_CAKE);
        register("red_candle_chocolate_cake", ModBlocks.RED_CANDLE_CHOCOLATE_CAKE);
        register("black_candle_chocolate_cake", ModBlocks.BLACK_CANDLE_CHOCOLATE_CAKE);
        register("maroon_candle_red_velvet_cake", ModBlocks.MAROON_CANDLE_RED_VELVET_CAKE);
        register("candle_red_velvet_cake", ModBlocks.CANDLE_RED_VELVET_CAKE);
        register("white_candle_red_velvet_cake", ModBlocks.WHITE_CANDLE_RED_VELVET_CAKE);
        register("orange_candle_red_velvet_cake", ModBlocks.ORANGE_CANDLE_RED_VELVET_CAKE);
        register("magenta_candle_red_velvet_cake", ModBlocks.MAGENTA_CANDLE_RED_VELVET_CAKE);
        register("light_blue_candle_red_velvet_cake", ModBlocks.LIGHT_BLUE_CANDLE_RED_VELVET_CAKE);
        register("yellow_candle_red_velvet_cake", ModBlocks.YELLOW_CANDLE_RED_VELVET_CAKE);
        register("lime_candle_red_velvet_cake", ModBlocks.LIME_CANDLE_RED_VELVET_CAKE);
        register("pink_candle_red_velvet_cake", ModBlocks.PINK_CANDLE_RED_VELVET_CAKE);
        register("gray_candle_red_velvet_cake", ModBlocks.GRAY_CANDLE_RED_VELVET_CAKE);
        register("light_gray_candle_red_velvet_cake", ModBlocks.LIGHT_GRAY_CANDLE_RED_VELVET_CAKE);
        register("cyan_candle_red_velvet_cake", ModBlocks.CYAN_CANDLE_RED_VELVET_CAKE);
        register("purple_candle_red_velvet_cake", ModBlocks.PURPLE_CANDLE_RED_VELVET_CAKE);
        register("blue_candle_red_velvet_cake", ModBlocks.BLUE_CANDLE_RED_VELVET_CAKE);
        register("brown_candle_red_velvet_cake", ModBlocks.BROWN_CANDLE_RED_VELVET_CAKE);
        register("green_candle_red_velvet_cake", ModBlocks.GREEN_CANDLE_RED_VELVET_CAKE);
        register("red_candle_red_velvet_cake", ModBlocks.RED_CANDLE_RED_VELVET_CAKE);
        register("black_candle_red_velvet_cake", ModBlocks.BLACK_CANDLE_RED_VELVET_CAKE);
        register("camel_plushie", ModBlocks.CAMEL_PLUSHIE);
        register("cindersnap_berry_bush", ModBlocks.CINDERSNAP_BERRY_BUSH);
        register("frostbite_berry_bush", ModBlocks.FROSTBITE_BERRY_BUSH);
        register("polished_dripstone", ModBlocks.POLISHED_DRIPSTONE);
        register("polished_dripstone_stairs", ModBlocks.POLISHED_DRIPSTONE_STAIRS);
        register("polished_dripstone_slab", ModBlocks.POLISHED_DRIPSTONE_SLAB);
        register("polished_dripstone_wall", ModBlocks.POLISHED_DRIPSTONE_WALL);
        register("polished_calcite", ModBlocks.POLISHED_CALCITE);
        register("polished_calcite_stairs", ModBlocks.POLISHED_CALCITE_STAIRS);
        register("polished_calcite_slab", ModBlocks.POLISHED_CALCITE_SLAB);
        register("polished_calcite_wall", ModBlocks.POLISHED_CALCITE_WALL);
        register("dripstone_stairs", ModBlocks.DRIPSTONE_STAIRS);
        register("dripstone_slab", ModBlocks.DRIPSTONE_SLAB);
        register("dripstone_wall", ModBlocks.DRIPSTONE_WALL);
        register("calcite_stairs", ModBlocks.CALCITE_STAIRS);
        register("calcite_slab", ModBlocks.CALCITE_SLAB);
        register("calcite_wall", ModBlocks.CALCITE_WALL);
        register("bamboo_planter_box", ModBlocks.BAMBOO_PLANTER_BOX);
        register("potted_cattail", ModBlocks.POTTED_CATTAIL);
        register("stone_wall", ModBlocks.STONE_WALL);
        register("quartz_wall", ModBlocks.QUARTZ_WALL);
        register("smooth_quartz_wall", ModBlocks.SMOOTH_QUARTZ_WALL);
        register("grass_slab", ModBlocks.GRASS_SLAB);
        register("podzol_slab", ModBlocks.PODZOL_SLAB);
        register("mycelium_slab", ModBlocks.MYCELIUM_SLAB);
        register("dirt_path_slab", ModBlocks.DIRT_PATH_SLAB);
        register("dirt_slab", ModBlocks.DIRT_SLAB);
        register("coarse_dirt_slab", ModBlocks.COARSE_DIRT_SLAB);
        register("rooted_dirt_slab", ModBlocks.ROOTED_DIRT_SLAB);
        register("wild_green_onions", ModBlocks.WILD_GREEN_ONIONS);

        AssortedDiscoveries.LOGGER.info("Registered blocks");
    }

    static {
        BAT_PLUSHIE = new BatPlushieBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor.CLEAR)
                .strength(0.2F).sounds(BlockSoundGroup.WOOL));
        BLAZE_PLUSHIE = new BlazePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CAVE_SPIDER_PLUSHIE = new CaveSpiderPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CHICKEN_PLUSHIE = new ChickenPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        COW_PLUSHIE = new CowPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CREEPER_PLUSHIE = new CreeperPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        ENDERMAN_PLUSHIE = new EndermanPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GHAST_PLUSHIE = new GhastPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GUARDIAN_PLUSHIE = new GuardianPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WHITE_HORSE_PLUSHIE = new HorsePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GRAY_HORSE_PLUSHIE = new HorsePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        LIGHT_GRAY_HORSE_PLUSHIE = new HorsePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BROWN_HORSE_PLUSHIE = new HorsePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BLACK_HORSE_PLUSHIE = new HorsePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        MAGMA_CUBE_PLUSHIE = new CubePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE)
                .pistonBehavior(PistonBehavior.DESTROY));
        RED_MOOSHROOM_PLUSHIE = new MooshroomPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BROWN_MOOSHROOM_PLUSHIE = new MooshroomPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        OCELOT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        TABBY_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        TUXEDO_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        RED_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SIAMESE_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BRITISH_SHORTHAIR_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CALICO_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PERSIAN_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        RAGDOLL_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WHITE_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        JELLIE_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BLACK_CAT_PLUSHIE = new CatPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PIG_PLUSHIE = new PigPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BROWN_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WHITE_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BLACK_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WHITE_SPLOTCHED_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GOLD_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        TOAST_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SALT_RABBIT_PLUSHIE = new RabbitPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WHITE_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        ORANGE_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        MAGENTA_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        LIGHT_BLUE_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        YELLOW_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        LIME_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PINK_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GRAY_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        LIGHT_GRAY_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CYAN_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PURPLE_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BLUE_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BROWN_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GREEN_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        RED_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        BLACK_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        MAROON_SHEEP_PLUSHIE = new SheepPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SKELETON_PLUSHIE = new SkeletonPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SLIME_PLUSHIE = new CubePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE)
                .pistonBehavior(PistonBehavior.DESTROY));
        SPIDER_PLUSHIE = new SpiderPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SQUID_PLUSHIE = new SquidPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        GLOW_SQUID_PLUSHIE = new SquidPlushieBlock(AbstractBlock.Settings.create().burnable()
                .mapColor(MapColor.CLEAR).strength(0.2F).sounds(BlockSoundGroup.WOOL).luminance((state) -> 10));
        BEE_PLUSHIE = new BeePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PLAINS_VILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        DESERT_VILLAGER_PLUSHIE = new DesertVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        JUNGLE_VILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SAVANNA_VILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SNOW_VILLAGER_PLUSHIE = new ShortHatVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SWAMP_VILLAGER_PLUSHIE = new ShortHatVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        TAIGA_VILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CRIMSON_VILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WARPED_VILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WANDERING_TRADER_PLUSHIE = new ShortHatVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PLAINS_ZOMBIE_VILLAGER_PLUSHIE = new ZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        DESERT_ZOMBIE_VILLAGER_PLUSHIE = new DesertZombieVillagerPlushieBlock(
                AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        JUNGLE_ZOMBIE_VILLAGER_PLUSHIE = new ZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SAVANNA_ZOMBIE_VILLAGER_PLUSHIE = new ZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SNOW_ZOMBIE_VILLAGER_PLUSHIE = new ShortHatZombieVillagerPlushieBlock(
                AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SWAMP_ZOMBIE_VILLAGER_PLUSHIE = new ShortHatZombieVillagerPlushieBlock(
                AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        TAIGA_ZOMBIE_VILLAGER_PLUSHIE = new ZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        CRIMSON_ZOMBIE_VILLAGER_PLUSHIE = new ZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WARPED_ZOMBIE_VILLAGER_PLUSHIE = new ZombieVillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WITCH_PLUSHIE = new WitchPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PALE_WOLF_PLUSHIE = new WolfPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        ZOMBIE_PLUSHIE = new ZombiePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PIGLIN_PLUSHIE = new PiglinPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        ZOMBIFIED_PIGLIN_PLUSHIE = new ZombiePlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PUFFERFISH_PLUSHIE = new PufferfishPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        WITHER_PLUSHIE = new WitherPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        STRIDER_PLUSHIE = new StriderPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SHIVERING_STRIDER_PLUSHIE = new StriderPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        PHANTOM_PLUSHIE = new PhantomPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        HOGLIN_PLUSHIE = new HoglinPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        ZOGLIN_PLUSHIE = new HoglinPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        POLAR_BEAR_PLUSHIE = new PolarBearPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        ALLAY_PLUSHIE = new AllayPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.GLOW_SQUID_PLUSHIE));
        PILLAGER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        VINDICATOR_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        EVOKER_PLUSHIE = new VillagerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        RAVAGER_PLUSHIE = new HoglinPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        SHULKER_PLUSHIE = new ShulkerPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        VEX_PLUSHIE = new AllayPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.GLOW_SQUID_PLUSHIE));
        CAMEL_PLUSHIE = new CamelPlushieBlock(AbstractBlock.Settings.copy(ModBlocks.BAT_PLUSHIE));
        NETHER_SMOKY_QUARTZ_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE));
        SMOKY_QUARTZ_BLOCK = new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK)
                .requiresTool().strength(0.8F));
        CHISELED_SMOKY_QUARTZ_BLOCK = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_BRICKS = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_BRICK_STAIRS = new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_PILLAR = new PillarBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_STAIRS = new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOKY_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOOTH_SMOKY_QUARTZ = new Block(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOOTH_SMOKY_QUARTZ_STAIRS = new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOOTH_SMOKY_QUARTZ_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        SMOOTH_SMOKY_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(SMOKY_QUARTZ_BLOCK));
        CRACKED_STONE_BRICK_STAIRS = new StairsBlock(Blocks.CRACKED_STONE_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
        CRACKED_STONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
        CRACKED_STONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS));
        BLUEBERRY_BUSH = new BlueberryBushBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
        GREEN_ONIONS = new GreenOnionsBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
        OAK_PLANTER_BOX = planterBoxBlock(Blocks.OAK_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        SPRUCE_PLANTER_BOX = planterBoxBlock(Blocks.SPRUCE_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        BIRCH_PLANTER_BOX = planterBoxBlock(Blocks.BIRCH_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        JUNGLE_PLANTER_BOX = planterBoxBlock(Blocks.JUNGLE_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        ACACIA_PLANTER_BOX = planterBoxBlock(Blocks.ACACIA_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        DARK_OAK_PLANTER_BOX = planterBoxBlock(Blocks.DARK_OAK_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        MANGROVE_PLANTER_BOX = planterBoxBlock(Blocks.MANGROVE_PLANKS.getDefaultMapColor(), BlockSoundGroup.WOOD);
        CHERRY_PLANTER_BOX = planterBoxBlock(Blocks.CHERRY_PLANKS.getDefaultMapColor(), BlockSoundGroup.CHERRY_WOOD);
        CRIMSON_PLANTER_BOX = netherPlanterBoxBlock(Blocks.CRIMSON_PLANKS.getDefaultMapColor());
        WARPED_PLANTER_BOX = netherPlanterBoxBlock(Blocks.WARPED_PLANKS.getDefaultMapColor());
        OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
        SPRUCE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS));
        BIRCH_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS));
        JUNGLE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS));
        ACACIA_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS));
        DARK_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS));
        MANGROVE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS));
        CRIMSON_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));
        WARPED_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
        CHERRY_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS));
        STRIPPED_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
        STRIPPED_SPRUCE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS));
        STRIPPED_BIRCH_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS));
        STRIPPED_JUNGLE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS));
        STRIPPED_ACACIA_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS));
        STRIPPED_DARK_OAK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS));
        STRIPPED_MANGROVE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS));
        STRIPPED_CRIMSON_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));
        STRIPPED_WARPED_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
        STRIPPED_CHERRY_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS));
        OAK_ROPE_LADDER = ropeLadderBlock();
        SPRUCE_ROPE_LADDER = ropeLadderBlock();
        BIRCH_ROPE_LADDER = ropeLadderBlock();
        JUNGLE_ROPE_LADDER = ropeLadderBlock();
        ACACIA_ROPE_LADDER = ropeLadderBlock();
        DARK_OAK_ROPE_LADDER = ropeLadderBlock();
        CRIMSON_ROPE_LADDER = ropeLadderBlock();
        WARPED_ROPE_LADDER = ropeLadderBlock();
        MANGROVE_ROPE_LADDER = ropeLadderBlock();
        CHERRY_ROPE_LADDER = ropeLadderBlock();
        IRON_LADDER = new LadderBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY)
                .requiresTool().strength(5.0F).sounds(BlockSoundGroup.METAL).nonOpaque());
        SNOW_BRICKS = new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE)
                .strength(0.4F).requiresTool().sounds(BlockSoundGroup.SNOW));
        SNOW_BRICK_STAIRS = new StairsBlock(ModBlocks.SNOW_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(SNOW_BRICKS));
        SNOW_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
        SNOW_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(SNOW_BRICKS));
        PACKED_SNOW = new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE)
                .strength(0.6F).requiresTool().sounds(BlockSoundGroup.SNOW));
        PACKED_SNOW_STAIRS = new StairsBlock(ModBlocks.PACKED_SNOW.getDefaultState(),
                AbstractBlock.Settings.copy(SNOW_BRICKS));
        PACKED_SNOW_SLAB = new SlabBlock(AbstractBlock.Settings.copy(PACKED_SNOW));
        PACKED_SNOW_WALL = new WallBlock(AbstractBlock.Settings.copy(PACKED_SNOW));
        PURPLE_MUSHROOM = new MushroomPlantBlock(ModTreeConfiguredFeatures.HUGE_PURPLE_MUSHROOM,
                AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).pistonBehavior(PistonBehavior.DESTROY)
                        .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS)
                        .postProcess(ModBlocks::always));
        PURPLE_MUSHROOM_BLOCK = new PurpleMushroomBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK));
        WOODCUTTER = new WoodcutterBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.OAK_TAN).strength(2.5F).sounds(BlockSoundGroup.WOOD).burnable());
        WHITE_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.WHITE_EMBER);
        ORANGE_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.ORANGE_EMBER);
        MAGENTA_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.MAGENTA_EMBER);
        LIGHT_BLUE_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.LIGHT_BLUE_EMBER);
        YELLOW_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.YELLOW_EMBER);
        LIME_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.LIME_EMBER);
        PINK_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.PINK_EMBER);
        GRAY_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.GRAY_EMBER);
        LIGHT_GRAY_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.LIGHT_GRAY_EMBER);
        CYAN_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.CYAN_EMBER);
        PURPLE_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.PURPLE_EMBER);
        BLUE_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.BLUE_EMBER);
        BROWN_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.BROWN_EMBER);
        GREEN_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.GREEN_EMBER);
        RED_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.RED_EMBER);
        BLACK_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.BLACK_EMBER);
        MAROON_CAMPFIRE = dyedCampfireBlock(ModParticleTypes.MAROON_EMBER);
        WHITE_LANTERN = lanternBlock();
        ORANGE_LANTERN = lanternBlock();
        MAGENTA_LANTERN = lanternBlock();
        LIGHT_BLUE_LANTERN = lanternBlock();
        YELLOW_LANTERN = lanternBlock();
        LIME_LANTERN = lanternBlock();
        PINK_LANTERN = lanternBlock();
        GRAY_LANTERN = lanternBlock();
        LIGHT_GRAY_LANTERN = lanternBlock();
        CYAN_LANTERN = lanternBlock();
        PURPLE_LANTERN = lanternBlock();
        BLUE_LANTERN = lanternBlock();
        BROWN_LANTERN = lanternBlock();
        GREEN_LANTERN = lanternBlock();
        RED_LANTERN = lanternBlock();
        BLACK_LANTERN = lanternBlock();
        MAROON_LANTERN = lanternBlock();
        WHITE_WALL_TORCH = wallTorchBlock(ModParticleTypes.WHITE_FLAME);
        ORANGE_WALL_TORCH = wallTorchBlock(ModParticleTypes.ORANGE_FLAME);
        MAGENTA_WALL_TORCH = wallTorchBlock(ModParticleTypes.MAGENTA_FLAME);
        LIGHT_BLUE_WALL_TORCH = wallTorchBlock(ModParticleTypes.LIGHT_BLUE_FLAME);
        YELLOW_WALL_TORCH = wallTorchBlock(ModParticleTypes.YELLOW_FLAME);
        LIME_WALL_TORCH = wallTorchBlock(ModParticleTypes.LIME_FLAME);
        PINK_WALL_TORCH = wallTorchBlock(ModParticleTypes.PINK_FLAME);
        GRAY_WALL_TORCH = wallTorchBlock(ModParticleTypes.GRAY_FLAME);
        LIGHT_GRAY_WALL_TORCH = wallTorchBlock(ModParticleTypes.LIGHT_GRAY_FLAME);
        CYAN_WALL_TORCH = wallTorchBlock(ModParticleTypes.CYAN_FLAME);
        PURPLE_WALL_TORCH = wallTorchBlock(ModParticleTypes.PURPLE_FLAME);
        BLUE_WALL_TORCH = wallTorchBlock(ModParticleTypes.BLUE_FLAME);
        BROWN_WALL_TORCH = wallTorchBlock(ModParticleTypes.BROWN_FLAME);
        GREEN_WALL_TORCH = wallTorchBlock(ModParticleTypes.GREEN_FLAME);
        RED_WALL_TORCH = wallTorchBlock(ModParticleTypes.RED_FLAME);
        BLACK_WALL_TORCH = wallTorchBlock(ModParticleTypes.BLACK_FLAME);
        MAROON_WALL_TORCH = wallTorchBlock(ModParticleTypes.MAROON_FLAME);
        WHITE_TORCH = torchBlock(ModParticleTypes.WHITE_FLAME);
        ORANGE_TORCH = torchBlock(ModParticleTypes.ORANGE_FLAME);
        MAGENTA_TORCH = torchBlock(ModParticleTypes.MAGENTA_FLAME);
        LIGHT_BLUE_TORCH = torchBlock(ModParticleTypes.LIGHT_BLUE_FLAME);
        YELLOW_TORCH = torchBlock(ModParticleTypes.YELLOW_FLAME);
        LIME_TORCH = torchBlock(ModParticleTypes.LIME_FLAME);
        PINK_TORCH = torchBlock(ModParticleTypes.PINK_FLAME);
        GRAY_TORCH = torchBlock(ModParticleTypes.GRAY_FLAME);
        LIGHT_GRAY_TORCH = torchBlock(ModParticleTypes.LIGHT_GRAY_FLAME);
        CYAN_TORCH = torchBlock(ModParticleTypes.CYAN_FLAME);
        PURPLE_TORCH = torchBlock(ModParticleTypes.PURPLE_FLAME);
        BLUE_TORCH = torchBlock(ModParticleTypes.BLUE_FLAME);
        BROWN_TORCH = torchBlock(ModParticleTypes.BROWN_FLAME);
        GREEN_TORCH = torchBlock(ModParticleTypes.GREEN_FLAME);
        RED_TORCH = torchBlock(ModParticleTypes.RED_FLAME);
        BLACK_TORCH = torchBlock(ModParticleTypes.BLACK_FLAME);
        MAROON_TORCH = torchBlock(ModParticleTypes.MAROON_FLAME);
        WITCHS_CRADLE = new WitchsCradleBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
                .luminance((state) -> 10));
        BAUXITE = new Block(AbstractBlock.Settings.create()
                .mapColor(MapColor.SPRUCE_BROWN).strength(0.3F));
        BAUXITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE));
        BAUXITE_STAIRS = new StairsBlock(BAUXITE.getDefaultState(),
                AbstractBlock.Settings.copy(BAUXITE));
        BAUXITE_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE));
        BAUXITE_BRICKS = new Block(AbstractBlock.Settings.create()
                .mapColor(MapColor.SPRUCE_BROWN).strength(0.4F).sounds(BlockSoundGroup.STONE));
        BAUXITE_BRICK_STAIRS = new StairsBlock(BAUXITE_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        BAUXITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        BAUXITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        MOSSY_BAUXITE_BRICKS = new Block(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        MOSSY_BAUXITE_BRICK_STAIRS = new StairsBlock(MOSSY_BAUXITE_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        MOSSY_BAUXITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        MOSSY_BAUXITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        CRACKED_BAUXITE_BRICKS = new Block(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        CRACKED_BAUXITE_BRICK_STAIRS = new StairsBlock(BAUXITE_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        CRACKED_BAUXITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        CRACKED_BAUXITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(BAUXITE_BRICKS));
        TWISTED_NETHER_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS));
        TWISTED_NETHER_BRICK_STAIRS = new StairsBlock(TWISTED_NETHER_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
        TWISTED_NETHER_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
        TWISTED_NETHER_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_NETHER_BRICKS));
        TWISTED_NETHERRACK = new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK));
        TWISTED_NETHERRACK_STAIRS = new StairsBlock(TWISTED_NETHERRACK.getDefaultState(),
                AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
        TWISTED_NETHERRACK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
        TWISTED_NETHERRACK_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_NETHERRACK));
        WEEPING_NETHER_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS));
        WEEPING_NETHER_BRICK_STAIRS = new StairsBlock(WEEPING_NETHER_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
        WEEPING_NETHER_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
        WEEPING_NETHER_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(WEEPING_NETHER_BRICKS));
        WEEPING_NETHERRACK = new Block(AbstractBlock.Settings.copy(Blocks.NETHERRACK));
        WEEPING_NETHERRACK_STAIRS = new StairsBlock(WEEPING_NETHERRACK.getDefaultState(),
                AbstractBlock.Settings.copy(WEEPING_NETHERRACK));
        WEEPING_NETHERRACK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(WEEPING_NETHERRACK));
        WEEPING_NETHERRACK_WALL = new WallBlock(AbstractBlock.Settings.copy(WEEPING_NETHERRACK));
        SNAPDRAGON = new SnapdragonBlock(StatusEffects.LUCK, 8,
                AbstractBlock.Settings.copy(Blocks.POPPY).luminance((state) -> 7));
        POTTED_SNAPDRAGON = new PottedSnapdragonBlock(ModBlocks.SNAPDRAGON,
                AbstractBlock.Settings.copy(Blocks.POTTED_POPPY).luminance((state) -> 7));
        POTTED_PURPLE_MUSHROOM = new FlowerPotBlock(ModBlocks.PURPLE_MUSHROOM,
                AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM));
        SHORT_ENDER_GRASS = new ShortEnderGrassBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)
                .luminance((state) -> 7));
        CATTAIL = new CattailBlock(AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
                .noCollision().nonOpaque().sounds(BlockSoundGroup.WET_GRASS));
        CHOCOLATE_CAKE = new ModdedCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
        RED_VELVET_CAKE = new ModdedCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
        STONE_TILES = new Block(AbstractBlock.Settings.copy(Blocks.STONE)
                .sounds(BlockSoundGroup.DEEPSLATE_TILES));
        STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
        STONE_TILE_STAIRS = new StairsBlock(STONE_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(STONE_TILES));
        STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
        MOSSY_STONE_TILES = new Block(AbstractBlock.Settings.copy(STONE_TILES));
        MOSSY_STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
        MOSSY_STONE_TILE_STAIRS = new StairsBlock(MOSSY_STONE_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(STONE_TILES));
        MOSSY_STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
        CRACKED_STONE_TILES = new Block(AbstractBlock.Settings.copy(STONE_TILES));
        CRACKED_STONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(STONE_TILES));
        CRACKED_STONE_TILE_STAIRS = new StairsBlock(CRACKED_STONE_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(STONE_TILES));
        CRACKED_STONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(STONE_TILES));
        SWEET_BERRY_PIE = new PieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), 3, 0.6F);
        BLUEBERRY_PIE = new PieBlock(AbstractBlock.Settings.copy(Blocks.CAKE), 3, 0.6F);
        BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)
                .sounds(BlockSoundGroup.DEEPSLATE_TILES));
        BLACKSTONE_TILE_STAIRS = new StairsBlock(BLACKSTONE_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        TWISTED_BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        TWISTED_BLACKSTONE_TILE_STAIRS = new StairsBlock(BLACKSTONE_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        TWISTED_BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        TWISTED_BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        WEEPING_BLACKSTONE_TILES = new Block(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        WEEPING_BLACKSTONE_TILE_STAIRS = new StairsBlock(BLACKSTONE_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        WEEPING_BLACKSTONE_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        WEEPING_BLACKSTONE_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(BLACKSTONE_TILES));
        TWISTED_POLISHED_BLACKSTONE_BRICKS = new Block(
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS = new StairsBlock(
                Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB = new SlabBlock(
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        TWISTED_POLISHED_BLACKSTONE_BRICK_WALL = new WallBlock(
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        WEEPING_POLISHED_BLACKSTONE_BRICKS = new Block(
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = new StairsBlock(
                Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = new SlabBlock(
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = new WallBlock(
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS));
        TWISTED_BLACKSTONE = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        TWISTED_BLACKSTONE_STAIRS = new StairsBlock(Blocks.BLACKSTONE.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        TWISTED_BLACKSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        TWISTED_BLACKSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(TWISTED_BLACKSTONE));
        WEEPING_BLACKSTONE = new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        WEEPING_BLACKSTONE_STAIRS = new StairsBlock(
                Blocks.BLACKSTONE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        WEEPING_BLACKSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        WEEPING_BLACKSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE));
        QUARTZ_TILES = new Block(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK)
                .sounds(BlockSoundGroup.DEEPSLATE_TILES));
        QUARTZ_TILE_STAIRS = new StairsBlock(QUARTZ_TILES.getDefaultState(),
                AbstractBlock.Settings.copy(QUARTZ_TILES));
        QUARTZ_TILE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(QUARTZ_TILES));
        QUARTZ_TILE_WALL = new WallBlock(AbstractBlock.Settings.copy(QUARTZ_TILES));
        CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
        CALCITE_BRICK_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.CALCITE));
        CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        MOSSY_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
        MOSSY_CALCITE_BRICK_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.CALCITE));
        MOSSY_CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        MOSSY_CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        CRACKED_CALCITE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
        CRACKED_CALCITE_BRICK_STAIRS = new StairsBlock(
                CRACKED_CALCITE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
        CRACKED_CALCITE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
        CRACKED_CALCITE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(CRACKED_CALCITE_BRICKS));
        CHISELED_CALCITE_BRICKS = new PillarBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        DRIPSTONE_BRICK_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        MOSSY_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        MOSSY_DRIPSTONE_BRICK_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        MOSSY_DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        MOSSY_DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        CRACKED_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        CRACKED_DRIPSTONE_BRICK_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        CRACKED_DRIPSTONE_BRICK_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        CRACKED_DRIPSTONE_BRICK_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        CHISELED_DRIPSTONE_BRICKS = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        BLOOD_KELP = new BloodKelpBlock(AbstractBlock.Settings.copy(Blocks.KELP)
                .luminance(getLuminanceFromState()));
        BLOOD_KELP_PLANT = new BloodKelpPlantBlock(AbstractBlock.Settings.copy(Blocks.KELP_PLANT)
                .luminance(getLuminanceFromState()));
        DRIED_BLOOD_KELP_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.DRIED_KELP_BLOCK));
        BLOOD_KELP_LANTERN = new PillarBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.PALE_YELLOW).strength(0.3F).sounds(BlockSoundGroup.GLASS).luminance((state) -> 15));
        MAROON_WOOL = new Block(AbstractBlock.Settings.copy(Blocks.RED_WOOL));
        MAROON_STAINED_GLASS = new StainedGlassBlock(DyeColor.RED,
                AbstractBlock.Settings.create().mapColor(DyeColor.RED).strength(0.3F).sounds(BlockSoundGroup.GLASS)
                        .nonOpaque().allowsSpawning(ModBlocks::never).solidBlock(ModBlocks::never)
                        .suffocates(ModBlocks::never).blockVision(ModBlocks::never));
        MAROON_STAINED_GLASS_PANE = new StainedGlassPaneBlock(DyeColor.RED,
                AbstractBlock.Settings.create().instrument(Instrument.HAT).strength(0.3F).sounds(BlockSoundGroup.GLASS)
                        .nonOpaque());
        MAROON_CANDLE = new CandleBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_RED).nonOpaque().strength(0.1F)
                .sounds(BlockSoundGroup.CANDLE).luminance(CandleBlock.STATE_TO_LUMINANCE)
                .pistonBehavior(PistonBehavior.DESTROY));
        MAROON_CONCRETE = new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED)
                .requiresTool().strength(1.8F).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.STONE));
        MAROON_CONCRETE_POWDER = new ConcretePowderBlock(MAROON_CONCRETE,
                AbstractBlock.Settings.create().instrument(Instrument.SNARE).mapColor(MapColor.DARK_RED)
                        .strength(0.5F).sounds(BlockSoundGroup.SAND));
        MAROON_CANDLE_CAKE = new CandleCakeBlock(MAROON_CANDLE, AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BOG_BLOSSOM = new BogBlossomBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN).breakInstantly().noCollision().sounds(BlockSoundGroup.SPORE_BLOSSOM)
                .pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> 10));
        MAROON_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, MAROON_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        WHITE_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.WHITE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        ORANGE_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.ORANGE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        MAGENTA_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.MAGENTA_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIGHT_BLUE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        YELLOW_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.YELLOW_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        LIME_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIME_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        PINK_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.PINK_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        GRAY_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.GRAY_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.LIGHT_GRAY_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        CYAN_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.CYAN_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        PURPLE_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.PURPLE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BLUE_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BLUE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BROWN_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BROWN_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        GREEN_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.GREEN_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        RED_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.RED_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BLACK_CANDLE_CHOCOLATE_CAKE = new ModdedCandleCakeBlock(CHOCOLATE_CAKE, Blocks.BLACK_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        MAROON_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, MAROON_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        WHITE_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.WHITE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        ORANGE_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.ORANGE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        MAGENTA_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.MAGENTA_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        LIGHT_BLUE_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.LIGHT_BLUE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        YELLOW_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.YELLOW_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        LIME_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.LIME_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        PINK_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.PINK_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        GRAY_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.GRAY_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        LIGHT_GRAY_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.LIGHT_GRAY_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        CYAN_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.CYAN_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        PURPLE_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.PURPLE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BLUE_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.BLUE_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BROWN_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.BROWN_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        GREEN_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.GREEN_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        RED_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.RED_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        BLACK_CANDLE_RED_VELVET_CAKE = new ModdedCandleCakeBlock(RED_VELVET_CAKE, Blocks.BLACK_CANDLE,
                AbstractBlock.Settings.copy(Blocks.CANDLE_CAKE));
        CINDERSNAP_BERRY_BUSH = new CindersnapBerryBushBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_CRIMSON).ticksRandomly().noCollision().sounds(BlockSoundGroup.NETHER_SPROUTS)
                .pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> 8));
        FROSTBITE_BERRY_BUSH = new FrostbiteBerryBushBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor.CYAN).ticksRandomly().noCollision().sounds(BlockSoundGroup.NETHER_SPROUTS)
                .pistonBehavior(PistonBehavior.DESTROY).luminance((state) -> 5));
        POLISHED_DRIPSTONE = new Block(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        POLISHED_DRIPSTONE_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        POLISHED_DRIPSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        POLISHED_DRIPSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        POLISHED_CALCITE = new Block(AbstractBlock.Settings.copy(Blocks.CALCITE));
        POLISHED_CALCITE_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.CALCITE));
        POLISHED_CALCITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        POLISHED_CALCITE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        DRIPSTONE_STAIRS = new StairsBlock(Blocks.DRIPSTONE_BLOCK.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        DRIPSTONE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        DRIPSTONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK));
        CALCITE_STAIRS = new StairsBlock(Blocks.CALCITE.getDefaultState(),
                AbstractBlock.Settings.copy(Blocks.CALCITE));
        CALCITE_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        CALCITE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE));
        BAMBOO_PLANTER_BOX = planterBoxBlock(Blocks.BAMBOO_PLANKS.getDefaultMapColor(),
                BlockSoundGroup.BAMBOO_WOOD);
        POTTED_CATTAIL = new FlowerPotBlock(ModBlocks.CATTAIL,
                AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM));
        STONE_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE));
        QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK));
        SMOOTH_QUARTZ_WALL = new WallBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ));
        GRASS_SLAB = new SnowySlabBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK));
        PODZOL_SLAB = new SnowySlabBlock(AbstractBlock.Settings.copy(Blocks.PODZOL));
        MYCELIUM_SLAB = new SnowySlabBlock(AbstractBlock.Settings.copy(Blocks.MYCELIUM));
        DIRT_PATH_SLAB = new DirtPathSlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT_PATH));
        DIRT_SLAB = new DirtSlabBlock(AbstractBlock.Settings.copy(Blocks.DIRT));
        COARSE_DIRT_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.COARSE_DIRT));
        ROOTED_DIRT_SLAB = new SlabBlock(AbstractBlock.Settings.copy(Blocks.ROOTED_DIRT));
        WILD_GREEN_ONIONS = new WildGreenOnionsBlock(AbstractBlock.Settings.copy(Blocks.WHEAT));
    }
}
