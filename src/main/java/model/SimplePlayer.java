package model;

import java.util.List;

public class SimplePlayer implements Player {

	private static final int BASICAL_SIGHT = 1;
	private int sight;
	private int index;
	private int pos;
	private Character character;
	private Role role;
	private List<Card> hand;
	
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
		return this.hand;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void playCard(Card card) {
		if(card.getLifeTime() == LifeTime.DEADLY) {
			//chiamo l'effetto della carta
			this.removeCard(card); 
			
		} else {//if the cart is deadness i only have to call the effects
			//chiamo l'effetto della carta
			
		}
	}
	
	private void removeCard(Card card) {
		this.hand.forEach(i -> {
			if(i.equals(card)) {
				//allora rimuovo quella specifica carta
			}
		});
	}
}
