package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.ImmutableSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ModVillagerProfessions {
    public static final VillagerProfession LUMBERJACK;

    private static VillagerProfession register(String id, VillagerProfession profession) {
        return Registry.register(Registries.VILLAGER_PROFESSION, ADReference.makeModId(id), profession);
    }

    private static VillagerProfession createVillagerProfession(String id, RegistryKey<PointOfInterestType> workstation,
                                                               @Nullable SoundEvent workSound) {
        return new VillagerProfession(ADReference.makeModId(id).toString(), (entry) -> entry.matchesKey(workstation),
                (entry) -> entry.matchesKey(workstation), ImmutableSet.of(), ImmutableSet.of(), workSound);
    }

    public static void registerVillagerProfessions() {
        register("lumberjack", LUMBERJACK);

        AssortedDiscoveries.LOGGER.info("Registered villager professions");
    }

    static {
        LUMBERJACK = createVillagerProfession("lumberjack",
                ModPointOfInterestTypes.LUMBERJACK, ModSoundEvents.UI_WOODCUTTER_TAKE_RESULT);
    }
}