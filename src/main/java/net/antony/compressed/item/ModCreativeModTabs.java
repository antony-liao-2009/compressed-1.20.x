package net.antony.compressed.item;

import net.antony.compressed.Compressed;
import net.antony.compressed.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
          DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Compressed.MODID);


    public static final RegistryObject<CreativeModeTab> COMPRESSED_TAB =
            CREATIVE_MOD_TABS.register("compressed_tab", () ->
                    CreativeModeTab.builder().icon(() -> new ItemStack((ModItems.COMPRESSED_DIAMOND.get())))
                            .title(Component.translatable("creativetab.compressed_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModBlocks.COMPRESSED_CRAFTING_TABLE.get());

                                pOutput.accept(ModItems.SOUL_DRINKER.get());
                                pOutput.accept(ModItems.SOUL_CATALYST.get());

                                pOutput.accept(ModItems.COMPRESSED_DIAMOND.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE.get());


                                pOutput.accept(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get());
                                pOutput.accept(ModBlocks.COMPRESSED_IRON_BLOCK.get());
                                pOutput.accept(ModBlocks.COMPRESSED_GOLD_BLOCK.get());
                                pOutput.accept(ModBlocks.COMPRESSED_NETHERITE_BLOCK.get());



                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_SWORD.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_PICKAXE.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_AXE.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_SHOVEL.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_HOE.get());

                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_HELMET.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_CHESTPLATE.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_LEGGINGS.get());
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND_BOOTS.get());





                                pOutput.accept(ModItems.COMPRESSED_IRON_SWORD.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_PICKAXE.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_AXE.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_SHOVEL.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_HOE.get());

                                pOutput.accept(ModItems.COMPRESSED_IRON_HELMET.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_CHESTPLATE.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_LEGGINGS.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON_BOOTS.get());





                                pOutput.accept(ModItems.COMPRESSED_GOLD_SWORD.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_PICKAXE.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_AXE.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_SHOVEL.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_HOE.get());

                                pOutput.accept(ModItems.COMPRESSED_GOLD_HELMET.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_CHESTPLATE.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_LEGGINGS.get());
                                pOutput.accept(ModItems.COMPRESSED_GOLD_BOOTS.get());





                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_SWORD.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_PICKAXE.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_AXE.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_SHOVEL.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_HOE.get());

                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_HELMET.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_CHESTPLATE.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_LEGGINGS.get());
                                pOutput.accept(ModItems.COMPRESSED_NETHERITE_BOOTS.get());

                            })
                            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }

}
