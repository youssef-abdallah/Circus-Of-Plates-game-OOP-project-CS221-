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
	int j=0;

	public CircusOfPlates(int screenWidth, int screenHeight) {
		width = screenWidth;
		height = screenHeight;
		// GameObject background = new Background(0,0,"/download.jpg");
		// constant.add(background);
		clown = new Clown((screenWidth / 2)-75, (int) (screenHeight) - 155, "/player1.png");
		controlable.add(clown);
		//for (int i = 0; i < 10; i++) {
			
		//}
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

	private boolean intersect(GameObject obj1, GameObject obj2) {
		if((obj1.getY()==obj2.getY()+20)&&(Math.abs((obj1.getX()-obj2.getX()))<50)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
		if(j%100==0) {
		Plate plate = new Plate(i * 100 + 110, 0);
		i++;
		movable.add(plate);}
		j++;
		for (GameObject o : movable.toArray(new GameObject[movable.size()])) {
			o.setY(o.getY() + 1);
			if(intersect(clown.getTopLeft(),o)) {
				controlable.add(o);
				movable.remove(o);
				clown.addToStack("lStack", (Plate) o);
				System.out.println("left colision");
			}
//			if(intersect(clown.getTopLeft(),o)) {
//				controlable.add(o);
//				movable.remove(o);
//				System.out.println("right colision");
//			}
			if (o.getY() == height) {
				//notify pool
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
