package net.antony.compressed.item;

import net.antony.compressed.Compressed;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    COMPRESSED_DIAMOND("compressed_diamond",300,new int[] {6,11,7,5},25,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 4.5f,0.15f,()->Ingredient.of(ModItems.COMPRESSED_DIAMOND.get())),
    COMPRESSED_IRON("compressed_iron",45,new int[] {4,8,6,4},15,
            SoundEvents.ARMOR_EQUIP_IRON, 2f,0.08f,()->Ingredient.of(ModItems.COMPRESSED_IRON.get())),
    COMPRESSED_GOLD("compressed_gold",20,new int[] {3,8,6,3},25,
    SoundEvents.ARMOR_EQUIP_GOLD, 0.3f,0f,()->Ingredient.of(ModItems.COMPRESSED_GOLD.get())),
    COMPRESSED_NETHERITE("compressed_netherite",100000000,new int[] {8,12,11,9},30,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 6f,0.25f,()->Ingredient.of(ModItems.COMPRESSED_NETHERITE.get()))
    ;


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private static final int[] BASE_DURABILITY = {11,16,15,13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Compressed.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
