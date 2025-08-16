package com.squidymine.deos.mixin;

import com.squidymine.deos.interfaces.ModStatusEffectFogModifiers;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BackgroundRenderer.class)
public abstract class StatusEffectFogModifierMixin implements ModStatusEffectFogModifiers {
    // public abstract class StatusEffectFogModifierMixin implements ModStatusEffectFogModifiers
    @Shadow @Final private static List<BackgroundRenderer.StatusEffectFogModifier> FOG_MODIFIERS;

    @Accessor("FOG_MODIFIERS")
    public static List<BackgroundRenderer.StatusEffectFogModifier> getFogModifiers() {
        throw new AssertionError();
    }

    @Inject(method = "getFogModifier", at = @At("RETURN"), cancellable = true)
    private static void onGetFogModifier(Entity entity, float tickDelta, CallbackInfoReturnable<BackgroundRenderer.StatusEffectFogModifier> cir) {
        if (entity instanceof LivingEntity livingEntity) {
            List<BackgroundRenderer.StatusEffectFogModifier> allFogModifiers = new java.util.ArrayList<>(FOG_MODIFIERS.stream().toList());
            allFogModifiers.add(PressureFogModifier.INSTANCE);
            cir.setReturnValue(((BackgroundRenderer.StatusEffectFogModifier) allFogModifiers.stream()
                    .filter((modifier) -> modifier.shouldApply(livingEntity, tickDelta))
                    .findFirst().orElse((BackgroundRenderer.StatusEffectFogModifier) null))); // Should be ((Object) null) instead
        }
    }


}
