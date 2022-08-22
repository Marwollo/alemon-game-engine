package com.vukmarkovic.alemon.game.base;

import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Animation {
	private double currentFrame = 0;
	private List<BufferedImage> frameAssets = new ArrayList<>();
	
	public Animation(String frameAsset) {
		this.addFrameAsset(frameAsset);
	}
	
	public Animation(List<String> frameAssets) {
		for (String frameAsset : frameAssets) {
			this.addFrameAsset(frameAsset);
		}
	}
	
	public void addFrameAsset(String frameAsset) {
		BufferedImage frame;
		try {
			frame = ImageIO.read(getClass().getResource(frameAsset));
			this.frameAssets.add(frame);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return this.frameAssets.get((int) Math.floor(this.currentFrame));
	}
	
	
	public void nextFrame(double speed) {
		this.currentFrame = (this.currentFrame + speed) % this.frameAssets.size();
	}
	
	public Boolean isLastFrame() {
		return ((int) this.currentFrame) == (this.frameAssets.size() - 1);
	}
}
