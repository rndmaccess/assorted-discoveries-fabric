package rndm_access.assorteddiscoveries.core;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block.*;

public final class ModBlockTypes {
    private static ResourceKey<MapCodec<? extends Block>> makeRegistryKey(String name) {
        return ResourceKey.create(Registries.BLOCK_TYPE, AssortedDiscoveries.makeModId(name));
    }

    private static void registerCodec(ResourceKey<MapCodec<? extends Block>> key, MapCodec<? extends Block> codec) {
        Registry.register(BuiltInRegistries.BLOCK_TYPE, key, codec);
    }

    public static void register() {
        registerCodec(makeRegistryKey("plushie"), PlushieBlock.CODEC);
        registerCodec(makeRegistryKey("sheep_plushie"), SheepPlushieBlock.CODEC);
        registerCodec(makeRegistryKey("blood_kelp"), BloodKelpBlock.CODEC);
        registerCodec(makeRegistryKey("blood_kelp_plant"), BloodKelpPlantBlock.CODEC);
        registerCodec(makeRegistryKey("blueberry_bush"), BlueberryBushBlock.CODEC);
        registerCodec(makeRegistryKey("frostbite_berry_bush"), FrostbiteBerryBushBlock.CODEC);
        registerCodec(makeRegistryKey("cindersnap_berry_bush"), CindersnapBerryBushBlock.CODEC);
        registerCodec(makeRegistryKey("witchs_cradle"), WitchsCradleBlock.CODEC);
        registerCodec(makeRegistryKey("bog_blossom"), BogBlossomBlock.CODEC);
        registerCodec(makeRegistryKey("cattail"), CattailBlock.CODEC);
        registerCodec(makeRegistryKey("modded_cake"), ModdedCakeBlock.CODEC);
        registerCodec(makeRegistryKey("modded_candle_cake"), ModdedCandleCakeBlock.CODEC);
        registerCodec(makeRegistryKey("pie"), PieBlock.CODEC);
        registerCodec(makeRegistryKey("planter_box"), PlanterBoxBlock.CODEC);
        registerCodec(makeRegistryKey("short_ender_grass"), ShortEnderGrassBlock.CODEC);
        registerCodec(makeRegistryKey("wild_green_onions"), WildGreenOnionsBlock.CODEC);
    }
}
