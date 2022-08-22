package com.vukmarkovic.alemon.game.base.interfaces;

import java.util.HashMap;

public interface Movable {
	public enum Direction { LEFT, RIGHT, UP, DOWN };
	
	public void move(HashMap<Direction, Boolean> movementState);

	public HashMap<Direction, Boolean> getMovementState();

	public void setMoving(Direction up, Boolean b);
}
