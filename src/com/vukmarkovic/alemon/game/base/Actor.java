package com.vukmarkovic.alemon.game.base;

import java.util.HashMap;
import java.util.Map.Entry;
import com.vukmarkovic.alemon.game.base.interfaces.Movable;

public class Actor extends Sprite implements Movable {
	private double speed = 0.5;
	private HashMap<Direction, Boolean> movementState = new HashMap<>();
	
	public static Actor from(Sprite sprite) {
		Actor actor = new Actor();
		actor.setPosition(sprite.getPosition());
		actor.setSize(sprite.getSize());
		actor.setAnimations(sprite.getAnimations());
		actor.setCurrentAnimation(sprite.getCurrentAnimation());
		
		actor.movementState.put(Direction.UP, false);
		actor.movementState.put(Direction.DOWN , false);
		actor.movementState.put(Direction.LEFT, false);
		actor.movementState.put(Direction.RIGHT, false);
		return actor;
	}
	@Override
	public void setMoving(Direction direction, Boolean state) {
		this.movementState.replace(direction, state);
	}
	
	public HashMap<Direction, Boolean> getMovementState() {
		return this.movementState;
	}
	
	public int getTotalActiveDirections() {
		int total = 0;
		for (Entry<Direction, Boolean> direction : this.movementState.entrySet()) {
			if (direction.getValue()) {
				total += 1;
			}
		}
		return total;
	}

	@Override
	public void move(HashMap<Direction, Boolean> movementState) {
		if (movementState.get(Direction.UP)) {
			this.getPosition().setY(this.getPosition().getY() - speed / this.getTotalActiveDirections());
		}
		if (movementState.get(Direction.DOWN)) {
			this.getPosition().setY(this.getPosition().getY() + speed / this.getTotalActiveDirections());
		}
		if (movementState.get(Direction.LEFT)) {
			this.getPosition().setX(this.getPosition().getX() - speed / this.getTotalActiveDirections());
		}
		if (movementState.get(Direction.RIGHT)) {
			this.getPosition().setX(this.getPosition().getX() + speed / this.getTotalActiveDirections());
		}
	}
}
