package rndm_access.assorteddiscoveries.block;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.phys.BlockHitResult;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class SoilSlabBlock extends SlabBlock {
    public SoilSlabBlock(Properties properties) {
        super(properties);
    }

    public boolean isSnowCovered(BlockState state, BlockState neighborState) {
        boolean isSnowBlock = neighborState.is(BlockTags.SNOW);
        boolean isNotBottom = state.hasProperty(TYPE) && state.getValue(TYPE) != SlabType.BOTTOM;

        if (FabricLoader.getInstance().isModLoaded("slabbed")) {
            return isSnowBlock;
        }
        return isNotBottom && isSnowBlock;
    }

    protected boolean canGrowGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos neighborPos = pos.above();
        BlockState neighborState = levelReader.getBlockState(neighborPos);

        if (isSnowCovered(state, neighborState)) {
            return true; // Keep grass slabs alive even when covered in snow!
        } else {
            return !isCovered(levelReader, neighborPos, neighborState, state);
        }
    }

    private boolean isCovered(LevelReader levelReader, BlockPos abovePos, BlockState aboveState, BlockState state) {
        boolean isBottom = state.hasProperty(TYPE) && state.getValue(TYPE) == SlabType.BOTTOM;
        boolean isBottomCovered = isBottom && !FabricLoader.getInstance().isModLoaded("slabbed");
        boolean isAboveTopSlab = aboveState.hasProperty(TYPE) && aboveState.getValue(TYPE) == SlabType.TOP;

        if (isBottomCovered || isAboveTopSlab) {
            return false; // Prevent coverage when there is a gap between slabs.
        } else if (aboveState.isFaceSturdy(levelReader, abovePos, Direction.DOWN)) {
            return true; // True if a solid block covers the slab.
        } else {
            // Fallback to light calc for special blocks like leaves and tinted glass.
            int lightDampeningValue = aboveState.getLightDampening();
            int lightDampeningTopFace = LightEngine.getLightDampeningInto(state, aboveState,
                    Direction.DOWN, lightDampeningValue);
            return lightDampeningTopFace >= 15;
        }
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockState aboveState = level.getBlockState(pos.above());
        boolean isDouble = state.hasProperty(TYPE) && state.getValue(TYPE) == SlabType.DOUBLE;
        boolean isSubmergedDouble = isDouble && aboveState.getFluidState().getAmount() == 8;
        boolean cannotConvertSlab = isCovered(level, pos.above(), aboveState, state) || isSubmergedDouble;

        if (!itemStack.is(ItemTags.SHOVELS) || cannotConvertSlab) {
            return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
        }

        level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS);

        if (!level.isClientSide()) {
            // This call will automatically broadcast the breaking animation to the client!
            itemStack.hurtAndBreak(1, player, hand);
            // We don't need to trigger a full world update here, so we just update clients. This improves performance!
            level.setBlock(pos, ModBlocks.DIRT_PATH_SLAB.defaultBlockState()
                    .setValue(SlabBlock.WATERLOGGED, state.getValue(SlabBlock.WATERLOGGED))
                    .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE)), SoilSlabBlock.UPDATE_CLIENTS);
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }
}
