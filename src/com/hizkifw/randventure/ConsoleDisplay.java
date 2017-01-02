package com.hizkifw.randventure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleDisplay {
	public static final int WIDTH = 80;
	public static String printBuffer = "";

	public static String centerText(String text) {
		return generateSequence(" ", (int) Math.floor(WIDTH / 2 - text.length() / 2)) + text;
	}

	;

	public static String generateSequence(String chr, int n) {
		String retval = "";
		for(int i = 0; i < n; i++) {
			retval += chr;
		}
		return retval;
	}

	public static String input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch(Exception e) {
			e.printStackTrace();

			// Just exit. You can't play a game without inputs.
			System.exit(1);
		}
		//return System.console().readLine();
		return null;
	}

	public static String input(String prompt) {
		System.out.print(prompt);
		//return System.console().readLine();
		return input();
	}

	public static void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void slowprint(String text, long interval) throws InterruptedException {
		String[] chars = text.split("");
		for(int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
			Thread.sleep(interval);
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
				for(String filename : saveFiles) {
					println("   - " + filename);
				}
				println("");
				println(" [ x ] Cancel");
				println("");
				break;

			case STORY:
				println("");
				println(centerText("[ STORY MODE ]"));
				println("");
				flush();

				Story currentStory = Main.state.story.stories.get(Main.state.story.stories.size() - 1);

				while(true) {
					Tuple<String, Integer> narrative = currentStory.narration.getNext();
					if(narrative == null) break;

					try {
						slowprint(narrative.x, narrative.y);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				println("");
				break;

			case MAP:

				break;

			default:
				break;
		}

		flush();
	}

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
	}
}
