package rndm_access.assorteddiscoveries.config;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModConfigErrorScreen extends Screen {
    private static final int DEFAULT_TEXT_COLOR = 0xFFFFFFFF;
    private static final Component DESC_LINE_ONE
            = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_one");
    private static final Component DESC_LINE_TWO
            = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_two");
    private static final Component DESC_LINE_THREE
            = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_three");
    private static final Component DESC_LINE_FOUR
            = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID
            + ".screen.description.line_four");
    private final Screen parent;
    public Button goBackButton;
    public Button continueButton;

    protected ModConfigErrorScreen(Component title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void extractBackground(@NonNull GuiGraphicsExtractor gui, int mouseX, int mouseY, float deltaTicks) {
        super.extractBackground(gui, mouseX, mouseY, deltaTicks);
        int centeredX = this.width / 2;
        int baseTextHeight = this.font.lineHeight - 10;

        gui.centeredText(this.font, this.title, centeredX, 10 - baseTextHeight, DEFAULT_TEXT_COLOR);
        gui.centeredText(this.font, DESC_LINE_ONE, centeredX, 50 - baseTextHeight, DEFAULT_TEXT_COLOR);
        gui.centeredText(this.font, DESC_LINE_TWO, centeredX, 60 - baseTextHeight, DEFAULT_TEXT_COLOR);
        gui.centeredText(this.font, DESC_LINE_THREE, centeredX, 70 - baseTextHeight, DEFAULT_TEXT_COLOR);
        gui.centeredText(this.font, DESC_LINE_FOUR, centeredX, 80 - baseTextHeight, DEFAULT_TEXT_COLOR);
    }

    @Override
    protected void init() {
        int buttonWidth = 100;
        int buttonHeight = 20;
        int gap = 10;
        int totalWidth = (buttonWidth * 2) + gap;
        int startX = (this.width - totalWidth) / 2;
        int yPos = (this.height / 2) + 20;

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
