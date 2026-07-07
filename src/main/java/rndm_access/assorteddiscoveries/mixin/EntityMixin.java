package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rndm_access.assorteddiscoveries.core.ModBlocks;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Unique
    private static final float JUMP_HEIGHT = 2.0F;

    @Shadow
    public void setDeltaMovement(final double xd, final double yd, final double zd) {}
    @Shadow
    public abstract boolean isCrouching();

    @Inject(method = "restituteMovementAfterCollisions", at = @At("HEAD"), cancellable = true)
    private void restituteMovementAfterCollisions(BlockState effectState, boolean xCollision, boolean zCollision,
                                                  Vec3 movement, CallbackInfo ci) {
        // Make the purple mushroom blocks bouncy!!!
        if (effectState.is(ModBlocks.PURPLE_MUSHROOM_BLOCK) && !isCrouching()) {
            if(movement.y() < 0) {
                setDeltaMovement(movement.x(), JUMP_HEIGHT, movement.z());
            } else {
                setDeltaMovement(movement.x(), movement.y(), movement.z());
            }
            ci.cancel();
        }
    }
}
