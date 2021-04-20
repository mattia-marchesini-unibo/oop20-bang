package model;

import java.util.Set;

import libs.CircularList;

public class Logics {
	
	private SimpleTable table;
	private CircularList<Player> currentPalyers;
	private Player player;
	private Set<Player> canBeFight;
	private int pos;
	
	public Logics(final SimpleTable table) {
		this.table = table;
		this.currentPalyers = this.table.getPlayers();
		this.pos = this.currentPalyers.getPosition(this.player);//dentro gli passo il player
	}

	public Set<Player> getPalyers(final Player player){
		this.addToSet(player);
		return this.canBeFight;		
	}

	private void addToSet(final Player player) {
		for(int i=0;i<this.player.getSight();i++) {
			var posdx = this.currentPalyers.getNext();
			var possx = this.currentPalyers.getPrev();
			if(posdx.getIndex() == this.currentPalyers.getPosition(posdx) || posdx.getIndex() <= player.getSight()  ) {
				this.canBeFight.add(posdx);
			}
			if(posdx.getIndex() == this.currentPalyers.getPosition(possx) || possx.getIndex() <= player.getSight()) {
				this.canBeFight.add(possx);
			}
		}
	}
	
}
