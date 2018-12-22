package eg.edu.alexu.csd.oop.game.myGame.model.shapes;

import java.awt.image.BufferedImage;
import eg.edu.alexu.csd.oop.game.myGame.model.Shape;
import eg.edu.alexu.csd.oop.game.myGame.view.Images;

public class Plate extends Shape {
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int type;
	private Images images = Images.getInstance();

	public Plate(int x, int y) {
		super.setX(x);
		super.setY(y);
		type = (int) Math.ceil(Math.random() * 3);
		if(type == 1) {
			spriteImages[0]=images.getImage("bluePlate");
		}
		if(type == 2) {
			spriteImages[0]=images.getImage("redPlate");
		}
		if(type == 3) {
			spriteImages[0]=images.getImage("greenPlate");
		}
		super.setSpriteImages(spriteImages);
		super.setVisible(true);
	}

	@Override
	public int getX() {
		return super.getX();
	}

	@Override
	public void setX(int x) {
		super.setX(x);

	}

	@Override
	public int getY() {
		return super.getY();
	}

	@Override
	public void setY(int y) {
		super.setY(y);
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
		return super.isVisible();
	}
	
	public void setVisible(boolean visible) {
		super.setVisible(visible);
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return super.getSpriteImages();
	}

	public int getType() {
		return type;
	}
	
	@Override
	public Plate clone() {
		Plate plate = new Plate(this.getX(), this.getY());
		return plate;
	}

}
