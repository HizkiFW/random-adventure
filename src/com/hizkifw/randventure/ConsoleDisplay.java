package com.hizkifw.randventure;

import java.io.IOException;
import java.util.List;

public class ConsoleDisplay {
	public static String printBuffer = "";
	public static final int WIDTH = 80;
	public static enum Scene {
		TITLE,
		MENU,
		LOAD_GAME,
		SAVE_GAME,
		STORY,
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
	
	public static String input() {
		return System.console().readLine();
	}
	public static String input(String prompt) {
		System.out.print(prompt);
		return System.console().readLine();
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
			println("");
			println(" Menu");
			println(" [ 1 ] New Game");
			println(" [ 2 ] Load saved");
			println("");
			println(" [ x ] Exit");
			println("");
			break;
			
		case LOAD_GAME:
			println("");
			println(" Saves:");
			List<String> saveFiles = SaveLoad.listFiles();
			for(String filename:saveFiles) {
				println("   - " + filename);
			}
			println("");
			println(" [ x ] Cancel");
			println("");
			break;
			
		case MAP:
			
			break;
			
		default:
			break;
		}
		
		flush();
	}
}
