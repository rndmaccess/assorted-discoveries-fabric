package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.core.ModSoundEvents;

public class PurpleMushroomBlock extends HugeMushroomBlock {
    public PurpleMushroomBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, @NonNull BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        SoundEvent sound = ModSoundEvents.BLOCK_MUSHROOM_BOUNCE;
        RandomSource random = level.getRandom();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if(entity.isShiftKeyDown()) {
            level.playLocalSound(x, y, z, sound, SoundSource.BLOCKS,
                    1.0F, 0.8F + random.nextFloat() / 0.4F, true);
        } else {
            level.playLocalSound(x, y, z, sound, SoundSource.BLOCKS, 1.0F,
                    0.8F + random.nextFloat() * 0.4F, true);
        }
    }
}
