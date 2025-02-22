package net.antony.compressed.block.entity;

import net.antony.compressed.Compressed;
import net.antony.compressed.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Compressed.MODID);

    public static final RegistryObject<BlockEntityType<CompressedCraftingTableBlockEntity>> COMPRESSED_CRAFTING_BE =
            BLOCK_ENTITIES.register("compressed_crafting_be", () ->
                    BlockEntityType.Builder.of(CompressedCraftingTableBlockEntity::new,
                            ModBlocks.COMPRESSED_CRAFTING_TABLE.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
