package rndm_access.assorteddiscoveries.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ADParticleTypes {
    public static final DefaultParticleType WHITE_EMBER = registerParticleType("white_ember");
    public static final DefaultParticleType ORANGE_EMBER = registerParticleType("orange_ember");
    public static final DefaultParticleType MAGENTA_EMBER = registerParticleType("magenta_ember");
    public static final DefaultParticleType LIGHT_BLUE_EMBER = registerParticleType("light_blue_ember");
    public static final DefaultParticleType YELLOW_EMBER = registerParticleType("yellow_ember");
    public static final DefaultParticleType LIME_EMBER = registerParticleType("lime_ember");
    public static final DefaultParticleType PINK_EMBER = registerParticleType("pink_ember");
    public static final DefaultParticleType GRAY_EMBER = registerParticleType("gray_ember");
    public static final DefaultParticleType LIGHT_GRAY_EMBER = registerParticleType("light_gray_ember");
    public static final DefaultParticleType CYAN_EMBER = registerParticleType("cyan_ember");
    public static final DefaultParticleType PURPLE_EMBER = registerParticleType("purple_ember");
    public static final DefaultParticleType BLUE_EMBER = registerParticleType("blue_ember");
    public static final DefaultParticleType BROWN_EMBER = registerParticleType("brown_ember");
    public static final DefaultParticleType GREEN_EMBER = registerParticleType("green_ember");
    public static final DefaultParticleType RED_EMBER = registerParticleType("red_ember");
    public static final DefaultParticleType BLACK_EMBER = registerParticleType("black_ember");
    public static final DefaultParticleType MAROON_EMBER = registerParticleType("maroon_ember");
    public static final DefaultParticleType WHITE_FLAME = registerParticleType("white_flame");
    public static final DefaultParticleType ORANGE_FLAME = registerParticleType("orange_flame");
    public static final DefaultParticleType MAGENTA_FLAME = registerParticleType("magenta_flame");
    public static final DefaultParticleType LIGHT_BLUE_FLAME = registerParticleType("light_blue_flame");
    public static final DefaultParticleType YELLOW_FLAME = registerParticleType("yellow_flame");
    public static final DefaultParticleType LIME_FLAME = registerParticleType("lime_flame");
    public static final DefaultParticleType PINK_FLAME = registerParticleType("pink_flame");
    public static final DefaultParticleType GRAY_FLAME = registerParticleType("gray_flame");
    public static final DefaultParticleType LIGHT_GRAY_FLAME = registerParticleType("light_gray_flame");
    public static final DefaultParticleType CYAN_FLAME = registerParticleType("cyan_flame");
    public static final DefaultParticleType PURPLE_FLAME = registerParticleType("purple_flame");
    public static final DefaultParticleType BLUE_FLAME = registerParticleType("blue_flame");
    public static final DefaultParticleType BROWN_FLAME = registerParticleType("brown_flame");
    public static final DefaultParticleType GREEN_FLAME = registerParticleType("green_flame");
    public static final DefaultParticleType RED_FLAME = registerParticleType("red_flame");
    public static final DefaultParticleType BLACK_FLAME = registerParticleType("black_flame");
    public static final DefaultParticleType MAROON_FLAME = registerParticleType("maroon_flame");
    public static final DefaultParticleType BLOOD_KELP_SPORE = registerParticleType("blood_kelp_spore");
    public static final DefaultParticleType WITCHS_CRADLE_SPORE = registerParticleType("witchs_cradle_spore");
    public static final DefaultParticleType FALLING_WEEPING_HEART_NECTAR = registerParticleType("falling_weeping_heart_nectar");
    public static final DefaultParticleType WEEPING_HEART_AIR_NECTAR = registerParticleType("weeping_heart_air_nectar");
    public static final DefaultParticleType SOUL_EMBER = registerParticleType("soul_ember");

    private static DefaultParticleType registerParticleType(String path) {
        return Registry.register(Registries.PARTICLE_TYPE, ADReference.makeModId(path), FabricParticleTypes.simple());
    }

    /**
     * Called during mod initialization to register every particle type.
     */
    public static void registerParticleTypes() {
        AssortedDiscoveries.LOGGER.info("Registered particle types");
    }
}