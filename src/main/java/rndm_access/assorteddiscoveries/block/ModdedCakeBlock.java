package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;

public class ModdedCakeBlock extends CakeBlock {
    public ModdedCakeBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);

        if (state.get(BITES) == 0) {
            Item item = heldStack.getItem();
            Block block = Block.getBlockFromItem(item);

            if (ModdedCandleCakeBlock.containsCandleCake(this, block)) {
                return this.placeCandleCake(world, player, pos, heldStack, block, item);
            }
        }
        return this.eatCake(world, player, pos, heldStack, state);
    }

    private ActionResult placeCandleCake(World world, PlayerEntity player, BlockPos pos, ItemStack itemStack,
                                         Block block, Item item) {
        if (!player.isCreative()) {
            itemStack.decrement(1);
        }

        world.playSound(null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS,
                1.0F, 1.0F);
        world.setBlockState(pos, ModdedCandleCakeBlock.getCandleCake(this, block));
        world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        player.incrementStat(Stats.USED.getOrCreateStat(item));
        return ActionResult.SUCCESS;
    }

    private ActionResult eatCake(World world, PlayerEntity player, BlockPos pos,
                                 ItemStack itemStack, BlockState state) {
        if (world.isClient()) {
            if (tryEatCake(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }
        return tryEatCake(world, pos, state, player);
    }

    public static ActionResult tryEatCake(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        }
        else {
            int bitesTaken = state.get(BITES);

            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(2, 0.1F);
            return eat(world, pos, state, player, bitesTaken, BITES);
        }
    }

    @NotNull
    public static ActionResult eat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player,
                                   int bitesTaken, IntProperty property) {
        world.emitGameEvent(player, GameEvent.EAT, pos);

        if (bitesTaken < 6) {
            world.setBlockState(pos, state.with(property, ++bitesTaken), 3);
        } else {
            world.removeBlock(pos, false);
            world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return ActionResult.SUCCESS;
    }
}
