package com.squidymine.deos.world.biome.surface;

import com.squidymine.deos.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);

    public static MaterialRules.MaterialRule makeRules() {
        //MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition stoneLevel = MaterialRules.stoneDepth(3, false, 0, VerticalSurfaceType.FLOOR);

        MaterialRules.MaterialRule gravelSurface = MaterialRules.sequence(MaterialRules.condition(stoneLevel, GRAVEL), STONE);

        return MaterialRules.sequence(
//                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.THE_DEPTHS),
//                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, RAW_RUBY)),
//                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, RUBY)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, gravelSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
