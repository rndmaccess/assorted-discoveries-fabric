package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

import java.util.function.Function;

public final class ModItems {
    public static final Item WHITE_TORCH;
    public static final Item ORANGE_TORCH;
    public static final Item MAGENTA_TORCH;
    public static final Item LIGHT_BLUE_TORCH;
    public static final Item YELLOW_TORCH;
    public static final Item LIME_TORCH;
    public static final Item PINK_TORCH;
    public static final Item GRAY_TORCH;
    public static final Item LIGHT_GRAY_TORCH;
    public static final Item CYAN_TORCH;
    public static final Item PURPLE_TORCH;
    public static final Item BLUE_TORCH;
    public static final Item BROWN_TORCH;
    public static final Item GREEN_TORCH;
    public static final Item RED_TORCH;
    public static final Item BLACK_TORCH;
    public static final Item GREEN_ONION_SEEDS;
    public static final Item GREEN_ONION;
    public static final Item BLUEBERRIES;
    public static final Item SWEET_BERRY_JUICE;
    public static final Item BLUEBERRY_JUICE;
    public static final Item NOODLES;
    public static final Item NOODLE_SOUP;
    public static final Item PUDDING;
    public static final Item BERRY_PUDDING;
    public static final Item SMOKY_QUARTZ;
    public static final Item CARAMEL_APPLE;
    public static final Item CARAMEL;
    public static final Item SPRUCE_CONE;
    public static final Item FORESTS_BOUNTY;
    public static final Item WITCHS_CRADLE_BRANCH;
    public static final Item WITCHS_CRADLE_SOUP;
    public static final Item CATTAIL;
    public static final Item FRIED_EGG;
    public static final Item BLOOD_KELP_SEED_CLUSTER;
    public static final Item BLOOD_KELP;
    public static final Item DRIED_BLOOD_KELP_BLOCK;
    public static final Item DRIED_BLOOD_KELP;
    public static final Item BLOOD_KELP_LANTERN;
    public static final Item CAMEL_PLUSHIE;
    public static final Item HOGLIN_STEW;
    public static final Item BOG_BLOSSOM;
    public static final Item CINDERSNAP_BERRIES;
    public static final Item FROSTBITE_BERRIES;

