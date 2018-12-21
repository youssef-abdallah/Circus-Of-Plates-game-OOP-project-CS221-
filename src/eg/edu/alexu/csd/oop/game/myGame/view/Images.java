package eg.edu.alexu.csd.oop.game.myGame.view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Images {

	private BufferedImage redPlate;
	private BufferedImage bluePlate;
	private BufferedImage greenPlate;
	private BufferedImage redBall;
	private BufferedImage blueBall;
	private BufferedImage greenBall;
	private static Images unique = new Images();
	
	private Images() {
	}
	
	public static Images getInstance(){
		unique.loadImages();
		return unique;
	}
	
	public void loadImages() {
		try {
			bluePlate=ImageIO.read(new File("res/images1.png"));
			redPlate=ImageIO.read(new File("res/images2.png"));
			blueBall=ImageIO.read(new File("res/blueBall.png"));
			redBall=ImageIO.read(new File("res/redBall.png"));
			greenBall=ImageIO.read(new File("res/greenBall.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage(String type) {
		if(type.equals("redBall")) {
			return redBall;
		}
		if(type.equals("blueBall")) {
			return blueBall;
		}
		if(type.equals("greenBall")) {
			return greenBall;
		}
		if(type.equals("redPlate")) {
			return redPlate;
		}
		if(type.equals("bluePlate")) {
			return bluePlate;
		}
		if(type.equals("greenPlate")) {
			return greenPlate;
		}
		return null;
	}
}
