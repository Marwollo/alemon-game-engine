package com.vukmarkovic.alemon.game.engines;
import com.vukmarkovic.alemon.game.Event;
import com.vukmarkovic.alemon.game.Game;
import com.vukmarkovic.alemon.game.base.interfaces.*;
import com.vukmarkovic.alemon.game.base.interfaces.Movable.Direction;

public class MovementEngine {
	
	protected Game game;
	protected Movable movable;
	
	public MovementEngine(Game game, Movable movable) {
		this.movable = movable;
		this.game = game;
	}
	
	public Event move(Direction direction) {
		movable.setMoving(direction, true);
		
		return new Event(() -> { 
			movable.move(movable.getMovementState());
			return 0; 
		});
	}
	
	public void stop(Direction direction) {
		movable.setMoving(direction, false);
	}
}
