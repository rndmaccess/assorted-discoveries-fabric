package rndm_access.assorteddiscoveries.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureSet;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.config.ModConfig;

import java.util.Optional;

@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {

    @Inject(method = "trySetStructureStart", at = @At("HEAD"), cancellable = true)
    public void trySetStructureStart(StructureSet.WeightedEntry weightedEntry, StructureAccessor structureAccessor,
                                     DynamicRegistryManager dynamicRegistryManager, NoiseConfig noiseConfig,
                                     StructureTemplateManager structureManager, long seed, Chunk chunk, ChunkPos pos,
                                     ChunkSectionPos sectionPos, CallbackInfoReturnable<Boolean> cir) {
        Optional<RegistryKey<Structure>> structureKey = weightedEntry.structure().getKey();

        if (structureKey.isPresent()) {
            String structureName = structureKey.get().getValue().toString();

            if (isStructureDisabled(structureName)) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method = "locateStructure*", at = @At("HEAD"), cancellable = true)
    public void locateStructure(ServerWorld world, RegistryEntryList<Structure> structures, BlockPos center,
                                int radius, boolean skipReferencedStructures,
                                CallbackInfoReturnable<Pair<BlockPos, RegistryEntry<Structure>>> cir) {
        structures.stream().forEach(structure -> {
            Optional<RegistryKey<Structure>> structureKey = structure.getKey();

            if (structureKey.isPresent()) {
                String structureName = structureKey.get().getValue().toString();

                if (isStructureDisabled(structureName)) {
                    cir.setReturnValue(null);
                }
            }
        });
    }

    @Unique
    private boolean isStructureDisabled(String structureName) {
        boolean forestCabinsEnabled = ModConfig.ENABLE_FOREST_CABINS.getValue().evaluate();
        boolean darkForestCabinsEnabled = ModConfig.ENABLE_DARK_FOREST_CABINS.getValue().evaluate();
        boolean birchForestCabinsEnabled = ModConfig.ENABLE_BIRCH_FOREST_CABINS.getValue().evaluate();
        boolean taigaCabinsEnabled = ModConfig.ENABLE_TAIGA_CABINS.getValue().evaluate();
        boolean snowyTaigaCabinsEnabled = ModConfig.ENABLE_SNOWY_TAIGA_CABINS.getValue().evaluate();
        boolean crimsonForestCabinsEnabled = ModConfig.ENABLE_CRIMSON_FOREST_CABINS.getValue().evaluate();
        boolean warpedForestCabinsEnabled = ModConfig.ENABLE_WARPED_FOREST_CABINS.getValue().evaluate();

        if (structureName.equals("assorted-discoveries:cabin_forest") && !forestCabinsEnabled) {
            return true;
        } else if (structureName.equals("assorted-discoveries:cabin_dark_forest") && !darkForestCabinsEnabled) {
            return true;
        } else if (structureName.equals("assorted-discoveries:cabin_birch_forest") && !birchForestCabinsEnabled) {
            return true;
        } else if (structureName.equals("assorted-discoveries:cabin_taiga") && !taigaCabinsEnabled) {
            return true;
        } else if (structureName.equals("assorted-discoveries:cabin_snowy_taiga") && !snowyTaigaCabinsEnabled) {
            return true;
        } else if (structureName.equals("assorted-discoveries:nether_cabin_crimson_forest")
                && !crimsonForestCabinsEnabled) {
            return true;
        } else {
            return structureName.equals("assorted-discoveries:nether_cabin_warped_forest")
                    && !warpedForestCabinsEnabled;
        }
    }
}