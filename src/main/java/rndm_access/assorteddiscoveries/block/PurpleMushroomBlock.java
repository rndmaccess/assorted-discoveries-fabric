package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.core.ModSoundEvents;

public class PurpleMushroomBlock extends MushroomBlock {
    public PurpleMushroomBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        SoundEvent sound = ModSoundEvents.BLOCK_MUSHROOM_BOUNCE;
        Random random = world.getRandom();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if(entity.isSneaking()) {
            world.playSound(x, y, z, sound, SoundCategory.BLOCKS,
                    1.0F, 0.8F + random.nextFloat() / 0.4F, true);
        } else {
            world.playSound(x, y, z, sound, SoundCategory.BLOCKS, 1.0F,
                    0.8F + random.nextFloat() * 0.4F, true);
        }
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        float jumpHeight = 0.2F;

        if(entity.getVelocity().getY() < -jumpHeight && !entity.isSneaking()) {
            Vec3d velocity = entity.getVelocity();
            double minBounce = 2;
            double bounceHeight = (entity.getVelocity().getY() * jumpHeight) + minBounce;
            double bounceYVelocity = Math.sqrt(jumpHeight * (bounceHeight + jumpHeight));

            entity.setVelocity(velocity.getX(), -velocity.getY() + bounceYVelocity,
                    velocity.getZ());
        } else {
            entity.setVelocity(entity.getVelocity().multiply(1.0, 0.0, 1.0));
        }
    }
}
