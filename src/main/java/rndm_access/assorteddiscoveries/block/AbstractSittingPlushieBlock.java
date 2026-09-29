package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;

public abstract class AbstractSittingPlushieBlock extends AbstractSimplePlushieBlock {
    protected static final BooleanProperty IS_SITTING = ModBlockStateProperties.IS_SITTING;

    public AbstractSittingPlushieBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult useWithoutItem(BlockState state, Level level, @NonNull BlockPos pos,
                                                     @NonNull Player player, @NonNull BlockHitResult hit) {
        boolean value = state.getValue(IS_SITTING);

        if (!level.isClientSide()) {
            level.setBlock(pos, state.setValue(IS_SITTING, !value), Block.UPDATE_CLIENTS);
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }

    /**
     * To add additional states please call super.createBlockStateDefinition(builder) in the inheriting class
     * before adding them with builder.add(property).
     */
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, IS_SITTING);
    }
}
