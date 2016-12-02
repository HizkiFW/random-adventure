package com.hizkifw.randventure;

import java.io.IOException;

public class ConsoleDisplay {
	public static final int WIDTH = 80;
	
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
	public static void printOut() {
		clearConsole();
		System.out.println(generateSequence("-", WIDTH));
		System.out.println(centerText("Random Adventure"));
		System.out.println(generateSequence("-", WIDTH));
		
	}
}
