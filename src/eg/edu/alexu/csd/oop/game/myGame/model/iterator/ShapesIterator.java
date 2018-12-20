package eg.edu.alexu.csd.oop.game.myGame.model.iterator;

import java.util.List;

import eg.edu.alexu.csd.oop.game.myGame.model.Shape;

public class ShapesIterator implements Iterator<Shape> {
	private List<Shape> list;
	private int index;
	
	public ShapesIterator(ShapesCollection platesCollection) {
		this.list = platesCollection.getList();
		index = 0;
	}
	
	@Override
	public void first() {
		index = 0;
		return;
	}

	@Override
	public void next() {
		index++;
		return;
	}

	@Override
	public boolean isDone() {
		return index >= list.size();
	}

	@Override
	public Shape currentItem() {
		return list.get(index);
	}

}
