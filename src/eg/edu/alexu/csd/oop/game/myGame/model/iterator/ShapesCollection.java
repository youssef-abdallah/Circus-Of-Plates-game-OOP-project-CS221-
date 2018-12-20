package eg.edu.alexu.csd.oop.game.myGame.model.iterator;

import java.util.ArrayList;
import java.util.List;
import eg.edu.alexu.csd.oop.game.myGame.model.Shape;

public class ShapesCollection implements Iterable<Shape> {
	private List<Shape> list;
	public ShapesCollection() {
		list = new ArrayList<Shape>();
	}
	
	public void add(Shape newPlate) {
		list.add(newPlate);
	}
	
	public void remove(Shape plate) {
		list.remove(plate);
	}
	
	public List<Shape> getList() {
		return list;
	}

	@Override
	public Iterator<Shape> createIterator() {
		return new ShapesIterator(this);
	}

}
