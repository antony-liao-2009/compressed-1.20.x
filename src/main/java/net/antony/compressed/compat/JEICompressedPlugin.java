package net.antony.compressed.compat;


import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.antony.compressed.Compressed;
import net.antony.compressed.recipe.CompressedCraftingRecipe;
import net.antony.compressed.screen.CompressedCraftingTableScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEICompressedPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Compressed.MODID,"jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CompressedCraftingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<CompressedCraftingRecipe> craftingRecipes = recipeManager.getAllRecipesFor(CompressedCraftingRecipe.Type.INSTANCE);
        registration.addRecipes(CompressedCraftingCategory.COMPRESSED_CRAFTING_TYPE, craftingRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CompressedCraftingTableScreen.class, 12, 60,17,100,  //check numbers
                CompressedCraftingCategory.COMPRESSED_CRAFTING_TYPE);
    }
}
