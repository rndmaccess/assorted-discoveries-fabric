package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import rndm_access.assorteddiscoveries.core.CEntityTypeTags;
import rndm_access.assorteddiscoveries.core.ADItems;

public class ADBlueberryBushBlock extends ADAbstractBerryBushBlock {
    public static final MapCodec<ADBlueberryBushBlock> CODEC;

    public ADBlueberryBushBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    protected MapCodec<ADBlueberryBushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected Item berryItem() {
        return ADItems.BLUEBERRIES;
    }

    @Override
    protected TagKey<EntityType<?>> mobsImmune() {
        return CEntityTypeTags.BLUEBERRY_BUSH_IMMUNE_ENTITY_TYPES;
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
        CODEC = createCodec(ADBlueberryBushBlock::new);
    }
}
