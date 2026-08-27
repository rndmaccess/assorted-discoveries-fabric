package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @ModifyReturnValue(method = "causeFallDamage", at = @At("RETURN"))
    public boolean assorteddiscoveries$extendSafeRabbitFall(boolean original, double fallDistance,
                                                            float damagePerDistance, DamageSource damageSource) {
        boolean isRabbit = ((EntityAccessor) this).getType().equals(EntityType.RABBIT);

        // This lets rabbits fall 6 blocks before they take damage.
        if(isRabbit && fallDistance <= 6.0) {
            return false;
        }
        return original;
    }
}
