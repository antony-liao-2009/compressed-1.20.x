package net.antony.compressed.datagen;

import net.antony.compressed.Compressed;
import net.antony.compressed.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, Compressed.MODID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.COMPRESSED_DIAMOND_BLOCK);
        blockWithItem(ModBlocks.COMPRESSED_IRON_BLOCK);
        blockWithItem(ModBlocks.COMPRESSED_GOLD_BLOCK);
        blockWithItem(ModBlocks.COMPRESSED_NETHERITE_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
