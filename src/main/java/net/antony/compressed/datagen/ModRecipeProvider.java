package net.antony.compressed.datagen;

import net.antony.compressed.block.ModBlocks;
import net.antony.compressed.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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




        //diamond tools
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_SWORD.get())
                .requires(Items.DIAMOND_SWORD)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_SWORD),
                        has(Items.DIAMOND_SWORD))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_PICKAXE.get())
                .requires(Items.DIAMOND_PICKAXE)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_PICKAXE),
                        has(Items.DIAMOND_PICKAXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_AXE.get())
                .requires(Items.DIAMOND_AXE)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_AXE),
                        has(Items.DIAMOND_AXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_SHOVEL.get())
                .requires(Items.DIAMOND_SHOVEL)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_SHOVEL),
                        has(Items.DIAMOND_SHOVEL))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_HOE.get())
                .requires(Items.DIAMOND_HOE)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_HOE),
                        has(Items.DIAMOND_HOE))
                .save(pWriter);




        //diamond armor
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_HELMET.get())
                .requires(Items.DIAMOND_HELMET)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_HELMET),
                        has(Items.DIAMOND_HELMET))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_CHESTPLATE.get())
                .requires(Items.DIAMOND_CHESTPLATE)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_CHESTPLATE),
                        has(Items.DIAMOND_CHESTPLATE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_LEGGINGS.get())
                .requires(Items.DIAMOND_LEGGINGS)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_LEGGINGS),
                        has(Items.DIAMOND_LEGGINGS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_DIAMOND_BOOTS.get())
                .requires(Items.DIAMOND_BOOTS)
                .requires(ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(Items.DIAMOND_BOOTS),
                        has(Items.DIAMOND_BOOTS))
                .save(pWriter);









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




        //iron tools
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_SWORD.get())
                .requires(Items.IRON_SWORD)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_SWORD),
                        has(Items.IRON_SWORD))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_PICKAXE.get())
                .requires(Items.IRON_PICKAXE)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_PICKAXE),
                        has(Items.IRON_PICKAXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_AXE.get())
                .requires(Items.IRON_AXE)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_AXE),
                        has(Items.IRON_AXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_SHOVEL.get())
                .requires(Items.IRON_SHOVEL)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_SHOVEL),
                        has(Items.IRON_SHOVEL))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_HOE.get())
                .requires(Items.IRON_HOE)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_HOE),
                        has(Items.IRON_HOE))
                .save(pWriter);



        //iron armor
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_HELMET.get())
                .requires(Items.IRON_HELMET)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_HELMET),
                        has(Items.IRON_HELMET))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_CHESTPLATE.get())
                .requires(Items.IRON_CHESTPLATE)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_CHESTPLATE),
                        has(Items.IRON_CHESTPLATE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_LEGGINGS.get())
                .requires(Items.IRON_LEGGINGS)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_LEGGINGS),
                        has(Items.IRON_LEGGINGS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_IRON_BOOTS.get())
                .requires(Items.IRON_BOOTS)
                .requires(ModItems.COMPRESSED_IRON.get())
                .unlockedBy(getHasName(Items.IRON_BOOTS),
                        has(Items.IRON_BOOTS))
                .save(pWriter);
    }
}
