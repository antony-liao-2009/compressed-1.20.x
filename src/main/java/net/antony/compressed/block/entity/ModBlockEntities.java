package net.antony.compressed.block.entity;

import net.antony.compressed.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "compressed");

    public static final RegistryObject<BlockEntityType<CustomCraftingBlockEntity>> CUSTOM_CRAFTING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("custom_crafting_table", () ->
                    BlockEntityType.Builder.of(CustomCraftingBlockEntity::new, ModBlocks.CUSTOM_CRAFTING_TABLE.get()).build(null));
}
