package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "causeFallDamage", at = @At("HEAD"), cancellable = true)
    public void causeFallDamage(double fallDistance, float damagePerDistance, DamageSource damageSource,
                                 CallbackInfoReturnable<Boolean> info) {
        boolean isRabbit = ((EntityAccessor) this).getType().equals(EntityType.RABBIT);

        // This lets rabbits fall 5 blocks before they take damage.
        if(isRabbit) {
            fallDistance = Math.max(fallDistance - 4.0F, 0.0F);

            if(fallDistance == 0.0F) {
                info.setReturnValue(false);
            }
        }
    }
}
