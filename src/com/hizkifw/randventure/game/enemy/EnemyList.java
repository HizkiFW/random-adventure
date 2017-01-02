package com.hizkifw.randventure.game.enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyList {
	public List<List<Class<?>>> list;

	public EnemyList() {
		list = new ArrayList<>();

		List<Class<?>> l = new ArrayList<Class<?>>();
		l.add(Slime.class);
		l.add(Rat.class);
		list.add(l);
	}

	public List<List<Class<?>>> listEnemies() {
		return list;
	}

	public List<Class<?>> listOnLevel(int level) {
		if(level > list.size()) return null;
		return list.get(level + 1);
	}
}
