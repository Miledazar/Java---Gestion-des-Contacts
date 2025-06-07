package controller;

import java.util.ArrayList;
import java.util.List;

public abstract class MyObservable {
	private final List<MyObserver> observers = new ArrayList<>();
	
	public void addObserver(MyObserver observer) {
		observers.add(observer);
	}
	
	public void removeObserver(MyObserver observer) {
		observers.remove(observer);
	}
	
	public boolean hasObserver(MyObserver observer) {
        return observers.contains(observer);
	}
	  
	public void notifyObservers() {
		for (MyObserver obs : observers) {
			obs.update();
		}
	}
}
