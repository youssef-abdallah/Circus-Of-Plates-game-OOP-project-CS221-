package eg.edu.alexu.csd.oop.game.myGame.view;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.myGame.model.CircusOfPlates;

public class TestMain {

	public static void main(String[] args) {
		GameEngine.start("test", new CircusOfPlates(1000, 1000));
	}
}
