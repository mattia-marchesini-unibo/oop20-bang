package model;

import java.util.List;
import java.util.Random;

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
		this.role = Role.values()[new Random().nextInt(Role.values().length)];
	}

	public List<Card> getCard(){
		return this.hand;
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public void playCard(Card card, SimplePlayer player) {
		if(card.getColor() == Color.BROWN) {
			card.getEffects().forEach( e -> e.useEffects(player));
			this.removeCard(card); 
			
		} else {
			//if the cart is deadness i only have to call the effects
			card.getEffects().forEach( e -> e.useEffects(player));			
		}
	}
	
	public void removeCard(Card card) {
		this.hand.forEach(i -> {
			if(i.equals(card)) {
				this.hand.remove(i);
			}
		});
	}

	@Override
	public Role getRole() {
		return this.role;
	}

}
