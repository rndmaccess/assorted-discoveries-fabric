package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.core.CommonEntityTypeTags;
import rndm_access.assorteddiscoveries.core.ModItems;
import rndm_access.assorteddiscoveries.core.ModParticleTypes;
import rndm_access.assorteddiscoveries.core.CommonBlockTags;

public class FrostbiteBerryBushBlock extends AbstractBerryBushBlock {
    public static final MapCodec<FrostbiteBerryBushBlock> CODEC;

    public FrostbiteBerryBushBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    protected MapCodec<FrostbiteBerryBushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected TagKey<EntityType<?>> mobsImmune() {
        return CommonEntityTypeTags.FROSTBITE_BERRY_BUSH_IMMUNE_ENTITY_TYPES;
    }

    @Override
    protected boolean bushDamages() {
        return true;
    }

    @Override
    protected boolean needsLightToGrow() {
        return false;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() + random.nextDouble();
        double z = pos.getZ() + random.nextDouble();
        double randNum = random.nextDouble();

        if(randNum < 0.2) {
            world.addParticle(ModParticleTypes.SOUL_EMBER, x, y, z, 0.0D,
                    0.0D, 0.0D);
        }
    }

    @Override
    protected Item berryItem() {
        return ModItems.FROSTBITE_BERRIES;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(CommonBlockTags.FROSTBITE_BERRY_BUSH_PLANTABLE_ON);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    static {
        CODEC = createCodec(FrostbiteBerryBushBlock::new);
    }
}
