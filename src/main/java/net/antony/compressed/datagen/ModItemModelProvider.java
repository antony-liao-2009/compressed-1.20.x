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
        final String MOD_ID = Compressed.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
