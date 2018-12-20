package eg.edu.alexu.csd.oop.game.myGame.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Clown implements GameObject, Subject {
	private int x;
	private int y;
	private boolean visible;
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private Stack<Shape> rStack = new Stack<Shape>();
	private Stack<Shape> lStack = new Stack<Shape>();
	private ArrayList<Observable> observers = new ArrayList<Observable>();

	public Clown(int x, int y, String imagePath) {
		this.x = x;
		this.y = y;
		this.visible = true;
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;

	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		// this.y = y; clown don't move up and down
	}

	@Override
	public int getWidth() {
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	public void addToStack(String stack, Shape plate) {
		if (stack.equals("lStack")) {
			lStack.push(plate);
			this.notifyObservers();
		} else if (stack.equals("rStack")) {
			rStack.push(plate);
			this.notifyObservers();
		}
	}

	public GameObject getTopRight() {
		if (rStack.isEmpty()) {
			return this;
		} else {
			return rStack.peek();
		}
	}

	public GameObject getTopLeft() {
		if (lStack.isEmpty()) {
			return this;
		} else {
			return lStack.peek();
		}
	}

	public Stack<Shape> getLeftStack() {
		return lStack;
	}

	public Stack<Shape> getRightStack() {
		return rStack;
	}

	@Override
	public void addObserver(Observable obs) {
		// TODO Auto-generated method stub
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observable obs) {
		// TODO Auto-generated method stub
		observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this);
		}
	}

}
