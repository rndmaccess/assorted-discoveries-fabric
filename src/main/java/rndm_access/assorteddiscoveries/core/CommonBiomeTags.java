package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import rndm_access.assorteddiscoveries.ADReference;

public class CommonBiomeTags {
    public static final TagKey<Biome> ORE_SMOKY_QUARTZ;
    public static final TagKey<Biome> PATCH_BLUEBERRY_BUSH;
    public static final TagKey<Biome> PATCH_CATTAIL_MANGROVE_SWAMP;
    public static final TagKey<Biome> PATCH_CATTAIL_RIVER;
    public static final TagKey<Biome> PATCH_ENDER_PLANTS;
    public static final TagKey<Biome> PATCH_HUGE_PURPLE_MUSHROOM;
    public static final TagKey<Biome> PATCH_WITCHS_CRADLE;
    public static final TagKey<Biome> BLOOD_KELP;
    public static final TagKey<Biome> ORE_BAUXITE;
    public static final TagKey<Biome> BOG_BLOSSOM;
    public static final TagKey<Biome> PATCH_CINDERSNAP_BERRY_BUSH;
    public static final TagKey<Biome> PATCH_FROSTBITE_BERRY_BUSH;
    public static final TagKey<Biome> PATCH_WILD_GREEN_ONIONS;

    private static TagKey<Biome> of(String path) {
        return TagKey.of(RegistryKeys.BIOME, ADReference.makeCommonId(path));
    }

    static {
        ORE_SMOKY_QUARTZ = of("has_feature/ore_smoky_quartz");
        PATCH_BLUEBERRY_BUSH = of("has_feature/patch_blueberry_bush");
        PATCH_CATTAIL_MANGROVE_SWAMP = of("has_feature/patch_cattail_mangrove_swamp");
        PATCH_CATTAIL_RIVER = of("has_feature/patch_cattail_river");
        PATCH_ENDER_PLANTS = of("has_feature/patch_ender_plants");
        PATCH_HUGE_PURPLE_MUSHROOM = of("has_feature/patch_huge_purple_mushroom");
        PATCH_WITCHS_CRADLE = of("has_feature/patch_witchs_cradle");
        BLOOD_KELP = of("has_feature/blood_kelp");
        ORE_BAUXITE = of("has_feature/ore_bauxite");
        BOG_BLOSSOM = of("has_feature/bog_blossom");
        PATCH_CINDERSNAP_BERRY_BUSH = of("has_feature/patch_cindersnap_berry_bush");
        PATCH_FROSTBITE_BERRY_BUSH = of("has_feature/patch_frostbite_berry_bush");
        PATCH_WILD_GREEN_ONIONS = of("has_feature/patch_wild_green_onions");
    }
}
