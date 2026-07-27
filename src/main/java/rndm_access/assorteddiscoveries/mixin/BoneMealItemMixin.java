package rndm_access.assorteddiscoveries.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.core.ModBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import rndm_access.assorteddiscoveries.util.EndBoneMealHelper;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {

    @ModifyReturnValue(method = "useOn", at = @At("RETURN"))
    private InteractionResult useOn(InteractionResult original, UseOnContext context) {
        if (original.consumesAction()) {
            return original;
        }

        BlockPos soilPos = context.getClickedPos();
        Level level = context.getLevel();
        boolean isBoneMealable = level.getBlockState(soilPos).is(ModBlockTags.END_BONE_MEALABLE_BLOCKS);
        BlockPos centerPos = soilPos.above();
        boolean isEmptyAbove = level.getBlockState(centerPos).isAir();

        if (!ModConfig.ENABLE_ENDER_PLANTS.getValue()) {
            return original;
        }

        // Grow snapdragons and ender grass on blocks in the END_BONE_MEALABLE_BLOCKS when using bone meal.
        if (isBoneMealable && !level.isOutsideBuildHeight(centerPos) && isEmptyAbove) {
            return applyBoneMeal(context, level, centerPos);
        }
        return original;
    }

    @Unique
    private static InteractionResult applyBoneMeal(UseOnContext context, Level level, BlockPos centerPos) {
        Player player = context.getPlayer();
        ItemStack boneMealStack = context.getItemInHand();

        if (!level.isClientSide()) {
            if (player != null) {
                boneMealStack.causeUseVibration(player, GameEvent.ITEM_INTERACT_FINISH);
            }

            if (player == null || !player.isCreative()) {
                boneMealStack.shrink(1);
            }
            EndBoneMealHelper.growEnderPlants(level, centerPos);
        }
        EndBoneMealHelper.spawnEndGrowthParticles(level, centerPos);
        level.playSound(player, centerPos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS);
        return InteractionResult.SUCCESS;
    }
}
