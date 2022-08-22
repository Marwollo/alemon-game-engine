package com.vukmarkovic.alemon.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

import com.vukmarkovic.alemon.game.base.Actor;
import com.vukmarkovic.alemon.game.base.Animation;
import com.vukmarkovic.alemon.game.base.interfaces.Movable.Direction;
import com.vukmarkovic.alemon.game.builders.SpriteBuilder;
import com.vukmarkovic.alemon.game.engines.ControlledMovementEngine;
import com.vukmarkovic.alemon.utils.GameManager;
import com.vukmarkovic.alemon.utils.LevelManager;

@SuppressWarnings("serial")
public class Game extends JPanel {
	
	private GameManager game;
	private LevelManager levelManager = new LevelManager();
	
	public Game(GameManager game) {
		this.game = game;
		
		this.setSize(GameManager.getFrameWidth(), GameManager.getFrameHeight());
		this.setVisible(true);
		this.setFocusable(true);
		this.initializeLevels();
	}
	
	public void initializeLevels() {
		this.levelManager.addLevel("debug_level", new Level(game));
		
		ArrayList<String> spriteSheet = new ArrayList<>();
		for (int i = 1; i <= 15; i++) {
			spriteSheet.add("/debug_character/Walk (" + String.valueOf(i) + ").png");
		}
		
		this.levelManager.getLevel("debug_level")
						 .addActor("debug_character", Actor.from(new SpriteBuilder()
									.addAnimation("idle", new Animation(spriteSheet))
									.setAnimation("idle")
									.setWidth(120)
									.setHeight(100)
									.setPositionX(20)
									.setPositionY(20)
									.build()));
		
		this.levelManager.setCurrentLevel("debug_level");
		
		ControlledMovementEngine controlledMovementEngine = new ControlledMovementEngine(this, 
				this.levelManager
					.getCurrentLevel()
					.getActor("debug_character"));
		this.game.getControlsManager().subscribers.add(controlledMovementEngine);
		
		this.levelManager.getCurrentLevel().getActor("debug_character").playAnimation();
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		Graphics2D graphics2D = (Graphics2D) graphics;
		
		graphics2D.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		this.levelManager.getCurrentLevel().paint(graphics2D);
		this.castListener("always");
	}
	
	public Level getCurrentLevel() {
		return this.levelManager.getCurrentLevel();
	}
	
	public void castListener(String listener) {
		this.levelManager.getCurrentLevel().getEventManager().runListener("always");
		this.repaint();
	}
}
