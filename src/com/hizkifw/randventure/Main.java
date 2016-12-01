package com.hizkifw.randventure;

public class Main {
	private static ConsoleDisplay display = null;
	
	public static void main(String[] args) {
		display = new ConsoleDisplay();
		display.printOut();
	}
}
