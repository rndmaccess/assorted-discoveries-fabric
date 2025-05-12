package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModSoundEvents {
    public static final SoundEvent BLOCK_MUSHROOM_BOUNCE;


    public static void register() {
        register(BLOCK_MUSHROOM_BOUNCE);
        AssortedDiscoveries.LOGGER.info("Registered sound events");
    }

    private static void register(SoundEvent soundEvent) {
        Registry.register(Registries.SOUND_EVENT, soundEvent.id(), soundEvent);
    }

    private static SoundEvent makeSoundEvent(String name) {
        return SoundEvent.of(ADReference.makeModId(name));
    }

    static {
        BLOCK_MUSHROOM_BOUNCE = makeSoundEvent("block.mushroom_bounce");
    }
}
