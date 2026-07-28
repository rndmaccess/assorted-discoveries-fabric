package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

@Mixin(BambooStalkBlock.class)
public abstract class BambooBlockMixin {
    @Inject(method = "getStateForPlacement", at = @At("HEAD"), cancellable = true)
    private void cancelPlacementOnSlabs(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        if (isSlabBottom(context.getLevel(), context.getClickedPos())) {
            cir.setReturnValue(null);
        }
    }

    @ModifyReturnValue(method = "canSurvive", at = @At("RETURN"))
    private boolean onCanSurvive(boolean original, BlockState state, LevelReader level, BlockPos pos) {
        if (isSlabBottom(level, pos)) {
            return false;
        }
        return original;
    }

    @Unique
    private static boolean isSlabBottom(LevelReader world, BlockPos pos) {
        BlockState soil = world.getBlockState(pos.below());
        return soil.is(ModBlockTags.SOIL_SLABS)
                && soil.hasProperty(SlabBlock.TYPE)
                && soil.getValue(SlabBlock.TYPE) == SlabType.BOTTOM;
    }
}