package net.antony.compressed.datagen;

import net.antony.compressed.Compressed;
import net.antony.compressed.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Compressed.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COMPRESSED_DIAMOND);
        simpleItem(ModItems.COMPRESSED_IRON);

        handheldItem(ModItems.COMPRESSED_DIAMOND_SWORD);
        handheldItem(ModItems.COMPRESSED_DIAMOND_AXE);
        handheldItem(ModItems.COMPRESSED_DIAMOND_PICKAXE);
        handheldItem(ModItems.COMPRESSED_DIAMOND_SHOVEL);
        handheldItem(ModItems.COMPRESSED_DIAMOND_HOE);

        handheldItem(ModItems.COMPRESSED_IRON_SWORD);
        handheldItem(ModItems.COMPRESSED_IRON_AXE);
        handheldItem(ModItems.COMPRESSED_IRON_PICKAXE);
        handheldItem(ModItems.COMPRESSED_IRON_SHOVEL);
        handheldItem(ModItems.COMPRESSED_IRON_HOE);


    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Compressed.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Compressed.MODID,"item/" + item.getId().getPath()));
    }
}
