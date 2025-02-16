package net.antony.compressed.events;

import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "compressed", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerLoginEventHandler {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer serverPlayer)) {
            return;
        }
        // Specify your advancement ID (namespace and path)
        ResourceLocation advancementId = new ResourceLocation("compressed", "compressed_root_advancement");
        Advancement advancement = serverPlayer.server.getAdvancements().getAdvancement(advancementId);
        if (advancement != null) {
            // Award the advancement to the player.
            // Make sure "tick" matches the criterion name defined in your advancement JSON.
            serverPlayer.getAdvancements().award(advancement, "tick");
        }
    }
}