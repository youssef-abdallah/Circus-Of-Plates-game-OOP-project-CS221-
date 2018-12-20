package eg.edu.alexu.csd.oop.game.myGame.model;

import java.util.Observable;

public interface Subject {
	public void addObserver(Observable obs);
	public void removeObserver(Observable obs);
	public void notifyObservers();
}
