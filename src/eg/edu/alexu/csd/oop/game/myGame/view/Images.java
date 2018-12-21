package eg.edu.alexu.csd.oop.game.myGame.view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Images {

	private BufferedImage redPlate;
	private BufferedImage bluePlate;
	private BufferedImage greenPlate;
	private BufferedImage redBall;
	private BufferedImage bleBall;
	private BufferedImage greenBall;
	private static Images unique = new Images();
	
	private Images() {
	}
	
	public static Images getInstance(){
		return unique;
	}
}
