package com.zkq.SkyWarsKillAlert;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class Command5 extends CommandBase {
	
	private static double chromaSpeed = FileManager.getSpeed();
	
	@Override
	public int getRequiredPermissionLevel() {
	    return 0;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] params) throws CommandException {
		if(parseDouble(params[0]) > 0 && parseDouble(params[0]) < 1) {
			chromaSpeed = (double)Math.round(parseDouble(params[0])*10) / 10;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Chroma speed set to " + chromaSpeed));
		} else {
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid Speed - Enter a value between 0 and 1, not inclusive - anyting greather than 0.95 will round up to 1.0"));
		}
		FileManager.setSpeed(chromaSpeed);
		FileManager.save();
	}
	
	@Override
	public String getCommandName() {
		return "swkasetchromaspeed";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
	return "swkasetchromaspeed <speed>";
	}
}
