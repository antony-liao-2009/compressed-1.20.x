package net.antony.compressed.datagen;

import net.antony.compressed.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
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
                .parent(root)
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
                .parent(root)
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
                .rewards(AdvancementRewards.Builder.experience(2000))
                .addCriterion("get_cmp_netherite",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE.get()))
                .save(saver, new ResourceLocation("compressed","get_cmp_netherite"), existingFileHelper);

        Advancement is_this_useful = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.COMPRESSED_GOLD.get(),
                        Component.translatable("advancement.compressed.is_this_useful.title"),
                        Component.translatable("advancement.compressed.is_this_useful.desc"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        true
                )
                .addCriterion("get_cmp_gold",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD.get()))
                .save(saver, new ResourceLocation("compressed","get_cmp_gold"), existingFileHelper);






        Advancement level1_or_100 = Advancement.Builder.advancement()
                .parent(first_things_first)
                .display(
                        ModItems.COMPRESSED_IRON_SWORD.get(),
                        Component.translatable("advancement.compressed.level1_or_100.title"),
                        Component.translatable("advancement.compressed.level1_or_100.desc"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cmp_iron_ta",InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(
                                ModItems.COMPRESSED_IRON_SWORD.get(),
                                ModItems.COMPRESSED_IRON_AXE.get(),
                                ModItems.COMPRESSED_IRON_BOOTS.get(),
                                ModItems.COMPRESSED_IRON_SHOVEL.get(),
                                ModItems.COMPRESSED_IRON_HOE.get(),
                                ModItems.COMPRESSED_IRON_HELMET.get(),
                                ModItems.COMPRESSED_IRON_PICKAXE.get(),
                                ModItems.COMPRESSED_IRON_CHESTPLATE.get(),
                                ModItems.COMPRESSED_IRON_LEGGINGS.get()
                        ).build()))
                .save(saver, new ResourceLocation("compressed","get_cmp_iron_ta"), existingFileHelper);


        Advancement stronger_than_netherite = Advancement.Builder.advancement()
                .parent(compressed_diamonds)
                .display(
                        ModItems.COMPRESSED_DIAMOND_SWORD.get(),
                        Component.translatable("advancement.compressed.stronger_than_netherite.title"),
                        Component.translatable("advancement.compressed.stronger_than_netherite.desc"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cmp_diamond_ta",InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(
                                ModItems.COMPRESSED_DIAMOND_SWORD.get(),
                                ModItems.COMPRESSED_DIAMOND_AXE.get(),
                                ModItems.COMPRESSED_DIAMOND_BOOTS.get(),
                                ModItems.COMPRESSED_DIAMOND_SHOVEL.get(),
                                ModItems.COMPRESSED_DIAMOND_HOE.get(),
                                ModItems.COMPRESSED_DIAMOND_HELMET.get(),
                                ModItems.COMPRESSED_DIAMOND_PICKAXE.get(),
                                ModItems.COMPRESSED_DIAMOND_CHESTPLATE.get(),
                                ModItems.COMPRESSED_DIAMOND_LEGGINGS.get()
                        ).build()))
                .save(saver, new ResourceLocation("compressed","get_cmp_diamond_ta"), existingFileHelper);


        Advancement demigod = Advancement.Builder.advancement()
                .parent(ultimate_building_blocks)
                .display(
                        ModItems.COMPRESSED_NETHERITE_SWORD.get(),
                        Component.translatable("advancement.compressed.demigod.title"),
                        Component.translatable("advancement.compressed.demigod.desc"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cmp_netherite_ta",InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(
                                ModItems.COMPRESSED_NETHERITE_SWORD.get(),
                                ModItems.COMPRESSED_NETHERITE_AXE.get(),
                                ModItems.COMPRESSED_NETHERITE_BOOTS.get(),
                                ModItems.COMPRESSED_NETHERITE_SHOVEL.get(),
                                ModItems.COMPRESSED_NETHERITE_HOE.get(),
                                ModItems.COMPRESSED_NETHERITE_HELMET.get(),
                                ModItems.COMPRESSED_NETHERITE_PICKAXE.get(),
                                ModItems.COMPRESSED_NETHERITE_CHESTPLATE.get(),
                                ModItems.COMPRESSED_NETHERITE_LEGGINGS.get()
                        ).build()))
                .save(saver, new ResourceLocation("compressed","get_cmp_netherite_ta"), existingFileHelper);




        Advancement that_is_expensive = Advancement.Builder.advancement()
                .parent(level1_or_100)
                .display(
                        ModItems.COMPRESSED_IRON_SWORD.get(),
                        Component.translatable("advancement.compressed.that_is_expensive.title"),
                        Component.translatable("advancement.compressed.that_is_expensive.desc"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .addCriterion("sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_SWORD.get()))
                .addCriterion("axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_AXE.get()))
                .addCriterion("shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_SHOVEL.get()))
                .addCriterion("pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_PICKAXE.get()))
                .addCriterion("hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_HOE.get()))
                .addCriterion("helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_HELMET.get()))
                .addCriterion("chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_CHESTPLATE.get()))
                .addCriterion("leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_LEGGINGS.get()))
                .addCriterion("boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_IRON_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(5000))
                .save(saver, new ResourceLocation("compressed","all_cmp_iron"), existingFileHelper);


        Advancement absolutely_op = Advancement.Builder.advancement()
                .parent(stronger_than_netherite)
                .display(
                        ModItems.COMPRESSED_DIAMOND_SWORD.get(),
                        Component.translatable("advancement.compressed.absolutely_op.title"),
                        Component.translatable("advancement.compressed.absolutely_op.desc"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .addCriterion("sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_SWORD.get()))
                .addCriterion("axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_AXE.get()))
                .addCriterion("shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_SHOVEL.get()))
                .addCriterion("pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_PICKAXE.get()))
                .addCriterion("hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_HOE.get()))
                .addCriterion("helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_HELMET.get()))
                .addCriterion("chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_CHESTPLATE.get()))
                .addCriterion("leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_LEGGINGS.get()))
                .addCriterion("boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_DIAMOND_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(10000))
                .save(saver, new ResourceLocation("compressed","all_cmp_diamond"), existingFileHelper);


        Advancement game_over = Advancement.Builder.advancement()
                .parent(demigod)
                .display(
                        ModItems.COMPRESSED_NETHERITE_SWORD.get(),
                        Component.translatable("advancement.game_over.title"),
                        Component.translatable("advancement.game_over.desc"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        false
                )
                .addCriterion("sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_SWORD.get()))
                .addCriterion("axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_AXE.get()))
                .addCriterion("shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_SHOVEL.get()))
                .addCriterion("pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_PICKAXE.get()))
                .addCriterion("hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_HOE.get()))
                .addCriterion("helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_HELMET.get()))
                .addCriterion("chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_CHESTPLATE.get()))
                .addCriterion("leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_LEGGINGS.get()))
                .addCriterion("boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_NETHERITE_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(25000))
                .save(saver, new ResourceLocation("compressed","all_cmp_netherite"), existingFileHelper);


        Advancement useless = Advancement.Builder.advancement()
                .parent(is_this_useful)
                .display(
                        ModItems.COMPRESSED_GOLD_SWORD.get(),
                        Component.translatable("advancement.useless.title"),
                        Component.translatable("advancement.useless.desc"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .addCriterion("sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_SWORD.get()))
                .addCriterion("axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_AXE.get()))
                .addCriterion("shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_SHOVEL.get()))
                .addCriterion("pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_PICKAXE.get()))
                .addCriterion("hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_HOE.get()))
                .addCriterion("helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_HELMET.get()))
                .addCriterion("chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_CHESTPLATE.get()))
                .addCriterion("leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_LEGGINGS.get()))
                .addCriterion("boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.COMPRESSED_GOLD_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .rewards(AdvancementRewards.Builder.experience(-1000))
                .save(saver, new ResourceLocation("compressed","all_cmp_gold"), existingFileHelper);



        Advancement what_is_it_used_for = Advancement.Builder.advancement()
                .parent(game_over)
                .display(
                        ModItems.SOUL_CATALYST.get(),
                        Component.translatable("advancement.compressed.what_is_it_used_for.title"),
                        Component.translatable("advancement.compressed.what_is_it_used_for.desc"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false
                )
                .addCriterion("get_cata",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOUL_CATALYST.get()))
                .save(saver, new ResourceLocation("compressed","get_cata"), existingFileHelper);

        Advancement invincibility = Advancement.Builder.advancement()
                .parent(what_is_it_used_for)
                .display(
                        ModItems.SOUL_DRINKER.get(),
                        Component.translatable("advancement.compressed.invincibility.title"),
                        Component.translatable("advancement.compressed.invincibility.desc"),
                        null,
                        FrameType.CHALLENGE,
                        true,
                        true,
                        true
                )
                .rewards(AdvancementRewards.Builder.experience(100000))
                .addCriterion("get_soul",InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.SOUL_DRINKER.get()))
                .save(saver, new ResourceLocation("compressed","get_soul"), existingFileHelper);
    }
}
