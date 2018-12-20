package eg.edu.alexu.csd.oop.game.myGame.model.factory;

import eg.edu.alexu.csd.oop.game.myGame.model.Plate;
import eg.edu.alexu.csd.oop.game.myGame.model.Shape;

public class ShapesFactory {
	private static ShapesFactory uniqueInstance = new ShapesFactory();
	private static int width;
	public static ShapesFactory getInstance(int backgroundWidth) {
		width = backgroundWidth;
		return uniqueInstance;
	}
	private ShapesFactory() {
		
	}
	
	public Shape  makeShape(String shapeName) {
		if ("plate".equalsIgnoreCase(shapeName)) {
			Shape plate = new Plate((int) Math.ceil(Math.random() * width), 0);
			return plate;
		}
		return null;
	}
}
