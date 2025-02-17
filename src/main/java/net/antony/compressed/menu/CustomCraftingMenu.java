package net.antony.compressed.menu;

import net.minecraft.core.RegistryAccess;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.awt.*;
import java.util.Optional;

public class CustomCraftingMenu extends CraftingMenu {
    public CustomCraftingMenu(int windowId, Inventory playerInv, ContainerLevelAccess access) {
        super(windowId, playerInv, access);
    }


    protected void slotChangedCraftingGrid(Container container, Level level, Player player, CraftingContainer craftingContainer, ResultContainer resultContainer) {
        if (!level.isClientSide) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            ItemStack result = ItemStack.EMPTY;
            Optional<CraftingRecipe> recipe = level.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftingContainer, level);
            if (recipe.isPresent() && isAllowed(recipe.get().getResultItem(level.registryAccess()))) {
                result = recipe.get().assemble(craftingContainer, level.registryAccess());
            }
            resultContainer.setItem(0, result);
            // Use the menu's containerId and getStateId()
            serverPlayer.connection.send(new ClientboundContainerSetSlotPacket(
                    this.containerId,  // Use the menu's ID
                    this.getStateId(), // Use the menu's state ID
                    0,
                    result
            ));
        }
    }

    private boolean isAllowed(ItemStack stack) {
        return stack.getItem() == Items.STICK || stack.getItem() == Items.OAK_PLANKS;
    }
}