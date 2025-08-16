package com.squidymine.deos.effect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class PressureEffect extends StatusEffect {
    protected PressureEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    // SHOULD? CHANGE TO EVERY TICK SO THAT TOTEMS OR SIMILAR ITEMS DON'T ALLOW YOU TO STAY ON THE LOWERED HEALTH
    @Override
    public void onEntityDamage(LivingEntity entity, int amplifier, DamageSource source, float amount) {
        if (entity.getHealth() <= (amplifier+1) * 2) {
            entity.kill(); // ADD A CUSTOM DAMAGE SOURCE
        }
    }
}
