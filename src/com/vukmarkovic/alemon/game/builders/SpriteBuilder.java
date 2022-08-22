package com.vukmarkovic.alemon.game.builders;

import com.vukmarkovic.alemon.game.base.*;

public class SpriteBuilder {
	protected Sprite sprite;
	
	public SpriteBuilder() {
		this.sprite = new Sprite();
	}
	
	public SpriteBuilder addAnimation(String name, Animation animation) {
		this.sprite.addAnimation(name, animation);
		return this;
	}
	
	public SpriteBuilder setAnimation(String name) {
		this.sprite.setCurrentAnimation(name);
		return this;
	}
	
	public SpriteBuilder setWidth(int width) {
		this.sprite.getSize().setWidth(width);;
		return this;
	}
	
	public SpriteBuilder setHeight(int height) {
		this.sprite.getSize().setHeight(height);
		return this;
	}
	
	public SpriteBuilder setPositionX(double positionX) {
		this.sprite.getPosition().setX(positionX);
		return this;
	}
	
	public SpriteBuilder setPositionY(double positionY) {
		this.sprite.getPosition().setY(positionY);
		return this;
	}
	
	public Sprite build() {
		return this.sprite;
	}
}
