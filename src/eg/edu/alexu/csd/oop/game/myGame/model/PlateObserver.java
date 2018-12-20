package eg.edu.alexu.csd.oop.game.myGame.model;

import java.util.Stack;

public class PlateObserver implements Observable{

	private Clown clown;
	private Stack<Plate> rStack;
	private Stack<Plate> lStack;
	
	//public PlateObserver(Subject clown) {
		//this.clown = (Clown) clown;
		
	//}
	@Override
	public void update(Object clown) {
		this.clown=(Clown) clown;
		rStack=this.clown.getRightStack();
		lStack=this.clown.getLeftStack();
		if(lStack.size()>2) {
			if((lStack.get(lStack.size()-1).getType()==lStack.get(lStack.size()-2).getType())&&(lStack.get(lStack.size()-2).getType()==lStack.get(lStack.size()-3).getType())) {
				lStack.pop();
				lStack.pop();
				lStack.pop();
			}
		}
	}

}
