package net.antony.compressed.item;

import net.antony.compressed.Compressed;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Compressed.MODID);

    public static final RegistryObject<Item> COMPRESSED_DIAMOND =
            ITEMS.register("compressed_diamond",
                    () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON =
            ITEMS.register("compressed_iron",
                    () -> new Item(new Item.Properties()));

    /*
    remember to add textures!!!!!!!
     */
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_SWORD = ITEMS.register("compressed_diamond_sword",
            ()->new SwordItem(ModToolTiers.CMP_DIM,60,
                    -2.4F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_PICKAXE = ITEMS.register("compressed_diamond_pickaxe",
            ()->new PickaxeItem(ModToolTiers.CMP_DIM,6, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_AXE = ITEMS.register("compressed_diamond_axe",
            ()->new AxeItem(ModToolTiers.CMP_DIM,20,
                    -3.1F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_SHOVEL = ITEMS.register("compressed_diamond_shovel",
            ()->new ShovelItem(ModToolTiers.CMP_DIM,0,
                    -2.8F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_HOE = ITEMS.register("compressed_diamond_hoe",
            ()->new HoeItem(ModToolTiers.CMP_DIM,0,
                    0,new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
