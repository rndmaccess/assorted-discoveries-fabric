package rndm_access.assorteddiscoveries;

import net.minecraft.util.Identifier;

public class ADReference {
    public static final String MOD_ID = "assorted-discoveries";
    public static final String COMMON_ID = "c";

    public static Identifier makeModId(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static Identifier makeCommonId(String path) {
        return new Identifier(COMMON_ID, path);
    }
}
