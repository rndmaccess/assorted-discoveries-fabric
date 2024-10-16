package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.core.CommonEntityTypeTags;
import rndm_access.assorteddiscoveries.core.ModItems;
import rndm_access.assorteddiscoveries.core.ModParticleTypes;

public class WitchsCradleBlock extends AbstractBerryBushBlock {
    public static final MapCodec<WitchsCradleBlock> CODEC;
    private static final VoxelShape SMALL_SHAPE;
    private static final VoxelShape MEDIUM_SHAPE;
    private static final VoxelShape LARGE_SHAPE;
    private static final VoxelShape GIANT_SHAPE;

    public WitchsCradleBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(AGE, 0));
    }

    @Override
    protected MapCodec<WitchsCradleBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected TagKey<EntityType<?>> mobsImmune() {
        return CommonEntityTypeTags.WITCHS_CRADLE_IMMUNE_ENTITY_TYPES;
    }

    @Override
    protected boolean bushDamages() {
        return true;
    }

    @Override
    protected boolean needsLightToGrow() {
        return true;
    }

    @Override
    protected Item berryItem() {
        return ModItems.WITCHS_CRADLE_BRANCH;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() + random.nextDouble();
        double z = pos.getZ() + random.nextDouble();

        world.addParticle(ModParticleTypes.WITCHS_CRADLE_SPORE, x, y, z, 0.0D,
                0.0D, 0.0D);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos,
                                      ShapeContext context) {
        return switch (state.get(AGE)) {
            case 0 -> SMALL_SHAPE;
            case 1 -> MEDIUM_SHAPE;
            case 2 -> LARGE_SHAPE;
            default -> GIANT_SHAPE;
        };
    }

    static {
        CODEC = createCodec(WitchsCradleBlock::new);
        SMALL_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D,
                9.0D, 13.0D);
        MEDIUM_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D,
                11.0D, 14.0D);
        LARGE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D,
                11.0D, 15.0D);
        GIANT_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D,
                12.0D, 16.0D);
    }
}
