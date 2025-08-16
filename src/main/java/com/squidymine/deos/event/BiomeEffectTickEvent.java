package com.squidymine.deos.event;

import com.squidymine.deos.Deos;
import com.squidymine.deos.effect.ModEffects;
import com.squidymine.deos.world.biome.ModBiomes;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

import java.util.ArrayList;
import java.util.List;

public class BiomeEffectTickEvent implements ServerTickEvents.EndTick{
    private int lastActivationTick = 0;

    @Override
    public void onEndTick(MinecraftServer server) {
        if (server.getTicks() % 60 == 0) {
            List<ServerPlayerEntity> players = server.getOverworld().getPlayers();

            for (ServerPlayerEntity player : players) {
                // If Player is in water AND Player is in The Depths biome
                if (player.isSubmergedInWater() && server.getOverworld().getBiome(player.getBlockPos()).matchesKey(ModBiomes.THE_DEPTHS)) {

                    if (player.getBlockY() < 32) {

                        int amp = (32 - player.getBlockY()) / 32;
                        player.addStatusEffect(new StatusEffectInstance(ModEffects.PRESSURE, 600, amp));
                    }
                }
            }
        }
    }
}
