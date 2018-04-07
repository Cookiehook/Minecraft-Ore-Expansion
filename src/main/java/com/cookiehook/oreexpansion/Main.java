package com.cookiehook.oreexpansion;

import com.cookiehook.oreexpansion.init.ModBlocks;
import com.cookiehook.oreexpansion.util.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, useMetadata = true)
public class Main {

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.register();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
