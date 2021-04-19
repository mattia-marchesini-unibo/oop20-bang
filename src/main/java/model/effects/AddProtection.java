package model.effects;

import model.Table;

public class AddProtection implements Effect {

	@Override
	public void useEffect(Table table) {
	    table.getCurrentPlayer().addProtection();
	}
}
