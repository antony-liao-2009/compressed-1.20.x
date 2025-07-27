package net.antony.compressed.datagen;

import net.antony.compressed.Compressed;
import net.antony.compressed.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Compressed.MODID, existingFileHelper);
    }



    @Override
    protected void registerModels() {
        handheldItem(ModItems.SOUL_DRINKER);

        simpleItem(ModItems.COMPRESSED_DIAMOND);
        simpleItem(ModItems.COMPRESSED_IRON);
        simpleItem(ModItems.COMPRESSED_GOLD);
        simpleItem(ModItems.COMPRESSED_NETHERITE);
        simpleItem(ModItems.SOUL_CATALYST);

        //diamond
        handheldItem(ModItems.COMPRESSED_DIAMOND_SWORD);
        handheldItem(ModItems.COMPRESSED_DIAMOND_AXE);
        handheldItem(ModItems.COMPRESSED_DIAMOND_PICKAXE);
        handheldItem(ModItems.COMPRESSED_DIAMOND_SHOVEL);
        handheldItem(ModItems.COMPRESSED_DIAMOND_HOE);

        trimmedArmorItem(ModItems.COMPRESSED_DIAMOND_HELMET);
        trimmedArmorItem(ModItems.COMPRESSED_DIAMOND_CHESTPLATE);
        trimmedArmorItem(ModItems.COMPRESSED_DIAMOND_LEGGINGS);
        trimmedArmorItem(ModItems.COMPRESSED_DIAMOND_BOOTS);


        //iron
        handheldItem(ModItems.COMPRESSED_IRON_SWORD);
        handheldItem(ModItems.COMPRESSED_IRON_AXE);
        handheldItem(ModItems.COMPRESSED_IRON_PICKAXE);
        handheldItem(ModItems.COMPRESSED_IRON_SHOVEL);
        handheldItem(ModItems.COMPRESSED_IRON_HOE);

        trimmedArmorItem(ModItems.COMPRESSED_IRON_HELMET);
        trimmedArmorItem(ModItems.COMPRESSED_IRON_CHESTPLATE);
        trimmedArmorItem(ModItems.COMPRESSED_IRON_LEGGINGS);
        trimmedArmorItem(ModItems.COMPRESSED_IRON_BOOTS);


        //gold
        handheldItem(ModItems.COMPRESSED_GOLD_SWORD);
        handheldItem(ModItems.COMPRESSED_GOLD_AXE);
        handheldItem(ModItems.COMPRESSED_GOLD_PICKAXE);
        handheldItem(ModItems.COMPRESSED_GOLD_SHOVEL);
        handheldItem(ModItems.COMPRESSED_GOLD_HOE);

        trimmedArmorItem(ModItems.COMPRESSED_GOLD_HELMET);
        trimmedArmorItem(ModItems.COMPRESSED_GOLD_CHESTPLATE);
        trimmedArmorItem(ModItems.COMPRESSED_GOLD_LEGGINGS);
        trimmedArmorItem(ModItems.COMPRESSED_GOLD_BOOTS);


        //netherite
        handheldItem(ModItems.COMPRESSED_NETHERITE_SWORD);
        handheldItem(ModItems.COMPRESSED_NETHERITE_AXE);
        handheldItem(ModItems.COMPRESSED_NETHERITE_PICKAXE);
        handheldItem(ModItems.COMPRESSED_NETHERITE_SHOVEL);
        handheldItem(ModItems.COMPRESSED_NETHERITE_HOE);

        trimmedArmorItem(ModItems.COMPRESSED_NETHERITE_HELMET);
        trimmedArmorItem(ModItems.COMPRESSED_NETHERITE_CHESTPLATE);
        trimmedArmorItem(ModItems.COMPRESSED_NETHERITE_LEGGINGS);
        trimmedArmorItem(ModItems.COMPRESSED_NETHERITE_BOOTS);

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


    //holy shit stuff, new armor trimming in 1.20
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        // ①  create the BASE (non‑trim) icon once — this stops hot‑bar jitter
        ItemModelBuilder baseModel = withExistingParent(
                itemRegistryObject.getId().getPath(),          // e.g. compressed_diamond_helmet
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/" + itemRegistryObject.getId().getPath()));

        // ②  keep your existing per‑trim loop
        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, trimValue) -> {

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS  -> "leggings";
                    case FEET  -> "boots";
                    default -> "";
                };

                String trimTexPath = "trims/items/" + armorType + "_trim_"
                        + trimMaterial.location().getPath();
                String trimModelId = "item/" + armorItem + "_"                 // item/compressed_diamond_helmet_diamond_trim
                        + trimMaterial.location().getPath() + "_trim";

                ResourceLocation armorTex = modLoc("item/" + armorItem);
                ResourceLocation trimTex  = new ResourceLocation(trimTexPath); // minecraft namespace
                ResourceLocation trimModel= modLoc(trimModelId);

                existingFileHelper.trackGenerated(trimTex, PackType.CLIENT_RESOURCES,
                        ".png", "textures");

                // trimmed‑variant model
                getBuilder(trimModelId)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorTex)
                        .texture("layer1", trimTex);

                // override entry added to the BASE model we built once
                baseModel.override()
                        .predicate(mcLoc("trim_type"), trimValue)
                        .model(new ModelFile.UncheckedModelFile(trimModel))
                        .end();
            });
        }
    }

}
