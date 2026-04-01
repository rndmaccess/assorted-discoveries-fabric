package rndm_access.assorteddiscoveries;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.block.SheepPlushieBlock;
import rndm_access.assorteddiscoveries.block_entity.DyedCampfireBlockEntityRenderer;
import rndm_access.assorteddiscoveries.config.BooleanEntriesS2CPayload;
import rndm_access.assorteddiscoveries.config.ModClientConfig;
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

        ClientPlayNetworking.registerGlobalReceiver(BooleanEntriesS2CPayload.ID, (payload, context) -> {
            ModClientConfig.updateBoolEntries(payload.configMap());
            AssortedDiscoveries.LOGGER.info("{} received the server config data!", context.player().getName().getString());
        });
    }

    private static void registerBlockEntityRenderers() {
        BlockEntityRenderers.register(ModBlockEntityTypes.DYED_CAMPFIRE, DyedCampfireBlockEntityRenderer::new);
    }

    private static void registerBlockColors() {
        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int color(@NonNull BlockState state) {
                return -1;
            }

            @Override
            public int colorInWorld(@NonNull BlockState state, @NonNull BlockAndTintGetter level, @NonNull BlockPos pos) {
                return BiomeColors.getAverageGrassColor(level, pos);
            }
        }), ModBlocks.ENDERMAN_PLUSHIE, ModBlocks.GRASS_SLAB);

        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int color(@NonNull BlockState state) {
                return -1;
            }

            @Override
            public int colorInWorld(@NonNull BlockState state, @NonNull BlockAndTintGetter level, @NonNull BlockPos pos) {
                return ((SheepPlushieBlock) state.getBlock()).getColor().getTextureDiffuseColor();
            }
        }), ModBlocks.WHITE_SHEEP_PLUSHIE, ModBlocks.ORANGE_SHEEP_PLUSHIE, ModBlocks.MAGENTA_SHEEP_PLUSHIE,
                ModBlocks.LIGHT_BLUE_SHEEP_PLUSHIE, ModBlocks.YELLOW_SHEEP_PLUSHIE, ModBlocks.LIME_SHEEP_PLUSHIE,
                ModBlocks.PINK_SHEEP_PLUSHIE, ModBlocks.GRAY_SHEEP_PLUSHIE, ModBlocks.LIGHT_GRAY_SHEEP_PLUSHIE,
                ModBlocks.CYAN_SHEEP_PLUSHIE, ModBlocks.PURPLE_SHEEP_PLUSHIE, ModBlocks.BLUE_SHEEP_PLUSHIE,
                ModBlocks.BROWN_SHEEP_PLUSHIE, ModBlocks.GREEN_SHEEP_PLUSHIE, ModBlocks.RED_SHEEP_PLUSHIE,
                ModBlocks.BLACK_SHEEP_PLUSHIE);
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
