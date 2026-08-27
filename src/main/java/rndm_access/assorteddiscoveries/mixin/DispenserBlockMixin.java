package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rndm_access.assorteddiscoveries.config.ModConfig;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.dispenser_behaviors.EndBoneMealDispenserBehavior;

@Mixin(DispenserBlock.class)
public class DispenserBlockMixin {
    @Inject(method = "dispenseFrom", at = @At("HEAD"))
    private void assorteddiscoveries$dispenseFromEndStone(ServerLevel level, BlockState state, BlockPos pos, CallbackInfo ci) {
        DispenserBlockEntity blockEntity = level.getBlockEntity(pos, BlockEntityTypes.DISPENSER).orElse(null);

        if (blockEntity != null && ModConfig.ENABLE_ENDER_PLANTS.getValue()) {
            assorteddiscoveries$dispenseBoneMeal(blockEntity, level, state, pos);
        }
    }

    @Unique
    private void assorteddiscoveries$dispenseBoneMeal(DispenserBlockEntity blockEntity, ServerLevel level,
                                                         BlockState state, BlockPos pos) {
        BlockPos blockPos = pos.relative(state.getValue(DispenserBlock.FACING));
        BlockState blockState = level.getBlockState(blockPos);
        int slot = blockEntity.getRandomSlot(level.getRandom());

        if (slot != -1 && blockState.is(ModBlockTags.END_BONE_MEALABLE_BLOCKS)) {
            ItemStack itemStack = blockEntity.getItem(slot);
            BlockSource source = new BlockSource(level, pos, state, blockEntity);
            EndBoneMealDispenserBehavior behavior = new EndBoneMealDispenserBehavior();
            behavior.dispense(source, itemStack);
        }
    }
}
