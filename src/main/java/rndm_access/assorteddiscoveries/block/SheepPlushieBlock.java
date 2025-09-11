package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class SheepPlushieBlock extends AbstractSimplePlushieBlock {
    public static final MapCodec<SheepPlushieBlock> CODEC
            = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(DyeColor.CODEC.fieldOf("color")
                            .forGetter(SheepPlushieBlock::getColor), createSettingsCodec())
                    .apply(instance, SheepPlushieBlock::new));
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 2.0D,
            12.0D, 12.0D, 14.0D);
    private final DyeColor color;

    public SheepPlushieBlock(DyeColor color, AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(WATERLOGGED, false)
                .with(FACING, Direction.NORTH));
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    protected MapCodec<SheepPlushieBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING);
    }
}