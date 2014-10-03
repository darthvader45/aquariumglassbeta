package com.aquariumglass.proxies;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.aquariumglass.AquariumGlass;
import com.aquariumglass.renderer.ItemRenderAquariumGlass;
import com.aquariumglass.renderer.RenderAquariumGlass;
import com.aquariumglass.tileentity.TileEntityAquariumGlass;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

public void registerRenderers(){
	//Aquarium Glass	
	TileEntitySpecialRenderer render = new RenderAquariumGlass();
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAquariumGlass.class, render);
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(AquariumGlass.aquariumGlass), new ItemRenderAquariumGlass(render, new TileEntityAquariumGlass()));
	}
	
public void registerTileEntitySpecialRenderer(){
	
}


public static void registerTileEntities()
{
    CommonProxy.registerTileEntities();
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAquariumGlass.class, new RenderAquariumGlass());
}
}
