package com.cookiehook.oreexpansion.blocks;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockNetherOre extends BlockEndOre {

	public BlockNetherOre(Item dropItem, String blockName, int minDropAmount, int maxExtraDrops, int minXP, int maxXP) {
		super(dropItem, blockName, minDropAmount, maxExtraDrops, minXP, maxXP);
	}

	public BlockNetherOre(String blockName) {
		this(null, blockName, 1, 1, 0, 0);
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
		return true;
	}

}
