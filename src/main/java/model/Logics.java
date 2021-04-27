package model;

import java.util.HashSet;
import java.util.Set;

public class Logics {
	
	private SimpleTable table;

	public Logics(final SimpleTable table) {
		this.table = table;
	}

	public Set<Player> getTargets() {		
	        Player currentPlayer = this.table.getCurrentPlayer();
		Set<Player> targets = new HashSet<Player>();
		
		Player cur = currentPlayer;
		for(int i=1;i<=currentPlayer.getSight();i++) {
			var playerdx = this.table.getPlayers().getNextOf(cur);
			i = i + playerdx.getRetreat();
			if(i <= currentPlayer.getSight()) {
				targets.add(playerdx);
			}
			cur = this.table.getPlayers().getNextOf(cur);
		}
		
		cur = currentPlayer;
		for(int i=1;i<=currentPlayer.getSight();i++) {
			var playerdx = this.table.getPlayers().getPrevOf(cur);
			i = i + playerdx.getRetreat();
			if(i <= currentPlayer.getSight()) {
				targets.add(playerdx);
			}
			cur = this.table.getPlayers().getPrevOf(cur);
		}
		return targets;
	}
	
	public boolean canUseBang() {
		if(!this.table.getCurrentPlayer().getActiveCardsByName("volcanic").isEmpty()) {
			return true;
		}
		return this.table.getCurrentPlayer().getUsedBang() ? false : true;
	}
}
	
