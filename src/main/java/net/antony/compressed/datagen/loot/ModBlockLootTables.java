package net.antony.compressed.datagen.loot;

import net.antony.compressed.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get());
        this.dropSelf(ModBlocks.COMPRESSED_IRON_BLOCK.get());
        this.dropSelf(ModBlocks.COMPRESSED_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.COMPRESSED_NETHERITE_BLOCK.get());
        this.dropSelf(ModBlocks.COMPRESSED_CRAFTING_TABLE.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
