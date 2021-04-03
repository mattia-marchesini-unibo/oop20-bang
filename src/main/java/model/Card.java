package model;

import java.util.List;

public class Card {
	
	private String name;
	private int cardId;
	private Death death;
	private List<Effects> effects;
	
	public Card(final int cardId,final Death death,final String name, List<Effects> effects ) {
		this.cardId = cardId;
		this.name = name;
		this.death = death;
		this.effects = effects;
	}
	
	public List<Effects> getEffects() {
		return this.effects;
	}

	
	public Death getDead() {
		return this.death;
	}
}
