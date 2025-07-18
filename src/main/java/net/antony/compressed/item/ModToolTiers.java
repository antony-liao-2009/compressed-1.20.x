package net.antony.compressed.item;

import net.antony.compressed.Compressed;
import net.antony.compressed.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier CMP_DIM = TierSortingRegistry.registerTier(
            new ForgeTier(5,1561*81,65f,3f,20,
                    ModTags.Blocks.NEEDS_CMP_DIM_TOOL,()->Ingredient.of(ModItems.COMPRESSED_DIAMOND.get())),
            new ResourceLocation(Compressed.MODID,"compressed_diamond"),
            List.of(Tiers.NETHERITE),
            List.of());

    public static final Tier CMP_IRON = TierSortingRegistry.registerTier(
            new ForgeTier(4,250*81,20f,3f,15,
                    ModTags.Blocks.NEEDS_CMP_IRON_TOOL,()->Ingredient.of(ModItems.COMPRESSED_IRON.get())),
            new ResourceLocation(Compressed.MODID,"compressed_iron"),
            List.of(Tiers.DIAMOND),
            List.of());

    public static final Tier CMP_GOLD = TierSortingRegistry.registerTier(
            new ForgeTier(3,40*18,130f,1f,20,
                    ModTags.Blocks.NEEDS_CMP_GOLD_TOOL,()->Ingredient.of(ModItems.COMPRESSED_GOLD.get())),
            new ResourceLocation(Compressed.MODID,"compressed_gold"),
            List.of(Tiers.GOLD),
            List.of());

    public static final Tier CMP_NTHR = TierSortingRegistry.registerTier(
            new ForgeTier(6,2147483647,2147483647f,3f,25,
                    ModTags.Blocks.NEEDS_CMP_NTHR_TOOL,()->Ingredient.of(ModItems.COMPRESSED_NETHERITE.get())),
            new ResourceLocation(Compressed.MODID,"compressed_netherite"),
            List.of(ModToolTiers.CMP_DIM),
            List.of());

}
