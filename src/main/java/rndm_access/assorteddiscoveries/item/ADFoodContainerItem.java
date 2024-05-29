package rndm_access.assorteddiscoveries.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ADFoodContainerItem extends ADContainerItem {
    public ADFoodContainerItem(Item.Settings settings) {
        super(settings, Items.BOWL);
    }

    public ADFoodContainerItem(Item.Settings settings, Item emptyContainer) {
        super(settings, emptyContainer);
    }
}
