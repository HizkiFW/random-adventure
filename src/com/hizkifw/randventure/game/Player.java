package com.hizkifw.randventure.game;

import com.hizkifw.randventure.game.enemy.Enemy;

public abstract class Player extends LivingEntity {
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
