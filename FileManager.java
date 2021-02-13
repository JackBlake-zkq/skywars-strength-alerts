package com.zkq.SkyWarsKillAlert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class FileManager {

	private File conf;
	private FileWriter writer;
	private Scanner scan;
	private String data;
	private static boolean alertsEnabled;
	private static String col;
	private static double xPos;
	private static double yPos;
	private static double speed;
	
	public FileManager() throws IOException{
		conf = new File("config\\swka.txt");
		if (conf.createNewFile()) {
	      writer = new FileWriter("config\\swka.txt");
		  writer.write("alertsEnabled=T col=FF0000 xPos=0.6 yPos=0.5 chromaspeed=1.0");
		  writer.close();
	    } 
	    data = FileUtils.readFileToString(conf);
		if(data.substring(14, 15).equals("T")) {
			alertsEnabled = true;
		} else {
			alertsEnabled = false;
		}
		col = data.substring(20, 26);
		xPos = Double.parseDouble(data.substring(32, 35));
		yPos = Double.parseDouble(data.substring(41, 44));
		speed = Double.parseDouble(data.substring(57, 60));
	}
	public static boolean getAlertsEnabled() {
		return alertsEnabled;
	}
	public static String getColor() {
		return col;
	}
	public static double getXPos()  {
		return xPos;
	}
	public static double getYPos() {
		return yPos;
	}
	public static double getSpeed() {
		return speed;
	}
	public static void setAlertsEnabled(boolean x) {
		alertsEnabled = x;
	}
	public static void setColor(String x) {
		col = x;
	}
	public static void setXPos(double x) {
		xPos = x;
	}
	public static void setYPos(double x) {
		yPos = x;
	}
	public static void setSpeed(double x) {
		speed = x;
	}
	public static void save() {
		try {
			File f = new File("config\\swka.txt");
	        String converted;
	        if(alertsEnabled) {
	        	converted = "T";
	        } else {
	        	converted = "F";
	        }
	        FileUtils.writeStringToFile(f, "alertsEnabled=" + converted + " col=" + col + " xPos=" + String.valueOf(xPos) + " yPos=" + String.valueOf(yPos) + " chromaspeed=" + speed);
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
}
