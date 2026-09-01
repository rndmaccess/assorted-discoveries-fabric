package rndm_access.assorteddiscoveries;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.LavaParticle;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.lwjgl.glfw.GLFW;
import rndm_access.assorteddiscoveries.block.SheepPlushieBlock;
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
        addTooltipCallback();
    }

    private static void addTooltipCallback() {
        Style blueText = Style.EMPTY.withColor(ChatFormatting.BLUE);
        Style purpleText = Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE);
        Style grayText = Style.EMPTY.withColor(ChatFormatting.GRAY);
        Component fire_resist = Component.translatable("tooltip.assorted-discoveries.nether_berry_juice.effect").setStyle(blueText);
        Component night_vision = Component.translatable("tooltip.assorted-discoveries.witchs_cradle_soup.effect").setStyle(blueText);
        Component speed = Component.translatable("tooltip.assorted-discoveries.caramel_apple.effect").setStyle(blueText);
        Component blank = Component.empty();
        Component when_applied = Component.translatable("tooltip.assorted-discoveries.caramel_apple.when_consumed").setStyle(purpleText);
        Component speed_inc = Component.translatable("tooltip.assorted-discoveries.caramel_apple.speed_amount").setStyle(blueText);
        Component shift = Component.translatable("tooltip.assorted-discoveries.caramel_apple.show").setStyle(grayText);

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, lines) -> {
            if (itemStack.is(ModItems.CINDERSNAP_BERRY_JUICE) || itemStack.is(ModItems.FROSTBITE_BERRY_JUICE)) {
                lines.add(fire_resist);
            }

            if (itemStack.is(ModItems.WITCHS_CRADLE_SOUP)) {
                lines.add(night_vision);
            }

            if (itemStack.is(ModItems.CARAMEL_APPLE)) {
                Window windowHandle = Minecraft.getInstance().getWindow();
                boolean isShiftDown = InputConstants.isKeyDown(windowHandle, GLFW.GLFW_KEY_LEFT_SHIFT)
                        || InputConstants.isKeyDown(windowHandle, GLFW.GLFW_KEY_RIGHT_SHIFT);
                lines.add(speed);

                if (isShiftDown) {
                    lines.add(blank);
                    lines.add(when_applied);
                    lines.add(speed_inc);
                } else {
                    lines.add(shift);
                }
            }
        });
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

        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int color(@NonNull BlockState state) {
                return -1;
            }

            @Override
            public int colorInWorld(@NonNull BlockState state, @NonNull BlockAndTintGetter level, @NonNull BlockPos pos) {
                return ((SheepPlushieBlock) state.getBlock()).getColor().getTextureDiffuseColor();
            }
        }), ModBlocks.DYED_SHEEP_PLUSHIES.asList().toArray(new Block[0]));
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
