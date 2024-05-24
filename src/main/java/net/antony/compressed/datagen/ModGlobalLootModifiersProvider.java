package net.antony.compressed.datagen;

import net.antony.compressed.Compressed;
import net.antony.compressed.item.ModItems;
import net.antony.compressed.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Compressed.MODID);
    }

    @Override
    protected void start() {
        //blocks
        add("compressed_iron_from_block", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_BLOCK).build(),
                LootItemRandomChanceCondition.randomChance(0.005f).build()}, ModItems.COMPRESSED_IRON.get()));

        add("compressed_diamond_from_block", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIAMOND_BLOCK).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_gold_from_block", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_BLOCK).build(),
                LootItemRandomChanceCondition.randomChance(0.01f).build()}, ModItems.COMPRESSED_GOLD.get()));

        add("compressed_netherite_from_block", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.IRON_BLOCK).build(),
                LootItemRandomChanceCondition.randomChance(0.0005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));




        //chests for netherite
        add("compressed_netherite_from_bastion", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.07f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_ancient_city", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.015f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_end_city", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.07f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_stronghold", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_library")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.COMPRESSED_NETHERITE.get()));




        //chests for diamond
        add("compressed_diamond_from_bastion", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_ancient_city", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.07f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_end_city", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_stronghold", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_library")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()}, ModItems.COMPRESSED_DIAMOND.get()));




        //entities for netherite
        add("compressed_netherite_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.00005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(0.00005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(0.00005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_spider", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(0.00005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_enderman", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/enderman")).build(),
                LootItemRandomChanceCondition.randomChance(0.00005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));

        add("compressed_netherite_from_zombified_piglin", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombified_piglin")).build(),
                LootItemRandomChanceCondition.randomChance(0.00005f).build()}, ModItems.COMPRESSED_NETHERITE.get()));



        //entities for diamond
        add("compressed_diamond_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.0002f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(0.0002f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(0.0002f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_spider", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(0.0002f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_enderman", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/enderman")).build(),
                LootItemRandomChanceCondition.randomChance(0.0002f).build()}, ModItems.COMPRESSED_DIAMOND.get()));

        add("compressed_diamond_from_zombified_piglin", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombified_piglin")).build(),
                LootItemRandomChanceCondition.randomChance(0.0002f).build()}, ModItems.COMPRESSED_DIAMOND.get()));



        //entities for iron
        add("compressed_iron_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_IRON.get()));

        add("compressed_iron_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_IRON.get()));

        add("compressed_iron_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_IRON.get()));

        add("compressed_iron_from_spider", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_IRON.get()));

        add("compressed_iron_from_enderman", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/enderman")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_IRON.get()));

        add("compressed_iron_from_zombified_piglin", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombified_piglin")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_IRON.get()));


        //entities for gold
        add("compressed_gold_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_GOLD.get()));

        add("compressed_gold_from_skeleton", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/skeleton")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_GOLD.get()));

        add("compressed_gold_from_creeper", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_GOLD.get()));

        add("compressed_gold_from_spider", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/spider")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_GOLD.get()));

        add("compressed_gold_from_enderman", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/enderman")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_GOLD.get()));

        add("compressed_gold_from_zombified_piglin", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombified_piglin")).build(),
                LootItemRandomChanceCondition.randomChance(0.001f).build()}, ModItems.COMPRESSED_GOLD.get()));
    }
}

