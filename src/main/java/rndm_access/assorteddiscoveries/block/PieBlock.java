package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class PieBlock extends Block {
    public static final IntProperty BITES;
    private static final VoxelShape[] SHAPE_BY_BITE;
    private final int nutrition;
    private final float saturationMod;

    public PieBlock(AbstractBlock.Settings settings, int nutrition, float saturationMod) {
        super(settings);
        this.nutrition = nutrition;
        this.saturationMod = saturationMod;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_BITE[state.get(BITES)];
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }
        }
        return tryEat(world, pos, state, player);
    }

    private ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (player.canConsume(false)) {
            int bitesTaken = state.get(BITES);

            player.getHungerManager().add(this.nutrition, this.saturationMod);
            return ModdedCakeBlock.eat(world, pos, state, player, bitesTaken, BITES);
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    static {
        BITES = Properties.BITES;
        SHAPE_BY_BITE = new VoxelShape[] {
                Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
                Block.createCuboidShape(3.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
                Block.createCuboidShape(5.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
                Block.createCuboidShape(7.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
                Block.createCuboidShape(9.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
                Block.createCuboidShape(11.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
                Block.createCuboidShape(13.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D)
        };
    }
}
