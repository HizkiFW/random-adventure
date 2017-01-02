package com.hizkifw.randventure;

import java.util.ArrayList;
import java.util.List;

public class StoryChain {
	public List<Story> stories;

	public StoryChain(Story start) {
		stories = new ArrayList<>();
		stories.add(start);
	}

}
