package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Direction;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.item.*;

public class ADItems {
    public static final Item BAT_PLUSHIE = blockItem(ADBlocks.BAT_PLUSHIE);
    public static final Item BLAZE_PLUSHIE = blockItem(ADBlocks.BLAZE_PLUSHIE);
    public static final Item CAVE_SPIDER_PLUSHIE = blockItem(ADBlocks.CAVE_SPIDER_PLUSHIE);
    public static final Item CHICKEN_PLUSHIE = blockItem(ADBlocks.CHICKEN_PLUSHIE);
    public static final Item COW_PLUSHIE = blockItem(ADBlocks.COW_PLUSHIE);
    public static final Item CREEPER_PLUSHIE = blockItem(ADBlocks.CREEPER_PLUSHIE);
    public static final Item ENDERMAN_PLUSHIE = blockItem(ADBlocks.ENDERMAN_PLUSHIE);
    public static final Item GHAST_PLUSHIE = blockItem(ADBlocks.GHAST_PLUSHIE);
    public static final Item GUARDIAN_PLUSHIE = blockItem(ADBlocks.GUARDIAN_PLUSHIE);
    public static final Item WHITE_HORSE_PLUSHIE = blockItem(ADBlocks.WHITE_HORSE_PLUSHIE);
    public static final Item GRAY_HORSE_PLUSHIE = blockItem(ADBlocks.GRAY_HORSE_PLUSHIE);
    public static final Item LIGHT_GRAY_HORSE_PLUSHIE = blockItem(ADBlocks.LIGHT_GRAY_HORSE_PLUSHIE);
    public static final Item BROWN_HORSE_PLUSHIE = blockItem(ADBlocks.BROWN_HORSE_PLUSHIE);
    public static final Item BLACK_HORSE_PLUSHIE = blockItem(ADBlocks.BLACK_HORSE_PLUSHIE);
    public static final Item MAGMA_CUBE_PLUSHIE = blockItem(ADBlocks.MAGMA_CUBE_PLUSHIE);
    public static final Item RED_MOOSHROOM_PLUSHIE = blockItem(ADBlocks.RED_MOOSHROOM_PLUSHIE);
    public static final Item BROWN_MOOSHROOM_PLUSHIE = blockItem(ADBlocks.BROWN_MOOSHROOM_PLUSHIE);
    public static final Item OCELOT_PLUSHIE = blockItem(ADBlocks.OCELOT_PLUSHIE);
    public static final Item TABBY_CAT_PLUSHIE = blockItem(ADBlocks.TABBY_CAT_PLUSHIE);
    public static final Item TUXEDO_CAT_PLUSHIE = blockItem(ADBlocks.TUXEDO_CAT_PLUSHIE);
    public static final Item RED_CAT_PLUSHIE = blockItem(ADBlocks.RED_CAT_PLUSHIE);
    public static final Item SIAMESE_CAT_PLUSHIE = blockItem(ADBlocks.SIAMESE_CAT_PLUSHIE);
    public static final Item BRITISH_SHORTHAIR_CAT_PLUSHIE = blockItem(ADBlocks.BRITISH_SHORTHAIR_CAT_PLUSHIE);
    public static final Item CALICO_CAT_PLUSHIE = blockItem(ADBlocks.CALICO_CAT_PLUSHIE);
    public static final Item PERSIAN_CAT_PLUSHIE = blockItem(ADBlocks.PERSIAN_CAT_PLUSHIE);
    public static final Item RAGDOLL_CAT_PLUSHIE = blockItem(ADBlocks.RAGDOLL_CAT_PLUSHIE);
    public static final Item WHITE_CAT_PLUSHIE = blockItem(ADBlocks.WHITE_CAT_PLUSHIE);
    public static final Item JELLIE_CAT_PLUSHIE = blockItem(ADBlocks.JELLIE_CAT_PLUSHIE);
    public static final Item BLACK_CAT_PLUSHIE = blockItem(ADBlocks.BLACK_CAT_PLUSHIE);
    public static final Item PIG_PLUSHIE = blockItem(ADBlocks.PIG_PLUSHIE);
    public static final Item BROWN_RABBIT_PLUSHIE = blockItem(ADBlocks.BROWN_RABBIT_PLUSHIE);
    public static final Item WHITE_RABBIT_PLUSHIE = blockItem(ADBlocks.WHITE_RABBIT_PLUSHIE);
    public static final Item BLACK_RABBIT_PLUSHIE = blockItem(ADBlocks.BLACK_RABBIT_PLUSHIE);
    public static final Item WHITE_SPLOTCHED_RABBIT_PLUSHIE = blockItem(ADBlocks.WHITE_SPLOTCHED_RABBIT_PLUSHIE);
    public static final Item GOLD_RABBIT_PLUSHIE = blockItem(ADBlocks.GOLD_RABBIT_PLUSHIE);
    public static final Item TOAST_RABBIT_PLUSHIE = blockItem(ADBlocks.TOAST_RABBIT_PLUSHIE);
    public static final Item SALT_RABBIT_PLUSHIE = blockItem(ADBlocks.SALT_RABBIT_PLUSHIE);
    public static final Item WHITE_SHEEP_PLUSHIE = blockItem(ADBlocks.WHITE_SHEEP_PLUSHIE);
    public static final Item ORANGE_SHEEP_PLUSHIE = blockItem(ADBlocks.ORANGE_SHEEP_PLUSHIE);
    public static final Item MAGENTA_SHEEP_PLUSHIE = blockItem(ADBlocks.MAGENTA_SHEEP_PLUSHIE);
    public static final Item LIGHT_BLUE_SHEEP_PLUSHIE = blockItem(ADBlocks.LIGHT_BLUE_SHEEP_PLUSHIE);
    public static final Item YELLOW_SHEEP_PLUSHIE = blockItem(ADBlocks.YELLOW_SHEEP_PLUSHIE);
    public static final Item LIME_SHEEP_PLUSHIE = blockItem(ADBlocks.LIME_SHEEP_PLUSHIE);
    public static final Item PINK_SHEEP_PLUSHIE = blockItem(ADBlocks.PINK_SHEEP_PLUSHIE);
    public static final Item GRAY_SHEEP_PLUSHIE = blockItem(ADBlocks.GRAY_SHEEP_PLUSHIE);
    public static final Item LIGHT_GRAY_SHEEP_PLUSHIE = blockItem(ADBlocks.LIGHT_GRAY_SHEEP_PLUSHIE);
    public static final Item CYAN_SHEEP_PLUSHIE = blockItem(ADBlocks.CYAN_SHEEP_PLUSHIE);
    public static final Item PURPLE_SHEEP_PLUSHIE = blockItem(ADBlocks.PURPLE_SHEEP_PLUSHIE);
    public static final Item BLUE_SHEEP_PLUSHIE = blockItem(ADBlocks.BLUE_SHEEP_PLUSHIE);
    public static final Item BROWN_SHEEP_PLUSHIE = blockItem(ADBlocks.BROWN_SHEEP_PLUSHIE);
    public static final Item GREEN_SHEEP_PLUSHIE = blockItem(ADBlocks.GREEN_SHEEP_PLUSHIE);
    public static final Item RED_SHEEP_PLUSHIE = blockItem(ADBlocks.RED_SHEEP_PLUSHIE);
    public static final Item BLACK_SHEEP_PLUSHIE = blockItem(ADBlocks.BLACK_SHEEP_PLUSHIE);
    public static final Item MAROON_SHEEP_PLUSHIE = blockItem(ADBlocks.MAROON_SHEEP_PLUSHIE);
    public static final Item SKELETON_PLUSHIE = blockItem(ADBlocks.SKELETON_PLUSHIE);
    public static final Item SLIME_PLUSHIE = blockItem(ADBlocks.SLIME_PLUSHIE);
    public static final Item SPIDER_PLUSHIE = blockItem(ADBlocks.SPIDER_PLUSHIE);
    public static final Item SQUID_PLUSHIE = blockItem(ADBlocks.SQUID_PLUSHIE);
    public static final Item GLOW_SQUID_PLUSHIE = blockItem(ADBlocks.GLOW_SQUID_PLUSHIE);
    public static final Item BEE_PLUSHIE = blockItem(ADBlocks.BEE_PLUSHIE);
    public static final Item PLAINS_VILLAGER_PLUSHIE = blockItem(ADBlocks.PLAINS_VILLAGER_PLUSHIE);
    public static final Item DESERT_VILLAGER_PLUSHIE = blockItem(ADBlocks.DESERT_VILLAGER_PLUSHIE);
    public static final Item JUNGLE_VILLAGER_PLUSHIE = blockItem(ADBlocks.JUNGLE_VILLAGER_PLUSHIE);
    public static final Item SAVANNA_VILLAGER_PLUSHIE = blockItem(ADBlocks.SAVANNA_VILLAGER_PLUSHIE);
    public static final Item SNOW_VILLAGER_PLUSHIE = blockItem(ADBlocks.SNOW_VILLAGER_PLUSHIE);
    public static final Item SWAMP_VILLAGER_PLUSHIE = blockItem(ADBlocks.SWAMP_VILLAGER_PLUSHIE);
    public static final Item TAIGA_VILLAGER_PLUSHIE = blockItem(ADBlocks.TAIGA_VILLAGER_PLUSHIE);
    public static final Item CRIMSON_VILLAGER_PLUSHIE = blockItem(ADBlocks.CRIMSON_VILLAGER_PLUSHIE);
    public static final Item WARPED_VILLAGER_PLUSHIE = blockItem(ADBlocks.WARPED_VILLAGER_PLUSHIE);
    public static final Item WANDERING_TRADER_PLUSHIE = blockItem(ADBlocks.WANDERING_TRADER_PLUSHIE);
    public static final Item PLAINS_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.PLAINS_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item DESERT_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.DESERT_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item JUNGLE_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.JUNGLE_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item SAVANNA_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.SAVANNA_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item SNOW_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.SNOW_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item SWAMP_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.SWAMP_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item TAIGA_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.TAIGA_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item CRIMSON_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.CRIMSON_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item WARPED_ZOMBIE_VILLAGER_PLUSHIE = blockItem(ADBlocks.WARPED_ZOMBIE_VILLAGER_PLUSHIE);
    public static final Item WITCH_PLUSHIE = blockItem(ADBlocks.WITCH_PLUSHIE);
    public static final Item PALE_WOLF_PLUSHIE = blockItem(ADBlocks.PALE_WOLF_PLUSHIE);
    public static final Item ZOMBIE_PLUSHIE = blockItem(ADBlocks.ZOMBIE_PLUSHIE);
    public static final Item PIGLIN_PLUSHIE = blockItem(ADBlocks.PIGLIN_PLUSHIE);
    public static final Item ZOMBIFIED_PIGLIN_PLUSHIE = blockItem(ADBlocks.ZOMBIFIED_PIGLIN_PLUSHIE);
    public static final Item PUFFERFISH_PLUSHIE = blockItem(ADBlocks.PUFFERFISH_PLUSHIE);
    public static final Item WITHER_PLUSHIE = blockItem(ADBlocks.WITHER_PLUSHIE);
    public static final Item STRIDER_PLUSHIE = blockItem(ADBlocks.STRIDER_PLUSHIE);
    public static final Item SHIVERING_STRIDER_PLUSHIE = blockItem(ADBlocks.SHIVERING_STRIDER_PLUSHIE);
    public static final Item PHANTOM_PLUSHIE = blockItem(ADBlocks.PHANTOM_PLUSHIE);
    public static final Item HOGLIN_PLUSHIE = blockItem(ADBlocks.HOGLIN_PLUSHIE);
    public static final Item ZOGLIN_PLUSHIE = blockItem(ADBlocks.ZOGLIN_PLUSHIE);
    public static final Item POLAR_BEAR_PLUSHIE = blockItem(ADBlocks.POLAR_BEAR_PLUSHIE);
    public static final Item ALLAY_PLUSHIE = blockItem(ADBlocks.ALLAY_PLUSHIE);
    public static final Item PILLAGER_PLUSHIE = blockItem(ADBlocks.PILLAGER_PLUSHIE);
    public static final Item VINDICATOR_PLUSHIE = blockItem(ADBlocks.VINDICATOR_PLUSHIE);
    public static final Item EVOKER_PLUSHIE = blockItem(ADBlocks.EVOKER_PLUSHIE);
    public static final Item RAVAGER_PLUSHIE = blockItem(ADBlocks.RAVAGER_PLUSHIE);
    public static final Item SHULKER_PLUSHIE = blockItem(ADBlocks.SHULKER_PLUSHIE);
    public static final Item VEX_PLUSHIE = blockItem(ADBlocks.VEX_PLUSHIE);
    public static final Item NETHER_SMOKY_QUARTZ_ORE = blockItem(ADBlocks.NETHER_SMOKY_QUARTZ_ORE);
    public static final Item SMOKY_QUARTZ_BLOCK = blockItem(ADBlocks.SMOKY_QUARTZ_BLOCK);
    public static final Item CHISELED_SMOKY_QUARTZ_BLOCK = blockItem(ADBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
    public static final Item SMOKY_QUARTZ_BRICKS = blockItem(ADBlocks.SMOKY_QUARTZ_BRICKS);
    public static final Item SMOKY_QUARTZ_BRICK_STAIRS = blockItem(ADBlocks.SMOKY_QUARTZ_BRICK_STAIRS);
    public static final Item SMOKY_QUARTZ_BRICK_SLAB = blockItem(ADBlocks.SMOKY_QUARTZ_BRICK_SLAB);
    public static final Item SMOKY_QUARTZ_BRICK_WALL = blockItem(ADBlocks.SMOKY_QUARTZ_BRICK_WALL);
    public static final Item SMOKY_QUARTZ_PILLAR = blockItem(ADBlocks.SMOKY_QUARTZ_PILLAR);
    public static final Item SMOKY_QUARTZ_STAIRS = blockItem(ADBlocks.SMOKY_QUARTZ_STAIRS);
    public static final Item SMOKY_QUARTZ_SLAB = blockItem(ADBlocks.SMOKY_QUARTZ_SLAB);
    public static final Item SMOKY_QUARTZ_WALL = blockItem(ADBlocks.SMOKY_QUARTZ_WALL);
    public static final Item SMOOTH_SMOKY_QUARTZ = blockItem(ADBlocks.SMOOTH_SMOKY_QUARTZ);
    public static final Item SMOOTH_SMOKY_QUARTZ_STAIRS = blockItem(ADBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
    public static final Item SMOOTH_SMOKY_QUARTZ_SLAB = blockItem(ADBlocks.SMOOTH_SMOKY_QUARTZ_SLAB);
    public static final Item SMOOTH_SMOKY_QUARTZ_WALL = blockItem(ADBlocks.SMOOTH_SMOKY_QUARTZ_WALL);
    public static final Item CRACKED_STONE_BRICK_STAIRS = blockItem(ADBlocks.CRACKED_STONE_BRICK_STAIRS);
    public static final Item CRACKED_STONE_BRICK_SLAB = blockItem(ADBlocks.CRACKED_STONE_BRICK_SLAB);
    public static final Item CRACKED_STONE_BRICK_WALL = blockItem(ADBlocks.CRACKED_STONE_BRICK_WALL);
    public static final Item OAK_PLANTER_BOX = blockItem(ADBlocks.OAK_PLANTER_BOX);
    public static final Item SPRUCE_PLANTER_BOX = blockItem(ADBlocks.SPRUCE_PLANTER_BOX);
    public static final Item BIRCH_PLANTER_BOX = blockItem(ADBlocks.BIRCH_PLANTER_BOX);
    public static final Item JUNGLE_PLANTER_BOX = blockItem(ADBlocks.JUNGLE_PLANTER_BOX);
    public static final Item ACACIA_PLANTER_BOX = blockItem(ADBlocks.ACACIA_PLANTER_BOX);
    public static final Item DARK_OAK_PLANTER_BOX = blockItem(ADBlocks.DARK_OAK_PLANTER_BOX);
    public static final Item MANGROVE_PLANTER_BOX = blockItem(ADBlocks.MANGROVE_PLANTER_BOX);
    public static final Item CHERRY_PLANTER_BOX = blockItem(ADBlocks.CHERRY_PLANTER_BOX);
    public static final Item CRIMSON_PLANTER_BOX = blockItem(ADBlocks.CRIMSON_PLANTER_BOX);
    public static final Item WARPED_PLANTER_BOX = blockItem(ADBlocks.WARPED_PLANTER_BOX);
    public static final Item OAK_WALL = blockItem(ADBlocks.OAK_WALL);
    public static final Item SPRUCE_WALL = blockItem(ADBlocks.SPRUCE_WALL);
    public static final Item BIRCH_WALL = blockItem(ADBlocks.BIRCH_WALL);
    public static final Item JUNGLE_WALL = blockItem(ADBlocks.JUNGLE_WALL);
    public static final Item ACACIA_WALL = blockItem(ADBlocks.ACACIA_WALL);
    public static final Item DARK_OAK_WALL = blockItem(ADBlocks.DARK_OAK_WALL);
    public static final Item MANGROVE_WALL = blockItem(ADBlocks.MANGROVE_WALL);
    public static final Item CRIMSON_WALL = blockItem(ADBlocks.CRIMSON_WALL);
    public static final Item WARPED_WALL = blockItem(ADBlocks.WARPED_WALL);
    public static final Item CHERRY_WALL = blockItem(ADBlocks.CHERRY_WALL);
    public static final Item STRIPPED_OAK_WALL = blockItem(ADBlocks.STRIPPED_OAK_WALL);
    public static final Item STRIPPED_SPRUCE_WALL = blockItem(ADBlocks.STRIPPED_SPRUCE_WALL);
    public static final Item STRIPPED_BIRCH_WALL = blockItem(ADBlocks.STRIPPED_BIRCH_WALL);
    public static final Item STRIPPED_JUNGLE_WALL = blockItem(ADBlocks.STRIPPED_JUNGLE_WALL);
    public static final Item STRIPPED_ACACIA_WALL = blockItem(ADBlocks.STRIPPED_ACACIA_WALL);
    public static final Item STRIPPED_DARK_OAK_WALL = blockItem(ADBlocks.STRIPPED_DARK_OAK_WALL);
    public static final Item STRIPPED_MANGROVE_WALL = blockItem(ADBlocks.STRIPPED_MANGROVE_WALL);
    public static final Item STRIPPED_CRIMSON_WALL = blockItem(ADBlocks.STRIPPED_CRIMSON_WALL);
    public static final Item STRIPPED_WARPED_WALL = blockItem(ADBlocks.STRIPPED_WARPED_WALL);
    public static final Item STRIPPED_CHERRY_WALL = blockItem(ADBlocks.STRIPPED_CHERRY_WALL);
    public static final Item OAK_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.OAK_ROPE_LADDER);
    public static final Item SPRUCE_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.SPRUCE_ROPE_LADDER);
    public static final Item BIRCH_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.BIRCH_ROPE_LADDER);
    public static final Item JUNGLE_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.JUNGLE_ROPE_LADDER);
    public static final Item ACACIA_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.ACACIA_ROPE_LADDER);
    public static final Item DARK_OAK_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.DARK_OAK_ROPE_LADDER);
    public static final Item CRIMSON_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.CRIMSON_ROPE_LADDER);
    public static final Item WARPED_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.WARPED_ROPE_LADDER);
    public static final Item MANGROVE_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.MANGROVE_ROPE_LADDER);
    public static final Item CHERRY_ROPE_LADDER = ropeLadderBlockItem(ADBlocks.CHERRY_ROPE_LADDER);
    public static final Item IRON_LADDER = blockItem(ADBlocks.IRON_LADDER);
    public static final Item SNOW_BRICKS = blockItem(ADBlocks.SNOW_BRICKS);
    public static final Item SNOW_BRICK_STAIRS = blockItem(ADBlocks.SNOW_BRICK_STAIRS);
    public static final Item SNOW_BRICK_SLAB = blockItem(ADBlocks.SNOW_BRICK_SLAB);
    public static final Item SNOW_BRICK_WALL = blockItem(ADBlocks.SNOW_BRICK_WALL);
    public static final Item PACKED_SNOW = blockItem(ADBlocks.PACKED_SNOW);
    public static final Item PACKED_SNOW_STAIRS = blockItem(ADBlocks.PACKED_SNOW_STAIRS);
    public static final Item PACKED_SNOW_SLAB = blockItem(ADBlocks.PACKED_SNOW_SLAB);
    public static final Item PACKED_SNOW_WALL = blockItem(ADBlocks.PACKED_SNOW_WALL);
    public static final Item PURPLE_MUSHROOM = blockItem(ADBlocks.PURPLE_MUSHROOM);
    public static final Item PURPLE_MUSHROOM_BLOCK = blockItem(ADBlocks.PURPLE_MUSHROOM_BLOCK);
    public static final Item WOODCUTTER = blockItem(ADBlocks.WOODCUTTER);
    public static final Item WHITE_CAMPFIRE = blockItem(ADBlocks.WHITE_CAMPFIRE);
    public static final Item ORANGE_CAMPFIRE = blockItem(ADBlocks.ORANGE_CAMPFIRE);
    public static final Item MAGENTA_CAMPFIRE = blockItem(ADBlocks.MAGENTA_CAMPFIRE);
    public static final Item LIGHT_BLUE_CAMPFIRE = blockItem(ADBlocks.LIGHT_BLUE_CAMPFIRE);
    public static final Item YELLOW_CAMPFIRE = blockItem(ADBlocks.YELLOW_CAMPFIRE);
    public static final Item LIME_CAMPFIRE = blockItem(ADBlocks.LIME_CAMPFIRE);
    public static final Item PINK_CAMPFIRE = blockItem(ADBlocks.PINK_CAMPFIRE);
    public static final Item GRAY_CAMPFIRE = blockItem(ADBlocks.GRAY_CAMPFIRE);
    public static final Item LIGHT_GRAY_CAMPFIRE = blockItem(ADBlocks.LIGHT_GRAY_CAMPFIRE);
    public static final Item CYAN_CAMPFIRE = blockItem(ADBlocks.CYAN_CAMPFIRE);
    public static final Item PURPLE_CAMPFIRE = blockItem(ADBlocks.PURPLE_CAMPFIRE);
    public static final Item BLUE_CAMPFIRE = blockItem(ADBlocks.BLUE_CAMPFIRE);
    public static final Item BROWN_CAMPFIRE = blockItem(ADBlocks.BROWN_CAMPFIRE);
    public static final Item GREEN_CAMPFIRE = blockItem(ADBlocks.GREEN_CAMPFIRE);
    public static final Item RED_CAMPFIRE = blockItem(ADBlocks.RED_CAMPFIRE);
    public static final Item BLACK_CAMPFIRE = blockItem(ADBlocks.BLACK_CAMPFIRE);
    public static final Item MAROON_CAMPFIRE = blockItem(ADBlocks.MAROON_CAMPFIRE);
    public static final Item WHITE_LANTERN = blockItem(ADBlocks.WHITE_LANTERN);
    public static final Item ORANGE_LANTERN = blockItem(ADBlocks.ORANGE_LANTERN);
    public static final Item MAGENTA_LANTERN = blockItem(ADBlocks.MAGENTA_LANTERN);
    public static final Item LIGHT_BLUE_LANTERN = blockItem(ADBlocks.LIGHT_BLUE_LANTERN);
    public static final Item YELLOW_LANTERN = blockItem(ADBlocks.YELLOW_LANTERN);
    public static final Item LIME_LANTERN = blockItem(ADBlocks.LIME_LANTERN);
    public static final Item PINK_LANTERN = blockItem(ADBlocks.PINK_LANTERN);
    public static final Item GRAY_LANTERN = blockItem(ADBlocks.GRAY_LANTERN);
    public static final Item LIGHT_GRAY_LANTERN = blockItem(ADBlocks.LIGHT_GRAY_LANTERN);
    public static final Item CYAN_LANTERN = blockItem(ADBlocks.CYAN_LANTERN);
    public static final Item PURPLE_LANTERN = blockItem(ADBlocks.PURPLE_LANTERN);
    public static final Item BLUE_LANTERN = blockItem(ADBlocks.BLUE_LANTERN);
    public static final Item BROWN_LANTERN = blockItem(ADBlocks.BROWN_LANTERN);
    public static final Item GREEN_LANTERN = blockItem(ADBlocks.GREEN_LANTERN);
    public static final Item RED_LANTERN = blockItem(ADBlocks.RED_LANTERN);
    public static final Item BLACK_LANTERN = blockItem(ADBlocks.BLACK_LANTERN);
    public static final Item MAROON_LANTERN = blockItem(ADBlocks.MAROON_LANTERN);
    public static final Item WHITE_TORCH = wallStandingBlockItem(ADBlocks.WHITE_TORCH, ADBlocks.WHITE_WALL_TORCH);
    public static final Item ORANGE_TORCH = wallStandingBlockItem(ADBlocks.ORANGE_TORCH, ADBlocks.ORANGE_WALL_TORCH);
    public static final Item MAGENTA_TORCH = wallStandingBlockItem(ADBlocks.MAGENTA_TORCH, ADBlocks.MAGENTA_WALL_TORCH);
    public static final Item LIGHT_BLUE_TORCH = wallStandingBlockItem(ADBlocks.LIGHT_BLUE_TORCH, ADBlocks.LIGHT_BLUE_WALL_TORCH);
    public static final Item YELLOW_TORCH = wallStandingBlockItem(ADBlocks.YELLOW_TORCH, ADBlocks.YELLOW_WALL_TORCH);
    public static final Item LIME_TORCH = wallStandingBlockItem(ADBlocks.LIME_TORCH, ADBlocks.LIME_WALL_TORCH);
    public static final Item PINK_TORCH = wallStandingBlockItem(ADBlocks.PINK_TORCH, ADBlocks.PINK_WALL_TORCH);
    public static final Item GRAY_TORCH = wallStandingBlockItem(ADBlocks.GRAY_TORCH, ADBlocks.GRAY_WALL_TORCH);
    public static final Item LIGHT_GRAY_TORCH = wallStandingBlockItem(ADBlocks.LIGHT_GRAY_TORCH, ADBlocks.LIGHT_GRAY_WALL_TORCH);
    public static final Item CYAN_TORCH = wallStandingBlockItem(ADBlocks.CYAN_TORCH, ADBlocks.CYAN_WALL_TORCH);
    public static final Item PURPLE_TORCH = wallStandingBlockItem(ADBlocks.PURPLE_TORCH, ADBlocks.PURPLE_WALL_TORCH);
    public static final Item BLUE_TORCH = wallStandingBlockItem(ADBlocks.BLUE_TORCH, ADBlocks.BLUE_WALL_TORCH);
    public static final Item BROWN_TORCH = wallStandingBlockItem(ADBlocks.BROWN_TORCH, ADBlocks.BROWN_WALL_TORCH);
    public static final Item GREEN_TORCH = wallStandingBlockItem(ADBlocks.GREEN_TORCH, ADBlocks.GREEN_WALL_TORCH);
    public static final Item RED_TORCH = wallStandingBlockItem(ADBlocks.RED_TORCH, ADBlocks.RED_WALL_TORCH);
    public static final Item BLACK_TORCH = wallStandingBlockItem(ADBlocks.BLACK_TORCH, ADBlocks.BLACK_WALL_TORCH);
    public static final Item MAROON_TORCH = wallStandingBlockItem(ADBlocks.MAROON_TORCH, ADBlocks.MAROON_WALL_TORCH);
    public static final Item BAUXITE = blockItem(ADBlocks.BAUXITE);
    public static final Item BAUXITE_SLAB = blockItem(ADBlocks.BAUXITE_SLAB);
    public static final Item BAUXITE_STAIRS = blockItem(ADBlocks.BAUXITE_STAIRS);
    public static final Item BAUXITE_WALL = blockItem(ADBlocks.BAUXITE_WALL);
    public static final Item BAUXITE_BRICKS = blockItem(ADBlocks.BAUXITE_BRICKS);
    public static final Item BAUXITE_BRICK_STAIRS = blockItem(ADBlocks.BAUXITE_BRICK_STAIRS);
    public static final Item BAUXITE_BRICK_SLAB = blockItem(ADBlocks.BAUXITE_BRICK_SLAB);
    public static final Item BAUXITE_BRICK_WALL = blockItem(ADBlocks.BAUXITE_BRICK_WALL);
    public static final Item MOSSY_BAUXITE_BRICKS = blockItem(ADBlocks.MOSSY_BAUXITE_BRICKS);
    public static final Item MOSSY_BAUXITE_BRICK_STAIRS = blockItem(ADBlocks.MOSSY_BAUXITE_BRICK_STAIRS);
    public static final Item MOSSY_BAUXITE_BRICK_SLAB = blockItem(ADBlocks.MOSSY_BAUXITE_BRICK_SLAB);
    public static final Item MOSSY_BAUXITE_BRICK_WALL = blockItem(ADBlocks.MOSSY_BAUXITE_BRICK_WALL);
    public static final Item CRACKED_BAUXITE_BRICKS = blockItem(ADBlocks.CRACKED_BAUXITE_BRICKS);
    public static final Item CRACKED_BAUXITE_BRICK_STAIRS = blockItem(ADBlocks.CRACKED_BAUXITE_BRICK_STAIRS);
    public static final Item CRACKED_BAUXITE_BRICK_SLAB = blockItem(ADBlocks.CRACKED_BAUXITE_BRICK_SLAB);
    public static final Item CRACKED_BAUXITE_BRICK_WALL = blockItem(ADBlocks.CRACKED_BAUXITE_BRICK_WALL);
    public static final Item TWISTED_NETHER_BRICKS = blockItem(ADBlocks.TWISTED_NETHER_BRICKS);
    public static final Item TWISTED_NETHER_BRICK_STAIRS = blockItem(ADBlocks.TWISTED_NETHER_BRICK_STAIRS);
    public static final Item TWISTED_NETHER_BRICK_SLAB = blockItem(ADBlocks.TWISTED_NETHER_BRICK_SLAB);
    public static final Item TWISTED_NETHER_BRICK_WALL = blockItem(ADBlocks.TWISTED_NETHER_BRICK_WALL);
    public static final Item TWISTED_NETHERRACK = blockItem(ADBlocks.TWISTED_NETHERRACK);
    public static final Item TWISTED_NETHERRACK_STAIRS = blockItem(ADBlocks.TWISTED_NETHERRACK_STAIRS);
    public static final Item TWISTED_NETHERRACK_SLAB = blockItem(ADBlocks.TWISTED_NETHERRACK_SLAB);
    public static final Item TWISTED_NETHERRACK_WALL = blockItem(ADBlocks.TWISTED_NETHERRACK_WALL);
    public static final Item WEEPING_NETHER_BRICKS = blockItem(ADBlocks.WEEPING_NETHER_BRICKS);
    public static final Item WEEPING_NETHER_BRICK_STAIRS = blockItem(ADBlocks.WEEPING_NETHER_BRICK_STAIRS);
    public static final Item WEEPING_NETHER_BRICK_SLAB = blockItem(ADBlocks.WEEPING_NETHER_BRICK_SLAB);
    public static final Item WEEPING_NETHER_BRICK_WALL = blockItem(ADBlocks.WEEPING_NETHER_BRICK_WALL);
    public static final Item WEEPING_NETHERRACK = blockItem(ADBlocks.WEEPING_NETHERRACK);
    public static final Item WEEPING_NETHERRACK_STAIRS = blockItem(ADBlocks.WEEPING_NETHERRACK_STAIRS);
    public static final Item WEEPING_NETHERRACK_SLAB = blockItem(ADBlocks.WEEPING_NETHERRACK_SLAB);
    public static final Item WEEPING_NETHERRACK_WALL = blockItem(ADBlocks.WEEPING_NETHERRACK_WALL);
    public static final Item SNAPDRAGON = blockItem(ADBlocks.SNAPDRAGON);
    public static final Item SHORT_ENDER_GRASS = blockItem(ADBlocks.SHORT_ENDER_GRASS);
    public static final Item CHOCOLATE_CAKE = blockItem(ADBlocks.CHOCOLATE_CAKE);
    public static final Item RED_VELVET_CAKE = blockItem(ADBlocks.RED_VELVET_CAKE);
    public static final Item STONE_TILES = blockItem(ADBlocks.STONE_TILES);
    public static final Item STONE_TILE_SLAB = blockItem(ADBlocks.STONE_TILE_SLAB);
    public static final Item STONE_TILE_STAIRS = blockItem(ADBlocks.STONE_TILE_STAIRS);
    public static final Item STONE_TILE_WALL = blockItem(ADBlocks.STONE_TILE_WALL);
    public static final Item MOSSY_STONE_TILES = blockItem(ADBlocks.MOSSY_STONE_TILES);
    public static final Item MOSSY_STONE_TILE_SLAB = blockItem(ADBlocks.MOSSY_STONE_TILE_SLAB);
    public static final Item MOSSY_STONE_TILE_STAIRS = blockItem(ADBlocks.MOSSY_STONE_TILE_STAIRS);
    public static final Item MOSSY_STONE_TILE_WALL = blockItem(ADBlocks.MOSSY_STONE_TILE_WALL);
    public static final Item CRACKED_STONE_TILES = blockItem(ADBlocks.CRACKED_STONE_TILES);
    public static final Item CRACKED_STONE_TILE_SLAB = blockItem(ADBlocks.CRACKED_STONE_TILE_SLAB);
    public static final Item CRACKED_STONE_TILE_STAIRS = blockItem(ADBlocks.CRACKED_STONE_TILE_STAIRS);
    public static final Item CRACKED_STONE_TILE_WALL = blockItem(ADBlocks.CRACKED_STONE_TILE_WALL);
    public static final Item SWEET_BERRY_PIE = blockItem(ADBlocks.SWEET_BERRY_PIE);
    public static final Item BLUEBERRY_PIE = blockItem(ADBlocks.BLUEBERRY_PIE);
    public static final Item BLACKSTONE_TILES = blockItem(ADBlocks.BLACKSTONE_TILES);
    public static final Item BLACKSTONE_TILE_STAIRS = blockItem(ADBlocks.BLACKSTONE_TILE_STAIRS);
    public static final Item BLACKSTONE_TILE_SLAB = blockItem(ADBlocks.BLACKSTONE_TILE_SLAB);
    public static final Item BLACKSTONE_TILE_WALL = blockItem(ADBlocks.BLACKSTONE_TILE_WALL);
    public static final Item TWISTED_BLACKSTONE_TILES = blockItem(ADBlocks.TWISTED_BLACKSTONE_TILES);
    public static final Item TWISTED_BLACKSTONE_TILE_STAIRS = blockItem(ADBlocks.TWISTED_BLACKSTONE_TILE_STAIRS);
    public static final Item TWISTED_BLACKSTONE_TILE_SLAB = blockItem(ADBlocks.TWISTED_BLACKSTONE_TILE_SLAB);
    public static final Item TWISTED_BLACKSTONE_TILE_WALL = blockItem(ADBlocks.TWISTED_BLACKSTONE_TILE_WALL);
    public static final Item WEEPING_BLACKSTONE_TILES = blockItem(ADBlocks.WEEPING_BLACKSTONE_TILES);
    public static final Item WEEPING_BLACKSTONE_TILE_STAIRS = blockItem(ADBlocks.WEEPING_BLACKSTONE_TILE_STAIRS);
    public static final Item WEEPING_BLACKSTONE_TILE_SLAB = blockItem(ADBlocks.WEEPING_BLACKSTONE_TILE_SLAB);
    public static final Item WEEPING_BLACKSTONE_TILE_WALL = blockItem(ADBlocks.WEEPING_BLACKSTONE_TILE_WALL);
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICKS = blockItem(ADBlocks.TWISTED_POLISHED_BLACKSTONE_BRICKS);
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS = blockItem(ADBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_STAIRS);
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB = blockItem(ADBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_SLAB);
    public static final Item TWISTED_POLISHED_BLACKSTONE_BRICK_WALL = blockItem(ADBlocks.TWISTED_POLISHED_BLACKSTONE_BRICK_WALL);
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICKS = blockItem(ADBlocks.WEEPING_POLISHED_BLACKSTONE_BRICKS);
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS = blockItem(ADBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_STAIRS);
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB = blockItem(ADBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_SLAB);
    public static final Item WEEPING_POLISHED_BLACKSTONE_BRICK_WALL = blockItem(ADBlocks.WEEPING_POLISHED_BLACKSTONE_BRICK_WALL);
    public static final Item TWISTED_BLACKSTONE = blockItem(ADBlocks.TWISTED_BLACKSTONE);
    public static final Item TWISTED_BLACKSTONE_STAIRS = blockItem(ADBlocks.TWISTED_BLACKSTONE_STAIRS);
    public static final Item TWISTED_BLACKSTONE_SLAB = blockItem(ADBlocks.TWISTED_BLACKSTONE_SLAB);
    public static final Item TWISTED_BLACKSTONE_WALL = blockItem(ADBlocks.TWISTED_BLACKSTONE_WALL);
    public static final Item WEEPING_BLACKSTONE = blockItem(ADBlocks.WEEPING_BLACKSTONE);
    public static final Item WEEPING_BLACKSTONE_STAIRS = blockItem(ADBlocks.WEEPING_BLACKSTONE_STAIRS);
    public static final Item WEEPING_BLACKSTONE_SLAB = blockItem(ADBlocks.WEEPING_BLACKSTONE_SLAB);
    public static final Item WEEPING_BLACKSTONE_WALL = blockItem(ADBlocks.WEEPING_BLACKSTONE_WALL);
    public static final Item QUARTZ_TILES = blockItem(ADBlocks.QUARTZ_TILES);
    public static final Item QUARTZ_TILE_STAIRS = blockItem(ADBlocks.QUARTZ_TILE_STAIRS);
    public static final Item QUARTZ_TILE_SLAB = blockItem(ADBlocks.QUARTZ_TILE_SLAB);
    public static final Item QUARTZ_TILE_WALL = blockItem(ADBlocks.QUARTZ_TILE_WALL);
    public static final Item CALCITE_BRICKS = blockItem(ADBlocks.CALCITE_BRICKS);
    public static final Item CALCITE_BRICK_STAIRS = blockItem(ADBlocks.CALCITE_BRICK_STAIRS);
    public static final Item CALCITE_BRICK_SLAB = blockItem(ADBlocks.CALCITE_BRICK_SLAB);
    public static final Item CALCITE_BRICK_WALL = blockItem(ADBlocks.CALCITE_BRICK_WALL);
    public static final Item MOSSY_CALCITE_BRICKS = blockItem(ADBlocks.MOSSY_CALCITE_BRICKS);
    public static final Item MOSSY_CALCITE_BRICK_STAIRS = blockItem(ADBlocks.MOSSY_CALCITE_BRICK_STAIRS);
    public static final Item MOSSY_CALCITE_BRICK_SLAB = blockItem(ADBlocks.MOSSY_CALCITE_BRICK_SLAB);
    public static final Item MOSSY_CALCITE_BRICK_WALL = blockItem(ADBlocks.MOSSY_CALCITE_BRICK_WALL);
    public static final Item CRACKED_CALCITE_BRICKS = blockItem(ADBlocks.CRACKED_CALCITE_BRICKS);
    public static final Item CRACKED_CALCITE_BRICK_STAIRS = blockItem(ADBlocks.CRACKED_CALCITE_BRICK_STAIRS);
    public static final Item CRACKED_CALCITE_BRICK_SLAB = blockItem(ADBlocks.CRACKED_CALCITE_BRICK_SLAB);
    public static final Item CRACKED_CALCITE_BRICK_WALL = blockItem(ADBlocks.CRACKED_CALCITE_BRICK_WALL);
    public static final Item CHISELED_CALCITE_BRICKS = blockItem(ADBlocks.CHISELED_CALCITE_BRICKS);
    public static final Item DRIPSTONE_BRICKS = blockItem(ADBlocks.DRIPSTONE_BRICKS);
    public static final Item DRIPSTONE_BRICK_STAIRS = blockItem(ADBlocks.DRIPSTONE_BRICK_STAIRS);
    public static final Item DRIPSTONE_BRICK_SLAB = blockItem(ADBlocks.DRIPSTONE_BRICK_SLAB);
    public static final Item DRIPSTONE_BRICK_WALL = blockItem(ADBlocks.DRIPSTONE_BRICK_WALL);
    public static final Item MOSSY_DRIPSTONE_BRICKS = blockItem(ADBlocks.MOSSY_DRIPSTONE_BRICKS);
    public static final Item MOSSY_DRIPSTONE_BRICK_STAIRS = blockItem(ADBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS);
    public static final Item MOSSY_DRIPSTONE_BRICK_SLAB = blockItem(ADBlocks.MOSSY_DRIPSTONE_BRICK_SLAB);
    public static final Item MOSSY_DRIPSTONE_BRICK_WALL = blockItem(ADBlocks.MOSSY_DRIPSTONE_BRICK_WALL);
    public static final Item CRACKED_DRIPSTONE_BRICKS = blockItem(ADBlocks.CRACKED_DRIPSTONE_BRICKS);
    public static final Item CRACKED_DRIPSTONE_BRICK_STAIRS = blockItem(ADBlocks.CRACKED_DRIPSTONE_BRICK_STAIRS);
    public static final Item CRACKED_DRIPSTONE_BRICK_SLAB = blockItem(ADBlocks.CRACKED_DRIPSTONE_BRICK_SLAB);
    public static final Item CRACKED_DRIPSTONE_BRICK_WALL = blockItem(ADBlocks.CRACKED_DRIPSTONE_BRICK_WALL);
    public static final Item CHISELED_DRIPSTONE_BRICKS = blockItem(ADBlocks.CHISELED_DRIPSTONE_BRICKS);
    public static final Item GREEN_ONION_SEEDS = new AliasedBlockItem(ADBlocks.GREEN_ONIONS, new Item.Settings());
    public static final Item GREEN_ONION = new Item(new Item.Settings().food(ADFoodComponents.GREEN_ONION));
    public static final Item BLUEBERRIES = new AliasedBlockItem(ADBlocks.BLUEBERRY_BUSH, new Item.Settings()
            .food(ADFoodComponents.BLUEBERRIES));
    public static final Item SWEET_BERRY_JUICE = new ADDrinkContainerItem(new Item.Settings()
            .food(ADFoodComponents.SWEET_BERRY_JUICE).maxCount(16));
    public static final Item BLUEBERRY_JUICE = new ADDrinkContainerItem(new Item.Settings()
            .food(ADFoodComponents.BLUEBERRY_JUICE).maxCount(16));
    public static final Item NOODLES = new Item(new Item.Settings());
    public static final Item NOODLE_SOUP = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.NOODLE_SOUP).maxCount(1));
    public static final Item PUDDING = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.PUDDING).maxCount(1));
    public static final Item BERRY_PUDDING = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.BERRY_PUDDING).maxCount(1));
    public static final Item SMOKY_QUARTZ = new Item(new Item.Settings());
    public static final Item CARAMEL_APPLE = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.CARAMEL_APPLE).maxCount(1), Items.STICK);
    public static final Item CARAMEL = new Item(new Item.Settings().food(ADFoodComponents.CARAMEL));
    public static final Item SPRUCE_CONE = new Item(new Item.Settings().food(ADFoodComponents.SPRUCE_CONE));
    public static final Item FORESTS_BOUNTY = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.FORESTS_BOUNTY).maxCount(1));
    public static final Item WITCHS_CRADLE_BRANCH = new AliasedBlockItem(ADBlocks.WITCHS_CRADLE, new Item.Settings()
            .food(ADFoodComponents.WITCHS_CRADLE_BRANCH));
    public static final Item WITCHS_CRADLE_SOUP = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.WITCHS_CRADLE_SOUP).maxCount(1));
    public static final Item CATTAIL = new AliasedBlockItem(ADBlocks.CATTAIL, new Item.Settings());
    public static final Item FRIED_EGG = new Item(new Item.Settings().food(ADFoodComponents.FRIED_EGG).maxCount(16));
    public static final Item BLOOD_KELP_SEED_CLUSTER = new AliasedBlockItem(ADBlocks.BLOOD_KELP, new Item.Settings());
    public static final Item BLOOD_KELP = new Item(new Item.Settings());
    public static final Item DRIED_BLOOD_KELP_BLOCK = blockItem(ADBlocks.DRIED_BLOOD_KELP_BLOCK);
    public static final Item DRIED_BLOOD_KELP = new Item(new Item.Settings().food(FoodComponents.DRIED_KELP));
    public static final Item BLOOD_KELP_LANTERN = blockItem(ADBlocks.BLOOD_KELP_LANTERN);
    public static final Item MAROON_WOOL = blockItem(ADBlocks.MAROON_WOOL);
    public static final Item MAROON_STAINED_GLASS = blockItem(ADBlocks.MAROON_STAINED_GLASS);
    public static final Item MAROON_STAINED_GLASS_PANE = blockItem(ADBlocks.MAROON_STAINED_GLASS_PANE);
    public static final Item MAROON_CANDLE = blockItem(ADBlocks.MAROON_CANDLE);
    public static final Item MAROON_CONCRETE = blockItem(ADBlocks.MAROON_CONCRETE);
    public static final Item MAROON_CONCRETE_POWDER = blockItem(ADBlocks.MAROON_CONCRETE_POWDER);
    public static final Item CAMEL_PLUSHIE = blockItem(ADBlocks.CAMEL_PLUSHIE);
    public static final Item MAROON_DYE = new Item(new Item.Settings());
    public static final Item HOGLIN_STEW = new ADFoodContainerItem(new Item.Settings()
            .food(ADFoodComponents.HOGLIN_STEW).maxCount(1));
    public static final Item BOG_BLOSSOM = blockItem(ADBlocks.BOG_BLOSSOM);
    public static final Item CINDERSNAP_BERRIES = new AliasedBlockItem(ADBlocks.CINDERSNAP_BERRY_BUSH, new Item.Settings()
            .food(ADFoodComponents.NETHER_BERRIES));
    public static final Item FROSTBITE_BERRIES = new AliasedBlockItem(ADBlocks.FROSTBITE_BERRY_BUSH, new Item.Settings()
            .food(ADFoodComponents.NETHER_BERRIES));
    public static final Item POLISHED_DRIPSTONE = blockItem(ADBlocks.POLISHED_DRIPSTONE);
    public static final Item POLISHED_DRIPSTONE_STAIRS = blockItem(ADBlocks.POLISHED_DRIPSTONE_STAIRS);
    public static final Item POLISHED_DRIPSTONE_SLAB = blockItem(ADBlocks.POLISHED_DRIPSTONE_SLAB);
    public static final Item POLISHED_DRIPSTONE_WALL = blockItem(ADBlocks.POLISHED_DRIPSTONE_WALL);
    public static final Item POLISHED_CALCITE = blockItem(ADBlocks.POLISHED_CALCITE);
    public static final Item POLISHED_CALCITE_STAIRS = blockItem(ADBlocks.POLISHED_CALCITE_STAIRS);
    public static final Item POLISHED_CALCITE_SLAB = blockItem(ADBlocks.POLISHED_CALCITE_SLAB);
    public static final Item POLISHED_CALCITE_WALL = blockItem(ADBlocks.POLISHED_CALCITE_WALL);
    public static final Item DRIPSTONE_STAIRS = blockItem(ADBlocks.DRIPSTONE_STAIRS);
    public static final Item DRIPSTONE_SLAB = blockItem(ADBlocks.DRIPSTONE_SLAB);
    public static final Item DRIPSTONE_WALL = blockItem(ADBlocks.DRIPSTONE_WALL);
    public static final Item CALCITE_STAIRS = blockItem(ADBlocks.CALCITE_STAIRS);
    public static final Item CALCITE_SLAB = blockItem(ADBlocks.CALCITE_SLAB);
    public static final Item CALCITE_WALL = blockItem(ADBlocks.CALCITE_WALL);
    public static final Item BAMBOO_PLANTER_BOX = blockItem(ADBlocks.BAMBOO_PLANTER_BOX);
    public static final Item STONE_WALL = blockItem(ADBlocks.STONE_WALL);
    public static final Item QUARTZ_WALL = blockItem(ADBlocks.QUARTZ_WALL);
    public static final Item SMOOTH_QUARTZ_WALL = blockItem(ADBlocks.SMOOTH_QUARTZ_WALL);
    public static final Item GRASS_SLAB = blockItem(ADBlocks.GRASS_SLAB);
    public static final Item PODZOL_SLAB = blockItem(ADBlocks.PODZOL_SLAB);
    public static final Item MYCELIUM_SLAB = blockItem(ADBlocks.MYCELIUM_SLAB);
    public static final Item DIRT_PATH_SLAB = blockItem(ADBlocks.DIRT_PATH_SLAB);
    public static final Item DIRT_SLAB = blockItem(ADBlocks.DIRT_SLAB);
    public static final Item COARSE_DIRT_SLAB = blockItem(ADBlocks.COARSE_DIRT_SLAB);
    public static final Item ROOTED_DIRT_SLAB = blockItem(ADBlocks.ROOTED_DIRT_SLAB);
    public static final Item WILD_GREEN_ONIONS = blockItem(ADBlocks.WILD_GREEN_ONIONS);

    private static Item blockItem(Block block) {
        return new BlockItem(block, new Item.Settings());
    }

    private static Item wallStandingBlockItem(Block standingBlock, Block wallBlock) {
        return new VerticallyAttachableBlockItem(standingBlock, wallBlock, new Item.Settings(), Direction.DOWN);
    }

    private static Item ropeLadderBlockItem(Block block) {
        return new ADRopeLadderBlockItem(block, new Item.Settings());
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
                throw new IllegalArgumentException("The passed item must be an instance of an ItemBlock");
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
}
