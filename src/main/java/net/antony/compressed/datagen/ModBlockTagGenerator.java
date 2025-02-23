package net.antony.compressed.datagen;

import net.antony.compressed.Compressed;
import net.antony.compressed.block.ModBlocks;
import net.antony.compressed.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Compressed.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get(),
                        ModBlocks.COMPRESSED_IRON_BLOCK.get(),
                        ModBlocks.COMPRESSED_GOLD_BLOCK.get(),
                        ModBlocks.COMPRESSED_NETHERITE_BLOCK.get(),
                        ModBlocks.COMPRESSED_CRAFTING_TABLE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get(),
                        ModBlocks.COMPRESSED_IRON_BLOCK.get(),
                        ModBlocks.COMPRESSED_GOLD_BLOCK.get(),
                        ModBlocks.COMPRESSED_NETHERITE_BLOCK.get(),
                        ModBlocks.COMPRESSED_CRAFTING_TABLE.get());


    }
}
