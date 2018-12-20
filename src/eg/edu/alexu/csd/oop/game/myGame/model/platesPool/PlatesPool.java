package eg.edu.alexu.csd.oop.game.myGame.model.platesPool;

import java.sql.Connection;

import eg.edu.alexu.csd.oop.game.myGame.model.Plate;

public class PlatesPool extends ObjectPool<Plate> {
	private static Class<? extends Plate> concretePlate;
	private static PlatesPool uniqueInstance = new PlatesPool();
	
	public static PlatesPool getInstance(Class<? extends Plate> concretePlate) {
		PlatesPool.concretePlate = concretePlate;
		return uniqueInstance;
	}
	private PlatesPool() {
		super();
	}
	@Override
	protected Plate create() {
		return null;
	}

	@Override
	public boolean validate(Plate object) {
		return object.isVisible();
	}

	@Override
	public void expire(Plate object) {
		object.setVisible(false);
	}

}
