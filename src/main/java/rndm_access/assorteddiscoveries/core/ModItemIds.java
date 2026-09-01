package rndm_access.assorteddiscoveries.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModItemIds {
    public static final ResourceKey<Item> WHITE_TORCH_KEY = create("white_torch");
    public static final ResourceKey<Item> ORANGE_TORCH_KEY = create("orange_torch");
    public static final ResourceKey<Item> MAGENTA_TORCH_KEY = create("magenta_torch");
    public static final ResourceKey<Item> LIGHT_BLUE_TORCH_KEY = create("light_blue_torch");
    public static final ResourceKey<Item> YELLOW_TORCH_KEY = create("yellow_torch");
    public static final ResourceKey<Item> LIME_TORCH_KEY = create("lime_torch");
    public static final ResourceKey<Item> PINK_TORCH_KEY = create("pink_torch");
    public static final ResourceKey<Item> GRAY_TORCH_KEY = create("gray_torch");
    public static final ResourceKey<Item> LIGHT_GRAY_TORCH_KEY = create("light_gray_torch");
    public static final ResourceKey<Item> CYAN_TORCH_KEY = create("cyan_torch");
    public static final ResourceKey<Item> PURPLE_TORCH_KEY = create("purple_torch");
    public static final ResourceKey<Item> BLUE_TORCH_KEY = create("blue_torch");
    public static final ResourceKey<Item> BROWN_TORCH_KEY = create("brown_torch");
    public static final ResourceKey<Item> GREEN_TORCH_KEY = create("green_torch");
    public static final ResourceKey<Item> RED_TORCH_KEY = create("red_torch");
    public static final ResourceKey<Item> BLACK_TORCH_KEY = create("black_torch");
    public static final ResourceKey<Item> GREEN_ONION_SEEDS_KEY = create("green_onion_seeds");
    public static final ResourceKey<Item> GREEN_ONION_KEY = create("green_onion");
    public static final ResourceKey<Item> BLUEBERRIES_KEY = create("blueberries");
    public static final ResourceKey<Item> SWEET_BERRY_JUICE_KEY = create("sweet_berry_juice");
    public static final ResourceKey<Item> BLUEBERRY_JUICE_KEY = create("blueberry_juice");
    public static final ResourceKey<Item> NOODLES_KEY = create("noodles");
    public static final ResourceKey<Item> NOODLE_SOUP_KEY = create("noodle_soup");
    public static final ResourceKey<Item> PUDDING_KEY = create("pudding");
    public static final ResourceKey<Item> BERRY_PUDDING_KEY = create("berry_pudding");
    public static final ResourceKey<Item> SMOKY_QUARTZ_KEY = create("smoky_quartz");
    public static final ResourceKey<Item> CARAMEL_APPLE_KEY = create("caramel_apple");
    public static final ResourceKey<Item> CARAMEL_KEY = create("caramel");
    public static final ResourceKey<Item> SPRUCE_CONE_KEY = create("spruce_cone");
    public static final ResourceKey<Item> FORESTS_BOUNTY_KEY = create("forests_bounty");
    public static final ResourceKey<Item> WITCHS_CRADLE_BRANCH_KEY = create("witchs_cradle_branch");
    public static final ResourceKey<Item> WITCHS_CRADLE_SOUP_KEY = create("witchs_cradle_soup");
    public static final ResourceKey<Item> FRIED_EGG_KEY = create("fried_egg");
    public static final ResourceKey<Item> BLOOD_KELP_SEED_CLUSTER_KEY = create("blood_kelp_seed_cluster");
    public static final ResourceKey<Item> BLOOD_KELP_KEY = create("blood_kelp");
    public static final ResourceKey<Item> DRIED_BLOOD_KELP_KEY = create("dried_blood_kelp");
    public static final ResourceKey<Item> HOGLIN_STEW_KEY = create("hoglin_stew");
    public static final ResourceKey<Item> CINDERSNAP_BERRIES_KEY = create("cindersnap_berries");
    public static final ResourceKey<Item> FROSTBITE_BERRIES_KEY = create("frostbite_berries");
    public static final ResourceKey<Item> CINDERSNAP_BERRY_JUICE_KEY = create("cindersnap_berry_juice");
    public static final ResourceKey<Item> FROSTBITE_BERRY_JUICE_KEY = create("frostbite_berry_juice");
    public static final ResourceKey<Item> WARPED_FORAGE_MIX_KEY = create("warped_forage_mix");
    public static final ResourceKey<Item> CRIMSON_FORAGE_MIX_KEY = create("crimson_forage_mix");

    private ModItemIds() {}

    private static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, AssortedDiscoveries.makeModId(name));
    }
}
