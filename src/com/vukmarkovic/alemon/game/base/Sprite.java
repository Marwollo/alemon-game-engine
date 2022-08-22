package com.vukmarkovic.alemon.game.base;

import java.util.HashMap;

import com.vukmarkovic.alemon.game.base.attributes.Position;
import com.vukmarkovic.alemon.game.base.attributes.Size;

import java.awt.*;

public class Sprite {
	private Position position = new Position();
	private Size size = new Size();
	
	private String currentAnimation;
	private Boolean isAnimationPaused = false;
	
	private HashMap<String, Animation> animations = new HashMap<>();
	
	public String getCurrentAnimation() {
		return this.currentAnimation;
	}
	
	public HashMap<String, Animation> getAnimations() {
		return this.animations;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return this.size;
	}
	
	public void setCurrentAnimation(String animationName) {
		if (animations.containsKey(animationName)) {
			this.currentAnimation = animationName;
		}
	}
	
	public void playAnimation() {
		this.animations.get(this.currentAnimation).nextFrame(0.038);
	}
	
	public void addAnimation(String name, Animation animation) {
		this.animations.put(name, animation);
	}
	
	public void setAnimations(HashMap<String, Animation> animations) {
		this.animations = animations;
	}
	
	public void setAnimationPaused(Boolean isPaused) {
		this.isAnimationPaused = isPaused;
	}
	
	public void paint(Graphics2D graphics) {
		graphics.drawImage(
				animations.get(currentAnimation).getCurrentFrame(), 
				(int) this.getPosition().getX(),
				(int) this.getPosition().getY(),
				this.getSize().getWidth(),
				this.getSize().getHeight(),
				null
		);
		if (!this.isAnimationPaused)
			this.playAnimation();
	}
}
