package rndm_access.assorteddiscoveries.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import rndm_access.assorteddiscoveries.util.ADHashPair;

import java.util.Map;

public class ADCandleCakeBlock extends AbstractCandleBlock {
    public static final MapCodec<ADCandleCakeBlock> CODEC;
    public static final BooleanProperty LIT;
    private static final VoxelShape CAKE_SHAPE;
    private static final VoxelShape CANDLE_SHAPE;
    private static final VoxelShape SHAPE;
    private static final Map<ADHashPair<Block, Block>, ADCandleCakeBlock> CANDLES_TO_CANDLE_CAKES;
    private final Block cake;
    private final Block candle;

    public ADCandleCakeBlock(Block cake, Block candle, Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false));
        this.cake = cake;
        this.candle = candle;

        CANDLES_TO_CANDLE_CAKES.put(new ADHashPair<>(cake, candle), this);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(cake);
    }

    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                              Hand hand, BlockHitResult hit) {
        ItemStack handStack = player.getStackInHand(hand);

        if (!handStack.isOf(Items.FLINT_AND_STEEL) && !handStack.isOf(Items.FIRE_CHARGE)) {
            if (isHittingCandle(hit) && player.getStackInHand(hand).isEmpty() && state.get(LIT)) {
                extinguish(player, state, world, pos);
                return ActionResult.success(world.isClient());
            } else {
                ActionResult actionResult = ADCakeBlock.tryEatCake(world, pos, this.cake.getDefaultState(), player);

                if (actionResult.isAccepted()) {
                    dropStacks(state, world, pos);
                }
                return actionResult;
            }
        }
        return ActionResult.PASS;
    }

    private static boolean isHittingCandle(BlockHitResult hitResult) {
        return hitResult.getPos().y - (double)hitResult.getBlockPos().getY() > 0.5D;
    }

    public static BlockState getCandleCake(Block cake, Block candle) {
        return CANDLES_TO_CANDLE_CAKES.get(new ADHashPair<>(cake, candle)).getDefaultState();
    }

    public static boolean containsCandleCake(Block cake, Block candle) {
        return CANDLES_TO_CANDLE_CAKES.containsKey(new ADHashPair<>(cake, candle));
    }

    @Override
    protected MapCodec<? extends AbstractCandleBlock> getCodec() {
        return CODEC;
    }

    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return ImmutableList.of(new Vec3d(0.5D, 1.0D, 0.5D));
    }

    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
    }

    @SuppressWarnings("deprecation")
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos);
    }

    @SuppressWarnings("deprecation")
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return CakeBlock.DEFAULT_COMPARATOR_OUTPUT;
    }

    @SuppressWarnings("deprecation")
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    static {
       CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
               Registries.BLOCK.getCodec().fieldOf("cake").forGetter((block) -> block.cake),
               Registries.BLOCK.getCodec().fieldOf("candle").forGetter((item) -> item.candle),
               createSettingsCodec()).apply(instance, ADCandleCakeBlock::new));
        LIT = AbstractCandleBlock.LIT;
        CAKE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
        CANDLE_SHAPE = Block.createCuboidShape(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
        SHAPE = VoxelShapes.union(CAKE_SHAPE, CANDLE_SHAPE);
        CANDLES_TO_CANDLE_CAKES = Maps.newHashMap();
    }
}
