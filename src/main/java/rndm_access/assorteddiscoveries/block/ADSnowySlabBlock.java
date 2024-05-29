package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import rndm_access.assorteddiscoveries.core.ADBlocks;
import rndm_access.assorteddiscoveries.core.CBlockTags;

public class ADSnowySlabBlock extends SlabBlock {
    public static final MapCodec<ADSnowySlabBlock> CODEC;
    public static final BooleanProperty SNOWY;

    public ADSnowySlabBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(SNOWY, false)
                .with(WATERLOGGED, false).with(TYPE, SlabType.BOTTOM));
    }

    @Override
    public MapCodec<ADSnowySlabBlock> getCodec() {
        return CODEC;
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.UP ? state.with(SNOWY, isSnow(world, state, neighborPos, neighborState)) : state;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos neighborPos = ctx.getBlockPos().up();
        BlockState neighborState = world.getBlockState(neighborPos);
        BlockState state = super.getPlacementState(ctx);

        return state != null ? state.with(SNOWY, isSnow(world, state, neighborPos, neighborState)) : null;
    }

    private static boolean isSnow(WorldView world, BlockState state, BlockPos neighborPos, BlockState neighborState) {
        return (neighborState.isIn(BlockTags.SNOW) && !isBottom(state)) ||
                (neighborState.isIn(CBlockTags.SNOW_STAIRS) && !isBottom(state) &&
                        isCovered(world, neighborPos, neighborState)) ||
                (neighborState.isIn(CBlockTags.SNOW_SLABS) && !isBottom(state) &&
                        isCovered(world, neighborPos, neighborState));
    }

    public static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos neighborPos = pos.up();
        BlockState neighborState = world.getBlockState(neighborPos);

        if (isSnow(world, state, neighborPos, neighborState)) {
            return true;
        } else if (neighborState.getFluidState().getLevel() == 8 || state.get(WATERLOGGED)) {
            return false;
        } else {
            return !isCovered(world, neighborPos, neighborState) || isBottom(state) || !neighborState.isOpaque();
        }
    }

    private static boolean isCovered(WorldView world, BlockPos neighborPos, BlockState neighborState) {
        return neighborState.isSideSolidFullSquare(world, neighborPos, Direction.DOWN);
    }

    private static boolean isBottom(BlockState state) {
        return state.get(TYPE).equals(SlabType.BOTTOM);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(!canSurvive(state, world, pos)) {
            world.setBlockState(pos, ADBlocks.DIRT_SLAB.getDefaultState().with(TYPE, state.get(TYPE))
                    .with(WATERLOGGED, state.get(WATERLOGGED)));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED, SNOWY);
    }

    static {
        CODEC = createCodec(ADSnowySlabBlock::new);
        SNOWY = Properties.SNOWY;
    }
}
