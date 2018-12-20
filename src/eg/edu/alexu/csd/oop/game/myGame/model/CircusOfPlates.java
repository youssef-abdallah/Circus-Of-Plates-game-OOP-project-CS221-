package eg.edu.alexu.csd.oop.game.myGame.model;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;

public class CircusOfPlates implements World {

	private final int width;
	private final int height;
	private final List<GameObject> constant = new LinkedList<GameObject>();
	private final List<GameObject> movable = new LinkedList<GameObject>();
	private final List<GameObject> controlable = new LinkedList<GameObject>();
	private Clown clown;
	int i;
	int j = 0;

	public CircusOfPlates(int screenWidth, int screenHeight) {
		width = screenWidth;
		height = screenHeight;
		// GameObject background = new Background(0,0,"/download.jpg");
		// constant.add(background);
		clown = new Clown((screenWidth / 2) - 75, (int) (screenHeight) - 155, "/player1.png");
		controlable.add(clown);
		Observable observer;
		//observer = new PlateObserver(clown);
		
	}

	@Override
	public List<GameObject> getConstantObjects() {
		// TODO Auto-generated method stub
		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		// TODO Auto-generated method stub
		return movable;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		// TODO Auto-generated method stub
		return controlable;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	private boolean intersect(GameObject obj1, GameObject obj2, int x) {
		if ((obj1.getY() == obj2.getY() + obj2.getHeight()) && (Math.abs((obj1.getX() + x - obj2.getX())) < obj2.getWidth())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
		if (j % 100 == 0) {
			Plate plate = new Plate(i * 100 + 110, 0);
			i++;
			movable.add(plate);
		}
		j++;
		for (GameObject o : movable.toArray(new GameObject[movable.size()])) {
			o.setY(o.getY() + 1);
			if (intersect(clown.getTopLeft(), o, 0)) {
				o.setX(clown.getTopLeft().getX());
				controlable.add(o);
				movable.remove(o);
				clown.addToStack("lStack", (Plate) o);
			}
			int x;
			if (clown.getTopLeft().getX() == clown.getTopRight().getX()) {
				x = 100;
			} else {
				x = 0;
			}
			if (intersect(clown.getTopRight(), o, x)) {
				o.setX(clown.getTopRight().getX() + x);
				controlable.add(o);
				movable.remove(o);
				clown.addToStack("rStack", (Plate) o);
			}
			for(int i = 0; i < clown.getLeftStack().size(); i++) {
				Plate p = clown.getLeftStack().get(i);
				p.setY(clown.getY() + ((i+1)* -p.getHeight()) );
			}
			for(int i = 0; i < clown.getRightStack().size(); i++) {
				Plate p = clown.getRightStack().get(i);
				p.setY(clown.getY() + ((i+1)* -p.getHeight()) );
			}
			controlable.clear();
			controlable.add(clown);
			for(int i=0;i<clown.getLeftStack().size();i++) {
				controlable.add(clown.getLeftStack().get(i));
			}
			for(int i=0;i<clown.getRightStack().size();i++) {
				controlable.add(clown.getRightStack().get(i));
			}
			if (o.getY() == height) {
				// notify pool
			}
		}
		return true;

	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return 20;
	}

}
