/**
 * RandVenture - A randomly-generated text-based adventure RPG
 * 
 * Copyright 2016 Hizkia Felix
 */
package com.hizkifw.randventure;

import com.hizkifw.randventure.ConsoleDisplay.Scene;
import com.hizkifw.randventure.game.Player;

public class Main {
	public static CurrentState state;
	
	public static void main(String[] args) {
		state = new CurrentState();
		state.player = new Player();
		state.currentPlace = new Place("Hometown", new Coordinate(0, 0));
		state.map = new Map(state.currentPlace);
		
		state.currentScene = Scene.MENU;
		drawCurrentScene();
		
		try {
			//SaveLoad.saveObject(state, "D:/test.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void drawCurrentScene() {
		ConsoleDisplay.printOut(state.currentScene);
		String choice = ConsoleDisplay.input("> ");
		if(choice.equals("1"))
			state.currentScene = Scene.STORY;
		else if(state.equals("2"))
			state.currentScene = Scene.LOAD_GAME;
		else if(state.equals("x"))
			System.exit(0);
	}
}
