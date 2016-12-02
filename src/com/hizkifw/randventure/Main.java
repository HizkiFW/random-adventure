/**
 * RandVenture - A randomly-generated text-based adventure RPG
 * 
 * Copyright 2016 Hizkia Felix
 */
package com.hizkifw.randventure;

import com.hizkifw.randventure.game.Player;

public class Main {
	public static void main(String[] args) {
		CurrentState.player = new Player();
		CurrentState.currentPlace = new Place("Hometown", new Coordinate(0, 0));
		CurrentState.map = new Map(CurrentState.currentPlace);
		
		ConsoleDisplay.printOut();
	}
}
