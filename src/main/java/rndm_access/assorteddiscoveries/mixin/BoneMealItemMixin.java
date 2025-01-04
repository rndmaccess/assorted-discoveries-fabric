package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import java.util.Random;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {
    @Shadow
    public static void createParticles(WorldAccess world, BlockPos pos, int count) {}

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> info) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack boneMealStack = context.getStack();
        Random random = new Random();
        BlockState boneMealedBlock = world.getBlockState(pos);
        boolean isEmptyAbove = world.getBlockState(pos.up()).isAir();

        // Grow snapdragons and ender grass on blocks in the END_BONE_MEALABLE_BLOCKS when using bone meal.
        if (boneMealedBlock.isIn(ModBlockTags.END_BONE_MEALABLE_BLOCKS) && isEmptyAbove) {
            if (!world.isClient()) {
                growEnderPlants(world, pos);
            }
            boneMealStack.decrement(1);
            world.playSound(null, pos, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS);
            createParticles(world, pos, random.nextInt(10));
            info.setReturnValue(ActionResult.success(world.isClient()));
        }
    }

    @Unique
    private static void growEnderPlants(World world, BlockPos centerPos) {
        Random random = new Random();

        for (int i = 0; i < 128; ++i) {
            // Re-center the position on the block bone mealed.
            BlockPos.Mutable mutablePos = centerPos.mutableCopy();

            for (int j = 0; j < i / 16; ++j) {
                int xOffset = random.nextInt(3) - 1;
                int yOffset = (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                int zOffset = random.nextInt(3) - 1;
                mutablePos.move(xOffset, yOffset, zOffset);
                BlockPos pos = mutablePos.toImmutable();

                placeBlocks(world, random, pos);
            }
        }
    }

    @Unique
    private static void placeBlocks(World world, Random random, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        BlockState soilState = world.getBlockState(pos.down());

        if (soilState.isIn(ModBlockTags.END_BONE_MEALABLE_BLOCKS) && state.isAir()) {
            // There is a 40% chance to grow a snapdragon and a 60% chance to grow some ender grass.
            if(random.nextFloat() <= 0.4) {
                world.setBlockState(pos, ModBlocks.SNAPDRAGON.getDefaultState());
            } else {
                world.setBlockState(pos, ModBlocks.SHORT_ENDER_GRASS.getDefaultState());
            }
        }
    }
}
