package rndm_access.assorteddiscoveries.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.core.ModParticleTypes;

public class BogBlossomBlock extends Block implements BonemealableBlock {
    private static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0,
            14.0, 3.0, 14.0);

    public BogBlossomBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        this.playAirNectarParticles(level, random, pos.getX(), pos.getY(), pos.getZ());
    }

    private void playAirNectarParticles(Level level, RandomSource random, int x, int y, int z) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int floatingCount = 10;
        int floatingArea = random.nextInt(4) + 10;
        int risingNum = random.nextInt(2) + 1;

        // Play rising particles
        for (int l = 0; l < risingNum; l++) {
            double risingX = x + random.nextDouble();
            double risingY = y + random.nextDouble();
            double risingZ = z + random.nextDouble();

            level.addParticle(ModParticleTypes.BOG_BLOSSOM_NECTAR, risingX, risingY, risingZ,
                    random.nextDouble(), 2 + random.nextDouble(), random.nextDouble());
        }

        // Play floating particles
        for(int l = 0; l < floatingCount; ++l) {
            int floatingXOrigin = x + Mth.nextInt(random, -floatingArea, floatingArea);
            int floatingYOrigin = y + random.nextInt(floatingArea);
            int floatingZOrigin = z + Mth.nextInt(random, -floatingArea, floatingArea);

            mutable.set(floatingXOrigin, floatingYOrigin, floatingZOrigin);
            BlockState blockState = level.getBlockState(mutable);

            if (!blockState.isCollisionShapeFullBlock(level, mutable)) {
                double floatingX = mutable.getX() + random.nextDouble();
                double floatingY = mutable.getY() + random.nextDouble();
                double floatingZ = mutable.getZ() + random.nextDouble();

                level.addParticle(ModParticleTypes.BOG_BLOSSOM_NECTAR, floatingX, floatingY, floatingZ,
                        0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean canSurvive(@NonNull BlockState state, @NonNull LevelReader levelReader, BlockPos pos) {
        return Block.canSupportCenter(levelReader, pos.below(), Direction.DOWN) && !levelReader.isWaterAt(pos);
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader levelReader, ScheduledTickAccess tickView,
                                  BlockPos pos, Direction direction, BlockPos neighborPos,
                                  BlockState neighborState, RandomSource random) {
        return direction == Direction.DOWN && !this.canSurvive(state, levelReader, pos) ? Blocks.AIR.defaultBlockState()
                : state;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        boolean placed = false;
        int tries = 0;

        do {
            int xOffset = random.nextInt(4) - random.nextInt(4);
            int yOffset = random.nextInt(4) - random.nextInt(4);
            int zOffset = random.nextInt(4) - random.nextInt(4);
            mutablePos.move(xOffset, yOffset, zOffset);
            BlockState worldState = serverLevel.getBlockState(mutablePos);

            if (this.canSurvive(worldState, serverLevel, mutablePos) && (worldState.isAir() || worldState.canBeReplaced())) {
                serverLevel.setBlock(mutablePos, this.defaultBlockState(), Block.UPDATE_CLIENTS);
                placed = true;
            }
            tries++;
            mutablePos.set(pos.getX(), pos.getY(), pos.getZ()); // Return to the center for the next try.
        } while (!placed && tries < 24); // Try to place a block 24 times before giving up!
    }
}
