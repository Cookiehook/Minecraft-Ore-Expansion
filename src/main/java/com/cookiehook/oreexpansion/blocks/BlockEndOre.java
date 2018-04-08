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

	/**
	 * When broken, with a 1/10 chance, teleport the player to a random safe location in a 16 * 16 * 16 area
	 * around the broken block.
	 */
	@Override
	public void harvestBlock(World world, EntityPlayer player, int posX, int posY, int posZ, int p_149636_6_) {
		super.harvestBlock(world, player, posX, posY, posZ, p_149636_6_);
		Random rand = new Random();
		if (rand.nextInt(100) > 90) {
			if (!world.isRemote) {
				boolean teleported = false;

				// Make 16 attempts to find a new X / Z location
				for (int i = 1; i <= 16; i++) {
					posX = posX + rand.nextInt(16) - 8;
					posZ = posZ + rand.nextInt(16) - 8;
					
					// For the chosen X / Z position, loop through Y -8 to Y + 8
					for (int j = posY - 8; j <= posY + 8; j++) {
						posY = j;
						Block groundBlock = world.getBlock(posX, posY - 1, posZ);
						Block footBlock = world.getBlock(posX, posY, posZ);
						Block headBlock = world.getBlock(posX, posY + 1, posZ);

						// Check that the chosen location is safe to teleport to
						if (groundBlock.isBlockNormalCube() && footBlock == Blocks.air && headBlock == Blocks.air) {
							player.setPositionAndUpdate(posX + 0.5, posY, posZ + 0.5);
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
