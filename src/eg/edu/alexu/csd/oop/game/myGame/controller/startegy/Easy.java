package eg.edu.alexu.csd.oop.game.myGame.controller.startegy;

import eg.edu.alexu.csd.oop.game.World;

public class Easy implements Difficulty {

	World world;

	Easy(World world) {
		this.world = world;
	}

	@Override
	public void setDifficulty() {
	}

}
