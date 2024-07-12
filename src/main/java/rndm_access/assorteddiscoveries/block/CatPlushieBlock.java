package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;

public class CatPlushieBlock extends AbstractSimplePlushieBlock {
    public static final BooleanProperty IS_SITTING;
    public static final MapCodec<CatPlushieBlock> CODEC;

    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.5D, 0.0D, 1.0D, 11.5D,
            9.5D, 14.5D);

    public CatPlushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH).with(IS_SITTING, false));
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        boolean value = state.get(IS_SITTING);

        world.setBlockState(pos, state.with(IS_SITTING, !value));
        return ActionResult.success(true);
    }

    @Override
    protected MapCodec<CatPlushieBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, IS_SITTING);
    }

    static {
        IS_SITTING = ModBlockStateProperties.IS_SITTING;
        CODEC = createCodec(CatPlushieBlock::new);
    }
}
