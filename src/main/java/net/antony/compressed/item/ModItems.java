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
    //diamond tools
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


    //diamond armor
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_HELMET = ITEMS.register("compressed_diamond_helmet",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_CHESTPLATE = ITEMS.register("compressed_diamond_chestplate",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_LEGGINGS = ITEMS.register("compressed_diamond_leggings",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_BOOTS = ITEMS.register("compressed_diamond_boots",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.BOOTS,new Item.Properties()));







    //iron tools
    public static final RegistryObject<Item> COMPRESSED_IRON_SWORD = ITEMS.register("compressed_iron_sword",
            ()->new SwordItem(ModToolTiers.CMP_DIM,14,
                    -2.4F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_PICKAXE = ITEMS.register("compressed_iron_pickaxe",
            ()->new PickaxeItem(ModToolTiers.CMP_DIM,3, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_AXE = ITEMS.register("compressed_iron_axe",
            ()->new AxeItem(ModToolTiers.CMP_DIM,10,
                    -3.1F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_SHOVEL = ITEMS.register("compressed_iron_shovel",
            ()->new ShovelItem(ModToolTiers.CMP_DIM,-1,
                    -2.8F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_HOE = ITEMS.register("compressed_iron_hoe",
            ()->new HoeItem(ModToolTiers.CMP_DIM,-1,
                    0,new Item.Properties()));


    //iron armor
    public static final RegistryObject<Item> COMPRESSED_IRON_HELMET = ITEMS.register("compressed_iron_helmet",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_CHESTPLATE = ITEMS.register("compressed_iron_chestplate",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_LEGGINGS = ITEMS.register("compressed_iron_leggings",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_BOOTS = ITEMS.register("compressed_iron_boots",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.BOOTS,new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
