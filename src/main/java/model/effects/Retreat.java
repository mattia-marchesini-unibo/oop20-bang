package model.effects;

import model.SimplePlayer;

/**
 * this is the class of cards witch allows you "change" your position in the table
 */
public class Retreat implements Effects {

	private int retreat;
	
	public Retreat(int retreat) {
		super();
		this.retreat = retreat;
	}

	@Override
	public void useEffects(SimplePlayer player) {
		player.setIndex(retreat);
		
	}		
}
