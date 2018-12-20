package eg.edu.alexu.csd.oop.game.myGame.view;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Difficulty;
import eg.edu.alexu.csd.oop.game.myGame.controller.startegy.Hard;
import eg.edu.alexu.csd.oop.game.myGame.model.CircusOfPlates;

public class TestMain {

	public static void main(String[] args) {
		CircusOfPlates circus = new CircusOfPlates(1500, 800);
		//Difficulty hard = new Hard(circus);
		GameEngine.start("test", circus);
	}
}
