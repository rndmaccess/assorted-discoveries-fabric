package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block_screen.ADWoodcutterScreenHandler;

public class ADScreenHandlerTypes {
    public static final ScreenHandlerType<ADWoodcutterScreenHandler> WOODCUTTER =
            new ScreenHandlerType<>(ADWoodcutterScreenHandler::new, FeatureSet.empty());

    private static void registerScreenHandlerType(String path, ScreenHandlerType<?> type) {
        Registry.register(Registries.SCREEN_HANDLER, ADReference.makeModId(path), type);
    }

    public static void registerScreenHandlerTypes() {
        registerScreenHandlerType("woodcutter", WOODCUTTER);

        AssortedDiscoveries.LOGGER.info("Registered screen handler types.");
    }
}
