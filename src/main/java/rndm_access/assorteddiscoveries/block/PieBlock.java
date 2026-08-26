package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PieBlock extends ModdedCakeBlock {
    public static final MapCodec<PieBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            propertiesCodec(),
            Codec.INT.fieldOf("nutrition").forGetter((block) -> block.nutrition),
            Codec.FLOAT.fieldOf("saturationMod").forGetter((block) -> block.saturationMod))
            .apply(instance, PieBlock::new));
    private static final VoxelShape[] SHAPE_BY_BITE = new VoxelShape[] {
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(3.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(5.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(7.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(9.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(11.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D),
            Block.box(13.0D, 0.0D, 1.0D, 15.0D, 6.0D, 15.0D)
    };
    private final int nutrition;
    private final float saturationMod;

    public PieBlock(BlockBehaviour.Properties settings, int nutrition, float saturationMod) {
        super(settings);
        this.nutrition = nutrition;
        this.saturationMod = saturationMod;
    }

    @Override
    public MapCodec<PieBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_BITE[state.getValue(BITES)];
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hit) {
        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide() && this.eatPie(world, pos, state, player).consumesAction()) {
            return InteractionResult.SUCCESS;
        }
        return this.eatPie(world, pos, state, player);
    }

    private InteractionResult eatPie(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
        if (player.canEat(false)) {
            return eat(world, pos, state, player, this.nutrition, this.saturationMod);
        }
        return InteractionResult.PASS;
    }
}
