package model;

import java.util.List;
import java.util.Random;

import model.card.Card;
import model.card.Color;

public class SimplePlayer implements Player {

	private static final int BASICAL_SIGHT = 1;
	private int sight;
	private int index;
	private int pos;
	private Character character;
	private Role role;
	private List<Card> hand;
	private int lifePoints;
	
	public SimplePlayer(int pos, Role role, Character character) {
		this.pos = pos;
		this.index = this.pos;
		this.sight = BASICAL_SIGHT;
		this.character = character;
		this.role = role;
	}
	
	@Override
	public void setRange(int sight) {
		this.sight = sight; 
	}

	@Override
	public void setIndex(int retreat) {
		this.index = retreat;	
	}

	@Override
	public int getSight() {
		return this.sight;
	}
	
	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public List<Card> getCard(){
		return this.hand;
	}

	@Override
	public Role getRole() {
		return this.role;
	}

	@Override
	public int getLifePoints() {
		return this.lifePoints;
	}

	@Override
	public void modifyLifePoints(int points) {
		int newLifePoints;
		newLifePoints = this.lifePoints + points;
		if(newLifePoints >=  this.character.getLifePoints()) {
			this.lifePoints =  this.character.getLifePoints();
		}else {
			this.lifePoints = newLifePoints;
		}
		
	}

	@Override
	public void addCard(Card card) {
		this.hand.add(card);		
	}

	@Override
	public void playCard(Card card, SimplePlayer player) {
		if(card.getColor() == Color.BROWN) {
			card.getEffects().forEach( e -> e.useEffects(player));
			this.removeCard(card); 
			
		} else {
			//if the cart is deadness i only have to call the effects
			card.getEffects().forEach( e -> e.useEffects(player));			
		}		
	}

	@Override
	public void removeCard(Card card) {
		this.hand.forEach(i -> {
			if(i.equals(card)) {
				this.hand.remove(i);
			}
		});		
	}

}
