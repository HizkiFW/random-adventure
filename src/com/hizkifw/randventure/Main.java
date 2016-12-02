/**
 * RandVenture - A randomly-generated text-based adventure RPG
 * 
 * Copyright 2016 Hizkia Felix
 */
package com.hizkifw.randventure;

import com.hizkifw.randventure.game.Player;

public class Main {
	public static CurrentState state;
	public static void main(String[] args) {
		state = new CurrentState();
		state.player = new Player();
		state.currentPlace = new Place("Hometown", new Coordinate(0, 0));
		state.map = new Map(state.currentPlace);
		
		ConsoleDisplay.printOut(ConsoleDisplay.Scene.TITLE);
		
		try {
			//SaveLoad.saveObject(state, "D:/test.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
