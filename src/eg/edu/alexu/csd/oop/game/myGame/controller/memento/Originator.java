package eg.edu.alexu.csd.oop.game.myGame.controller.memento;

public interface Originator {
	public void setState(String state);
	public Memento save();
	public void restore(Memento m);
}
