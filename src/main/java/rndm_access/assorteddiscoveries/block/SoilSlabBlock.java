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

public class SoilSlabBlock  extends SlabBlock {
    public SoilSlabBlock(Properties properties) {
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
        BlockPos neighborPos = pos.above();
        BlockState neighborState = levelReader.getBlockState(neighborPos);

        if (isSnowCovered(state, neighborState)) {
            return true; // Keep grass slabs alive even when covered in snow!
        } else {
            return !isCovered(levelReader, neighborPos, neighborState, state);
        }
    }

    private boolean isCovered(LevelReader levelReader, BlockPos neighborPos, BlockState neighborState, BlockState state) {
        boolean isBottomCovered = !FabricLoader.getInstance().isModLoaded("slabbed") && isBottom(state);
        boolean isWaterlogged = state.hasProperty(WATERLOGGED) && state.getValue(WATERLOGGED);

        if (isWaterlogged) {
            return true;
        } else if (isBottomCovered || isTop(neighborState)) {
            return false; // Prevent coverage when there is a gap between slabs.
        } else if (neighborState.isFaceSturdy(levelReader, neighborPos, Direction.DOWN)) {
            return true; // True if a solid block covers the slab.
        } else {
            // Fallback to light calc for special blocks like leaves and tinted glass.
            int lightDampeningValue = neighborState.getLightDampening();
            int lightDampeningTopFace = LightEngine.getLightDampeningInto(state, neighborState,
                    Direction.DOWN, lightDampeningValue);
            return lightDampeningTopFace >= 15;
        }
    }

    private boolean isTop(BlockState state) {
        boolean hasTypeProperty = state.hasProperty(TYPE);

        if (hasTypeProperty) {
            return state.getValue(TYPE) == SlabType.TOP;
        }
        return false;
    }

    private boolean isBottom(BlockState state) {
        boolean hasTypeProperty = state.hasProperty(TYPE);

        if (hasTypeProperty) {
            return state.getValue(TYPE) == SlabType.BOTTOM;
        }
        return false;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockState coveringState = level.getBlockState(pos.above());
        boolean cannotConvertSlab = isCovered(level, pos.above(), coveringState, state);

        if (!itemStack.is(ItemTags.SHOVELS) || cannotConvertSlab) {
            return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
        }

        level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN.value(), SoundSource.BLOCKS);

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
