package com.zkq.SkyWarsKillAlert;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.util.ChatComponentText;

public class Command4 extends CommandBase {
	

	private static double x = FileManager.getXPos();
	private static double y = FileManager.getYPos();
	
	@Override
	public int getRequiredPermissionLevel() {
	    return 0;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {
		if(parseDouble(params[0]) > 0 && parseDouble(params[0]) < 1) {
			x = (double)Math.round(parseDouble(params[0])*10) / 10;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("x position set to " + x + " of the width"));
		} else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid x position - please enter a number between 0 and 1, not inclusive"));
		}
		if(parseDouble(params[1]) > 0 && parseDouble(params[1]) < 1) {
			y = (double)Math.round(parseDouble(params[1])*10) / 10;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("y position set to " + y + " of the height"));
		} else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid y position - please enter a number between 0 and 1, not inclusive"));
		}
		FileManager.setXPos(x);
		FileManager.setYPos(y);
		FileManager.save();
	}
	
	@Override
	public String getCommandName() {
		return "swkasetpos";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
	return "swkasetpos <x> <y>";
	}
}