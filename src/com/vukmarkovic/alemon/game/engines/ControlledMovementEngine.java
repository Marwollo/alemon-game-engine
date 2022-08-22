package com.vukmarkovic.alemon.game.engines;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import com.vukmarkovic.alemon.game.Game;
import com.vukmarkovic.alemon.game.base.interfaces.Movable;
import com.vukmarkovic.alemon.game.base.interfaces.Movable.Direction;

public class ControlledMovementEngine extends MovementEngine implements KeyListener {

	private HashMap<Integer, Direction> directionBindings = new HashMap<>();
	private HashMap<Integer, String> eventBindings = new HashMap<>();
	
	public ControlledMovementEngine(Game game, Movable movable) {
		super(game, movable);
		
		directionBindings.put(KeyEvent.VK_W, Direction.UP);
		directionBindings.put(KeyEvent.VK_S, Direction.DOWN);
		directionBindings.put(KeyEvent.VK_A, Direction.LEFT);
		directionBindings.put(KeyEvent.VK_D, Direction.RIGHT);
		
		eventBindings.put(KeyEvent.VK_W, "controlled_movement_engine:move_up");
		eventBindings.put(KeyEvent.VK_S, "controlled_movement_engine:move_down");
		eventBindings.put(KeyEvent.VK_A, "controlled_movement_engine:move_left");
		eventBindings.put(KeyEvent.VK_D, "controlled_movement_engine:move_right");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.game
			.getCurrentLevel()
			.getEventManager()
			.addEvent("always", eventBindings.get(e.getKeyCode()), 
					super.move(directionBindings.get(e.getKeyCode())));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.game
			.getCurrentLevel()
			.getEventManager()
			.removeEvent("always", eventBindings.get(e.getKeyCode()));
		super.stop(directionBindings.get(e.getKeyCode()));
	}
}
