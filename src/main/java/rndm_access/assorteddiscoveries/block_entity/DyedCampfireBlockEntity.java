package rndm_access.assorteddiscoveries.block_entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.math.BlockPos;
import rndm_access.assorteddiscoveries.core.ModBlockEntityTypes;

public class DyedCampfireBlockEntity extends CampfireBlockEntity {
    public DyedCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntityTypes.DYED_CAMPFIRE;
    }
}
