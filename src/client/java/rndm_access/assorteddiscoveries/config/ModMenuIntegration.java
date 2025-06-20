package rndm_access.assorteddiscoveries.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (ModConfig.getConfigError() != null) {
            return parent -> new ModConfigErrorScreen(Text.literal("Assorted Discoveries Config Errors"), parent);
        }
        return parent -> ModConfigScreen.getConfigScreenBuilder().setParentScreen(parent).build();
    }
}
