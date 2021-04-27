package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import libs.CircularList;

public class Logics {
	
	private SimpleTable table;
	private CircularList<Player> currentPlayers;
	
	private static final List<Role> totalRoles = List.of(
			Role.SHERIFF,Role.RENEGADE,Role.OUTLAW,Role.OUTLAW,Role.DEPUTY,Role.OUTLAW,Role.OUTLAW);

	public Logics(final SimpleTable table) {
		this.table = table;
		this.currentPlayers = this.table.getPlayers();
	}

	public List<Role> getRolesForPlayers(final int playerNumber){
		return totalRoles.subList(0, playerNumber);
	}
	
	public Set<Player> getTargets() {		
	        Player currentPlayer = this.table.getCurrentPlayer();
		Set<Player> targets = new HashSet<Player>();
		
		Player cur = currentPlayer;
		for(int i=1;i<=currentPlayer.getSight();i++) {
			var playerdx = this.currentPlayers.getNextOf(cur);
			i = i + playerdx.getRetreat();
			if(i <= currentPlayer.getSight()) {
				targets.add(playerdx);
			}
			cur = this.currentPlayers.getNextOf(cur);
		}
		
		cur = currentPlayer;
		for(int i=1;i<=currentPlayer.getSight();i++) {
			var playerdx = this.currentPlayers.getPrevOf(cur);
			i = i + playerdx.getRetreat();
			if(i <= currentPlayer.getSight()) {
				targets.add(playerdx);
			}
			cur = this.currentPlayers.getPrevOf(cur);
		}
		return targets;
	}
	
	public boolean canUseBang() {
		if(!this.table.getCurrentPlayer().getActiveCardsByName("volcanic").isEmpty()) {
			return true;
		}
		return this.table.getCurrentPlayer().getUSeBang() ? false : true;
	}
}
	
