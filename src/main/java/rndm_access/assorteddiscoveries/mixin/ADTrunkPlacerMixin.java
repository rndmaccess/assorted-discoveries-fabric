package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rndm_access.assorteddiscoveries.core.ADBlockTags;

import java.util.function.BiConsumer;

@Mixin(TrunkPlacer.class)
public class ADTrunkPlacerMixin {
    @Inject(method = "setToDirt", at = @At("HEAD"), cancellable = true)
    private static void assorteddiscoveries_setToDirt(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                      Random random, BlockPos pos, TreeFeatureConfig config,
                                                      CallbackInfo info) {
        if(isPlanterBox(world, pos)) {
            info.cancel();
        }
    }

    @Unique
    private static boolean isPlanterBox(TestableWorld world, BlockPos pos) {
        return world.testBlockState(pos, (state) ->
                   state.isIn(ADBlockTags.OVERWORLD_PLANTER_BOXES)
                || state.isIn(ADBlockTags.NETHER_PLANTER_BOXES));
    }
}
