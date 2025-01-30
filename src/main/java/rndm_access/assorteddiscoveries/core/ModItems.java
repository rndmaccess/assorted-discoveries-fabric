package rndm_access.assorteddiscoveries.core;

import net.minecraft.block.Block;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Direction;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModItems {
    public static final RegistryKey<Item> WHITE_TORCH_KEY = makeRegistryKey("white_torch");
    public static final Item WHITE_TORCH = registerBlockItem(WHITE_TORCH_KEY,
            ModBlocks.WHITE_TORCH, ModBlocks.WHITE_WALL_TORCH);
    public static final RegistryKey<Item> ORANGE_TORCH_KEY = makeRegistryKey("orange_torch");
    public static final Item ORANGE_TORCH = registerBlockItem(ORANGE_TORCH_KEY,
            ModBlocks.ORANGE_TORCH, ModBlocks.ORANGE_WALL_TORCH);
    public static final RegistryKey<Item> MAGENTA_TORCH_KEY = makeRegistryKey("magenta_torch");
    public static final Item MAGENTA_TORCH = registerBlockItem(MAGENTA_TORCH_KEY,
            ModBlocks.MAGENTA_TORCH, ModBlocks.MAGENTA_WALL_TORCH);
    public static final RegistryKey<Item> LIGHT_BLUE_TORCH_KEY = makeRegistryKey("light_blue_torch");
    public static final Item LIGHT_BLUE_TORCH = registerBlockItem(LIGHT_BLUE_TORCH_KEY,
            ModBlocks.LIGHT_BLUE_TORCH, ModBlocks.LIGHT_BLUE_WALL_TORCH);
    public static final RegistryKey<Item> YELLOW_TORCH_KEY = makeRegistryKey("yellow_torch");
    public static final Item YELLOW_TORCH = registerBlockItem(YELLOW_TORCH_KEY,
            ModBlocks.YELLOW_TORCH, ModBlocks.YELLOW_WALL_TORCH);
    public static final RegistryKey<Item> LIME_TORCH_KEY = makeRegistryKey("lime_torch");
    public static final Item LIME_TORCH = registerBlockItem(LIME_TORCH_KEY,
            ModBlocks.LIME_TORCH, ModBlocks.LIME_WALL_TORCH);
    public static final RegistryKey<Item> PINK_TORCH_KEY = makeRegistryKey("pink_torch");
    public static final Item PINK_TORCH = registerBlockItem(PINK_TORCH_KEY,
            ModBlocks.PINK_TORCH, ModBlocks.PINK_WALL_TORCH);
    public static final RegistryKey<Item> GRAY_TORCH_KEY = makeRegistryKey("gray_torch");
    public static final Item GRAY_TORCH = registerBlockItem(GRAY_TORCH_KEY,
            ModBlocks.GRAY_TORCH, ModBlocks.GRAY_WALL_TORCH);
    public static final RegistryKey<Item> LIGHT_GRAY_TORCH_KEY = makeRegistryKey("light_gray_torch");
    public static final Item LIGHT_GRAY_TORCH = registerBlockItem(LIGHT_GRAY_TORCH_KEY,
            ModBlocks.LIGHT_GRAY_TORCH, ModBlocks.LIGHT_GRAY_WALL_TORCH);
    public static final RegistryKey<Item> CYAN_TORCH_KEY = makeRegistryKey("cyan_torch");
    public static final Item CYAN_TORCH = registerBlockItem(CYAN_TORCH_KEY,
            ModBlocks.CYAN_TORCH, ModBlocks.CYAN_WALL_TORCH);
    public static final RegistryKey<Item> PURPLE_TORCH_KEY = makeRegistryKey("purple_torch");
    public static final Item PURPLE_TORCH = registerBlockItem(PURPLE_TORCH_KEY,
            ModBlocks.PURPLE_TORCH, ModBlocks.PURPLE_WALL_TORCH);
    public static final RegistryKey<Item> BLUE_TORCH_KEY = makeRegistryKey("blue_torch");
    public static final Item BLUE_TORCH = registerBlockItem(BLUE_TORCH_KEY,
            ModBlocks.BLUE_TORCH, ModBlocks.BLUE_WALL_TORCH);
    public static final RegistryKey<Item> BROWN_TORCH_KEY = makeRegistryKey("brown_torch");
    public static final Item BROWN_TORCH = registerBlockItem(BROWN_TORCH_KEY,
            ModBlocks.BROWN_TORCH, ModBlocks.BROWN_WALL_TORCH);
    public static final RegistryKey<Item> GREEN_TORCH_KEY = makeRegistryKey("green_torch");
    public static final Item GREEN_TORCH = registerBlockItem(GREEN_TORCH_KEY,
            ModBlocks.GREEN_TORCH, ModBlocks.GREEN_WALL_TORCH);
    public static final RegistryKey<Item> RED_TORCH_KEY = makeRegistryKey("red_torch");
    public static final Item RED_TORCH = registerBlockItem(RED_TORCH_KEY,
            ModBlocks.RED_TORCH, ModBlocks.RED_WALL_TORCH);
    public static final RegistryKey<Item> BLACK_TORCH_KEY = makeRegistryKey("black_torch");
    public static final Item BLACK_TORCH = registerBlockItem(BLACK_TORCH_KEY,
            ModBlocks.BLACK_TORCH, ModBlocks.BLACK_WALL_TORCH);
    public static final RegistryKey<Item> GREEN_ONION_SEEDS_KEY = makeRegistryKey("green_onion_seeds");
    public static final Item GREEN_ONION_SEEDS = registerBlockItem(GREEN_ONION_SEEDS_KEY, ModBlocks.GREEN_ONIONS);
    public static final RegistryKey<Item> GREEN_ONION_KEY = makeRegistryKey("green_onion");
    public static final Item GREEN_ONION
            = register(new Item(new Item.Settings().food(ModFoodComponents.GREEN_ONION)
            .registryKey(GREEN_ONION_KEY)), GREEN_ONION_KEY);
    public static final RegistryKey<Item> BLUEBERRIES_KEY = makeRegistryKey("blueberries");
    public static final Item BLUEBERRIES = registerBlockItem(BLUEBERRIES_KEY, ModBlocks.BLUEBERRY_BUSH,
            new Item.Settings().food(ModFoodComponents.BLUEBERRIES).registryKey(BLUEBERRIES_KEY));
    public static final RegistryKey<Item> SWEET_BERRY_JUICE_KEY = makeRegistryKey("sweet_berry_juice");
    public static final Item SWEET_BERRY_JUICE = register(new Item(new Item.Settings()
                .food(ModFoodComponents.SWEET_BERRY_JUICE, ConsumableComponents.DRINK).maxCount(16)
                .useRemainder(Items.GLASS_BOTTLE).registryKey(SWEET_BERRY_JUICE_KEY)), SWEET_BERRY_JUICE_KEY);
    public static final RegistryKey<Item> BLUEBERRY_JUICE_KEY = makeRegistryKey("blueberry_juice");
    public static final Item BLUEBERRY_JUICE = register(new Item(new Item.Settings()
                .food(ModFoodComponents.BLUEBERRY_JUICE, ConsumableComponents.DRINK).maxCount(16)
                .useRemainder(Items.GLASS_BOTTLE).registryKey(BLUEBERRY_JUICE_KEY)), BLUEBERRY_JUICE_KEY);
    public static final RegistryKey<Item> NOODLES_KEY = makeRegistryKey("noodles");
    public static final Item NOODLES = register(new Item(new Item.Settings().registryKey(NOODLES_KEY)), NOODLES_KEY);
    public static final RegistryKey<Item> NOODLE_SOUP_KEY = makeRegistryKey("noodle_soup");
    public static final Item NOODLE_SOUP = register(new Item(new Item.Settings().food(ModFoodComponents.NOODLE_SOUP)
            .maxCount(1).useRemainder(Items.BOWL).registryKey(NOODLE_SOUP_KEY)), NOODLE_SOUP_KEY);
    public static final RegistryKey<Item> PUDDING_KEY = makeRegistryKey("pudding");
    public static final Item PUDDING = register(new Item(new Item.Settings()
            .food(ModFoodComponents.PUDDING).maxCount(1).useRemainder(Items.BOWL).registryKey(PUDDING_KEY)),
            PUDDING_KEY);
    public static final RegistryKey<Item> BERRY_PUDDING_KEY = makeRegistryKey("berry_pudding");
    public static final Item BERRY_PUDDING = register(new Item(new Item.Settings()
            .food(ModFoodComponents.BERRY_PUDDING).maxCount(1).useRemainder(Items.BOWL)
            .registryKey(BERRY_PUDDING_KEY)), BERRY_PUDDING_KEY);
    public static final RegistryKey<Item> SMOKY_QUARTZ_KEY = makeRegistryKey("smoky_quartz");
    public static final Item SMOKY_QUARTZ = register(new Item(new Item.Settings().registryKey(SMOKY_QUARTZ_KEY)),
            SMOKY_QUARTZ_KEY);
    public static final RegistryKey<Item> CARAMEL_APPLE_KEY = makeRegistryKey("caramel_apple");
    public static final Item CARAMEL_APPLE = register(new Item(new Item.Settings()
            .food(ModFoodComponents.CARAMEL_APPLE).maxCount(1).useRemainder(Items.STICK)
            .registryKey(CARAMEL_APPLE_KEY)), CARAMEL_APPLE_KEY);
    public static final RegistryKey<Item> CARAMEL_KEY = makeRegistryKey("caramel");
    public static final Item CARAMEL = register(new Item(new Item.Settings().food(ModFoodComponents.CARAMEL)
            .registryKey(CARAMEL_KEY)), CARAMEL_KEY);
    public static final RegistryKey<Item> SPRUCE_CONE_KEY = makeRegistryKey("spruce_cone");
    public static final Item SPRUCE_CONE = register(new Item(new Item.Settings().food(ModFoodComponents.SPRUCE_CONE)
            .registryKey(SPRUCE_CONE_KEY)), SPRUCE_CONE_KEY);
    public static final RegistryKey<Item> FORESTS_BOUNTY_KEY = makeRegistryKey("forests_bounty");
    public static final Item FORESTS_BOUNTY = register(new Item(new Item.Settings()
            .food(ModFoodComponents.FORESTS_BOUNTY).maxCount(1).useRemainder(Items.BOWL)
            .registryKey(FORESTS_BOUNTY_KEY)), FORESTS_BOUNTY_KEY);
    public static final RegistryKey<Item> WITCHS_CRADLE_BRANCH_KEY = makeRegistryKey("witchs_cradle_branch");
    public static final Item WITCHS_CRADLE_BRANCH = registerBlockItem(WITCHS_CRADLE_BRANCH_KEY, ModBlocks.WITCHS_CRADLE,
            new Item.Settings().food(ModFoodComponents.WITCHS_CRADLE_BRANCH).registryKey(WITCHS_CRADLE_BRANCH_KEY));
    public static final RegistryKey<Item> WITCHS_CRADLE_SOUP_KEY = makeRegistryKey("witchs_cradle_soup");
    public static final Item WITCHS_CRADLE_SOUP = register(new Item(new Item.Settings()
            .food(ModFoodComponents.WITCHS_CRADLE_SOUP, ModConsumableComponents.WITCHS_CRADLE_SOUP)
            .maxCount(1).useRemainder(Items.BOWL).registryKey(WITCHS_CRADLE_SOUP_KEY)), WITCHS_CRADLE_SOUP_KEY);
    public static final RegistryKey<Item> FRIED_EGG_KEY = makeRegistryKey("fried_egg");
    public static final Item FRIED_EGG = register(new Item(new Item.Settings()
            .food(ModFoodComponents.FRIED_EGG).maxCount(16).registryKey(FRIED_EGG_KEY)), FRIED_EGG_KEY);
    public static final RegistryKey<Item> BLOOD_KELP_SEED_CLUSTER_KEY = makeRegistryKey("blood_kelp_seed_cluster");
    public static final Item BLOOD_KELP_SEED_CLUSTER = registerBlockItem(BLOOD_KELP_SEED_CLUSTER_KEY, ModBlocks.BLOOD_KELP);
    public static final RegistryKey<Item> BLOOD_KELP_KEY = makeRegistryKey("blood_kelp");
    public static final Item BLOOD_KELP = register(new Item(new Item.Settings()
            .registryKey(BLOOD_KELP_KEY)), BLOOD_KELP_KEY);
    public static final RegistryKey<Item> DRIED_BLOOD_KELP_KEY = makeRegistryKey("dried_blood_kelp");
    public static final Item DRIED_BLOOD_KELP = register(new Item(new Item.Settings()
            .food(FoodComponents.DRIED_KELP).registryKey(DRIED_BLOOD_KELP_KEY)), DRIED_BLOOD_KELP_KEY);
    public static final RegistryKey<Item> HOGLIN_STEW_KEY = makeRegistryKey("hoglin_stew");
    public static final Item HOGLIN_STEW = register(new Item(new Item.Settings()
            .food(ModFoodComponents.HOGLIN_STEW).maxCount(1).useRemainder(Items.BOWL)
            .registryKey(HOGLIN_STEW_KEY)), HOGLIN_STEW_KEY);
    public static final RegistryKey<Item> CINDERSNAP_BERRIES_KEY = makeRegistryKey("cindersnap_berries");
    public static final Item CINDERSNAP_BERRIES = registerBlockItem(CINDERSNAP_BERRIES_KEY,
            ModBlocks.CINDERSNAP_BERRY_BUSH, new Item.Settings().food(ModFoodComponents.NETHER_BERRIES)
                    .registryKey(CINDERSNAP_BERRIES_KEY));
    public static final RegistryKey<Item> FROSTBITE_BERRIES_KEY = makeRegistryKey("frostbite_berries");
    public static final Item FROSTBITE_BERRIES = registerBlockItem(FROSTBITE_BERRIES_KEY,
            ModBlocks.FROSTBITE_BERRY_BUSH, new Item.Settings().food(ModFoodComponents.NETHER_BERRIES)
                    .registryKey(FROSTBITE_BERRIES_KEY));

    private static RegistryKey<Item> makeRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, ADReference.makeModId(name));
    }

    private static Item register(Item item, RegistryKey<Item> key) {
        return Registry.register(Registries.ITEM, key, item);
    }

    private static Item registerBlockItem(RegistryKey<Item> key, Block standingBlock, Block wallBlock) {
        final Item blockItem = new VerticallyAttachableBlockItem(standingBlock, wallBlock,
                Direction.DOWN, new Item.Settings().registryKey(key));
        Item.BLOCK_ITEMS.put(standingBlock, blockItem);
        Item.BLOCK_ITEMS.put(wallBlock, blockItem);
        return register(blockItem, key);
    }

    private static Item registerBlockItem(RegistryKey<Item> key, Block block) {
        final Item blockItem = new BlockItem(block, new Item.Settings().registryKey(key));
        Item.BLOCK_ITEMS.put(block, blockItem);
        return register(blockItem, key);
    }

    private static Item registerBlockItem(RegistryKey<Item> key, Block block, Item.Settings settings) {
        final Item blockItem = new BlockItem(block, settings);
        Item.BLOCK_ITEMS.put(block, blockItem);
        return register(blockItem, key);
    }

    /**
     * Called during mod initialization to register every item.
     */
    public static void registerItems() {
        AssortedDiscoveries.LOGGER.info("Registered Items");
    }
}
