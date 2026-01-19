package rndm_access.assorteddiscoveries.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {
    @Shadow
    public static void addGrowthParticles(LevelAccessor world, BlockPos pos, int count) {}

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void useOnBlock(UseOnContext context, CallbackInfoReturnable<InteractionResult> info) {
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        ItemStack boneMealStack = context.getItemInHand();
        Random random = new Random();
        BlockState boneMealedBlock = world.getBlockState(pos);
        boolean isEmptyAbove = world.getBlockState(pos.above()).isAir();

        // Grow snapdragons and ender grass on blocks in the END_BONE_MEALABLE_BLOCKS when using bone meal.
        if (boneMealedBlock.is(ModBlockTags.END_BONE_MEALABLE_BLOCKS) && isEmptyAbove) {
            if (!world.isClientSide()) {
                growEnderPlants(world, pos);
            }
            boneMealStack.shrink(1);
            world.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS);
            addGrowthParticles(world, pos, random.nextInt(10));
            info.setReturnValue(InteractionResult.SUCCESS);
        }
    }

    @Unique
    private static void growEnderPlants(Level world, BlockPos centerPos) {
        Random random = new Random();

        for (int i = 0; i < 128; ++i) {
            // Re-center the position on the block bone mealed.
            BlockPos.MutableBlockPos mutablePos = centerPos.mutable();

            for (int j = 0; j < i / 16; ++j) {
                int xOffset = random.nextInt(3) - 1;
                int yOffset = (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                int zOffset = random.nextInt(3) - 1;
                mutablePos.move(xOffset, yOffset, zOffset);
                BlockPos pos = mutablePos.immutable();

                placeBlocks(world, random, pos);
            }
        }
    }

    @Unique
    private static void placeBlocks(Level world, Random random, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        BlockState soilState = world.getBlockState(pos.below());

        if (soilState.is(ModBlockTags.END_BONE_MEALABLE_BLOCKS) && state.isAir()) {
            // There is a 40% chance to grow a snapdragon and a 60% chance to grow some ender grass.
            if(random.nextFloat() <= 0.4) {
                world.setBlockAndUpdate(pos, ModBlocks.SNAPDRAGON.defaultBlockState());
            } else {
                world.setBlockAndUpdate(pos, ModBlocks.SHORT_ENDER_GRASS.defaultBlockState());
            }
        }
    }
}
