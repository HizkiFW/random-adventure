package com.hizkifw.randventure;

import java.io.IOException;

public class ConsoleDisplay {
	public static String printBuffer = "";
	public static final int WIDTH = 80;
	public static enum Scene {
		TITLE,
		MENU,
		INVENTORY,
		SHOP,
		MAP,
		BATTLE
	};
	
	public static String centerText(String text) {
		return generateSequence(" ", (int) Math.floor(WIDTH/2 - text.length()/2)) +  text;
	}
	public static String generateSequence(String chr, int n) {
		String retval = "";
		for(int i = 0; i < n; i++) {
			retval += chr;
		}
		return retval;
	}
	
	public static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	public static void print(String text) {
		printBuffer += text;
	}
	public static void println(String text) {
		printBuffer += text + "\n";
	}
	public static void flush() {
		System.out.print(printBuffer);
		printBuffer = "";
	}
	public static void printOut(Scene s) {
		clearConsole();
		println(generateSequence("-", WIDTH));
		println(centerText("Random Adventure"));
		println(generateSequence("-", WIDTH));
		
		switch(s) {
		case TITLE:
			break;
			
		case MENU:
			
			break;
			
		default:
			break;
		}
		
		flush();
	}
}
