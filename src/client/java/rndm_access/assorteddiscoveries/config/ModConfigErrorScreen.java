package rndm_access.assorteddiscoveries.config;

import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

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
        MutableText errorText = Text.literal(ModServerConfig.getConfigError());
        errorText.setStyle(Style.EMPTY.withColor(0xff5555));
        final MultilineText multilineError = MultilineText.create(textRenderer, errorText, width - 80);
        Text desc_line_one = Text.translatable("config_error." + AssortedDiscoveries.MOD_ID
                + ".screen.description.line_one");
        Text desc_line_two = Text.translatable("config_error." + AssortedDiscoveries.MOD_ID
                + ".screen.description.line_two");
        Text desc_line_three = Text.translatable("config_error." + AssortedDiscoveries.MOD_ID
                + ".screen.description.line_three");

        context.drawCenteredTextWithShadow(textRenderer, title, width / 2, 20, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, desc_line_one, width / 2,
                height / 2 - 80, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, desc_line_two, width / 2,
                height / 2 - 65, 0xffffff);
        context.drawCenteredTextWithShadow(textRenderer, desc_line_three, width / 2,
                height / 2 - 50, 0xffffff);
        //context.drawTextWithShadow(textRenderer, multilineError, height / 2 - 30, 16, 30);

        //multilineError.draw(Alignment.LEFT, , DrawnTextConsumer);
    }

    @Override
    protected void init() {
        this.closeButton = ButtonWidget
                .builder(Text.translatable("config_error." + AssortedDiscoveries.MOD_ID + ".screen.close_button"),
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
