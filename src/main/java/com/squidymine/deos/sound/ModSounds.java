package com.squidymine.deos.sound;

import com.squidymine.deos.Deos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    // public static final SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");

    /* Block Sound Group Example
    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");
    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL); */

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Deos.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Deos.LOGGER.info("Registering Mod Sounds for " + Deos.MOD_ID);
    }
}
