package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import rndm_access.assorteddiscoveries.block.state.ModBlockStateProperties;
import rndm_access.assorteddiscoveries.util.ShapeHelper;

import java.util.HashMap;

public class PufferfishPlushieBlock extends AbstractPlushieBlock {
    public static final MapCodec<PufferfishPlushieBlock> CODEC = simpleCodec(PufferfishPlushieBlock::new);
    public static final IntegerProperty PUFFED = ModBlockStateProperties.PUFFED;
    private static final VoxelShape SMALL_NORTH_SHAPE = Block.box(4.0D, 0.0D, 3.0D,
            12.0D, 6.0D, 14.0D);
    private static final VoxelShape MEDIUM_NORTH_SHAPE = Block.box(1.5D, 0.0D, 2.5D,
            14.5D, 8.5D, 11.5D);
    private static final VoxelShape LARGE_NORTH_SHAPE = Block.box(0.5D, 0.0D, 1.5D,
            15.5D, 9.5D, 12.5D);
    private static final HashMap<Direction, VoxelShape> SMALL_SHAPES = ShapeHelper.makeShapeRotMap(SMALL_NORTH_SHAPE);
    private static final HashMap<Direction, VoxelShape> MEDIUM_SHAPES = ShapeHelper.makeShapeRotMap(MEDIUM_NORTH_SHAPE);
    private static final HashMap<Direction, VoxelShape> LARGE_SHAPES = ShapeHelper.makeShapeRotMap(LARGE_NORTH_SHAPE);

    public PufferfishPlushieBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.NORTH).setValue(PUFFED, 0));
    }

    @Override
    protected MapCodec<PufferfishPlushieBlock> codec() {
        return CODEC;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int puffedLevel = state.getValue(PUFFED);
        float pitch = 0.8F + world.getRandom().nextFloat() * 0.4F;

        if (puffedLevel < 2) {
            world.playSound(null, pos, SoundEvents.PUFFER_FISH_BLOW_UP,
                    SoundSource.BLOCKS, 1.0F, pitch);
            world.setBlockAndUpdate(pos, state.setValue(PUFFED, puffedLevel + 1));
        } else {
            world.playSound(null, pos, SoundEvents.PUFFER_FISH_BLOW_OUT,
                    SoundSource.BLOCKS, 1.0F, pitch);
            world.setBlockAndUpdate(pos, state.setValue(PUFFED, 0));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos,
                                      CollisionContext context) {
        Direction direction = state.getValue(FACING);

        return switch (state.getValue(PUFFED)) {
            case 0 -> SMALL_SHAPES.get(direction);
            case 1 -> MEDIUM_SHAPES.get(direction);
            default -> LARGE_SHAPES.get(direction);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, PUFFED);
    }
}
