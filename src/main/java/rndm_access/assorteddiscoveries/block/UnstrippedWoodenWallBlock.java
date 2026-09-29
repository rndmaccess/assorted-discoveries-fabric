package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

import java.util.HashMap;
import java.util.Map;

public class UnstrippedWoodenWallBlock extends WallBlock {
    private static final Map<Block, Block> STRIPPING_MAP = new HashMap<>();

    public UnstrippedWoodenWallBlock(Properties properties) {
        super(properties);
    }

    /**
     * Register unstripped walls to stripped variants!
     */
    public static void registerStrippableWall(Block unstrippedWall, Block strippedWall) {
        if (unstrippedWall instanceof UnstrippedWoodenWallBlock && strippedWall instanceof WallBlock) {
            STRIPPING_MAP.put(unstrippedWall, strippedWall);
            return;
        }
        AssortedDiscoveries.LOGGER.warn("Failed to map wall stripping: {} -> {}",
                strippedWall, unstrippedWall);
    }

    @Override
    public InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!itemStack.is(ItemTags.AXES)) {
            return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
        }

        Block unstrippedBlock = state.getBlock();
        Block strippedBlock = STRIPPING_MAP.get(unstrippedBlock);

        if (strippedBlock == null) {
            return InteractionResult.CONSUME;
        }

        level.playSound(player, pos, SoundEvents.AXE_STRIP.value(), SoundSource.BLOCKS);
        if (!level.isClientSide()) {
            ItemStack stack = player.getItemInHand(hand);
            EquipmentSlot handSlot = hand == InteractionHand.MAIN_HAND
                    ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            // This call will automatically broadcast the breaking animation to the client!
            stack.hurtAndBreak(1, player, handSlot);

            BlockState strippedState = getStrippedState(state, strippedBlock);
            level.setBlock(pos, strippedState, Block.UPDATE_CLIENTS);
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }

    private static BlockState getStrippedState(BlockState unstripped, Block stripped) {
        BlockState strippedState = stripped.defaultBlockState();

        for (Property<?> prop : unstripped.getProperties()) {
            if (strippedState.hasProperty(prop)) {
                strippedState = copyProperty(unstripped, strippedState, prop);
            }
        }
        return strippedState;
    }

    private static <T extends Comparable<T>> BlockState copyProperty(BlockState unstripped, BlockState stripped, Property<T> property) {
        return stripped.setValue(property, unstripped.getValue(property));
    }
}
