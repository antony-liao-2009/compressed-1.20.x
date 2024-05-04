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
                                pOutput.accept(ModItems.COMPRESSED_DIAMOND.get());
                                pOutput.accept(ModItems.COMPRESSED_IRON.get());

                                pOutput.accept(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get());
                                pOutput.accept(ModBlocks.COMPRESSED_IRON_BLOCK.get());


                            })
                            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }

}
