package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import rndm_access.assorteddiscoveries.ADReference;

public class ADPlacedFeatureKeys {
    public static final RegistryKey<PlacedFeature> PATCH_CATTAIL_MANGROVE_SWAMP = of("patch_cattail_mangrove_swamp");
    public static final RegistryKey<PlacedFeature> PATCH_CATTAIL_RIVER = of("patch_cattail_river");
    public static final RegistryKey<PlacedFeature> ORE_SMOKY_QUARTZ = of("ore_smoky_quartz");
    public static final RegistryKey<PlacedFeature> PATCH_HUGE_PURPLE_MUSHROOM = of("patch_huge_purple_mushroom");
    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY_COMMON = of("patch_blueberry_bush_common");
    public static final RegistryKey<PlacedFeature> PATCH_BLUEBERRY_RARE = of("patch_blueberry_bush_rare");
    public static final RegistryKey<PlacedFeature> PATCH_WITCHS_CRADLE_COMMON = of("patch_witchs_cradle_common");
    public static final RegistryKey<PlacedFeature> PATCH_WITCHS_CRADLE_RARE = of("patch_witchs_cradle_rare");
    public static final RegistryKey<PlacedFeature> PATCH_ENDER_PLANTS = of("patch_ender_plants");
    public static final RegistryKey<PlacedFeature> BLOOD_KELP = of("blood_kelp");
    public static final RegistryKey<PlacedFeature> ORE_BAUXITE_LOWER = of("ore_bauxite_lower");
    public static final RegistryKey<PlacedFeature> ORE_BAUXITE_UPPER = of("ore_bauxite_upper");
    public static final RegistryKey<PlacedFeature> BOG_BLOSSOM = of("bog_blossom");
    public static final RegistryKey<PlacedFeature> PATCH_CINDERSNAP_BERRY_BUSH_COMMON = of("patch_cindersnap_berry_bush_common");
    public static final RegistryKey<PlacedFeature> PATCH_CINDERSNAP_BERRY_BUSH_RARE = of("patch_cindersnap_berry_bush_rare");
    public static final RegistryKey<PlacedFeature> PATCH_FROSTBITE_BERRY_BUSH_COMMON = of("patch_frostbite_berry_bush_common");
    public static final RegistryKey<PlacedFeature> PATCH_FROSTBITE_BERRY_BUSH_RARE = of("patch_frostbite_berry_bush_rare");
    public static final RegistryKey<PlacedFeature> PATCH_WILD_GREEN_ONIONS_COMMON = of("patch_wild_green_onions_common");
    public static final RegistryKey<PlacedFeature> PATCH_WILD_GREEN_ONIONS_RARE = of("patch_wild_green_onions_rare");

    public static RegistryKey<PlacedFeature> of(String path) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, ADReference.makeModId(path));
    }
}
