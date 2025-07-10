package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaEmberParticle;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import rndm_access.assorteddiscoveries.block.SheepPlushieBlock;
import rndm_access.assorteddiscoveries.block_entity.DyedCampfireBlockEntityRenderer;
import rndm_access.assorteddiscoveries.core.*;
import rndm_access.assorteddiscoveries.particle.AirNectarParticle;
import rndm_access.assorteddiscoveries.particle.SporeParticle;

public class AssortedDiscoveriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockColorProviders();
        registerParticleFactories();
        registerRenderLayers();
        registerBlockEntityRenderers();
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRendererFactories.register(ModBlockEntityTypes.DYED_CAMPFIRE, DyedCampfireBlockEntityRenderer::new);
    }

    private static void registerBlockColorProviders() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (tintIndex == 1 && view != null) {
                return BiomeColors.getGrassColor(view, pos);
            }
            return -1;
        }, ModBlocks.ENDERMAN_PLUSHIE, ModBlocks.GRASS_SLAB);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view != null && state != null) {
                return ((SheepPlushieBlock) state.getBlock()).getColor().getEntityColor();
            }
            return -1;
        }, ModBlocks.WHITE_SHEEP_PLUSHIE, ModBlocks.ORANGE_SHEEP_PLUSHIE, ModBlocks.MAGENTA_SHEEP_PLUSHIE,
                ModBlocks.LIGHT_BLUE_SHEEP_PLUSHIE, ModBlocks.YELLOW_SHEEP_PLUSHIE, ModBlocks.LIME_SHEEP_PLUSHIE,
                ModBlocks.PINK_SHEEP_PLUSHIE, ModBlocks.GRAY_SHEEP_PLUSHIE, ModBlocks.LIGHT_GRAY_SHEEP_PLUSHIE,
                ModBlocks.CYAN_SHEEP_PLUSHIE, ModBlocks.PURPLE_SHEEP_PLUSHIE, ModBlocks.BLUE_SHEEP_PLUSHIE,
                ModBlocks.BROWN_SHEEP_PLUSHIE, ModBlocks.GREEN_SHEEP_PLUSHIE, ModBlocks.RED_SHEEP_PLUSHIE,
                ModBlocks.BLACK_SHEEP_PLUSHIE);
    }

    private static void registerParticleFactories() {
        ParticleFactoryRegistry factoryRegistry = ParticleFactoryRegistry.getInstance();

        factoryRegistry.register(ModParticleTypes.WHITE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.ORANGE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.MAGENTA_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.LIGHT_BLUE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.YELLOW_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.LIME_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.PINK_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.GRAY_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.LIGHT_GRAY_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.CYAN_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.PURPLE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BLUE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BROWN_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.GREEN_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.RED_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BLACK_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.WHITE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.ORANGE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.MAGENTA_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.LIGHT_BLUE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.YELLOW_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.LIME_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.PINK_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.GRAY_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.LIGHT_GRAY_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.CYAN_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.PURPLE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BLUE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BROWN_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.GREEN_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.RED_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BLACK_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BLOOD_KELP_SPORE, SporeParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.WITCHS_CRADLE_SPORE, SporeParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.BOG_BLOSSOM_AIR_NECTAR, AirNectarParticle.Factory::new);
        factoryRegistry.register(ModParticleTypes.SOUL_EMBER, LavaEmberParticle.Factory::new);
    }

    private static void registerRenderLayers() {
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
                ModBlocks.OAK_ROPE_LADDER, ModBlocks.SPRUCE_ROPE_LADDER, ModBlocks.BIRCH_ROPE_LADDER,
                ModBlocks.JUNGLE_ROPE_LADDER, ModBlocks.ACACIA_ROPE_LADDER, ModBlocks.DARK_OAK_ROPE_LADDER,
                ModBlocks.WARPED_ROPE_LADDER, ModBlocks.CRIMSON_ROPE_LADDER, ModBlocks.IRON_LADDER,
                ModBlocks.PURPLE_MUSHROOM, ModBlocks.WHITE_CAMPFIRE, ModBlocks.ORANGE_CAMPFIRE,
                ModBlocks.MAGENTA_CAMPFIRE, ModBlocks.LIGHT_BLUE_CAMPFIRE, ModBlocks.YELLOW_CAMPFIRE,
                ModBlocks.LIME_CAMPFIRE, ModBlocks.PINK_CAMPFIRE, ModBlocks.LIGHT_GRAY_CAMPFIRE,
                ModBlocks.GRAY_CAMPFIRE, ModBlocks.CYAN_CAMPFIRE, ModBlocks.PURPLE_CAMPFIRE,
                ModBlocks.BLUE_CAMPFIRE, ModBlocks.BROWN_CAMPFIRE, ModBlocks.GREEN_CAMPFIRE,
                ModBlocks.RED_CAMPFIRE, ModBlocks.BLACK_CAMPFIRE, ModBlocks.WHITE_LANTERN,
                ModBlocks.ORANGE_LANTERN, ModBlocks.MAGENTA_LANTERN, ModBlocks.LIGHT_BLUE_LANTERN,
                ModBlocks.YELLOW_LANTERN, ModBlocks.LIME_LANTERN, ModBlocks.PINK_LANTERN,
                ModBlocks.LIGHT_GRAY_LANTERN, ModBlocks.GRAY_LANTERN, ModBlocks.CYAN_LANTERN,
                ModBlocks.PURPLE_LANTERN, ModBlocks.BLUE_LANTERN, ModBlocks.BROWN_LANTERN,
                ModBlocks.GREEN_LANTERN, ModBlocks.RED_LANTERN, ModBlocks.BLACK_LANTERN,
                ModBlocks.WHITE_TORCH, ModBlocks.ORANGE_TORCH, ModBlocks.MAGENTA_TORCH,
                ModBlocks.LIGHT_BLUE_TORCH, ModBlocks.YELLOW_TORCH, ModBlocks.LIME_TORCH,
                ModBlocks.PINK_TORCH, ModBlocks.LIGHT_GRAY_TORCH, ModBlocks.GRAY_TORCH, ModBlocks.CYAN_TORCH,
                ModBlocks.PURPLE_TORCH, ModBlocks.BLUE_TORCH, ModBlocks.BROWN_TORCH, ModBlocks.GREEN_TORCH,
                ModBlocks.RED_TORCH, ModBlocks.BLACK_TORCH, ModBlocks.WHITE_WALL_TORCH, ModBlocks.ORANGE_WALL_TORCH,
                ModBlocks.MAGENTA_WALL_TORCH, ModBlocks.LIGHT_BLUE_WALL_TORCH, ModBlocks.YELLOW_WALL_TORCH,
                ModBlocks.LIME_WALL_TORCH, ModBlocks.PINK_WALL_TORCH, ModBlocks.LIGHT_GRAY_WALL_TORCH,
                ModBlocks.GRAY_WALL_TORCH, ModBlocks.CYAN_WALL_TORCH, ModBlocks.PURPLE_WALL_TORCH,
                ModBlocks.BLUE_WALL_TORCH, ModBlocks.BROWN_WALL_TORCH, ModBlocks.GREEN_WALL_TORCH,
                ModBlocks.RED_WALL_TORCH, ModBlocks.BLACK_WALL_TORCH, ModBlocks.GREEN_ONIONS, ModBlocks.BLUEBERRY_BUSH,
                ModBlocks.WITCHS_CRADLE, ModBlocks.SNAPDRAGON, ModBlocks.POTTED_SNAPDRAGON, ModBlocks.SHORT_ENDER_GRASS,
                ModBlocks.CATTAIL, ModBlocks.POTTED_PURPLE_MUSHROOM, ModBlocks.BLOOD_KELP, ModBlocks.BLOOD_KELP_PLANT,
                ModBlocks.MANGROVE_ROPE_LADDER, ModBlocks.BOG_BLOSSOM, ModBlocks.CINDERSNAP_BERRY_BUSH,
                ModBlocks.FROSTBITE_BERRY_BUSH, ModBlocks.CHERRY_ROPE_LADDER, ModBlocks.POTTED_CATTAIL,
                ModBlocks.WILD_GREEN_ONIONS, ModBlocks.CREAKING_PLUSHIE, ModBlocks.PALE_OAK_ROPE_LADDER,
                ModBlocks.BAMBOO_ROPE_LADDER);

        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT_MIPPED,
                ModBlocks.ENDERMAN_PLUSHIE, ModBlocks.GRASS_SLAB);
    }
}
