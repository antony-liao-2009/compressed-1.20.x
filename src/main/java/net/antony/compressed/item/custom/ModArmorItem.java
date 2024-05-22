package net.antony.compressed.item.custom;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import net.antony.compressed.Compressed;
import net.antony.compressed.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Multimap<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP;
    static {
        Multimap<ArmorMaterial, MobEffectInstance> map = ArrayListMultimap.create();
        map.put(ModArmorMaterials.COMPRESSED_DIAMOND, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 10, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_DIAMOND, new MobEffectInstance(MobEffects.NIGHT_VISION, 230, 10, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_DIAMOND, new MobEffectInstance(MobEffects.WATER_BREATHING, 230, 10, false, false, true));

        map.put(ModArmorMaterials.COMPRESSED_IRON, new MobEffectInstance(MobEffects.NIGHT_VISION, 230, 10, false, false, true));

        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 10, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.NIGHT_VISION, 100000, 10, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.WATER_BREATHING, 10000, 10, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 3, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2000, 3, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.ABSORPTION, 2000, 3, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.REGENERATION, 2000, 2, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 230, 0, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.DAMAGE_BOOST, 230, 2, false, false, true));
        map.put(ModArmorMaterials.COMPRESSED_NETHERITE, new MobEffectInstance(MobEffects.JUMP, 2000, 3, false, false, true));
        MATERIAL_TO_EFFECT_MAP = map;
    }

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entries()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}

