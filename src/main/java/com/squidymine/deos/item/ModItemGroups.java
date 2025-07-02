package com.squidymine.deos.item;

import com.squidymine.deos.Deos;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DEOS_MOD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Deos.MOD_ID, "deos_mod"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DEPTH_BERRIES))
                    .displayName(Text.translatable("itemgroup.deos.deos_mod_item_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DEPTH_BERRIES);

                    }).build());


    public static void registerItemGroups() {
        Deos.LOGGER.info("Registering Item Groups for " + Deos.MOD_ID);
    }
}
