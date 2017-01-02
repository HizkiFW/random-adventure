package com.hizkifw.randventure;

import com.hizkifw.randventure.game.Player;

public class CurrentState implements java.io.Serializable {
	private static final long serialVersionUID = -1654027488775596379L;
	public ConsoleDisplay.Scene currentScene;
	public Player player;
	public Map map;
	public Place currentPlace;
	public StoryChain story;
}
