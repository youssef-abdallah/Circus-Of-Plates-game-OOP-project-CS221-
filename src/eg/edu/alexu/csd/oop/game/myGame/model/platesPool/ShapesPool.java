package eg.edu.alexu.csd.oop.game.myGame.model.platesPool;

import eg.edu.alexu.csd.oop.game.myGame.model.Shape;
import eg.edu.alexu.csd.oop.game.myGame.model.factory.ShapesFactory;

public class ShapesPool extends ObjectPool<Shape> {
	private static String shape;
	private static ShapesFactory factory;
	private static int width;
	private static ShapesPool uniqueInstance;
	
	public static ShapesPool getInstance(int width) {
		ShapesPool.width = width;
		if (uniqueInstance != null)
			return uniqueInstance;
		else {
			uniqueInstance = new ShapesPool();
			return uniqueInstance;
		}
	}
	private ShapesPool() {
		super();
		factory = ShapesFactory.getInstance(width);
	}
	
	public static String getShape() {
		return shape;
	}
	public static void setShape(String shape) {
		ShapesPool.shape = shape;
	}
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		ShapesPool.width = width;
	}
	@Override
	protected Shape create() {
		return factory.makeShape(shape);
	}
	
	@Override
	public boolean validate(Shape object) {
		return object.isVisible();
	}
	@Override
	public void expire(Shape object) {
		object.setVisible(false);
	}

}
