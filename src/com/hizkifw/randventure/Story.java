package com.hizkifw.randventure;

import java.util.concurrent.ThreadLocalRandom;

public class Story {
	public boolean hasItems;
	public boolean hasEnemies;
	public boolean hasSavePoint;

	public boolean canGoNorth;
	public boolean canGoSouth;
	public boolean canGoEast;
	public boolean canGoWest;

	public Narration narration;

	public Story(StoryType type) {
		narration = new Narration();
		generateDirections();

		boolean canNavigate = true;
		switch(type) {
			case FILLER:
				narration.addText("Once upon a time...", 200);
				break;

			case INTERACTION:
				// TODO: Improve.
				if(hasItems)
					narration.addText("You found something [take].", 50);
				if(hasEnemies)
					narration.addText("You encounter some enemies [fight | flee].", 25);
				if(hasSavePoint)
					narration.addText("You see a save point [save].", 50);
				break;

			default:
				break;
		}

		if(canNavigate) {
			if(canGoNorth)
				narration.addText("You see a path towards the [north].", 50);
			if(canGoSouth)
				narration.addText("You see a path towards the [south].", 50);
			if(canGoEast)
				narration.addText("You see a path towards the [east].", 50);
			if(canGoWest)
				narration.addText("You see a path towards the [west].", 50);
		}
	}

	public void generateDirections() {
		canGoNorth = ThreadLocalRandom.current().nextInt(2) == 0;
		canGoSouth = ThreadLocalRandom.current().nextInt(2) == 0;
		canGoEast = ThreadLocalRandom.current().nextInt(2) == 0;
		canGoWest = ThreadLocalRandom.current().nextInt(2) == 0;
	}
	public void generateStuffs() {
		//TODO: Generate interaction stuff (items etc)

	}

	public static enum StoryType {
		FILLER,
		INTERACTION,
		MINOR_CONFLICT,
		MAJOR_CONFLICT
	}

	public static enum Choices {
		GO_NORTH,
		GO_SOUTH,
		GO_EAST,
		GO_WEST,

		TAKE_ITEM,
		USE_ITEM,
		DISCARD_ITEM,

		FIGHT,
		FLEE
	}
}
