package com.squidymine.deos.interfaces;

import com.squidymine.deos.effect.ModEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.MathHelper;

public interface ModStatusEffectFogModifiers {
    default PressureFogModifier getPressureFogModifier() {
        return PressureFogModifier.INSTANCE;
    }

    @Environment(EnvType.CLIENT)
    static class PressureFogModifier implements BackgroundRenderer.StatusEffectFogModifier {
        public static final PressureFogModifier INSTANCE = new PressureFogModifier();

        @Override
        public RegistryEntry<StatusEffect> getStatusEffect() {
            return ModEffects.PRESSURE;
        }

        @Override
        public void applyStartEndModifier(BackgroundRenderer.FogData fogData, LivingEntity entity, StatusEffectInstance effect, float viewDistance, float tickDelta) {
            // float f = effect.isInfinite() ? 5.0F : MathHelper.lerp(Math.min(1.0F, (float)effect.getDuration() / 20.0F), viewDistance, 5.0F);
            float entityY = ((float) entity.getY());
            float endDist = entityY <= -64.0F ? 6.0F : MathHelper.lerp(Math.min(1.0F, (entityY+64)/96), 6.0F, 32.0F);

            if (fogData.fogType == BackgroundRenderer.FogType.FOG_SKY) {
                fogData.fogStart = 0.0F;
                fogData.fogEnd = endDist * 0.8F;
            } else { // vvvvvv I don't know what this does or how it's applied (copied from BlindnessFogModifier)
                fogData.fogStart = endDist * 0.25F;
                fogData.fogEnd = endDist;
            }
        }
    }
}
