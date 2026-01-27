package rndm_access.assorteddiscoveries.config;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModConfigErrorScreen extends Screen {
    private static final int DEFAULT_TEXT_COLOR = 0xFFFFFFFF;
    private static final int ERROR_TEXT_COLOR = 0xFF5555;
    private final Screen parent;
    public Button goBackButton;
    public Button continueButton;
    private final Component desc_line_one = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_one");
    private final Component desc_line_two = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_two");
    private final Component desc_line_three = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_three");
    private final Component desc_line_four = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_four");

    protected ModConfigErrorScreen(Component title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void render(@NonNull GuiGraphics gui, int mouseX, int mouseY, float deltaTicks) {
        super.render(gui, mouseX, mouseY, deltaTicks);
        String errorStr = ModServerConfig.getConfigError();
        FormattedText errorText = FormattedText.of(errorStr, Style.EMPTY.withColor(ERROR_TEXT_COLOR));
        int centeredX = this.width / 2;

        gui.drawCenteredString(this.font, this.title, centeredX, 40 - this.font.lineHeight - 10, DEFAULT_TEXT_COLOR);
        gui.drawCenteredString(this.font, desc_line_one, centeredX, 60 - this.font.lineHeight - 10, DEFAULT_TEXT_COLOR);
        gui.drawCenteredString(this.font, desc_line_two, centeredX, 70 - this.font.lineHeight - 10, DEFAULT_TEXT_COLOR);
        gui.drawCenteredString(this.font, desc_line_three, centeredX, 80 - this.font.lineHeight - 10, DEFAULT_TEXT_COLOR);
        gui.drawCenteredString(this.font, desc_line_four, centeredX, 90 - this.font.lineHeight - 10, DEFAULT_TEXT_COLOR);
        gui.drawWordWrap(this.font, errorText, centeredX - 80, 110 - this.font.lineHeight - 10, 200, DEFAULT_TEXT_COLOR);
    }

    @Override
    protected void init() {
        int buttonWidth = 100;
        int buttonHeight = 20;
        int gap = 10;
        int totalWidth = (buttonWidth * 2) + gap;
        int startX = (this.width - totalWidth) / 2;
        int yPos = (this.height / 2) + 30;

        this.goBackButton = Button.builder(Component.translatable("config_error."
                                + AssortedDiscoveries.MOD_ID + ".screen.go_back_button"),
                        button -> this.onClose())
                .bounds(startX, yPos, buttonWidth, buttonHeight).build();
        this.addRenderableWidget(goBackButton);

        this.continueButton = Button.builder(Component.translatable("config_error."
                                + AssortedDiscoveries.MOD_ID + ".screen.continue_button"),
                        button -> this.minecraft.setScreen(ModConfigScreen.getConfigScreenBuilder()
                                .setParentScreen(this.parent).build()))
                .bounds(startX + buttonWidth + gap, yPos, buttonWidth, buttonHeight).build();
        this.addRenderableWidget(continueButton);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }
}
