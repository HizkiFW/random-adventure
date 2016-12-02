package com.hizkifw.randventure.game.enemy;

public class Slime extends Enemy {
	public Slime() {
		this.name = "Slime";
		this.difficulty = 1;
		this.isPhysical = true;
		this.healthMax = 2;
		this.health = 2;
		this.attack = 1;
		this.defense = 0;
		this.speed = 1;
	}
}
