package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import rndm_access.assorteddiscoveries.core.CommonEntityTypeTags;
import rndm_access.assorteddiscoveries.core.ModItems;

public class BlueberryBushBlock extends AbstractBerryBushBlock {
    public static final MapCodec<BlueberryBushBlock> CODEC;

    public BlueberryBushBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    protected MapCodec<BlueberryBushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected Item berryItem() {
        return ModItems.BLUEBERRIES;
    }

    @Override
    protected TagKey<EntityType<?>> mobsImmune() {
        return CommonEntityTypeTags.BLUEBERRY_BUSH_IMMUNE_ENTITY_TYPES;
    }

    @Override
    protected boolean bushDamages() {
        return false;
    }

    @Override
    protected boolean needsLightToGrow() {
        return true;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    static {
        CODEC = createCodec(BlueberryBushBlock::new);
    }
}
