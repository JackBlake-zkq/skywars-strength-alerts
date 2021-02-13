package com.zkq.SkyWarsKillAlert;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.command.NumberInvalidException;


public class GuiNotif extends Gui {
	
    private FontRenderer fontRenderer;
    private ScaledResolution scaled;
    
    public GuiNotif(Minecraft minecraft, String player, int i) {
    	fontRenderer = minecraft.fontRendererObj;
	    scaled = new ScaledResolution(minecraft);
	    if(FileManager.getColor().equals("chroma")) {
	    	drawString(fontRenderer, player, (int)(FileManager.getXPos() * scaled.getScaledWidth()), (int)((1-FileManager.getYPos())*scaled.getScaledHeight()) - i*12, Integer.parseInt(RenderGuiHandler.getCurrentChromaHex(), 16));
	    } else {
	    	drawString(fontRenderer, player, (int)(FileManager.getXPos() * scaled.getScaledWidth()), (int)((1-FileManager.getYPos())*scaled.getScaledHeight()) - i*12, Integer.parseInt(FileManager.getColor(), 16));
	    }
    } 
}

