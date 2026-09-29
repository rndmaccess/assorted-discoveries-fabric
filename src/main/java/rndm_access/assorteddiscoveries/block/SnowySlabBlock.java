package rndm_access.assorteddiscoveries.block;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class SnowySlabBlock extends SoilSlabBlock {
    public static final BooleanProperty SNOWY = BlockStateProperties.SNOWY;

    public SnowySlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SNOWY, false)
                .setValue(WATERLOGGED, false).setValue(TYPE, SlabType.BOTTOM));
    }

    @Override
    protected @NonNull BlockState updateShape(@NonNull BlockState state, @NonNull LevelReader levelReader,
                                              @NonNull ScheduledTickAccess tickView, @NonNull BlockPos pos,
                                              @NonNull Direction direction, @NonNull BlockPos neighborPos,
                                              @NonNull BlockState neighborState, @NonNull RandomSource random) {
        if (direction == Direction.UP) {
            boolean isSnowy = isSnowCovered(levelReader, neighborPos, state, neighborState);
            return state.setValue(SNOWY, isSnowy);
        } else {
            return state;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level level = ctx.getLevel();
        BlockPos neighborPos = ctx.getClickedPos().above();
        BlockState neighborState = level.getBlockState(neighborPos);
        BlockState state = super.getStateForPlacement(ctx);

        return state != null ? state.setValue(SNOWY, isSnowCovered(level, neighborPos, state, neighborState)) : null;
    }

    public static boolean canGrowGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos neighborPos = pos.above();
        BlockState neighborState = levelReader.getBlockState(neighborPos);

        if (isSnowCovered(levelReader, neighborPos, state, neighborState)) {
            return true;
        } else if (neighborState.getFluidState().getAmount() == 8 || state.getValue(WATERLOGGED)) {
            return false;
        } else {
            return !isCovered(levelReader, neighborPos, neighborState) || !neighborState.canOcclude();// || isBottom(state);
        }
    }

    public static boolean isSnowCovered(LevelReader levelReader, BlockPos neighborPos, BlockState state, BlockState neighborState) {
        boolean isSnowBlock = neighborState.is(BlockTags.SNOW);
        boolean isSnowyStairs = neighborState.is(ModBlockTags.SNOW_STAIRS)
                && isCovered(levelReader, neighborPos, neighborState);
        boolean isSnowySlab = neighborState.is(ModBlockTags.SNOW_SLABS)
                && isNotBottom(state)
                && neighborState.hasProperty(TYPE)
                && !neighborState.getValue(TYPE).equals(SlabType.TOP)
                && isCovered(levelReader, neighborPos, neighborState);

        if (FabricLoader.getInstance().isModLoaded("slabbed")) {
            return isSnowBlock || isSnowyStairs || isSnowySlab;
        }
        return (isSnowBlock && isNotBottom(state)) || (isSnowyStairs && isNotBottom(state)) || isSnowySlab;
    }

    private static boolean isNotBottom(BlockState state) {
        return state.hasProperty(TYPE) && state.getValue(TYPE) != SlabType.BOTTOM;
    }

    private static boolean isCovered(LevelReader levelReader, BlockPos neighborPos, BlockState neighborState) {
        return neighborState.isFaceSturdy(levelReader, neighborPos, Direction.DOWN);
    }

    @Override
    public void randomTick(@NonNull BlockState state, @NonNull ServerLevel serverLevel,
                           @NonNull BlockPos pos, @NonNull RandomSource random) {
        if(!canGrowGrass(state, serverLevel, pos)) {
            serverLevel.setBlock(pos, ModBlocks.DIRT_SLAB.defaultBlockState().setValue(TYPE, state.getValue(TYPE))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED)), Block.UPDATE_CLIENTS);
        }
    }

    public static boolean canSupportGrass(BlockState state) {
        if (FabricLoader.getInstance().isModLoaded("slabbed")) {
            return true;
        }
        return state.hasProperty(TYPE) && state.getValue(TYPE) != SlabType.BOTTOM;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, WATERLOGGED, SNOWY);
    }
}
