package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        ItemStack boneMealStack = context.getItemInHand();
        BlockState boneMealedBlock = level.getBlockState(pos);
        boolean isEmptyAbove = level.getBlockState(pos.above()).isAir();

        // Grow snapdragons and ender grass on blocks in the END_BONE_MEALABLE_BLOCKS when using bone meal.
        if (boneMealedBlock.is(ModBlockTags.END_BONE_MEALABLE_BLOCKS) && isEmptyAbove) {
            if (!level.isClientSide()) {
                assert context.getPlayer() != null;
                boneMealStack.causeUseVibration(context.getPlayer(), GameEvent.ITEM_INTERACT_FINISH);
                List<BlockPos> poses = growEnderPlants(level, pos);

                if (level instanceof ServerLevel serverLevel) {
                    for (BlockPos blockPos : poses) {
                        spawnGrowthParticles(serverLevel, blockPos);
                    }
                }
            }

            boneMealStack.shrink(1);
            level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS);
            info.setReturnValue(InteractionResult.SUCCESS);
        }
    }

    @Unique
    private static void spawnGrowthParticles(final ServerLevel serverLevel, final BlockPos pos) {
        final double spreadWidth = 3.0F;
        final double spreadHeight = 1.0F;
        final ParticleOptions particle = ParticleTypes.HAPPY_VILLAGER;
        RandomSource random = serverLevel.getRandom();

        double xVelocity = random.nextGaussian() * 0.02;
        double yVelocity = random.nextGaussian() * 0.02;
        double zVelocity = random.nextGaussian() * 0.02;
        double spreadStartOffset = (double)0.5F - spreadWidth;
        double x = (double)pos.getX() + spreadStartOffset + random.nextDouble() * spreadWidth * (double)2.0F;
        double y = (double)pos.getY() + random.nextDouble() * spreadHeight;
        double z = (double)pos.getZ() + spreadStartOffset + random.nextDouble() * spreadWidth * (double)2.0F;

        if (!serverLevel.getBlockState(BlockPos.containing(x, y, z).below()).isAir()) {
            serverLevel.sendParticles(particle, x + 0.5, y + 0.5, z + 0.5, 1, xVelocity, yVelocity, zVelocity, 0.05);
        }
    }

    @Unique
    private static List<BlockPos> growEnderPlants(Level world, BlockPos centerPos) {
        Random random = new Random();
        List<BlockPos> poses = new ArrayList<>();

        for (int i = 0; i < 128; ++i) {
            // Re-center the position on the block bone mealed.
            BlockPos.MutableBlockPos mutablePos = centerPos.mutable();

            for (int j = 0; j < i / 16; ++j) {
                int xOffset = random.nextInt(3) - 1;
                int yOffset = (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                int zOffset = random.nextInt(3) - 1;
                mutablePos.move(xOffset, yOffset, zOffset);
                BlockPos pos = mutablePos.immutable();

                boolean canPlace = placeBlocks(world, random, pos);
                if (canPlace) {
                    poses.add(pos);
                }
            }
        }
        return poses;
    }

    @Unique
    private static boolean placeBlocks(Level level, Random random, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        BlockState soilState = level.getBlockState(pos.below());
        boolean canPlace = soilState.is(ModBlockTags.END_BONE_MEALABLE_BLOCKS) && state.isAir();

        if (canPlace) {
            // There is a 40% chance to grow a snapdragon and a 60% chance to grow some ender grass.
            if(random.nextFloat() <= 0.4) {
                level.setBlockAndUpdate(pos, ModBlocks.SNAPDRAGON.defaultBlockState());
            } else {
                level.setBlockAndUpdate(pos, ModBlocks.SHORT_ENDER_GRASS.defaultBlockState());
            }
        }
        return canPlace;
    }
}
