package rndm_access.assorteddiscoveries.core;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import rndm_access.assorteddiscoveries.ADReference;

public class CEntityTypeTags {
    public static final TagKey<EntityType<?>> BLUEBERRY_BUSH_IMMUNE_ENTITY_TYPES;
    public static final TagKey<EntityType<?>> WITCHS_CRADLE_IMMUNE_ENTITY_TYPES;
    public static final TagKey<EntityType<?>> CINDERSNAP_BERRY_BUSH_IMMUNE_ENTITY_TYPES;
    public static final TagKey<EntityType<?>> FROSTBITE_BERRY_BUSH_IMMUNE_ENTITY_TYPES;

    private static TagKey<EntityType<?>> of(String path) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, ADReference.makeCommonId(path));
    }

    static {
        BLUEBERRY_BUSH_IMMUNE_ENTITY_TYPES = of("blueberry_bush_immune_entity_types");
        WITCHS_CRADLE_IMMUNE_ENTITY_TYPES = of("witchs_cradle_immune_entity_types");
        CINDERSNAP_BERRY_BUSH_IMMUNE_ENTITY_TYPES = of("cindersnap_berry_bush_immune_entity_types");
        FROSTBITE_BERRY_BUSH_IMMUNE_ENTITY_TYPES = of("frostbite_berry_bush_immune_entity_types");
    }
}
