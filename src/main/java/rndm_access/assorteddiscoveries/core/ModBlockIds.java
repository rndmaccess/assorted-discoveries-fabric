package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColorCollection;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModBlockIds {
    public static final BlockItemId BAT_PLUSHIE_KEY = create("bat_plushie");
    public static final BlockItemId BLAZE_PLUSHIE_KEY = create("blaze_plushie");
    public static final BlockItemId CAVE_SPIDER_PLUSHIE_KEY = create("cave_spider_plushie");
    public static final BlockItemId TEMPERATE_CHICKEN_PLUSHIE_KEY
            = create("temperate_chicken_plushie");
    public static final BlockItemId TEMPERATE_COW_PLUSHIE_KEY
            = create("temperate_cow_plushie");
    public static final BlockItemId CREEPER_PLUSHIE_KEY = create("creeper_plushie");
    public static final BlockItemId ENDERMAN_PLUSHIE_KEY = create("enderman_plushie");
    public static final BlockItemId GHAST_PLUSHIE_KEY = create("ghast_plushie");
    public static final BlockItemId GUARDIAN_PLUSHIE_KEY = create("guardian_plushie");
    public static final BlockItemId WHITE_HORSE_PLUSHIE_KEY = create("white_horse_plushie");
    public static final BlockItemId GRAY_HORSE_PLUSHIE_KEY = create("gray_horse_plushie");
    public static final BlockItemId BROWN_HORSE_PLUSHIE_KEY = create("brown_horse_plushie");
    public static final BlockItemId BLACK_HORSE_PLUSHIE_KEY = create("black_horse_plushie");
    public static final BlockItemId MAGMA_CUBE_PLUSHIE_KEY = create("magma_cube_plushie");
    public static final BlockItemId RED_MOOSHROOM_PLUSHIE_KEY = create("red_mooshroom_plushie");
    public static final BlockItemId BROWN_MOOSHROOM_PLUSHIE_KEY = create("brown_mooshroom_plushie");
    public static final BlockItemId OCELOT_PLUSHIE_KEY = create("ocelot_plushie");
    public static final BlockItemId TABBY_CAT_PLUSHIE_KEY = create("tabby_cat_plushie");
    public static final BlockItemId TUXEDO_CAT_PLUSHIE_KEY = create("tuxedo_cat_plushie");
    public static final BlockItemId RED_CAT_PLUSHIE_KEY = create("red_cat_plushie");
    public static final BlockItemId SIAMESE_CAT_PLUSHIE_KEY = create("siamese_cat_plushie");
    public static final BlockItemId BRITISH_SHORTHAIR_CAT_PLUSHIE_KEY
            = create("british_shorthair_cat_plushie");
    public static final BlockItemId CALICO_CAT_PLUSHIE_KEY = create("calico_cat_plushie");
    public static final BlockItemId PERSIAN_CAT_PLUSHIE_KEY = create("persian_cat_plushie");
    public static final BlockItemId RAGDOLL_CAT_PLUSHIE_KEY = create("ragdoll_cat_plushie");
    public static final BlockItemId WHITE_CAT_PLUSHIE_KEY = create("white_cat_plushie");
    public static final BlockItemId JELLIE_CAT_PLUSHIE_KEY = create("jellie_cat_plushie");
    public static final BlockItemId BLACK_CAT_PLUSHIE_KEY = create("black_cat_plushie");
    public static final BlockItemId TEMPERATE_PIG_PLUSHIE_KEY = create("temperate_pig_plushie");
    public static final BlockItemId COLD_PIG_PLUSHIE_KEY = create("cold_pig_plushie");
    public static final BlockItemId WARM_PIG_PLUSHIE_KEY = create("warm_pig_plushie");
    public static final BlockItemId BROWN_RABBIT_PLUSHIE_KEY = create("brown_rabbit_plushie");
    public static final BlockItemId WHITE_RABBIT_PLUSHIE_KEY = create("white_rabbit_plushie");
    public static final BlockItemId BLACK_RABBIT_PLUSHIE_KEY = create("black_rabbit_plushie");
    public static final BlockItemId WHITE_SPLOTCHED_RABBIT_PLUSHIE_KEY
            = create("white_splotched_rabbit_plushie");
    public static final BlockItemId GOLD_RABBIT_PLUSHIE_KEY = create("gold_rabbit_plushie");
    public static final BlockItemId TOAST_RABBIT_PLUSHIE_KEY = create("toast_rabbit_plushie");
    public static final BlockItemId SALT_RABBIT_PLUSHIE_KEY = create("salt_rabbit_plushie");
    public static final BlockItemId SKELETON_PLUSHIE_KEY = create("skeleton_plushie");
    public static final BlockItemId SLIME_PLUSHIE_KEY = create("slime_plushie");
    public static final BlockItemId SPIDER_PLUSHIE_KEY = create("spider_plushie");
    public static final BlockItemId SQUID_PLUSHIE_KEY = create("squid_plushie");
    public static final BlockItemId GLOW_SQUID_PLUSHIE_KEY = create("glow_squid_plushie");
    public static final BlockItemId BEE_PLUSHIE_KEY = create("bee_plushie");
    public static final BlockItemId PLAINS_VILLAGER_PLUSHIE_KEY = create("plains_villager_plushie");
    public static final BlockItemId DESERT_VILLAGER_PLUSHIE_KEY = create("desert_villager_plushie");
    public static final BlockItemId JUNGLE_VILLAGER_PLUSHIE_KEY = create("jungle_villager_plushie");
    public static final BlockItemId SAVANNA_VILLAGER_PLUSHIE_KEY
            = create("savanna_villager_plushie");
    public static final BlockItemId SNOWY_VILLAGER_PLUSHIE_KEY = create("snowy_villager_plushie");
    public static final BlockItemId SWAMP_VILLAGER_PLUSHIE_KEY = create("swamp_villager_plushie");
    public static final BlockItemId TAIGA_VILLAGER_PLUSHIE_KEY = create("taiga_villager_plushie");
    public static final BlockItemId WITCH_PLUSHIE_KEY = create("witch_plushie");
    public static final BlockItemId PALE_WOLF_PLUSHIE_KEY = create("pale_wolf_plushie");
    public static final BlockItemId ZOMBIE_PLUSHIE_KEY = create("zombie_plushie");
    public static final BlockItemId PIGLIN_PLUSHIE_KEY = create("piglin_plushie");
    public static final BlockItemId ZOMBIFIED_PIGLIN_PLUSHIE_KEY = create("zombified_piglin_plushie");
    public static final BlockItemId PUFFERFISH_PLUSHIE_KEY = create("pufferfish_plushie");
    public static final BlockItemId WITHER_PLUSHIE_KEY = create("wither_plushie");
    public static final BlockItemId STRIDER_PLUSHIE_KEY = create("strider_plushie");
    public static final BlockItemId SHIVERING_STRIDER_PLUSHIE_KEY
            = create("shivering_strider_plushie");
    public static final BlockItemId PHANTOM_PLUSHIE_KEY = create("phantom_plushie");
    public static final BlockItemId HOGLIN_PLUSHIE_KEY = create("hoglin_plushie");
    public static final BlockItemId ZOGLIN_PLUSHIE_KEY = create("zoglin_plushie");
    public static final BlockItemId ALLAY_PLUSHIE_KEY = create("allay_plushie");
    public static final BlockItemId PILLAGER_PLUSHIE_KEY = create("pillager_plushie");
    public static final BlockItemId VINDICATOR_PLUSHIE_KEY = create("vindicator_plushie");
    public static final BlockItemId EVOKER_PLUSHIE_KEY = create("evoker_plushie");
    public static final BlockItemId SHULKER_PLUSHIE_KEY = create("shulker_plushie");
    public static final BlockItemId VEX_PLUSHIE_KEY = create("vex_plushie");
    public static final BlockItemId CAMEL_PLUSHIE_KEY = create("camel_plushie");
    public static final BlockItemId NETHER_SMOKY_QUARTZ_ORE_KEY = create("nether_smoky_quartz_ore");
    public static final BlockItemId SMOKY_QUARTZ_BLOCK_KEY = create("smoky_quartz_block");
    public static final BlockItemId CHISELED_SMOKY_QUARTZ_BLOCK_KEY
            = create("chiseled_smoky_quartz_block");
    public static final BlockItemId SMOKY_QUARTZ_BRICKS_KEY = create("smoky_quartz_bricks");
    public static final BlockItemId SMOKY_QUARTZ_BRICK_STAIRS_KEY
            = create("smoky_quartz_brick_stairs");
    public static final BlockItemId SMOKY_QUARTZ_BRICK_SLAB_KEY
            = create("smoky_quartz_brick_slab");
    public static final BlockItemId SMOKY_QUARTZ_BRICK_WALL_KEY = create("smoky_quartz_brick_wall");
    public static final BlockItemId SMOKY_QUARTZ_PILLAR_KEY = create("smoky_quartz_pillar");
    public static final BlockItemId SMOKY_QUARTZ_STAIRS_KEY = create("smoky_quartz_stairs");
    public static final BlockItemId SMOKY_QUARTZ_SLAB_KEY = create("smoky_quartz_slab");
    public static final BlockItemId SMOKY_QUARTZ_WALL_KEY = create("smoky_quartz_wall");
    public static final BlockItemId SMOOTH_SMOKY_QUARTZ_KEY = create("smooth_smoky_quartz");
    public static final BlockItemId SMOOTH_SMOKY_QUARTZ_STAIRS_KEY
            = create("smooth_smoky_quartz_stairs");
    public static final BlockItemId SMOOTH_SMOKY_QUARTZ_SLAB_KEY
            = create("smooth_smoky_quartz_slab");
    public static final BlockItemId SMOOTH_SMOKY_QUARTZ_WALL_KEY
            = create("smooth_smoky_quartz_wall");
    public static final BlockItemId CRACKED_STONE_BRICK_STAIRS_KEY
            = create("cracked_stone_brick_stairs");
    public static final BlockItemId CRACKED_STONE_BRICK_SLAB_KEY
            = create("cracked_stone_brick_slab");
    public static final BlockItemId CRACKED_STONE_BRICK_WALL_KEY
            = create("cracked_stone_brick_wall");
    public static final ResourceKey<Block> BLUEBERRY_BUSH_KEY = createBlockId("blueberry_bush");
    public static final ResourceKey<Block> GREEN_ONIONS_KEY = createBlockId("green_onions");
    public static final BlockItemId OAK_PLANTER_BOX_KEY = create("oak_planter_box");
    public static final BlockItemId SPRUCE_PLANTER_BOX_KEY = create("spruce_planter_box");
    public static final BlockItemId BIRCH_PLANTER_BOX_KEY = create("birch_planter_box");
    public static final BlockItemId JUNGLE_PLANTER_BOX_KEY = create("jungle_planter_box");
    public static final BlockItemId ACACIA_PLANTER_BOX_KEY = create("acacia_planter_box");
    public static final BlockItemId DARK_OAK_PLANTER_BOX_KEY = create("dark_oak_planter_box");
    public static final BlockItemId MANGROVE_PLANTER_BOX_KEY = create("mangrove_planter_box");
    public static final BlockItemId CHERRY_PLANTER_BOX_KEY = create("cherry_planter_box");
    public static final BlockItemId PALE_OAK_PLANTER_BOX_KEY = create("pale_oak_planter_box");
    public static final BlockItemId CRIMSON_PLANTER_BOX_KEY = create("crimson_planter_box");
    public static final BlockItemId WARPED_PLANTER_BOX_KEY = create("warped_planter_box");
    public static final BlockItemId OAK_WALL_KEY = create("oak_wall");
    public static final BlockItemId SPRUCE_WALL_KEY = create("spruce_wall");
    public static final BlockItemId BIRCH_WALL_KEY = create("birch_wall");
    public static final BlockItemId JUNGLE_WALL_KEY = create("jungle_wall");
    public static final BlockItemId ACACIA_WALL_KEY = create("acacia_wall");
    public static final BlockItemId DARK_OAK_WALL_KEY = create("dark_oak_wall");
    public static final BlockItemId MANGROVE_WALL_KEY = create("mangrove_wall");
    public static final BlockItemId CRIMSON_WALL_KEY = create("crimson_wall");
    public static final BlockItemId WARPED_WALL_KEY = create("warped_wall");
    public static final BlockItemId CHERRY_WALL_KEY = create("cherry_wall");
    public static final BlockItemId STRIPPED_OAK_WALL_KEY = create("stripped_oak_wall");
    public static final BlockItemId STRIPPED_SPRUCE_WALL_KEY = create("stripped_spruce_wall");
    public static final BlockItemId STRIPPED_BIRCH_WALL_KEY = create("stripped_birch_wall");
    public static final BlockItemId STRIPPED_JUNGLE_WALL_KEY = create("stripped_jungle_wall");
    public static final BlockItemId STRIPPED_ACACIA_WALL_KEY = create("stripped_acacia_wall");
    public static final BlockItemId STRIPPED_DARK_OAK_WALL_KEY = create("stripped_dark_oak_wall");
    public static final BlockItemId STRIPPED_MANGROVE_WALL_KEY = create("stripped_mangrove_wall");
    public static final BlockItemId STRIPPED_CRIMSON_WALL_KEY = create("stripped_crimson_wall");
    public static final BlockItemId STRIPPED_WARPED_WALL_KEY = create("stripped_warped_wall");
    public static final BlockItemId STRIPPED_CHERRY_WALL_KEY = create("stripped_cherry_wall");
    public static final BlockItemId OAK_ROPE_LADDER_KEY = create("oak_rope_ladder");
    public static final BlockItemId SPRUCE_ROPE_LADDER_KEY = create("spruce_rope_ladder");
    public static final BlockItemId BIRCH_ROPE_LADDER_KEY = create("birch_rope_ladder");
    public static final BlockItemId JUNGLE_ROPE_LADDER_KEY = create("jungle_rope_ladder");
    public static final BlockItemId ACACIA_ROPE_LADDER_KEY = create("acacia_rope_ladder");
    public static final BlockItemId DARK_OAK_ROPE_LADDER_KEY = create("dark_oak_rope_ladder");
    public static final BlockItemId CRIMSON_ROPE_LADDER_KEY = create("crimson_rope_ladder");
    public static final BlockItemId WARPED_ROPE_LADDER_KEY = create("warped_rope_ladder");
    public static final BlockItemId MANGROVE_ROPE_LADDER_KEY = create("mangrove_rope_ladder");
    public static final BlockItemId CHERRY_ROPE_LADDER_KEY = create("cherry_rope_ladder");
    public static final BlockItemId PALE_OAK_ROPE_LADDER_KEY = create("pale_oak_rope_ladder");
    public static final BlockItemId IRON_LADDER_KEY = create("iron_ladder");
    public static final BlockItemId SNOW_BRICKS_KEY = create("snow_bricks");
    public static final BlockItemId SNOW_BRICK_STAIRS_KEY = create("snow_brick_stairs");
    public static final BlockItemId SNOW_BRICK_SLAB_KEY = create("snow_brick_slab");
    public static final BlockItemId SNOW_BRICK_WALL_KEY = create("snow_brick_wall");
    public static final BlockItemId PACKED_SNOW_KEY = create("packed_snow");
    public static final BlockItemId PACKED_SNOW_STAIRS_KEY = create("packed_snow_stairs");
    public static final BlockItemId PACKED_SNOW_SLAB_KEY = create("packed_snow_slab");
    public static final BlockItemId PACKED_SNOW_WALL_KEY = create("packed_snow_wall");
    public static final BlockItemId PURPLE_MUSHROOM_KEY = create("purple_mushroom");
    public static final BlockItemId PURPLE_MUSHROOM_BLOCK_KEY = create("purple_mushroom_block");
    public static final BlockItemId WHITE_CAMPFIRE_KEY = create("white_campfire");
    public static final BlockItemId ORANGE_CAMPFIRE_KEY = create("orange_campfire");
    public static final BlockItemId MAGENTA_CAMPFIRE_KEY = create("magenta_campfire");
    public static final BlockItemId LIGHT_BLUE_CAMPFIRE_KEY = create("light_blue_campfire");
    public static final BlockItemId YELLOW_CAMPFIRE_KEY = create("yellow_campfire");
    public static final BlockItemId LIME_CAMPFIRE_KEY = create("lime_campfire");
    public static final BlockItemId PINK_CAMPFIRE_KEY = create("pink_campfire");
    public static final BlockItemId GRAY_CAMPFIRE_KEY = create("gray_campfire");
    public static final BlockItemId LIGHT_GRAY_CAMPFIRE_KEY = create("light_gray_campfire");
    public static final BlockItemId CYAN_CAMPFIRE_KEY = create("cyan_campfire");
    public static final BlockItemId PURPLE_CAMPFIRE_KEY = create("purple_campfire");
    public static final BlockItemId BLUE_CAMPFIRE_KEY = create("blue_campfire");
    public static final BlockItemId BROWN_CAMPFIRE_KEY = create("brown_campfire");
    public static final BlockItemId GREEN_CAMPFIRE_KEY = create("green_campfire");
    public static final BlockItemId RED_CAMPFIRE_KEY = create("red_campfire");
    public static final BlockItemId BLACK_CAMPFIRE_KEY = create("black_campfire");
    public static final ResourceKey<Block> WHITE_TORCH_KEY = createBlockId("white_torch");
    public static final ResourceKey<Block> ORANGE_TORCH_KEY = createBlockId("orange_torch");
    public static final ResourceKey<Block> MAGENTA_TORCH_KEY = createBlockId("magenta_torch");
    public static final ResourceKey<Block> LIGHT_BLUE_TORCH_KEY = createBlockId("light_blue_torch");
    public static final ResourceKey<Block> YELLOW_TORCH_KEY = createBlockId("yellow_torch");
    public static final ResourceKey<Block> LIME_TORCH_KEY = createBlockId("lime_torch");
    public static final ResourceKey<Block> PINK_TORCH_KEY = createBlockId("pink_torch");
    public static final ResourceKey<Block> GRAY_TORCH_KEY = createBlockId("gray_torch");
    public static final ResourceKey<Block> LIGHT_GRAY_TORCH_KEY = createBlockId("light_gray_torch");
    public static final ResourceKey<Block> CYAN_TORCH_KEY = createBlockId("cyan_torch");
    public static final ResourceKey<Block> PURPLE_TORCH_KEY = createBlockId("purple_torch");
    public static final ResourceKey<Block> BLUE_TORCH_KEY = createBlockId("blue_torch");
    public static final ResourceKey<Block> BROWN_TORCH_KEY = createBlockId("brown_torch");
    public static final ResourceKey<Block> GREEN_TORCH_KEY = createBlockId("green_torch");
    public static final ResourceKey<Block> RED_TORCH_KEY = createBlockId("red_torch");
    public static final ResourceKey<Block> BLACK_TORCH_KEY = createBlockId("black_torch");
    public static final ResourceKey<Block> WHITE_WALL_TORCH_KEY = createBlockId("white_wall_torch");
    public static final ResourceKey<Block> ORANGE_WALL_TORCH_KEY = createBlockId("orange_wall_torch");
    public static final ResourceKey<Block> MAGENTA_WALL_TORCH_KEY = createBlockId("magenta_wall_torch");
    public static final ResourceKey<Block> LIGHT_BLUE_WALL_TORCH_KEY = createBlockId("light_blue_wall_torch");
    public static final ResourceKey<Block> YELLOW_WALL_TORCH_KEY = createBlockId("yellow_wall_torch");
    public static final ResourceKey<Block> LIME_WALL_TORCH_KEY = createBlockId("lime_wall_torch");
    public static final ResourceKey<Block> PINK_WALL_TORCH_KEY = createBlockId("pink_wall_torch");
    public static final ResourceKey<Block> GRAY_WALL_TORCH_KEY = createBlockId("gray_wall_torch");
    public static final ResourceKey<Block> LIGHT_GRAY_WALL_TORCH_KEY = createBlockId("light_gray_wall_torch");
    public static final ResourceKey<Block> CYAN_WALL_TORCH_KEY = createBlockId("cyan_wall_torch");
    public static final ResourceKey<Block> PURPLE_WALL_TORCH_KEY = createBlockId("purple_wall_torch");
    public static final ResourceKey<Block> BLUE_WALL_TORCH_KEY = createBlockId("blue_wall_torch");
    public static final ResourceKey<Block> BROWN_WALL_TORCH_KEY = createBlockId("brown_wall_torch");
    public static final ResourceKey<Block> GREEN_WALL_TORCH_KEY = createBlockId("green_wall_torch");
    public static final ResourceKey<Block> RED_WALL_TORCH_KEY = createBlockId("red_wall_torch");
    public static final ResourceKey<Block> BLACK_WALL_TORCH_KEY = createBlockId("black_wall_torch");
    public static final ResourceKey<Block> WITCHS_CRADLE_KEY = createBlockId("witchs_cradle");
    public static final BlockItemId BAUXITE_KEY = create("bauxite");
    public static final BlockItemId BAUXITE_SLAB_KEY = create("bauxite_slab");
    public static final BlockItemId BAUXITE_STAIRS_KEY = create("bauxite_stairs");
    public static final BlockItemId BAUXITE_WALL_KEY = create("bauxite_wall");
    public static final BlockItemId BAUXITE_BRICKS_KEY = create("bauxite_bricks");
    public static final BlockItemId BAUXITE_BRICK_STAIRS_KEY = create("bauxite_brick_stairs");
    public static final BlockItemId BAUXITE_BRICK_SLAB_KEY = create("bauxite_brick_slab");
    public static final BlockItemId BAUXITE_BRICK_WALL_KEY = create("bauxite_brick_wall");
    public static final BlockItemId MOSSY_BAUXITE_BRICKS_KEY = create("mossy_bauxite_bricks");
    public static final BlockItemId MOSSY_BAUXITE_BRICK_STAIRS_KEY
            = create("mossy_bauxite_brick_stairs");
    public static final BlockItemId MOSSY_BAUXITE_BRICK_SLAB_KEY
            = create("mossy_bauxite_brick_slab");
    public static final BlockItemId MOSSY_BAUXITE_BRICK_WALL_KEY
            = create("mossy_bauxite_brick_wall");
    public static final BlockItemId CRACKED_BAUXITE_BRICKS_KEY = create("cracked_bauxite_bricks");
    public static final BlockItemId CRACKED_BAUXITE_BRICK_STAIRS_KEY
            = create("cracked_bauxite_brick_stairs");
    public static final BlockItemId CRACKED_BAUXITE_BRICK_SLAB_KEY
            = create("cracked_bauxite_brick_slab");
    public static final BlockItemId CRACKED_BAUXITE_BRICK_WALL_KEY
            = create("cracked_bauxite_brick_wall");
    public static final BlockItemId TWISTED_NETHER_BRICKS_KEY = create("twisted_nether_bricks");
    public static final BlockItemId TWISTED_NETHER_BRICK_STAIRS_KEY
            = create("twisted_nether_brick_stairs");
    public static final BlockItemId TWISTED_NETHER_BRICK_SLAB_KEY
            = create("twisted_nether_brick_slab");
    public static final BlockItemId TWISTED_NETHER_BRICK_WALL_KEY
            = create("twisted_nether_brick_wall");
    public static final BlockItemId TWISTED_NETHERRACK_KEY = create("twisted_netherrack");
    public static final BlockItemId TWISTED_NETHERRACK_STAIRS_KEY
            = create("twisted_netherrack_stairs");
    public static final BlockItemId TWISTED_NETHERRACK_SLAB_KEY
            = create("twisted_netherrack_slab");
    public static final BlockItemId TWISTED_NETHERRACK_WALL_KEY
            = create("twisted_netherrack_wall");
    public static final BlockItemId WEEPING_NETHER_BRICKS_KEY = create("weeping_nether_bricks");
    public static final BlockItemId WEEPING_NETHER_BRICK_STAIRS_KEY
            = create("weeping_nether_brick_stairs");
    public static final BlockItemId WEEPING_NETHER_BRICK_SLAB_KEY
            = create("weeping_nether_brick_slab");
    public static final BlockItemId WEEPING_NETHER_BRICK_WALL_KEY
            = create("weeping_nether_brick_wall");
    public static final BlockItemId WEEPING_NETHERRACK_KEY = create("weeping_netherrack");
    public static final BlockItemId WEEPING_NETHERRACK_STAIRS_KEY
            = create("weeping_netherrack_stairs");
    public static final BlockItemId WEEPING_NETHERRACK_SLAB_KEY
            = create("weeping_netherrack_slab");
    public static final BlockItemId WEEPING_NETHERRACK_WALL_KEY = create("weeping_netherrack_wall");
    public static final BlockItemId SNAPDRAGON_KEY = create("snapdragon");
    public static final ResourceKey<Block> POTTED_SNAPDRAGON_KEY = createBlockId("potted_snapdragon");
    public static final BlockItemId POTTED_PURPLE_MUSHROOM_KEY = create("potted_purple_mushroom");
    public static final BlockItemId SHORT_ENDER_GRASS_KEY = create("short_ender_grass");
    public static final BlockItemId CATTAIL_KEY = create("cattail");
    public static final BlockItemId CHOCOLATE_CAKE_KEY = create("chocolate_cake");
    public static final BlockItemId RED_VELVET_CAKE_KEY = create("red_velvet_cake");
    public static final ResourceKey<Block> CANDLE_CHOCOLATE_CAKE_KEY = createBlockId("candle_chocolate_cake");
    public static final ColorCollection<BlockItemId> DYED_CANDLE_CHOCOLATE_CAKE_KEYS
            = createSimpleColored("candle_chocolate_cake");
    public static final ResourceKey<Block> CANDLE_RED_VELVET_CAKE_KEY = createBlockId("candle_red_velvet_cake");
    public static final ColorCollection<BlockItemId> DYED_CANDLE_RED_VELVET_CAKE_KEYS
            = createSimpleColored("candle_red_velvet_cake");
    public static final BlockItemId STONE_TILES_KEY = create("stone_tiles");
    public static final BlockItemId STONE_TILE_SLAB_KEY = create("stone_tile_slab");
    public static final BlockItemId STONE_TILE_STAIRS_KEY = create("stone_tile_stairs");
    public static final BlockItemId STONE_TILE_WALL_KEY = create("stone_tile_wall");
    public static final BlockItemId MOSSY_STONE_TILES_KEY = create("mossy_stone_tiles");
    public static final BlockItemId MOSSY_STONE_TILE_SLAB_KEY = create("mossy_stone_tile_slab");
    public static final BlockItemId MOSSY_STONE_TILE_STAIRS_KEY = create("mossy_stone_tile_stairs");
    public static final BlockItemId MOSSY_STONE_TILE_WALL_KEY = create("mossy_stone_tile_wall");
    public static final BlockItemId CRACKED_STONE_TILES_KEY = create("cracked_stone_tiles");
    public static final BlockItemId CRACKED_STONE_TILE_SLAB_KEY
            = create("cracked_stone_tile_slab");
    public static final BlockItemId CRACKED_STONE_TILE_STAIRS_KEY
            = create("cracked_stone_tile_stairs");
    public static final BlockItemId CRACKED_STONE_TILE_WALL_KEY
            = create("cracked_stone_tile_wall");
    public static final BlockItemId SWEET_BERRY_PIE_KEY = create("sweet_berry_pie");
    public static final BlockItemId BLUEBERRY_PIE_KEY = create("blueberry_pie");
    public static final BlockItemId BLACKSTONE_TILES_KEY = create("blackstone_tiles");
    public static final BlockItemId BLACKSTONE_TILE_STAIRS_KEY = create("blackstone_tile_stairs");
    public static final BlockItemId BLACKSTONE_TILE_SLAB_KEY = create("blackstone_tile_slab");
    public static final BlockItemId BLACKSTONE_TILE_WALL_KEY = create("blackstone_tile_wall");
    public static final BlockItemId TWISTED_BLACKSTONE_TILES_KEY = create("twisted_blackstone_tiles");
    public static final BlockItemId TWISTED_BLACKSTONE_TILE_STAIRS_KEY
            = create("twisted_blackstone_tile_stairs");
    public static final BlockItemId TWISTED_BLACKSTONE_TILE_SLAB_KEY
            = create("twisted_blackstone_tile_slab");
    public static final BlockItemId TWISTED_BLACKSTONE_TILE_WALL_KEY
            = create("twisted_blackstone_tile_wall");
    public static final BlockItemId WEEPING_BLACKSTONE_TILES_KEY
            = create("weeping_blackstone_tiles");
    public static final BlockItemId WEEPING_BLACKSTONE_TILE_STAIRS_KEY
            = create("weeping_blackstone_tile_stairs");
    public static final BlockItemId WEEPING_BLACKSTONE_TILE_SLAB_KEY
            = create("weeping_blackstone_tile_slab");
    public static final BlockItemId WEEPING_BLACKSTONE_TILE_WALL_KEY
            = create("weeping_blackstone_tile_wall");
    public static final BlockItemId TWISTED_POLISHED_BLACKSTONE_BRICKS_KEY
            = create("twisted_polished_blackstone_bricks");
    public static final BlockItemId TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY
            = create("twisted_polished_blackstone_brick_stairs");
    public static final BlockItemId TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB_KEY
            = create("twisted_polished_blackstone_brick_slab");
    public static final BlockItemId TWISTED_POLISHED_BLACKSTONE_BRICK_WALL_KEY
            = create("twisted_polished_blackstone_brick_wall");
    public static final BlockItemId WEEPING_POLISHED_BLACKSTONE_BRICKS_KEY
            = create("weeping_polished_blackstone_bricks");
    public static final BlockItemId WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS_KEY
            = create("weeping_polished_blackstone_brick_stairs");
    public static final BlockItemId WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB_KEY
            = create("weeping_polished_blackstone_brick_slab");
    public static final BlockItemId WEEPING_POLISHED_BLACKSTONE_BRICK_WALL_KEY
            = create("weeping_polished_blackstone_brick_wall");
    public static final BlockItemId TWISTED_BLACKSTONE_KEY = create("twisted_blackstone");
    public static final BlockItemId TWISTED_BLACKSTONE_STAIRS_KEY
            = create("twisted_blackstone_stairs");
    public static final BlockItemId TWISTED_BLACKSTONE_SLAB_KEY
            = create("twisted_blackstone_slab");
    public static final BlockItemId TWISTED_BLACKSTONE_WALL_KEY
            = create("twisted_blackstone_wall");
    public static final BlockItemId WEEPING_BLACKSTONE_KEY = create("weeping_blackstone");
    public static final BlockItemId WEEPING_BLACKSTONE_STAIRS_KEY
            = create("weeping_blackstone_stairs");
    public static final BlockItemId WEEPING_BLACKSTONE_SLAB_KEY
            = create("weeping_blackstone_slab");
    public static final BlockItemId WEEPING_BLACKSTONE_WALL_KEY
            = create("weeping_blackstone_wall");
    public static final BlockItemId QUARTZ_TILES_KEY = create("quartz_tiles");
    public static final BlockItemId QUARTZ_TILE_STAIRS_KEY = create("quartz_tile_stairs");
    public static final BlockItemId QUARTZ_TILE_SLAB_KEY = create("quartz_tile_slab");
    public static final BlockItemId QUARTZ_TILE_WALL_KEY = create("quartz_tile_wall");
    public static final BlockItemId CALCITE_BRICKS_KEY = create("calcite_bricks");
    public static final BlockItemId CALCITE_BRICK_STAIRS_KEY = create("calcite_brick_stairs");
    public static final BlockItemId CALCITE_BRICK_SLAB_KEY = create("calcite_brick_slab");
    public static final BlockItemId CALCITE_BRICK_WALL_KEY = create("calcite_brick_wall");
    public static final BlockItemId MOSSY_CALCITE_BRICKS_KEY = create("mossy_calcite_bricks");
    public static final BlockItemId MOSSY_CALCITE_BRICK_STAIRS_KEY
            = create("mossy_calcite_brick_stairs");
    public static final BlockItemId MOSSY_CALCITE_BRICK_SLAB_KEY
            = create("mossy_calcite_brick_slab");
    public static final BlockItemId MOSSY_CALCITE_BRICK_WALL_KEY
            = create("mossy_calcite_brick_wall");
    public static final BlockItemId CRACKED_CALCITE_BRICKS_KEY
            = create("cracked_calcite_bricks");
    public static final BlockItemId CRACKED_CALCITE_BRICK_STAIRS_KEY
            = create("cracked_calcite_brick_stairs");
    public static final BlockItemId CRACKED_CALCITE_BRICK_SLAB_KEY
            = create("cracked_calcite_brick_slab");
    public static final BlockItemId CRACKED_CALCITE_BRICK_WALL_KEY
            = create("cracked_calcite_brick_wall");
    public static final BlockItemId CHISELED_CALCITE_BRICKS_KEY
            = create("chiseled_calcite_bricks");
    public static final BlockItemId DRIPSTONE_BRICKS_KEY = create("dripstone_bricks");
    public static final BlockItemId DRIPSTONE_BRICK_STAIRS_KEY = create("dripstone_brick_stairs");
    public static final BlockItemId DRIPSTONE_BRICK_SLAB_KEY = create("dripstone_brick_slab");
    public static final BlockItemId DRIPSTONE_BRICK_WALL_KEY = create("dripstone_brick_wall");
    public static final BlockItemId MOSSY_DRIPSTONE_BRICKS_KEY = create("mossy_dripstone_bricks");
    public static final BlockItemId MOSSY_DRIPSTONE_BRICK_STAIRS_KEY
            = create("mossy_dripstone_brick_stairs");
    public static final BlockItemId MOSSY_DRIPSTONE_BRICK_SLAB_KEY
            = create("mossy_dripstone_brick_slab");
    public static final BlockItemId MOSSY_DRIPSTONE_BRICK_WALL_KEY
            = create("mossy_dripstone_brick_wall");
    public static final BlockItemId CRACKED_DRIPSTONE_BRICKS_KEY
            = create("cracked_dripstone_bricks");
    public static final BlockItemId CRACKED_DRIPSTONE_BRICK_STAIRS_KEY
            = create("cracked_dripstone_brick_stairs");
    public static final BlockItemId CRACKED_DRIPSTONE_BRICK_SLAB_KEY
            = create("cracked_dripstone_brick_slab");
    public static final BlockItemId CRACKED_DRIPSTONE_BRICK_WALL_KEY
            = create("cracked_dripstone_brick_wall");
    public static final BlockItemId CHISELED_DRIPSTONE_BRICKS_KEY
            = create("chiseled_dripstone_bricks");
    public static final ResourceKey<Block> BLOOD_KELP_KEY = createBlockId("blood_kelp");
    public static final ResourceKey<Block> BLOOD_KELP_PLANT_KEY = createBlockId("blood_kelp_plant");
    public static final BlockItemId DRIED_BLOOD_KELP_BLOCK_KEY = create("dried_blood_kelp_block");
    public static final BlockItemId BLOOD_KELP_LANTERN_KEY = create("blood_kelp_lantern");
    public static final BlockItemId BOG_BLOSSOM_KEY = create("bog_blossom");
    public static final ResourceKey<Block> CINDERSNAP_BERRY_BUSH_KEY = createBlockId("cindersnap_berry_bush");
    public static final ResourceKey<Block> FROSTBITE_BERRY_BUSH_KEY = createBlockId("frostbite_berry_bush");
    public static final BlockItemId POLISHED_DRIPSTONE_KEY = create("polished_dripstone");
    public static final BlockItemId POLISHED_DRIPSTONE_STAIRS_KEY
            = create("polished_dripstone_stairs");
    public static final BlockItemId POLISHED_DRIPSTONE_SLAB_KEY
            = create("polished_dripstone_slab");
    public static final BlockItemId POLISHED_DRIPSTONE_WALL_KEY
            = create("polished_dripstone_wall");
    public static final BlockItemId POLISHED_CALCITE_KEY = create("polished_calcite");
    public static final BlockItemId POLISHED_CALCITE_STAIRS_KEY
            = create("polished_calcite_stairs");
    public static final BlockItemId POLISHED_CALCITE_SLAB_KEY = create("polished_calcite_slab");
    public static final BlockItemId POLISHED_CALCITE_WALL_KEY = create("polished_calcite_wall");
    public static final BlockItemId DRIPSTONE_STAIRS_KEY = create("dripstone_stairs");
    public static final BlockItemId DRIPSTONE_SLAB_KEY = create("dripstone_slab");
    public static final BlockItemId DRIPSTONE_WALL_KEY = create("dripstone_wall");
    public static final BlockItemId CALCITE_STAIRS_KEY = create("calcite_stairs");
    public static final BlockItemId CALCITE_SLAB_KEY = create("calcite_slab");
    public static final BlockItemId CALCITE_WALL_KEY = create("calcite_wall");
    public static final BlockItemId BAMBOO_PLANTER_BOX_KEY = create("bamboo_planter_box");
    public static final ResourceKey<Block> POTTED_CATTAIL_KEY = createBlockId("potted_cattail");
    public static final BlockItemId STONE_WALL_KEY = create("stone_wall");
    public static final BlockItemId QUARTZ_WALL_KEY = create("quartz_wall");
    public static final BlockItemId SMOOTH_QUARTZ_WALL_KEY = create("smooth_quartz_wall");
    public static final BlockItemId GRASS_SLAB_KEY = create("grass_slab");
    public static final BlockItemId PODZOL_SLAB_KEY = create("podzol_slab");
    public static final BlockItemId MYCELIUM_SLAB_KEY = create("mycelium_slab");
    public static final BlockItemId DIRT_PATH_SLAB_KEY = create("dirt_path_slab");
    public static final BlockItemId DIRT_SLAB_KEY = create("dirt_slab");
    public static final BlockItemId COARSE_DIRT_SLAB_KEY = create("coarse_dirt_slab");
    public static final BlockItemId ROOTED_DIRT_SLAB_KEY = create("rooted_dirt_slab");
    public static final BlockItemId WILD_GREEN_ONIONS_KEY = create("wild_green_onions");
    public static final BlockItemId CREAKING_PLUSHIE_KEY = create("creaking_plushie");
    public static final BlockItemId QUARTZ_BRICK_STAIRS_KEY = create("quartz_brick_stairs");
    public static final BlockItemId QUARTZ_BRICK_SLAB_KEY = create("quartz_brick_slab");
    public static final BlockItemId QUARTZ_BRICK_WALL_KEY = create("quartz_brick_wall");
    public static final BlockItemId SNIFFER_PLUSHIE_KEY = create("sniffer_plushie");
    public static final BlockItemId STRIPPED_PALE_OAK_WALL_KEY = create("stripped_pale_oak_wall");
    public static final BlockItemId PALE_OAK_WALL_KEY = create("pale_oak_wall");
    public static final BlockItemId BAMBOO_ROPE_LADDER_KEY = create("bamboo_rope_ladder");
    public static final BlockItemId STRIPPED_BAMBOO_WALL_KEY = create("stripped_bamboo_wall");
    public static final BlockItemId BAMBOO_WALL_KEY = create("bamboo_wall");
    public static final BlockItemId BLACK_WOLF_PLUSHIE_KEY = create("black_wolf_plushie");
    public static final BlockItemId ASHEN_WOLF_PLUSHIE_KEY = create("ashen_wolf_plushie");
    public static final BlockItemId CHESTNUT_WOLF_PLUSHIE_KEY = create("chestnut_wolf_plushie");
    public static final BlockItemId RUSTY_WOLF_PLUSHIE_KEY = create("rusty_wolf_plushie");
    public static final ColorCollection<BlockItemId> DYED_LANTERN_KEYS = createSimpleColored("lantern");
    public static final ColorCollection<BlockItemId> DYED_SHEEP_KEYS = createSimpleColored("sheep_plushie");

    private ModBlockIds() {}

    private static BlockItemId create(String name) {
        Identifier id = AssortedDiscoveries.makeModId(name);
        return BlockItemId.create(id, id);
    }

    private static ResourceKey<Block> createBlockId(String name) {
        Identifier id = AssortedDiscoveries.makeModId(name);
        return ResourceKey.create(Registries.BLOCK, id);
    }

    private static ColorCollection<BlockItemId> createSimpleColored(final String baseName) {
        return ColorCollection.prefixWithColor(ColorCollection.create(baseName)).map(ModBlockIds::create);
    }
}
