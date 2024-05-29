package rndm_access.assorteddiscoveries.common.core;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.registry.Registry;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.common.AssortedDiscoveries;

public class ADPaintingTypes {
    public static final PaintingMotive STARRY_NIGHT = new PaintingMotive(32, 32);

    private static void register(String path, PaintingMotive motive) {
        Registry.register(Registry.PAINTING_MOTIVE, ADReference.makeId(path), motive);
    }

    public static void registerPaintingMotives() {
        register("starry_night", STARRY_NIGHT);

        AssortedDiscoveries.LOGGER.info("Registered painting motives");
    }
}
