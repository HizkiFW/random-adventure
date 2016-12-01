package com.hizkifw.randventure.game;

public abstract class LivingEntity {
	public String name;
	public int health;
	public int healthMax;
	public int attack;
	public int defense;
	public int speed;
	
	public boolean isDead() {
		return health <= 0;
	}
	
	public boolean attack(int power, LivingEntity target) {
		return target.getAttacked(power);
	}
	public boolean getAttacked(int damage) {
		if(damage > defense)
			health -= damage - defense;
		if(health < 0) health = 0;
		
		return health > 0;
	}
}
