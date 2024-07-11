package rndm_access.assorteddiscoveries.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ADParticleTypes {
    public static final DefaultParticleType WHITE_EMBER;
    public static final DefaultParticleType ORANGE_EMBER;
    public static final DefaultParticleType MAGENTA_EMBER;
    public static final DefaultParticleType LIGHT_BLUE_EMBER;
    public static final DefaultParticleType YELLOW_EMBER;
    public static final DefaultParticleType LIME_EMBER;
    public static final DefaultParticleType PINK_EMBER;
    public static final DefaultParticleType GRAY_EMBER;
    public static final DefaultParticleType LIGHT_GRAY_EMBER;
    public static final DefaultParticleType CYAN_EMBER;
    public static final DefaultParticleType PURPLE_EMBER;
    public static final DefaultParticleType BLUE_EMBER;
    public static final DefaultParticleType BROWN_EMBER;
    public static final DefaultParticleType GREEN_EMBER;
    public static final DefaultParticleType RED_EMBER;
    public static final DefaultParticleType BLACK_EMBER;
    public static final DefaultParticleType MAROON_EMBER;
    public static final DefaultParticleType WHITE_FLAME;
    public static final DefaultParticleType ORANGE_FLAME;
    public static final DefaultParticleType MAGENTA_FLAME;
    public static final DefaultParticleType LIGHT_BLUE_FLAME;
    public static final DefaultParticleType YELLOW_FLAME;
    public static final DefaultParticleType LIME_FLAME;
    public static final DefaultParticleType PINK_FLAME;
    public static final DefaultParticleType GRAY_FLAME;
    public static final DefaultParticleType LIGHT_GRAY_FLAME;
    public static final DefaultParticleType CYAN_FLAME;
    public static final DefaultParticleType PURPLE_FLAME;
    public static final DefaultParticleType BLUE_FLAME;
    public static final DefaultParticleType BROWN_FLAME;
    public static final DefaultParticleType GREEN_FLAME;
    public static final DefaultParticleType RED_FLAME;
    public static final DefaultParticleType BLACK_FLAME;
    public static final DefaultParticleType MAROON_FLAME;
    public static final DefaultParticleType BLOOD_KELP_SPORE;
    public static final DefaultParticleType WITCHS_CRADLE_SPORE;
    public static final DefaultParticleType BOG_BLOSSOM_AIR_NECTAR;
    public static final DefaultParticleType SOUL_EMBER;

    private static void register(String path, DefaultParticleType particleType) {
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
        register("maroon_ember", MAROON_EMBER);
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
        register("maroon_flame", MAROON_FLAME);
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
        MAROON_EMBER = FabricParticleTypes.simple();
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
        MAROON_FLAME = FabricParticleTypes.simple();
        BLOOD_KELP_SPORE = FabricParticleTypes.simple();
        WITCHS_CRADLE_SPORE = FabricParticleTypes.simple();
        BOG_BLOSSOM_AIR_NECTAR = FabricParticleTypes.simple();
        SOUL_EMBER = FabricParticleTypes.simple();
    }
}