package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import rndm_access.assorteddiscoveries.core.ADParticleTypes;

public class ADBogBlossomBlock extends Block implements Fertilizable {
    private static final VoxelShape SHAPE;
    public static final MapCodec<ADBogBlossomBlock> CODEC;

    public ADBogBlossomBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADBogBlossomBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        this.playAirNectarParticles(world, random, pos.getX(), pos.getY(), pos.getZ());
    }

    private void playAirNectarParticles(World world, Random random, int x, int y, int z) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int floatingCount = 14;
        int floatingArea = random.nextInt(4) + 10;

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

                world.addParticle(ADParticleTypes.BOG_BLOSSOM_AIR_NECTAR, floatingX, floatingY, floatingZ,
                        0.0D, 0.0D, 0.0D);
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.DOWN) && !world.isWater(pos);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !this.canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState()
                : state;
    }

    @SuppressWarnings("deprecation")
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
        dropStack(world, pos, new ItemStack(this));
    }

    static {
        SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0);
        CODEC = createCodec(ADBogBlossomBlock::new);
    }
}
