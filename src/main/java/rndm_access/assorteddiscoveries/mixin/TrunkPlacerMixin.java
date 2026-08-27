package rndm_access.assorteddiscoveries.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

import java.util.function.BiConsumer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

@Mixin(TrunkPlacer.class)
public abstract class TrunkPlacerMixin {
    @Inject(method = "setDirtAt", at = @At("HEAD"), cancellable = true)
    private static void assorteddiscoveries$preventDirtReplacement(LevelSimulatedReader world,
                                                                   BiConsumer<BlockPos, BlockState> replacer,
                                                                   RandomSource random, BlockPos pos,
                                                                   TreeConfiguration config, CallbackInfo info) {
        if(assorteddiscoveries$isPlanterBox(world, pos)) {
            info.cancel();
        }
    }

    @Unique
    private static boolean assorteddiscoveries$isPlanterBox(LevelSimulatedReader world, BlockPos pos) {
        return world.isStateAtPosition(pos,
                (state) -> state.is(ModBlockTags.OVERWORLD_PLANTER_BOXES)
                        || state.is(ModBlockTags.NETHER_PLANTER_BOXES));
    }
}
