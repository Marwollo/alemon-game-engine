package com.vukmarkovic.alemon.utils;

import com.vukmarkovic.alemon.game.Level;
import java.util.HashMap;



public class LevelManager {
	private HashMap<String, Level> levels = new HashMap<>();
	private String currentLevel;
	
	public void setCurrentLevel(String name) {
		this.currentLevel = name;
	}
	
	public Level getLevel(String name) {
		return levels.get(name);
	}
	
	public Level getCurrentLevel() {
		return levels.get(currentLevel);
	}
	
	public void addLevel(String identifier, Level level) {
		levels.put(identifier, level);
	}
}
