package com.squidymine.deos.world.biome;

import com.squidymine.deos.Deos;
import com.squidymine.deos.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(Deos.MOD_ID, "overworld"), 4));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Deos.MOD_ID, ModMaterialRules.makeRules());
    }
}
