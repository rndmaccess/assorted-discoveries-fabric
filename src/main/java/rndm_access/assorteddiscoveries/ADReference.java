package rndm_access.assorteddiscoveries;

import net.minecraft.util.Identifier;

public class ADReference {
    public static final String MOD_ID = "assorted-discoveries";

    public static Identifier makeModId(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
