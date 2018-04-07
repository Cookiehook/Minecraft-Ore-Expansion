package com.cookiehook.oreexpansion.init;

import com.cookiehook.oreexpansion.blocks.BlockEndOre;
import com.cookiehook.oreexpansion.blocks.BlockNetherOre;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;

public class ModBlocks {

	private static Block nether_coal_ore = new BlockNetherOre(Items.coal, "nether_coal_ore", 1, 0, 0, 2);
	private static Block nether_iron_ore = new BlockNetherOre("nether_iron_ore");
	private static Block nether_gold_ore = new BlockNetherOre("nether_gold_ore");
	private static Block nether_redstone_ore = new BlockNetherOre(Items.redstone, "nether_redstone_ore", 4, 1, 1, 5);
	private static Block nether_lapis_ore = new BlockNetherOre(Items.dye, "nether_lapis_ore", 4, 4, 2, 5);
	private static Block nether_diamond_ore = new BlockNetherOre(Items.diamond, "nether_diamond_ore", 1, 0, 3, 7);
	private static Block nether_emerald_ore = new BlockNetherOre(Items.emerald, "nether_emerald_ore", 1, 0, 3, 7);

	private static Block end_coal_ore = new BlockEndOre(Items.coal, "end_coal_ore", 1, 0, 0, 2);
	private static Block end_iron_ore = new BlockEndOre("end_iron_ore");
	private static Block end_gold_ore = new BlockEndOre("end_gold_ore");
	private static Block end_redstone_ore = new BlockEndOre(Items.redstone, "end_redstone_ore", 4, 1, 1, 5);
	private static Block end_lapis_ore = new BlockEndOre(Items.dye, "end_lapis_ore", 4, 4, 2, 5);
	private static Block end_diamond_ore = new BlockEndOre(Items.diamond, "end_diamond_ore", 1, 0, 3, 7);
	private static Block end_emerald_ore = new BlockEndOre(Items.emerald, "end_emerald_ore", 1, 0, 3, 7);
	
	private static Block end_quartz_ore = new BlockEndOre(Items.quartz, "end_quartz_ore", 1, 0, 2, 5);
	private static Block overworld_quartz_ore = new BlockEndOre(Items.quartz, "overworld_quartz_ore", 1, 0, 2, 5);

	public static void register() {
		GameRegistry.registerBlock(nether_coal_ore, nether_coal_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_iron_ore, nether_iron_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_gold_ore, nether_gold_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_redstone_ore, nether_redstone_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_lapis_ore, nether_lapis_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_diamond_ore, nether_diamond_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nether_emerald_ore, nether_emerald_ore.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(end_coal_ore, end_coal_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_iron_ore, end_iron_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_gold_ore, end_gold_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_redstone_ore, end_redstone_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_lapis_ore, end_lapis_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_diamond_ore, end_diamond_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_emerald_ore, end_emerald_ore.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(end_quartz_ore, end_quartz_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(overworld_quartz_ore, overworld_quartz_ore.getUnlocalizedName().substring(5));
	}
}
