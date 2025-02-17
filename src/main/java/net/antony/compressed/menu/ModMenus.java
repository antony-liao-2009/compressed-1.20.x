package net.antony.compressed.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "compressed");

    public static final RegistryObject<MenuType<CustomCraftingMenu>> CUSTOM_CRAFTING_MENU = MENUS.register(
            "custom_crafting",
            () -> IForgeMenuType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new CustomCraftingMenu(windowId, inv, ContainerLevelAccess.create(inv.player.level(), pos));
            })
    );
}
