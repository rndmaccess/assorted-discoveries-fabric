package rndm_access.assorteddiscoveries.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.config.ADConfig;

@Mixin(LivingEntity.class)
public abstract class ADLivingEntityMixin {

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    public void handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource,
                                 CallbackInfoReturnable<Boolean> info) {
        ADConfig config = AutoConfig.getConfigHolder(ADConfig.class).getConfig();

        // This lets rabbits fall 5 blocks before they take damage.
        if(((ADEntityAccessor) this).getType().equals(EntityType.RABBIT) && config.getIsRabbitsSafeFallIncreased()) {
            fallDistance = Math.max(fallDistance - 4.0F, 0.0F);

            if(fallDistance == 0.0F) {
                info.setReturnValue(false);
            }
        }
    }
}
