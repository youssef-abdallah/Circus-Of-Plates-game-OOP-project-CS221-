package eg.edu.alexu.csd.oop.game.myGame.model;

import eg.edu.alexu.csd.oop.game.GameObject;

public class PlateObserver implements Observable{

	private Subject clown;
	
	public PlateObserver(Subject clown) {
		this.clown = clown;
		
	}
	@Override
	public void update() {
		
	}

}
