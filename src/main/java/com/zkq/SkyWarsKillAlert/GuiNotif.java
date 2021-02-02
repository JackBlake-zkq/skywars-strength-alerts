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
    int num;
    
    public GuiNotif(Minecraft minecraft, String player, int i) throws NumberFormatException{
    	fontRenderer = minecraft.fontRendererObj;
	    scaled = new ScaledResolution(minecraft);
	    if(Command3.getColor().equals("chroma")) {
	    	drawString(fontRenderer, player, (int)(Command4.getX() * scaled.getScaledWidth()), (int)((1-Command4.getY())*scaled.getScaledHeight()) - i*12, Integer.parseInt(RenderGuiHandler.getCurrentChromaHex(), 16));
	    } else {
	    	drawString(fontRenderer, player, (int)(Command4.getX() * scaled.getScaledWidth()), (int)((1-Command4.getY())*scaled.getScaledHeight()) - i*12, Integer.parseInt(Command3.getColor(), 16));
	    }
	    
    } 
}

