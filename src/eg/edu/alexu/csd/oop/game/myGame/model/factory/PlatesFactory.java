package eg.edu.alexu.csd.oop.game.myGame.model.factory;

import eg.edu.alexu.csd.oop.game.myGame.model.Plate;
import eg.edu.alexu.csd.oop.game.myGame.model.Shape;

public class PlatesFactory {
	private static PlatesFactory uniqueInstance = new PlatesFactory();
	private static int width;
	public static PlatesFactory getInstance(int backgroundWidth) {
		width = backgroundWidth;
		return uniqueInstance;
	}
	private PlatesFactory() {
		
	}
	
	public Shape  makeShape(String shapeName) {
		if ("plate".equalsIgnoreCase(shapeName)) {
			Shape plate = new Plate((int) Math.ceil(Math.random() * width), 0);
			return plate;
		}
		return null;
	}
}
