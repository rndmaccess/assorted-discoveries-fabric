package rndm_access.assorteddiscoveries.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class FoodContainerItem extends ContainerItem {
    public FoodContainerItem(Item.Settings settings) {
        super(settings, Items.BOWL);
    }

    public FoodContainerItem(Item.Settings settings, Item emptyContainer) {
        super(settings, emptyContainer);
    }
}
