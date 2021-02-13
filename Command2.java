package com.zkq.SkyWarsKillAlert;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class Command2 extends CommandBase {
	
	@Override
	public int getRequiredPermissionLevel() {
	    return 0;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {

		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("-----------------------swkahelp----------------------"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Commands: Note - Ranges are NOT INCLUSIVE"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("swkatoggle - Enables/Disables kill alersts, Enabled by default"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("swkasetcolor <hex> - Provide a color hex to set the colors of the alerts to, defaults to FF0000, or type chroma for chroma"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("swkasetpos <x> <y> - input the decimal proportion between 0 and 1.0 of screen dimensions to change the position, rounds to nearest tenth, defaults to 0.6 0.5"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("swkasetchromaspeed <speed> - input a decimal between 0 and 1.0 with 1 being the fastest, rounds to nearest tenth, defaults to 1.0, "));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("-----------------------------------------------------"));
	}
	
	@Override
	public String getCommandName() {
		return "swkahelp";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
	return "swkahelp";
	}
	
}
