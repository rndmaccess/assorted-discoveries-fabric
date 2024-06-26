package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaEmberParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import rndm_access.assorteddiscoveries.block_entity.ADDyedCampfireBlockEntityRenderer;
import rndm_access.assorteddiscoveries.core.*;
import rndm_access.assorteddiscoveries.particle.ADAirNectarParticle;
import rndm_access.assorteddiscoveries.particle.ADSporeParticle;
import rndm_access.assorteddiscoveries.screen.ADWoodcutterScreen;

public class AssortedDiscoveriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockColorProviders();
        registerItemColorProviders();
        registerParticleFactories();
        registerRenderLayers();
        registerScreens();
        registerBlockEntityRenderers();
    }

    private void registerBlockEntityRenderers() {
        BlockEntityRendererFactories.register(ADBlockEntityTypes.DYED_CAMPFIRE, ADDyedCampfireBlockEntityRenderer::new);
    }

    private void registerBlockColorProviders() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> ((tintIndex == 1) && (view != null))
                ? BiomeColors.getGrassColor(view, pos)
                : -1, ADBlocks.ENDERMAN_PLUSH, ADBlocks.GRASS_SLAB);
    }

    private void registerItemColorProviders() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D),
                ADItems.ENDERMAN_PLUSH, ADBlocks.GRASS_SLAB);
    }

    private void registerScreens() {
        HandledScreens.register(ADScreenHandlerTypes.WOODCUTTER, ADWoodcutterScreen::new);
    }

    private void registerParticleFactories() {
        ParticleFactoryRegistry factoryRegistry = ParticleFactoryRegistry.getInstance();

        factoryRegistry.register(ADParticleTypes.WHITE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.ORANGE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.MAGENTA_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.LIGHT_BLUE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.YELLOW_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.LIME_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.PINK_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.GRAY_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.LIGHT_GRAY_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.CYAN_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.PURPLE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BLUE_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BROWN_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.GREEN_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.RED_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BLACK_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.MAROON_EMBER, LavaEmberParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.WHITE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.ORANGE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.MAGENTA_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.LIGHT_BLUE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.YELLOW_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.LIME_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.PINK_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.GRAY_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.LIGHT_GRAY_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.CYAN_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.PURPLE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BLUE_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BROWN_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.GREEN_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.RED_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BLACK_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.MAROON_FLAME, FlameParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BLOOD_KELP_SPORE, ADSporeParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.WITCHS_CRADLE_SPORE, ADSporeParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.BOG_BLOSSOM_AIR_NECTAR, ADAirNectarParticle.Factory::new);
        factoryRegistry.register(ADParticleTypes.SOUL_EMBER, LavaEmberParticle.Factory::new);
    }

    private void registerRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ADBlocks.OAK_ROPE_LADDER, ADBlocks.SPRUCE_ROPE_LADDER,
                ADBlocks.BIRCH_ROPE_LADDER, ADBlocks.JUNGLE_ROPE_LADDER, ADBlocks.ACACIA_ROPE_LADDER,
                ADBlocks.DARK_OAK_ROPE_LADDER, ADBlocks.WARPED_ROPE_LADDER, ADBlocks.CRIMSON_ROPE_LADDER,
                ADBlocks.IRON_LADDER, ADBlocks.PURPLE_MUSHROOM, ADBlocks.WOODCUTTER, ADBlocks.WHITE_CAMPFIRE,
                ADBlocks.ORANGE_CAMPFIRE, ADBlocks.MAGENTA_CAMPFIRE, ADBlocks.LIGHT_BLUE_CAMPFIRE,
                ADBlocks.YELLOW_CAMPFIRE, ADBlocks.LIME_CAMPFIRE, ADBlocks.PINK_CAMPFIRE, ADBlocks.LIGHT_GRAY_CAMPFIRE,
                ADBlocks.GRAY_CAMPFIRE, ADBlocks.CYAN_CAMPFIRE, ADBlocks.PURPLE_CAMPFIRE, ADBlocks.BLUE_CAMPFIRE,
                ADBlocks.BROWN_CAMPFIRE, ADBlocks.GREEN_CAMPFIRE, ADBlocks.RED_CAMPFIRE, ADBlocks.BLACK_CAMPFIRE,
                ADBlocks.WHITE_LANTERN, ADBlocks.ORANGE_LANTERN, ADBlocks.MAGENTA_LANTERN, ADBlocks.LIGHT_BLUE_LANTERN,
                ADBlocks.YELLOW_LANTERN, ADBlocks.LIME_LANTERN, ADBlocks.PINK_LANTERN, ADBlocks.LIGHT_GRAY_LANTERN,
                ADBlocks.GRAY_LANTERN, ADBlocks.CYAN_LANTERN, ADBlocks.PURPLE_LANTERN, ADBlocks.BLUE_LANTERN,
                ADBlocks.BROWN_LANTERN, ADBlocks.GREEN_LANTERN, ADBlocks.RED_LANTERN, ADBlocks.BLACK_LANTERN,
                ADBlocks.WHITE_TORCH, ADBlocks.ORANGE_TORCH, ADBlocks.MAGENTA_TORCH, ADBlocks.LIGHT_BLUE_TORCH,
                ADBlocks.YELLOW_TORCH, ADBlocks.LIME_TORCH, ADBlocks.PINK_TORCH, ADBlocks.LIGHT_GRAY_TORCH,
                ADBlocks.GRAY_TORCH, ADBlocks.CYAN_TORCH, ADBlocks.PURPLE_TORCH, ADBlocks.BLUE_TORCH,
                ADBlocks.BROWN_TORCH, ADBlocks.GREEN_TORCH, ADBlocks.RED_TORCH, ADBlocks.BLACK_TORCH,
                ADBlocks.WHITE_WALL_TORCH, ADBlocks.ORANGE_WALL_TORCH, ADBlocks.MAGENTA_WALL_TORCH,
                ADBlocks.LIGHT_BLUE_WALL_TORCH, ADBlocks.YELLOW_WALL_TORCH, ADBlocks.LIME_WALL_TORCH,
                ADBlocks.PINK_WALL_TORCH, ADBlocks.LIGHT_GRAY_WALL_TORCH, ADBlocks.GRAY_WALL_TORCH,
                ADBlocks.CYAN_WALL_TORCH, ADBlocks.PURPLE_WALL_TORCH, ADBlocks.BLUE_WALL_TORCH,
                ADBlocks.BROWN_WALL_TORCH, ADBlocks.GREEN_WALL_TORCH, ADBlocks.RED_WALL_TORCH,
                ADBlocks.BLACK_WALL_TORCH, ADBlocks.GREEN_ONIONS, ADBlocks.BLUEBERRY_BUSH,
                ADBlocks.WITCHS_CRADLE, ADBlocks.SNAPDRAGON, ADBlocks.POTTED_SNAPDRAGON, ADBlocks.SHORT_ENDER_GRASS,
                ADBlocks.CATTAIL, ADBlocks.POTTED_PURPLE_MUSHROOM, ADBlocks.BLOOD_KELP,
                ADBlocks.BLOOD_KELP_PLANT, ADBlocks.MANGROVE_ROPE_LADDER, ADBlocks.BOG_BLOSSOM,
                ADBlocks.MAROON_CAMPFIRE, ADBlocks.MAROON_TORCH, ADBlocks.MAROON_WALL_TORCH, ADBlocks.MAROON_LANTERN,
                ADBlocks.CINDERSNAP_BERRY_BUSH, ADBlocks.FROSTBITE_BERRY_BUSH, ADBlocks.CHERRY_ROPE_LADDER,
                ADBlocks.POTTED_CATTAIL, ADBlocks.WILD_GREEN_ONIONS);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(),
                ADBlocks.ENDERMAN_PLUSH, ADBlocks.GRASS_SLAB);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                ADBlocks.MAROON_STAINED_GLASS, ADBlocks.MAROON_STAINED_GLASS_PANE);
    }
}
