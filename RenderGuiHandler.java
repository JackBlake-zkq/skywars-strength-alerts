package com.zkq.SkyWarsKillAlert;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.command.NumberInvalidException;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public class RenderGuiHandler {

	ArrayList<String> killers = new ArrayList<String>();
	private long renderTickCounter=0;
	private long renderTickCounter2=0;
	private static int r = 255;
	private static int g = 0;
	private static int b = 0;
	
	@SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
		//manage killers
		if(killers.size() > 0) {
			renderTickCounter++;
		}
		if(renderTickCounter != 0 && killers.size() > 0 && renderTickCounter % 1500 == 0) {
			killers.remove(killers.size()-1);
		}
		//render text
		if(FileManager.getAlertsEnabled()) {
			for(int i = 0; i<killers.size(); i++)
			{
				new GuiNotif(Minecraft.getMinecraft(), killers.get(i), i);
			}
		}
		//manage rgb
		renderTickCounter2++;
		if(renderTickCounter2 % ((long)(1 / FileManager.getSpeed())) == 0) {
			if(r == 255 && g < 255 && b == 0) {
				g++;
			}
			else if(r > 0 && g == 255 && b == 0) {
				r--;
			}
			else if(r == 0 && g == 255 && b < 255) {
				b++;
			}
			else if(r == 0 && g > 0 && b == 255) {
				g--;
			}
			else if(r < 255 && g == 0 && b == 255) {
				r++;
			}
			else if(r == 255 && g == 0 && b > 0) {
				b--;
			}
		}
		
    }
	
	@SubscribeEvent
	 public void onChat(final ClientChatReceivedEvent event) {
		Message m = new Message(event.message.getUnformattedText()); 
		if(m.isKill()) {
				 killers.add(0, m.getPlayer());
		 }
	 }
	
	public static String getCurrentChromaHex() {
		String hex = "";
		int[] arr = {(int)(r / 16),r%16,(int)(g / 16),g%16,(int)(b / 16),b%16};
		for (int x : arr) {
			if(x>=0 && x<=9) {
				hex+=String.valueOf(x);
			}
			else if(x==10) {
				hex+="A";
			}
			else if(x==11) {
				hex+="B";
			}
			else if(x==12) {
				hex+="C";
			}
			else if(x==13) {
				hex+="D";
			}
			else if(x==14) {
				hex+="E";
			}
			else if(x==15) {
				hex+="F";
			}
		}
		return hex;
	}
	
}
