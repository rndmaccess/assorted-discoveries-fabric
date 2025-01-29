package rndm_access.assorteddiscoveries.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModParticleTypes {
    public static final SimpleParticleType WHITE_EMBER;
    public static final SimpleParticleType ORANGE_EMBER;
    public static final SimpleParticleType MAGENTA_EMBER;
    public static final SimpleParticleType LIGHT_BLUE_EMBER;
    public static final SimpleParticleType YELLOW_EMBER;
    public static final SimpleParticleType LIME_EMBER;
    public static final SimpleParticleType PINK_EMBER;
    public static final SimpleParticleType GRAY_EMBER;
    public static final SimpleParticleType LIGHT_GRAY_EMBER;
    public static final SimpleParticleType CYAN_EMBER;
    public static final SimpleParticleType PURPLE_EMBER;
    public static final SimpleParticleType BLUE_EMBER;
    public static final SimpleParticleType BROWN_EMBER;
    public static final SimpleParticleType GREEN_EMBER;
    public static final SimpleParticleType RED_EMBER;
    public static final SimpleParticleType BLACK_EMBER;
    public static final SimpleParticleType WHITE_FLAME;
    public static final SimpleParticleType ORANGE_FLAME;
    public static final SimpleParticleType MAGENTA_FLAME;
    public static final SimpleParticleType LIGHT_BLUE_FLAME;
    public static final SimpleParticleType YELLOW_FLAME;
    public static final SimpleParticleType LIME_FLAME;
    public static final SimpleParticleType PINK_FLAME;
    public static final SimpleParticleType GRAY_FLAME;
    public static final SimpleParticleType LIGHT_GRAY_FLAME;
    public static final SimpleParticleType CYAN_FLAME;
    public static final SimpleParticleType PURPLE_FLAME;
    public static final SimpleParticleType BLUE_FLAME;
    public static final SimpleParticleType BROWN_FLAME;
    public static final SimpleParticleType GREEN_FLAME;
    public static final SimpleParticleType RED_FLAME;
    public static final SimpleParticleType BLACK_FLAME;
    public static final SimpleParticleType BLOOD_KELP_SPORE;
    public static final SimpleParticleType WITCHS_CRADLE_SPORE;
    public static final SimpleParticleType BOG_BLOSSOM_AIR_NECTAR;
    public static final SimpleParticleType SOUL_EMBER;

    private static void register(String path, SimpleParticleType particleType) {
        Registry.register(Registries.PARTICLE_TYPE, ADReference.makeModId(path), particleType);
    }

    /**
     * Called during mod initialization to register every particle type.
     */
    public static void registerParticleTypes() {
        register("white_ember", WHITE_EMBER);
        register("orange_ember", ORANGE_EMBER);
        register("magenta_ember", MAGENTA_EMBER);
        register("light_blue_ember", LIGHT_BLUE_EMBER);
        register("yellow_ember", YELLOW_EMBER);
        register("lime_ember", LIME_EMBER);
        register("pink_ember", PINK_EMBER);
        register("gray_ember", GRAY_EMBER);
        register("light_gray_ember", LIGHT_GRAY_EMBER);
        register("cyan_ember", CYAN_EMBER);
        register("purple_ember", PURPLE_EMBER);
        register("blue_ember", BLUE_EMBER);
        register("brown_ember", BROWN_EMBER);
        register("green_ember", GREEN_EMBER);
        register("red_ember", RED_EMBER);
        register("black_ember", BLACK_EMBER);
        register("white_flame", WHITE_FLAME);
        register("orange_flame", ORANGE_FLAME);
        register("magenta_flame", MAGENTA_FLAME);
        register("light_blue_flame", LIGHT_BLUE_FLAME);
        register("yellow_flame", YELLOW_FLAME);
        register("lime_flame", LIME_FLAME);
        register("pink_flame", PINK_FLAME);
        register("gray_flame", GRAY_FLAME);
        register("light_gray_flame", LIGHT_GRAY_FLAME);
        register("cyan_flame", CYAN_FLAME);
        register("purple_flame", PURPLE_FLAME);
        register("blue_flame", BLUE_FLAME);
        register("brown_flame", BROWN_FLAME);
        register("green_flame", GREEN_FLAME);
        register("red_flame", RED_FLAME);
        register("black_flame", BLACK_FLAME);
        register("blood_kelp_spore", BLOOD_KELP_SPORE);
        register("witchs_cradle_spore", WITCHS_CRADLE_SPORE);
        register("bog_blossom_air_nectar", BOG_BLOSSOM_AIR_NECTAR);
        register("soul_ember", SOUL_EMBER);

        AssortedDiscoveries.LOGGER.info("Registered particle types");
    }

    static {
        WHITE_EMBER = FabricParticleTypes.simple();
        ORANGE_EMBER = FabricParticleTypes.simple();
        MAGENTA_EMBER = FabricParticleTypes.simple();
        LIGHT_BLUE_EMBER = FabricParticleTypes.simple();
        YELLOW_EMBER = FabricParticleTypes.simple();
        LIME_EMBER = FabricParticleTypes.simple();
        PINK_EMBER = FabricParticleTypes.simple();
        GRAY_EMBER = FabricParticleTypes.simple();
        LIGHT_GRAY_EMBER = FabricParticleTypes.simple();
        CYAN_EMBER = FabricParticleTypes.simple();
        PURPLE_EMBER = FabricParticleTypes.simple();
        BLUE_EMBER = FabricParticleTypes.simple();
        BROWN_EMBER = FabricParticleTypes.simple();
        GREEN_EMBER = FabricParticleTypes.simple();
        RED_EMBER = FabricParticleTypes.simple();
        BLACK_EMBER = FabricParticleTypes.simple();
        WHITE_FLAME = FabricParticleTypes.simple();
        ORANGE_FLAME = FabricParticleTypes.simple();
        MAGENTA_FLAME = FabricParticleTypes.simple();
        LIGHT_BLUE_FLAME = FabricParticleTypes.simple();
        YELLOW_FLAME = FabricParticleTypes.simple();
        LIME_FLAME = FabricParticleTypes.simple();
        PINK_FLAME = FabricParticleTypes.simple();
        GRAY_FLAME = FabricParticleTypes.simple();
        LIGHT_GRAY_FLAME = FabricParticleTypes.simple();
        CYAN_FLAME = FabricParticleTypes.simple();
        PURPLE_FLAME = FabricParticleTypes.simple();
        BLUE_FLAME = FabricParticleTypes.simple();
        BROWN_FLAME = FabricParticleTypes.simple();
        GREEN_FLAME = FabricParticleTypes.simple();
        RED_FLAME = FabricParticleTypes.simple();
        BLACK_FLAME = FabricParticleTypes.simple();
        BLOOD_KELP_SPORE = FabricParticleTypes.simple();
        WITCHS_CRADLE_SPORE = FabricParticleTypes.simple();
        BOG_BLOSSOM_AIR_NECTAR = FabricParticleTypes.simple();
        SOUL_EMBER = FabricParticleTypes.simple();
    }
}