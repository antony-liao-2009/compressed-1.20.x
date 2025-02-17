package net.antony.compressed.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomCraftingBlockEntity extends BlockEntity {
    public CustomCraftingBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CUSTOM_CRAFTING_BLOCK_ENTITY.get(), pos, state);
    }
}