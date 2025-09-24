package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.world.tick.ScheduledTickView;
import rndm_access.assorteddiscoveries.core.ModParticleTypes;

public class BogBlossomBlock extends Block implements Fertilizable {
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0,
            14.0, 3.0, 14.0);
    public static final MapCodec<BogBlossomBlock> CODEC = createCodec(BogBlossomBlock::new);

    public BogBlossomBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<BogBlossomBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        this.playAirNectarParticles(world, random, pos.getX(), pos.getY(), pos.getZ());
    }

    private void playAirNectarParticles(World world, Random random, int x, int y, int z) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int floatingCount = 10;
        int floatingArea = random.nextInt(4) + 10;
        int risingNum = random.nextInt(2) + 1;

        // Play rising particles
        for (int l = 0; l < risingNum; l++) {
            double risingX = x + random.nextDouble();
            double risingY = y + random.nextDouble();
            double risingZ = z + random.nextDouble();

            world.addParticleClient(ModParticleTypes.BOG_BLOSSOM_NECTAR, risingX, risingY, risingZ,
                    random.nextDouble(), 2 + random.nextDouble(), random.nextDouble());
        }

        // Play floating particles
        for(int l = 0; l < floatingCount; ++l) {
            int floatingXOrigin = x + MathHelper.nextInt(random, -floatingArea, floatingArea);
            int floatingYOrigin = y + random.nextInt(floatingArea);
            int floatingZOrigin = z + MathHelper.nextInt(random, -floatingArea, floatingArea);

            mutable.set(floatingXOrigin, floatingYOrigin, floatingZOrigin);
            BlockState blockState = world.getBlockState(mutable);

            if (!blockState.isFullCube(world, mutable)) {
                double floatingX = mutable.getX() + random.nextDouble();
                double floatingY = mutable.getY() + random.nextDouble();
                double floatingZ = mutable.getZ() + random.nextDouble();

                world.addParticleClient(ModParticleTypes.BOG_BLOSSOM_NECTAR, floatingX, floatingY, floatingZ,
                        0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.DOWN) && !world.isWater(pos);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView,
                                                BlockPos pos, Direction direction, BlockPos neighborPos,
                                                BlockState neighborState, Random random) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState()
                : state;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos.Mutable mutablePos = pos.mutableCopy();
        boolean placed = false;
        int tries = 0;

        do {
            int xOffset = random.nextInt(4) - random.nextInt(4);
            int yOffset = random.nextInt(4) - random.nextInt(4);
            int zOffset = random.nextInt(4) - random.nextInt(4);
            mutablePos.move(xOffset, yOffset, zOffset);
            BlockPos placePos = mutablePos.toImmutable();
            BlockState worldState = world.getBlockState(placePos);

            if (this.canPlaceAt(null, world, placePos) && (worldState.isAir() || worldState.isReplaceable())) {
                world.setBlockState(placePos, this.getDefaultState());
                placed = true;
            }
            tries++;
            mutablePos = pos.mutableCopy();
        } while (!placed && tries < 24); // Try to place a block 24 times before giving up!
    }
}
