package rndm_access.assorteddiscoveries.block;

import net.fabricmc.loader.api.FabricLoader;
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
        BlockState coveringState = level.getBlockState(pos.above());
        boolean isCovered = coveringState.isFaceSturdy(level, pos.above(), Direction.DOWN);
        boolean hasProperties = state.hasProperty(SlabBlock.TYPE) && state.hasProperty(SlabBlock.WATERLOGGED);
        boolean isSlabbedInstalled = FabricLoader.getInstance().isModLoaded("slabbed");
        boolean canConvertBottomSlab = state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && !isSlabbedInstalled;

        if (!itemStack.is(ItemTags.SHOVELS) || !hasProperties || (!canConvertBottomSlab && isCovered)) {
            return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
        }

        level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN.value(), SoundSource.BLOCKS);

        if (!level.isClientSide()) {
            // This call will automatically broadcast the breaking animation to the client!
            itemStack.hurtAndBreak(1, player, hand);
            level.setBlockAndUpdate(pos, ModBlocks.DIRT_PATH_SLAB.defaultBlockState()
                    .setValue(SlabBlock.WATERLOGGED, state.getValue(SlabBlock.WATERLOGGED))
                    .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE)));
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }
}
