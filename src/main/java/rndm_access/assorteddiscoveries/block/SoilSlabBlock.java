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
    protected SoilSlabBlock(Properties properties) {
        super(properties);
    }

    public boolean isSnowCovered(BlockState state, BlockState neighborState) {
        boolean isSnowBlock = neighborState.is(BlockTags.SNOW);

        if (FabricLoader.getInstance().isModLoaded("slabbed")) {
            return isSnowBlock;
        }
        return !isBottom(state) && isSnowBlock;
    }

    protected boolean canGrowGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos abovePos = pos.above();
        BlockState aboveState = levelReader.getBlockState(abovePos);
        boolean isWaterlogged = state.hasProperty(WATERLOGGED) && state.getValue(WATERLOGGED);
        boolean isWaterAbove = aboveState.getFluidState().getAmount() == 8;

        if (isSnowCovered(state, aboveState)) {
            return true; // Keep grass slabs alive even when covered in snow!
        } else if (isWaterlogged || isWaterAbove) {
            return false;
        } else {
            return !isCovered(levelReader, abovePos, aboveState, state);
        }
    }

    private boolean isCovered(LevelReader levelReader, BlockPos abovePos, BlockState aboveState, BlockState state) {
        boolean isBottomCovered = !FabricLoader.getInstance().isModLoaded("slabbed") && isBottom(state);

        if (isBottomCovered || isTop(aboveState)) {
            return false; // Prevent coverage when there is a gap between slabs.
        } else if (aboveState.isFaceSturdy(levelReader, abovePos, Direction.DOWN)) {
            return true; // True if a solid block covers the slab.
        } else {
            // Fallback to light calc for special blocks like leaves and tinted glass.
            int lightDampeningValue = aboveState.getLightBlock();
            int lightDampeningTopFace = LightEngine.getLightBlockInto(state, aboveState,
                    Direction.DOWN, lightDampeningValue);
            return lightDampeningTopFace >= 15;
        }
    }

    private boolean isDouble(BlockState state) {
        boolean hasTypeProperty = state.hasProperty(TYPE);

        if (hasTypeProperty) {
            return state.getValue(TYPE) == SlabType.DOUBLE;
        }
        return false;
    }

    private boolean isTop(BlockState state) {
        boolean hasTypeProperty = state.hasProperty(TYPE);

        if (hasTypeProperty) {
            return state.getValue(TYPE) == SlabType.TOP;
        }
        return false;
    }

    protected boolean isBottom(BlockState state) {
        boolean hasTypeProperty = state.hasProperty(TYPE);

        if (hasTypeProperty) {
            return state.getValue(TYPE) == SlabType.BOTTOM;
        }
        return false;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockState aboveState = level.getBlockState(pos.above());
        boolean isSubmergedDouble = aboveState.getFluidState().getAmount() == 8 && isDouble(state);
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
