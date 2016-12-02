/**
 * Randomly generates enemies based on level difficulty
 */
package com.hizkifw.randventure.game;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.hizkifw.randventure.game.enemy.Enemy;
import com.hizkifw.randventure.game.enemy.EnemyList;

public class BattleGround {
	public List<Enemy> enemies = new ArrayList<>();
	
	public BattleGround(int difficulty) {
		double levelDifficulty = ThreadLocalRandom.current().nextInt(difficulty + 1);
		double n = Math.pow(2, Math.log(levelDifficulty));
		
		EnemyList el = new EnemyList();
		
		for(double i = 0; i < n; i++) {
			try {
				int enemyDifficulty = ThreadLocalRandom.current().nextInt(1, difficulty + 1);
				
				List<Class<?>> listLevel = el.listOnLevel(enemyDifficulty);
				Constructor<?> cEnemy = listLevel.get(ThreadLocalRandom.current().nextInt(listLevel.size()))
						.getConstructor();
				
				Enemy enemy = (Enemy) cEnemy.newInstance();
				enemies.add(enemy);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
