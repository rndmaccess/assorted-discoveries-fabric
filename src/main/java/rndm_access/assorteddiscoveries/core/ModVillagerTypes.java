package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModVillagerTypes {

    private static void register(String path, RegistryKey<Biome> biome) {
        register(path, ImmutableList.of(biome));
    }

    private static void register(String path, ImmutableList<RegistryKey<Biome>> biomes) {
        VillagerType type = createVillagerType(ADReference.makeModId(path));

        // Add the villager type to each biome listed.
        for(RegistryKey<Biome> biome : biomes) {
            VillagerType.BIOME_TO_TYPE.put(biome, type);
        }
    }

    private static VillagerType createVillagerType(Identifier id) {
        return Registry.register(Registries.VILLAGER_TYPE, new Identifier(id.toString()),
                new VillagerType(id.toString()));
    }

    public static void registerVillagerTypes() {
        register("crimson", BiomeKeys.CRIMSON_FOREST);
        register("warped", BiomeKeys.WARPED_FOREST);
        register("forest", ImmutableList.of(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST));

        AssortedDiscoveries.LOGGER.info("Registered villager types.");
    }
}