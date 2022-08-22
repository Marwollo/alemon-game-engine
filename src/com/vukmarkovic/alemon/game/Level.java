package com.vukmarkovic.alemon.game;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map.Entry;

import com.vukmarkovic.alemon.game.base.Actor;
import com.vukmarkovic.alemon.game.base.Sprite;
import com.vukmarkovic.alemon.utils.EventManager;
import com.vukmarkovic.alemon.utils.GameManager;

public class Level {
	private GameManager game;
	private EventManager eventManager;
	private HashMap<String, Sprite> sprites = new HashMap<>();
	private HashMap<String, Actor> actors = new HashMap<>();
	
	public Level(GameManager game) {
		this.game = game;
		this.eventManager = new EventManager();
	}
	
	public EventManager getEventManager() {
		return this.eventManager;
	}
	
	public void addSprite(String name, Sprite sprite) {
		sprites.put(name, sprite);
	}
	
	public Sprite getSprite(String name) {
		return this.sprites.get(name);
	}
	
	public void addActor(String name, Actor actor) {
		actors.put(name, actor);
	}
	
	public Actor getActor(String name) {
		return this.actors.get(name);
	}
	
	public void paint(Graphics2D graphics) {
		for (Entry<String, Sprite> sprite : sprites.entrySet()) {
			sprite.getValue().paint(graphics);
		}
		for (Entry<String, Actor> actor : actors.entrySet()) {
			actor.getValue().paint(graphics);
		}
	}
}
