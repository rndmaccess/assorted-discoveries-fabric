package rndm_access.assorteddiscoveries.block_entity;

import net.minecraft.block.CampfireBlock;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.block.entity.state.CampfireBlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DyedCampfireBlockEntityRenderer implements BlockEntityRenderer<DyedCampfireBlockEntity, CampfireBlockEntityRenderState> {
    private static final float SCALE = 0.375F;
    private final ItemModelManager itemModelManager;

    public DyedCampfireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.itemModelManager = ctx.itemModelManager();
    }

    @Override
    public CampfireBlockEntityRenderState createRenderState() {
        return new CampfireBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(DyedCampfireBlockEntity blockEntity, CampfireBlockEntityRenderState renderState,
                                  float f, Vec3d vec3d,
                                  @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlayCommand) {
        BlockEntityRenderState.updateBlockEntityRenderState(blockEntity, renderState, crumblingOverlayCommand);
        renderState.facing = blockEntity.getCachedState().get(CampfireBlock.FACING);
        int i = (int) blockEntity.getPos().asLong();
        renderState.cookedItemStates = new ArrayList<>();

        for(int j = 0; j < blockEntity.getItemsBeingCooked().size(); ++j) {
            ItemRenderState itemRenderState = new ItemRenderState();
            this.itemModelManager.clearAndUpdate(itemRenderState, blockEntity.getItemsBeingCooked().get(j),
                    ItemDisplayContext.FIXED, blockEntity.getWorld(), null, i + j);
            renderState.cookedItemStates.add(itemRenderState);
        }

    }

    @Override
    public void render(CampfireBlockEntityRenderState renderState, MatrixStack matrixStack,
                       OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        Direction direction = renderState.facing;
        List<ItemRenderState> cookedItemStates = renderState.cookedItemStates;

        for (int i = 0; i < cookedItemStates.size(); ++i) {
            ItemRenderState itemRenderState = cookedItemStates.get(i);
            if (!itemRenderState.isEmpty()) {
                matrixStack.push();
                matrixStack.translate(0.5F, 0.44921875F, 0.5F);
                Direction direction2 = Direction.fromHorizontalQuarterTurns((i + direction.getHorizontalQuarterTurns()) % 4);
                float f = -direction2.getPositiveHorizontalDegrees();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f));
                matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
                matrixStack.translate(-0.3125F, -0.3125F, 0.0F);
                matrixStack.scale(SCALE, SCALE, SCALE);
                itemRenderState.render(matrixStack, orderedRenderCommandQueue, renderState.lightmapCoordinates,
                        OverlayTexture.DEFAULT_UV, 0);
                matrixStack.pop();
            }
        }
    }
}
