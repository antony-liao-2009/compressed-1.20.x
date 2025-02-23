package net.antony.compressed.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.antony.compressed.Compressed;
import net.antony.compressed.block.ModBlocks;
import net.antony.compressed.recipe.CompressedCraftingRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class CompressedCraftingCategory implements IRecipeCategory<CompressedCraftingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Compressed.MODID,"compressed_crafting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Compressed.MODID,
            "textures/gui/compressed_crafting_table_gui.png");

    public static final RecipeType<CompressedCraftingRecipe> COMPRESSED_CRAFTING_TYPE =
            new RecipeType<>(UID,CompressedCraftingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CompressedCraftingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COMPRESSED_CRAFTING_TABLE.get()));
    }

    @Override
    public RecipeType<CompressedCraftingRecipe> getRecipeType() {
        return COMPRESSED_CRAFTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.compressed.compressed_crafting_table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CompressedCraftingRecipe recipe, IFocusGroup focuses) {
        /*
        builder.addSlot(RecipeIngredientRole.INPUT, 30, 17).addIngredients(recipe.getIngredients().get(0)); // (1,1)
        builder.addSlot(RecipeIngredientRole.INPUT,  48, 17).addIngredients(recipe.getIngredients().get(1)); // (1,2)
        builder.addSlot(RecipeIngredientRole.INPUT,  66, 17).addIngredients(recipe.getIngredients().get(2)); // (1,3)

        // Row 2
        builder.addSlot(RecipeIngredientRole.INPUT,  30, 35).addIngredients(recipe.getIngredients().get(3)); // (2,1)
        builder.addSlot(RecipeIngredientRole.INPUT,  48, 35).addIngredients(recipe.getIngredients().get(4)); // (2,2)
        builder.addSlot(RecipeIngredientRole.INPUT,  66, 35).addIngredients(recipe.getIngredients().get(5)); // (2,3)

        // Row 3
        builder.addSlot(RecipeIngredientRole.INPUT,  30, 53).addIngredients(recipe.getIngredients().get(6)); // (3,1)
        builder.addSlot(RecipeIngredientRole.INPUT,  48, 53).addIngredients(recipe.getIngredients().get(7)); // (3,2)
        builder.addSlot(RecipeIngredientRole.INPUT,  66, 53).addIngredients(recipe.getIngredients().get(8)); // (3,3)

        // Output slot
        builder.addSlot(RecipeIngredientRole.OUTPUT,  124, 35).addItemStack(recipe.getResultItem(null));
        */
        NonNullList<Ingredient> ingredients = recipe.getIngredients();

        int[][] coords = {
                {30, 17}, {48, 17}, {66, 17},  // Row 1
                {30, 35}, {48, 35}, {66, 35},  // Row 2
                {30, 53}, {48, 53}, {66, 53}   // Row 3
        };

        // Add input slots for available ingredients.
        for (int i = 0; i < ingredients.size(); i++) {
            builder.addSlot(RecipeIngredientRole.INPUT, coords[i][0], coords[i][1])
                    .addIngredients(ingredients.get(i));
        }

        // Optionally, if you want to show empty slots for the missing ones,
        // you can add them with no ingredient.
        for (int i = ingredients.size(); i < 9; i++) {
            builder.addSlot(RecipeIngredientRole.INPUT, coords[i][0], coords[i][1]);
        }

        // Output slot remains constant.
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35)
                .addItemStack(recipe.getResultItem(null));

    }
}
