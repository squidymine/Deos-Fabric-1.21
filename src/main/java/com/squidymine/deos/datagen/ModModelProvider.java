package com.squidymine.deos.datagen;

import com.squidymine.deos.block.ModBlocks;
import com.squidymine.deos.block.custom.DepthBerryBushBlock;
import com.squidymine.deos.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK); // Test

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.DEPTH_BERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                DepthBerryBushBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED); // Test
    }
}
