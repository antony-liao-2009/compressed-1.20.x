package net.antony.compressed.block;

import net.antony.compressed.Compressed;
import net.antony.compressed.item.ModItems;
import net.antony.compressed.block.CompressedCraftingTableBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Compressed.MODID);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static final RegistryObject<Block> COMPRESSED_DIAMOND_BLOCK = registerBlock(
            "compressed_diamond_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.ANCIENT_DEBRIS)));

        public static final RegistryObject<Block> COMPRESSED_IRON_BLOCK = registerBlock(
            "compressed_iron_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.ANCIENT_DEBRIS)));

        public static final RegistryObject<Block> COMPRESSED_GOLD_BLOCK = registerBlock(
            "compressed_gold_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.ANCIENT_DEBRIS)));
        public static final RegistryObject<Block> COMPRESSED_NETHERITE_BLOCK = registerBlock(
            "compressed_netherite_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> COMPRESSED_CRAFTING_TABLE = registerBlock(
            "compressed_crafting_table", ()-> new CompressedCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).noOcclusion()));






    private static <T extends Block> RegistryObject<Item> registerBlockItem
            (String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
