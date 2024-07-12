package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.core.ModBlocks;

public class BloodKelpBlock extends AbstractPlantStemBlock implements FluidFillable, BloodKelp {
    public static final MapCodec<BloodKelpBlock> CODEC;
    private static final VoxelShape SHAPE;

    public BloodKelpBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.UP, SHAPE, true, 0.14);
        this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.BLOOD_KELP_PLANT;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos)
                .with(LIT, state.get(LIT));
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isOf(Blocks.WATER);
    }

    @Override
    protected MapCodec<BloodKelpBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos newStemPos = pos.offset(this.growthDirection);
        int age = state.get(AGE);

        if (age < 25 && this.chooseStemState(world.getBlockState(newStemPos))) {
            world.setBlockState(pos, this.growStemToPlant(state), 2);
            world.setBlockState(newStemPos, this.getStemState(random, age).cycle(AGE));
        }
    }

    @Override
    protected boolean canAttachTo(BlockState state) {
        return !state.isOf(Blocks.MAGMA_BLOCK);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos newStemPos = pos.mutableCopy().offset(this.growthDirection);
        int age = Math.min(state.get(AGE) + 1, 25);

        if(this.chooseStemState(world.getBlockState(newStemPos))) {
            world.setBlockState(pos, this.growStemToPlant(state), 2);
            world.setBlockState(newStemPos, this.getStemState(random, age));
        }
    }

    public BlockState getStemState(Random random, int age) {
        return this.getDefaultState().with(LIT, BloodKelp.isLit(random)).with(AGE, age);
    }

    private BlockState growStemToPlant(BlockState stemState) {
        boolean isLit = stemState.get(LIT);

        return this.getPlant().getDefaultState().with(BloodKelpPlantBlock.LIT, isLit);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        BloodKelp.playParticles(world, state, pos, random);
    }

    @Override
    protected int getGrowthLength(Random random) {
        return 1;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        return BloodKelp.pickSeedCluster(world, player, state, pos);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !state.get(LIT) && super.isFertilizable(world, pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, AGE);
    }

    @Override
    public boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos,
                                    BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return fluidState.isIn(FluidTags.WATER) && fluidState.getLevel() == 8 ? super.getPlacementState(ctx) : null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStill(false);
    }

    static {
        CODEC = createCodec(BloodKelpBlock::new);
        SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 9.0, 16.0);
    }
}
