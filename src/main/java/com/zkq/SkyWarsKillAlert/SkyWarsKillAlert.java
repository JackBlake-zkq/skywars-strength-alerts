package com.zkq.SkyWarsKillAlert;

import java.io.IOException;

import com.zkq.SkyWarsKillAlert.proxy.CommonProxy;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_Name, version = Reference.VERSION, clientSideOnly = true)
public class SkyWarsKillAlert {
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance("Sky Wars Kill Alert")
	public static SkyWarsKillAlert instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {
		FileManager f = new FileManager();
	}
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
	    ClientCommandHandler.instance.registerCommand(new Command());
	    ClientCommandHandler.instance.registerCommand(new Command2());
	    ClientCommandHandler.instance.registerCommand(new Command3());
	    ClientCommandHandler.instance.registerCommand(new Command4());
	    ClientCommandHandler.instance.registerCommand(new Command5());
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
	}
}
