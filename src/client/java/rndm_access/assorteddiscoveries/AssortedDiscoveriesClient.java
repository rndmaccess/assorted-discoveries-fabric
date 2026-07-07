package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import rndm_access.assorteddiscoveries.block_entity.DyedCampfireBlockEntityRenderer;
import rndm_access.assorteddiscoveries.config.BooleanEntriesS2CPayload;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.core.*;
import rndm_access.assorteddiscoveries.particle.BogBlossomNectarParticle;
import rndm_access.assorteddiscoveries.particle.SporeParticle;

import java.util.List;

public class AssortedDiscoveriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockColors();
        registerParticleProvider();
        registerBlockEntityRenderers();
        ClientPlayNetworking.registerGlobalReceiver(BooleanEntriesS2CPayload.ID, AssortedDiscoveriesClient::receiveServerConfig);
        ClientPlayConnectionEvents.DISCONNECT.register(AssortedDiscoveriesClient::reloadLocalConfig);
    }

    private static void receiveServerConfig(BooleanEntriesS2CPayload payload, ClientPlayNetworking.Context context) {
        ModConfig.updateFromList(payload.configList());
        AssortedDiscoveries.LOGGER.info("{} received the config data!", context.player().getName().getString());
    }

    private static void reloadLocalConfig(ClientPacketListener listener, Minecraft minecraft) {
        ModConfig.updateFromFile();
        AssortedDiscoveries.LOGGER.info("Local config data reloaded!");
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRenderers.register(ModBlockEntityTypes.DYED_CAMPFIRE, DyedCampfireBlockEntityRenderer::new);
    }

    private static void registerBlockColors() {
        BlockColorRegistry.register(List.of(BlockTintSources.grassBlock()), ModBlocks.ENDERMAN_PLUSHIE, ModBlocks.GRASS_SLAB);

        /*
        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int color(@NonNull BlockState state) {
                return -1;
            }

            @Override
            public int colorInWorld(@NonNull BlockState state, @NonNull BlockAndTintGetter level, @NonNull BlockPos pos) {
                return ((SheepPlushieBlock) state.getBlock()).getColor().getTextureDiffuseColor();
            }
        }), ModBlocks.DYED_SHEEP_PLUSHIES);
         */
    }

    private static void registerParticleProvider() {
        ParticleProviderRegistry providerRegistry = ParticleProviderRegistry.getInstance();

        providerRegistry.register(ModParticleTypes.WHITE_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.ORANGE_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.MAGENTA_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.LIGHT_BLUE_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.YELLOW_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.LIME_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.PINK_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.GRAY_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.LIGHT_GRAY_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.CYAN_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.PURPLE_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BLUE_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BROWN_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.GREEN_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.RED_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BLACK_EMBER, LavaParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.WHITE_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.ORANGE_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.MAGENTA_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.LIGHT_BLUE_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.YELLOW_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.LIME_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.PINK_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.GRAY_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.LIGHT_GRAY_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.CYAN_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.PURPLE_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BLUE_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BROWN_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.GREEN_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.RED_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BLACK_FLAME, FlameParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BLOOD_KELP_SPORE, SporeParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.WITCHS_CRADLE_SPORE, SporeParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.BOG_BLOSSOM_NECTAR, BogBlossomNectarParticle.Provider::new);
        providerRegistry.register(ModParticleTypes.SOUL_EMBER, LavaParticle.Provider::new);
    }
}
