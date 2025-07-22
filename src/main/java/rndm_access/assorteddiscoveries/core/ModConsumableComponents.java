package rndm_access.assorteddiscoveries.core;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public final class ModConsumableComponents {
    public static final ConsumableComponent WITCHS_CRADLE_SOUP;
    public static final ConsumableComponent NETHER_FOOD;

    static {
        WITCHS_CRADLE_SOUP = ConsumableComponents.food()
                .consumeEffect(new ApplyEffectsConsumeEffect(
                        new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2400, 0,
                                true, true))).build();
        NETHER_FOOD = ConsumableComponents.drink()
                .consumeEffect(new ApplyEffectsConsumeEffect(
                        new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400,
                                0, true, true))).build();
    }
}
