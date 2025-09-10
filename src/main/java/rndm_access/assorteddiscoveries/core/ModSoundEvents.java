package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public final class ModSoundEvents {
    public static final SoundEvent BLOCK_MUSHROOM_BOUNCE = register("block.mushroom_bounce");

    private static SoundEvent register(String name) {
        SoundEvent sound = SoundEvent.of(AssortedDiscoveries.makeModId(name));
        return Registry.register(Registries.SOUND_EVENT, sound.id(), sound);
    }

    public static void register() {
        AssortedDiscoveries.LOGGER.info("Registered sound events");
    }
}
