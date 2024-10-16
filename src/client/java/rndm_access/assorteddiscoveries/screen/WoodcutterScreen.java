package rndm_access.assorteddiscoveries.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import rndm_access.assorteddiscoveries.block_screen.WoodcutterScreenHandler;
import rndm_access.assorteddiscoveries.item.crafting.WoodcuttingRecipe;

import java.util.List;
import java.util.Objects;

public class WoodcutterScreen extends HandledScreen<WoodcutterScreenHandler> {
    private static final Identifier SCROLLER_TEXTURE = new Identifier("container/stonecutter/scroller");
    private static final Identifier SCROLLER_DISABLED_TEXTURE = new Identifier("container/stonecutter/scroller_disabled");
    private static final Identifier RECIPE_SELECTED_TEXTURE = new Identifier("container/stonecutter/recipe_selected");
    private static final Identifier RECIPE_HIGHLIGHTED_TEXTURE = new Identifier("container/stonecutter/recipe_highlighted");
    private static final Identifier RECIPE_TEXTURE = new Identifier("container/stonecutter/recipe");
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/stonecutter.png");
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public WoodcutterScreen(WoodcutterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        handler.setContentsChangedListener(this::onInventoryChange);
        --this.titleY;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;
        int k = (int)(41.0F * this.scrollAmount);
        int l = this.x + 52;
        int m = this.y + 14;
        int n = this.scrollOffset + 12;

        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        Identifier identifier = this.shouldScroll() ? SCROLLER_TEXTURE : SCROLLER_DISABLED_TEXTURE;
        context.drawGuiTexture(identifier, i + 119, j + 15 + k, 12, 15);
        this.renderRecipeBackground(context, mouseX, mouseY, l, m, n);
        this.renderRecipeIcons(context, l, m, n);
    }

    @Override
    protected void drawMouseoverTooltip(DrawContext context, int x, int y) {
        super.drawMouseoverTooltip(context, x, y);
        if (this.canCraft) {
            List<RecipeEntry<WoodcuttingRecipe>> list = this.handler.getAvailableRecipes();
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;

            for (int l = this.scrollOffset; l < k && l < this.handler.getAvailableRecipeCount(); ++l) {
                int i1 = l - this.scrollOffset;
                int j1 = i + i1 % 4 * 16;
                int k1 = j + i1 / 4 * 18 + 2;

                if (x >= j1 && x < j1 + 16 && y >= k1 && y < k1 + 18) {
                    assert this.client != null;
                    assert this.client.world != null;
                    context.drawItemTooltip(this.textRenderer, list.get(l).value()
                            .getResult(this.client.world.getRegistryManager()), x, y);
                }
            }
        }
    }

    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int x, int y, int scrollOffset) {
        for(int i = this.scrollOffset; i < scrollOffset && i < this.handler.getAvailableRecipeCount(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;
            Identifier identifier;
            if (i == this.handler.getSelectedRecipe()) {
                identifier = RECIPE_SELECTED_TEXTURE;
            } else if (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18) {
                identifier = RECIPE_HIGHLIGHTED_TEXTURE;
            } else {
                identifier = RECIPE_TEXTURE;
            }

            context.drawGuiTexture(identifier, k, m - 1, 16, 18);
        }
    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        List<RecipeEntry<WoodcuttingRecipe>> list = this.handler.getAvailableRecipes();

        for(int i = this.scrollOffset; i < scrollOffset && i < this.handler.getAvailableRecipeCount(); ++i) {
            int j = i - this.scrollOffset;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;

            assert this.client != null;
            assert this.client.world != null;
            context.drawItem(list.get(i).value().getResult(this.client.world.getRegistryManager()), k, m);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            MinecraftClient client = Objects.requireNonNull(this.client);
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;

            for(int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = mouseX - (double)(i + m % 4 * 16);
                double e = mouseY - (double)(j + m / 4 * 18);
                if (d >= 0.0D && e >= 0.0D && d < 16.0D && e < 18.0D && this.handler.onButtonClick(client.player, l)) {
                    MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    Objects.requireNonNull(client.interactionManager).clickButton(this.handler.syncId, l);
                    return true;
                }
            }

            i = this.x + 119;
            j = this.y + 9;
            if (mouseX >= (double)i && mouseX < (double)(i + 12) && mouseY >= (double)j && mouseY < (double)(j + 54)) {
                this.mouseClicked = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.y + 14;
            int j = i + 54;

            this.scrollAmount = ((float)mouseY - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0F, 1.0F);
            this.scrollOffset = (int)((double)(this.scrollAmount * (float)this.getMaxScroll()) + 0.5D) * 4;
            return true;
        } else {
            return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (this.shouldScroll()) {
            int i = this.getMaxScroll();
            float f = (float)verticalAmount / (float)i;
            this.scrollAmount = MathHelper.clamp(this.scrollAmount - f, 0.0F, 1.0F);
            this.scrollOffset = (int)((double)(this.scrollAmount * (float)i) + 0.5D) * 4;
        }
        return true;
    }

    private boolean shouldScroll() {
        return this.canCraft && this.handler.getAvailableRecipeCount() > 12;
    }

    protected int getMaxScroll() {
        return (this.handler.getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void onInventoryChange() {
        this.canCraft = this.handler.canCraft();
        if (!this.canCraft) {
            this.scrollAmount = 0.0F;
            this.scrollOffset = 0;
        }
    }
}
