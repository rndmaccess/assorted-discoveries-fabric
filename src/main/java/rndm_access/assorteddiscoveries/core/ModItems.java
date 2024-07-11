package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Direction;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.item.*;

public class ModItems {
    public static final Item BAT_PLUSHIE;
    public static final Item BLAZE_PLUSHIE;
    public static final Item CAVE_SPIDER_PLUSHIE;
    public static final Item CHICKEN_PLUSHIE;
    public static final Item COW_PLUSHIE;
    public static final Item CREEPER_PLUSHIE;
    public static final Item ENDERMAN_PLUSHIE;
    public static final Item GHAST_PLUSHIE;
    public static final Item GUARDIAN_PLUSHIE;
    public static final Item WHITE_HORSE_PLUSHIE;
    public static final Item GRAY_HORSE_PLUSHIE;
    public static final Item LIGHT_GRAY_HORSE_PLUSHIE;
    public static final Item BROWN_HORSE_PLUSHIE;
    public static final Item BLACK_HORSE_PLUSHIE;
    public static final Item MAGMA_CUBE_PLUSHIE;
    public static final Item RED_MOOSHROOM_PLUSHIE;
    public static final Item BROWN_MOOSHROOM_PLUSHIE;
    public static final Item OCELOT_PLUSHIE;
    public static final Item TABBY_CAT_PLUSHIE;
    public static final Item TUXEDO_CAT_PLUSHIE;
    public static final Item RED_CAT_PLUSHIE;
    public static final Item SIAMESE_CAT_PLUSHIE;
    public static final Item BRITISH_SHORTHAIR_CAT_PLUSHIE;
    public static final Item CALICO_CAT_PLUSHIE;
    public static final Item PERSIAN_CAT_PLUSHIE;
    public static final Item RAGDOLL_CAT_PLUSHIE;
    public static final Item WHITE_CAT_PLUSHIE;
    public static final Item JELLIE_CAT_PLUSHIE;
    public static final Item BLACK_CAT_PLUSHIE;
    public static final Item PIG_PLUSHIE;
    public static final Item BROWN_RABBIT_PLUSHIE;
    public static final Item WHITE_RABBIT_PLUSHIE;
    public static final Item BLACK_RABBIT_PLUSHIE;
    public static final Item WHITE_SPLOTCHED_RABBIT_PLUSHIE;
    public static final Item GOLD_RABBIT_PLUSHIE;
    public static final Item TOAST_RABBIT_PLUSHIE;
    public static final Item SALT_RABBIT_PLUSHIE;
    public static final Item WHITE_SHEEP_PLUSHIE;
    public static final Item ORANGE_SHEEP_PLUSHIE;
    public static final Item MAGENTA_SHEEP_PLUSHIE;
    public static final Item LIGHT_BLUE_SHEEP_PLUSHIE;
    public static final Item YELLOW_SHEEP_PLUSHIE;
    public static final Item LIME_SHEEP_PLUSHIE;
    public static final Item PINK_SHEEP_PLUSHIE;
    public static final Item GRAY_SHEEP_PLUSHIE;
    public static final Item LIGHT_GRAY_SHEEP_PLUSHIE;
    public static final Item CYAN_SHEEP_PLUSHIE;
    public static final Item PURPLE_SHEEP_PLUSHIE;
    public static final Item BLUE_SHEEP_PLUSHIE;
    public static final Item BROWN_SHEEP_PLUSHIE;
    public static final Item GREEN_SHEEP_PLUSHIE;
    public static final Item RED_SHEEP_PLUSHIE;
    public static final Item BLACK_SHEEP_PLUSHIE;
    public static final Item MAROON_SHEEP_PLUSHIE;
    public static final Item SKELETON_PLUSHIE;
    public static final Item SLIME_PLUSHIE;
    public static final Item SPIDER_PLUSHIE;
    public static final Item SQUID_PLUSHIE;
    public static final Item GLOW_SQUID_PLUSHIE;
    public static final Item BEE_PLUSHIE;
    public static final Item PLAINS_VILLAGER_PLUSHIE;
    public static final Item DESERT_VILLAGER_PLUSHIE;
    public static final Item JUNGLE_VILLAGER_PLUSHIE;
    public static final Item SAVANNA_VILLAGER_PLUSHIE;
    public static final Item SNOW_VILLAGER_PLUSHIE;
    public static final Item SWAMP_VILLAGER_PLUSHIE;
    public static final Item TAIGA_VILLAGER_PLUSHIE;
    public static final Item CRIMSON_VILLAGER_PLUSHIE;
    public static final Item WARPED_VILLAGER_PLUSHIE;
    public static final Item WANDERING_TRADER_PLUSHIE;
    public static final Item PLAINS_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item DESERT_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item JUNGLE_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item SAVANNA_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item SNOW_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item SWAMP_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item TAIGA_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item CRIMSON_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item WARPED_ZOMBIE_VILLAGER_PLUSHIE;
    public static final Item WITCH_PLUSHIE;
    public static final Item PALE_WOLF_PLUSHIE;
    public static final Item ZOMBIE_PLUSHIE;
    public static final Item PIGLIN_PLUSHIE;
    public static final Item ZOMBIFIED_PIGLIN_PLUSHIE;
    public static final Item PUFFERFISH_PLUSHIE;
    public static final Item WITHER_PLUSHIE;
    public static final Item STRIDER_PLUSHIE;
    public static final Item SHIVERING_STRIDER_PLUSHIE;
    public static final Item PHANTOM_PLUSHIE;
    public static final Item HOGLIN_PLUSHIE;
    public static final Item ZOGLIN_PLUSHIE;
    public static final Item POLAR_BEAR_PLUSHIE;
    public static final Item ALLAY_PLUSHIE;
    public static final Item PILLAGER_PLUSHIE;
    public static final Item VINDICATOR_PLUSHIE;
    public static final Item EVOKER_PLUSHIE;
    public static final Item RAVAGER_PLUSHIE;
    public static final Item SHULKER_PLUSHIE;
    public static final Item VEX_PLUSHIE;
    public static final Item NETHER_SMOKY_QUARTZ_ORE;
    public static final Item SMOKY_QUARTZ_BLOCK;
    public static final Item CHISELED_SMOKY_QUARTZ_BLOCK;
    public static final Item SMOKY_QUARTZ_BRICKS;
    public static final Item SMOKY_QUARTZ_BRICK_STAIRS;
    public static final Item SMOKY_QUARTZ_BRICK_SLAB;
    public static final Item SMOKY_QUARTZ_BRICK_WALL;
    public static final Item SMOKY_QUARTZ_PILLAR;
    public static final Item SMOKY_QUARTZ_STAIRS;
    public static final Item SMOKY_QUARTZ_SLAB;
    public static final Item SMOKY_QUARTZ_WALL;
    public static final Item SMOOTH_SMOKY_QUARTZ;
    public static final Item SMOOTH_SMOKY_QUARTZ_STAIRS;
    public static final Item SMOOTH_SMOKY_QUARTZ_SLAB;
    public static final Item SMOOTH_SMOKY_QUARTZ_WALL;
    public static final Item CRACKED_STONE_BRICK_STAIRS;
    public static final Item CRACKED_STONE_BRICK_SLAB;
    public static final Item CRACKED_STONE_BRICK_WALL;
    public static final Item OAK_PLANTER_BOX;
    public static final Item SPRUCE_PLANTER_BOX;
    public static final Item BIRCH_PLANTER_BOX;
    public static final Item JUNGLE_PLANTER_BOX;
    public static final Item ACACIA_PLANTER_BOX;
    public static final Item DARK_OAK_PLANTER_BOX;
    public static final Item MANGROVE_PLANTER_BOX;
    public static final Item CHERRY_PLANTER_BOX;
    public static final Item CRIMSON_PLANTER_BOX;
    public static final Item WARPED_PLANTER_BOX;
    public static final Item OAK_WALL;
    public static final Item SPRUCE_WALL;
    public static final Item BIRCH_WALL;
    public static final Item JUNGLE_WALL;
    public static final Item ACACIA_WALL;
    public static final Item DARK_OAK_WALL;
    public static final Item MANGROVE_WALL;
    public static final Item CRIMSON_WALL;
    public static final Item WARPED_WALL;
    public static final Item CHERRY_WALL;
    public static final Item STRIPPED_OAK_WALL;
    public static final Item STRIPPED_SPRUCE_WALL;
    public static final Item STRIPPED_BIRCH_WALL;
    public static final Item STRIPPED_JUNGLE_WALL;
    public static final Item STRIPPED_ACACIA_WALL;
    public static final Item STRIPPED_DARK_OAK_WALL;
    public static final Item STRIPPED_MANGROVE_WALL;
    public static final Item STRIPPED_CRIMSON_WALL;
    public static final Item STRIPPED_WARPED_WALL;
    public static final Item STRIPPED_CHERRY_WALL;
    public static final Item OAK_ROPE_LADDER;
    public static final Item SPRUCE_ROPE_LADDER;
    public static final Item BIRCH_ROPE_LADDER;
    public static final Item JUNGLE_ROPE_LADDER;
    public static final Item ACACIA_ROPE_LADDER;
    public static final Item DARK_OAK_ROPE_LADDER;
    public static final Item CRIMSON_ROPE_LADDER;
    public static final Item WARPED_ROPE_LADDER;
    public static final Item MANGROVE_ROPE_LADDER;
    public static final Item CHERRY_ROPE_LADDER;
    public static final Item IRON_LADDER;
    public static final Item SNOW_BRICKS;
    public static final Item SNOW_BRICK_STAIRS;
    public static final Item SNOW_BRICK_SLAB;
    public static final Item SNOW_BRICK_WALL;
    public static final Item PACKED_SNOW;
    public static final Item PACKED_SNOW_STAIRS;
    public static final Item PACKED_SNOW_SLAB;
    public static final Item PACKED_SNOW_WALL;
    public static final Item PURPLE_MUSHROOM;
    public static final Item PURPLE_MUSHROOM_BLOCK;
    public static final Item WOODCUTTER;
    public static final Item WHITE_CAMPFIRE;
    public static final Item ORANGE_CAMPFIRE;
    public static final Item MAGENTA_CAMPFIRE;
    public static final Item LIGHT_BLUE_CAMPFIRE;
    public static final Item YELLOW_CAMPFIRE;
    public static final Item LIME_CAMPFIRE;
    public static final Item PINK_CAMPFIRE;
    public static final Item GRAY_CAMPFIRE;
    public static final Item LIGHT_GRAY_CAMPFIRE;
    public static final Item CYAN_CAMPFIRE;
    public static final Item PURPLE_CAMPFIRE;
    public static final Item BLUE_CAMPFIRE;
    public static final Item BROWN_CAMPFIRE;
    public static final Item GREEN_CAMPFIRE;
    public static final Item RED_CAMPFIRE;
    public static final Item BLACK_CAMPFIRE;
    public static final Item MAROON_CAMPFIRE;
    public static final Item WHITE_LANTERN;
    public static final Item ORANGE_LANTERN;
    public static final Item MAGENTA_LANTERN;
    public static final Item LIGHT_BLUE_LANTERN;
    public static final Item YELLOW_LANTERN;
    public static final Item LIME_LANTERN;
    public static final Item PINK_LANTERN;
    public static final Item GRAY_LANTERN;
    public static final Item LIGHT_GRAY_LANTERN;
    public static final Item CYAN_LANTERN;
    public static final Item PURPLE_LANTERN;
    public static final Item BLUE_LANTERN;
    public static final Item BROWN_LANTERN;
    public static final Item GREEN_LANTERN;
    public static final Item RED_LANTERN;
    public static final Item BLACK_LANTERN;
    public static final Item MAROON_LANTERN;
    public static final Item WHITE_TORCH;
    public static final Item ORANGE_TORCH;
    public static final Item MAGENTA_TORCH;
    public static final Item LIGHT_BLUE_TORCH;
    public static final Item YELLOW_TORCH;
    public static final Item LIME_TORCH;
    public static final Item PINK_TORCH;
    public static final Item GRAY_TORCH;
    public static final Item LIGHT_GRAY_TORCH;
    public static final Item CYAN_TORCH;
    public static final Item PURPLE_TORCH;
    public static final Item BLUE_TORCH;
    public static final Item BROWN_TORCH;
    public static final Item GREEN_TORCH;
    public static final Item RED_TORCH;
    public static final Item BLACK_TORCH;
    public static final Item MAROON_TORCH;
    public static final Item BAUXITE;
    public static final Item BAUXITE_SLAB;
    public static final Item BAUXITE_STAIRS;
    public static final Item BAUXITE_WALL;
    public static final Item BAUXITE_BRICKS;
    public static final Item BAUXITE_BRICK_STAIRS;
    public static final Item BAUXITE_BRICK_SLAB;
    public static final Item BAUXITE_BRICK_WALL;
    public static final Item MOSSY_BAUXITE_BRICKS;
    public static final Item MOSSY_BAUXITE_BRICK_STAIRS;
    public static final Item MOSSY_BAUXITE_BRICK_SLAB;
    public static final Item MOSSY_BAUXITE_BRICK_WALL;
    public static final Item CRACKED_BAUXITE_BRICKS;
    public static final Item CRACKED_BAUXITE_BRICK_STAIRS;
    public static final Item CRACKED_BAUXITE_BRICK_SLAB;
    public static final Item CRACKED_BAUXITE_BRICK_WALL;
    public static final Item TWISTED_NETHER_BRICKS;
    public static final Item TWISTED_NETHER_BRICK_STAIRS;
    public static final Item TWISTED_NETHER_BRICK_SLAB;
    public static final Item TWISTED_NETHER_BRICK_WALL;
    public static final Item TWISTED_NETHERRACK;
    public static final Item TWISTED_NETHERRACK_STAIRS;
    public static final Item TWISTED_NETHERRACK_SLAB;
    public static final Item TWISTED_NETHERRACK_WALL;
    public static final Item WEEPING_NETHER_BRICKS;
    public static final Item WEEPING_NETHER_BRICK_STAIRS;
    public static final Item WEEPING_NETHER_BRICK_SLAB;
    public static final Item WEEPING_NETHER_BRICK_WALL;
    public static final Item WEEPING_NETHERRACK;
    public static final Item WEEPING_NETHERRACK_STAIRS;
    public static final Item WEEPING_NETHERRACK_SLAB;
    public static final Item WEEPING_NETHERRACK_WALL;
    public static final Item SNAPDRAGON;
    public static final Item SHORT_ENDER_GRASS;
    public static final Item CHOCOLATE_CAKE;
    public static final Item RED_VELVET_CAKE;
    public static final Item STONE_TILES;
    public static final Item STONE_TILE_SLAB;
    public static final Item STONE_TILE_STAIRS;
    public static final Item STONE_TILE_WALL;
    public static final Item MOSSY_STONE_TILES;
    public static final Item MOSSY_STONE_TILE_SLAB;
    public static final Item MOSSY_STONE_TILE_STAIRS;
    public static final Item MOSSY_STONE_TILE_WALL;
    public static final Item CRACKED_STONE_TILES;
    public static final Item CRACKED_STONE_TILE_SLAB;
    public static final Item CRACKED_STONE_TILE_STAIRS;
    public static final Item CRACKED_STONE_TILE_WALL;
    public static final Item SWEET_BERRY_PIE;
    public static final Item BLUEBERRY_PIE;
    public static final Item BLACKSTONE_TILES;
    public static final Item BLACKSTONE_TILE_STAIRS;
    public static final Item BLACKSTONE_TILE_SLAB;
    public static final Item BLACKSTONE_TILE_WALL;
    public static final Item TWISTED_BLACKSTONE_TILES;
    public static final Item TWISTED_BLACKSTONE_TILE_STAIRS;
    public static final Item TWISTED_BLACKSTONE_TILE_SLAB;
    public static final Item TWISTED_BLACKSTONE_TILE_WALL;
    public static final Item WEEPING_BLACKSTONE_TILES;
    public static final Item WEEPING_BLACKSTONE_TILE_STAIRS;
    public static final Item WEEPING_BLACKSTONE_TILE_SLAB;
    public static final Item WEEPING_BLACKSTONE_TILE_WALL;
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICKS;
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS;
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB;
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICK_WALL;
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICKS;
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS;
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB;
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICK_WALL;
    public static final Item TWISTED_BLACKSTONE;
    public static final Item TWISTED_BLACKSTONE_STAIRS;
    public static final Item TWISTED_BLACKSTONE_SLAB;
    public static final Item TWISTED_BLACKSTONE_WALL;
    public static final Item WEEPING_BLACKSTONE;
    public static final Item WEEPING_BLACKSTONE_STAIRS;
    public static final Item WEEPING_BLACKSTONE_SLAB;
    public static final Item WEEPING_BLACKSTONE_WALL;
    public static final Item QUARTZ_TILES;
    public static final Item QUARTZ_TILE_STAIRS;
    public static final Item QUARTZ_TILE_SLAB;
    public static final Item QUARTZ_TILE_WALL;
    public static final Item CALCITE_BRICKS;
    public static final Item CALCITE_BRICK_STAIRS;
    public static final Item CALCITE_BRICK_SLAB;
    public static final Item CALCITE_BRICK_WALL;
    public static final Item MOSSY_CALCITE_BRICKS;
    public static final Item MOSSY_CALCITE_BRICK_STAIRS;
    public static final Item MOSSY_CALCITE_BRICK_SLAB;
    public static final Item MOSSY_CALCITE_BRICK_WALL;
    public static final Item CRACKED_CALCITE_BRICKS;
    public static final Item CRACKED_CALCITE_BRICK_STAIRS;
    public static final Item CRACKED_CALCITE_BRICK_SLAB;
    public static final Item CRACKED_CALCITE_BRICK_WALL;
    public static final Item CHISELED_CALCITE_BRICKS;
    public static final Item DRIPSTONE_BRICKS;
    public static final Item DRIPSTONE_BRICK_STAIRS;
    public static final Item DRIPSTONE_BRICK_SLAB;
    public static final Item DRIPSTONE_BRICK_WALL;
    public static final Item MOSSY_DRIPSTONE_BRICKS;
    public static final Item MOSSY_DRIPSTONE_BRICK_STAIRS;
    public static final Item MOSSY_DRIPSTONE_BRICK_SLAB;
    public static final Item MOSSY_DRIPSTONE_BRICK_WALL;
    public static final Item CRACKED_DRIPSTONE_BRICKS;
    public static final Item CRACKED_DRIPSTONE_BRICK_STAIRS;
    public static final Item CRACKED_DRIPSTONE_BRICK_SLAB;
    public static final Item CRACKED_DRIPSTONE_BRICK_WALL;
    public static final Item CHISELED_DRIPSTONE_BRICKS;
    public static final Item GREEN_ONION_SEEDS;
    public static final Item GREEN_ONION;
    public static final Item BLUEBERRIES;
    public static final Item SWEET_BERRY_JUICE;
    public static final Item BLUEBERRY_JUICE;
    public static final Item NOODLES;
    public static final Item NOODLE_SOUP;
    public static final Item PUDDING;
    public static final Item BERRY_PUDDING;
    public static final Item SMOKY_QUARTZ;
    public static final Item CARAMEL_APPLE;
    public static final Item CARAMEL;
    public static final Item SPRUCE_CONE;
    public static final Item FORESTS_BOUNTY;
    public static final Item WITCHS_CRADLE_BRANCH;
    public static final Item WITCHS_CRADLE_SOUP;
    public static final Item CATTAIL;
    public static final Item FRIED_EGG;
    public static final Item BLOOD_KELP_SEED_CLUSTER;
    public static final Item BLOOD_KELP;
    public static final Item DRIED_BLOOD_KELP_BLOCK;
    public static final Item DRIED_BLOOD_KELP;
    public static final Item BLOOD_KELP_LANTERN;
    public static final Item MAROON_WOOL;
    public static final Item MAROON_STAINED_GLASS;
    public static final Item MAROON_STAINED_GLASS_PANE;
    public static final Item MAROON_CANDLE;
    public static final Item MAROON_CONCRETE;
    public static final Item MAROON_CONCRETE_POWDER;
    public static final Item CAMEL_PLUSHIE;
    public static final Item MAROON_DYE;
    public static final Item HOGLIN_STEW;
    public static final Item BOG_BLOSSOM;
    public static final Item CINDERSNAP_BERRIES;
    public static final Item FROSTBITE_BERRIES;
    public static final Item POLISHED_DRIPSTONE;
    public static final Item POLISHED_DRIPSTONE_STAIRS;
    public static final Item POLISHED_DRIPSTONE_SLAB;
    public static final Item POLISHED_DRIPSTONE_WALL;
    public static final Item POLISHED_CALCITE;
    public static final Item POLISHED_CALCITE_STAIRS;
    public static final Item POLISHED_CALCITE_SLAB;
    public static final Item POLISHED_CALCITE_WALL;
    public static final Item DRIPSTONE_STAIRS;
    public static final Item DRIPSTONE_SLAB;
    public static final Item DRIPSTONE_WALL;
    public static final Item CALCITE_STAIRS;
    public static final Item CALCITE_SLAB;
    public static final Item CALCITE_WALL;
    public static final Item BAMBOO_PLANTER_BOX;
    public static final Item STONE_WALL;
    public static final Item QUARTZ_WALL;
    public static final Item SMOOTH_QUARTZ_WALL;
    public static final Item GRASS_SLAB;
    public static final Item PODZOL_SLAB;
    public static final Item MYCELIUM_SLAB;
    public static final Item DIRT_PATH_SLAB;
    public static final Item DIRT_SLAB;
    public static final Item COARSE_DIRT_SLAB;
    public static final Item ROOTED_DIRT_SLAB;
    public static final Item WILD_GREEN_ONIONS;

