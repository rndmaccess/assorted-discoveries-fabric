package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.block_entity.DyedCampfireBlockEntity;
import rndm_access.assorteddiscoveries.core.ModBlockEntityTypes;

public class DyedCampfireBlock extends CampfireBlock {
    private final ParticleEffect emberParticle;

    public DyedCampfireBlock(AbstractBlock.Settings settings, ParticleEffect sparkParticle) {
        super(false, 1, settings);
        this.emberParticle = sparkParticle;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            if (random.nextInt(10) == 0) {
                world.playSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                        SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + random.nextFloat(),
                        random.nextFloat() * 0.7F + 0.6F, false);
            }

            // Spawn the spark particle randomly.
            if (random.nextInt(5) == 0) {
                for (int i = 0; i < random.nextInt(1) + 1; ++i) {
                    world.addParticle(emberParticle, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                            random.nextFloat() / 2.0F, 5.0E-5D, random.nextFloat() / 2.0F);
                }
            }
        }
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (world.isClient()) {
            return state.get(LIT)
                    ? validateTicker(type, ModBlockEntityTypes.DYED_CAMPFIRE, DyedCampfireBlockEntity::clientTick) : null;
        } else {
            return state.get(LIT) ? validateTicker(type, ModBlockEntityTypes.DYED_CAMPFIRE,
                    DyedCampfireBlockEntity::litServerTick)
                    : validateTicker(type, ModBlockEntityTypes.DYED_CAMPFIRE,
                    DyedCampfireBlockEntity::unlitServerTick);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DyedCampfireBlockEntity(pos, state);
    }
}
