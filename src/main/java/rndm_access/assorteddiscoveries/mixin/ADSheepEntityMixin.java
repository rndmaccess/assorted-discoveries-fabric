package rndm_access.assorteddiscoveries.mixin;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rndm_access.assorteddiscoveries.ADReference;

@Mixin(SheepEntity.class)
public class ADSheepEntityMixin {
    private static final Identifier MAROON_SHEEP_ENTITY = ADReference.makeModId("entities/sheep/maroon");

    @Inject(method = "getLootTableId", at = @At("HEAD"), cancellable = true)
    private void assorteddiscoveries_getLootTableId(CallbackInfoReturnable<Identifier> cir) {
        //if() {
        //    cir.setReturnValue(MAROON_SHEEP_ENTITY);
        //}
    }
}