    private static Item blockItem(Block block) {
        return new BlockItem(block, new Item.Settings());
    }

    private static Item wallStandingBlockItem(Block standingBlock, Block wallBlock) {
        return new VerticallyAttachableBlockItem(standingBlock, wallBlock, new Item.Settings(), Direction.DOWN);
    }

    private static Item ropeLadderBlockItem(Block block) {
        return new RopeLadderBlockItem(block, new Item.Settings());
    }

    /**
     * Register an item using the passed in name.
     * @param path The name of this item.
     * @param item The item to register.
     */
    private static void register(String path, Item item) {
        Registry.register(Registries.ITEM, ADReference.makeModId(path), item);
    }

    /**
     * Register an item block for every block passed in using the identifier of the block.
     * @param blockItems The item blocks to register.
     */
    private static void register(Item... blockItems) {
        for(Item item : blockItems) {
            if(item instanceof BlockItem) {
                Registry.register(Registries.ITEM, Registries.BLOCK.getId(Block.getBlockFromItem(item)), item);
            } else {
                throw new IllegalArgumentException("The passed item must be an ItemBlock");
            }
        }
    }

    /**
     * Called during mod initialization to register every item.
     */
    public static void registerItems() {
        register(BAT_PLUSHIE, BLAZE_PLUSHIE, CAVE_SPIDER_PLUSHIE, CHICKEN_PLUSHIE, COW_PLUSHIE, CREEPER_PLUSHIE,
                ENDERMAN_PLUSHIE, GHAST_PLUSHIE, GUARDIAN_PLUSHIE, WHITE_HORSE_PLUSHIE, GRAY_HORSE_PLUSHIE,
                LIGHT_GRAY_HORSE_PLUSHIE, BROWN_HORSE_PLUSHIE, BLACK_HORSE_PLUSHIE, MAGMA_CUBE_PLUSHIE,
                RED_MOOSHROOM_PLUSHIE, BROWN_MOOSHROOM_PLUSHIE, OCELOT_PLUSHIE, TABBY_CAT_PLUSHIE, TUXEDO_CAT_PLUSHIE,
                RED_CAT_PLUSHIE, SIAMESE_CAT_PLUSHIE, BRITISH_SHORTHAIR_CAT_PLUSHIE, CALICO_CAT_PLUSHIE,
                PERSIAN_CAT_PLUSHIE, RAGDOLL_CAT_PLUSHIE, WHITE_CAT_PLUSHIE, JELLIE_CAT_PLUSHIE, BLACK_CAT_PLUSHIE,
                PIG_PLUSHIE, BROWN_RABBIT_PLUSHIE, WHITE_RABBIT_PLUSHIE, BLACK_RABBIT_PLUSHIE,
                WHITE_SPLOTCHED_RABBIT_PLUSHIE, GOLD_RABBIT_PLUSHIE, TOAST_RABBIT_PLUSHIE, SALT_RABBIT_PLUSHIE,
                WHITE_SHEEP_PLUSHIE, ORANGE_SHEEP_PLUSHIE, MAGENTA_SHEEP_PLUSHIE, LIGHT_BLUE_SHEEP_PLUSHIE,
                YELLOW_SHEEP_PLUSHIE, LIME_SHEEP_PLUSHIE, PINK_SHEEP_PLUSHIE, GRAY_SHEEP_PLUSHIE,
                LIGHT_GRAY_SHEEP_PLUSHIE, CYAN_SHEEP_PLUSHIE, PURPLE_SHEEP_PLUSHIE, BLUE_SHEEP_PLUSHIE,
                BROWN_SHEEP_PLUSHIE, GREEN_SHEEP_PLUSHIE, RED_SHEEP_PLUSHIE, BLACK_SHEEP_PLUSHIE, MAROON_SHEEP_PLUSHIE,
                SKELETON_PLUSHIE, SLIME_PLUSHIE, SPIDER_PLUSHIE, SQUID_PLUSHIE, GLOW_SQUID_PLUSHIE, BEE_PLUSHIE,
                PLAINS_VILLAGER_PLUSHIE, DESERT_VILLAGER_PLUSHIE, JUNGLE_VILLAGER_PLUSHIE, SAVANNA_VILLAGER_PLUSHIE,
                SNOW_VILLAGER_PLUSHIE, SWAMP_VILLAGER_PLUSHIE, TAIGA_VILLAGER_PLUSHIE, CRIMSON_VILLAGER_PLUSHIE,
                WARPED_VILLAGER_PLUSHIE, WANDERING_TRADER_PLUSHIE, PLAINS_ZOMBIE_VILLAGER_PLUSHIE,
                DESERT_ZOMBIE_VILLAGER_PLUSHIE, JUNGLE_ZOMBIE_VILLAGER_PLUSHIE, SAVANNA_ZOMBIE_VILLAGER_PLUSHIE,
                SNOW_ZOMBIE_VILLAGER_PLUSHIE, SWAMP_ZOMBIE_VILLAGER_PLUSHIE, TAIGA_ZOMBIE_VILLAGER_PLUSHIE,
                CRIMSON_ZOMBIE_VILLAGER_PLUSHIE, WARPED_ZOMBIE_VILLAGER_PLUSHIE, WITCH_PLUSHIE, PALE_WOLF_PLUSHIE,
                ZOMBIE_PLUSHIE, PIGLIN_PLUSHIE, ZOMBIFIED_PIGLIN_PLUSHIE, PUFFERFISH_PLUSHIE, WITHER_PLUSHIE,
                STRIDER_PLUSHIE, SHIVERING_STRIDER_PLUSHIE, PHANTOM_PLUSHIE, HOGLIN_PLUSHIE, ZOGLIN_PLUSHIE,
                POLAR_BEAR_PLUSHIE, ALLAY_PLUSHIE, PILLAGER_PLUSHIE, VINDICATOR_PLUSHIE, EVOKER_PLUSHIE,
                RAVAGER_PLUSHIE, SHULKER_PLUSHIE, VEX_PLUSHIE, NETHER_SMOKY_QUARTZ_ORE, SMOKY_QUARTZ_BLOCK,
                CHISELED_SMOKY_QUARTZ_BLOCK, SMOKY_QUARTZ_BRICKS, SMOKY_QUARTZ_BRICK_STAIRS, SMOKY_QUARTZ_BRICK_SLAB,
                SMOKY_QUARTZ_BRICK_WALL, SMOKY_QUARTZ_PILLAR, SMOKY_QUARTZ_STAIRS, SMOKY_QUARTZ_SLAB, SMOKY_QUARTZ_WALL,
                SMOOTH_SMOKY_QUARTZ, SMOOTH_SMOKY_QUARTZ_STAIRS, SMOOTH_SMOKY_QUARTZ_SLAB, SMOOTH_SMOKY_QUARTZ_WALL,
                CRACKED_STONE_BRICK_STAIRS, CRACKED_STONE_BRICK_SLAB, CRACKED_STONE_BRICK_WALL, OAK_PLANTER_BOX,
                SPRUCE_PLANTER_BOX, BIRCH_PLANTER_BOX, JUNGLE_PLANTER_BOX, ACACIA_PLANTER_BOX, DARK_OAK_PLANTER_BOX,
                MANGROVE_PLANTER_BOX, CHERRY_PLANTER_BOX, CRIMSON_PLANTER_BOX, WARPED_PLANTER_BOX, OAK_WALL,
                SPRUCE_WALL, BIRCH_WALL, JUNGLE_WALL, ACACIA_WALL, DARK_OAK_WALL, MANGROVE_WALL, CRIMSON_WALL,
                WARPED_WALL, CHERRY_WALL, STRIPPED_OAK_WALL, STRIPPED_SPRUCE_WALL, STRIPPED_BIRCH_WALL,
                STRIPPED_JUNGLE_WALL, STRIPPED_ACACIA_WALL, STRIPPED_DARK_OAK_WALL, STRIPPED_MANGROVE_WALL,
                STRIPPED_CRIMSON_WALL, STRIPPED_WARPED_WALL, STRIPPED_CHERRY_WALL, OAK_ROPE_LADDER,
                SPRUCE_ROPE_LADDER, BIRCH_ROPE_LADDER, JUNGLE_ROPE_LADDER, ACACIA_ROPE_LADDER, DARK_OAK_ROPE_LADDER,
                CRIMSON_ROPE_LADDER, WARPED_ROPE_LADDER, MANGROVE_ROPE_LADDER, CHERRY_ROPE_LADDER, IRON_LADDER,
                SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL, PACKED_SNOW, PACKED_SNOW_STAIRS,
                PACKED_SNOW_SLAB, PACKED_SNOW_WALL, PURPLE_MUSHROOM, PURPLE_MUSHROOM_BLOCK, WOODCUTTER,
                WHITE_CAMPFIRE, ORANGE_CAMPFIRE, MAGENTA_CAMPFIRE, LIGHT_BLUE_CAMPFIRE, YELLOW_CAMPFIRE,
                LIME_CAMPFIRE, PINK_CAMPFIRE, GRAY_CAMPFIRE, LIGHT_GRAY_CAMPFIRE, CYAN_CAMPFIRE,
                PURPLE_CAMPFIRE, BLUE_CAMPFIRE, BROWN_CAMPFIRE, GREEN_CAMPFIRE, RED_CAMPFIRE, BLACK_CAMPFIRE,
                MAROON_CAMPFIRE, WHITE_LANTERN, ORANGE_LANTERN, MAGENTA_LANTERN, LIGHT_BLUE_LANTERN, YELLOW_LANTERN,
                LIME_LANTERN, PINK_LANTERN, GRAY_LANTERN, LIGHT_GRAY_LANTERN, CYAN_LANTERN, PURPLE_LANTERN,
                BLUE_LANTERN, BROWN_LANTERN, GREEN_LANTERN, RED_LANTERN, BLACK_LANTERN, MAROON_LANTERN, WHITE_TORCH,
                ORANGE_TORCH, MAGENTA_TORCH, LIGHT_BLUE_TORCH, YELLOW_TORCH, LIME_TORCH, PINK_TORCH, GRAY_TORCH,
                LIGHT_GRAY_TORCH, CYAN_TORCH, PURPLE_TORCH, BLUE_TORCH, BROWN_TORCH, GREEN_TORCH, RED_TORCH,
                BLACK_TORCH, MAROON_TORCH, BAUXITE, BAUXITE_SLAB, BAUXITE_STAIRS, BAUXITE_WALL, BAUXITE_BRICKS,
                BAUXITE_BRICK_STAIRS, BAUXITE_BRICK_SLAB, BAUXITE_BRICK_WALL, MOSSY_BAUXITE_BRICKS,
                MOSSY_BAUXITE_BRICK_STAIRS, MOSSY_BAUXITE_BRICK_SLAB, MOSSY_BAUXITE_BRICK_WALL,
                CRACKED_BAUXITE_BRICKS, CRACKED_BAUXITE_BRICK_STAIRS, CRACKED_BAUXITE_BRICK_SLAB,
                CRACKED_BAUXITE_BRICK_WALL, TWISTED_NETHER_BRICKS, TWISTED_NETHER_BRICK_STAIRS,
                TWISTED_NETHER_BRICK_SLAB, TWISTED_NETHER_BRICK_WALL, TWISTED_NETHERRACK, TWISTED_NETHERRACK_STAIRS,
                TWISTED_NETHERRACK_SLAB, TWISTED_NETHERRACK_WALL, WEEPING_NETHER_BRICKS, WEEPING_NETHER_BRICK_STAIRS,
                WEEPING_NETHER_BRICK_SLAB, WEEPING_NETHER_BRICK_WALL, WEEPING_NETHERRACK, WEEPING_NETHERRACK_STAIRS,
                WEEPING_NETHERRACK_SLAB, WEEPING_NETHERRACK_WALL, SNAPDRAGON, SHORT_ENDER_GRASS, CHOCOLATE_CAKE,
                RED_VELVET_CAKE, STONE_TILES, STONE_TILE_SLAB, STONE_TILE_STAIRS, STONE_TILE_WALL, MOSSY_STONE_TILES,
                MOSSY_STONE_TILE_SLAB, MOSSY_STONE_TILE_STAIRS, MOSSY_STONE_TILE_WALL, CRACKED_STONE_TILES,
                CRACKED_STONE_TILE_SLAB, CRACKED_STONE_TILE_STAIRS, CRACKED_STONE_TILE_WALL, SWEET_BERRY_PIE,
                BLUEBERRY_PIE, BLACKSTONE_TILES, BLACKSTONE_TILE_STAIRS, BLACKSTONE_TILE_SLAB, BLACKSTONE_TILE_WALL,
                TWISTED_BLACKSTONE_TILES, TWISTED_BLACKSTONE_TILE_STAIRS, TWISTED_BLACKSTONE_TILE_SLAB,
                TWISTED_BLACKSTONE_TILE_WALL, WEEPING_BLACKSTONE_TILES, WEEPING_BLACKSTONE_TILE_STAIRS,
                WEEPING_BLACKSTONE_TILE_SLAB, WEEPING_BLACKSTONE_TILE_WALL, TWISTED_POLISHED_BLACKSTONE_BRICKS,
                TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS, TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB,
                TWISTED_POLISHED_BLACKSTONE_BRICK_WALL, WEEPING_POLISHED_BLACKSTONE_BRICKS,
                WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS, WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB,
                WEEPING_POLISHED_BLACKSTONE_BRICK_WALL, TWISTED_BLACKSTONE, TWISTED_BLACKSTONE_STAIRS,
                TWISTED_BLACKSTONE_SLAB, TWISTED_BLACKSTONE_WALL, WEEPING_BLACKSTONE, WEEPING_BLACKSTONE_STAIRS,
                WEEPING_BLACKSTONE_SLAB, WEEPING_BLACKSTONE_WALL, QUARTZ_TILES, QUARTZ_TILE_STAIRS, QUARTZ_TILE_SLAB,
                QUARTZ_TILE_WALL, CALCITE_BRICKS, CALCITE_BRICK_STAIRS, CALCITE_BRICK_SLAB, CALCITE_BRICK_WALL,
                MOSSY_CALCITE_BRICKS, MOSSY_CALCITE_BRICK_STAIRS, MOSSY_CALCITE_BRICK_SLAB, MOSSY_CALCITE_BRICK_WALL,
                CRACKED_CALCITE_BRICKS, CRACKED_CALCITE_BRICK_STAIRS, CRACKED_CALCITE_BRICK_SLAB,
                CRACKED_CALCITE_BRICK_WALL, CHISELED_CALCITE_BRICKS, DRIPSTONE_BRICKS, DRIPSTONE_BRICK_STAIRS,
                DRIPSTONE_BRICK_SLAB, DRIPSTONE_BRICK_WALL, MOSSY_DRIPSTONE_BRICKS, MOSSY_DRIPSTONE_BRICK_STAIRS,
                MOSSY_DRIPSTONE_BRICK_SLAB, MOSSY_DRIPSTONE_BRICK_WALL, CRACKED_DRIPSTONE_BRICKS,
                CRACKED_DRIPSTONE_BRICK_STAIRS, CRACKED_DRIPSTONE_BRICK_SLAB, CRACKED_DRIPSTONE_BRICK_WALL,
                CHISELED_DRIPSTONE_BRICKS, CATTAIL, DRIED_BLOOD_KELP_BLOCK, BLOOD_KELP_LANTERN, CAMEL_PLUSHIE,
                MAROON_WOOL, MAROON_STAINED_GLASS, MAROON_STAINED_GLASS_PANE, MAROON_CANDLE, MAROON_CONCRETE,
                MAROON_CONCRETE_POWDER, POLISHED_DRIPSTONE, POLISHED_DRIPSTONE_STAIRS, POLISHED_DRIPSTONE_SLAB,
                POLISHED_DRIPSTONE_WALL, POLISHED_CALCITE, POLISHED_CALCITE_STAIRS, POLISHED_CALCITE_SLAB,
                POLISHED_CALCITE_WALL, DRIPSTONE_STAIRS, DRIPSTONE_SLAB, DRIPSTONE_WALL, CALCITE_STAIRS,
                CALCITE_SLAB, CALCITE_WALL, BAMBOO_PLANTER_BOX, BOG_BLOSSOM, STONE_WALL, QUARTZ_WALL,
                SMOOTH_QUARTZ_WALL, GRASS_SLAB, PODZOL_SLAB, MYCELIUM_SLAB, DIRT_PATH_SLAB, DIRT_SLAB,
                COARSE_DIRT_SLAB, ROOTED_DIRT_SLAB, WILD_GREEN_ONIONS);
        register("green_onion_seeds", GREEN_ONION_SEEDS);
        register("green_onion", GREEN_ONION);
        register("blueberries", BLUEBERRIES);
        register("sweet_berry_juice", SWEET_BERRY_JUICE);
        register("blueberry_juice", BLUEBERRY_JUICE);
        register("noodles", NOODLES);
        register("noodle_soup", NOODLE_SOUP);
        register("pudding", PUDDING);
        register("berry_pudding", BERRY_PUDDING);
        register("smoky_quartz", SMOKY_QUARTZ);
        register("caramel_apple", CARAMEL_APPLE);
        register("caramel", CARAMEL);
        register("spruce_cone", SPRUCE_CONE);
        register("forests_bounty", FORESTS_BOUNTY);
        register("witchs_cradle_branch", WITCHS_CRADLE_BRANCH);
        register("witchs_cradle_soup", WITCHS_CRADLE_SOUP);
        register("fried_egg", FRIED_EGG);
        register("blood_kelp_seed_cluster", BLOOD_KELP_SEED_CLUSTER);
        register("blood_kelp", BLOOD_KELP);
        register("dried_blood_kelp", DRIED_BLOOD_KELP);
        register("maroon_dye", MAROON_DYE);
        register("hoglin_stew", HOGLIN_STEW);
        register("cindersnap_berries", CINDERSNAP_BERRIES);
        register("frostbite_berries", FROSTBITE_BERRIES);

        AssortedDiscoveries.LOGGER.info("Registered Items");
    }

