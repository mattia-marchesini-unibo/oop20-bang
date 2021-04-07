package model;

import java.util.List;

public class Card {
	
	private String name;
	private int cardId;
	private LifeTime lft;
	private List<Effects> effects;
	
	public Card(final int cardId,final LifeTime lft,final String name, List<Effects> effects ) {
		this.cardId = cardId;
		this.name = name;
		this.lft = lft;
		this.effects = effects;
	}
	
	public List<Effects> getEffects() {
		return this.effects;
	}

	
	public LifeTime getLifeTime() {
		return this.lft;
	}
}
