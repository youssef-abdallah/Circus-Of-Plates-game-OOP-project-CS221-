package eg.edu.alexu.csd.oop.game.myGame.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public  class Plate implements GameObject {
	private int x;
	private int y;
	private boolean visible;
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	public Plate(int x,int y) {
		this.x=x;
		this.y=y;
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("/images.jpg"));
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
		this.y = y;
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
		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

}
