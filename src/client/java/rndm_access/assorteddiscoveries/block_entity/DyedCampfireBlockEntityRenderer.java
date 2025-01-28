package rndm_access.assorteddiscoveries.block_entity;

import net.minecraft.block.CampfireBlock;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;

public class DyedCampfireBlockEntityRenderer implements BlockEntityRenderer<DyedCampfireBlockEntity> {
    private static final float SCALE = 0.375F;
    private final ItemRenderer itemRenderer;

    public DyedCampfireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(DyedCampfireBlockEntity blockEntity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Direction direction = blockEntity.getCachedState().get(CampfireBlock.FACING);
        DefaultedList<ItemStack> defaultedList = blockEntity.getItemsBeingCooked();
        int k = (int) blockEntity.getPos().asLong();

        for(int l = 0; l < defaultedList.size(); ++l) {
            ItemStack itemStack = defaultedList.get(l);
            if (itemStack != ItemStack.EMPTY) {
                matrices.push();
                matrices.translate(0.5F, 0.44921875F, 0.5F);
                Direction direction2 = Direction.fromHorizontalQuarterTurns((l + direction.getHorizontalQuarterTurns()) % 4);
                float g = -direction2.getPositiveHorizontalDegrees();
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(g));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                matrices.translate(-0.3125F, -0.3125F, 0.0F);
                matrices.scale(SCALE, SCALE, SCALE);
                this.itemRenderer.renderItem(itemStack, ModelTransformationMode.FIXED,
                        light, overlay, matrices, vertexConsumers, blockEntity.getWorld(), k + l);
                matrices.pop();
            }
        }

    }
}
