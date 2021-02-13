package com.zkq.SkyWarsKillAlert;

import java.util.Scanner;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class Command extends CommandBase {
	
	Scanner scan = new Scanner("C:\\Users\\jblak\\AppData\\Roaming\\.minecraft\\config\\swka.txt");
	private static boolean status = FileManager.getAlertsEnabled();
	
	@Override
	public int getRequiredPermissionLevel() {
	    return 0;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {
		if(status) {
			status = false;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Kill Alerts Disabled"));
		} else {
			status = true;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Kill Alerts Enabled"));
		}
		FileManager.setAlertsEnabled(status);
		FileManager.save();
	}
	
	@Override
	public String getCommandName() {
		return "swkatoggle";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
	return "swkatoggle";
	}	
}

