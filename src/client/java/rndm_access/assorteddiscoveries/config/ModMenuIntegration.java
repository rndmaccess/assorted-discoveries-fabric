package rndm_access.assorteddiscoveries.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.network.chat.Component;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (ModConfig.getServerConfig().getConfigError() != null) {
            Component config_errors_title = Component.translatable("config_error." + AssortedDiscoveries.MOD_ID + ".screen.title");
            return parent -> new ModConfigErrorScreen(config_errors_title, parent);
        }
        return parent -> ModConfigScreen.getConfigScreenBuilder().setParentScreen(parent).build();
    }
}
