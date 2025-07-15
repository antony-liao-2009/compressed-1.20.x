package net.antony.compressed.datagen;


import net.antony.compressed.Compressed;
import net.antony.compressed.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Compressed.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COMPRESSED_DIAMOND_HELMET.get(),
                        ModItems.COMPRESSED_DIAMOND_CHESTPLATE.get(),
                        ModItems.COMPRESSED_DIAMOND_LEGGINGS.get(),
                        ModItems.COMPRESSED_DIAMOND_BOOTS.get(),

                        ModItems.COMPRESSED_IRON_HELMET.get(),
                        ModItems.COMPRESSED_IRON_CHESTPLATE.get(),
                        ModItems.COMPRESSED_IRON_LEGGINGS.get(),
                        ModItems.COMPRESSED_IRON_BOOTS.get(),

                        ModItems.COMPRESSED_GOLD_HELMET.get(),
                        ModItems.COMPRESSED_GOLD_CHESTPLATE.get(),
                        ModItems.COMPRESSED_GOLD_LEGGINGS.get(),
                        ModItems.COMPRESSED_GOLD_BOOTS.get(),

                        ModItems.COMPRESSED_NETHERITE_HELMET.get(),
                        ModItems.COMPRESSED_NETHERITE_CHESTPLATE.get(),
                        ModItems.COMPRESSED_NETHERITE_LEGGINGS.get(),
                        ModItems.COMPRESSED_NETHERITE_BOOTS.get());
    }
}
