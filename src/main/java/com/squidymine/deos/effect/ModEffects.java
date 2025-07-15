package com.squidymine.deos.effect;

import com.squidymine.deos.Deos;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> PRESSURE = registerStatusEffect("pressure",
            new PressureEffect(StatusEffectCategory.HARMFUL, 0x050621)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Deos.MOD_ID, "pressure"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));




    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Deos.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Deos.LOGGER.info("Registering Mod Effects for " + Deos.MOD_ID);
    }
}
