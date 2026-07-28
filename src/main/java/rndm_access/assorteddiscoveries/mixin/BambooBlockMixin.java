package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.fabricmc.loader.api.FabricLoader;
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
        if (canSupportPlant(context.getLevel(), context.getClickedPos())) {
            cir.setReturnValue(null);
        }
    }

    @ModifyReturnValue(method = "canSurvive", at = @At("RETURN"))
    private boolean onCanSurvive(boolean original, BlockState state, LevelReader level, BlockPos pos) {
        if (canSupportPlant(level, pos)) {
            return false;
        }
        return original;
    }

    @Unique
    private static boolean canSupportPlant(LevelReader world, BlockPos pos) {
        BlockState soil = world.getBlockState(pos.below());
        // If slabbed is installed we should allow placing plants on dirt slabs!
        return !FabricLoader.getInstance().isModLoaded("slabbed")
                && soil.is(ModBlockTags.SOIL_SLABS)
                && soil.hasProperty(SlabBlock.TYPE)
                && soil.getValue(SlabBlock.TYPE) == SlabType.BOTTOM;
    }
}