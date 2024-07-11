package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BambooBlock.class)
public abstract class BambooBlockMixin {
    @Inject(method = "getPlacementState", at = @At("HEAD"), cancellable = true)
    private void getPlacementState(@NotNull ItemPlacementContext ctx, CallbackInfoReturnable<BlockState> cir) {
        if(canStay(ctx.getWorld(), ctx.getBlockPos())) {
            cir.setReturnValue(null);
        }
    }

    @Inject(method = "canPlaceAt", at = @At("HEAD"), cancellable = true)
    private void canPlaceAt(BlockState state, WorldView world, BlockPos pos,
                            CallbackInfoReturnable<Boolean> cir) {
        if(canStay(world, pos)) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private static boolean canStay(WorldView world, BlockPos pos) {
        BlockState soil = world.getBlockState(pos.down());

        return soil.getBlock() instanceof SlabBlock && soil.get(SlabBlock.TYPE).equals(SlabType.BOTTOM);
    }
}