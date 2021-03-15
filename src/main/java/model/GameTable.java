package model;

import java.util.ArrayList;
import java.util.List;

public class GameTable {
	
	private int numGamer;
	private List<Gamer> table = new ArrayList<>(); //or set
	
	public GameTable(final int numGamer) {
		this.numGamer = numGamer;
		this.setTable();
	}

	private void setTable() {
		int i = 0;
		while(i < this.numGamer) {
			table.add(new Gamer(i,0));
		}
	}
	
	public boolean canBeShout(Gamer i, Gamer k) {
		if(!this.table.contains(i)) {
			return false;
		}
		//acquisisci il range di gamer e lo confronti 
		return false;
	}
	
	public boolean removeToTable(int pos) {
		if(!this.table.contains(pos)) {
			return false;
		} 
		table.remove(pos);
		return true;
	}
}
