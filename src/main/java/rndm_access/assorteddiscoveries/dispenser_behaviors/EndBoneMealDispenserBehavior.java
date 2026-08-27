package rndm_access.assorteddiscoveries.dispenser_behaviors;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.util.EndBoneMealHelper;

public class EndBoneMealDispenserBehavior implements DispenseItemBehavior {
    private final DispenseItemBehavior vanillaBehavior;

    public EndBoneMealDispenserBehavior(DispenseItemBehavior vanillaBehavior) {
        this.vanillaBehavior = vanillaBehavior;
    }

    @Override
    public @NonNull ItemStack dispense(BlockSource blockSource, @NonNull ItemStack itemStack) {
        ServerLevel level = blockSource.level();
        BlockPos targetPos = blockSource.pos().relative(blockSource.state().getValue(DispenserBlock.FACING));

        if (!ModConfig.ENABLE_ENDER_PLANTS.getValue()) {
            return vanillaBehavior.dispense(blockSource, itemStack);
        }

        if (level.getBlockState(targetPos).is(ModBlockTags.END_BONE_MEALABLE_BLOCKS)) {
            if (!level.isClientSide()) {
                EndBoneMealHelper.growEnderPlants(level, targetPos);
            }
            EndBoneMealHelper.spawnEndGrowthParticles(level, targetPos.above());
            level.levelEvent(2005, targetPos, 0);

            itemStack.shrink(1);
            return itemStack;
        }
        return vanillaBehavior.dispense(blockSource, itemStack);
    }
}