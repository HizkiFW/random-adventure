package com.hizkifw.randventure;

public class ConsoleDisplay {
	public static final int WIDTH = 80;
	
	public static String centerText(String text) {
		return String.format("%1$" + Math.floor(WIDTH/2 - text.length()/2) + "s", text);
	}
	public static String generateLine(String chr) {
		return String.format("%1$" + WIDTH + "s", chr).replace(" ", chr);
	}
	public static void printOut() {
		System.out.println(generateLine("-"));
		System.out.println(centerText("Random Adventure"));
	}
}
