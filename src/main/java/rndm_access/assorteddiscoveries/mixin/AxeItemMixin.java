package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.properties.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {
    @ModifyReturnValue(method = "useOn", at = @At("RETURN"))
    private InteractionResult assorteddiscoveries$useOnWoodenWall(InteractionResult original, UseOnContext context) {
        // If another mod already handled the behavior then this fixes the edge case.
        if (original.consumesAction()) {
            return original;
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState unstrippedState = level.getBlockState(pos);
        Block unstrippedBlock = unstrippedState.getBlock();
        ItemStack stack = context.getItemInHand();
        Block strippedBlock = assorteddiscoveries$getStrippedVariant(unstrippedBlock);

        if (strippedBlock != null && unstrippedBlock instanceof WallBlock) {
            Player player = context.getPlayer();
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);

            if (player != null) {
                EquipmentSlot handSlot = context.getHand() == InteractionHand.MAIN_HAND
                        ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                stack.hurtAndBreak(1, player, handSlot);
            }
            BlockState strippedState = assorteddiscoveries$getStrippedState(unstrippedState, strippedBlock);
            level.setBlockAndUpdate(pos, strippedState);
            return InteractionResult.SUCCESS;
        }
        return original;
    }

    @Unique
    private static Block assorteddiscoveries$getStrippedVariant(Block input) {
        if (input == ModBlocks.OAK_WALL) return ModBlocks.STRIPPED_OAK_WALL;
        if (input == ModBlocks.SPRUCE_WALL) return ModBlocks.STRIPPED_SPRUCE_WALL;
        if (input == ModBlocks.BIRCH_WALL) return ModBlocks.STRIPPED_BIRCH_WALL;
        if (input == ModBlocks.JUNGLE_WALL) return ModBlocks.STRIPPED_JUNGLE_WALL;
        if (input == ModBlocks.ACACIA_WALL) return ModBlocks.STRIPPED_ACACIA_WALL;
        if (input == ModBlocks.DARK_OAK_WALL) return ModBlocks.STRIPPED_DARK_OAK_WALL;
        if (input == ModBlocks.MANGROVE_WALL) return ModBlocks.STRIPPED_MANGROVE_WALL;
        if (input == ModBlocks.CRIMSON_WALL) return ModBlocks.STRIPPED_CRIMSON_WALL;
        if (input == ModBlocks.WARPED_WALL) return ModBlocks.STRIPPED_WARPED_WALL;
        if (input == ModBlocks.CHERRY_WALL) return ModBlocks.STRIPPED_CHERRY_WALL;
        if (input == ModBlocks.BAMBOO_WALL) return ModBlocks.STRIPPED_BAMBOO_WALL;
        if (input == ModBlocks.PALE_OAK_WALL) return ModBlocks.STRIPPED_PALE_OAK_WALL;
        return null;
    }

    @Unique
    private static BlockState assorteddiscoveries$getStrippedState(BlockState unstripped, Block stripped) {
        BlockState strippedState = stripped.defaultBlockState();

        for (Property<?> prop : unstripped.getProperties()) {
            if (strippedState.hasProperty(prop)) {
                strippedState = assorteddiscoveries$copyProperty(unstripped, strippedState, prop);
            }
        }
        return strippedState;
    }

    @Unique
    private static <T extends Comparable<T>> BlockState assorteddiscoveries$copyProperty(BlockState unstripped, BlockState stripped, Property<T> property) {
        return stripped.setValue(property, unstripped.getValue(property));
    }
}
