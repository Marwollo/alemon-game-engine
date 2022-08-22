package com.vukmarkovic.alemon.utils;

import javax.swing.*;

import com.vukmarkovic.alemon.game.Game;

public class GameManager {
	private static final String NAME = "Alemon";
	private static final String VERSION = "v0.1b";
	private static final int DEFAULT_FRAME_WIDTH = 800;
	private static final int DEFAULT_FRAME_HEIGHT = 600;
	
	private JFrame frame;
	private ControlsManager controlsManager = new ControlsManager();
	
	public GameManager() {
		 this.frame = new JFrame(GameManager.NAME + " " + GameManager.VERSION);
		 this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.frame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
		 this.frame.setVisible(true);
		 
		 Game game = new Game(this);
		 
		 this.frame.addKeyListener(controlsManager);
		 this.frame.add(game);
		 
		 this.frame.repaint();
	}
	
	public static int getFrameWidth() {
		return GameManager.DEFAULT_FRAME_WIDTH;
	}
	
	public static int getFrameHeight() {
		return GameManager.DEFAULT_FRAME_HEIGHT;
	}
	
	public ControlsManager getControlsManager() {
		return this.controlsManager;
	}
	
}
