package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import libs.CircularList;

public class Logics {
	
	private SimpleTable table;
	private CircularList<Player> currentPlayers;
	
	public Logics(final SimpleTable table) {
		this.table = table;
		this.currentPlayers = this.table.getPlayers();
	}

	public Set<Player> getTargets() {		
		Set<Player> targets = new HashSet<Player>();
		Player cur = this.table.getCurrentPlayer();
		for(int i=1;i<=this.table.getCurrentPlayer().getSight();i++) {
			var playerdx = this.currentPlayers.getNextOf(cur);
			i = i + playerdx.getRetreat();
			if(i <= this.table.getCurrentPlayer().getSight()) {
				targets.add(playerdx);
			}
			cur = this.currentPlayers.getNextOf(cur);
		}
		cur = this.table.getCurrentPlayer();
		for(int i=1;i<=this.table.getCurrentPlayer().getSight();i++) {
			var playerdx = this.currentPlayers.getPrevOf(cur);
			i = i + playerdx.getRetreat();
			if(i <= this.table.getCurrentPlayer().getSight()) {
				targets.add(playerdx);
			}
			cur = this.currentPlayers.getPrevOf(cur);
		}
		return targets;
	}
}
	
