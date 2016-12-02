package com.hizkifw.randventure.game;

public class Player extends LivingEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5115881810693433148L;

	public String name = "Player";
	
	public int health = 100;
	public int healthMax = 100;
	public int speed = 10;
	public int attack = 10;
	public int defense = 10;
	public int xp = 0;
	public int level = 0;
	
	public float powerFactor = 0.5f;
}
