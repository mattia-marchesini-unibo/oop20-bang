package model.effects;

import model.Table;

/**
 * this is the class of cards witch allows you "change" your position in the table
 */
public class Retreat implements Effect {

	private int retreat;
	
	public Retreat(int retreat) {
		this.retreat = retreat;
	}

	@Override
	public void useEffect(Table table) {
		table.getCurrentPlayer().modifyRetreat(this.retreat);
	}		
}
