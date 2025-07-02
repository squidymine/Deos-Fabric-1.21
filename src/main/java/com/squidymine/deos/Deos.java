package com.squidymine.deos;

import com.squidymine.deos.block.ModBlocks;
import com.squidymine.deos.item.ModItemGroups;
import com.squidymine.deos.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
	}
}