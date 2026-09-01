package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.block.Block;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModItems {
    public static final Item WHITE_TORCH = registerTorch(ModItemIds.WHITE_TORCH_KEY,
            ModBlocks.WHITE_TORCH, ModBlocks.WHITE_WALL_TORCH);
    public static final Item ORANGE_TORCH = registerTorch(ModItemIds.ORANGE_TORCH_KEY,
            ModBlocks.ORANGE_TORCH, ModBlocks.ORANGE_WALL_TORCH);
    public static final Item MAGENTA_TORCH = registerTorch(ModItemIds.MAGENTA_TORCH_KEY,
            ModBlocks.MAGENTA_TORCH, ModBlocks.MAGENTA_WALL_TORCH);
    public static final Item LIGHT_BLUE_TORCH = registerTorch(ModItemIds.LIGHT_BLUE_TORCH_KEY,
            ModBlocks.LIGHT_BLUE_TORCH, ModBlocks.LIGHT_BLUE_WALL_TORCH);
    public static final Item YELLOW_TORCH = registerTorch(ModItemIds.YELLOW_TORCH_KEY,
            ModBlocks.YELLOW_TORCH, ModBlocks.YELLOW_WALL_TORCH);
    public static final Item LIME_TORCH = registerTorch(ModItemIds.LIME_TORCH_KEY,
            ModBlocks.LIME_TORCH, ModBlocks.LIME_WALL_TORCH);
    public static final Item PINK_TORCH = registerTorch(ModItemIds.PINK_TORCH_KEY,
            ModBlocks.PINK_TORCH, ModBlocks.PINK_WALL_TORCH);
    public static final Item GRAY_TORCH = registerTorch(ModItemIds.GRAY_TORCH_KEY,
            ModBlocks.GRAY_TORCH, ModBlocks.GRAY_WALL_TORCH);
    public static final Item LIGHT_GRAY_TORCH = registerTorch(ModItemIds.LIGHT_GRAY_TORCH_KEY,
            ModBlocks.LIGHT_GRAY_TORCH, ModBlocks.LIGHT_GRAY_WALL_TORCH);
    public static final Item CYAN_TORCH = registerTorch(ModItemIds.CYAN_TORCH_KEY,
            ModBlocks.CYAN_TORCH, ModBlocks.CYAN_WALL_TORCH);
    public static final Item PURPLE_TORCH = registerTorch(ModItemIds.PURPLE_TORCH_KEY,
            ModBlocks.PURPLE_TORCH, ModBlocks.PURPLE_WALL_TORCH);
    public static final Item BLUE_TORCH = registerTorch(ModItemIds.BLUE_TORCH_KEY,
            ModBlocks.BLUE_TORCH, ModBlocks.BLUE_WALL_TORCH);
    public static final Item BROWN_TORCH = registerTorch(ModItemIds.BROWN_TORCH_KEY,
            ModBlocks.BROWN_TORCH, ModBlocks.BROWN_WALL_TORCH);
    public static final Item GREEN_TORCH = registerTorch(ModItemIds.GREEN_TORCH_KEY,
            ModBlocks.GREEN_TORCH, ModBlocks.GREEN_WALL_TORCH);
    public static final Item RED_TORCH = registerTorch(ModItemIds.RED_TORCH_KEY,
            ModBlocks.RED_TORCH, ModBlocks.RED_WALL_TORCH);
    public static final Item BLACK_TORCH = registerTorch(ModItemIds.BLACK_TORCH_KEY,
            ModBlocks.BLACK_TORCH, ModBlocks.BLACK_WALL_TORCH);
    public static final Item GREEN_ONION_SEEDS = registerBlockItem(ModItemIds.GREEN_ONION_SEEDS_KEY, ModBlocks.GREEN_ONIONS);
    public static final Item GREEN_ONION
            = register(new Item(new Item.Properties().food(ModFoods.GREEN_ONION)
            .setId(ModItemIds.GREEN_ONION_KEY)), ModItemIds.GREEN_ONION_KEY);
    public static final Item BLUEBERRIES = registerBlockItem(ModItemIds.BLUEBERRIES_KEY, ModBlocks.BLUEBERRY_BUSH,
            new Item.Properties().food(ModFoods.BLUEBERRIES));
    public static final Item SWEET_BERRY_JUICE = register(new Item(new Item.Properties()
                .food(ModFoods.JUICE, Consumables.DEFAULT_DRINK).stacksTo(16)
                .usingConvertsTo(Items.GLASS_BOTTLE).setId(ModItemIds.SWEET_BERRY_JUICE_KEY)), ModItemIds.SWEET_BERRY_JUICE_KEY);
    public static final Item BLUEBERRY_JUICE = register(new Item(new Item.Properties()
                .food(ModFoods.JUICE, Consumables.DEFAULT_DRINK).stacksTo(16)
                .usingConvertsTo(Items.GLASS_BOTTLE).setId(ModItemIds.BLUEBERRY_JUICE_KEY)), ModItemIds.BLUEBERRY_JUICE_KEY);
    public static final Item NOODLES = register(new Item(new Item.Properties().setId(ModItemIds.NOODLES_KEY)), ModItemIds.NOODLES_KEY);
    public static final Item NOODLE_SOUP = register(new Item(new Item.Properties().food(ModFoods.NOODLE_SOUP)
            .stacksTo(1).usingConvertsTo(Items.BOWL).setId(ModItemIds.NOODLE_SOUP_KEY)), ModItemIds.NOODLE_SOUP_KEY);
    public static final Item PUDDING = register(new Item(new Item.Properties()
            .food(ModFoods.PUDDING).stacksTo(1).usingConvertsTo(Items.BOWL).setId(ModItemIds.PUDDING_KEY)),
            ModItemIds.PUDDING_KEY);
    public static final Item BERRY_PUDDING = register(new Item(new Item.Properties()
            .food(ModFoods.BERRY_PUDDING).stacksTo(1).usingConvertsTo(Items.BOWL)
            .setId(ModItemIds.BERRY_PUDDING_KEY)), ModItemIds.BERRY_PUDDING_KEY);
    public static final Item SMOKY_QUARTZ = register(new Item(new Item.Properties().setId(ModItemIds.SMOKY_QUARTZ_KEY)),
            ModItemIds.SMOKY_QUARTZ_KEY);
    public static final Item CARAMEL_APPLE = register(new Item(new Item.Properties()
            .food(ModFoods.CARAMEL_APPLE, ModConsumableComponents.CARAMEL_APPLE).stacksTo(16)
            .usingConvertsTo(Items.STICK).setId(ModItemIds.CARAMEL_APPLE_KEY)), ModItemIds.CARAMEL_APPLE_KEY);
    public static final Item CARAMEL = register(new Item(new Item.Properties().food(ModFoods.CARAMEL)
            .setId(ModItemIds.CARAMEL_KEY)), ModItemIds.CARAMEL_KEY);
    public static final Item SPRUCE_CONE = register(new Item(new Item.Properties().food(ModFoods.SPRUCE_CONE)
            .setId(ModItemIds.SPRUCE_CONE_KEY)), ModItemIds.SPRUCE_CONE_KEY);
    public static final Item FORESTS_BOUNTY = register(new Item(new Item.Properties()
            .food(ModFoods.FORESTS_BOUNTY).stacksTo(1).usingConvertsTo(Items.BOWL)
            .setId(ModItemIds.FORESTS_BOUNTY_KEY)), ModItemIds.FORESTS_BOUNTY_KEY);
    public static final Item WITCHS_CRADLE_BRANCH = registerBlockItem(ModItemIds.WITCHS_CRADLE_BRANCH_KEY, ModBlocks.WITCHS_CRADLE,
            new Item.Properties().food(ModFoods.WITCHS_CRADLE_BRANCH));
    public static final Item WITCHS_CRADLE_SOUP = register(new Item(new Item.Properties()
            .food(ModFoods.WITCHS_CRADLE_SOUP, ModConsumableComponents.WITCHS_CRADLE_SOUP)
            .stacksTo(1).usingConvertsTo(Items.BOWL).setId(ModItemIds.WITCHS_CRADLE_SOUP_KEY)), ModItemIds.WITCHS_CRADLE_SOUP_KEY);
    public static final Item FRIED_EGG = register(new Item(new Item.Properties()
            .food(ModFoods.FRIED_EGG).stacksTo(16).setId(ModItemIds.FRIED_EGG_KEY)), ModItemIds.FRIED_EGG_KEY);
    public static final Item BLOOD_KELP_SEED_CLUSTER = registerBlockItem(ModItemIds.BLOOD_KELP_SEED_CLUSTER_KEY, ModBlocks.BLOOD_KELP);
    public static final Item BLOOD_KELP = register(new Item(new Item.Properties()
            .setId(ModItemIds.BLOOD_KELP_KEY)), ModItemIds.BLOOD_KELP_KEY);
    public static final Item DRIED_BLOOD_KELP = register(new Item(new Item.Properties()
            .food(Foods.DRIED_KELP).setId(ModItemIds.DRIED_BLOOD_KELP_KEY)), ModItemIds.DRIED_BLOOD_KELP_KEY);
    public static final Item HOGLIN_STEW = register(new Item(new Item.Properties()
            .food(ModFoods.HOGLIN_STEW).stacksTo(1).usingConvertsTo(Items.BOWL)
            .setId(ModItemIds.HOGLIN_STEW_KEY)), ModItemIds.HOGLIN_STEW_KEY);
    public static final Item CINDERSNAP_BERRIES = registerBlockItem(ModItemIds.CINDERSNAP_BERRIES_KEY,
            ModBlocks.CINDERSNAP_BERRY_BUSH, new Item.Properties().food(ModFoods.NETHER_BERRIES));
    public static final Item FROSTBITE_BERRIES = registerBlockItem(ModItemIds.FROSTBITE_BERRIES_KEY,
            ModBlocks.FROSTBITE_BERRY_BUSH, new Item.Properties().food(ModFoods.NETHER_BERRIES));
    public static final Item CINDERSNAP_BERRY_JUICE = register(new Item(new Item.Properties()
                .food(ModFoods.NETHER_JUICE, ModConsumableComponents.NETHER_DRINK).stacksTo(16)
                .usingConvertsTo(Items.GLASS_BOTTLE).setId(ModItemIds.CINDERSNAP_BERRY_JUICE_KEY)), ModItemIds.CINDERSNAP_BERRY_JUICE_KEY);
    public static final Item FROSTBITE_BERRY_JUICE = register(new Item(new Item.Properties()
            .food(ModFoods.NETHER_JUICE, ModConsumableComponents.NETHER_DRINK).stacksTo(16)
            .usingConvertsTo(Items.GLASS_BOTTLE).setId(ModItemIds.FROSTBITE_BERRY_JUICE_KEY)), ModItemIds.FROSTBITE_BERRY_JUICE_KEY);
    public static final Item WARPED_FORAGE_MIX = register(new Item(new Item.Properties().stacksTo(32)
            .food(ModFoods.NETHER_FORAGE, ModConsumableComponents.NETHER_FOOD)
            .setId(ModItemIds.WARPED_FORAGE_MIX_KEY)), ModItemIds.WARPED_FORAGE_MIX_KEY);
    public static final Item CRIMSON_FORAGE_MIX = register(new Item(new Item.Properties()
            .food(ModFoods.NETHER_FORAGE, ModConsumableComponents.NETHER_FOOD).stacksTo(32)
            .setId(ModItemIds.CRIMSON_FORAGE_MIX_KEY)), ModItemIds.CRIMSON_FORAGE_MIX_KEY);

    private static Item register(Item item, ResourceKey<Item> key) {
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item registerTorch(ResourceKey<Item> key, Block standingBlock, Block wallBlock) {
        final Item blockItem = register(new StandingAndWallBlockItem(standingBlock, wallBlock,
                Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().setId(key)), key);
        Item.BY_BLOCK.put(standingBlock, blockItem);
        Item.BY_BLOCK.put(wallBlock, blockItem);
        return blockItem;
    }

    private static Item registerBlockItem(ResourceKey<Item> key, Block block) {
        final Item blockItem = register(new BlockItem(block, new Item.Properties().setId(key)), key);
        Item.BY_BLOCK.put(block, blockItem);
        return blockItem;
    }

    private static Item registerBlockItem(ResourceKey<Item> key, Block block, Item.Properties settings) {
        final Item blockItem = register(new BlockItem(block, settings.setId(key)), key);
        Item.BY_BLOCK.put(block, blockItem);
        return blockItem;
    }

    /**
     * Called during mod initialization to register every item.
     */
    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered Items");
    }
}
