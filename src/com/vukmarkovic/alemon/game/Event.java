package com.vukmarkovic.alemon.game;

import com.vukmarkovic.alemon.game.base.interfaces.EventCallable;


public class Event {
	private EventCallable<Integer> callback;
	
	public Event(EventCallable<Integer> callback) {
		this.callback = callback;
	}

	public void call() {
		try {
			this.callback.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
