package rndm_access.assorteddiscoveries.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;

public class DrinkContainerItem extends ContainerItem {
    public DrinkContainerItem(Item.Settings settings) {
        super(settings, Items.GLASS_BOTTLE);
    }

    public DrinkContainerItem(Item.Settings settings, Item emptyContainer) {
        super(settings, emptyContainer);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
