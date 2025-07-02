package com.squidymine.deos.item;

import com.squidymine.deos.Deos;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.tutorial.TutorialManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings())); // Test Block

    public static final Item DEPTH_BERRIES = registerItem("depth_berries", new Item(new Item.Settings().food(ModFoodComponents.DEPTH_BERRIES)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Deos.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Deos.LOGGER.info("Registering Mod Items for " + Deos.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(DEPTH_BERRIES);
        });
    }
}
