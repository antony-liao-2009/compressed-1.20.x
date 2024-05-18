package net.antony.compressed.item;

import net.antony.compressed.Compressed;
import net.antony.compressed.item.custom.ModArmorItem;
import net.antony.compressed.item.custom.SoulDrinkerItem;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
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
    public static final RegistryObject<Item> COMPRESSED_GOLD =
            ITEMS.register("compressed_gold",
                    () -> new Item(new Item.Properties()));

    /*
    remember to add textures!!!!!!!
     */

    //soul breaker
    public static final RegistryObject<Item> SOUL_DRINKER =
            ITEMS.register("soul_drinker",()->new SoulDrinkerItem(new Tier() {
                @Override
                public int getUses() {
                    return 9999;
                }

                @Override
                public float getSpeed() {
                    return 0;
                }

                @Override
                public float getAttackDamageBonus() {
                    return 0;
                }

                @Override
                public int getLevel() {
                    return 0;
                }

                @Override
                public int getEnchantmentValue() {
                    return 30;
                }

                @Override
                public Ingredient getRepairIngredient() {
                    return null;
                }
            }));


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
            ()->new ModArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_CHESTPLATE = ITEMS.register("compressed_diamond_chestplate",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_LEGGINGS = ITEMS.register("compressed_diamond_leggings",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_DIAMOND_BOOTS = ITEMS.register("compressed_diamond_boots",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_DIAMOND,ArmorItem.Type.BOOTS,new Item.Properties()));







    //iron tools
    public static final RegistryObject<Item> COMPRESSED_IRON_SWORD = ITEMS.register("compressed_iron_sword",
            ()->new SwordItem(ModToolTiers.CMP_IRON,14,
                    -2.4F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_PICKAXE = ITEMS.register("compressed_iron_pickaxe",
            ()->new PickaxeItem(ModToolTiers.CMP_IRON,3, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_AXE = ITEMS.register("compressed_iron_axe",
            ()->new AxeItem(ModToolTiers.CMP_IRON,10,
                    -3.1F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_SHOVEL = ITEMS.register("compressed_iron_shovel",
            ()->new ShovelItem(ModToolTiers.CMP_IRON,-1,
                    -2.8F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_HOE = ITEMS.register("compressed_iron_hoe",
            ()->new HoeItem(ModToolTiers.CMP_IRON,-1,
                    0,new Item.Properties()));


    //iron armor
    public static final RegistryObject<Item> COMPRESSED_IRON_HELMET = ITEMS.register("compressed_iron_helmet",
            ()->new ModArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_CHESTPLATE = ITEMS.register("compressed_iron_chestplate",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_LEGGINGS = ITEMS.register("compressed_iron_leggings",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_IRON_BOOTS = ITEMS.register("compressed_iron_boots",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_IRON,ArmorItem.Type.BOOTS,new Item.Properties()));






    //gold tools
    public static final RegistryObject<Item> COMPRESSED_GOLD_SWORD = ITEMS.register("compressed_gold_sword",
            ()->new SwordItem(ModToolTiers.CMP_GOLD,9,
                    -2.4F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_PICKAXE = ITEMS.register("compressed_gold_pickaxe",
            ()->new PickaxeItem(ModToolTiers.CMP_IRON,2, -2.8F,
                    new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_AXE = ITEMS.register("compressed_gold_axe",
            ()->new AxeItem(ModToolTiers.CMP_IRON,8,
                    -3.1F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_SHOVEL = ITEMS.register("compressed_gold_shovel",
            ()->new ShovelItem(ModToolTiers.CMP_IRON,0,
                    -2.8F,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_HOE = ITEMS.register("compressed_gold_hoe",
            ()->new HoeItem(ModToolTiers.CMP_IRON,0,
                    0,new Item.Properties()));



    //gold armor
    public static final RegistryObject<Item> COMPRESSED_GOLD_HELMET = ITEMS.register("compressed_gold_helmet",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_GOLD,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_CHESTPLATE = ITEMS.register("compressed_gold_chestplate",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_GOLD,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_LEGGINGS = ITEMS.register("compressed_gold_leggings",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_GOLD,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COMPRESSED_GOLD_BOOTS = ITEMS.register("compressed_gold_boots",
            ()->new ArmorItem(ModArmorMaterials.COMPRESSED_GOLD,ArmorItem.Type.BOOTS,new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
