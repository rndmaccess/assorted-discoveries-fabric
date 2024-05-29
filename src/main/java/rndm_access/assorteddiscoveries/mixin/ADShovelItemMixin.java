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
import rndm_access.assorteddiscoveries.block.ADSnowySlabBlock;
import rndm_access.assorteddiscoveries.core.ADBlocks;

import java.util.HashMap;
import java.util.Map;

@Mixin(ShovelItem.class)
public abstract class ADShovelItemMixin {
    @Unique
    private static final Map<Block, BlockState> PATH_SLAB_STATES;

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if(PATH_SLAB_STATES.containsKey(block) && block instanceof SlabBlock) {
            if(state.contains(ADSnowySlabBlock.SNOWY) && state.get(ADSnowySlabBlock.SNOWY).equals(true)) {
                cir.setReturnValue(ActionResult.FAIL);
                return;
            }

            world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, PATH_SLAB_STATES.get(block)
                    .with(SlabBlock.WATERLOGGED, state.get(SlabBlock.WATERLOGGED))
                    .with(SlabBlock.TYPE, state.get(SlabBlock.TYPE)));
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

    static {
        PATH_SLAB_STATES = new HashMap<>();
        PATH_SLAB_STATES.put(ADBlocks.GRASS_SLAB, ADBlocks.DIRT_PATH_SLAB.getDefaultState());
        PATH_SLAB_STATES.put(ADBlocks.PODZOL_SLAB, ADBlocks.DIRT_PATH_SLAB.getDefaultState());
        PATH_SLAB_STATES.put(ADBlocks.COARSE_DIRT_SLAB, ADBlocks.DIRT_PATH_SLAB.getDefaultState());
        PATH_SLAB_STATES.put(ADBlocks.DIRT_SLAB, ADBlocks.DIRT_PATH_SLAB.getDefaultState());
        PATH_SLAB_STATES.put(ADBlocks.MYCELIUM_SLAB, ADBlocks.DIRT_PATH_SLAB.getDefaultState());
        PATH_SLAB_STATES.put(ADBlocks.ROOTED_DIRT_SLAB, ADBlocks.DIRT_PATH_SLAB.getDefaultState());
    }
}
