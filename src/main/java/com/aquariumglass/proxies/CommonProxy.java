package com.aquariumglass.proxies;

import com.aquariumglass.tileentity.TileEntityAquariumGlass;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class CommonProxy {

	
public void registerRenderers()
	{
		TileEntitySpecialRenderer render;
	}
	
public void registerTileEntitySpecialRenderer()
	{
	
	}
public static void registerTileEntities()
{
    GameRegistry.registerTileEntity(TileEntityAquariumGlass.class, "AquariumGlass");
}
}
