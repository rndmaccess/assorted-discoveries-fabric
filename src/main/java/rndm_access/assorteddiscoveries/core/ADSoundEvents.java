package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;
public class ADSoundEvents {
    public static final SoundEvent BLOCK_MUSHROOM_BOUNCE = registerSoundEvent("block.mushroom_bounce");
    public static final SoundEvent UI_WOODCUTTER_TAKE_RESULT = registerSoundEvent("ui.woodcutter.take_result");

    public static void registerSoundEvents() {
        AssortedDiscoveries.LOGGER.info("Registered sound events.");
    }

    /**
     * @param name The name for the sound event.
     * @return new sound event.
     */
    private static SoundEvent registerSoundEvent(String name) {
        return Registry.register(Registries.SOUND_EVENT, ADReference.makeModId(name), SoundEvent.of(ADReference.makeModId(name)));
    }
}
