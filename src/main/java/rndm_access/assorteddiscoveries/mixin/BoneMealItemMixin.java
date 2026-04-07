package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> info) {
        BlockPos soilPos = context.getClickedPos();
        Level level = context.getLevel();
        boolean isBoneMealable = level.getBlockState(soilPos).is(ModBlockTags.END_BONE_MEALABLE_BLOCKS);
        BlockPos centerPos = soilPos.above();
        boolean isEmptyAbove = level.getBlockState(centerPos).isAir();

        // Grow snapdragons and ender grass on blocks in the END_BONE_MEALABLE_BLOCKS when using bone meal.
        if (isBoneMealable && !level.isOutsideBuildHeight(centerPos) && isEmptyAbove) {
            applyBoneMeal(context, level, centerPos);
            info.setReturnValue(InteractionResult.SUCCESS);
        }
    }

    @Unique
    private static void applyBoneMeal(UseOnContext context, Level level, BlockPos centerPos) {
        Player player = context.getPlayer();
        ItemStack boneMealStack = context.getItemInHand();

        if (!level.isClientSide()) {
            if (player != null) {
                boneMealStack.causeUseVibration(player, GameEvent.ITEM_INTERACT_FINISH);
            }
            growEnderPlants(level, centerPos);
        }
        spawnGrowthParticles(level, centerPos);

        boneMealStack.shrink(1);
        level.playSound(null, centerPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS);
    }

    @Unique
    private static void spawnGrowthParticles(final Level level, final BlockPos pos) {
        int count = level.getRandom().nextInt(10);
        ParticleUtils.spawnParticles(level, pos, count * 3, 3.0D, 1.0D,
                false, ParticleTypes.HAPPY_VILLAGER);
    }

    @Unique
    private static void growEnderPlants(Level level, BlockPos centerPos) {
        RandomSource random = level.getRandom();
        BlockPos.MutableBlockPos mutablePos = centerPos.mutable();

        for (int i = 0; i < 128; ++i) {
            // Re-center the position on the block bone mealed.
            mutablePos.set(centerPos);

            for (int j = 0; j < i / 16; ++j) {
                int xOffset = random.nextInt(3) - 1;
                int yOffset = (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                int zOffset = random.nextInt(3) - 1;
                mutablePos.move(xOffset, yOffset, zOffset);
                boolean shouldPlace = random.nextFloat() <= 0.5F; // This gives the placement a sparse look!
                BlockState state = level.getBlockState(mutablePos);
                BlockState soilState = level.getBlockState(mutablePos.below());

                if (state.isAir() && shouldPlace && soilState.is(ModBlockTags.END_BONE_MEALABLE_BLOCKS)) {
                    placeBlock(level, random, mutablePos);
                }
            }
        }
    }

    @Unique
    private static void placeBlock(Level level, RandomSource random, BlockPos pos) {
        boolean placeSnapdragon = random.nextFloat() <= 0.4F; // 40% chance

        if(placeSnapdragon) {
            level.setBlockAndUpdate(pos, ModBlocks.SNAPDRAGON.defaultBlockState());
        } else {
            level.setBlockAndUpdate(pos, ModBlocks.SHORT_ENDER_GRASS.defaultBlockState());
        }
    }
}
