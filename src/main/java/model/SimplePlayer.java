package model;

import java.util.List;

public class SimplePlayer {

	private static final int BASICAL_SIGHT = 1;
	private int sight;
	private int index;
	private int pos;
	private Character character;
	private Role role;
	
	public SimplePlayer(int pos) {
		this.pos = pos;
		this.index = this.pos;
		this.sight = BASICAL_SIGHT;
		this.drawCharacter();
		this.drawRole();
	}
	
	public void setRange(int sight) {
		this.sight = sight; 
	}

	public void setIndex(int retreat) {
		this.index = retreat;	
	}

	public int getSight() {
		return this.sight;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	private void drawCharacter() {
		// TODO Auto-generated method stub
		
	}
	
	private void drawRole() {
		// TODO Auto-generated method stub
		
	}

	public List<Card> getCard(){
		
	}
	
	public void addCard(Card card) {
		
	}
	
}
