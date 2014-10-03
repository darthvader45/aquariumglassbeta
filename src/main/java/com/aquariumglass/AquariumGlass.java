package com.aquariumglass;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.aquariumglass.blocks.BlockAquariumGlass;
import com.aquariumglass.blocks.BlockElectricFence;
import com.aquariumglass.proxies.CommonProxy;



import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
//import cpw.mods.fml.common.Mod.PreInit;    // used in 1.5.2
//import cpw.mods.fml.common.Mod.Init;       // used in 1.5.2
//import cpw.mods.fml.common.Mod.PostInit;   // used in 1.5.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7

@Mod(modid="aquariumglass", name="Aquarium Glass", version="1.0.0")
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class AquariumGlass {
public static Block aquariumGlass;
public static Block electricFence;
public static CreativeTabs aquariumTab;
        // The instance of your mod that Forge uses.
        @Instance(value = "aquariumglass")
        public static AquariumGlass instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.aquariumglass.proxies.ClientProxy", serverSide="com.aquariumglass.proxies.CommonProxy")
        public static CommonProxy aquarProxy;
        public static String modid = "aquariumglass";
        
        @EventHandler // used in 1.6.2
        
        public void preInit(FMLPreInitializationEvent event) {
        	aquariumTab = new CreativeTabs("AquariumGlass"){
        		@SideOnly(Side.CLIENT)
        		public Item getTabIconItem() {
        			
        			return Item.getItemFromBlock(AquariumGlass.aquariumGlass);
        		}

        	};
        	aquariumGlass = new BlockAquariumGlass().setBlockName("aquarglass").setBlockTextureName(this.modid +":" + "aquarglass2");
        	electricFence = new BlockElectricFence(this.modid + ":" + "electricfence", Material.iron);
        	
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
        	aquarProxy.registerRenderers();
        	aquarProxy.registerTileEntities();
                GameRegistry.registerBlock(aquariumGlass, "AquariumGlass");
				GameRegistry.registerBlock(electricFence, "ElectricFence");
				
        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}