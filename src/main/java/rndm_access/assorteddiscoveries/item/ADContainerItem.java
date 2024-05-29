package rndm_access.assorteddiscoveries.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ADContainerItem extends Item {
    private final Item emptyContainer;

    public ADContainerItem(Item.Settings settings, Item emptyContainer) {
        super(settings);
        this.emptyContainer = emptyContainer;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.eatFood(world, stack);

        if (user instanceof PlayerEntity player && !player.isCreative()) {
            ItemStack emptyContainerStack = new ItemStack(this.emptyContainer);

            if(stack.isEmpty()) {
                return emptyContainerStack;
            } else {
                player.giveItemStack(emptyContainerStack);
            }
        }
        return stack;
    }
}
