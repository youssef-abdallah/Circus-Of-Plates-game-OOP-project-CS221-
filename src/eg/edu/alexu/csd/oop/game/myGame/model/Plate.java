package eg.edu.alexu.csd.oop.game.myGame.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Plate implements GameObject {
	private int x;
	private int y;
	private boolean visible;
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int type;

	public Plate(int x, int y) {
		this.x = x;
		this.y = y;
		type = (int) Math.ceil(Math.random() * 2);
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("/images" + type + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		visible = true;
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
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	public int getType() {
		return type;
	}

}
