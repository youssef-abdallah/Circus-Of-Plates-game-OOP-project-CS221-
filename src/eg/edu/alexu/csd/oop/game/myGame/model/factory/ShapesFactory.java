package eg.edu.alexu.csd.oop.game.myGame.model.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.myGame.controller.dynamicloader.Loadable;
import eg.edu.alexu.csd.oop.game.myGame.model.Shape;
import eg.edu.alexu.csd.oop.game.myGame.model.shapes.Plate;

public class ShapesFactory implements Loadable {
	private static ShapesFactory uniqueInstance = new ShapesFactory();
	private static int width;
	private static List<Class<?>> supportedShapes;

	public static ShapesFactory getInstance(int backgroundWidth) {
		width = backgroundWidth;
		return uniqueInstance;
	}

	private ShapesFactory() {
		supportedShapes = new ArrayList<Class<?>>();
		supportedShapes.add(Plate.class);
	}

	public Shape makeShape(String shapeName) {
		try {
			Constructor<?> co = supportedShapes.get(0).getConstructor(int.class, int.class);
			Shape plate = (Shape) co.newInstance((int) Math.ceil(Math.random() * width),0);
			return plate;
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if ("plate".equalsIgnoreCase(shapeName)) {
			Shape plate = new Plate((int) Math.ceil(Math.random() * width), 0);
			return plate;
		}
		return null;
	}

	@Override
	public void addSupportedClasses(Class<?> c) {
		supportedShapes.add(c);
	}

	@Override
	public List<Class<?>> getSupportedClasses() {
		return supportedShapes;
	}
}
