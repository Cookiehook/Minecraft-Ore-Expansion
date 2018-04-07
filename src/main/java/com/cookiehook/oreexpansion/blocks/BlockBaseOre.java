package com.cookiehook.oreexpansion.blocks;

import java.util.Random;

import com.cookiehook.oreexpansion.util.Reference;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockBaseOre extends BlockOre {
	private Item dropItem;
	private int minDropAmount, maxExtraDrops;
	private int minXP, maxXP;

	public BlockBaseOre(String blockName) {
		this(null, blockName, 1, 0, 0, 0);
	}

	public BlockBaseOre(Item dropItem, String blockName, int minDropAmount, int maxExtraDrops, int minXP, int maxXP) {
		this.dropItem = dropItem;
		this.minDropAmount = minDropAmount;
		this.maxExtraDrops = maxExtraDrops;
		this.minXP = minXP;
		this.maxXP = maxXP;
		this.setBlockName(blockName).setBlockTextureName(Reference.MOD_ID + ":" + blockName);
		this.setHardness(3.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		if (dropItem == null)
			return Item.getItemFromBlock(this);
		return dropItem;
	}

	@Override
	public int quantityDropped(Random rand) {
		return minDropAmount + rand.nextInt(maxExtraDrops + 1);
	}

	@Override
	public int damageDropped(int metadata) {
		return dropItem == Items.dye ? 4 : 0;
	}

	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_) {
		Random rand = new Random();
		return MathHelper.getRandomIntegerInRange(rand, minXP, maxXP);
	}
}
