package rndm_access.assorteddiscoveries.core;

import net.minecraft.component.type.FoodComponent;

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
        return new FoodComponent.Builder().nutrition(hunger).saturationModifier(0.6F).build();
    }

    static {
        FRIED_EGG = (new FoodComponent.Builder()).nutrition(5).saturationModifier(0.6F).build();
        GREEN_ONION = new FoodComponent.Builder().nutrition(1).saturationModifier(0.6F).build();
        NOODLE_SOUP = createBasicStew(8);
        PUDDING = createBasicStew(3);
        BERRY_PUDDING = createBasicStew(6);
        CARAMEL = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build();
        CARAMEL_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.6F).build();
        WITCHS_CRADLE_BRANCH = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
        WITCHS_CRADLE_SOUP = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).alwaysEdible().build();
        BLUEBERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
        SWEET_BERRY_JUICE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
        BLUEBERRY_JUICE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();
        SPRUCE_CONE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3F).build();
        FORESTS_BOUNTY = createBasicStew(5);
        HOGLIN_STEW = new FoodComponent.Builder().nutrition(8).saturationModifier(0.8F).build();
        NETHER_BERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2F).build();
    }
}
