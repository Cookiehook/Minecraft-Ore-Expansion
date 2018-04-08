package com.cookiehook.oreexpansion.worldgen;

import java.util.Random;

import com.cookiehook.oreexpansion.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class ModOreGeneration implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		}

	}

	public void generateNether(World world, Random rand, int chunkX, int chunkZ) {
		generateOre(ModBlocks.nether_coal_ore, world, rand, chunkX, chunkZ, 2, 10, 20, 0, 128, Blocks.netherrack);
		generateOre(ModBlocks.nether_iron_ore, world, rand, chunkX, chunkZ, 4, 8, 20, 0, 128, Blocks.netherrack);
		generateOre(ModBlocks.nether_gold_ore, world, rand, chunkX, chunkZ, 4, 8, 2, 0, 128, Blocks.netherrack);
		generateOre(ModBlocks.nether_redstone_ore, world, rand, chunkX, chunkZ, 4, 8, 8, 0, 128, Blocks.netherrack);
		generateOre(ModBlocks.nether_lapis_ore, world, rand, chunkX, chunkZ, 2, 10, 1, 0, 128, Blocks.netherrack);
		generateOre(ModBlocks.nether_diamond_ore, world, rand, chunkX, chunkZ, 1, 8, 1, 0, 128, Blocks.netherrack);
		generateOre(ModBlocks.nether_emerald_ore, world, rand, chunkX, chunkZ, 1, 1, 1, 0, 128, Blocks.netherrack);
	}

	public void generateOverworld(World world, Random rand, int chunkX, int chunkZ) {
		generateOre(ModBlocks.overworld_quartz_ore, world, rand, chunkX, chunkZ, 4, 8, 8, 0, 64, Blocks.stone);
	}

	public void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
		generateOre(ModBlocks.end_coal_ore, world, rand, chunkX, chunkZ, 2, 10, 20, 0, 128, Blocks.end_stone);
		generateOre(ModBlocks.end_iron_ore, world, rand, chunkX, chunkZ, 4, 8, 20, 0, 128, Blocks.end_stone);
		generateOre(ModBlocks.end_gold_ore, world, rand, chunkX, chunkZ, 4, 8, 2, 0, 128, Blocks.end_stone);
		generateOre(ModBlocks.end_redstone_ore, world, rand, chunkX, chunkZ, 4, 8, 8, 0, 128, Blocks.end_stone);
		generateOre(ModBlocks.end_lapis_ore, world, rand, chunkX, chunkZ, 2, 10, 1, 0, 128, Blocks.end_stone);
		generateOre(ModBlocks.end_diamond_ore, world, rand, chunkX, chunkZ, 1, 8, 1, 0, 128, Blocks.end_stone);
		generateOre(ModBlocks.end_emerald_ore, world, rand, chunkX, chunkZ, 1, 1, 1, 0, 128, Blocks.end_stone);
	}

	public void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY,
			int maxY, Block generateIn) {
		int veinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize + 1);
		int heightRange = maxY - minY;
		WorldGenMinable generator = new WorldGenMinable(block, veinSize, generateIn);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, xRand, yRand, zRand);
		}
	}
}
