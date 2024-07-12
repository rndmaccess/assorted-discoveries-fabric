package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;

public abstract class AbstractBerryBushBlock extends PlantBlock implements Fertilizable {
    public static IntProperty AGE;
    public static VoxelShape SMALL_SHAPE;
    public static VoxelShape LARGE_SHAPE;

    public AbstractBerryBushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected abstract MapCodec<? extends AbstractBerryBushBlock> getCodec();

    @Override
    protected abstract void appendProperties(StateManager.Builder<Block, BlockState> builder);

    protected abstract Item berryItem();

    protected abstract TagKey<EntityType<?>> mobsImmune();

    protected abstract boolean bushDamages();

    protected abstract boolean needsLightToGrow();

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(this.berryItem());
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(AGE) == 0) {
            return SMALL_SHAPE;
        } else {
            return this.isBushYoung(state) ? LARGE_SHAPE : VoxelShapes.fullCube();
        }
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return this.isBushYoung(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = state.get(AGE);

        if(!this.needsLightToGrow() || random.nextInt(5) == 0 && this.hasLight(world, pos)) {
            BlockState blockState = state.with(AGE, age + 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.getType().isIn(this.mobsImmune())) {
            entity.slowMovement(state, new Vec3d(0.8D, 0.75D, 0.8D));

            if (this.bushDamages() && !world.isClient() && state.get(AGE) > 0
                    && (entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ())) {
                double minMovementForDamage = 0.003D;
                double d = Math.abs(entity.getX() - entity.lastRenderX);
                double e = Math.abs(entity.getZ() - entity.lastRenderZ);

                if (d >= minMovementForDamage || e >= minMovementForDamage) {
                    entity.damage(world.getDamageSources().sweetBerryBush(), 1.0F);
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                              Hand hand, BlockHitResult hit) {
        boolean isHoldingBoneMeal = player.getStackInHand(hand).isOf(Items.BONE_MEAL);
        int age = state.get(AGE);

        if (this.isMaxAge(age) || age > 1 && !isHoldingBoneMeal) {
            ItemStack berryStack = new ItemStack(this.berryItem(), this.getBushBerryAmount(world, age));

            dropStack(world, pos, berryStack);
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS,
                    1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, state.with(AGE, 1), 2);
            return ActionResult.success(world.isClient());
        }
        return ActionResult.PASS;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return this.isBushYoung(state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(this.getMaxAge(), state.get(AGE) + 1);
        world.setBlockState(pos, state.with(AGE, i), 2);
    }

    private boolean isMaxAge(int age) {
        return Objects.equals(age, this.getMaxAge());
    }

    private boolean isBushYoung(BlockState state) {
        return state.get(AGE) < this.getMaxAge();
    }

    private boolean hasLight(World world, BlockPos pos) {
        return world.getBaseLightLevel(pos.up(), 0) >= 9;
    }

    private int getMaxAge() {
        return 3;
    }

    private int getBushBerryAmount(World world, int age) {
        int amount = 1 + world.getRandom().nextInt(2);

        if(this.isMaxAge(age)) {
            ++amount;
        }
        return amount;
    }

    static {
        AGE = Properties.AGE_3;
        SMALL_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
        LARGE_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    }
}
