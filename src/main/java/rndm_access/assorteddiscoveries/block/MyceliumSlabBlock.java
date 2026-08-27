package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;

public class MyceliumSlabBlock extends SnowySlabBlock {
    public static final MapCodec<MyceliumSlabBlock> CODEC = simpleCodec(MyceliumSlabBlock::new);

    public MyceliumSlabBlock(Properties settings) {
        super(settings);
    }

    public MapCodec<MyceliumSlabBlock> codec() {
        return CODEC;
    }

    public void animateTick(final BlockState state, final Level level, final BlockPos pos, final RandomSource random) {
        if (random.nextInt(10) == 0) {
            double particleOffset = state.getValue(TYPE) == SlabType.BOTTOM ? 0.6 : 1.1;

            level.addParticle(ParticleTypes.MYCELIUM,
                    (double)pos.getX() + random.nextDouble(),
                    (double)pos.getY() + particleOffset,
                    (double)pos.getZ() + random.nextDouble(),
                    0.0F, 0.0F, 0.0F);
        }
    }
}
