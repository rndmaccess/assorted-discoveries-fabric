package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.config.ModConfigKeys;
import rndm_access.assorteddiscoveries.config.json.ConfigData;
import rndm_access.assorteddiscoveries.config.json.JsonConfig;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow protected abstract int computeFallDamage(float fallDistance, float damageMultiplier);

    @Inject(method = "handleFallDamage", at = @At("HEAD"), cancellable = true)
    public void handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource,
                                 CallbackInfoReturnable<Boolean> info) {
        ConfigData data = ConfigData.getInstance();
        JsonConfig config = ModConfig.getInternalConfig();
        config.load(data);

        boolean isRabbit = ((EntityAccessor) this).getType().equals(EntityType.RABBIT);
        BooleanConfigEntry configEntry = (BooleanConfigEntry) config.getEntry(ModConfigKeys.RABBITS_SAFE_FALL_INCREASED);
        boolean isSafeFallDistanceIncreased = configEntry.getValue();

        // This lets rabbits fall 5 blocks before they take damage.
        if(isRabbit && isSafeFallDistanceIncreased) {
            fallDistance = Math.max(fallDistance - 4.0F, 0.0F);

            if(fallDistance == 0.0F) {
                info.setReturnValue(false);
            }
        }
    }
}
