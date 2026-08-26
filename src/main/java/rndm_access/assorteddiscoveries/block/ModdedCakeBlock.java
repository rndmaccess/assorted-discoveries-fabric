package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModdedCakeBlock extends Block {
    public static final IntegerProperty BITES = BlockStateProperties.BITES;
    public static final MapCodec<ModdedCakeBlock> CODEC = simpleCodec(ModdedCakeBlock::new);
    private static final VoxelShape[] SHAPES = Block.boxes(6,
            (bite) -> Block.box(
                    1 + bite * 2,
                    0.0F,
                    1.0F,
                    15.0F,
                    8.0F,
                    15.0F
            ));

    public ModdedCakeBlock(Properties settings) {
        super(settings);
    }

    protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return SHAPES[state.getValue(BITES)];
    }

    public MapCodec<? extends ModdedCakeBlock> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos,
                                         Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(BITES) != 0) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        ItemStack heldStack = player.getItemInHand(hand);
        Item item = heldStack.getItem();
        Block block = Block.byItem(item);

        if (ModdedCandleCakeBlock.containsCandleCake(this, block)) {
            return this.placeCandleCake(world, player, pos, heldStack, block, item);
        }
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    protected InteractionResult useWithoutItem(final BlockState state, final Level level, final BlockPos pos,
                                               final Player player, final BlockHitResult hitResult) {
        if (level.isClientSide()) {
            if (eatCake(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eatCake(level, pos, state, player);
    }

    private InteractionResult placeCandleCake(Level world, Player player, BlockPos pos, ItemStack itemStack,
                                         Block block, Item item) {
        itemStack.consume(1, player);
        world.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS,
                1.0F, 1.0F);
        world.setBlockAndUpdate(pos, ModdedCandleCakeBlock.getCandleCake(this, block));
        world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        player.awardStat(Stats.ITEM_USED.get(item));
        return InteractionResult.SUCCESS;
    }

    public static InteractionResult eatCake(final LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        return eat(level, pos, state, player, 2, 0.1F);
    }

    protected static InteractionResult eat(final LevelAccessor level, BlockPos pos, BlockState state, Player player,
                                           int food, float saturationModifier) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }
        int bites = state.getValue(BITES);

        player.awardStat(Stats.EAT_CAKE_SLICE);
        player.getFoodData().eat(food, saturationModifier);
        level.gameEvent(player, GameEvent.EAT, pos);

        if (bites < 6) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected int getAnalogOutputSignal(final BlockState state, final Level level, final BlockPos pos, final Direction direction) {
        return CakeBlock.getOutputSignal(state.getValue(BITES));
    }

    protected BlockState updateShape(final BlockState state, final LevelReader level, final ScheduledTickAccess ticks,
                                     final BlockPos pos, final Direction directionToNeighbour, final BlockPos neighbourPos,
                                     final BlockState neighbourState, final RandomSource random) {
        return directionToNeighbour == Direction.DOWN && !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : state;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos posBelow = pos.below();
        BlockState stateBelow = level.getBlockState(posBelow);

        return stateBelow.isFaceSturdy(level, posBelow, Direction.DOWN)
                || stateBelow.isFaceSturdy(level, posBelow, Direction.UP);
    }

    @Override
    protected boolean hasAnalogOutputSignal(final BlockState state) {
        return true;
    }

    @Override
    protected boolean isPathfindable(final BlockState state, final PathComputationType type) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }
}
