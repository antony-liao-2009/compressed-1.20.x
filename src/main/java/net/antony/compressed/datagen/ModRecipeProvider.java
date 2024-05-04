package net.antony.compressed.datagen;

import net.antony.compressed.block.ModBlocks;
import net.antony.compressed.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                ModBlocks.COMPRESSED_DIAMOND_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_DIAMOND.get()),
                        has(ModItems.COMPRESSED_DIAMOND.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        ModItems.COMPRESSED_DIAMOND.get())
                .requires(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get()),
                        has(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModBlocks.COMPRESSED_IRON_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_IRON.get()),
                        has(ModItems.COMPRESSED_IRON.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        ModItems.COMPRESSED_IRON.get())
                .requires(ModBlocks.COMPRESSED_IRON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_IRON_BLOCK.get()),
                        has(ModBlocks.COMPRESSED_IRON_BLOCK.get()))
                .save(pWriter);
    }
}
