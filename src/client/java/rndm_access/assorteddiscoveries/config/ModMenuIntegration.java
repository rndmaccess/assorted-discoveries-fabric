package rndm_access.assorteddiscoveries.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import rndm_access.assorteddiscoveries.ADReference;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (ModConfig.getConfigError() != null) {
            Text config_errors_title = Text.translatable("config_error." + ADReference.MOD_ID + ".screen.title");
            return parent -> new ModConfigErrorScreen(config_errors_title, parent);
        }
        return parent -> ModConfigScreen.getConfigScreenBuilder().setParentScreen(parent).build();
    }
}
