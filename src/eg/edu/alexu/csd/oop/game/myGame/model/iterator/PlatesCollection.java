package eg.edu.alexu.csd.oop.game.myGame.model.iterator;

import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.myGame.model.Plate;

public class PlatesCollection implements Iterable<Plate> {
	private List<Plate> list;
	public PlatesCollection() {
		list = new ArrayList<Plate>();
	}
	
	public void add(Plate newPlate) {
		list.add(newPlate);
	}
	
	public void remove(Plate plate) {
		list.remove(plate);
	}
	
	public List<Plate> getList() {
		return list;
	}

	@Override
	public Iterator<Plate> createIterator() {
		return new PlatesIterator(this);
	}

}
