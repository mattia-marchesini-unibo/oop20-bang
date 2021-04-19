package model.effects;

import model.Table;

/**
 * this the class of cards witch allow you to see other players 
 */

public class ModifySight implements Effect {
	
	private int sight; 
	
	public ModifySight(int sight) {
		this.sight = sight;
	}

	@Override
	public void useEffect(Table table) {
		table.getCurrentPlayer().modifySight(this.sight);
	}
}
