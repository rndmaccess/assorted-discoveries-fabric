package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
import rndm_access.assorteddiscoveries.block_screen.WoodcutterScreenHandler;

public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<WoodcutterScreenHandler> WOODCUTTER;

    private static void register(String path, ScreenHandlerType<?> type) {
        Registry.register(Registries.SCREEN_HANDLER, ADReference.makeModId(path), type);
    }

    public static void registerScreenHandlerTypes() {
        register("woodcutter", WOODCUTTER);

        AssortedDiscoveries.LOGGER.info("Registered screen handler types.");
    }

    static {
        WOODCUTTER = new ScreenHandlerType<>(WoodcutterScreenHandler::new, FeatureSet.empty());
    }
}
