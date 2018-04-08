package com.cookiehook.oreexpansion.blocks;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.Explosion;
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
	public void harvestBlock(World world, EntityPlayer player, int posX, int posY, int posZ, int p_149636_6_) {
		super.harvestBlock(world, player, posX, posY, posZ, p_149636_6_);
		Random rand = new Random();
		if (!EnchantmentHelper.getSilkTouchModifier(player))
			world.newExplosion(null, posX + 0.5, posY + 0.5, posZ + 0.5, 1.5F, true, true);
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, int posX, int posY, int posZ, Explosion explosion) {
		super.onBlockDestroyedByExplosion(world, posX, posY, posZ, explosion);
		world.newExplosion(null, posX, posY, posZ, 1.5F, true, true);
	}

}
