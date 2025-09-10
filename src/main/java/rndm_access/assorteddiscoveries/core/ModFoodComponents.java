package rndm_access.assorteddiscoveries.core;

import net.minecraft.component.type.FoodComponent;

public final class ModFoodComponents {
    public static final FoodComponent FRIED_EGG = (new FoodComponent.Builder()).nutrition(5)
            .saturationModifier(0.6F).build();
    public static final FoodComponent GREEN_ONION = new FoodComponent.Builder().nutrition(1)
            .saturationModifier(0.6F).build();
    public static final FoodComponent NOODLE_SOUP = createBasicStew(8);
    public static final FoodComponent PUDDING = createBasicStew(3);
    public static final FoodComponent BERRY_PUDDING = createBasicStew(6);
    public static final FoodComponent CARAMEL = new FoodComponent.Builder().nutrition(2)
            .saturationModifier(0.3F).build();
    public static final FoodComponent CARAMEL_APPLE = new FoodComponent.Builder().nutrition(4)
            .saturationModifier(0.6F).build();
    public static final FoodComponent WITCHS_CRADLE_BRANCH = new FoodComponent.Builder().nutrition(2)
            .saturationModifier(0.1F).build();
    public static final FoodComponent WITCHS_CRADLE_SOUP = new FoodComponent.Builder().nutrition(6)
            .saturationModifier(0.6F).alwaysEdible().build();
    public static final FoodComponent BLUEBERRIES = new FoodComponent.Builder().nutrition(2)
            .saturationModifier(0.1F).build();
    public static final FoodComponent JUICE = new FoodComponent.Builder().nutrition(6)
            .saturationModifier(0.6F).build();
    public static final FoodComponent SPRUCE_CONE = new FoodComponent.Builder().nutrition(2)
            .saturationModifier(0.3F).build();
    public static final FoodComponent FORESTS_BOUNTY = createBasicStew(5);
    public static final FoodComponent HOGLIN_STEW = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(0.8F).build();
    public static final FoodComponent NETHER_BERRIES = new FoodComponent.Builder().nutrition(3)
            .saturationModifier(0.2F).build();
    public static final FoodComponent NETHER_FORAGE = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(0.8F).build();

    private static FoodComponent createBasicStew(int hunger) {
        return new FoodComponent.Builder().nutrition(hunger).saturationModifier(0.6F).build();
    }
}
