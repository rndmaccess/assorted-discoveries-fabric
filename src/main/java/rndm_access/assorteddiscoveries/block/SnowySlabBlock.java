package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
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
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.core.ModBlockTags;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class SnowySlabBlock extends SlabBlock {
    public static final MapCodec<SnowySlabBlock> CODEC = simpleCodec(SnowySlabBlock::new);
    public static final BooleanProperty SNOWY = BlockStateProperties.SNOWY;

    public SnowySlabBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SNOWY, false)
                .setValue(WATERLOGGED, false).setValue(TYPE, SlabType.BOTTOM));
    }

    @Override
    public MapCodec<? extends SnowySlabBlock> codec() {
        return CODEC;
    }

    @Override
    protected @NonNull BlockState updateShape(@NonNull BlockState state, @NonNull LevelReader world,
                                              @NonNull ScheduledTickAccess tickView, @NonNull BlockPos pos,
                                              @NonNull Direction direction, @NonNull BlockPos neighborPos,
                                              @NonNull BlockState neighborState, @NonNull RandomSource random) {
        if (direction == Direction.UP) {
            boolean isSnowy = isSnowCovered(world, neighborPos, state, neighborState);
            return state.setValue(SNOWY, isSnowy);
        } else {
            return state;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level world = ctx.getLevel();
        BlockPos neighborPos = ctx.getClickedPos().above();
        BlockState neighborState = world.getBlockState(neighborPos);
        BlockState state = super.getStateForPlacement(ctx);

        return state != null ? state.setValue(SNOWY, isSnowCovered(world, neighborPos, state, neighborState)) : null;
    }

    public static boolean canGrowGrass(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos neighborPos = pos.above();
        BlockState neighborState = world.getBlockState(neighborPos);

        if (isSnowCovered(world, neighborPos, state, neighborState)) {
            return true;
        } else if (neighborState.getFluidState().getAmount() == 8 || state.getValue(WATERLOGGED)) {
            return false;
        } else {
            return !isCovered(world, neighborPos, neighborState) || !neighborState.canOcclude();// || isBottom(state);
        }
    }

    public static boolean isSnowCovered(LevelReader world, BlockPos neighborPos, BlockState state, BlockState neighborState) {
        boolean isSnowBlock = neighborState.is(BlockTags.SNOW);
        boolean isSnowyStairs = neighborState.is(ModBlockTags.SNOW_STAIRS)
                && isCovered(world, neighborPos, neighborState);
        boolean isSnowySlab = neighborState.is(ModBlockTags.SNOW_SLABS)
                && isNotBottom(state)
                && neighborState.hasProperty(TYPE)
                && !neighborState.getValue(TYPE).equals(SlabType.TOP)
                && isCovered(world, neighborPos, neighborState);

        if (FabricLoader.getInstance().isModLoaded("slabbed")) {
            return isSnowBlock || isSnowyStairs || isSnowySlab;
        }
        return (isSnowBlock && isNotBottom(state)) || (isSnowyStairs && isNotBottom(state)) || isSnowySlab;
    }

    private static boolean isNotBottom(BlockState state) {
        return state.hasProperty(TYPE) && state.getValue(TYPE) != SlabType.BOTTOM;
    }

    private static boolean isCovered(LevelReader world, BlockPos neighborPos, BlockState neighborState) {
        return neighborState.isFaceSturdy(world, neighborPos, Direction.DOWN);
    }

    @Override
    public void randomTick(@NonNull BlockState state, @NonNull ServerLevel world,
                           @NonNull BlockPos pos, @NonNull RandomSource random) {
        if(!canGrowGrass(state, world, pos)) {
            world.setBlockAndUpdate(pos, ModBlocks.DIRT_SLAB.defaultBlockState().setValue(TYPE, state.getValue(TYPE))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED)));
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
