package com.squidymine.deos.util;

import com.squidymine.deos.Deos;
import com.squidymine.deos.component.ModDataComponentTypes;
import com.squidymine.deos.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        /* Chisel Example
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(Deos.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f); */

    }
}
