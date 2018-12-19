package eg.edu.alexu.csd.oop.game.myGame.model.factory;

import java.awt.Point;
import eg.edu.alexu.csd.oop.game.myGame.model.Plate;

public class PlatesFactory {
	private static PlatesFactory uniqueInstance = new PlatesFactory();
	public static PlatesFactory getInstance() {
		return uniqueInstance;
	}
	private PlatesFactory() {
		
	}
	
	public Plate makePlate(String plateShape, 
			Point position) {
		return null;
	}
}
