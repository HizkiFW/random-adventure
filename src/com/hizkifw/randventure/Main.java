/**
 * RandVenture - A randomly-generated text-based adventure RPG
 * <p>
 * Copyright 2016 Hizkia Felix
 */
package com.hizkifw.randventure;

import com.hizkifw.randventure.ConsoleDisplay.Scene;
import com.hizkifw.randventure.game.Player;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public static CurrentState state;

	public static void main(String[] args) {
		// Initialize game state
		state = new CurrentState();
		state.player = new Player();
		state.currentPlace = new Place("Hometown", new Coordinate(0, 0));
		state.map = new Map(state.currentPlace);
		Story start = new Story(Story.StoryType.FILLER);
		state.story = new StoryChain(start);
		state.currentScene = Scene.MENU;

		// Save initialized state to file (for debugging purposes)
		try {
			SaveLoad.saveObject(state, "new.ser");
		} catch(Exception e) {
			e.printStackTrace();
		}

		// Start game loop
		while(true) {
			drawCurrentScene();
		}
	}

	public static void drawCurrentScene() {
		if(state.currentScene == Scene.STORY)
			generateStory();

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
					if(state.currentScene == Scene.MENU)
						state.currentScene = Scene.STORY;

					ConsoleDisplay.input("Save file loaded.");
				} catch(Exception e) {
					ConsoleDisplay.input("Unable to load file.");
					e.printStackTrace();
				}
			}
		} else if(state.currentScene == Scene.STORY) {

		}
	}

	public static void generateStory() {
		float rand = ThreadLocalRandom.current().nextFloat();
		Story story;
		if(rand < 0.05f)
			story = new Story(Story.StoryType.MAJOR_CONFLICT);
		else if(rand < 0.25f)
			story = new Story(Story.StoryType.MINOR_CONFLICT);
		else
			story = new Story(Story.StoryType.INTERACTION);

		state.story.stories.add(story);
	}
}
