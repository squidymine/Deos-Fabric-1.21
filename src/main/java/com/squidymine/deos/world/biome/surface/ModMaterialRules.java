package com.squidymine.deos.world.biome.surface;

import com.squidymine.deos.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
//    private static final MaterialRules.MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);
//    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRules.MaterialRule WATER = makeStateRule(Blocks.WATER);
    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);

    public static MaterialRules.MaterialRule makeRules() {
        //MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialCondition stoneLevel = MaterialRules.stoneDepth(3, false, 94, VerticalSurfaceType.FLOOR);

//        MaterialRules.MaterialRule gravelSurface = MaterialRules.sequence(MaterialRules.condition(stoneLevel, GRAVEL), STONE);

        return MaterialRules.sequence(
//                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.THE_DEPTHS),
//                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, RAW_RUBY)),
//                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, RUBY)),

                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(-59), 0), // Above y: 5?
                        MaterialRules.condition(stoneLevel, WATER)) // Replace block down ~amount with water
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
