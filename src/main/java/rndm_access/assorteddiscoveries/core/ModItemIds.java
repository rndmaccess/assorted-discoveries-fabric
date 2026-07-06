package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModItemIds {
    public static final ResourceKey<Item> WHITE_TORCH_KEY = createKey("white_torch");
    public static final ResourceKey<Item> ORANGE_TORCH_KEY = createKey("orange_torch");
    public static final ResourceKey<Item> MAGENTA_TORCH_KEY = createKey("magenta_torch");
    public static final ResourceKey<Item> LIGHT_BLUE_TORCH_KEY = createKey("light_blue_torch");
    public static final ResourceKey<Item> YELLOW_TORCH_KEY = createKey("yellow_torch");
    public static final ResourceKey<Item> LIME_TORCH_KEY = createKey("lime_torch");
    public static final ResourceKey<Item> PINK_TORCH_KEY = createKey("pink_torch");
    public static final ResourceKey<Item> GRAY_TORCH_KEY = createKey("gray_torch");
    public static final ResourceKey<Item> LIGHT_GRAY_TORCH_KEY = createKey("light_gray_torch");
    public static final ResourceKey<Item> CYAN_TORCH_KEY = createKey("cyan_torch");
    public static final ResourceKey<Item> PURPLE_TORCH_KEY = createKey("purple_torch");
    public static final ResourceKey<Item> BLUE_TORCH_KEY = createKey("blue_torch");
    public static final ResourceKey<Item> BROWN_TORCH_KEY = createKey("brown_torch");
    public static final ResourceKey<Item> GREEN_TORCH_KEY = createKey("green_torch");
    public static final ResourceKey<Item> RED_TORCH_KEY = createKey("red_torch");
    public static final ResourceKey<Item> BLACK_TORCH_KEY = createKey("black_torch");
    public static final ResourceKey<Item> GREEN_ONION_SEEDS_KEY = createKey("green_onion_seeds");
    public static final ResourceKey<Item> GREEN_ONION_KEY = createKey("green_onion");
    public static final ResourceKey<Item> BLUEBERRIES_KEY = createKey("blueberries");
    public static final ResourceKey<Item> SWEET_BERRY_JUICE_KEY = createKey("sweet_berry_juice");
    public static final ResourceKey<Item> BLUEBERRY_JUICE_KEY = createKey("blueberry_juice");
    public static final ResourceKey<Item> NOODLES_KEY = createKey("noodles");
    public static final ResourceKey<Item> NOODLE_SOUP_KEY = createKey("noodle_soup");
    public static final ResourceKey<Item> PUDDING_KEY = createKey("pudding");
    public static final ResourceKey<Item> BERRY_PUDDING_KEY = createKey("berry_pudding");
    public static final ResourceKey<Item> SMOKY_QUARTZ_KEY = createKey("smoky_quartz");
    public static final ResourceKey<Item> CARAMEL_APPLE_KEY = createKey("caramel_apple");
    public static final ResourceKey<Item> CARAMEL_KEY = createKey("caramel");
    public static final ResourceKey<Item> SPRUCE_CONE_KEY = createKey("spruce_cone");
    public static final ResourceKey<Item> FORESTS_BOUNTY_KEY = createKey("forests_bounty");
    public static final ResourceKey<Item> WITCHS_CRADLE_BRANCH_KEY = createKey("witchs_cradle_branch");
    public static final ResourceKey<Item> WITCHS_CRADLE_SOUP_KEY = createKey("witchs_cradle_soup");
    public static final ResourceKey<Item> FRIED_EGG_KEY = createKey("fried_egg");
    public static final ResourceKey<Item> BLOOD_KELP_SEED_CLUSTER_KEY = createKey("blood_kelp_seed_cluster");
    public static final ResourceKey<Item> BLOOD_KELP_KEY = createKey("blood_kelp");
    public static final ResourceKey<Item> DRIED_BLOOD_KELP_KEY = createKey("dried_blood_kelp");
    public static final ResourceKey<Item> HOGLIN_STEW_KEY = createKey("hoglin_stew");
    public static final ResourceKey<Item> CINDERSNAP_BERRIES_KEY = createKey("cindersnap_berries");
    public static final ResourceKey<Item> FROSTBITE_BERRIES_KEY = createKey("frostbite_berries");
    public static final ResourceKey<Item> CINDERSNAP_BERRY_JUICE_KEY = createKey("cindersnap_berry_juice");
    public static final ResourceKey<Item> FROSTBITE_BERRY_JUICE_KEY = createKey("frostbite_berry_juice");
    public static final ResourceKey<Item> WARPED_FORAGE_MIX_KEY = createKey("warped_forage_mix");
    public static final ResourceKey<Item> CRIMSON_FORAGE_MIX_KEY = createKey("crimson_forage_mix");

    private static ResourceKey<Item> createKey(String name) {
        return ResourceKey.create(Registries.ITEM, AssortedDiscoveries.makeModId(name));
    }
}
