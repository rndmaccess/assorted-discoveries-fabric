package rndm_access.assorteddiscoveries.core;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModSoundEvents {
    public static final SoundEvent BLOCK_MUSHROOM_BOUNCE;
    public static final SoundEvent UI_WOODCUTTER_TAKE_RESULT;

    public static void registerSoundEvents() {
        register(BLOCK_MUSHROOM_BOUNCE);
        register(UI_WOODCUTTER_TAKE_RESULT);
        AssortedDiscoveries.LOGGER.info("Registered sound events.");
    }

    private static void register(SoundEvent soundEvent) {
        Registry.register(Registries.SOUND_EVENT, soundEvent.getId(), soundEvent);
    }

    private static SoundEvent makeSoundEvent(String name) {
        return SoundEvent.of(ADReference.makeModId(name));
    }

    static {
        BLOCK_MUSHROOM_BOUNCE = makeSoundEvent("block.mushroom_bounce");
        UI_WOODCUTTER_TAKE_RESULT = makeSoundEvent("ui.woodcutter.take_result");
    }
}