    private static Item register(String name, Function<Item.Settings, Item> factory,
                                 Item.Settings settings) {
        final Identifier id = ADReference.makeModId(name);
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, id);
        return Items.register(registryKey, factory, settings);
    }

    private static Item registerBlockItem(String name, Block standingBlock, Block wallBlock) {
        final Function<Item.Settings, Item> blockItem = (settingsIn) ->
                new VerticallyAttachableBlockItem(standingBlock, wallBlock, Direction.DOWN, settingsIn);
        return register(name, blockItem, new Item.Settings());
    }

    private static Item registerBlockItem(Block block) {
        return Items.register(block, BlockItem::new);
    }

    private static Item registerBlockItem(String name, Block block) {
        return registerBlockItem(name, block, new Item.Settings());
    }

    private static Item registerBlockItem(String name, Block block, Item.Settings settings) {
        final Function<Item.Settings, Item> blockItem = (settingsIn) -> new BlockItem(block, settingsIn);
        return register(name, blockItem, settings);
    }

    /**
     * Called during mod initialization to register every item.
     */
    public static void registerItems() {
        AssortedDiscoveries.LOGGER.info("Registered Items");
    }

    static {
        WHITE_TORCH = registerBlockItem("white_torch", ModBlocks.WHITE_TORCH, ModBlocks.WHITE_WALL_TORCH);
        ORANGE_TORCH = registerBlockItem("orange_torch", ModBlocks.ORANGE_TORCH, ModBlocks.ORANGE_WALL_TORCH);
        MAGENTA_TORCH = registerBlockItem("magenta_torch", ModBlocks.MAGENTA_TORCH, ModBlocks.MAGENTA_WALL_TORCH);
        LIGHT_BLUE_TORCH = registerBlockItem("light_blue_torch", ModBlocks.LIGHT_BLUE_TORCH,
                ModBlocks.LIGHT_BLUE_WALL_TORCH);
        YELLOW_TORCH = registerBlockItem("yellow_torch", ModBlocks.YELLOW_TORCH, ModBlocks.YELLOW_WALL_TORCH);
        LIME_TORCH = registerBlockItem("lime_torch", ModBlocks.LIME_TORCH, ModBlocks.LIME_WALL_TORCH);
        PINK_TORCH = registerBlockItem("pink_torch", ModBlocks.PINK_TORCH, ModBlocks.PINK_WALL_TORCH);
        GRAY_TORCH = registerBlockItem("gray_torch", ModBlocks.GRAY_TORCH, ModBlocks.GRAY_WALL_TORCH);
        LIGHT_GRAY_TORCH = registerBlockItem("light_gray_torch", ModBlocks.LIGHT_GRAY_TORCH,
                ModBlocks.LIGHT_GRAY_WALL_TORCH);
        CYAN_TORCH = registerBlockItem("cyan_torch", ModBlocks.CYAN_TORCH, ModBlocks.CYAN_WALL_TORCH);
        PURPLE_TORCH = registerBlockItem("purple_torch", ModBlocks.PURPLE_TORCH, ModBlocks.PURPLE_WALL_TORCH);
        BLUE_TORCH = registerBlockItem("blue_torch", ModBlocks.BLUE_TORCH, ModBlocks.BLUE_WALL_TORCH);
        BROWN_TORCH = registerBlockItem("brown_torch", ModBlocks.BROWN_TORCH, ModBlocks.BROWN_WALL_TORCH);
        GREEN_TORCH = registerBlockItem("green_torch", ModBlocks.GREEN_TORCH, ModBlocks.GREEN_WALL_TORCH);
        RED_TORCH = registerBlockItem("red_torch", ModBlocks.RED_TORCH, ModBlocks.RED_WALL_TORCH);
        BLACK_TORCH = registerBlockItem("black_torch", ModBlocks.BLACK_TORCH, ModBlocks.BLACK_WALL_TORCH);
        GREEN_ONION_SEEDS = registerBlockItem("green_onion_seeds", ModBlocks.GREEN_ONIONS);
        GREEN_ONION = register("green_onion", Item::new, new Item.Settings().food(ModFoodComponents.GREEN_ONION));
        BLUEBERRIES = registerBlockItem("blueberries", ModBlocks.BLUEBERRY_BUSH, new Item.Settings()
                .food(ModFoodComponents.BLUEBERRIES));
        SWEET_BERRY_JUICE = register("sweet_berry_juice", Item::new, new Item.Settings()
                .food(ModFoodComponents.SWEET_BERRY_JUICE, ConsumableComponents.DRINK).maxCount(16)
                .useRemainder(Items.GLASS_BOTTLE));
        BLUEBERRY_JUICE = register("blueberry_juice", Item::new, new Item.Settings()
                .food(ModFoodComponents.BLUEBERRY_JUICE, ConsumableComponents.DRINK).maxCount(16)
                .useRemainder(Items.GLASS_BOTTLE));
        NOODLES = register("noodles", Item::new, new Item.Settings());
        NOODLE_SOUP = register("noodle_soup", Item::new, new Item.Settings()
                .food(ModFoodComponents.NOODLE_SOUP).maxCount(1).useRemainder(Items.BOWL));
        PUDDING = register("pudding", Item::new, new Item.Settings()
                .food(ModFoodComponents.PUDDING).maxCount(1).useRemainder(Items.BOWL));
        BERRY_PUDDING = register("berry_pudding", Item::new, new Item.Settings()
                .food(ModFoodComponents.BERRY_PUDDING).maxCount(1).useRemainder(Items.BOWL));
        SMOKY_QUARTZ = register("smoky_quartz", Item::new, new Item.Settings());
        CARAMEL_APPLE = register("caramel_apple", Item::new, new Item.Settings()
                .food(ModFoodComponents.CARAMEL_APPLE).maxCount(1).useRemainder(Items.STICK));
        CARAMEL = register("caramel", Item::new, new Item.Settings().food(ModFoodComponents.CARAMEL));
        SPRUCE_CONE = register("spruce_cone", Item::new, new Item.Settings().food(ModFoodComponents.SPRUCE_CONE));
        FORESTS_BOUNTY = register("forests_bounty", Item::new, new Item.Settings()
                .food(ModFoodComponents.FORESTS_BOUNTY).maxCount(1).useRemainder(Items.BOWL));
        WITCHS_CRADLE_BRANCH = registerBlockItem("witchs_cradle_branch", ModBlocks.WITCHS_CRADLE, new Item.Settings()
                .food(ModFoodComponents.WITCHS_CRADLE_BRANCH));
        WITCHS_CRADLE_SOUP = register("witchs_cradle_soup", Item::new, new Item.Settings()
                .food(ModFoodComponents.WITCHS_CRADLE_SOUP, ModConsumableComponents.WITCHS_CRADLE_SOUP)
                .maxCount(1).useRemainder(Items.BOWL));
        CATTAIL = registerBlockItem(ModBlocks.CATTAIL);
        FRIED_EGG = register("fried_egg", Item::new, new Item.Settings()
                .food(ModFoodComponents.FRIED_EGG).maxCount(16));
        BLOOD_KELP_SEED_CLUSTER = registerBlockItem("blood_kelp_seed_cluster", ModBlocks.BLOOD_KELP);
        BLOOD_KELP = register("blood_kelp", Item::new, new Item.Settings());
        DRIED_BLOOD_KELP_BLOCK = registerBlockItem(ModBlocks.DRIED_BLOOD_KELP_BLOCK);
        DRIED_BLOOD_KELP = register("dried_blood_kelp", Item::new, new Item.Settings()
                .food(FoodComponents.DRIED_KELP));
        BLOOD_KELP_LANTERN = registerBlockItem(ModBlocks.BLOOD_KELP_LANTERN);
        CAMEL_PLUSHIE = registerBlockItem(ModBlocks.CAMEL_PLUSHIE);
        HOGLIN_STEW = register("hoglin_stew", Item::new, new Item.Settings()
                .food(ModFoodComponents.HOGLIN_STEW).maxCount(1).useRemainder(Items.BOWL));
        BOG_BLOSSOM = registerBlockItem(ModBlocks.BOG_BLOSSOM);
        CINDERSNAP_BERRIES = registerBlockItem("cindersnap_berries", ModBlocks.CINDERSNAP_BERRY_BUSH,
                new Item.Settings().food(ModFoodComponents.NETHER_BERRIES));
        FROSTBITE_BERRIES = registerBlockItem("frostbite_berries", ModBlocks.FROSTBITE_BERRY_BUSH,
                new Item.Settings().food(ModFoodComponents.NETHER_BERRIES));
    }
}
