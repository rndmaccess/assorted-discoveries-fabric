package rndm_access.assorteddiscoveries.config;

import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import rndm_access.assorteddiscoveries.ADReference;

public class ModConfigErrorScreen extends Screen {
    private final Screen parent;
    public ButtonWidget closeButton;

    protected ModConfigErrorScreen(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);

        final MultilineText multilineError = MultilineText.create(textRenderer,
                Text.literal(ModConfig.getConfigError()), width - 80);
        Text desc_line_one = Text.translatable("config_error." + ADReference.MOD_ID
                + ".screen.description.line_one");
        Text desc_line_two = Text.translatable("config_error." + ADReference.MOD_ID
                + ".screen.description.line_two");
        Text desc_line_three = Text.translatable("config_error." + ADReference.MOD_ID
                + ".screen.description.line_three");

        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, 20, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, desc_line_one, width / 2,
                height / 2 - 80, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, desc_line_two, width / 2,
                height / 2 - 65, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, desc_line_three, width / 2,
                height / 2 - 50, 0xffffff);
        multilineError.drawWithShadow(context, 30, height / 2 - 30, 16, 0xff5555);
    }

    @Override
    protected void init() {
        this.closeButton = ButtonWidget
                .builder(Text.translatable("config_error." + ADReference.MOD_ID + ".screen.close_button"),
                        button -> this.close())
                .dimensions(width / 2 - 50, height / 4 + height / 2 + 40, 100, 20).build();
        addDrawableChild(closeButton);
    }

    @Override
    public void close() {
        assert this.client != null;
        this.client.setScreen(this.parent);
    }
}
