package eg.edu.alexu.csd.oop.game.myGame.controller.startegy;

import eg.edu.alexu.csd.oop.game.myGame.model.CircusOfPlates;

public class Easy implements Difficulty {

	CircusOfPlates world;

	public Easy(CircusOfPlates world) {
		this.world = world;
		setDifficulty();
	}

	@Override
	public void setDifficulty() {
		world.setSpeed(10);
	}
}
