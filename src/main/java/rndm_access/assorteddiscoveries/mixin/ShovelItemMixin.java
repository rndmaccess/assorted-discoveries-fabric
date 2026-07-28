package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(ShovelItem.class)
public abstract class ShovelItemMixin {
    @ModifyReturnValue(method = "useOn", at = @At("RETURN"))
    private InteractionResult useOn(InteractionResult original, UseOnContext context) {
        // If a previous mixin already succeeded or canceled, respect it
        if (original.consumesAction()) {
            return original;
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if(state.is(ModBlockTags.SOIL_SLABS)) {
            if (!state.hasProperty(SlabBlock.TYPE) || !state.hasProperty(SlabBlock.WATERLOGGED)) {
                return InteractionResult.FAIL;
            }

            if (state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) {
                this.convertSlabToPath(context);
                return InteractionResult.SUCCESS;
            }

            BlockState coveringState = level.getBlockState(pos.above());
            if(!coveringState.isFaceSturdy(level, pos.above(), Direction.DOWN)) {
                this.convertSlabToPath(context);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.FAIL;
        }
        return original;
    }

    @Unique
    private void convertSlabToPath(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos slabPos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockState state = level.getBlockState(slabPos);

        if (player != null) {
            level.playSound(player, slabPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            stack.hurtAndBreak(1, player, context.getHand());
            level.setBlockAndUpdate(slabPos, ModBlocks.DIRT_PATH_SLAB.defaultBlockState()
                    .setValue(SlabBlock.WATERLOGGED, state.getValue(SlabBlock.WATERLOGGED))
                    .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE)));
        }
    }
}
