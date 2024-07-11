package rndm_access.assorteddiscoveries.core;

import com.google.common.collect.ImmutableSet;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.ADReference;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

public class ADVillagerProfessions {
    public static final VillagerProfession LUMBERJACK;

    private static VillagerProfession register(Identifier id, VillagerProfession profession) {
        return Registry.register(Registries.VILLAGER_PROFESSION, id, profession);
    }

    private static VillagerProfession createVillagerProfession(Identifier id, RegistryKey<PointOfInterestType> workstation,
                                                               @Nullable SoundEvent workSound) {
        return new VillagerProfession(id.toString(), (entry) -> entry.matchesKey(workstation),
                (entry) -> entry.matchesKey(workstation), ImmutableSet.of(), ImmutableSet.of(), workSound);
    }

    public static void registerVillagerProfessions() {
        register(ADReference.makeModId("lumberjack"), LUMBERJACK);

        AssortedDiscoveries.LOGGER.info("Registered villager professions");
    }

    static {
        LUMBERJACK = createVillagerProfession(ADReference.makeModId("lumberjack"),
                ADPointOfInterestTypes.LUMBERJACK, ADSoundEvents.UI_WOODCUTTER_TAKE_RESULT);
    }
}