    static {
        BAT_PLUSHIE = blockItem(ModBlocks.BAT_PLUSHIE);
        BLAZE_PLUSHIE = blockItem(ModBlocks.BLAZE_PLUSHIE);
        CAVE_SPIDER_PLUSHIE = blockItem(ModBlocks.CAVE_SPIDER_PLUSHIE);
        CHICKEN_PLUSHIE = blockItem(ModBlocks.CHICKEN_PLUSHIE);
        COW_PLUSHIE = blockItem(ModBlocks.COW_PLUSHIE);
        CREEPER_PLUSHIE = blockItem(ModBlocks.CREEPER_PLUSHIE);
        ENDERMAN_PLUSHIE = blockItem(ModBlocks.ENDERMAN_PLUSHIE);
        GHAST_PLUSHIE = blockItem(ModBlocks.GHAST_PLUSHIE);
        GUARDIAN_PLUSHIE = blockItem(ModBlocks.GUARDIAN_PLUSHIE);
        WHITE_HORSE_PLUSHIE = blockItem(ModBlocks.WHITE_HORSE_PLUSHIE);
        GRAY_HORSE_PLUSHIE = blockItem(ModBlocks.GRAY_HORSE_PLUSHIE);
        LIGHT_GRAY_HORSE_PLUSHIE = blockItem(ModBlocks.LIGHT_GRAY_HORSE_PLUSHIE);
        BROWN_HORSE_PLUSHIE = blockItem(ModBlocks.BROWN_HORSE_PLUSHIE);
        BLACK_HORSE_PLUSHIE = blockItem(ModBlocks.BLACK_HORSE_PLUSHIE);
        MAGMA_CUBE_PLUSHIE = blockItem(ModBlocks.MAGMA_CUBE_PLUSHIE);
        RED_MOOSHROOM_PLUSHIE = blockItem(ModBlocks.RED_MOOSHROOM_PLUSHIE);
        BROWN_MOOSHROOM_PLUSHIE = blockItem(ModBlocks.BROWN_MOOSHROOM_PLUSHIE);
        OCELOT_PLUSHIE = blockItem(ModBlocks.OCELOT_PLUSHIE);
        TABBY_CAT_PLUSHIE = blockItem(ModBlocks.TABBY_CAT_PLUSHIE);
        TUXEDO_CAT_PLUSHIE = blockItem(ModBlocks.TUXEDO_CAT_PLUSHIE);
        RED_CAT_PLUSHIE = blockItem(ModBlocks.RED_CAT_PLUSHIE);
        SIAMESE_CAT_PLUSHIE = blockItem(ModBlocks.SIAMESE_CAT_PLUSHIE);
        BRITISH_SHORTHAIR_CAT_PLUSHIE = blockItem(ModBlocks.BRITISH_SHORTHAIR_CAT_PLUSHIE);
        CALICO_CAT_PLUSHIE = blockItem(ModBlocks.CALICO_CAT_PLUSHIE);
        PERSIAN_CAT_PLUSHIE = blockItem(ModBlocks.PERSIAN_CAT_PLUSHIE);
        RAGDOLL_CAT_PLUSHIE = blockItem(ModBlocks.RAGDOLL_CAT_PLUSHIE);
        WHITE_CAT_PLUSHIE = blockItem(ModBlocks.WHITE_CAT_PLUSHIE);
        JELLIE_CAT_PLUSHIE = blockItem(ModBlocks.JELLIE_CAT_PLUSHIE);
        BLACK_CAT_PLUSHIE = blockItem(ModBlocks.BLACK_CAT_PLUSHIE);
        PIG_PLUSHIE = blockItem(ModBlocks.PIG_PLUSHIE);
        BROWN_RABBIT_PLUSHIE = blockItem(ModBlocks.BROWN_RABBIT_PLUSHIE);
        WHITE_RABBIT_PLUSHIE = blockItem(ModBlocks.WHITE_RABBIT_PLUSHIE);
        BLACK_RABBIT_PLUSHIE = blockItem(ModBlocks.BLACK_RABBIT_PLUSHIE);
        WHITE_SPLOTCHED_RABBIT_PLUSHIE = blockItem(ModBlocks.WHITE_SPLOTCHED_RABBIT_PLUSHIE);
        GOLD_RABBIT_PLUSHIE = blockItem(ModBlocks.GOLD_RABBIT_PLUSHIE);
        TOAST_RABBIT_PLUSHIE = blockItem(ModBlocks.TOAST_RABBIT_PLUSHIE);
        SALT_RABBIT_PLUSHIE = blockItem(ModBlocks.SALT_RABBIT_PLUSHIE);
        WHITE_SHEEP_PLUSHIE = blockItem(ModBlocks.WHITE_SHEEP_PLUSHIE);
        ORANGE_SHEEP_PLUSHIE = blockItem(ModBlocks.ORANGE_SHEEP_PLUSHIE);
        MAGENTA_SHEEP_PLUSHIE = blockItem(ModBlocks.MAGENTA_SHEEP_PLUSHIE);
        LIGHT_BLUE_SHEEP_PLUSHIE = blockItem(ModBlocks.LIGHT_BLUE_SHEEP_PLUSHIE);
        YELLOW_SHEEP_PLUSHIE = blockItem(ModBlocks.YELLOW_SHEEP_PLUSHIE);
        LIME_SHEEP_PLUSHIE = blockItem(ModBlocks.LIME_SHEEP_PLUSHIE);
        PINK_SHEEP_PLUSHIE = blockItem(ModBlocks.PINK_SHEEP_PLUSHIE);
        GRAY_SHEEP_PLUSHIE = blockItem(ModBlocks.GRAY_SHEEP_PLUSHIE);
        LIGHT_GRAY_SHEEP_PLUSHIE = blockItem(ModBlocks.LIGHT_GRAY_SHEEP_PLUSHIE);
        CYAN_SHEEP_PLUSHIE = blockItem(ModBlocks.CYAN_SHEEP_PLUSHIE);
        PURPLE_SHEEP_PLUSHIE = blockItem(ModBlocks.PURPLE_SHEEP_PLUSHIE);
        BLUE_SHEEP_PLUSHIE = blockItem(ModBlocks.BLUE_SHEEP_PLUSHIE);
        BROWN_SHEEP_PLUSHIE = blockItem(ModBlocks.BROWN_SHEEP_PLUSHIE);
        GREEN_SHEEP_PLUSHIE = blockItem(ModBlocks.GREEN_SHEEP_PLUSHIE);
        RED_SHEEP_PLUSHIE = blockItem(ModBlocks.RED_SHEEP_PLUSHIE);
        BLACK_SHEEP_PLUSHIE = blockItem(ModBlocks.BLACK_SHEEP_PLUSHIE);
        MAROON_SHEEP_PLUSHIE = blockItem(ModBlocks.MAROON_SHEEP_PLUSHIE);
        SKELETON_PLUSHIE = blockItem(ModBlocks.SKELETON_PLUSHIE);
        SLIME_PLUSHIE = blockItem(ModBlocks.SLIME_PLUSHIE);
        SPIDER_PLUSHIE = blockItem(ModBlocks.SPIDER_PLUSHIE);
        SQUID_PLUSHIE = blockItem(ModBlocks.SQUID_PLUSHIE);
        GLOW_SQUID_PLUSHIE = blockItem(ModBlocks.GLOW_SQUID_PLUSHIE);
        BEE_PLUSHIE = blockItem(ModBlocks.BEE_PLUSHIE);
        PLAINS_VILLAGER_PLUSHIE = blockItem(ModBlocks.PLAINS_VILLAGER_PLUSHIE);
        DESERT_VILLAGER_PLUSHIE = blockItem(ModBlocks.DESERT_VILLAGER_PLUSHIE);
        JUNGLE_VILLAGER_PLUSHIE = blockItem(ModBlocks.JUNGLE_VILLAGER_PLUSHIE);
        SAVANNA_VILLAGER_PLUSHIE = blockItem(ModBlocks.SAVANNA_VILLAGER_PLUSHIE);
        SNOW_VILLAGER_PLUSHIE = blockItem(ModBlocks.SNOW_VILLAGER_PLUSHIE);
        SWAMP_VILLAGER_PLUSHIE = blockItem(ModBlocks.SWAMP_VILLAGER_PLUSHIE);
        TAIGA_VILLAGER_PLUSHIE = blockItem(ModBlocks.TAIGA_VILLAGER_PLUSHIE);
        CRIMSON_VILLAGER_PLUSHIE = blockItem(ModBlocks.CRIMSON_VILLAGER_PLUSHIE);
        WARPED_VILLAGER_PLUSHIE = blockItem(ModBlocks.WARPED_VILLAGER_PLUSHIE);
        WANDERING_TRADER_PLUSHIE = blockItem(ModBlocks.WANDERING_TRADER_PLUSHIE);
        PLAINS_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.PLAINS_ZOMBIE_VILLAGER_PLUSHIE);
        DESERT_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.DESERT_ZOMBIE_VILLAGER_PLUSHIE);
        JUNGLE_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.JUNGLE_ZOMBIE_VILLAGER_PLUSHIE);
        SAVANNA_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.SAVANNA_ZOMBIE_VILLAGER_PLUSHIE);
        SNOW_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.SNOW_ZOMBIE_VILLAGER_PLUSHIE);
        SWAMP_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.SWAMP_ZOMBIE_VILLAGER_PLUSHIE);
        TAIGA_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.TAIGA_ZOMBIE_VILLAGER_PLUSHIE);
        CRIMSON_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.CRIMSON_ZOMBIE_VILLAGER_PLUSHIE);
        WARPED_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ModBlocks.WARPED_ZOMBIE_VILLAGER_PLUSHIE);
        WITCH_PLUSHIE = blockItem(ModBlocks.WITCH_PLUSHIE);
        PALE_WOLF_PLUSHIE = blockItem(ModBlocks.PALE_WOLF_PLUSHIE);
        ZOMBIE_PLUSHIE = blockItem(ModBlocks.ZOMBIE_PLUSHIE);
        PIGLIN_PLUSHIE = blockItem(ModBlocks.PIGLIN_PLUSHIE);
        ZOMBIFIED_PIGLIN_PLUSHIE = blockItem(ModBlocks.ZOMBIFIED_PIGLIN_PLUSHIE);
        PUFFERFISH_PLUSHIE = blockItem(ModBlocks.PUFFERFISH_PLUSHIE);
        WITHER_PLUSHIE = blockItem(ModBlocks.WITHER_PLUSHIE);
        STRIDER_PLUSHIE = blockItem(ModBlocks.STRIDER_PLUSHIE);
        SHIVERING_STRIDER_PLUSHIE = blockItem(ModBlocks.SHIVERING_STRIDER_PLUSHIE);
        PHANTOM_PLUSHIE = blockItem(ModBlocks.PHANTOM_PLUSHIE);
        HOGLIN_PLUSHIE = blockItem(ModBlocks.HOGLIN_PLUSHIE);
        ZOGLIN_PLUSHIE = blockItem(ModBlocks.ZOGLIN_PLUSHIE);
        POLAR_BEAR_PLUSHIE = blockItem(ModBlocks.POLAR_BEAR_PLUSHIE);
        ALLAY_PLUSHIE = blockItem(ModBlocks.ALLAY_PLUSHIE);
        PILLAGER_PLUSHIE = blockItem(ModBlocks.PILLAGER_PLUSHIE);
        VINDICATOR_PLUSHIE = blockItem(ModBlocks.VINDICATOR_PLUSHIE);
        EVOKER_PLUSHIE = blockItem(ModBlocks.EVOKER_PLUSHIE);
        RAVAGER_PLUSHIE = blockItem(ModBlocks.RAVAGER_PLUSHIE);
        SHULKER_PLUSHIE = blockItem(ModBlocks.SHULKER_PLUSHIE);
        VEX_PLUSHIE = blockItem(ModBlocks.VEX_PLUSHIE);
        NETHER_SMOKY_QUARTZ_ORE = blockItem(ModBlocks.NETHER_SMOKY_QUARTZ_ORE);
        SMOKY_QUARTZ_BLOCK = blockItem(ModBlocks.SMOKY_QUARTZ_BLOCK);
        CHISELED_SMOKY_QUARTZ_BLOCK = blockItem(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        SMOKY_QUARTZ_BRICKS = blockItem(ModBlocks.SMOKY_QUARTZ_BRICKS);
        SMOKY_QUARTZ_BRICK_STAIRS = blockItem(ModBlocks.SMOKY_QUARTZ_BRICK_STAIRS);
        SMOKY_QUARTZ_BRICK_SLAB = blockItem(ModBlocks.SMOKY_QUARTZ_BRICK_SLAB);
        SMOKY_QUARTZ_BRICK_WALL = blockItem(ModBlocks.SMOKY_QUARTZ_BRICK_WALL);
        SMOKY_QUARTZ_PILLAR = blockItem(ModBlocks.SMOKY_QUARTZ_PILLAR);
        SMOKY_QUARTZ_STAIRS = blockItem(ModBlocks.SMOKY_QUARTZ_STAIRS);
        SMOKY_QUARTZ_SLAB = blockItem(ModBlocks.SMOKY_QUARTZ_SLAB);
        SMOKY_QUARTZ_WALL = blockItem(ModBlocks.SMOKY_QUARTZ_WALL);
        SMOOTH_SMOKY_QUARTZ = blockItem(ModBlocks.SMOOTH_SMOKY_QUARTZ);
        SMOOTH_SMOKY_QUARTZ_STAIRS = blockItem(ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
        SMOOTH_SMOKY_QUARTZ_SLAB = blockItem(ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB);
        SMOOTH_SMOKY_QUARTZ_WALL = blockItem(ModBlocks.SMOOTH_SMOKY_QUARTZ_WALL);
        CRACKED_STONE_BRICK_STAIRS = blockItem(ModBlocks.CRACKED_STONE_BRICK_STAIRS);
        CRACKED_STONE_BRICK_SLAB = blockItem(ModBlocks.CRACKED_STONE_BRICK_SLAB);
        CRACKED_STONE_BRICK_WALL = blockItem(ModBlocks.CRACKED_STONE_BRICK_WALL);
        OAK_PLANTER_BOX = blockItem(ModBlocks.OAK_PLANTER_BOX);
        SPRUCE_PLANTER_BOX = blockItem(ModBlocks.SPRUCE_PLANTER_BOX);
        BIRCH_PLANTER_BOX = blockItem(ModBlocks.BIRCH_PLANTER_BOX);
        JUNGLE_PLANTER_BOX = blockItem(ModBlocks.JUNGLE_PLANTER_BOX);
        ACACIA_PLANTER_BOX = blockItem(ModBlocks.ACACIA_PLANTER_BOX);
        DARK_OAK_PLANTER_BOX = blockItem(ModBlocks.DARK_OAK_PLANTER_BOX);
        MANGROVE_PLANTER_BOX = blockItem(ModBlocks.MANGROVE_PLANTER_BOX);
        CHERRY_PLANTER_BOX = blockItem(ModBlocks.CHERRY_PLANTER_BOX);
        CRIMSON_PLANTER_BOX = blockItem(ModBlocks.CRIMSON_PLANTER_BOX);
        WARPED_PLANTER_BOX = blockItem(ModBlocks.WARPED_PLANTER_BOX);
        OAK_WALL = blockItem(ModBlocks.OAK_WALL);
        SPRUCE_WALL = blockItem(ModBlocks.SPRUCE_WALL);
        BIRCH_WALL = blockItem(ModBlocks.BIRCH_WALL);
        JUNGLE_WALL = blockItem(ModBlocks.JUNGLE_WALL);
        ACACIA_WALL = blockItem(ModBlocks.ACACIA_WALL);
        DARK_OAK_WALL = blockItem(ModBlocks.DARK_OAK_WALL);
        MANGROVE_WALL = blockItem(ModBlocks.MANGROVE_WALL);
        CRIMSON_WALL = blockItem(ModBlocks.CRIMSON_WALL);
        WARPED_WALL = blockItem(ModBlocks.WARPED_WALL);
        CHERRY_WALL = blockItem(ModBlocks.CHERRY_WALL);
        STRIPPED_OAK_WALL = blockItem(ModBlocks.STRIPPED_OAK_WALL);
        STRIPPED_SPRUCE_WALL = blockItem(ModBlocks.STRIPPED_SPRUCE_WALL);
        STRIPPED_BIRCH_WALL = blockItem(ModBlocks.STRIPPED_BIRCH_WALL);
        STRIPPED_JUNGLE_WALL = blockItem(ModBlocks.STRIPPED_JUNGLE_WALL);
        STRIPPED_ACACIA_WALL = blockItem(ModBlocks.STRIPPED_ACACIA_WALL);
        STRIPPED_DARK_OAK_WALL = blockItem(ModBlocks.STRIPPED_DARK_OAK_WALL);
        STRIPPED_MANGROVE_WALL = blockItem(ModBlocks.STRIPPED_MANGROVE_WALL);
        STRIPPED_CRIMSON_WALL = blockItem(ModBlocks.STRIPPED_CRIMSON_WALL);
        STRIPPED_WARPED_WALL = blockItem(ModBlocks.STRIPPED_WARPED_WALL);
        STRIPPED_CHERRY_WALL = blockItem(ModBlocks.STRIPPED_CHERRY_WALL);
        OAK_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.OAK_ROPE_LADDER);
        SPRUCE_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.SPRUCE_ROPE_LADDER);
        BIRCH_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.BIRCH_ROPE_LADDER);
        JUNGLE_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.JUNGLE_ROPE_LADDER);
        ACACIA_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.ACACIA_ROPE_LADDER);
        DARK_OAK_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.DARK_OAK_ROPE_LADDER);
        CRIMSON_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.CRIMSON_ROPE_LADDER);
        WARPED_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.WARPED_ROPE_LADDER);
        MANGROVE_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.MANGROVE_ROPE_LADDER);
        CHERRY_ROPE_LADDER = ropeLadderBlockItem(ModBlocks.CHERRY_ROPE_LADDER);
        IRON_LADDER = blockItem(ModBlocks.IRON_LADDER);
        SNOW_BRICKS = blockItem(ModBlocks.SNOW_BRICKS);
        SNOW_BRICK_STAIRS = blockItem(ModBlocks.SNOW_BRICK_STAIRS);
        SNOW_BRICK_SLAB = blockItem(ModBlocks.SNOW_BRICK_SLAB);
        SNOW_BRICK_WALL = blockItem(ModBlocks.SNOW_BRICK_WALL);
        PACKED_SNOW = blockItem(ModBlocks.PACKED_SNOW);
        PACKED_SNOW_STAIRS = blockItem(ModBlocks.PACKED_SNOW_STAIRS);
        PACKED_SNOW_SLAB = blockItem(ModBlocks.PACKED_SNOW_SLAB);
        PACKED_SNOW_WALL = blockItem(ModBlocks.PACKED_SNOW_WALL);
        PURPLE_MUSHROOM = blockItem(ModBlocks.PURPLE_MUSHROOM);
        PURPLE_MUSHROOM_BLOCK = blockItem(ModBlocks.PURPLE_MUSHROOM_BLOCK);
        WOODCUTTER = blockItem(ModBlocks.WOODCUTTER);
        WHITE_CAMPFIRE = blockItem(ModBlocks.WHITE_CAMPFIRE);
        ORANGE_CAMPFIRE = blockItem(ModBlocks.ORANGE_CAMPFIRE);
        MAGENTA_CAMPFIRE = blockItem(ModBlocks.MAGENTA_CAMPFIRE);
        LIGHT_BLUE_CAMPFIRE = blockItem(ModBlocks.LIGHT_BLUE_CAMPFIRE);
        YELLOW_CAMPFIRE = blockItem(ModBlocks.YELLOW_CAMPFIRE);
        LIME_CAMPFIRE = blockItem(ModBlocks.LIME_CAMPFIRE);
        PINK_CAMPFIRE = blockItem(ModBlocks.PINK_CAMPFIRE);
        GRAY_CAMPFIRE = blockItem(ModBlocks.GRAY_CAMPFIRE);
        LIGHT_GRAY_CAMPFIRE = blockItem(ModBlocks.LIGHT_GRAY_CAMPFIRE);
        CYAN_CAMPFIRE = blockItem(ModBlocks.CYAN_CAMPFIRE);
        PURPLE_CAMPFIRE = blockItem(ModBlocks.PURPLE_CAMPFIRE);
        BLUE_CAMPFIRE = blockItem(ModBlocks.BLUE_CAMPFIRE);
        BROWN_CAMPFIRE = blockItem(ModBlocks.BROWN_CAMPFIRE);
        GREEN_CAMPFIRE = blockItem(ModBlocks.GREEN_CAMPFIRE);
        RED_CAMPFIRE = blockItem(ModBlocks.RED_CAMPFIRE);
        BLACK_CAMPFIRE = blockItem(ModBlocks.BLACK_CAMPFIRE);
        MAROON_CAMPFIRE = blockItem(ModBlocks.MAROON_CAMPFIRE);
        WHITE_LANTERN = blockItem(ModBlocks.WHITE_LANTERN);
        ORANGE_LANTERN = blockItem(ModBlocks.ORANGE_LANTERN);
        MAGENTA_LANTERN = blockItem(ModBlocks.MAGENTA_LANTERN);
        LIGHT_BLUE_LANTERN = blockItem(ModBlocks.LIGHT_BLUE_LANTERN);
        YELLOW_LANTERN = blockItem(ModBlocks.YELLOW_LANTERN);
        LIME_LANTERN = blockItem(ModBlocks.LIME_LANTERN);
        PINK_LANTERN = blockItem(ModBlocks.PINK_LANTERN);
        GRAY_LANTERN = blockItem(ModBlocks.GRAY_LANTERN);
        LIGHT_GRAY_LANTERN = blockItem(ModBlocks.LIGHT_GRAY_LANTERN);
        CYAN_LANTERN = blockItem(ModBlocks.CYAN_LANTERN);
        PURPLE_LANTERN = blockItem(ModBlocks.PURPLE_LANTERN);
        BLUE_LANTERN = blockItem(ModBlocks.BLUE_LANTERN);
        BROWN_LANTERN = blockItem(ModBlocks.BROWN_LANTERN);
        GREEN_LANTERN = blockItem(ModBlocks.GREEN_LANTERN);
        RED_LANTERN = blockItem(ModBlocks.RED_LANTERN);
        BLACK_LANTERN = blockItem(ModBlocks.BLACK_LANTERN);
        MAROON_LANTERN = blockItem(ModBlocks.MAROON_LANTERN);
        WHITE_TORCH = wallStandingBlockItem(ModBlocks.WHITE_TORCH, ModBlocks.WHITE_WALL_TORCH);
        ORANGE_TORCH = wallStandingBlockItem(ModBlocks.ORANGE_TORCH, ModBlocks.ORANGE_WALL_TORCH);
        MAGENTA_TORCH = wallStandingBlockItem(ModBlocks.MAGENTA_TORCH, ModBlocks.MAGENTA_WALL_TORCH);
        LIGHT_BLUE_TORCH = wallStandingBlockItem(ModBlocks.LIGHT_BLUE_TORCH, ModBlocks.LIGHT_BLUE_WALL_TORCH);
        YELLOW_TORCH = wallStandingBlockItem(ModBlocks.YELLOW_TORCH, ModBlocks.YELLOW_WALL_TORCH);
        LIME_TORCH = wallStandingBlockItem(ModBlocks.LIME_TORCH, ModBlocks.LIME_WALL_TORCH);
        PINK_TORCH = wallStandingBlockItem(ModBlocks.PINK_TORCH, ModBlocks.PINK_WALL_TORCH);
        GRAY_TORCH = wallStandingBlockItem(ModBlocks.GRAY_TORCH, ModBlocks.GRAY_WALL_TORCH);
        LIGHT_GRAY_TORCH = wallStandingBlockItem(ModBlocks.LIGHT_GRAY_TORCH, ModBlocks.LIGHT_GRAY_WALL_TORCH);
        CYAN_TORCH = wallStandingBlockItem(ModBlocks.CYAN_TORCH, ModBlocks.CYAN_WALL_TORCH);
        PURPLE_TORCH = wallStandingBlockItem(ModBlocks.PURPLE_TORCH, ModBlocks.PURPLE_WALL_TORCH);
        BLUE_TORCH = wallStandingBlockItem(ModBlocks.BLUE_TORCH, ModBlocks.BLUE_WALL_TORCH);
        BROWN_TORCH = wallStandingBlockItem(ModBlocks.BROWN_TORCH, ModBlocks.BROWN_WALL_TORCH);
        GREEN_TORCH = wallStandingBlockItem(ModBlocks.GREEN_TORCH, ModBlocks.GREEN_WALL_TORCH);
        RED_TORCH = wallStandingBlockItem(ModBlocks.RED_TORCH, ModBlocks.RED_WALL_TORCH);
        BLACK_TORCH = wallStandingBlockItem(ModBlocks.BLACK_TORCH, ModBlocks.BLACK_WALL_TORCH);
        MAROON_TORCH = wallStandingBlockItem(ModBlocks.MAROON_TORCH, ModBlocks.MAROON_WALL_TORCH);
        BAUXITE = blockItem(ModBlocks.BAUXITE);
        BAUXITE_SLAB = blockItem(ModBlocks.BAUXITE_SLAB);
        BAUXITE_STAIRS = blockItem(ModBlocks.BAUXITE_STAIRS);
        BAUXITE_WALL = blockItem(ModBlocks.BAUXITE_WALL);
        BAUXITE_BRICKS = blockItem(ModBlocks.BAUXITE_BRICKS);
        BAUXITE_BRICK_STAIRS = blockItem(ModBlocks.BAUXITE_BRICK_STAIRS);
        BAUXITE_BRICK_SLAB = blockItem(ModBlocks.BAUXITE_BRICK_SLAB);
        BAUXITE_BRICK_WALL = blockItem(ModBlocks.BAUXITE_BRICK_WALL);
        MOSSY_BAUXITE_BRICKS = blockItem(ModBlocks.MOSSY_BAUXITE_BRICKS);
        MOSSY_BAUXITE_BRICK_STAIRS = blockItem(ModBlocks.MOSSY_BAUXITE_BRICK_STAIRS);
        MOSSY_BAUXITE_BRICK_SLAB = blockItem(ModBlocks.MOSSY_BAUXITE_BRICK_SLAB);
        MOSSY_BAUXITE_BRICK_WALL = blockItem(ModBlocks.MOSSY_BAUXITE_BRICK_WALL);
        CRACKED_BAUXITE_BRICKS = blockItem(ModBlocks.CRACKED_BAUXITE_BRICKS);
        CRACKED_BAUXITE_BRICK_STAIRS = blockItem(ModBlocks.CRACKED_BAUXITE_BRICK_STAIRS);
        CRACKED_BAUXITE_BRICK_SLAB = blockItem(ModBlocks.CRACKED_BAUXITE_BRICK_SLAB);
        CRACKED_BAUXITE_BRICK_WALL = blockItem(ModBlocks.CRACKED_BAUXITE_BRICK_WALL);
        TWISTED_NETHER_BRICKS = blockItem(ModBlocks.TWISTED_NETHER_BRICKS);
        TWISTED_NETHER_BRICK_STAIRS = blockItem(ModBlocks.TWISTED_NETHER_BRICK_STAIRS);
        TWISTED_NETHER_BRICK_SLAB = blockItem(ModBlocks.TWISTED_NETHER_BRICK_SLAB);
        TWISTED_NETHER_BRICK_WALL = blockItem(ModBlocks.TWISTED_NETHER_BRICK_WALL);
        TWISTED_NETHERRACK = blockItem(ModBlocks.TWISTED_NETHERRACK);
        TWISTED_NETHERRACK_STAIRS = blockItem(ModBlocks.TWISTED_NETHERRACK_STAIRS);
        TWISTED_NETHERRACK_SLAB = blockItem(ModBlocks.TWISTED_NETHERRACK_SLAB);
        TWISTED_NETHERRACK_WALL = blockItem(ModBlocks.TWISTED_NETHERRACK_WALL);
        WEEPING_NETHER_BRICKS = blockItem(ModBlocks.WEEPING_NETHER_BRICKS);
        WEEPING_NETHER_BRICK_STAIRS = blockItem(ModBlocks.WEEPING_NETHER_BRICK_STAIRS);
        WEEPING_NETHER_BRICK_SLAB = blockItem(ModBlocks.WEEPING_NETHER_BRICK_SLAB);
        WEEPING_NETHER_BRICK_WALL = blockItem(ModBlocks.WEEPING_NETHER_BRICK_WALL);
        WEEPING_NETHERRACK = blockItem(ModBlocks.WEEPING_NETHERRACK);
        WEEPING_NETHERRACK_STAIRS = blockItem(ModBlocks.WEEPING_NETHERRACK_STAIRS);
        WEEPING_NETHERRACK_SLAB = blockItem(ModBlocks.WEEPING_NETHERRACK_SLAB);
        WEEPING_NETHERRACK_WALL = blockItem(ModBlocks.WEEPING_NETHERRACK_WALL);
        SNAPDRAGON = blockItem(ModBlocks.SNAPDRAGON);
        SHORT_ENDER_GRASS = blockItem(ModBlocks.SHORT_ENDER_GRASS);
        CHOCOLATE_CAKE = blockItem(ModBlocks.CHOCOLATE_CAKE);
        RED_VELVET_CAKE = blockItem(ModBlocks.RED_VELVET_CAKE);
        STONE_TILES = blockItem(ModBlocks.STONE_TILES);
        STONE_TILE_SLAB = blockItem(ModBlocks.STONE_TILE_SLAB);
        STONE_TILE_STAIRS = blockItem(ModBlocks.STONE_TILE_STAIRS);
        STONE_TILE_WALL = blockItem(ModBlocks.STONE_TILE_WALL);
        MOSSY_STONE_TILES = blockItem(ModBlocks.MOSSY_STONE_TILES);
        MOSSY_STONE_TILE_SLAB = blockItem(ModBlocks.MOSSY_STONE_TILE_SLAB);
        MOSSY_STONE_TILE_STAIRS = blockItem(ModBlocks.MOSSY_STONE_TILE_STAIRS);
        MOSSY_STONE_TILE_WALL = blockItem(ModBlocks.MOSSY_STONE_TILE_WALL);
        CRACKED_STONE_TILES = blockItem(ModBlocks.CRACKED_STONE_TILES);
        CRACKED_STONE_TILE_SLAB = blockItem(ModBlocks.CRACKED_STONE_TILE_SLAB);
        CRACKED_STONE_TILE_STAIRS = blockItem(ModBlocks.CRACKED_STONE_TILE_STAIRS);
        CRACKED_STONE_TILE_WALL = blockItem(ModBlocks.CRACKED_STONE_TILE_WALL);
        SWEET_BERRY_PIE = blockItem(ModBlocks.SWEET_BERRY_PIE);
        BLUEBERRY_PIE = blockItem(ModBlocks.BLUEBERRY_PIE);
        BLACKSTONE_TILES = blockItem(ModBlocks.BLACKSTONE_TILES);
        BLACKSTONE_TILE_STAIRS = blockItem(ModBlocks.BLACKSTONE_TILE_STAIRS);
        BLACKSTONE_TILE_SLAB = blockItem(ModBlocks.BLACKSTONE_TILE_SLAB);
        BLACKSTONE_TILE_WALL = blockItem(ModBlocks.BLACKSTONE_TILE_WALL);
        TWISTED_BLACKSTONE_TILES = blockItem(ModBlocks.TWISTED_BLACKSTONE_TILES);
        TWISTED_BLACKSTONE_TILE_STAIRS = blockItem(ModBlocks.TWISTED_BLACKSTONE_TILE_STAIRS);
        TWISTED_BLACKSTONE_TILE_SLAB = blockItem(ModBlocks.TWISTED_BLACKSTONE_TILE_SLAB);
        TWISTED_BLACKSTONE_TILE_WALL = blockItem(ModBlocks.TWISTED_BLACKSTONE_TILE_WALL);
        WEEPING_BLACKSTONE_TILES = blockItem(ModBlocks.WEEPING_BLACKSTONE_TILES);
        WEEPING_BLACKSTONE_TILE_STAIRS = blockItem(ModBlocks.WEEPING_BLACKSTONE_TILE_STAIRS);
        WEEPING_BLACKSTONE_TILE_SLAB = blockItem(ModBlocks.WEEPING_BLACKSTONE_TILE_SLAB);
        WEEPING_BLACKSTONE_TILE_WALL = blockItem(ModBlocks.WEEPING_BLACKSTONE_TILE_WALL);
        TWISTED_POLISHED_BLACKSTONE_BRICKS = blockItem(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICKS);
        TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS = blockItem(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
        TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB = blockItem(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
        TWISTED_POLISHED_BLACKSTONE_BRICK_WALL = blockItem(ModBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
        WEEPING_POLISHED_BLACKSTONE_BRICKS = blockItem(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS);
        WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = blockItem(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
        WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = blockItem(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
        WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = blockItem(ModBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
        TWISTED_BLACKSTONE = blockItem(ModBlocks.TWISTED_BLACKSTONE);
        TWISTED_BLACKSTONE_STAIRS = blockItem(ModBlocks.TWISTED_BLACKSTONE_STAIRS);
        TWISTED_BLACKSTONE_SLAB = blockItem(ModBlocks.TWISTED_BLACKSTONE_SLAB);
        TWISTED_BLACKSTONE_WALL = blockItem(ModBlocks.TWISTED_BLACKSTONE_WALL);
        WEEPING_BLACKSTONE = blockItem(ModBlocks.WEEPING_BLACKSTONE);
        WEEPING_BLACKSTONE_STAIRS = blockItem(ModBlocks.WEEPING_BLACKSTONE_STAIRS);
        WEEPING_BLACKSTONE_SLAB = blockItem(ModBlocks.WEEPING_BLACKSTONE_SLAB);
        WEEPING_BLACKSTONE_WALL = blockItem(ModBlocks.WEEPING_BLACKSTONE_WALL);
        QUARTZ_TILES = blockItem(ModBlocks.QUARTZ_TILES);
        QUARTZ_TILE_STAIRS = blockItem(ModBlocks.QUARTZ_TILE_STAIRS);
        QUARTZ_TILE_SLAB = blockItem(ModBlocks.QUARTZ_TILE_SLAB);
        QUARTZ_TILE_WALL = blockItem(ModBlocks.QUARTZ_TILE_WALL);
        CALCITE_BRICKS = blockItem(ModBlocks.CALCITE_BRICKS);
        CALCITE_BRICK_STAIRS = blockItem(ModBlocks.CALCITE_BRICK_STAIRS);
        CALCITE_BRICK_SLAB = blockItem(ModBlocks.CALCITE_BRICK_SLAB);
        CALCITE_BRICK_WALL = blockItem(ModBlocks.CALCITE_BRICK_WALL);
        MOSSY_CALCITE_BRICKS = blockItem(ModBlocks.MOSSY_CALCITE_BRICKS);
        MOSSY_CALCITE_BRICK_STAIRS = blockItem(ModBlocks.MOSSY_CALCITE_BRICK_STAIRS);
        MOSSY_CALCITE_BRICK_SLAB = blockItem(ModBlocks.MOSSY_CALCITE_BRICK_SLAB);
        MOSSY_CALCITE_BRICK_WALL = blockItem(ModBlocks.MOSSY_CALCITE_BRICK_WALL);
        CRACKED_CALCITE_BRICKS = blockItem(ModBlocks.CRACKED_CALCITE_BRICKS);
        CRACKED_CALCITE_BRICK_STAIRS = blockItem(ModBlocks.CRACKED_CALCITE_BRICK_STAIRS);
        CRACKED_CALCITE_BRICK_SLAB = blockItem(ModBlocks.CRACKED_CALCITE_BRICK_SLAB);
        CRACKED_CALCITE_BRICK_WALL = blockItem(ModBlocks.CRACKED_CALCITE_BRICK_WALL);
        CHISELED_CALCITE_BRICKS = blockItem(ModBlocks.CHISELED_CALCITE_BRICKS);
        DRIPSTONE_BRICKS = blockItem(ModBlocks.DRIPSTONE_BRICKS);
        DRIPSTONE_BRICK_STAIRS = blockItem(ModBlocks.DRIPSTONE_BRICK_STAIRS);
        DRIPSTONE_BRICK_SLAB = blockItem(ModBlocks.DRIPSTONE_BRICK_SLAB);
        DRIPSTONE_BRICK_WALL = blockItem(ModBlocks.DRIPSTONE_BRICK_WALL);
        MOSSY_DRIPSTONE_BRICKS = blockItem(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
        MOSSY_DRIPSTONE_BRICK_STAIRS = blockItem(ModBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS);
        MOSSY_DRIPSTONE_BRICK_SLAB = blockItem(ModBlocks.MOSSY_DRIPSTONE_BRICK_SLAB);
        MOSSY_DRIPSTONE_BRICK_WALL = blockItem(ModBlocks.MOSSY_DRIPSTONE_BRICK_WALL);
        CRACKED_DRIPSTONE_BRICKS = blockItem(ModBlocks.CRACKED_DRIPSTONE_BRICKS);
        CRACKED_DRIPSTONE_BRICK_STAIRS = blockItem(ModBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS);
        CRACKED_DRIPSTONE_BRICK_SLAB = blockItem(ModBlocks.CRACKED_DRIPSTONE_BRICK_SLAB);
        CRACKED_DRIPSTONE_BRICK_WALL = blockItem(ModBlocks.CRACKED_DRIPSTONE_BRICK_WALL);
        CHISELED_DRIPSTONE_BRICKS = blockItem(ModBlocks.CHISELED_DRIPSTONE_BRICKS);
        GREEN_ONION_SEEDS = new AliasedBlockItem(ModBlocks.GREEN_ONIONS, new Item.Settings());
        GREEN_ONION = new Item(new Item.Settings().food(ModFoodComponents.GREEN_ONION));
        BLUEBERRIES = new AliasedBlockItem(ModBlocks.BLUEBERRY_BUSH, new Item.Settings()
                .food(ModFoodComponents.BLUEBERRIES));
        SWEET_BERRY_JUICE = new DrinkContainerItem(new Item.Settings()
                .food(ModFoodComponents.SWEET_BERRY_JUICE).maxCount(16));
        BLUEBERRY_JUICE = new DrinkContainerItem(new Item.Settings()
                .food(ModFoodComponents.BLUEBERRY_JUICE).maxCount(16));
        NOODLES = new Item(new Item.Settings());
        NOODLE_SOUP = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.NOODLE_SOUP).maxCount(1));
        PUDDING = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.PUDDING).maxCount(1));
        BERRY_PUDDING = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.BERRY_PUDDING).maxCount(1));
        SMOKY_QUARTZ = new Item(new Item.Settings());
        CARAMEL_APPLE = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.CARAMEL_APPLE).maxCount(1), net.minecraft.item.Items.STICK);
        CARAMEL = new Item(new Item.Settings().food(ModFoodComponents.CARAMEL));
        SPRUCE_CONE = new Item(new Item.Settings().food(ModFoodComponents.SPRUCE_CONE));
        FORESTS_BOUNTY = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.FORESTS_BOUNTY).maxCount(1));
        WITCHS_CRADLE_BRANCH = new AliasedBlockItem(ModBlocks.WITCHS_CRADLE, new Item.Settings()
                .food(ModFoodComponents.WITCHS_CRADLE_BRANCH));
        WITCHS_CRADLE_SOUP = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.WITCHS_CRADLE_SOUP).maxCount(1));
        CATTAIL = new AliasedBlockItem(ModBlocks.CATTAIL, new Item.Settings());
        FRIED_EGG = new Item(new Item.Settings().food(ModFoodComponents.FRIED_EGG).maxCount(16));
        BLOOD_KELP_SEED_CLUSTER = new AliasedBlockItem(ModBlocks.BLOOD_KELP, new Item.Settings());
        BLOOD_KELP = new Item(new Item.Settings());
        DRIED_BLOOD_KELP_BLOCK = blockItem(ModBlocks.DRIED_BLOOD_KELP_BLOCK);
        DRIED_BLOOD_KELP = new Item(new Item.Settings().food(net.minecraft.item.FoodComponents.DRIED_KELP));
        BLOOD_KELP_LANTERN = blockItem(ModBlocks.BLOOD_KELP_LANTERN);
        MAROON_WOOL = blockItem(ModBlocks.MAROON_WOOL);
        MAROON_STAINED_GLASS = blockItem(ModBlocks.MAROON_STAINED_GLASS);
        MAROON_STAINED_GLASS_PANE = blockItem(ModBlocks.MAROON_STAINED_GLASS_PANE);
        MAROON_CANDLE = blockItem(ModBlocks.MAROON_CANDLE);
        MAROON_CONCRETE = blockItem(ModBlocks.MAROON_CONCRETE);
        MAROON_CONCRETE_POWDER = blockItem(ModBlocks.MAROON_CONCRETE_POWDER);
        CAMEL_PLUSHIE = blockItem(ModBlocks.CAMEL_PLUSHIE);
        MAROON_DYE = new Item(new Item.Settings());
        HOGLIN_STEW = new FoodContainerItem(new Item.Settings()
                .food(ModFoodComponents.HOGLIN_STEW).maxCount(1));
        BOG_BLOSSOM = blockItem(ModBlocks.BOG_BLOSSOM);
        CINDERSNAP_BERRIES = new AliasedBlockItem(ModBlocks.CINDERSNAP_BERRY_BUSH, new Item.Settings()
                .food(ModFoodComponents.NETHER_BERRIES));
        FROSTBITE_BERRIES = new AliasedBlockItem(ModBlocks.FROSTBITE_BERRY_BUSH, new Item.Settings()
                .food(ModFoodComponents.NETHER_BERRIES));
        POLISHED_DRIPSTONE = blockItem(ModBlocks.POLISHED_DRIPSTONE);
        POLISHED_DRIPSTONE_STAIRS = blockItem(ModBlocks.POLISHED_DRIPSTONE_STAIRS);
        POLISHED_DRIPSTONE_SLAB = blockItem(ModBlocks.POLISHED_DRIPSTONE_SLAB);
        POLISHED_DRIPSTONE_WALL = blockItem(ModBlocks.POLISHED_DRIPSTONE_WALL);
        POLISHED_CALCITE = blockItem(ModBlocks.POLISHED_CALCITE);
        POLISHED_CALCITE_STAIRS = blockItem(ModBlocks.POLISHED_CALCITE_STAIRS);
        POLISHED_CALCITE_SLAB = blockItem(ModBlocks.POLISHED_CALCITE_SLAB);
        POLISHED_CALCITE_WALL = blockItem(ModBlocks.POLISHED_CALCITE_WALL);
        DRIPSTONE_STAIRS = blockItem(ModBlocks.DRIPSTONE_STAIRS);
        DRIPSTONE_SLAB = blockItem(ModBlocks.DRIPSTONE_SLAB);
        DRIPSTONE_WALL = blockItem(ModBlocks.DRIPSTONE_WALL);
        CALCITE_STAIRS = blockItem(ModBlocks.CALCITE_STAIRS);
        CALCITE_SLAB = blockItem(ModBlocks.CALCITE_SLAB);
        CALCITE_WALL = blockItem(ModBlocks.CALCITE_WALL);
        BAMBOO_PLANTER_BOX = blockItem(ModBlocks.BAMBOO_PLANTER_BOX);
        STONE_WALL = blockItem(ModBlocks.STONE_WALL);
        QUARTZ_WALL = blockItem(ModBlocks.QUARTZ_WALL);
        SMOOTH_QUARTZ_WALL = blockItem(ModBlocks.SMOOTH_QUARTZ_WALL);
        GRASS_SLAB = blockItem(ModBlocks.GRASS_SLAB);
        PODZOL_SLAB = blockItem(ModBlocks.PODZOL_SLAB);
        MYCELIUM_SLAB = blockItem(ModBlocks.MYCELIUM_SLAB);
        DIRT_PATH_SLAB = blockItem(ModBlocks.DIRT_PATH_SLAB);
        DIRT_SLAB = blockItem(ModBlocks.DIRT_SLAB);
        COARSE_DIRT_SLAB = blockItem(ModBlocks.COARSE_DIRT_SLAB);
        ROOTED_DIRT_SLAB = blockItem(ModBlocks.ROOTED_DIRT_SLAB);
        WILD_GREEN_ONIONS = blockItem(ModBlocks.WILD_GREEN_ONIONS);
    }
}
