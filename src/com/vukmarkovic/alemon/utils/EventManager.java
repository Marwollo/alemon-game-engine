package com.vukmarkovic.alemon.utils;

import java.util.HashMap;
import java.util.Map.Entry;

import com.vukmarkovic.alemon.game.Event;

public class EventManager {
	private HashMap<String, HashMap<String, Event>> events = new HashMap<>();
	
	public EventManager() {
		this.addListener("always");
	}
	
	public void addListener(String listener) {
		events.put(listener, new HashMap<>());
	}
	
	public void addEvent(String listener, String name, Event event) {
		System.out.println(listener + " " + name);
		events.get(listener).put(name, event);
	}
	
	public void removeEvent(String listener, String name) {
		events.get(listener).remove(name);
	}
	
	public Event getEvent(String listener, String name) {
		return events.get(listener).get(name);
	}
	
	public void runEvent(String listener, String name) {
		this.getEvent(listener, name).call();
	}
	
	public void runListener(String listener) {
		HashMap<String, Event> listenerEvents = events.get(listener);
		for (Entry<String, Event> entry : listenerEvents.entrySet()) {
			entry.getValue().call();
		}
	}
}
