package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BambooStalkBlock.class)
public abstract class BambooBlockMixin {
    @Inject(method = "getStateForPlacement", at = @At("HEAD"), cancellable = true)
    private void getStateForPlacement(@NotNull BlockPlaceContext ctx, CallbackInfoReturnable<BlockState> cir) {
        if(canStay(ctx.getLevel(), ctx.getClickedPos())) {
            cir.setReturnValue(null);
        }
    }

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    private void canSurvive(BlockState state, LevelReader world, BlockPos pos,
                            CallbackInfoReturnable<Boolean> cir) {
        if(canStay(world, pos)) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private static boolean canStay(LevelReader world, BlockPos pos) {
        BlockState soil = world.getBlockState(pos.below());

        return soil.getBlock() instanceof SlabBlock && soil.getValue(SlabBlock.TYPE).equals(SlabType.BOTTOM);
    }
}