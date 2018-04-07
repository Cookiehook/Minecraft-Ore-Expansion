package com.cookiehook.oreexpansion.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockEndOre extends BlockBaseOre {

	public BlockEndOre(Item dropItem, String blockName, int minDropAmount, int maxExtraDrops, int minXP, int maxXP) {
		super(dropItem, blockName, minDropAmount, maxExtraDrops, minXP, maxXP);
	}

	public BlockEndOre(String blockName) {
		this(null, blockName, 1, 0, 0, 0);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
		super.harvestBlock(world, player, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
		Random rand = new Random();

		if (rand.nextInt(100) > 90) {
			if (!world.isRemote) {
				boolean teleported = false;

				for (int i = 1; i <= 16; i++) {
					int posX = (int) player.posX;
					int posY = (int) player.posY;
					int posZ = (int) player.posZ;

					posX = posX + rand.nextInt(16) - 8;
					posZ = posZ + rand.nextInt(16) - 8;

					for (int j = posY - 8; j <= posY + 8; j++) {
						posY = j;
						Block groundBlock = world.getBlock(posX, posY - 1, posZ);
						Block footBlock = world.getBlock(posX, posY, posZ);
						Block headBlock = world.getBlock(posX, posY + 1, posZ);

						if (groundBlock.isBlockNormalCube() && footBlock == Blocks.air && headBlock == Blocks.air) {
							player.setPositionAndUpdate(posX, posY, posZ);
							world.playSoundAtEntity(player, "mob.endermen.portal", 1.0F, 1.0F);
							teleported = true;
							break;
						}
					}
					if (teleported)
						break;
				}
			}
		}
	}
}
