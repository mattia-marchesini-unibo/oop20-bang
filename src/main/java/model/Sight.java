package model;

/**
 * this the class of cards witch allow you to see other players 
 */

public class Sight implements Effects {
	
	private int sight; 
	
	public Sight(int sight) {
		super();
		this.sight = sight;
	}

	@Override
	public void useEffects(SimplePlayer player) {
		player.setRange(this.sight);
	}



}
