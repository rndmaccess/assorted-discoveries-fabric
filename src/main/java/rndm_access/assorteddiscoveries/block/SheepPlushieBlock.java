package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SheepPlushieBlock extends SimplePlushieBlock {
    public static final MapCodec<SheepPlushieBlock> CODEC
            = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(DyeColor.CODEC.fieldOf("color")
                            .forGetter(SheepPlushieBlock::getColor), propertiesCodec())
                    .apply(instance, SheepPlushieBlock::new));
    private static final VoxelShape NORTH_SHAPE = Block.box(4.0D, 0.0D, 2.0D,
            12.0D, 12.0D, 14.0D);
    private final DyeColor color;

    public SheepPlushieBlock(DyeColor color, BlockBehaviour.Properties properties) {
        super(properties, NORTH_SHAPE);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    protected MapCodec<SheepPlushieBlock> codec() {
        return CODEC;
    }
}