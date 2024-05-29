package rndm_access.assorteddiscoveries.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;

public class ADDrinkContainerItem extends ADContainerItem {
    public ADDrinkContainerItem(Item.Settings settings) {
        super(settings, Items.GLASS_BOTTLE);
    }

    public ADDrinkContainerItem(Item.Settings settings, Item emptyContainer) {
        super(settings, emptyContainer);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
}
