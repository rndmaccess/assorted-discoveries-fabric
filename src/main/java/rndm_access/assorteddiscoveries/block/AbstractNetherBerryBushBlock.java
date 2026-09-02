package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public abstract class AbstractNetherBerryBushBlock extends AbstractBerryBushBlock {
    public AbstractNetherBerryBushBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected abstract MapCodec<? extends AbstractNetherBerryBushBlock> codec();

    @Override
    protected boolean bushDamages() {
        return true;
    }

    @Override
    protected boolean needsLightToGrow() {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(@NonNull Level world, @NonNull RandomSource random, @NonNull BlockPos pos, @NonNull BlockState state) {
        return false;
    }

    @Override
    public boolean isValidBonemealTarget(@NonNull LevelReader world, @NonNull BlockPos pos, @NonNull BlockState state) {
        return false;
    }
}
