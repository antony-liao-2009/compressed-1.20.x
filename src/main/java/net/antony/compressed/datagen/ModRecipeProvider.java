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



    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        /*

        //diamond

        below is cmp_dim_to_cmp_dim_blk,
        to_cmp_dim
        cmp_dim_to_dim_blk

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                ModBlocks.COMPRESSED_DIAMOND_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COMPRESSED_DIAMOND.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_DIAMOND.get()),
                        has(ModItems.COMPRESSED_DIAMOND.get()))
                .save(pWriter,"cmp_dim_to_cmp_dim_blk");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModItems.COMPRESSED_DIAMOND.get())
                .pattern(" S ")
                .pattern("S S")
                .pattern(" S ")
                .define('S', Blocks.DIAMOND_BLOCK)
                .unlockedBy(getHasName(Blocks.DIAMOND_BLOCK),
                        has(Blocks.DIAMOND_BLOCK))
                .save(pWriter,"to_cmp_dim");

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

        below is cmp_ir_to_cmp_ir_blk,
        cmp_ir_blk_to_cmp_ir,
        ir_blk_to_cmp_ir
        cmp_ir_to_ir_blk



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





        //gold

        below is cmp_gl_to_cmp_gl_blk,
        cmp_gl_blk_to_cmp_gl,
        gl_blk_to_cmp_gl
        cmp_gl_to_gl_blk


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModBlocks.COMPRESSED_GOLD_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_GOLD.get()),
                        has(ModItems.COMPRESSED_GOLD.get()))
                .save(pWriter,"cmp_gl_to_cmp_gl_blk");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        ModItems.COMPRESSED_GOLD.get(),9)
                .requires(ModBlocks.COMPRESSED_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_GOLD_BLOCK.get()),
                        has(ModBlocks.COMPRESSED_GOLD_BLOCK.get()))
                .save(pWriter,"cmp_gl_blk_to_cmp_gl");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModItems.COMPRESSED_GOLD.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Blocks.GOLD_BLOCK)
                .unlockedBy(getHasName(Blocks.GOLD_BLOCK),
                        has(Blocks.GOLD_BLOCK))
                .save(pWriter,"gl_blk_to_cmp_gl");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        Blocks.GOLD_BLOCK,9)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_GOLD.get()),
                        has(ModItems.COMPRESSED_GOLD.get()))
                .save(pWriter,"cmp_gl_to_gl_blk");



        //gold tools
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_SWORD.get())
                .requires(Items.GOLDEN_SWORD)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_SWORD),
                        has(Items.GOLDEN_SWORD))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_PICKAXE.get())
                .requires(Items.GOLDEN_PICKAXE)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_PICKAXE),
                        has(Items.GOLDEN_PICKAXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_AXE.get())
                .requires(Items.GOLDEN_AXE)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_AXE),
                        has(Items.GOLDEN_AXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_SHOVEL.get())
                .requires(Items.GOLDEN_SHOVEL)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_SHOVEL),
                        has(Items.GOLDEN_SHOVEL))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_HOE.get())
                .requires(Items.GOLDEN_HOE)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_HOE),
                        has(Items.GOLDEN_HOE))
                .save(pWriter);



        //gold armor
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_HELMET.get())
                .requires(Items.GOLDEN_HELMET)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_HELMET),
                        has(Items.GOLDEN_HELMET))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_CHESTPLATE.get())
                .requires(Items.GOLDEN_CHESTPLATE)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_CHESTPLATE),
                        has(Items.GOLDEN_CHESTPLATE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_LEGGINGS.get())
                .requires(Items.GOLDEN_LEGGINGS)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_LEGGINGS),
                        has(Items.GOLDEN_LEGGINGS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_GOLD_BOOTS.get())
                .requires(Items.GOLDEN_BOOTS)
                .requires(ModItems.COMPRESSED_GOLD.get())
                .unlockedBy(getHasName(Items.GOLDEN_BOOTS),
                        has(Items.GOLDEN_BOOTS))
                .save(pWriter);



        //netherite

        below is cmp_n_to_cmp_n_blk,
        to_cmp_n,


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModBlocks.COMPRESSED_NETHERITE_BLOCK.get())
                .pattern("HHH")
                .pattern("HHH")
                .pattern("HHH")
                .define('H', ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_NETHERITE.get()),
                        has(ModItems.COMPRESSED_NETHERITE.get()))
                .save(pWriter,"cmp_n_to_cmp_n_blk");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                    ModItems.COMPRESSED_NETHERITE.get())
                .requires(Blocks.NETHERITE_BLOCK,2)
                .requires(Blocks.GOLD_BLOCK,2)
                .unlockedBy(getHasName(Blocks.NETHERITE_BLOCK),
                        has(Blocks.NETHERITE_BLOCK))
                .save(pWriter,"to_cmp_n");




        //netherite tools
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_SWORD.get())
                .requires(Items.NETHERITE_SWORD)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_SWORD),
                        has(Items.NETHERITE_SWORD))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_PICKAXE.get())
                .requires(Items.NETHERITE_PICKAXE)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_PICKAXE),
                        has(Items.NETHERITE_PICKAXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_AXE.get())
                .requires(Items.NETHERITE_AXE)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_AXE),
                        has(Items.NETHERITE_AXE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_SHOVEL.get())
                .requires(Items.NETHERITE_SHOVEL)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_SHOVEL),
                        has(Items.NETHERITE_SHOVEL))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_HOE.get())
                .requires(Items.NETHERITE_HOE)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_HOE),
                        has(Items.NETHERITE_HOE))
                .save(pWriter);




        //netherite armor
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_HELMET.get())
                .requires(Items.NETHERITE_HELMET)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_HELMET),
                        has(Items.NETHERITE_HELMET))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_CHESTPLATE.get())
                .requires(Items.NETHERITE_CHESTPLATE)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_CHESTPLATE),
                        has(Items.NETHERITE_CHESTPLATE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_LEGGINGS.get())
                .requires(Items.NETHERITE_LEGGINGS)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_LEGGINGS),
                        has(Items.NETHERITE_LEGGINGS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.COMPRESSED_NETHERITE_BOOTS.get())
                .requires(Items.NETHERITE_BOOTS)
                .requires(ModItems.COMPRESSED_NETHERITE.get())
                .unlockedBy(getHasName(Items.NETHERITE_BOOTS),
                        has(Items.NETHERITE_BOOTS))
                .save(pWriter);






        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SOUL_CATALYST.get())
                .requires(ModBlocks.COMPRESSED_NETHERITE_BLOCK.get())
                .requires(Items.BEACON,2)
                .requires(Items.ZOMBIE_HEAD)
                .requires(Items.CREEPER_HEAD)
                .requires(Items.PIGLIN_HEAD)
                .requires(Items.SKELETON_SKULL)
                .requires(Items.DRAGON_HEAD,2)
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_NETHERITE_BLOCK.get()),
                        has(ModBlocks.COMPRESSED_NETHERITE_BLOCK.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SOUL_DRINKER.get())
                .requires(ModItems.SOUL_CATALYST.get())
                .requires(ModItems.COMPRESSED_NETHERITE_SWORD.get())
                .unlockedBy(getHasName(ModItems.COMPRESSED_NETHERITE.get()),
                        has(ModItems.COMPRESSED_NETHERITE.get()))
                .save(pWriter);
        */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,
                        ModBlocks.COMPRESSED_CRAFTING_TABLE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Items.CRAFTING_TABLE)
                .unlockedBy(getHasName(Items.CRAFTING_TABLE),
                        has(Items.CRAFTING_TABLE))
                .save(pWriter,"compressed_crafting_table_reci");
    }
}
