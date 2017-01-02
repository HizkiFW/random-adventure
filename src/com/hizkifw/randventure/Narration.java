package com.hizkifw.randventure;

import java.util.ArrayList;
import java.util.List;

public class Narration {
	public List<Tuple<String, Integer>> narrative;
	private int progress = -1;

	public Narration() {
		narrative = new ArrayList<>();
	}

	public void addText(String text, Integer duration) {
		narrative.add(new Tuple<String, Integer>(text, duration));
	}

	public void addPause() {
		narrative.add(new Tuple<String, Integer>(null, -1));
	}

	public Tuple<String, Integer> getNext() {
		progress++;
		if(progress > narrative.size() - 1) return null;
		return narrative.get(progress);
	}
}
