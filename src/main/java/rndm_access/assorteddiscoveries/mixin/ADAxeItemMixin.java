package rndm_access.assorteddiscoveries.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUsageContext;
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
import rndm_access.assorteddiscoveries.core.ADBlocks;

import java.util.Map;

@Mixin(AxeItem.class)
public class ADAxeItemMixin {
    @Unique
    private static final Map<Block, Block> STRIPPABLE_WALLS;

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        if(STRIPPABLE_WALLS.containsKey(block) && block instanceof WallBlock) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, STRIPPABLE_WALLS.get(block).getDefaultState()
                    .with(WallBlock.NORTH_SHAPE, state.get(WallBlock.NORTH_SHAPE))
                    .with(WallBlock.SOUTH_SHAPE, state.get(WallBlock.SOUTH_SHAPE))
                    .with(WallBlock.WEST_SHAPE, state.get(WallBlock.WEST_SHAPE))
                    .with(WallBlock.EAST_SHAPE, state.get(WallBlock.EAST_SHAPE))
                    .with(WallBlock.UP, state.get(WallBlock.UP))
                    .with(WallBlock.WATERLOGGED, state.get(WallBlock.WATERLOGGED)));
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }

    static {
        STRIPPABLE_WALLS = new ImmutableMap.Builder<Block, Block>()
                .put(ADBlocks.OAK_WALL, ADBlocks.STRIPPED_OAK_WALL)
                .put(ADBlocks.SPRUCE_WALL, ADBlocks.STRIPPED_SPRUCE_WALL)
                .put(ADBlocks.BIRCH_WALL, ADBlocks.STRIPPED_BIRCH_WALL)
                .put(ADBlocks.JUNGLE_WALL, ADBlocks.STRIPPED_JUNGLE_WALL)
                .put(ADBlocks.ACACIA_WALL, ADBlocks.STRIPPED_ACACIA_WALL)
                .put(ADBlocks.DARK_OAK_WALL, ADBlocks.STRIPPED_DARK_OAK_WALL)
                .put(ADBlocks.MANGROVE_WALL, ADBlocks.STRIPPED_MANGROVE_WALL)
                .put(ADBlocks.CRIMSON_WALL, ADBlocks.STRIPPED_CRIMSON_WALL)
                .put(ADBlocks.WARPED_WALL, ADBlocks.STRIPPED_WARPED_WALL)
                .put(ADBlocks.CHERRY_WALL, ADBlocks.STRIPPED_CHERRY_WALL).build();
    }
}
