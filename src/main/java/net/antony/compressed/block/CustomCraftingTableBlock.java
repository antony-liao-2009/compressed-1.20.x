package net.antony.compressed.block;

import net.antony.compressed.block.entity.CustomCraftingBlockEntity;
import net.antony.compressed.menu.CustomCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class CustomCraftingTableBlock extends CraftingTableBlock {
    public CustomCraftingTableBlock(Properties properties) {
        super(properties);
    }


    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CustomCraftingBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            // Create a title component for the GUI
            Component title = Component.translatable("container.mymod.custom_crafting_table");

            NetworkHooks.openScreen(
                    serverPlayer,
                    new SimpleMenuProvider(
                            (windowId, inv, p) -> new CustomCraftingMenu(windowId, inv, ContainerLevelAccess.create(level, pos)),
                            title // Title component (not the buffer!)
                    ),
                    buffer -> buffer.writeBlockPos(pos) // Data writer for the buffer
            );
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}