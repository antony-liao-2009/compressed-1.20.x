package net.antony.compressed.block;

import net.antony.compressed.Compressed;
import net.antony.compressed.block.entity.CustomCraftingBlockEntity;
import net.antony.compressed.item.ModItems;
import net.antony.compressed.menu.CustomCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.antony.compressed.block.entity.ModBlockEntities.BLOCK_ENTITIES;
import static net.antony.compressed.menu.ModMenus.MENUS;

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


    public static final RegistryObject<Block> CUSTOM_CRAFTING_TABLE = BLOCKS.register("custom_crafting_table", () ->
            new CustomCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)));

    public static final RegistryObject<BlockEntityType<CustomCraftingBlockEntity>> CUSTOM_CRAFTING_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "custom_crafting_block_entity",
            () -> BlockEntityType.Builder.of(CustomCraftingBlockEntity::new, CUSTOM_CRAFTING_TABLE.get()).build(null)
    );

    public static final RegistryObject<MenuType<CustomCraftingMenu>> CUSTOM_CRAFTING_MENU = MENUS.register(
            "custom_crafting_menu",
            () -> IForgeMenuType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new CustomCraftingMenu(windowId, inv, ContainerLevelAccess.create(inv.player.level(), pos));
            })
    );




    private static <T extends Block> RegistryObject<Item> registerBlockItem
            (String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
