package com.vukmarkovic.alemon.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class ControlsManager implements KeyListener {
	public List<KeyListener> subscribers = new ArrayList<>();
	
	public ControlsManager() {}

	@Override
	public void keyTyped(KeyEvent e) {
		for (KeyListener listener : subscribers) {
			listener.keyTyped(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		for (KeyListener listener : subscribers) {
			listener.keyPressed(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (KeyListener listener : subscribers) {
			listener.keyReleased(e);
		}
	}
}
