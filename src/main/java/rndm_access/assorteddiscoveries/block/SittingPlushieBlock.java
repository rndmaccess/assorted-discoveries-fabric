package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;

public abstract class SittingPlushieBlock extends SimplePlushieBlock {
    protected static final BooleanProperty IS_SITTING = ModBlockStateProperties.IS_SITTING;

    protected SittingPlushieBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                            Player player, BlockHitResult hit) {
        boolean value = state.getValue(IS_SITTING);

        if (!level.isClientSide()) {
            level.setBlock(pos, state.setValue(IS_SITTING, !value), Block.UPDATE_CLIENTS);
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, IS_SITTING);
    }
}
