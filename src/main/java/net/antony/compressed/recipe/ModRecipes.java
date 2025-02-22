package net.antony.compressed.recipe;

import net.antony.compressed.Compressed;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Compressed.MODID);

    public static final RegistryObject<RecipeSerializer<CompressedCraftingRecipe>> COMPRESSED_CRAFTING_SERIALIZER =
            SERIALIZERS.register("compressed_crafting", ()-> CompressedCraftingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
