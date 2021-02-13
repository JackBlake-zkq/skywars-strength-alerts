package com.zkq.SkyWarsKillAlert;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Command3 extends CommandBase {
	
	private static String color = FileManager.getColor();
	
	@Override
	public int getRequiredPermissionLevel() {
	    return 0;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(params[0]);
		if(params[0].length() == 6 && !m.find()) {
			color = params[0];
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Color set to " + color));
		} else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid Color Hex - Must be 6 characters long and contain no special characters or spaces"));
		}
		FileManager.setColor(color);
		FileManager.save();
	}
	
	@Override
	public String getCommandName() {
		return "swkasetcolor";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
	return "swkasetcolor <color hex>";
	}
}
