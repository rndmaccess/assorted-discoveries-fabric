package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.BlockHitResult;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class SoilSlabBlock  extends SlabBlock {
    public SoilSlabBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!itemStack.is(ItemTags.SHOVELS)) {
            return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
        }

        if (!level.isClientSide()) {
            return tryConvertSlabToPath(level, state, pos, player, itemStack, hand);
        }
        return InteractionResult.SUCCESS;
    }

    private InteractionResult tryConvertSlabToPath(Level level, BlockState state, BlockPos pos, Player player, ItemStack stack, InteractionHand hand) {
        BlockState coveringState = level.getBlockState(pos.above());

        if (!state.hasProperty(SlabBlock.TYPE) || !state.hasProperty(SlabBlock.WATERLOGGED)) {
            return InteractionResult.FAIL;
        } else if (state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) {
            this.convertSlabToPath(level, pos, player, stack, state, hand);
            return InteractionResult.CONSUME;
        } else if(!coveringState.isFaceSturdy(level, pos.above(), Direction.DOWN)) {
            this.convertSlabToPath(level, pos, player, stack, state, hand);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME;
    }

    private void convertSlabToPath(Level level, BlockPos pos, Player player, ItemStack stack, BlockState state, InteractionHand hand) {
        if (player != null) {
            level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN.value(), SoundSource.BLOCKS);
            stack.hurtAndBreak(1, player, hand);
            level.setBlockAndUpdate(pos, ModBlocks.DIRT_PATH_SLAB.defaultBlockState()
                    .setValue(SlabBlock.WATERLOGGED, state.getValue(SlabBlock.WATERLOGGED))
                    .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE)));
        }
    }
}
