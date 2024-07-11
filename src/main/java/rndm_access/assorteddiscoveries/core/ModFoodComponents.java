package rndm_access.assorteddiscoveries.core;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent FRIED_EGG;
    public static final FoodComponent GREEN_ONION;
    public static final FoodComponent NOODLE_SOUP;
    public static final FoodComponent PUDDING;
    public static final FoodComponent BERRY_PUDDING;
    public static final FoodComponent CARAMEL;
    public static final FoodComponent CARAMEL_APPLE;
    public static final FoodComponent WITCHS_CRADLE_BRANCH;
    public static final FoodComponent WITCHS_CRADLE_SOUP;
    public static final FoodComponent BLUEBERRIES;
    public static final FoodComponent SWEET_BERRY_JUICE;
    public static final FoodComponent BLUEBERRY_JUICE;
    public static final FoodComponent SPRUCE_CONE;
    public static final FoodComponent FORESTS_BOUNTY;
    public static final FoodComponent HOGLIN_STEW;
    public static final FoodComponent NETHER_BERRIES;

    private static FoodComponent createBasicStew(int hunger) {
        return new FoodComponent.Builder().hunger(hunger).saturationModifier(0.6F).build();
    }

    static {
        FRIED_EGG = (new FoodComponent.Builder()).hunger(5).saturationModifier(0.6F).build();
        GREEN_ONION = new FoodComponent.Builder().hunger(1).saturationModifier(0.6F).build();
        NOODLE_SOUP = createBasicStew(8);
        PUDDING = createBasicStew(3);
        BERRY_PUDDING = createBasicStew(6);
        CARAMEL = new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).snack().build();
        CARAMEL_APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(0.6F).build();
        WITCHS_CRADLE_BRANCH = new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).snack().build();
        WITCHS_CRADLE_SOUP = new FoodComponent.Builder().hunger(6).saturationModifier(0.6F)
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1000, 0,
                        true, true), 1.0F).alwaysEdible().build();
        BLUEBERRIES = new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).snack().build();
        SWEET_BERRY_JUICE = new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).build();
        BLUEBERRY_JUICE = new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).build();
        SPRUCE_CONE = new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).snack().build();
        FORESTS_BOUNTY = createBasicStew(5);
        HOGLIN_STEW = new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).build();
        NETHER_BERRIES = new FoodComponent.Builder().hunger(2).saturationModifier(0.2F).snack().build();
    }
}
