package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.block.SnowySlabBlock;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import java.util.HashSet;

@Mixin(ShovelItem.class)
public abstract class ShovelItemMixin {
    @Unique
    private static final HashSet<Block> DIRT_SLAB_LIST;

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if(DIRT_SLAB_LIST.contains(block) && block instanceof SlabBlock) {
            if(state.contains(SnowySlabBlock.SNOWY) && state.get(SnowySlabBlock.SNOWY).equals(true)) {
                cir.setReturnValue(ActionResult.FAIL);
                return;
            }

            world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, ModBlocks.DIRT_PATH_SLAB.getDefaultState()
                    .with(SlabBlock.WATERLOGGED, state.get(SlabBlock.WATERLOGGED))
                    .with(SlabBlock.TYPE, state.get(SlabBlock.TYPE)));
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

    static {
        DIRT_SLAB_LIST = new HashSet<>();
        DIRT_SLAB_LIST.add(ModBlocks.GRASS_SLAB);
        DIRT_SLAB_LIST.add(ModBlocks.PODZOL_SLAB);
        DIRT_SLAB_LIST.add(ModBlocks.COARSE_DIRT_SLAB);
        DIRT_SLAB_LIST.add(ModBlocks.DIRT_SLAB);
        DIRT_SLAB_LIST.add(ModBlocks.MYCELIUM_SLAB);
        DIRT_SLAB_LIST.add(ModBlocks.ROOTED_DIRT_SLAB);
    }
}
