package net.antony.compressed.datagen;

import net.antony.compressed.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {


    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        // Define a root advancement.
        Advancement root = Advancement.Builder.advancement()
                .display(
                        ModItems.COMPRESSED_DIAMOND.get(),                              // Icon
                        Component.literal("Compressed"),    // Title
                        Component.literal("Explore Compressed tools and armor!"), // Description
                        new ResourceLocation("compressed","textures/block/compressed_diamond_block.png"),                                       // Background image (null if not used)
                        FrameType.TASK,                             // Frame type (TASK, GOAL, or CHALLENGE)
                        true,                                       // Show toast?
                        false,                                       // Announce in chat?
                        false                                       // Hidden?
                )

                .addCriterion("tick",   new ImpossibleTrigger.TriggerInstance())

                // Notice we now pass the advancement ID as a string (the path part) plus the existingFileHelper.
                .save(saver, new ResourceLocation("compressed","compressed_root_advancement"), existingFileHelper);


    }
}
