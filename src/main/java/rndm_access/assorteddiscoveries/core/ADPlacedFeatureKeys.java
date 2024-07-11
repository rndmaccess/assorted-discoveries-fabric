package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import rndm_access.assorteddiscoveries.ADReference;

public class ADPlacedFeatureKeys {
    public static final RegistryKey<PlacedFeature> PATCH_CATTAIL_MANGROVE_SWAMP;
    public static final RegistryKey<PlacedFeature> PATCH_CATTAIL_RIVER;
    public static final RegistryKey<PlacedFeature> ORE_SMOKY_QUARTZ;
    public static final RegistryKey<PlacedFeature> PATCH_HUGE_PURPLE_MUSHROOM;
    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY_COMMON;
    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY_RARE;
    public static final RegistryKey<PlacedFeature> PATCH_WITCHS_CRADLE_COMMON;
    public static final RegistryKey<PlacedFeature> PATCH_WITCHS_CRADLE_RARE;
    public static final RegistryKey<PlacedFeature> PATCH_ENDER_PLANTS;
    public static final RegistryKey<PlacedFeature> BLOOD_KELP;
    public static final RegistryKey<PlacedFeature> ORE_BAUXITE_LOWER;
    public static final RegistryKey<PlacedFeature> ORE_BAUXITE_UPPER;
    public static final RegistryKey<PlacedFeature> BOG_BLOSSOM;
    public static final RegistryKey<PlacedFeature> PATCH_CINDERSNAP_BERRY_BUSH_COMMON;
    public static final RegistryKey<PlacedFeature> PATCH_CINDERSNAP_BERRY_BUSH_RARE;
    public static final RegistryKey<PlacedFeature> PATCH_FROSTBITE_BERRY_BUSH_COMMON;
    public static final RegistryKey<PlacedFeature> PATCH_FROSTBITE_BERRY_BUSH_RARE;
    public static final RegistryKey<PlacedFeature> PATCH_WILD_GREEN_ONIONS_COMMON;
    public static final RegistryKey<PlacedFeature> PATCH_WILD_GREEN_ONIONS_RARE;

    public static RegistryKey<PlacedFeature> of(String path) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, ADReference.makeModId(path));
    }

    static {
        PATCH_CATTAIL_MANGROVE_SWAMP = of("patch_cattail_mangrove_swamp");
        PATCH_CATTAIL_RIVER = of("patch_cattail_river");
        ORE_SMOKY_QUARTZ = of("ore_smoky_quartz");
        PATCH_HUGE_PURPLE_MUSHROOM = of("patch_huge_purple_mushroom");
        PATCH_BLUEBERRY_COMMON = of("patch_blueberry_bush_common");
        PATCH_BLUEBERRY_RARE = of("patch_blueberry_bush_rare");
        PATCH_WITCHS_CRADLE_COMMON = of("patch_witchs_cradle_common");
        PATCH_WITCHS_CRADLE_RARE = of("patch_witchs_cradle_rare");
        PATCH_ENDER_PLANTS = of("patch_ender_plants");
        BLOOD_KELP = of("blood_kelp");
        ORE_BAUXITE_LOWER = of("ore_bauxite_lower");
        ORE_BAUXITE_UPPER = of("ore_bauxite_upper");
        BOG_BLOSSOM = of("bog_blossom");
        PATCH_CINDERSNAP_BERRY_BUSH_COMMON = of("patch_cindersnap_berry_bush_common");
        PATCH_CINDERSNAP_BERRY_BUSH_RARE = of("patch_cindersnap_berry_bush_rare");
        PATCH_FROSTBITE_BERRY_BUSH_COMMON = of("patch_frostbite_berry_bush_common");
        PATCH_FROSTBITE_BERRY_BUSH_RARE = of("patch_frostbite_berry_bush_rare");
        PATCH_WILD_GREEN_ONIONS_COMMON = of("patch_wild_green_onions_common");
        PATCH_WILD_GREEN_ONIONS_RARE = of("patch_wild_green_onions_rare");
    }
}
