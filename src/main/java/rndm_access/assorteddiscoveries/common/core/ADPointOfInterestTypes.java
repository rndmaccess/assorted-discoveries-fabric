package rndm_access.assorteddiscoveries.common.core;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.world.poi.PointOfInterestType;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.common.AssortedDiscoveries;

public class ADPointOfInterestTypes {
    public static final PointOfInterestType LUMBERJACK = PointOfInterestHelper.register(ADReference.makeId("lumberjack"), 1, 1,
            ADBlocks.WOODCUTTER);

    public static void registerPointOfInterestTypes() {
        AssortedDiscoveries.LOGGER.info("Registered point of interest types.");
    }
}