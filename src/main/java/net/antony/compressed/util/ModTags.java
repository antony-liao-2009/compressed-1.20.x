package net.antony.compressed.util;

import net.antony.compressed.Compressed;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> NEEDS_CMP_DIM_TOOL = tag("needs_cmp_dim_tool");
        public static final TagKey<Block> NEEDS_CMP_IRON_TOOL = tag("needs_cmp_iron_tool");
        public static final TagKey<Block> NEEDS_CMP_GOLD_TOOL = tag("needs_cmp_gold_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Compressed.MODID,name));
        }
    }
    public static class Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Compressed.MODID,name));
        }
    }
}
