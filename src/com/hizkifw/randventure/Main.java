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
		
		try {
			SaveLoad.saveObject(state, "new.ser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			drawCurrentScene();
		}
	}
	
	public static void drawCurrentScene() {
		ConsoleDisplay.printOut(state.currentScene);
		if(state.currentScene == Scene.MENU) {
			String choice = ConsoleDisplay.input("> ");
			if(choice.equals("1"))
				state.currentScene = Scene.STORY;
			else if(choice.equals("2"))
				state.currentScene = Scene.LOAD_GAME;
			else if(choice.equals("x"))
				System.exit(0);
		} else if(state.currentScene == Scene.LOAD_GAME) {
			String fname = ConsoleDisplay.input("File name> ");
			if(fname.equals("x"))
				state.currentScene = Scene.MENU;
			else {
				try {
					state = (CurrentState) SaveLoad.loadObject(fname);
					ConsoleDisplay.input("Save file loaded.");
				} catch(Exception e) {
					ConsoleDisplay.input("Unable to load file.");
				}
			}
		}
	}
}
