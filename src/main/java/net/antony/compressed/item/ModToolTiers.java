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
            new ForgeTier(5,1561*9,32f,3f,30,
                    ModTags.Blocks.NEEDS_CMP_DIM_TOOL,()->Ingredient.of(ModItems.COMPRESSED_DIAMOND.get())),
            new ResourceLocation(Compressed.MODID,"compressed_diamond"),
            List.of(Tiers.NETHERITE),
            List.of());

    public static final Tier CMP_IRON = TierSortingRegistry.registerTier(
            new ForgeTier(4,250*9,14f,3f,20,
                    ModTags.Blocks.NEEDS_CMP_IRON_TOOL,()->Ingredient.of(ModItems.COMPRESSED_IRON.get())),
            new ResourceLocation(Compressed.MODID,"compressed_iron"),
            List.of(Tiers.DIAMOND),
            List.of());


}