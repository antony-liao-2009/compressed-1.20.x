package net.antony.compressed.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.antony.compressed.Compressed;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CompressedCraftingTableScreen extends AbstractContainerScreen<CompressedCraftingTableMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Compressed.MODID, "textures/gui/compressed_crafting_table_gui.png");
    public CompressedCraftingTableScreen(CompressedCraftingTableMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        int x = (width - imageWidth)/2;
        int y = (height - imageHeight)/2;

        guiGraphics.blit(TEXTURE,x,y,0,0,imageWidth,imageHeight);

        renderProgressArrow(guiGraphics,x,y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y){
        if (menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x+85,y+30,176,0,menu.getScaledProgress(), 8); //change values here. Renders the arrow
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mousex, int mousey, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mousex, mousey, delta);
        renderTooltip(guiGraphics, mousex, mousey);
    }
}
