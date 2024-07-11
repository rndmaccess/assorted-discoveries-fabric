package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.block.state.BlockStateProperties;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.HashMap;

public class PufferfishPlushieBlock extends AbstractPlushieBlock {
    public static final MapCodec<PufferfishPlushieBlock> CODEC;
    public static final IntProperty PUFFED;
    private static final VoxelShape SMALL_NORTH_SHAPE;
    private static final VoxelShape MEDIUM_NORTH_SHAPE;
    private static final VoxelShape LARGE_NORTH_SHAPE;
    private static final HashMap<Direction, VoxelShape> SMALL_SHAPES;
    private static final HashMap<Direction, VoxelShape> MEDIUM_SHAPES;
    private static final HashMap<Direction, VoxelShape> LARGE_SHAPES;

    public PufferfishPlushieBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH).with(PUFFED, 0));
    }

    @Override
    protected MapCodec<PufferfishPlushieBlock> getCodec() {
        return CODEC;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int puffedLevel = state.get(PUFFED);
        float pitch = 0.8F + world.getRandom().nextFloat() * 0.4F;

        if (puffedLevel < 2) {
            world.playSound(null, pos, SoundEvents.ENTITY_PUFFER_FISH_BLOW_UP, SoundCategory.BLOCKS,
                    1.0F, pitch);
            world.setBlockState(pos, state.with(PUFFED, puffedLevel + 1));
        } else {
            world.playSound(null, pos, SoundEvents.ENTITY_PUFFER_FISH_BLOW_OUT, SoundCategory.BLOCKS,
                    1.0F, pitch);
            world.setBlockState(pos, state.with(PUFFED, 0));
        }
        return ActionResult.success(world.isClient());
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);

        return switch (state.get(PUFFED)) {
            case 0 -> SMALL_SHAPES.get(direction);
            case 1 -> MEDIUM_SHAPES.get(direction);
            default -> LARGE_SHAPES.get(direction);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, PUFFED);
    }

    static {
        CODEC = createCodec(PufferfishPlushieBlock::new);
        PUFFED = BlockStateProperties.PUFFED;
        SMALL_NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 3.0D, 12.0D, 6.0D,
                14.0D);
        MEDIUM_NORTH_SHAPE = Block.createCuboidShape(1.5D, 0.0D, 2.5D, 14.5D, 8.5D,
                11.5D);
        LARGE_NORTH_SHAPE = Block.createCuboidShape(0.5D, 0.0D, 1.5D, 15.5D, 9.5D,
                12.5D);
        SMALL_SHAPES = ShapeHelper.makeShapeRotMap(SMALL_NORTH_SHAPE);
        MEDIUM_SHAPES = ShapeHelper.makeShapeRotMap(MEDIUM_NORTH_SHAPE);
        LARGE_SHAPES = ShapeHelper.makeShapeRotMap(LARGE_NORTH_SHAPE);
    }
}
