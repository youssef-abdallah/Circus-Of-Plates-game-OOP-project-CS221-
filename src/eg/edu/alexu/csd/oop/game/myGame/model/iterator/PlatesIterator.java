package eg.edu.alexu.csd.oop.game.myGame.model.iterator;

import java.util.List;

import eg.edu.alexu.csd.oop.game.myGame.model.Plate;

public class PlatesIterator implements Iterator<Plate> {
	private List<Plate> list;
	private int index;
	
	public PlatesIterator(PlatesCollection platesCollection) {
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
	public Plate currentItem() {
		return list.get(index);
	}

}
