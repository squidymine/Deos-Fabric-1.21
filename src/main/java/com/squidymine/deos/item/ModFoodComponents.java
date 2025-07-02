package com.squidymine.deos.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;

public class ModFoodComponents {
    private static final Random random = new Random();

    // Prob have to make custom class for an effect of random length
    public static final FoodComponent DEPTH_BERRIES = new FoodComponent.Builder().snack().nutrition(2).saturationModifier(0.15f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 400), 1.0f).build();
}
