package net.antony.compressed.datagen;

import net.antony.compressed.block.ModBlocks;
import net.antony.compressed.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.extensions.IForgeItem;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    //diamond
    /*
    below is cmp_dim_to_cmp_dim_blk,
    cmp_dim_blk_to_cmp_dim,
    dim_blk_to_cmp_dim
    cmp_dim_to_dim_blk
    */

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
                .save(pWriter,"cmp_dim_to_cmp_dim_blk");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        ModItems.COMPRESSED_DIAMOND.get(),9)
                .requires(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get()),
                        has(ModBlocks.COMPRESSED_DIAMOND_BLOCK.get()))
                .save(pWriter,"cmp_dim_blk_to_cmp_dim");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModItems.COMPRESSED_DIAMOND.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Blocks.DIAMOND_BLOCK)
                .unlockedBy(getHasName(Blocks.DIAMOND_BLOCK),
                        has(Blocks.DIAMOND_BLOCK))
                .save(pWriter,"dim_blk_to_cmp_dim");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        Blocks.DIAMOND_BLOCK,9)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_DIAMOND.get()),
                        has(ModItems.COMPRESSED_DIAMOND.get()))
                .save(pWriter,"cmp_dim_to_dim_blk");


        //iron
        /*
        below is cmp_ir_to_cmp_ir_blk,
        cmp_ir_blk_to_cmp_ir,
        ir_blk_to_cmp_ir
        cmp_ir_to_ir_blk
        */


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModBlocks.COMPRESSED_IRON_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_IRON.get()),
                        has(ModItems.COMPRESSED_IRON.get()))
                .save(pWriter,"cmp_ir_to_cmp_ir_blk");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        ModItems.COMPRESSED_IRON.get(),9)
                .requires(ModBlocks.COMPRESSED_IRON_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_IRON_BLOCK.get()),
                        has(ModBlocks.COMPRESSED_IRON_BLOCK.get()))
                .save(pWriter,"cmp_ir_blk_to_cmp_ir");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModItems.COMPRESSED_IRON.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Blocks.IRON_BLOCK)
                .unlockedBy(getHasName(Blocks.IRON_BLOCK),
                        has(Blocks.IRON_BLOCK))
                .save(pWriter,"ir_blk_to_cmp_ir");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        Blocks.IRON_BLOCK,9)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_IRON.get()),
                        has(ModItems.COMPRESSED_IRON.get()))
                .save(pWriter,"cmp_ir_to_ir_blk");


    }
}
