package com.squidymine.deos;

import com.squidymine.deos.block.ModBlocks;
import com.squidymine.deos.component.ModDataComponentTypes;
import com.squidymine.deos.effect.ModEffects;
import com.squidymine.deos.event.BiomeEffectTickEvent;
import com.squidymine.deos.item.ModItemGroups;
import com.squidymine.deos.item.ModItems;
import com.squidymine.deos.sound.ModSounds;
import com.squidymine.deos.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.client.render.BackgroundRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deos implements ModInitializer {
	public static final String MOD_ID = "deos";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading: " + MOD_ID);
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModWorldGeneration.generateModWorldGen();


		CompostingChanceRegistry.INSTANCE.add(ModItems.DEPTH_BERRIES, 0.25f);

		ServerTickEvents.END_SERVER_TICK.register(new BiomeEffectTickEvent());

	}
}