package com.cookiehook.oreexpansion.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockNetherOre extends BlockBaseOre {

	public BlockNetherOre(Item dropItem, String blockName, int minDropAmount, int maxExtraDrops, int minXP, int maxXP) {
		super(dropItem, blockName, minDropAmount, maxExtraDrops, minXP, maxXP);
	}

	public BlockNetherOre(String blockName) {
		this(null, blockName, 1, 0, 0, 0);
	}

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side) {
		return true;
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
		super.harvestBlock(world, player, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
		System.out.println("BOOM");
	}

}
