package rndm_access.assorteddiscoveries.config;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModConfigErrorScreen extends Screen {
    private static final int DEFAULT_COLOR = 0xffffff;
    private final Screen parent;
    public Button closeButton;

    protected ModConfigErrorScreen(Component title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void render(@NonNull GuiGraphics context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        MutableComponent errorText = Component.literal(ModServerConfig.getConfigError());
        errorText.setStyle(Style.EMPTY.withColor(0xff5555));
        //final MultilineText multilineError = FittingMultiLineTextWidget.create(textRenderer, errorText, width - 80);
        Component desc_line_one = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
                + ".screen.description.line_one");
        Component desc_line_two = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
                + ".screen.description.line_two");
        Component desc_line_three = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
                + ".screen.description.line_three");

        context.drawCenteredString(this.getFont(), title, width / 2, 20, DEFAULT_COLOR);
        context.drawCenteredString(this.getFont(), desc_line_one, width / 2, height / 2 - 80, DEFAULT_COLOR);
        context.drawCenteredString(this.getFont(), desc_line_two, width / 2, height / 2 - 65, DEFAULT_COLOR);
        context.drawCenteredString(this.getFont(), desc_line_three, width / 2, height / 2 - 50, DEFAULT_COLOR);
        //context.drawTextWithShadow(textRenderer, multilineError, height / 2 - 30, 16, 30);

        //multilineError.draw(Alignment.LEFT, , DrawnTextConsumer);
    }

    @Override
    protected void init() {
        this.closeButton = Button.builder(Component.translatable("config_error."
                                + AssortedDiscoveries.MOD_ID + ".screen.close_button"),
                        button -> this.onClose())
                .bounds(width / 2 - 50, height / 4 + height / 2 + 40, 100, 20).build();
        this.addRenderableWidget(closeButton);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }
}
