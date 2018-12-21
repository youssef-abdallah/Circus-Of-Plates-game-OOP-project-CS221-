package eg.edu.alexu.csd.oop.game.myGame.controller.startegy;

import eg.edu.alexu.csd.oop.game.myGame.model.CircusOfPlates;

public class Hard implements Difficulty {

	CircusOfPlates world;

	public Hard(CircusOfPlates world) {
		this.world = world;
		setDifficulty();
	}

	@Override
	public void setDifficulty() {
		world.setSpeed(1);
	}
}