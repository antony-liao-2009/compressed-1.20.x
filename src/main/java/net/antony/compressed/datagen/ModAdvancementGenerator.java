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
                        Component.translatable("advancement.compressed.root.title"),    // Title
                        Component.translatable("advancement.compressed.root.desc"), // Description
                        new ResourceLocation("compressed","textures/block/compressed_diamond_block.png"),                                       // Background image (null if not used)
                        FrameType.TASK,                             // Frame type (TASK, GOAL, or CHALLENGE)
                        true,                                       // Show toast?
                        false,                                       // Announce in chat?
                        false                                       // Hidden?
                )

                .addCriterion("tick",   new ImpossibleTrigger.TriggerInstance())

                // Notice we now pass the advancement ID as a string (the path part) plus the existingFileHelper.
                .save(saver, new ResourceLocation("compressed","compressed_root_advancement"), existingFileHelper);


        Advancement first_things_first = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.COMPRESSED_IRON.get(),
                        Component.translatable("advancement.compressed.first_things_first.title"),
                        Component.translatable("advancement.compressed.first_things_first.desc"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cmp_iron",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON.get()))
                .save(saver, new ResourceLocation("compressed","get_cmp_iron"), existingFileHelper);

        Advancement compressed_diamonds = Advancement.Builder.advancement()
                .parent(first_things_first)
                .display(
                        ModItems.COMPRESSED_DIAMOND.get(),
                        Component.translatable("advancement.compressed.compressed_diamonds.title"),
                        Component.translatable("advancement.compressed.compressed_diamonds.desc"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cmp_diamond",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND.get()))
                .save(saver, new ResourceLocation("compressed","get_cmp_diamond"), existingFileHelper);

        Advancement ultimate_building_blocks = Advancement.Builder.advancement()
                .parent(compressed_diamonds)
                .display(
                        ModItems.COMPRESSED_NETHERITE.get(),
                        Component.translatable("advancement.compressed.ultimate_building_blocks.title"),
                        Component.translatable("advancement.compressed.ultimate_building_blocks.desc"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cmp_netherite",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE.get()))
                .save(saver, new ResourceLocation("compressed","get_cmp_netherite"), existingFileHelper);
    }
}
